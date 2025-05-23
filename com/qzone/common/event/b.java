package com.qzone.common.event;

import com.qzone.common.event.IObserver;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<IObserver> f45863a;

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<Object> f45864b;

    /* renamed from: c, reason: collision with root package name */
    public final int f45865c;

    /* renamed from: d, reason: collision with root package name */
    private final int f45866d;

    /* renamed from: e, reason: collision with root package name */
    private final int f45867e;

    public b(IObserver iObserver, Object obj, int i3) {
        if (iObserver != null) {
            this.f45863a = new WeakReference<>(iObserver);
            this.f45867e = iObserver.hashCode();
            if (obj != null) {
                this.f45864b = new WeakReference<>(obj);
                this.f45866d = obj.hashCode();
            } else {
                this.f45864b = null;
                this.f45866d = 0;
            }
            this.f45865c = i3;
            return;
        }
        throw new NullPointerException("observer cannot be null");
    }

    public IObserver a() {
        return this.f45863a.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Event event) {
        IObserver a16 = a();
        if (a16 != null) {
            int i3 = this.f45865c;
            if (i3 == 0) {
                ((IObserver.main) a16).onEventUIThread(event);
                return;
            }
            if (1 == i3) {
                ((IObserver.async) a16).onEventAsync(event);
            } else if (2 == i3) {
                ((IObserver.post) a16).onEventPostThread(event);
            } else if (3 == i3) {
                ((IObserver.background) a16).onEventBackgroundThread(event);
            }
        }
    }

    public int hashCode() {
        return ((((this.f45865c + 31) * 31) + this.f45867e) * 31) + this.f45866d;
    }

    public String toString() {
        return "ObserverBean [observer=" + a() + " threadMode=" + this.f45865c + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f45865c == bVar.f45865c && this.f45867e == bVar.f45867e && this.f45866d == bVar.f45866d;
    }
}
