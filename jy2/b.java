package jy2;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentLinkedQueue<WeakReference<T>> f411159a = new ConcurrentLinkedQueue<>();

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a<T> {
        void onNotify(T t16);
    }

    public void a(T t16) {
        if (t16 == null) {
            return;
        }
        synchronized (this.f411159a) {
            Iterator<WeakReference<T>> it = this.f411159a.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                T t17 = it.next().get();
                if (t17 == null) {
                    it.remove();
                } else if (t17 == t16) {
                    z16 = true;
                }
            }
            if (!z16) {
                this.f411159a.add(new WeakReference<>(t16));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(a<T> aVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        synchronized (this.f411159a) {
            if (this.f411159a.size() > 0) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue(this.f411159a);
            } else {
                concurrentLinkedQueue = null;
            }
        }
        if (concurrentLinkedQueue != null) {
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                Object obj = ((WeakReference) it.next()).get();
                if (obj != null) {
                    aVar.onNotify(obj);
                }
            }
        }
    }

    public void c(T t16) {
        if (t16 == null) {
            return;
        }
        synchronized (this.f411159a) {
            Iterator<WeakReference<T>> it = this.f411159a.iterator();
            while (it.hasNext()) {
                if (it.next().get() == t16) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
