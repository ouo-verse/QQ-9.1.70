package cooperation.qqpim;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;

/* loaded from: classes28.dex */
public class QQPimPluginProxyService extends PluginProxyService {
    public static void a(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            return;
        }
        Intent intent = new Intent(qQAppInterface.getApp(), (Class<?>) QQPimPluginProxyService.class);
        IPluginManager.i iVar = new IPluginManager.i(1);
        iVar.f390198d = "qqpim_plugin.apk";
        iVar.f390201g = "QQ\u540c\u6b65\u52a9\u624b\u63d2\u4ef6";
        iVar.f390197c = qQAppInterface.getCurrentAccountUin();
        iVar.f390202h = a.f390807k;
        iVar.f390204j = intent;
        IPluginManager.A5(qQAppInterface.getApp(), iVar);
        if (QLog.isColorLevel()) {
            QLog.i(a.f390797a, 2, "QQPimPluginProxyService.preloadQQPimService() IPluginManager.SUPPORT_NETWORKING = true");
        }
    }
}
