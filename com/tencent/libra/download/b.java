package com.tencent.libra.download;

import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWNetworkUtils;
import com.tencent.libra.strategy.ILibraBaseStrategy;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J&\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bJ\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u001e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0016J\u001e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cR\"\u0010\"\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u000b0\u000b0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010!R \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010%R\u0016\u0010(\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/libra/download/b;", "", "Lcom/tencent/libra/strategy/ILibraBaseStrategy;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "", "e", "g", "businessStrategy", "", "Ljava/net/InetAddress;", "addressList", "", "hostName", "f", "networkSateType", h.F, "Lokhttp3/Call;", "call", "Ljava/net/InetSocketAddress;", "inetSocketAddress", "c", "d", "Ljava/io/IOException;", "exception", "b", "inetAddress", "", "totalBytes", "", "totalTime", "a", "Ljava/util/concurrent/CopyOnWriteArrayList;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/CopyOnWriteArrayList;", "strategyIpList", "Ljava/util/concurrent/ConcurrentHashMap;", "Ly01/a;", "Ljava/util/concurrent/ConcurrentHashMap;", "ipStrategyMap", "Ljava/lang/String;", "currentNetworkStateType", "<init>", "()V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<String> strategyIpList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, y01.a> ipStrategyMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String currentNetworkStateType;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final b f118670d = new b();

    static {
        List listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"IPV6_AND_IPV4_INTERWEAVE", "IP_RACE", "IP_BLACKLIST"});
        strategyIpList = new CopyOnWriteArrayList<>(listOf);
        ipStrategyMap = new ConcurrentHashMap<>();
        currentNetworkStateType = "";
    }

    b() {
    }

    private final void e(ILibraBaseStrategy strategy) {
        w01.a libraIpStrategyBean;
        w01.a libraIpStrategyBean2;
        w01.a libraIpStrategyBean3;
        ConcurrentHashMap<String, y01.a> concurrentHashMap = ipStrategyMap;
        if (strategy != null && (libraIpStrategyBean3 = strategy.getLibraIpStrategyBean()) != null && libraIpStrategyBean3.getIsSupportIpv6AndIpv4Interweave() && !concurrentHashMap.containsKey("IPV6_AND_IPV4_INTERWEAVE")) {
            RFWLog.i("LibraNetworkStateObserver", RFWLog.USR, "init interweave strategy");
            concurrentHashMap.put("IPV6_AND_IPV4_INTERWEAVE", new y01.d(strategy));
        }
        if (strategy != null && (libraIpStrategyBean2 = strategy.getLibraIpStrategyBean()) != null && libraIpStrategyBean2.getIsSupportIpRaceStrategy() && !concurrentHashMap.containsKey("IP_RACE")) {
            RFWLog.i("LibraNetworkStateObserver", RFWLog.USR, "init ip race strategy");
            concurrentHashMap.put("IP_RACE", new y01.c(strategy));
        }
        if (strategy != null && (libraIpStrategyBean = strategy.getLibraIpStrategyBean()) != null && libraIpStrategyBean.getIsSupportIpBlacklist() && !concurrentHashMap.containsKey("IP_BLACKLIST")) {
            RFWLog.i("LibraNetworkStateObserver", RFWLog.USR, "init ip blacklist strategy");
            concurrentHashMap.put("IP_BLACKLIST", new y01.b(strategy));
        }
    }

    public final void a(@NotNull InetAddress inetAddress, long totalBytes, float totalTime) {
        Intrinsics.checkNotNullParameter(inetAddress, "inetAddress");
        for (String str : strategyIpList) {
            y01.a aVar = ipStrategyMap.get(str);
            if (aVar != null) {
                RFWLog.i("LibraNetworkStateObserver", RFWLog.DEV, "[handleOkHttpBytesReadDone] | strategy is " + str);
                if (aVar.i()) {
                    aVar.e(inetAddress, totalBytes, totalTime);
                }
            }
        }
    }

    public final void b(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull IOException exception) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(exception, "exception");
        for (String str : strategyIpList) {
            y01.a aVar = ipStrategyMap.get(str);
            if (aVar != null) {
                RFWLog.i("LibraNetworkStateObserver", RFWLog.DEV, "[handleOkHttpConnectFail] | strategy is " + str);
                if (aVar.i()) {
                    aVar.f(call, inetSocketAddress, exception);
                }
            }
        }
    }

    public final void c(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        for (String str : strategyIpList) {
            y01.a aVar = ipStrategyMap.get(str);
            if (aVar != null) {
                RFWLog.i("LibraNetworkStateObserver", RFWLog.DEV, "[handleOkHttpConnectStart] | strategy is " + str);
                if (aVar.i()) {
                    aVar.g(call, inetSocketAddress);
                }
            }
        }
    }

    public final void d(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        for (String str : strategyIpList) {
            y01.a aVar = ipStrategyMap.get(str);
            if (aVar != null) {
                RFWLog.i("LibraNetworkStateObserver", RFWLog.DEV, "[handleOkHttpConnectSuccess] | strategy is " + str);
                if (aVar.i()) {
                    aVar.h(call, inetSocketAddress);
                }
            }
        }
    }

    public final void f(@Nullable ILibraBaseStrategy businessStrategy, @NotNull List<InetAddress> addressList, @NotNull String hostName) {
        Intrinsics.checkNotNullParameter(addressList, "addressList");
        Intrinsics.checkNotNullParameter(hostName, "hostName");
        e(businessStrategy);
        for (String str : strategyIpList) {
            y01.a aVar = ipStrategyMap.get(str);
            if (aVar != null) {
                RFWLog.i("LibraNetworkStateObserver", RFWLog.DEV, "[interveneByIpStrategyList] | strategy is " + str);
                if (aVar.i()) {
                    aVar.a(addressList, hostName);
                }
            }
        }
    }

    public final void g() {
        ipStrategyMap.clear();
    }

    public final void h(@NotNull String networkSateType) {
        Intrinsics.checkNotNullParameter(networkSateType, "networkSateType");
        if (TextUtils.isEmpty(networkSateType)) {
            RFWLog.e("LibraNetworkStateObserver", RFWLog.USR, "networkSateType is empty");
            return;
        }
        if (!TextUtils.equals(currentNetworkStateType, networkSateType) || RFWNetworkUtils.isWifiNetwork(networkSateType) || RFWNetworkUtils.isCellularNetwork(networkSateType)) {
            RFWLog.i("LibraNetworkStateObserver", RFWLog.USR, "clear cache ip info");
            for (String str : strategyIpList) {
                y01.a aVar = ipStrategyMap.get(str);
                if (aVar != null) {
                    RFWLog.i("LibraNetworkStateObserver", RFWLog.DEV, "[updateCurrentNetworkStateType] | strategy is " + str);
                    aVar.b();
                }
            }
        }
        currentNetworkStateType = networkSateType;
    }
}
