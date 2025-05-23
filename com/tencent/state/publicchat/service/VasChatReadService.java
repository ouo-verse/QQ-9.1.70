package com.tencent.state.publicchat.service;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest;
import com.tencent.state.SquareRuntime;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.publicchat.data.LatestMsgInfos;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.httpcore.message.TokenParser;
import xs4.a;
import xs4.b;
import xs4.c;
import xs4.d;
import xs4.f;
import zr4.e;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J8\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000e0\u0012J\u001c\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012J$\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/publicchat/service/VasChatReadService;", "", "()V", "METHOD_BATCH_GET_MSG_INFOS", "", "METHOD_GET_PUBLIC_CHAT_CONF_INFO", "METHOD_LIST_LATEST_MSG_INFOS", "SERVICE", "TAG", "batchGetMsgInfos", "", "appId", "", "msgIds", "", "", "roomId", "callback", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/publicchat/data/MsgInfo;", "getPublicChatConfInfo", "Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", "listLatestMsgInfos", "Lcom/tencent/state/publicchat/data/LatestMsgInfos;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasChatReadService {
    public static final VasChatReadService INSTANCE = new VasChatReadService();
    private static final String METHOD_BATCH_GET_MSG_INFOS = "BatchGetMsgInfos";
    private static final String METHOD_GET_PUBLIC_CHAT_CONF_INFO = "GetPublicChatConfInfo";
    private static final String METHOD_LIST_LATEST_MSG_INFOS = "ListLatestMsgInfos";
    private static final String SERVICE = "trpc.qmeta.public_chat_read_svr.ChatRead";
    private static final String TAG = "VasChatReadService";

    VasChatReadService() {
    }

    public final void batchGetMsgInfos(int appId, List<Long> msgIds, long roomId, final ResultCallback<List<MsgInfo>> callback) {
        long[] longArray;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(msgIds, "msgIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "batchGetMsgInfos request. " + appId + TokenParser.SP + msgIds + ", roomId:" + roomId);
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            callback.onResultFailure(-3, "batchGetMsgInfos network delegate is null");
            return;
        }
        a aVar = new a();
        aVar.f448472d = appId;
        aVar.f448469a = appId;
        longArray = CollectionsKt___CollectionsKt.toLongArray(msgIds);
        aVar.f448470b = longArray;
        aVar.f448471c = roomId;
        byte[] byteArray = MessageNano.toByteArray(aVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest(SERVICE, METHOD_BATCH_GET_MSG_INFOS, byteArray, emptyMap, SquareRuntime.INSTANCE.getQMetaContextSource(), new INetworkDelegateCallBack() { // from class: com.tencent.state.publicchat.service.VasChatReadService$batchGetMsgInfos$1
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
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasChatReadService", "listLatestMsgInfos error: code=" + intValue + ", message=" + data.getErrMsg() + ", prompt=" + data.getPrompt(), null, 4, null);
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
                Collection emptyList;
                e[] eVarArr;
                try {
                    b c16 = b.c(rspData);
                    if (c16 == null || (eVarArr = c16.f448473a) == null) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                    } else {
                        emptyList = new ArrayList(eVarArr.length);
                        for (e eVar : eVarArr) {
                            emptyList.add(new MsgInfo(eVar));
                        }
                    }
                    SquareBaseKt.getSquareLog().i("VasChatReadService", "batchGetMsgInfos success: msgs = " + emptyList);
                    ResultCallback.this.onResultSuccess(emptyList);
                } catch (InvalidProtocolBufferNanoException e16) {
                    SquareBaseKt.getSquareLog().e("VasChatReadService", "batchGetMsgInfos parse err.", e16);
                    ResultCallback.this.onResultFailure(-2, "batchGetMsgInfos parse error");
                }
            }
        });
    }

    public final void getPublicChatConfInfo(int appId, final ResultCallback<PublicChatConfInfo> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "getPublicChatConfInfo request. " + appId);
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            callback.onResultFailure(-3, "getPublicChatConfInfo network delegate is null");
            return;
        }
        c cVar = new c();
        cVar.f448475b = appId;
        cVar.f448474a = appId;
        byte[] byteArray = MessageNano.toByteArray(cVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest(SERVICE, METHOD_GET_PUBLIC_CHAT_CONF_INFO, byteArray, emptyMap, SquareRuntime.INSTANCE.getQMetaContextSource(), new INetworkDelegateCallBack() { // from class: com.tencent.state.publicchat.service.VasChatReadService$getPublicChatConfInfo$1
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
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasChatReadService", "getPublicChatConfInfo error: code=" + intValue + ", message=" + data.getErrMsg() + ", prompt=" + data.getPrompt(), null, 4, null);
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
                    PublicChatConfInfo publicChatConfInfo = new PublicChatConfInfo(d.c(rspData));
                    SquareBaseKt.getSquareLog().i("VasChatReadService", "getPublicChatConfInfo success: info = " + publicChatConfInfo);
                    ResultCallback.this.onResultSuccess(publicChatConfInfo);
                } catch (InvalidProtocolBufferNanoException e16) {
                    SquareBaseKt.getSquareLog().e("VasChatReadService", "getPublicChatConfInfo parse err.", e16);
                    ResultCallback.this.onResultFailure(-2, "getPublicChatConfInfo parse error");
                }
            }
        });
    }

    public final void listLatestMsgInfos(int appId, long roomId, final ResultCallback<LatestMsgInfos> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "listLatestMsgInfos request. " + appId + ", roomId:" + roomId);
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            callback.onResultFailure(-3, "listLatestMsgInfos network delegate is null");
            return;
        }
        xs4.e eVar = new xs4.e();
        eVar.f448485c = appId;
        eVar.f448483a = appId;
        eVar.f448484b = roomId;
        byte[] byteArray = MessageNano.toByteArray(eVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest(SERVICE, METHOD_LIST_LATEST_MSG_INFOS, byteArray, emptyMap, SquareRuntime.INSTANCE.getQMetaContextSource(), new INetworkDelegateCallBack() { // from class: com.tencent.state.publicchat.service.VasChatReadService$listLatestMsgInfos$1
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
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasChatReadService", "listLatestMsgInfos error: code=" + intValue + ", message=" + data.getErrMsg() + ", prompt=" + data.getPrompt(), null, 4, null);
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
                    LatestMsgInfos latestMsgInfos = new LatestMsgInfos(f.c(rspData));
                    SquareBaseKt.getSquareLog().i("VasChatReadService", "listLatestMsgInfos success: info = " + latestMsgInfos);
                    ResultCallback.this.onResultSuccess(latestMsgInfos);
                } catch (InvalidProtocolBufferNanoException e16) {
                    SquareBaseKt.getSquareLog().e("VasChatReadService", "listLatestMsgInfos parse err.", e16);
                    ResultCallback.this.onResultFailure(-2, "listLatestMsgInfos parse error");
                }
            }
        });
    }
}
