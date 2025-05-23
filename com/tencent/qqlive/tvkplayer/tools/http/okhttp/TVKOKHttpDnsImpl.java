package com.tencent.qqlive.tvkplayer.tools.http.okhttp;

import android.net.Network;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.httpdns.TVKHttpDnsResolverFactory;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKHttpUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKNetworkUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.Dns;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKOKHttpDnsImpl implements Dns {
    private static final long DEFAULT_DNS_TIMEOUT_MS = 2000;
    private static final String TAG = "TVKOKHttpDnsImpl";
    private static final Map<String, DnsFuture> sHostToDnsFutureMap = new ConcurrentHashMap();
    private final boolean mDisableIpv6;

    @DnsPreferred
    private final int mDnsPreferred;
    private final long mDnsTimeoutMs;
    private final boolean mEnableHttpDns;
    private final boolean mNeedShuffle;

    @Nullable
    private final Network mNetworkInterface;
    private final boolean mUseRemoteDns;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Builder {
        private long dnsTimeoutMs = 2000;
        private Network networkInterface = null;
        private boolean needShuffle = true;
        private boolean enableHttpDns = false;

        @DnsPreferred
        private int dnsPreferred = 0;
        private boolean disableIpv6 = false;
        private boolean useRemoteDns = true;

        public TVKOKHttpDnsImpl build() {
            return new TVKOKHttpDnsImpl(this);
        }

        public Builder disableIpv6(boolean z16) {
            this.disableIpv6 = z16;
            return this;
        }

        public Builder dnsPreferred(@DnsPreferred int i3) {
            this.dnsPreferred = i3;
            return this;
        }

        public Builder dnsTimeoutMs(long j3) {
            this.dnsTimeoutMs = j3;
            return this;
        }

        public Builder httpDns(boolean z16) {
            this.enableHttpDns = z16;
            return this;
        }

        public Builder networkInterface(@Nullable Network network) {
            this.networkInterface = network;
            return this;
        }

        public Builder remoteDns(boolean z16) {
            this.useRemoteDns = z16;
            return this;
        }

        public Builder shuffle(boolean z16) {
            this.needShuffle = z16;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public @interface DnsPreferred {
        public static final int HTTP_DNS_FIRST = 1;
        public static final int SYSTEM_DNS_FIRST = 0;
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public @interface DnsResolverType {
        public static final String HTTP_DNS = "httpdns";
        public static final String SYSTEM_DNS = "systemdns";
    }

    private List<InetAddress> excludeIpv6AddressIfNeeded(List<InetAddress> list) {
        if ((this.mDisableIpv6 || (!TVKNetworkUtils.isNetworkTypeMobile() && (TVKNetworkUtils.getNetworkType() != 1 || !TVKMediaPlayerConfig.PlayerConfig.is_wifi_use_ipv6))) && TVKNetworkUtils.getIPStackType() != 2 && !TVKHttpUtils.isIpv6OnlyAddresses(list)) {
            ArrayList arrayList = new ArrayList();
            for (InetAddress inetAddress : list) {
                if (inetAddress instanceof Inet4Address) {
                    arrayList.add(inetAddress);
                }
            }
            return arrayList;
        }
        return list;
    }

    @NonNull
    private String generateCacheKeyForDnsFuture(@NonNull String str, @NonNull String str2) {
        Object valueOf;
        String str3 = str + "_" + TVKNetworkUtils.getNetworkType() + "_" + str2 + "_";
        Network network = this.mNetworkInterface;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str3);
        if (network == null) {
            valueOf = "";
        } else {
            valueOf = Long.valueOf(network.getNetworkHandle());
        }
        sb5.append(valueOf);
        return sb5.toString();
    }

    @NonNull
    private List<InetAddress> getHttpDnsResult(String str) {
        DnsFuture dnsFuture;
        if (!shouldResolveHostWithHttpDns()) {
            return Collections.emptyList();
        }
        List<InetAddress> emptyList = Collections.emptyList();
        String generateCacheKeyForDnsFuture = generateCacheKeyForDnsFuture(str, DnsResolverType.HTTP_DNS);
        synchronized (generateCacheKeyForDnsFuture.intern()) {
            Map<String, DnsFuture> map = sHostToDnsFutureMap;
            dnsFuture = map.get(generateCacheKeyForDnsFuture);
            if (dnsFuture == null || dnsFuture.isInvalid()) {
                dnsFuture = lookupByHttpDnsAsync(str);
                map.put(generateCacheKeyForDnsFuture, dnsFuture);
            }
        }
        try {
            emptyList = dnsFuture.get(this.mDnsTimeoutMs, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e16) {
            e = e16;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("exception encountered during http dns lookup: ");
            if (e.getCause() != null) {
                e = e.getCause();
            }
            sb5.append(e);
            TVKLogUtil.e(TAG, sb5.toString());
        }
        if (emptyList == null) {
            return Collections.emptyList();
        }
        return emptyList;
    }

    @NonNull
    private List<InetAddress> getSystemDnsResult(String str) {
        DnsFuture dnsFuture;
        List<InetAddress> list;
        String generateCacheKeyForDnsFuture = generateCacheKeyForDnsFuture(str, DnsResolverType.SYSTEM_DNS);
        synchronized (generateCacheKeyForDnsFuture.intern()) {
            Map<String, DnsFuture> map = sHostToDnsFutureMap;
            dnsFuture = map.get(generateCacheKeyForDnsFuture);
            if (dnsFuture == null || dnsFuture.isInvalid()) {
                dnsFuture = lookupBySystemDnsAsync(str);
                map.put(generateCacheKeyForDnsFuture, dnsFuture);
            }
        }
        try {
            list = dnsFuture.get(this.mDnsTimeoutMs, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e16) {
            e = e16;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("exception encountered during system dns lookup: ");
            if (e.getCause() != null) {
                e = e.getCause();
            }
            sb5.append(e);
            TVKLogUtil.e(TAG, sb5.toString());
            list = null;
        }
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$lookupByHttpDnsAsync$2(String str) throws Exception {
        return TVKHttpDnsResolverFactory.getHttpDnsResolver().lookup(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$lookupBySystemDnsAsync$0(String str) throws Exception {
        return Arrays.asList(this.mNetworkInterface.getAllByName(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$lookupBySystemDnsAsync$1(String str) throws Exception {
        return Dns.SYSTEM.lookup(str);
    }

    private List<InetAddress> lookupAsyncWithWait(String str) throws UnknownHostException {
        List<InetAddress> emptyList;
        if (this.mDnsPreferred == 1) {
            List<InetAddress> httpDnsResult = getHttpDnsResult(str);
            if (!httpDnsResult.isEmpty()) {
                return httpDnsResult;
            }
            List<InetAddress> systemDnsResult = getSystemDnsResult(str);
            if (systemDnsResult.isEmpty()) {
                return systemDnsResult;
            }
        } else {
            List<InetAddress> systemDnsResult2 = getSystemDnsResult(str);
            if (!systemDnsResult2.isEmpty()) {
                return systemDnsResult2;
            }
            List<InetAddress> httpDnsResult2 = getHttpDnsResult(str);
            if (!httpDnsResult2.isEmpty()) {
                return httpDnsResult2;
            }
        }
        if (this.mUseRemoteDns) {
            emptyList = TVKDnsJava.getInstance().lookup(str);
        } else {
            emptyList = Collections.emptyList();
        }
        if (!emptyList.isEmpty()) {
            return emptyList;
        }
        throw new UnknownHostException("Broken HttpDns behaviour for dns lookup of " + str);
    }

    @NonNull
    private DnsFuture lookupByHttpDnsAsync(final String str) {
        return new DnsFuture(TVKThreadPool.getInstance().obtainHighPriorityExecutor().submit(new Callable() { // from class: com.tencent.qqlive.tvkplayer.tools.http.okhttp.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List lambda$lookupByHttpDnsAsync$2;
                lambda$lookupByHttpDnsAsync$2 = TVKOKHttpDnsImpl.lambda$lookupByHttpDnsAsync$2(str);
                return lambda$lookupByHttpDnsAsync$2;
            }
        }));
    }

    @NonNull
    private DnsFuture lookupBySystemDnsAsync(final String str) {
        if (this.mNetworkInterface != null) {
            TVKLogUtil.i(TAG, "use cellular network lookup, hostName=" + str);
            return new DnsFuture(TVKThreadPool.getInstance().obtainHighPriorityExecutor().submit(new Callable() { // from class: com.tencent.qqlive.tvkplayer.tools.http.okhttp.n
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    List lambda$lookupBySystemDnsAsync$0;
                    lambda$lookupBySystemDnsAsync$0 = TVKOKHttpDnsImpl.this.lambda$lookupBySystemDnsAsync$0(str);
                    return lambda$lookupBySystemDnsAsync$0;
                }
            }));
        }
        return new DnsFuture(TVKThreadPool.getInstance().obtainHighPriorityExecutor().submit(new Callable() { // from class: com.tencent.qqlive.tvkplayer.tools.http.okhttp.o
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List lambda$lookupBySystemDnsAsync$1;
                lambda$lookupBySystemDnsAsync$1 = TVKOKHttpDnsImpl.lambda$lookupBySystemDnsAsync$1(str);
                return lambda$lookupBySystemDnsAsync$1;
            }
        }));
    }

    private boolean shouldResolveHostWithHttpDns() {
        if (!TVKMediaPlayerConfig.PlayerConfig.use_http_dns_when_sys_dns_failed || !this.mEnableHttpDns) {
            return false;
        }
        return true;
    }

    private List<InetAddress> sortInetAddressByIpv6First(List<InetAddress> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (InetAddress inetAddress : list) {
                if (inetAddress instanceof Inet6Address) {
                    arrayList.add(inetAddress);
                } else {
                    arrayList2.add(inetAddress);
                }
            }
            arrayList.addAll(arrayList2);
            return arrayList;
        }
        return Collections.emptyList();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.mNetworkInterface == ((TVKOKHttpDnsImpl) obj).mNetworkInterface) {
            return true;
        }
        return false;
    }

    @Override // okhttp3.Dns
    @NonNull
    public List<InetAddress> lookup(@NonNull String str) throws UnknownHostException {
        if (!TextUtils.isEmpty(str)) {
            if (TVKHttpUtils.isIpAddress(str)) {
                return Arrays.asList(InetAddress.getAllByName(str));
            }
            List<InetAddress> excludeIpv6AddressIfNeeded = excludeIpv6AddressIfNeeded(lookupAsyncWithWait(str));
            if (this.mNeedShuffle && excludeIpv6AddressIfNeeded.size() > 1) {
                Collections.shuffle(excludeIpv6AddressIfNeeded);
            }
            return sortInetAddressByIpv6First(excludeIpv6AddressIfNeeded);
        }
        throw new UnknownHostException("hostName is null or empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class DnsFuture implements Future<List<InetAddress>> {
        private static final long DEFAULT_EXPIRED_TIME_MS = -1;
        private final Future<List<InetAddress>> mFuture;
        private List<InetAddress> mResult;
        private final long FUTURE_TASK_RESULT_TTL_MS = TVKMediaPlayerConfig.PlayerConfig.cache_dns_future_ttl_ms;
        private volatile long mResultExpiredTimeMs = -1;

        public DnsFuture(@NonNull Future<List<InetAddress>> future) {
            this.mFuture = future;
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z16) {
            return this.mFuture.cancel(z16);
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.mFuture.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.mFuture.isDone();
        }

        public boolean isInvalid() {
            if (!this.mFuture.isDone()) {
                return false;
            }
            List<InetAddress> list = this.mResult;
            if ((list == null || !list.isEmpty()) && SystemClock.elapsedRealtime() <= this.mResultExpiredTimeMs) {
                return false;
            }
            return true;
        }

        @Override // java.util.concurrent.Future
        public List<InetAddress> get() throws ExecutionException, InterruptedException {
            this.mResult = this.mFuture.get();
            if (this.mResultExpiredTimeMs == -1) {
                this.mResultExpiredTimeMs = SystemClock.elapsedRealtime() + this.FUTURE_TASK_RESULT_TTL_MS;
            }
            return this.mResult;
        }

        @Override // java.util.concurrent.Future
        public List<InetAddress> get(long j3, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            this.mResult = this.mFuture.get(j3, timeUnit);
            if (this.mResultExpiredTimeMs == -1) {
                this.mResultExpiredTimeMs = SystemClock.elapsedRealtime() + this.FUTURE_TASK_RESULT_TTL_MS;
            }
            return this.mResult;
        }
    }

    TVKOKHttpDnsImpl(Builder builder) {
        this.mNetworkInterface = builder.networkInterface;
        this.mNeedShuffle = builder.needShuffle;
        this.mDnsPreferred = builder.dnsPreferred;
        this.mEnableHttpDns = builder.enableHttpDns;
        this.mDnsTimeoutMs = builder.dnsTimeoutMs;
        this.mDisableIpv6 = builder.disableIpv6;
        this.mUseRemoteDns = builder.useRemoteDns;
    }
}
