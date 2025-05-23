package cooperation.qwallet.plugin;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.qwallet.activity.patternlock.PatternLockActivity;
import com.qwallet.temp.IQWalletApiProxy;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityForTool;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.base.c;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.ToggleConfig;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.qwallet.utils.f;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.sdk.activity.ConfirmTransactionActivity;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;
import java.lang.ref.WeakReference;
import mqq.app.Constants;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QWalletToolFragmentActivity extends QPublicTransFragmentActivityForTool implements IActivity, ql2.a {
    private static final String TAG = "QWalletPluginProxyActivity";
    private static Boolean mDisableSetBundleClassLoader = null;
    protected static long mQWalletPLockBgIntervalTime = -1;
    private long lastTipsTime;
    protected long mQWalletPLockLastBgTime;
    protected MyBroadcastReceiver myReceiver;
    protected TouchEventReceiver touchEventReceiver;
    protected TouchEventStartReceiver touchEventStartReceiver;
    protected boolean mIsStop = false;
    protected boolean mIsPause = false;
    protected boolean mIsStartTouchEvent = false;
    protected long mResumeStartTime = 0;
    private final ql2.b mActivityMonitor = new ql2.b();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class MyBroadcastReceiver extends BroadcastReceiver {
        MyBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action;
            if (intent != null && (action = intent.getAction()) != null && action.equals(IActivity.ACTION_QWALLET_PATTERN_LOCK_COLSEALL)) {
                QWalletToolFragmentActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    protected static class TouchEventReceiver extends BroadcastReceiver {
        private WeakReference<QWalletToolFragmentActivity> activityWeakReference;

        public TouchEventReceiver(QWalletToolFragmentActivity qWalletToolFragmentActivity) {
            this.activityWeakReference = new WeakReference<>(qWalletToolFragmentActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            KeyEvent keyEvent;
            QWalletToolFragmentActivity qWalletToolFragmentActivity = this.activityWeakReference.get();
            if (qWalletToolFragmentActivity != null && intent != null && !qWalletToolFragmentActivity.isFinishing() && !qWalletToolFragmentActivity.mIsStop) {
                String action = intent.getAction();
                if (IActivity.ACTION_TOUCH_EVENT.equals(action)) {
                    MotionEvent motionEvent = (MotionEvent) intent.getParcelableExtra(IActivity.EXTRA_KEY_EVENT);
                    if (motionEvent != null) {
                        qWalletToolFragmentActivity.dispatchTouchEvent(motionEvent);
                        return;
                    }
                    return;
                }
                if (IActivity.ACTION_KEY_EVENT.equals(action) && (keyEvent = (KeyEvent) intent.getParcelableExtra(IActivity.EXTRA_KEY_EVENT)) != null) {
                    qWalletToolFragmentActivity.dispatchKeyEvent(keyEvent);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class TouchEventStartReceiver extends BroadcastReceiver {
        private WeakReference<QWalletToolFragmentActivity> activityWeakReference;

        public TouchEventStartReceiver(QWalletToolFragmentActivity qWalletToolFragmentActivity) {
            this.activityWeakReference = new WeakReference<>(qWalletToolFragmentActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            QWalletToolFragmentActivity qWalletToolFragmentActivity = this.activityWeakReference.get();
            if (qWalletToolFragmentActivity != null && qWalletToolFragmentActivity.getFragment() != null && intent != null && !qWalletToolFragmentActivity.isFinishing() && !qWalletToolFragmentActivity.mIsStop && !(qWalletToolFragmentActivity.getFragment() instanceof QWalletBaseFragment) && IActivity.ACTION_TOUCH_START.equals(intent.getAction())) {
                try {
                    String stringExtra = intent.getStringExtra("url");
                    if (TextUtils.isEmpty(stringExtra)) {
                        return;
                    }
                    qWalletToolFragmentActivity.mIsStartTouchEvent = true;
                    ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).openUrl(qWalletToolFragmentActivity.getFragment(), stringExtra);
                    if (qWalletToolFragmentActivity.touchEventReceiver == null) {
                        qWalletToolFragmentActivity.touchEventReceiver = new TouchEventReceiver(qWalletToolFragmentActivity);
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction(IActivity.ACTION_TOUCH_EVENT);
                        qWalletToolFragmentActivity.registerReceiver(qWalletToolFragmentActivity.touchEventReceiver, intentFilter);
                    }
                } catch (Exception e16) {
                    QLog.e(QWalletToolFragmentActivity.TAG, 1, "", e16);
                }
            }
        }
    }

    private void addReportInfoFromIntent(long j3) {
        long j16;
        String str;
        Intent intent = getIntent();
        if (intent == null) {
            f.a(TAG, "intent is null");
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras.containsKey(IQWalletHelper.EXTRA_LAUNCH_TIME)) {
            j16 = extras.getLong(IQWalletHelper.EXTRA_LAUNCH_TIME);
        } else {
            j16 = j3;
        }
        addReportParam(3, Long.valueOf(j3 - j16));
        addReportParam(1, getClass().getCanonicalName());
        QPublicBaseFragment fragment = getFragment();
        String str2 = "unknown";
        if (fragment == null) {
            str = "unknown";
        } else {
            str = fragment.getClass().getCanonicalName();
        }
        addReportParam(2, str);
        if (extras.containsKey(IQWalletHelper.EXTRA_FROM_ACTIVITY)) {
            str2 = extras.getString(IQWalletHelper.EXTRA_FROM_ACTIVITY);
        }
        addReportParam(0, str2);
        f.a(TAG, "launchTime, " + j16 + ", fromActivity," + str2);
    }

    private boolean enablePatternLock() {
        boolean enableGestureLock = BaseGesturePWDUtil.enableGestureLock(this);
        Bundle innerBundle = getInnerBundle();
        if (innerBundle != null && !enableGestureLock) {
            if (innerBundle.getBoolean(IActivity.PARAM_DISABLE_PATTERN_LOCK, false)) {
                return false;
            }
            return innerBundle.getBoolean(IActivity.PARAM_IS_USE_QWALLET_PATTERN_LOCK, false);
        }
        return enableGestureLock;
    }

    private void fixCrashWhenParcelBundle(Bundle bundle) {
        if (bundle != null && !ToggleConfig.c()) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 == 29 || i3 == 28) {
                bundle.setClassLoader(getClassLoader());
            }
        }
    }

    private void handleCrash(Bundle bundle, Throwable th5) {
        StringBuilder sb5 = new StringBuilder(256);
        if (th5 != null) {
            sb5.append(th5.toString());
            if (th5.getStackTrace() != null) {
                StackTraceElement[] stackTrace = th5.getStackTrace();
                for (int i3 = 0; i3 < stackTrace.length && i3 < 16; i3++) {
                    sb5.append("\n ");
                    sb5.append(stackTrace[i3].toString());
                }
            }
        }
        VACDReportUtil.a(APMidasPayAPI.PAY_CHANNEL_QQWALLET, "crash", "Catch", null, 668814, sb5.toString());
    }

    public static void handleNoCatchCrash(String str) {
        if (!TextUtils.isEmpty(str) && QWalletHelperDelegate.sEnterQWalletPluginCount > 0) {
            QWalletHelperDelegate.sEnterQWalletPluginCount = 0;
            VACDReportUtil.a(APMidasPayAPI.PAY_CHANNEL_QQWALLET, "crash", "NoCatch", null, 668815, str);
        }
    }

    private void initPatterLock() {
        boolean z16;
        try {
            Bundle innerBundle = getInnerBundle();
            if (innerBundle != null) {
                if (mQWalletPLockBgIntervalTime < 0) {
                    mQWalletPLockBgIntervalTime = innerBundle.getLong(IActivity.PARAM_QWALLET_PLOCK_BG_INTVERAL_TIME, -1L);
                }
                z16 = innerBundle.getBoolean(IActivity.PARAM_IS_USE_QWALLET_PATTERN_LOCK, false);
            } else {
                z16 = false;
            }
            if (!z16) {
                getIntent().getBooleanExtra(IActivity.PARAM_IS_USE_QWALLET_PATTERN_LOCK, false);
            }
            if (mQWalletPLockBgIntervalTime < 0) {
                mQWalletPLockBgIntervalTime = getIntent().getLongExtra(IActivity.PARAM_QWALLET_PLOCK_BG_INTVERAL_TIME, -1L);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "qwallet read data exception.", e16);
            }
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "qwallet read data exception.", e17);
            }
            if (QLog.isColorLevel()) {
                QLog.e("initPatterLock", 2, "OutOfMemoryError");
            }
        }
        try {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cooperation.qwallet.plugin.b
                @Override // java.lang.Runnable
                public final void run() {
                    QWalletToolFragmentActivity.this.lambda$initPatterLock$1();
                }
            });
        } catch (Exception e18) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "register exception.", e18);
            }
        }
    }

    private boolean isPatternLockOpened() {
        Bundle innerBundle = getInnerBundle();
        if (innerBundle != null) {
            if (innerBundle.getBoolean(IActivity.PARAM_DISABLE_PATTERN_LOCK, false)) {
                return false;
            }
            if (innerBundle.getBoolean(IActivity.PARAM_IS_USE_QWALLET_PATTERN_LOCK, false)) {
                return true;
            }
        }
        return ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getJumpLock(this, getCurrentAccountUinFromRuntime());
    }

    private boolean isStackLocked(ActivityManager activityManager) throws Exception {
        Class<?> cls = Class.forName("android.app.ActivityManager");
        int i3 = cls.getDeclaredField("LOCK_TASK_MODE_NONE").getInt(ActivityManager.class);
        Object invoke = cls.getDeclaredMethod("getLockTaskModeState", new Class[0]).invoke(activityManager, new Object[0]);
        if (invoke == null || !(invoke instanceof Integer) || ((Integer) invoke).intValue() == i3) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doOnCreate$0() {
        this.touchEventStartReceiver = new TouchEventStartReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IActivity.ACTION_TOUCH_START);
        registerReceiver(this.touchEventStartReceiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPatterLock$1() {
        this.myReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IActivity.ACTION_QWALLET_PATTERN_LOCK_COLSEALL);
        registerReceiver(this.myReceiver, intentFilter);
    }

    private void tryParseExtraFromQvipPayBridge() {
        getIntent();
    }

    @Override // ql2.a
    public void addReportParam(int i3, @NonNull Object obj) {
        this.mActivityMonitor.addReportParam(i3, obj);
    }

    @Override // com.tencent.mobileqq.activity.QPublicTransFragmentActivityForTool, com.tencent.mobileqq.activity.QPublicFragmentActivityForTool, com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        Bundle bundle2;
        try {
            long now = now();
            super.doOnCreate(bundle);
            tryParseExtraFromQvipPayBridge();
            addReportInfoFromIntent(now);
            initPatterLock();
            if (getFragment() != null) {
                try {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cooperation.qwallet.plugin.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            QWalletToolFragmentActivity.this.lambda$doOnCreate$0();
                        }
                    });
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "", e16);
                }
            }
            long now2 = now() - now;
            addReportParam(4, Long.valueOf(now2));
            f.a(TAG, "createCost " + now2);
            return true;
        } catch (Exception e17) {
            Intent intent = getIntent();
            if (intent != null) {
                bundle2 = intent.getExtras();
            } else {
                bundle2 = null;
            }
            handleCrash(bundle2, e17);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        try {
            TouchEventReceiver touchEventReceiver = this.touchEventReceiver;
            if (touchEventReceiver != null) {
                unregisterReceiver(touchEventReceiver);
                this.touchEventReceiver = null;
            }
            MyBroadcastReceiver myBroadcastReceiver = this.myReceiver;
            if (myBroadcastReceiver != null) {
                unregisterReceiver(myBroadcastReceiver);
                this.myReceiver = null;
            }
            TouchEventStartReceiver touchEventStartReceiver = this.touchEventStartReceiver;
            if (touchEventStartReceiver != null) {
                unregisterReceiver(touchEventStartReceiver);
                this.touchEventStartReceiver = null;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        this.mIsPause = true;
        super.doOnPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        long now = now();
        this.mIsPause = false;
        this.mResumeStartTime = System.currentTimeMillis();
        super.doOnResume();
        QBaseActivity.mAppForground = BaseGesturePWDUtil.getAppForground(this);
        if (enablePatternLock() && !QBaseActivity.mAppForground && isPatternLockOpened() && this.mCanLock) {
            startUnlockActivity();
        }
        if (!QBaseActivity.mAppForground) {
            QBaseActivity.mAppForground = true;
            ((IQWalletApiProxy) QRoute.api(IQWalletApiProxy.class)).setAppForground(this, QBaseActivity.mAppForground);
        }
        addReportParam(6, Long.valueOf(now() - now));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        long now = now();
        this.mIsStop = false;
        super.doOnStart();
        addReportParam(5, Long.valueOf(now() - now));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        this.mQWalletPLockLastBgTime = System.currentTimeMillis();
        this.mIsStop = true;
        super.doOnStop();
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    @TargetApi(21)
    public void finish() {
        if (this.mIsStartTouchEvent) {
            Intent intent = new Intent();
            intent.setAction("cn.abel.action.broadcast");
            sendBroadcast(intent);
        }
        try {
            if ((getFragment() instanceof ConfirmTransactionActivity) && getInnerBundle() != null && getInnerBundle().containsKey(j.T0) && getInnerBundle().getString(j.T0).contains("thirdpartapp") && isStackLocked((ActivityManager) getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.lastTipsTime > 3000) {
                    this.lastTipsTime = currentTimeMillis;
                    QQToast.makeText(this, HardCodeUtil.qqStr(R.string.rkj), 0).show();
                    return;
                }
                return;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
        super.finish();
    }

    protected Bundle getInnerBundle() {
        Intent intent = getIntent();
        if (intent != null) {
            return intent.getExtras();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.QPublicTransFragmentActivityForTool, com.tencent.mobileqq.activity.QPublicFragmentActivityForTool, mqq.app.AppActivity
    public String getModuleId() {
        return "qwallet_plugin.apk";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        if (super.getIntent() == null) {
            return false;
        }
        return super.getIntent().getBooleanExtra(IQWalletHelper.QWALLET_EXTRA_KEY_IS_FLING, false);
    }

    @Override // ql2.a
    public long now() {
        return this.mActivityMonitor.now();
    }

    @Override // com.tencent.mobileqq.activity.QPublicTransFragmentActivityForTool, com.tencent.mobileqq.activity.QPublicFragmentActivityForTool, com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        fixCrashWhenParcelBundle(bundle);
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, mqq.app.AppActivity
    public void onLogout(Constants.LogoutReason logoutReason) {
        QPublicBaseFragment fragment = getFragment();
        if (fragment instanceof QWalletBaseFragment) {
            ((QWalletBaseFragment) fragment).doOnLogout();
        }
    }

    public void startQWalletUnlockActivity() {
        if (mQWalletPLockBgIntervalTime > 0 && System.currentTimeMillis() - this.mQWalletPLockLastBgTime < mQWalletPLockBgIntervalTime * 1000) {
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("plugintest", 2, "startQWalletUnlockActivity");
            }
            Intent intent = new Intent();
            intent.putExtra("action_mode", 1);
            intent.putExtra("is_for_entrance", true);
            intent.putExtra("is_from_background", true);
            intent.putExtra(IActivity.PARAM_DISABLE_PATTERN_LOCK, true);
            c.d(this, intent, PatternLockActivity.class);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void startUnlockActivity() {
        Bundle innerBundle = getInnerBundle();
        if (innerBundle != null && innerBundle.getBoolean(IActivity.PARAM_IS_USE_QWALLET_PATTERN_LOCK, false)) {
            startQWalletUnlockActivity();
        } else {
            super.startUnlockActivity();
        }
    }
}
