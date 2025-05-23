package com.tencent.state.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.status.FinishStatusInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import rt4.d;
import rt4.e;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/service/VasStatusTaskInfoService;", "", "()V", Const.BUNDLE_KEY_REQUEST, "", "status", "", "richStatus", "callback", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/status/FinishStatusInfo;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasStatusTaskInfoService {
    private static final String CMD_SERVICE = "trpc.qmeta.status_panel_svr.StatusPanel";
    private static final String METHOD = "FinishStatusTask";
    private static final String TAG = "VasStatusTaskInfoService";

    public final void request(int status, int richStatus, final ResultCallback<FinishStatusInfo> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        d dVar = new d();
        dVar.f432399a = status;
        dVar.f432400b = richStatus;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(dVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasStatusTaskInfoService$request$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasStatusTaskInfoService", "errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    try {
                        e rsp = e.c(rspData);
                        if (rsp == null) {
                            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasStatusTaskInfoService", "rsp is null", null, 4, null);
                        }
                        ResultCallback resultCallback = ResultCallback.this;
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        resultCallback.onResultSuccess(UserFormatKt.formatFinishStatusTask(rsp));
                    } catch (Exception e16) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasStatusTaskInfoService", "parse error " + e16, null, 4, null);
                        ResultCallback.this.onResultFailure(-1, e16.getMessage());
                    }
                }
            });
        }
    }
}
