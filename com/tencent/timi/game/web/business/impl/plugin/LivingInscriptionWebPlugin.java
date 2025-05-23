package com.tencent.timi.game.web.business.impl.plugin;

import ag4.i;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.state.data.SquareJSConst;
import com.tencent.timi.game.ad.ui.event.RefreshBatteryOperationEvent;
import com.tencent.timi.game.app.event.AudienceInputEvent;
import com.tencent.timi.game.component.gamecore.impl.GameCoreServiceImpl;
import com.tencent.timi.game.expand.hall.impl.ipc.HallServerIpcModule;
import com.tencent.timi.game.expand.hall.impl.ipc.param.HallInfo;
import com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.w;
import com.tencent.timi.game.web.business.api.race.LivingRaceNativeEvent;
import com.tencent.timi.game.web.business.api.race.LivingRoomInfo;
import com.tencent.timi.game.web.business.api.task.LiveLotteryTaskDataManager;
import com.tencent.timi.game.web.business.impl.common.TimiBrowserActivity;
import com.tencent.timi.game.web.business.impl.plugin.LivingInscriptionWebPlugin;
import com.vivo.push.PushClientConstants;
import cooperation.qzone.QzoneIPCModule;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.ULong;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.UStringsKt;
import nn4.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import trpc.yes.common.GameAuthOuterClass$AgreeGameAuthRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameRoleListRsp;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAbsInfo;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleInfo;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\t\u0018\u0000 T2\u00020\u0001:\u0002UVB\t\b\u0016\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0016JO\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\t\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000bJ\u0016\u0010\u0015\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002JX\u0010#\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u000bH\u0002J\u0018\u0010%\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0002H\u0002J\b\u0010&\u001a\u00020\u0012H\u0002J\u0010\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020\u0019H\u0002J\u0016\u0010*\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002J\b\u0010+\u001a\u00020\u0012H\u0002J\b\u0010,\u001a\u00020\u0012H\u0002J\u0016\u0010-\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002J\u0016\u0010.\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002J\u0016\u0010/\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002J\u0010\u00101\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u0019H\u0002J\u0016\u00102\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002J\u0016\u00103\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002J\u0016\u00104\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002J\b\u00105\u001a\u00020\u0012H\u0002J\u0016\u00106\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002J\u0016\u00107\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002J\u0016\u00108\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002J\u0016\u00109\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002J\b\u0010:\u001a\u00020\u0012H\u0002J\u0016\u0010=\u001a\u00020\u00122\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00020;H\u0002J\u0016\u0010>\u001a\u00020\u00122\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00020;H\u0002J\u0016\u0010?\u001a\u00020\u00122\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002J\u0016\u0010@\u001a\u00020\u00122\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002J\u0016\u0010A\u001a\u00020(2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002J\u0012\u0010C\u001a\u00020\u000b2\b\u0010B\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010D\u001a\u00020(2\u0006\u0010$\u001a\u00020\u0002H\u0002J\u001e\u0010H\u001a\u00020\u00022\u0014\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020F\u0018\u00010EH\u0002J\u0010\u0010I\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0019H\u0002J\u0018\u0010K\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00192\u0006\u0010J\u001a\u00020\u0002H\u0002J\u0012\u0010M\u001a\u00020\u00022\b\u0010L\u001a\u0004\u0018\u00010\u0002H\u0002R\"\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006W"}, d2 = {"Lcom/tencent/timi/game/web/business/impl/plugin/LivingInscriptionWebPlugin;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "", "getNameSpace", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "args", "", "handleJsRequest", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "Lcom/tencent/timi/game/web/business/api/race/LivingRaceNativeEvent;", "event", "m0", "hidden", "", "w0", "", "i0", ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, "anchorId", "", VirtualAppProxy.KEY_GAME_ID, "isAnchor", "roomId", "liveUid", "nick", "headUrl", "anchorNick", "anchorHeadUrl", "isFromGuild", "K", "content", "J", "M", "code", "Lorg/json/JSONObject;", "O", "E", "X", "T", "W", "v0", "j0", "yesGameId", "f0", "u0", "n0", "r0", "U", "t0", "L", "s0", "e0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "argsList", "b0", "Y", "p0", "D", "V", "arg", "g0", "N", "", "", "responseParams", "I", "G", "msg", "H", "params", "P", "", "d", "Ljava/util/Map;", "callBackIdMap", "<init>", "()V", "e", "a", "MyResultReceiver", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class LivingInscriptionWebPlugin extends WebViewPlugin {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final String f380335f = "com.tencent.timi.game.getChangedData";

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final String f380336h = "com.tencent.timi.game.getTriggeredByNative";

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final String f380337i = "com.tencent.timi.game.tabVisibilityChange";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, String> callBackIdMap = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014\u00a8\u0006\t"}, d2 = {"Lcom/tencent/timi/game/web/business/impl/plugin/LivingInscriptionWebPlugin$MyResultReceiver;", "Landroid/os/ResultReceiver;", "(Lcom/tencent/timi/game/web/business/impl/plugin/LivingInscriptionWebPlugin;)V", "onReceiveResult", "", QzoneIPCModule.RESULT_CODE, "", "resultData", "Landroid/os/Bundle;", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public final class MyResultReceiver extends ResultReceiver {
        public MyResultReceiver() {
            super(new Handler(Looper.getMainLooper()));
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int resultCode, @NotNull Bundle resultData) {
            Intrinsics.checkNotNullParameter(resultData, "resultData");
            super.onReceiveResult(resultCode, resultData);
            resultData.setClassLoader(ShareActionSheetV2.class.getClassLoader());
            if (resultData.getInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO) == 2 && resultCode == -1) {
                ArrayList parcelableArrayList = resultData.getParcelableArrayList(ISelectMemberActivityConstants.PARAM_RESULT_SET);
                JSONArray jSONArray = new JSONArray();
                if (parcelableArrayList != null) {
                    Iterator it = parcelableArrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.mo162put(((ResultRecord) it.next()).uin);
                    }
                }
                HashMap hashMap = new HashMap();
                hashMap.put(SquareJSConst.Params.PARAMS_UIN_LIST, jSONArray);
                LivingInscriptionWebPlugin livingInscriptionWebPlugin = LivingInscriptionWebPlugin.this;
                livingInscriptionWebPlugin.J("getRecentContactUinList", livingInscriptionWebPlugin.I(hashMap));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/web/business/impl/plugin/LivingInscriptionWebPlugin$d", "Leipc/EIPCResultCallback;", "Leipc/EIPCResult;", "result", "", "onCallback", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements EIPCResultCallback {
        d() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(@Nullable EIPCResult result) {
            HallInfo hallInfo;
            Map mapOf;
            l.h("HallServerIpcModule_", 1, "getHallInfo result:" + result);
            if (result == null) {
                LivingInscriptionWebPlugin livingInscriptionWebPlugin = LivingInscriptionWebPlugin.this;
                livingInscriptionWebPlugin.J("getHallInfo", livingInscriptionWebPlugin.H(-1, "getHallInfo ipc result is null!"));
                return;
            }
            try {
                hallInfo = (HallInfo) result.data.getParcelable("hall_info");
            } catch (Exception unused) {
                hallInfo = null;
            }
            if (hallInfo != null) {
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("ipcCode", Integer.valueOf(result.code)), TuplesKt.to("roomId", a.a(hallInfo.f376905d)), TuplesKt.to("yesGameId", Integer.valueOf(hallInfo.f376906e)));
                LivingInscriptionWebPlugin livingInscriptionWebPlugin2 = LivingInscriptionWebPlugin.this;
                livingInscriptionWebPlugin2.J("getHallInfo", livingInscriptionWebPlugin2.I(mapOf));
                l.h("HallServerIpcModule_", 1, "getHallInfo resultMap:" + mapOf);
                return;
            }
            LivingInscriptionWebPlugin livingInscriptionWebPlugin3 = LivingInscriptionWebPlugin.this;
            livingInscriptionWebPlugin3.J("getHallInfo", livingInscriptionWebPlugin3.H(-1, "getHallInfo ipc hallInfo is null!"));
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/web/business/impl/plugin/LivingInscriptionWebPlugin$e", "Lag4/i$b;", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameRoleListRsp;", "", "result", "", "errorCode", "", "errorMsg", "rsp", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements i.b<YesGameInfoOuterClass$GetUserGameRoleListRsp> {
        e() {
        }

        @Override // ag4.i.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void i(boolean result, int errorCode, @Nullable String errorMsg, @Nullable YesGameInfoOuterClass$GetUserGameRoleListRsp rsp) {
            List<YesGameInfoOuterClass$YesGameRoleAbsInfo> list;
            PBRepeatMessageField<YesGameInfoOuterClass$YesGameRoleAbsInfo> pBRepeatMessageField;
            if (!result) {
                l.e("LivingInscriptionWebPlugin", "acquireRoleList error " + errorCode + "," + errorMsg + " ");
            }
            if (rsp != null && (pBRepeatMessageField = rsp.role_list) != null) {
                list = pBRepeatMessageField.get();
            } else {
                list = null;
            }
            JSONObject a16 = oo4.b.f423274a.a(list);
            if (result) {
                errorCode = 0;
            }
            a16.put("code", errorCode);
            LivingInscriptionWebPlugin livingInscriptionWebPlugin = LivingInscriptionWebPlugin.this;
            String jSONObject = a16.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "json.toString()");
            livingInscriptionWebPlugin.J("getMySmobaRoleList", jSONObject);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/timi/game/web/business/impl/plugin/LivingInscriptionWebPlugin$f", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "", "isFollow", "", "onSuccess", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements IQQLiveCheckFollowCallback {
        f() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            LivingInscriptionWebPlugin livingInscriptionWebPlugin = LivingInscriptionWebPlugin.this;
            livingInscriptionWebPlugin.J("getRoomFollowState", livingInscriptionWebPlugin.G(errCode));
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onSuccess(int isFollow) {
            HashMap hashMap = new HashMap();
            boolean z16 = true;
            if (isFollow != 1) {
                z16 = false;
            }
            hashMap.put("isFollow", Boolean.valueOf(z16));
            LivingInscriptionWebPlugin livingInscriptionWebPlugin = LivingInscriptionWebPlugin.this;
            livingInscriptionWebPlugin.J("getRoomFollowState", livingInscriptionWebPlugin.I(hashMap));
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/web/business/impl/plugin/LivingInscriptionWebPlugin$g", "Lag4/i$b;", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "", "result", "", "errorCode", "", "errorMsg", "rsp", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class g implements i.b<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> {
        g() {
        }

        @Override // ag4.i.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void i(boolean result, int errorCode, @Nullable String errorMsg, @Nullable YesGameInfoOuterClass$GetUserGameDefaultRoleRsp rsp) {
            String str;
            YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo;
            PBStringField pBStringField;
            if (rsp != null && (yesGameInfoOuterClass$YesGameRoleInfo = rsp.role_info) != null && (pBStringField = yesGameInfoOuterClass$YesGameRoleInfo.role_name) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            boolean z16 = !TextUtils.isEmpty(str);
            JSONObject jSONObject = new JSONObject();
            if (result) {
                errorCode = 0;
            }
            jSONObject.put("code", errorCode);
            jSONObject.put("isBind", z16);
            LivingInscriptionWebPlugin livingInscriptionWebPlugin = LivingInscriptionWebPlugin.this;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
            livingInscriptionWebPlugin.J("getSmobaRoleBindStatus", jSONObject2);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/timi/game/web/business/impl/plugin/LivingInscriptionWebPlugin$h", "Lcom/tencent/timi/game/utils/IResultListener;", "", "result", "", "a", "", "errorCode", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class h implements IResultListener<String> {
        h() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String result) {
            HashMap hashMap = new HashMap();
            if (result == null) {
                result = "";
            }
            hashMap.put("rsp", result);
            LivingInscriptionWebPlugin livingInscriptionWebPlugin = LivingInscriptionWebPlugin.this;
            livingInscriptionWebPlugin.J("requestTimiServer", livingInscriptionWebPlugin.I(hashMap));
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            LivingInscriptionWebPlugin livingInscriptionWebPlugin = LivingInscriptionWebPlugin.this;
            if (errorMessage == null) {
                errorMessage = "";
            }
            livingInscriptionWebPlugin.J("requestTimiServer", livingInscriptionWebPlugin.H(errorCode, errorMessage));
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/web/business/impl/plugin/LivingInscriptionWebPlugin$k", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class k implements IQQLiveFollowCallback {
        k() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            LivingInscriptionWebPlugin livingInscriptionWebPlugin = LivingInscriptionWebPlugin.this;
            livingInscriptionWebPlugin.J("subscribeRoom", livingInscriptionWebPlugin.G(errCode));
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onSuccess() {
            LivingInscriptionWebPlugin livingInscriptionWebPlugin = LivingInscriptionWebPlugin.this;
            livingInscriptionWebPlugin.J("subscribeRoom", livingInscriptionWebPlugin.I(null));
        }
    }

    public LivingInscriptionWebPlugin() {
        po4.j.INSTANCE.a().c(this);
        l.i("LivingInscriptionWebPlugin", "LivingInscriptionWebPlugin instance create");
    }

    private final void D(List<String> argsList) {
        l.h("LivingInscriptionWebPlugin", 1, "batteryTaskStateChanged " + argsList);
        SimpleEventBus.getInstance().dispatchEvent(new RefreshBatteryOperationEvent(0L, 1, null));
        J("batteryTaskStateChanged", I(null));
    }

    private final void E(List<String> args) {
        final Activity activity;
        final JSONObject V = V(args);
        final c cVar = new c();
        final b bVar = new b();
        WebViewPlugin.b bVar2 = this.mRuntime;
        if (bVar2 != null) {
            activity = bVar2.a();
        } else {
            activity = null;
        }
        if (activity == null) {
            l.e("LivingInscriptionWebPlugin", "bindUserRole activity error " + activity + " ");
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: po4.e
            @Override // java.lang.Runnable
            public final void run() {
                LivingInscriptionWebPlugin.F(activity, V, bVar, cVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Activity activity, JSONObject requestParams, b authListener, c bindListener) {
        Intrinsics.checkNotNullParameter(requestParams, "$requestParams");
        Intrinsics.checkNotNullParameter(authListener, "$authListener");
        Intrinsics.checkNotNullParameter(bindListener, "$bindListener");
        if (activity != null) {
            HashMap hashMap = new HashMap();
            if (requestParams.has("scene")) {
                hashMap.put("caller_scene", String.valueOf(requestParams.optInt("scene")));
            }
            ((ag4.i) mm4.b.b(ag4.i.class)).N2(101, activity, Boolean.TRUE, authListener, bindListener, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String G(int code) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", code);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String H(int code, String msg2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", code);
        jSONObject.put("msg", msg2);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String I(Map<String, ? extends Object> responseParams) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", 0);
        if (responseParams != null) {
            for (Map.Entry<String, ? extends Object> entry : responseParams.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(String method, String content) {
        String str = this.callBackIdMap.get(method);
        if (str != null) {
            callJs(str, content);
        }
    }

    private final void K(String anchorId, int gameId, boolean isAnchor, String roomId, String liveUid, String nick, String headUrl, String anchorNick, String anchorHeadUrl, boolean isFromGuild) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("anchorId", anchorId);
        jSONObject.put(VirtualAppProxy.KEY_GAME_ID, gameId);
        jSONObject.put("isAnchor", isAnchor);
        jSONObject.put("roomId", roomId);
        jSONObject.put("liveUid", liveUid);
        jSONObject.put("nick", nick);
        jSONObject.put("headUrl", headUrl);
        jSONObject.put("anchorNick", anchorNick);
        jSONObject.put("anchorHeadUrl", anchorHeadUrl);
        jSONObject.put("isFromGuild", isFromGuild);
        jSONObject.put("code", 0);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        J("getLiveRoomInfo", jSONObject2);
    }

    private final void L(List<String> args) {
        JSONObject V = V(args);
        if (V.has("status")) {
            if (TextUtils.isEmpty(V.getString("status"))) {
                J("changeLiveSoundStatus", H(-1, "paramError no param status find"));
            } else if (((ni4.a) mm4.b.b(ni4.a.class)).D0(!TextUtils.equals(r6, "1"))) {
                J("changeLiveSoundStatus", I(null));
            } else {
                J("changeLiveSoundStatus", H(-1, "paramError no param status find"));
            }
        }
    }

    private final void M() {
        Activity activity;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            activity = bVar.a();
        } else {
            activity = null;
        }
        l.b("LivingInscriptionWebPlugin", "closeWebActivity " + activity);
        if (activity instanceof TimiBrowserActivity) {
            ((TimiBrowserActivity) activity).W2();
        }
    }

    private final JSONObject N(String content) {
        try {
            return new JSONObject(content);
        } catch (JSONException unused) {
            l.e("LivingInscriptionWebPlugin", "convertStringToJson error");
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject O(int code) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", code);
        return jSONObject;
    }

    private final String P(String params) {
        try {
            String optString = new JSONObject(params).optString("callback");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"callback\")");
            return optString;
        } catch (JSONException unused) {
            l.e("LivingInscriptionWebPlugin", "getCallbackId error");
            return "";
        }
    }

    private final void Q() {
        HallServerIpcModule.INSTANCE.a("get_hall_info", new Bundle(), new d());
        l.h("LivingInscriptionWebPlugin", 4, "getHallInfo running");
    }

    private final void R() {
        l.b("LivingInscriptionWebPlugin", "getLiveRoomInfo");
        LivingRoomInfo currentLivingRoomInfo = mo4.b.INSTANCE.a().getCurrentLivingRoomInfo();
        if (currentLivingRoomInfo != null) {
            K(currentLivingRoomInfo.getAnchorId(), currentLivingRoomInfo.getGameId(), currentLivingRoomInfo.getIsAnchor(), currentLivingRoomInfo.getRoomId(), currentLivingRoomInfo.getLiveUid(), currentLivingRoomInfo.getNick(), currentLivingRoomInfo.getHeadUrl(), currentLivingRoomInfo.getAnchorNick(), currentLivingRoomInfo.getAnchorHeadUrl(), currentLivingRoomInfo.getIsFromGuild());
        }
    }

    private final void S() {
        l.b("LivingInscriptionWebPlugin", "getLiveRoomReportInfo");
        LivingRoomInfo currentLivingRoomInfo = mo4.b.INSTANCE.a().getCurrentLivingRoomInfo();
        if (currentLivingRoomInfo != null && !TextUtils.isEmpty(currentLivingRoomInfo.getAnchorId()) && TextUtils.isDigitsOnly(currentLivingRoomInfo.getAnchorId())) {
            String jSONObject = oo4.a.f423273a.b(Long.parseLong(currentLivingRoomInfo.getAnchorId())).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "json.toString()");
            J("getLiveRoomReportInfo", jSONObject);
        }
    }

    private final void T() {
        ((ag4.i) mm4.b.b(ag4.i.class)).s3(101, new e());
    }

    private final void U() {
        Activity a16;
        Activity a17;
        Intent intent = new Intent();
        intent.putExtra("direct_send_if_dataline_forward", true);
        intent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity");
        intent.putExtra("forward_source_business_type", -1);
        intent.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 2);
        intent.putExtra("PARAM_ActivityResultReceiver", new MyResultReceiver());
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (a17 = bVar.a()) != null) {
            a17.startActivity(intent);
        }
        WebViewPlugin.b bVar2 = this.mRuntime;
        if (bVar2 != null && (a16 = bVar2.a()) != null) {
            a16.overridePendingTransition(0, 0);
        }
    }

    private final JSONObject V(List<String> args) {
        if (g0(args.get(0))) {
            return N(args.get(0));
        }
        if (g0(args.get(args.size() - 1))) {
            return N(args.get(args.size() - 1));
        }
        return new JSONObject();
    }

    private final void W(List<String> args) {
        IQQLiveFollowMsgService iQQLiveFollowMsgService;
        JSONObject V = V(args);
        if (V.has("roomId") && V.has("anchorId")) {
            IQQLiveSDK f16 = ((jg4.b) mm4.b.b(jg4.b.class)).f();
            if (f16 != null) {
                iQQLiveFollowMsgService = f16.getFollowMsgService();
            } else {
                iQQLiveFollowMsgService = null;
            }
            if (iQQLiveFollowMsgService == null) {
                return;
            }
            TGLiveFollowManager.f377684a.f(iQQLiveFollowMsgService, V.getLong("anchorId"), new f());
        }
    }

    private final void X() {
        ((ag4.i) mm4.b.b(ag4.i.class)).m2(101, new g());
    }

    private final void Y(List<String> argsList) {
        final long j3;
        Long longOrNull;
        long j16;
        Long longOrNull2;
        long j17;
        l.i("LivingInscriptionWebPlugin", "getStatusTime :" + argsList);
        JSONObject V = V(argsList);
        String optString = V.optString("roomId");
        Intrinsics.checkNotNullExpressionValue(optString, "requestParams.optString(\"roomId\")");
        ULong uLongOrNull = UStringsKt.toULongOrNull(optString);
        if (uLongOrNull != null) {
            j3 = uLongOrNull.getData();
        } else {
            j3 = 0;
        }
        final Ref.LongRef longRef = new Ref.LongRef();
        String optString2 = V.optString("startTime");
        Intrinsics.checkNotNullExpressionValue(optString2, "requestParams.optString(\"startTime\")");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(optString2);
        if (longOrNull != null) {
            j16 = longOrNull.longValue();
        } else {
            j16 = 0;
        }
        longRef.element = j16;
        final Ref.LongRef longRef2 = new Ref.LongRef();
        String optString3 = V.optString("endTime");
        Intrinsics.checkNotNullExpressionValue(optString3, "requestParams.optString(\"endTime\")");
        longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(optString3);
        if (longOrNull2 != null) {
            j17 = longOrNull2.longValue();
        } else {
            j17 = 0;
        }
        longRef2.element = j17;
        long j18 = longRef.element;
        if (j18 > 0 && j17 > 0 && j3 != 0) {
            w.a(new Runnable() { // from class: po4.b
                @Override // java.lang.Runnable
                public final void run() {
                    LivingInscriptionWebPlugin.Z(j3, longRef, longRef2, this);
                }
            });
            return;
        }
        J("getStayTimeByRoomId", H(-1, "param error,startTime :" + j18 + " ,endTime :" + j17 + ",roomId:" + j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(final long j3, final Ref.LongRef startTime, final Ref.LongRef endTime, final LivingInscriptionWebPlugin this$0) {
        Intrinsics.checkNotNullParameter(startTime, "$startTime");
        Intrinsics.checkNotNullParameter(endTime, "$endTime");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((hi4.b) mm4.b.b(hi4.b.class)).d3(new hi4.a() { // from class: po4.g
            @Override // hi4.a
            public final void a(boolean z16) {
                LivingInscriptionWebPlugin.a0(j3, startTime, endTime, this$0, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(long j3, Ref.LongRef startTime, Ref.LongRef endTime, LivingInscriptionWebPlugin this$0, boolean z16) {
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(startTime, "$startTime");
        Intrinsics.checkNotNullParameter(endTime, "$endTime");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("duration", String.valueOf(wi4.a.f445705a.d(j3, startTime.element, endTime.element, false))));
        this$0.J("getStayTimeByRoomId", this$0.I(mapOf));
    }

    private final void b0(List<String> argsList) {
        Long longOrNull;
        long j3;
        Long longOrNull2;
        long j16;
        l.i("LivingInscriptionWebPlugin", "getStatusTimeAll :" + argsList);
        JSONObject V = V(argsList);
        final Ref.LongRef longRef = new Ref.LongRef();
        String optString = V.optString("startTime");
        Intrinsics.checkNotNullExpressionValue(optString, "requestParams.optString(\"startTime\")");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(optString);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        longRef.element = j3;
        final Ref.LongRef longRef2 = new Ref.LongRef();
        String optString2 = V.optString("endTime");
        Intrinsics.checkNotNullExpressionValue(optString2, "requestParams.optString(\"endTime\")");
        longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(optString2);
        if (longOrNull2 != null) {
            j16 = longOrNull2.longValue();
        } else {
            j16 = 0;
        }
        longRef2.element = j16;
        long j17 = longRef.element;
        if (j17 > 0 && j16 > 0) {
            w.a(new Runnable() { // from class: po4.a
                @Override // java.lang.Runnable
                public final void run() {
                    LivingInscriptionWebPlugin.c0(Ref.LongRef.this, longRef2, this);
                }
            });
            return;
        }
        J("getStayTimeAll", H(-1, "param error,startTime :" + j17 + " ,endTime :" + j16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(final Ref.LongRef startTime, final Ref.LongRef endTime, final LivingInscriptionWebPlugin this$0) {
        Intrinsics.checkNotNullParameter(startTime, "$startTime");
        Intrinsics.checkNotNullParameter(endTime, "$endTime");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((hi4.b) mm4.b.b(hi4.b.class)).d3(new hi4.a() { // from class: po4.h
            @Override // hi4.a
            public final void a(boolean z16) {
                LivingInscriptionWebPlugin.d0(Ref.LongRef.this, endTime, this$0, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(Ref.LongRef startTime, Ref.LongRef endTime, LivingInscriptionWebPlugin this$0, boolean z16) {
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(startTime, "$startTime");
        Intrinsics.checkNotNullParameter(endTime, "$endTime");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("duration", String.valueOf(wi4.a.f445705a.d(0L, startTime.element, endTime.element, false))));
        this$0.J("getStayTimeAll", this$0.I(mapOf));
    }

    private final void e0(List<String> args) {
        boolean z16;
        Map<String, ? extends Object> mapOf;
        String taskId = V(args).optString("additionInfoKey");
        if (taskId != null && taskId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            J("getTaskAdditionInfo", H(-1, "additionInfoKey is null!"));
            return;
        }
        LiveLotteryTaskDataManager liveLotteryTaskDataManager = LiveLotteryTaskDataManager.f380318a;
        Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("additionInfo", liveLotteryTaskDataManager.b(taskId)));
        J("getTaskAdditionInfo", I(mapOf));
    }

    private final void f0(int yesGameId) {
        Activity activity;
        int i3;
        Map<String, ? extends Object> mapOf;
        l.h("LivingInscriptionWebPlugin", 1, "openGameApp yesGameId:" + yesGameId);
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            activity = bVar.a();
        } else {
            activity = null;
        }
        if (hg4.d.o(yesGameId, activity)) {
            i3 = 0;
        } else {
            i3 = -1;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("launchResult", Integer.valueOf(i3)));
        J("openGameApp", I(mapOf));
        l.h("LivingInscriptionWebPlugin", 1, "openGameApp resultMap:" + mapOf);
    }

    private final boolean g0(String arg) {
        try {
            new JSONObject(arg);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private final void i0(List<String> args) {
        SimpleEventBus.getInstance().dispatchEvent(new LivingRaceNativeEvent(mo4.a.f417109a.a(), args.get(0)));
    }

    private final void j0(List<String> args) {
        l.i("LivingInscriptionWebPlugin", "openGameApp :" + args);
        final int optInt = V(args).optInt(VirtualAppProxy.KEY_GAME_ID);
        ((hi4.b) mm4.b.b(hi4.b.class)).d3(new hi4.a() { // from class: po4.c
            @Override // hi4.a
            public final void a(boolean z16) {
                LivingInscriptionWebPlugin.k0(LivingInscriptionWebPlugin.this, optInt, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(final LivingInscriptionWebPlugin this$0, final int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: po4.i
            @Override // java.lang.Runnable
            public final void run() {
                LivingInscriptionWebPlugin.l0(LivingInscriptionWebPlugin.this, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(LivingInscriptionWebPlugin this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f0(i3);
    }

    private final void n0(List<String> args) {
        JSONObject V = V(args);
        if (V.has(VirtualAppProxy.KEY_GAME_ID)) {
            GameCoreServiceImpl.INSTANCE.a().m2(V.getInt(VirtualAppProxy.KEY_GAME_ID), new i.b() { // from class: po4.d
                @Override // ag4.i.b
                public final void i(boolean z16, int i3, String str, Object obj) {
                    LivingInscriptionWebPlugin.o0(LivingInscriptionWebPlugin.this, z16, i3, str, (YesGameInfoOuterClass$GetUserGameDefaultRoleRsp) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(LivingInscriptionWebPlugin this$0, boolean z16, int i3, String str, YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (yesGameInfoOuterClass$GetUserGameDefaultRoleRsp != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("smobaGameRoleAbsInfo", oo4.b.f423274a.b(yesGameInfoOuterClass$GetUserGameDefaultRoleRsp.role_info));
            this$0.J("queryCurrentBindRole", this$0.I(hashMap));
            return;
        }
        this$0.J("queryCurrentBindRole", this$0.G(-1));
    }

    private final void p0(List<String> argsList) {
        l.i("LivingInscriptionWebPlugin", "requestServer :" + argsList);
        JSONObject V = V(argsList);
        final int optInt = V.optInt("cmd");
        final String optString = V.optString("req");
        if (optString == null) {
            optString = "";
        }
        ((hi4.b) mm4.b.b(hi4.b.class)).d3(new hi4.a() { // from class: po4.f
            @Override // hi4.a
            public final void a(boolean z16) {
                LivingInscriptionWebPlugin.q0(optInt, optString, this, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(int i3, String req, LivingInscriptionWebPlugin this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pl4.b.e(i3, req, new h());
    }

    private final void r0(List<String> args) {
        JSONObject V = V(args);
        if (V.has("danmuMsg") && V.has("roomId")) {
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            long j3 = V.getLong("roomId");
            String string = V.getString("danmuMsg");
            Intrinsics.checkNotNullExpressionValue(string, "requestParams.getString(\"danmuMsg\")");
            simpleEventBus.dispatchEvent(new AudienceInputEvent(j3, string));
        }
    }

    private final void s0(List<String> args) {
        JSONObject V = V(args);
        if (V.has("text")) {
            if (((ni4.a) mm4.b.b(ni4.a.class)).n0(V.getString("text"))) {
                J("sendLocalFakeLiveMessage", I(null));
                return;
            } else {
                J("sendLocalFakeLiveMessage", H(-9, "room not exit"));
                return;
            }
        }
        J("sendLocalFakeLiveMessage", H(-1, "paramError no param status find"));
    }

    private final void t0(List<String> args) {
        boolean z16;
        JSONObject V = V(args);
        String taskId = V.optString(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
        int optInt = V.optInt("participateState");
        if (taskId != null && taskId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            J("setTaskParticipateState", H(-1, "taskId is null!"));
            return;
        }
        LiveLotteryTaskDataManager liveLotteryTaskDataManager = LiveLotteryTaskDataManager.f380318a;
        Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
        liveLotteryTaskDataManager.k(taskId, optInt);
        J("setTaskParticipateState", I(null));
    }

    private final void u0(List<String> args) {
        Activity activity;
        JSONObject V = V(args);
        if (V.has(VirtualAppProxy.KEY_GAME_ID)) {
            WebViewPlugin.b bVar = this.mRuntime;
            Activity activity2 = null;
            if (bVar != null) {
                activity = bVar.a();
            } else {
                activity = null;
            }
            if (activity != null) {
                HashMap hashMap = new HashMap();
                if (V.has("scene")) {
                    hashMap.put("caller_scene", String.valueOf(V.optInt("scene")));
                }
                j jVar = new j();
                ag4.i iVar = (ag4.i) mm4.b.b(ag4.i.class);
                int i3 = V.getInt(VirtualAppProxy.KEY_GAME_ID);
                WebViewPlugin.b bVar2 = this.mRuntime;
                if (bVar2 != null) {
                    activity2 = bVar2.a();
                }
                iVar.q1(i3, activity2, Boolean.TRUE, jVar, new i(), hashMap);
            }
        }
    }

    private final void v0(List<String> args) {
        IQQLiveFollowMsgService iQQLiveFollowMsgService;
        JSONObject V = V(args);
        if (V.has("roomId") && V.has("anchorId")) {
            IQQLiveSDK f16 = ((jg4.b) mm4.b.b(jg4.b.class)).f();
            if (f16 != null) {
                iQQLiveFollowMsgService = f16.getFollowMsgService();
            } else {
                iQQLiveFollowMsgService = null;
            }
            IQQLiveFollowMsgService iQQLiveFollowMsgService2 = iQQLiveFollowMsgService;
            if (iQQLiveFollowMsgService2 != null) {
                TGLiveFollowManager.f377684a.h(iQQLiveFollowMsgService2, V.getLong("anchorId"), V.getLong("roomId"), new k());
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NotNull
    public String getNameSpace() {
        return "timiEsports";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(@Nullable JsBridgeListener listener, @Nullable String url, @Nullable String pkgName, @Nullable String method, @NotNull String... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (!Intrinsics.areEqual("timiEsports", pkgName)) {
            return false;
        }
        l.i("LivingInscriptionWebPlugin", "handleJsRequest " + url + "," + pkgName + "," + method + "," + args);
        ArrayList arrayList = new ArrayList();
        int length = args.length;
        for (int i3 = 0; i3 < length; i3++) {
            String str = args[i3];
            if (str != null) {
                arrayList.add(str);
            }
        }
        if (args.length > 0 && method != null) {
            this.callBackIdMap.put(method, P(args[0]));
        }
        if (method != null) {
            switch (method.hashCode()) {
                case -1345994139:
                    if (method.equals("notifyNativeTask")) {
                        i0(arrayList);
                        return true;
                    }
                    break;
                case -1192714714:
                    if (method.equals("getMySmobaRoleList")) {
                        T();
                        return true;
                    }
                    break;
                case -1005817941:
                    if (method.equals("getLiveRoomInfo")) {
                        R();
                        return true;
                    }
                    break;
                case -904048187:
                    if (method.equals("getStayTimeAll")) {
                        b0(arrayList);
                        return true;
                    }
                    break;
                case -682213116:
                    if (method.equals("queryCurrentBindRole")) {
                        n0(arrayList);
                        break;
                    }
                    break;
                case -652106884:
                    if (method.equals("doSmobaRoleBind")) {
                        E(arrayList);
                        return true;
                    }
                    break;
                case -392461531:
                    if (method.equals("openGameApp")) {
                        j0(arrayList);
                        return true;
                    }
                    break;
                case -326267585:
                    if (method.equals("getLiveRoomReportInfo")) {
                        S();
                        return true;
                    }
                    break;
                case -255363195:
                    if (method.equals("changeLiveSoundStatus")) {
                        L(arrayList);
                        return true;
                    }
                    break;
                case -205682843:
                    if (method.equals("getTaskAdditionInfo")) {
                        e0(arrayList);
                        return true;
                    }
                    break;
                case 60018569:
                    if (method.equals("getRecentContactUinList")) {
                        U();
                        break;
                    }
                    break;
                case 94756344:
                    if (method.equals("close")) {
                        M();
                        return true;
                    }
                    break;
                case 327867002:
                    if (method.equals("setTaskParticipateState")) {
                        t0(arrayList);
                        return true;
                    }
                    break;
                case 421807011:
                    if (method.equals("sendLocalFakeLiveMessage")) {
                        s0(arrayList);
                        return true;
                    }
                    break;
                case 979570147:
                    if (method.equals("getSmobaRoleBindStatus")) {
                        X();
                        return true;
                    }
                    break;
                case 1251979599:
                    if (method.equals("getRoomFollowState")) {
                        W(arrayList);
                        return true;
                    }
                    break;
                case 1298691427:
                    if (method.equals("requestTimiServer")) {
                        p0(arrayList);
                        return true;
                    }
                    break;
                case 1331020597:
                    if (method.equals("batteryTaskStateChanged")) {
                        D(arrayList);
                        return true;
                    }
                    break;
                case 1572019525:
                    if (method.equals("subscribeRoom")) {
                        v0(arrayList);
                        break;
                    }
                    break;
                case 2029064701:
                    if (method.equals("getHallInfo")) {
                        Q();
                        return true;
                    }
                    break;
                case 2050783465:
                    if (method.equals("getStayTimeByRoomId")) {
                        Y(arrayList);
                        return true;
                    }
                    break;
                case 2051644272:
                    if (method.equals("sendDanmuMsg")) {
                        r0(arrayList);
                        break;
                    }
                    break;
                case 2062116141:
                    if (method.equals("showRoleSelectList")) {
                        u0(arrayList);
                        break;
                    }
                    break;
            }
        }
        return super.handleJsRequest(listener, url, pkgName, method, (String[]) Arrays.copyOf(args, args.length));
    }

    public final boolean m0(@NotNull LivingRaceNativeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Object data = event.getData();
        if (Intrinsics.areEqual("live_trigge_race_model_type", event.getEventName())) {
            if (data instanceof String) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AdMetricTag.EVENT_NAME, data);
                jSONObject.put("code", 0);
                dispatchJsEvent(f380336h, jSONObject, new JSONObject());
                l.i("LivingInscriptionWebPlugin", "processEventFromNative : GET_TRIGGERED_BY_NATIVE_METHOD");
            }
            return true;
        }
        if (!Intrinsics.areEqual("live_race_change_model_type", event.getEventName())) {
            return false;
        }
        if (data instanceof String) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", data);
            jSONObject2.put("code", 0);
            dispatchJsEvent(f380335f, jSONObject2, new JSONObject());
        }
        return true;
    }

    public final void w0(boolean hidden) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("hidden", hidden);
        dispatchJsEvent(f380337i, jSONObject, new JSONObject());
        l.i("LivingInscriptionWebPlugin", "tabVisibilityChange hidden : " + hidden);
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/timi/game/web/business/impl/plugin/LivingInscriptionWebPlugin$b", "Lag4/i$a;", "", "c", "Ltrpc/yes/common/GameAuthOuterClass$AgreeGameAuthRsp;", "gameAuthRsp", "g", "f", "", "errorCode", "", "errorMsg", "d", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements i.a {
        b() {
        }

        @Override // ag4.i.a
        public void d(int errorCode, @Nullable String errorMsg) {
            LivingInscriptionWebPlugin livingInscriptionWebPlugin = LivingInscriptionWebPlugin.this;
            String jSONObject = livingInscriptionWebPlugin.O(-1).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "errorJson(COMMON_ERROR).toString()");
            livingInscriptionWebPlugin.J("doSmobaRoleBind", jSONObject);
        }

        @Override // ag4.i.a
        public void f() {
            LivingInscriptionWebPlugin livingInscriptionWebPlugin = LivingInscriptionWebPlugin.this;
            String jSONObject = livingInscriptionWebPlugin.O(-2).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "errorJson(COMMON_CANCEL).toString()");
            livingInscriptionWebPlugin.J("doSmobaRoleBind", jSONObject);
        }

        @Override // ag4.i.c
        public void c() {
        }

        @Override // ag4.i.a
        public void g(@Nullable GameAuthOuterClass$AgreeGameAuthRsp gameAuthRsp) {
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/timi/game/web/business/impl/plugin/LivingInscriptionWebPlugin$c", "Lag4/i$d;", "", "b", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "selectedDefaultAccount", "a", "", "errorCode", "", "errorMsg", "e", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements i.d {
        c() {
        }

        @Override // ag4.i.d
        public void a(@NotNull YesGameInfoOuterClass$GetUserGameDefaultRoleRsp selectedDefaultAccount) {
            Intrinsics.checkNotNullParameter(selectedDefaultAccount, "selectedDefaultAccount");
            l.i("LivingInscriptionWebPlugin", "showSmobaAccountSelectDialog bindSucceed ");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 0);
            jSONObject.put("isBind", true);
            LivingInscriptionWebPlugin livingInscriptionWebPlugin = LivingInscriptionWebPlugin.this;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
            livingInscriptionWebPlugin.J("doSmobaRoleBind", jSONObject2);
        }

        @Override // ag4.i.d
        public void b() {
            l.i("LivingInscriptionWebPlugin", "showSmobaAccountSelectDialog bindCancel ");
            LivingInscriptionWebPlugin livingInscriptionWebPlugin = LivingInscriptionWebPlugin.this;
            String jSONObject = livingInscriptionWebPlugin.O(-2).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "errorJson(COMMON_CANCEL).toString()");
            livingInscriptionWebPlugin.J("doSmobaRoleBind", jSONObject);
        }

        @Override // ag4.i.d
        public void e(int errorCode, @Nullable String errorMsg) {
            LivingInscriptionWebPlugin livingInscriptionWebPlugin = LivingInscriptionWebPlugin.this;
            String jSONObject = livingInscriptionWebPlugin.O(-1).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "errorJson(COMMON_ERROR).toString()");
            livingInscriptionWebPlugin.J("doSmobaRoleBind", jSONObject);
        }

        @Override // ag4.i.c
        public void c() {
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/timi/game/web/business/impl/plugin/LivingInscriptionWebPlugin$i", "Lag4/i$d;", "", "c", "b", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "getUserGameDefaultRoleRsp", "a", "", "errorCode", "", "errorMsg", "e", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class i implements i.d {
        i() {
        }

        @Override // ag4.i.d
        public void a(@Nullable YesGameInfoOuterClass$GetUserGameDefaultRoleRsp getUserGameDefaultRoleRsp) {
            YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo;
            HashMap hashMap = new HashMap();
            oo4.b bVar = oo4.b.f423274a;
            if (getUserGameDefaultRoleRsp != null) {
                yesGameInfoOuterClass$YesGameRoleInfo = getUserGameDefaultRoleRsp.role_info;
            } else {
                yesGameInfoOuterClass$YesGameRoleInfo = null;
            }
            hashMap.put("smobaGameRoleAbsInfo", bVar.b(yesGameInfoOuterClass$YesGameRoleInfo));
            LivingInscriptionWebPlugin livingInscriptionWebPlugin = LivingInscriptionWebPlugin.this;
            livingInscriptionWebPlugin.J("showRoleSelectList", livingInscriptionWebPlugin.I(hashMap));
        }

        @Override // ag4.i.d
        public void b() {
            LivingInscriptionWebPlugin livingInscriptionWebPlugin = LivingInscriptionWebPlugin.this;
            String jSONObject = livingInscriptionWebPlugin.O(-2).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "errorJson(COMMON_CANCEL).toString()");
            livingInscriptionWebPlugin.J("showRoleSelectList", jSONObject);
        }

        @Override // ag4.i.c
        public void c() {
        }

        @Override // ag4.i.d
        public void e(int errorCode, @Nullable String errorMsg) {
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/timi/game/web/business/impl/plugin/LivingInscriptionWebPlugin$j", "Lag4/i$a;", "", "c", "Ltrpc/yes/common/GameAuthOuterClass$AgreeGameAuthRsp;", "gameAuthRsp", "g", "f", "", "errorCode", "", "errorMsg", "d", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class j implements i.a {
        j() {
        }

        @Override // ag4.i.a
        public void d(int errorCode, @Nullable String errorMsg) {
            LivingInscriptionWebPlugin livingInscriptionWebPlugin = LivingInscriptionWebPlugin.this;
            String jSONObject = livingInscriptionWebPlugin.O(-1).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "errorJson(COMMON_ERROR).toString()");
            livingInscriptionWebPlugin.J("showRoleSelectList", jSONObject);
        }

        @Override // ag4.i.a
        public void f() {
            LivingInscriptionWebPlugin livingInscriptionWebPlugin = LivingInscriptionWebPlugin.this;
            String jSONObject = livingInscriptionWebPlugin.O(-2).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "errorJson(COMMON_CANCEL).toString()");
            livingInscriptionWebPlugin.J("showRoleSelectList", jSONObject);
        }

        @Override // ag4.i.c
        public void c() {
        }

        @Override // ag4.i.a
        public void g(@Nullable GameAuthOuterClass$AgreeGameAuthRsp gameAuthRsp) {
        }
    }
}
