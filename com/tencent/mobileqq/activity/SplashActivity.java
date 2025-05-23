package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.dataline.activities.LiteActivity;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aio.pref.MethodTrace;
import com.tencent.biz.richframework.compat.IFragmentCallbacks;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.util.ConversationDependencyLoader;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ThemeOverdueBannerProcessor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.AppOpenConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadSetting;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.login.api.ILoginSuccessAnimApi;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.managers.PushNoticeManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.nearbypro.api.INearbyProChatApi;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.perf.report.PerfReportUtil;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.pushnotice.ThirdPushManager;
import com.tencent.mobileqq.pushnotice.ThirdPushNotifyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpActionLegacy;
import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.mobileqq.vas.api.IVasAppIconStateManager;
import com.tencent.mobileqq.vas.theme.ThemeVideoController;
import com.tencent.mobileqq.vas.theme.ThemeVipBehavior;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.OpenSdkIMBlockFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.SplashAIOFragment;
import com.tencent.qqnt.aio.adapter.api.IAIOConvertApi;
import com.tencent.qqnt.aio.adapter.api.UnsupportedChatTypeException;
import com.tencent.qqnt.aio.utils.AIOOptConfigKt;
import com.tencent.qqnt.chats.api.IAvatarGetterService;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.qqperf.crashdefend.CrashDefendManager;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;
import com.tencent.richframework.preload.activity.ArgusPreloadManager;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import cooperation.qzone.api.QZoneApiProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
@RoutePage(desc = "\u624bQ\u4e3b\u9875", path = RouterConstants.UI_ROUTER_SPLASH)
/* loaded from: classes9.dex */
public class SplashActivity extends BaseActivity implements com.tencent.mobileqq.pad.l, com.tencent.mobileqq.webview.swift.u {
    static IPatchRedirector $redirector_ = null;
    private static final long AIO_OPEN_GAP_TIME = 800;
    public static final String CLEAR_FUNCTION_FRAGMENT = "clear_function_fragment";
    public static final int FRAGMENT_CHAT = 2;
    public static final int FRAGMENT_EMPTY = 0;
    public static final String FRAGMENT_ID = "fragment_id";
    public static final int FRAGMENT_MAIN = 1;
    public static final String FROM_HIDDEN_CHAT = "from_hidden_chat";
    private static final Map<String, e> MCALLBACKMAP;
    private static long OPEN_AIO_MIN_INTERVAL_TIME = 0;
    public static final String SWITCH_ANIM = "switch_anim";
    public static final String TAB_INDEX = "tab_index";
    public static final String TAG = "SplashActivity";
    public static volatile int currentFragment;
    private static boolean isProcessStart;
    public static int sExitAIOCode;
    public static long sExitAIOTime;
    public static volatile boolean sIsNormalRouteEnter;
    public static int sOpenAIOCode;
    public static volatile WeakReference<SplashActivity> sWeakInstance;
    private static int taskId;

    /* renamed from: br, reason: collision with root package name */
    private BroadcastReceiver f177134br;
    private long firtCreateAIOTime;
    private Future<View> futureSplashMain;
    private final boolean isCloneInflaterInSubThreadForSplashActivity;
    private final boolean isEnableDelegateLayoutInflaterForSplashActivity;
    private final boolean isEnableDelegateResourceForSplashActivity;
    private WeakReference<SplashAIOFragment> mCurrentAIOFragmentWr;
    private String mJumpShecme;
    private long mLastOpenAIOTime;
    private int mLastOpenAIOType;
    private String mLastOpenAIOUid;
    private long mLastOpenAioTime;
    private String mPkg;
    public View mPreloadConversationView;
    public View mPreloadLocalSearchBar;
    public IRecentContactRepo mPreloadRepo;
    public com.tencent.mobileqq.widget.bn mSplashPreLoadUI;
    public com.tencent.mobileqq.activity.contacts.base.j preladSearchAssistant;
    private com.tencent.mobileqq.pad.k qFragmentStackManager;
    private Resources resourcesWrapper;
    private String splashAIOFragmentTag;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements Callable<View> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f177136d;

        a(long j3) {
            this.f177136d = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SplashActivity.this, Long.valueOf(j3));
            }
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public View call() throws Exception {
            StringBuilder sb5;
            String str = "[loadSplashMain] finished, time: ";
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            View view = null;
            try {
                try {
                    view = LayoutInflater.from(SplashActivity.this).inflate(R.layout.fgq, (ViewGroup) null);
                    sb5 = new StringBuilder();
                } catch (Exception e16) {
                    QLog.i("SplashActivity", 1, "[loadSplashMain] exc=" + e16);
                    sb5 = new StringBuilder();
                }
                sb5.append("[loadSplashMain] finished, time: ");
                sb5.append(System.currentTimeMillis() - this.f177136d);
                str = sb5.toString();
                QLog.i("SplashActivity", 1, str);
                return view;
            } catch (Throwable th5) {
                QLog.i("SplashActivity", 1, str + (System.currentTimeMillis() - this.f177136d));
                throw th5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements e72.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Intent f177138a;

        b(Intent intent) {
            this.f177138a = intent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SplashActivity.this, (Object) intent);
            }
        }

        @Override // e72.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i("SplashActivity", 1, "onAnimStart");
            FrameHelperActivity ji5 = FrameHelperActivity.ji(SplashActivity.this);
            if (ji5 == null) {
                QLog.i("SplashActivity", 1, "frameHelperActivity is null");
            } else {
                ji5.bj();
            }
        }

        @Override // e72.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.i("SplashActivity", 1, "onAnimDisable");
            this.f177138a.removeExtra("loginSuccessAnim");
            ((ILoginSuccessAnimApi) QRoute.api(ILoginSuccessAnimApi.class)).setSplashAnimState(false);
            FrameHelperActivity ji5 = FrameHelperActivity.ji(SplashActivity.this);
            if (ji5 == null) {
                QLog.i("SplashActivity", 1, "frameHelperActivity is null");
            } else {
                ji5.Wi();
            }
        }

        @Override // e72.b
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            QLog.i("SplashActivity", 1, "onLoginAnimEnd");
            this.f177138a.removeExtra("loginSuccessAnim");
            ((ILoginSuccessAnimApi) QRoute.api(ILoginSuccessAnimApi.class)).setSplashAnimState(false);
            FrameHelperActivity ji5 = FrameHelperActivity.ji(SplashActivity.this);
            if (ji5 == null) {
                QLog.i("SplashActivity", 1, "frameHelperActivity is null");
            } else {
                ji5.aj();
            }
        }

        @Override // e72.b
        public void onAnimEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                QLog.i("SplashActivity", 1, "onAnimEnd");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SplashActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            Intent intent = new Intent(SplashActivity.this, (Class<?>) GesturePWDSettingActivity.class);
            intent.putExtra(GesturePWDSettingActivity.KEY_GESTURE_RESET, true);
            SplashActivity.this.startActivity(intent);
            dialogInterface.dismiss();
            ReportController.y(SplashActivity.this.app, "0X800C55C");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SplashActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
                ReportController.y(SplashActivity.this.app, "0X800C55B");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface e {
        void a(int i3, int i16, Intent intent);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67489);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 65)) {
            redirector.redirect((short) 65);
            return;
        }
        sWeakInstance = null;
        currentFragment = 1;
        sIsNormalRouteEnter = true;
        OPEN_AIO_MIN_INTERVAL_TIME = 500L;
        MCALLBACKMAP = new HashMap();
        isProcessStart = false;
        taskId = 0;
        sOpenAIOCode = 0;
        sExitAIOCode = 0;
        sExitAIOTime = 0L;
    }

    public SplashActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mJumpShecme = null;
        this.mPkg = null;
        this.f177134br = null;
        this.mCurrentAIOFragmentWr = null;
        this.isCloneInflaterInSubThreadForSplashActivity = RFWConfig.getConfigValue("SPLASH_ACTIVITY_INFLATE_CLONE", true);
        this.isEnableDelegateLayoutInflaterForSplashActivity = RFWConfig.getConfigValue("SPLASH_ACTIVITY_INFLATE_DELEGATE", false);
        this.isEnableDelegateResourceForSplashActivity = RFWConfig.getConfigValue("SPLASH_ACTIVITY_RESOURCE_DELEGATE", false);
        this.mLastOpenAIOTime = -1L;
        this.mLastOpenAIOUid = "";
        this.mLastOpenAIOType = -2;
    }

    private void checkAndHideMainFragment() {
        Intent intent = getIntent();
        if (intent != null && !TextUtils.isEmpty(intent.getStringExtra("key_peerId"))) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.SplashActivity.17
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SplashActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!SplashActivity.this.isFinishing() && !SplashActivity.this.isDestroyed()) {
                        FragmentManager supportFragmentManager = SplashActivity.this.getSupportFragmentManager();
                        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(SplashActivity.this.getChatFragmentTag());
                        Fragment findFragmentByTag2 = supportFragmentManager.findFragmentByTag(MainFragment.class.getName());
                        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_open_hide_mainfragment_9060", true);
                        QLog.i("SplashActivity", 1, "[checkAndHideMainFragment]: aioFragment is " + findFragmentByTag + " mainFragment is " + findFragmentByTag2 + " currentFragment is " + SplashActivity.currentFragment + " switch is " + isSwitchOn);
                        if (isSwitchOn && findFragmentByTag != null && findFragmentByTag2 != null && SplashActivity.currentFragment == 2) {
                            beginTransaction.hide(findFragmentByTag2);
                            beginTransaction.commitAllowingStateLoss();
                        }
                    }
                }
            }, 200L);
        } else {
            QLog.i("SplashActivity", 1, "[checkAndHideMainFragment]: param invalid");
        }
    }

    private boolean checkDuplication() {
        SplashActivity splashActivity;
        if (sWeakInstance != null) {
            splashActivity = sWeakInstance.get();
        } else {
            splashActivity = null;
        }
        if (splashActivity != null && splashActivity != this && !splashActivity.isFinishing()) {
            int taskId2 = getTaskId();
            int taskId3 = splashActivity.getTaskId();
            QLog.d("SplashActivity", 1, "checkDuplication, " + splashActivity + ", " + taskId3 + ", " + this + ", " + taskId2);
            if (taskId2 == taskId3 && ThemeVipBehavior.handleDuplicationJump(this)) {
                return true;
            }
            splashActivity.finish();
            return false;
        }
        return false;
    }

    private void checkGesture() {
        if (BaseGesturePWDUtil.getGestureUnlockFailed(this, this.app.getCurrentAccountUin())) {
            DialogUtil.createCustomDialog(this, 230, getString(R.string.bi_), getString(R.string.bib), R.string.cancel, R.string.bia, new c(), new d()).show();
            ReportController.y(this.app, "0X800C55D");
        }
    }

    private boolean dealFromSplashAD() {
        if (com.tencent.mobileqq.splashad.t.n(this, this.app)) {
            finish();
            return true;
        }
        if (((ISplashMiniGameStarterService) QRoute.api(ISplashMiniGameStarterService.class)).needJump() && jumpMiniGameAction(this, this.app)) {
            finish();
            return true;
        }
        return false;
    }

    private void dispatchFrameSetIntent(Intent intent) {
        MainFragment mainFragment;
        if (intent != null && (mainFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName())) != null) {
            QLog.d("SplashActivity", 1, "dispatchFrameSetIntent:" + intent.hashCode(), new RuntimeException("intent has new"));
            mainFragment.setIntent(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private WebViewFragment findCurrentWebViewFragment(List<Fragment> list) {
        if (list != null && !list.isEmpty()) {
            for (Fragment fragment : list) {
                if (fragment.isVisible()) {
                    if (fragment instanceof WebViewFragment) {
                        return (WebViewFragment) fragment;
                    }
                    if (fragment instanceof com.tencent.mobileqq.webview.swift.u) {
                        return ((com.tencent.mobileqq.webview.swift.u) fragment).getCurrentWebViewFragment();
                    }
                    WebViewFragment findCurrentWebViewFragment = findCurrentWebViewFragment(fragment.getChildFragmentManager().getFragments());
                    if (findCurrentWebViewFragment != null) {
                        return findCurrentWebViewFragment;
                    }
                }
            }
        }
        return null;
    }

    public static ComponentName getAliasComponent(Context context) {
        return ((IVasAppIconStateManager) QRoute.api(IVasAppIconStateManager.class)).getSplashActivityComponent(context);
    }

    public static Intent getAliasIntent(Context context) {
        Intent intent = new Intent();
        intent.setComponent(((IVasAppIconStateManager) QRoute.api(IVasAppIconStateManager.class)).getSplashActivityComponent(context));
        return intent;
    }

    public static String getAliasName() {
        return ((IVasAppIconStateManager) QRoute.api(IVasAppIconStateManager.class)).getSplashActivityName();
    }

    private void handleIntentFromQc(Intent intent) {
        int intExtra = intent.getIntExtra("forward", -1);
        int intExtra2 = intent.getIntExtra("uintype", -1);
        if (intExtra > 0 && (intExtra2 == 1035 || intExtra2 == 1041 || intExtra2 == 1042)) {
            QQAppInterface qQAppInterface = this.app;
            int i3 = QQManagerFactory.PUSH_NOTICE_MANAGER;
            if (qQAppInterface.isCreateManager(i3)) {
                ((PushNoticeManager) this.app.getManager(i3)).a(this, intent);
                return;
            }
        }
        if (intExtra != 1) {
            if (intExtra != 2) {
                if (intExtra == 3) {
                    String stringExtra = intent.getStringExtra("url");
                    Intent intent2 = new Intent(this, (Class<?>) QQBrowserActivity.class);
                    if (intExtra2 != -1) {
                        intent2.putExtra("uintype", intExtra2);
                        if (intExtra2 == 1030) {
                            QQAppInterface qQAppInterface2 = this.app;
                            int i16 = QQManagerFactory.CAMPUS_NOTICE_MANAGER;
                            if (qQAppInterface2.isCreateManager(i16)) {
                                ((com.tencent.mobileqq.campuscircle.d) this.app.getManager(i16)).f(null);
                                if (QLog.isColorLevel()) {
                                    QLog.d("CampusNoticeManager", 2, "remove campus notice");
                                }
                            }
                        }
                    }
                    intent2.putExtra("url", stringExtra);
                    startActivity(intent2);
                }
            } else {
                Parcelable parcelableExtra = intent.getParcelableExtra(IProfileCardConst.KEY_ALL_IN_ONE);
                if (parcelableExtra instanceof AllInOne) {
                    AllInOne allInOne = (AllInOne) parcelableExtra;
                    allInOne.lastActivity = 100;
                    allInOne.profileEntryType = 6;
                    ProfileUtils.openProfileCard(this, allInOne);
                }
            }
        } else {
            Intent m3 = BaseAIOUtils.m(getAliasIntent(this), null);
            m3.putExtra("uin", intent.getStringExtra("uin"));
            m3.putExtra("uintype", intent.getIntExtra("uintype", 0));
            m3.putExtra("yuyin", intent.getBooleanExtra("yuyin", false));
            m3.putExtra("uinname", intent.getStringExtra("uinname"));
            m3.putExtra("enterchatwin", true);
            startActivity(m3);
            getIntent().removeExtra("fromMsgBox");
        }
        getIntent().removeExtra("forward");
    }

    private void handleLoginSplashAnim(Intent intent) {
        if (!intent.getBooleanExtra("loginSuccessAnim", false)) {
            return;
        }
        b bVar = new b(intent);
        int currentTab = getCurrentTab();
        if (currentTab != 0) {
            QLog.i("SplashActivity", 1, "handleLoginSplashAnim currentTab: " + currentTab);
            bVar.b();
            return;
        }
        ((ILoginSuccessAnimApi) QRoute.api(ILoginSuccessAnimApi.class)).startSplashAnim(this, 300L, bVar);
    }

    private boolean highFrequencyOpenSameAio() {
        Intent intent = getIntent();
        String str = "";
        boolean z16 = false;
        int i3 = -1;
        try {
            str = intent.getStringExtra("key_peerId");
            i3 = intent.getIntExtra("key_chat_type", -1);
        } catch (Exception e16) {
            QLog.e("SplashActivity", 2, e16, new Object[0]);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (!TextUtils.isEmpty(str) && str.equals(this.mLastOpenAIOUid) && i3 == this.mLastOpenAIOType && uptimeMillis - this.mLastOpenAIOTime <= 800) {
            z16 = true;
        }
        if (!z16) {
            this.mLastOpenAIOTime = uptimeMillis;
            this.mLastOpenAIOUid = str;
            this.mLastOpenAIOType = i3;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SplashActivity", 2, "highFrequencyOpenSameAio " + z16);
        }
        return z16;
    }

    private void initSplashState() {
        if ("Success".equals(MobileQQ.sInjectResult)) {
            BaseApplicationImpl.sSplashActivityEscapedMsg = "";
            return;
        }
        String str = "sInjectResult:" + MobileQQ.sInjectResult;
        try {
            throw new IllegalAccessError("SplashActivity escapes!");
        } catch (Throwable th5) {
            BaseApplicationImpl.sSplashActivityEscapedMsg = str + "\n" + Log.getStackTraceString(th5);
        }
    }

    private void initSuperTheme() {
        try {
            ThemeVideoController.getInstance().release();
            if (ThemeUtil.useNativeThemeVideoPlayer()) {
                if (findViewById(R.id.vea) != null) {
                    findViewById(R.id.vea).setBackground(null);
                }
                if (findViewById(R.id.ve9) != null) {
                    findViewById(R.id.ve9).setBackground(null);
                }
                runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.SplashActivity.16
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) SplashActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            ThemeVideoController.getInstance().init((ViewGroup) SplashActivity.this.findViewById(android.R.id.content));
                            ThemeVideoController.getInstance().playMainAnimation();
                        }
                    }
                });
            }
        } catch (Exception e16) {
            QLog.e("SplashActivity", 1, "initSuperTheme error", e16);
        }
    }

    private boolean intercept() {
        return com.tencent.mobileqq.pushnotice.c.b(this, getIntent());
    }

    public static boolean jumpMiniGameAction(SplashActivity splashActivity, AppInterface appInterface) {
        QLog.d("SplashActivity", 2, "jumpMiniGameAction");
        IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
        ISplashMiniGameStarterService iSplashMiniGameStarterService = (ISplashMiniGameStarterService) QRoute.api(ISplashMiniGameStarterService.class);
        iMiniAppService.splashMiniGameClickReport(iSplashMiniGameStarterService.getCurrData());
        iSplashMiniGameStarterService.setNeedJump(false);
        iSplashMiniGameStarterService.setHasJumped();
        Intent intent = new Intent(BaseApplicationImpl.getApplication(), (Class<?>) iSplashMiniGameStarterService.getGameActivityClass());
        intent.addFlags(805371904);
        intent.putExtra("fromSplash", true);
        intent.putExtra("processName", "com.tencent.mobileqq:mini3");
        intent.putExtra("startDuration", System.currentTimeMillis());
        intent.putExtra("splashData", ((ISplashMiniGameStarterService) QRoute.api(ISplashMiniGameStarterService.class)).getCurrData());
        splashActivity.startActivity(intent);
        splashActivity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openAIO$0(Fragment fragment, FragmentTransaction fragmentTransaction) {
        if (!AppSetting.t(this)) {
            if (fragment != null) {
                fragmentTransaction.hide(fragment);
                return;
            } else {
                checkAndHideMainFragment();
                return;
            }
        }
        this.qFragmentStackManager.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openAIO$1(FragmentTransaction fragmentTransaction) {
        if (AppSetting.t(this)) {
            this.qFragmentStackManager.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openNewAIO$3(Fragment fragment, SplashAIOFragment splashAIOFragment, FragmentTransaction fragmentTransaction) {
        SplashAIOFragment splashAIOFragment2;
        if (!AppSetting.t(this)) {
            if (fragment != null) {
                fragmentTransaction.hide(fragment);
            } else {
                checkAndHideMainFragment();
            }
        } else {
            this.qFragmentStackManager.d();
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("open_aio_remove_fragment_8980", true);
        WeakReference<SplashAIOFragment> weakReference = this.mCurrentAIOFragmentWr;
        if (weakReference != null) {
            splashAIOFragment2 = weakReference.get();
        } else {
            splashAIOFragment2 = null;
        }
        if (isSwitchOn && splashAIOFragment2 != null && splashAIOFragment2 != splashAIOFragment) {
            fragmentTransaction.remove(splashAIOFragment2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$preloadUi$2() {
        try {
            this.mPreloadConversationView = LayoutInflater.from(this).inflate(R.layout.f167820ik, (ViewGroup) null);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("SplashActivity", 2, "[preloadUi] e=", th5);
            }
        }
    }

    private void loadChatsListDependencies() {
        new ConversationDependencyLoader().l();
    }

    private void loadSplashMainLayout() {
        this.futureSplashMain = ThreadManager.execute(new a(System.currentTimeMillis()), 16);
    }

    private void onAccountChangedImpl() {
        QLog.d("SplashActivity", 1, "onAccountChangedImpl");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(MainFragment.class.getName());
        if (findFragmentByTag != null) {
            ((MainFragment) findFragmentByTag).onAccountChanged();
        }
        Fragment findFragmentByTag2 = supportFragmentManager.findFragmentByTag(this.splashAIOFragmentTag);
        if (findFragmentByTag2 != null) {
            ((SplashAIOFragment) findFragmentByTag2).onAccountChanged();
        }
        com.tencent.mobileqq.pad.k kVar = this.qFragmentStackManager;
        if (kVar != null) {
            kVar.d();
        }
        ThirdPushManager.getInstance().registerThirdPartyPush();
        SplashADUtil.z(BaseApplication.getContext(), this.app.getLongAccountUin());
        j71.a.c(this.app, true);
    }

    private void onAccountChangedImplV2() {
        QLog.d("SplashActivity", 1, "onAccountChangedImplV2");
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.SplashActivity.13
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SplashActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Fragment findFragmentByTag = SplashActivity.this.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
                if (findFragmentByTag != null) {
                    ((MainFragment) findFragmentByTag).onAccountChanged();
                }
            }
        });
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.SplashActivity.14
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SplashActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Fragment findFragmentByTag = SplashActivity.this.getSupportFragmentManager().findFragmentByTag(SplashActivity.this.splashAIOFragmentTag);
                if (findFragmentByTag != null) {
                    ((SplashAIOFragment) findFragmentByTag).onAccountChanged();
                }
            }
        });
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.SplashActivity.15
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SplashActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (SplashActivity.this.qFragmentStackManager != null) {
                    SplashActivity.this.qFragmentStackManager.d();
                }
                ThirdPushManager.getInstance().registerThirdPartyPush();
                SplashADUtil.z(BaseApplication.getContext(), SplashActivity.this.app.getLongAccountUin());
                j71.a.c(SplashActivity.this.app, true);
            }
        });
    }

    public static void onSystemScreenSettingChanged() {
        ScreenUtil.updateCache();
        XPanelContainer.f384717k0 = 0;
    }

    private SplashAIOFragment openNewAIO(final Fragment fragment, int i3, int i16, Bundle bundle) {
        final SplashAIOFragment splashAIOFragment = new SplashAIOFragment();
        this.splashAIOFragmentTag = this.qFragmentStackManager.t(splashAIOFragment, i3, i16, bundle, new com.tencent.mobileqq.pad.n() { // from class: com.tencent.mobileqq.activity.fe
            @Override // com.tencent.mobileqq.pad.n
            public final void a(FragmentTransaction fragmentTransaction) {
                SplashActivity.this.lambda$openNewAIO$3(fragment, splashAIOFragment, fragmentTransaction);
            }
        });
        this.mCurrentAIOFragmentWr = new WeakReference<>(splashAIOFragment);
        return splashAIOFragment;
    }

    private void removeRegisteredInfo(Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3;
        if (bundle != null && (bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key")) != null && (bundle3 = bundle2.getBundle("android:support:activity-result")) != null) {
            QLog.d("SplashActivity", 1, "remove bundle: KEY_COMPONENT_ACTIVITY_REGISTERE");
            bundle3.remove("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            bundle3.remove("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        }
    }

    private void setSwitch() {
        if (com.tencent.mobileqq.activity.aio.l.f179525a) {
            return;
        }
        com.tencent.mobileqq.activity.aio.l.f179526b = getIntent().getBooleanExtra("traceviewSwitch", false);
        com.tencent.mobileqq.activity.aio.l.f179527c = getIntent().getBooleanExtra("forbidChatFont", false);
        com.tencent.mobileqq.activity.aio.l.f179528d = getIntent().getBooleanExtra("forbidHeadPendant", false);
        com.tencent.mobileqq.activity.aio.l.f179529e = getIntent().getBooleanExtra("forbidChatBubble", false);
        com.tencent.mobileqq.activity.aio.l.f179530f = getIntent().getBooleanExtra("logDBOperation", false);
        ThreadSetting.logcatBgTaskMonitor = getIntent().getBooleanExtra("logBgTaskMonitor", false);
        com.tencent.mobileqq.activity.aio.l.f179525a = true;
        if (QLog.isColorLevel()) {
            QLog.d("SplashActivity", 2, "traceviewSwitch: " + com.tencent.mobileqq.activity.aio.l.f179526b + " isForbidChatFontFun: " + com.tencent.mobileqq.activity.aio.l.f179527c + " isForbidHeadPendantFun: " + com.tencent.mobileqq.activity.aio.l.f179528d + " isForbidChatBubbleFun: " + com.tencent.mobileqq.activity.aio.l.f179529e + " logcatDBOperation: " + com.tencent.mobileqq.activity.aio.l.f179530f + " isEnableAutoDumpLeak: " + AppSetting.f99566z);
        }
    }

    private boolean tryOpenAio(Intent intent) {
        boolean z16;
        boolean z17;
        if (intent.getIntExtra("key_chat_type", -1) == 119) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("SplashActivity", 1, "tryOpenAio isNearbyPro");
            ((INearbyProChatApi) QRoute.api(INearbyProChatApi.class)).openNearbyProAndAIO(this, intent);
            return false;
        }
        if (!verifyOpenAioIntent(intent)) {
            return false;
        }
        if (intent.getIntExtra("uintype", -1) == 10014) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean booleanExtra = intent.getBooleanExtra("open_chatfragment", false);
        QLog.i("SplashActivity", 1, "[tryOpenAio] isGuild " + z17 + " is OpenAIO:" + booleanExtra);
        if (!booleanExtra || z17) {
            return false;
        }
        boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) this.app.getRuntimeService(IFeatureRuntimeService.class)).isFeatureSwitchEnable("pad_navigation_bug_fix");
        QLog.d("SplashActivity", 2, "switch status : ", Boolean.valueOf(isFeatureSwitchEnable));
        if (AppSetting.t(this) && isFeatureSwitchEnable) {
            QLog.d("SplashActivity", 1, "open main fragment");
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager.findFragmentByTag(MainFragment.class.getName()) == null && MainFragment.Vj()) {
                supportFragmentManager.beginTransaction().add(R.id.vea, MainFragment.Sj(true), MainFragment.class.getName()).commitAllowingStateLoss();
            }
        }
        com.tencent.mobileqq.activity.recent.bannerprocessor.d.b(this.app, intent);
        setIntent(intent);
        getIntent().putExtra("isBack2Root", true);
        openAIO(false, 0);
        return true;
    }

    private boolean tryOpenFlashShowTab(Intent intent) {
        if (!intent.getBooleanExtra("open_flash_show_tab_fragment", false)) {
            return false;
        }
        setIntent(intent);
        getIntent().putExtra("isBack2Root", true);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        if (supportFragmentManager.findFragmentByTag(MainFragment.class.getName()) == null) {
            currentFragment = 1;
            MainFragment Sj = MainFragment.Sj(true);
            Sj.mPendingIntent = intent;
            beginTransaction.add(R.id.vea, Sj, MainFragment.class.getName());
            beginTransaction.commitAllowingStateLoss();
        } else {
            openMainFragment(intent);
        }
        return true;
    }

    private boolean tryOpenLiteAio(Intent intent) {
        int intExtra = intent.getIntExtra("uintype", -1);
        if (intExtra != 6000 && intExtra != 6003 && intExtra != 6005) {
            return false;
        }
        String stringExtra = intent.getStringExtra("uin");
        Intent intent2 = new Intent(this, (Class<?>) LiteActivity.class);
        intent2.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, stringExtra);
        intent2.putExtra(PeakConstants.SEND_FLAG, true);
        intent2.putExtra("PhotoConst.PHOTO_PATHS", intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
        startActivity(intent2);
        return true;
    }

    private boolean tryOpenNowTab(Intent intent) {
        if (!intent.getBooleanExtra("open_now_tab_fragment", false) || !this.app.getNowLiveManager().f446627f) {
            return false;
        }
        setIntent(intent);
        getIntent().putExtra("isBack2Root", true);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        if (supportFragmentManager.findFragmentByTag(MainFragment.class.getName()) == null) {
            currentFragment = 1;
            MainFragment Sj = MainFragment.Sj(true);
            Sj.mPendingIntent = intent;
            beginTransaction.add(R.id.vea, Sj, MainFragment.class.getName());
            beginTransaction.commitAllowingStateLoss();
        } else {
            openMainFragment(intent);
        }
        return true;
    }

    private boolean tryOpenQzoneTab(Intent intent) {
        int i3 = 0;
        if (!intent.getBooleanExtra("open_qzone_tab_fragment", false) || !QZoneApiProxy.isInQZoneEnvironment()) {
            return false;
        }
        setIntent(intent);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        if (supportFragmentManager.findFragmentByTag(MainFragment.class.getName()) == null) {
            currentFragment = 1;
            MainFragment Sj = MainFragment.Sj(true);
            Sj.mPendingIntent = intent;
            beginTransaction.add(R.id.vea, Sj, MainFragment.class.getName());
            beginTransaction.commitAllowingStateLoss();
        } else {
            openMainFragment(intent);
            i3 = 1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SplashActivity", 2, "tryOpenQzoneTab type : " + i3);
        }
        return true;
    }

    private boolean verifyOpenAioIntent(Intent intent) {
        if (intent == null) {
            return true;
        }
        try {
            if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("filter_invalid_open_aio_intent_9135", true)) {
                QLog.i("SplashActivity", 1, "[verifyOpenAioIntent] switch is off");
                return true;
            }
            if (intent.getBooleanExtra("fromThirdPush", false) && intent.hasExtra(AppOpenConstants.Key.THIRD_PUSH_START_ACTIVITY_TIME)) {
                long longExtra = intent.getLongExtra(AppOpenConstants.Key.THIRD_PUSH_START_ACTIVITY_TIME, 0L);
                long currentTimeMillis = System.currentTimeMillis() - longExtra;
                if (currentTimeMillis > JsonGrayBusiId.UI_RESERVE_100000_110000) {
                    QLog.w("SplashActivity", 1, "[verifyOpenAioIntent] invalid, delta:" + currentTimeMillis + " startActivityTime:" + longExtra + " bundle:" + intent.getExtras());
                    intent.removeExtra("fromThirdPush");
                    intent.removeExtra("open_chatfragment");
                    intent.removeExtra(AppOpenConstants.Key.THIRD_PUSH_MSG_SEQ);
                    intent.removeExtra(AppOpenConstants.Key.THIRD_PUSH_START_ACTIVITY_TIME);
                    return false;
                }
                QLog.i("SplashActivity", 1, "[verifyOpenAioIntent] pass, delta:" + currentTimeMillis + " startActivityTime:" + longExtra + " bundle:" + intent.getExtras());
            }
            return true;
        } catch (Exception e16) {
            QLog.w("SplashActivity", 1, "[verifyOpenAioIntent] exception:", e16);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, (Object) context);
        } else {
            super.attachBaseContext(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, mqq.app.AppActivity
    public void beforeDoOnCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.mobileqq.utils.ei.a(null, "Main_Before_OnCreate");
        super.beforeDoOnCreate();
        com.tencent.mobileqq.utils.ei.a("Main_Before_OnCreate", null);
    }

    protected void clearAIO() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SplashActivity", 4, "clearAIO");
        }
        com.tencent.mobileqq.activity.aio.c.b().g();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(MainFragment.class.getName());
        Fragment findFragmentByTag2 = supportFragmentManager.findFragmentByTag(this.splashAIOFragmentTag);
        if (findFragmentByTag2 != null) {
            if (QLog.isColorLevel()) {
                QLog.i("ChatActivity", 2, "clearAIO");
            }
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            if (findFragmentByTag2.isVisible()) {
                currentFragment = 1;
                beginTransaction.hide(findFragmentByTag2);
                if (findFragmentByTag == null) {
                    beginTransaction.add(R.id.vea, MainFragment.Sj(true), MainFragment.class.getName());
                } else {
                    beginTransaction.show(findFragmentByTag);
                }
            }
            beginTransaction.remove(findFragmentByTag2).commitAllowingStateLoss();
            if (com.tencent.qqnt.selectable.a.C().isSelected()) {
                com.tencent.qqnt.selectable.a.C().z();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        QLog.d("SplashActivity", 1, "doOnActivityResult requestCode:" + i3 + ", resultCode:" + i16 + ", currentFragment=" + currentFragment);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(this.splashAIOFragmentTag);
        if (findFragmentByTag != null && findFragmentByTag.isVisible()) {
            QLog.d("SplashActivity", 1, "doOnActivityResult in aio");
            ((SplashAIOFragment) findFragmentByTag).onActivityResult(i3, i16, intent);
        } else {
            QLog.d("SplashActivity", 1, "doOnActivityResult in main");
            Fragment findFragmentByTag2 = supportFragmentManager.findFragmentByTag(MainFragment.class.getName());
            if (findFragmentByTag2 != null) {
                ((MainFragment) findFragmentByTag2).doOnActivityResult(i3, i16, intent);
            }
        }
        Fragment findFragmentById = supportFragmentManager.findFragmentById(R.id.ve8);
        if (shouldDispatchActivityResult(findFragmentById)) {
            findFragmentById.onActivityResult(i3, i16, intent);
        }
        e eVar = MCALLBACKMAP.get("" + i3);
        if (eVar != null) {
            try {
                eVar.a(i3, i16, intent);
            } catch (Exception e16) {
                QLog.e("SplashActivity", 1, e16, new Object[0]);
            }
            MCALLBACKMAP.remove("" + i3);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SplashActivity", 2, "doOnBackPressed");
        }
        com.tencent.mobileqq.pad.k kVar = this.qFragmentStackManager;
        if (kVar != null && kVar.p()) {
            return;
        }
        finish();
        super.doOnBackPressed();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) configuration);
            return;
        }
        super.doOnConfigurationChanged(configuration);
        com.tencent.mobileqq.pad.c.c(this);
        com.tencent.mobileqq.pad.e.d(configuration, this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02b7 A[Catch: Exception -> 0x036a, TryCatch #0 {Exception -> 0x036a, blocks: (B:10:0x0049, B:12:0x0051, B:17:0x005d, B:21:0x0077, B:24:0x007a, B:26:0x0094, B:28:0x009a, B:31:0x00a2, B:33:0x00a8, B:35:0x00ac, B:37:0x00b6, B:39:0x00bf, B:41:0x00c6, B:43:0x00d6, B:44:0x0106, B:46:0x0111, B:48:0x0117, B:49:0x0125, B:51:0x012c, B:52:0x0146, B:54:0x0163, B:56:0x0170, B:63:0x017b, B:65:0x0181, B:66:0x0187, B:67:0x01a3, B:69:0x01a9, B:71:0x01b6, B:72:0x01e4, B:74:0x01ea, B:77:0x01fa, B:84:0x0215, B:87:0x024d, B:90:0x0262, B:92:0x0272, B:95:0x027a, B:97:0x0280, B:98:0x0289, B:100:0x0293, B:102:0x029d, B:104:0x02a7, B:109:0x02b7, B:110:0x02d5, B:112:0x0309, B:114:0x030f, B:115:0x031f, B:117:0x0327, B:119:0x032f, B:121:0x0335, B:123:0x033b, B:125:0x034a, B:128:0x0348, B:130:0x0136, B:132:0x035d), top: B:9:0x0049 }] */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean doOnCreate(Bundle bundle) {
        boolean z16;
        View view;
        boolean z17;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) bundle)).booleanValue();
        }
        QLog.d("SplashActivity", 1, "[" + System.identityHashCode(this) + "] doOnCreate");
        com.tencent.mobileqq.perf.startup.f.g("SplashActivity.doOnCreate");
        try {
            initSplashState();
            String str = BaseApplicationImpl.sSplashActivityEscapedMsg;
            if (str != null && str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Intent intent = new Intent(getIntent());
                intent.addFlags(603979776);
                super.finish();
                super.superStartActivityForResult(intent, -1, null);
                try {
                    LockMethodProxy.sleep(50L);
                } catch (Exception unused) {
                }
                System.exit(-1);
            }
            com.tencent.mobileqq.pad.c.c(this);
            com.tencent.mobileqq.utils.ei.a(null, "Main_Start");
            com.tencent.mobileqq.utils.ei.a(null, "Main_OnCreate");
            com.tencent.mobileqq.utils.ei.a(null, "Main_super_create");
            this.mActNeedImmersive = false;
            super.doOnCreate(bundle);
            com.tencent.mobileqq.utils.ei.a("Main_super_create", null);
        } catch (Exception e16) {
            QLog.e("SplashActivity", 1, "com.tencent.mobileqq.activity.SplashActivity.doOnCreate has exception", e16);
            CrashDefendManager.i().p(e16);
        }
        if (!intercept() && !needFinish() && !checkDuplication()) {
            if (dealFromSplashAD()) {
                com.tencent.mobileqq.perf.startup.f.h("SplashActivity.doOnCreate");
                return false;
            }
            String action = getIntent().getAction();
            if (action != null && "QQ_ACTION_MENU_QUIT".equals(action)) {
                finish();
                com.tencent.mobileqq.perf.startup.f.h("SplashActivity.doOnCreate");
                return false;
            }
            sWeakInstance = new WeakReference<>(this);
            this.qFragmentStackManager = new com.tencent.mobileqq.pad.k(this);
            if (bundle != null) {
                QLog.i("SplashActivity", 1, "[" + System.identityHashCode(this) + "] doOnCreate killedRestore");
                getIntent().putExtra("open_chatfragment", false);
                getIntent().putExtra("open_kandian_tab_fragment", false);
            }
            this.app.isClearTaskBySystem = false;
            setSwitch();
            Future<View> future = this.futureSplashMain;
            if (future != null && future.isDone()) {
                view = this.futureSplashMain.get(0L, TimeUnit.SECONDS);
            } else {
                view = null;
            }
            this.futureSplashMain = null;
            if (view != null) {
                ((ViewGroup) findViewById(android.R.id.content)).addView(view);
            } else {
                LayoutInflater.from(this).inflate(R.layout.fgq, (ViewGroup) findViewById(android.R.id.content), true);
            }
            handleLoginSplashAnim(getIntent());
            com.tencent.mobileqq.pad.e.d(getResources().getConfiguration(), this, false);
            Intent intent2 = getIntent();
            if (intent2.getExtras() != null) {
                if (intent2.getExtras().containsKey("forward") || (intent2.getBooleanExtra("k_from_login", false) && bundle == null)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SplashActivity", 2, "mCanLock set false, intent from forward or login");
                    }
                    this.mCanLock = false;
                }
                try {
                    this.mJumpShecme = getIntent().getStringExtra("jump_action_from_h5");
                    this.mPkg = getIntent().getStringExtra("package_from_h5");
                } catch (Exception unused2) {
                }
            }
            if (intent2.getExtras() != null && intent2.getExtras().containsKey("forward_type")) {
                StringBuilder sb5 = new StringBuilder("!!action:");
                sb5.append(intent2.getAction());
                sb5.append(" data:");
                sb5.append(intent2.getDataString());
                sb5.append(" extras:");
                for (String str2 : intent2.getExtras().keySet()) {
                    if (!str2.equalsIgnoreCase("uin")) {
                        sb5.append(str2);
                        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                        sb5.append(intent2.getExtras().get(str2));
                        sb5.append(" ");
                    }
                }
                QLog.i("SplashActivity", 1, sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append("!!hash=");
                sb6.append(intent2.hashCode());
                sb6.append(" flag=");
                sb6.append(intent2.getFlags());
                sb6.append(" isNewLaunch=");
                if ((intent2.getFlags() & 1048576) == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                sb6.append(z18);
                sb6.append("\uff5c");
                if ((intent2.getFlags() & 268435456) == 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                sb6.append(z19);
                QLog.i("SplashActivity", 1, sb6.toString());
                if (ForwardUtils.T(intent2)) {
                    setIntent(new Intent());
                }
            }
            if (JumpActivity.shouldFinishJumpActivity(intent2)) {
                QLog.i("SplashActivity", 1, "send broadcast to finish JumpActivity");
                JumpActivity.sendFinishBroadcast(this);
            }
            if (!tryOpenAio(getIntent()) && !tryOpenNowTab(getIntent()) && !tryOpenQzoneTab(getIntent()) && !tryOpenFlashShowTab(getIntent())) {
                z17 = false;
                if (!z17) {
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    currentFragment = 1;
                    supportFragmentManager.beginTransaction().add(R.id.vea, MainFragment.Sj(true), MainFragment.class.getName()).commitAllowingStateLoss();
                }
                QLog.d("SplashActivity", 1, "intentProcessed: " + z17 + " currentFragment: " + currentFragment);
                ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.SplashActivity.2
                    static IPatchRedirector $redirector_;

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.activity.SplashActivity$2$a */
                    /* loaded from: classes9.dex */
                    class a extends BroadcastReceiver {
                        static IPatchRedirector $redirector_;

                        a() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                            }
                        }

                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context, Intent intent) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("SplashActivity", 2, "onReceive:before_account_change");
                            }
                            SplashActivity.this.clearAIO();
                        }
                    }

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SplashActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        try {
                            QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
                            qQNotificationManager.cancel("SplashActivity", 241);
                            QZoneManagerImp qZoneManagerImp = (QZoneManagerImp) SplashActivity.this.app.getManager(QQManagerFactory.QZONE_MANAGER);
                            if (qZoneManagerImp != null) {
                                qZoneManagerImp.x(1, 0);
                            }
                            qQNotificationManager.cancel("SplashActivity", 265);
                            qQNotificationManager.cancel("SplashActivity", 267);
                            qQNotificationManager.cancel("SplashActivity", 274);
                            qQNotificationManager.cancel("SplashActivity", 236);
                            qQNotificationManager.cancel("SplashActivity", 271);
                            qQNotificationManager.cancel("SplashActivity", 273);
                            qQNotificationManager.cancel("SplashActivity", 269);
                            qQNotificationManager.cancel("SplashActivity", 239);
                            qQNotificationManager.cancel("SplashActivity", 527);
                            com.tencent.util.notification.d.h(SplashActivity.this.app).b();
                            if (!SplashActivity.this.isDestroyed() && !SplashActivity.this.isFinishing()) {
                                QLog.d("SplashActivity", 1, "registerReceiver before_account_change");
                                SplashActivity.this.f177134br = new a();
                                SplashActivity splashActivity = SplashActivity.this;
                                splashActivity.registerReceiver(splashActivity.f177134br, new IntentFilter("before_account_change"));
                            }
                        } catch (Exception unused3) {
                        }
                    }
                }, 3000L);
                BaseApplicationImpl.appMainActivityHasLanuch = true;
                if (!ImmersiveUtils.statusHeightCorrect && !isInMultiWindow()) {
                    getWindow().getDecorView().post(new Runnable() { // from class: com.tencent.mobileqq.activity.SplashActivity.3
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SplashActivity.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (com.tencent.mobileqq.util.af.d()) {
                                ImmersiveUtils.getStatusBarHeight(SplashActivity.this);
                            }
                            if (ImmersiveUtils.correctStatusBarHeight(SplashActivity.this.getWindow())) {
                                QLog.e("SplashActivity", 1, "recreate activity?");
                                SplashActivity.this.recreate();
                            }
                        }
                    });
                }
                ArrayList<String> activityRoutes = QBaseActivity.getActivityRoutes();
                if (currentFragment == 1 || getCurrentTab() != com.tencent.mobileqq.activity.home.impl.a.f183038a || activityRoutes.size() > 2 || (activityRoutes.size() == 2 && !"LoginActivity".equals(activityRoutes.get(0)))) {
                    sIsNormalRouteEnter = false;
                }
                ThirdPushNotifyManager.d().b(this.app, this);
                com.tencent.mobileqq.alpha.a.a();
                initSuperTheme();
                com.tencent.mobileqq.utils.ei.a("Main_OnCreate", null);
                com.tencent.qqnt.aio.b.f349763a.a(getSupportFragmentManager());
                com.tencent.mobileqq.perf.startup.f.h("SplashActivity.doOnCreate");
                return true;
            }
            z17 = true;
            if (!z17) {
            }
            QLog.d("SplashActivity", 1, "intentProcessed: " + z17 + " currentFragment: " + currentFragment);
            ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.SplashActivity.2
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.activity.SplashActivity$2$a */
                /* loaded from: classes9.dex */
                class a extends BroadcastReceiver {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                        }
                    }

                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("SplashActivity", 2, "onReceive:before_account_change");
                        }
                        SplashActivity.this.clearAIO();
                    }
                }

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SplashActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
                        qQNotificationManager.cancel("SplashActivity", 241);
                        QZoneManagerImp qZoneManagerImp = (QZoneManagerImp) SplashActivity.this.app.getManager(QQManagerFactory.QZONE_MANAGER);
                        if (qZoneManagerImp != null) {
                            qZoneManagerImp.x(1, 0);
                        }
                        qQNotificationManager.cancel("SplashActivity", 265);
                        qQNotificationManager.cancel("SplashActivity", 267);
                        qQNotificationManager.cancel("SplashActivity", 274);
                        qQNotificationManager.cancel("SplashActivity", 236);
                        qQNotificationManager.cancel("SplashActivity", 271);
                        qQNotificationManager.cancel("SplashActivity", 273);
                        qQNotificationManager.cancel("SplashActivity", 269);
                        qQNotificationManager.cancel("SplashActivity", 239);
                        qQNotificationManager.cancel("SplashActivity", 527);
                        com.tencent.util.notification.d.h(SplashActivity.this.app).b();
                        if (!SplashActivity.this.isDestroyed() && !SplashActivity.this.isFinishing()) {
                            QLog.d("SplashActivity", 1, "registerReceiver before_account_change");
                            SplashActivity.this.f177134br = new a();
                            SplashActivity splashActivity = SplashActivity.this;
                            splashActivity.registerReceiver(splashActivity.f177134br, new IntentFilter("before_account_change"));
                        }
                    } catch (Exception unused3) {
                    }
                }
            }, 3000L);
            BaseApplicationImpl.appMainActivityHasLanuch = true;
            if (!ImmersiveUtils.statusHeightCorrect) {
                getWindow().getDecorView().post(new Runnable() { // from class: com.tencent.mobileqq.activity.SplashActivity.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SplashActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (com.tencent.mobileqq.util.af.d()) {
                            ImmersiveUtils.getStatusBarHeight(SplashActivity.this);
                        }
                        if (ImmersiveUtils.correctStatusBarHeight(SplashActivity.this.getWindow())) {
                            QLog.e("SplashActivity", 1, "recreate activity?");
                            SplashActivity.this.recreate();
                        }
                    }
                });
            }
            ArrayList<String> activityRoutes2 = QBaseActivity.getActivityRoutes();
            if (currentFragment == 1) {
            }
            sIsNormalRouteEnter = false;
            ThirdPushNotifyManager.d().b(this.app, this);
            com.tencent.mobileqq.alpha.a.a();
            initSuperTheme();
            com.tencent.mobileqq.utils.ei.a("Main_OnCreate", null);
            com.tencent.qqnt.aio.b.f349763a.a(getSupportFragmentManager());
            com.tencent.mobileqq.perf.startup.f.h("SplashActivity.doOnCreate");
            return true;
        }
        finish();
        com.tencent.mobileqq.utils.ei.a("Main_OnCreate", null);
        com.tencent.mobileqq.utils.ei.a("Main_Start", null);
        com.tencent.mobileqq.perf.startup.f.h("SplashActivity.doOnCreate");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        super.doOnDestroy();
        QLog.d("SplashActivity", 1, "[" + System.identityHashCode(this) + "] doOnDestroy");
        if (QLog.isColorLevel()) {
            QLog.d("SplashActivity", 2, "doOnDestroy");
        }
        BroadcastReceiver broadcastReceiver = this.f177134br;
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (Throwable th5) {
                QLog.d("SplashActivity", 1, "", th5);
            }
            this.f177134br = null;
        }
        if (QQPlayerService.s0()) {
            if (QLog.isColorLevel()) {
                QLog.d("SplashActivity", 2, "QQPlayerService stopPlayMusic");
            }
            QQPlayerService.m1(getApplicationContext());
        }
        onSystemScreenSettingChanged();
        if (sWeakInstance != null && sWeakInstance.get() == this) {
            ThemeVideoController.getInstance().release();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        FragmentManager supportFragmentManager;
        Fragment findFragmentByTag;
        MainFragment mainFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4) {
            if (QLog.isColorLevel()) {
                QLog.d("SplashActivity", 2, "doOnKeyDown");
            }
            FragmentManager supportFragmentManager2 = getSupportFragmentManager();
            com.tencent.mobileqq.pad.k kVar = this.qFragmentStackManager;
            if (kVar != null && kVar.p()) {
                return true;
            }
            Fragment findFragmentByTag2 = supportFragmentManager2.findFragmentByTag(this.splashAIOFragmentTag);
            if (findFragmentByTag2 != null && findFragmentByTag2.isVisible()) {
                ((SplashAIOFragment) findFragmentByTag2).onBackEvent();
                return true;
            }
            MainFragment mainFragment2 = (MainFragment) supportFragmentManager2.findFragmentByTag(MainFragment.class.getName());
            if (mainFragment2 != null) {
                return mainFragment2.doOnKeyDown(i3, keyEvent);
            }
        }
        if (i3 == 82 && (((findFragmentByTag = (supportFragmentManager = getSupportFragmentManager()).findFragmentByTag(this.splashAIOFragmentTag)) == null || !findFragmentByTag.isVisible()) && (mainFragment = (MainFragment) supportFragmentManager.findFragmentByTag(MainFragment.class.getName())) != null)) {
            return mainFragment.doOnKeyDown(i3, keyEvent);
        }
        if ((i3 == 24 || i3 == 25) && com.tencent.mobileqq.hotpic.t.c(this).d()) {
            Intent intent = new Intent();
            intent.setAction("VolumeBtnDown");
            sendBroadcast(intent);
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        MainFragment mainFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) intent);
            return;
        }
        try {
            super.doOnNewIntent(intent);
            QLog.d("SplashActivity", 1, "doOnNewIntent code=" + hashCode());
            if (needFinish()) {
                finish();
                return;
            }
            String action = intent.getAction();
            if (action != null && "QQ_ACTION_MENU_QUIT".equals(action)) {
                finish();
                return;
            }
            Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey("forward_type") && ForwardUtils.T(intent)) {
                setIntent(new Intent());
            }
            if (intent.getIntExtra("fromCmGame", 0) == 1) {
                overridePendingTransition(0, 0);
            }
            if (this.qFragmentStackManager.s(intent) != null) {
                return;
            }
            int intExtra = getIntent().getIntExtra("uintype", -1);
            if (intExtra == 10005) {
                getIntent().removeExtra("uintype");
                QLog.e("SplashActivity", 1, "wtf 10005 aio" + intent);
            }
            if (intExtra != 10005 && extras != null) {
                if (tryOpenAio(intent)) {
                    return;
                }
                if (Boolean.valueOf(extras.getBoolean("EXIT", false)).booleanValue()) {
                    finish();
                }
                if (extras.getBoolean("activepull_push_flag")) {
                    setIntent(intent);
                    handleNativeIntentByPullActivePush(intent);
                    return;
                }
                if (extras.getBoolean(CLEAR_FUNCTION_FRAGMENT) && AppSetting.t(this) && this.qFragmentStackManager.i()) {
                    getIntent().removeExtra(CLEAR_FUNCTION_FRAGMENT);
                    this.qFragmentStackManager.d();
                    QLog.d("SplashActivity", 1, "[doOnNewIntent] clearFunctionFragment");
                }
                if (extras.getInt(FRAGMENT_ID) == 1 && currentFragment != 1) {
                    setIntent(intent);
                    openMainFragment(intent);
                    return;
                }
            }
            if (currentFragment == 1 && (mainFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName())) != null) {
                setIntent(intent);
                mainFragment.doOnNewIntent(intent);
            }
            if (extras != null && extras.getBoolean("k_from_login", false) && AppSetting.t(this) && this.qFragmentStackManager.i() && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("splash_open_after_login_clear_function", true)) {
                this.qFragmentStackManager.d();
            }
            handleLoginSplashAnim(intent);
        } catch (Exception e16) {
            QLog.e("SplashActivity", 2, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        QLog.d("SplashActivity", 1, "doOnPause code=" + hashCode());
        if (isInMultiWindow()) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(this.splashAIOFragmentTag);
            if (findFragmentByTag != null && findFragmentByTag.isVisible()) {
                ((SplashAIOFragment) findFragmentByTag).Qh();
                return;
            }
            Fragment findFragmentByTag2 = supportFragmentManager.findFragmentByTag(MainFragment.class.getName());
            if (findFragmentByTag2 != null) {
                ((MainFragment) findFragmentByTag2).ck();
                super.doOnPause();
                return;
            }
            return;
        }
        super.doOnPause();
        AbstractVideoImage.pauseAll();
        ApngImage.pauseAll();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnPostResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        com.tencent.mobileqq.utils.ei.a(null, "Main_OnPostResume");
        super.doOnPostResume();
        com.tencent.mobileqq.utils.ei.a("Main_OnPostResume", null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnRestoreInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) bundle);
            return;
        }
        com.tencent.mobileqq.utils.ei.a(null, "Main_OnRestoreInstanceState");
        super.doOnRestoreInstanceState(bundle);
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (findFragmentByTag instanceof MainFragment) {
            ((MainFragment) findFragmentByTag).doOnRestoreInstanceState(bundle);
        }
        com.tencent.mobileqq.utils.ei.a("Main_OnRestoreInstanceState", null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        com.tencent.mobileqq.perf.startup.f.g("SplashActivity.doOnResume");
        try {
            com.tencent.mobileqq.utils.ei.a(null, "Main_OnResume");
            super.doOnResume();
            AbstractVideoImage.resumeAll();
            QLog.d("SplashActivity", 1, "doOnResume code=" + hashCode());
            checkGesture();
            Window window = getWindow();
            if ((window.getAttributes().flags & 1024) != 0) {
                window.clearFlags(1024);
            }
        } catch (Exception e16) {
            QLog.e("SplashActivity", 2, e16, new Object[0]);
        }
        if (this.app.getKickIntent() != null) {
            QLog.d("SplashActivity", 1, "doOnResume finish, kickIntent exists");
            startActivity(this.app.getKickIntent());
            com.tencent.mobileqq.utils.ei.a("Main_OnResume", null);
            com.tencent.mobileqq.perf.startup.f.h("SplashActivity.doOnResume");
            return;
        }
        handleIntentFromQc(getIntent());
        if (this.app.isLogin() && this.app.getAccount().equals(BaseApplicationImpl.getApplication().getPCActiveUin())) {
            if (QLog.isColorLevel()) {
                QLog.d("SplashActivity", 2, "onResume start push");
            }
            if (!isResume()) {
                com.tencent.mobileqq.perf.startup.f.h("SplashActivity.doOnResume");
                return;
            }
            Intent pCActiveNoticeIntent = BaseApplicationImpl.getApplication().getPCActiveNoticeIntent();
            if (pCActiveNoticeIntent == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("SplashActivity", 2, "Intent is null");
                }
            } else {
                try {
                    if (NotifyPCActiveActivity.f176576d0 == null && (BaseActivity.sTopActivity instanceof SplashActivity)) {
                        startActivity(pCActiveNoticeIntent);
                    }
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.i("SplashActivity", 2, "", th5);
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(this.app.getAccount()) && !"0".equals(this.app.getAccount())) {
            ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.SplashActivity.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SplashActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    boolean readValue = SettingCloneUtil.readValue((Context) SplashActivity.this.app.getApp(), SplashActivity.this.app.getAccount(), (String) null, AppConstants.PCACTIVE_NOTICE_KEY, false);
                    if (!SettingCloneUtil.readValue((Context) SplashActivity.this.app.getApp(), SplashActivity.this.app.getAccount(), (String) null, AppConstants.PCACTIVE_HAS_NOTICE_KEY, false) && readValue) {
                        SettingCloneUtil.writeValue((Context) SplashActivity.this.app.getApp(), SplashActivity.this.app.getAccount(), (String) null, AppConstants.PCACTIVE_HAS_NOTICE_KEY, true);
                        Intent intent = new Intent(NewIntent.ACTION_NOTICE_ON_PCACTIVE);
                        intent.addFlags(268435456);
                        intent.putExtra("uin", SplashActivity.this.app.getAccount());
                        BaseApplicationImpl.getApplication().startActivity(intent);
                    }
                }
            }, 800L);
        }
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.SplashActivity.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SplashActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    OpenSdkIMBlockFragment.th(SplashActivity.this, up3.b.i(), false);
                }
            }
        }, 800L);
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.SplashActivity.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SplashActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                long F2 = SpaceLowNoticeActiviy.F2(SplashActivity.this.app, "conf_space_low_shreshold", GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT);
                if (SpaceLowNoticeActiviy.G2(SpaceLowNoticeActiviy.F2(SplashActivity.this.app, "conf_space_check_interval", 259200000L))) {
                    if (SdCardUtil.getAvailableExternalMemorySize(SplashActivity.this) + SdCardUtil.getAvailableInternalMemorySize() < F2) {
                        QLog.i("SplashActivity", 1, "qqclean conf did notice");
                        SpaceLowNoticeActiviy.H2(SplashActivity.this);
                        QQAppInterface qQAppInterface = SplashActivity.this.app;
                        ReportController.o(qQAppInterface, "dc00898", "", "", "0X8007545", "0X8007545", 0, 0, qQAppInterface.getCurrentAccountUin(), "", "", "");
                        return;
                    }
                    QLog.i("SplashActivity", 1, "qqclean conf not need notice");
                }
            }
        }, 800L);
        if (isInMultiWindow()) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(this.splashAIOFragmentTag);
            if (findFragmentByTag != null && findFragmentByTag.isVisible()) {
                ((SplashAIOFragment) findFragmentByTag).Ph();
            } else {
                Fragment findFragmentByTag2 = supportFragmentManager.findFragmentByTag(MainFragment.class.getName());
                if (findFragmentByTag2 != null) {
                    ((MainFragment) findFragmentByTag2).ck();
                }
            }
        }
        PerfReportUtil.i();
        com.tencent.mobileqq.utils.ei.a("Main_OnResume", null);
        com.tencent.mobileqq.perf.startup.f.h("SplashActivity.doOnResume");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnSaveInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) bundle);
            return;
        }
        super.doOnRestoreInstanceState(bundle);
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (findFragmentByTag instanceof MainFragment) {
            ((MainFragment) findFragmentByTag).doOnSaveInstanceState(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        com.tencent.mobileqq.perf.startup.f.g("SplashActivity.doOnStart");
        com.tencent.mobileqq.utils.ei.a(null, "Main_OnStart");
        super.doOnStart();
        if (QLog.isColorLevel()) {
            QLog.d("SplashActivity", 2, "doOnStart");
        }
        String str = this.mJumpShecme;
        if (str != null && str.length() > 0 && "pakage_from_h5".equalsIgnoreCase(this.mPkg)) {
            com.tencent.mobileqq.utils.ax c16 = com.tencent.mobileqq.utils.bi.c(this.app, this, this.mJumpShecme);
            c16.B(this.mPkg);
            c16.b();
            this.mJumpShecme = null;
            this.mPkg = null;
        }
        com.tencent.mobileqq.utils.ei.a("Main_OnStart", null);
        com.tencent.mobileqq.perf.startup.f.h("SplashActivity.doOnStart");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        QLog.d("SplashActivity", 1, "doOnStop code=" + hashCode());
        if (isInMultiWindow()) {
            super.doOnPause();
            AbstractVideoImage.pauseAll();
            ApngImage.pauseAll();
            super.doOnStop();
            return;
        }
        super.doOnStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
            return;
        }
        com.tencent.mobileqq.utils.ei.a(null, "Main_OnWindowFocusChanged");
        super.doOnWindowFocusChanged(z16);
        com.tencent.mobileqq.utils.ei.a("Main_OnWindowFocusChanged", null);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        QLog.d("SplashActivity", 1, "finish()");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(this.splashAIOFragmentTag);
        if (findFragmentByTag != null) {
            if (QLog.isColorLevel()) {
                QLog.i("SplashActivity", 2, "finish clearAIO");
            }
            supportFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        }
        super.finish();
        if (sWeakInstance != null && sWeakInstance.get() == this) {
            sWeakInstance = null;
            ThemeVideoController.getInstance().release();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity
    public String getActivityName() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (String) iPatchRedirector.redirect((short) 53, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("SplashActivity");
        if (currentFragment == 1) {
            str = "_MainFragment";
        } else {
            str = "_SplashAIOFragment";
        }
        sb5.append(str);
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public String getCIOPageName() {
        String name;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return (String) iPatchRedirector.redirect((short) 56, (Object) this);
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (currentFragment == 1) {
            name = MainFragment.class.getName();
        } else {
            name = SplashAIOFragment.class.getName();
        }
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(name);
        if (findFragmentByTag != null) {
            return ((QBaseFragment) findFragmentByTag).getCIOPageName();
        }
        return super.getCIOPageName();
    }

    public String getChatFragmentTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (String) iPatchRedirector.redirect((short) 59, (Object) this);
        }
        return this.splashAIOFragmentTag;
    }

    @Override // android.app.Activity
    public ComponentName getComponentName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ComponentName) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        ComponentName componentName = super.getComponentName();
        if (componentName == null) {
            return new ComponentName(getApplicationContext(), (Class<?>) SplashActivity.class);
        }
        return componentName;
    }

    public int getCurrentTab() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Integer) iPatchRedirector.redirect((short) 52, (Object) this)).intValue();
        }
        try {
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
            if (findFragmentByTag != null) {
                return ((MainFragment) findFragmentByTag).getCurrentTab();
            }
            return 0;
        } catch (Exception e16) {
            QLog.e("SplashActivity", 1, "getCurrentTab error: " + e16);
            return 0;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.u
    public WebViewFragment getCurrentWebViewFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return (WebViewFragment) iPatchRedirector.redirect((short) 62, (Object) this);
        }
        return findCurrentWebViewFragment(super.getSupportFragmentManager().getFragments());
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity
    public String getPreProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (String) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return MobileQQ.PACKAGE_NAME + ":peak";
    }

    @Override // com.tencent.mobileqq.pad.l
    public com.tencent.mobileqq.pad.k getqFragmentStackManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (com.tencent.mobileqq.pad.k) iPatchRedirector.redirect((short) 60, (Object) this);
        }
        return this.qFragmentStackManager;
    }

    public void handleNativeIntentByPullActivePush(Intent intent) {
        Intent intent2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) intent);
            return;
        }
        int intExtra = intent.getIntExtra("extra_pull_active_push_type", 0);
        if (intExtra == 0) {
            return;
        }
        if (intExtra == 2) {
            String stringExtra = intent.getStringExtra("extra_pull_active_push_url");
            intent2 = new Intent(this.app.getApp(), (Class<?>) QQBrowserActivity.class);
            intent2.putExtra("url", stringExtra);
        } else {
            if (intExtra == 1) {
                int intExtra2 = intent.getIntExtra("extra_pull_active_push_subtype", 0);
                if (intExtra2 != 1) {
                    if (intExtra2 != 2) {
                        if (intExtra2 == 3) {
                            intent2 = new Intent(this.app.getApp(), (Class<?>) ActivateFriendActivity.class);
                            intent2.putExtra("af_key_from", 4);
                        }
                    } else {
                        new JumpActionLegacy(this.app, this).p();
                    }
                } else {
                    new JumpActionLegacy(this.app, this).o();
                }
            }
            intent2 = null;
        }
        if (intent2 != null) {
            startActivity(intent2);
        }
        QQAppInterface qQAppInterface = this.app;
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X8006593", "0X8006593", 0, 0, qQAppInterface.getCurrentAccountUin(), "", "", "");
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isCloneInflaterInSubThreadEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isCloneInflaterInSubThreadForSplashActivity;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isDelegateLayoutInflaterEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isEnableDelegateLayoutInflaterForSplashActivity;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isDelegateResourceEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isEnableDelegateResourceForSplashActivity;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isNeedInterruptDoMultiWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, (Object) this)).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return false;
    }

    public boolean needFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null && qQAppInterface.isExitTaskUnfinished) {
            QLog.d("SplashActivity", 1, "LastExitTaskUnfinished finish");
            return true;
        }
        if (((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).finishNotifyActivityByKicked(this)) {
            return false;
        }
        QQAppInterface qQAppInterface2 = this.app;
        if (qQAppInterface2 != null && (qQAppInterface2.isLogin() || this.app.getKickIntent() != null)) {
            return false;
        }
        ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).jumpToLoginForSplash(this);
        return true;
    }

    @Override // mqq.app.AppActivity
    protected boolean needRestoreFragmentAfterRecreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
        } else {
            super.onAccountChanged();
            onAccountChangedImpl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void onAccoutChangeFailed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
            return;
        }
        super.onAccoutChangeFailed();
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (findFragmentByTag != null) {
            ((MainFragment) findFragmentByTag).b6();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        DrawerFrame drawerFrame;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) configuration);
        } else {
            WeakReference<DrawerFrame> weakReference = FrameHelperActivity.f194645g0;
            if (weakReference != null && (drawerFrame = weakReference.get()) != null) {
                drawerFrame.onConfigurationChanged(configuration);
            }
            super.onConfigurationChanged(configuration);
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        QLog.d("SplashActivity", 1, "[" + System.identityHashCode(this) + "] onCreate");
        com.tencent.mobileqq.util.cv.e();
        com.tencent.mobileqq.perf.startup.f.g("SplashActivity.onCreate");
        loadChatsListDependencies();
        removeRegisteredInfo(bundle);
        super.onCreate(bundle);
        com.tencent.mobileqq.perf.startup.f.h("SplashActivity.onCreate");
        com.tencent.mobileqq.qui.b.f276860a.l(getWindow());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        super.onDestroy();
        if (sWeakInstance != null && sWeakInstance.get() == this) {
            sWeakInstance = null;
            ThemeVideoController.getInstance().release();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void onLogout(Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) logoutReason);
            return;
        }
        clearAIO();
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (findFragmentByTag != null) {
            ((MainFragment) findFragmentByTag).onLogout(logoutReason);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, z16);
            return;
        }
        super.onMultiWindowModeChanged(z16);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        ActivityResultCaller chatFragment = getChatFragment();
        if (chatFragment != null) {
            ((SplashAIOFragment) chatFragment).onMultiWindowModeChanged(z16);
        }
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(MainFragment.class.getName());
        if (findFragmentByTag != null) {
            ((MainFragment) findFragmentByTag).onMultiWindowModeChanged(z16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this);
            return;
        }
        initSuperTheme();
        super.onPostThemeChanged();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(MainFragment.class.getName());
        QLog.i("SplashActivity", 1, "[" + System.identityHashCode(this) + "] onPostThemeChanged, fragment[" + System.identityHashCode(this) + "]");
        if (findFragmentByTag != null) {
            ((MainFragment) findFragmentByTag).onPostThemeChanged();
        }
        for (Fragment fragment : supportFragmentManager.getFragments()) {
            if ((fragment instanceof SplashAIOFragment) && fragment.isAdded()) {
                try {
                    ((SplashAIOFragment) fragment).onPostThemeChanged();
                } catch (Exception e16) {
                    QLog.e("SplashActivity", 1, "onPostThemeChanged exception:" + e16);
                }
            }
        }
        Fragment findFragmentById = supportFragmentManager.findFragmentById(R.id.ve8);
        if ((findFragmentById instanceof IFragmentCallbacks) && shouldDispatchPostThemeChanged(findFragmentById)) {
            ((IFragmentCallbacks) findFragmentById).onPostThemeChanged();
        }
        if (!"1000".equals(ThemeUtil.getCurrentThemeId())) {
            if (getAppInterface() != null) {
                BannerManager.l().O(ThemeOverdueBannerProcessor.f185275d, 0, null);
            }
            if (QLog.isColorLevel()) {
                QLog.d("SplashActivity", 2, "onPostThemeChanged: hide theme overdue tips");
            }
        }
        com.tencent.mobileqq.ark.f.f();
        ArgusPreloadManager.INSTANCE.getLayoutPreLoader().clearAll(false);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (MobileQQ.sProcessId == 1) {
            com.tencent.mobileqq.perf.startup.f.e();
        }
        super.onRestart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, (Object) bundle);
            return;
        }
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.remove("android:support:fragments");
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100050", false)) {
                QLog.d("SplashActivity", 1, "isSwitchOn == true");
                return;
            }
            Bundle bundle3 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            if (bundle3 != null && (bundle2 = bundle3.getBundle("android:support:fragments")) != null) {
                QLog.d("SplashActivity", 1, "remove bundle: android:support:fragments");
                bundle2.remove("android:support:fragments");
            }
        }
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
            return;
        }
        super.onWindowFocusChanged(z16);
        if (MobileQQ.sProcessId == 1 && z16) {
            com.tencent.mobileqq.perf.startup.f.f();
        }
    }

    public void openAIO(boolean z16, int i3) {
        int i16;
        int i17;
        int i18;
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        getIntent().putExtra("key_need_show_unread_count", true);
        MethodTrace.METHOD_TRACE_TOGGLE = AIOOptConfigKt.n();
        com.tencent.mobileqq.activity.aio.c.b().g();
        ThreadRegulator.d().f(1);
        sOpenAIOCode = HardCoderManager.getInstance().start(0, 1, 1, 0, new int[]{0}, 2000, 301, 4L, Process.myTid(), "openAIO", true);
        SceneTracker.f258213d.traceStart("SplashAIOFragment", true);
        com.tencent.mobileqq.utils.ej.b(null, "AIO_Start_cost");
        try {
            ((IAIOConvertApi) QRoute.api(IAIOConvertApi.class)).handleAIOIntent(getIntent());
            if (highFrequencyOpenSameAio()) {
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.mLastOpenAioTime < OPEN_AIO_MIN_INTERVAL_TIME) {
                return;
            }
            this.mLastOpenAioTime = uptimeMillis;
            if (QLog.isColorLevel()) {
                QLog.e("SplashActivity", 2, i3 + "|openAIO|" + getIntent().getIntExtra("uintype", -1));
            }
            boolean booleanExtra = getIntent().getBooleanExtra("open_chatfragment_withanim", false);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            supportFragmentManager.beginTransaction();
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(getChatFragmentTag());
            final Fragment findFragmentByTag2 = supportFragmentManager.findFragmentByTag(MainFragment.class.getName());
            if (findFragmentByTag2 != null) {
                MainFragment mainFragment = (MainFragment) findFragmentByTag2;
                mainFragment.dismissLocalSearchDialog();
                if (getIntent().getIntExtra("uintype", -1) != 10014) {
                    int currentTab = mainFragment.getCurrentTab();
                    int i19 = com.tencent.mobileqq.activity.home.impl.a.f183038a;
                    if (currentTab != i19) {
                        mainFragment.setCurrentTab(i19);
                    }
                }
            }
            QLog.i("SplashActivity", 1, "[openAIO]: findAIOFragment is " + findFragmentByTag + ", tag is " + this.splashAIOFragmentTag);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[open AIO]: Bundle is ");
            com.tencent.qqnt.aio.utils.b bVar = com.tencent.qqnt.aio.utils.b.f352292a;
            sb5.append(com.tencent.qqnt.aio.utils.b.a(getIntent().getExtras()));
            QLog.i("SplashActivity", 1, sb5.toString());
            int i26 = R.anim.f154449lf;
            int i27 = R.anim.f154445lb;
            if (findFragmentByTag != null) {
                if (QLog.isColorLevel()) {
                    QLog.i("SplashActivity", 2, "openAIO f != null ");
                }
                SplashAIOFragment splashAIOFragment = (SplashAIOFragment) findFragmentByTag;
                currentFragment = 2;
                if (splashAIOFragment.getRootView() == null) {
                    QLog.i("SplashActivity", 1, "splashAIOFragment state error, trying to recreate it, tag is " + this.splashAIOFragmentTag);
                    this.qFragmentStackManager.q(this.splashAIOFragmentTag);
                    QLog.i("SplashActivity", 1, "[openAIO]: aioFragment state err, new fragment hashCode is " + openNewAIO(findFragmentByTag2, 0, 0, null).hashCode() + ", tag is " + this.splashAIOFragmentTag);
                } else if (!findFragmentByTag.isVisible()) {
                    Bundle extras = getIntent().getExtras();
                    if (extras != null && (bundle = extras.getBundle(AppConstants.Key.GUILD_EXTRA)) != null) {
                        i16 = bundle.getInt("open_chat_fragment_anim_type", 0);
                    } else {
                        i16 = 0;
                    }
                    if (booleanExtra && com.tencent.qqperf.tools.f.f() > 1) {
                        if (i16 == 1) {
                            i26 = R.anim.f154442w;
                        } else if (i16 == 2) {
                            i26 = R.anim.f154636p8;
                        }
                    } else {
                        i26 = 0;
                        i27 = 0;
                    }
                    if (AppSetting.t(this) && this.qFragmentStackManager.i()) {
                        i18 = 0;
                        i17 = 0;
                    } else {
                        i17 = i26;
                        i18 = i27;
                    }
                    this.splashAIOFragmentTag = this.qFragmentStackManager.t(splashAIOFragment, i18, i17, null, new com.tencent.mobileqq.pad.n() { // from class: com.tencent.mobileqq.activity.fg
                        @Override // com.tencent.mobileqq.pad.n
                        public final void a(FragmentTransaction fragmentTransaction) {
                            SplashActivity.this.lambda$openAIO$0(findFragmentByTag2, fragmentTransaction);
                        }
                    });
                    QLog.i("SplashActivity", 1, "[openAIO]: aioFragment is inVisible, hashCode is " + splashAIOFragment.hashCode() + ", tag is " + this.splashAIOFragmentTag);
                } else {
                    this.splashAIOFragmentTag = this.qFragmentStackManager.t(splashAIOFragment, 0, 0, null, new com.tencent.mobileqq.pad.n() { // from class: com.tencent.mobileqq.activity.fh
                        @Override // com.tencent.mobileqq.pad.n
                        public final void a(FragmentTransaction fragmentTransaction) {
                            SplashActivity.this.lambda$openAIO$1(fragmentTransaction);
                        }
                    });
                    QLog.i("SplashActivity", 1, "[openAIO]: aioFragment is visible, hashCode is " + splashAIOFragment.hashCode() + ", tag is " + this.splashAIOFragmentTag);
                }
            } else {
                if (Math.abs(SystemClock.uptimeMillis() - this.firtCreateAIOTime) < 1000) {
                    if (QLog.isColorLevel()) {
                        QLog.i("SplashActivity", 2, "openAIO hasOpenedAIO true, renturn ");
                        return;
                    }
                    return;
                }
                this.firtCreateAIOTime = SystemClock.uptimeMillis();
                if (!booleanExtra || com.tencent.qqperf.tools.f.f() <= 1) {
                    i26 = 0;
                    i27 = 0;
                }
                SplashAIOFragment openNewAIO = openNewAIO(findFragmentByTag2, i27, i26, null);
                currentFragment = 2;
                com.tencent.mobileqq.activity.aio.c.b().g();
                QLog.i("SplashActivity", 1, "[openAIO]: new aiofragment, hashCode is " + openNewAIO.hashCode() + ", tag is " + this.splashAIOFragmentTag);
            }
            if (getIntent().getBooleanExtra("activepull_push_flag", false)) {
                QQAppInterface qQAppInterface = this.app;
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X8006593", "0X8006593", 0, 0, qQAppInterface.getCurrentAccountUin(), "", "", "");
            }
            getIntent().removeExtra("open_chatfragment");
            if (!getIntent().hasExtra("open_chat_time")) {
                getIntent().putExtra("open_chat_time", System.currentTimeMillis());
            }
            com.tencent.qqnt.aio.b.f349763a.a(supportFragmentManager);
        } catch (UnsupportedChatTypeException e16) {
            QLog.e("SplashActivity", 1, "UnsupportedChatTypeException", e16.getMessage(), e16);
            QQToast makeText = QQToast.makeText(BaseApplication.context, R.string.f1359202r, 1);
            makeText.show(makeText.getTitleBarHeight());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void openMainFragment(Intent intent) {
        Exception exc;
        boolean z16;
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SplashActivity", 2, "openMainFragment");
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment) supportFragmentManager.findFragmentByTag(MainFragment.class.getName());
        if (mainFragment == null) {
            if (QLog.isColorLevel()) {
                QLog.i("SplashActivity", 2, "openMainFragment mainfragment is null");
                return;
            }
            return;
        }
        if (currentFragment != 1) {
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            SplashAIOFragment splashAIOFragment = (SplashAIOFragment) supportFragmentManager.findFragmentByTag(this.splashAIOFragmentTag);
            boolean z17 = false;
            try {
                if (intent.getBooleanExtra(SWITCH_ANIM, false)) {
                    try {
                        beginTransaction.setCustomAnimations(R.anim.f154567be, R.anim.f154563bb);
                        z17 = true;
                    } catch (Exception e16) {
                        exc = e16;
                        z16 = true;
                        QLog.e("SplashActivity", 2, exc, new Object[0]);
                        z17 = z16;
                        currentFragment = 1;
                        beginTransaction.show(mainFragment);
                        if (splashAIOFragment != null) {
                        }
                        beginTransaction.commitAllowingStateLoss();
                        mainFragment.doOnNewIntent(intent);
                    }
                }
            } catch (Exception e17) {
                exc = e17;
                z16 = false;
            }
            currentFragment = 1;
            beginTransaction.show(mainFragment);
            if (splashAIOFragment != null) {
                try {
                    if (!supportFragmentManager.isStateSaved()) {
                        if (splashAIOFragment.getArguments() != null) {
                            bundle = splashAIOFragment.getArguments();
                        } else {
                            bundle = new Bundle();
                        }
                        bundle.putBoolean("exit_anim", z17);
                        splashAIOFragment.setArguments(bundle);
                    } else {
                        QLog.i("SplashActivity", 1, "[openMainFragment]: fm state is already saved");
                    }
                } catch (Exception e18) {
                    QLog.i("SplashActivity", 1, "openMainFragment: ", e18);
                }
                beginTransaction.hide(splashAIOFragment);
            }
            beginTransaction.commitAllowingStateLoss();
        }
        mainFragment.doOnNewIntent(intent);
    }

    public void preloadAIO() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
            return;
        }
        try {
            SplashAIOFragment splashAIOFragment = new SplashAIOFragment();
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("preload_aio_fragment_commit_now_8980", true);
            Bundle bundle = new Bundle();
            bundle.putBoolean("retain_fragment_record", true);
            if (isSwitchOn) {
                bundle.putBoolean("commit_now", true);
            }
            this.splashAIOFragmentTag = this.qFragmentStackManager.t(splashAIOFragment, 0, 0, bundle, null);
            this.mCurrentAIOFragmentWr = new WeakReference<>(splashAIOFragment);
            QLog.i("SplashActivity", 1, "[preloadAIO]: hashCode is " + splashAIOFragment.hashCode() + ", tag is " + this.splashAIOFragmentTag + " commitNowSwitch is " + isSwitchOn);
            com.tencent.qqnt.aio.b.f349763a.a(getSupportFragmentManager());
        } catch (Throwable th5) {
            if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_preload_exception_9080", true)) {
                QLog.i("SplashActivity", 1, "[preloadAIO]: ", th5);
                return;
            }
            throw th5;
        }
    }

    @Override // mqq.app.AppActivity
    public HashMap<String, Runnable> preloadUi(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (HashMap) iPatchRedirector.redirect((short) 40, (Object) this, z16);
        }
        HashMap<String, Runnable> hashMap = new HashMap<>();
        hashMap.put("ConversationPreload", new Runnable() { // from class: com.tencent.mobileqq.activity.ff
            @Override // java.lang.Runnable
            public final void run() {
                SplashActivity.this.lambda$preloadUi$2();
            }
        });
        hashMap.put("DarkPreload", new Runnable() { // from class: com.tencent.mobileqq.activity.SplashActivity.10
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SplashActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    DarkModeManager.f();
                }
            }
        });
        hashMap.put("repo", new Runnable() { // from class: com.tencent.mobileqq.activity.SplashActivity.11
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SplashActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    ((IAvatarGetterService) peekAppRuntime.getRuntimeService(IAvatarGetterService.class, "")).getDrawable(0, peekAppRuntime.getAccount(), false);
                }
            }
        });
        return hashMap;
    }

    @Override // android.app.Activity
    public void recreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QLog.d("SplashActivity", 1, "recreate \u6ce8\u610fSplashActivity\u72b6\u6001\u5f02\u5e38\uff0c\u9700\u8981\u91cd\u65b0\u521b\u5efa\uff01\uff01\uff01" + Log.getStackTraceString(new Throwable()));
        super.recreate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
        } else {
            super.requestWindowFeature(intent);
            super.getWindow().setFormat(-3);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.u
    public boolean setBottomBarVisibility(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return ((Boolean) iPatchRedirector.redirect((short) 63, (Object) this, z16)).booleanValue();
        }
        return false;
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, (Object) intent);
        } else {
            dispatchFrameSetIntent(intent);
            super.setIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public String setLastActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (String) iPatchRedirector.redirect((short) 51, (Object) this);
        }
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (findFragmentByTag != null) {
            return ((MainFragment) findFragmentByTag).setLastActivityName();
        }
        return super.setLastActivityName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean shouldDispatchActivityResult(Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, (Object) fragment)).booleanValue();
        }
        if (fragment != 0 && fragment.isVisible()) {
            if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isProfileCardFragment(fragment)) {
                return true;
            }
            if (fragment instanceof com.tencent.mobileqq.pad.d) {
                return ((com.tencent.mobileqq.pad.d) fragment).shouldDispatchActivityResult();
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean shouldDispatchPostThemeChanged(Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, (Object) fragment)).booleanValue();
        }
        if (fragment == 0 || !fragment.isVisible() || !(fragment instanceof com.tencent.mobileqq.pad.d)) {
            return false;
        }
        return ((com.tencent.mobileqq.pad.d) fragment).shouldDispatchPostThemeChanged();
    }

    public void showGifAnnimate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this);
            return;
        }
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (findFragmentByTag != null) {
            ((MainFragment) findFragmentByTag).jk();
        }
    }

    public void startActivityForResult(Intent intent, int i3, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, this, intent, Integer.valueOf(i3), eVar);
            return;
        }
        MCALLBACKMAP.put("" + i3, eVar);
        startActivityForResult(intent, i3);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity
    public void updateAppRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
        } else {
            super.updateAppRuntime();
        }
    }

    public void updateMain(int i3, int i16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, Integer.valueOf(i3), Integer.valueOf(i16), obj);
            return;
        }
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (findFragmentByTag != null) {
            ((MainFragment) findFragmentByTag).updateMain(i3, i16, obj);
        }
    }

    public void updateTabRedTouch(int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, i3, (Object) redTypeInfo);
            return;
        }
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        if (findFragmentByTag != null) {
            MainFragment mainFragment = (MainFragment) findFragmentByTag;
            if (TianshuRedTouch.INSTANCE.j()) {
                ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateTabRedBadge(mainFragment, i3, redTypeInfo);
            } else {
                ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateTabRedTouch(mainFragment, i3, redTypeInfo);
            }
        }
    }

    @Override // mqq.app.AppActivity
    public void preloadUi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        try {
            this.mSplashPreLoadUI = FrameFragment.preloadMainUI(LayoutInflater.from(this));
        } catch (Throwable th5) {
            QLog.e("SplashActivity", 1, "", th5);
        }
    }

    private void checkNeedClearAct() {
    }
}
