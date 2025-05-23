package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.biz.richframework.collection.RFWThreadLocal;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.layoutinflater.LayoutInflaterCompat;
import com.tencent.biz.richframework.layoutinflater.RFWMainThreadLayoutInflater;
import com.tencent.biz.richframework.layoutinflater.RFWSubThreadLayoutInflater;
import com.tencent.biz.richframework.layoutinflater.RedirectAndAndroidNFactory2;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.activitymodule.ActivityModuleHub;
import com.tencent.mobileqq.app.activitymodule.IActivityModule;
import com.tencent.mobileqq.app.activitymodule.IActivityModuleHub;
import com.tencent.mobileqq.app.activitymodule.IActivityModuleProvider;
import com.tencent.mobileqq.app.activitymodule.IGesturePropertyProvider;
import com.tencent.mobileqq.app.activitymodule.IScreenShotPropertyProvider;
import com.tencent.mobileqq.app.activitymodule.ISkinPropertyProvider;
import com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider;
import com.tencent.mobileqq.app.anim.IUnitedAnimSetter;
import com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks;
import com.tencent.mobileqq.app.lifecycle.GlobalLifecycleCallbacks;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.preload.activity.ArgusPreloadManager;
import com.tencent.richframework.preload.activity.BaseActivityResPreloadTask;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.os.MqqInterceptHandler;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QBaseActivity extends AppActivity implements ISkinCallback, IActivityModuleHub {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_ACTIVITY_CLOSE_ENTER_ANIMATION = "activity_close_enter_animation";
    public static final String KEY_ACTIVITY_CLOSE_EXIT_ANIMATION = "activity_close_exit_animation";
    public static final String KEY_ACTIVITY_OPEN_ENTER_ANIMATION = "activity_open_enter_animation";
    public static final String KEY_ACTIVITY_OPEN_EXIT_ANIMATION = "activity_open_exit_animation";
    public static final String KEY_GESTURE_SHOWGESTURE_VALID = "key_gesture_showgesture_valid";
    public static final String KEY_SET_ACTIVITY_ANIMATION = "set_activity_animation";
    public static final String KEY_TYPE_ACTIVITY_ANIMATION = "type_activity_animation";
    public static final int MSG_SHAKE = 1001;
    public static final int REQUEST_CODE_UNLOCK = 12289;
    public static final String TAG = "qqBaseActivity";
    private static IBaseActivityInjectInterface injectInterface;
    public static boolean isUnLockSuccess;
    private static final GlobalLifecycleCallbacks lifecycleCallbacks;
    public static long mAppBackgroundTime;
    public static boolean mAppForground;
    protected static long mShowGesture;
    public static ArrayList<String> sActivityRoute;
    public static QBaseActivity sTopActivity;
    private ActivityModuleHub activityModuleHub;
    private String className;
    public int clickX;
    public int clickY;
    protected long currentActivityStayTime;
    private final RFWThreadLocal<Resources> currentResource;
    public boolean isClearCoverLayer;
    public boolean isCloneInflaterInSubThread;
    public boolean isEnableDelegateLayoutInflater;
    public boolean isEnableDelegateResource;
    private Dialog jumpDialog;
    public boolean mActNeedImmersive;
    private final ArrayList<BaseActivityLifecycleCallbacks> mActivityLifecycleCallbacks;
    protected boolean mCanLock;
    public boolean mCurrentActivityShakeFlag;
    private BroadcastReceiver mDebugUiHierarchyBroadcastReceiver;
    private LayoutInflater mDelegateLayoutInflater;
    protected boolean mIsAttachedToWindow;
    protected boolean mIsStatusBarVisibilityNeedGone;
    private final RFWThreadLocal<LayoutInflater> mLayoutInflaters;
    private Runnable mNFCPauseRunnable;
    private Runnable mNFCResumeRunnable;
    public boolean mNeedStatusTrans;
    protected boolean mShowOnFirst;
    protected int mStopFlag;
    private a mTopResumedActivityListener;
    public boolean preloadCompatFactory2Enabled;
    Runnable runnableRemoveNotification;
    private IUnitedAnimSetter unitedAnimSetter;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class ActivityPropertyProvider implements IGesturePropertyProvider, IScreenShotPropertyProvider, ISkinPropertyProvider, ISystemBarPropertyProvider {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: protected */
        public ActivityPropertyProvider() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QBaseActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
        public boolean actNeedImmersive() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
            }
            return QBaseActivity.this.mActNeedImmersive;
        }

        @Override // com.tencent.mobileqq.app.activitymodule.IActivityPropertyProvider, or.e
        public Activity getActivity() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Activity) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return QBaseActivity.this;
        }

        @Override // com.tencent.mobileqq.app.activitymodule.IActivityPropertyProvider
        public AppRuntime getAppRuntime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (AppRuntime) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return QBaseActivity.this.getAppRuntime();
        }

        @Override // com.tencent.mobileqq.app.activitymodule.IActivityPropertyProvider
        public String getCurrentAccountUinFromRuntime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return QBaseActivity.this.getCurrentAccountUinFromRuntime();
        }

        @Override // com.tencent.mobileqq.app.activitymodule.IActivityPropertyProvider
        public Intent getIntent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Intent) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return QBaseActivity.this.getIntent();
        }

        @Override // com.tencent.mobileqq.app.activitymodule.IScreenShotPropertyProvider
        public boolean getShakeFlag() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            return QBaseActivity.this.mCurrentActivityShakeFlag;
        }

        @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
        public boolean hasTitleBar() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
        public boolean isAttachedToWindow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
            }
            return QBaseActivity.this.mIsAttachedToWindow;
        }

        @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
        public boolean isClearCoverLayer() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
            }
            return QBaseActivity.this.isClearCoverLayer;
        }

        @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
        public boolean isInMultiWindow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
            }
            return QBaseActivity.this.isInMultiWindow();
        }

        @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
        public boolean isNeedInterruptDoMultiWindow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
            }
            return QBaseActivity.this.isNeedInterruptDoMultiWindow();
        }

        @Override // com.tencent.mobileqq.app.activitymodule.IScreenShotPropertyProvider
        public boolean isSupportScreenShot() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return QBaseActivity.this.isSupportScreenShot();
        }

        @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
        public boolean needStatusTrans() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
            }
            return QBaseActivity.this.mNeedStatusTrans;
        }

        @Override // com.tencent.mobileqq.app.activitymodule.IGesturePropertyProvider
        public boolean needWrapContent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return QBaseActivity.this.getNeedGestureBack();
        }

        @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
        public void notifyMultiWindowModeStatusVisibilityChange(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this, i3);
            } else {
                QBaseActivity.this.doInMultiWindowModeStatusBarVisibilityChange(i3);
            }
        }

        @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
        public void setStatusBarVisibilityNeedGone(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, z16);
            } else {
                QBaseActivity.this.mIsStatusBarVisibilityNeedGone = z16;
            }
        }

        @Override // com.tencent.mobileqq.app.activitymodule.ISkinPropertyProvider
        public boolean themeChangeRightNow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
            }
            return QBaseActivity.this.themeChangeRightNow();
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void a(Activity activity, boolean z16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42130);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 88)) {
            redirector.redirect((short) 88);
            return;
        }
        lifecycleCallbacks = new GlobalLifecycleCallbacks();
        Iterator<BaseActivityLifecycleCallbacks> it = QBaseActivityInjectUtil.sGlobalCallbacks.iterator();
        while (it.hasNext()) {
            lifecycleCallbacks.registerActivityLifecycleCallbacks(it.next());
        }
        if (QBaseActivityInjectUtil.sInjectInterfaceList.size() > 0) {
            injectInterface = QBaseActivityInjectUtil.sInjectInterfaceList.get(0);
        }
        mAppForground = true;
        isUnLockSuccess = false;
        mAppBackgroundTime = 0L;
        mShowGesture = 0L;
        sActivityRoute = new ArrayList<>();
    }

    public QBaseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.activityModuleHub = null;
        this.className = getClass().getSimpleName();
        this.mStopFlag = 0;
        this.mCanLock = true;
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = true;
        this.mCurrentActivityShakeFlag = true;
        this.isClearCoverLayer = true;
        this.mActivityLifecycleCallbacks = new ArrayList<>();
        this.runnableRemoveNotification = null;
        this.mLayoutInflaters = new RFWThreadLocal<>();
        this.currentResource = new RFWThreadLocal<>();
        this.mDelegateLayoutInflater = null;
        this.isCloneInflaterInSubThread = false;
        this.isEnableDelegateLayoutInflater = false;
        this.preloadCompatFactory2Enabled = RFWConfig.getConfigValue("COMPAT_FACTORY2", false);
        this.isEnableDelegateResource = false;
    }

    private Object[] collectActivityLifecycleCallbacks() {
        Object[] objArr;
        synchronized (this.mActivityLifecycleCallbacks) {
            if (this.mActivityLifecycleCallbacks.size() > 0) {
                objArr = this.mActivityLifecycleCallbacks.toArray();
            } else {
                objArr = null;
            }
        }
        return objArr;
    }

    public static ArrayList<String> getActivityRoutes() {
        return (ArrayList) sActivityRoute.clone();
    }

    private LayoutInflater getInnerLayoutInflater(LayoutInflater layoutInflater) {
        if (isDelegateLayoutInflaterEnabled() && Looper.getMainLooper() == Looper.myLooper()) {
            if (this.mDelegateLayoutInflater == null) {
                this.mDelegateLayoutInflater = RFWMainThreadLayoutInflater.from(layoutInflater, ArgusPreloadManager.INSTANCE.getLayoutPreLoader());
            }
            return this.mDelegateLayoutInflater;
        }
        if (isCloneInflaterInSubThreadEnabled() && Looper.getMainLooper() != Looper.myLooper()) {
            LayoutInflater layoutInflater2 = this.mLayoutInflaters.get();
            if (layoutInflater2 == null) {
                layoutInflater2 = RFWSubThreadLayoutInflater.INSTANCE.from(layoutInflater);
                if (this.preloadCompatFactory2Enabled) {
                    LayoutInflaterCompat.INSTANCE.setForceMainAndFallbackFactory2(layoutInflater2, new RedirectAndAndroidNFactory2(), true);
                }
            }
            this.mLayoutInflaters.set(layoutInflater2);
            return layoutInflater2;
        }
        return layoutInflater;
    }

    public static boolean isMoveTaskToBack(Context context, Intent intent) {
        if (intent.getComponent() == null || !intent.getComponent().getPackageName().equals(context.getPackageName())) {
            return true;
        }
        return false;
    }

    private boolean isStartQQ3rdApp(Intent intent) {
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

    private void realStartActivityForResult(Intent intent, int i3) {
        boolean booleanExtra = intent.getBooleanExtra("key_gesture_showgesture_valid", true);
        if (booleanExtra && Math.abs(mShowGesture - SystemClock.uptimeMillis()) < 1000) {
            QLog.d("qqBaseActivity", 1, IAELaunchRecorder.MILESTONE_START_ACTIVITY + mShowGesture + "," + booleanExtra);
            return;
        }
        this.mStopFlag = 2;
        if (isStartQQ3rdApp(intent)) {
            if (QLog.isColorLevel()) {
                QLog.d("qqBaseActivity", 2, "mCanLock set false, isStartQQ3rdApp");
            }
            this.mCanLock = false;
        }
        dispatchPreHandleStartActivityForResult(this, intent, i3);
        if (!isMoveTaskToBack(this, intent)) {
            intent.addFlags(262144);
        }
        String stringExtra = intent.getStringExtra(AppStatusCallbackSingleton.getInstance().getCallback().getKeyOfSelfSetLeftViewText());
        if (TextUtils.isEmpty(stringExtra)) {
            intent.putExtra(AppStatusCallbackSingleton.getInstance().getCallback().getKeyOfLeftViewText(), setLastActivityName());
        } else {
            intent.putExtra(AppStatusCallbackSingleton.getInstance().getCallback().getKeyOfLeftViewText(), stringExtra);
            intent.removeExtra(AppStatusCallbackSingleton.getInstance().getCallback().getKeyOfLeftViewText());
        }
        if (!AppStatusCallbackSingleton.getInstance().getCallback().isDebugVersion()) {
            try {
                super.startActivityForResult(intent, i3);
            } catch (Exception e16) {
                QLog.w("qqBaseActivity", 1, "startActivity failed with: ", e16);
            }
        } else {
            super.startActivityForResult(intent, i3);
        }
        IUnitedAnimSetter iUnitedAnimSetter = this.unitedAnimSetter;
        if (iUnitedAnimSetter != null) {
            iUnitedAnimSetter.afterFinishActivity();
        }
    }

    private void replaceActivityHandler() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            Handler createMqqHandler = MqqInterceptHandler.createMqqHandler((Handler) declaredField.get(this));
            if (createMqqHandler != null) {
                declaredField.set(this, createMqqHandler);
            }
        } catch (Exception e16) {
            QLog.e("qqBaseActivity", 1, "", e16);
        }
    }

    public static void setIsUnLockSuccess(boolean z16) {
        isUnLockSuccess = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void activityCloseAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this);
            return;
        }
        if (getIntent().getBooleanExtra(KEY_SET_ACTIVITY_ANIMATION, false)) {
            overridePendingTransition(getIntent().getIntExtra(KEY_ACTIVITY_CLOSE_ENTER_ANIMATION, 0), getIntent().getIntExtra(KEY_ACTIVITY_CLOSE_EXIT_ANIMATION, 0));
            return;
        }
        String stringExtra = getIntent().getStringExtra(KEY_TYPE_ACTIVITY_ANIMATION);
        if (stringExtra != null) {
            com.tencent.mobileqq.app.anim.b.b(stringExtra, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void activityOpenAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this);
            return;
        }
        if (getIntent().getBooleanExtra(KEY_SET_ACTIVITY_ANIMATION, false)) {
            overridePendingTransition(getIntent().getIntExtra(KEY_ACTIVITY_OPEN_ENTER_ANIMATION, 0), getIntent().getIntExtra(KEY_ACTIVITY_OPEN_EXIT_ANIMATION, 0));
            return;
        }
        String stringExtra = getIntent().getStringExtra(KEY_TYPE_ACTIVITY_ANIMATION);
        if (stringExtra != null) {
            com.tencent.mobileqq.app.anim.b.c(stringExtra, this);
        }
    }

    public void addObserver(BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) businessObserver);
            return;
        }
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime instanceof AppInterface) {
            ((AppInterface) appRuntime).addObserver(businessObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) context);
            return;
        }
        if (getBaseContext() instanceof Application) {
            BaseActivityResPreloadTask.INSTANCE.setActivityFakeResource(this, null);
        }
        super.attachBaseContext(context);
        if (QBaseActivityInjectUtil.sInstanceCallbacks.size() <= 0) {
            QLog.i("qqBaseActivity", 1, "initInjectVariable \u4e4b\u540e\uff0csInstanceCallbacks \u4e3a\u7a7a", new Throwable());
        }
        Iterator<BaseActivityLifecycleCallbacks> it = QBaseActivityInjectUtil.sInstanceCallbacks.iterator();
        while (it.hasNext()) {
            registerActivityLifecycleCallbacks(it.next());
        }
        ActivityModuleHub activityModuleHub = new ActivityModuleHub(getActivityModuleProvider(), getActivityPropertyProvider());
        this.activityModuleHub = activityModuleHub;
        registerActivityLifecycleCallbacks(activityModuleHub);
    }

    public void checkUnlockForSpecial() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("qqBaseActivity", 4, "checkUnlockForSpecial. flag=,AbsAppInter.visibleActCnt=" + Foreground.getActivityCount() + ",stopflag" + this.mStopFlag);
        }
    }

    void dispatchAccountChanged(Activity activity) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).onAccountChanged(activity);
            }
        }
        lifecycleCallbacks.dispatchAccountChanged(activity);
    }

    void dispatchActivityConfigurationChanged(Activity activity, Configuration configuration) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnConfigurationChanged(activity, configuration);
            }
        }
        lifecycleCallbacks.dispatchActivityConfigurationChanged(activity, configuration);
    }

    void dispatchActivityDestroyed(Activity activity) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityDestroyed(activity);
            }
        }
        lifecycleCallbacks.dispatchActivityDestroyed(activity);
    }

    void dispatchActivityOnCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityCreate(qBaseActivity, bundle);
            }
        }
        lifecycleCallbacks.dispatchActivityOnCreate(qBaseActivity, bundle);
    }

    void dispatchActivityOnPause(Activity activity) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityPause(activity);
            }
        }
        lifecycleCallbacks.dispatchActivityOnPause(activity);
    }

    void dispatchActivityPostCreated(Activity activity, Bundle bundle) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityPostCreated(activity, bundle);
            }
        }
        lifecycleCallbacks.dispatchActivityPostCreated(activity, bundle);
    }

    void dispatchActivityPostPaused(Activity activity) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityPostPaused(activity);
            }
        }
        lifecycleCallbacks.dispatchActivityPostPaused(activity);
    }

    void dispatchActivityPostResumed(Activity activity) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityPostResumed(activity);
            }
        }
        lifecycleCallbacks.dispatchActivityPostResumed(activity);
    }

    void dispatchActivityPreCreated(QBaseActivity qBaseActivity, Bundle bundle) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityPreCreated(qBaseActivity, bundle);
            }
        }
        lifecycleCallbacks.dispatchActivityPreCreated(qBaseActivity, bundle);
    }

    void dispatchActivityPrePaused(Activity activity) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityPrePaused(activity);
            }
        }
        lifecycleCallbacks.dispatchActivityPrePaused(activity);
    }

    void dispatchActivityPreResumed(Activity activity) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityPreResumed(activity);
            }
        }
        lifecycleCallbacks.dispatchActivityPreResumed(activity);
    }

    void dispatchActivityResumed(Activity activity) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityResume(activity);
            }
        }
        lifecycleCallbacks.dispatchActivityOnResume(activity);
    }

    void dispatchActivityStarted(Activity activity) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityOnStart(activity);
            }
        }
        lifecycleCallbacks.dispatchActivityOnStart(activity);
    }

    void dispatchActivityStopped(Activity activity) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityStopped(activity);
            }
        }
        lifecycleCallbacks.dispatchActivityStopped(activity);
    }

    void dispatchActivityWindowFocusChanged(Activity activity, boolean z16) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnWindowFocusChanged(activity, z16);
            }
        }
        lifecycleCallbacks.dispatchActivityWindowFocusChanged(activity, z16);
    }

    void dispatchNewInstant(Activity activity, Intent intent) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnNewIntent(activity, intent);
            }
        }
        lifecycleCallbacks.dispatchNewInstant(activity, intent);
    }

    public void dispatchOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        }
    }

    boolean dispatchOnKeyEvent(KeyEvent keyEvent) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                if (((BaseActivityLifecycleCallbacks) obj).doOnDispatchKeyEvent(keyEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    void dispatchOnMultiWindowModeChanged(Activity activity, boolean z16) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).onMultiWindowModeChanged(activity, z16);
            }
        }
        lifecycleCallbacks.dispatchOnMultiWindowModeChanged(activity, z16);
    }

    void dispatchOnRestoreInstanceState(Activity activity, Bundle bundle) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).onRestoreInstanceState(activity, bundle);
            }
        }
    }

    void dispatchOnSaveInstanceState(Activity activity, Bundle bundle) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).onSaveInstanceState(activity, bundle);
            }
        }
    }

    void dispatchPreHandleStartActivityForResult(Activity activity, Intent intent, int i3) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).onPreHandleStartActivityForResult(activity, intent, i3);
            }
        }
        lifecycleCallbacks.dispatchPreHandlerStartActivityForResult(activity, intent, i3);
    }

    void dispatchPreSetContentView(View view) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).onPreSetContentView(view);
            }
        }
    }

    void dispatchThemeChanged(Activity activity) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).onPostThemeChanged(activity);
            }
        }
        lifecycleCallbacks.dispatchThemeChanged(activity);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent;
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            dispatchTouchEvent = ((Boolean) iPatchRedirector.redirect((short) 75, (Object) this, (Object) motionEvent)).booleanValue();
        } else {
            injectInterface.dispatchTouchEvent(this, motionEvent);
            if (motionEvent.getAction() == 1) {
                this.clickX = (int) motionEvent.getRawX();
                this.clickY = (int) motionEvent.getRawY();
            }
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // mqq.app.AppActivity
    public boolean doDispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) keyEvent)).booleanValue();
        }
        if (dispatchOnKeyEvent(keyEvent)) {
            return true;
        }
        return super.doDispatchKeyEvent(keyEvent);
    }

    public void doInMultiWindowModeStatusBarVisibilityChange(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, i3);
        }
    }

    @Override // mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        if (!onBackEvent()) {
            try {
                super.doOnBackPressed();
                dispatchOnBackPressed();
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("qqBaseActivity", 2, "", th5);
                }
                finish();
            }
        }
    }

    @Override // mqq.app.AppActivity
    public void doOnConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) configuration);
        } else {
            super.doOnConfigurationChanged(configuration);
            dispatchActivityConfigurationChanged(this, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) bundle)).booleanValue();
        }
        dispatchActivityPreCreated(this, bundle);
        super.doOnCreate(bundle);
        dispatchActivityOnCreate(this, bundle);
        replaceActivityHandler();
        if (QLog.isColorLevel()) {
            QLog.i("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " process id =" + Process.myPid() + " onCreate task : " + getTaskId());
        }
        sActivityRoute.add(getActivityName());
        if (getAppRuntime() != null) {
            setVolumeControlStream(3);
        }
        dispatchActivityPostCreated(this, bundle);
        activityOpenAnimation();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        try {
            Dialog dialog = this.jumpDialog;
            if (dialog != null && dialog.isShowing()) {
                this.jumpDialog.dismiss();
            }
        } catch (Throwable th5) {
            QLog.e("qqBaseActivity", 1, th5, new Object[0]);
        }
        super.doOnDestroy();
        sActivityRoute.remove(getActivityName());
        if (this.mNFCPauseRunnable != null) {
            ThreadManager.getSubThreadHandler().removeCallbacks(this.mNFCPauseRunnable);
            this.mNFCPauseRunnable = null;
        }
        if (this.mNFCResumeRunnable != null) {
            ThreadManager.getSubThreadHandler().removeCallbacks(this.mNFCResumeRunnable);
            this.mNFCResumeRunnable = null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " process id =" + Process.myPid() + " onDestroy task : " + getTaskId());
        }
        dispatchActivityDestroyed(this);
        if (sTopActivity == this) {
            sTopActivity = null;
        }
        this.mTopResumedActivityListener = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) intent);
        } else {
            super.doOnNewIntent(intent);
            dispatchNewInstant(this, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        dispatchActivityPrePaused(this);
        super.doOnPause();
        dispatchActivityOnPause(this);
        dispatchActivityPostPaused(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnRestoreInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) bundle);
        } else {
            super.doOnRestoreInstanceState(bundle);
            dispatchOnRestoreInstanceState(this, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    @TargetApi(9)
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        super.doOnResume();
        sTopActivity = this;
        dispatchActivityPreResumed(this);
        this.currentActivityStayTime = SystemClock.uptimeMillis();
        dispatchActivityResumed(this);
        dispatchActivityPostResumed(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnSaveInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) bundle);
        } else {
            super.doOnSaveInstanceState(bundle);
            dispatchOnSaveInstanceState(this, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        super.doOnStart();
        if (QLog.isColorLevel()) {
            QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " onStart " + Foreground.getActivityCountFromLifecycle(0));
        }
        dispatchActivityStarted(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        super.doOnStop();
        if (QLog.isColorLevel()) {
            QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " onStop " + Foreground.getActivityCountFromLifecycle(2));
        }
        this.mStopFlag = 1;
        dispatchActivityStopped(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else {
            super.doOnWindowFocusChanged(z16);
            dispatchActivityWindowFocusChanged(this, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean enableCheckDensity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            return ((Boolean) iPatchRedirector.redirect((short) 83, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this);
            return;
        }
        try {
            super.finish();
            activityCloseAnimation();
        } catch (Exception unused) {
            QLog.e("qqBaseActivity", 1, "finish error");
        }
    }

    @Deprecated
    public Activity getActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (Activity) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IActivityModuleProvider getActivityModuleProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            return (IActivityModuleProvider) iPatchRedirector.redirect((short) 76, (Object) this);
        }
        if (QBaseActivityInjectUtil.sInjectModuleProviderList.size() > 0) {
            return QBaseActivityInjectUtil.sInjectModuleProviderList.get(0);
        }
        return null;
    }

    public String getActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (String) iPatchRedirector.redirect((short) 63, (Object) this);
        }
        return this.className;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityPropertyProvider getActivityPropertyProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            return (ActivityPropertyProvider) iPatchRedirector.redirect((short) 77, (Object) this);
        }
        return new ActivityPropertyProvider();
    }

    public String getCIOPageName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return (String) iPatchRedirector.redirect((short) 71, (Object) this);
        }
        return getClass().getName();
    }

    public boolean getCanLock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this)).booleanValue();
        }
        return this.mCanLock;
    }

    public String getCurrentAccountUinFromRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (String) iPatchRedirector.redirect((short) 58, (Object) this);
        }
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime == null) {
            return "";
        }
        if (appRuntime instanceof AppInterface) {
            return ((AppInterface) appRuntime).getCurrentAccountUin();
        }
        return appRuntime.getAccount();
    }

    public BroadcastReceiver getDebugUiHierarchyBroadcastReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (BroadcastReceiver) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mDebugUiHierarchyBroadcastReceiver;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getDensity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return ((Float) iPatchRedirector.redirect((short) 78, (Object) this)).floatValue();
        }
        return getResources().getDisplayMetrics().density;
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return (LayoutInflater) iPatchRedirector.redirect((short) 79, (Object) this);
        }
        return getInnerLayoutInflater(super.getLayoutInflater());
    }

    @Override // com.tencent.mobileqq.app.activitymodule.IActivityModuleHub
    public <T extends IActivityModule> T getModule(Class<? extends IActivityModule> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return (T) iPatchRedirector.redirect((short) 64, (Object) this, (Object) cls);
        }
        ActivityModuleHub activityModuleHub = this.activityModuleHub;
        if (activityModuleHub == null) {
            return null;
        }
        return (T) activityModuleHub.getModule(cls);
    }

    public Runnable getNFCResumeRunnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Runnable) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mNFCResumeRunnable;
    }

    public String getPreProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return null;
    }

    @Override // mqq.app.AppActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            return (Resources) iPatchRedirector.redirect((short) 85, (Object) this);
        }
        if (isDelegateResourceEnabled()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                resources = super.getResources();
            } else {
                try {
                    resources = this.currentResource.get();
                    if (resources == null) {
                        Configuration configuration = new Configuration(super.getResources().getConfiguration());
                        configuration.setLocale(new Locale(String.valueOf(Thread.currentThread().getId())));
                        resources = createConfigurationContext(configuration).getResources();
                        this.currentResource.set(resources);
                    }
                } catch (Exception e16) {
                    RFWLog.e("qqBaseActivity", RFWLog.USR, e16.getMessage(), e16);
                    resources = super.getResources();
                }
            }
        } else {
            resources = super.getResources();
        }
        if (enableCheckDensity()) {
            com.tencent.mobileqq.app.displaymetric.a.f195491a.a(resources);
        }
        return resources;
    }

    public Runnable getRunnableRemoveNotification() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Runnable) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.runnableRemoveNotification;
    }

    @Override // mqq.app.AppActivity, android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 57, (Object) this, (Object) str, i3);
        }
        return SharedPreferencesProxyManager.getInstance().getProxy(str, i3);
    }

    public int getStopFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.mStopFlag;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            return iPatchRedirector.redirect((short) 82, (Object) this, (Object) str);
        }
        if ("layout_inflater".equals(str)) {
            Object systemService = super.getSystemService("layout_inflater");
            if (systemService instanceof LayoutInflater) {
                return getInnerLayoutInflater((LayoutInflater) systemService);
            }
        } else if ("connectivity".equals(str)) {
            return MobileQQ.sMobileQQ.getSystemService("connectivity");
        }
        return super.getSystemService(str);
    }

    public int getTitleBarHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this)).intValue();
        }
        return getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    public boolean isAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return ((Boolean) iPatchRedirector.redirect((short) 61, (Object) this)).booleanValue();
        }
        return this.mIsAttachedToWindow;
    }

    public boolean isCanLock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.mCanLock;
    }

    public boolean isCloneInflaterInSubThreadEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            return ((Boolean) iPatchRedirector.redirect((short) 80, (Object) this)).booleanValue();
        }
        return this.isCloneInflaterInSubThread;
    }

    public boolean isDelegateLayoutInflaterEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            return ((Boolean) iPatchRedirector.redirect((short) 81, (Object) this)).booleanValue();
        }
        return this.isEnableDelegateLayoutInflater;
    }

    public boolean isDelegateResourceEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            return ((Boolean) iPatchRedirector.redirect((short) 84, (Object) this)).booleanValue();
        }
        return this.isEnableDelegateResource;
    }

    @TargetApi(24)
    public boolean isInMultiWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return ((Boolean) iPatchRedirector.redirect((short) 65, (Object) this)).booleanValue();
        }
        boolean z16 = false;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                z16 = isInMultiWindowMode();
            } catch (Exception unused) {
            }
        }
        if (QLog.isDebugVersion()) {
            QLog.i("qqBaseActivity", 2, " fight...isInMultiWindowMode = " + z16);
        }
        return z16;
    }

    public boolean isNeedInterruptDoMultiWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return ((Boolean) iPatchRedirector.redirect((short) 70, (Object) this)).booleanValue();
        }
        return false;
    }

    public boolean isNeedMiniMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return ((Boolean) iPatchRedirector.redirect((short) 73, (Object) this)).booleanValue();
        }
        return false;
    }

    public boolean isShowOnFirst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.mShowOnFirst;
    }

    public boolean isSupportScreenShot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this)).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void onAccountChanged() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        super.onAccountChanged();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onAccountChanged ");
            if (getAppRuntime() == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("qqBaseActivity", 2, sb5.toString());
        }
        dispatchAccountChanged(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @TargetApi(24)
    public void onMultiWindowModeChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this, z16);
            return;
        }
        if (z16 && sTopActivity == this && QLog.isDevelopLevel()) {
            QLog.i("qqBaseActivity", 4, "fight..onMultiWindowModeChanged " + getActivityName());
        }
        dispatchOnMultiWindowModeChanged(this, z16);
    }

    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
        } else {
            dispatchThemeChanged(this);
        }
    }

    public void onPreThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
        }
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, (Object) this, z16);
            return;
        }
        super.onTopResumedActivityChanged(z16);
        a aVar = this.mTopResumedActivityListener;
        if (aVar != null) {
            aVar.a(this, z16);
        }
    }

    public void receiveScreenOff() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
        }
    }

    public void registerActivityLifecycleCallbacks(BaseActivityLifecycleCallbacks baseActivityLifecycleCallbacks) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) baseActivityLifecycleCallbacks);
            return;
        }
        synchronized (this.mActivityLifecycleCallbacks) {
            this.mActivityLifecycleCallbacks.add(baseActivityLifecycleCallbacks);
        }
    }

    public void removeObserver(BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) businessObserver);
            return;
        }
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime instanceof AppInterface) {
            ((AppInterface) appRuntime).removeObserver(businessObserver);
        }
    }

    public void setAttachedToWindow(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, z16);
        } else {
            this.mIsAttachedToWindow = z16;
        }
    }

    public void setCanLock(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, z16);
            return;
        }
        if (!z16 && QLog.isColorLevel()) {
            QLog.e("qqBaseActivity", 2, "mCanLock set false", new Throwable());
        }
        this.mCanLock = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentBackgroundResource(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, i3);
        } else {
            findViewById(android.R.id.content).setBackgroundResource(i3);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, (Object) view);
        } else {
            dispatchPreSetContentView(view);
            super.setContentView(view);
        }
    }

    public void setDebugUiHierarchyBroadcastReceiver(BroadcastReceiver broadcastReceiver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) broadcastReceiver);
        } else {
            this.mDebugUiHierarchyBroadcastReceiver = broadcastReceiver;
        }
    }

    public void setJumpDialog(Dialog dialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this, (Object) dialog);
        } else {
            this.jumpDialog = dialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String setLastActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return getString(R.string.button_back);
    }

    public void setNFCResumeRunnable(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) runnable);
        } else {
            this.mNFCResumeRunnable = runnable;
        }
    }

    public void setRunnableRemoveNotification(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) runnable);
        } else {
            this.runnableRemoveNotification = runnable;
        }
    }

    public void setShowOnFirst(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        } else {
            this.mShowOnFirst = z16;
        }
    }

    public void setStopFlag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.mStopFlag = i3;
        }
    }

    public void setTopResumedActivityListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, (Object) this, (Object) aVar);
        } else {
            this.mTopResumedActivityListener = aVar;
        }
    }

    public void setUnitedAnimSetter(IUnitedAnimSetter iUnitedAnimSetter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iUnitedAnimSetter);
        } else {
            this.unitedAnimSetter = iUnitedAnimSetter;
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) intent);
            return;
        }
        injectInterface.startActivity(this, intent);
        IUnitedAnimSetter iUnitedAnimSetter = this.unitedAnimSetter;
        if (iUnitedAnimSetter != null) {
            iUnitedAnimSetter.beforeStartActivity(intent);
        }
        super.startActivity(intent);
        IUnitedAnimSetter iUnitedAnimSetter2 = this.unitedAnimSetter;
        if (iUnitedAnimSetter2 != null) {
            iUnitedAnimSetter2.afterStartActivity();
        }
    }

    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3, Bundle bundle) {
        IUnitedAnimSetter iUnitedAnimSetter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, intent, Integer.valueOf(i3), bundle);
            return;
        }
        IUnitedAnimSetter iUnitedAnimSetter2 = this.unitedAnimSetter;
        if (iUnitedAnimSetter2 != null) {
            iUnitedAnimSetter2.beforeStartActivity(intent);
        }
        if (!injectInterface.startActivityForResult(this, intent, i3, bundle) || (iUnitedAnimSetter = this.unitedAnimSetter) == null) {
            return;
        }
        iUnitedAnimSetter.afterStartActivity();
    }

    public void startActivityForResultOriginal(Intent intent, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, intent, Integer.valueOf(i3), bundle);
            return;
        }
        IUnitedAnimSetter iUnitedAnimSetter = this.unitedAnimSetter;
        if (iUnitedAnimSetter != null) {
            iUnitedAnimSetter.beforeStartActivity(intent);
        }
        super.startActivityForResult(intent, i3, bundle);
        IUnitedAnimSetter iUnitedAnimSetter2 = this.unitedAnimSetter;
        if (iUnitedAnimSetter2 != null) {
            iUnitedAnimSetter2.afterStartActivity();
        }
    }

    public void startUnlockActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("qqBaseActivity", 4, "startUnlockActivity..." + this.className);
        }
        Intent startUnlockActivityIntent = injectInterface.startUnlockActivityIntent(this);
        startUnlockActivityIntent.putExtra("key_gesture_showgesture_valid", false);
        startActivityForResult(startUnlockActivityIntent, 12289);
        mShowGesture = SystemClock.uptimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean themeChangeRightNow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return ((Boolean) iPatchRedirector.redirect((short) 72, (Object) this)).booleanValue();
        }
        return true;
    }

    public void unregisterActivityLifecycleCallbacks(BaseActivityLifecycleCallbacks baseActivityLifecycleCallbacks) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) baseActivityLifecycleCallbacks);
            return;
        }
        synchronized (this.mActivityLifecycleCallbacks) {
            this.mActivityLifecycleCallbacks.remove(baseActivityLifecycleCallbacks);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, i3);
        } else {
            dispatchPreSetContentView(i3);
            super.setContentView(i3);
        }
    }

    public void addObserver(BusinessObserver businessObserver, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, businessObserver, Boolean.valueOf(z16));
            return;
        }
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime instanceof AppInterface) {
            ((AppInterface) appRuntime).addObserver(businessObserver, z16);
        }
    }

    void dispatchPreSetContentView(int i3) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).onPreSetContentView(i3);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) intent, i3);
        } else {
            injectInterface.startActivityForResult(this, intent, i3);
            realStartActivityForResult(intent, i3);
        }
    }

    public void startActivityForResultOriginal(Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) intent, i3);
            return;
        }
        IUnitedAnimSetter iUnitedAnimSetter = this.unitedAnimSetter;
        if (iUnitedAnimSetter != null) {
            iUnitedAnimSetter.beforeStartActivity(intent);
        }
        super.startActivityForResult(intent, i3);
        IUnitedAnimSetter iUnitedAnimSetter2 = this.unitedAnimSetter;
        if (iUnitedAnimSetter2 != null) {
            iUnitedAnimSetter2.afterStartActivity();
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) intent, (Object) bundle);
            return;
        }
        injectInterface.startActivity(this, intent, bundle);
        IUnitedAnimSetter iUnitedAnimSetter = this.unitedAnimSetter;
        if (iUnitedAnimSetter != null) {
            iUnitedAnimSetter.beforeStartActivity(intent);
        }
        super.startActivity(intent, bundle);
        IUnitedAnimSetter iUnitedAnimSetter2 = this.unitedAnimSetter;
        if (iUnitedAnimSetter2 != null) {
            iUnitedAnimSetter2.afterStartActivity();
        }
    }
}
