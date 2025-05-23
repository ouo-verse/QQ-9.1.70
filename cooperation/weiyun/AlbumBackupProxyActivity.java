package cooperation.weiyun;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.utils.ca;
import com.tencent.mobileqq.weiyun.api.IWeiyunHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.IPluginManager;

/* loaded from: classes28.dex */
public class AlbumBackupProxyActivity extends PluginProxyActivity {
    public static void F2(Activity activity, String str, String str2) {
        G2(activity, str, str2, -1);
    }

    public static void G2(Activity activity, String str, String str2, int i3) {
        Intent intent = new Intent();
        intent.setFlags(536870912);
        intent.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 1);
        intent.putExtra(PluginStatic.PARAM_USE_SKIN_ENGINE, true);
        intent.putExtra("weiyun_backup_source", str2);
        IPluginManager.i iVar = new IPluginManager.i(0);
        iVar.f390198d = IWeiyunHelper.WEIYUN_PLUGIN_ID;
        iVar.f390201g = activity.getResources().getString(R.string.f173255ig4);
        iVar.f390197c = str;
        iVar.f390202h = "com.weiyun.plugin.cloudalbum.activity.CloudAlbumActivity";
        iVar.f390203i = AlbumBackupProxyActivity.class;
        iVar.f390204j = intent;
        if (i3 != -1) {
            iVar.f390205k = i3;
        }
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
        return IWeiyunHelper.WEIYUN_PLUGIN_ID;
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle, @Nullable PersistableBundle persistableBundle) {
        ca.a(this);
        super.onCreate(bundle, persistableBundle);
    }
}
