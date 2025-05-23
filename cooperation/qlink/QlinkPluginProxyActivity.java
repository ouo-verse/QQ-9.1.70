package cooperation.qlink;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.utils.ca;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes28.dex */
public class QlinkPluginProxyActivity extends PluginProxyActivity {
    static String F2(Intent intent) {
        return intent.getStringExtra("qlink_plugin_activity_name");
    }

    public static ClassLoader G2(Context context) throws Exception {
        return PluginStatic.getOrCreateClassLoader(context, "qlink_plugin.apk");
    }

    public static String H2() {
        return "qlink_plugin.apk";
    }

    public static boolean I2(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null || (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) == null) {
            return false;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (it.hasNext()) {
            if ("com.tencent.mobileqq:qlink".compareTo(it.next().processName) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void J2(Activity activity, String str, Intent intent, int i3, QQProgressDialog qQProgressDialog) {
        intent.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 2);
        IPluginManager.i iVar = new IPluginManager.i(0);
        iVar.f390198d = "qlink_plugin.apk";
        iVar.f390201g = PluginInfo.f390236f;
        iVar.f390197c = str;
        iVar.f390202h = F2(intent);
        iVar.f390203i = QlinkPluginProxyActivity.class;
        iVar.f390204j = intent;
        iVar.f390205k = i3;
        iVar.f390206l = qQProgressDialog;
        iVar.f390212r = 10000;
        iVar.f390211q = null;
        IPluginManager.B5(activity, iVar);
    }

    public static void setActivityNameToIntent(Intent intent, String str) {
        intent.putExtra("qlink_plugin_activity_name", str);
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity
    public String getPluginID() {
        return "qlink_plugin.apk";
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ca.a(this);
        super.onCreate(bundle);
        if (!TextUtils.isEmpty(this.mCreateErrorInfo)) {
            if (bundle == null) {
                bundle = getIntent().getExtras();
            }
            String string = bundle.getString("pluginsdk_launchActivity");
            StringBuffer stringBuffer = new StringBuffer(HardCodeUtil.qqStr(R.string.qfn));
            stringBuffer.append(string);
            stringBuffer.append(" ");
            stringBuffer.append(this.mCreateErrorInfo);
            QLog.e("QLinkLog", 1, stringBuffer.toString());
        }
    }
}
