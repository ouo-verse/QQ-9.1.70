package cooperation.qqindividuality;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;

/* loaded from: classes28.dex */
public class QQIndividualityProxyActivity extends PluginProxyActivity {
    public static boolean F2(Activity activity, Intent intent, String str, String str2, Class<? extends Activity> cls, Dialog dialog, int i3) {
        cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService.e();
        intent.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 2);
        intent.putExtra(PluginStatic.PARAM_USE_SKIN_ENGINE, true);
        IPluginManager.i iVar = new IPluginManager.i(1);
        iVar.f390198d = "qqindividuality_plugin.apk";
        iVar.f390201g = PluginInfo.F;
        iVar.f390197c = str;
        iVar.f390202h = str2;
        iVar.f390203i = cls;
        iVar.f390204j = intent;
        iVar.f390205k = i3;
        iVar.f390212r = 30000;
        iVar.f390211q = null;
        iVar.f390210p = false;
        IPluginManager.B5(activity, iVar);
        if (str2.equals("com.qqindividuality.activity.QQIndividualitySignatureActivity") && (activity instanceof QQIndividualityBridgeActivity) && dialog != null) {
            activity.finish();
        }
        if (QLog.isColorLevel()) {
            QLog.i("QQIndividuality", 2, "QQIndividualityPluginProxyActivity.openPluginActivityForResult() " + str2 + " IPluginManager.SUPPORT_NETWORKING true");
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
