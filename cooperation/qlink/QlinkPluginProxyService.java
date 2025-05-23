package cooperation.qlink;

import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

/* loaded from: classes28.dex */
public class QlinkPluginProxyService extends PluginProxyService {
    public static void a(AppRuntime appRuntime, ServiceConnection serviceConnection) {
        Intent intent = new Intent(appRuntime.getApplication(), (Class<?>) QlinkPluginProxyService.class);
        intent.putExtra(PluginStatic.PARAM_USE_SKIN_ENGINE, 1);
        intent.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 2);
        IPluginManager.i iVar = new IPluginManager.i(0);
        iVar.f390198d = QlinkPluginProxyActivity.H2();
        iVar.f390201g = PluginInfo.f390236f;
        iVar.f390197c = appRuntime.getAccount();
        iVar.f390202h = "com.tencent.qlink.service.QlinkService";
        iVar.f390204j = intent;
        iVar.f390209o = serviceConnection;
        QLog.d("QLinkLog", 4, "Bind Qlink Service");
        IPluginManager.A5(appRuntime.getApplication(), iVar);
    }
}
