package cooperation.qqfav;

import android.content.Intent;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import cooperation.plugin.IPluginManager;
import mqq.app.AppRuntime;

/* loaded from: classes28.dex */
public class QfavPluginProxyReceiver extends PluginProxyBroadcastReceiver {
    public static void a(AppRuntime appRuntime, Intent intent) {
        IPluginManager.i iVar = new IPluginManager.i(0);
        iVar.f390198d = "qqfav.apk";
        iVar.f390201g = "qqfav.apk";
        iVar.f390197c = appRuntime.getAccount();
        iVar.f390202h = "com.qqfav.ipc.QfavPluginReceiver";
        iVar.f390204j = intent;
        IPluginManager.z5(appRuntime.getApplication(), iVar);
    }
}
