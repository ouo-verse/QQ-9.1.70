package com.tencent.mobileqq.app.activitymodule;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.simpleui.api.ISimpleUIUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

/* compiled from: P */
/* loaded from: classes11.dex */
public class SystemBarActivityModule extends AbsActivityModule implements ISystemBar {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SystemBarActivityModule";
    private static boolean mIsInMultiScreen;
    protected QBaseActivity activity;
    private StatusBarCorrectTask mStatusBarCorrectTask;
    private int mStatusBarVisibility;
    protected SystemBarCompact mSystemBarComp;
    private int[] mWindowLocation;
    private ISystemBarPropertyProvider propertyProvider;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class StatusBarCorrectTask implements Runnable {
        static IPatchRedirector $redirector_;

        public StatusBarCorrectTask() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SystemBarActivityModule.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (ImmersiveUtils.correctStatusBarHeight(SystemBarActivityModule.this.activity.getWindow())) {
                SystemBarActivityModule.this.activity.recreate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements View.OnSystemUiVisibilityChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SystemBarActivityModule.this);
            }
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i3) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (i3 == 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            boolean unused = SystemBarActivityModule.mIsInMultiScreen = z16;
            SystemBarActivityModule.this.activity.onMultiWindowModeChanged(SystemBarActivityModule.mIsInMultiScreen);
            if (QLog.isDevelopLevel()) {
                QLog.d(SystemBarActivityModule.TAG, 4, "onSystemUiVisibilityChange:" + i3 + ",Activity name:" + getClass().getName());
            }
        }
    }

    public SystemBarActivityModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mStatusBarVisibility = 0;
        }
    }

    public static SystemBarCompact getSystemBarComp(QBaseActivity qBaseActivity) {
        SystemBarActivityModule systemBarActivityModule = (SystemBarActivityModule) qBaseActivity.getModule(SystemBarActivityModule.class);
        if (systemBarActivityModule == null) {
            return null;
        }
        return systemBarActivityModule.getSystemBarComp();
    }

    public static boolean isInMultiScreen() {
        return mIsInMultiScreen;
    }

    public static boolean isNeedStatusBarGone(QBaseActivity qBaseActivity) {
        SystemBarActivityModule systemBarActivityModule = (SystemBarActivityModule) qBaseActivity.getModule(SystemBarActivityModule.class);
        if (systemBarActivityModule == null) {
            return false;
        }
        return systemBarActivityModule.isNeedStatusBarGone();
    }

    private void resumeStatusBar() {
        int i3;
        this.propertyProvider.setStatusBarVisibilityNeedGone(false);
        if (!this.propertyProvider.isNeedInterruptDoMultiWindow() && this.propertyProvider.isAttachedToWindow() && this.propertyProvider.isInMultiWindow()) {
            boolean isNeedStatusBarGone = isNeedStatusBarGone();
            SystemBarCompact systemBarCompact = this.mSystemBarComp;
            if (systemBarCompact != null && systemBarCompact.isStatusBarVisible == isNeedStatusBarGone) {
                if (isNeedStatusBarGone) {
                    i3 = 2;
                } else {
                    i3 = 0;
                }
                systemBarCompact.setStatusBarVisible(i3, 0);
                setStatusBarVisibility(i3);
                this.propertyProvider.notifyMultiWindowModeStatusVisibilityChange(i3);
            }
        }
    }

    public static void setImmersiveStatus(QBaseActivity qBaseActivity, int i3) {
        SystemBarActivityModule systemBarActivityModule = (SystemBarActivityModule) qBaseActivity.getModule(SystemBarActivityModule.class);
        if (systemBarActivityModule != null) {
            systemBarActivityModule.setImmersiveStatus(i3);
        }
    }

    @TargetApi(11)
    private void setOnMultiScreenChangeListener() {
        if (Build.VERSION.SDK_INT < 24) {
            a aVar = new a();
            try {
                View decorView = this.activity.getWindow().getDecorView();
                decorView.setOnSystemUiVisibilityChangeListener(aVar);
                if (decorView.getSystemUiVisibility() != 0) {
                    aVar.onSystemUiVisibilityChange(decorView.getSystemUiVisibility());
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d(TAG, 4, "setOnMultiScreenChangeListener:" + decorView.getSystemUiVisibility() + ",Activity name:" + getClass().getName());
                }
            } catch (Exception e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(TAG, 4, "setOnMultiScreenChangeListener happen exception:" + e16.getMessage() + ",Activity name:" + getClass().getName());
                }
            }
        }
    }

    public static void setStatusBarBlue(QBaseActivity qBaseActivity) {
        SystemBarActivityModule systemBarActivityModule = (SystemBarActivityModule) qBaseActivity.getModule(SystemBarActivityModule.class);
        if (systemBarActivityModule != null) {
            systemBarActivityModule.setStatusBarBlue();
        }
    }

    public static void setSystemBarComp(QBaseActivity qBaseActivity, SystemBarCompact systemBarCompact) {
        SystemBarActivityModule systemBarActivityModule = (SystemBarActivityModule) qBaseActivity.getModule(SystemBarActivityModule.class);
        if (systemBarActivityModule != null) {
            systemBarActivityModule.setSystemBarComp(systemBarCompact);
        }
    }

    protected void adjustDisplayMetrics() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        GlobalDisplayMetricsManager.adjustDisplayMetrics(this.activity);
        FontSettingManager.resetFontIfNeeded(this.activity, true, false);
        GlobalDisplayMetricsManager.adjustDisplayMetrics(BaseApplication.getContext());
        FontSettingManager.resetFontIfNeeded(BaseApplication.getContext(), true, false);
    }

    public void adjustSimpleStatusBar() {
        SystemBarCompact systemBarCompact;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (((ISimpleUIUtil) QRoute.api(ISimpleUIUtil.class)).getSimpleUISwitch()) {
            boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
            if (ImmersiveUtils.isSupporImmersive() != 0 && ImmersiveUtils.couldSetStatusTextColor()) {
                ImmersiveUtils.setStatusTextColor(!isNowThemeIsNight, this.activity.getWindow());
                return;
            } else {
                if (ImmersiveUtils.isSupporImmersive() != 0 && (systemBarCompact = this.mSystemBarComp) != null && !isNowThemeIsNight) {
                    systemBarCompact.setStatusBarColor(-2368549);
                    return;
                }
                return;
            }
        }
        if (ImmersiveUtils.isSupporImmersive() != 0) {
            ImmersiveUtils.setStatusTextColor(false, this.activity.getWindow());
        }
    }

    public void correctStatusBarHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (!ImmersiveUtils.statusHeightCorrect && !this.propertyProvider.isInMultiWindow()) {
            if (this.mStatusBarCorrectTask == null) {
                this.mStatusBarCorrectTask = new StatusBarCorrectTask();
            }
            ThreadManager.getUIHandler().post(this.mStatusBarCorrectTask);
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityCreate(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        setImmersiveStatus();
        initNavigationBarColor();
        setOnMultiScreenChangeListener();
        ((ISimpleUIUtil) QRoute.api(ISimpleUIUtil.class)).adjustSimpleStatusBar(this.mSystemBarComp, activity.getWindow());
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPreCreated(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) activity, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityResume(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) activity);
            return;
        }
        SystemBarCompact systemBarCompact = this.mSystemBarComp;
        if (systemBarCompact != null) {
            systemBarCompact.init();
            setOnMultiScreenChangeListener();
        }
        resumeStatusBar();
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnConfigurationChanged(Activity activity, Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) activity, (Object) configuration);
        } else {
            super.doOnConfigurationChanged(activity, configuration);
            adjustDisplayMetrics();
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public boolean doOnDispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) keyEvent)).booleanValue();
        }
        return false;
    }

    protected void fitViewIfImmersive(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) view);
        } else if (this.propertyProvider.needStatusTrans() && ImmersiveUtils.isSupporImmersive() == 1) {
            ImmersiveUtils.setFitsSystemWindows(view, true);
        }
    }

    public int getStatusBarVisibility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mStatusBarVisibility;
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.activitymodule.IActivityModule
    public void init(IActivityPropertyProvider iActivityPropertyProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iActivityPropertyProvider);
        } else {
            this.activity = (QBaseActivity) iActivityPropertyProvider.getActivity();
            this.propertyProvider = (ISystemBarPropertyProvider) iActivityPropertyProvider;
        }
    }

    public void initNavigationBarColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else if (QUIImmersiveHelper.i()) {
            QLog.d(TAG, 1, "initNavigationBarColor fail, because QUIImmersiveHelper running");
        } else {
            com.tencent.mobileqq.theme.a.d(this.activity.getWindow());
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onPostThemeChanged(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) activity);
            return;
        }
        if (this.mSystemBarComp != null) {
            if (!QQTheme.isDefaultOrDIYTheme() && !QQTheme.isNowThemeIsNight()) {
                this.mSystemBarComp.setStatusBarDrawable(null);
                this.mSystemBarComp.setStatusBarColor(activity.getResources().getColor(R.color.skin_color_title_immersive_bar));
            } else {
                this.mSystemBarComp.setStatusBarDrawable(activity.getResources().getDrawable(R.drawable.qui_status_bar_bg));
            }
        }
        ((ISimpleUIUtil) QRoute.api(ISimpleUIUtil.class)).adjustSimpleStatusBar(this.mSystemBarComp, activity.getWindow());
        initNavigationBarColor();
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onPreSetContentView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) view);
            return;
        }
        if (this.propertyProvider.hasTitleBar()) {
            fitViewIfImmersive(view);
            printWindowFeatures();
        }
        super.onPreSetContentView(view);
    }

    protected void printWindowFeatures() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        Window window = this.activity.getWindow();
        try {
            if (window.hasFeature(0)) {
                QLog.i(TAG, 1, "printWindowFeatures: FEATURE_OPTIONS_PANEL");
            }
            if (window.hasFeature(1)) {
                QLog.i(TAG, 1, "printWindowFeatures: FEATURE_NO_TITLE");
            }
            if (window.hasFeature(2)) {
                QLog.i(TAG, 1, "printWindowFeatures: FEATURE_PROGRESS");
            }
            if (window.hasFeature(3)) {
                QLog.i(TAG, 1, "printWindowFeatures: FEATURE_LEFT_ICON");
            }
            if (window.hasFeature(4)) {
                QLog.i(TAG, 1, "printWindowFeatures: FEATURE_RIGHT_ICON");
            }
            if (window.hasFeature(5)) {
                QLog.i(TAG, 1, "printWindowFeatures: FEATURE_INDETERMINATE_PROGRESS");
            }
            if (window.hasFeature(6)) {
                QLog.i(TAG, 1, "printWindowFeatures: FEATURE_CONTEXT_MENU");
            }
            if (window.hasFeature(7)) {
                QLog.i(TAG, 1, "printWindowFeatures: FEATURE_CUSTOM_TITLE");
            }
            if (window.hasFeature(8)) {
                QLog.i(TAG, 1, "printWindowFeatures: FEATURE_ACTION_BAR");
            }
            if (window.hasFeature(9)) {
                QLog.i(TAG, 1, "printWindowFeatures: FEATURE_ACTION_BAR_OVERLAY");
            }
            if (window.hasFeature(10)) {
                QLog.i(TAG, 1, "printWindowFeatures: FEATURE_ACTION_MODE_OVERLAY");
            }
            if (window.hasFeature(11)) {
                QLog.i(TAG, 1, "printWindowFeatures: FEATURE_SWIPE_TO_DISMISS");
            }
            if (window.hasFeature(12)) {
                QLog.i(TAG, 1, "printWindowFeatures: FEATURE_CONTENT_TRANSITIONS");
            }
            if (window.hasFeature(13)) {
                QLog.i(TAG, 1, "printWindowFeatures: FEATURE_ACTIVITY_TRANSITIONS");
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "printWindowFeatures: ", th5);
        }
    }

    public void setStatusBarVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mStatusBarVisibility = i3;
        }
    }

    public static void setImmersiveStatus(QBaseActivity qBaseActivity) {
        SystemBarActivityModule systemBarActivityModule = (SystemBarActivityModule) qBaseActivity.getModule(SystemBarActivityModule.class);
        if (systemBarActivityModule != null) {
            systemBarActivityModule.setImmersiveStatus();
        }
    }

    public SystemBarCompact getSystemBarComp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.mSystemBarComp : (SystemBarCompact) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    protected boolean isNeedStatusBarGone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        if (this.mWindowLocation == null) {
            this.mWindowLocation = new int[2];
        }
        this.activity.getWindow().getDecorView().getLayoutParams();
        this.activity.getWindow().getDecorView().getLocationOnScreen(this.mWindowLocation);
        boolean z16 = this.mWindowLocation[1] > 10 || !(this.activity.getWindow().getDecorView().getSystemUiVisibility() == 0);
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "fight..isNeedStatusBarGone " + z16);
        }
        return z16;
    }

    protected void setStatusBarBlue() {
        SystemBarCompact systemBarCompact;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            if (!QQTheme.isDefaultOrDIYTheme() || (systemBarCompact = this.mSystemBarComp) == null) {
                return;
            }
            systemBarCompact.setStatusBarDrawable(this.activity.getResources().getDrawable(R.drawable.qui_status_bar_bg));
        }
    }

    public void setSystemBarComp(SystemBarCompact systemBarCompact) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.mSystemBarComp = systemBarCompact;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) systemBarCompact);
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onPreSetContentView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        if (this.propertyProvider.hasTitleBar()) {
            printWindowFeatures();
        }
        super.onPreSetContentView(i3);
    }

    public void setImmersiveStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.propertyProvider.needStatusTrans() && ImmersiveUtils.isSupporImmersive() == 1) {
            this.activity.getWindow().addFlags(67108864);
            if (this.propertyProvider.actNeedImmersive()) {
                int color = this.activity.getResources().getColor(R.color.skin_color_title_immersive_bar);
                if (this.mSystemBarComp == null) {
                    this.mSystemBarComp = new SystemBarCompact((Activity) this.activity, true, color);
                    if (!QQTheme.isDefaultOrDIYTheme() && !QQTheme.isNowThemeIsNight()) {
                        this.mSystemBarComp.setStatusDrawable(null);
                    } else {
                        this.mSystemBarComp.setStatusDrawable(this.activity.getResources().getDrawable(R.drawable.qui_status_bar_bg));
                    }
                }
            }
            ImmersiveUtils.clearCoverForStatus(this.activity.getWindow(), this.propertyProvider.isClearCoverLayer());
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBar
    public void setImmersiveStatus(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        if (this.propertyProvider.needStatusTrans() && ImmersiveUtils.isSupporImmersive() == 1) {
            this.activity.getWindow().addFlags(67108864);
            if (this.mSystemBarComp == null) {
                this.mSystemBarComp = new SystemBarCompact((Activity) this.activity, true, i3);
            }
            ImmersiveUtils.clearCoverForStatus(this.activity.getWindow(), this.propertyProvider.isClearCoverLayer());
        }
    }
}
