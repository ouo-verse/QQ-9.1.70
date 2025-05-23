package cooperation.qqpim;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.IPluginManager;

/* loaded from: classes28.dex */
public class QQPimPluginProxyActivity extends PluginProxyActivity {
    public static void F2(Activity activity, Bundle bundle, Dialog dialog) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        H2(activity, intent, bundle.getString(a.f390808l), a.f390805i, QQPimPluginProxyActivity.class, dialog);
    }

    public static void G2(Activity activity, Bundle bundle, Dialog dialog) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        H2(activity, intent, bundle.getString(a.f390808l), a.f390806j, QQPimPluginProxyActivity.class, dialog);
    }

    private static boolean H2(Activity activity, Intent intent, String str, String str2, Class<? extends Activity> cls, Dialog dialog) {
        intent.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 2);
        intent.putExtra(PluginStatic.PARAM_USE_SKIN_ENGINE, true);
        IPluginManager.i iVar = new IPluginManager.i(1);
        iVar.f390198d = "qqpim_plugin.apk";
        iVar.f390201g = "QQ\u540c\u6b65\u52a9\u624b\u63d2\u4ef6";
        iVar.f390197c = str;
        iVar.f390202h = str2;
        iVar.f390203i = cls;
        iVar.f390204j = intent;
        iVar.f390205k = -1;
        iVar.f390206l = dialog;
        iVar.f390212r = 30000;
        iVar.f390211q = null;
        iVar.f390210p = false;
        IPluginManager.B5(activity, iVar);
        if (QLog.isColorLevel()) {
            QLog.i(a.f390797a, 2, "QQPimPluginProxyActivity.openPluginActivityForResult() " + str2 + " IPluginManager.SUPPORT_NETWORKING true");
        }
        return true;
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
