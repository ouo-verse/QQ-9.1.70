package com.tencent.state.publicchat.service;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.state.SquareRuntime;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import zs4.c;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/publicchat/service/VasChatWriteService;", "", "()V", "METHOD_SEND_MSG", "", "SERVICE", "TAG", SmsPlugin.API_SEND_SMS, "", "req", "Lcom/tencent/state/publicchat/service/SendMsgReq;", "callback", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/publicchat/service/SendMsgRsp;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasChatWriteService {
    public static final VasChatWriteService INSTANCE = new VasChatWriteService();
    private static final String METHOD_SEND_MSG = "SendMsg";
    private static final String SERVICE = "trpc.qmeta.public_chat_write_svr.ChatWrite";
    private static final String TAG = "VasChatWriteService";

    VasChatWriteService() {
    }

    public final void sendMsg(SendMsgReq req, final ResultCallback<SendMsgRsp> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "sendMsg request. " + req);
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            callback.onResultFailure(-3, "sendMsg network delegate is null");
            return;
        }
        byte[] byteArray = MessageNano.toByteArray(req.toPB());
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req.toPB())");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest(SERVICE, METHOD_SEND_MSG, byteArray, emptyMap, SquareRuntime.INSTANCE.getQMetaContextSource(), new INetworkDelegateCallBack() { // from class: com.tencent.state.publicchat.service.VasChatWriteService$sendMsg$1
            /* JADX WARN: Removed duplicated region for block: B:10:0x005d  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0061  */
            @Override // com.tencent.state.api.INetworkDelegateCallBack
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onError(SquareErrorData data) {
                boolean z16;
                String prompt;
                boolean isBlank;
                Intrinsics.checkNotNullParameter(data, "data");
                Integer errCode = data.getErrCode();
                int intValue = errCode != null ? errCode.intValue() : -1;
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasChatWriteService", "sendMsg error: code=" + intValue + ", message=" + data.getErrMsg() + ", prompt=" + data.getPrompt(), null, 4, null);
                String prompt2 = data.getPrompt();
                if (prompt2 != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(prompt2);
                    if (!isBlank) {
                        z16 = false;
                        if (!z16) {
                            prompt = VSNetLightQUICBaseRequest.NETWORK_ERROR_HINT;
                        } else {
                            prompt = data.getPrompt();
                        }
                        ResultCallback.this.onResultFailure(intValue, data.getErrMsg(), prompt);
                    }
                }
                z16 = true;
                if (!z16) {
                }
                ResultCallback.this.onResultFailure(intValue, data.getErrMsg(), prompt);
            }

            @Override // com.tencent.state.api.INetworkDelegateCallBack
            public void onReceive(byte[] rspData) {
                try {
                    SendMsgRsp sendMsgRsp = new SendMsgRsp(c.c(rspData));
                    SquareBaseKt.getSquareLog().i("VasChatWriteService", "sendMsg success: info = " + sendMsgRsp);
                    ResultCallback.this.onResultSuccess(sendMsgRsp);
                } catch (InvalidProtocolBufferNanoException e16) {
                    SquareBaseKt.getSquareLog().e("VasChatWriteService", "sendMsg parse err.", e16);
                    ResultCallback.this.onResultFailure(-2, "sendMsg parse error");
                }
            }
        });
    }
}
