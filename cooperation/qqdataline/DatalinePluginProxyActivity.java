package cooperation.qqdataline;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
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
public class DatalinePluginProxyActivity extends PluginProxyActivity {

    /* loaded from: classes28.dex */
    public static class SingleTop extends DatalinePluginProxyActivity {
        @Override // cooperation.qqdataline.DatalinePluginProxyActivity, com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
            return dispatchTouchEvent;
        }

        @Override // cooperation.qqdataline.DatalinePluginProxyActivity, com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
        }
    }

    private static Class<? extends PluginProxyActivity> F2(Intent intent, String str) {
        if (str != null && str.equals("com.qqdataline.activity.LiteWifiphotoActivity")) {
            intent.setFlags(intent.getFlags() | 536870912);
        }
        if ((intent.getFlags() & 536870912) != 0) {
            return SingleTop.class;
        }
        return DatalinePluginProxyActivity.class;
    }

    public static boolean G2(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null || (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) == null) {
            return false;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (it.hasNext()) {
            if ("com.tencent.mobileqq:dataline".compareTo(it.next().processName) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void H2(Activity activity, String str, Intent intent, String str2, int i3, QQProgressDialog qQProgressDialog) {
        intent.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 2);
        IPluginManager.i iVar = new IPluginManager.i(0);
        iVar.f390198d = "qqdataline.apk";
        iVar.f390201g = PluginInfo.f390237h;
        iVar.f390197c = str;
        iVar.f390202h = str2;
        iVar.f390203i = F2(intent, str2);
        iVar.f390204j = intent;
        iVar.f390205k = i3;
        iVar.f390206l = qQProgressDialog;
        iVar.f390212r = 10000;
        iVar.f390211q = null;
        IPluginManager.B5(activity, iVar);
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
        return "qqdataline.apk";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity
    public Class<? extends PluginProxyActivity> getProxyActivity(String str) {
        if (str.equals("com.qqdataline.activity.LiteWifiphotoActivity")) {
            return SingleTop.class;
        }
        return super.getProxyActivity(str);
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
            StringBuffer stringBuffer = new StringBuffer("[\u63d2\u4ef6Activity\u542f\u52a8] ");
            stringBuffer.append(string);
            stringBuffer.append(" ");
            stringBuffer.append(this.mCreateErrorInfo);
            QLog.e("qqdataline", 1, stringBuffer.toString());
        }
    }
}
