package mqq.app;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import mqq.app.Constants;
import mqq.app.lifecycle.ActivityLifeCycleMonitor;
import mqq.inject.MqqInjectorManager;

/* compiled from: P */
/* loaded from: classes28.dex */
public class BaseActivity extends Activity implements LifecycleOwner, IPermissionRequester {
    public static Locale locale;
    public static int localeId;
    private AppRuntime app;
    private boolean isResume;
    AndroidOreoUtils mAndroidOreoUtils;
    private BroadcastReceiver mDebugUiHierarchyBroadcastReceiver;
    protected boolean mIsShadow;
    private AppRuntime mProcRuntime;

    /* renamed from: mqq, reason: collision with root package name */
    private MobileQQ f417201mqq;
    private LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
    private final SparseArray<List<Object>> mPermissionCallerMap = new SparseArray<>();

    private void attachDebugUiHierarchyTools(final Activity activity) {
        if (MqqInjectorManager.instance().isDebugVersion()) {
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: mqq.app.BaseActivity.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    MqqInjectorManager.instance().tryDumpUiHierarchyToFile(activity.getWindow().getDecorView());
                }
            };
            this.mDebugUiHierarchyBroadcastReceiver = broadcastReceiver;
            activity.registerReceiver(broadcastReceiver, new IntentFilter("com.qzone.debug.UI_HIERARCHY"));
        }
    }

    private void detachDebugUiHierarchyTools(Activity activity) {
        BroadcastReceiver broadcastReceiver;
        if (MqqInjectorManager.instance().isDebugVersion() && (broadcastReceiver = this.mDebugUiHierarchyBroadcastReceiver) != null) {
            activity.unregisterReceiver(broadcastReceiver);
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

    @TargetApi(11)
    private void recreateOnLocaleUpdate() {
        if (isActivityLocaleUpdated(getResources().getConfiguration().locale)) {
            recreate();
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

    protected boolean compatibleAndroidOreo() {
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    public final AppRuntime getAppRuntime() {
        return this.app;
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    protected String getModuleId() {
        return null;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (!this.mIsShadow && !isLocaleCN()) {
            return getApplicationContext().getResources();
        }
        return super.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i3) {
        return SharedPreferencesProxyManager.getInstance().getProxy(str, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLatecyWaitRuntime() {
        return false;
    }

    public final boolean isResume() {
        return this.isResume;
    }

    protected boolean isShadow() {
        return false;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActivityLifeCycleMonitor.doOnActiviyConfigurationChanged(this);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        this.mAndroidOreoUtils = new AndroidOreoUtils(this);
        if (Build.VERSION.SDK_INT == 26 && compatibleAndroidOreo() && getApplicationInfo().targetSdkVersion >= 27 && this.mAndroidOreoUtils.isTranslucentOrFloating()) {
            QLog.i("mqq", 1, "onCreate fixOrientation when Oreo, result = " + this.mAndroidOreoUtils.fixOrientation());
        }
        onCreateNoRuntime(bundle);
        if (QLog.isColorLevel()) {
            QLog.i("mqq", 2, "[Activity]" + getClass().getSimpleName() + " onCreate");
        }
        if (!isLatecyWaitRuntime()) {
            waitAppRuntime();
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
        attachDebugUiHierarchyTools(this);
        this.lifecycleRegistry.markState(Lifecycle.State.CREATED);
    }

    protected void onCreateNoRuntime(Bundle bundle) {
        boolean isShadow = isShadow();
        this.mIsShadow = isShadow;
        if (!isShadow) {
            super.onCreate(bundle);
        }
        if (QLog.isColorLevel()) {
            QLog.i("mqq", 2, "[Activity]" + getClass().getSimpleName() + " onCreateNoRuntime");
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        this.f417201mqq = mobileQQ;
        mobileQQ.addBaseActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        if (!this.mIsShadow) {
            super.onDestroy();
        }
        if (QLog.isColorLevel()) {
            QLog.i("mqq", 2, "[Activity]" + getClass().getSimpleName() + " onDestroy");
        }
        this.lifecycleRegistry.markState(Lifecycle.State.DESTROYED);
        detachDebugUiHierarchyTools(this);
        this.f417201mqq.removeBaseActivity(this);
        this.f417201mqq = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLogout(Constants.LogoutReason logoutReason) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        if (!this.mIsShadow) {
            super.onPause();
        }
        this.isResume = false;
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        ActivityLifeCycleMonitor.doOnActivityPostResumeEnd(this);
    }

    @Override // android.app.Activity
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
    public void onResume() {
        if (!this.mIsShadow) {
            try {
                super.onResume();
            } catch (IllegalArgumentException e16) {
                QLog.d("BaseActivityActivity", 1, "super onResume", e16);
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
                QLog.d("BaseActivity", 1, "super onResume", e27);
            }
        }
        this.lifecycleRegistry.markState(Lifecycle.State.RESUMED);
        this.isResume = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        if (!this.mIsShadow) {
            super.onStart();
            recreateOnLocaleUpdate();
        }
        this.lifecycleRegistry.markState(Lifecycle.State.STARTED);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        if (QLog.isColorLevel()) {
            QLog.i("mqq", 2, "[Activity]" + getClass().getSimpleName() + " onStop");
        }
        if (!this.mIsShadow) {
            super.onStop();
        }
    }

    @TargetApi(24)
    public void requestPermissions(Object obj, int i3, String... strArr) {
        ArrayList arrayList = new ArrayList();
        boolean z16 = false;
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
                if (i16 >= size) {
                    break;
                }
                Object obj2 = list.get(i16);
                if (obj2 != null && obj2 == obj) {
                    z16 = true;
                    break;
                }
                i16++;
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
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str) {
        MobileQQ.restrictBroadcast(intent);
        super.sendOrderedBroadcast(intent, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAppRuntime(AppRuntime appRuntime) {
        this.mProcRuntime = appRuntime;
        if (appRuntime != null) {
            appRuntime = appRuntime.getAppRuntime(getModuleId());
        }
        this.app = appRuntime;
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i3) {
        if (Build.VERSION.SDK_INT == 26 && compatibleAndroidOreo() && getApplicationInfo().targetSdkVersion >= 27 && this.mAndroidOreoUtils.isTranslucentOrFloating()) {
            AndroidOreoUtils androidOreoUtils = this.mAndroidOreoUtils;
            if (androidOreoUtils.isFixedOrientation(androidOreoUtils.getCurrentActivityInfo(), i3)) {
                QLog.i("mqq", 1, "avoid calling setRequestedOrientation when Oreo.");
                return;
            }
        }
        super.setRequestedOrientation(i3);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i3, Bundle bundle) {
        if (!this.mIsShadow) {
            intent.putExtra(QQWinkConstants.KEY_PREVIOUS_ACTIVITY, getClass().getSimpleName());
            intent.putExtra("preAct_time", System.currentTimeMillis());
        }
        FileProvider7Helper.intentCompatForN(getApplicationContext(), intent);
        ThirdAppReportHelper.reportThirdAppOpen(this, intent, 0);
        super.startActivityForResult(intent, i3, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        ThirdAppReportHelper.reportThirdAppOpen(this, intent, 1);
        return super.startService(intent);
    }

    public final void superFinish() {
        super.finish();
    }

    public AppRuntime waitAppRuntime() {
        AppRuntime waitAppRuntime = this.f417201mqq.waitAppRuntime();
        if (waitAppRuntime == null) {
            return null;
        }
        this.mProcRuntime = waitAppRuntime;
        AppRuntime appRuntime = waitAppRuntime.getAppRuntime(getModuleId());
        this.app = appRuntime;
        return appRuntime;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        MobileQQ.restrictBroadcast(intent);
        super.sendBroadcast(intent, str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str2, Bundle bundle) {
        MobileQQ.restrictBroadcast(intent);
        super.sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i3, str2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAccountChanged() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAccoutChangeFailed() {
    }
}
