package cooperation.qqdataline.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

/* loaded from: classes28.dex */
public class DatalineProxyService extends PluginProxyService {
    public static void a(AppRuntime appRuntime, ServiceConnection serviceConnection) {
        Intent intent = new Intent(appRuntime.getApplication(), (Class<?>) DatalineProxyService.class);
        intent.putExtra(PluginStatic.PARAM_USE_SKIN_ENGINE, 1);
        IPluginManager.i iVar = new IPluginManager.i(0);
        iVar.f390198d = "qqdataline.apk";
        iVar.f390201g = PluginInfo.f390237h;
        iVar.f390197c = appRuntime.getAccount();
        iVar.f390202h = "com.qqdataline.ipc.QQDatalineService";
        iVar.f390204j = intent;
        iVar.f390209o = serviceConnection;
        IPluginManager.A5(appRuntime.getApplication(), iVar);
    }
}
