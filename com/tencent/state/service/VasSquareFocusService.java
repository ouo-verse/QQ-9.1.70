package com.tencent.state.service;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest;
import com.tencent.state.SquareRuntime;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import ft4.a;
import ft4.b;
import ft4.c;
import ft4.j;
import ft4.k;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J<\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u0004J$\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/service/VasSquareFocusService;", "", "", "appId", "Lcom/tencent/state/service/ResultCallback;", "", "callback", "callGather", "", "uin", "focusId", "tableId", "deskmateTableId", "Lft4/b;", "applyCallGather", "Lft4/k;", "watchUserRoom", "", "TAG", "Ljava/lang/String;", "SERVICE", "METHOD_CALL_GATHER", "METHOD_APPLY_CALL_GATHER", "METHOD_WATCH_USER_ROOM", "<init>", "()V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSquareFocusService {
    public static final VasSquareFocusService INSTANCE = new VasSquareFocusService();
    private static final String METHOD_APPLY_CALL_GATHER = "ApplyCallGather";
    private static final String METHOD_CALL_GATHER = "CallGather";
    private static final String METHOD_WATCH_USER_ROOM = "WatchUserRoom";
    private static final String SERVICE = "trpc.qmeta.square_focus_svr.SquareFocusSvr";
    private static final String TAG = "VasSquareFocusService";

    VasSquareFocusService() {
    }

    public final void applyCallGather(int appId, long uin, long focusId, long tableId, long deskmateTableId, final ResultCallback<b> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "applyCallGather request.");
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            callback.onResultFailure(-3, "applyCallGather network delegate is null");
            return;
        }
        a aVar = new a();
        aVar.f400611f = appId;
        aVar.f400606a = appId;
        aVar.f400607b = uin;
        aVar.f400608c = focusId;
        aVar.f400609d = tableId;
        aVar.f400610e = deskmateTableId;
        byte[] byteArray = MessageNano.toByteArray(aVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest(SERVICE, METHOD_APPLY_CALL_GATHER, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasSquareFocusService$applyCallGather$1
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
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareFocusService", "applyCallGather error: code=" + intValue + ", message=" + data.getErrMsg() + ", prompt=" + data.getPrompt(), null, 4, null);
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
                    b response = b.c(rspData);
                    SquareBaseKt.getSquareLog().i("VasSquareFocusService", "applyCallGather success: user=" + response);
                    ResultCallback resultCallback = ResultCallback.this;
                    Intrinsics.checkNotNullExpressionValue(response, "response");
                    resultCallback.onResultSuccess(response);
                } catch (InvalidProtocolBufferNanoException e16) {
                    SquareBaseKt.getSquareLog().e("VasSquareFocusService", "applyCallGather parse err.", e16);
                    ResultCallback.this.onResultFailure(-2, "applyCallGather parse error");
                }
            }
        });
    }

    public final void callGather(int appId, final ResultCallback<Unit> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "callGather request.");
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            callback.onResultFailure(-3, "callGather network delegate is null");
            return;
        }
        c cVar = new c();
        cVar.f400616b = appId;
        cVar.f400615a = cVar.f400615a;
        byte[] byteArray = MessageNano.toByteArray(cVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest(SERVICE, METHOD_CALL_GATHER, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasSquareFocusService$callGather$1
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
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareFocusService", "callGather error: code=" + intValue + ", message=" + data.getErrMsg() + ", prompt=" + data.getPrompt(), null, 4, null);
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
                ResultCallback.this.onResultSuccess(Unit.INSTANCE);
            }
        });
    }

    public final void watchUserRoom(int appId, long uin, final ResultCallback<k> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "watchUserRoom request.");
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            callback.onResultFailure(-3, "watchUserRoom network delegate is null");
            return;
        }
        j jVar = new j();
        jVar.f400622c = appId;
        jVar.f400620a = appId;
        jVar.f400621b = uin;
        byte[] byteArray = MessageNano.toByteArray(jVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest(SERVICE, METHOD_WATCH_USER_ROOM, byteArray, emptyMap, SquareRuntime.INSTANCE.getQMetaContextSource(), new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasSquareFocusService$watchUserRoom$1
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
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareFocusService", "watchUserRoom error: code=" + intValue + ", message=" + data.getErrMsg() + ", prompt=" + data.getPrompt(), null, 4, null);
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
                    k response = k.c(rspData);
                    SquareBaseKt.getSquareLog().i("VasSquareFocusService", "watchUserRoom success: user=" + response);
                    ResultCallback resultCallback = ResultCallback.this;
                    Intrinsics.checkNotNullExpressionValue(response, "response");
                    resultCallback.onResultSuccess(response);
                } catch (InvalidProtocolBufferNanoException e16) {
                    SquareBaseKt.getSquareLog().e("VasSquareFocusService", "watchUserRoom parse err.", e16);
                    ResultCallback.this.onResultFailure(-2, "watchUserRoom parse error");
                }
            }
        });
    }
}
