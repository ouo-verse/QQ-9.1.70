package com.tencent.gdtad.splash.adapter;

import com.qq.e.comm.pi.ITGChangeBackgroundStatusManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b implements ITGChangeBackgroundStatusManager {

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<WeakReference<ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack>> f109354a;

    /* renamed from: b, reason: collision with root package name */
    private final a f109355b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f109356c;

    public b() {
        CopyOnWriteArrayList<WeakReference<ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack>> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.f109354a = copyOnWriteArrayList;
        this.f109355b = new a(copyOnWriteArrayList);
        this.f109356c = new AtomicBoolean(false);
    }

    private WeakReference<ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack> a(ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack iChangeBackgroundStatusCallBack) {
        ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack iChangeBackgroundStatusCallBack2;
        WeakReference<ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack> next;
        Iterator<WeakReference<ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack>> it = this.f109354a.iterator();
        do {
            iChangeBackgroundStatusCallBack2 = null;
            if (!it.hasNext()) {
                return null;
            }
            next = it.next();
            if (next != null) {
                iChangeBackgroundStatusCallBack2 = next.get();
            }
        } while (iChangeBackgroundStatusCallBack2 != iChangeBackgroundStatusCallBack);
        QLog.i("GdtSplashBackgroundManager", 1, "[register] duplicate IChangeBackgroundStatusCallBack");
        return next;
    }

    @Override // com.qq.e.comm.pi.ITGChangeBackgroundStatusManager
    public void register(WeakReference<ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack> weakReference) {
        ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack iChangeBackgroundStatusCallBack;
        GuardManager guardManager;
        QLog.i("GdtSplashBackgroundManager", 1, "[register]");
        if (weakReference != null) {
            iChangeBackgroundStatusCallBack = weakReference.get();
        } else {
            iChangeBackgroundStatusCallBack = null;
        }
        if (iChangeBackgroundStatusCallBack == null) {
            QLog.i("GdtSplashBackgroundManager", 1, "[register] callBackToRegister is null");
            return;
        }
        if (a(iChangeBackgroundStatusCallBack) != null) {
            QLog.i("GdtSplashBackgroundManager", 1, "[register] duplicate callBackToRegister");
            return;
        }
        this.f109354a.add(weakReference);
        if (!this.f109356c.getAndSet(true) && (guardManager = GuardManager.sInstance) != null) {
            guardManager.registerCallBack(this.f109355b);
        }
    }

    @Override // com.qq.e.comm.pi.ITGChangeBackgroundStatusManager
    public void unRegister(WeakReference<ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack> weakReference) {
        ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack iChangeBackgroundStatusCallBack;
        GuardManager guardManager;
        QLog.i("GdtSplashBackgroundManager", 1, "[unRegister]");
        if (weakReference != null) {
            iChangeBackgroundStatusCallBack = weakReference.get();
        } else {
            iChangeBackgroundStatusCallBack = null;
        }
        if (iChangeBackgroundStatusCallBack == null) {
            QLog.i("GdtSplashBackgroundManager", 1, "[unRegister] callBackToUnregister is null");
            return;
        }
        WeakReference<ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack> a16 = a(iChangeBackgroundStatusCallBack);
        if (a16 != null) {
            this.f109354a.remove(a16);
        }
        if (this.f109354a.size() > 0) {
            QLog.i("GdtSplashBackgroundManager", 1, "[unRegister] no need to unRegister GuardManager");
        } else if (this.f109356c.getAndSet(false) && (guardManager = GuardManager.sInstance) != null) {
            guardManager.unregisterCallback(this.f109355b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static class a implements IGuardInterface {

        /* renamed from: d, reason: collision with root package name */
        private final CopyOnWriteArrayList<WeakReference<ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack>> f109357d;

        a(CopyOnWriteArrayList<WeakReference<ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack>> copyOnWriteArrayList) {
            this.f109357d = copyOnWriteArrayList;
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack iChangeBackgroundStatusCallBack;
            QLog.i("GdtSplashBackgroundManager", 1, "[onApplicationBackground]");
            Iterator<WeakReference<ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack>> it = this.f109357d.iterator();
            while (it.hasNext()) {
                WeakReference<ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack> next = it.next();
                if (next != null) {
                    iChangeBackgroundStatusCallBack = next.get();
                } else {
                    iChangeBackgroundStatusCallBack = null;
                }
                if (iChangeBackgroundStatusCallBack != null) {
                    iChangeBackgroundStatusCallBack.onBackground();
                }
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack iChangeBackgroundStatusCallBack;
            QLog.i("GdtSplashBackgroundManager", 1, "[onApplicationForeground]");
            Iterator<WeakReference<ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack>> it = this.f109357d.iterator();
            while (it.hasNext()) {
                WeakReference<ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack> next = it.next();
                if (next != null) {
                    iChangeBackgroundStatusCallBack = next.get();
                } else {
                    iChangeBackgroundStatusCallBack = null;
                }
                if (iChangeBackgroundStatusCallBack != null) {
                    iChangeBackgroundStatusCallBack.onForeground();
                }
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean z16) {
        }
    }
}
