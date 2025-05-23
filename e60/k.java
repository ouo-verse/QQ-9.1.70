package e60;

import android.content.Context;
import android.provider.Settings;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes4.dex */
public class k {

    /* renamed from: h, reason: collision with root package name */
    private static volatile k f395767h;

    /* renamed from: a, reason: collision with root package name */
    private i f395768a;

    /* renamed from: b, reason: collision with root package name */
    private Set<WeakReference<b>> f395769b;

    /* renamed from: d, reason: collision with root package name */
    private long f395771d;

    /* renamed from: c, reason: collision with root package name */
    private int f395770c = 1;

    /* renamed from: e, reason: collision with root package name */
    private boolean f395772e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f395773f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f395774g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends i {
        a(Context context, int i3) {
            super(context, i3);
        }

        @Override // e60.i
        public void f(int i3) {
            k.this.i(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        boolean M8(int i3);
    }

    k() {
        d();
        this.f395769b = new CopyOnWriteArraySet();
    }

    private void d() {
        if (!l()) {
            return;
        }
        a aVar = new a(QCircleApplication.getAPP(), 2);
        this.f395768a = aVar;
        QLog.d("QOC-QFSOrientationEventManager", 1, "[enabledPageOrientation] isDetectOrientation: " + aVar.c() + " | hashCode: " + hashCode());
        try {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: e60.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.n();
                }
            });
        } catch (Throwable th5) {
            QLog.e("QOC-QFSOrientationEventManager", 1, "[enabledPageOrientation] error: ", th5);
        }
    }

    private void e(int i3, int i16, int i17) {
        if (System.currentTimeMillis() - this.f395771d > i17 && o(i16)) {
            this.f395770c = i16;
            this.f395771d = System.currentTimeMillis();
            QLog.d("QOC-QFSOrientationEventManager", 1, "[executeIntervalTask] orientation: " + i3 + " | orientationType: " + h(i16));
        }
    }

    private WeakReference<b> f(b bVar) {
        b bVar2;
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        WeakReference<b> weakReference = null;
        for (WeakReference<b> weakReference2 : this.f395769b) {
            if (weakReference2 == null) {
                bVar2 = null;
            } else {
                bVar2 = weakReference2.get();
            }
            if (bVar2 == null) {
                copyOnWriteArraySet.add(weakReference2);
            }
            if (bVar2 == bVar) {
                weakReference = weakReference2;
            }
        }
        this.f395769b.removeAll(copyOnWriteArraySet);
        return weakReference;
    }

    private int g(int i3) {
        boolean k3 = k(i3);
        boolean k16 = k(this.f395770c);
        if (k3 && k16) {
            return 0;
        }
        return 1500;
    }

    private String h(int i3) {
        if (i3 == 1) {
            return "ORIENTATION_UP_VERTICAL";
        }
        if (i3 == 2) {
            return "ORIENTATION_DOWN_VERTICAL";
        }
        if (i3 == 3) {
            return "ORIENTATION_LEFT_ACROSS";
        }
        if (i3 == 4) {
            return "ORIENTATION_RIGHT_ACROSS";
        }
        return "ORIENTATION_UNKNOWN";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i3) {
        int i16;
        if (i3 == -1) {
            return;
        }
        if ((i3 >= 0 && i3 < 20) || i3 >= 340) {
            this.f395774g = false;
            i16 = 1;
        } else if (i3 >= 70 && i3 < 110) {
            i16 = 4;
        } else if (i3 >= 160 && i3 < 200) {
            this.f395774g = false;
            i16 = 2;
        } else if (i3 >= 250 && i3 < 290) {
            i16 = 3;
        } else {
            i16 = -1;
        }
        if (i16 == -1 || i16 == this.f395770c || this.f395774g) {
            return;
        }
        e(i3, i16, g(i16));
    }

    public static k j() {
        if (f395767h == null) {
            synchronized (k.class) {
                if (f395767h == null) {
                    f395767h = new k();
                }
            }
        }
        return f395767h;
    }

    private boolean k(int i3) {
        if (i3 != 3 && i3 != 4) {
            return false;
        }
        return true;
    }

    private boolean l() {
        if (uq3.c.P5() && uq3.c.b6()) {
            return true;
        }
        return false;
    }

    private boolean m() {
        boolean z16;
        try {
            if (Settings.System.getInt(QCircleApplication.getAPP().getContentResolver(), "accelerometer_rotation", 0) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.f395773f != z16) {
                QLog.d("QOC-QFSOrientationEventManager", 1, "[isSystemAutoRotateOn] isSystemAutoRotateOn: " + z16);
            }
            this.f395773f = z16;
            return z16;
        } catch (Throwable th5) {
            QLog.d("QOC-QFSOrientationEventManager", 1, "[isSystemAutoRotateOn] error: ", th5);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        if (this.f395768a.c()) {
            this.f395768a.e();
        } else {
            this.f395768a.d();
        }
    }

    private boolean o(int i3) {
        b bVar;
        boolean z16 = false;
        if (this.f395769b == null || !m() || !l() || this.f395772e) {
            return false;
        }
        for (WeakReference<b> weakReference : this.f395769b) {
            if (weakReference == null) {
                bVar = null;
            } else {
                bVar = weakReference.get();
            }
            if (bVar != null && bVar.M8(i3)) {
                z16 = true;
            }
        }
        return z16;
    }

    public void c() {
        if (this.f395768a != null) {
            return;
        }
        synchronized (k.class) {
            if (this.f395768a == null) {
                d();
            }
        }
    }

    public void p(b bVar) {
        if (bVar == null) {
            QLog.d("QOC-QFSOrientationEventManager", 1, "[registerScreenOrientationChange] listener should not be null.");
            return;
        }
        if (!l()) {
            return;
        }
        c();
        if (f(bVar) != null) {
            QLog.d("QOC-QFSOrientationEventManager", 1, "[registerScreenOrientationChange] current listener exist.");
            return;
        }
        QLog.d("QOC-QFSOrientationEventManager", 1, "[registerScreenOrientationChange] listener: " + bVar.hashCode() + " \uff5c listener: " + bVar);
        this.f395769b.add(new WeakReference<>(bVar));
    }

    public void q() {
        this.f395770c = 1;
    }

    public void r(boolean z16) {
        this.f395774g = z16;
    }

    public void s(b bVar) {
        if (bVar == null) {
            QLog.d("QOC-QFSOrientationEventManager", 1, "[unregisterScreenOrientationChange] listener should not be null.");
            return;
        }
        if (!l()) {
            return;
        }
        QLog.d("QOC-QFSOrientationEventManager", 1, "[unregisterScreenOrientationChange] listener: " + bVar.hashCode() + " \uff5c listener: " + bVar);
        this.f395769b.remove(f(bVar));
    }

    public void t(boolean z16) {
        QLog.d("QOC-QFSOrientationEventManager", 1, "[updatePanelShowing] isPanelShowing: " + z16);
        this.f395772e = z16;
    }
}
