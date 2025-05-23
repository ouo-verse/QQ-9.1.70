package com.tencent.mobileqq.activity.home;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.StrictMode;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.view.TitleAreaHeadLayout;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.step.ChatBackgroundAuth;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.login.bq;
import com.tencent.mobileqq.main.api.IMainUIHelperApi;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.y;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqsettingme.QQSettingMe;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.startup.task.ce;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.utils.ei;
import com.tencent.mobileqq.vas.adapter.ThemeFontAdapter;
import com.tencent.mobileqq.vas.theme.ThemeVipBehavior;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.bn;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.widget.ActionSheet;
import common.config.service.QzoneConfig;
import cooperation.qwallet.plugin.PatternLockUtils;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.api.ProcessConstant;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import protocol.KQQConfig.UpgradeInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MainFragment extends FrameHelperActivity {
    static IPatchRedirector $redirector_;
    public static boolean B0;
    public static boolean C0;
    private static Set<Integer> D0;
    boolean A0;

    /* renamed from: i0, reason: collision with root package name */
    private long f182801i0;

    /* renamed from: j0, reason: collision with root package name */
    public String f182802j0;

    /* renamed from: k0, reason: collision with root package name */
    private String f182803k0;

    /* renamed from: l0, reason: collision with root package name */
    private String f182804l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f182805m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f182806n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f182807o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f182808p0;

    /* renamed from: q0, reason: collision with root package name */
    private final BroadcastReceiver f182809q0;

    /* renamed from: r0, reason: collision with root package name */
    private final l<n> f182810r0;

    /* renamed from: s0, reason: collision with root package name */
    public MainAssistObserver f182811s0;

    /* renamed from: t0, reason: collision with root package name */
    public com.tencent.mobileqq.activity.recent.cur.c f182812t0;

    /* renamed from: u0, reason: collision with root package name */
    public final l<com.tencent.mobileqq.tab.c> f182813u0;

    /* renamed from: v0, reason: collision with root package name */
    public QzoneConfig.QzoneConfigChangeListener f182814v0;

    /* renamed from: w0, reason: collision with root package name */
    public com.tencent.mobileqq.logic.a f182815w0;

    /* renamed from: x0, reason: collision with root package name */
    private final l<com.tencent.mobileqq.main.api.b> f182816x0;

    /* renamed from: y0, reason: collision with root package name */
    private Dialog f182817y0;

    /* renamed from: z0, reason: collision with root package name */
    Dialog f182818z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            MainFragment mainFragment = MainFragment.this;
            if (dialogInterface == mainFragment.f182818z0) {
                mainFragment.f182818z0 = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f182821d;

        b(Dialog dialog) {
            this.f182821d = dialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainFragment.this, (Object) dialog);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QLog.flushLog();
                boolean isChecked = ((CheckBox) this.f182821d.findViewById(R.id.checkBoxConfirm)).isChecked();
                MainFragment mainFragment = MainFragment.this;
                mainFragment.A0 = isChecked;
                SettingCloneUtil.writeValue(mainFragment.getBaseActivity(), MainFragment.this.app.getCurrentAccountUin(), MainFragment.this.getString(R.string.receive_msg_whenexit), AppConstants.QQSETTING_RECEIVEMSG_WHENEXIST_KEY, isChecked);
                com.tencent.common.a.c(MainFragment.this.getBaseActivity(), MainFragment.this.A0);
                com.tencent.qqconnect.wtlogin.c.d(MainFragment.this.getBaseActivity(), MainFragment.this.Qj().getMessageFacade().H1() + MainFragment.this.Qj().getCallFacade().v());
                MainFragment.this.Kj();
                MainFragment.this.Qj().bReceiveMsgOnExit = MainFragment.this.A0;
                MainFragment.C0 = true;
                if (QQPlayerService.s0()) {
                    Intent intent = new Intent();
                    intent.setAction("qqplayer_exit_action");
                    MainFragment.this.getBaseActivity().sendBroadcast(intent);
                }
                PatternLockUtils.setFirstEnterAfterLoginState(MainFragment.this.getBaseActivity(), MainFragment.this.app.getCurrentAccountUin(), true);
                MainFragment.this.getBaseActivity().finish();
                ReportController.o(MainFragment.this.app, "CliOper", "", "", "Quit", "Setting_Quit", 0, 0, "0", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                MainFragment.this.Kj();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainFragment.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                final MainFragment mainFragment = MainFragment.this;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.home.ag
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainFragment.Fj(MainFragment.this);
                    }
                }, 16, null, false);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class e implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainFragment.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                MainFragment.this.Pj();
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class f extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainFragment.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MainFragment.this.Rb();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class g extends l<n> {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.activity.home.MainFragment.l
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public n a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (n) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new n(MainFragment.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class h extends l<com.tencent.mobileqq.tab.c> {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            int gesturePWDState = BaseGesturePWDUtil.getGesturePWDState(MainFragment.this.app.getApp(), MainFragment.this.app.getCurrentAccountUin());
            int gesturePWDMode = BaseGesturePWDUtil.getGesturePWDMode(MainFragment.this.app.getApp(), MainFragment.this.app.getCurrentAccountUin());
            if (gesturePWDState == 2 && gesturePWDMode == 20) {
                if (QLog.isColorLevel()) {
                    QLog.d("mainactivity", 2, "gesturepwd manual move.");
                }
                MainFragment.this.getBaseActivity().startUnlockActivity();
                MainFragment.this.getBaseActivity().overridePendingTransition(R.anim.f154454a3, R.anim.f154442w);
                FrameFragment.mTabWidgetMoveFlag = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.activity.home.MainFragment.l
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public com.tencent.mobileqq.tab.c a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.tab.c) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new com.tencent.mobileqq.tab.c() { // from class: com.tencent.mobileqq.activity.home.ah
                @Override // com.tencent.mobileqq.tab.c
                public final void a() {
                    MainFragment.h.this.e();
                }
            };
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class i extends l<com.tencent.mobileqq.main.api.b> {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes10.dex */
        public class a implements com.tencent.mobileqq.main.api.d {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
                }
            }

            @Override // com.tencent.mobileqq.main.api.d
            @NonNull
            public FrameFragment a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (FrameFragment) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return MainFragment.this;
            }

            @Override // com.tencent.mobileqq.main.api.d
            @Nullable
            public QBaseActivity getActivity() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (QBaseActivity) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return MainFragment.this.getQBaseActivity();
            }
        }

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.activity.home.MainFragment.l
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.tencent.mobileqq.main.api.b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.main.api.b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return ((IMainUIHelperApi) QRoute.api(IMainUIHelperApi.class)).getFrameHost(new a(), new ArrayList());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class j implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f182831d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f182832e;

        j(List list, ActionSheet actionSheet) {
            this.f182831d = list;
            this.f182832e = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MainFragment.this, list, actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            MainFragment.this.Lj();
            if (i3 >= 0 || i3 < this.f182831d.size()) {
                try {
                    MainFragment.this.Nj(((Integer) ((Pair) this.f182831d.get(i3)).first).intValue(), (o) ((Pair) this.f182831d.get(i3)).second);
                    this.f182832e.dismiss();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class k implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                MainFragment.this.Lj();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static abstract class l<T> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private T f182835a;

        public l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        protected abstract T a();

        public T b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            if (this.f182835a == null) {
                this.f182835a = a();
            }
            return this.f182835a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private static class m extends com.tencent.mobileqq.logic.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<MainFragment> f182836d;

        public m(MainFragment mainFragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) mainFragment);
            } else {
                this.f182836d = new WeakReference<>(mainFragment);
            }
        }

        @Override // com.tencent.mobileqq.logic.a
        public void onReceive(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                return;
            }
            MainFragment mainFragment = this.f182836d.get();
            if (mainFragment == null) {
                QLog.i("MainFragment", 1, "MainFragmentTabDataObserver mainFragment is null");
            } else {
                mainFragment.ek(i3, z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class n implements StudyModeChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final SoftReference<FrameFragment> f182837d;

        n(FrameFragment frameFragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) frameFragment);
            } else {
                this.f182837d = new SoftReference<>(frameFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).updateGuildTabStatus();
            FrameFragment frameFragment = this.f182837d.get();
            if (frameFragment == null) {
                QLog.e("MainFragment", 1, "MainStudyModeChangeListener onChange fragment is null");
            } else {
                ((ITabFrameController) QRoute.api(ITabFrameController.class)).setFrames(frameFragment, false, 9);
            }
        }

        @Override // com.tencent.mobileqq.studymode.StudyModeChangeListener
        public void onChange(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                ((ILebaHelperService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ILebaHelperService.class, ProcessConstant.MULTI)).checkModleAndRefesh();
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.ai
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainFragment.n.this.b();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class o {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f182838a;

        /* renamed from: b, reason: collision with root package name */
        ResourcePluginInfo f182839b;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68437);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 40)) {
            redirector.redirect((short) 40);
            return;
        }
        B0 = false;
        C0 = false;
        D0 = new HashSet();
    }

    public MainFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f182801i0 = 0L;
        this.f182803k0 = null;
        this.f182804l0 = null;
        this.f182805m0 = true;
        this.f182806n0 = false;
        this.f182807o0 = -1;
        this.f182808p0 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("mainfragment_handle_drawer_anr_bugfix", true);
        this.f182809q0 = new f();
        this.f182810r0 = new g();
        this.f182812t0 = new com.tencent.mobileqq.activity.recent.cur.c(null);
        this.f182813u0 = new h();
        this.f182815w0 = new m(this);
        this.f182816x0 = new i();
        this.A0 = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void Fj(MainFragment mainFragment) {
        mainFragment.Yj();
    }

    private void Ij() {
        com.tencent.util.notification.d.h(Qj()).b();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.home.ac
            @Override // java.lang.Runnable
            public final void run() {
                MainFragment.this.Xj();
            }
        }, 16, null, false);
    }

    private void Jj(boolean z16) {
        if (this.E != null && AppSetting.f99565y && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100177", false)) {
            AccessibilityUtil.e(this.E, z16);
        }
    }

    private void Mj() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().penaltyLog().build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nj(int i3, o oVar) {
        UpgradeInfo upgradeInfo;
        if (oVar == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, oVar.f182838a + " is execute");
        }
        if (i3 == R.id.fge) {
            UpgradeDetailWrapper u16 = this.f182811s0.u();
            if (u16 != null && (upgradeInfo = u16.f306170d) != null) {
                if (upgradeInfo.iUpgradeType == 0) {
                    QQToast.makeText(this.app.getApp(), 0, HardCodeUtil.qqStr(R.string.nww), 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                } else if (upgradeInfo != null) {
                    UpgradeDetailActivity.Y2(getBaseActivity(), com.tencent.mobileqq.upgrade.k.i().j(), false, false, true);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.w("MainFragment", 2, "mWrapper is null");
                }
                QQToast.makeText(this.app.getApp(), 0, HardCodeUtil.qqStr(R.string.f172157nx0), 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            }
            ReportController.o(this.app, "CliOper", "", "", "0X80041C1", "0X80041C1", 0, 0, "", "", "", "");
            return;
        }
        if (i3 == R.id.fgc) {
            ReportController.o(this.app, "CliOper", "", "", "0X80041C3", "0X80041C3", 0, 0, "", "", "", "");
            if (bq.a(Qj(), getBaseActivity())) {
                return;
            }
            ik();
            return;
        }
        if (i3 == R.id.fgb) {
            Lj();
        } else if (oVar.f182839b != null) {
            AboutConfig.o(Qj(), getBaseActivity(), oVar.f182839b);
            if ("com.tencent.Feedback_5_8".equals(oVar.f182839b.strPkgName)) {
                ReportController.o(this.app, "CliOper", "", "", "0X80041C2", "0X80041C2", 0, 0, "", "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oj() {
        QLog.i("MainFragment", 1, "[garbageCollect]");
        ThreadManagerV2.excute(new ae(), 16, null, false);
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.activity.home.af
            @Override // java.lang.Runnable
            public final void run() {
                MainFragment.this.Yj();
            }
        }, 16, null, false, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pj() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("call_gc_after_exit_aio", true)) {
            QLog.i("MainFragment", 1, "[garbageCollectIfIdle] switch is off");
        } else if (Build.VERSION.SDK_INT < 24) {
            QLog.i("MainFragment", 1, "[garbageCollectIfIdle] not support below api level 24");
        } else {
            Looper.getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.activity.home.MainFragment.15
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainFragment.this);
                    }
                }

                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        MainFragment.this.Oj();
                        return false;
                    }
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rb() {
        com.tencent.mobileqq.onlinestatus.y yVar;
        if (QLog.isDevelopLevel()) {
            QLog.i("MainFragment", 1, "onKernelInitComplete");
        }
        if (!OnlineStatusToggleUtils.e() && (yVar = this.H) != null) {
            yVar.Rb();
        }
    }

    public static MainFragment Sj(boolean z16) {
        long currentTimeMillis = System.currentTimeMillis();
        MainFragment mainFragment = new MainFragment();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        Bundle bundle = new Bundle();
        bundle.putBoolean(BaseFragment.SHOULD_RESTORE_FROM_KILL, false);
        mainFragment.setArguments(bundle);
        QLog.d("MainFragment", 1, "[" + mainFragment.hashCode() + "]getInstance() usedTime=" + currentTimeMillis2);
        if (z16) {
            D0.add(Integer.valueOf(mainFragment.hashCode()));
        }
        return mainFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tj() {
        if (Wj()) {
            QLog.i("MainFragment", 1, "handleDrawer isNeedCloseDrawer true");
            FrameHelperActivity.Zh();
        }
        int i3 = DrawerFrame.f185113z0;
        if (i3 > 0) {
            if (i3 == 3 && QLog.isColorLevel()) {
                QLog.d("MainFragment", 2, String.format(Locale.getDefault(), "maybe back from campus notice cur tab: %d", Integer.valueOf(getCurrentTab())));
            }
            MqqHandler handler = Qj().getHandler(Conversation.class);
            if (handler != null) {
                handler.removeMessages(1031);
            }
            QLog.i("MainFragment", 1, "handleDrawer resetDrawer");
            FrameHelperActivity.cj();
        }
    }

    public static boolean Vj() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("MainFragment_repeated_9080_127056175", false)) {
            return true;
        }
        return D0.isEmpty();
    }

    private boolean Wj() {
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return false;
        }
        return baseActivity.getIntent().getBooleanExtra("is_need_close_drawer", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Xj() {
        try {
            QZoneManagerImp qZoneManagerImp = (QZoneManagerImp) this.app.getManager(QQManagerFactory.QZONE_MANAGER);
            if (qZoneManagerImp != null) {
                qZoneManagerImp.x(1, 0);
            }
            QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
            qQNotificationManager.cancel("MainFragment", 241);
            qQNotificationManager.cancel("MainFragment", 243);
            qQNotificationManager.cancel("MainFragment", 265);
            qQNotificationManager.cancel("MainFragment", 267);
            qQNotificationManager.cancel("MainFragment", 274);
            qQNotificationManager.cancel("MainFragment", 236);
            qQNotificationManager.cancel("MainFragment", 271);
            qQNotificationManager.cancel("MainFragment", 273);
            qQNotificationManager.cancel("MainFragment", 239);
            qQNotificationManager.cancel("MainFragment", 527);
        } catch (Exception e16) {
            QLog.w("MainFragment", 1, "[cancelNotifications] exception:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Zj() {
        Jj(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ak(Constants.LogoutReason logoutReason) {
        if (FrameHelperActivity.Gi() && logoutReason != Constants.LogoutReason.restartProcess) {
            FrameHelperActivity.gj(true, "MainFragment");
            FrameHelperActivity.Zh();
        }
        if (logoutReason != Constants.LogoutReason.restartProcess) {
            com.tencent.mobileqq.onlinestatus.utils.a.a(getBaseActivity());
        }
        bi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: fk, reason: merged with bridge method [inline-methods] */
    public void Yj() {
        QLog.i("MainFragment", 1, "[printMemoryUsage] " + com.tencent.mobileqq.perf.tracker.printer.a.f258261a.h(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gk() {
        try {
            MobileQQ.sMobileQQ.registerReceiver(this.f182809q0, new IntentFilter("com.tencent.mobileqq.action.ON_KERNEL_INIT_COMPLETE"));
            QLog.d("MainFragment", 1, "register KernelInitCompleteListener");
        } catch (Exception e16) {
            QLog.i("MainFragment", 1, "registerReceiver", e16);
        }
    }

    private void init() {
        AppRuntime appRuntime = getBaseActivity().getAppRuntime();
        this.app = appRuntime;
        if (appRuntime == null) {
            QLog.e("MainFragment", 1, "appRuntime of activity is null, prepare to fix");
            getBaseActivity().fixAppRuntime();
            this.app = getBaseActivity().getAppRuntime();
        }
        this.f182802j0 = this.app.getAccount();
        this.f182811s0 = new MainAssistObserver((SplashActivity) getBaseActivity());
        QLog.i("MainFragment", 1, "init: addObserver");
        ((QQAppInterface) this.app).addObserver(this.f182815w0);
        com.tencent.mobileqq.troop.navigatebar.expriment.a.f297992a = true;
        SimpleModeHelper.f307331e = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lk() {
        FragmentActivity activity = getActivity();
        if ((activity instanceof SplashActivity) && !ThemeUtil.useNativeThemeVideoPlayer()) {
            QLog.d("MainFragment", 1, "show fragment bg");
            if (com.tencent.mobileqq.pad.c.a(activity, activity.getResources().getConfiguration().orientation)) {
                activity.findViewById(R.id.ve9).setVisibility(0);
            }
        }
    }

    private void showActionSheet() {
        if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, "showActionSheet");
        }
        Lj();
        ArrayList arrayList = new ArrayList();
        o oVar = new o();
        oVar.f182838a = getResources().getString(R.string.ic5);
        arrayList.add(new Pair(Integer.valueOf(R.id.fge), oVar));
        ResourcePluginInfo k3 = Qj().getAboutConfig().k("com.tencent.Feedback_5_8");
        if (k3 != null && k3.cLocalState != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("MainFragment", 2, "feedback plugin is add overmenu");
            }
            o oVar2 = new o();
            oVar2.f182838a = k3.strResName;
            oVar2.f182839b = k3;
            arrayList.add(new Pair(Integer.valueOf(R.id.fgd), oVar2));
        }
        o oVar3 = new o();
        oVar3.f182838a = getResources().getString(R.string.c86);
        arrayList.add(new Pair(Integer.valueOf(R.id.fgc), oVar3));
        o oVar4 = new o();
        oVar4.f182838a = getResources().getString(R.string.f170647xd);
        arrayList.add(new Pair(Integer.valueOf(R.id.fgb), oVar4));
        ActionSheet createMenuSheet = ActionSheet.createMenuSheet(getBaseActivity());
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (R.id.fgb == ((Integer) ((Pair) arrayList.get(i3)).first).intValue()) {
                createMenuSheet.addCancelButton(((o) ((Pair) arrayList.get(i3)).second).f182838a);
            } else {
                createMenuSheet.addButton(((o) ((Pair) arrayList.get(i3)).second).f182838a);
            }
        }
        createMenuSheet.setOnButtonClickListener(new j(arrayList, createMenuSheet));
        createMenuSheet.setOnDismissListener(new k());
        createMenuSheet.setCanceledOnTouchOutside(true);
        this.f182817y0 = createMenuSheet;
        try {
            createMenuSheet.show();
        } catch (Exception unused) {
        }
    }

    void Kj() {
        Dialog dialog = this.f182818z0;
        if (dialog != null) {
            if (dialog.isShowing()) {
                try {
                    this.f182818z0.dismiss();
                } catch (Exception unused) {
                }
            }
            this.f182818z0 = null;
        }
    }

    void Lj() {
        Dialog dialog = this.f182817y0;
        if (dialog != null) {
            if (dialog.isShowing()) {
                try {
                    this.f182817y0.dismiss();
                } catch (Exception unused) {
                }
            }
            this.f182817y0 = null;
        }
    }

    @Override // com.tencent.mobileqq.app.FrameHelperActivity
    protected void Qi(com.tencent.mobileqq.onlinestatus.y yVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) yVar);
        } else {
            if (yVar == null) {
                return;
            }
            yVar.qe(new y.a() { // from class: com.tencent.mobileqq.activity.home.ad
                @Override // com.tencent.mobileqq.onlinestatus.y.a
                public final void a() {
                    MainFragment.this.Zj();
                }
            });
        }
    }

    public QQAppInterface Qj() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (QQAppInterface) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return (QQAppInterface) this.app;
    }

    @Override // com.tencent.mobileqq.app.FrameHelperActivity
    protected void Ri() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        Jj(false);
        if (getCurrentTab() == com.tencent.mobileqq.activity.home.impl.a.f183038a) {
            if (QLog.isColorLevel()) {
                QLog.d("DynimiIcon", 2, "onFragmentDrawerOpened");
            }
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).revertTabIconChange(this);
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.MainFragment.16
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MainFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ((CardHandler) MainFragment.this.Qj().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).getAutoReplyList();
                }
            }
        });
    }

    public String Rj() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        if (getCurrentTab() == com.tencent.mobileqq.activity.home.impl.a.f183038a && (getCurrentFrame() instanceof Conversation) && QQSettingMe.d0()) {
            return "QQSettingMe";
        }
        return getCurrentTabName();
    }

    @Override // com.tencent.mobileqq.app.FrameHelperActivity
    protected void Ti(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).onFragmentDrawerClosed(this, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.app.FrameHelperActivity
    protected void Ui(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, z16);
        } else {
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).onFragmentDrawerInit(z16);
        }
    }

    public void Uj(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) str);
        } else {
            com.tencent.mobileqq.activity.framebusiness.controllerinject.n.d(context, str);
        }
    }

    @Override // com.tencent.mobileqq.app.FrameHelperActivity
    protected void Vi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        if (getCurrentTab() == com.tencent.mobileqq.activity.home.impl.a.f183038a) {
            if (QLog.isColorLevel()) {
                QLog.d("DynimiIcon", 2, "onFragmentDrawerOpened");
            }
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).revertTabIconChange(this);
        }
        QCircleInjectImpl.z0();
    }

    public void b6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (OnlineStatusToggleUtils.e()) {
            ActivityResultCaller findFragmentByTag = getQBaseActivity().getSupportFragmentManager().findFragmentByTag(com.tencent.mobileqq.onlinestatus.y.class.getName());
            if (findFragmentByTag instanceof com.tencent.mobileqq.onlinestatus.y) {
                ((com.tencent.mobileqq.onlinestatus.y) findFragmentByTag).b6();
                return;
            }
            return;
        }
        com.tencent.mobileqq.onlinestatus.y yVar = this.H;
        if (yVar != null) {
            yVar.b6();
        }
    }

    public Dialog bk(String str, String str2, DialogInterface.OnDismissListener onDismissListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Dialog) iPatchRedirector.redirect((short) 22, this, str, str2, onDismissListener);
        }
        ReportDialog reportDialog = new ReportDialog(getBaseActivity(), R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.f167936ng);
        TextView textView = (TextView) reportDialog.findViewById(R.id.dialogTitle);
        if (textView != null) {
            if (str == null) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(str);
            }
        }
        TextView textView2 = (TextView) reportDialog.findViewById(R.id.dialogText);
        if (textView2 != null) {
            if (str2 == null) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(str2);
            }
        }
        TextView textView3 = (TextView) reportDialog.findViewById(R.id.dialogLeftBtn);
        if (textView3 != null) {
            textView3.setText(R.string.cancel);
        }
        TextView textView4 = (TextView) reportDialog.findViewById(R.id.dialogRightBtn);
        if (textView4 != null) {
            textView4.setText(R.string.f171151ok);
        }
        reportDialog.setOnDismissListener(onDismissListener);
        return reportDialog;
    }

    public void ck() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
        } else if (getCurrentTab() == com.tencent.mobileqq.activity.home.impl.a.f183038a) {
            if (QLog.isColorLevel()) {
                QLog.d("FDynimiIcon", 2, "onFragmentDrawerOpened");
            }
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).revertTabIconChange(this);
        }
    }

    @Override // com.tencent.mobileqq.app.FrameFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 82) {
            showActionSheet();
            return true;
        }
        if (i3 != 4) {
            return false;
        }
        if (Md()) {
            return true;
        }
        be currentFrame = getCurrentFrame();
        if (currentFrame != null && currentFrame.notifyBackPressed()) {
            return true;
        }
        try {
            PendingIntent pendingIntent = (PendingIntent) getBaseActivity().getIntent().getParcelableExtra(AppConstants.Key.ACTIVITY_FINISH_RUN_PENDING_INTENT);
            if (pendingIntent != null && !getBaseActivity().getIntent().getBooleanExtra("share_from_aio", false)) {
                if (QLog.isColorLevel()) {
                    QLog.d("MainFragment", 2, "-->finish--send callback using PendingIntent");
                }
                try {
                    pendingIntent.send();
                    getBaseActivity().getIntent().removeExtra(AppConstants.Key.ACTIVITY_FINISH_RUN_PENDING_INTENT);
                } catch (PendingIntent.CanceledException e16) {
                    QLog.e("MainFragment", 2, "failed to send PendingIntent", e16);
                }
            }
            getBaseActivity().moveTaskToBack(true);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("MainFragment", 2, "", th5);
            }
        }
        return true;
    }

    public void ek(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        QLog.i("MainFragment", 1, "onTabDataChange type=" + i3 + ",isSuccess=" + z16);
        if (z16 && isAdded()) {
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).setFrames(this, false, 7);
            QBaseActivity baseActivity = getBaseActivity();
            if (baseActivity == null) {
                return;
            }
            String currentAccountUinFromRuntime = baseActivity.getCurrentAccountUinFromRuntime();
            if (TextUtils.isEmpty(currentAccountUinFromRuntime)) {
                return;
            }
            if (!this.R) {
                Uj(baseActivity, currentAccountUinFromRuntime);
            }
            be frame = getFrame(QCircleFrame.class);
            if (frame != null) {
                ((QCircleFrame) frame).onTabDataChange();
            }
        }
    }

    public void hk() {
        View findViewById;
        ViewParent parent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (getBaseActivity() != null && (findViewById = getBaseActivity().findViewById(R.id.j0l)) != null && (parent = findViewById.getParent()) != null) {
            ((ViewGroup) parent).removeView(findViewById);
        }
        SetSplash.j();
    }

    void ik() {
        Kj();
        Dialog bk5 = bk("\u4f60\u786e\u5b9a\u9000\u51faQQ\uff1f", null, new a());
        TextView textView = (TextView) bk5.findViewById(R.id.dialogRightBtn);
        if (textView != null) {
            textView.setOnClickListener(new b(bk5));
        }
        TextView textView2 = (TextView) bk5.findViewById(R.id.dialogLeftBtn);
        if (textView2 != null) {
            textView2.setOnClickListener(new c());
        }
        String string = getString(R.string.receive_msg_whenexit);
        boolean isContainValue = SettingCloneUtil.isContainValue(getBaseActivity(), this.app.getCurrentAccountUin(), string, AppConstants.QQSETTING_RECEIVEMSG_WHENEXIST_KEY);
        this.A0 = SettingCloneUtil.readValue((Context) getBaseActivity(), this.app.getCurrentAccountUin(), string, AppConstants.QQSETTING_RECEIVEMSG_WHENEXIST_KEY, true);
        CheckBox checkBox = (CheckBox) bk5.findViewById(R.id.checkBoxConfirm);
        if (isContainValue && this.A0) {
            checkBox.setVisibility(8);
        }
        checkBox.setChecked(this.A0);
        this.f182818z0 = bk5;
        bk5.show();
    }

    public void jk() {
        com.tencent.mobileqq.vipgift.b bVar;
        com.tencent.mobileqq.vipgift.a d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        be frame = getFrame(Conversation.class);
        if (frame != null && ((Conversation) frame).isForeground() && (bVar = (com.tencent.mobileqq.vipgift.b) this.app.getManager(QQManagerFactory.VIP_GIF_MANAGER)) != null && (d16 = bVar.d()) != null && isResumed() && d16.f313121f == 2) {
            bVar.m(d16, (BaseActivity) getBaseActivity());
        }
    }

    @Override // com.tencent.mobileqq.app.FrameFragment
    public void onAccountChanged() {
        MainAssistObserver mainAssistObserver;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, "onAccountChanged");
        }
        FrameFragment.mTabWidgetMoveFlag = false;
        com.tencent.mobileqq.activity.framebusiness.controllerinject.j.e();
        QQAppInterface Qj = Qj();
        super.onAccountChanged();
        this.app = getBaseActivity().getAppRuntime();
        FriendListHandler.getSpecialRecommendStat = -1;
        this.hasSpecialCareFriend = false;
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.MainFragment.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MainFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (BaseApplication.getContext() != null) {
                    ea.U2(BaseApplication.getContext(), "");
                }
            }
        }, 2, null, true);
        this.f182816x0.b().onAccountChanged();
        if (this.app != null && (mainAssistObserver = this.f182811s0) != null) {
            mainAssistObserver.f183363e = false;
            this.f182811s0.O();
            if (QLog.isColorLevel()) {
                QLog.d("MainFragment", 2, "onAccountChange.check.new....");
            }
            if (TextUtils.isEmpty(this.f182802j0) || !this.f182802j0.equals(this.app.getAccount())) {
                Ij();
            }
            this.f182811s0.U();
            this.f182811s0.J(Qj);
        }
        AppRuntime appRuntime = this.app;
        if (appRuntime != null) {
            appRuntime.registObserver(this.f194651e0);
            QLog.i("MainFragment", 1, "onAccountChange: addObserver");
            ((QQAppInterface) this.app).addObserver(this.f182815w0);
            com.tencent.mobileqq.onlinestatus.z zVar = this.I;
            if (zVar != null) {
                zVar.a((AppInterface) this.app);
            }
        }
        if (OnlineStatusToggleUtils.e()) {
            com.tencent.mobileqq.onlinestatus.y yVar = (com.tencent.mobileqq.onlinestatus.y) getBaseActivity().getSupportFragmentManager().findFragmentByTag(com.tencent.mobileqq.onlinestatus.y.class.getName());
            if (yVar != null) {
                yVar.onAccountChanged();
            }
        } else {
            com.tencent.mobileqq.onlinestatus.y yVar2 = this.H;
            if (yVar2 != null) {
                yVar2.onAccountChanged();
            }
        }
        if (this.f182806n0) {
            this.f182806n0 = false;
        }
        if (this.app != null && this.mTabViewMap != null && hasTabNotifyIcon().booleanValue()) {
            try {
                ((ITabFrameController) QRoute.api(ITabFrameController.class)).setFrames(this, false, 8);
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.d("MainFragment", 2, "onAccountChange setFrame has error : " + e16);
            }
        }
        com.tencent.mobileqq.app.qim.a.b();
        MainAssistObserver mainAssistObserver2 = this.f182811s0;
        if (mainAssistObserver2 != null) {
            mainAssistObserver2.O = false;
        }
        getBaseActivity().getIntent().removeExtra("if_check_account_same");
        AppRuntime appRuntime2 = this.app;
        if (appRuntime2 != null) {
            this.f182802j0 = appRuntime2.getAccount();
        }
        UserguideActivity.F2();
        ThemeFontAdapter.y(true);
        new ChatBackgroundAuth().i();
        com.tencent.mobileqq.troop.navigatebar.expriment.a.f297992a = true;
        SimpleModeHelper.f307331e = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        ei.a(null, "Main_Fragment_onAttach");
        if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onAttach");
        }
        super.onAttach(activity);
        ei.a("Main_Fragment_onAttach", null);
    }

    @Override // com.tencent.mobileqq.app.FrameHelperActivity, com.tencent.mobileqq.app.FrameFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        QLog.d("MainFragment", 1, "onConfigurationChanged, orientation : ", Integer.valueOf(configuration.orientation));
        ((ITabFrameController) QRoute.api(ITabFrameController.class)).onConfigurationChanged(configuration, this);
    }

    @Override // com.tencent.mobileqq.app.FrameHelperActivity, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        QLog.d("MainFragment", 1, "MainFragment onCreate");
        ei.a(null, "Main_Fragment_onCreate");
        super.onCreate(bundle);
        this.f182816x0.b().onCreate();
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("main_fragment_async_register_kernel_listener_9070_125992517", true)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.home.y
                @Override // java.lang.Runnable
                public final void run() {
                    MainFragment.this.gk();
                }
            }, 16, null, true);
        } else {
            gk();
        }
        ei.a("Main_Fragment_onCreate", null);
        ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).registerStudyModeChangeListener(this.f182810r0.b());
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i3, boolean z16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (Animation) iPatchRedirector.redirect((short) 29, this, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
        }
        if (i16 == 0) {
            return null;
        }
        if (i16 == R.anim.f154449lf) {
            Animation e16 = com.tencent.mobileqq.anim.aio.f.f194321a.e(requireContext());
            e16.setAnimationListener(new d());
            return e16;
        }
        Animation d16 = com.tencent.mobileqq.anim.aio.f.f194321a.d(getBaseActivity());
        d16.setAnimationListener(new e());
        return d16;
    }

    @Override // com.tencent.mobileqq.app.FrameFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            view = (View) iPatchRedirector.redirect((short) 7, this, layoutInflater, viewGroup, bundle);
        } else {
            ei.a(null, "Main_Fragment_onCreateView");
            com.tencent.mobileqq.perf.startup.f.g("MainFragment.onCreateView");
            QLog.d("MainFragment", 1, "MainFragment onCreateView + rootView =  " + this.mRootView);
            init();
            View view2 = this.mRootView;
            if (view2 == null) {
                if (SetSplash.g()) {
                    viewGroup.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.home.MainFragment.5
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MainFragment.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                MainFragment.this.hk();
                                MainFragment.this.lk();
                            }
                        }
                    }, 3000L);
                } else {
                    hk();
                    lk();
                }
                bn bnVar = ((SplashActivity) getBaseActivity()).mSplashPreLoadUI;
                if (bnVar != null) {
                    this.mRootView = bnVar.b();
                } else {
                    this.mRootView = super.onCreateView(layoutInflater, null, bundle);
                }
            } else if (view2.getParent() != null) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            final Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.activity.home.MainFragment.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MainFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    MainAssistObserver mainAssistObserver = MainFragment.this.f182811s0;
                    if (mainAssistObserver != null) {
                        mainAssistObserver.O();
                    }
                    MainFragment mainFragment = MainFragment.this;
                    AppRuntime appRuntime = mainFragment.app;
                    if (appRuntime != null) {
                        appRuntime.registObserver(((FrameHelperActivity) mainFragment).f194651e0);
                    }
                    MainFragment.this.f182805m0 = false;
                }
            };
            ce.e(new ce.b() { // from class: com.tencent.mobileqq.activity.home.aa
                @Override // com.tencent.mobileqq.startup.task.ce.b
                public final void a() {
                    runnable.run();
                }
            });
            Intent intent = getBaseActivity().getIntent();
            if (intent != null) {
                this.f182807o0 = intent.getIntExtra(FrameFragment.CURRENT_TAB_PARAMS_TAG, -1);
            }
            kk();
            ei.a("Main_Fragment_onCreateView", null);
            com.tencent.mobileqq.perf.startup.f.h("MainFragment.onCreateView");
            view = this.mRootView;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.FrameHelperActivity, com.tencent.mobileqq.app.FrameFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MainAssistObserver mainAssistObserver;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        QLog.d("MainFragment", 1, "MainFragment onDestroy " + hashCode());
        super.onDestroy();
        this.f182816x0.b().onDestroy();
        try {
            BaseApplication.getContext().unregisterReceiver(this.f182809q0);
        } catch (IllegalArgumentException e16) {
            QLog.w("MainFragment", 1, "[onDestroy] unregisterReceiver, exc=" + e16);
        }
        if (this.app != null && (mainAssistObserver = this.f182811s0) != null) {
            if (!this.f182805m0) {
                mainAssistObserver.T();
                this.f182805m0 = true;
                com.tencent.mobileqq.onlinestatus.z zVar = this.I;
                if (zVar != null) {
                    zVar.b((AppInterface) this.app);
                }
            }
            this.f182811s0.r();
        }
        AppRuntime appRuntime = this.app;
        if (appRuntime != null) {
            appRuntime.unRegistObserver(this.f194651e0);
            ((QQAppInterface) this.app).removeObserver(this.f182815w0);
        }
        ScreenCapture.clearSnapCacheFile(getBaseActivity());
        if (getBaseActivity().isFinishing()) {
            try {
                ((IUniformDownloadMgr) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "")).onQQProcessExit();
                if (QLog.isColorLevel()) {
                    QLog.d("MainFragment", 2, "MainActivity.onDestory");
                }
                if (DownloadManager.G()) {
                    DownloadManager.C().r();
                }
                TMAssistantDownloadManager.closeAllService(BaseApplication.getContext());
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            boolean z16 = !C0;
            B0 = z16;
            C0 = false;
            AppRuntime appRuntime2 = this.app;
            if (appRuntime2 != null) {
                appRuntime2.isClearTaskBySystem = z16;
                if (z16) {
                    appRuntime2.isBackgroundStop = true;
                    getBaseActivity().sendBroadcast(new Intent(NewIntent.ACTION_EXIT + getBaseActivity().getPackageName()));
                } else if (SettingCloneUtil.readValue((Context) appRuntime2.getApplication(), this.app.getAccount(), (String) null, AppConstants.PCACTIVE_CONFIG, false)) {
                    AppRuntime appRuntime3 = this.app;
                    appRuntime3.startPCActivePolling(appRuntime3.getAccount(), "exitApp");
                    Qj().exit(true);
                } else {
                    Qj().exit(false);
                }
            }
        }
        onFramesDestroyAfter();
        com.tencent.mobileqq.search.util.y.f();
        QzoneConfig.getInstance().removeListener(QCircleInjectImpl.a0(this));
        ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).unregisterStudyModeChangeListener(this.f182810r0.b());
        D0.remove(Integer.valueOf(hashCode()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QLog.d("MainFragment", 1, "MainFragment onDestroyView [" + System.identityHashCode(this) + "]");
        this.f182811s0.T();
        AppRuntime appRuntime = this.app;
        if (appRuntime != null) {
            appRuntime.unRegistObserver(this.f194651e0);
            ((QQAppInterface) this.app).removeObserver(this.f182815w0);
            com.tencent.mobileqq.onlinestatus.z zVar = this.I;
            if (zVar != null) {
                zVar.b((AppInterface) this.app);
            }
        }
        this.f182805m0 = true;
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.app.FrameFragment, com.tencent.mobileqq.fpsreport.a
    public void onDrawComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        QLog.d("MainFragment", 1, "MainFragment onDrawComplete [" + ((ITabFrameController) QRoute.api(ITabFrameController.class)).getCurrentTabTag(this.mTabIndicator) + "]");
        com.tencent.mobileqq.perf.startup.b.b("End");
        super.onDrawComplete();
        this.f182816x0.b().onDrawComplete();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
            return;
        }
        StringBuilder P = com.tencent.mobileqq.activity.aio.l.P();
        P.append("onHiddenChanged");
        P.append(z16);
        QLog.d("MainFragment", 1, P.toString());
        if (z16) {
            this.mForceDoIt = true;
            onPause();
            onStop();
            this.mForceDoIt = false;
        } else if (getBaseActivity().getIntent().getBooleanExtra("isFromAioFragment", false)) {
            onStart();
            onResume();
        }
        super.onHiddenChanged(z16);
    }

    @Override // com.tencent.mobileqq.app.FrameHelperActivity, com.tencent.mobileqq.app.FrameFragment
    public void onLogout(final Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) logoutReason);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, "MainActivity:onLogout");
        }
        com.tencent.mobileqq.activity.framebusiness.controllerinject.j.g();
        ea.U2(this.app.getApp(), "");
        com.tencent.mobileqq.managers.b.b().k(1, "onLogout");
        this.f182806n0 = true;
        com.tencent.mobileqq.app.qim.a.b();
        UserguideActivity.F2();
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.ab
            @Override // java.lang.Runnable
            public final void run() {
                MainFragment.this.ak(logoutReason);
            }
        });
        super.onLogout(logoutReason);
        if (logoutReason != Constants.LogoutReason.kicked && logoutReason != Constants.LogoutReason.secKicked) {
            this.f182816x0.b().onLogout();
        }
    }

    @Override // com.tencent.mobileqq.app.FrameHelperActivity, androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
            return;
        }
        super.onMultiWindowModeChanged(z16);
        be currentFrame = getCurrentFrame();
        if (currentFrame != null) {
            currentFrame.notifyMultiWindowModeChanged(z16);
        }
        ((ITabFrameController) QRoute.api(ITabFrameController.class)).setCurrentIntentParams(this);
    }

    @Override // com.tencent.mobileqq.app.FrameHelperActivity, com.tencent.mobileqq.app.FrameFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.onPause();
        this.f182816x0.b().onPause();
        if (SplashActivity.currentFragment != 1 && !this.mForceDoIt) {
            QLog.d("MainFragment", 1, "MainFragment onPause return");
            return;
        }
        QLog.d("MainFragment", 1, "MainFragment onPause");
        if (this.f182801i0 != 0 && this.currentTabName != null && ey3.a.f().whetherReportThisTime(8)) {
            ey3.a.f().addEvent(8, this.currentTabName, (int) (SystemClock.uptimeMillis() - this.f182801i0), 0, null);
        }
        this.f182801i0 = 0L;
        Lj();
        RecentUtil.f185179d = false;
        if (DrawerFrame.f185113z0 == 2) {
            FrameHelperActivity.cj();
        }
        if (!AppSetting.t(getBaseActivity())) {
            FrameHelperActivity.gj(false, "MainFragment");
        }
        LebaTabRedTouch.c();
        onFramesPauseAfter();
    }

    @Override // com.tencent.mobileqq.app.FrameHelperActivity, com.tencent.mobileqq.app.FrameFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            super.onPostThemeChanged();
            this.f182816x0.b().onPostThemeChanged();
        }
    }

    @Override // com.tencent.mobileqq.app.FrameHelperActivity, com.tencent.mobileqq.app.FrameFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        com.tencent.mobileqq.perf.startup.f.g("MainFragment.onResume");
        super.onResume();
        this.f182816x0.b().onResume();
        if (SplashActivity.currentFragment != 1) {
            QLog.d("MainFragment", 1, "MainFragment onResume return");
            return;
        }
        QLog.d("MainFragment", 1, "MainFragment onResume");
        ei.a(null, "Main_Fragment_OnResume");
        this.f182801i0 = SystemClock.uptimeMillis();
        String str = this.currentTabName;
        if (str != null) {
            SceneTracker.f258213d.m(str);
        }
        FrameHelperActivity.gj(true, "MainFragment");
        if (this.f182808p0) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.z
                @Override // java.lang.Runnable
                public final void run() {
                    MainFragment.this.Tj();
                }
            });
        } else {
            Tj();
        }
        ((ITabFrameController) QRoute.api(ITabFrameController.class)).setFrames(this, false, 1);
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.onEvent(6, null);
        }
        RecentUtil.f185179d = true;
        Intent intent = this.mPendingIntent;
        if (intent != null) {
            this.mPendingIntent = null;
            ((SplashActivity) getBaseActivity()).openMainFragment(intent);
        }
        updateSoundEffectEnableOnResume();
        this.f182811s0.U();
        if (SplashActivity.sExitAIOCode != 0) {
            HardCoderManager.getInstance().stop(SplashActivity.sExitAIOCode);
            SplashActivity.sExitAIOCode = 0;
        }
        if (SplashActivity.sExitAIOTime != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOExit", 2, "exit aio cost = " + (SystemClock.uptimeMillis() - SplashActivity.sExitAIOTime));
            }
            SplashActivity.sExitAIOTime = 0L;
        }
        QQBlurViewWrapper qQBlurViewWrapper = this.mTabBlurView;
        if (qQBlurViewWrapper != null && !this.mBlurSuspended) {
            qQBlurViewWrapper.onResume();
        }
        int i3 = this.f182807o0;
        if (i3 != -1) {
            setCurrentTab(i3, false);
            this.f182807o0 = -1;
        }
        FrameFragment.mTabWidgetMoveFlag = false;
        this.f182811s0.v(getBaseActivity().getIntent());
        this.f182811s0.x(getBaseActivity().getIntent());
        QQUtils.f(getBaseActivity(), getBaseActivity().getIntent());
        com.tencent.mobileqq.forward.g.b(getBaseActivity(), getBaseActivity().getIntent());
        ((ITabFrameController) QRoute.api(ITabFrameController.class)).onResumeAfter(this);
        ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginShowMsgTab();
        ThemeVipBehavior.handleChangeTheme(getBaseActivity());
        ei.a("Main_Fragment_OnResume", null);
        com.tencent.mobileqq.perf.startup.f.h("MainFragment.onResume");
        if (QQUtils.g()) {
            QQUtils.l(requireContext());
            Mj();
            QQToast.makeText(requireContext(), "\u6162\u51fd\u6570\u9632\u88c2\u5316\u5de5\u5177\u5df2\u542f\u52a8", 1).show();
        }
    }

    @Override // com.tencent.mobileqq.app.FrameFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        ei.a(null, "Main_Fragment_onStart");
        super.onStart();
        if (SplashActivity.currentFragment != 1) {
            QLog.d("MainFragment", 1, "MainFragment onStart return");
            ei.a("Main_Fragment_onStart", null);
            return;
        }
        QLog.d("MainFragment", 1, "MainFragment onStart [" + System.identityHashCode(this) + "]");
        String str = this.f182803k0;
        if (str != null && str.length() > 0 && "pakage_from_h5".equalsIgnoreCase(this.f182804l0)) {
            ax c16 = bi.c(Qj(), getBaseActivity(), this.f182803k0);
            c16.B(this.f182804l0);
            c16.b();
            this.f182803k0 = null;
            this.f182804l0 = null;
        }
        ei.a("Main_Fragment_onStart", null);
    }

    @Override // com.tencent.mobileqq.app.FrameFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onStop();
        if (SplashActivity.currentFragment != 1 && !this.mForceDoIt) {
            QLog.d("MainFragment", 1, "MainFragment onStop return");
            return;
        }
        QLog.d("MainFragment", 1, "MainFragment onStop [" + System.identityHashCode(this) + "] ");
        if (DrawerFrame.f185113z0 > 0) {
            FrameHelperActivity.cj();
        }
    }

    @Override // com.tencent.mobileqq.app.FrameHelperActivity, com.tencent.mobileqq.app.FrameFragment
    public void onTabChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
            return;
        }
        if (this.f182801i0 != 0 && this.currentTabName != null && ey3.a.f().whetherReportThisTime(8)) {
            ey3.a.f().addEvent(8, this.currentTabName, (int) (SystemClock.uptimeMillis() - this.f182801i0), 0, null);
        }
        String str2 = this.currentTabName;
        if (str2 != null) {
            SceneTracker.f258213d.traceEnd(str2);
        }
        SceneTracker.f258213d.m(str);
        this.f182801i0 = SystemClock.uptimeMillis();
        View ki5 = ki();
        if (ki5 != null) {
            ki5.setVisibility(0);
        }
        super.onTabChanged(str);
        RecentUtil.f185179d = true;
        TitleAreaHeadLayout titleAreaHeadLayout = this.D;
        if (titleAreaHeadLayout != null) {
            titleAreaHeadLayout.p();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        ei.a(null, "Main_Fragment_onViewCreated");
        com.tencent.mobileqq.perf.startup.f.g("MainFragment.onViewCreated");
        QLog.i("MainFragment", 1, "MainFragment onViewCreated [" + System.identityHashCode(this) + "]");
        super.onViewCreated(view, bundle);
        if (this.mTabViewMap == null) {
            com.tencent.mobileqq.perf.startup.b.b("Begin");
            com.tencent.mobileqq.perf.startup.f.g("MainFragment.onViewCreated.initTabs");
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).initTabs(this, this.mRootView);
            com.tencent.mobileqq.perf.startup.f.h("MainFragment.onViewCreated.initTabs");
            com.tencent.mobileqq.perf.startup.b.b("InitTabs");
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).setFrames(this, true, 0);
            this.mTabHost.setOnDrawCompleteListener(this);
            this.mTabHostDivider = SimpleModeHelper.b((ViewGroup) this.mTabHost, this.mTabHostDivider);
        }
        ei.a("Main_Fragment_onViewCreated", null);
        com.tencent.mobileqq.perf.startup.f.h("MainFragment.onViewCreated");
    }

    public void setIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) intent);
        } else {
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).setIntent(intent, this);
        }
    }

    @Override // com.tencent.mobileqq.app.FrameFragment
    public String setLastActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        if (FrameHelperActivity.Gi()) {
            return getString(R.string.f170549u3);
        }
        return super.setLastActivityName();
    }

    @Override // com.tencent.mobileqq.app.FrameFragment
    protected void updateNecessaryUI(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) str);
            return;
        }
        if (com.tencent.mobileqq.util.af.i()) {
            if (str.equals(((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass().getName()) || str.equals(Conversation.class.getName())) {
                sj();
                this.mUiHandler.sendEmptyMessageDelayed(1, 200L);
                this.mUiHandler.sendEmptyMessageDelayed(2, 500L);
            }
        }
    }

    private void kk() {
    }
}
