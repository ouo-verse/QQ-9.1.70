package com.tencent.mobileqq.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.view.TitleAreaHeadLayout;
import com.tencent.mobileqq.activity.home.view.TitleAreaLeftLayout;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.y;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.utils.QQDarenUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.resconfig.MainResourceConfig;
import com.tencent.mobileqq.settingme.QQSettingMeBackgroundView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statustitle.api.IBaseStatusTitleBarApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager;
import com.tencent.mobileqq.vas.pendant.api.IMaskDownloadDispatch;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.vas.pendant.api.VasMaskDownloadCallback;
import com.tencent.mobileqq.vas.theme.ThemeVideoController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vashealth.api.IQQHealthStatusApi;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.mobileqq.widget.imageview.CircleBoarderImageView;
import com.tencent.mobileqq.zplan.utils.api.IZPlanDrawerStateHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.aio.forward.NtMsgForwardUtils;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.statemachine.api.IStateManager;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.QUITokenResCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class FrameHelperActivity extends FrameFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: g0, reason: collision with root package name */
    public static WeakReference<DrawerFrame> f194645g0;

    /* renamed from: h0, reason: collision with root package name */
    public static boolean f194646h0;
    public CircleBoarderImageView C;

    @Nullable
    protected TitleAreaHeadLayout D;
    public DrawerFrame E;
    public ViewGroup F;
    private QQSettingMeBackgroundView G;
    public com.tencent.mobileqq.onlinestatus.y H;
    protected com.tencent.mobileqq.onlinestatus.z I;
    private final List<DrawerFrame.d> J;
    private View K;
    private View L;
    private boolean M;
    private boolean N;
    DrawerFrame.d P;
    private Dialog Q;
    public boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private volatile boolean V;
    private CallBacker W;
    private p X;
    private final ReentrantLock Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f194647a0;

    /* renamed from: b0, reason: collision with root package name */
    private k f194648b0;

    /* renamed from: c0, reason: collision with root package name */
    private final boolean f194649c0;

    /* renamed from: d0, reason: collision with root package name */
    private j f194650d0;

    /* renamed from: e0, reason: collision with root package name */
    protected com.tencent.mobileqq.onlinestatus.ac f194651e0;

    /* renamed from: f0, reason: collision with root package name */
    private y.d f194652f0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.FrameHelperActivity$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass1 implements DrawerFrame.d {
        static IPatchRedirector $redirector_;

        AnonymousClass1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FrameHelperActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(final View view) {
            try {
                final Drawable drawable = FrameHelperActivity.this.getQBaseActivity().getDrawable(R.drawable.qui_common_bg_primary_bg);
                view.post(new Runnable() { // from class: com.tencent.mobileqq.app.ak
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setBackground(drawable);
                    }
                });
            } catch (Exception e16) {
                QLog.e("Q.recent", 1, "setDecorViewBg error" + e16.getCause());
            }
        }

        private void j() {
            Window window;
            QBaseActivity qBaseActivity = FrameHelperActivity.this.getQBaseActivity();
            if (qBaseActivity == null || (window = qBaseActivity.getWindow()) == null) {
                return;
            }
            View decorView = window.getDecorView();
            if (decorView.getBackground() != null) {
                decorView.setBackground(null);
            }
        }

        private void k() {
            Window window;
            QBaseActivity qBaseActivity = FrameHelperActivity.this.getQBaseActivity();
            if (qBaseActivity == null || (window = qBaseActivity.getWindow()) == null) {
                return;
            }
            final View decorView = window.getDecorView();
            if (decorView.getBackground() == null) {
                if (com.tencent.mobileqq.vas.ar.b("linkliang", "2024-03-21", "vas_theme_drawable_async").isEnable(false)) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.aj
                        @Override // java.lang.Runnable
                        public final void run() {
                            FrameHelperActivity.AnonymousClass1.this.i(decorView);
                        }
                    }, 16, null, true);
                } else {
                    decorView.setBackground(FrameHelperActivity.this.getQBaseActivity().getDrawable(R.drawable.qui_common_bg_primary_bg));
                }
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        public void a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                FrameHelperActivity.this.f194647a0 = true;
                if (QLog.isDevelopLevel()) {
                    QLog.i("Q.recent", 4, "onDrawerOpened:: side = " + i3 + " getActivity = " + FrameHelperActivity.this.getBaseActivity());
                }
                if (FrameHelperActivity.this.getBaseActivity() == null) {
                    return;
                }
                j();
                if (!FrameHelperActivity.this.getBaseActivity().isFinishing() && FrameHelperActivity.this.X != null && !FrameHelperActivity.this.R) {
                    QLog.d("Q.recent", 1, "FrameHelperActivity#onDrawerOpened: trigger onResume");
                    FrameHelperActivity.this.X.onResume();
                }
                FrameHelperActivity frameHelperActivity = FrameHelperActivity.this;
                frameHelperActivity.R = true;
                frameHelperActivity.ci(i16, true, frameHelperActivity.ii());
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.PROFILE_CARD, 2, "[getCover(app)]from DrawerOpened");
                }
                FrameHelperActivity.this.mUiHandler.sendEmptyMessage(14);
                for (DrawerFrame.d dVar : FrameHelperActivity.this.J) {
                    if (dVar != null) {
                        dVar.a(i3, i16);
                    }
                }
                FrameHelperActivity.this.Yh();
                FrameHelperActivity.this.Uh(true);
                FrameHelperActivity.this.Vi();
                ((IStateManager) QRoute.api(IStateManager.class)).onMainDrawerChange(true);
                ((IZPlanDrawerStateHelper) QRoute.api(IZPlanDrawerStateHelper.class)).onDrawerStateChange(true);
                return;
            }
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        public void b(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, "onDrawerClosed:: side = " + i3 + " getActivity = " + FrameHelperActivity.this.getBaseActivity());
            }
            if (FrameHelperActivity.this.getBaseActivity() == null) {
                return;
            }
            j();
            QLog.d("Q.recent", 1, "FrameHelperActivity#onDrawerClosed: misDrawerOpened=false");
            FrameHelperActivity frameHelperActivity = FrameHelperActivity.this;
            frameHelperActivity.R = false;
            frameHelperActivity.ci(i16, false, frameHelperActivity.ii());
            if (!FrameHelperActivity.this.getBaseActivity().isFinishing() && FrameHelperActivity.this.X != null) {
                FrameHelperActivity.this.X.onPause();
            }
            ViewGroup viewGroup = FrameHelperActivity.this.F;
            if (viewGroup != null) {
                ((ImageView) viewGroup.findViewById(R.id.kis)).setImageResource(0);
            }
            for (DrawerFrame.d dVar : FrameHelperActivity.this.J) {
                if (dVar != null) {
                    dVar.b(i3, i16);
                }
            }
            FrameHelperActivity.this.Uh(false);
            FrameHelperActivity.this.Ti(i3, i16);
            ((IStateManager) QRoute.api(IStateManager.class)).onMainDrawerChange(false);
            ((IZPlanDrawerStateHelper) QRoute.api(IZPlanDrawerStateHelper.class)).onDrawerStateChange(false);
            if (FrameHelperActivity.this.N) {
                FrameHelperActivity.this.resumeBlur();
            }
            ApngImage.resumeAll();
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        public void c(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, "onDrawerStartToggle:: side = " + i3 + " open:" + z16 + " getActivity = " + FrameHelperActivity.this.getBaseActivity());
            }
            for (DrawerFrame.d dVar : FrameHelperActivity.this.J) {
                if (dVar != null) {
                    dVar.c(i3, z16);
                }
            }
            if (z16) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.app.FrameHelperActivity.1.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (FrameHelperActivity.this.getBaseActivity() != null && FrameHelperActivity.this.getBaseActivity().getAppRuntime() != null) {
                            LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) FrameHelperActivity.this.getBaseActivity().getAppRuntime().getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
                            RedTouchItem j3 = localRedTouchManager.j(10015);
                            RedTouchItem j16 = localRedTouchManager.j(10016);
                            RedTouchItem j17 = localRedTouchManager.j(-7);
                            if (j17 != null && j17.unReadFlag) {
                                if (j3 != null || j16 != null) {
                                    int h16 = localRedTouchManager.h();
                                    if (h16 != 3) {
                                        if (h16 != 4) {
                                            if (h16 != 5) {
                                                str = null;
                                            } else {
                                                str = "0X80073B7";
                                            }
                                        } else {
                                            str = "0X80073B3";
                                        }
                                    } else {
                                        str = "0X80073B1";
                                    }
                                    String str2 = str;
                                    if (str2 != null) {
                                        ReportController.o(FrameHelperActivity.this.getBaseActivity().getAppRuntime(), "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
                                    }
                                }
                            }
                        }
                    }
                }, 5, null, true);
            }
            FrameHelperActivity.this.Uh(z16);
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        public void d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, "onDrawerStartMoving:: side = " + i3 + " getActivity = " + FrameHelperActivity.this.getBaseActivity() + " mDrawerBg= " + FrameHelperActivity.this.F);
            }
            k();
            FrameHelperActivity frameHelperActivity = FrameHelperActivity.this;
            if (frameHelperActivity.E != null && frameHelperActivity.X != null) {
                FrameHelperActivity frameHelperActivity2 = FrameHelperActivity.this;
                frameHelperActivity2.E.setIsQQSettingMeInit(frameHelperActivity2.X.isInited());
            }
            if (FrameHelperActivity.this.getBaseActivity() == null) {
                return;
            }
            for (DrawerFrame.d dVar : FrameHelperActivity.this.J) {
                if (dVar != null) {
                    dVar.d(i3);
                }
            }
            FrameHelperActivity.this.Mi();
            FrameHelperActivity.this.Uh(true);
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        public void e(int i3, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Float.valueOf(f16));
                return;
            }
            if (QLog.isDevelopLevel() && FrameHelperActivity.this.f194647a0) {
                FrameHelperActivity.this.f194647a0 = false;
                QLog.i("Q.recent", 4, "onDrawerMoving:: side = " + i3 + " getActivity = " + FrameHelperActivity.this.getBaseActivity());
            }
            if (FrameHelperActivity.this.getBaseActivity() == null) {
                return;
            }
            for (DrawerFrame.d dVar : FrameHelperActivity.this.J) {
                if (dVar != null) {
                    dVar.e(i3, f16);
                }
            }
            FrameHelperActivity.this.Uh(true);
            if (FrameHelperActivity.this.N) {
                FrameHelperActivity.this.pauseBlur();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements y.d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FrameHelperActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.y.d
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                FrameHelperActivity.this.rj("from_user_click_dianzan_num");
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.y.d
        public void b(AppRuntime.Status status) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) status);
            } else {
                FrameHelperActivity.this.rj("AccountPanel.OnlineStatusChangedListener");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f194666d;

        b(QQAppInterface qQAppInterface) {
            this.f194666d = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FrameHelperActivity.this, (Object) qQAppInterface);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (FrameHelperActivity.this.Q != null && FrameHelperActivity.this.Q.isShowing()) {
                    FrameHelperActivity.this.Q.dismiss();
                }
                ReportController.o(this.f194666d, "CliOper", "", "", "0X800433B", "0X800433B", 0, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f194668d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f194669e;

        c(QQAppInterface qQAppInterface, QBaseActivity qBaseActivity) {
            this.f194668d = qQAppInterface;
            this.f194669e = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, FrameHelperActivity.this, qQAppInterface, qBaseActivity);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(this.f194668d, "CliOper", "", "", "Quit", "Setting_Quit", 0, 0, "2", "", "", "");
                if (SettingCloneUtil.readValue((Context) this.f194668d.getApplication(), this.f194668d.getAccount(), (String) null, AppConstants.PCACTIVE_CONFIG, false)) {
                    QQAppInterface qQAppInterface = this.f194668d;
                    qQAppInterface.startPCActivePolling(qQAppInterface.getAccount(), "logout");
                }
                FrameHelperActivity.this.Xi(this.f194669e, this.f194668d);
                if (FrameHelperActivity.this.Q != null && FrameHelperActivity.this.Q.isShowing()) {
                    FrameHelperActivity.this.Q.dismiss();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class d implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FrameHelperActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                FrameHelperActivity.this.Q = null;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class e implements TitleAreaHeadLayout.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FrameHelperActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            FrameHelperActivity.this.E.O();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            FrameHelperActivity frameHelperActivity = FrameHelperActivity.this;
            if (frameHelperActivity.E == null) {
                frameHelperActivity.Bi();
            }
            DrawerFrame drawerFrame = FrameHelperActivity.this.E;
            if (drawerFrame != null && drawerFrame.o()) {
                FrameHelperActivity.this.E.post(new Runnable() { // from class: com.tencent.mobileqq.app.am
                    @Override // java.lang.Runnable
                    public final void run() {
                        FrameHelperActivity.e.this.c();
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.activity.home.view.TitleAreaHeadLayout.a
        public int G() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return FrameHelperActivity.this.ii();
            }
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }

        @Override // com.tencent.mobileqq.activity.home.view.TitleAreaHeadLayout.a
        public void H() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (FrameHelperActivity.this.f194649c0) {
                FrameHelperActivity.this.Li(new m() { // from class: com.tencent.mobileqq.app.al
                    @Override // com.tencent.mobileqq.app.FrameHelperActivity.m
                    public final void a() {
                        FrameHelperActivity.e.this.d();
                    }
                });
            } else {
                d();
            }
        }

        @Override // com.tencent.mobileqq.activity.home.view.TitleAreaHeadLayout.a
        public String I() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return FrameHelperActivity.this.getCurrentTabName();
        }

        @Override // com.tencent.mobileqq.activity.home.view.TitleAreaHeadLayout.a
        public AppRuntime getApp() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (AppRuntime) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return FrameHelperActivity.this.app;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class f extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FrameHelperActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            Conversation conversation = (Conversation) FrameHelperActivity.this.getFrame(Conversation.class);
            if (conversation != null) {
                conversation.handleOnLoginAnimEnd();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            QLog.i("Q.recent", 1, "loginAnim second: onAnimationEnd");
            com.tencent.mobileqq.util.ax.h(FrameHelperActivity.this.mUiHandler, new Runnable() { // from class: com.tencent.mobileqq.app.an
                @Override // java.lang.Runnable
                public final void run() {
                    FrameHelperActivity.f.this.b();
                }
            });
            QQBlurViewWrapper qQBlurViewWrapper = FrameHelperActivity.this.mTabBlurView;
            if (qQBlurViewWrapper != null) {
                qQBlurViewWrapper.invalidate();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                QLog.i("Q.recent", 1, "loginAnim second: onAnimationStart");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class g implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f194674d;

        g(View view) {
            this.f194674d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FrameHelperActivity.this, (Object) view);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            DrawerFrame drawerFrame;
            int i3;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else {
                if (FrameHelperActivity.this.getBaseActivity() != null && !FrameHelperActivity.this.getBaseActivity().isFinishing()) {
                    boolean z17 = false;
                    if (((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).isHeadIconLongClickFunc((QQAppInterface) FrameHelperActivity.this.getBaseActivity().getAppRuntime(), false) && ((drawerFrame = FrameHelperActivity.this.E) == null || !drawerFrame.q())) {
                        FrameHelperActivity.this.Si();
                        com.tencent.mobileqq.onlinestatus.y yVar = FrameHelperActivity.this.H;
                        if (yVar != null && !yVar.isShowing()) {
                            z17 = true;
                        }
                        if (OnlineStatusToggleUtils.e()) {
                            z17 = FrameHelperActivity.this.Ei();
                        }
                        if (view == this.f194674d && z17) {
                            FrameHelperActivity.this.tj();
                            if (FrameHelperActivity.this.getCurrentTab() == com.tencent.mobileqq.activity.home.impl.a.f183038a) {
                                i3 = 3;
                            } else {
                                i3 = 1;
                            }
                            if (OnlineStatusToggleUtils.e()) {
                                com.tencent.mobileqq.onlinestatus.y newAccountPanel = ((IOnlineStatusService) FrameHelperActivity.this.app.getRuntimeService(IOnlineStatusService.class, "")).newAccountPanel(FrameHelperActivity.this.getBaseActivity());
                                FrameHelperActivity.this.Qi(newAccountPanel);
                                newAccountPanel.D3(FrameHelperActivity.this.f194652f0);
                                newAccountPanel.Pc(new o(FrameHelperActivity.this));
                                newAccountPanel.show(i3);
                            } else {
                                if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100981", true)) {
                                    FrameHelperActivity frameHelperActivity = FrameHelperActivity.this;
                                    frameHelperActivity.H.D3(frameHelperActivity.f194652f0);
                                    FrameHelperActivity frameHelperActivity2 = FrameHelperActivity.this;
                                    frameHelperActivity2.H.Pc(new o(frameHelperActivity2));
                                }
                                FrameHelperActivity.this.H.show(i3);
                            }
                            com.tencent.mobileqq.onlinestatus.z zVar = FrameHelperActivity.this.I;
                            if (zVar != null) {
                                zVar.c("from_user_click");
                            }
                            ReportController.o(FrameHelperActivity.this.getBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800A999", "0X800A999", 1, 0, "", "", "", "");
                            ReportController.o(FrameHelperActivity.this.getBaseActivity().getAppRuntime(), "dc00898", "", "", "0X8009E84", "0X8009E84", 0, 0, "", "", "", "");
                            ReportController.o(FrameHelperActivity.this.getBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800BDEC", "0X800BDEC", 1, 0, "", "", "", "");
                        }
                        FrameHelperActivity.this.Ri();
                        FrameHelperActivity.this.Wh();
                        ReportController.o(FrameHelperActivity.this.getBaseActivity().getAppRuntime(), "CliOper", "", "", "0X80072D1", "0X80072D1", 0, 0, "", "", "", "");
                    }
                }
                z16 = true;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class h implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FrameHelperActivity.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    if (FrameHelperActivity.this.mUiHandler.hasMessages(13)) {
                        FrameHelperActivity.this.mUiHandler.removeMessages(13);
                        if (FrameHelperActivity.this.li() != null) {
                            FrameHelperActivity.this.li().clearAnimation();
                        }
                        if (FrameHelperActivity.this.gi() != null) {
                            FrameHelperActivity.this.gi().clearAnimation();
                        }
                    } else {
                        TitleAreaHeadLayout titleAreaHeadLayout = FrameHelperActivity.this.D;
                        if (titleAreaHeadLayout != null) {
                            titleAreaHeadLayout.n();
                        }
                    }
                }
            } else if (((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).isHeadIconLongClickFunc((QQAppInterface) FrameHelperActivity.this.getBaseActivity().getAppRuntime(), false)) {
                FrameHelperActivity.this.mUiHandler.sendEmptyMessageDelayed(13, 200L);
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class i extends com.tencent.mobileqq.onlinestatus.ac {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FrameHelperActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.ac
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent", 2, "onBatteryChanged updateOnlineStatusItem");
            }
            com.tencent.mobileqq.onlinestatus.z zVar = FrameHelperActivity.this.I;
            if (zVar != null) {
                zVar.e(i3);
            }
            FrameHelperActivity.this.rj("OnBatteryChangeObserver");
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface j {
        void onDrawerInit(boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class k implements VasMaskDownloadCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<FrameHelperActivity> f194678a;

        public k(FrameHelperActivity frameHelperActivity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) frameHelperActivity);
            } else {
                this.f194678a = new WeakReference<>(frameHelperActivity);
            }
        }

        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (this.f194678a.get() != null) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.vas.pendant.api.VasMaskDownloadCallback
        public void dispatch(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            FrameHelperActivity frameHelperActivity = this.f194678a.get();
            if (frameHelperActivity != null) {
                com.tencent.mobileqq.util.ax.f(frameHelperActivity.mUiHandler, 12);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class l implements Handler.Callback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<FrameHelperActivity> f194679d;

        l(FrameHelperActivity frameHelperActivity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) frameHelperActivity);
            } else {
                this.f194679d = new WeakReference<>(frameHelperActivity);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            FrameHelperActivity frameHelperActivity = this.f194679d.get();
            if (frameHelperActivity != null) {
                frameHelperActivity.handleMessage(message);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface m {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class n implements com.tencent.mobileqq.activity.qqsettingme.k {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<FrameHelperActivity> f194680a;

        n(FrameHelperActivity frameHelperActivity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) frameHelperActivity);
            } else {
                this.f194680a = new WeakReference<>(frameHelperActivity);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(String str, boolean z16) {
            FrameHelperActivity frameHelperActivity = this.f194680a.get();
            if (frameHelperActivity != null && frameHelperActivity.F != null && frameHelperActivity.X != null) {
                RandomCoverView randomCoverView = (RandomCoverView) frameHelperActivity.F.findViewById(R.id.f167001jt4);
                if (TextUtils.isEmpty(str)) {
                    frameHelperActivity.X.b(false);
                    randomCoverView.setDefaultCoverBg();
                    return;
                }
                frameHelperActivity.X.b(true);
                randomCoverView.b().setVisibility(0);
                if (TextUtils.equals(str, "qzone_zplan_bg")) {
                    randomCoverView.d().setImageDrawable(randomCoverView.getContext().getDrawable(R.drawable.nzw));
                } else {
                    randomCoverView.h(str, z16, randomCoverView.getWidth(), randomCoverView.getHeight());
                }
            }
        }

        @Override // com.tencent.mobileqq.activity.qqsettingme.k
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (this.f194680a.get() != null) {
                r0.Z--;
            }
        }

        @Override // com.tencent.mobileqq.activity.qqsettingme.k
        public void onResult(@Nullable final String str, final boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.app.ao
                    @Override // java.lang.Runnable
                    public final void run() {
                        FrameHelperActivity.n.this.c(str, z16);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static final class o implements y.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<FrameHelperActivity> f194681a;

        public o(FrameHelperActivity frameHelperActivity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) frameHelperActivity);
            } else {
                this.f194681a = new WeakReference<>(frameHelperActivity);
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.y.b
        public void a() {
            QBaseActivity baseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            FrameHelperActivity frameHelperActivity = this.f194681a.get();
            if (frameHelperActivity != null && (baseActivity = frameHelperActivity.getBaseActivity()) != null && baseActivity.getAppRuntime() != null) {
                QQAppInterface qQAppInterface = (QQAppInterface) baseActivity.getAppRuntime();
                if (com.tencent.mobileqq.login.bq.a(qQAppInterface, baseActivity)) {
                    return;
                }
                if (frameHelperActivity.Q == null || !frameHelperActivity.Q.isShowing()) {
                    frameHelperActivity.oj(qQAppInterface, baseActivity);
                    ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A00D", "0X800A00D", 0, 0, "", "", "", "");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface p {
        void a(com.tencent.mobileqq.t tVar);

        void b(boolean z16);

        boolean c();

        ViewGroup getContent();

        boolean isInited();

        void onConfigurationChanged(Configuration configuration);

        void onDestroy();

        void onPause();

        void onResume();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69712);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 53)) {
            redirector.redirect((short) 53);
        } else {
            f194646h0 = false;
        }
    }

    public FrameHelperActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.J = new ArrayList();
        this.N = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("main_tab_blur_view_pause_while_drawer_open", true);
        this.P = new AnonymousClass1();
        this.R = false;
        this.S = true;
        this.T = false;
        this.Y = new ReentrantLock();
        this.Z = 3;
        this.f194647a0 = true;
        this.f194649c0 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("frame_helper_async_inflate_ui_128353173", true);
        this.f194651e0 = new i();
        this.f194652f0 = new a();
    }

    private void Ai() {
        if (getBaseActivity() == null) {
            return;
        }
        if (!OnlineStatusToggleUtils.e() && this.H != null) {
            return;
        }
        ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).isHeadIconLongClickFunc((QQAppInterface) getBaseActivity().getAppRuntime(), true);
        if (!OnlineStatusToggleUtils.e()) {
            com.tencent.mobileqq.onlinestatus.y newAccountPanel = ((IOnlineStatusService) this.app.getRuntimeService(IOnlineStatusService.class, "")).newAccountPanel(getBaseActivity());
            this.H = newAccountPanel;
            Qi(newAccountPanel);
            this.H.D3(this.f194652f0);
            this.H.Pc(new o(this));
        }
        View ki5 = ki();
        if (ki5 == null) {
            return;
        }
        ki5.setHapticFeedbackEnabled(false);
        ki5.setOnLongClickListener(new g(ki5));
        ki5.setOnTouchListener(new h());
        AccessibilityUtil.d(ki5, Button.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bi() {
        Conversation conversation;
        QLog.i("Q.recent", 1, "frameHelper_initDrawerFrame: mDrawerFrame=  " + this.E + "mDrawerBg= " + this.F + "mIsInflated = " + this.V);
        if (this.E != null) {
            j jVar = this.f194650d0;
            if (jVar != null) {
                jVar.onDrawerInit(true);
                return;
            }
            return;
        }
        if (this.X == null && (conversation = (Conversation) getFrame(Conversation.class)) != null) {
            conversation.inflateUI();
        }
        if (!this.V) {
            zi();
        }
        ViewGroup viewGroup = (ViewGroup) getBaseActivity().findViewById(R.id.b9o);
        try {
            if (this.X != null) {
                this.E = new DrawerFrame(getBaseActivity(), viewGroup, this.X.getContent(), null, this.F, this);
            }
            ViewGroup viewGroup2 = (ViewGroup) getBaseActivity().findViewById(R.id.zxc);
            viewGroup2.setVisibility(0);
            ((ViewGroup) viewGroup2.getParent()).bringChildToFront(viewGroup2);
        } catch (Exception e16) {
            QLog.i("Q.recent", 1, "frameHelper_initDrawerFrame exception, " + e16.toString());
        }
        if (this.E == null) {
            return;
        }
        j jVar2 = this.f194650d0;
        if (jVar2 != null) {
            jVar2.onDrawerInit(true);
        }
        this.E.setDrawerCallbacks(this.P);
        lj();
        f194645g0 = new WeakReference<>(this.E);
        Ui(true);
    }

    private void Ci() {
        int id5;
        QLog.i("Q.recent", 1, "[" + System.identityHashCode(this) + "] initNecessaryUI  currentTabName:" + this.currentTabName);
        this.U = true;
        TitleAreaHeadLayout titleAreaHeadLayout = (TitleAreaHeadLayout) getBaseActivity().findViewById(R.id.e3u);
        this.D = titleAreaHeadLayout;
        titleAreaHeadLayout.i(getBaseActivity(), new e());
        CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) getBaseActivity().findViewById(R.id.fd9);
        this.C = circleBoarderImageView;
        circleBoarderImageView.setVisibility(8);
        this.C.setOnClickListener(this);
        CircleBoarderImageView circleBoarderImageView2 = this.C;
        if (li() == null) {
            id5 = R.id.conversation_head;
        } else {
            id5 = li().getId();
        }
        qj(circleBoarderImageView2, id5);
        Di();
        sj();
        rj("initNecessaryUI");
        View findViewById = this.mRootView.findViewById(R.id.zrb);
        this.K = findViewById;
        jj(findViewById);
        ei(null);
    }

    private void Di() {
        if (this.I == null) {
            com.tencent.mobileqq.onlinestatus.bw bwVar = new com.tencent.mobileqq.onlinestatus.bw() { // from class: com.tencent.mobileqq.app.FrameHelperActivity.5
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.app.FrameHelperActivity$5$2, reason: invalid class name */
                /* loaded from: classes11.dex */
                class AnonymousClass2 implements Runnable {
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Drawable f194662d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f194663e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass5 f194664f;

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (this.f194662d == null) {
                            FrameHelperActivity.this.C.setVisibility(8);
                        } else {
                            FrameHelperActivity.this.C.setVisibility(8);
                            FrameHelperActivity.this.C.setImageDrawable(this.f194662d);
                        }
                        FrameHelperActivity.this.C.setContentDescription(this.f194663e);
                    }
                }

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FrameHelperActivity.this);
                    }
                }

                @Override // com.tencent.mobileqq.onlinestatus.bw
                public TextView a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (TextView) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    Conversation conversation = (Conversation) FrameHelperActivity.this.getFrame(Conversation.class);
                    if (conversation != null) {
                        return conversation.mStatusInfo;
                    }
                    return null;
                }

                @Override // com.tencent.mobileqq.onlinestatus.bw
                public void b(String str, Drawable drawable, Drawable drawable2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, this, str, drawable, drawable2);
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    com.tencent.mobileqq.util.ax.a(ThreadManagerV2.getUIHandlerV2(), new Runnable(str, drawable, drawable2, (Conversation) FrameHelperActivity.this.getFrame(Conversation.class), currentTimeMillis) { // from class: com.tencent.mobileqq.app.FrameHelperActivity.5.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f194656d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ Drawable f194657e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ Drawable f194658f;

                        /* renamed from: h, reason: collision with root package name */
                        final /* synthetic */ Conversation f194659h;

                        /* renamed from: i, reason: collision with root package name */
                        final /* synthetic */ long f194660i;

                        {
                            this.f194656d = str;
                            this.f194657e = drawable;
                            this.f194658f = drawable2;
                            this.f194659h = r9;
                            this.f194660i = currentTimeMillis;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass5.this, str, drawable, drawable2, r9, Long.valueOf(currentTimeMillis));
                            }
                        }

                        /* JADX WARN: Removed duplicated region for block: B:27:0x00fe  */
                        /* JADX WARN: Removed duplicated region for block: B:33:0x0142  */
                        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void run() {
                            TextView textView;
                            AppRuntime appRuntime;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            ((IBaseStatusTitleBarApi) QRoute.api(IBaseStatusTitleBarApi.class)).notifyStatusInfo(this.f194656d, this.f194657e, this.f194658f);
                            if (this.f194659h != null && FrameHelperActivity.this.isAdded()) {
                                TextView textView2 = this.f194659h.mStatusInfo;
                                if (this.f194657e != null) {
                                    int f16 = BaseAIOUtils.f(12.0f, FrameHelperActivity.this.getResources());
                                    this.f194657e.setBounds(0, 0, f16, f16);
                                }
                                Drawable drawable3 = FrameHelperActivity.this.getResources().getDrawable(R.drawable.qui_chevron_right);
                                int f17 = BaseAIOUtils.f(9.0f, FrameHelperActivity.this.getResources());
                                drawable3.setBounds(0, 0, f17, f17);
                                Drawable drawable4 = this.f194658f;
                                if (drawable4 == null) {
                                    if (drawable3 instanceof SkinnableBitmapDrawable) {
                                        drawable4 = new BitmapDrawable(FrameHelperActivity.this.getResources(), ((SkinnableBitmapDrawable) drawable3).getBitmap());
                                        drawable4.setBounds(0, 0, f17, f17);
                                        drawable4.setColorFilter(textView2.getCurrentTextColor(), PorterDuff.Mode.SRC_IN);
                                    } else {
                                        drawable4 = drawable3;
                                    }
                                }
                                textView2.setText(this.f194656d);
                                textView2.setCompoundDrawablePadding(BaseAIOUtils.f(2.0f, FrameHelperActivity.this.getResources()));
                                textView2.setCompoundDrawables(this.f194657e, null, drawable4, null);
                                QLog.i("Q.recent", 1, "[updateStatusInfo] info=" + com.tencent.util.k.d(this.f194656d) + "delay=" + (System.currentTimeMillis() - this.f194660i));
                                Object tag = textView2.getTag(R.id.uwi);
                                if (tag instanceof WeakReference) {
                                    WeakReference weakReference = (WeakReference) tag;
                                    if (weakReference.get() instanceof TextView) {
                                        textView = (TextView) weakReference.get();
                                        if (textView != null) {
                                            textView.setText(this.f194656d);
                                            textView.setCompoundDrawablePadding(BaseAIOUtils.f(2.0f, FrameHelperActivity.this.getResources()));
                                            if (drawable3 instanceof SkinnableBitmapDrawable) {
                                                BitmapDrawable bitmapDrawable = new BitmapDrawable(FrameHelperActivity.this.getResources(), ((SkinnableBitmapDrawable) drawable3).getBitmap());
                                                bitmapDrawable.setBounds(0, 0, f17, f17);
                                                bitmapDrawable.setColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN);
                                            }
                                            textView.setCompoundDrawables(this.f194657e, null, null, null);
                                        }
                                        appRuntime = FrameHelperActivity.this.app;
                                        if (appRuntime == null) {
                                            IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "");
                                            Conversation conversation = this.f194659h;
                                            iOnlineStatusService.checkAndSetConversationGuide(conversation.mStatusInfo, conversation.mStatusInfoGuide);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                textView = null;
                                if (textView != null) {
                                }
                                appRuntime = FrameHelperActivity.this.app;
                                if (appRuntime == null) {
                                }
                            }
                        }
                    });
                }
            };
            AppRuntime appRuntime = this.app;
            if (appRuntime == null) {
                return;
            }
            this.I = ((IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "")).newPresenter(getBaseActivity(), bwVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ei() {
        ActivityResultCaller findFragmentByTag = getQBaseActivity().getSupportFragmentManager().findFragmentByTag(com.tencent.mobileqq.onlinestatus.y.class.getName());
        if (!(findFragmentByTag instanceof com.tencent.mobileqq.onlinestatus.y)) {
            return true;
        }
        return true ^ ((com.tencent.mobileqq.onlinestatus.y) findFragmentByTag).isShowing();
    }

    public static boolean Fi() {
        DrawerFrame drawerFrame;
        WeakReference<DrawerFrame> weakReference = f194645g0;
        if (weakReference != null) {
            drawerFrame = weakReference.get();
        } else {
            drawerFrame = null;
        }
        if (drawerFrame != null) {
            return drawerFrame.o();
        }
        return true;
    }

    public static boolean Gi() {
        DrawerFrame drawerFrame;
        WeakReference<DrawerFrame> weakReference = f194645g0;
        if (weakReference != null) {
            drawerFrame = weakReference.get();
        } else {
            drawerFrame = null;
        }
        if (drawerFrame == null) {
            return false;
        }
        if (!drawerFrame.q() && !drawerFrame.p()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Oi(final QQAppInterface qQAppInterface, final QBaseActivity qBaseActivity) {
        final Card card;
        try {
            QQAppInterface qQAppInterface2 = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            card = ((FriendsManager) qQAppInterface2.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(qQAppInterface2.getCurrentAccountUin());
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w("AccountManageActivity", 2, "showLogoutDialog getCard Exception! ");
            }
            card = null;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.app.ai
            @Override // java.lang.Runnable
            public final void run() {
                FrameHelperActivity.this.Ni(qQAppInterface, qBaseActivity, card);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Pi() {
        Vibrator vibrator = (Vibrator) BaseApplication.getContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(new long[]{0, 1, 20, 21}, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Sh, reason: merged with bridge method [inline-methods] */
    public void Mi() {
        ViewGroup viewGroup = this.F;
        if (viewGroup != null) {
            RandomCoverView randomCoverView = (RandomCoverView) viewGroup.findViewById(R.id.f167001jt4);
            ImageView imageView = (ImageView) this.F.findViewById(R.id.ac5);
            ImageView imageView2 = (ImageView) this.F.findViewById(R.id.kis);
            p pVar = this.X;
            if (pVar != null && pVar.isInited() && !this.X.c()) {
                dj(true);
                if (Vh()) {
                    try {
                        randomCoverView.setVisibility(0);
                        if (!this.mUiHandler.hasMessages(14)) {
                            this.mUiHandler.sendEmptyMessage(14);
                        }
                    } catch (OutOfMemoryError e16) {
                        randomCoverView.setVisibility(8);
                        e16.printStackTrace();
                    }
                    imageView.setVisibility(0);
                    imageView2.setVisibility(8);
                    return;
                }
                imageView.setVisibility(8);
                randomCoverView.d().setImageDrawable(null);
                randomCoverView.setVisibility(8);
                imageView2.setImageResource(R.drawable.qq_com_bg_pic);
                imageView2.setVisibility(0);
                return;
            }
            dj(false);
        }
    }

    private void Th() {
        DrawerFrame drawerFrame = this.E;
        if (drawerFrame != null) {
            if (drawerFrame.q()) {
                this.E.a();
            } else {
                this.E.setDrawerShadowFlag(true);
            }
        }
    }

    private boolean Vh() {
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || this.X.c()) {
            return false;
        }
        return ThemeUtil.isNowThemeIsDefault(baseActivity.getAppRuntime(), true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wh() {
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null && baseActivity.getAppRuntime() != null) {
            AppRuntime.Status onlineStatus = ((IOnlineStatusService) baseActivity.getAppRuntime().getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
            long selfExtOnlineStatus = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getSelfExtOnlineStatus(baseActivity.getAppRuntime());
            AppRuntime.Status status = AppRuntime.Status.online;
            if (onlineStatus == status && selfExtOnlineStatus == 1030) {
                int checkSelfPermission = baseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION");
                if (checkSelfPermission != 0) {
                    DialogUtil.showPermissionDialogForOnlineStatusLocation(baseActivity, R.string.f197034ix, R.string.f197054iz);
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("OnlineStatus", 2, "granted:", Integer.valueOf(checkSelfPermission));
                        return;
                    }
                    return;
                }
            }
            if (onlineStatus == status && selfExtOnlineStatus == 2017) {
                if (((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepPermission()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.recent", 2, "granted: step count");
                        return;
                    }
                    return;
                }
                DialogUtil.showPermissionDialogForOnlineStatusLocation(baseActivity, R.string.f197094j3, R.string.f197114j5);
                return;
            }
            return;
        }
        QLog.d("Q.recent", 1, "checkLocationPermission, activity or app is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yh() {
        com.tencent.mobileqq.onlinestatus.utils.a.a(getBaseActivity());
        com.tencent.mobileqq.onlinestatus.y yVar = this.H;
        if (yVar != null && yVar.isShowing()) {
            this.H.l(false);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "closeAccountPanel");
        }
    }

    private void Yi(Intent intent) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments.size() == 0) {
            return;
        }
        Fragment fragment = fragments.get(fragments.size() - 1);
        if (Ji(fragment) || Ii(fragment)) {
            ((QPublicBaseFragment) fragment).onNewIntent(intent);
        }
    }

    public static void Zh() {
        DrawerFrame drawerFrame;
        WeakReference<DrawerFrame> weakReference = f194645g0;
        if (weakReference != null) {
            drawerFrame = weakReference.get();
        } else {
            drawerFrame = null;
        }
        if (drawerFrame != null) {
            drawerFrame.c();
        }
    }

    private void Zi(int i3, int i16, Intent intent) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments.size() == 0) {
            return;
        }
        Fragment fragment = fragments.get(fragments.size() - 1);
        if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isProfileCardFragment(fragment)) {
            fragment.onActivityResult(i3, i16, intent);
        }
    }

    public static void cj() {
        DrawerFrame drawerFrame;
        WeakReference<DrawerFrame> weakReference = f194645g0;
        if (weakReference != null) {
            drawerFrame = weakReference.get();
        } else {
            drawerFrame = null;
        }
        if (drawerFrame != null && drawerFrame.q()) {
            drawerFrame.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di() {
        Bi();
        Ai();
    }

    private void dj(boolean z16) {
        DrawerFrame drawerFrame = this.E;
        if (drawerFrame != null) {
            drawerFrame.setBgViewVisibility(z16);
        }
    }

    private void ei(Animator.AnimatorListener animatorListener) {
        if (this.M && this.mRootView != null) {
            QLog.i("Q.recent", 1, "start executeAfterLoginAnim");
            this.M = false;
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mTabBlurView);
            arrayList.add(this.mTabWidget);
            if (this.K == null || this.L == null) {
                fi();
            }
            MainResourceConfig.e(arrayList, this.K, this.L, animatorListener);
            return;
        }
        QLog.i("Q.recent", 1, "executeAfterLoginAnim  needLoginAnimation:" + this.M + ", mRootView:" + this.mRootView + ", this:" + this);
    }

    private void ej() {
        boolean z16;
        if (!Vh()) {
            return;
        }
        n nVar = new n(this);
        if (this.Z > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.util.e.n(nVar, z16);
    }

    private void fi() {
        if (this.K == null) {
            this.K = this.mRootView.findViewById(R.id.zrb);
        }
        if (this.L == null) {
            this.L = this.mRootView.findViewById(R.id.u9_);
        }
    }

    public static void gj(boolean z16, String str) {
        DrawerFrame drawerFrame;
        WeakReference<DrawerFrame> weakReference = f194645g0;
        if (weakReference != null) {
            drawerFrame = weakReference.get();
        } else {
            drawerFrame = null;
        }
        if (drawerFrame != null) {
            drawerFrame.setDrawerEnabled(z16);
            QLog.i("Q.recent", 1, "setDrawerFrameEnable: " + z16 + ", " + str);
        }
    }

    private int hi() {
        if (QQTheme.isDefaultTheme()) {
            return Color.parseColor("#01CEFB");
        }
        return getResources().getColor(R.color.skin_color_title_immersive_bar);
    }

    public static void hj(boolean z16) {
        DrawerFrame drawerFrame;
        WeakReference<DrawerFrame> weakReference = f194645g0;
        if (weakReference != null) {
            drawerFrame = weakReference.get();
        } else {
            drawerFrame = null;
        }
        if (drawerFrame != null) {
            drawerFrame.f185141v0 = z16;
            QLog.i("Q.recent", 1, "setDrawerFrameTouchable, " + z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ii() {
        be currentFrame = getCurrentFrame();
        if (currentFrame instanceof Conversation) {
            return 1;
        }
        if (currentFrame instanceof Contacts) {
            return 3;
        }
        if (!((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).isLebaFrame(currentFrame)) {
            return 1;
        }
        return 4;
    }

    public static FrameHelperActivity ji(@NonNull BaseActivity baseActivity) {
        QBaseFragment qBaseFragment = (QBaseFragment) baseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (qBaseFragment != null) {
            return (FrameHelperActivity) qBaseFragment;
        }
        return null;
    }

    private void jj(View view) {
        TitleAreaHeadLayout titleAreaHeadLayout = this.D;
        if (titleAreaHeadLayout != null && titleAreaHeadLayout.g() == 0 && (view instanceof TitleAreaLeftLayout)) {
            this.D.setLeftLayout(view);
            TitleAreaLeftLayout titleAreaLeftLayout = (TitleAreaLeftLayout) view;
            if (titleAreaLeftLayout.a() == 0) {
                titleAreaLeftLayout.setHeadLayout(this.D);
            }
        }
    }

    private static int ni(float f16) {
        return ViewUtils.dip2px(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(final QQAppInterface qQAppInterface, final QBaseActivity qBaseActivity) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.ag
            @Override // java.lang.Runnable
            public final void run() {
                FrameHelperActivity.this.Oi(qQAppInterface, qBaseActivity);
            }
        }, 16, null, true);
    }

    private void pi() {
        this.mUiHandler.sendEmptyMessage(3);
        this.W = null;
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "start updateOnlineStatus");
        }
        CustomOnlineStatusManager.d().j();
        rj("AccountChange");
        ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).isHeadIconLongClickFunc((QQAppInterface) getBaseActivity().getAppRuntime(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: pj, reason: merged with bridge method [inline-methods] */
    public void Ni(QQAppInterface qQAppInterface, QBaseActivity qBaseActivity, Card card) {
        String string;
        if (getActivity() == null) {
            QLog.e("Q.recent", 1, "showLogoutDialog getActivity is null");
            return;
        }
        if (card != null) {
            long j3 = card.lQQMasterLogindays;
            if (j3 > 0) {
                QQDarenUtils.sQQDarenLoginDays = j3;
            } else {
                QQDarenUtils.sQQDarenLoginDays = 30L;
            }
            long j16 = card.lLoginDays;
            if (j16 != 1 && (j16 <= 1 || j16 >= QQDarenUtils.sQQDarenLoginDays)) {
                if (j16 >= QQDarenUtils.sQQDarenLoginDays) {
                    string = String.format(getString(R.string.c6r), Integer.valueOf((int) card.lLoginDays));
                } else {
                    string = getString(R.string.c6s);
                }
            } else {
                string = String.format(getString(R.string.c6q), Integer.valueOf((int) (QQDarenUtils.sQQDarenLoginDays - card.lLoginDays)));
            }
        } else {
            string = getString(R.string.c6s);
        }
        Dialog dialog = this.Q;
        if (dialog != null) {
            TextView textView = (TextView) dialog.findViewById(R.id.dialogText);
            if (textView != null) {
                textView.requestFocus();
                textView.setText(string);
                textView.setContentDescription(string);
            }
            this.Q.show();
            return;
        }
        ReportDialog reportDialog = new ReportDialog(qBaseActivity, R.style.qZoneInputDialog);
        this.Q = reportDialog;
        reportDialog.setContentView(R.layout.custom_dialog);
        TextView textView2 = (TextView) this.Q.findViewById(R.id.dialogTitle);
        if (textView2 != null) {
            textView2.setText(getString(R.string.c6n));
        }
        TextView textView3 = (TextView) this.Q.findViewById(R.id.dialogText);
        if (textView3 != null) {
            textView3.requestFocus();
            textView3.setText(string);
            textView3.setContentDescription(string);
        }
        TextView textView4 = (TextView) this.Q.findViewById(R.id.dialogLeftBtn);
        if (textView4 != null) {
            textView4.setText(R.string.cancel);
            textView4.setOnClickListener(new b(qQAppInterface));
        }
        TextView textView5 = (TextView) this.Q.findViewById(R.id.dialogRightBtn);
        if (textView5 != null) {
            textView5.setText(R.string.c6p);
            textView5.setOnClickListener(new c(qQAppInterface, qBaseActivity));
        }
        this.Q.setOnDismissListener(new d());
        this.Q.show();
    }

    private void qi() {
        this.mUiHandler.removeMessages(2);
        if (this.f194649c0) {
            Li(new m() { // from class: com.tencent.mobileqq.app.ad
                @Override // com.tencent.mobileqq.app.FrameHelperActivity.m
                public final void a() {
                    FrameHelperActivity.this.di();
                }
            });
        } else {
            di();
        }
    }

    private void ri() {
        if (!this.U) {
            Ci();
        }
    }

    private void si(Message message) {
        if (message.arg1 == 0) {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.app.FrameHelperActivity.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FrameHelperActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (FrameHelperActivity.this.getBaseActivity() != null && FrameHelperActivity.this.getBaseActivity().getAppRuntime() != null) {
                        FrameHelperActivity.this.zi();
                        Handler handler = FrameHelperActivity.this.mUiHandler;
                        if (handler != null) {
                            handler.sendEmptyMessage(9);
                        }
                    }
                }
            });
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.arg1 = 1;
            this.mUiHandler.sendMessageDelayed(obtain, 20000L);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.recent", 2, "frameHelper_infalter time out, need do in UI thread ");
        }
        this.mUiHandler.sendEmptyMessage(9);
    }

    private void ti() {
        lj();
        DrawerFrame drawerFrame = this.E;
        if (drawerFrame != null && drawerFrame.q()) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "[getCover(app)]from MSG_SET_DIYBG, drawerOpened?" + this.E.q());
            }
            com.tencent.util.e.t();
            this.Z = 3;
            this.mUiHandler.sendEmptyMessage(14);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.ae
            @Override // java.lang.Runnable
            public final void run() {
                FrameHelperActivity.Pi();
            }
        }, 16, null, false);
    }

    private void ui() {
        if (this.E == null) {
            Bi();
        }
        DrawerFrame drawerFrame = this.E;
        if (drawerFrame != null && drawerFrame.o()) {
            this.E.P();
        }
    }

    private void vi() {
        if (!this.U) {
            Ci();
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.recent", 2, "FrameHelperActivity, updateSelfFace now");
        }
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        TitleAreaHeadLayout titleAreaHeadLayout = this.D;
        if (titleAreaHeadLayout != null) {
            titleAreaHeadLayout.k(currentAccountUin);
        }
        ISpecialShapeAvatarMaskLayer iSpecialShapeAvatarMaskLayer = (ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class);
        if (!this.T && (iSpecialShapeAvatarMaskLayer instanceof IMaskDownloadDispatch)) {
            k kVar = this.f194648b0;
            if (kVar == null || !kVar.a()) {
                k kVar2 = this.f194648b0;
                if (kVar2 != null && !kVar2.a()) {
                    ((IMaskDownloadDispatch) iSpecialShapeAvatarMaskLayer).unregisterDispatchCallback(currentAccountUin, this.f194648b0);
                }
                this.f194648b0 = new k(this);
            }
            ((IMaskDownloadDispatch) iSpecialShapeAvatarMaskLayer).registerDispatchCallback(currentAccountUin, this.f194648b0);
        }
    }

    private void wi() {
        com.tencent.mobileqq.onlinestatus.z zVar = this.I;
        if (zVar != null) {
            zVar.c("OlympicMedalEventUpdate");
        }
    }

    private void xi() {
        if (this.F != null) {
            if (ThemeUtil.isNowThemeIsSuperTheme()) {
                this.F.setBackground(null);
            } else {
                this.F.setBackgroundResource(QUITokenResCompat.getDrawableResId(R.drawable.qui_common_bg_setting_me_bg));
            }
        }
        if (this.G != null) {
            if (ThemeUtil.isNowThemeIsSuperTheme()) {
                this.G.setVisibility(4);
                return;
            }
            this.G.setVisibility(0);
            if (ThemeUtil.useNativeThemeVideoPlayer()) {
                this.G.post(new Runnable() { // from class: com.tencent.mobileqq.app.FrameHelperActivity.8
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) FrameHelperActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else if (FrameHelperActivity.this.G != null) {
                            ThemeVideoController.getInstance().initDrawer(FrameHelperActivity.this.G);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public void zi() {
        String str;
        long j3;
        try {
            try {
                this.Y.lock();
                if (QLog.isDevelopLevel()) {
                    QLog.i("Q.recent", 4, "frameHelper_inflateUI, " + this.V + "mDrawerBgView=" + this.F);
                }
            } catch (Exception e16) {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    str = "in main thread ";
                } else {
                    this.F = null;
                    this.V = false;
                    str = "not in main thread ";
                }
                if (QLog.isColorLevel()) {
                    QLog.i("Q.recent", 2, str + e16.toString());
                }
                try {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("device_mode", com.tencent.mobileqq.utils.ah.s());
                    hashMap.put("manufacturer", Build.MANUFACTURER);
                    StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                    String currentAccountUin = getBaseActivity().getAppRuntime().getCurrentAccountUin();
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        j3 = 0;
                    } else {
                        j3 = 1;
                    }
                    statisticCollector.collectPerformance(currentAccountUin, "actFrameHelperSubInflate", false, j3, 0L, hashMap, "");
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.recent", 2, e17.toString());
                    }
                }
            }
            if (!this.V && getBaseActivity() != null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getBaseActivity()).inflate(R.layout.b2e, (ViewGroup) null);
                this.F = viewGroup;
                this.G = (QQSettingMeBackgroundView) viewGroup.findViewById(R.id.f164598a81);
                xi();
                if (QLog.isColorLevel()) {
                    QLog.d("Q.recent", 2, "frameHelper_inflateUI|mDrawerBgView= " + this.F);
                }
                this.V = true;
            }
        } finally {
            this.Y.unlock();
        }
    }

    public boolean Hi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this)).booleanValue();
        }
        if (this.E != null) {
            return true;
        }
        return false;
    }

    public boolean Ii(Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this, (Object) fragment)).booleanValue();
        }
        if (AppSetting.t(getContext()) && ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).isLiveReadyFragment(fragment)) {
            return true;
        }
        return false;
    }

    public boolean Ji(Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, (Object) fragment)).booleanValue();
        }
        if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isProfileCardFragment(fragment) && (fragment instanceof QPublicBaseFragment)) {
            return true;
        }
        return false;
    }

    public boolean Ki() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        TitleAreaHeadLayout titleAreaHeadLayout = this.D;
        if (titleAreaHeadLayout == null || titleAreaHeadLayout.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Md() {
        com.tencent.mobileqq.onlinestatus.y yVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, (Object) this)).booleanValue();
        }
        if (OnlineStatusToggleUtils.e() && (yVar = (com.tencent.mobileqq.onlinestatus.y) getBaseActivity().getSupportFragmentManager().findFragmentByTag(com.tencent.mobileqq.onlinestatus.y.class.getName())) != null) {
            yVar.Md();
            return true;
        }
        com.tencent.mobileqq.onlinestatus.y yVar2 = this.H;
        if (yVar2 != null && yVar2.Md()) {
            return true;
        }
        return false;
    }

    public void Qh(DrawerFrame.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
        } else {
            this.J.add(dVar);
        }
    }

    protected void Qi(com.tencent.mobileqq.onlinestatus.y yVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) yVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @MainThread
    /* renamed from: Rh, reason: merged with bridge method [inline-methods] */
    public void Li(final m mVar) {
        if (this.V) {
            QLog.i("Q.recent", 1, "[inflateUI] already inflated, notify");
            mVar.a();
            return;
        }
        try {
            if (this.Y.tryLock(1L, TimeUnit.MILLISECONDS)) {
                try {
                    QLog.i("Q.recent", 1, "[inflateUI] start inflating");
                    zi();
                    mVar.a();
                    this.Y.unlock();
                    return;
                } catch (Throwable th5) {
                    this.Y.unlock();
                    throw th5;
                }
            }
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.app.af
                @Override // java.lang.Runnable
                public final void run() {
                    FrameHelperActivity.this.Li(mVar);
                }
            }, 100L);
        } catch (Exception e16) {
            QLog.w("Q.recent", 1, "[inflateUI] failed to wait lock, exc=" + e16);
        }
    }

    protected void Ri() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
        }
    }

    protected void Si() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        Conversation conversation = (Conversation) getFrame(Conversation.class);
        if (conversation != null) {
            ((IOnlineStatusService) this.app.getRuntimeService(IOnlineStatusService.class, "")).onClickConversationGuide(this.app, conversation.mStatusInfo, conversation.mStatusInfoGuide);
            ((IBaseStatusTitleBarApi) QRoute.api(IBaseStatusTitleBarApi.class)).solveStatusBeforePanelShow();
        }
    }

    protected void Ti(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void Uh(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, z16);
        } else {
            f194646h0 = z16;
        }
    }

    protected void Ui(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        }
    }

    protected void Vi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    public void Wi() {
        Conversation conversation;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else if (!this.T && (conversation = (Conversation) getFrame(Conversation.class)) != null) {
            conversation.handleOnLoginAnimEnd();
        }
    }

    public void Xh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        TitleAreaHeadLayout titleAreaHeadLayout = this.D;
        if (titleAreaHeadLayout != null) {
            titleAreaHeadLayout.a();
        }
    }

    public void Xi(Activity activity, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) activity, (Object) qQAppInterface);
        } else {
            ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).logout(activity, true);
            ThreadManagerV2.getUIHandlerV2().postDelayed(new com.tencent.mobileqq.activity.home.ae(), 500L);
        }
    }

    public void aj() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        QLog.i("Q.recent", 1, "prepareAfterLoginAnim");
        this.M = true;
        TitleAreaHeadLayout titleAreaHeadLayout = this.D;
        if (titleAreaHeadLayout != null) {
            titleAreaHeadLayout.setVisibility(0, "login_anim");
        }
        ei(new f());
    }

    public void bi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this);
            return;
        }
        Dialog dialog = this.Q;
        if (dialog != null && dialog.isShowing()) {
            try {
                this.Q.dismiss();
            } catch (Exception e16) {
                QLog.e("Q.recent", 1, "dismiss logout dialog exception:", e16);
            }
        }
        this.Q = null;
    }

    public void bj() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        fi();
        QQBlurViewWrapper qQBlurViewWrapper = this.mTabBlurView;
        if (qQBlurViewWrapper != null && this.mTabWidget != null && this.K != null && this.L != null) {
            qQBlurViewWrapper.setVisibility(8);
            this.mTabWidget.setVisibility(8);
            this.K.setVisibility(8);
            this.L.setVisibility(8);
            TitleAreaHeadLayout titleAreaHeadLayout = this.D;
            if (titleAreaHeadLayout != null) {
                titleAreaHeadLayout.setVisibility(8, "login_anim");
            }
        }
    }

    protected void ci(int i3, boolean z16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
            return;
        }
        AppRuntime appRuntime = null;
        String str = null;
        if (getBaseActivity() != null && getBaseActivity().getAppRuntime() != null) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            str = "0X8004031";
                        }
                    } else {
                        str = "0X8004030";
                    }
                } else {
                    str = "0X8004032";
                }
            } else if (z16) {
                ReportController.o(getBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800ABB1", "0X800ABB1", VipInfoHandler.J2((QQAppInterface) getBaseActivity().getAppRuntime(), getBaseActivity().getAppRuntime().getCurrentUin(), yi().booleanValue()), 0, "0", "0", "", "");
                str = "0X800402E";
            } else {
                str = "0X800402F";
            }
            if (str != null) {
                ReportController.o(getBaseActivity().getAppRuntime(), "CliOper", "", "", str, str, i16, 0, "", "", "", "");
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, "doDrawerActionReport, actionFlag: " + i3 + ", tag = " + str);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("doDrawerActionReport, getActivity =  ");
            sb5.append(getBaseActivity());
            sb5.append(" app = ");
            if (getBaseActivity() != null) {
                appRuntime = getBaseActivity().getAppRuntime();
            }
            sb5.append(appRuntime);
            QLog.i("Q.recent", 2, sb5.toString());
        }
    }

    @Override // com.tencent.mobileqq.app.FrameFragment
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        com.tencent.mobileqq.onlinestatus.y yVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (!OnlineStatusToggleUtils.e() && (yVar = this.H) != null) {
            yVar.onActivityResult(i3, i16, intent);
        }
        DrawerFrame drawerFrame = this.E;
        if (drawerFrame != null && this.X != null && drawerFrame.q()) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "[getCover(app)]from doOnActivityResult");
            }
            this.mUiHandler.sendEmptyMessage(14);
        } else {
            super.doOnActivityResult(i3, i16, intent);
        }
        Zi(i3, i16, intent);
        NtMsgForwardUtils.f349949a.m(getActivity(), i3, i16, intent, null);
    }

    @Override // com.tencent.mobileqq.app.FrameFragment
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) intent);
        } else {
            super.doOnNewIntent(intent);
            Yi(intent);
        }
    }

    public void fj(Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) card);
            return;
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || baseActivity.getAppRuntime() == null || card == null || this.X == null || !Vh()) {
            return;
        }
        if (com.tencent.util.e.q()) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.PROFILE_CARD, 2, "account has logouted,restart to fetch coverUrl");
            }
            com.tencent.util.e.j();
            this.Z = 3;
            ej();
            return;
        }
        com.tencent.util.e.o(card, new n(this));
    }

    @Nullable
    public QQProAvatarView gi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (QQProAvatarView) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        TitleAreaHeadLayout titleAreaHeadLayout = this.D;
        if (titleAreaHeadLayout != null) {
            return titleAreaHeadLayout.c();
        }
        return null;
    }

    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) message)).booleanValue();
        }
        if (!this.T && getBaseActivity() != null) {
            int i3 = message.what;
            if (i3 != 9) {
                if (i3 != 19) {
                    switch (i3) {
                        case 1:
                            ri();
                            break;
                        case 2:
                            si(message);
                            break;
                        case 3:
                            sj();
                            break;
                        case 4:
                            pi();
                            break;
                        case 5:
                            ti();
                            break;
                        case 6:
                            ui();
                            break;
                        default:
                            switch (i3) {
                                case 12:
                                    vi();
                                    break;
                                case 13:
                                    TitleAreaHeadLayout titleAreaHeadLayout = this.D;
                                    if (titleAreaHeadLayout != null) {
                                        titleAreaHeadLayout.o();
                                        break;
                                    }
                                    break;
                                case 14:
                                    ej();
                                    break;
                            }
                    }
                } else {
                    wi();
                }
            } else {
                qi();
            }
        }
        return false;
    }

    public void ij(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) jVar);
            return;
        }
        this.f194650d0 = jVar;
        if (this.E != null && jVar != null) {
            jVar.onDrawerInit(true);
        }
    }

    @Nullable
    public View ki() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (View) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        TitleAreaHeadLayout titleAreaHeadLayout = this.D;
        if (titleAreaHeadLayout != null) {
            return titleAreaHeadLayout.e();
        }
        return null;
    }

    public void kj(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) pVar);
            return;
        }
        this.X = pVar;
        if (pVar != null) {
            pVar.a(new com.tencent.mobileqq.t() { // from class: com.tencent.mobileqq.app.ah
                @Override // com.tencent.mobileqq.t
                public final void a() {
                    FrameHelperActivity.this.Mi();
                }
            });
        }
    }

    @Nullable
    public View li() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (View) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        TitleAreaHeadLayout titleAreaHeadLayout = this.D;
        if (titleAreaHeadLayout != null) {
            return titleAreaHeadLayout.f();
        }
        return null;
    }

    void lj() {
        ThemeBackground.applyThemeBg(super.getBaseActivity().getAppRuntime(), this.G, 0, 0, "-conversation-");
    }

    public TitleAreaHeadLayout mi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (TitleAreaHeadLayout) iPatchRedirector.redirect((short) 50, (Object) this);
        }
        return this.D;
    }

    public void mj() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (getCurrentTab() == com.tencent.mobileqq.activity.home.impl.a.f183038a) {
            i3 = 3;
        } else {
            i3 = 2;
        }
        nj(i3);
    }

    public void nj(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
            return;
        }
        if (this.app == null) {
            return;
        }
        com.tencent.mobileqq.onlinestatus.y yVar = this.H;
        if (yVar != null && !yVar.isShowing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (OnlineStatusToggleUtils.e()) {
            z16 = Ei();
        }
        if (!z16) {
            return;
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            QLog.d("Q.recent", 1, "showAccountPanel null == activity");
            return;
        }
        if (baseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName()) == null) {
            QLog.d("Q.recent", 1, "showAccountPanel null == mf");
            return;
        }
        tj();
        ((IOnlineStatusService) this.app.getRuntimeService(IOnlineStatusService.class, "")).getOlympicMedalEventReq(false, true);
        Si();
        com.tencent.mobileqq.onlinestatus.z zVar = this.I;
        if (zVar != null) {
            zVar.c("from_user_click");
        }
        if (OnlineStatusToggleUtils.e()) {
            com.tencent.mobileqq.onlinestatus.y newAccountPanel = ((IOnlineStatusService) this.app.getRuntimeService(IOnlineStatusService.class, "")).newAccountPanel(getBaseActivity());
            Qi(newAccountPanel);
            newAccountPanel.D3(this.f194652f0);
            newAccountPanel.Pc(new o(this));
            newAccountPanel.show(i3);
        } else {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100981", true)) {
                this.H.D3(this.f194652f0);
                this.H.Pc(new o(this));
            }
            this.H.show(i3);
        }
        Ri();
        Wh();
    }

    public void oi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this);
        } else if (((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getSelfExtOnlineStatus(this.app) == 1080) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.FrameHelperActivity.14
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FrameHelperActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ((IOnlineStatusService) FrameHelperActivity.this.app.getRuntimeService(IOnlineStatusService.class, "")).getOlympicMedalEventReq(false, false);
                    }
                }
            }, 16, null, true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) view);
        } else if (view.getId() == R.id.fd9) {
            com.tencent.mobileqq.onlinestatus.y yVar = this.H;
            if (yVar != null && !yVar.isShowing()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (OnlineStatusToggleUtils.e()) {
                z16 = Ei();
            }
            if (z16) {
                mj();
                ReportController.o(getBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800A999", "0X800A999", 2, 0, "", "", "", "");
                ReportController.o(getBaseActivity().getAppRuntime(), "dc00898", "", "", "0X8009E83", "0X8009E83", 0, 0, "", "", "", "");
                ReportController.o(getBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800BDEC", "0X800BDEC", 2, 0, "", "", "", "");
                if (QLog.isColorLevel()) {
                    QLog.d("Q.recent", 2, "click online status icon");
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.FrameFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        p pVar = this.X;
        if (pVar != null) {
            pVar.onConfigurationChanged(configuration);
        }
        Yh();
        cj();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        this.mUiHandler = new Handler(Looper.getMainLooper(), new l(this));
        this.T = false;
        super.onCreate(bundle);
    }

    @Override // com.tencent.mobileqq.app.FrameFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        com.tencent.mobileqq.onlinestatus.z zVar;
        AppRuntime peekAppRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.T = true;
        super.onDestroy();
        p pVar = this.X;
        if (pVar != null) {
            pVar.onDestroy();
        }
        IVasQuickUpdateService iVasQuickUpdateService = (IVasQuickUpdateService) getBaseActivity().getAppRuntime().getRuntimeService(IVasQuickUpdateService.class, "");
        CallBacker callBacker = this.W;
        if (callBacker != null) {
            iVasQuickUpdateService.removeCallBacker(callBacker);
        }
        this.mUiHandler.removeCallbacksAndMessages(null);
        com.tencent.mobileqq.onlinestatus.y yVar = this.H;
        if (yVar != null) {
            yVar.onDestory();
            this.H = null;
        }
        TitleAreaHeadLayout titleAreaHeadLayout = this.D;
        if (titleAreaHeadLayout != null) {
            titleAreaHeadLayout.destroy();
        }
        ISpecialShapeAvatarMaskLayer iSpecialShapeAvatarMaskLayer = (ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class);
        if ((iSpecialShapeAvatarMaskLayer instanceof IMaskDownloadDispatch) && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null && peekAppRuntime.getCurrentAccountUin() != null && this.f194648b0 != null) {
            ((IMaskDownloadDispatch) iSpecialShapeAvatarMaskLayer).unregisterDispatchCallback(peekAppRuntime.getCurrentAccountUin(), this.f194648b0);
        }
        this.W = null;
        if (OnlineStatusToggleUtils.g() && (zVar = this.I) != null) {
            zVar.d(null);
            this.I = null;
        }
    }

    @Override // com.tencent.mobileqq.app.FrameFragment
    public void onLogout(Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) logoutReason);
            return;
        }
        super.onLogout(logoutReason);
        com.tencent.mobileqq.onlinestatus.z zVar = this.I;
        if (zVar != null) {
            zVar.unRegisterBatteryBroadcastReceiver();
            this.I.b((AppInterface) this.app);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        DrawerFrame drawerFrame = this.E;
        if (drawerFrame != null) {
            drawerFrame.v(z16);
        }
    }

    @Override // com.tencent.mobileqq.app.FrameFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onPause();
        if (SplashActivity.currentFragment != 1 && !this.mForceDoIt) {
            return;
        }
        this.S = false;
        DrawerFrame drawerFrame = this.E;
        if (drawerFrame != null && drawerFrame.p() && this.app.isLogin()) {
            this.E.M();
        }
        DrawerFrame drawerFrame2 = this.E;
        if (drawerFrame2 != null && this.X != null && drawerFrame2.q()) {
            this.X.onPause();
        }
        com.tencent.mobileqq.onlinestatus.y yVar = this.H;
        if (yVar instanceof Dialog) {
            yVar.onPause();
        }
        ((LocalRedTouchManager) getBaseActivity().getAppRuntime().getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).x(1);
    }

    @Override // com.tencent.mobileqq.app.FrameFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        int id5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        Th();
        Mi();
        lj();
        CircleBoarderImageView circleBoarderImageView = this.C;
        if (li() == null) {
            id5 = R.id.conversation_head;
        } else {
            id5 = li().getId();
        }
        qj(circleBoarderImageView, id5);
        this.mTabHostDivider = SimpleModeHelper.b((ViewGroup) this.mTabHost, this.mTabHostDivider);
        super.onPostThemeChanged();
        xi();
        ai();
    }

    @Override // com.tencent.mobileqq.app.FrameFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onResume();
        if (SplashActivity.currentFragment != 1) {
            return;
        }
        this.S = true;
        Mi();
        DrawerFrame drawerFrame = this.E;
        if (drawerFrame != null && this.X != null && drawerFrame.q()) {
            this.X.onResume();
            sj();
            if (!this.mUiHandler.hasMessages(14)) {
                this.mUiHandler.sendEmptyMessage(14);
            }
            ApngImage.pauseAll();
            ApngImage.playByTag(1);
        }
        rj("onResume");
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PROFILE_CARD, 2, "[QQSetting onResume] updateOnlineStatus");
        }
        TitleAreaHeadLayout titleAreaHeadLayout = this.D;
        if (titleAreaHeadLayout != null) {
            titleAreaHeadLayout.m(getCurrentTabName());
        } else {
            QLog.i("Q.recent", 1, "onResume mHeadRoot is null");
        }
    }

    @Override // com.tencent.mobileqq.app.FrameFragment
    public void onTabChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) str);
            return;
        }
        super.onTabChanged(str);
        CircleBoarderImageView circleBoarderImageView = this.C;
        if (circleBoarderImageView != null) {
            circleBoarderImageView.setVisibility(8);
        }
        TitleAreaHeadLayout titleAreaHeadLayout = this.D;
        if (titleAreaHeadLayout != null) {
            titleAreaHeadLayout.l(str.equals(Conversation.class.getName()));
        }
    }

    public void qj(CircleBoarderImageView circleBoarderImageView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) circleBoarderImageView, i3);
            return;
        }
        if (circleBoarderImageView != null && (circleBoarderImageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            circleBoarderImageView.setBorderWidth(ni(1.1f));
            int hi5 = hi();
            circleBoarderImageView.setBorderColor(hi5);
            circleBoarderImageView.setFillColor(hi5);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) circleBoarderImageView.getLayoutParams();
            layoutParams.width = ni(34.0f);
            layoutParams.height = ni(19.0f);
            layoutParams.rightMargin = ni(-21.1f);
            layoutParams.bottomMargin = ni(-6.1f);
            layoutParams.removeRule(1);
            layoutParams.addRule(7, i3);
            circleBoarderImageView.setLayoutParams(layoutParams);
            circleBoarderImageView.setPadding(ni(2.0f), ni(2.0f), ni(20.0f), ni(5.0f));
        }
    }

    public void rj(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) str);
            return;
        }
        com.tencent.mobileqq.onlinestatus.z zVar = this.I;
        if (zVar != null) {
            zVar.c(str);
        }
    }

    @Override // com.tencent.mobileqq.app.FrameFragment
    public void setQQHeadVisibility(int i3, @NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3, (Object) str);
            return;
        }
        TitleAreaHeadLayout titleAreaHeadLayout = this.D;
        if (titleAreaHeadLayout != null) {
            titleAreaHeadLayout.setVisibility(i3, str, "currentTabName:" + this.currentTabName);
        }
    }

    public void sj() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (!this.T && baseActivity != null && baseActivity.getAppRuntime() != null) {
            handleMessage(com.tencent.mobileqq.util.ax.b(this.mUiHandler, 12));
            QLog.i(LogTag.GET_HEAD, 1, "FrameHelperActivity, updateSelfFace");
        }
    }

    @Override // com.tencent.mobileqq.app.FrameFragment
    public void updateTabSetting(@Nullable BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, IRedTouchManager iRedTouchManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) redTypeInfo, (Object) iRedTouchManager);
            return;
        }
        TitleAreaHeadLayout titleAreaHeadLayout = this.D;
        if (titleAreaHeadLayout != null) {
            titleAreaHeadLayout.q(redTypeInfo, iRedTouchManager);
        }
    }

    @Nullable
    public Boolean yi() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (Boolean) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        TitleAreaHeadLayout titleAreaHeadLayout = this.D;
        if (titleAreaHeadLayout != null) {
            z16 = titleAreaHeadLayout.b();
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    private void ai() {
    }
}
