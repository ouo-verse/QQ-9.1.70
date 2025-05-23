package com.tencent.mobileqq.pluginsdk;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

/* loaded from: classes16.dex */
public abstract class PluginProxyFragmentActivity extends PluginProxyActivity {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PluginProxyFragmentActivity";
    private static final HashMap<String, String> pluginInstalledPathMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14524);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            pluginInstalledPathMap = new HashMap<>();
        }
    }

    public PluginProxyFragmentActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "new PluginContext start");
            }
            HashMap<String, String> hashMap = pluginInstalledPathMap;
            String str = hashMap.get(getPluginID());
            if (TextUtils.isEmpty(str)) {
                str = PluginUtils.getInstalledPluginPath(context, getPluginID()).getAbsolutePath();
                hashMap.put(getPluginID(), str);
            }
            PluginContext pluginContext = new PluginContext(context, getThemeResId(), str, PluginStatic.getOrCreateClassLoader(context, getPluginID()), context.getResources(), getPluginResType());
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "new PluginContext end ,cost:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            super.attachBaseContext(pluginContext);
        } catch (Throwable th5) {
            super.attachBaseContext(context);
            QLog.e(TAG, 1, "attachBaseContext", QLog.getStackTraceString(th5));
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Intent) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Intent intent = super.getIntent();
        intent.setExtrasClassLoader(getClassLoader());
        try {
            Bundle bundleExtra = intent.getBundleExtra("pluginsdk_inner_intent_extras");
            QLog.i(TAG, 1, "inner extras: " + bundleExtra);
            if (bundleExtra != null) {
                intent.removeExtra("pluginsdk_inner_intent_extras");
                for (String str : bundleExtra.keySet()) {
                    if (bundleExtra.get(str) == null) {
                        QLog.w(TAG, 1, "bundle key: " + str + ", value is null!");
                    }
                }
                intent.putExtras(bundleExtra);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "putExtras error!", e16);
        }
        setIntent(intent);
        return intent;
    }

    protected abstract int getPluginResType();

    protected abstract int getThemeResId();

    @Override // android.app.Activity
    public void onAttachFragment(Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fragment);
            return;
        }
        super.onAttachFragment(fragment);
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null) {
            iPluginActivity.IOnAttachFragment(fragment);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent, i3);
            return;
        }
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null && (iPluginActivity instanceof BasePluginActivity) && ((BasePluginActivity) iPluginActivity).isSamePackage2(intent)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            intent.putExtra("pluginsdk_IsPluginActivity", true);
        }
        super.startActivityForResult(intent, i3);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(@NonNull Fragment fragment, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            startActivityFromFragment(fragment, intent, i3, (Bundle) null);
        } else {
            iPatchRedirector.redirect((short) 5, this, fragment, intent, Integer.valueOf(i3));
        }
    }

    public void startPluginActivityFromFragment(@NonNull Fragment fragment, String str, Intent intent, int i3, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, fragment, str, intent, Integer.valueOf(i3), bundle);
            return;
        }
        Intent intent2 = new Intent(this, getProxyActivity(str));
        intent2.putExtra("pluginsdk_pluginName", this.mPluginName);
        intent2.putExtra("pluginsdk_pluginLocation", this.mPluginID);
        intent2.putExtra("pluginsdk_pluginpath", this.mPluginApkFilePath);
        intent2.putExtra("pluginsdk_launchActivity", str);
        intent2.putExtra(PluginStatic.PARAM_USE_SKIN_ENGINE, this.mUseSkinEngine);
        int i16 = this.mPluginResoucesType;
        if (i16 == 1 || i16 == -1 || i16 == 2) {
            intent2.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, i16);
        }
        if (intent != null) {
            intent2.addFlags(intent.getFlags());
            if (intent.getExtras() != null) {
                intent2.putExtra("pluginsdk_inner_intent_extras", new Bundle(intent.getExtras()));
            }
        }
        super.startActivityFromFragment(fragment, intent2, i3, bundle);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(@NonNull Fragment fragment, Intent intent, int i3, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, fragment, intent, Integer.valueOf(i3), bundle);
            return;
        }
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity != null && (iPluginActivity instanceof BasePluginActivity) && ((BasePluginActivity) iPluginActivity).isSamePackage2(intent)) {
            ComponentName component = intent.getComponent();
            String className = component != null ? component.getClassName() : null;
            intent.putExtra("pluginsdk_IsPluginActivity", false);
            if (className != null && className.length() > 0) {
                startPluginActivityFromFragment(fragment, className, intent, i3, bundle);
                return;
            } else {
                QLog.e(TAG, 1, "startActivityFromFragment activityName==null");
                return;
            }
        }
        super.startActivityFromFragment(fragment, intent, i3, bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fragment);
            return;
        }
        super.onAttachFragment(fragment);
        IPluginActivity iPluginActivity = this.mPluginActivity;
        if (iPluginActivity instanceof IPluginFragmentActivity) {
            ((IPluginFragmentActivity) iPluginActivity).IOnAttachFragment(fragment);
        }
    }
}
