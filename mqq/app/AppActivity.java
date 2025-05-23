package mqq.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import mqq.app.Constants;
import mqq.app.lifecycle.ActivityLifeCycleMonitor;
import mqq.util.AndroidOUIWrapperUtil;
import mqq.util.WeakReference;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes28.dex */
public class AppActivity extends FragmentActivity implements IPermissionRequester {
    public static Locale locale;
    public static int localeId;
    public static IActivityDispatchCallback sActivityDispatchCallback;
    private boolean mIsResultWaiting;
    private Intent mNewIntent;
    private Bundle mOnRestoreBundle;
    private AppRuntime mProRuntime;
    private int mRequestCode;
    private int mResultCode;
    private Intent mResultData;
    protected AppRuntime mRuntime = null;
    protected boolean mIsResume = false;
    private boolean mIsSplashing = false;
    private Bundle mOnCreateBundle = null;
    private Bundle mPostCreateBundle = null;
    private boolean mIsStartSkipped = false;
    private boolean mIsFinishingInOnCreate = false;
    private int mWindowFocusState = -1;
    private final SparseArray<List<Object>> mPermissionCallerMap = new SparseArray<>();

    private void disableFragmentRestore(Bundle bundle) {
        if (bundle != null) {
            bundle.remove("android:support:fragments");
            Bundle bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            if (bundle2 != null) {
                bundle2.remove("android:support:fragments");
            }
        }
    }

    private void fixPostCreateFlag() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mCalled");
            declaredField.setAccessible(true);
            declaredField.set(this, Boolean.TRUE);
        } catch (Throwable th5) {
            QLog.e("AppActivity", 1, "fixPostCreateFlag", th5);
        }
    }

    private boolean isActivityLocaleUpdated(Locale locale2) {
        Locale locale3 = locale;
        if (locale3 == null || locale2 == null) {
            return false;
        }
        boolean equals = locale3.getLanguage().equals(locale2.getLanguage());
        boolean equals2 = locale.getCountry().equals(locale2.getCountry());
        if (equals && equals2) {
            return false;
        }
        return true;
    }

    private boolean isLocaleCN() {
        if (localeId == 2052) {
            return true;
        }
        return false;
    }

    public static void setActivityDispatchCallback(IActivityDispatchCallback iActivityDispatchCallback) {
        sActivityDispatchCallback = iActivityDispatchCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void beforeDoOnCreate() {
        MobileQQ.sMobileQQ.appActivities.add(new WeakReference<>(this));
        this.mOnCreateBundle = null;
        if (shouldWaitAppRuntime()) {
            setAppRuntime(MobileQQ.sMobileQQ.waitAppRuntime());
        } else {
            QLog.d("AppActivity", 1, "should not wait AppRuntime");
        }
        if (isActivityLocaleUpdated(getResources().getConfiguration().locale)) {
            Resources resources = getResources();
            Configuration configuration = resources.getConfiguration();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setTo(resources.getDisplayMetrics());
            configuration.locale = locale;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            resources.getDisplayMetrics().setTo(displayMetrics);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i3) {
        ThirdAppReportHelper.reportThirdAppOpen(this, intent, 2);
        return super.bindService(intent, serviceConnection, i3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkSelfPermission(String str) {
        return super.checkSelfPermission(str);
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    @Deprecated
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.mIsSplashing) {
            return false;
        }
        return doDispatchKeyEvent(keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        IActivityDispatchCallback iActivityDispatchCallback = sActivityDispatchCallback;
        if (iActivityDispatchCallback != null) {
            iActivityDispatchCallback.disaptchTouchEventCallback(this, motionEvent);
        }
        try {
            z16 = super.dispatchTouchEvent(motionEvent);
        } catch (Throwable th5) {
            QLog.w("AppActivity", 1, "dispatchTouchEvent", th5);
            z16 = false;
        }
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, z16, false);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean doDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnBackPressed() {
        try {
            super.onBackPressed();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("qqBaseActivity", 2, "", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean doOnCreate(Bundle bundle) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnDestroy() {
        MobileQQ.sMobileQQ.appActivities.remove(new WeakReference(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        return super.onKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnPostCreate(Bundle bundle) {
        this.mPostCreateBundle = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnStart() {
        if (isActivityLocaleUpdated(getResources().getConfiguration().locale)) {
            recreate();
        }
    }

    public void fixAppRuntime() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("AppActivity", 1, "MobileQQ appRuntime is null");
        } else if (this.mRuntime == null) {
            QLog.e("AppActivity", 1, "setAppRuntime to fix null");
            setAppRuntime(peekAppRuntime);
        }
    }

    public AppRuntime getAppRuntime() {
        return this.mRuntime;
    }

    public String getCurrentFragments() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        StringBuilder sb5 = new StringBuilder("current fragment size =");
        sb5.append(fragments.size());
        sb5.append(":\n");
        for (int i3 = 0; i3 < fragments.size(); i3++) {
            Fragment fragment = fragments.get(i3);
            if (fragment != null && fragment.isAdded()) {
                sb5.append(fragment.getClass().getName());
                sb5.append("\n");
            }
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getModuleId() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final AppRuntime getProRuntime() {
        return this.mProRuntime;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (isLocaleCN()) {
            return super.getResources();
        }
        return getApplicationContext().getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i3) {
        return SharedPreferencesProxyManager.getInstance().getProxy(str, i3);
    }

    public boolean isResume() {
        return this.mIsResume;
    }

    protected boolean needRestoreFragmentAfterRecreate() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (!this.mIsSplashing) {
            doOnActivityResult(i3, i16, intent);
            return;
        }
        this.mIsResultWaiting = true;
        this.mRequestCode = i3;
        this.mResultCode = i16;
        this.mResultData = intent;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated
    public void onBackPressed() {
        if (this.mIsSplashing) {
            return;
        }
        doOnBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    @Deprecated
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        if (!this.mIsSplashing) {
            doOnConfigurationChanged(configuration);
        }
        super.onConfigurationChanged(configuration);
        ActivityLifeCycleMonitor.doOnActiviyConfigurationChanged(this);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @Deprecated
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        requestWindowFeature(intent);
        this.mIsSplashing = MobileQQ.sMobileQQ.onActivityCreate(this, intent);
        if (AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
            AndroidOUIWrapperUtil.fixOrientation(this);
        }
        if (this.mIsSplashing) {
            this.mOnCreateBundle = bundle;
            disableFragmentRestore(bundle);
            super.onCreate(bundle);
        } else {
            beforeDoOnCreate();
            if (needRestoreFragmentAfterRecreate()) {
                disableFragmentRestore(bundle);
            }
            super.onCreate(bundle);
            doOnCreate(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @Deprecated
    public void onDestroy() {
        if (!this.mIsSplashing || this.mIsFinishingInOnCreate) {
            doOnDestroy();
        }
        super.onDestroy();
        this.mProRuntime = null;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    @Deprecated
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (this.mIsSplashing) {
            return false;
        }
        return doOnKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLogout(Constants.LogoutReason logoutReason) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @Deprecated
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (!this.mIsSplashing) {
            doOnNewIntent(intent);
        } else {
            this.mNewIntent = intent;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @Deprecated
    public void onPause() {
        if (!this.mIsSplashing) {
            doOnPause();
        }
        this.mIsResume = false;
        super.onPause();
    }

    @Override // android.app.Activity
    @Deprecated
    protected void onPostCreate(Bundle bundle) {
        try {
            super.onPostCreate(bundle);
        } catch (ClassCastException e16) {
            fixPostCreateFlag();
            QLog.e("AppActivity", 1, "super onPostCreate", e16);
        }
        if (!this.mIsSplashing) {
            doOnPostCreate(bundle);
        } else {
            this.mPostCreateBundle = bundle;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @Deprecated
    public void onPostResume() {
        super.onPostResume();
        if (!this.mIsSplashing) {
            doOnPostResume();
        }
        ActivityLifeCycleMonitor.doOnActivityPostResumeEnd(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
        if (iArr.length == 0) {
            return;
        }
        List<Object> list = this.mPermissionCallerMap.get(i3);
        if (list != null && list.size() > 0) {
            for (Object obj : list) {
                if (obj != null) {
                    if (obj instanceof QQPermissionCallback) {
                        QQPermissionCallback qQPermissionCallback = (QQPermissionCallback) obj;
                        ArrayList arrayList = new ArrayList();
                        for (int i16 = 0; i16 < iArr.length; i16++) {
                            if (iArr[i16] != 0) {
                                arrayList.add(strArr[i16]);
                            }
                        }
                        if (arrayList.size() > 0) {
                            qQPermissionCallback.deny(i3, strArr, iArr);
                        } else {
                            qQPermissionCallback.grant(i3, strArr, iArr);
                        }
                    } else {
                        QQPermissionHelper.requestResult(obj, i3, strArr, iArr);
                    }
                }
            }
        }
        if (list != null) {
            this.mPermissionCallerMap.remove(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    @Deprecated
    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (!this.mIsSplashing) {
            doOnRestoreInstanceState(bundle);
        } else {
            this.mOnRestoreBundle = bundle;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @Deprecated
    public void onResume() {
        try {
            super.onResume();
        } catch (IllegalArgumentException e16) {
            QLog.d("AppActivity", 1, "super onResume", e16);
            try {
                Field declaredField = Activity.class.getDeclaredField("mCalled");
                declaredField.setAccessible(true);
                declaredField.set(this, Boolean.TRUE);
            } catch (IllegalAccessException e17) {
                e17.printStackTrace();
            } catch (IllegalArgumentException e18) {
                e18.printStackTrace();
            } catch (NoSuchFieldException e19) {
                e19.printStackTrace();
            } catch (SecurityException e26) {
                e26.printStackTrace();
            }
        } catch (NullPointerException e27) {
            QLog.d("AppActivity", 1, "super onResume", e27);
        }
        this.mIsResume = true;
        if (!this.mIsSplashing) {
            doOnResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @Deprecated
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!this.mIsSplashing) {
            doOnSaveInstanceState(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @Deprecated
    public void onStart() {
        try {
            super.onStart();
            if (!this.mIsSplashing) {
                doOnStart();
            } else {
                this.mIsStartSkipped = true;
            }
        } catch (IllegalArgumentException e16) {
            throw new IllegalArgumentException(getCurrentFragments(), e16);
        } catch (IllegalStateException e17) {
            throw new IllegalStateException(getCurrentFragments(), e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @Deprecated
    public void onStop() {
        if (!this.mIsSplashing) {
            doOnStop();
        } else {
            this.mIsStartSkipped = false;
        }
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    @Deprecated
    public void onUserLeaveHint() {
        if (!this.mIsSplashing) {
            doOnUserLeaveHint();
        }
        super.onUserLeaveHint();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    @Deprecated
    public void onWindowFocusChanged(boolean z16) {
        MobileQQ.sMobileQQ.onActivityFocusChanged(this, z16);
        super.onWindowFocusChanged(z16);
        IActivityDispatchCallback iActivityDispatchCallback = sActivityDispatchCallback;
        if (iActivityDispatchCallback != null) {
            iActivityDispatchCallback.onWindowFocusChanged(this, z16);
        }
        if (!this.mIsSplashing) {
            doOnWindowFocusChanged(z16);
        } else {
            this.mWindowFocusState = z16 ? 1 : 0;
        }
    }

    public boolean preloadData(AppRuntime appRuntime, boolean z16) {
        return false;
    }

    public void preloadUi() {
    }

    public void realOnCreate() {
        if (this.mIsSplashing) {
            boolean z16 = false;
            this.mIsSplashing = false;
            beforeDoOnCreate();
            if (doOnCreate(this.mOnCreateBundle) && !isFinishing()) {
                Foreground.updateRuntimeState(this.mProRuntime);
                if (this.mIsStartSkipped) {
                    doOnStart();
                    this.mIsStartSkipped = false;
                    Bundle bundle = this.mOnRestoreBundle;
                    if (bundle != null) {
                        doOnRestoreInstanceState(bundle);
                        this.mOnRestoreBundle = null;
                    }
                    doOnPostCreate(this.mPostCreateBundle);
                    if (this.mIsResultWaiting) {
                        doOnActivityResult(this.mRequestCode, this.mResultCode, this.mResultData);
                        this.mIsResultWaiting = false;
                        this.mResultData = null;
                    }
                    Intent intent = this.mNewIntent;
                    if (intent != null) {
                        doOnNewIntent(intent);
                        this.mNewIntent = null;
                    }
                    if (isResume()) {
                        doOnResume();
                        doOnPostResume();
                    }
                    int i3 = this.mWindowFocusState;
                    if (i3 != -1) {
                        if (i3 == 1) {
                            z16 = true;
                        }
                        doOnWindowFocusChanged(z16);
                        return;
                    }
                    return;
                }
                return;
            }
            if (isFinishing()) {
                this.mIsSplashing = true;
                this.mIsFinishingInOnCreate = true;
            }
        }
    }

    @TargetApi(24)
    public void requestPermissions(Object obj, int i3, String... strArr) {
        boolean z16 = true;
        if (QLog.isColorLevel()) {
            QLog.d("qqBaseActivity", 2, "fight.requestPermissions-", strArr);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (checkSelfPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            List<Object> list = this.mPermissionCallerMap.get(i3);
            if (list == null) {
                list = new ArrayList<>();
            }
            int size = list.size();
            int i16 = 0;
            while (true) {
                if (i16 < size) {
                    Object obj2 = list.get(i16);
                    if (obj2 != null && obj2 == obj) {
                        break;
                    } else {
                        i16++;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                list.add(obj);
                this.mPermissionCallerMap.put(i3, list);
            }
            requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), i3);
            return;
        }
        if (obj instanceof QQPermissionCallback) {
            ((QQPermissionCallback) obj).grant(i3, strArr, null);
        } else {
            QQPermissionHelper.doExecuteSuccess(obj, i3);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        MobileQQ.restrictBroadcast(intent);
        super.sendBroadcast(intent);
        MobileQQ.sMobileQQ.onSendBroadcast(this, intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str) {
        MobileQQ.restrictBroadcast(intent);
        super.sendOrderedBroadcast(intent, str);
        MobileQQ.sMobileQQ.onSendBroadcast(this, intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAppRuntime(AppRuntime appRuntime) {
        this.mProRuntime = appRuntime;
        if (appRuntime != null) {
            String moduleId = getModuleId();
            if (!TextUtils.isEmpty(moduleId)) {
                appRuntime = appRuntime.getAppRuntime(moduleId);
            }
        }
        this.mRuntime = appRuntime;
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i3) {
        if (!AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
            super.setRequestedOrientation(i3);
        }
    }

    protected boolean shouldWaitAppRuntime() {
        return true;
    }

    public boolean showPreview() {
        return false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3, Bundle bundle) {
        intent.putExtra(QQWinkConstants.KEY_PREVIOUS_ACTIVITY, getClass().getSimpleName());
        intent.putExtra("preAct_time", System.currentTimeMillis());
        intent.putExtra("preAct_elapsedRealtime", SystemClock.elapsedRealtime());
        FileProvider7Helper.intentCompatForN(this, intent);
        ThirdAppReportHelper.reportThirdAppOpen(this, intent, 0);
        super.startActivityForResult(intent, i3, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        ThirdAppReportHelper.reportThirdAppOpen(this, intent, 1);
        return super.startService(intent);
    }

    public void superFinish() {
        super.finish();
    }

    public void superSetRequestedOrientation(int i3) {
        super.setRequestedOrientation(i3);
    }

    public final void superStartActivityForResult(Intent intent, int i3, Bundle bundle) {
        super.startActivityForResult(intent, -1, bundle);
    }

    public HashMap<String, Runnable> preloadUi(boolean z16) {
        return new HashMap<>();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        MobileQQ.restrictBroadcast(intent);
        super.sendBroadcast(intent, str);
        MobileQQ.sMobileQQ.onSendBroadcast(this, intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str2, Bundle bundle) {
        MobileQQ.restrictBroadcast(intent);
        super.sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i3, str2, bundle);
        MobileQQ.sMobileQQ.onSendBroadcast(this, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnPause() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnPostResume() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnResume() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnStop() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnUserLeaveHint() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAccountChanged() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAccoutChangeFailed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnConfigurationChanged(Configuration configuration) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnNewIntent(Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnRestoreInstanceState(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnSaveInstanceState(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnWindowFocusChanged(boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void requestWindowFeature(Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnActivityResult(int i3, int i16, Intent intent) {
    }
}
