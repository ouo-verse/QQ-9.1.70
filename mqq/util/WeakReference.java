package mqq.util;

import java.lang.ref.ReferenceQueue;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WeakReference<T> extends java.lang.ref.WeakReference<T> {
    public WeakReference(T t16) {
        super(t16);
    }

    public boolean equals(Object obj) {
        T t16 = get();
        if (obj instanceof WeakReference) {
            obj = ((WeakReference) obj).get();
        }
        if (t16 != null && obj != null) {
            return t16.equals(obj);
        }
        return false;
    }

    public int hashCode() {
        T t16 = get();
        if (t16 != null) {
            return t16.hashCode();
        }
        return 0;
    }

    public WeakReference(T t16, ReferenceQueue<? super T> referenceQueue) {
        super(t16, referenceQueue);
    }
}
