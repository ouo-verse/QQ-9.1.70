package com.tencent.state.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.status.NewStatusInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import rt4.h;
import rt4.i;
import rt4.s;
import rt4.t;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/service/VasSquareNewStatusRedDotService;", "", "()V", "getNewStatus", "", "callback", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/status/NewStatusInfo;", "setNewStatus", "redDotId", "", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSquareNewStatusRedDotService {
    private static final String CMD_SERVICE = "trpc.qmeta.status_panel_svr.StatusPanel";
    private static final String GET_METHOD = "GetNewStatusReddot";
    private static final String SET_METHOD = "SetNewStatusReddotCursor";
    private static final String TAG = "VasSquareNewStatusRedDotService";

    public final void getNewStatus(final ResultCallback<NewStatusInfo> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        h hVar = new h();
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(hVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, GET_METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasSquareNewStatusRedDotService$getNewStatus$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareNewStatusRedDotService", "errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    try {
                        i rsp = i.c(rspData);
                        if (rsp == null) {
                            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareNewStatusRedDotService", "rsp is null", null, 4, null);
                        }
                        ResultCallback resultCallback = ResultCallback.this;
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        resultCallback.onResultSuccess(UserFormatKt.formatNewStatusRedDot(rsp));
                    } catch (Exception e16) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareNewStatusRedDotService", "parse error " + e16, null, 4, null);
                        ResultCallback.this.onResultFailure(-1, e16.getMessage());
                    }
                }
            });
        }
    }

    public final void setNewStatus(long redDotId, final ResultCallback<Boolean> callback) {
        Map<String, String> emptyMap;
        s sVar = new s();
        sVar.f432448a = redDotId;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(sVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, SET_METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasSquareNewStatusRedDotService$setNewStatus$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareNewStatusRedDotService", "errCode: " + data.getErrCode() + ", errMsg: " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    if (resultCallback != null) {
                        Integer errCode = data.getErrCode();
                        resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    try {
                        if (t.c(rspData) == null) {
                            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareNewStatusRedDotService", "rsp is null", null, 4, null);
                        }
                        ResultCallback resultCallback = ResultCallback.this;
                        if (resultCallback != null) {
                            resultCallback.onResultSuccess(Boolean.TRUE);
                        }
                    } catch (Exception e16) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareNewStatusRedDotService", "parse error " + e16, null, 4, null);
                        ResultCallback resultCallback2 = ResultCallback.this;
                        if (resultCallback2 != null) {
                            resultCallback2.onResultFailure(-1, e16.getMessage());
                        }
                    }
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setNewStatus$default(VasSquareNewStatusRedDotService vasSquareNewStatusRedDotService, long j3, ResultCallback resultCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            resultCallback = null;
        }
        vasSquareNewStatusRedDotService.setNewStatus(j3, resultCallback);
    }
}
