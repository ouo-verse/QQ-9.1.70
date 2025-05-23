package com.tencent.mobileqq.activity.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.NotifyPCActiveActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.activity.home.chats.avatar.AvatarRefreshHelper;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ForwardMiniAppThirdPartyHelper;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.app.bt;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.guild.api.IGuildDelayInitializeService;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.av;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.y;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.helper.QCircleObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;
import com.tencent.mobileqq.service.qzone.QZoneIntimateEntranceManager;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingApi;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.af;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.open.api.IOpenSdkCommonChannelJumpActionMgr;
import com.tencent.open.api.IOpenSdkJumpActionStashApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.troop.ITroopNotificationRepoApi;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.TimeCostTrace;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.AccountObserver;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MainAssistObserver {
    static IPatchRedirector $redirector_;
    private UpgradeDetailWrapper A;
    QQCustomDialog B;
    Handler C;
    private com.tencent.mobileqq.observer.b D;
    CardObserver E;
    protected String F;
    protected String G;
    protected boolean H;
    protected Bundle I;
    protected String J;
    protected QQProgressDialog K;
    protected Handler L;
    protected boolean M;
    protected QQCustomDialog N;
    public boolean O;
    protected com.tencent.biz.common.util.i P;
    RedpointObserver Q;
    protected QQCustomDialog R;
    protected Bundle S;

    /* renamed from: a, reason: collision with root package name */
    public SplashActivity f183359a;

    /* renamed from: b, reason: collision with root package name */
    public final int f183360b;

    /* renamed from: c, reason: collision with root package name */
    public final int f183361c;

    /* renamed from: d, reason: collision with root package name */
    public final int f183362d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f183363e;

    /* renamed from: f, reason: collision with root package name */
    public LebaTabRedTouch f183364f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.mobileqq.activity.main.e f183365g;

    /* renamed from: h, reason: collision with root package name */
    private final ec2.d f183366h;

    /* renamed from: i, reason: collision with root package name */
    private final av f183367i;

    /* renamed from: j, reason: collision with root package name */
    private final AccountObserver f183368j;

    /* renamed from: k, reason: collision with root package name */
    private final com.tencent.mobileqq.avatar.observer.a f183369k;

    /* renamed from: l, reason: collision with root package name */
    private final CardObserver f183370l;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.observer.d f183371m;

    /* renamed from: n, reason: collision with root package name */
    private bs f183372n;

    /* renamed from: o, reason: collision with root package name */
    private QZoneObserver f183373o;

    /* renamed from: p, reason: collision with root package name */
    private com.tencent.mobileqq.observer.a f183374p;

    /* renamed from: q, reason: collision with root package name */
    private bt f183375q;

    /* renamed from: r, reason: collision with root package name */
    private nb2.a f183376r;

    /* renamed from: s, reason: collision with root package name */
    private com.tencent.qqnt.troop.g f183377s;

    /* renamed from: t, reason: collision with root package name */
    private com.tencent.mobileqq.app.h f183378t;

    /* renamed from: u, reason: collision with root package name */
    private ExpandObserver f183379u;

    /* renamed from: v, reason: collision with root package name */
    private final com.tencent.relation.common.servlet.b f183380v;

    /* renamed from: w, reason: collision with root package name */
    private final com.tencent.mobileqq.nearbypro.entry.api.impl.a f183381w;

    /* renamed from: x, reason: collision with root package name */
    private QCircleObserver f183382x;

    /* renamed from: y, reason: collision with root package name */
    ConcurrentLinkedQueue<Runnable> f183383y;

    /* renamed from: z, reason: collision with root package name */
    AtomicInteger f183384z;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements nb2.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // nb2.a
        public void onContactCountChanged() {
            QQAppInterface qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            SplashActivity splashActivity = MainAssistObserver.this.f183359a;
            if (splashActivity != null && (qQAppInterface = splashActivity.app) != null) {
                ((INewFriendService) qQAppInterface.getRuntimeService(INewFriendService.class)).getUnreadMessageCountAsync();
            }
        }

        @Override // nb2.a
        public void onMayKnowStatesChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // nb2.a
        public void onUnreadChanged(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                MainAssistObserver.this.X();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends com.tencent.mobileqq.app.h {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.h
        public void p(boolean z16, UpgradeDetailWrapper upgradeDetailWrapper) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MainAssistObserver.this.A = upgradeDetailWrapper;
                MainAssistObserver.this.a0();
            } else {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), upgradeDetailWrapper);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c extends ExpandObserver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void B(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                MainAssistObserver.this.X();
                MainAssistObserver.this.Y(3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d implements com.tencent.relation.common.servlet.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            } else if (i3 == 14) {
                MainAssistObserver.this.X();
                MainAssistObserver.this.Y(4);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class e extends com.tencent.mobileqq.nearbypro.entry.api.impl.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // com.tencent.mobileqq.nearbypro.entry.api.impl.a, com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, @Nullable Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            } else if (i3 == 0) {
                MainAssistObserver.this.Y(5);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class f extends QCircleObserver {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // com.tencent.mobileqq.qcircle.api.helper.QCircleObserver
        protected void onUpdateRedPoint(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                MainAssistObserver.this.Y(6);
                MainAssistObserver.this.Z(40, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class g implements LebaTabRedTouch.c {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.main.LebaTabRedTouch.c
        public void a(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) redTypeInfo);
                return;
            }
            boolean z16 = true;
            Message obtainMessage = MainAssistObserver.this.C.obtainMessage(1);
            obtainMessage.obj = redTypeInfo;
            MainAssistObserver.this.C.sendMessage(obtainMessage);
            IReadInJoySPEventReport iReadInJoySPEventReport = (IReadInJoySPEventReport) QRoute.api(IReadInJoySPEventReport.class);
            if (redTypeInfo == null) {
                z16 = false;
            }
            iReadInJoySPEventReport.updateDTRedPntStats(z16);
        }

        @Override // com.tencent.mobileqq.activity.main.LebaTabRedTouch.c
        public void onFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                MainAssistObserver.this.f183384z.decrementAndGet();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class h extends av {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.av
        public void f(boolean z16, Bundle bundle) {
            FrameHelperActivity ji5;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            SplashActivity splashActivity = MainAssistObserver.this.f183359a;
            if (splashActivity != null && splashActivity.app != null && (ji5 = FrameHelperActivity.ji(splashActivity)) != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, "onSetOnlineStatus, isSuccess", Boolean.valueOf(z16));
                }
                ji5.rj("OnlineStatusObserver.onSetOnlineStatus");
                ji5.oi();
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.av
        public void j(boolean z16, pc2.a aVar) {
            FrameHelperActivity ji5;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), aVar);
                return;
            }
            SplashActivity splashActivity = MainAssistObserver.this.f183359a;
            if (splashActivity != null && splashActivity.app != null && (ji5 = FrameHelperActivity.ji(splashActivity)) != null && ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getSelfExtOnlineStatus(MainAssistObserver.this.f183359a.app) == 1080) {
                ji5.mUiHandler.sendEmptyMessage(19);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class i extends Handler {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class b implements DialogInterface.OnCancelListener {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
                }
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class c implements DialogInterface.OnDismissListener {
            static IPatchRedirector $redirector_;

            c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                }
            }
        }

        i(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            QQAppInterface qQAppInterface;
            Bundle data;
            String string;
            String string2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            SplashActivity splashActivity = MainAssistObserver.this.f183359a;
            if (splashActivity != null && (qQAppInterface = splashActivity.app) != null && qQAppInterface.isLogin()) {
                int i3 = message.what;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 3) {
                            if (i3 != 28929 || (data = message.getData()) == null) {
                                return;
                            }
                            int i16 = data.getInt("result");
                            if (i16 != -1 && i16 != -2) {
                                QQCustomDialog qQCustomDialog = MainAssistObserver.this.B;
                                if (qQCustomDialog != null) {
                                    qQCustomDialog.dismiss();
                                    return;
                                }
                                return;
                            }
                            if (i16 == -1) {
                                string = MainAssistObserver.this.f183359a.getString(R.string.h_4);
                                string2 = MainAssistObserver.this.f183359a.getString(R.string.h_3);
                            } else {
                                string = MainAssistObserver.this.f183359a.getString(R.string.h_7);
                                string2 = MainAssistObserver.this.f183359a.getString(R.string.h_6);
                            }
                            String str = string;
                            String str2 = string2;
                            try {
                                QQCustomDialog qQCustomDialog2 = MainAssistObserver.this.B;
                                if (qQCustomDialog2 != null) {
                                    if (qQCustomDialog2.isShowing()) {
                                        MainAssistObserver.this.B.dismiss();
                                    }
                                    MainAssistObserver.this.B = null;
                                }
                                MainAssistObserver mainAssistObserver = MainAssistObserver.this;
                                mainAssistObserver.B = DialogUtil.createCustomDialog(mainAssistObserver.f183359a, 230, str, str2, new a(), null);
                                MainAssistObserver.this.B.setOnCancelListener(new b());
                                MainAssistObserver.this.B.setOnDismissListener(new c());
                                MainAssistObserver.this.B.show();
                                return;
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    e16.printStackTrace();
                                    return;
                                }
                                return;
                            }
                        }
                        MainAssistObserver.this.Z(33, (BusinessInfoCheckUpdate.RedTypeInfo) message.obj);
                        return;
                    }
                    BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo) message.obj;
                    com.tencent.mobileqq.activity.leba.utils.a.g(redTypeInfo);
                    MainAssistObserver.this.V(redTypeInfo);
                    MainAssistObserver.this.Z(48, null);
                    MainAssistObserver.this.Z(40, null);
                    return;
                }
                MainAssistObserver.this.Z(35, (BusinessInfoCheckUpdate.RedTypeInfo) message.obj);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class j extends com.tencent.mobileqq.observer.b {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // com.tencent.mobileqq.observer.b
        protected void a(Object obj) {
            QQAppInterface qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, obj);
                return;
            }
            MainAssistObserver.this.Y(8);
            SplashActivity splashActivity = MainAssistObserver.this.f183359a;
            if (splashActivity != null && (qQAppInterface = splashActivity.app) != null && com.tencent.mobileqq.nearby.h.b(qQAppInterface) != null) {
                com.tencent.mobileqq.nearby.h.b(MainAssistObserver.this.f183359a.app).d();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class k extends CardObserver {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetMedal(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else if (z16) {
                MainAssistObserver.this.a0();
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetSignInInfo(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else if (z16) {
                MainAssistObserver.this.a0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class l implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                MainAssistObserver.this.f183359a.getIntent().removeExtra("if_check_account_same");
                MainAssistObserver.this.N.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class m implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("is_change_account", true);
            if (MainAssistObserver.this.f183359a.getIntent().getExtras() != null) {
                intent.putExtras(MainAssistObserver.this.f183359a.getIntent().getExtras());
            }
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            RouteUtils.startActivity(MainAssistObserver.this.f183359a, intent, RouterConstants.UI_ROUTER_LOGIN);
            MainAssistObserver.this.N.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class n extends com.tencent.biz.common.util.i {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // com.tencent.biz.common.util.i
        protected void a(boolean z16, OpenID openID) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), openID);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, "-->onGetOpenId, isSuccess: " + z16 + " data: " + openID + " mOpenId = " + MainAssistObserver.this.G);
            }
            if (!MainAssistObserver.this.f183359a.isFinishing()) {
                MainAssistObserver mainAssistObserver = MainAssistObserver.this;
                if (!mainAssistObserver.M) {
                    QQProgressDialog qQProgressDialog = mainAssistObserver.K;
                    if (qQProgressDialog != null) {
                        qQProgressDialog.hide();
                    }
                    Handler handler = MainAssistObserver.this.L;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                    if (z16 && openID != null && openID.openID != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, "openIdObserver success");
                        }
                        if (!TextUtils.isEmpty(MainAssistObserver.this.G) && !openID.openID.equals(MainAssistObserver.this.G)) {
                            MainAssistObserver.this.R();
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, "openIdObserver fail");
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class o extends RedpointObserver {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // com.tencent.mobileqq.tianshu.observer.RedpointObserver
        public void onDataChange(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, "RedpointObserver, onUpdateSettingMe");
            }
            MainAssistObserver.this.a0();
        }

        @Override // com.tencent.mobileqq.tianshu.observer.RedpointObserver
        public void onNotifyLebaRedTouch(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, "RedpointObserver, onNotifyLebaRedTouch");
            }
            MainAssistObserver.this.Y(9);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class p implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class q extends AccountObserver {
        static IPatchRedirector $redirector_;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // mqq.observer.AccountObserver
        protected void onOnlineStatusChanged(boolean z16, AppRuntime.Status status, long j3, boolean z17, boolean z18, long j16, boolean z19) {
            FrameHelperActivity ji5;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), status, Long.valueOf(j3), Boolean.valueOf(z17), Boolean.valueOf(z18), Long.valueOf(j16), Boolean.valueOf(z19));
                return;
            }
            SplashActivity splashActivity = MainAssistObserver.this.f183359a;
            if (splashActivity != null && splashActivity.app != null && (ji5 = FrameHelperActivity.ji(splashActivity)) != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, String.format("onOnlineStatusChanged, currentStatus = %s", status));
                }
                ji5.rj("AccountObserver.onOnlineStatusChanged");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mqq.observer.AccountObserver
        public void onOnlineStatusPush(AppRuntime.Status status, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, status, Long.valueOf(j3));
                return;
            }
            SplashActivity splashActivity = MainAssistObserver.this.f183359a;
            if (splashActivity != null && splashActivity.app != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, String.format("onOnlineStatusPush, currentStatus = %s , extOnlineStatus = %d", status, Long.valueOf(j3)));
                }
                FrameHelperActivity ji5 = FrameHelperActivity.ji(MainAssistObserver.this.f183359a);
                if (ji5 == null) {
                    return;
                }
                ji5.rj("AccountObserver.onOnlineStatusPush");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class r implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f183417d;

        r(String str) {
            this.f183417d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this, (Object) str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            dialogInterface.dismiss();
            Intent intent = new Intent(MainAssistObserver.this.f183359a, (Class<?>) SearchContactsActivity.class);
            intent.putExtra("from_key", 0);
            intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, 13);
            intent.putExtra("start_search_key", this.f183417d);
            intent.putExtra("auto_add_and_prohibit_auto_search", true);
            MainAssistObserver.this.f183359a.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class s implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class t implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
                MainAssistObserver.this.f183359a.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class u implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class v extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        v() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            FrameHelperActivity ji5;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, " Conversation.onUpdateCustomHead: uin:" + str + ", success :" + z16);
            }
            if (!z16 || (ji5 = FrameHelperActivity.ji(MainAssistObserver.this.f183359a)) == null) {
                return;
            }
            if (Utils.p(str, MainAssistObserver.this.f183359a.getAppRuntime().getCurrentAccountUin())) {
                ji5.mUiHandler.sendEmptyMessage(3);
            } else {
                AvatarRefreshHelper.f182873a.c(str);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateTroopHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else {
                AvatarRefreshHelper.f182873a.c(str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class w extends CardObserver {
        static IPatchRedirector $redirector_;

        w() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.CardObserver
        public void onUpdateAvatar(boolean z16, String str, int i3) {
            AppRuntime appRuntime;
            FrameHelperActivity ji5;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
            } else {
                if (!z16 || (appRuntime = MainAssistObserver.this.f183359a.getAppRuntime()) == null || !Utils.p(str, appRuntime.getCurrentAccountUin()) || (ji5 = FrameHelperActivity.ji(MainAssistObserver.this.f183359a)) == null) {
                    return;
                }
                ji5.mUiHandler.sendEmptyMessage(3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class x extends com.tencent.mobileqq.observer.d {
        static IPatchRedirector $redirector_;

        x() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // com.tencent.mobileqq.observer.d, mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            } else if (i3 == 0 && z16) {
                MainAssistObserver.this.S();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class y extends bs {
        static IPatchRedirector $redirector_;

        y() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        public void onPushPCActiveNotice(boolean z16, String str, String str2, String str3, String str4) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2, str3, str4);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MainAssistObserver_PCActiveNotice", 2, "onPushPCActiveNotice.isSuccess=" + z16);
            }
            SplashActivity splashActivity = MainAssistObserver.this.f183359a;
            if (splashActivity == null || !splashActivity.isResume() || !z16) {
                return;
            }
            Intent intent = new Intent(NewIntent.ACTION_PCACTIVE_TIPS);
            intent.putExtra("uin", str);
            intent.putExtra("Message", str2);
            intent.putExtra("lButton", str3);
            intent.putExtra("rButton", str4);
            if (NotifyPCActiveActivity.f176576d0 == null) {
                MainAssistObserver.this.f183359a.startActivity(intent);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class z extends com.tencent.mobileqq.observer.a {
        static IPatchRedirector $redirector_;

        z() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
            }
        }

        @Override // com.tencent.mobileqq.observer.a
        protected void a(boolean z16, boolean z17, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
                return;
            }
            if (z16 && z17 && i3 != 2) {
                if (QLog.isColorLevel()) {
                    QLog.d("MainActivity", 2, "inform onGameCenterMsgReceive.type=" + i3);
                }
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 4) {
                            if (i3 == 5 || i3 == 6) {
                                MainAssistObserver.this.Y(2);
                                MainAssistObserver.this.a0();
                                MainAssistObserver.this.X();
                                return;
                            }
                            return;
                        }
                        MainAssistObserver.this.Y(2);
                        return;
                    }
                    MainAssistObserver.this.Y(2);
                    return;
                }
                MainAssistObserver.this.Y(2);
            }
        }
    }

    public MainAssistObserver(SplashActivity splashActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) splashActivity);
            return;
        }
        this.f183360b = 0;
        this.f183361c = 1;
        this.f183362d = 3;
        this.f183363e = false;
        this.f183366h = new ec2.d() { // from class: com.tencent.mobileqq.activity.main.h
            @Override // ec2.d
            public final void a(String str) {
                MainAssistObserver.this.B(str);
            }
        };
        this.f183367i = new h();
        this.f183368j = new q();
        this.f183369k = new v();
        this.f183370l = new w();
        this.f183371m = new x();
        this.f183372n = new y();
        this.f183373o = new QZoneObserver() { // from class: com.tencent.mobileqq.activity.main.MainAssistObserver.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.observer.QZoneObserver
            public void a(boolean z16) {
                BusinessInfoCheckUpdate.RedTypeInfo a16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, z16);
                    return;
                }
                super.a(z16);
                com.tencent.mobileqq.activity.leba.utils.a.h(z16);
                BusinessInfoCheckUpdate.RedTypeInfo a17 = com.tencent.mobileqq.activity.leba.utils.a.a();
                if (a17 != null && MainAssistObserver.this.z(a17)) {
                    SplashActivity splashActivity2 = MainAssistObserver.this.f183359a;
                    if (splashActivity2 != null && splashActivity2.app != null) {
                        if (!com.tencent.mobileqq.leba.feed.d.a()) {
                            return;
                        }
                        if (QLog.isColorLevel() || QLog.isDebugVersion()) {
                            QLog.d("UndealCount.QZoneObserver", 1, "[onDynamicTabSelected] current isSelected: ", Boolean.valueOf(z16));
                        }
                        MainAssistObserver mainAssistObserver = MainAssistObserver.this;
                        if (z16) {
                            a16 = null;
                        } else {
                            a16 = com.tencent.mobileqq.activity.leba.utils.a.a();
                        }
                        mainAssistObserver.V(a16);
                        return;
                    }
                    QLog.e("UndealCount.QZoneObserver", 1, "[onDynamicTabSelected] activity or app should not be null.");
                }
            }

            @Override // com.tencent.mobileqq.observer.QZoneObserver
            protected void f(boolean z16, boolean z17, long j3) {
                QQAppInterface qQAppInterface;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3));
                    return;
                }
                if (z16 && z17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MainActivity", 2, "inform onGetQZoneFeedCountFin");
                    }
                    SplashActivity splashActivity2 = MainAssistObserver.this.f183359a;
                    if (splashActivity2 != null && (qQAppInterface = splashActivity2.app) != null) {
                        GuardManager guardManager = GuardManager.sInstance;
                        if (guardManager != null && !guardManager.isLiteOrUnguard()) {
                            ThreadManagerV2.post(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.activity.main.MainAssistObserver.8.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ QQAppInterface f183395d;

                                {
                                    this.f183395d = qQAppInterface;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass8.this, (Object) qQAppInterface);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                        MainAssistObserver.this.q(this.f183395d);
                                    } else {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    }
                                }
                            }, 8, null, false);
                        }
                        MainAssistObserver.this.Y(1);
                    }
                }
            }
        };
        this.f183374p = new z();
        this.f183375q = new bt() { // from class: com.tencent.mobileqq.activity.main.MainAssistObserver.10
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void c(boolean z16, int i3) {
                if (z16) {
                    d(((IChatsUtil) QRoute.api(IChatsUtil.class)).getUnreadCountByListType(1));
                } else {
                    d(i3);
                }
            }

            @Override // com.tencent.mobileqq.app.bt
            public void a(boolean z16, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                } else {
                    ThreadManager.getUIHandler().postDelayed(new Runnable(z16, i3) { // from class: com.tencent.mobileqq.activity.main.MainAssistObserver.10.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f183386d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ int f183387e;

                        {
                            this.f183386d = z16;
                            this.f183387e = i3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass10.this, Boolean.valueOf(z16), Integer.valueOf(i3));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                c(this.f183386d, this.f183387e);
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    }, 50L);
                }
            }

            public void d(int i3) {
                QQAppInterface qQAppInterface;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, i3);
                    return;
                }
                MainAssistObserver mainAssistObserver = MainAssistObserver.this;
                SplashActivity splashActivity2 = mainAssistObserver.f183359a;
                if (splashActivity2 != null && (qQAppInterface = splashActivity2.app) != null) {
                    mainAssistObserver.W(32, 16, Integer.valueOf(i3));
                    qQAppInterface.getApp().sendBroadcast(new Intent("com.tencent.qq.syncQQMessage"));
                    if (QLog.isDevelopLevel()) {
                        QLog.d("fetchUnReadCount", 4, String.format("MainAssistObserver\u6d88\u606ftab, nUnreadCount[%s]", Integer.valueOf(i3)));
                    }
                }
            }
        };
        this.f183376r = new a();
        this.f183377s = new com.tencent.qqnt.troop.g() { // from class: com.tencent.mobileqq.activity.main.i
            @Override // com.tencent.qqnt.troop.g
            public final void b(int i3, int i16, int i17) {
                MainAssistObserver.this.C(i3, i16, i17);
            }
        };
        this.f183378t = new b();
        this.f183379u = new c();
        this.f183380v = new d();
        this.f183381w = new e();
        this.f183382x = new f();
        this.f183383y = new ConcurrentLinkedQueue<>();
        this.f183384z = new AtomicInteger(0);
        this.B = null;
        this.C = new i(Looper.getMainLooper());
        this.D = new j();
        this.E = new k();
        this.O = false;
        this.P = new n();
        this.Q = new o();
        this.f183364f = new LebaTabRedTouch(splashActivity);
        this.f183365g = new com.tencent.mobileqq.activity.main.e(splashActivity);
        this.f183359a = splashActivity;
    }

    private boolean A(String str) {
        if (str == null) {
            QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 1, "realHandleThirdPartyPullUpSyncStatus video: null");
            return true;
        }
        SplashActivity splashActivity = this.f183359a;
        if (splashActivity == null) {
            QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 1, "realHandleThirdPartyPullUpSyncStatus mActivity == null");
            return true;
        }
        if (splashActivity.getWindow() == null) {
            QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 1, "realHandleThirdPartyPullUpSyncStatus mActivity.getWindow() == null");
            return true;
        }
        if (this.f183359a.getWindow().getDecorView() == null) {
            QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 1, "realHandleThirdPartyPullUpSyncStatus mActivity.getWindow().getDecorView() == null");
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(String str) {
        FrameHelperActivity ji5;
        SplashActivity splashActivity = this.f183359a;
        if (splashActivity != null && splashActivity.app != null && (ji5 = FrameHelperActivity.ji(splashActivity)) != null) {
            ji5.rj("from_conf_update");
            ji5.oi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(int i3, int i16, int i17) {
        if (QLog.isColorLevel()) {
            QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 1, "onUnreadCountChanged, count = " + i3);
        }
        X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT, bundle.getString(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT));
        intent.putExtra("pkg_name", bundle.getString("pkg_name"));
        zp3.d buildHelper = ((IOpenSdkCommonChannelJumpActionMgr) QRoute.api(IOpenSdkCommonChannelJumpActionMgr.class)).buildHelper(this.f183359a, intent);
        if (buildHelper != null) {
            buildHelper.c(this.f183359a, 0, "isSuccess");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(final Bundle bundle, int i3, String str) {
        com.tencent.mobileqq.onlinestatus.y newAccountPanel;
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) this.f183359a.app.getRuntimeService(IOnlineStatusService.class, "");
        FrameHelperActivity ji5 = FrameHelperActivity.ji(this.f183359a);
        if (ji5 == null) {
            QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 1, "helperActivity == null");
            return;
        }
        com.tencent.mobileqq.onlinestatus.y yVar = ji5.H;
        if (yVar != null && yVar.isShowing() && !OnlineStatusToggleUtils.e()) {
            newAccountPanel = ji5.H;
        } else {
            newAccountPanel = iOnlineStatusService.newAccountPanel(this.f183359a, 10);
            newAccountPanel.show();
        }
        newAccountPanel.Og(new y.a() { // from class: com.tencent.mobileqq.activity.main.l
            @Override // com.tencent.mobileqq.onlinestatus.y.a
            public final void a() {
                MainAssistObserver.this.D(bundle);
            }
        });
        if (i3 != 1) {
            if (i3 == 2) {
                newAccountPanel.l2(str, 3);
                return;
            }
            return;
        }
        newAccountPanel.O8(str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(INewFriendService iNewFriendService) {
        if (this.f183359a == null) {
            return;
        }
        iNewFriendService.addListener(this.f183376r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        AppRuntime s16 = s();
        if (s16 == null) {
            return;
        }
        final INewFriendService iNewFriendService = (INewFriendService) s16.getRuntimeService(INewFriendService.class, "");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.main.k
            @Override // java.lang.Runnable
            public final void run() {
                MainAssistObserver.this.F(iNewFriendService);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit H() {
        this.f183365g.n();
        return Unit.INSTANCE;
    }

    private void K(String str) {
        DialogUtil.createCustomDialog(this.f183359a, 230).setTitle((String) null).setMessage(String.format(this.f183359a.getString(R.string.izq), str)).setPositiveButton(this.f183359a.getString(R.string.a97), new r(str)).setNegativeButton(this.f183359a.getString(R.string.f170647xd), new p()).show();
    }

    private void L(Bundle bundle) {
        boolean z16 = bundle.getBoolean(AppConstants.Key.PULL_APP_NOT_PRIVILEGE, false);
        String string = bundle.getString(AppConstants.Key.PULL_APP_NOT_PRIVILEGE_STRING, "");
        boolean z17 = bundle.getBoolean(AppConstants.Key.PULL_SHOULD_SHOW_OPEN_ID_DIFF_MAIN, false);
        bundle.getBoolean(AppConstants.Key.PULL_UIN_NOT_EXIST, false);
        boolean z18 = bundle.getBoolean(AppConstants.Key.PULL_ADD_FRIEND_TIP, false);
        String string2 = bundle.getString("uin", "");
        bundle.getString("openid", "");
        bundle.getString("appid", "");
        if (z16) {
            this.f183359a.getIntent().removeExtra(AppConstants.Key.PULL_APP_NOT_PRIVILEGE);
            QQCustomDialog n3 = n(string);
            this.R = n3;
            n3.show();
            return;
        }
        if (z17) {
            this.f183359a.getIntent().removeExtra(AppConstants.Key.THRIPARTY_PULL_MAIN);
            this.f183359a.getIntent().removeExtra(AppConstants.Key.PULL_SHOULD_SHOW_OPEN_ID_DIFF_MAIN);
            this.f183359a.getIntent().putExtra("is_change_account", true);
            this.f183359a.getIntent().putExtra("if_check_account_same", true);
            this.f183359a.getIntent().putExtra("key_action", com.tencent.mobileqq.forward.h.class.getSimpleName());
            this.f183359a.getIntent().putExtra("hide_uin", true);
            R();
            return;
        }
        if (z18) {
            this.f183359a.getIntent().removeExtra(AppConstants.Key.PULL_ADD_FRIEND_TIP);
            K(string2);
        }
    }

    private void M(Bundle bundle) {
        this.f183359a.getIntent().putExtra(AppConstants.Key.THRIPARTY_PREPARE_MINI_APP, false);
        boolean z16 = bundle.getBoolean(AppConstants.Key.PULL_SHOULD_SHOW_OPEN_ID_DIFF_MAIN, false);
        String string = bundle.getString("mini_app_id", "");
        String string2 = bundle.getString(AppConstants.Key.THRIPARTY_PULL_MINI_APP_PATH, "");
        String string3 = bundle.getString(AppConstants.Key.THRIPARTY_PULL_MINI_APP_TYPE, "release");
        boolean z17 = bundle.getBoolean(AppConstants.Key.PULL_MINI_APP_NOT_PRIVILEGE, false);
        boolean z18 = bundle.getBoolean(AppConstants.Key.PULL_MINI_APP_NOT_PRIVILEGE_NOT_BIND, false);
        String string4 = bundle.getString(AppConstants.Key.PULL_MINI_APP_NOT_PRIVILEGE_NOT_BIND_APP_NAME, "");
        String string5 = bundle.getString(AppConstants.Key.PULL_MINI_APP_NOT_PRIVILEGE_STRING, "");
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.i(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, "showAccountConfirm: shouldShowOpenIdDifferent is true");
            }
            this.f183359a.getIntent().removeExtra(AppConstants.Key.PULL_SHOULD_SHOW_OPEN_ID_DIFF_MAIN);
            this.f183359a.getIntent().putExtra("is_change_account", true);
            this.f183359a.getIntent().putExtra("if_check_account_same", true);
            this.f183359a.getIntent().putExtra("key_action", ForwardMiniAppThirdPartyHelper.class.getSimpleName());
            R();
            return;
        }
        if (z17) {
            this.f183359a.getIntent().removeExtra(AppConstants.Key.PULL_APP_NOT_PRIVILEGE);
            if (z18) {
                this.f183359a.getIntent().removeExtra(AppConstants.Key.PULL_MINI_APP_NOT_PRIVILEGE_NOT_BIND);
                this.R = o(string5, string4);
            } else {
                this.R = n(string5);
            }
            this.R.show();
            return;
        }
        ForwardMiniAppThirdPartyHelper.launchMiniApp(this.f183359a, string, string2, string3);
    }

    private void N(final Bundle bundle) {
        QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 1, "realHandleThirdPartyPullUpSyncStatus");
        final String string = bundle.getString("extInfo");
        final int i3 = bundle.getInt(IOnlineStatusService.SYNC_TYPE);
        QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 1, "pkgType: " + i3);
        if (!A(string) && i3 != 0) {
            MobileQQ.sMobileQQ.peekAppRuntime().notifyObservers(com.tencent.mobileqq.onlinestatus.observer.c.class, 1, true, null);
            Intent intent = this.f183359a.getIntent();
            intent.putExtra("sdk_mult_share", "");
            intent.putExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT, "");
            intent.putExtra("pkg_name", "");
            intent.putExtra("k_from_login", "");
            this.f183359a.getWindow().getDecorView().post(new Runnable() { // from class: com.tencent.mobileqq.activity.main.j
                @Override // java.lang.Runnable
                public final void run() {
                    MainAssistObserver.this.E(bundle, i3, string);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(QQAppInterface qQAppInterface) {
        String str;
        int h16 = ((LocalRedTouchManager) qQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).h();
        if (h16 != 3) {
            if (h16 != 4) {
                if (h16 != 5) {
                    str = null;
                } else {
                    str = "0X80073B6";
                }
            } else {
                str = "0X80073B2";
            }
        } else {
            str = "0X80073B0";
        }
        String str2 = str;
        if (str2 != null) {
            ReportController.o(qQAppInterface, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
        }
    }

    private void Q() {
        Runnable poll;
        if (QLog.isDevelopLevel()) {
            QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, "runNext: mRunningTaskNum=" + this.f183384z.get() + ", queueSize=" + this.f183383y.size());
        }
        if (this.f183384z.get() <= 3 && (poll = this.f183383y.poll()) != null) {
            this.f183384z.incrementAndGet();
            ThreadManagerV2.post(poll, 10, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        SplashActivity splashActivity = this.f183359a;
        if (splashActivity == null) {
            return;
        }
        splashActivity.showGifAnnimate();
    }

    private void m(Runnable runnable) {
        this.f183383y.offer(runnable);
        Q();
    }

    private QQCustomDialog n(String str) {
        return DialogUtil.createCustomDialog(this.f183359a, 230).setTitle((String) null).setMessage(str).setPositiveButton(this.f183359a.getString(R.string.f170648xe), new s());
    }

    private QQCustomDialog o(String str, String str2) {
        return DialogUtil.createCustomDialog(this.f183359a, 230).setTitle((String) null).setMessage(str).setPositiveButton(this.f183359a.getString(R.string.hii), new u()).setNegativeButton(this.f183359a.getString(R.string.hih) + str2, new t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(QQAppInterface qQAppInterface) {
        if (qQAppInterface != null && QZoneConfigHelper.y()) {
            if (LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_PROCESS_IS_FIRST_LOGIN, true)) {
                LocalMultiProcConfig.putBool(LocalMultiProcConfig.QZONE_PROCESS_IS_FIRST_LOGIN, false);
                QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "QZONE_PROCESS_IS_FIRST_LOGIN, do not launch qzone");
                return;
            } else if (y(qQAppInterface)) {
                QZoneHelper.preloadQzone(qQAppInterface, QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT);
                return;
            } else {
                QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 2, "has no external red dot, do not launch qzone");
                return;
            }
        }
        QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "preload when has red dot fail: " + qQAppInterface);
    }

    private AppRuntime s() {
        SplashActivity splashActivity = this.f183359a;
        if (splashActivity == null) {
            return null;
        }
        return splashActivity.app;
    }

    private boolean w(Intent intent) {
        IOpenSdkCommonChannelJumpActionMgr iOpenSdkCommonChannelJumpActionMgr = (IOpenSdkCommonChannelJumpActionMgr) QRoute.api(IOpenSdkCommonChannelJumpActionMgr.class);
        if (!iOpenSdkCommonChannelJumpActionMgr.isCommonChannelHandleSwitchOn()) {
            return false;
        }
        try {
            boolean handleCommonChannelJumpAction = iOpenSdkCommonChannelJumpActionMgr.handleCommonChannelJumpAction(this.f183359a, intent);
            if (handleCommonChannelJumpAction) {
                MobileQQ.sMobileQQ.peekAppRuntime().notifyObservers(com.tencent.mobileqq.onlinestatus.observer.c.class, 1, true, null);
                Intent intent2 = this.f183359a.getIntent();
                intent2.putExtra("sdk_mult_share", "");
                intent2.putExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT, "");
                intent2.putExtra("pkg_name", "");
                intent2.putExtra("k_from_login", "");
            }
            QLog.i(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 1, "handleOpenSdkCommonChannelJumpAction ret: " + handleCommonChannelJumpAction);
            return handleCommonChannelJumpAction;
        } catch (Exception e16) {
            QLog.e(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 1, "handleOpenSdkCommonChannelJumpAction exception ", e16);
            return false;
        }
    }

    private boolean y(QQAppInterface qQAppInterface) {
        int i3;
        if (qQAppInterface == null) {
            QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "hasNewQZoneExternalRedDot, app is null");
            return false;
        }
        QZoneManagerImp qZoneManagerImp = (QZoneManagerImp) qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
        if (qZoneManagerImp != null) {
            i3 = qZoneManagerImp.j(2) + qZoneManagerImp.j(3) + qZoneManagerImp.j(1);
            if (QZoneIntimateEntranceManager.u()) {
                i3 += qZoneManagerImp.j(66) + qZoneManagerImp.j(67);
            }
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        return com.tencent.mobileqq.activity.leba.utils.a.b(redTypeInfo);
    }

    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.main.MainAssistObserver.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    QQAppInterface qQAppInterface;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    SplashActivity splashActivity = MainAssistObserver.this.f183359a;
                    if (splashActivity != null) {
                        qQAppInterface = splashActivity.app;
                    } else {
                        qQAppInterface = null;
                    }
                    if (splashActivity != null && qQAppInterface != null) {
                        try {
                            l61.a.a(qQAppInterface);
                            MultiMsgManager.w().I(qQAppInterface);
                        } catch (Exception e16) {
                            QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 4, "notifyWindowShowed e=" + e16);
                        }
                        qQAppInterface.setTalkbackSwitch();
                        QQToast.canUseCustomToast();
                    }
                }
            }, 500L);
        } catch (Exception e16) {
            QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 4, "notifyWindowShowed e=" + e16);
        }
    }

    public void J(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) qQAppInterface);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, "onAccountChanged, ");
        }
        this.f183384z.set(0);
        this.f183383y.clear();
        StudyModeManager.u();
        ElderModeManager.h(true);
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).updateGuildTabStatus();
    }

    public void O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        SplashActivity splashActivity = this.f183359a;
        if (splashActivity == null || splashActivity.app == null || this.f183363e) {
            return;
        }
        try {
            this.f183359a.app.registObserver(this.f183371m);
            this.f183359a.app.registObserver(this.f183373o);
            this.f183359a.app.registObserver(this.f183374p);
            this.f183359a.app.addObserver(this.f183378t);
            this.f183359a.app.addObserver(this.f183372n);
            this.f183359a.app.addObserver(this.D);
            this.f183359a.app.setMsgTabUnreadListener(this.f183375q);
            VSNetworkHelper.getInstance();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.main.f
                @Override // java.lang.Runnable
                public final void run() {
                    MainAssistObserver.this.G();
                }
            }, 16, null, true);
            ((TroopRedTouchHandler) this.f183359a.app.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER)).H2();
            this.f183359a.app.addObserver(this.E);
            this.f183359a.app.addObserver(this.P);
            this.f183359a.app.addObserver(this.Q);
            this.f183359a.app.addObserver(this.f183379u);
            this.f183359a.app.addObserver(this.f183380v);
            this.f183359a.app.addObserver(this.f183382x);
            this.f183359a.app.addObserver(this.f183381w);
            if (af.i()) {
                this.f183359a.app.addObserver(this.f183367i);
                this.f183359a.app.registObserver(this.f183368j);
                this.f183359a.app.addObserver(this.f183369k);
                this.f183359a.app.addObserver(this.f183370l);
                ((IOnlineStatusManagerService) this.f183359a.app.getRuntimeService(IOnlineStatusManagerService.class, "")).addConfigUpdateListener(this.f183366h);
            }
            ((ITroopNotificationRepoApi) QRoute.api(ITroopNotificationRepoApi.class)).registerNotificationChangedObserver(this.f183359a, this.f183377s);
            this.f183365g.i();
            ((IGuildDelayInitializeService) this.f183359a.app.getRuntimeService(IGuildDelayInitializeService.class, "")).scheduleTask(new IGuildDelayInitializeService.InitializeTask("MainAssistObserver.registerObserversAndListensers delay guild updateRedPoint", new Function0() { // from class: com.tencent.mobileqq.activity.main.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit H;
                    H = MainAssistObserver.this.H();
                    return H;
                }
            }));
        } catch (NullPointerException e16) {
            e16.printStackTrace();
        }
        this.f183363e = true;
    }

    protected void R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (this.N == null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f183359a, 230);
            this.N = createCustomDialog;
            createCustomDialog.setMessage(R.string.d65);
            this.N.setTitle(R.string.b1v);
            this.N.setNegativeButton(R.string.cancel, new l());
            this.N.setPositiveButton(R.string.d5b, new m());
        }
        if (!this.N.isShowing()) {
            this.N.show();
        }
    }

    public void T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        SplashActivity splashActivity = this.f183359a;
        if (splashActivity == null || splashActivity.app == null || !this.f183363e) {
            return;
        }
        this.f183359a.app.unRegistObserver(this.f183373o);
        this.f183359a.app.removeObserver(this.f183372n);
        this.f183359a.app.removeObserver(this.D);
        this.f183359a.app.unRegistObserver(this.f183374p);
        this.f183359a.app.setMsgTabUnreadListener(null);
        this.f183359a.app.removeObserver(this.f183378t);
        ((INewFriendService) this.f183359a.app.getRuntimeService(INewFriendService.class)).removeListener(this.f183376r);
        ((ITroopNotificationRepoApi) QRoute.api(ITroopNotificationRepoApi.class)).unregisterNotificationChangeObserver(this.f183377s);
        this.f183359a.app.removeObserver(this.Q);
        this.f183359a.app.unRegistObserver(this.f183371m);
        ((TroopRedTouchHandler) this.f183359a.app.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER)).L2();
        this.f183365g.k();
        this.f183363e = false;
        this.f183359a.app.removeObserver(this.E);
        this.f183359a.app.removeObserver(this.P);
        this.f183359a.app.removeObserver(this.f183379u);
        this.f183359a.app.removeObserver(this.f183380v);
        this.f183359a.app.removeObserver(this.f183381w);
        this.f183359a.app.removeObserver(this.f183382x);
        if (af.i()) {
            this.f183359a.app.removeObserver(this.f183370l);
            this.f183359a.app.removeObserver(this.f183369k);
            this.f183359a.app.removeObserver(this.f183367i);
            this.f183359a.app.unRegistObserver(this.f183368j);
            ((IOnlineStatusManagerService) this.f183359a.app.getRuntimeService(IOnlineStatusManagerService.class, "")).removeConfigUpdateListener(this.f183366h);
        }
    }

    public void U() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        SplashActivity splashActivity = this.f183359a;
        if (splashActivity != null && (qQAppInterface = splashActivity.app) != null) {
            a0();
            ThreadManagerV2.post(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.activity.main.MainAssistObserver.20
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f183391d;

                {
                    this.f183391d = qQAppInterface;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this, (Object) qQAppInterface);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int H1 = this.f183391d.getMessageFacade().H1() + com.tencent.mobileqq.qcall.f.w(this.f183391d);
                    if (QLog.isColorLevel()) {
                        QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, "updateTab = " + H1);
                    }
                    this.f183391d.runOnUiThread(new Runnable(H1) { // from class: com.tencent.mobileqq.activity.main.MainAssistObserver.20.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f183392d;

                        {
                            this.f183392d = H1;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass20.this, H1);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            MainAssistObserver.this.W(32, 16, Integer.valueOf(this.f183392d));
                            AnonymousClass20.this.f183391d.getApp().sendBroadcast(new Intent("com.tencent.qq.syncQQMessage"));
                        }
                    });
                }
            }, 8, null, false);
            Y(7);
            X();
            Z(40, null);
            Z(49, null);
            Z(48, null);
            qQAppInterface.getApp().sendBroadcast(new Intent("com.tencent.qq.syncQQMessage"));
        }
    }

    public void V(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) redTypeInfo);
            return;
        }
        if (com.tencent.mobileqq.activity.leba.utils.a.f() && z(redTypeInfo) && this.f183359a != null && com.tencent.mobileqq.leba.feed.d.a()) {
            redTypeInfo = null;
        }
        Z(34, redTypeInfo);
    }

    public void W(int i3, int i16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), obj);
            return;
        }
        SplashActivity splashActivity = this.f183359a;
        if (splashActivity == null) {
            return;
        }
        splashActivity.updateMain(i3, i16, obj);
    }

    public void X() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        SplashActivity splashActivity = this.f183359a;
        if (splashActivity != null && (qQAppInterface = splashActivity.app) != null) {
            ThreadManagerV2.post(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.activity.main.MainAssistObserver.18
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f183390d;

                {
                    this.f183390d = qQAppInterface;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this, (Object) qQAppInterface);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        INewFriendService iNewFriendService = (INewFriendService) this.f183390d.getRuntimeService(INewFriendService.class);
                        int allUnreadMessageCount = iNewFriendService.getAllUnreadMessageCount();
                        if (QLog.isColorLevel()) {
                            QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 1, "updateTabContactNotify, totalCount = " + allUnreadMessageCount);
                        }
                        int notificationUnreadCount = ((ITroopNotificationRepoApi) QRoute.api(ITroopNotificationRepoApi.class)).getNotificationUnreadCount();
                        int i3 = allUnreadMessageCount + notificationUnreadCount;
                        if (QLog.isColorLevel()) {
                            QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 1, "updateTabContactNotify, totalCount = " + i3 + " notificationUnreadCount" + notificationUnreadCount);
                        }
                        int a16 = i3 + com.tencent.mobileqq.extendfriend.utils.a.a(this.f183390d);
                        if (a16 > 0) {
                            redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
                            redTypeInfo.red_type.set(5);
                            redTypeInfo.red_content.set(a16 + "");
                            redTypeInfo.red_desc.set("{'cn':'#FF0000'}");
                            if (QLog.isDebugVersion()) {
                                QLog.d("UndealCount.updateTabContactNotify", 2, "unread=" + a16);
                            }
                        } else if (iNewFriendService.needShowAvatar()) {
                            redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
                            redTypeInfo.red_type.set(0);
                            redTypeInfo.red_content.set("");
                            redTypeInfo.red_desc.set("");
                            if (QLog.isDebugVersion()) {
                                QLog.d("UndealCount.updateTabContactNotify", 2, RedTouchWebviewHandler.PLUGIN_NAMESPACE);
                            }
                        } else if (((INewFriendVerificationService) this.f183390d.getRuntimeService(INewFriendVerificationService.class)).isShowRedPoint()) {
                            redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
                            redTypeInfo.red_type.set(0);
                            redTypeInfo.red_content.set("");
                            redTypeInfo.red_desc.set("");
                            if (QLog.isColorLevel()) {
                                QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, "updateTabContactNotify redpoint");
                            }
                        } else {
                            redTypeInfo = null;
                        }
                        Message obtainMessage = MainAssistObserver.this.C.obtainMessage(3);
                        obtainMessage.obj = redTypeInfo;
                        MainAssistObserver.this.C.sendMessage(obtainMessage);
                        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("notification_badge_count_group_notification_9025_121000545", true)) {
                            ((IAppBadgeService) this.f183390d.getRuntimeService(IAppBadgeService.class)).refreshAppBadge();
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }, 8, null, false);
        }
    }

    public void Y(int i3) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        SplashActivity splashActivity = this.f183359a;
        if (splashActivity != null && (qQAppInterface = splashActivity.app) != null) {
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            if (QLog.isDevelopLevel()) {
                QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, "updateTabLebaNotify, curUin=" + currentAccountUin);
            }
            m(this.f183364f.l(i3, new g()));
            return;
        }
        QLog.d(LogTag.TAG_LEBA_NEW, 1, "updateTabLebaNotify but it's NewLeba!");
    }

    public void Z(int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) redTypeInfo);
            return;
        }
        SplashActivity splashActivity = this.f183359a;
        if (splashActivity == null) {
            return;
        }
        splashActivity.updateTabRedTouch(i3, redTypeInfo);
    }

    public void a0() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        SplashActivity splashActivity = this.f183359a;
        if (splashActivity != null && (qQAppInterface = splashActivity.app) != null) {
            ThreadManagerV2.post(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.activity.main.MainAssistObserver.17
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f183389d;

                {
                    this.f183389d = qQAppInterface;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this, (Object) qQAppInterface);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        IRedTouchManager iRedTouchManager = (IRedTouchManager) this.f183389d.getRuntimeService(IRedTouchManager.class, "");
                        BusinessInfoCheckUpdate.RedTypeInfo redTouchInfoByAppSet = iRedTouchManager.getRedTouchInfoByAppSet(1);
                        if (TianshuRedTouch.INSTANCE.j()) {
                            i3 = 0;
                        } else {
                            if (redTouchInfoByAppSet == null) {
                                LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) this.f183389d.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
                                localRedTouchManager.b(BusinessInfoCheckUpdateItem.UIAPPID_ME_PROFILE_LIKE_RANDKINGLIST, false);
                                boolean b16 = localRedTouchManager.b(10015, false) | localRedTouchManager.b(10016, false);
                                ProfileCardUtil.f(this.f183389d);
                                RedTouchItem j3 = localRedTouchManager.j(-3);
                                if (localRedTouchManager.d(j3, true)) {
                                    redTouchInfoByAppSet = new BusinessInfoCheckUpdate.RedTypeInfo();
                                    if (b16) {
                                        MainAssistObserver.this.P(this.f183389d);
                                    }
                                    QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 1, "updateTabSettingNotify me count=" + j3.count);
                                    i3 = 1;
                                    if (redTouchInfoByAppSet == null && com.tencent.mobileqq.upgrade.n.i()) {
                                        redTouchInfoByAppSet = new BusinessInfoCheckUpdate.RedTypeInfo();
                                        i3 = 2;
                                    }
                                    CardHandler cardHandler = (CardHandler) this.f183389d.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
                                    if (redTouchInfoByAppSet == null && !cardHandler.z4() && cardHandler.w4()) {
                                        redTouchInfoByAppSet = new BusinessInfoCheckUpdate.RedTypeInfo();
                                        i3 = 3;
                                    }
                                    if (redTouchInfoByAppSet == null && PrivacyPolicyHelper.needShowPrivacyPolicyOrUserAgreement(1)) {
                                        redTouchInfoByAppSet = new BusinessInfoCheckUpdate.RedTypeInfo();
                                        i3 = 4;
                                    }
                                }
                            }
                            i3 = 0;
                            if (redTouchInfoByAppSet == null) {
                                redTouchInfoByAppSet = new BusinessInfoCheckUpdate.RedTypeInfo();
                                i3 = 2;
                            }
                            CardHandler cardHandler2 = (CardHandler) this.f183389d.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
                            if (redTouchInfoByAppSet == null) {
                                redTouchInfoByAppSet = new BusinessInfoCheckUpdate.RedTypeInfo();
                                i3 = 3;
                            }
                            if (redTouchInfoByAppSet == null) {
                                redTouchInfoByAppSet = new BusinessInfoCheckUpdate.RedTypeInfo();
                                i3 = 4;
                            }
                        }
                        int numRedShowNumByAppSet = iRedTouchManager.getNumRedShowNumByAppSet(1);
                        if (redTouchInfoByAppSet != null) {
                            redTouchInfoByAppSet.red_type.set(0);
                        }
                        if (numRedShowNumByAppSet > 0) {
                            redTouchInfoByAppSet = new BusinessInfoCheckUpdate.RedTypeInfo();
                            redTouchInfoByAppSet.red_type.set(0);
                            i3 = 5;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, "updateTabSettingNotify: showRedFromWhere=" + i3);
                        }
                        Message obtainMessage = MainAssistObserver.this.C.obtainMessage(0);
                        obtainMessage.obj = redTouchInfoByAppSet;
                        MainAssistObserver.this.C.sendMessage(obtainMessage);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }, 8, null, false);
        }
    }

    protected void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        if (this.K == null) {
            SplashActivity splashActivity = this.f183359a;
            QQProgressDialog qQProgressDialog = new QQProgressDialog(splashActivity, splashActivity.getTitleBarHeight());
            this.K = qQProgressDialog;
            qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.nwu));
        }
        OpenID b36 = this.f183359a.app.getMsgHandler().b3(this.F);
        if (QLog.isColorLevel()) {
            QLog.i(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, "-->checkAccountDiff, mOpenid: " + this.G);
        }
        if (!TextUtils.isEmpty(this.G)) {
            if (b36 != null && !TextUtils.isEmpty(b36.openID)) {
                if (!this.G.equals(b36.openID)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, "-->checkAccountDiff, !mOpenId.equals(openId.openID) mOpenId =" + this.G + " openId.openID = " + b36.openID);
                    }
                    R();
                    return;
                }
                if (this.O) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, "-->checkAccountDiff, mOpenId.equals(openId.openID)  " + this.G);
                }
                if (BindGroupActivity.class.getSimpleName().equals(this.J)) {
                    Intent intent = new Intent(this.f183359a, (Class<?>) BindGroupActivity.class);
                    intent.putExtra("uin", this.f183359a.getCurrentAccountUin());
                    intent.putExtra("key_params", this.I);
                    this.f183359a.startActivity(intent);
                } else if (((ITroopSettingApi) QRoute.api(ITroopSettingApi.class)).getSimpleNameForTroopSettingActivity().equals(this.J)) {
                    SplashActivity splashActivity2 = this.f183359a;
                    Bundle bundle = this.I;
                    TroopUtils.I(splashActivity2, bundle, bundle.getInt(ITroopUtilsApi.VISTOR_TYPE, 1));
                } else if ("key_sdk_add_friend".equals(this.J)) {
                    Intent intent2 = new Intent();
                    intent2.putExtras(this.I);
                    ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(this.f183359a, intent2);
                } else if (com.tencent.mobileqq.forward.h.class.getSimpleName().equals(this.J)) {
                    FriendsManager friendsManager = (FriendsManager) this.f183359a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
                    String string = this.I.getString("uin", "");
                    if (friendsManager.c0(string)) {
                        if (this.I.getBoolean(AppConstants.Key.THRIPARTY_PULL_AIO, false)) {
                            Intent aliasIntent = SplashActivity.getAliasIntent(this.f183359a);
                            aliasIntent.putExtras(this.I);
                            aliasIntent.putExtra(AppConstants.Key.THRIPARTY_PULL_AIO, true);
                            String F = ac.F(this.f183359a.app, string);
                            if (F != null) {
                                aliasIntent.putExtra("uinname", F);
                            }
                            this.f183359a.startActivity(BaseAIOUtils.m(aliasIntent, new int[]{2}));
                        }
                    } else {
                        K(string);
                    }
                } else if (ForwardMiniAppThirdPartyHelper.class.getSimpleName().equals(this.J)) {
                    ForwardMiniAppThirdPartyHelper.launchMiniApp(this.f183359a, this.I.getString("mini_app_id", ""), this.I.getString(AppConstants.Key.THRIPARTY_PULL_MINI_APP_PATH, ""), this.I.getString(AppConstants.Key.THRIPARTY_PULL_MINI_APP_TYPE, "release"));
                }
                this.O = true;
                return;
            }
            this.K.setMessage(R.string.bj_);
            this.K.show();
            Handler handler = new Handler();
            this.L = handler;
            handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.main.MainAssistObserver.27
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MainAssistObserver.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, "-->onGetOpenId timeout.");
                    }
                    SplashActivity splashActivity3 = MainAssistObserver.this.f183359a;
                    if (splashActivity3 != null && !splashActivity3.isFinishing()) {
                        MainAssistObserver mainAssistObserver = MainAssistObserver.this;
                        mainAssistObserver.M = true;
                        mainAssistObserver.K.hide();
                    }
                }
            }, 3000L);
            com.tencent.mobileqq.app.handler.a.a(this.f183359a.app.getMsgHandler(), this.F);
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f183384z.set(0);
        this.f183383y.clear();
        this.f183364f.b();
        SplashActivity splashActivity = this.f183359a;
        if (splashActivity != null && splashActivity.app != null) {
            this.f183359a = null;
        }
    }

    public IGuildUnreadCntService.b t() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IGuildUnreadCntService.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        SplashActivity splashActivity = this.f183359a;
        if (splashActivity != null && (qQAppInterface = splashActivity.app) != null) {
            return this.f183365g.e(qQAppInterface);
        }
        return null;
    }

    public UpgradeDetailWrapper u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (UpgradeDetailWrapper) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        if (this.A == null) {
            this.A = com.tencent.mobileqq.upgrade.k.i().j();
        }
        return this.A;
    }

    public void v(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) intent);
            return;
        }
        if (intent == null) {
            return;
        }
        this.H = intent.getBooleanExtra("if_check_account_same", false);
        String stringExtra = intent.getStringExtra("key_action");
        this.J = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        Bundle extras = intent.getExtras();
        this.I = extras;
        if (extras == null) {
            return;
        }
        this.F = extras.getString("appid");
        this.G = this.I.getString("openid");
        if (QLog.isColorLevel()) {
            QLog.i(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 2, "if Check =" + this.H + " appid = " + this.F + " openId= " + this.G);
        }
        if (this.H) {
            p();
        }
    }

    public void x(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) intent);
            return;
        }
        if (intent == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        this.S = extras;
        if (extras == null) {
            return;
        }
        boolean z16 = extras.getBoolean(AppConstants.Key.THRIPARTY_PULL_MAIN, false);
        boolean z17 = this.S.getBoolean(AppConstants.Key.THRIPARTY_PREPARE_MINI_APP, false);
        zp3.d buildHelper = ((IOpenSdkCommonChannelJumpActionMgr) QRoute.api(IOpenSdkCommonChannelJumpActionMgr.class)).buildHelper(this.f183359a, intent);
        QLog.d(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_REDDOT, 1, "handleThirdPartyPullUp ICommonChannelJumpActionHandleHelper: " + buildHelper);
        if (z16) {
            L(this.S);
        } else if (z17) {
            M(this.S);
        } else if (buildHelper != null && !w(intent)) {
            N(this.S);
        }
        ((IOpenSdkJumpActionStashApi) QRoute.api(IOpenSdkJumpActionStashApi.class)).restoreHandleJumpAction(this.f183359a);
    }
}
