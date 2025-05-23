package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aelight.camera.util.api.IAIOShortVideoUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.fling.FlingConstant;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.peak.PeakConstants;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BaseActivity2 extends mqq.app.BaseActivity implements SkinnableActivityProcesser.Callback, ISystemBarPropertyProvider {
    static IPatchRedirector $redirector_;
    static BaseActivity2 J;
    private static ShakeListener K;
    private static boolean L;
    static boolean M;
    protected boolean C;
    protected long D;
    protected String E;
    public boolean F;
    public boolean G;
    public SystemBarCompact H;
    private BroadcastReceiver I;

    /* renamed from: d, reason: collision with root package name */
    private String f194436d;

    /* renamed from: e, reason: collision with root package name */
    SkinnableActivityProcesser f194437e;

    /* renamed from: f, reason: collision with root package name */
    private FlingHandler f194438f;

    /* renamed from: h, reason: collision with root package name */
    ScreenShot f194439h;

    /* renamed from: i, reason: collision with root package name */
    boolean f194440i;

    /* renamed from: m, reason: collision with root package name */
    protected int f194441m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class LogActivityOnCreateRunnalbe implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<Activity> f194445d;

        public LogActivityOnCreateRunnalbe(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            } else {
                this.f194445d = new WeakReference<>(activity);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Activity activity = this.f194445d.get();
            if (activity != null) {
                com.tencent.qqperf.monitor.crash.tools.b.f(activity);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseActivity2.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent.getAction().equals(IECScreenReceiver.ACTION_SCREEN_OFF)) {
                BaseActivity2.M = false;
                GesturePWDUtils.setAppForground(context, false);
            } else if (intent.getAction().equals(IECScreenReceiver.ACTION_SCREEN_ON)) {
                boolean isAppOnForegroundByTasks = BaseGesturePWDUtil.isAppOnForegroundByTasks(context, 0);
                BaseActivity2.M = isAppOnForegroundByTasks;
                GesturePWDUtils.setAppForground(context, isAppOnForegroundByTasks);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class b extends ShakeListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.ShakeListener
        public void shake() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            String string = BaseApplicationImpl.sApplication.getSharedPreferences(AppConstants.PREF_SCREEN_SHOT, 4).getString("currentactivity", null);
            BaseActivity2 baseActivity2 = BaseActivity2.J;
            if (baseActivity2 != null && baseActivity2.getClass().getName().equals(string)) {
                BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
                boolean readValue = SettingCloneUtil.readValue((Context) baseApplicationImpl, (String) null, baseApplicationImpl.getString(R.string.cyv), AppConstants.QQSETTING_SCREENSHOT_KEY, false);
                boolean b16 = com.tencent.mobileqq.util.ca.b(BaseApplication.getContext());
                if (readValue && b16) {
                    BaseActivity2 baseActivity22 = BaseActivity2.J;
                    if (baseActivity22.f194439h == null) {
                        boolean z16 = baseActivity22.f194440i;
                        Context context = baseActivity22;
                        if (z16) {
                            context = baseActivity22.getApplicationContext();
                        }
                        BaseActivity2 baseActivity23 = BaseActivity2.J;
                        baseActivity23.f194439h = new ScreenShot(context, baseActivity23.getWindow());
                    }
                    boolean isShowing = BaseActivity2.J.f194439h.isShowing();
                    if (isShowing) {
                        ScreenShot.s("BaseActivity2 is showing");
                        return;
                    }
                    if (!BaseActivity2.J.f194439h.f()) {
                        BaseActivity2.J.m0();
                    } else {
                        boolean z17 = wy2.d.f446757g;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("BaseActivity", 2, "snapshot activate " + isShowing);
                    }
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69584);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
        } else {
            M = true;
        }
    }

    public BaseActivity2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f194436d = getClass().getSimpleName();
        this.f194440i = true;
        this.f194441m = 0;
        this.C = true;
        this.F = true;
        this.G = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        ScreenShot screenShot = this.f194439h;
        if (screenShot != null) {
            screenShot.i();
            this.f194439h = null;
            ScreenShot.s("BaseActivity2 cleanScreenShot");
        }
    }

    public static <T extends View> T n0(View view, int i3) {
        return (T) view.findViewById(i3);
    }

    public static <T extends ViewGroup.LayoutParams> T o0(View view) {
        return (T) view.getLayoutParams();
    }

    private boolean p0(Intent intent) {
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action) && action.equals("android.media.action.IMAGE_CAPTURE")) {
            return true;
        }
        if (!TextUtils.isEmpty(action) && action.equals("android.intent.action.GET_CONTENT")) {
            return true;
        }
        if (!TextUtils.isEmpty(action) && action.equals("android.intent.action.PICK")) {
            return true;
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            if (!TextUtils.isEmpty(packageName) && packageName.equals("com.qzone")) {
                return true;
            }
            String className = component.getClassName();
            if (!TextUtils.isEmpty(className) && className.equals("com.tencent.mobileqq.activity.QQBrowserDelegationActivity")) {
                return true;
            }
            return false;
        }
        return false;
    }

    private void s0() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.BaseActivity2.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseActivity2.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                BaseActivity2 baseActivity2 = BaseActivity2.this;
                boolean readValue = SettingCloneUtil.readValue((Context) baseActivity2, (String) null, baseActivity2.getString(R.string.cyv), AppConstants.QQSETTING_SCREENSHOT_KEY, false);
                if (readValue && BaseActivity2.K == null) {
                    b bVar = new b();
                    SensorManager sensorManager = (SensorManager) BaseActivity2.this.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
                    SensorMonitor.registerListener(sensorManager, bVar, SensorMonitor.getDefaultSensor(sensorManager, 1), 2);
                    BaseActivity2.K = bVar;
                    return;
                }
                if (!readValue && BaseActivity2.K != null) {
                    ((SensorManager) BaseActivity2.this.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR)).unregisterListener(BaseActivity2.K);
                    BaseActivity2.K = null;
                }
            }
        }, 16, null, true);
    }

    private void t0(Intent intent, int i3) {
        intent.putExtra(FlingConstant.FLING_ACTION_KEY, 2);
        intent.putExtra(FlingConstant.FLING_CODE_KEY, hashCode());
        super.startActivityForResult(intent, i3);
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
    public boolean actNeedImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.G;
    }

    @Override // mqq.app.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    public Activity getActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Activity) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.app.activitymodule.IActivityPropertyProvider
    public String getCurrentAccountUinFromRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
    public boolean hasTitleBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        return false;
    }

    public void initNavigationBarColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            com.tencent.mobileqq.theme.a.d(getWindow());
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
    public boolean isAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
    public boolean isClearCoverLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
    @TargetApi(24)
    public boolean isInMultiWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        boolean z16 = false;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                z16 = isInMultiWindowMode();
            } catch (Exception unused) {
            }
        }
        if (QLog.isDebugVersion()) {
            QLog.i("BaseActivity2", 2, " fight...isInMultiWindowMode = " + z16);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
    public boolean isNeedInterruptDoMultiWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return false;
    }

    protected void l0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else if (QLog.isDevelopLevel()) {
            QLog.d("BaseActivity2", 4, "checkUnlockForSpecial. flag=,AbsAppInter.visibleActCnt=?,stopflag" + this.f194441m);
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.F;
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
    public void notifyMultiWindowModeStatusVisibilityChange(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (r0()) {
            return;
        }
        try {
            super.onBackPressed();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("BaseActivity2", 2, "", th5);
            }
            finish();
        }
    }

    @Override // mqq.app.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        FlingHandler flingHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) configuration);
        } else {
            super.onConfigurationChanged(configuration);
            if (q0() && (flingHandler = this.f194438f) != null) {
                flingHandler.onConfigurationChanged(configuration);
            }
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        if (QLog.isColorLevel()) {
            QLog.i("BaseActivity2", 2, "[" + hashCode() + "]" + this.f194436d + " process id =" + Process.myPid() + " onCreate task : " + getTaskId());
        }
        try {
            if (getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L) != 0) {
                ((IAIOShortVideoUtil) QRoute.api(IAIOShortVideoUtil.class)).setBaseActivtiyCreateTime(System.currentTimeMillis());
                QLog.e(IAIOShortVideoUtil.MONITOR_EVENT_TAG, 1, "TIMESTAMP_BASE_ACTIVITY_CREATE ", Long.valueOf(((IAIOShortVideoUtil) QRoute.api(IAIOShortVideoUtil.class)).getBaseActivtiyCreateTime()));
            }
        } catch (Exception e16) {
            QLog.e("BaseActivity2", 1, "getLongExtra fail, ", e16);
        }
        try {
            this.E = MobileQQ.sMobileQQ.getLastLoginUin();
        } catch (IllegalStateException e17) {
            this.E = null;
            if (QLog.isColorLevel()) {
                QLog.e("BaseActivity2", 2, "Get lastLoginUin error", e17);
            }
        }
        if (this.E == null && QLog.isColorLevel()) {
            QLog.d("BaseActivity2", 1, "last uin is null.. has problem");
        }
        ThreadManagerV2.excute(new LogActivityOnCreateRunnalbe(this), 16, null, true);
        if (InitSkin.sInited) {
            this.f194437e = new SkinnableActivityProcesser(this, this);
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int i3 = extras.getInt(FlingConstant.FLING_ACTION_KEY);
            if (i3 != 0 && q0()) {
                if (1 == i3) {
                    this.f194438f = new FlingTrackerHandler(this);
                } else {
                    this.f194438f = new FlingGestureHandler(this);
                }
            }
            this.C = extras.getBoolean(PeakConstants.ALLOW_LOCK, true);
        }
        if (!L) {
            s0();
            L = true;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
            a aVar = new a();
            this.I = aVar;
            registerReceiver(aVar, intentFilter);
        } catch (Exception e18) {
            if (QLog.isColorLevel()) {
                QLog.e("BaseActivity2", 2, "registerReceiver error", e18);
            }
        }
        if (this.F && ImmersiveUtils.isSupporImmersive() == 1) {
            getWindow().addFlags(67108864);
            if (this.G) {
                this.H = new SystemBarCompact((Activity) this, true, getResources().getColor(R.color.skin_color_title_immersive_bar));
                if (ThemeUtil.isDefaultOrDIYTheme(false)) {
                    this.H.setStatusDrawable(getResources().getDrawable(R.drawable.qq_title_immersive_bar));
                } else {
                    this.H.setStatusDrawable(null);
                }
            }
        }
        initNavigationBarColor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.i("BaseActivity2", 2, "[" + hashCode() + "]" + this.f194436d + " process id =" + Process.myPid() + " onDestroy task : " + getTaskId());
        }
        J = null;
        com.tencent.qqperf.monitor.crash.tools.b.g(this);
        BroadcastReceiver broadcastReceiver = this.I;
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (Exception unused) {
            }
        }
        SkinnableActivityProcesser skinnableActivityProcesser = this.f194437e;
        if (skinnableActivityProcesser != null) {
            skinnableActivityProcesser.destory();
        }
    }

    @Override // android.app.Activity
    @TargetApi(24)
    public void onMultiWindowModeChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onPause();
        if (QLog.isColorLevel()) {
            QLog.d("BaseActivity2", 2, "[" + hashCode() + "]" + this.f194436d + " onPause");
        }
        this.f194440i = true;
        com.tencent.qqperf.monitor.crash.tools.b.h(this);
        m0();
    }

    @Override // com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            initNavigationBarColor();
        }
    }

    @Override // com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPreThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    @TargetApi(9)
    public void onResume() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onResume();
        if (getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L) != 0) {
            ((IAIOShortVideoUtil) QRoute.api(IAIOShortVideoUtil.class)).setBaseActivtiyResumeTime(System.currentTimeMillis());
            QLog.e(IAIOShortVideoUtil.MONITOR_EVENT_TAG, 1, "TIMESTAMP_BASE_ACTIVITY_RESUME ", Long.valueOf(((IAIOShortVideoUtil) QRoute.api(IAIOShortVideoUtil.class)).getBaseActivtiyResumeTime()));
        }
        if (QLog.isColorLevel()) {
            QLog.d("BaseActivity2", 2, "[" + hashCode() + "]" + this.f194436d + " onResume ");
        }
        this.f194440i = false;
        com.tencent.qqperf.monitor.crash.tools.b.i(this);
        J = this;
        this.D = SystemClock.uptimeMillis();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.BaseActivity2.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseActivity2.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                SharedPreferences.Editor edit = BaseActivity2.this.getSharedPreferences(AppConstants.PREF_SCREEN_SHOT, 4).edit();
                edit.putString("currentactivity", getClass().getName());
                edit.apply();
            }
        }, 64, null, false);
        M = BaseGesturePWDUtil.getAppForground(this);
        if (QLog.isDevelopLevel()) {
            QLog.d("BaseActivity2", 4, "onResume.mAppForground = " + M + ",mCanLock=" + this.C);
        }
        if (!M && this.C && (str = this.E) != null && BaseGesturePWDUtil.getJumpLock(this, str)) {
            u0();
        } else if (!M && this.C) {
            l0();
        }
        if (!M) {
            M = true;
            GesturePWDUtils.setAppForground(this, true);
        }
        this.f194441m = 0;
        this.C = true;
        SystemBarCompact systemBarCompact = this.H;
        if (systemBarCompact != null && this.G) {
            systemBarCompact.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onStart() {
        FlingHandler flingHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onStart();
        if (getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L) != 0) {
            ((IAIOShortVideoUtil) QRoute.api(IAIOShortVideoUtil.class)).setBaseActivtiyStartTime(System.currentTimeMillis());
            QLog.e(IAIOShortVideoUtil.MONITOR_EVENT_TAG, 1, "TIMESTAMP_BASE_ACTIVITY_START ", Long.valueOf(((IAIOShortVideoUtil) QRoute.api(IAIOShortVideoUtil.class)).getBaseActivtiyStartTime()));
        }
        if (QLog.isColorLevel()) {
            QLog.d("BaseActivity2", 2, "[" + hashCode() + "]" + this.f194436d + " onStart");
        }
        if (q0() && (flingHandler = this.f194438f) != null) {
            flingHandler.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onStop();
        if (QLog.isColorLevel()) {
            QLog.d("BaseActivity2", 2, "[" + hashCode() + "]" + this.f194436d + " onStop");
        }
        this.f194441m = 1;
        boolean isAppOnForegroundByTasks = BaseGesturePWDUtil.isAppOnForegroundByTasks(this);
        M = isAppOnForegroundByTasks;
        if (!isAppOnForegroundByTasks) {
            GesturePWDUtils.setAppForground(this, isAppOnForegroundByTasks);
        }
        if (QLog.isColorLevel()) {
            QLog.d("BaseActivity2", 2, "zsw subaccount onStop stop get sub msg AbsAppInter.visibleActCnt = ?");
        }
    }

    protected boolean q0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    protected boolean r0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
    public void setStatusBarVisibilityNeedGone(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) intent, i3);
            return;
        }
        this.f194441m = 2;
        if (p0(intent)) {
            this.C = false;
        }
        try {
            t0(intent, i3);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("BaseActivity2", 2, "startActivity failed with: ", e16);
            }
        }
    }

    protected void u0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("BaseActivity2", 4, "startUnlockActivity..." + this.f194436d);
        }
        startActivity(new Intent(this, (Class<?>) GesturePWDUnlockActivity.class));
    }

    @Override // mqq.app.BaseActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, intent, Integer.valueOf(i3), bundle);
            return;
        }
        try {
            JefsClass.getInstance().checkAndDoSync(this, intent, new TeleScreenRunnable(intent, i3, bundle) { // from class: com.tencent.mobileqq.app.BaseActivity2.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Intent f194442d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f194443e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Bundle f194444f;

                {
                    this.f194442d = intent;
                    this.f194443e = i3;
                    this.f194444f = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BaseActivity2.this, intent, Integer.valueOf(i3), bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        try {
                            BaseActivity2.super.startActivityForResult(this.f194442d, this.f194443e, this.f194444f);
                            return;
                        } catch (Throwable th5) {
                            QLog.e("BaseActivity2", 1, th5, new Object[0]);
                            return;
                        }
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        } catch (Throwable th5) {
            QLog.e("BaseActivity2", 1, th5, new Object[0]);
        }
    }
}
