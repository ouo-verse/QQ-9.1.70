package kotlinx.coroutines.debug.internal;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: P */
/* loaded from: classes28.dex */
public final /* synthetic */ class a {
    public static /* synthetic */ boolean a(AtomicReferenceArray atomicReferenceArray, int i3, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i3, obj, obj2)) {
            if (atomicReferenceArray.get(i3) != obj) {
                return false;
            }
        }
        return true;
    }
}
