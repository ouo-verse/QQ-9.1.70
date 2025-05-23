package e6;

import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.requestengine.callbacks.QZoneServiceCallback;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected int f395741a;

    /* renamed from: b, reason: collision with root package name */
    private QZoneResult f395742b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<QZoneServiceCallback> f395743c;

    protected abstract QZoneResult a(int i3);

    public QZoneServiceCallback b() {
        WeakReference<QZoneServiceCallback> weakReference = this.f395743c;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public QZoneResult c() {
        if (this.f395742b == null) {
            this.f395742b = a(d());
        }
        return this.f395742b;
    }

    public int d() {
        return this.f395741a;
    }

    public void f(int i3) {
        this.f395741a = i3;
    }

    public void e(QZoneServiceCallback qZoneServiceCallback) {
        if (qZoneServiceCallback != null) {
            this.f395743c = new WeakReference<>(qZoneServiceCallback);
        }
    }
}
