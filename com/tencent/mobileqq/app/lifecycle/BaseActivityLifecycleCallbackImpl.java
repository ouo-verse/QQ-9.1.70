package com.tencent.mobileqq.app.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.qfileJumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.identity.IAccountApi;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.w;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ei;
import com.tencent.mobileqq.utils.m;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qlink.QlinkBridgeActivity;
import cooperation.qlink.QlinkShareJumpActivity;
import cooperation.qqfav.widget.QfavJumpActivity;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BaseActivityLifecycleCallbackImpl extends DefaultBaseActivityLifecycleCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    boolean f195821d;

    public BaseActivityLifecycleCallbackImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f195821d = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("account_api_impl_foreground_anr_bugfix", true);
        }
    }

    private boolean h() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("open_sdk_forbid_gesture_lock", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(String str) {
        ((IAccountApi) QRoute.api(IAccountApi.class)).setForegroundANRBugfixSwitch(true);
        if ((!QBaseActivity.mAppForground || ((IAccountApi) QRoute.api(IAccountApi.class)).isIdentityFirstInit()) && !TextUtils.isEmpty(str)) {
            ((IAccountApi) QRoute.api(IAccountApi.class)).onForegroundSwitch();
        }
    }

    private void j(QBaseActivity qBaseActivity) {
        String a16 = BridgeHelper.b(qBaseActivity, qBaseActivity.getCurrentAccountUinFromRuntime()).a("buscard_registerNFC");
        if (TextUtils.isEmpty(a16) || "true".equals(a16)) {
            Runnable nFCResumeRunnable = qBaseActivity.getNFCResumeRunnable();
            if (nFCResumeRunnable != null) {
                try {
                    ThreadManager.getSubThreadHandler().removeCallbacks(nFCResumeRunnable);
                } catch (Throwable unused) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("qqBaseActivity", 4, "registerNFCEvent failed");
                        return;
                    }
                    return;
                }
            }
            Runnable runnable = new Runnable(qBaseActivity) { // from class: com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbackImpl.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QBaseActivity f195824d;

                {
                    this.f195824d = qBaseActivity;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseActivityLifecycleCallbackImpl.this, (Object) qBaseActivity);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        ActivityLifecycle.onResume(this.f195824d);
                    }
                }
            };
            qBaseActivity.setNFCResumeRunnable(runnable);
            ThreadManager.getSubThreadHandler().post(runnable);
        }
    }

    private void k(QBaseActivity qBaseActivity) {
        final String currentAccountUinFromRuntime = qBaseActivity.getCurrentAccountUinFromRuntime();
        ILoginRegisterApi iLoginRegisterApi = (ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class);
        if ((!QBaseActivity.mAppForground || (MobileQQ.PACKAGE_NAME.equals(MobileQQ.processName) && !QBaseActivity.isUnLockSuccess)) && qBaseActivity.getCanLock() && currentAccountUinFromRuntime != null && BaseGesturePWDUtil.getJumpLock(qBaseActivity, currentAccountUinFromRuntime) && !(qBaseActivity instanceof GesturePWDUnlockActivity) && !(qBaseActivity instanceof UserguideActivity) && !(qBaseActivity instanceof JumpActivity) && !(qBaseActivity instanceof qfileJumpActivity) && !(qBaseActivity instanceof QfavJumpActivity) && ((!(qBaseActivity instanceof AgentActivity) || !h()) && !iLoginRegisterApi.getLoginActivityClass().isInstance(qBaseActivity) && !(qBaseActivity instanceof QlinkBridgeActivity) && !(qBaseActivity instanceof QlinkShareJumpActivity))) {
            qBaseActivity.startUnlockActivity();
        } else if (!QBaseActivity.mAppForground && qBaseActivity.isCanLock()) {
            qBaseActivity.checkUnlockForSpecial();
        } else if (!QBaseActivity.mAppForground && !qBaseActivity.isCanLock()) {
            QBaseActivity.isUnLockSuccess = true;
        }
        if (this.f195821d) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.lifecycle.a
                @Override // java.lang.Runnable
                public final void run() {
                    BaseActivityLifecycleCallbackImpl.i(currentAccountUinFromRuntime);
                }
            }, 16, null, false);
        } else {
            ((IAccountApi) QRoute.api(IAccountApi.class)).setForegroundANRBugfixSwitch(false);
            if ((!QBaseActivity.mAppForground || ((IAccountApi) QRoute.api(IAccountApi.class)).isIdentityFirstInit()) && !TextUtils.isEmpty(currentAccountUinFromRuntime)) {
                ((IAccountApi) QRoute.api(IAccountApi.class)).onForegroundSwitch();
            }
        }
        if (!QBaseActivity.mAppForground && !(qBaseActivity instanceof JumpActivity)) {
            QBaseActivity.mAppForground = true;
            GesturePWDUtils.setAppForground(qBaseActivity, true);
        }
        qBaseActivity.setStopFlag(0);
        qBaseActivity.setCanLock(true);
    }

    private void l(QBaseActivity qBaseActivity) {
        String a16 = BridgeHelper.b(qBaseActivity, qBaseActivity.getCurrentAccountUinFromRuntime()).a("buscard_registerNFC");
        if (TextUtils.isEmpty(a16) || "true".equals(a16)) {
            try {
                Runnable nFCResumeRunnable = qBaseActivity.getNFCResumeRunnable();
                if (nFCResumeRunnable != null) {
                    ThreadManager.getSubThreadHandler().removeCallbacks(nFCResumeRunnable);
                }
                Runnable runnable = new Runnable(new WeakReference(qBaseActivity)) { // from class: com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbackImpl.3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ WeakReference f195825d;

                    {
                        this.f195825d = r5;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseActivityLifecycleCallbackImpl.this, (Object) r5);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        QBaseActivity qBaseActivity2 = (QBaseActivity) this.f195825d.get();
                        if (qBaseActivity2 != null && !qBaseActivity2.isFinishing()) {
                            ActivityLifecycle.onPause(qBaseActivity2);
                        }
                    }
                };
                qBaseActivity.setNFCResumeRunnable(nFCResumeRunnable);
                ThreadManager.getSubThreadHandler().post(runnable);
            } catch (Throwable unused) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("qqBaseActivity", 4, "disableNFCEvent failed");
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityCreate(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        com.tencent.qqperf.monitor.crash.tools.b.f(activity);
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).updateAppRuntime();
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityDestroyed(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity);
            return;
        }
        if (activity instanceof QBaseActivity) {
            com.tencent.qqperf.monitor.crash.tools.b.g(activity);
            ((IAccountApi) QRoute.api(IAccountApi.class)).onActivityDestroy(activity);
            QBaseActivity qBaseActivity = (QBaseActivity) activity;
            AppRuntime appRuntime = qBaseActivity.getAppRuntime();
            if (appRuntime instanceof AppInterface) {
                ((AppInterface) appRuntime).removeHandler(activity.getClass());
            }
            g(qBaseActivity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityOnStart(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            com.tencent.mobileqq.managers.d.b(activity.getIntent());
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPause(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
            return;
        }
        if (activity instanceof QBaseActivity) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder(256);
                sb5.append("[");
                sb5.append(activity.hashCode());
                sb5.append("]");
                sb5.append(activity.getClass().getSimpleName());
                sb5.append(" onPause HeapAlloc=");
                sb5.append(Runtime.getRuntime().totalMemory() / 1024);
                sb5.append(" KB HeapFree=");
                sb5.append(Runtime.getRuntime().freeMemory() / 1024);
                sb5.append(" KB");
                QLog.d("qqBaseActivity", 2, sb5.toString());
            }
            l((QBaseActivity) activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPostCreated(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        ei.a("Main_base_create", null);
        if (activity instanceof QBaseActivity) {
            f((QBaseActivity) activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPreCreated(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
        } else {
            ei.a(null, "Main_base_create");
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPrePaused(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
        } else {
            com.tencent.qqperf.monitor.crash.tools.b.h(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPreResumed(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            com.tencent.qqperf.monitor.crash.tools.b.i(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityResume(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
            return;
        }
        if (activity instanceof QBaseActivity) {
            if (!((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).isBlockNotifyActivity(activity)) {
                com.tencent.biz.qrcode.logindev.pclock.b.f94950a.c();
            }
            com.tencent.biz.qrcode.logindev.pclock.b bVar = com.tencent.biz.qrcode.logindev.pclock.b.f94950a;
            if (bVar.d()) {
                bVar.b();
            }
            if (!((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).isBlockNotifyActivity(activity)) {
                EquipmentLockImpl.o().i();
            }
            if (EquipmentLockImpl.f205331x) {
                EquipmentLockImpl.o().h();
            }
            QBaseActivity.mAppForground = BaseGesturePWDUtil.getAppForground(activity);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder(256);
                sb5.append("[");
                sb5.append(hashCode());
                sb5.append("]");
                sb5.append(activity.getClass().getSimpleName());
                sb5.append(" onQResume .mAppForground = ");
                sb5.append(QBaseActivity.mAppForground);
                sb5.append(" isUnLockSuccess = ");
                sb5.append(QBaseActivity.isUnLockSuccess);
                sb5.append(",mCanLock=");
                sb5.append(((QBaseActivity) activity).getCanLock());
                sb5.append(" HeapAlloc=");
                sb5.append(Runtime.getRuntime().totalMemory() / 1024);
                sb5.append(" KB HeapFree=");
                sb5.append(Runtime.getRuntime().freeMemory() / 1024);
                sb5.append(" KB HeapMax=");
                sb5.append(Runtime.getRuntime().maxMemory() / 1024);
                sb5.append(" KB");
                QLog.d("qqBaseActivity", 2, sb5.toString());
            }
            if (QBaseActivity.mAppBackgroundTime > 0) {
                w.e(SystemClock.elapsedRealtime() - QBaseActivity.mAppBackgroundTime);
            }
            QBaseActivity.mAppBackgroundTime = 0L;
            QBaseActivity qBaseActivity = (QBaseActivity) activity;
            k(qBaseActivity);
            ((IAccountApi) QRoute.api(IAccountApi.class)).onActivityResume(activity);
            GuardManager guardManager = GuardManager.sInstance;
            if (guardManager != null) {
                guardManager.onEvent(1, qBaseActivity.getPreProcess());
            }
            j(qBaseActivity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityStopped(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
            return;
        }
        if (activity instanceof QBaseActivity) {
            QBaseActivity qBaseActivity = (QBaseActivity) activity;
            boolean isAppOnForegroundByTasks = BaseGesturePWDUtil.isAppOnForegroundByTasks(qBaseActivity, 2);
            QBaseActivity.mAppForground = isAppOnForegroundByTasks;
            if (!isAppOnForegroundByTasks) {
                GesturePWDUtils.setAppForground(qBaseActivity, isAppOnForegroundByTasks);
                QBaseActivity.isUnLockSuccess = false;
                QBaseActivity.mAppBackgroundTime = SystemClock.elapsedRealtime();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnNewIntent(Activity activity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) activity, (Object) intent);
            return;
        }
        if (26 <= Build.VERSION.SDK_INT) {
            GlobalDisplayMetricsManager.adjustDisplayMetrics(activity);
            FontSettingManager.resetFontIfNeeded(activity, true, false);
        }
        if (intent != null) {
            ActivityLifecycle.onNewIntent(activity, intent);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0095  */
    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doOnWindowFocusChanged(Activity activity, boolean z16) {
        boolean isNeedStatusBarGone;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, activity, Boolean.valueOf(z16));
            return;
        }
        if (activity instanceof QBaseActivity) {
            QBaseActivity qBaseActivity = (QBaseActivity) activity;
            AppRuntime appRuntime = qBaseActivity.getAppRuntime();
            if (appRuntime instanceof QQAppInterface) {
                QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
                if (z16) {
                    try {
                        if (com.tencent.mobileqq.startup.a.f289668i && !m.b().equalsIgnoreCase("Xiaomi-MI 5")) {
                            if (QLog.isColorLevel()) {
                                QLog.d("notification", 2, "BaseActivity doOnWindowFocusChanged removeNotification");
                            }
                            qQAppInterface.removeNotification();
                            if (qBaseActivity.isNeedInterruptDoMultiWindow() && !qBaseActivity.isAttachedToWindow() && qBaseActivity.isInMultiWindow()) {
                                isNeedStatusBarGone = SystemBarActivityModule.isNeedStatusBarGone(qBaseActivity);
                                if (SystemBarActivityModule.getSystemBarComp(qBaseActivity) != null && SystemBarActivityModule.getSystemBarComp(qBaseActivity).isStatusBarVisible == isNeedStatusBarGone) {
                                    if (isNeedStatusBarGone) {
                                        i3 = 0;
                                    }
                                    SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarVisible(i3, 0);
                                    ((SystemBarActivityModule) qBaseActivity.getModule(SystemBarActivityModule.class)).setStatusBarVisibility(i3);
                                    qBaseActivity.doInMultiWindowModeStatusBarVisibilityChange(i3);
                                }
                            }
                            qBaseActivity.setAttachedToWindow(true);
                            return;
                        }
                        Runnable runnableRemoveNotification = qBaseActivity.getRunnableRemoveNotification();
                        if (runnableRemoveNotification == null) {
                            runnableRemoveNotification = new Runnable(qBaseActivity, qQAppInterface) { // from class: com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbackImpl.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ QBaseActivity f195822d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ QQAppInterface f195823e;

                                {
                                    this.f195822d = qBaseActivity;
                                    this.f195823e = qQAppInterface;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, this, BaseActivityLifecycleCallbackImpl.this, qBaseActivity, qQAppInterface);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    if (this.f195822d.getRunnableRemoveNotification() != null) {
                                        this.f195822d.setRunnableRemoveNotification(null);
                                        if (this.f195823e != null) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("notification", 2, "BaseActivity doOnWindowFocusChanged removeNotification Xiaomi-MI 5");
                                            }
                                            this.f195823e.removeNotification();
                                        }
                                    }
                                }
                            };
                            qBaseActivity.setRunnableRemoveNotification(runnableRemoveNotification);
                        }
                        ThreadManager.getUIHandler().postDelayed(runnableRemoveNotification, 3000L);
                        if (qBaseActivity.isNeedInterruptDoMultiWindow()) {
                            isNeedStatusBarGone = SystemBarActivityModule.isNeedStatusBarGone(qBaseActivity);
                            if (SystemBarActivityModule.getSystemBarComp(qBaseActivity) != null) {
                                if (isNeedStatusBarGone) {
                                }
                                SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarVisible(i3, 0);
                                ((SystemBarActivityModule) qBaseActivity.getModule(SystemBarActivityModule.class)).setStatusBarVisibility(i3);
                                qBaseActivity.doInMultiWindowModeStatusBarVisibilityChange(i3);
                            }
                        }
                        qBaseActivity.setAttachedToWindow(true);
                        return;
                    } catch (Throwable unused) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("qqBaseActivity", 4, "doOnWindowFocusChanged failed");
                            return;
                        }
                        return;
                    }
                }
                Runnable runnableRemoveNotification2 = qBaseActivity.getRunnableRemoveNotification();
                if (runnableRemoveNotification2 != null) {
                    ThreadManager.getUIHandler().removeCallbacks(runnableRemoveNotification2);
                    qBaseActivity.setRunnableRemoveNotification(null);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onAccountChanged(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) activity);
        } else if (activity instanceof QBaseActivity) {
            AppRuntime appRuntime = ((QBaseActivity) activity).getAppRuntime();
            if (appRuntime instanceof QQAppInterface) {
                ((QQAppInterface) appRuntime).cancelSyncOnlineFriend(0L);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onMultiWindowModeChanged(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, activity, Boolean.valueOf(z16));
            return;
        }
        if (activity instanceof QBaseActivity) {
            if (z16 && QBaseActivity.sTopActivity == activity && z16 && Build.VERSION.SDK_INT >= 24) {
                AppRuntime appRuntime = ((QBaseActivity) activity).getAppRuntime();
                if (appRuntime instanceof QQAppInterface) {
                    ReportController.r((QQAppInterface) appRuntime, "dc00898", "", "", "0X800859D", "0X800859D", 0, 0, "", "", "", "");
                }
                StatisticCollector.getInstance(activity).collectPerformance(null, "MulitScreenMode", z16, 0L, 0L, null, null);
            }
            GlobalDisplayMetricsManager.adjustDisplayMetrics(activity);
            FontSettingManager.resetFontIfNeeded(activity, true, false);
        }
    }

    private void f(QBaseActivity qBaseActivity) {
    }

    private void g(QBaseActivity qBaseActivity) {
    }
}
