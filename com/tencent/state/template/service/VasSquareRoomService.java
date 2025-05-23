package com.tencent.state.template.service;

import android.app.Application;
import android.graphics.Point;
import android.util.Size;
import com.google.protobuf.nano.MessageNano;
import com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest;
import com.tencent.rapier.b;
import com.tencent.state.SquareRuntime;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.template.data.CommonDataParserKt;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.RemainTimeInfo;
import com.tencent.state.template.data.RoomConfig;
import com.tencent.state.template.data.SitDownTagParams;
import com.tencent.state.template.data.User;
import com.tencent.state.utils.CacheFileUtils;
import com.tencent.state.utils.CachePath;
import fs4.k;
import fs4.r;
import fs4.t;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.httpcore.message.TokenParser;
import wt4.a;
import wt4.c;
import wt4.d;
import wt4.e;
import wt4.f;
import wt4.g;
import wt4.h;
import wt4.i;
import wt4.j;
import wt4.l;
import wt4.m;
import wt4.n;
import wt4.o;
import wt4.p;
import wt4.q;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 72\u00020\u0001:\u00017B?\u0012\u0006\u0010)\u001a\u00020!\u0012\u001e\u0010/\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+\u0012\u0006\u0012\u0004\u0018\u00010-0\u0017j\u0002`.\u0012\u000e\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010201\u00a2\u0006\u0004\b5\u00106J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J1\u0010\f\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0004H\u0016J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0004H\u0016J&\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017H\u0016J8\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004H\u0016J\u001e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00152\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H\u0016J\u0016\u0010 \u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0004H\u0016J$\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u0017H\u0016J,\u0010%\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010$\u001a\u00020!2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u0017H\u0016R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R,\u0010/\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+\u0012\u0006\u0012\u0004\u0018\u00010-0\u0017j\u0002`.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001c\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u000102018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/state/template/service/VasSquareRoomService;", "Lcom/tencent/state/template/service/ITemplateRoomService;", "Lwt4/f;", "response", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/template/data/EnterRoomInfo;", "callback", "", "parseEnterRoom", "", "roomId", "uin", "enterRoom", "(Ljava/lang/Long;Ljava/lang/Long;Lcom/tencent/state/service/ResultCallback;)V", "switchRoom", "", "leaveRoom", "Lcom/tencent/state/template/data/SitDownTagParams;", "params", "Lcom/tencent/state/template/data/User;", "sitDown", "", "from", "Lkotlin/Function1;", "standUp", "tableId", "Landroid/graphics/Point;", "sitLocation", "switchTable", "tagId", "editTag", "Lcom/tencent/state/template/data/RemainTimeInfo;", "getRemainLifeTime", "", "motionId", "refreshUserInfo", "optionNum", "choose", "Lcom/tencent/state/template/service/IVasSquareRoomService;", "service", "Lcom/tencent/state/template/service/IVasSquareRoomService;", "appId", "I", "", "Lfs4/r;", "Lcom/tencent/state/template/data/RoomConfig;", "Lcom/tencent/state/template/data/RoomConfParser;", "roomConfParser", "Lkotlin/jvm/functions/Function1;", "Lkotlin/Function0;", "Landroid/util/Size;", "getMapSize", "Lkotlin/jvm/functions/Function0;", "<init>", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSquareRoomService implements ITemplateRoomService {
    private static final String METHOD_FOCUS = "Focus";
    private static final String METHOD_SWITCH_TABLE = "SwitchTable";
    public static final int PK_ACTION_OPPOSE = 2;
    public static final int PK_ACTION_SUPPORT = 1;
    private static final String SERVICE = "trpc.qmeta.status_square_room_svr.StatusSquareRoomSvr";
    public static final String TAG = "VasSquareRoomService";
    private final int appId;
    private final Function0<Size> getMapSize;
    private final Function1<r[], RoomConfig> roomConfParser;
    private final IVasSquareRoomService service;

    /* JADX WARN: Multi-variable type inference failed */
    public VasSquareRoomService(int i3, Function1<? super r[], RoomConfig> roomConfParser, Function0<Size> getMapSize) {
        Intrinsics.checkNotNullParameter(roomConfParser, "roomConfParser");
        Intrinsics.checkNotNullParameter(getMapSize, "getMapSize");
        this.appId = i3;
        this.roomConfParser = roomConfParser;
        this.getMapSize = getMapSize;
        this.service = (IVasSquareRoomService) Square.INSTANCE.getConfig().getRapier().b(IVasSquareRoomService.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void parseEnterRoom(f response, ResultCallback<EnterRoomInfo> callback) {
        EnterRoomInfo enterRoomInfo;
        try {
            enterRoomInfo = VasSquareRoomServiceKt.parse(response, (Function1<? super r[], RoomConfig>) this.roomConfParser, this.getMapSize.invoke());
        } catch (Throwable th5) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "enter room parse response failed: " + th5.getMessage(), null, 4, null);
            callback.onResultFailure(-2, "enterRoom parse failed.");
            enterRoomInfo = null;
        }
        SquareBaseKt.getSquareLog().i(TAG, "enter room success: info = " + enterRoomInfo);
        if (enterRoomInfo != null) {
            callback.onResultSuccess(enterRoomInfo);
        }
    }

    @Override // com.tencent.state.template.service.ITemplateRoomService
    public void choose(long roomId, int optionNum, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().d(TAG, "pk choose roomId:" + roomId + ", option_num:" + optionNum);
        IVasSquareRoomService iVasSquareRoomService = this.service;
        c cVar = new c();
        cVar.f446502a = this.appId;
        cVar.f446503b = roomId;
        cVar.f446504c = optionNum;
        Unit unit = Unit.INSTANCE;
        iVasSquareRoomService.choose(cVar, SquareRuntime.INSTANCE.getQMetaContextSource()).a(new b<d>() { // from class: com.tencent.state.template.service.VasSquareRoomService$choose$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomService.TAG, "pk choose error: errorCode=" + errorCode + ", errorMessage=" + errorMessage, null, 4, null);
                Function1.this.invoke(Boolean.FALSE);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(d response) {
                Intrinsics.checkNotNullParameter(response, "response");
                SquareBaseKt.getSquareLog().i(VasSquareRoomService.TAG, "pk choose succeed");
                Function1.this.invoke(Boolean.TRUE);
            }
        });
    }

    @Override // com.tencent.state.template.service.ITemplateRoomService
    public void editTag(String tagId, ResultCallback<Boolean> callback) {
        Intrinsics.checkNotNullParameter(tagId, "tagId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "[editTag], tId:" + tagId);
    }

    @Override // com.tencent.state.template.service.ITemplateRoomService
    public void enterRoom(Long roomId, Long uin, final ResultCallback<EnterRoomInfo> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "enter room request. " + hashCode());
        e eVar = new e();
        eVar.f446505a = this.appId;
        if (roomId != null) {
            eVar.f446506b = roomId.longValue();
        }
        if (uin != null) {
            eVar.f446507c = uin.longValue();
        }
        this.service.enterRoom(eVar, SquareRuntime.INSTANCE.getQMetaContextSource()).a(new b<f>() { // from class: com.tencent.state.template.service.VasSquareRoomService$enterRoom$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomService.TAG, "enter room failed: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                callback.onResultFailure(errorCode, errorMessage);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(f response) {
                int i3;
                Intrinsics.checkNotNullParameter(response, "response");
                VasSquareRoomService.this.parseEnterRoom(response, callback);
                CacheFileUtils cacheFileUtils = CacheFileUtils.INSTANCE;
                i3 = VasSquareRoomService.this.appId;
                CachePath chatLandCacheType = cacheFileUtils.getChatLandCacheType(i3);
                if (chatLandCacheType != null) {
                    cacheFileUtils.saveCache(chatLandCacheType, MessageNano.toByteArray(response));
                }
            }
        });
    }

    @Override // com.tencent.state.template.service.ITemplateRoomService
    public void getRemainLifeTime(ResultCallback<RemainTimeInfo> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "getRemainLifeTime");
    }

    @Override // com.tencent.state.template.service.ITemplateRoomService
    public void leaveRoom(final ResultCallback<Boolean> callback) {
        SquareBaseKt.getSquareLog().i(TAG, "leaveRoom request.");
        IVasSquareRoomService iVasSquareRoomService = this.service;
        i iVar = new i();
        iVar.f446517a = this.appId;
        Unit unit = Unit.INSTANCE;
        iVasSquareRoomService.leaveRoom(iVar, SquareRuntime.INSTANCE.getQMetaContextSource()).a(new b<j>() { // from class: com.tencent.state.template.service.VasSquareRoomService$leaveRoom$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomService.TAG, "leaveRoom failed: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                ResultCallback resultCallback = ResultCallback.this;
                if (resultCallback != null) {
                    resultCallback.onResultFailure(errorCode, errorMessage);
                }
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(j response) {
                Intrinsics.checkNotNullParameter(response, "response");
                SquareBaseKt.getSquareLog().i(VasSquareRoomService.TAG, "leaveRoom success");
                ResultCallback resultCallback = ResultCallback.this;
                if (resultCallback != null) {
                    resultCallback.onResultSuccess(Boolean.TRUE);
                }
            }
        });
    }

    @Override // com.tencent.state.template.service.ITemplateRoomService
    public void refreshUserInfo(int motionId, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "refreshUserInfo, motionId=" + motionId);
        IVasSquareRoomService iVasSquareRoomService = this.service;
        l lVar = new l();
        lVar.f446520a = this.appId;
        lVar.f446521b = motionId;
        Unit unit = Unit.INSTANCE;
        iVasSquareRoomService.refreshUserInfo(lVar, SquareRuntime.INSTANCE.getQMetaContextSource()).a(new b<m>() { // from class: com.tencent.state.template.service.VasSquareRoomService$refreshUserInfo$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomService.TAG, "refreshUserInfo, error: errorCode=" + errorCode + ", errorMessage=" + errorMessage, null, 4, null);
                Function1.this.invoke(Boolean.FALSE);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(m response) {
                Intrinsics.checkNotNullParameter(response, "response");
                SquareBaseKt.getSquareLog().i(VasSquareRoomService.TAG, "refreshUserInfo, success");
                Function1.this.invoke(Boolean.TRUE);
            }
        });
    }

    @Override // com.tencent.state.template.service.ITemplateRoomService
    public void sitDown(SitDownTagParams params, final ResultCallback<User> callback) {
        k kVar;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "doPray: " + params);
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            callback.onResultFailure(-3, "doFocus network delegate is null");
            return;
        }
        Application application = Square.INSTANCE.getApplication();
        g gVar = new g();
        gVar.f446511a = this.appId;
        gVar.f446512b = params.getRoomId();
        gVar.f446513c = params.getTableId();
        if (params.getSitLocation() == null) {
            kVar = new k();
        } else {
            k kVar2 = new k();
            kVar2.f400532a = ViewExtensionsKt.reversePx(application, params.getSitLocation().x);
            kVar2.f400533b = ViewExtensionsKt.reversePx(application, params.getSitLocation().y);
            Unit unit = Unit.INSTANCE;
            kVar = kVar2;
        }
        gVar.f446514d = kVar;
        byte[] byteArray = MessageNano.toByteArray(gVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest(SERVICE, METHOD_FOCUS, byteArray, emptyMap, SquareRuntime.INSTANCE.getQMetaContextSource(), new INetworkDelegateCallBack() { // from class: com.tencent.state.template.service.VasSquareRoomService$sitDown$1
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
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomService.TAG, "doPray error: code=" + intValue + ", message=" + data.getErrMsg() + ", prompt=" + data.getPrompt(), null, 4, null);
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
                t tVar;
                try {
                    h c16 = h.c(rspData);
                    User parse = (c16 == null || (tVar = c16.f446515a) == null) ? null : CommonDataParserKt.parse(tVar);
                    SquareBaseKt.getSquareLog().i(VasSquareRoomService.TAG, "doPray success: user=" + parse);
                    ResultCallback.this.onResultSuccess(parse);
                } catch (Throwable th5) {
                    SquareBaseKt.getSquareLog().e(VasSquareRoomService.TAG, "doPray parse err.", th5);
                    ResultCallback.this.onResultFailure(-2, "doPray parse error");
                }
            }
        });
    }

    @Override // com.tencent.state.template.service.ITemplateRoomService
    public void standUp(String from, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(from, "from");
        SquareBaseKt.getSquareLog().i(TAG, "[TempleCancelPray] cancelPray, from=" + from);
        IVasSquareRoomService iVasSquareRoomService = this.service;
        a aVar = new a();
        aVar.f446501a = this.appId;
        Unit unit = Unit.INSTANCE;
        iVasSquareRoomService.cancelFocus(aVar, SquareRuntime.INSTANCE.getQMetaContextSource()).a(new b<wt4.b>() { // from class: com.tencent.state.template.service.VasSquareRoomService$standUp$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomService.TAG, "[TempleCancelPray] cancelPray, error: errorCode=" + errorCode + ", errorMessage=" + errorMessage, null, 4, null);
                Function1 function1 = Function1.this;
                if (function1 != null) {
                }
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(wt4.b response) {
                Intrinsics.checkNotNullParameter(response, "response");
                SquareBaseKt.getSquareLog().i(VasSquareRoomService.TAG, "[TempleCancelPray] cancelPray, success");
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
        IVasSquareRoomService iVasSquareRoomService = this.service;
        n nVar = new n();
        nVar.f446522a = this.appId;
        Unit unit = Unit.INSTANCE;
        iVasSquareRoomService.switchRoom(nVar, SquareRuntime.INSTANCE.getQMetaContextSource()).a(new b<o>() { // from class: com.tencent.state.template.service.VasSquareRoomService$switchRoom$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomService.TAG, "switchRoom failed: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                callback.onResultFailure(errorCode, errorMessage);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(o response) {
                EnterRoomInfo enterRoomInfo;
                Function1 function1;
                Function0 function0;
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    function1 = VasSquareRoomService.this.roomConfParser;
                    function0 = VasSquareRoomService.this.getMapSize;
                    enterRoomInfo = VasSquareRoomServiceKt.parse(response, (Function1<? super r[], RoomConfig>) function1, (Size) function0.invoke());
                } catch (Throwable th5) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomService.TAG, "switchRoom parse response failed: " + th5.getMessage(), null, 4, null);
                    callback.onResultFailure(-2, "enterRoom parse failed.");
                    enterRoomInfo = null;
                }
                SquareBaseKt.getSquareLog().i(VasSquareRoomService.TAG, "switchRoom success: info = " + enterRoomInfo);
                if (enterRoomInfo != null) {
                    callback.onResultSuccess(enterRoomInfo);
                }
            }
        });
    }

    @Override // com.tencent.state.template.service.ITemplateRoomService
    public void switchTable(String uin, final long roomId, final long tableId, Point sitLocation, final ResultCallback<User> callback) {
        k kVar;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().i(TAG, "[switchTable] rId:" + roomId + ", tId:" + tableId);
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate == null) {
            callback.onResultFailure(-3, "doFocus network delegate is null");
            return;
        }
        Application application = Square.INSTANCE.getApplication();
        p pVar = new p();
        pVar.f446526b = roomId;
        pVar.f446527c = tableId;
        pVar.f446525a = this.appId;
        if (sitLocation == null) {
            kVar = new k();
        } else {
            k kVar2 = new k();
            kVar2.f400532a = ViewExtensionsKt.reversePx(application, sitLocation.x);
            kVar2.f400533b = ViewExtensionsKt.reversePx(application, sitLocation.y);
            Unit unit = Unit.INSTANCE;
            kVar = kVar2;
        }
        pVar.f446528d = kVar;
        byte[] byteArray = MessageNano.toByteArray(pVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        networkDelegate.sendVasProxyRequest(SERVICE, METHOD_SWITCH_TABLE, byteArray, emptyMap, SquareRuntime.INSTANCE.getQMetaContextSource(), new INetworkDelegateCallBack() { // from class: com.tencent.state.template.service.VasSquareRoomService$switchTable$1
            /* JADX WARN: Removed duplicated region for block: B:10:0x0082  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0086  */
            @Override // com.tencent.state.api.INetworkDelegateCallBack
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onError(SquareErrorData data) {
                int i3;
                boolean z16;
                String prompt;
                boolean isBlank;
                Intrinsics.checkNotNullParameter(data, "data");
                Integer errCode = data.getErrCode();
                int intValue = errCode != null ? errCode.intValue() : -1;
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("switch error: appId=");
                i3 = VasSquareRoomService.this.appId;
                sb5.append(i3);
                sb5.append(" roomId=");
                sb5.append(roomId);
                sb5.append(" tableId=");
                sb5.append(tableId);
                sb5.append(" code=");
                sb5.append(intValue);
                sb5.append(", message=");
                sb5.append(data.getErrMsg());
                sb5.append(", prompt=");
                sb5.append(data.getPrompt());
                SquareLogger.DefaultImpls.e$default(squareLog, VasSquareRoomService.TAG, sb5.toString(), null, 4, null);
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
                        callback.onResultFailure(intValue, data.getErrMsg(), prompt);
                    }
                }
                z16 = true;
                if (!z16) {
                }
                callback.onResultFailure(intValue, data.getErrMsg(), prompt);
            }

            @Override // com.tencent.state.api.INetworkDelegateCallBack
            public void onReceive(byte[] rspData) {
                int i3;
                int i16;
                t tVar;
                try {
                    q c16 = q.c(rspData);
                    User parse = (c16 == null || (tVar = c16.f446529a) == null) ? null : CommonDataParserKt.parse(tVar);
                    SquareLogger squareLog = SquareBaseKt.getSquareLog();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("switch success: appId=");
                    i16 = VasSquareRoomService.this.appId;
                    sb5.append(i16);
                    sb5.append(" roomId=");
                    sb5.append(roomId);
                    sb5.append(" tableId=");
                    sb5.append(tableId);
                    sb5.append(" user=");
                    sb5.append(parse);
                    squareLog.i(VasSquareRoomService.TAG, sb5.toString());
                    if (parse == null) {
                        callback.onResultFailure(-2, "result parse null");
                    } else {
                        callback.onResultSuccess(parse);
                    }
                } catch (Throwable th5) {
                    SquareLogger squareLog2 = SquareBaseKt.getSquareLog();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("switch parse err. appId=");
                    i3 = VasSquareRoomService.this.appId;
                    sb6.append(i3);
                    sb6.append(" roomId=");
                    sb6.append(roomId);
                    sb6.append(" tableId=");
                    sb6.append(tableId);
                    sb6.append(TokenParser.SP);
                    squareLog2.e(VasSquareRoomService.TAG, sb6.toString(), th5);
                    callback.onResultFailure(-2, "switch table parse error");
                }
            }
        });
    }
}
