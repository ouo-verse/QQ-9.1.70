package com.tencent.state.service;

import android.text.TextUtils;
import android.util.Size;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.rapier.b;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.battery.SquareBatteryStatusManager;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.map.MapItem;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareMessageRecord;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.FilamentCoverResourceItem;
import com.tencent.state.square.data.FilamentCoverResourceKt;
import com.tencent.state.square.data.RecordSource;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareAvatarExtra;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareItemKt;
import com.tencent.state.square.data.SquareJudgeRecordData;
import com.tencent.state.square.data.Stickers;
import com.tencent.state.square.detail.DetailFragmentLauncherKt;
import com.tencent.state.square.detail.MainScene;
import com.tencent.state.square.interaction.InteractionManager;
import com.tencent.state.square.record.SquareRecordManager;
import com.tencent.state.template.data.CommonDataKt;
import com.tencent.state.utils.CacheFileUtils;
import com.tencent.state.utils.CachePath;
import com.tencent.state.utils.SquareSwitchUtils;
import hs4.f;
import hs4.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import xt4.af;
import xt4.ag;
import xt4.e;
import xt4.g;
import xt4.i;
import xt4.j;
import xt4.k;
import xt4.l;
import xt4.m;
import xt4.n;
import xt4.o;
import xt4.p;
import xt4.t;
import xt4.x;
import xt4.y;
import xt4.z;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bK\u0010LJ>\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002JH\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ@\u0010!\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u000bJ\"\u0010#\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00122\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00060\u000bJb\u0010-\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00152\u0006\u0010'\u001a\u00020&2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010&2\u0006\u0010)\u001a\u00020\u00122\u0018\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120*0\u00062\u0006\u0010,\u001a\u00020\u00152\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000bJ\u0014\u0010.\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bJ*\u00104\u001a\u00020\u000e2\u0006\u00100\u001a\u00020/2\f\u00102\u001a\b\u0012\u0004\u0012\u0002010\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002030\u000bJ\u0016\u00106\u001a\u00020\u000e2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u000bJ\u001c\u00108\u001a\u00020\u000e2\u0006\u00100\u001a\u0002072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bJ\u001a\u00109\u001a\u00020\u000e2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u00060\u000bR\u0014\u0010:\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b<\u0010;R\u0014\u0010=\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0014\u0010>\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b>\u0010;R\u0014\u0010?\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b?\u0010;R\u0014\u0010@\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b@\u0010;R\u0014\u0010A\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bA\u0010;R\u0014\u0010B\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bB\u0010;R\u0014\u0010C\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bC\u0010;R\u0014\u0010D\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bF\u0010ER\u0014\u0010G\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006M"}, d2 = {"Lcom/tencent/state/service/VasStatusSquareService;", "", "", "rspData", "Lxt4/o;", "req", "", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "unreadList", "", QAdRewardDefine$VideoParams.ISCACHE, "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/service/SquarePageInfo;", "callback", "", "formatUserListData", "Lhs4/f;", "getHardwareInfo", "", GetAdInfoRequest.SOURCE_FROM, "recentUserList", "", "pageNum", "mapId", "getUserList", "uin", "Lcom/tencent/state/square/detail/MainScene;", "source", "Lcom/tencent/state/square/api/SquareMessageRecord;", "message", "Landroid/util/Size;", "mapSize", "Lcom/tencent/state/square/data/SquareAvatarItem;", "getUserInfo", "Lcom/tencent/state/square/data/AvatarAction;", "getUserActionInfo", "motionType", "actionId", "Lcom/tencent/state/square/data/RecordSource;", "mp4", "cover", "dressKey", "Lkotlin/Pair;", "dressKeyList", "appId", "setUserAction", "queryDressKey", "Lcom/tencent/state/square/data/Resource;", "resource", "", "uins", "Lcom/tencent/state/square/data/SquareJudgeRecordData;", "isMotionNeedRecord", "Lcom/tencent/state/square/data/Stickers;", "getStickers", "Lcom/tencent/state/square/data/FilamentCoverResourceItem;", "setFilamentCover", "getMyCurrentResources", "TAG", "Ljava/lang/String;", "CMD_SERVICE", "METHOD_GET_USER_LIST", "METHOD_GET_USER_INFO", "METHOD_SET_USER_MOTION", "METHOD_GET_DRESS_KEY", "METHOD_GET_NOVICE_GUIDE", "METHOD_JUDGE_MOTION_RECORD", "METHOD_GET_STICKERS", "UN_KNOW_ERROR", "I", "PARSE_ERROR", "NETWORK_DELEGATE_ERROR", "Lcom/tencent/state/service/IVasStatusSquareService;", "rapierSrv", "Lcom/tencent/state/service/IVasStatusSquareService;", "<init>", "()V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasStatusSquareService {
    public static final String CMD_SERVICE = "trpc.qmeta.status_square_svr.StatusSquareSvr";
    private static final String METHOD_GET_DRESS_KEY = "GetDressKey";
    private static final String METHOD_GET_NOVICE_GUIDE = "GetNoviceGuidance";
    private static final String METHOD_GET_STICKERS = "GetSticker";
    private static final String METHOD_GET_USER_INFO = "BatchGetUserInfo";
    public static final String METHOD_GET_USER_LIST = "GetUserList";
    private static final String METHOD_JUDGE_MOTION_RECORD = "JudgeMotionRecord";
    private static final String METHOD_SET_USER_MOTION = "SetMotion";
    public static final int NETWORK_DELEGATE_ERROR = -3;
    public static final int PARSE_ERROR = -2;
    private static final String TAG = "ZPlanVasSocialService";
    public static final int UN_KNOW_ERROR = -1;
    public static final VasStatusSquareService INSTANCE = new VasStatusSquareService();
    private static final IVasStatusSquareService rapierSrv = (IVasStatusSquareService) Square.INSTANCE.getConfig().getRapier().b(IVasStatusSquareService.class);

    VasStatusSquareService() {
    }

    private final f getHardwareInfo() {
        f fVar = new f();
        Square square = Square.INSTANCE;
        fVar.f406137a = square.getConfig().getCommonUtils().getGpuInfo();
        fVar.f406138b = square.getConfig().getCommonUtils().getDeviceName();
        fVar.f406139c = square.getConfig().getCommonUtils().getSystemVersion();
        return fVar;
    }

    public final void getMyCurrentResources(final ResultCallback<List<Resource>> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        final String str = "getMyCurrentResources_" + UUID.randomUUID();
        SquareBaseKt.getSquareLog().d(TAG, String.valueOf(str));
        rapierSrv.getResourceInfo(new k()).a(new b<l>() { // from class: com.tencent.state.service.VasStatusSquareService$getMyCurrentResources$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ZPlanVasSocialService", str + " FAIL: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                callback.onResultFailure(errorCode, errorMessage);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(l response) {
                List listOfNotNull;
                Intrinsics.checkNotNullParameter(response, "response");
                SquareBaseKt.getSquareLog().i("ZPlanVasSocialService", str + " success");
                ResultCallback resultCallback = callback;
                s sVar = response.f448603a;
                Intrinsics.checkNotNullExpressionValue(sVar, "response.filamentStatusRes");
                s sVar2 = response.f448604b;
                Intrinsics.checkNotNullExpressionValue(sVar2, "response.unreadFilamentRes");
                listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new Resource[]{VasStatusSquareServiceKt.parse(sVar), VasStatusSquareServiceKt.parse(sVar2)});
                resultCallback.onResultSuccess(listOfNotNull);
            }
        });
    }

    public final void getStickers(final ResultCallback<Stickers> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        m mVar = new m();
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(mVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_GET_STICKERS, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasStatusSquareService$getStickers$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ZPlanVasSocialService", "getSticker failed " + data.getErrCode() + ", " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    try {
                        n c16 = n.c(rspData);
                        SquareBaseKt.getSquareLog().d("ZPlanVasSocialService", "getSticker response: " + c16);
                        ResultCallback.this.onResultSuccess(Stickers.INSTANCE.parse(c16.f448605a));
                    } catch (Throwable th5) {
                        SquareBaseKt.getSquareLog().e("ZPlanVasSocialService", "getSticker parse throw:", th5);
                        ResultCallback.this.onResultFailure(-2, "getSticker parse error");
                    }
                }
            });
            return;
        }
        callback.onResultFailure(-3, "getSticker network delegate is null");
    }

    public final void getUserActionInfo(String uin, final ResultCallback<List<AvatarAction>> callback) {
        Long longOrNull;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            e eVar = new e();
            eVar.f448578a = new long[]{longValue};
            INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
            if (networkDelegate != null) {
                byte[] byteArray = MessageNano.toByteArray(eVar);
                Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
                emptyMap = MapsKt__MapsKt.emptyMap();
                networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_GET_USER_INFO, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasStatusSquareService$getUserActionInfo$1
                    @Override // com.tencent.state.api.INetworkDelegateCallBack
                    public void onError(SquareErrorData data) {
                        Intrinsics.checkNotNullParameter(data, "data");
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ZPlanVasSocialService", "getUserActionInfo fail " + data.getErrCode() + ", " + data.getErrMsg(), null, 4, null);
                        ResultCallback resultCallback = ResultCallback.this;
                        Integer errCode = data.getErrCode();
                        resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                    }

                    @Override // com.tencent.state.api.INetworkDelegateCallBack
                    public void onReceive(byte[] rspData) {
                        Object firstOrNull;
                        List<AvatarAction> emptyList;
                        try {
                            xt4.f c16 = xt4.f.c(rspData);
                            SquareBaseKt.getSquareLog().d("ZPlanVasSocialService", "getUserActionInfo response: " + c16.f448581a.length);
                            ResultCallback resultCallback = ResultCallback.this;
                            ag[] agVarArr = c16.f448581a;
                            Intrinsics.checkNotNullExpressionValue(agVarArr, "rsp.infos");
                            firstOrNull = ArraysKt___ArraysKt.firstOrNull(agVarArr);
                            ag agVar = (ag) firstOrNull;
                            if (agVar == null || (emptyList = UserFormatKt.formatActions(agVar)) == null) {
                                emptyList = CollectionsKt__CollectionsKt.emptyList();
                            }
                            resultCallback.onResultSuccess(emptyList);
                        } catch (Throwable th5) {
                            SquareBaseKt.getSquareLog().e("ZPlanVasSocialService", "getUserActionInfo parse throw:", th5);
                            ResultCallback.this.onResultFailure(-2, "getUserActionInfo parse error");
                        }
                    }
                });
                return;
            }
            callback.onResultFailure(-3, "getUserActionInfo network delegate is null");
            return;
        }
        callback.onResultFailure(-1, "longUin covert err");
    }

    public final void getUserInfo(String uin, MainScene source, final SquareMessageRecord message, final Size mapSize, final ResultCallback<SquareAvatarItem> callback) {
        Long longOrNull;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(callback, "callback");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
        long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
        e eVar = new e();
        eVar.f448578a = new long[]{longValue};
        eVar.f448579b = DetailFragmentLauncherKt.covertToSource(source);
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(eVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_GET_USER_INFO, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasStatusSquareService$getUserInfo$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ZPlanVasSocialService", "getUserInfo fail " + data.getErrCode() + ", " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    Object firstOrNull;
                    SquareAvatarItem squareAvatarItem;
                    try {
                        xt4.f rsp = xt4.f.c(rspData);
                        SquareBaseKt.getSquareLog().d("ZPlanVasSocialService", "getUserInfo response: " + rsp.f448581a.length);
                        ResultCallback resultCallback = ResultCallback.this;
                        ag[] agVarArr = rsp.f448581a;
                        Intrinsics.checkNotNullExpressionValue(agVarArr, "rsp.infos");
                        firstOrNull = ArraysKt___ArraysKt.firstOrNull(agVarArr);
                        ag agVar = (ag) firstOrNull;
                        if (agVar == null || (squareAvatarItem = UserFormatKt.formatUserInfo$default(agVar, message, mapSize, InteractionManager.INSTANCE.getSquareInteractionUnread(), null, SquareBaseKt.getSquareCommon().getNeedShieldTeenager(), 8, null)) == null) {
                            squareAvatarItem = null;
                        } else {
                            SquareAvatarExtra extra = squareAvatarItem.getExtra();
                            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                            extra.setDetailBackgroundInfo(UserFormatKt.formatAdaptiveBkg(rsp));
                            Unit unit = Unit.INSTANCE;
                        }
                        resultCallback.onResultSuccess(squareAvatarItem);
                    } catch (Throwable th5) {
                        SquareBaseKt.getSquareLog().e("ZPlanVasSocialService", "getUserInfo parse throw:", th5);
                        ResultCallback.this.onResultFailure(-2, "getUserInfo parse error");
                    }
                }
            });
            return;
        }
        callback.onResultFailure(-3, "getUserInfo network delegate is null");
    }

    public final void getUserList(String sourceFrom, final List<? extends SquareBaseMessageRecord> unreadList, List<String> recentUserList, final int pageNum, int mapId, final ResultCallback<SquarePageInfo> callback) {
        int collectionSizeOrDefault;
        long[] longArray;
        int collectionSizeOrDefault2;
        long[] longArray2;
        Map<String, String> emptyMap;
        Long longOrNull;
        Long longOrNull2;
        Intrinsics.checkNotNullParameter(sourceFrom, "sourceFrom");
        Intrinsics.checkNotNullParameter(unreadList, "unreadList");
        Intrinsics.checkNotNullParameter(recentUserList, "recentUserList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().d(TAG, "getUserList, from:" + sourceFrom + ", pagNum:" + pageNum + ", mapId:" + mapId);
        final o oVar = new o();
        oVar.f448612g = SquareFragment.INSTANCE.getChatLandAppId();
        List<? extends SquareBaseMessageRecord> list = unreadList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (true) {
            long j3 = 0;
            if (!it.hasNext()) {
                break;
            }
            longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(((SquareBaseMessageRecord) it.next()).getUin());
            if (longOrNull2 != null) {
                j3 = longOrNull2.longValue();
            }
            arrayList.add(Long.valueOf(j3));
        }
        longArray = CollectionsKt___CollectionsKt.toLongArray(arrayList);
        oVar.f448606a = longArray;
        oVar.f448607b = pageNum;
        oVar.f448609d = mapId;
        oVar.f448608c = INSTANCE.getHardwareInfo();
        List<String> list2 = recentUserList;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = list2.iterator();
        while (it5.hasNext()) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) it5.next());
            arrayList2.add(Long.valueOf(longOrNull != null ? longOrNull.longValue() : 0L));
        }
        longArray2 = CollectionsKt___CollectionsKt.toLongArray(arrayList2);
        oVar.f448610e = longArray2;
        oVar.f448611f = sourceFrom;
        if (SquareSwitchUtils.INSTANCE.enableIndexUseCache()) {
            CacheFileUtils.INSTANCE.getCache(CachePath.IndexUserList, new Function1<byte[], Unit>() { // from class: com.tencent.state.service.VasStatusSquareService$getUserList$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr) {
                    invoke2(bArr);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(byte[] it6) {
                    Intrinsics.checkNotNullParameter(it6, "it");
                    VasStatusSquareService.INSTANCE.formatUserListData(it6, o.this, unreadList, true, callback);
                }
            });
        }
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(oVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_GET_USER_LIST, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasStatusSquareService$getUserList$2
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ZPlanVasSocialService", "getUserList pageNum:" + pageNum + " fail " + data.getErrCode() + ", " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = callback;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    VasStatusSquareService.INSTANCE.formatUserListData(rspData, o.this, unreadList, false, callback);
                    if (SquareSwitchUtils.INSTANCE.enableIndexUseCache()) {
                        CacheFileUtils.INSTANCE.saveCache(CachePath.IndexUserList, rspData);
                    }
                }
            });
            return;
        }
        callback.onResultFailure(-3, "getUserList network delegate is null");
    }

    public final void queryDressKey(final ResultCallback<String> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        i iVar = new i();
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(iVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_GET_DRESS_KEY, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasStatusSquareService$queryDressKey$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ZPlanVasSocialService", "queryDressKey fail " + data.getErrCode() + ", " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    try {
                        j c16 = j.c(rspData);
                        ResultCallback resultCallback = ResultCallback.this;
                        String str = c16.f448602a;
                        Intrinsics.checkNotNullExpressionValue(str, "rsp.dressKey");
                        resultCallback.onResultSuccess(str);
                        SquareBaseKt.getSquareLog().d("ZPlanVasSocialService", "queryDressKey dressKey: " + c16.f448602a);
                    } catch (InvalidProtocolBufferNanoException e16) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ZPlanVasSocialService", "queryDressKey parse throw: " + e16, null, 4, null);
                        ResultCallback.this.onResultFailure(-2, "queryDressKey parse error");
                    }
                }
            });
            return;
        }
        callback.onResultFailure(-3, "queryDressKey network delegate is null");
    }

    public final void setFilamentCover(final FilamentCoverResourceItem resource, final ResultCallback<Unit> callback) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final String str = "setFilamentCoverResource_" + UUID.randomUUID();
        SquareBaseKt.getSquareLog().d(TAG, str + MsgSummary.STR_COLON + resource);
        x xVar = new x();
        xVar.f448670a = new g[]{FilamentCoverResourceKt.toPB(resource)};
        rapierSrv.setCoverResource(xVar).a(new b<y>() { // from class: com.tencent.state.service.VasStatusSquareService$setFilamentCover$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ZPlanVasSocialService", str + " FAIL: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                callback.onResultFailure(errorCode, errorMessage);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(y response) {
                Intrinsics.checkNotNullParameter(response, "response");
                SquareBaseKt.getSquareLog().i("ZPlanVasSocialService", str + " success");
                callback.onResultSuccess(Unit.INSTANCE);
                if (CommonDataKt.isMe(resource.getUin())) {
                    return;
                }
                CacheFileUtils.INSTANCE.doUpdateWhenExit();
            }
        });
    }

    public final void setUserAction(final int motionType, final int actionId, RecordSource mp42, RecordSource cover, final String dressKey, List<Pair<String, String>> dressKeyList, int appId, final ResultCallback<Boolean> callback) {
        int collectionSizeOrDefault;
        Map<String, String> emptyMap;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(mp42, "mp4");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        Intrinsics.checkNotNullParameter(dressKeyList, "dressKeyList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        z zVar = new z();
        zVar.f448671a = motionType;
        zVar.f448672b = actionId;
        hs4.m mVar = new hs4.m();
        mVar.f406169a = mp42.getPath();
        mVar.f406170b = mp42.getMd5();
        Unit unit = Unit.INSTANCE;
        zVar.f448673c = mVar;
        zVar.f448674d = dressKey;
        zVar.f448675e = INSTANCE.getHardwareInfo();
        List<Pair<String, String>> list = dressKeyList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            af afVar = new af();
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) pair.getFirst());
            afVar.f448534a = longOrNull != null ? longOrNull.longValue() : 0L;
            afVar.f448535b = (String) pair.getSecond();
            arrayList.add(afVar);
        }
        Object[] array = arrayList.toArray(new af[0]);
        if (array != null) {
            zVar.f448680j = (af[]) array;
            zVar.f448683m = appId;
            if (cover != null) {
                hs4.m mVar2 = new hs4.m();
                mVar2.f406169a = cover.getPath();
                mVar2.f406170b = cover.getMd5();
                Unit unit2 = Unit.INSTANCE;
                zVar.f448682l = mVar2;
            }
            zVar.f448681k = 6;
            SquareBaseKt.getSquareLog().d(TAG, "setUserAction req: motionType:" + motionType + ", actionId:" + actionId + ", dressKey:" + dressKey + ", appId:" + appId);
            INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
            if (networkDelegate != null) {
                byte[] byteArray = MessageNano.toByteArray(zVar);
                Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
                emptyMap = MapsKt__MapsKt.emptyMap();
                networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_SET_USER_MOTION, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasStatusSquareService$setUserAction$1
                    @Override // com.tencent.state.api.INetworkDelegateCallBack
                    public void onError(SquareErrorData data) {
                        Intrinsics.checkNotNullParameter(data, "data");
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ZPlanVasSocialService", "setUserAction actionId:" + actionId + " dressKey:" + dressKey + " motionType:" + motionType + " fail " + data.getErrCode() + ", " + data.getErrMsg(), null, 4, null);
                        ResultCallback resultCallback = ResultCallback.this;
                        Integer errCode = data.getErrCode();
                        resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                    }

                    @Override // com.tencent.state.api.INetworkDelegateCallBack
                    public void onReceive(byte[] rspData) {
                        ResultCallback.this.onResultSuccess(Boolean.TRUE);
                    }
                });
                return;
            }
            callback.onResultFailure(-3, "setUserAction network delegate is null");
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static /* synthetic */ void getUserInfo$default(VasStatusSquareService vasStatusSquareService, String str, MainScene mainScene, SquareMessageRecord squareMessageRecord, Size size, ResultCallback resultCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            mainScene = MainScene.SQUARE;
        }
        vasStatusSquareService.getUserInfo(str, mainScene, (i3 & 4) != 0 ? null : squareMessageRecord, (i3 & 8) != 0 ? null : size, resultCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void formatUserListData(byte[] rspData, o req, List<? extends SquareBaseMessageRecord> unreadList, boolean isCache, ResultCallback<SquarePageInfo> callback) {
        Object obj;
        Object obj2;
        try {
            p rsp = p.c(rspData);
            SquareBaseKt.getSquareLog().d(TAG, "getUserList reqPageNum:" + req.f448607b + ", reqMapId:" + req.f448609d + ", rspMapId:" + rsp.f448617e + ", flowerBubbleText=" + rsp.f448626n + ", needShieldTeenager:" + Boolean.valueOf(rsp.f448627o));
            SquareBaseKt.getSquareCommon().setNeedShieldTeenager(rsp.f448627o);
            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
            List<MapItem> formatSquareItemList = UserFormatKt.formatSquareItemList(rsp, unreadList, isCache);
            int i3 = req.f448607b;
            int i16 = rsp.f448614b;
            Square square = Square.INSTANCE;
            callback.onResultSuccess(new SquarePageInfo(formatSquareItemList, i3, i16, new Size(ViewExtensionsKt.calPx(square.getApplication(), rsp.f448616d), ViewExtensionsKt.calPx(square.getApplication(), rsp.f448615c)), rsp.f448617e, rsp.f448624l, UserFormatKt.formatAdaptiveBkg(rsp), rsp.f448628p, isCache));
            if (isCache) {
                return;
            }
            Iterator<T> it = formatSquareItemList.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                } else {
                    obj2 = it.next();
                    if (Intrinsics.areEqual(((MapItem) obj2).getUin(), Square.INSTANCE.getConfig().getCommonUtils().getCurrentAccountUin())) {
                        break;
                    }
                }
            }
            if (obj2 instanceof SquareAvatarItem) {
                obj = obj2;
            }
            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) obj;
            if (squareAvatarItem != null) {
                if (!TextUtils.isEmpty(squareAvatarItem.getDressKey())) {
                    SquareRecordManager.updateDressKey$default(SquareRecordManager.INSTANCE, squareAvatarItem.getDressKey(), "getUserList", false, squareAvatarItem.getIsGenderMale(), 4, null);
                }
                SquareBatteryStatusManager.INSTANCE.onStatusChange(squareAvatarItem.getUin(), squareAvatarItem.getIsGenderMale(), squareAvatarItem.getExtra().getOnlineStatus(), "getUserList");
            }
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "getUserList parse throw:", th5);
            if (isCache) {
                return;
            }
            callback.onResultFailure(-2, "getUserList parse error");
        }
    }

    public final void isMotionNeedRecord(final Resource resource, List<Long> uins, final ResultCallback<SquareJudgeRecordData> callback) {
        long[] longArray;
        String joinToString$default;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(uins, "uins");
        Intrinsics.checkNotNullParameter(callback, "callback");
        xt4.s sVar = new xt4.s();
        sVar.f448644a = resource.getActionType();
        sVar.f448645b = resource.getActionId();
        longArray = CollectionsKt___CollectionsKt.toLongArray(uins);
        sVar.f448646c = longArray;
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isMotionNeedRecord request start: uins=");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(uins, ",", null, null, 0, null, null, 62, null);
        sb5.append(joinToString$default);
        sb5.append(" res=");
        sb5.append(resource);
        squareLog.i(TAG, sb5.toString());
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(sVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_JUDGE_MOTION_RECORD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasStatusSquareService$isMotionNeedRecord$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ZPlanVasSocialService", "isMotionNeedRecord fail " + data.getErrCode() + ", " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = callback;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    Resource copyResource;
                    try {
                        t rsp = t.c(rspData);
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        copyResource = SquareItemKt.copyResource(r4, (r21 & 1) != 0 ? r4.getActionId() : 0, (r21 & 2) != 0 ? r4.getDynamic() : null, (r21 & 4) != 0 ? r4.getStatic() : null, (r21 & 8) != 0 ? r4.getShowSize() : null, (r21 & 16) != 0 ? r4.getRecordSize() : null, (r21 & 32) != 0 ? r4.getIsDefault() : false, (r21 & 64) != 0 ? r4.getBubbleCoordinate() : null, (r21 & 128) != 0 ? r4.getActionType() : 0, (r21 & 256) != 0 ? r4.getActionStyle() : 0, (r21 & 512) != 0 ? Resource.this.getFilament() : null);
                        SquareJudgeRecordData format = UserFormatKt.format(rsp, copyResource);
                        SquareBaseKt.getSquareLog().i("ZPlanVasSocialService", "isMotionNeedRecord response: " + format);
                        callback.onResultSuccess(format);
                    } catch (Throwable th5) {
                        SquareBaseKt.getSquareLog().e("ZPlanVasSocialService", "isMotionNeedRecord parse throw:", th5);
                        callback.onResultFailure(-2, "isMotionNeedRecord parse error");
                    }
                }
            });
            return;
        }
        callback.onResultFailure(-3, "isMotionNeedRecord network delegate is null");
    }
}
