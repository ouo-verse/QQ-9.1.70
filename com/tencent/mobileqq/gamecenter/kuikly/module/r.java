package com.tencent.mobileqq.gamecenter.kuikly.module;

import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.AnchorPointContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J5\u0010\u0011\u001a\u00020\u00022+\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nj\u0004\u0018\u0001`\u000fH\u0002J5\u0010\u0012\u001a\u00020\u00022+\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nj\u0004\u0018\u0001`\u000fH\u0002J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J5\u0010\u001b\u001a\u00020\u00022+\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nj\u0004\u0018\u0001`\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004H\u0002JI\u0010$\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00042+\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nj\u0004\u0018\u0001`\u000fH\u0016\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/kuikly/module/r;", "Li01/e;", "", "w", "", "uid", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "isTop", "y", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "B", "u", "Lgd1/a;", "gInfo", "Lcom/tencent/mobileqq/activity/recent/gamemsgbox/data/GameBoxRecentUser;", "gRecentUser", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "contactInfo", "Lorg/json/JSONObject;", "l", "t", "Lmqq/app/AppRuntime;", "p", "Lcom/tencent/qqnt/kernel/api/aa;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "peerUid", "r", "method", "params", "call", "<init>", "()V", "d", "a", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class r extends i01.e {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/gamecenter/kuikly/module/r$b", "Lk71/a;", "", "onLoadSuccess", "onLoadFailed", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements k71.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f212136b;

        b(Function1<Object, Unit> function1) {
            this.f212136b = function1;
        }

        @Override // k71.a
        public void onLoadFailed() {
            QLog.i("QQGameMsgKuiklyModule", 1, "[onLoadFailed]");
            r.this.u(this.f212136b);
        }

        @Override // k71.a
        public void onLoadSuccess() {
            QLog.i("QQGameMsgKuiklyModule", 1, "[onLoadSuccess]");
            r.this.u(this.f212136b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i("QQGameMsgKuiklyModule", 1, "topGameSession, result=" + i3 + ", errMsg=" + errMsg);
    }

    private final void B(Function1<Object, Unit> callback) {
        QLog.i("QQGameMsgKuiklyModule", 1, "[getSessionList]");
        IRuntimeService runtimeService = p().getRuntimeService(IGameMsgBoxManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026va, ProcessConstant.MAIN)");
        IGameMsgBoxManager iGameMsgBoxManager = (IGameMsgBoxManager) runtimeService;
        iGameMsgBoxManager.tryUpdateGameMsgInfoFromRecentUser();
        iGameMsgBoxManager.resetNTLoadRemoteUserList();
        iGameMsgBoxManager.fetchRecentGameContacts(false, new b(callback), 2);
    }

    private final JSONObject l(gd1.a gInfo, GameBoxRecentUser gRecentUser, RecentContactInfo contactInfo) {
        try {
            GameSwitchConfig findGameSwitchConfigFromMemoryCache = ((IGameMsgManagerService) p().getRuntimeService(IGameMsgManagerService.class, "")).findGameSwitchConfigFromMemoryCache(gInfo.f401939c);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("level_text", gInfo.f401944h);
            JSONObject put = jSONObject.put("level_pic", gInfo.f401943g);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appid", gInfo.f401939c);
            jSONObject2.put("medal_jump", gInfo.f401957u);
            jSONObject2.put("mutex_switch", findGameSwitchConfigFromMemoryCache.mMuteSwitch);
            jSONObject2.put("online_desc", gInfo.a());
            jSONObject2.put("sex", gInfo.f401945i);
            jSONObject2.put("icon", gInfo.f401948l);
            jSONObject2.put("toOpenId", gRecentUser.mToOpenId);
            jSONObject2.put("sessionId", gRecentUser.mConvertUin);
            jSONObject2.put("msg_max_len", gInfo.f401952p);
            jSONObject2.put("name", gInfo.f401947k);
            jSONObject2.put("online_type", gInfo.f401946j);
            jSONObject2.put("medal_url", gInfo.f401956t);
            jSONObject2.put("box_switch", findGameSwitchConfigFromMemoryCache.mBoxSwitch);
            jSONObject2.put("uid", contactInfo.getPeerUid());
            jSONObject2.put("qq_block_switch", findGameSwitchConfigFromMemoryCache.mBlockSwitch);
            jSONObject2.put("growth_rank_jump", gInfo.f401955s);
            jSONObject2.put("nick", gInfo.f401941e);
            jSONObject2.put("partition_name", gInfo.f401942f);
            jSONObject2.put(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, findGameSwitchConfigFromMemoryCache.mSyncSwitch);
            jSONObject2.put("data_update_ts", gInfo.f401958v);
            jSONObject2.put("uin", contactInfo.getSenderUin());
            jSONObject2.put("face_url", gInfo.f401940d);
            jSONObject2.put("viprank_url", gInfo.f401953q);
            jSONObject2.put("role_id", gInfo.f401937a);
            jSONObject2.put("msgsync_switch", gInfo.f401949m);
            JSONObject result = jSONObject2.put("growth_rank_url", gInfo.f401954r);
            result.put("game_profile", put);
            Intrinsics.checkNotNullExpressionValue(result, "result");
            return result;
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    private final void m(final String uid) {
        QRouteApi api = QRoute.api(IGameMsgNtApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGameMsgNtApi::class.java)");
        final IGameMsgNtApi iGameMsgNtApi = (IGameMsgNtApi) api;
        iGameMsgNtApi.fetchGameRecentContactInfo(new AnchorPointContactInfo(), true, 200, new IOperateCallback() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.p
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                r.o(IGameMsgNtApi.this, uid, this, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(IGameMsgNtApi msgNtApi, String uid, r this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(msgNtApi, "$msgNtApi");
        Intrinsics.checkNotNullParameter(uid, "$uid");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        for (RecentContactInfo recentContactInfo : msgNtApi.getGameRecentContactList()) {
            if (Intrinsics.areEqual(uid, recentContactInfo.getPeerUid())) {
                ArrayList<Contact> arrayList = new ArrayList<>();
                arrayList.add(new Contact(recentContactInfo.chatType, recentContactInfo.peerUid, ex3.a.f(recentContactInfo)));
                aa q16 = this$0.q();
                if (q16 != null) {
                    q16.a0(arrayList, null);
                    return;
                }
                return;
            }
        }
    }

    private final AppRuntime p() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
            Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime()");
            return waitAppRuntime;
        }
        return peekAppRuntime;
    }

    private final aa q() {
        AppRuntime p16 = p();
        IRuntimeService runtimeService = p16.getRuntimeService(IKernelService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026va, ProcessConstant.MAIN)");
        IKernelService iKernelService = (IKernelService) runtimeService;
        aa recentContactService = iKernelService.getRecentContactService();
        if (recentContactService == null) {
            QLog.i("QQGameMsgKuiklyModule", 1, "appRuntime: " + p16.hashCode() + " kernelService: " + iKernelService.hashCode() + " getService == null");
        }
        return recentContactService;
    }

    private final String r(String peerUid) {
        List split$default;
        List split$default2;
        split$default = StringsKt__StringsKt.split$default((CharSequence) peerUid, new String[]{PeerUid.BIDIRECTION_TINY_ID_PERFIX}, false, 0, 6, (Object) null);
        if (split$default.size() == 2) {
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(1), new String[]{"_"}, false, 0, 6, (Object) null);
            if (split$default2.size() != 2) {
                return "";
            }
            try {
                return ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).createConvertUinFromTinyId(Long.parseLong((String) split$default2.get(0)), Long.parseLong((String) split$default2.get(1)));
            } catch (NumberFormatException e16) {
                QLog.e("QQGameMsgKuiklyModule", 1, e16.getMessage(), e16);
                return "";
            }
        }
        return "";
    }

    private final void t(Function1<Object, Unit> callback) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        List<com.tencent.mobileqq.gamecenter.data.n> recentPartnerList = ((IGameMsgManagerService) p().getRuntimeService(IGameMsgManagerService.class, "")).getRecentPartnerList();
        if (recentPartnerList != null) {
            for (com.tencent.mobileqq.gamecenter.data.n nVar : recentPartnerList) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appId", nVar.getGameAppId());
                jSONObject2.put("fromRoleId", nVar.getFromRoleId());
                jSONObject2.put("toRoleId", nVar.getToRoleId());
                jSONObject2.put("fromOpenaioId", nVar.getFromOpenAioId());
                jSONObject2.put("toOpenaioId", nVar.getToOpenAioId());
                jSONObject2.put("status", nVar.getCom.tencent.mobileqq.shortvideo.ShortVideoConstants.PARAM_KEY_SESSION_TYPE java.lang.String());
                jSONObject2.put("lastMsgTime", nVar.getLastMsgTime());
                jSONObject2.put("toNick", nVar.getNickname());
                jSONObject2.put("toIconUrl", nVar.getCom.qzone.album.data.model.PhotoCategorySummaryInfo.AVATAR_URL java.lang.String());
                jSONArray.mo162put(jSONObject2.put("toOnlineState", nVar.getStatus()));
            }
        }
        jSONObject.put("result", jSONArray);
        if (callback != null) {
            callback.invoke(jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(final Function1<Object, Unit> callback) {
        QRouteApi api = QRoute.api(IGameMsgNtApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGameMsgNtApi::class.java)");
        final IGameMsgNtApi iGameMsgNtApi = (IGameMsgNtApi) api;
        iGameMsgNtApi.fetchGameRecentContactInfo(new AnchorPointContactInfo(), true, 200, new IOperateCallback() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.o
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                r.v(IGameMsgNtApi.this, callback, this, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(IGameMsgNtApi msgNtApi, Function1 function1, r this$0, int i3, String str) {
        Integer num;
        boolean z16;
        Intrinsics.checkNotNullParameter(msgNtApi, "$msgNtApi");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<RecentContactInfo> gameRecentContactList = msgNtApi.getGameRecentContactList();
        if (gameRecentContactList != null) {
            num = Integer.valueOf(gameRecentContactList.size());
        } else {
            num = null;
        }
        QLog.i("QQGameMsgKuiklyModule", 1, "contactL.size:" + num);
        JSONObject jSONObject = new JSONObject();
        List<RecentContactInfo> list = gameRecentContactList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.i("QQGameMsgKuiklyModule", 1, "chat list is empty++++++++++");
            if (function1 != null) {
                function1.invoke(jSONObject.toString());
                return;
            }
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (RecentContactInfo recentContactInfo : gameRecentContactList) {
            String peerUid = recentContactInfo.getPeerUid();
            Intrinsics.checkNotNullExpressionValue(peerUid, "chatItem.getPeerUid()");
            String r16 = this$0.r(peerUid);
            gd1.a findGameDetailInfoByConvertUin = ((IGameMsgBoxManager) this$0.p().getRuntimeService(IGameMsgBoxManager.class, "")).findGameDetailInfoByConvertUin(r16);
            GameBoxRecentUser recentUsrInfo = ((IGameMsgBoxManager) this$0.p().getRuntimeService(IGameMsgBoxManager.class, "")).findGameBoxRecentUserInfo(r16);
            Intrinsics.checkNotNullExpressionValue(recentUsrInfo, "recentUsrInfo");
            jSONArray.mo162put(this$0.l(findGameDetailInfoByConvertUin, recentUsrInfo, recentContactInfo));
        }
        jSONObject.put("result", jSONArray);
        if (function1 != null) {
            function1.invoke(jSONObject.toString());
        }
    }

    private final void w() {
        IKernelService iKernelService;
        w msgService;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        if (waitAppRuntime != null && (iKernelService = (IKernelService) waitAppRuntime.getRuntimeService(IKernelService.class, "")) != null && (msgService = iKernelService.getMsgService()) != null) {
            msgService.setMsgRead(new Contact(116, "", ""), new IOperateCallback() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.m
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    r.x(r.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(r this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QQGameMsgKuiklyModule", 1, "setBoxMsgRead,code=" + i3 + ",msg=" + str);
    }

    private final void y(final String uid, final boolean isTop) {
        QRouteApi api = QRoute.api(IGameMsgNtApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGameMsgNtApi::class.java)");
        final IGameMsgNtApi iGameMsgNtApi = (IGameMsgNtApi) api;
        iGameMsgNtApi.fetchGameRecentContactInfo(new AnchorPointContactInfo(), true, 200, new IOperateCallback() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.n
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                r.z(IGameMsgNtApi.this, uid, isTop, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(IGameMsgNtApi msgNtApi, String uid, boolean z16, int i3, String str) {
        w wVar;
        IKernelService iKernelService;
        Intrinsics.checkNotNullParameter(msgNtApi, "$msgNtApi");
        Intrinsics.checkNotNullParameter(uid, "$uid");
        for (RecentContactInfo recentContactInfo : msgNtApi.getGameRecentContactList()) {
            if (Intrinsics.areEqual(uid, recentContactInfo.getPeerUid())) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null) {
                    wVar = iKernelService.getMsgService();
                } else {
                    wVar = null;
                }
                if (wVar == null) {
                    QLog.e("QQGameMsgKuiklyModule", 1, "topGameSession fail, service is null");
                    return;
                }
                wVar.setContactLocalTop(new Contact(recentContactInfo.chatType, uid, ""), z16, new IOperateCallback() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.q
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i16, String str2) {
                        r.A(i16, str2);
                    }
                });
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0053 A[Catch: all -> 0x00b8, TRY_ENTER, TryCatch #0 {all -> 0x00b8, blocks: (B:3:0x002b, B:6:0x0035, B:10:0x0045, B:13:0x0053, B:17:0x005c, B:22:0x0067, B:25:0x0071, B:27:0x0077, B:30:0x0081, B:32:0x0087, B:35:0x0091, B:37:0x0097, B:41:0x00a0, B:43:0x00b3, B:46:0x0040), top: B:2:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067 A[Catch: all -> 0x00b8, TryCatch #0 {all -> 0x00b8, blocks: (B:3:0x002b, B:6:0x0035, B:10:0x0045, B:13:0x0053, B:17:0x005c, B:22:0x0067, B:25:0x0071, B:27:0x0077, B:30:0x0081, B:32:0x0087, B:35:0x0091, B:37:0x0097, B:41:0x00a0, B:43:0x00b3, B:46:0x0040), top: B:2:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0077 A[Catch: all -> 0x00b8, TryCatch #0 {all -> 0x00b8, blocks: (B:3:0x002b, B:6:0x0035, B:10:0x0045, B:13:0x0053, B:17:0x005c, B:22:0x0067, B:25:0x0071, B:27:0x0077, B:30:0x0081, B:32:0x0087, B:35:0x0091, B:37:0x0097, B:41:0x00a0, B:43:0x00b3, B:46:0x0040), top: B:2:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0087 A[Catch: all -> 0x00b8, TryCatch #0 {all -> 0x00b8, blocks: (B:3:0x002b, B:6:0x0035, B:10:0x0045, B:13:0x0053, B:17:0x005c, B:22:0x0067, B:25:0x0071, B:27:0x0077, B:30:0x0081, B:32:0x0087, B:35:0x0091, B:37:0x0097, B:41:0x00a0, B:43:0x00b3, B:46:0x0040), top: B:2:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0097 A[Catch: all -> 0x00b8, TryCatch #0 {all -> 0x00b8, blocks: (B:3:0x002b, B:6:0x0035, B:10:0x0045, B:13:0x0053, B:17:0x005c, B:22:0x0067, B:25:0x0071, B:27:0x0077, B:30:0x0081, B:32:0x0087, B:35:0x0091, B:37:0x0097, B:41:0x00a0, B:43:0x00b3, B:46:0x0040), top: B:2:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b3 A[Catch: all -> 0x00b8, TRY_LEAVE, TryCatch #0 {all -> 0x00b8, blocks: (B:3:0x002b, B:6:0x0035, B:10:0x0045, B:13:0x0053, B:17:0x005c, B:22:0x0067, B:25:0x0071, B:27:0x0077, B:30:0x0081, B:32:0x0087, B:35:0x0091, B:37:0x0097, B:41:0x00a0, B:43:0x00b3, B:46:0x0040), top: B:2:0x002b }] */
    @Override // i01.e, i01.a
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.d("QQGameMsgKuiklyModule", 1, "call method=" + method + ", params=" + params);
        try {
            if (!Intrinsics.areEqual(method, "deleteGameSession")) {
                if (Intrinsics.areEqual(method, "setTopGameSession")) {
                }
                jSONObject = null;
                switch (method.hashCode()) {
                    case -1453703503:
                        if (method.equals("setTopGameSession")) {
                            if (jSONObject == null) {
                                return null;
                            }
                            String optString = jSONObject.optString("peerUid");
                            Intrinsics.checkNotNullExpressionValue(optString, "optString(\"peerUid\")");
                            y(optString, jSONObject.optBoolean("isTop"));
                            break;
                        } else {
                            return super.call(method, params, callback);
                        }
                    case -1324225229:
                        if (method.equals("getGamePartners")) {
                            t(callback);
                            return Unit.INSTANCE;
                        }
                        return super.call(method, params, callback);
                    case -1186927554:
                        if (method.equals("getAllSessionModel")) {
                            B(callback);
                            return Unit.INSTANCE;
                        }
                        return super.call(method, params, callback);
                    case 1821671405:
                        if (method.equals("setGameBoxRead")) {
                            w();
                            return Unit.INSTANCE;
                        }
                        return super.call(method, params, callback);
                    case 1949455257:
                        if (method.equals("deleteGameSession")) {
                            if (jSONObject == null) {
                                return null;
                            }
                            String optString2 = jSONObject.optString("peerUid");
                            Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"peerUid\")");
                            m(optString2);
                            break;
                        } else {
                            return super.call(method, params, callback);
                        }
                    default:
                        return super.call(method, params, callback);
                }
                return jSONObject;
            }
            if (params != null) {
                jSONObject = new JSONObject(params);
                switch (method.hashCode()) {
                    case -1453703503:
                        break;
                    case -1324225229:
                        break;
                    case -1186927554:
                        break;
                    case 1821671405:
                        break;
                    case 1949455257:
                        break;
                }
                return jSONObject;
            }
            jSONObject = null;
            switch (method.hashCode()) {
                case -1453703503:
                    break;
                case -1324225229:
                    break;
                case -1186927554:
                    break;
                case 1821671405:
                    break;
                case 1949455257:
                    break;
            }
            return jSONObject;
        } catch (Throwable th5) {
            QLog.e("QQGameMsgKuiklyModule", 1, th5, new Object[0]);
            return super.call(method, params, callback);
        }
    }
}
