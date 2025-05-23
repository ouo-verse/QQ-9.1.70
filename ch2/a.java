package ch2;

import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes39.dex */
class a implements IGuardInterface {

    /* renamed from: d, reason: collision with root package name */
    private final d f30842d;

    public a(d dVar) {
        this.f30842d = dVar;
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        if (QLog.isDevelopLevel()) {
            QLog.d("ExpandPluginPreloadManager", 4, "guard: onApplicationBackground()");
        }
        this.f30842d.onAppBackground();
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        if (QLog.isDevelopLevel()) {
            QLog.d("ExpandPluginPreloadManager", 4, "guard: onApplicationForeground()");
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long j3) {
        if (QLog.isDevelopLevel()) {
            QLog.d("ExpandPluginPreloadManager", 4, "guard: onBackgroundTimeTick()", Long.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long j3) {
        if (QLog.isDevelopLevel()) {
            QLog.d("ExpandPluginPreloadManager", 4, "guard: onBackgroundUnguardTimeTick()", Long.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long j3) {
        if (QLog.isDevelopLevel()) {
            QLog.d("ExpandPluginPreloadManager", 4, "guard: onLiteTimeTick()", Long.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean z16) {
        if (QLog.isDevelopLevel()) {
            QLog.d("ExpandPluginPreloadManager", 4, "guard: onScreensStateChanged()", Boolean.valueOf(z16));
        }
    }
}
