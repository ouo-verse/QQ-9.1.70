package com.tencent.qqlive.tvkplayer.tools.http.okhttp;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.config.TVKUrlConfig;
import com.tencent.qqlive.tvkplayer.tools.http.okhttp.TVKOKHttpDnsImpl;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKNetworkUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Route;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKHappyEyeballsV2ConnectionRace {
    private static final int CONNECT_RACE_INTERVAL_MS = 250;
    private static final int CONNECT_TIMEOUT_MS = 1000;
    private static final int READ_TIMEOUT_MS = 250;
    private static final String TAG = "TVKHappyEyeballsV2Connection";
    private static final int WRITE_TIMEOUT_MS = 250;

    @Nullable
    private ConcurrentLinkedQueue<RealConnection> mConnections;

    @NonNull
    private final OkHttpClient mOKHttpClient;

    @Nullable
    private RealConnectionPool mRealConnectionPool;
    private final Map<String, List<Future<?>>> mRacedHostToFutureMap = new HashMap();
    private final TVKOKHttpDnsImpl mOKHttpDnsImpl = new TVKOKHttpDnsImpl.Builder().build();

    public TVKHappyEyeballsV2ConnectionRace(@NonNull OkHttpClient okHttpClient) {
        this.mOKHttpClient = okHttpClient;
        initRaceHostToFutureMap();
    }

    private boolean acquiredHostInConnectionPool(@NonNull String str) {
        ConcurrentLinkedQueue<RealConnection> concurrentLinkedQueue = this.mConnections;
        if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
            Iterator<RealConnection> it = this.mConnections.iterator();
            while (it.hasNext()) {
                RealConnection next = it.next();
                if (next != null && next.getCalls().size() <= 0 && TextUtils.equals(str, next.getRoute().address().url().host())) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<InetAddress> crossIpv6AndIpv4Address(List<InetAddress> list) {
        if (list != null && list.size() >= 2) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (InetAddress inetAddress : list) {
                if (inetAddress instanceof Inet6Address) {
                    arrayList.add(inetAddress);
                } else if (inetAddress instanceof Inet4Address) {
                    arrayList2.add(inetAddress);
                }
            }
            int i3 = 0;
            int i16 = 0;
            while (true) {
                if (i3 >= arrayList.size() && i16 >= arrayList2.size()) {
                    return arrayList3;
                }
                if (i3 < arrayList.size()) {
                    arrayList3.add((InetAddress) arrayList.get(i3));
                    i3++;
                }
                if (i16 < arrayList2.size()) {
                    arrayList3.add((InetAddress) arrayList2.get(i16));
                    i16++;
                }
            }
        } else {
            return list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: establishConnectionAsync, reason: merged with bridge method [inline-methods] */
    public void lambda$raceToConnect$1(final RealCall realCall, final InetAddress inetAddress) {
        final HttpUrl url = realCall.request().url();
        TVKThreadPool.getInstance().obtainNormalPriorityExecutor().submit(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.tools.http.okhttp.j
            @Override // java.lang.Runnable
            public final void run() {
                TVKHappyEyeballsV2ConnectionRace.this.lambda$establishConnectionAsync$2(url, inetAddress, realCall);
            }
        });
    }

    @Nullable
    private ConcurrentLinkedQueue<RealConnection> getConnectionsFromConnectionPool(@Nullable RealConnectionPool realConnectionPool) {
        if (realConnectionPool == null) {
            return null;
        }
        try {
            Field declaredField = RealConnectionPool.class.getDeclaredField("connections");
            declaredField.setAccessible(true);
            return (ConcurrentLinkedQueue) declaredField.get(realConnectionPool);
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
            return null;
        }
    }

    @Nullable
    private RealConnectionPool getRealConnectionPoolFromClient(@Nullable OkHttpClient okHttpClient) {
        if (okHttpClient == null) {
            return null;
        }
        try {
            ConnectionPool connectionPool = okHttpClient.connectionPool();
            Field declaredField = connectionPool.getClass().getDeclaredField("delegate");
            declaredField.setAccessible(true);
            return (RealConnectionPool) declaredField.get(connectionPool);
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
            return null;
        }
    }

    private void initRaceHostToFutureMap() {
        this.mRacedHostToFutureMap.put(TVKNetworkUtils.getHostnameFromUrl(TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_VINFO_CGI_DUALSTACK_HOST)), new CopyOnWriteArrayList());
        this.mRacedHostToFutureMap.put(TVKNetworkUtils.getHostnameFromUrl(TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_VINFO_CGI_V4ONLY_HOST)), new CopyOnWriteArrayList());
        this.mRacedHostToFutureMap.put(TVKNetworkUtils.getHostnameFromUrl(TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_LIVE_DUALSTACK_CGI_HOST)), new CopyOnWriteArrayList());
    }

    private boolean isValidForRacingToConnect(@NonNull Call call) {
        OkHttpClient okHttpClient;
        String host;
        List<Future<?>> list;
        if (!TVKMediaPlayerConfig.PlayerConfig.enable_connection_race || Build.VERSION.SDK_INT == 27 || (okHttpClient = this.mOKHttpClient) == null) {
            return false;
        }
        if (this.mRealConnectionPool == null) {
            this.mRealConnectionPool = getRealConnectionPoolFromClient(okHttpClient);
        }
        if (this.mConnections == null) {
            this.mConnections = getConnectionsFromConnectionPool(this.mRealConnectionPool);
        }
        if (this.mRealConnectionPool == null || this.mConnections == null || !(call instanceof RealCall) || (list = this.mRacedHostToFutureMap.get((host = call.request().url().host()))) == null || !list.isEmpty()) {
            return false;
        }
        return !acquiredHostInConnectionPool(host);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$establishConnectionAsync$2(final HttpUrl httpUrl, final InetAddress inetAddress, RealCall realCall) {
        TVKLogUtil.i(TAG, "start establishConnection, host=" + httpUrl.host() + ", ip=" + inetAddress);
        final RealConnection realConnection = new RealConnection(this.mRealConnectionPool, new Route(new Address(httpUrl.host(), httpUrl.port(), this.mOKHttpClient.dns(), this.mOKHttpClient.socketFactory(), this.mOKHttpClient.sslSocketFactory(), this.mOKHttpClient.hostnameVerifier(), this.mOKHttpClient.certificatePinner(), this.mOKHttpClient.authenticator(), this.mOKHttpClient.proxy(), this.mOKHttpClient.protocols(), this.mOKHttpClient.connectionSpecs(), this.mOKHttpClient.proxySelector()), Proxy.NO_PROXY, new InetSocketAddress(inetAddress, httpUrl.port())));
        try {
            realConnection.connect(1000, 250, 250, 0, false, realCall, new EventListener() { // from class: com.tencent.qqlive.tvkplayer.tools.http.okhttp.TVKHappyEyeballsV2ConnectionRace.1
                @Override // okhttp3.EventListener
                public void connectEnd(@NonNull Call call, @NonNull InetSocketAddress inetSocketAddress, @NonNull Proxy proxy, @Nullable Protocol protocol2) {
                    String host = httpUrl.host();
                    TVKLogUtil.i(TVKHappyEyeballsV2ConnectionRace.TAG, "establishConnection done, host=" + host + ", ip=" + inetAddress + ", connect isHealthy=" + realConnection.isHealthy(true));
                    TVKHappyEyeballsV2ConnectionRace.this.mRealConnectionPool.put(realConnection);
                    List<Future> list = (List) TVKHappyEyeballsV2ConnectionRace.this.mRacedHostToFutureMap.get(host);
                    if (list != null) {
                        for (Future future : list) {
                            if (future != null) {
                                try {
                                    future.cancel(true);
                                } catch (Exception e16) {
                                    TVKLogUtil.e(TVKHappyEyeballsV2ConnectionRace.TAG, e16);
                                }
                            }
                        }
                        list.clear();
                    }
                }

                @Override // okhttp3.EventListener
                public void connectFailed(@NonNull Call call, @NonNull InetSocketAddress inetSocketAddress, @NonNull Proxy proxy, @Nullable Protocol protocol2, @NonNull IOException iOException) {
                    TVKLogUtil.e(TVKHappyEyeballsV2ConnectionRace.TAG, iOException);
                }
            });
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: raceToConnect, reason: merged with bridge method [inline-methods] */
    public void lambda$raceToConnectAsync$0(@NonNull final Call call) {
        if (!isValidForRacingToConnect(call)) {
            return;
        }
        String host = call.request().url().host();
        try {
            List<InetAddress> lookup = this.mOKHttpDnsImpl.lookup(host);
            List<Future<?>> list = this.mRacedHostToFutureMap.get(host);
            if (list == null) {
                return;
            }
            int i3 = 0;
            for (final InetAddress inetAddress : crossIpv6AndIpv4Address(lookup)) {
                TVKLogUtil.d(TAG, "start connect raced host=" + host + ", inetAddress=" + inetAddress + ", connectRaceInterval=" + i3);
                list.add(TVKThreadPool.getInstance().obtainScheduledExecutorService().schedule(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.tools.http.okhttp.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        TVKHappyEyeballsV2ConnectionRace.this.lambda$raceToConnect$1(call, inetAddress);
                    }
                }, (long) i3, TimeUnit.MILLISECONDS));
                i3 += 250;
            }
        } catch (UnknownHostException e16) {
            TVKLogUtil.e(TAG, "exception encountered during system dns lookup: " + e16);
        }
    }

    public void raceToConnectAsync(@NonNull final Call call) {
        TVKThreadPool.getInstance().obtainNormalPriorityExecutor().execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.tools.http.okhttp.k
            @Override // java.lang.Runnable
            public final void run() {
                TVKHappyEyeballsV2ConnectionRace.this.lambda$raceToConnectAsync$0(call);
            }
        });
    }
}
