package cooperation.qqfav;

import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import cooperation.plugin.IPluginManager;
import cooperation.qqfav.ipc.QfavRemoteProxyForQQ;
import mqq.app.AppRuntime;

/* loaded from: classes28.dex */
public class QfavPluginProxyService extends PluginProxyService {

    /* renamed from: d, reason: collision with root package name */
    private static QfavRemoteProxyForQQ f390587d;

    /* renamed from: e, reason: collision with root package name */
    private static cooperation.qqfav.ipc.a f390588e;

    public static void a(AppRuntime appRuntime, ServiceConnection serviceConnection, String str) {
        Intent intent = new Intent(appRuntime.getApplication(), (Class<?>) QfavPluginProxyService.class);
        intent.putExtra(PluginStatic.PARAM_USE_SKIN_ENGINE, 1);
        IPluginManager.i iVar = new IPluginManager.i(0);
        iVar.f390198d = "qqfav.apk";
        iVar.f390201g = "qqfav.apk";
        iVar.f390197c = appRuntime.getAccount();
        iVar.f390202h = str;
        iVar.f390204j = intent;
        iVar.f390209o = serviceConnection;
        IPluginManager.A5(appRuntime.getApplication(), iVar);
    }

    public static cooperation.qqfav.ipc.a b() {
        if (f390588e == null) {
            synchronized (cooperation.qqfav.ipc.a.class) {
                if (f390588e == null) {
                    f390588e = new cooperation.qqfav.ipc.a(BaseApplicationImpl.getApplication().getRuntime());
                }
            }
        }
        return f390588e;
    }

    public static QfavRemoteProxyForQQ c() {
        if (f390587d == null) {
            synchronized (QfavRemoteProxyForQQ.class) {
                if (f390587d == null) {
                    f390587d = new QfavRemoteProxyForQQ(BaseApplicationImpl.getApplication().getRuntime());
                }
            }
        }
        return f390587d;
    }

    public static boolean d() {
        cooperation.qqfav.ipc.a b16 = b();
        if (!PluginCommunicationHandler.getInstance().containsCmd(b16.getCmd())) {
            PluginCommunicationHandler.getInstance().register(b16);
            return true;
        }
        return false;
    }
}
