package com.tencent.qqlive.tvkplayer.tools.http.okhttp;

import android.os.Build;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.AAAARecord;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.ARecord;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Name;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Record;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.SimpleResolver;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.exception.TextParseException;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.LookupResult;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup.LookupSession;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKGlobalEventNotifier;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKNetworkUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKDnsJava {
    private static final String ALIBABA_DNS_SERVER_IPV4_BACKUP = "223.6.6.6";
    private static final String ALIBABA_DNS_SERVER_IPV4_MASTER = "223.5.5.5";
    private static final String ALIBABA_DNS_SERVER_IPV6_BACKUP = "2400:3200:baba::1";
    private static final String ALIBABA_DNS_SERVER_IPV6_MASTER = "2400:3200::1";
    private static final String BAIDU_DNS_SERVER_IPV4_MASTER = "180.76.76.76";
    private static final String BAIDU_DNS_SERVER_IPV6_MASTER = "2400:da00::6666";
    private static final long CLEAR_DNS_RESULT_INTERVAL_SECOND = 120;
    private static final long RESOLVE_HOST_TIMEOUT_SECOND = 10;
    private static final String TAG = "TVKDnsJava";
    private static final String TENCENT_DNS_SERVER_IPV4_BACKUP = "119.28.28.28";
    private static final String TENCENT_DNS_SERVER_IPV4_BACKUP2 = "182.254.116.116";
    private static final String TENCENT_DNS_SERVER_IPV4_MASTER = "119.29.29.29";
    private static final List<String> sIpv4DnsSeverList;
    private static final List<String> sIpv6DnsSeverList;
    private final Set<String> mAsyncQueryingHosts;
    private final Map<String, Set<InetAddress>> mDnsCache;
    private final List<LookupSession> mIpv4LookupSessionList;
    private final List<LookupSession> mIpv6LookupSessionList;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class SingletonHolder {
        private static final TVKDnsJava sInstance = new TVKDnsJava();

        SingletonHolder() {
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        sIpv4DnsSeverList = arrayList;
        ArrayList arrayList2 = new ArrayList();
        sIpv6DnsSeverList = arrayList2;
        arrayList.add(BAIDU_DNS_SERVER_IPV4_MASTER);
        arrayList.add(ALIBABA_DNS_SERVER_IPV4_MASTER);
        arrayList.add(ALIBABA_DNS_SERVER_IPV4_BACKUP);
        arrayList.add(TENCENT_DNS_SERVER_IPV4_MASTER);
        arrayList.add(TENCENT_DNS_SERVER_IPV4_BACKUP);
        arrayList.add(TENCENT_DNS_SERVER_IPV4_BACKUP2);
        arrayList2.add(BAIDU_DNS_SERVER_IPV6_MASTER);
        arrayList2.add(ALIBABA_DNS_SERVER_IPV6_MASTER);
        arrayList2.add(ALIBABA_DNS_SERVER_IPV6_BACKUP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clear() {
        Iterator<Set<InetAddress>> it = this.mDnsCache.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    public static TVKDnsJava getInstance() {
        return SingletonHolder.sInstance;
    }

    private void initDnsResolver() {
        Duration ofSeconds;
        Duration ofSeconds2;
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        Iterator<String> it = sIpv4DnsSeverList.iterator();
        while (it.hasNext()) {
            try {
                SimpleResolver simpleResolver = new SimpleResolver(it.next());
                ofSeconds2 = Duration.ofSeconds(10L);
                simpleResolver.setTimeout(ofSeconds2);
                this.mIpv4LookupSessionList.add(LookupSession.builder().resolver(simpleResolver).build());
            } catch (UnknownHostException e16) {
                TVKLogUtil.e(TAG, "addLookupSession has exception=" + e16);
            }
        }
        Iterator<String> it5 = sIpv6DnsSeverList.iterator();
        while (it5.hasNext()) {
            try {
                SimpleResolver simpleResolver2 = new SimpleResolver(it5.next());
                ofSeconds = Duration.ofSeconds(10L);
                simpleResolver2.setTimeout(ofSeconds);
                this.mIpv6LookupSessionList.add(LookupSession.builder().resolver(simpleResolver2).build());
            } catch (UnknownHostException e17) {
                TVKLogUtil.e(TAG, "addLookupSession has exception=" + e17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$lookupAsync$1(String str) throws Exception {
        return Boolean.valueOf(this.mAsyncQueryingHosts.remove(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$lookupAsync$2(Set set, String str, LookupResult lookupResult) {
        for (Record record : lookupResult.getRecords()) {
            if (record instanceof ARecord) {
                try {
                    set.add(InetAddress.getByName(((ARecord) record).getAddress().getHostAddress()));
                    this.mAsyncQueryingHosts.remove(str);
                } catch (UnknownHostException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$lookupAsync$3(Set set, String str, LookupResult lookupResult) {
        for (Record record : lookupResult.getRecords()) {
            if (record instanceof AAAARecord) {
                try {
                    set.add(InetAddress.getByName(((AAAARecord) record).getAddress().getHostAddress()));
                    this.mAsyncQueryingHosts.remove(str);
                } catch (UnknownHostException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$lookupAsync$4(Set set, String str, LookupResult lookupResult) {
        for (Record record : lookupResult.getRecords()) {
            if (record instanceof ARecord) {
                try {
                    set.add(InetAddress.getByName(((ARecord) record).getAddress().getHostAddress()));
                    this.mAsyncQueryingHosts.remove(str);
                } catch (UnknownHostException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$lookupAsync$5(Set set, String str, LookupResult lookupResult) {
        for (Record record : lookupResult.getRecords()) {
            if (record instanceof AAAARecord) {
                try {
                    set.add(InetAddress.getByName(((AAAARecord) record).getAddress().getHostAddress()));
                    this.mAsyncQueryingHosts.remove(str);
                } catch (UnknownHostException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerNetworkListener$0(int i3, int i16, int i17, Object obj) {
        if (i3 == 100003) {
            clear();
        }
    }

    private void lookupAsync(@NonNull final String str) {
        if (Build.VERSION.SDK_INT < 26 || !TVKMediaPlayerConfig.PlayerConfig.use_dns_java_resolve_host_name || this.mAsyncQueryingHosts.contains(str)) {
            return;
        }
        this.mAsyncQueryingHosts.add(str);
        TVKThreadPool.getInstance().obtainScheduledExecutorService().schedule(new Callable() { // from class: com.tencent.qqlive.tvkplayer.tools.http.okhttp.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean lambda$lookupAsync$1;
                lambda$lookupAsync$1 = TVKDnsJava.this.lambda$lookupAsync$1(str);
                return lambda$lookupAsync$1;
            }
        }, 10L, TimeUnit.SECONDS);
        final Set<InetAddress> set = this.mDnsCache.get(str);
        if (set == null) {
            set = Collections.synchronizedSet(new HashSet());
            this.mDnsCache.put(str, set);
        }
        set.clear();
        try {
            for (LookupSession lookupSession : this.mIpv4LookupSessionList) {
                lookupSession.lookupAsync(Name.fromString(str), 1).thenAccept(new Consumer() { // from class: com.tencent.qqlive.tvkplayer.tools.http.okhttp.e
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        TVKDnsJava.this.lambda$lookupAsync$2(set, str, (LookupResult) obj);
                    }
                });
                lookupSession.lookupAsync(Name.fromString(str), 28).thenAccept(new Consumer() { // from class: com.tencent.qqlive.tvkplayer.tools.http.okhttp.f
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        TVKDnsJava.this.lambda$lookupAsync$3(set, str, (LookupResult) obj);
                    }
                });
            }
            if (TVKNetworkUtils.getIPStackType() == 1) {
                return;
            }
            for (LookupSession lookupSession2 : this.mIpv6LookupSessionList) {
                lookupSession2.lookupAsync(Name.fromString(str), 1).thenAccept(new Consumer() { // from class: com.tencent.qqlive.tvkplayer.tools.http.okhttp.g
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        TVKDnsJava.this.lambda$lookupAsync$4(set, str, (LookupResult) obj);
                    }
                });
                lookupSession2.lookupAsync(Name.fromString(str), 28).thenAccept(new Consumer() { // from class: com.tencent.qqlive.tvkplayer.tools.http.okhttp.h
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        TVKDnsJava.this.lambda$lookupAsync$5(set, str, (LookupResult) obj);
                    }
                });
            }
        } catch (TextParseException e16) {
            TVKLogUtil.e(TAG, e16);
        }
    }

    private void registerNetworkListener() {
        TVKGlobalEventNotifier.getInstance().addEventListener(new TVKGlobalEventNotifier.OnGlobalEventChangeListener() { // from class: com.tencent.qqlive.tvkplayer.tools.http.okhttp.b
            @Override // com.tencent.qqlive.tvkplayer.tools.utils.TVKGlobalEventNotifier.OnGlobalEventChangeListener
            public final void onEvent(int i3, int i16, int i17, Object obj) {
                TVKDnsJava.this.lambda$registerNetworkListener$0(i3, i16, i17, obj);
            }
        });
        TVKThreadPool.getInstance().obtainScheduledExecutorService().scheduleAtFixedRate(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.tools.http.okhttp.c
            @Override // java.lang.Runnable
            public final void run() {
                TVKDnsJava.this.clear();
            }
        }, 120L, 120L, TimeUnit.SECONDS);
    }

    @NonNull
    public List<InetAddress> lookup(@NonNull String str) {
        if (Build.VERSION.SDK_INT <= 27) {
            return Collections.emptyList();
        }
        synchronized (str.intern()) {
            Set<InetAddress> set = this.mDnsCache.get(str);
            if (set != null && !set.isEmpty()) {
                TVKLogUtil.i(TAG, "lookup hostName:" + str + ", result:" + set);
                return new ArrayList(set);
            }
            lookupAsync(str);
            return Collections.emptyList();
        }
    }

    TVKDnsJava() {
        this.mIpv4LookupSessionList = new ArrayList();
        this.mIpv6LookupSessionList = new ArrayList();
        this.mDnsCache = new ConcurrentHashMap();
        this.mAsyncQueryingHosts = Collections.synchronizedSet(new HashSet());
        initDnsResolver();
        registerNetworkListener();
    }
}
