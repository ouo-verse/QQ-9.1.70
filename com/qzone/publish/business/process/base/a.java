package com.qzone.publish.business.process.base;

import com.qzone.publish.business.protocol.QzoneMediaUploadRequest;
import com.qzone.publish.utils.d;
import com.tencent.component.app.common.SmartParcelable;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class a<T extends SmartParcelable> {

    /* renamed from: d, reason: collision with root package name */
    protected final String f51048d;

    /* renamed from: e, reason: collision with root package name */
    protected final T f51049e;

    /* renamed from: f, reason: collision with root package name */
    protected final T f51050f;

    /* renamed from: h, reason: collision with root package name */
    private final List<WeakReference<InterfaceC0438a<T>>> f51051h;

    /* renamed from: i, reason: collision with root package name */
    private float f51052i;

    /* renamed from: m, reason: collision with root package name */
    private QzoneMediaUploadRequest.d f51053m;

    /* compiled from: P */
    /* renamed from: com.qzone.publish.business.process.base.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public interface InterfaceC0438a<T> {
        void a(a aVar, T t16, T t17, float f16);

        void b(a aVar, T t16);

        void c(a aVar, T t16, T t17);

        void d(a aVar, T t16, T t17);

        void e(a aVar, T t16);

        void f(a aVar, T t16, int i3, String str);
    }

    public a(T t16, InterfaceC0438a<T> interfaceC0438a) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f51051h = copyOnWriteArrayList;
        this.f51052i = 0.0f;
        String str = "upload2_" + getClass().getSimpleName();
        this.f51048d = str;
        this.f51049e = t16;
        this.f51050f = (T) d.a(t16);
        if (interfaceC0438a != null) {
            copyOnWriteArrayList.add(new WeakReference(interfaceC0438a));
        }
        QZLog.d(str, 1, "init");
    }

    public void a(InterfaceC0438a interfaceC0438a) {
        this.f51051h.add(new WeakReference<>(interfaceC0438a));
    }

    public void b() {
        InterfaceC0438a<T> interfaceC0438a;
        QZLog.d(this.f51048d, 1, "callCancel");
        for (WeakReference<InterfaceC0438a<T>> weakReference : this.f51051h) {
            if (weakReference != null && (interfaceC0438a = weakReference.get()) != null) {
                try {
                    interfaceC0438a.b(this, this.f51049e);
                } catch (Exception e16) {
                    xe.b.f447841a.d(e16);
                }
            }
        }
        i();
    }

    public void c(int i3, String str) {
        InterfaceC0438a<T> interfaceC0438a;
        QZLog.d(this.f51048d, 1, "callFailed");
        for (WeakReference<InterfaceC0438a<T>> weakReference : this.f51051h) {
            if (weakReference != null && (interfaceC0438a = weakReference.get()) != null) {
                try {
                    if (p()) {
                        T t16 = this.f51049e;
                        interfaceC0438a.d(this, t16, t16);
                    } else {
                        interfaceC0438a.f(this, this.f51049e, i3, str);
                    }
                } catch (Exception e16) {
                    xe.b.f447841a.d(e16);
                }
            }
        }
        i();
    }

    public void d(float f16) {
        InterfaceC0438a<T> interfaceC0438a;
        this.f51052i = f16;
        QZLog.d(this.f51048d, 4, "callProgress\uff1a" + f16);
        for (WeakReference<InterfaceC0438a<T>> weakReference : this.f51051h) {
            if (weakReference != null && (interfaceC0438a = weakReference.get()) != null) {
                try {
                    interfaceC0438a.a(this, this.f51049e, this.f51050f, f16);
                } catch (Exception e16) {
                    xe.b.f447841a.d(e16);
                }
            }
        }
    }

    public void e() {
        InterfaceC0438a<T> interfaceC0438a;
        QZLog.d(this.f51048d, 1, "callStart");
        for (WeakReference<InterfaceC0438a<T>> weakReference : this.f51051h) {
            if (weakReference != null && (interfaceC0438a = weakReference.get()) != null) {
                try {
                    interfaceC0438a.c(this, this.f51049e, this.f51050f);
                } catch (Exception e16) {
                    xe.b.f447841a.d(e16);
                }
            }
        }
    }

    public void f() {
        InterfaceC0438a<T> interfaceC0438a;
        QZLog.d(this.f51048d, 1, "callSucceed");
        for (WeakReference<InterfaceC0438a<T>> weakReference : this.f51051h) {
            if (weakReference != null && (interfaceC0438a = weakReference.get()) != null) {
                try {
                    interfaceC0438a.d(this, this.f51049e, this.f51050f);
                } catch (Exception e16) {
                    xe.b.f447841a.d(e16);
                }
            }
        }
        i();
    }

    public void g() {
        InterfaceC0438a<T> interfaceC0438a;
        QZLog.d(this.f51048d, 1, "callWaiting");
        for (WeakReference<InterfaceC0438a<T>> weakReference : this.f51051h) {
            if (weakReference != null && (interfaceC0438a = weakReference.get()) != null) {
                try {
                    interfaceC0438a.e(this, this.f51049e);
                } catch (Exception e16) {
                    xe.b.f447841a.d(e16);
                }
            }
        }
    }

    public abstract void h();

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        QZLog.d(this.f51048d, 1, "destroy");
        this.f51051h.clear();
    }

    public long j() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_MEDIA_PROCESS_NO_PROGRESS_TIMEOUT_DUATION, 42000L);
    }

    public abstract QZoneProcessType k();

    public float l() {
        return this.f51052i;
    }

    public abstract boolean m(Object obj);

    public void n(QzoneMediaUploadRequest.d dVar) {
        this.f51053m = dVar;
    }

    public abstract void o();

    protected abstract boolean p();

    public String toString() {
        return this.f51048d + hashCode();
    }
}
