package com.tencent.mobileqq.mini;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseMiniAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.fake.FakeSdkBrandUI;
import com.tencent.mobileqq.mini.network.RequestStrategy;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.l;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.webview.swift.cookie.c;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import mqq.app.Constants;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppInterface extends BaseMiniAppInterface {
    public static final String ACTION_MINI_PROCESS_EXIT = "com.tencent.mobile.mini.process.exit";
    private static final String ACTION_PROCESS_EXIT = "com.tencent.process.exit";
    static final String TAG = "MiniAppInterface";
    private BroadcastReceiver accountReceiver;
    private HashMap<String, AuthorizeCenter> authorizeMap;
    private EntityManagerFactory mFactory;
    private List<Activity> mForegroundActivitys;
    private long mMiniAppLastUseTimeStamp;

    public MiniAppInterface(BaseApplicationImpl baseApplicationImpl, String str) {
        super(baseApplicationImpl, str);
        this.authorizeMap = new HashMap<>();
        this.mForegroundActivitys = new ArrayList();
        this.accountReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.mini.MiniAppInterface.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent == null || intent.getAction() == null) {
                    return;
                }
                String action = intent.getAction();
                if (QLog.isColorLevel()) {
                    QLog.w(MiniAppInterface.TAG, 2, "accountReceiver.onReceive broacast action=" + action);
                }
                if ("com.tencent.process.exit".equals(action)) {
                    QLog.w(MiniAppInterface.TAG, 2, "accountReceiver.onReceive no exit!");
                    return;
                }
                if (!NewIntent.ACTION_ACCOUNT_CHANGED.equals(action) && !NewIntent.ACTION_ACCOUNT_KICKED.equals(action) && !NewIntent.ACTION_LOGOUT.equals(action)) {
                    if (!("mqq.intent.action.EXIT_" + ((AppInterface) MiniAppInterface.this).app.getPackageName()).equals(action)) {
                        if (NewIntent.ACTION_ACCOUNT_EXPIRED.equals(action)) {
                            c.h(1);
                            if (MiniAppInterface.this.isLogin()) {
                                QLog.w(MiniAppInterface.TAG, 2, "user was logined in, not exit.");
                                MiniAppInterface.this.exitProcess();
                                return;
                            } else {
                                QLog.w(MiniAppInterface.TAG, 2, "user was not logined in, not exit.");
                                return;
                            }
                        }
                        if (MiniAppInterface.ACTION_MINI_PROCESS_EXIT.equals(action)) {
                            QLog.w(MiniAppInterface.TAG, 2, "ACTION_MINI_PROCESS_EXIT.onReceive exit!");
                            MiniAppInterface.this.exitProcess();
                            return;
                        }
                        return;
                    }
                }
                c.h(1);
                MiniAppInterface.this.exitProcess();
            }
        };
    }

    private void initSuperPlayer() {
        try {
            if (QQVideoPlaySDKManager.isSDKReady()) {
                return;
            }
            QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getApplication(), new SDKInitListener() { // from class: com.tencent.mobileqq.mini.MiniAppInterface.4
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public void onSDKInited(boolean z16) {
                    if (!z16) {
                        QLog.e(MiniAppInterface.TAG, 1, "initSDKAsync failed!");
                    } else {
                        QLog.d(MiniAppInterface.TAG, 1, "initSDKAsync succeed!");
                    }
                }
            });
            QLog.d(TAG, 1, "superplayer not ready !");
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "initSuperplayer failed", th5);
        }
    }

    private boolean isMiniAppUsed() {
        return System.currentTimeMillis() - this.mMiniAppLastUseTimeStamp < TimeUnit.MINUTES.toMillis(60L);
    }

    private void registerAccountReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        intentFilter.addAction("mqq.intent.action.EXIT_" + this.app.getPackageName());
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_EXPIRED);
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        intentFilter.addAction("com.tencent.process.exit");
        intentFilter.addAction(ACTION_MINI_PROCESS_EXIT);
        this.app.registerReceiver(this.accountReceiver, intentFilter);
    }

    public void exitProcess() {
        try {
            this.app.unregisterReceiver(this.accountReceiver);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        QLog.d(TAG, 1, "Kill process " + this.app.getPackageName());
        SystemMethodProxy.killProcess(Process.myPid());
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public BaseApplication getApp() {
        return this.app;
    }

    @Override // com.tencent.common.app.AppInterface
    public int getAppid() {
        return AppSetting.f();
    }

    public AuthorizeCenter getAuthorizeCenter(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!this.authorizeMap.containsKey(str)) {
            synchronized (this.authorizeMap) {
                if (!this.authorizeMap.containsKey(str)) {
                    this.authorizeMap.put(str, new AuthorizeCenter(str, getCurrentAccountUin()));
                }
            }
        }
        return this.authorizeMap.get(str);
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        return getAccount();
    }

    @Override // com.tencent.common.app.AppInterface
    public String getCurrentNickname() {
        return BaseApplicationImpl.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + getAccount());
    }

    @Override // mqq.app.AppRuntime
    public EntityManagerFactory getEntityManagerFactory(String str) {
        if (this.mFactory == null) {
            this.mFactory = l.d(getAccount(), super.getEntityManagerFactory());
        }
        return this.mFactory;
    }

    @Override // mqq.app.AppRuntime
    public String getModuleId() {
        return "mini";
    }

    @Override // mqq.app.AppRuntime
    public boolean isProcessIdle() {
        this.mMiniAppLastUseTimeStamp = MiniAppLauncher.getLastMiniAppUsedTime();
        boolean z16 = !isMiniAppUsed();
        QLog.d(TAG, 1, "isProcessIdle =" + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QLog.i("miniapp-start", 1, "MiniAppInterface onCreate");
        Thread.setDefaultUncaughtExceptionHandler(new MiniCrashHandler());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.MiniAppInterface.1
            @Override // java.lang.Runnable
            public void run() {
                FakeSdkBrandUI.setCookie();
                FakeSdkBrandUI.initOKHttpClient();
            }
        }, 16, null, true);
        AppLoaderFactory.setMiniAppInterface(this);
        registerAccountReceiver();
        getApp().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.tencent.mobileqq.mini.MiniAppInterface.2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                QLog.e("mini_ActivityLifecycle", 1, "onActivityPaused " + activity.getClass().getSimpleName());
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (MiniAppInterface.this.mForegroundActivitys.contains(activity)) {
                    return;
                }
                MiniAppInterface.this.mForegroundActivitys.add(activity);
                if (MiniAppInterface.this.mForegroundActivitys.size() == 1) {
                    MiniAppInterface.this.onEnterForeground();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                MiniAppInterface.this.mForegroundActivitys.remove(activity);
                if (MiniAppInterface.this.mForegroundActivitys.size() == 0) {
                    MiniAppInterface.this.onEnterBackground();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle2) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
            }
        });
        initSuperPlayer();
        RequestStrategy.f246656g.notifyNetWorkStatusChange();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Application OnCreate complete");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onDestroy() {
        super.onDestroy();
        MiniAppController.getInstance().onDestory();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        synchronized (this.authorizeMap) {
            this.authorizeMap.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onRunningBackground() {
        super.onRunningBackground();
        LpReportManager.getInstance().startReportImediately(2);
    }

    protected void onEnterBackground() {
        QLog.e("miniapp-start", 1, "onEnterBackground ");
    }

    protected void onEnterForeground() {
        QLog.e("miniapp-start", 1, "onEnterForeground ");
    }

    @Override // mqq.app.AppRuntime
    public void preExit() {
        QLog.d(TAG, 1, "preExit");
        MiniAppLauncher.markMiniAppUsed(0L);
    }

    public void exitApp(boolean z16) {
        if (z16) {
            try {
                System.exit(0);
                SystemMethodProxy.killProcess(Process.myPid());
            } catch (Throwable unused) {
                System.exit(-1);
            }
        }
    }
}
