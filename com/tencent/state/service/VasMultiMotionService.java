package com.tencent.state.service;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareMultiMotionDetailData;
import com.tencent.state.square.record.RecordIdentifier;
import hs4.r;
import hs4.t;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import vs4.a;
import vs4.b;
import vs4.c;
import vs4.d;
import vs4.e;
import vs4.f;
import vs4.g;
import vs4.h;
import vs4.i;
import vs4.j;
import vs4.k;
import vs4.l;
import vs4.m;
import vs4.n;
import vs4.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)JE\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bJ\u001c\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bJ3\u0010\u0016\u001a\u00020\r2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b\u00a2\u0006\u0004\b\u0016\u0010\u0017J(\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u000bJ\u0018\u0010\u001b\u001a\u00020\r2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000bJ(\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000bR\u0014\u0010\u001e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010\"\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001fR\u0014\u0010#\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\u0014\u0010$\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010\u001fR\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006*"}, d2 = {"Lcom/tencent/state/service/VasMultiMotionService;", "", "", "uin", "", "motionId", "singleMotionId", "Lcom/tencent/state/square/data/OnlineStatus;", "status", "", "customText", "Lcom/tencent/state/service/ResultCallback;", "callback", "", "sendInviteArk", "(JILjava/lang/Integer;Lcom/tencent/state/square/data/OnlineStatus;Ljava/lang/String;Lcom/tencent/state/service/ResultCallback;)V", "billNo", "", "acceptInvite", "Lvs4/j;", "getInviteStatus", "Lcom/tencent/state/square/data/SquareMultiMotionDetailData;", "getInviteDetail", "(Ljava/lang/Long;Ljava/lang/String;Lcom/tencent/state/service/ResultCallback;)V", "endType", "Lcom/tencent/state/square/data/Resource;", "endInvite", "resetUserInvite", "Lcom/tencent/state/service/InviteGender;", "checkInvitePermission", "TAG", "Ljava/lang/String;", "CMD_SERVICE", "METHOD_SEND_INVITE", "METHOD_END_INVITE", "METHOD_ACCEPT_INVITE", "METHOD_CHECK_PERMISSION", "Lcom/tencent/state/service/IVasMultiMotionInviteService;", "service", "Lcom/tencent/state/service/IVasMultiMotionInviteService;", "<init>", "()V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasMultiMotionService {
    private static final String CMD_SERVICE = "trpc.qmeta.multi_motion_invite_svr.MultiMotionInviteSvr";
    private static final String METHOD_ACCEPT_INVITE = "AcceptInvite";
    private static final String METHOD_CHECK_PERMISSION = "CheckInvitePermission";
    private static final String METHOD_END_INVITE = "EndInvite";
    private static final String METHOD_SEND_INVITE = "SendInvite";
    private static final String TAG = "VasMultiMotionService";
    public static final VasMultiMotionService INSTANCE = new VasMultiMotionService();
    private static final IVasMultiMotionInviteService service = (IVasMultiMotionInviteService) Square.INSTANCE.getConfig().getRapier().b(IVasMultiMotionInviteService.class);

    VasMultiMotionService() {
    }

    public final void acceptInvite(String billNo, String customText, final ResultCallback<Boolean> callback) {
        boolean isBlank;
        byte[] encodeToByteArray;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(customText, "customText");
        Intrinsics.checkNotNullParameter(callback, "callback");
        isBlank = StringsKt__StringsJVMKt.isBlank(billNo);
        if (isBlank) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "acceptInvite wrong args " + billNo, null, 4, null);
            callback.onResultFailure(-1, "acceptInvite wrong args " + billNo);
            return;
        }
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            callback.onResultFailure(-3, "acceptInvite network delegate is null");
            return;
        }
        a aVar = new a();
        aVar.f443296a = billNo;
        encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(customText);
        aVar.f443297b = encodeToByteArray;
        byte[] byteArray = MessageNano.toByteArray(aVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_ACCEPT_INVITE, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasMultiMotionService$acceptInvite$1
            @Override // com.tencent.state.api.INetworkDelegateCallBack
            public void onError(SquareErrorData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                Integer errCode = data.getErrCode();
                ResultCallback.this.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg(), data.getPrompt());
            }

            @Override // com.tencent.state.api.INetworkDelegateCallBack
            public void onReceive(byte[] rspData) {
                ResultCallback.this.onResultSuccess(Boolean.TRUE);
            }
        });
    }

    public final void checkInvitePermission(final long uin, final int motionId, final ResultCallback<InviteGender> callback) {
        Map<String, String> emptyMap;
        SquareBaseKt.getSquareLog().i(TAG, "checkInvitePermission start: uin=" + uin + ", motionId=" + motionId);
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            if (callback != null) {
                callback.onResultFailure(-3, "checkInvitePermission network delegate is null");
                return;
            }
            return;
        }
        b bVar = new b();
        bVar.f443298a = uin;
        bVar.f443299b = motionId;
        byte[] byteArray = MessageNano.toByteArray(bVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_CHECK_PERMISSION, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasMultiMotionService$checkInvitePermission$1
            @Override // com.tencent.state.api.INetworkDelegateCallBack
            public void onError(SquareErrorData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasMultiMotionService", "checkInvitePermission error " + data.getErrCode() + ", " + data.getErrMsg() + ", uin=" + uin + ", motionId=" + motionId, null, 4, null);
                Integer errCode = data.getErrCode();
                int intValue = errCode != null ? errCode.intValue() : -1;
                ResultCallback resultCallback = callback;
                if (resultCallback != null) {
                    resultCallback.onResultFailure(intValue, data.getErrMsg(), data.getPrompt());
                }
            }

            @Override // com.tencent.state.api.INetworkDelegateCallBack
            public void onReceive(byte[] rspData) {
                SquareBaseKt.getSquareLog().i("VasMultiMotionService", "checkInvitePermission success: uin=" + uin + ", motionId=" + motionId);
                try {
                    c c16 = c.c(rspData);
                    SquareBaseKt.getSquareLog().i("VasMultiMotionService", "checkInvitePermission success: uin=" + uin + ", motionId=" + motionId + ", sender:" + c16.f443300a.f443305a + ", reciever:" + c16.f443300a.f443306b);
                    ResultCallback resultCallback = callback;
                    if (resultCallback != null) {
                        f fVar = c16.f443300a;
                        resultCallback.onResultSuccess(new InviteGender(fVar.f443305a, fVar.f443306b));
                    }
                } catch (InvalidProtocolBufferNanoException e16) {
                    SquareBaseKt.getSquareLog().e("VasMultiMotionService", "checkInvitePermission parse err: uin=" + uin + ", motionId=" + motionId, e16);
                    ResultCallback resultCallback2 = callback;
                    if (resultCallback2 != null) {
                        resultCallback2.onResultFailure(-2, "checkInvitePermission parse error");
                    }
                }
            }
        });
    }

    public final void endInvite(String billNo, int endType, final ResultCallback<Resource> callback) {
        boolean isBlank;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        isBlank = StringsKt__StringsJVMKt.isBlank(billNo);
        if (isBlank) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "endInvite wrong args " + billNo, null, 4, null);
            callback.onResultFailure(-1, "endInvite wrong args " + billNo);
        }
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            callback.onResultFailure(-3, "endInvite network delegate is null");
            return;
        }
        d dVar = new d();
        dVar.f443301a = billNo;
        dVar.f443302b = endType;
        byte[] byteArray = MessageNano.toByteArray(dVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_END_INVITE, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasMultiMotionService$endInvite$1
            @Override // com.tencent.state.api.INetworkDelegateCallBack
            public void onError(SquareErrorData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                Integer errCode = data.getErrCode();
                ResultCallback.this.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg(), data.getPrompt());
            }

            @Override // com.tencent.state.api.INetworkDelegateCallBack
            public void onReceive(byte[] rspData) {
                try {
                    e c16 = e.c(rspData);
                    r rVar = c16.f443303a;
                    ResultCallback.this.onResultSuccess(rVar != null ? UserFormatKt.formatActionResource$default(rVar, false, c16.f443304b, 2, null) : null);
                } catch (InvalidProtocolBufferNanoException e16) {
                    SquareBaseKt.getSquareLog().e("VasMultiMotionService", "endInvite parse err.", e16);
                    ResultCallback.this.onResultFailure(-2, "endInvite parse error");
                }
            }
        });
    }

    public final void getInviteDetail(final Long uin, String billNo, final ResultCallback<SquareMultiMotionDetailData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        final g gVar = new g();
        Long longOrNull = uin != null ? uin : StringsKt__StringNumberConversionsKt.toLongOrNull(SquareBaseKt.getSquareCommon().getCurrentAccountUin());
        gVar.f443308b = longOrNull != null ? longOrNull.longValue() : 0L;
        if (billNo != null) {
            gVar.f443307a = billNo;
        }
        com.tencent.rapier.a<h> inviteDetail = service.getInviteDetail(gVar);
        SquareBaseKt.getSquareLog().i(TAG, "start getInviteDetail: uin=" + gVar.f443308b + ", billNo=" + gVar.f443307a);
        inviteDetail.a(new com.tencent.rapier.b<h>() { // from class: com.tencent.state.service.VasMultiMotionService$getInviteDetail$2
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasMultiMotionService", "getInviteDetail wrong " + errorCode + ", " + errorMessage, null, 4, null);
                ResultCallback.this.onResultFailure(errorCode, errorMessage);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(h response) {
                String selfUin;
                o oVar;
                t tVar;
                Intrinsics.checkNotNullParameter(response, "response");
                Long l3 = uin;
                if (l3 == null || (selfUin = String.valueOf(l3.longValue())) == null) {
                    selfUin = RecordIdentifier.INSTANCE.getSelfUin();
                }
                o oVar2 = response.f443310b;
                Integer valueOf = (!Intrinsics.areEqual(selfUin, oVar2 != null ? String.valueOf(oVar2.f443328a) : null) ? (oVar = response.f443311c) != null : (oVar = response.f443310b) != null) ? null : Integer.valueOf(oVar.f443330c);
                String str = response.f443309a;
                Intrinsics.checkNotNullExpressionValue(str, "response.billNo");
                SquareMultiMotionDetailData squareMultiMotionDetailData = new SquareMultiMotionDetailData(str);
                o oVar3 = response.f443310b;
                if (oVar3 != null) {
                    squareMultiMotionDetailData.setSender(oVar3);
                }
                o oVar4 = response.f443311c;
                if (oVar4 != null) {
                    squareMultiMotionDetailData.setReceiver(oVar4);
                }
                squareMultiMotionDetailData.setInviteStatus(valueOf != null ? valueOf.intValue() : 0);
                r rVar = response.f443312d;
                if (rVar != null) {
                    squareMultiMotionDetailData.setStatusResource(UserFormatKt.formatActionResource$default(rVar, false, response.f443317i, 2, null));
                }
                String str2 = response.f443313e;
                if (str2 == null) {
                    str2 = "";
                }
                squareMultiMotionDetailData.setCountDown(str2);
                String str3 = response.f443314f;
                Intrinsics.checkNotNullExpressionValue(str3, "response.backgroundUrl");
                squareMultiMotionDetailData.setBackgroundUrl(str3);
                String str4 = response.f443315g;
                Intrinsics.checkNotNullExpressionValue(str4, "response.previewUrl");
                squareMultiMotionDetailData.setPreviewUrl(str4);
                squareMultiMotionDetailData.setSingleMotionId(response.f443316h);
                o user = squareMultiMotionDetailData.getUser(String.valueOf(gVar.f443308b));
                if (user != null && (tVar = user.f443331d) != null) {
                    squareMultiMotionDetailData.setStatusInfo(UserFormatKt.formatOnlineStatus(tVar));
                }
                SquareBaseKt.getSquareLog().i("VasMultiMotionService", "getInviteDetail success: " + squareMultiMotionDetailData);
                ResultCallback.this.onResultSuccess(squareMultiMotionDetailData);
            }
        });
    }

    public final void getInviteStatus(String billNo, final ResultCallback<j> callback) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        isBlank = StringsKt__StringsJVMKt.isBlank(billNo);
        if (isBlank) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "getInviteStatus wrong args " + billNo, null, 4, null);
            callback.onResultFailure(-1, "getInviteStatus wrong args " + billNo);
        }
        IVasMultiMotionInviteService iVasMultiMotionInviteService = service;
        i iVar = new i();
        iVar.f443318a = billNo;
        Unit unit = Unit.INSTANCE;
        iVasMultiMotionInviteService.getInviteStatus(iVar).a(new com.tencent.rapier.b<j>() { // from class: com.tencent.state.service.VasMultiMotionService$getInviteStatus$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasMultiMotionService", "getInviteStatus wrong " + errorCode + ", " + errorMessage, null, 4, null);
                ResultCallback.this.onResultFailure(errorCode, errorMessage);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(j response) {
                Intrinsics.checkNotNullParameter(response, "response");
                ResultCallback.this.onResultSuccess(response);
            }
        });
    }

    public final void resetUserInvite(final ResultCallback<Boolean> callback) {
        SquareBaseKt.getSquareLog().i(TAG, "resetUserInvite start.");
        service.resetUserInvite(new k()).a(new com.tencent.rapier.b<l>() { // from class: com.tencent.state.service.VasMultiMotionService$resetUserInvite$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasMultiMotionService", "resetUserInvite error " + errorCode + ", " + errorMessage, null, 4, null);
                ResultCallback resultCallback = ResultCallback.this;
                if (resultCallback != null) {
                    resultCallback.onResultFailure(errorCode, errorMessage);
                }
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(l response) {
                Intrinsics.checkNotNullParameter(response, "response");
                SquareBaseKt.getSquareLog().i("VasMultiMotionService", "resetUserInvite success.");
                ResultCallback resultCallback = ResultCallback.this;
                if (resultCallback != null) {
                    resultCallback.onResultSuccess(Boolean.TRUE);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void checkInvitePermission$default(VasMultiMotionService vasMultiMotionService, long j3, int i3, ResultCallback resultCallback, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            resultCallback = null;
        }
        vasMultiMotionService.checkInvitePermission(j3, i3, resultCallback);
    }

    public static /* synthetic */ void endInvite$default(VasMultiMotionService vasMultiMotionService, String str, int i3, ResultCallback resultCallback, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        vasMultiMotionService.endInvite(str, i3, resultCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void resetUserInvite$default(VasMultiMotionService vasMultiMotionService, ResultCallback resultCallback, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            resultCallback = null;
        }
        vasMultiMotionService.resetUserInvite(resultCallback);
    }

    public final void sendInviteArk(long uin, int motionId, Integer singleMotionId, OnlineStatus status, String customText, final ResultCallback<String> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(customText, "customText");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (uin == 0 || motionId == 0) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "sendInviteArk wrong args " + uin + ", " + motionId, null, 4, null);
            callback.onResultFailure(-1, "sendInviteArk wrong args " + uin + ", " + motionId);
        }
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            callback.onResultFailure(-3, "sendInviteArk network delegate is null");
            return;
        }
        m mVar = new m();
        mVar.f443321a = uin;
        mVar.f443322b = motionId;
        mVar.f443326f = singleMotionId != null ? singleMotionId.intValue() : 0;
        mVar.f443323c = status.getTopStatusId();
        mVar.f443324d = status.getRichStatus();
        byte[] bytes = customText.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        mVar.f443325e = bytes;
        byte[] byteArray = MessageNano.toByteArray(mVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest(CMD_SERVICE, "SendInvite", byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasMultiMotionService$sendInviteArk$1
            @Override // com.tencent.state.api.INetworkDelegateCallBack
            public void onError(SquareErrorData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                Integer errCode = data.getErrCode();
                ResultCallback.this.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg(), data.getPrompt());
            }

            @Override // com.tencent.state.api.INetworkDelegateCallBack
            public void onReceive(byte[] rspData) {
                boolean isBlank;
                try {
                    n c16 = n.c(rspData);
                    String str = c16.f443327a;
                    Intrinsics.checkNotNullExpressionValue(str, "response.billNo");
                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                    if (isBlank) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasMultiMotionService", "sendInviteArk wrong billNo: " + c16.f443327a, null, 4, null);
                        ResultCallback.this.onResultFailure(-1, "sendInviteArk wrong billNo: " + c16.f443327a);
                        return;
                    }
                    ResultCallback resultCallback = ResultCallback.this;
                    String str2 = c16.f443327a;
                    Intrinsics.checkNotNullExpressionValue(str2, "response.billNo");
                    resultCallback.onResultSuccess(str2);
                } catch (InvalidProtocolBufferNanoException e16) {
                    SquareBaseKt.getSquareLog().e("VasMultiMotionService", "sendInviteArk parse err.", e16);
                    ResultCallback.this.onResultFailure(-2, "sendInviteArk parse error");
                }
            }
        });
    }

    public static /* synthetic */ void getInviteDetail$default(VasMultiMotionService vasMultiMotionService, Long l3, String str, ResultCallback resultCallback, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            l3 = null;
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        vasMultiMotionService.getInviteDetail(l3, str, resultCallback);
    }
}
