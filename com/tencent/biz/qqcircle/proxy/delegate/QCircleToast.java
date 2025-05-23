package com.tencent.biz.qqcircle.proxy.delegate;

import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import com.tencent.biz.qui.toast.b;
import com.tencent.biz.richframework.AutoShadowPluginRuntime;
import com.tencent.mobileqq.auto.engine.lib.IToastDelegate;
import com.tencent.mobileqq.auto.engine.lib.delegateimpl.ASToastImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleToast {

    /* renamed from: b, reason: collision with root package name */
    private static volatile QCircleToast f91642b = null;

    /* renamed from: c, reason: collision with root package name */
    public static int f91643c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static int f91644d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static int f91645e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static int f91646f = 2;

    /* renamed from: g, reason: collision with root package name */
    private static final Set<String> f91647g = new HashSet();

    /* renamed from: h, reason: collision with root package name */
    private static final Set<String> f91648h = new HashSet();

    /* renamed from: i, reason: collision with root package name */
    private static final List<WeakReference<a>> f91649i = new CopyOnWriteArrayList();

    /* renamed from: a, reason: collision with root package name */
    private IToastDelegate f91650a;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.proxy.delegate.QCircleToast$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f91657d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f91658e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f91659f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f91660h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f91661i;

        @Override // java.lang.Runnable
        public void run() {
            Toast v3;
            boolean z16 = this.f91657d;
            if (!z16) {
                QLog.e("QCircleToast", 1, "[makeTextAndShow] return. force =", Boolean.valueOf(z16), ", QFSRuntimeUtil.isInQCircleNew() =", Boolean.valueOf(kc0.a.d()));
                return;
            }
            if (this.f91658e) {
                try {
                    v3 = b.j(AutoShadowPluginRuntime.getInstance().getApplication(), this.f91659f);
                    v3.show();
                } catch (Throwable th5) {
                    QLog.e("QCircleToast", 1, "[makeTextAndShow] error", th5);
                    v3 = QCircleToast.v(this.f91660h, this.f91659f, this.f91661i);
                }
            } else {
                v3 = QCircleToast.v(this.f91660h, this.f91659f, this.f91661i);
            }
            QCircleToast.b(v3, this.f91661i);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void a(Toast toast, long j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Toast toast, int i3) {
        if (toast == null) {
            return;
        }
        for (WeakReference<a> weakReference : f91649i) {
            if (weakReference != null) {
                a aVar = weakReference.get();
                if (aVar == null) {
                    f91649i.remove(weakReference);
                } else {
                    aVar.a(toast, i3);
                }
            }
        }
    }

    private static synchronized QCircleToast c() {
        QCircleToast qCircleToast;
        synchronized (QCircleToast.class) {
            if (f91642b == null) {
                synchronized (QCircleToast.class) {
                    if (f91642b == null) {
                        f91642b = new QCircleToast();
                    }
                }
            }
            qCircleToast = f91642b;
        }
        return qCircleToast;
    }

    private IToastDelegate d() {
        return this.f91650a;
    }

    public static void e(IToastDelegate iToastDelegate) {
        c().r(iToastDelegate);
    }

    public static boolean f() {
        if (f91648h.size() > 0) {
            return true;
        }
        return false;
    }

    public static boolean g() {
        if (f91647g.size() > 0) {
            return true;
        }
        return false;
    }

    public static void h(int i3, int i16) {
        j(f91644d, AutoShadowPluginRuntime.getInstance().getApplication().getResources().getString(i3), i16);
    }

    public static void i(int i3, int i16, int i17) {
        j(i3, AutoShadowPluginRuntime.getInstance().getApplication().getString(i16), i17);
    }

    public static void j(int i3, String str, int i16) {
        k(i3, str, i16, false);
    }

    public static void k(int i3, String str, int i16, boolean z16) {
        l(i3, str, i16, z16, true);
    }

    public static void l(int i3, String str, int i16, boolean z16, boolean z17) {
        m(i3, str, i16, z16, z17, 0L, 0);
    }

    public static void m(int i3, String str, int i16, boolean z16, boolean z17, long j3, int i17) {
        n(i3, str, i16, z16, z17, j3, i17, null);
    }

    public static void n(final int i3, final String str, final int i16, final boolean z16, final boolean z17, final long j3, final int i17, @Nullable final Consumer<Toast> consumer) {
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.proxy.delegate.QCircleToast.1
            @Override // java.lang.Runnable
            public void run() {
                Toast v3;
                String a16 = kc0.a.a();
                if (a16 != null && kc0.a.e(a16)) {
                    if (!z16 && !kc0.a.d()) {
                        QLog.e("QCircleToast", 1, "[makeTextAndShow] return. force =", Boolean.valueOf(z16), ", QFSRuntimeUtil.isInQCircleNew() =", Boolean.valueOf(kc0.a.d()));
                        return;
                    }
                    if (z17) {
                        try {
                            v3 = b.j(AutoShadowPluginRuntime.getInstance().getApplication(), str);
                            v3.show();
                        } catch (Throwable th5) {
                            QLog.e("QCircleToast", 1, "[makeTextAndShow] error", th5);
                            v3 = QCircleToast.v(i3, str, i16);
                        }
                    } else {
                        v3 = QCircleToast.v(i3, str, i16);
                    }
                    Consumer consumer2 = consumer;
                    if (consumer2 != null) {
                        consumer2.accept(v3);
                    }
                    QCircleToast.b(v3, i16);
                    return;
                }
                QLog.e("QCircleToast", 1, "[makeTextAndShow] return. !QFSRuntimeUtil.isProcessForeground(), processName=" + a16 + ", retryCount=" + i17);
                int i18 = i17;
                if (i18 > 0) {
                    QCircleToast.m(i3, str, i16, z16, z17, j3, i18 - 1);
                }
            }
        }, j3);
    }

    public static void o(String str, int i3) {
        j(f91644d, str, i3);
    }

    public static void p(String str, int i3, boolean z16) {
        k(f91644d, str, i3, z16);
    }

    public static void q(a aVar) {
        if (aVar == null) {
            return;
        }
        for (WeakReference<a> weakReference : f91649i) {
            if (weakReference != null) {
                a aVar2 = weakReference.get();
                if (aVar2 == null) {
                    f91649i.remove(weakReference);
                } else if (aVar2 == aVar) {
                    return;
                }
            }
        }
        f91649i.add(new WeakReference<>(aVar));
    }

    private void r(IToastDelegate iToastDelegate) {
        if (iToastDelegate != null) {
            this.f91650a = iToastDelegate;
            f91643c = iToastDelegate.getIconTypeNone();
            f91644d = iToastDelegate.getIconTypeDefault();
            f91645e = iToastDelegate.getIconTypeError();
            f91646f = iToastDelegate.getIconTypeSuccess();
            return;
        }
        Log.d("QCircleToast", "setDelegate input delegate is null!");
    }

    public static void s(String str, boolean z16) {
        if (z16) {
            f91648h.add(str);
        } else {
            f91648h.remove(str);
        }
        QLog.d("QCircleToast", 1, "[setFullScene] hashcode: " + str + ", state: " + z16);
    }

    public static void t(String str, boolean z16) {
        if (z16) {
            f91647g.add(str);
        } else {
            f91647g.remove(str);
        }
        QLog.d("QCircleToast", 1, "[setImmersiveScene] hashcode: " + str + ", state: " + z16);
    }

    public static void u(String str, int i3, boolean z16) {
        l(f91644d, str, i3, z16, true);
    }

    public static Toast v(int i3, String str, int i16) {
        IToastDelegate d16 = c().d();
        if (d16 != null) {
            return d16.makeTextAndShow(i3, str, i16);
        }
        QLog.e("QCircleToast", 1, "makeTextAndShow() get delegate is null!");
        Toast makeTextAndShow = new ASToastImpl().makeTextAndShow(i3, str, i16);
        QLog.e("QCircleToast", 1, "[showToastByDelegate] toast: " + makeTextAndShow + " | msg: " + str);
        return makeTextAndShow;
    }

    public static Toast w(int i3, String str, int i16) {
        IToastDelegate d16 = c().d();
        if (d16 != null) {
            return d16.showToastByNativeToast(i3, str, i16);
        }
        QLog.e("QCircleToast", 1, "showToastByNativeToast() get delegate is null!");
        Toast showToastByNativeToast = new ASToastImpl().showToastByNativeToast(i3, str, i16);
        QLog.e("QCircleToast", 1, "[showToastByNativeToast] toast: " + showToastByNativeToast + " | msg: " + str);
        return showToastByNativeToast;
    }

    public static void x(a aVar) {
        if (aVar == null) {
            return;
        }
        for (WeakReference<a> weakReference : f91649i) {
            if (weakReference != null) {
                a aVar2 = weakReference.get();
                if (aVar2 == null) {
                    f91649i.remove(weakReference);
                } else if (aVar2 == aVar) {
                    f91649i.remove(weakReference);
                }
            }
        }
    }
}
