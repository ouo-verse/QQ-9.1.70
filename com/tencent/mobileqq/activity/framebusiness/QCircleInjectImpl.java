package com.tencent.mobileqq.activity.framebusiness;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.immersive.floatingwindow.model.QFSSmallWindowGlobalCollect;
import com.tencent.biz.qqcircle.richframework.preload.coldbootV2.QCircleColdBootPreloadFeedManagerV2;
import com.tencent.biz.qqcircle.utils.QCircleNetWorkTestHelper;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.request.VSNetQUICUtils;
import com.tencent.biz.richframework.network.util.StringUtils;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWLowDeviceAv1Exp;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWPlayerBusinessStrategyExp9095;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWVideoFluencyExp9095;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.home.impl.c;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.activity.qcircle.bubble.BubbleFailReason;
import com.tencent.mobileqq.activity.qcircle.bubble.QCircleRedPointBubbleReportInfo;
import com.tencent.mobileqq.activity.qcircle.bubble.QCircleTabRedPointBubbleShowController;
import com.tencent.mobileqq.activity.qcircle.bubble.QCircleTianShuBubbleReporter;
import com.tencent.mobileqq.activity.qcircle.bubble.RedPointDismissSource;
import com.tencent.mobileqq.activity.qcircle.tab.QCircleTabAvatarHelper;
import com.tencent.mobileqq.activity.qcircle.tab.QCircleTabRedPointJumpHandler;
import com.tencent.mobileqq.activity.qcircle.tab.UpdateTabAvatarSource;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.auto.engine.lib.IBackEventListener;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qcircle.api.data.QCircleRedInfoBean;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleRedInfoEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSSelectTabEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.helper.QCircleRedDotDataHelper;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.mobileqq.qcircle.api.utils.QCircleStyleTabExtKt;
import com.tencent.mobileqq.qcircle.api.utils.RedPointInfoExtKt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchTab;
import com.tencent.mobileqq.rfw.common.api.IRFWCommonConfigService;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.theme.ThemeVideoController;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.mobileqq.widget.TabViewMap;
import com.tencent.qcircle.cooperation.config.AccountChangeEvent;
import com.tencent.qcircle.cooperation.config.AccountKickedEvent;
import com.tencent.qcircle.cooperation.config.AccountLoginOutEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import p40.f;
import p40.l;
import qqcircle.QQCircleCounter$RedPointInfo;
import qqcircle.QQCircleCounterStyle$StyleTab;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QCircleInjectImpl extends com.tencent.mobileqq.activity.framebusiness.a implements SimpleEventReceiver {
    static IPatchRedirector $redirector_;
    private static com.tencent.mobileqq.activity.home.impl.d C;
    public static boolean D;
    public static boolean E;
    private static int F;
    private static long G;
    private static final QCircleTabRedPointJumpHandler H;
    private static BroadcastReceiver I;
    private static Application.ActivityLifecycleCallbacks J;
    private static String K;
    private static AtomicInteger L;
    private static final Runnable M;
    private static int N;
    private static RFWNavigationBarImmersiveHelper.NavigationBarHeightChangeCallback P;

    /* renamed from: f, reason: collision with root package name */
    private static WeakReference<FrameFragment> f182289f;

    /* renamed from: h, reason: collision with root package name */
    private static com.tencent.mobileqq.activity.qcircle.utils.b f182290h;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f182291i;

    /* renamed from: m, reason: collision with root package name */
    private static StudyModeChangeListener f182292m;

    /* renamed from: d, reason: collision with root package name */
    private boolean f182293d;

    /* renamed from: e, reason: collision with root package name */
    private g f182294e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl$2, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameFragment f182295d;

        AnonymousClass2(FrameFragment frameFragment) {
            this.f182295d = frameFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) frameFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(FrameFragment frameFragment, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, boolean z16) {
            if (TianshuRedTouch.INSTANCE.j()) {
                TianshuRedTouch redBadge = frameFragment.getRedBadge(com.tencent.mobileqq.activity.home.impl.b.f183055r);
                if (redBadge != null) {
                    ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateRedBadge(frameFragment, 40, redBadge, redTypeInfo);
                }
            } else {
                View tabNotifyIcon = frameFragment.getTabNotifyIcon(com.tencent.mobileqq.activity.home.impl.b.f183055r);
                if (!(tabNotifyIcon instanceof RedTouch)) {
                    return;
                } else {
                    ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateRedTouch(frameFragment, 40, (RedTouch) tabNotifyIcon, redTypeInfo);
                }
            }
            QCircleRedInfoBean redInfoBean = QCircleFrame.getRedInfoBean();
            QCircleInjectImpl.e0(redInfoBean, z16, frameFragment);
            QCircleInjectImpl.g0(redInfoBean, z16);
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            FrameFragment frameFragment = this.f182295d;
            if (frameFragment == null || !frameFragment.hasTabNotifyIcon().booleanValue() || this.f182295d.mUiHandler == null) {
                return;
            }
            final boolean equals = QCircleFrame.class.getName().equals(this.f182295d.getCurrentTabName());
            final BusinessInfoCheckUpdate.RedTypeInfo qQRedTypeInfo = QCircleFrame.getQQRedTypeInfo(equals);
            final FrameFragment frameFragment2 = this.f182295d;
            frameFragment2.mUiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.z
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleInjectImpl.AnonymousClass2.b(FrameFragment.this, qQRedTypeInfo, equals);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements com.tencent.mobileqq.activity.qcircle.bubble.n {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQCircleCounter$RedPointInfo f182297a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QCircleRedPointBubbleReportInfo f182298b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QCircleRedInfoBean f182299c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameFragment f182300d;

        a(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo, QCircleRedPointBubbleReportInfo qCircleRedPointBubbleReportInfo, QCircleRedInfoBean qCircleRedInfoBean, FrameFragment frameFragment) {
            this.f182297a = qQCircleCounter$RedPointInfo;
            this.f182298b = qCircleRedPointBubbleReportInfo;
            this.f182299c = qCircleRedInfoBean;
            this.f182300d = frameFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQCircleCounter$RedPointInfo, qCircleRedPointBubbleReportInfo, qCircleRedInfoBean, frameFragment);
            }
        }

        @Override // com.tencent.mobileqq.activity.qcircle.bubble.n
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            QLog.i("QCBT-QCircleInjectImpl", 1, "handleRedPointTips onShow, loadImageTimeout=" + z16);
            this.f182299c.setLastExposedBubble(this.f182297a);
            QCircleInjectImpl.L0(this.f182299c.getRedDotReportExt(), z16 ^ true);
            QCircleFrame.reportDcQQCircleBubbleShow(this.f182298b);
            QCircleTianShuBubbleReporter.q();
        }

        @Override // com.tencent.mobileqq.activity.qcircle.bubble.n
        public void b(@NonNull BubbleFailReason bubbleFailReason) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bubbleFailReason);
                return;
            }
            QLog.e("QCBT-QCircleInjectImpl", 1, "handleRedPointTips onFailed, reason=" + bubbleFailReason.name());
            if (bubbleFailReason == BubbleFailReason.INTERCEPTED) {
                this.f182297a.allPushInfo.styleBottomTab.bubble.clear();
                QCircleFrame.reportDcQCircleBubbleInterceptByTianShu(this.f182298b);
                QCircleFrame.reportDTQCircleBubbleInterceptByTianShu(this.f182298b);
            } else if (bubbleFailReason == BubbleFailReason.EXPIRED) {
                this.f182297a.allPushInfo.styleBottomTab.bubble.clear();
            }
        }

        @Override // com.tencent.mobileqq.activity.qcircle.bubble.n
        public void onClick() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            QLog.i("QCBT-QCircleInjectImpl", 1, "handleRedPointTips onClick");
            QCircleHostGlobalInfo.setCurrentTabActive(!com.tencent.mobileqq.activity.qcircle.utils.c.i());
            QCircleInjectImpl.d0(this.f182297a);
            this.f182300d.setCurrentTab(QCircleInjectImpl.b0(this.f182300d));
        }

        @Override // com.tencent.mobileqq.activity.qcircle.bubble.n
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            QLog.i("QCBT-QCircleInjectImpl", 1, "handleRedPointTips onDismiss, reportInfo=" + this.f182298b);
            QCircleFrame.reportDcQQCircleRedDotClear(this.f182298b);
            QCircleTabAvatarHelper.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements Application.ActivityLifecycleCallbacks {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
                return;
            }
            if (activity instanceof SplashActivity) {
                com.tencent.mobileqq.auto.engine.main.c.a(activity);
                QLog.d("QCBT-QCircleInjectImpl", 1, "on activity resume:" + activity.getClass());
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) bundle);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).mainPageReport(com.tencent.mobileqq.dt.api.c.S, motionEvent);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).mainPageReport(com.tencent.mobileqq.dt.api.c.S, motionEvent);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements QzoneConfig.QzoneConfigChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameFragment f182301d;

        e(FrameFragment frameFragment) {
            this.f182301d = frameFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) frameFragment);
            }
        }

        @Override // common.config.service.QzoneConfig.QzoneConfigChangeListener
        public void onConfigChange() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d("QCBT-QCircleInjectImpl", 2, "onConfigChange = " + this.f182301d);
            if (this.f182301d.getBaseActivity() != null) {
                QCircleInjectImpl.f182289f = new WeakReference(this.f182301d);
                QCircleInjectImpl.S0(this.f182301d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class f implements IBackEventListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<FrameFragment> f182302a;

        f(FrameFragment frameFragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) frameFragment);
            } else {
                this.f182302a = new WeakReference<>(frameFragment);
            }
        }

        @Override // com.tencent.mobileqq.auto.engine.lib.IBackEventListener
        public void onBackEvent(boolean z16, String str) {
            FrameFragment frameFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else if (ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE.equals(str) && (frameFragment = this.f182302a.get()) != null) {
                QCircleInjectImpl.A0(frameFragment, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private static class g implements IGuardInterface {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QCircleInjectImpl> f182303d;

        public g(QCircleInjectImpl qCircleInjectImpl) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qCircleInjectImpl);
            } else {
                this.f182303d = new WeakReference<>(qCircleInjectImpl);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            QCircleInjectImpl qCircleInjectImpl;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            WeakReference<QCircleInjectImpl> weakReference = this.f182303d;
            if (weakReference == null) {
                qCircleInjectImpl = null;
            } else {
                qCircleInjectImpl = weakReference.get();
            }
            if (qCircleInjectImpl != null) {
                qCircleInjectImpl.h0();
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class h implements f.c {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // p40.f.c
        public Activity a() {
            FrameFragment frameFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Activity) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            if (QCircleInjectImpl.f182289f == null || (frameFragment = (FrameFragment) QCircleInjectImpl.f182289f.get()) == null) {
                return null;
            }
            return frameFragment.getActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class i extends FrameFragment.DragViewPunctureClickListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a extends l.d {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f182304a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ FrameFragment f182305b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ View f182306c;

            a(boolean z16, FrameFragment frameFragment, View view) {
                this.f182304a = z16;
                this.f182305b = frameFragment;
                this.f182306c = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, i.this, Boolean.valueOf(z16), frameFragment, view);
                }
            }

            @Override // p40.l.d
            public void b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (!this.f182304a) {
                    k30.h.f().r(this.f182305b.getActivity());
                }
                i.this.b(this.f182306c);
            }
        }

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(View view) {
            super.onClick(view);
        }

        @Override // com.tencent.mobileqq.app.FrameFragment.DragViewPunctureClickListener, android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (QCircleInjectImpl.f182289f == null) {
                b(view);
            } else {
                FrameFragment frameFragment = (FrameFragment) QCircleInjectImpl.f182289f.get();
                if (frameFragment == null) {
                    b(view);
                } else {
                    be currentFrame = frameFragment.getCurrentFrame();
                    if (currentFrame instanceof QCircleFrame) {
                        ((QCircleFrame) currentFrame).onTabClickSelf();
                        b(view);
                    } else {
                        boolean w3 = p40.l.w();
                        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_hook_bottom_click_for_float", true)) {
                            if (!w3) {
                                k30.h.f().r(frameFragment.getActivity());
                            }
                            p40.l.t().m(frameFragment.getActivity(), null);
                            b(view);
                        } else {
                            p40.l.t().m(frameFragment.getActivity(), new a(w3, frameFragment, view));
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68323);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
            return;
        }
        f182290h = new com.tencent.mobileqq.activity.qcircle.utils.b();
        f182291i = false;
        H = new QCircleTabRedPointJumpHandler();
        L = new AtomicInteger(0);
        M = new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                for (String str : com.tencent.biz.qqcircle.utils.l.f92776b) {
                    String b16 = com.tencent.biz.qqcircle.utils.l.b(str);
                    if (!StringUtils.isEmpty(b16)) {
                        com.tencent.biz.qqcircle.utils.l.f92776b.remove(str);
                        com.tencent.biz.qqcircle.utils.l.i(str);
                        QLog.d("QCBT-QCircleInjectImpl", 2, "[sRetryRunnableTAB1505] reportExperimentExport " + b16);
                    }
                }
                QCircleInjectImpl.M0();
            }
        };
        P = new RFWNavigationBarImmersiveHelper.NavigationBarHeightChangeCallback() { // from class: com.tencent.mobileqq.activity.framebusiness.p
            @Override // com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper.NavigationBarHeightChangeCallback
            public final void onChange(int i3, int i16, int i17) {
                QCircleInjectImpl.N = i3;
            }
        };
    }

    public QCircleInjectImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void A0(FrameFragment frameFragment, boolean z16) {
        if (frameFragment != null && frameFragment.getBaseActivity() != null) {
            if (z16) {
                QLog.d("ASDynamicEngine_back", 1, "onFlashShowBackEventCall flashShowFrame: true");
            } else if (com.tencent.mobileqq.activity.qcircle.utils.c.i()) {
                B0(frameFragment);
            } else {
                frameFragment.getBaseActivity().moveTaskToBack(true);
                QLog.d("ASDynamicEngine_back", 1, "onFlashShowBackEventCall flashShowFrame: false");
            }
        }
    }

    private static void B0(FrameFragment frameFragment) {
        if (W()) {
            QLog.d("ASDynamicEngine_back", 1, "onQCirclePadBackEventCall is loop, return");
        } else {
            QLog.d("ASDynamicEngine_back", 1, "onQCirclePadBackEventCall QCircleFrame: doOnBackPressed");
            frameFragment.getBaseActivity().doOnBackPressed();
        }
    }

    private static void C0() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_video_report_seek_rate", false)) {
            return;
        }
        VideoReport.supportSeekReport(true);
        VideoReport.supportSpeedRatioReport(true);
        QLog.d("QCBT-QCircleInjectImpl", 1, "openVideoReport");
    }

    private static void D0(FrameFragment frameFragment) {
        if (uq3.c.W0("qqcircle", "qqcircle_bottom_preload_view", Boolean.TRUE).booleanValue()) {
            QLog.d("QCBT-QCircleInjectImpl", 1, "do preLoadView");
            frameFragment.loadFrameContent("com.tencent.mobileqq.activity.qcircle.QCircleFrame", true);
            be frame = frameFragment.getFrame(QCircleFrame.class);
            if (frame instanceof QCircleFrame) {
                ((QCircleFrame) frame).tryInitFastPlayVideoView(frameFragment);
            }
        }
    }

    public static void E0(final FrameFragment frameFragment) {
        QLog.d(TabFrameControllerImpl.TAG, 1, "preLoadViewAndCheckDynamicPlugin init after message tab 0");
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.activity.framebusiness.u
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean u06;
                u06 = QCircleInjectImpl.u0(FrameFragment.this);
                return u06;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F0() {
        if (RFWApplication.getApplication() == null) {
            return;
        }
        if (I != null) {
            QLog.d("QCBT-QCircleInjectImpl", 1, "has registered");
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        intentFilter.addAction(NewIntent.ACTION_FORCE_LOGOUT);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        intentFilter.addAction(NewIntent.ACTION_LOGIN);
        I = new BroadcastReceiver() { // from class: com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                } else {
                    ThreadManagerV2.excute(new Runnable(intent) { // from class: com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.7.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Intent f182296d;

                        {
                            this.f182296d = intent;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this, (Object) intent);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (this.f182296d.getAction().equals(NewIntent.ACTION_ACCOUNT_CHANGED)) {
                                QLog.d("QCBT-QCircleInjectImpl", 1, "account chang from receiver");
                                bb0.e.f().o();
                                QCircleInjectImpl.Y();
                                SimpleEventBus.getInstance().dispatchEvent(new AccountChangeEvent(true));
                                QCircleTabRedPointBubbleShowController.p(RedPointDismissSource.CHANGE_ACCOUNT);
                                QCircleTabAvatarHelper.N(new QQCircleCounter$RedPointInfo(), UpdateTabAvatarSource.CHANGE_ACCOUNT);
                                QCircleFeedPicLoader.g().deleteSdCacheIfNeed();
                                RFWLowDeviceAv1Exp.onAccountChange();
                                RFWVideoFluencyExp9095.onAccountChange();
                                com.tencent.biz.qqcircle.utils.l.k();
                                com.tencent.biz.qqcircle.utils.m.f92779a.d(null);
                                com.tencent.biz.qqcircle.richframework.preload.coldbootV2.i.c();
                                QCircleNativeSessionManager.g().clearSession();
                                QCircleInjectImpl.O0();
                                com.tencent.biz.qqcircle.immersive.personal.utils.k.i();
                                k30.n.k().p();
                                p40.n.e().a();
                                com.tencent.mobileqq.activity.qcircle.k.i();
                                ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).onAccountChange();
                                ((IQCircle571ABTestApi) QRoute.api(IQCircle571ABTestApi.class)).onAccountChange();
                                ac0.c.b();
                                com.tencent.biz.qqcircle.utils.k.i();
                                ((IQCircleRFWApi) QRoute.api(IQCircleRFWApi.class)).notifyAccountChange();
                                RFWPlayerBusinessStrategyExp9095.onAccountChange();
                                EeveeRedpointUtil.setLastExposeRedPointInfo(null);
                                com.tencent.biz.qqcircle.immersive.utils.o.h();
                                o70.a.j();
                            }
                            if (this.f182296d.getAction().equals(NewIntent.ACTION_ACCOUNT_KICKED)) {
                                SimpleEventBus.getInstance().dispatchEvent(new AccountKickedEvent());
                            }
                            if (this.f182296d.getAction().equals(NewIntent.ACTION_LOGOUT)) {
                                SimpleEventBus.getInstance().dispatchEvent(new AccountLoginOutEvent());
                            }
                        }
                    }, 16, null, true);
                }
            }
        };
        MobileQQ.sMobileQQ.registerReceiver(I, intentFilter);
    }

    private static void G0() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_thub_thread_exectue_qcircleinject_change", true)) {
            QLog.d("QCBT-QCircleInjectImpl", 1, "registerAccountChange async");
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.y
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleInjectImpl.F0();
                }
            });
        } else {
            F0();
        }
    }

    private static void H0() {
        if (!uq3.o.n() || Build.VERSION.SDK_INT < 35 || J != null) {
            return;
        }
        J = new b();
        RFWLifecycleHelper.getInstance().registerActivityLifecycleCallback(J);
    }

    private static void I0() {
        f182292m = new StudyModeChangeListener() { // from class: com.tencent.mobileqq.activity.framebusiness.x
            @Override // com.tencent.mobileqq.studymode.StudyModeChangeListener
            public final void onChange(boolean z16) {
                QCircleInjectImpl.v0(z16);
            }
        };
        ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).registerStudyModeChangeListener(f182292m);
    }

    private static void J0() {
        Runnable runnable = M;
        if (runnable != null) {
            RFWThreadManager.getInstance().remove(runnable);
        }
    }

    private void K0(FrameFragment frameFragment, int i3, be beVar, int i16) {
        TianshuRedTouch redBadge;
        boolean z16;
        IRedTouchManager iRedTouchManager;
        String traceInfo;
        if (frameFragment != null && (redBadge = frameFragment.getRedBadge(com.tencent.mobileqq.activity.home.impl.b.f183055r)) != null) {
            String tabNameFromTabIndex = ((ITabFrameController) QRoute.api(ITabFrameController.class)).getTabNameFromTabIndex(i16);
            if (tabNameFromTabIndex != null) {
                z16 = tabNameFromTabIndex.equals(com.tencent.mobileqq.activity.home.impl.b.F);
            } else {
                z16 = false;
            }
            Boolean valueOf = Boolean.valueOf(z16);
            AppRuntime appRuntime = frameFragment.app;
            if (appRuntime != null && (iRedTouchManager = (IRedTouchManager) appRuntime.getRuntimeService(IRedTouchManager.class, "")) != null && (traceInfo = iRedTouchManager.getTraceInfo()) != null) {
                redBadge.setExtraData(traceInfo);
            }
            com.tencent.mobileqq.activity.home.impl.b.j(redBadge, com.tencent.mobileqq.activity.home.impl.b.g(102), com.tencent.mobileqq.activity.home.impl.b.f(redBadge.O()), valueOf);
        }
    }

    public static void L0(String str, boolean z16) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EXTERNAL_ENTRANCE, QCircleDaTongConstant.ElementParamValue.QQ_MAIN_TAB);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_RECOM_TYPE, str);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_BUBBLE_IS_IMAGE_DOWNLOAD, Integer.valueOf(z16 ? 1 : 0));
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_EXTERNAL_BUBBLE_IMP, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void M0() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[retryTab1505Report] retry size = ");
        List<String> list = com.tencent.biz.qqcircle.utils.l.f92776b;
        sb5.append(RFSafeListUtils.getSize(list));
        QLog.d("QCBT-QCircleInjectImpl", 4, sb5.toString());
        if (!RFSafeListUtils.isEmpty(list) && L.incrementAndGet() <= uq3.o.G()) {
            RFWThreadManager.getInstance().execOnSubThread(M, uq3.o.H());
        }
    }

    private void N0(FrameFragment frameFragment) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_forbbiden_drwaer_by_dynamic", true)) {
            if (n0(frameFragment)) {
                FrameHelperActivity.gj(false, "QCBT-QCircleInjectImpl_setDrawerNotEnableIfNeed");
                QLog.d("QCBT-QCircleInjectImpl", 1, "setDrawerNotEnableIfNeed true");
                return;
            }
            return;
        }
        if (this.f182293d) {
            FrameHelperActivity.gj(false, "QCBT-QCircleInjectImpl");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void O0() {
        com.tencent.biz.qqcircle.utils.l.f92776b.clear();
        L.set(0);
        J0();
        P0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void P0() {
        if (!uq3.o.I0()) {
            return;
        }
        for (String str : com.tencent.biz.qqcircle.utils.l.f92775a) {
            String b16 = com.tencent.biz.qqcircle.utils.l.b(str);
            if (!StringUtils.isEmpty(b16)) {
                com.tencent.biz.qqcircle.utils.l.i(str);
                QLog.d("QCBT-QCircleInjectImpl", 2, "[tab1505ReportWhenOpenQQ] reportExperimentExport " + b16);
            } else {
                com.tencent.biz.qqcircle.utils.l.f92776b.add(str);
            }
        }
        M0();
    }

    public static void Q0(FrameFragment frameFragment, String str) {
        R0(frameFragment, str, false);
    }

    public static void R0(FrameFragment frameFragment, String str, boolean z16) {
        String str2 = "update at " + str + ", isResume=" + E;
        if (!TextUtils.equals(K, str2)) {
            QLog.i("updateQCircleRedDot", 1, str2);
            K = str2;
        }
        if (!f182291i) {
            QLog.i("updateQCircleRedDot", 1, "will not update QCircleRedDot because not show at" + str);
            return;
        }
        ThreadManagerV2.executeOnSubThread(new AnonymousClass2(frameFragment));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void S0(@NonNull final FrameFragment frameFragment) {
        View view;
        final TextView textView;
        final String O3 = uq3.c.O3();
        if (frameFragment.mTabTextView == null || frameFragment.getActivity() == null || frameFragment.getActivity().isFinishing() || (view = frameFragment.mTabViewMap.get(TabDataHelper.TAB_NEW_WORLD)) == null || (textView = (TextView) view.findViewById(R.id.kbi)) == null || TextUtils.equals(textView.getText().toString(), O3)) {
            return;
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.s
            @Override // java.lang.Runnable
            public final void run() {
                QCircleInjectImpl.x0(textView, O3, frameFragment);
            }
        });
    }

    public static boolean V(QCircleRedInfoBean qCircleRedInfoBean) {
        if (qCircleRedInfoBean == null) {
            return false;
        }
        String redPointId = EeveeRedpointUtil.getRedPointId(qCircleRedInfoBean.getRedPointInfo());
        if (!qCircleRedInfoBean.isShowRedDot() || !EeveeRedpointUtil.enableNumRedShowAvatar(qCircleRedInfoBean.getRedPointInfo()) || TextUtils.equals(redPointId, uq3.k.a().h("sp_key_last_insert_red_point_id", ""))) {
            return false;
        }
        return true;
    }

    private static boolean W() {
        if (F == 0) {
            G = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - G > 500) {
            F = 0;
            G = System.currentTimeMillis();
        }
        int i3 = F + 1;
        F = i3;
        if (i3 <= 4) {
            return false;
        }
        return true;
    }

    private static void X(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, com.tencent.mobileqq.activity.home.impl.d dVar) {
        com.tencent.mobileqq.qcircle.api.global.a.d();
        C = dVar;
        com.tencent.mobileqq.activity.qcircle.utils.b.s(dVar);
        if (dVar.c(TabDataHelper.TAB_NEW_WORLD)) {
            QFSSmallWindowGlobalCollect.k().j(frameFragment);
            if (frameFragment.mTabViewMap.get(TabDataHelper.TAB_NEW_WORLD) == null) {
                com.tencent.mobileqq.activity.home.impl.c frameInfoByClazz = ((ITabFrameController) QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(QCircleFrame.class);
                View generateTabItem = tabFrameControllerImpl.generateTabItem(frameInfoByClazz.i(), frameInfoByClazz.d(), frameInfoByClazz.j(), frameInfoByClazz.e(), frameInfoByClazz.p(), frameInfoByClazz.a(), frameInfoByClazz.b(), frameInfoByClazz.f(), frameInfoByClazz.g(), frameInfoByClazz.o(), frameInfoByClazz.n());
                if (generateTabItem == null) {
                    QLog.e(TabFrameControllerImpl.TAG, 1, "initQCircleTab qcircleTab is generate null");
                    return;
                }
                generateTabItem.setId(23);
                generateTabItem.setOnTouchListener(new c());
                generateTabItem.setOnClickListener(new i());
                frameFragment.mTabViewMap.put(TabDataHelper.TAB_NEW_WORLD, Z(frameFragment.getBaseActivity(), generateTabItem, TabDataHelper.TAB_NEW_WORLD));
                QLog.i("FrameUtil.QCBT-QCircleInjectImpl", 1, "doInitTabView  key:NEW_WORLD, RedTouchTab=" + frameFragment.mTabViewMap.get(TabDataHelper.TAB_NEW_WORLD));
                generateTabItem.setContentDescription(frameFragment.getResources().getString(R.string.f181523e0));
            }
            QLog.i(TabFrameControllerImpl.TAG, 1, "initQCircleTab mTabs[8] is not null");
            String str = com.tencent.mobileqq.activity.home.impl.b.f183055r;
            frameFragment.setTabNotifyIcon(str, frameFragment.mTabViewMap.get(TabDataHelper.TAB_NEW_WORLD));
            frameFragment.setTabNotifyIcon(str + "_num", frameFragment.mTabViewMap.get(TabDataHelper.TAB_NEW_WORLD).findViewById(R.id.khc));
            TabDragAnimationView tabDragAnimationView = (TabDragAnimationView) frameFragment.mTabViewMap.get(TabDataHelper.TAB_NEW_WORLD).findViewById(R.id.j_k);
            if (tabDragAnimationView != null) {
                tabDragAnimationView.setOnTouchListener(new d());
            }
            TextView textView = (TextView) frameFragment.mTabViewMap.get(TabDataHelper.TAB_NEW_WORLD).findViewById(R.id.kbi);
            TabDragAnimationView.G(textView);
            if (tabDragAnimationView != null && textView != null) {
                frameFragment.mTabDragIcon.put(com.tencent.mobileqq.activity.home.impl.a.f183046i, tabDragAnimationView);
                frameFragment.mTabTextView.put(com.tencent.mobileqq.activity.home.impl.a.f183046i, textView);
                tabFrameControllerImpl.addFrame(frameFragment, frameFragment.mRootView, QCircleFrame.class, frameFragment.mTabViewMap.get(TabDataHelper.TAB_NEW_WORLD));
                f182291i = true;
                QLog.i(TabFrameControllerImpl.TAG, 1, "initQCircleTab addFrame success FrameControllerUtil.QCircleTab=" + com.tencent.mobileqq.activity.home.impl.a.f183046i + ", tabDragAnimationView=" + tabDragAnimationView);
            }
        } else {
            if (TabFrameControllerImpl.isLazyLoadTabView()) {
                frameFragment.mTabViewMap.remove(TabDataHelper.TAB_NEW_WORLD);
            }
            frameFragment.mTabDragIcon.remove(com.tencent.mobileqq.activity.home.impl.a.f183046i);
            frameFragment.mTabTextView.remove(com.tencent.mobileqq.activity.home.impl.a.f183046i);
            frameFragment.removeFrame(QCircleFrame.class);
            f182291i = false;
            QLog.i(TabFrameControllerImpl.TAG, 1, "initQCircleTab remove qcircleTab");
        }
        l0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Y() {
        QLog.d("QCBT-QCircleInjectImpl", 1, "doLoginInit");
        bb0.e.f().c();
        if (com.tencent.biz.qqcircle.richframework.preload.coldbootV2.i.a()) {
            QLog.d("QCBT-QCircleInjectImpl", 1, "[doLoginInit] init eevee");
            com.tencent.mobileqq.activity.qcircle.utils.c.d().onSend(4, null, null);
            ((IRFWCommonConfigService) QRoute.api(IRFWCommonConfigService.class)).onSend(3);
        } else {
            QLog.d("QCBT-QCircleInjectImpl", 1, "[doLoginInit] init QCircleColdBootPreloadFeedManagerV2");
            QCircleColdBootPreloadFeedManagerV2.getInstance().doPrepareSpData();
        }
        com.tencent.biz.qqcircle.helpers.o.a().b();
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.r
            @Override // java.lang.Runnable
            public final void run() {
                QCircleInjectImpl.q0();
            }
        });
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (!z20.h.c()) {
                    z20.f.k().o();
                    QLog.d("QCBT-QCircleInjectImpl", 1, "[doLoginInit] not hit exp, preload disk feed.");
                }
                bb0.b.i().s();
                com.tencent.mobileqq.activity.qcircle.k.l();
                VSNetQUICUtils.retryPingReq();
            }
        }, 3000L);
    }

    private static View Z(Context context, View view, String str) {
        if (TianshuRedTouch.INSTANCE.j()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388659;
            layoutParams.topMargin = 10;
            layoutParams.leftMargin = 5;
            TianshuRedTouch t16 = new TianshuRedTouch(context, view).h0(49).k0(layoutParams).p0(TianshuRedTouch.RedTouchAssembleType.ME_REDTOUCH).r0(2.0f).j0(14.0f).t();
            QLog.d("QCBT-QCircleInjectImpl", 1, "TianshuRedTouch buildTabIcon redTouch: " + str, "view" + view.toString());
            t16.n0("140110");
            return t16;
        }
        RedTouch useRobotoTtf = new RedTouchTab(context, view).setGravity(49).setTopMargin(3.0f).setLeftAlign(true).setLeftMargin(5).applyTo().setUseRobotoTtf();
        QLog.d("QCBT-QCircleInjectImpl", 1, "buildTabIcon redTouch: " + str);
        return useRobotoTtf;
    }

    public static QzoneConfig.QzoneConfigChangeListener a0(FrameFragment frameFragment) {
        MainFragment mainFragment = (MainFragment) frameFragment;
        if (mainFragment.f182814v0 == null) {
            f182289f = new WeakReference<>(frameFragment);
            mainFragment.f182814v0 = new e(frameFragment);
        }
        return mainFragment.f182814v0;
    }

    public static int b0(FrameFragment frameFragment) {
        com.tencent.mobileqq.activity.home.impl.d dVar;
        ArrayList<FrameFragment.e> arrayList = frameFragment.mTabHostTabList;
        if (arrayList.size() >= 4 && (dVar = C) != null) {
            if (dVar.c("GUILD") && arrayList.size() == 5) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    private String c0() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getAccount();
        } else {
            str = null;
        }
        if (str == null) {
            return MobileQQ.sMobileQQ.getLastLoginUin();
        }
        return str;
    }

    public static void d0(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        if (qQCircleCounter$RedPointInfo == null) {
            QLog.i("QCBT-QCircleInjectImpl", 1, "handleRedPointJumpInfo, redPointInfo=null");
        } else if (!uq3.c.o0()) {
            QLog.e("QCBT-QCircleInjectImpl", 1, "tab red dot jump wns not enable");
        } else {
            H.c(qQCircleCounter$RedPointInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e0(QCircleRedInfoBean qCircleRedInfoBean, boolean z16, FrameFragment frameFragment) {
        String redDotReportExt;
        String tabTipWording;
        QQCircleCounter$RedPointInfo redPointInfo = qCircleRedInfoBean.getRedPointInfo();
        QQCircleCounterStyle$StyleTab qQCircleCounterStyle$StyleTab = redPointInfo.allPushInfo.styleBottomTab.get();
        if (o0(redPointInfo, qCircleRedInfoBean.getLastExposedBubble())) {
            QLog.i("QCBT-QCircleInjectImpl", 2, "handleRedPointTips, sameBubble");
            return;
        }
        if (RedPointInfoExtKt.isContentEmpty(qQCircleCounterStyle$StyleTab.bubble.get())) {
            qCircleRedInfoBean.setLastExposedRedPointInfo(redPointInfo);
            return;
        }
        if (y0(frameFragment, z16, redPointInfo)) {
            String outLayerRedType = QCircleFrame.getOutLayerRedType(qCircleRedInfoBean);
            String dtRedDotType = QCircleFrame.getDtRedDotType(qCircleRedInfoBean);
            if (qCircleRedInfoBean.getRedDotReportExt() == null) {
                redDotReportExt = "";
            } else {
                redDotReportExt = qCircleRedInfoBean.getRedDotReportExt();
            }
            String str = qCircleRedInfoBean.getLastExposedRedPointInfo().extend.get();
            if (qCircleRedInfoBean.getTabTipWording() == null) {
                tabTipWording = "";
            } else {
                tabTipWording = qCircleRedInfoBean.getTabTipWording();
            }
            QCircleTabRedPointBubbleShowController.x(frameFragment, redPointInfo, new a(redPointInfo, new QCircleRedPointBubbleReportInfo(outLayerRedType, dtRedDotType, redDotReportExt, str, tabTipWording, com.tencent.mobileqq.activity.qcircle.utils.d.a(qCircleRedInfoBean.getRedPointInfo().allPushInfo.styleBottomTab.bubble.get())), qCircleRedInfoBean, frameFragment));
            qCircleRedInfoBean.setLastExposedRedPointInfo(redPointInfo);
        }
    }

    private void f0(boolean z16) {
        f182290h.z(z16);
        WeakReference<FrameFragment> weakReference = f182289f;
        if (weakReference != null) {
            f182290h.g(weakReference.get());
        }
        if (uq3.o.A()) {
            QLog.d("QCBT-QCircleInjectImpl", 1, "[handleSelectTabEvent] release other player");
            SuperPlayerSDKMgr.releaseOtherScened(String.valueOf(126));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g0(QCircleRedInfoBean qCircleRedInfoBean, boolean z16) {
        if (z16) {
            QCircleTabAvatarHelper.N(new QQCircleCounter$RedPointInfo(), UpdateTabAvatarSource.TAB_SELECTED);
            if (EeveeRedpointUtil.enableNumRedShowAvatar(qCircleRedInfoBean.getRedPointInfo())) {
                uq3.k.a().p("sp_key_last_insert_red_point_id", EeveeRedpointUtil.getRedPointId(qCircleRedInfoBean.getRedPointInfo()));
                return;
            }
            return;
        }
        QQCircleCounter$RedPointInfo redPointInfo = qCircleRedInfoBean.getRedPointInfo();
        if (qCircleRedInfoBean.isShowRedDot() && qCircleRedInfoBean.getAllRedNum() <= 0) {
            QCircleTabAvatarHelper.N(redPointInfo, UpdateTabAvatarSource.UPDATE_RED_POINT);
        } else if (V(qCircleRedInfoBean)) {
            QCircleTabAvatarHelper.N(redPointInfo, UpdateTabAvatarSource.UPDATE_NUM_RED_AVATAR);
        } else {
            QCircleTabAvatarHelper.N(new QQCircleCounter$RedPointInfo(), UpdateTabAvatarSource.UPDATE_RED_POINT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        if (!this.f182293d || !uq3.o.T1()) {
            return;
        }
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.v
            @Override // java.lang.Runnable
            public final void run() {
                QCircleInjectImpl.s0();
            }
        }, 100L);
    }

    public static boolean i0(boolean z16) {
        if (E && !z16 && !D) {
            return true;
        }
        return false;
    }

    private static void j0(FrameFragment frameFragment) {
        if (((MainFragment) frameFragment).f182814v0 == null) {
            QzoneConfig.getInstance().addListener(a0(frameFragment));
        }
    }

    public static void k0(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, com.tencent.mobileqq.activity.home.impl.d dVar) {
        if (dVar == null) {
            return;
        }
        Y();
        com.tencent.mobileqq.perf.startup.f.g("QCircleInjectImpl.initQCircleTab");
        C = dVar;
        com.tencent.mobileqq.activity.qcircle.utils.b.s(dVar);
        m0(frameFragment);
        G0();
        QLog.i(TabFrameControllerImpl.TAG, 1, "initQCircleTab enter");
        j0(frameFragment);
        if (dVar.c(TabDataHelper.TAB_NEW_WORLD)) {
            Q0(frameFragment, "initQCircleTab");
            com.tencent.mobileqq.activity.qcircle.k.j(frameFragment);
        }
        C0();
        com.tencent.mobileqq.perf.startup.f.h("QCircleInjectImpl.initQCircleTab");
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.w
            @Override // java.lang.Runnable
            public final void run() {
                QCircleInjectImpl.P0();
            }
        });
        com.tencent.biz.qqcircle.immersive.personal.utils.k.i();
        com.tencent.mobileqq.qui.b.f276860a.k(frameFragment.getContext(), frameFragment, P);
        if (QCircleNativeSessionManager.enableSessionReborn()) {
            QCircleNativeSessionManager.g().onAppStart();
        } else {
            QCircleNativeSessionManager.g().clearSession();
        }
        k30.n.k().p();
        QCircleNetWorkTestHelper.i();
        I0();
        H0();
        bb0.b.i().q();
    }

    private static void l0() {
        p40.f.o(new h());
    }

    private static void m0(FrameFragment frameFragment) {
        ASInject.g().setBackEventListener(new f(frameFragment));
    }

    private boolean n0(FrameFragment frameFragment) {
        if (frameFragment == null) {
            return false;
        }
        return TextUtils.equals(frameFragment.getCurrentTabName(), com.tencent.mobileqq.activity.home.impl.b.F);
    }

    private static boolean o0(@org.jetbrains.annotations.Nullable QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo, @org.jetbrains.annotations.Nullable QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo2) {
        if (qQCircleCounter$RedPointInfo == null && qQCircleCounter$RedPointInfo2 == null) {
            return true;
        }
        if (qQCircleCounter$RedPointInfo != null && qQCircleCounter$RedPointInfo2 != null) {
            return QCircleStyleTabExtKt.isSameBubbleContent(qQCircleCounter$RedPointInfo.allPushInfo.styleBottomTab.bubble.get(), qQCircleCounter$RedPointInfo2.allPushInfo.styleBottomTab.bubble.get());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p0() {
        ((IReadInJoySPEventReport) QRoute.api(IReadInJoySPEventReport.class)).registerScreenReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q0() {
        if (z20.h.c()) {
            z20.f.k().o();
            QLog.d("QCBT-QCircleInjectImpl", 1, "[doLoginInit] hit exp, preload disk feed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r0(FrameFragment frameFragment, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        TianshuRedTouch redBadge = frameFragment.getRedBadge(com.tencent.mobileqq.activity.home.impl.b.f183055r);
        if (redBadge != null) {
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateRedBadge(frameFragment, 40, redBadge, redTypeInfo);
            if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
                redBadge.setHiddenRedBadge(true);
            } else {
                redBadge.n0(redBadge.O());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s0() {
        QLog.d("QCBT-QCircleInjectImpl", 1, "[onProcessForeground] execute theme video pause.");
        ThemeVideoController.getInstance().pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean u0(FrameFragment frameFragment) {
        D0(frameFragment);
        QLog.d(TabFrameControllerImpl.TAG, 1, "preLoadViewAndCheckDynamicPlugin init after message tab 1");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v0(boolean z16) {
        QLog.d("QCBT-QCircleInjectImpl", 1, "StudyModeChangeListener onChange " + z16);
        QCirclePluginGlobalInfo.Y(true);
        WeakReference<FrameFragment> weakReference = f182289f;
        if (weakReference != null && weakReference.get() != null) {
            FrameFragment frameFragment = f182289f.get();
            QCircleFrame qCircleFrame = (QCircleFrame) f182289f.get().getFrame(QCircleFrame.class);
            if (qCircleFrame != null) {
                qCircleFrame.onStudyModeChange(frameFragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x0(TextView textView, String str, FrameFragment frameFragment) {
        textView.setText(str);
        f182290h.g(frameFragment);
    }

    private static boolean y0(FrameFragment frameFragment, boolean z16, QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        ViewGroup viewGroup;
        TabViewMap tabViewMap;
        WeakReference<FrameFragment> weakReference = f182289f;
        if (weakReference == null || weakReference.get() == null || f182289f.get().getTabHost() == null || !uq3.c.M6() || (viewGroup = f182289f.get().mTabWidget) == null || viewGroup.getVisibility() == 8 || frameFragment == null || (tabViewMap = frameFragment.mTabViewMap) == null || tabViewMap.get(TabDataHelper.TAB_NEW_WORLD) == null || frameFragment.mTabViewMap.get(TabDataHelper.TAB_NEW_WORLD).getVisibility() == 8 || !i0(z16) || !QCircleRedDotDataHelper.isShowBubbleRedDot(qQCircleCounter$RedPointInfo)) {
            return false;
        }
        return true;
    }

    public static void z0() {
        D = true;
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.home.impl.c frameInfoByClazz = ((ITabFrameController) QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(QCircleFrame.class);
        frameInfoByClazz.w(com.tencent.mobileqq.activity.home.impl.a.f183046i);
        QLog.d("QCBT-QCircleInjectImpl", 1, "doOnUpdateFrameInfo className: " + frameInfoByClazz.k().getName() + " tabIndex: " + frameInfoByClazz.l());
        WeakReference<FrameFragment> weakReference = f182289f;
        if (weakReference != null) {
            f182290h.g(weakReference.get());
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void a(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) frameFragment);
            return;
        }
        QLog.i("QCBT-QCircleInjectImpl", 1, "doOnResumeAfter, mIsSelectedQCircleTab=" + this.f182293d);
        E = true;
        N0(frameFragment);
        H.d();
        ((IReadInJoySPEventReport) QRoute.api(IReadInJoySPEventReport.class)).reportTabExposure();
        if (frameFragment.mIsFirst) {
            return;
        }
        be frame = frameFragment.getFrame(QCircleFrame.class);
        if (frame != null) {
            ((QCircleFrame) frame).reportQCircleFrameExpose();
        }
        if (f182291i) {
            QCircleFrame.reportQCircleRedDotExpose();
        }
        K0(frameFragment, 0, null, -1);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void b(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, com.tencent.mobileqq.activity.home.impl.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, tabFrameControllerImpl, frameFragment, dVar);
        } else {
            X(tabFrameControllerImpl, frameFragment, dVar);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void c(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) frameFragment);
            return;
        }
        QCircleFrame qCircleFrame = (QCircleFrame) frameFragment.getFrame(QCircleFrame.class);
        if (qCircleFrame != null) {
            qCircleFrame.onPostThemeChanged(frameFragment, f182290h);
        }
        f182290h.g(frameFragment);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void d(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) frameFragment);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void f(TianshuRedTouch tianshuRedTouch, final FrameFragment frameFragment, int i3, final BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, IRedTouchManager iRedTouchManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, tianshuRedTouch, frameFragment, Integer.valueOf(i3), redTypeInfo, iRedTouchManager);
        } else if (i3 == 40 && frameFragment != null) {
            frameFragment.mUiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.q
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleInjectImpl.r0(FrameFragment.this, redTypeInfo);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (ArrayList) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleFrameEvent.class);
        arrayList.add(QFSSelectTabEvent.class);
        arrayList.add(QCircleRedInfoEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.activity.home.w
    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TabDataHelper.TAB_NEW_WORLD;
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public boolean h(com.tencent.mobileqq.activity.home.impl.d dVar, FrameFragment frameFragment) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar, (Object) frameFragment)).booleanValue();
        }
        boolean c16 = dVar.c(TabDataHelper.TAB_NEW_WORLD);
        if (f182291i != c16) {
            z16 = true;
        } else {
            z16 = false;
        }
        StringBuilder b16 = dVar.b();
        b16.append("toShowQCircle: ");
        b16.append(c16);
        b16.append(" ");
        b16.append("isQCircleTabChange: ");
        b16.append(z16);
        b16.append(" ");
        return z16;
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void i(RedTouch redTouch, FrameFragment frameFragment, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, IRedTouchManager iRedTouchManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, redTouch, frameFragment, Integer.valueOf(i3), redTypeInfo, iRedTouchManager);
        } else if (i3 == 40) {
            Q0(frameFragment, "updateTabRedTouch");
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void k(HashMap<String, View> hashMap, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, hashMap, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void l(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) frameFragment);
        } else {
            E = false;
            H.d();
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void m(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) frameFragment);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public boolean o(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) frameFragment)).booleanValue();
        }
        f182290h.g(frameFragment);
        return false;
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void onFragmentDrawerClosed(FrameFragment frameFragment, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, frameFragment, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        D = false;
        if (frameFragment != null && i3 == 0 && ((IQCircleConfigApi) QRoute.api(IQCircleConfigApi.class)).isShowQQCircleMainTabEntrance()) {
            Q0(frameFragment, "onFragmentDrawerClosed");
            WeakReference<FrameFragment> weakReference = f182289f;
            if (weakReference != null && weakReference.get() != null) {
                S0(f182289f.get());
            }
        }
        K0(frameFragment, 0, null, -1);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void onFragmentDrawerInit(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
            return;
        }
        super.onFragmentDrawerInit(z16);
        if (z16) {
            FrameHelperActivity.hj(!this.f182293d);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        QCircleRedInfoBean redInfoBean;
        WeakReference<FrameFragment> weakReference;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleFrameEvent) {
            WeakReference<FrameFragment> weakReference2 = f182289f;
            if (weakReference2 != null && weakReference2.get() != null) {
                QCircleFrameEvent qCircleFrameEvent = (QCircleFrameEvent) simpleBaseEvent;
                if (qCircleFrameEvent.mTriggerSelectedQCircleTab) {
                    int b06 = b0(f182289f.get());
                    if (f182289f.get() instanceof MainFragment) {
                        ((MainFragment) f182289f.get()).setCurrentTab(b06);
                        QLog.d("QCBT-QCircleInjectImpl", 2, "mCurTabIndex = " + b06);
                        return;
                    }
                    return;
                }
                if (qCircleFrameEvent.mAddTab) {
                    ((ITabFrameController) QRoute.api(ITabFrameController.class)).setFrames(f182289f.get(), false, 6);
                    return;
                } else {
                    if (qCircleFrameEvent.mSwitchTab >= 0 && (weakReference = f182289f) != null && weakReference.get() != null) {
                        f182289f.get().setCurrentTab(qCircleFrameEvent.mSwitchTab);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (simpleBaseEvent instanceof QFSSelectTabEvent) {
            f0(((QFSSelectTabEvent) simpleBaseEvent).useDarkTheme());
        } else if ((simpleBaseEvent instanceof QCircleRedInfoEvent) && QCircleRedInfoEvent.OUTER_ENTRANCE_RED_POINT_READED.equals(((QCircleRedInfoEvent) simpleBaseEvent).mInvokeMethodName) && (redInfoBean = QCircleFrame.getRedInfoBean()) != null) {
            redInfoBean.setLastExposedRedPointInfo(new QQCircleCounter$RedPointInfo());
            redInfoBean.setLastExposedBubble(new QQCircleCounter$RedPointInfo());
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void p(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) frameFragment);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void q(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) frameFragment);
        } else {
            f182290h.g(frameFragment);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void r(com.tencent.mobileqq.activity.home.impl.d dVar) {
        boolean M6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dVar);
            return;
        }
        com.tencent.mobileqq.perf.startup.f.g("FrameControllerInjectImpl.isShowQCircleTab");
        String c06 = c0();
        if (TabDataHelper.isOnceFetchFromServer(MobileQQ.sMobileQQ, c06)) {
            M6 = TabDataHelper.isExtendTabShow(MobileQQ.sMobileQQ, c06, TabDataHelper.TAB_NEW_WORLD);
        } else {
            M6 = uq3.c.M6();
        }
        com.tencent.mobileqq.perf.startup.f.h("FrameControllerInjectImpl.isShowQCircleTab");
        dVar.f(TabDataHelper.TAB_NEW_WORLD, M6);
        if (M6) {
            dVar.f(TabDataHelper.TAB_RIJ, false);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void s(FrameFragment frameFragment, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, frameFragment, Integer.valueOf(i3), str);
        } else {
            ((IReadInJoySPEventReport) QRoute.api(IReadInJoySPEventReport.class)).reportFragmentTabClick(i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void setIntent(Intent intent, FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) intent, (Object) frameFragment);
            return;
        }
        super.setIntent(intent, frameFragment);
        be frame = frameFragment.getFrame(QCircleFrame.class);
        if (!(frame instanceof QCircleFrame)) {
            return;
        }
        ((QCircleFrame) frame).setIntent(intent);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public boolean t(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) appRuntime)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.d("QCBT-QCircleInjectImpl", 1, "doRegisterInfo bgId=", R.drawable.qui_tab_new_btm_small_world_default + "\uff0c bgPressId=" + R.drawable.qui_tab_new_btm_small_world_default_pressed);
        TabFrameControllerImpl.registerFrameInfo(c.b.B().H(TabDataHelper.TAB_NEW_WORLD).F(QCircleFrame.class).L(false).G(com.tencent.mobileqq.activity.home.impl.a.f183046i).Q(com.tencent.mobileqq.activity.home.impl.b.f183055r).w(R.drawable.qui_tab_new_btm_small_world_default).x(R.drawable.qui_tab_new_btm_small_world_default_pressed).N(R.string.f181523e0).t(17).u(8).y(R.drawable.qui_tab_new_btm_small_world_simple).z(R.drawable.qui_tab_new_btm_small_world_simple_pressed).J("littleworld.json").I("littleworld_back.json").D(-1).E(-1).M(false).K(false).P(TabDataHelper.VALUE_SETTING_NEW_WORLD_REPORT).O(TabDataHelper.VALUE_SETTING_NEW_WORLD_CLICK).v(R.drawable.qui_tab_new_btm_small_world_default_dark).R(R.drawable.skin_tab_icon_3).A());
        SimpleEventBus.getInstance().registerReceiver(this);
        g gVar = new g(this);
        this.f182294e = gVar;
        GuardManagerCallbackDispatcher.registerCallBack(gVar);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void v(FrameFragment frameFragment, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) frameFragment, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void w(FrameFragment frameFragment, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) frameFragment, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void x(FrameFragment frameFragment, FrameFragment.DragViewTouchListener dragViewTouchListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) frameFragment, (Object) dragViewTouchListener);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void y(FrameFragment frameFragment, int i3, be beVar, int i16) {
        TianshuRedTouch redBadge;
        TianshuRedTouch redBadge2;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, frameFragment, Integer.valueOf(i3), beVar, Integer.valueOf(i16));
            return;
        }
        K0(frameFragment, i3, beVar, i16);
        boolean q16 = QCircleTabRedPointBubbleShowController.q();
        boolean v3 = QCircleTabRedPointBubbleShowController.v();
        if (i16 == com.tencent.mobileqq.activity.home.impl.a.f183046i) {
            QCircleHostGlobalInfo.setCurrentTabActive(!com.tencent.mobileqq.activity.qcircle.utils.c.i());
            QCircleTabRedPointBubbleShowController.p(RedPointDismissSource.CHANGE_TAB);
            d0(QCircleRedDotDataHelper.getQQMainTabRedPointInfo());
            if (TianshuRedTouch.INSTANCE.j() && (redBadge2 = frameFragment.getRedBadge(com.tencent.mobileqq.activity.home.impl.b.f183055r)) != null) {
                redBadge2.setHiddenRedBadge(true);
                AppRuntime appRuntime = frameFragment.getBaseActivity().getAppRuntime();
                if (appRuntime != null) {
                    ((IRedTouchManager) appRuntime.getRuntimeService(IRedTouchManager.class, "")).dismissRedTouch(redBadge2.O());
                }
            }
        } else if (TianshuRedTouch.INSTANCE.j() && (redBadge = frameFragment.getRedBadge(com.tencent.mobileqq.activity.home.impl.b.f183055r)) != null) {
            if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
                redBadge.setHiddenRedBadge(true);
            } else {
                redBadge.setHiddenRedBadge(false);
            }
        }
        QCircleFrame qCircleFrame = (QCircleFrame) frameFragment.getFrame(QCircleFrame.class);
        if (qCircleFrame != null) {
            qCircleFrame.setMainFragment((MainFragment) frameFragment);
        }
        if (i16 == com.tencent.mobileqq.activity.home.impl.a.f183046i) {
            z16 = true;
        }
        this.f182293d = z16;
        if (z16) {
            ViewGroup viewGroup = frameFragment.mTabWidget;
            if (viewGroup != null && viewGroup.getHeight() > 0 && qCircleFrame != null) {
                qCircleFrame.setTabHeight(frameFragment.mTabWidget.getHeight() - N);
            }
            if (qCircleFrame != null) {
                qCircleFrame.onTabSelected(q16, v3);
            }
            ThemeVideoController.getInstance().pause();
            QFSSmallWindowGlobalCollect.k().q(frameFragment, i3, i16);
            return;
        }
        if (beVar instanceof QCircleFrame) {
            QFSSmallWindowGlobalCollect.k().w();
            ((QCircleFrame) beVar).onTabUnSelected(i16);
            ThemeVideoController.getInstance().resume();
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void z(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, com.tencent.mobileqq.activity.home.impl.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, tabFrameControllerImpl, frameFragment, dVar);
            return;
        }
        k0(tabFrameControllerImpl, frameFragment, dVar);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.t
            @Override // java.lang.Runnable
            public final void run() {
                QCircleInjectImpl.p0();
            }
        });
        f182290h.g(frameFragment);
    }
}
