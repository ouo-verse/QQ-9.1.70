package cooperation.qqpim;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

/* loaded from: classes28.dex */
public class QQPimPluginLoadRunnable implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private a f390789d;

    /* renamed from: e, reason: collision with root package name */
    private IPluginManager f390790e;

    /* renamed from: f, reason: collision with root package name */
    private long f390791f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f390792h;

    /* loaded from: classes28.dex */
    public interface a {
        void a(float f16);

        void b();

        void c(int i3);

        void d();
    }

    public QQPimPluginLoadRunnable(a aVar) {
        this.f390789d = aVar;
    }

    private QQAppInterface e() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int i3;
        this.f390791f = System.currentTimeMillis();
        QQAppInterface e16 = e();
        if (e16 == null) {
            return;
        }
        IPluginManager iPluginManager = (IPluginManager) e16.getManager(QQManagerFactory.MGR_PLUGIN);
        this.f390790e = iPluginManager;
        if (iPluginManager == null) {
            return;
        }
        PluginInfo queryPlugin = iPluginManager.queryPlugin("qqpim_plugin.apk");
        if (queryPlugin == null) {
            str = "qqpim_plugin.apk";
            i3 = 1;
        } else if (queryPlugin.mState == 4) {
            if (QLog.isDevelopLevel()) {
                QLog.i(cooperation.qqpim.a.f390797a, 1, "onPluginManagerLoaded has installed");
            }
            i3 = 1;
            ReportController.o(e16, "CliOper", "", "", "0X8006716", "0X8006716", 0, 0, "", "", "", "");
            a aVar = this.f390789d;
            if (aVar != null) {
                aVar.d();
            }
            str = "qqpim_plugin.apk";
        } else {
            i3 = 1;
            if (QLog.isDevelopLevel()) {
                QLog.i(cooperation.qqpim.a.f390797a, 1, "onPluginManagerLoaded start down or install...");
            }
            ReportController.o(e16, "CliOper", "", "", "0X8006717", "0X8006717", 0, 0, "", "", "", "");
            str = "qqpim_plugin.apk";
            this.f390790e.x5(str);
            a aVar2 = this.f390789d;
            if (aVar2 != null) {
                aVar2.b();
            }
        }
        while (!this.f390792h) {
            if (System.currentTimeMillis() - this.f390791f > 30000) {
                ReportController.o(e(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
                a aVar3 = this.f390789d;
                if (aVar3 != null) {
                    aVar3.c(-5);
                    return;
                }
                return;
            }
            PluginInfo queryPlugin2 = this.f390790e.queryPlugin(str);
            if (queryPlugin2 == null) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(cooperation.qqpim.a.f390797a, 4, "null == pluginInfo");
                }
                if (this.f390790e.isReady()) {
                    ReportController.o(e(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
                    a aVar4 = this.f390789d;
                    if (aVar4 != null) {
                        aVar4.c(-1);
                        return;
                    }
                    return;
                }
            } else {
                if (QLog.isDevelopLevel()) {
                    QLog.d(cooperation.qqpim.a.f390797a, 4, "queryPluginInfo mState : " + queryPlugin2.mState + " progress:" + queryPlugin2.mDownloadProgress);
                }
                int i16 = queryPlugin2.mState;
                if (i16 == 4) {
                    ReportController.o(e16, "CliOper", "", "", "0X8006718", "0X8006718", 0, 0, "", "", "", "");
                    a aVar5 = this.f390789d;
                    if (aVar5 != null) {
                        aVar5.d();
                        return;
                    }
                    return;
                }
                if (i16 == 0) {
                    this.f390790e.x5(str);
                } else if (i16 == 3) {
                    a aVar6 = this.f390789d;
                    if (aVar6 != null) {
                        aVar6.a(queryPlugin2.mDownloadProgress);
                    }
                } else if (i16 == i3) {
                    a aVar7 = this.f390789d;
                    if (aVar7 != null) {
                        aVar7.a(queryPlugin2.mDownloadProgress);
                    }
                } else if (i16 == 2) {
                    a aVar8 = this.f390789d;
                    if (aVar8 != null) {
                        aVar8.a(queryPlugin2.mDownloadProgress);
                    }
                } else {
                    if (i16 == -1) {
                        ReportController.o(e(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
                        a aVar9 = this.f390789d;
                        if (aVar9 != null) {
                            aVar9.c(-6);
                            return;
                        }
                        return;
                    }
                    if (i16 == -2) {
                        ReportController.o(e(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
                        a aVar10 = this.f390789d;
                        if (aVar10 != null) {
                            aVar10.c(-3);
                            return;
                        }
                        return;
                    }
                    ReportController.o(e(), "CliOper", "", "", "0X8006719", "0X8006719", 0, 0, "", "", "", "");
                    a aVar11 = this.f390789d;
                    if (aVar11 != null) {
                        aVar11.c(-2);
                        return;
                    }
                    return;
                }
                try {
                    LockMethodProxy.sleep(500L);
                } catch (InterruptedException e17) {
                    e17.printStackTrace();
                }
            }
        }
    }

    public void stop() {
        this.f390789d = null;
        this.f390792h = true;
    }
}
