package h00;

import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<c> f403969a;

    public a(c cVar) {
        this.f403969a = new WeakReference<>(cVar);
    }

    public boolean a() {
        WeakReference<c> weakReference = this.f403969a;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return b(this.f403969a.get());
    }

    public abstract boolean b(c cVar);
}
