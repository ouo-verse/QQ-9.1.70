package cooperation.qqindividuality.ipc;

import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.vas.VasNtCommonReporter;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

/* loaded from: classes28.dex */
public class QQIndividualityPluginProxyService extends PluginProxyService {

    /* renamed from: d, reason: collision with root package name */
    private static QQIndividualityRemoteProxy f390743d;

    /* renamed from: e, reason: collision with root package name */
    private static b f390744e;

    public static void a(AppRuntime appRuntime, ServiceConnection serviceConnection, String str) {
        Intent intent = new Intent(appRuntime.getApplication(), (Class<?>) QQIndividualityPluginProxyService.class);
        intent.putExtra(PluginStatic.PARAM_USE_SKIN_ENGINE, 1);
        IPluginManager.i iVar = new IPluginManager.i(0);
        iVar.f390198d = "qqindividuality_plugin.apk";
        iVar.f390201g = PluginInfo.F;
        iVar.f390197c = appRuntime.getAccount();
        iVar.f390202h = str;
        iVar.f390204j = intent;
        iVar.f390209o = serviceConnection;
        IPluginManager.A5(appRuntime.getApplication(), iVar);
    }

    public static void b() {
        QQIndividualityRemoteProxy qQIndividualityRemoteProxy = f390743d;
        if (qQIndividualityRemoteProxy != null) {
            qQIndividualityRemoteProxy.g("qqindividuality_signature");
            f390743d = null;
        }
    }

    public static QQIndividualityRemoteProxy c() {
        if (f390743d == null) {
            synchronized (QQIndividualityRemoteProxy.class) {
                if (f390743d == null) {
                    f390743d = new QQIndividualityRemoteProxy(BaseApplicationImpl.getApplication().getRuntime());
                }
            }
        }
        return f390743d;
    }

    public static b d() {
        if (f390744e == null) {
            synchronized (b.class) {
                if (f390744e == null) {
                    f390744e = new b(BaseApplicationImpl.getApplication().getRuntime());
                }
            }
        }
        return f390744e;
    }

    public static boolean e() {
        b d16 = d();
        if (!PluginCommunicationHandler.getInstance().containsCmd(d16.getCmd())) {
            PluginCommunicationHandler.getInstance().register(d16);
            return true;
        }
        return false;
    }

    public static void f(AppRuntime appRuntime, ServiceConnection serviceConnection) {
        appRuntime.getApplication().unbindService(serviceConnection);
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyService, android.app.Service
    public void onCreate() {
        super.onCreate();
        VasNtCommonReporter.getHistoryFeature("QQIndividuality").setValue2("service-create").report(false);
    }
}
