package com.tencent.state.template.service;

import bt4.a;
import bt4.b;
import bt4.c;
import bt4.d;
import bt4.e;
import bt4.f;
import bt4.g;
import bt4.h;
import bt4.i;
import bt4.j;
import bt4.k;
import bt4.l;
import com.google.protobuf.nano.MessageNano;
import com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest;
import com.tencent.state.SquareRuntime;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.template.data.ActionType;
import com.tencent.state.template.data.InterResourceInfo;
import com.tencent.state.template.data.InteractionMotionDataParserKt;
import com.tencent.state.template.data.InteractionMotionInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fJ\u001c\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fJ\"\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\fJ\u001c\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00140\fJ,\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fJ$\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u001d0\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/template/service/VasSquareRoomInteractionService;", "", "appId", "", "(I)V", "service", "Lcom/tencent/state/template/service/IVasSquareRoomInteractionService;", "cancelInvite", "", "billNo", "", "callback", "Lcom/tencent/state/service/ResultCallback;", "endInteraction", "getMotionList", "actionType", "Lcom/tencent/state/template/data/ActionType;", "", "Lcom/tencent/state/template/data/InteractionMotionInfo;", "refreshUserInfo", "Lcom/tencent/state/template/data/InterResourceInfo;", "replyInvite", "accept", "", "needShield", "sendInvite", "uin", "", "motionId", "Lcom/tencent/state/template/service/InviteRsp;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSquareRoomInteractionService {
    private static final String ERROR_MSG_TIMEOUT = "\u670d\u52a1\u5668\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
    public static final String TAG = "VasSquareRoomInteractionService";
    private final int appId;
    private final IVasSquareRoomInteractionService service = (IVasSquareRoomInteractionService) Square.INSTANCE.getConfig().getRapier().b(IVasSquareRoomInteractionService.class);

    public VasSquareRoomInteractionService(int i3) {
        this.appId = i3;
    }

    public final void cancelInvite(String billNo, final ResultCallback<Unit> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "cancelInvite request. " + billNo);
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            callback.onResultFailure(-3, "cancelInvite network delegate is null");
            return;
        }
        a aVar = new a();
        aVar.f29106a = this.appId;
        aVar.f29107b = billNo;
        byte[] byteArray = MessageNano.toByteArray(aVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest("trpc.qmeta.room_interaction_svr.RoomInteractionSvr", "CancelInvite", byteArray, emptyMap, SquareRuntime.INSTANCE.getQMetaContextSource(), new INetworkDelegateCallBack() { // from class: com.tencent.state.template.service.VasSquareRoomInteractionService$cancelInvite$1
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
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomInteractionService.TAG, "cancelInvite failed: errorCode=" + intValue + ", errorMsg=" + data.getErrMsg() + " prompt=" + data.getPrompt(), null, 4, null);
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

    public final void endInteraction(String billNo, final ResultCallback<String> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "endInteraction request. " + billNo);
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            callback.onResultFailure(-3, "endInteraction network delegate is null");
            return;
        }
        b bVar = new b();
        bVar.f29108a = this.appId;
        bVar.f29109b = billNo;
        byte[] byteArray = MessageNano.toByteArray(bVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest("trpc.qmeta.room_interaction_svr.RoomInteractionSvr", "EndInteraction", byteArray, emptyMap, SquareRuntime.INSTANCE.getQMetaContextSource(), new INetworkDelegateCallBack() { // from class: com.tencent.state.template.service.VasSquareRoomInteractionService$endInteraction$1
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
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomInteractionService.TAG, "endInteraction failed: errorCode=" + intValue + ", errorMsg=" + data.getErrMsg() + " prompt=" + data.getPrompt(), null, 4, null);
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
                String str;
                try {
                    c c16 = c.c(rspData);
                    SquareBaseKt.getSquareLog().i(VasSquareRoomInteractionService.TAG, "endInteraction success: " + c16);
                    ResultCallback resultCallback = ResultCallback.this;
                    if (c16 == null || (str = c16.f29111a) == null) {
                        str = "";
                    }
                    resultCallback.onResultSuccess(str);
                } catch (Throwable th5) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomInteractionService.TAG, "endInteraction parse response failed: " + th5.getMessage(), null, 4, null);
                    ResultCallback.this.onResultFailure(-2, "endInteraction parse response failed");
                }
            }
        });
    }

    public final void getMotionList(ActionType actionType, final ResultCallback<List<InteractionMotionInfo>> callback) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "getMotionList request. " + actionType);
        d dVar = new d();
        dVar.f29112a = this.appId;
        dVar.f29113b = InteractionMotionDataParserKt.toInt(actionType);
        this.service.getMotionList(dVar, SquareRuntime.INSTANCE.getQMetaContextSource()).a(new com.tencent.rapier.b<e>() { // from class: com.tencent.state.template.service.VasSquareRoomInteractionService$getMotionList$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomInteractionService.TAG, "getMotionList failed: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                ResultCallback.this.onResultFailure(errorCode, "\u670d\u52a1\u5668\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(e response) {
                List list;
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    f[] fVarArr = response.f29114a;
                    if (fVarArr != null) {
                        list = new ArrayList(fVarArr.length);
                        for (f fVar : fVarArr) {
                            list.add(InteractionMotionDataParserKt.parsePB(InteractionMotionInfo.INSTANCE, fVar));
                        }
                    } else {
                        list = null;
                    }
                    SquareBaseKt.getSquareLog().i(VasSquareRoomInteractionService.TAG, "getMotionList success: " + list);
                    ResultCallback resultCallback = ResultCallback.this;
                    if (list == null) {
                        list = CollectionsKt__CollectionsKt.emptyList();
                    }
                    resultCallback.onResultSuccess(list);
                } catch (Throwable th5) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomInteractionService.TAG, "getMotionList parse response failed: " + th5.getMessage(), null, 4, null);
                    ResultCallback.this.onResultFailure(-2, "\u670d\u52a1\u5668\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                }
            }
        });
    }

    public final void refreshUserInfo(String billNo, final ResultCallback<InterResourceInfo> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "refreshUserInfo request. " + billNo);
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            callback.onResultFailure(-3, "refreshUserInfo network delegate is null");
            return;
        }
        g gVar = new g();
        gVar.f29122a = this.appId;
        gVar.f29123b = billNo;
        byte[] byteArray = MessageNano.toByteArray(gVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest("trpc.qmeta.room_interaction_svr.RoomInteractionSvr", "RefreshUserInfo", byteArray, emptyMap, SquareRuntime.INSTANCE.getQMetaContextSource(), new INetworkDelegateCallBack() { // from class: com.tencent.state.template.service.VasSquareRoomInteractionService$refreshUserInfo$1
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
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomInteractionService.TAG, "refreshUserInfo failed: errorCode=" + intValue + ", errorMsg=" + data.getErrMsg() + " prompt=" + data.getPrompt(), null, 4, null);
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
                    h c16 = h.c(rspData);
                    InterResourceInfo parsePB = InteractionMotionDataParserKt.parsePB(InterResourceInfo.INSTANCE, c16 != null ? c16.f29124a : null);
                    SquareBaseKt.getSquareLog().i(VasSquareRoomInteractionService.TAG, "refreshUserInfo success: " + parsePB);
                    ResultCallback.this.onResultSuccess(parsePB);
                } catch (Throwable th5) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomInteractionService.TAG, "refreshUserInfo parse response failed: " + th5.getMessage(), null, 4, null);
                    ResultCallback.this.onResultFailure(-2, "refreshUserInfo parse response failed");
                }
            }
        });
    }

    public final void replyInvite(String billNo, boolean accept, boolean needShield, final ResultCallback<String> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "replyInvite request. " + billNo + TokenParser.SP + accept + TokenParser.SP + needShield);
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            callback.onResultFailure(-3, "replyInvite network delegate is null");
            return;
        }
        i iVar = new i();
        iVar.f29125a = this.appId;
        iVar.f29126b = billNo;
        iVar.f29128d = needShield;
        iVar.f29127c = accept ? 2 : 1;
        byte[] byteArray = MessageNano.toByteArray(iVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest("trpc.qmeta.room_interaction_svr.RoomInteractionSvr", "ReplyInvite", byteArray, emptyMap, SquareRuntime.INSTANCE.getQMetaContextSource(), new INetworkDelegateCallBack() { // from class: com.tencent.state.template.service.VasSquareRoomInteractionService$replyInvite$1
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
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomInteractionService.TAG, "replyInvite failed: errorCode=" + intValue + ", errorMsg=" + data.getErrMsg() + " prompt=" + data.getPrompt(), null, 4, null);
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
                    j c16 = j.c(rspData);
                    SquareBaseKt.getSquareLog().i(VasSquareRoomInteractionService.TAG, "replyInvite success: " + c16);
                    ResultCallback resultCallback = ResultCallback.this;
                    String str = c16.f29129a;
                    Intrinsics.checkNotNullExpressionValue(str, "rsp.tips");
                    resultCallback.onResultSuccess(str);
                } catch (Throwable th5) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomInteractionService.TAG, "replyInvite parse response failed: " + th5.getMessage(), null, 4, null);
                    ResultCallback.this.onResultFailure(-2, "replyInvite parse response failed");
                }
            }
        });
    }

    public final void sendInvite(long uin, int motionId, final ResultCallback<InviteRsp> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "sendInvite request. " + uin + TokenParser.SP + motionId + TokenParser.SP + this.appId);
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            callback.onResultFailure(-3, "sendInvite network delegate is null");
            return;
        }
        k kVar = new k();
        kVar.f29130a = this.appId;
        kVar.f29131b = uin;
        kVar.f29132c = motionId;
        byte[] byteArray = MessageNano.toByteArray(kVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest("trpc.qmeta.room_interaction_svr.RoomInteractionSvr", "SendInvite", byteArray, emptyMap, SquareRuntime.INSTANCE.getQMetaContextSource(), new INetworkDelegateCallBack() { // from class: com.tencent.state.template.service.VasSquareRoomInteractionService$sendInvite$1
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
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomInteractionService.TAG, "sendInvite failed: errorCode=" + intValue + ", errorMsg=" + data.getErrMsg() + " prompt=" + data.getPrompt(), null, 4, null);
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
                    InviteRsp parsePB = InviteRsp.INSTANCE.parsePB(l.c(rspData));
                    SquareBaseKt.getSquareLog().i(VasSquareRoomInteractionService.TAG, "sendInvite success: " + parsePB);
                    ResultCallback.this.onResultSuccess(parsePB);
                } catch (Throwable th5) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomInteractionService.TAG, "sendInvite parse response failed: " + th5.getMessage(), null, 4, null);
                    ResultCallback.this.onResultFailure(-2, "sendInvite parse response failed");
                }
            }
        });
    }
}
