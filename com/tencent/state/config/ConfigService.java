package com.tencent.state.config;

import com.google.protobuf.nano.MessageNano;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nt4.b;
import nt4.c;
import nt4.d;
import nt4.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0006\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002J$\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00040\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/config/ConfigService;", "", "Lkotlin/Function1;", "Lnt4/e;", "", "callback", "getConfig", "", "buildingIds", "Lnt4/c;", "getBuildingConfig", "<init>", "()V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ConfigService {
    private static final String METHOD = "GetConfig";
    private static final String METHOD_GET_BUILDING_CONFIG = "GetBuildingConfig";
    private static final String SERVICE = "trpc.qmeta.status_config_svr.StatusConfig";
    private static final String TAG = "ConfigService";

    public final void getBuildingConfig(int[] buildingIds, final Function1<? super c, Unit> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(buildingIds, "buildingIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        b bVar = new b();
        bVar.f421279a = buildingIds;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(bVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(SERVICE, METHOD_GET_BUILDING_CONFIG, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.config.ConfigService$getBuildingConfig$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ConfigService", "getConfig failed errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    Function1.this.invoke(null);
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    c cVar;
                    try {
                        cVar = c.c(rspData);
                    } catch (Throwable th5) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ConfigService", "getConfig failed " + th5.getMessage(), null, 4, null);
                        cVar = null;
                    }
                    Function1.this.invoke(cVar);
                }
            });
        }
    }

    public final void getConfig(final Function1<? super e, Unit> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        d dVar = new d();
        Square square = Square.INSTANCE;
        dVar.f421281a = square.getConfig().getCommonUtils().getCpuCoreNum();
        dVar.f421282b = square.getConfig().getCommonUtils().getCpuMaxFreq();
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareBaseKt.getSquareLog().d(TAG, "req: " + dVar.f421281a + ", " + dVar.f421282b + ", " + square.getConfig().getCommonUtils().getRAMSize());
        }
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(dVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(SERVICE, METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.config.ConfigService$getConfig$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ConfigService", "getConfig failed errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    Function1.this.invoke(null);
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    e eVar;
                    try {
                        eVar = e.c(rspData);
                    } catch (Throwable th5) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ConfigService", "getConfig failed " + th5.getMessage(), null, 4, null);
                        eVar = null;
                    }
                    SquareLogger squareLog = SquareBaseKt.getSquareLog();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("getConfig playCount is ");
                    sb5.append(eVar != null ? Integer.valueOf(eVar.f421283a) : null);
                    sb5.append(", forbidden: ");
                    sb5.append(eVar != null ? Boolean.valueOf(eVar.f421284b) : null);
                    squareLog.i("ConfigService", sb5.toString());
                    Function1.this.invoke(eVar);
                }
            });
        }
    }
}
