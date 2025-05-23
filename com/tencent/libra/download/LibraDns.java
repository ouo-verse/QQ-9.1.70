package com.tencent.libra.download;

import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.request.IpPortMappingConfig;
import com.tencent.libra.request.Option;
import com.tencent.libra.strategy.ILibraBaseStrategy;
import com.tencent.libra.util.LibraLogUtil;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R&\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00040\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/libra/download/LibraDns;", "Lokhttp3/Dns;", "", "hostname", "", "Ljava/net/InetAddress;", "addressList", "", "addSystemLookUpResult", "addIpDirectConfiguration", "Lcom/tencent/libra/request/Option;", "option", "handleIpConnect", "Lokhttp3/HttpUrl;", "getHttpUrl", "lookup", "TAG", "Ljava/lang/String;", "", "Lcom/tencent/libra/request/c;", "optionHostIpsMap", "Ljava/util/Map;", "Lcom/tencent/libra/strategy/ILibraBaseStrategy;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "Lcom/tencent/libra/strategy/ILibraBaseStrategy;", "getStrategy", "()Lcom/tencent/libra/strategy/ILibraBaseStrategy;", "<init>", "(Lcom/tencent/libra/strategy/ILibraBaseStrategy;)V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class LibraDns implements Dns {
    private final String TAG;
    private final Map<String, List<IpPortMappingConfig>> optionHostIpsMap;

    @NotNull
    private final ILibraBaseStrategy strategy;

    public LibraDns(@NotNull ILibraBaseStrategy strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.strategy = strategy;
        this.TAG = LibraLogUtil.INSTANCE.getLogTag("LibraDns");
        this.optionHostIpsMap = new ConcurrentHashMap();
    }

    private final void addIpDirectConfiguration(String hostname, List<InetAddress> addressList) {
        boolean z16;
        IpConnectConfig ipConnectConfig = this.strategy.getIpConnectConfig(hostname);
        if (ipConnectConfig != null) {
            List<IpPortMappingConfig> ipPortList = ipConnectConfig.getIpPortList();
            if (ipPortList != null && !ipPortList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return;
            }
            Iterator<T> it = ipConnectConfig.getIpPortList().iterator();
            while (it.hasNext()) {
                InetAddress byName = InetAddress.getByName(((IpPortMappingConfig) it.next()).getIp());
                Intrinsics.checkNotNullExpressionValue(byName, "InetAddress.getByName(it.ip)");
                addressList.add(byName);
            }
        }
    }

    private final void addSystemLookUpResult(String hostname, List<InetAddress> addressList) {
        try {
            addressList.addAll(Dns.SYSTEM.lookup(hostname));
        } catch (Exception e16) {
            RFWLog.e(this.TAG, RFWLog.USR, "[addSystemLookUpResult] error: hostname=", hostname, " addressList size=", Integer.valueOf(addressList.size()), " exception=", e16.getMessage());
        }
    }

    @NotNull
    public final HttpUrl getHttpUrl(@NotNull Option option) {
        Intrinsics.checkNotNullParameter(option, "option");
        HttpUrl.Companion companion = HttpUrl.INSTANCE;
        String url = option.getUrl();
        Intrinsics.checkNotNullExpressionValue(url, "option.url");
        return companion.get(url);
    }

    @NotNull
    public final ILibraBaseStrategy getStrategy() {
        return this.strategy;
    }

    public final void handleIpConnect(@NotNull Option option) {
        Intrinsics.checkNotNullParameter(option, "option");
        IpConnectConfig f16 = com.tencent.libra.util.a.f118813a.f(option);
        if (f16 != null) {
            this.optionHostIpsMap.put(f16.getHost(), f16.getIpPortList());
        }
    }

    @Override // okhttp3.Dns
    @NotNull
    public List<InetAddress> lookup(@NotNull String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        ArrayList arrayList = new ArrayList();
        if (this.strategy.getLibraIpStrategyBean().getIsSupportIpDirectFirst()) {
            addIpDirectConfiguration(hostname, arrayList);
            addSystemLookUpResult(hostname, arrayList);
        } else {
            addSystemLookUpResult(hostname, arrayList);
            addIpDirectConfiguration(hostname, arrayList);
        }
        b.f118670d.f(this.strategy, arrayList, hostname);
        return arrayList;
    }
}
