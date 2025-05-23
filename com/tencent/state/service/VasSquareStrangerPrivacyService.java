package com.tencent.state.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.util.Map;
import jt4.a;
import jt4.b;
import jt4.c;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u001c\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/service/VasSquareStrangerPrivacyService;", "", "()V", "CMD_SERVICE", "", "METHOD_GET_STRANGER_VISIBLE", "METHOD_SET_STRANGER_VISIBLE", "TAG", "getStrangerVisible", "", "callback", "Lcom/tencent/state/service/ResultCallback;", "", "setStrangerVisible", NodeProps.VISIBLE, "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSquareStrangerPrivacyService {
    private static final String CMD_SERVICE = "trpc.qmeta.square_stranger_svr.SquareStrangerSvr";
    public static final VasSquareStrangerPrivacyService INSTANCE = new VasSquareStrangerPrivacyService();
    private static final String METHOD_GET_STRANGER_VISIBLE = "GetStrangerVisible";
    private static final String METHOD_SET_STRANGER_VISIBLE = "SetStrangerVisible";
    private static final String TAG = "VasSquareStrangerPrivacyService";

    VasSquareStrangerPrivacyService() {
    }

    public final void getStrangerVisible(final ResultCallback<Boolean> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        a aVar = new a();
        SquareBaseKt.getSquareLog().i(TAG, "getStrangerVisible.");
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(aVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_GET_STRANGER_VISIBLE, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasSquareStrangerPrivacyService$getStrangerVisible$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareStrangerPrivacyService", "getStrangerVisible on error " + data.getErrCode() + ", " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    try {
                        b c16 = b.c(rspData);
                        SquareBaseKt.getSquareLog().d("VasSquareStrangerPrivacyService", "getStrangerVisible on receive " + c16.f410948a);
                        ResultCallback.this.onResultSuccess(Boolean.valueOf(c16.f410948a));
                    } catch (Throwable th5) {
                        SquareBaseKt.getSquareLog().e("VasSquareStrangerPrivacyService", "getStrangerVisible on receive but parse throw:", th5);
                        ResultCallback.this.onResultFailure(-2, "getStrangerVisible parse error");
                    }
                }
            });
        }
    }

    public final void setStrangerVisible(boolean visible, final ResultCallback<Boolean> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        c cVar = new c();
        cVar.f410949a = visible;
        SquareBaseKt.getSquareLog().i(TAG, "setStrangerVisible: visible=" + visible);
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(cVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_SET_STRANGER_VISIBLE, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasSquareStrangerPrivacyService$setStrangerVisible$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareStrangerPrivacyService", "setStrangerVisible on error " + data.getErrCode() + ", " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    SquareBaseKt.getSquareLog().i("VasSquareStrangerPrivacyService", "setStrangerVisible success");
                    ResultCallback.this.onResultSuccess(Boolean.TRUE);
                }
            });
        }
    }
}
