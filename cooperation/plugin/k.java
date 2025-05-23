package cooperation.plugin;

import android.content.Intent;
import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class k implements com.tencent.mobileqq.qroute.module.a {

    /* renamed from: a, reason: collision with root package name */
    private String f390319a;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements IPluginManager.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qroute.module.d f390320a;

        a(com.tencent.mobileqq.qroute.module.d dVar) {
            this.f390320a = dVar;
        }

        @Override // cooperation.plugin.IPluginManager.f
        public void a(boolean z16) {
            this.f390320a.f276443j.a(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b extends OnPluginInstallListener.Stub {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qroute.module.c f390322d;

        b(com.tencent.mobileqq.qroute.module.c cVar) {
            this.f390322d = cVar;
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallBegin(String str) throws RemoteException {
            this.f390322d.onInstallBegin(str);
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallDownloadProgress(String str, int i3, int i16) throws RemoteException {
            this.f390322d.onInstallDownloadProgress(str, i3, i16);
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallError(String str, int i3) throws RemoteException {
            this.f390322d.onInstallError(str, i3);
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallFinish(String str) throws RemoteException {
            this.f390322d.onInstallFinish(str);
        }
    }

    public k(String str) {
        this.f390319a = str;
    }

    private static boolean a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return true;
        }
        String qQProcessName = MobileQQ.sMobileQQ.getQQProcessName();
        for (String str : strArr) {
            if (qQProcessName.endsWith(str)) {
                return true;
            }
        }
        return false;
    }

    private IPluginManager.i k(com.tencent.mobileqq.qroute.module.d dVar) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        PluginBaseInfo m3 = m();
        if (m3 == null) {
            return null;
        }
        IPluginManager.i iVar = new IPluginManager.i(m3.mType, m3.mSubType);
        iVar.f390197c = waitAppRuntime.getCurrentUin();
        String str = this.f390319a;
        iVar.f390198d = str;
        iVar.f390201g = str;
        if (m3.mSubType == 1) {
            iVar.f390198d = dVar.f276440g;
        }
        String str2 = dVar.f276437d;
        iVar.f390203i = dVar.f276438e;
        iVar.f390205k = dVar.f276434a;
        iVar.f390202h = str2;
        if (dVar.f276439f == null) {
            dVar.f276439f = new Intent(dVar.f276441h, (Class<?>) dVar.f276438e);
        }
        iVar.f390204j = dVar.f276439f;
        iVar.f390207m = (com.tencent.mobileqq.hitrate.b) dVar.f276442i;
        iVar.f390212r = dVar.f276436c;
        iVar.f390206l = dVar.f276435b;
        return iVar;
    }

    private PluginManagerClient l() {
        return PluginManagerHelper.getPluginInterface(MobileQQ.sMobileQQ);
    }

    private PluginBaseInfo m() {
        if (MobileQQ.sProcessId == 1) {
            return ((IPluginManager) MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(QQManagerFactory.MGR_PLUGIN)).queryPlugin(this.f390319a);
        }
        PluginManagerClient l3 = l();
        if (!l3.useful()) {
            return null;
        }
        return l3.queryPlugin(this.f390319a);
    }

    @Override // com.tencent.mobileqq.qroute.module.a
    public boolean b() {
        if (MobileQQ.sProcessId == 1) {
            return ((IPluginManager) MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(QQManagerFactory.MGR_PLUGIN)).isPlugininstalled(this.f390319a);
        }
        PluginManagerClient l3 = l();
        if (l3.useful()) {
            return l3.isPluginInstalled(this.f390319a);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qroute.module.a
    public Class c(String str) {
        PluginBaseInfo m3 = m();
        if (m3 == null) {
            return null;
        }
        if (a(m3.mProcesses)) {
            if (m3.mState != 4) {
                return null;
            }
            if (m3.mSubType != 1) {
                try {
                    return PluginStatic.getOrCreateClassLoader(MobileQQ.sMobileQQ, this.f390319a).loadClass(str);
                } catch (Exception e16) {
                    throw new RuntimeException(e16);
                }
            }
            StringBuilder sb5 = new StringBuilder(50);
            sb5.append("QRouteApi:  ");
            sb5.append(str);
            sb5.append(" not support shadow plugin: " + this.f390319a);
            throw new RuntimeException(sb5.toString());
        }
        QLog.e("QRoute.Module.Plugin", 1, "loadPluginClass failed" + str + " " + this.f390319a + " can't not run in current Process:" + MobileQQ.sMobileQQ);
        StringBuilder sb6 = new StringBuilder(50);
        sb6.append("QRouteApi: its impl ");
        sb6.append(str);
        StringBuilder sb7 = new StringBuilder();
        sb7.append(" in Plugin ");
        sb7.append(this.f390319a);
        sb6.append(sb7.toString());
        sb6.append(" can not run on this process: ");
        sb6.append(MobileQQ.sMobileQQ.getQQProcessName());
        sb6.append("\uff0c\u8bf7\u8054\u7cfbAPI\u5f00\u53d1\u8005\u6c9f\u901a\u5904\u7406\u3002\n");
        throw new RuntimeException(sb6.toString());
    }

    @Override // com.tencent.mobileqq.qroute.module.a
    public void d(com.tencent.mobileqq.qroute.module.c cVar) {
        g(cVar, false);
    }

    @Override // com.tencent.mobileqq.qroute.module.a
    public boolean e() {
        PluginBaseInfo m3 = m();
        if (m3 != null && m3.mSubType == 2) {
            QLog.d("QRoute.Module.Plugin", 1, "loadPlugin for DYNAMIC_FEATURE_PLUGIN " + this.f390319a);
            return com.tencent.mobileqq.app.compact.a.k().o(this.f390319a, BaseApplicationImpl.sApplication);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qroute.module.a
    public void f(com.tencent.mobileqq.qroute.module.d dVar) {
        a aVar;
        if (dVar.f276443j != null) {
            aVar = new a(dVar);
        } else {
            aVar = null;
        }
        IPluginManager.C5(dVar.f276441h, k(dVar), aVar);
    }

    @Override // com.tencent.mobileqq.qroute.module.a
    public void g(com.tencent.mobileqq.qroute.module.c cVar, boolean z16) {
        b bVar = new b(cVar);
        if (MobileQQ.sProcessId == 1) {
            ((IPluginManager) MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(QQManagerFactory.MGR_PLUGIN)).installPlugin(this.f390319a, bVar);
            return;
        }
        PluginManagerClient l3 = l();
        if (l3.useful()) {
            l3.installPlugin(this.f390319a, bVar);
        }
    }

    @Override // com.tencent.mobileqq.qroute.module.a
    public String h() {
        return this.f390319a;
    }

    @Override // com.tencent.mobileqq.qroute.module.a
    public boolean i() {
        if (m() != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qroute.module.a
    public com.tencent.mobileqq.qroute.module.e j() {
        com.tencent.mobileqq.qroute.module.e eVar = new com.tencent.mobileqq.qroute.module.e();
        PluginBaseInfo m3 = m();
        if (m3 == null) {
            return null;
        }
        eVar.r(m3.mState);
        eVar.k(m3.mID);
        eVar.o(m3.mName);
        eVar.m(m3.mLength);
        eVar.n(m3.mMD5);
        eVar.t(m3.mURL);
        eVar.u(m3.mVersion);
        eVar.p(m3.mProcesses);
        eVar.s(m3.mSubType);
        eVar.l(m3.installCode);
        eVar.j(m3.downloadDuration);
        eVar.q(m3.startDownloadNetType);
        eVar.h(m3.costDex2Oat);
        eVar.g(m3.costApk);
        eVar.i(m3.costLib);
        return eVar;
    }
}
