package ch2;

import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.e;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f30843a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private final IGuardInterface f30844b = new a(this);

    /* renamed from: c, reason: collision with root package name */
    private boolean f30845c = false;

    public void a() {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager == null) {
            QLog.e("ExpandPluginPreloadManager", 1, "start() error, guardManager is null");
            return;
        }
        if (this.f30843a.compareAndSet(false, true)) {
            guardManager.registerCallBack(this.f30844b);
        }
        QLog.d("ExpandPluginPreloadManager", 1, "start()");
    }

    public void b() {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager == null) {
            QLog.e("ExpandPluginPreloadManager", 1, "stop() error, guardManager is null");
            return;
        }
        if (this.f30843a.compareAndSet(true, false)) {
            guardManager.unregisterCallback(this.f30844b);
        }
        QLog.d("ExpandPluginPreloadManager", 1, "stop()");
    }

    @Override // ch2.d
    public void onAppBackground() {
        if (!this.f30845c) {
            QLog.d("ExpandPluginPreloadManager", 1, "preloadPlugin: pre install is disable");
            return;
        }
        com.tencent.mobileqq.qroute.module.a plugin = QRoute.plugin("expand");
        if (plugin != null && plugin.i()) {
            e j3 = plugin.j();
            if (j3 == null) {
                QLog.w("ExpandPluginPreloadManager", 1, "preloadPlugin: fail, plugin info not exist!");
                return;
            }
            if (j3.d() != 2) {
                QLog.i("ExpandPluginPreloadManager", 1, "preloadPlugin: ignore, plugin state is not downloaded! getState: " + j3.d());
                return;
            }
            if (plugin.b()) {
                QLog.i("ExpandPluginPreloadManager", 1, "preloadPlugin: ignore, plugin is already install!");
                return;
            } else {
                QLog.i("ExpandPluginPreloadManager", 1, "preloadPlugin: start pre install, pluginId: expand");
                plugin.g(new b(), true);
                return;
            }
        }
        QLog.w("ExpandPluginPreloadManager", 1, "preloadPlugin: fail, plugin not exist!");
    }
}
