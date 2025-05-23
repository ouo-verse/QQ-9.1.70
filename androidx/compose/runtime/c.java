package androidx.compose.runtime;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public final /* synthetic */ class c {
    public static /* synthetic */ boolean a(AtomicReference atomicReference, Object obj, Object obj2) {
        while (!atomicReference.compareAndSet(obj, obj2)) {
            if (atomicReference.get() != obj) {
                return false;
            }
        }
        return true;
    }
}
