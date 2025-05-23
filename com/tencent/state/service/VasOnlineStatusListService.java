package com.tencent.state.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.PanelInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import rt4.j;
import rt4.k;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/service/VasOnlineStatusListService;", "", "()V", "getOnlineStatusList", "", "isMale", "", "status", "", "richStatus", "recentList", "", "", "callback", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/square/data/PanelInfo;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasOnlineStatusListService {
    private static final String CMD_SERVICE = "trpc.qmeta.status_panel_svr.StatusPanel";
    private static final String METHOD = "GetStatusPanel";
    private static final String TAG = "VasOnlineStatusListService";

    public final void getOnlineStatusList(boolean isMale, int status, int richStatus, List<Long> recentList, final ResultCallback<PanelInfo> callback) {
        long[] longArray;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(recentList, "recentList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (Square.INSTANCE.getConfig().isDebug() && SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareBaseKt.getSquareLog().d(TAG, "getOnlineStatusList: " + isMale + ", " + status + ", " + richStatus);
        }
        j jVar = new j();
        jVar.f432414a = isMale ? 1 : 2;
        jVar.f432415b = status;
        jVar.f432416c = richStatus;
        longArray = CollectionsKt___CollectionsKt.toLongArray(recentList);
        jVar.f432417d = longArray;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(jVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasOnlineStatusListService$getOnlineStatusList$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasOnlineStatusListService", "errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    try {
                        k rsp = k.c(rspData);
                        if (rsp == null) {
                            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasOnlineStatusListService", "rsp is null", null, 4, null);
                        }
                        ResultCallback resultCallback = ResultCallback.this;
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        resultCallback.onResultSuccess(UserFormatKt.formatPanelInfo(rsp));
                    } catch (Exception e16) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasOnlineStatusListService", "parse error " + e16, null, 4, null);
                        ResultCallback.this.onResultFailure(-1, e16.getMessage());
                    }
                }
            });
        }
    }
}
