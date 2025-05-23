package com.tencent.state.service;

import android.graphics.Point;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest;
import com.tencent.rapier.b;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.library.data.LibraryDataParserKt;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.RemainTimeInfo;
import com.tencent.state.template.data.SitDownTagParams;
import com.tencent.state.template.data.User;
import com.tencent.state.template.service.ITemplateRoomService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import rs4.a;
import rs4.c;
import rs4.d;
import rs4.e;
import rs4.f;
import rs4.g;
import rs4.h;
import rs4.i;
import rs4.j;
import rs4.k;
import rs4.l;
import rs4.m;
import rs4.n;
import rs4.o;
import rs4.p;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J/\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012H\u0016\u00a2\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0012H\u0016J\u0018\u0010\u001c\u001a\u00020\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J$\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f0\u001fH\u0016J+\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00132\b\b\u0002\u0010\"\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002\u00a2\u0006\u0002\u0010#J \u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&2\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0\u0012H\u0016J&\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u00062\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001fH\u0016J\u0016\u0010*\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012H\u0016J8\u0010+\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u00162\b\u0010-\u001a\u0004\u0018\u00010.2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020'0\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/tencent/state/service/VasLibraryRoomService;", "Lcom/tencent/state/template/service/ITemplateRoomService;", "()V", "ERROR_FOCUS_FAIL_DUE_TO_ROOM_FULL", "", "METHOD_DO_FOCUS", "", "METHOD_REFRESH_USERINFO", "SERVICE", "TAG", "reporter", "Lcom/tencent/state/square/IReporter;", "service", "Lcom/tencent/state/service/IVasLibraryRoomService;", "editTag", "", "tagId", "callback", "Lcom/tencent/state/service/ResultCallback;", "", "enterRoom", "roomId", "", "uin", "Lcom/tencent/state/template/data/EnterRoomInfo;", "(Ljava/lang/Long;Ljava/lang/Long;Lcom/tencent/state/service/ResultCallback;)V", "getRemainLifeTime", "Lcom/tencent/state/template/data/RemainTimeInfo;", "leaveRoom", "refreshUserInfo", "motionId", "Lkotlin/Function1;", "reportEnterRoomEvent", "result", "errorCode", "(ZILjava/lang/Long;)V", "sitDown", "params", "Lcom/tencent/state/template/data/SitDownTagParams;", "Lcom/tencent/state/template/data/User;", "standUp", "from", "switchRoom", "switchTable", "tableId", "sitLocation", "Landroid/graphics/Point;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasLibraryRoomService implements ITemplateRoomService {
    public static final int ERROR_FOCUS_FAIL_DUE_TO_ROOM_FULL = -24022;
    private static final String METHOD_DO_FOCUS = "Focus";
    private static final String METHOD_REFRESH_USERINFO = "RefreshUserInfo";
    private static final String SERVICE = "trpc.qmeta.library_room_svr.LibraryRoom";
    private static final String TAG = "VasLibraryRoomService";
    public static final VasLibraryRoomService INSTANCE = new VasLibraryRoomService();
    private static final IVasLibraryRoomService service = (IVasLibraryRoomService) Square.INSTANCE.getConfig().getRapier().b(IVasLibraryRoomService.class);
    private static IReporter reporter = SquareBase.INSTANCE.getConfig().getReporter();

    VasLibraryRoomService() {
    }

    @Override // com.tencent.state.template.service.ITemplateRoomService
    public void choose(long j3, int i3, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ITemplateRoomService.DefaultImpls.choose(this, j3, i3, callback);
    }

    @Override // com.tencent.state.template.service.ITemplateRoomService
    public void editTag(final String tagId, final ResultCallback<Boolean> callback) {
        Intrinsics.checkNotNullParameter(tagId, "tagId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "[editTag], tId:" + tagId);
        IVasLibraryRoomService iVasLibraryRoomService = service;
        c cVar = new c();
        cVar.f432162a = tagId;
        Unit unit = Unit.INSTANCE;
        iVasLibraryRoomService.editTag(cVar).a(new b<d>() { // from class: com.tencent.state.service.VasLibraryRoomService$editTag$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareBaseKt.getSquareLog().i("VasLibraryRoomService", "[editTag], tId:" + tagId + ", failed, " + errorCode + ", " + errorMessage);
                callback.onResultFailure(errorCode, errorMessage);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(d response) {
                Intrinsics.checkNotNullParameter(response, "response");
                SquareBaseKt.getSquareLog().i("VasLibraryRoomService", "[editTag], tId:" + tagId + ", success");
                callback.onResultSuccess(Boolean.TRUE);
            }
        });
    }

    @Override // com.tencent.state.template.service.ITemplateRoomService
    public void enterRoom(final Long roomId, Long uin, final ResultCallback<EnterRoomInfo> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "enter room request.");
        e eVar = new e();
        if (roomId != null) {
            eVar.f432163a = roomId.longValue();
        }
        if (uin != null) {
            eVar.f432164b = uin.longValue();
        }
        service.enterRoom(eVar).a(new b<f>() { // from class: com.tencent.state.service.VasLibraryRoomService$enterRoom$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasLibraryRoomService", "enter room failed: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                ResultCallback.this.onResultFailure(errorCode, errorMessage);
                VasLibraryRoomService.INSTANCE.reportEnterRoomEvent(false, errorCode, roomId);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(f response) {
                EnterRoomInfo enterRoomInfo;
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    enterRoomInfo = LibraryDataParserKt.parse(response);
                } catch (Throwable th5) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasLibraryRoomService", "enter room parse response failed: " + th5.getMessage(), null, 4, null);
                    ResultCallback.this.onResultFailure(-2, "enterRoom parse failed.");
                    enterRoomInfo = null;
                }
                SquareBaseKt.getSquareLog().i("VasLibraryRoomService", "enter room success: info = " + enterRoomInfo);
                if (enterRoomInfo != null) {
                    ResultCallback.this.onResultSuccess(enterRoomInfo);
                }
                VasLibraryRoomService.reportEnterRoomEvent$default(VasLibraryRoomService.INSTANCE, true, 0, roomId, 2, null);
            }
        });
    }

    @Override // com.tencent.state.template.service.ITemplateRoomService
    public void getRemainLifeTime(final ResultCallback<RemainTimeInfo> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "getRemainLifeTime");
        service.getRemainLifeTime(new i()).a(new b<j>() { // from class: com.tencent.state.service.VasLibraryRoomService$getRemainLifeTime$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasLibraryRoomService", "getRemainLifeTime: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                ResultCallback.this.onResultFailure(errorCode, errorMessage);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(j response) {
                Intrinsics.checkNotNullParameter(response, "response");
                ResultCallback.this.onResultSuccess(new RemainTimeInfo(response.f432174a, response.f432175b, response.f432176c));
            }
        });
    }

    @Override // com.tencent.state.template.service.ITemplateRoomService
    public void leaveRoom(final ResultCallback<Boolean> callback) {
        SquareBaseKt.getSquareLog().i(TAG, "leaveRoom request.");
        service.leaveRoom(new k()).a(new b<l>() { // from class: com.tencent.state.service.VasLibraryRoomService$leaveRoom$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasLibraryRoomService", "leaveRoom failed: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                ResultCallback resultCallback = ResultCallback.this;
                if (resultCallback != null) {
                    resultCallback.onResultFailure(errorCode, errorMessage);
                }
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(l response) {
                Intrinsics.checkNotNullParameter(response, "response");
                SquareBaseKt.getSquareLog().i("VasLibraryRoomService", "leaveRoom success");
                ResultCallback resultCallback = ResultCallback.this;
                if (resultCallback != null) {
                    resultCallback.onResultSuccess(Boolean.TRUE);
                }
            }
        });
    }

    @Override // com.tencent.state.template.service.ITemplateRoomService
    public void refreshUserInfo(int motionId, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.state.template.service.ITemplateRoomService
    public void sitDown(SitDownTagParams params, final ResultCallback<User> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "doFocus: " + params);
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            callback.onResultFailure(-3, "doFocus network delegate is null");
            return;
        }
        g gVar = new g();
        gVar.f432168a = params.getRoomId();
        gVar.f432171d = params.getSubTagId();
        gVar.f432170c = params.getTargetTagId();
        gVar.f432169b = params.getTableId();
        gVar.f432172e = params.isShowInSquare() ? 1 : 0;
        byte[] byteArray = MessageNano.toByteArray(gVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest(SERVICE, METHOD_DO_FOCUS, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasLibraryRoomService$sitDown$1
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
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasLibraryRoomService", "doFocus error: code=" + intValue + ", message=" + data.getErrMsg() + ", prompt=" + data.getPrompt(), null, 4, null);
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
                bs4.j jVar;
                try {
                    h c16 = h.c(rspData);
                    User parse = (c16 == null || (jVar = c16.f432173a) == null) ? null : LibraryDataParserKt.parse(jVar);
                    SquareBaseKt.getSquareLog().i("VasLibraryRoomService", "doFocus success: user=" + parse);
                    ResultCallback.this.onResultSuccess(parse);
                } catch (InvalidProtocolBufferNanoException e16) {
                    SquareBaseKt.getSquareLog().e("VasLibraryRoomService", "sendInviteArk parse err.", e16);
                    ResultCallback.this.onResultFailure(-2, "doFocus parse error");
                }
            }
        });
    }

    @Override // com.tencent.state.template.service.ITemplateRoomService
    public void standUp(String from, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(from, "from");
        SquareBaseKt.getSquareLog().i(TAG, "[LibraryEndFocus] end focus from=" + from);
        service.doEndFocus(new a()).a(new b<rs4.b>() { // from class: com.tencent.state.service.VasLibraryRoomService$standUp$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasLibraryRoomService", "end focus error: errorCode=" + errorCode + ", errorMessage=" + errorMessage, null, 4, null);
                Function1 function1 = Function1.this;
                if (function1 != null) {
                }
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(rs4.b response) {
                Intrinsics.checkNotNullParameter(response, "response");
                SquareBaseKt.getSquareLog().i("VasLibraryRoomService", "[LibraryEndFocus] end focus success");
                Function1 function1 = Function1.this;
                if (function1 != null) {
                }
            }
        });
    }

    @Override // com.tencent.state.template.service.ITemplateRoomService
    public void switchRoom(final ResultCallback<EnterRoomInfo> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "switchRoom request.");
        service.switchRoom(new m()).a(new b<n>() { // from class: com.tencent.state.service.VasLibraryRoomService$switchRoom$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasLibraryRoomService", "switchRoom failed: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                ResultCallback.this.onResultFailure(errorCode, errorMessage);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(n response) {
                EnterRoomInfo enterRoomInfo;
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    enterRoomInfo = LibraryDataParserKt.parse(response);
                } catch (Throwable th5) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasLibraryRoomService", "switchRoom parse response failed: " + th5.getMessage(), null, 4, null);
                    ResultCallback.this.onResultFailure(-2, "enterRoom parse failed.");
                    enterRoomInfo = null;
                }
                SquareBaseKt.getSquareLog().i("VasLibraryRoomService", "switchRoom success: info = " + enterRoomInfo);
                if (enterRoomInfo != null) {
                    ResultCallback.this.onResultSuccess(enterRoomInfo);
                }
            }
        });
    }

    @Override // com.tencent.state.template.service.ITemplateRoomService
    public void switchTable(String uin, final long roomId, final long tableId, Point sitLocation, final ResultCallback<User> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "[switchTable] rId:" + roomId + ", tId:" + tableId);
        IVasLibraryRoomService iVasLibraryRoomService = service;
        o oVar = new o();
        oVar.f432179a = roomId;
        oVar.f432180b = tableId;
        Unit unit = Unit.INSTANCE;
        iVasLibraryRoomService.switchTable(oVar).a(new b<p>() { // from class: com.tencent.state.service.VasLibraryRoomService$switchTable$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareBaseKt.getSquareLog().i("VasLibraryRoomService", "[switchTable] rId:" + roomId + ", tId:" + tableId + ", err: " + errorCode + ", " + errorMessage);
                callback.onResultFailure(errorCode, errorMessage);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(p response) {
                Intrinsics.checkNotNullParameter(response, "response");
                SquareBaseKt.getSquareLog().i("VasLibraryRoomService", "[switchTable] rId:" + roomId + ", tId:" + tableId + ", success");
                bs4.j jVar = response.f432181a;
                User parse = jVar != null ? LibraryDataParserKt.parse(jVar) : null;
                if (parse == null) {
                    callback.onResultFailure(-1, "result parse null");
                } else {
                    callback.onResultSuccess(parse);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportEnterRoomEvent(boolean result, int errorCode, Long roomId) {
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("zplan_action_result", Integer.valueOf(result ? 1 : 0));
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_IS_ROOM_ID, Long.valueOf(roomId != null ? roomId.longValue() : 0L));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        if (!result) {
            mutableMapOf.put("zplan_action_fail_reason", Integer.valueOf(errorCode));
        }
        reporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_ENTER_ROOM, mutableMapOf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void reportEnterRoomEvent$default(VasLibraryRoomService vasLibraryRoomService, boolean z16, int i3, Long l3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        if ((i16 & 4) != 0) {
            l3 = null;
        }
        vasLibraryRoomService.reportEnterRoomEvent(z16, i3, l3);
    }
}
