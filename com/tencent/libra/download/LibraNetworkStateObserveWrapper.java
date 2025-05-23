package com.tencent.libra.download;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWConnectivityCallbackRegister;
import com.tencent.biz.richframework.util.RFWNetworkUtils;
import com.tencent.libra.download.LibraNetworkStateObserveWrapper;
import com.tencent.libra.strategy.ILibraBaseStrategy;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0002\u0006\u0003B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u001b\u0010\t\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/libra/download/LibraNetworkStateObserveWrapper;", "", "", "b", "c", "Lcom/tencent/libra/download/LibraNetworkStateObserveWrapper$b;", "a", "Lkotlin/Lazy;", "()Lcom/tencent/libra/download/LibraNetworkStateObserveWrapper$b;", "networkCallback", "", "Z", "hasRegistered", "Lcom/tencent/libra/strategy/ILibraBaseStrategy;", "Lcom/tencent/libra/strategy/ILibraBaseStrategy;", "getStrategy", "()Lcom/tencent/libra/strategy/ILibraBaseStrategy;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "<init>", "(Lcom/tencent/libra/strategy/ILibraBaseStrategy;)V", "d", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class LibraNetworkStateObserveWrapper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy networkCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean hasRegistered;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ILibraBaseStrategy strategy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/libra/download/LibraNetworkStateObserveWrapper$b;", "Landroid/net/ConnectivityManager$NetworkCallback;", "Landroid/net/Network;", "network", "", "a", "", "onAvailable", "Landroid/net/LinkProperties;", "linkProperties", "onLinkPropertiesChanged", "onLost", "<init>", "()V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b extends ConnectivityManager.NetworkCallback {
        private final String a(Network network) {
            String networkType = RFWNetworkUtils.getNetworkType(network);
            if (RFWNetworkUtils.isWifiNetwork(networkType)) {
                String wifiInfoName = RFWNetworkUtils.getWifiInfoName();
                Intrinsics.checkNotNullExpressionValue(wifiInfoName, "RFWNetworkUtils.getWifiInfoName()");
                return wifiInfoName;
            }
            if (RFWNetworkUtils.isCellularNetwork(networkType)) {
                String phoneCarrierName = RFWNetworkUtils.getPhoneCarrierName();
                Intrinsics.checkNotNullExpressionValue(phoneCarrierName, "RFWNetworkUtils.getPhoneCarrierName()");
                return phoneCarrierName;
            }
            Intrinsics.checkNotNullExpressionValue(networkType, "networkType");
            return networkType;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NotNull Network network) {
            Intrinsics.checkNotNullParameter(network, "network");
            super.onAvailable(network);
            String a16 = a(network);
            RFWLog.i("LibraNetworkStateObserveWrapper", RFWLog.CLR, "[onAvailable] network type is " + a16);
            com.tencent.libra.download.b.f118670d.h(a16);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(@NotNull Network network, @NotNull LinkProperties linkProperties) {
            Intrinsics.checkNotNullParameter(network, "network");
            Intrinsics.checkNotNullParameter(linkProperties, "linkProperties");
            super.onLinkPropertiesChanged(network, linkProperties);
            String a16 = a(network);
            RFWLog.i("LibraNetworkStateObserveWrapper", RFWLog.CLR, "[onLinkPropertiesChanged] network type is " + a16);
            com.tencent.libra.download.b.f118670d.h(a16);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NotNull Network network) {
            Intrinsics.checkNotNullParameter(network, "network");
            super.onLost(network);
            String a16 = a(network);
            RFWLog.i("LibraNetworkStateObserveWrapper", RFWLog.CLR, "[onLost] network type is " + a16);
            com.tencent.libra.download.b.f118670d.h(a16);
        }
    }

    public LibraNetworkStateObserveWrapper(@NotNull ILibraBaseStrategy strategy) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.strategy = strategy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.libra.download.LibraNetworkStateObserveWrapper$networkCallback$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LibraNetworkStateObserveWrapper.b invoke() {
                return new LibraNetworkStateObserveWrapper.b();
            }
        });
        this.networkCallback = lazy;
    }

    private final b a() {
        return (b) this.networkCallback.getValue();
    }

    public final void b() {
        if (this.hasRegistered) {
            return;
        }
        this.hasRegistered = true;
        RFWLog.i("LibraNetworkStateObserveWrapper", RFWLog.USR, "RFWNetworkStateObserveWrapper register");
        RFWConnectivityCallbackRegister.INSTANCE.registerNetworkCallback("LibraNetworkStateObserveWrapper", a());
    }

    public final void c() {
        this.hasRegistered = false;
        RFWLog.i("LibraNetworkStateObserveWrapper", RFWLog.USR, "RFWNetworkStateObserveWrapper release");
        com.tencent.libra.download.b.f118670d.g();
        RFWConnectivityCallbackRegister.INSTANCE.unregisterNetworkCallback("LibraNetworkStateObserveWrapper", a());
    }
}
