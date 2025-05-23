package com.tencent.mobileqq.matchfriend.reborn.login;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerEntryApi;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerGameInfoUpdateEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerLoginLoadingDismissEvent;
import com.tencent.mobileqq.matchfriend.reborn.register.event.QQStrangerRegisterSuccessEvent;
import com.tencent.mobileqq.matchfriend.reborn.register.guest.QQStrangerGuestHelper;
import com.tencent.mobileqq.matchfriend.reborn.userinfo.QQStrangerUserInfoRequest;
import com.tencent.mobileqq.matchfriend.request.MatchFriendRequest;
import com.tencent.mobileqq.nearbypro.api.INearbyDataService;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.trpcprotocol.kuolie.gray_ctrl.gray_ctrl.GrayCtrl$MultiGrayCtlReq;
import com.tencent.trpcprotocol.kuolie.gray_ctrl.gray_ctrl.GrayCtrl$MultiGrayCtlRsp;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$GetHomePageOfficeAnnouncementReq;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$GetHomePageOfficeAnnouncementRsp;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$GetMiniUserInfoReq;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$GetMiniUserInfoRsp;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import com.tencent.util.LoadingUtil;
import com.tencent.xweb.internal.ConstValue;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 H2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002IJB\u0007\u00a2\u0006\u0004\bF\u0010GJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\"\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00190\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\nH\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\b\u0010 \u001a\u00020\u0006H\u0002J\b\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020\u0006H\u0002J\b\u0010'\u001a\u00020\u0006H\u0002J\b\u0010(\u001a\u00020\u0006H\u0002R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/login/QQStrangerLoginPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartPause", "onPartDestroy", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "H9", "U9", "bundle", "W9", "O9", "K9", "M9", "I9", "", "openId", "T9", "X9", "S9", "Q9", "Lcom/tencent/mobileqq/matchfriend/reborn/login/d;", "d", "Lcom/tencent/mobileqq/matchfriend/reborn/login/d;", "loginDialog", "Lp72/a;", "e", "Lp72/a;", "loginInfo", "", "f", "Z", "isNewUser", tl.h.F, "forbiddenGuest", "Lcom/tencent/mobileqq/matchfriend/reborn/login/QQStrangerLoginPart$HeartBeatRunnable;", "i", "Lcom/tencent/mobileqq/matchfriend/reborn/login/QQStrangerLoginPart$HeartBeatRunnable;", "heartBeat", "Ljava/lang/Runnable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Runnable;", "heartBeatStopHandle", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "loadingPage", "Landroid/app/Dialog;", "D", "Landroid/app/Dialog;", "loadingDialog", "<init>", "()V", "E", "a", "HeartBeatRunnable", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerLoginPart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: E, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static AtomicBoolean F = new AtomicBoolean(false);
    private static AtomicBoolean G = new AtomicBoolean(false);

    /* renamed from: C, reason: from kotlin metadata */
    private View loadingPage;

    /* renamed from: D, reason: from kotlin metadata */
    private Dialog loadingDialog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private d loginDialog = new d();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final p72.a loginInfo = new p72.a();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isNewUser;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean forbiddenGuest;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private HeartBeatRunnable heartBeat;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Runnable heartBeatStopHandle;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\t\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/login/QQStrangerLoginPart$HeartBeatRunnable;", "Ljava/lang/Runnable;", "", "e", TencentLocation.RUN_MODE, "", "d", "Ljava/lang/String;", "openId", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "setStopHandle", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class HeartBeatRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final String openId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final Function1<Runnable, Unit> setStopHandle;

        /* JADX WARN: Multi-variable type inference failed */
        public HeartBeatRunnable(String openId, Function1<? super Runnable, Unit> setStopHandle) {
            Intrinsics.checkNotNullParameter(openId, "openId");
            Intrinsics.checkNotNullParameter(setStopHandle, "setStopHandle");
            this.openId = openId;
            this.setStopHandle = setStopHandle;
        }

        private final void e() {
            HashMap hashMap = new HashMap();
            hashMap.put("kl_new_from_openid", this.openId);
            VideoReport.reportEvent("ev_kl_new_heartbeat", hashMap);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            if (appInterface != null) {
                MatchFriendRequest.G(appInterface);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            e();
            Function1<Runnable, Unit> function1 = this.setStopHandle;
            Runnable executeDelay = ThreadManagerV2.executeDelay(this, 16, null, true, 30000L);
            Intrinsics.checkNotNullExpressionValue(executeDelay, "executeDelay(this, Threa\u2026HEART_BEAT_TIME_INTERVAL)");
            function1.invoke(executeDelay);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/login/QQStrangerLoginPart$a;", "", "Ljava/util/concurrent/atomic/AtomicBoolean;", ConstValue.EXTEND_CONFIG_KEY_HAS_LOGIN, "Ljava/util/concurrent/atomic/AtomicBoolean;", "a", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setHasLogin", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "", "tag", "Ljava/lang/String;", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.login.QQStrangerLoginPart$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AtomicBoolean a() {
            return QQStrangerLoginPart.G;
        }

        Companion() {
        }
    }

    private final void H9() {
        if (QQTheme.isNowThemeIsNight()) {
            View partRootView = getPartRootView();
            View findViewById = partRootView != null ? partRootView.findViewById(R.id.oog) : null;
            if (findViewById == null) {
                return;
            }
            findViewById.setBackground(getContext().getResources().getDrawable(R.drawable.f7w));
        }
    }

    private final void I9() {
        if (getActivity() == null || getActivity().isFinishing() || getActivity().isDestroyed()) {
            return;
        }
        if (this.loginInfo.f425678h && (this.forbiddenGuest || !QQStrangerGuestHelper.f245363a.d())) {
            QLog.i("QQStrangerLoginPart", 1, "checkNewRegisterTask,should jump new register page! forbiddenGuest=" + this.forbiddenGuest);
            Intent intent = new Intent();
            intent.putExtra("key_open_id", this.loginInfo.f425671a);
            intent.putExtra("key_is_new_user", this.loginInfo.f425672b);
            IQQStrangerEntryApi iQQStrangerEntryApi = (IQQStrangerEntryApi) QRoute.api(IQQStrangerEntryApi.class);
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            iQQStrangerEntryApi.startRegisterForResult(activity, intent);
            return;
        }
        if (!this.loginInfo.f425678h) {
            com.tencent.mobileqq.matchfriend.reborn.utils.h.p();
        }
        runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.login.j
            @Override // java.lang.Runnable
            public final void run() {
                QQStrangerLoginPart.J9(QQStrangerLoginPart.this);
            }
        });
        O9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(QQStrangerLoginPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (F.get()) {
            this$0.S9();
        }
    }

    private final void K9() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        MessageMicro<GrayCtrl$MultiGrayCtlReq> messageMicro = new MessageMicro<GrayCtrl$MultiGrayCtlReq>() { // from class: com.tencent.trpcprotocol.kuolie.gray_ctrl.gray_ctrl.GrayCtrl$MultiGrayCtlReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GrayCtrl$MultiGrayCtlReq.class);
        };
        Object businessHandler = appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        ((com.tencent.relation.common.servlet.a) businessHandler).Z0("QQStranger.gray_ctrl.SsoMultiGrayCtrl", messageMicro.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.login.k
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                QQStrangerLoginPart.L9(i3, z16, obj);
            }
        });
    }

    private final void M9() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        Prompt$GetHomePageOfficeAnnouncementReq prompt$GetHomePageOfficeAnnouncementReq = new Prompt$GetHomePageOfficeAnnouncementReq();
        Object businessHandler = appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        ((com.tencent.relation.common.servlet.a) businessHandler).Z0("QQStranger.prompt.SsoGetHomePageOfficeAnnouncement", prompt$GetHomePageOfficeAnnouncementReq.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.login.g
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                QQStrangerLoginPart.N9(i3, z16, obj);
            }
        });
    }

    private final void O9() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        final AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        userInfo$GetMiniUserInfoReq userinfo_getminiuserinforeq = new userInfo$GetMiniUserInfoReq();
        for (int i3 = 1; i3 < 30; i3++) {
            userinfo_getminiuserinforeq.mini_info_ids.add(Integer.valueOf(i3));
        }
        userinfo_getminiuserinforeq.account_id.set(this.loginInfo.f425671a);
        userinfo_getminiuserinforeq.account_type.set(0);
        Object businessHandler = appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        final com.tencent.relation.common.servlet.a aVar = businessHandler instanceof com.tencent.relation.common.servlet.a ? (com.tencent.relation.common.servlet.a) businessHandler : null;
        if (aVar != null) {
            aVar.Z0("QQStranger.UserInfo.SsoGetMiniUserInfo", userinfo_getminiuserinforeq.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.login.i
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public final void onUpdate(int i16, boolean z16, Object obj) {
                    QQStrangerLoginPart.P9(AppInterface.this, aVar, i16, z16, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(AppInterface app, com.tencent.relation.common.servlet.a aVar, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(app, "$app");
        if (z16 && obj != null) {
            userInfo$GetMiniUserInfoRsp userinfo_getminiuserinforsp = new userInfo$GetMiniUserInfoRsp();
            try {
                userinfo_getminiuserinforsp.mergeFrom((byte[]) obj);
                if (userinfo_getminiuserinforsp.code.get() != 0) {
                    QLog.e("QQStrangerLoginPart", 1, "[fetchMatchEntranceInfo] fail, code=" + userinfo_getminiuserinforsp.code.get());
                    return;
                }
                String str = userinfo_getminiuserinforsp.infos.open_id.get();
                String str2 = userinfo_getminiuserinforsp.infos.nick.get();
                String str3 = userinfo_getminiuserinforsp.infos.avatar.get();
                IQQStrangerUserInfoMgr iQQStrangerUserInfoMgr = (IQQStrangerUserInfoMgr) app.getRuntimeService(IQQStrangerUserInfoMgr.class, "all");
                QQStrangerUserInfoRequest qQStrangerUserInfoRequest = QQStrangerUserInfoRequest.f245443a;
                userInfo$MiniInfo userinfo_miniinfo = userinfo_getminiuserinforsp.infos.get();
                Intrinsics.checkNotNullExpressionValue(userinfo_miniinfo, "rsp.infos.get()");
                iQQStrangerUserInfoMgr.setSelfUserInfo(qQStrangerUserInfoRequest.d(userinfo_miniinfo));
                ((INearbyDataService) QRoute.api(INearbyDataService.class)).setMatchFriendBaseInfo(new ca2.b(str, str2, str3));
                com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.c("loginUserInfoKey", userinfo_getminiuserinforsp.infos.get());
                aVar.notifyUI(10, true, null);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQStrangerLoginPart", 1, "[fetchMatchEntranceInfo] error", e16);
                return;
            }
        }
        QLog.e("QQStrangerLoginPart", 1, "[fetchMatchEntranceInfo] isSuccess:" + z16 + ", data:" + obj);
    }

    private final void Q9() {
        runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.login.e
            @Override // java.lang.Runnable
            public final void run() {
                QQStrangerLoginPart.R9(QQStrangerLoginPart.this);
            }
        });
        O9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(QQStrangerLoginPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.getContext(), 2, "\u6ce8\u518c\u6210\u529f", 0).show();
    }

    private final void S9() {
        QLog.d("QQStrangerLoginPart", 1, UIJsPlugin.EVENT_HIDE_LOADING);
        View view = this.loadingPage;
        if (view != null) {
            view.setVisibility(8);
        }
        F.set(false);
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerLoginLoadingDismissEvent());
        try {
            Dialog dialog = this.loadingDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
        } catch (Throwable th5) {
            QLog.e("QQStrangerLoginPart", 1, th5, new Object[0]);
        }
        Activity activity = getActivity();
        if (activity != null) {
            QUIImmersiveHelper.s(activity, false, true);
        }
    }

    private final void T9(String openId) {
        HeartBeatRunnable heartBeatRunnable = new HeartBeatRunnable(openId, new Function1<Runnable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.login.QQStrangerLoginPart$initHeartBeatReport$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Runnable runnable) {
                invoke2(runnable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Runnable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                QQStrangerLoginPart.this.heartBeatStopHandle = it;
            }
        });
        this.heartBeat = heartBeatRunnable;
        ThreadManagerV2.excute(heartBeatRunnable, 16, null, true);
    }

    private final void U9() {
        G.set(false);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        MatchFriendRequest.K(peekAppRuntime, 0, 0, new com.tencent.relation.common.servlet.c() { // from class: com.tencent.mobileqq.matchfriend.reborn.login.f
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i3, boolean z16, Bundle bundle) {
                QQStrangerLoginPart.V9(QQStrangerLoginPart.this, i3, z16, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(QQStrangerLoginPart this$0, int i3, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QQStrangerLoginPart", 1, "login,isSuccess=" + z16);
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(bundle, "bundle");
            this$0.W9(bundle);
        }
        G.set(true);
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerLoginEndEvent(z16));
    }

    private final void W9(Bundle bundle) {
        this.loginInfo.f425671a = bundle.getString("key_open_id", "");
        this.loginInfo.f425673c = bundle.getBoolean("key_is_forbid", false);
        this.loginInfo.f425672b = bundle.getBoolean("key_is_new_user", false);
        this.loginInfo.f425678h = bundle.getBoolean("ket_is_new_register", false);
        this.loginInfo.f425679i = bundle.getInt("key_user_type", 0);
        p72.a aVar = this.loginInfo;
        this.isNewUser = aVar.f425672b;
        aVar.f425674d = bundle.getString("key_forbid_title", "");
        this.loginInfo.f425675e = bundle.getString("key_forbid_body", "");
        this.loginInfo.f425676f = bundle.getString("key_forbid_tips", "");
        this.loginInfo.f425677g = bundle.getInt("key_forbid_window_type", 0);
        QLog.i("QQStrangerLoginPart", 1, "loginInfo:" + this.loginInfo);
        this.loginDialog.d(getActivity(), this.loginInfo, this.loadingPage);
        String str = this.loginInfo.f425671a;
        Intrinsics.checkNotNullExpressionValue(str, "loginInfo.openId");
        T9(str);
        K9();
        com.tencent.mobileqq.matchfriend.utils.b.d().p(this.loginInfo);
        I9();
        ((INearbyDataService) QRoute.api(INearbyDataService.class)).setQQKLLogin(true);
        com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.c("selfOpenIDKey", this.loginInfo.f425671a);
    }

    private final void X9() {
        View view = this.loadingPage;
        if (view != null) {
            view.setVisibility(0);
        }
        Dialog showLoadingDialogTipsRight = LoadingUtil.showLoadingDialogTipsRight(getContext(), false, true);
        this.loadingDialog = showLoadingDialogTipsRight;
        if (showLoadingDialogTipsRight != null) {
            showLoadingDialogTipsRight.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.login.h
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    QQStrangerLoginPart.Y9(QQStrangerLoginPart.this, dialogInterface);
                }
            });
        }
        Dialog dialog = this.loadingDialog;
        if (dialog != null) {
            dialog.show();
        }
        F.set(true);
        QLog.d("QQStrangerLoginPart", 1, UIJsPlugin.EVENT_SHOW_LOADING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(QQStrangerLoginPart this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == -1) {
                S9();
                return;
            }
            Activity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intent intent;
        super.onInitView(rootView);
        Activity activity = getActivity();
        boolean z16 = false;
        if (activity != null && (intent = activity.getIntent()) != null) {
            z16 = intent.getBooleanExtra("key_forbidden_guest", false);
        }
        this.forbiddenGuest = z16;
        this.loadingPage = rootView != null ? rootView.findViewById(R.id.ooi) : null;
        H9();
        if (com.tencent.mobileqq.matchfriend.reborn.utils.h.h()) {
            return;
        }
        X9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
        U9();
        M9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        ((INearbyDataService) QRoute.api(INearbyDataService.class)).setQQKLLogin(false);
        G.set(false);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            MatchFriendRequest.M(peekAppRuntime);
        }
        Runnable runnable = this.heartBeatStopHandle;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
        }
        HeartBeatRunnable heartBeatRunnable = this.heartBeat;
        if (heartBeatRunnable != null) {
            ThreadManagerV2.removeJob(heartBeatRunnable, 16);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        Runnable runnable = this.heartBeatStopHandle;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
        }
        HeartBeatRunnable heartBeatRunnable = this.heartBeat;
        if (heartBeatRunnable != null) {
            ThreadManagerV2.removeJob(heartBeatRunnable, 16);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        Runnable runnable = this.heartBeatStopHandle;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
        }
        HeartBeatRunnable heartBeatRunnable = this.heartBeat;
        if (heartBeatRunnable != null) {
            ThreadManagerV2.removeJob(heartBeatRunnable, 16);
            ThreadManagerV2.excute(heartBeatRunnable, 16, null, true);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QQStrangerRegisterSuccessEvent) {
            Q9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(int i3, boolean z16, Object obj) {
        if (z16 && obj != null) {
            GrayCtrl$MultiGrayCtlRsp grayCtrl$MultiGrayCtlRsp = new GrayCtrl$MultiGrayCtlRsp();
            try {
                grayCtrl$MultiGrayCtlRsp.mergeFrom((byte[]) obj);
                if (grayCtrl$MultiGrayCtlRsp.ret_code.get() != 0) {
                    return;
                }
                com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.c("gameInfos", grayCtrl$MultiGrayCtlRsp.game_infos.get());
                SimpleEventBus.getInstance().dispatchEvent(new QQStrangerGameInfoUpdateEvent());
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQStrangerLoginPart", 1, "[fetchMatchEntranceInfo] error", e16);
                return;
            }
        }
        QLog.e("QQStrangerLoginPart", 1, "[fetchMatchEntranceInfo] isSuccess:" + z16 + ", data:" + obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(int i3, boolean z16, Object obj) {
        if (z16 && obj != null) {
            Prompt$GetHomePageOfficeAnnouncementRsp prompt$GetHomePageOfficeAnnouncementRsp = new Prompt$GetHomePageOfficeAnnouncementRsp();
            try {
                prompt$GetHomePageOfficeAnnouncementRsp.mergeFrom((byte[]) obj);
                if (prompt$GetHomePageOfficeAnnouncementRsp.ret_code.get() != 0) {
                    return;
                }
                QLog.i("QQStrangerLoginPart", 1, "fetchOnlinePeople:" + prompt$GetHomePageOfficeAnnouncementRsp.online_num.get());
                SimpleEventBus.getInstance().dispatchEvent(new QQStrangerOnlinePeopleEvent(prompt$GetHomePageOfficeAnnouncementRsp.online_num.get()));
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQStrangerLoginPart", 1, "[fetchOnlinePeople] error", e16);
                return;
            }
        }
        QLog.e("QQStrangerLoginPart", 1, "[fetchOnlinePeople] isSuccess:" + z16 + ", data:" + obj);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQStrangerRegisterSuccessEvent.class);
        return arrayListOf;
    }
}
