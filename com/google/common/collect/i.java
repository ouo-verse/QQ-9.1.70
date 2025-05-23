package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public final class i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Collection<T> a(Iterable<T> iterable) {
        return (Collection) iterable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder b(int i3) {
        h.b(i3, "size");
        return new StringBuilder((int) Math.min(i3 * 8, 1073741824L));
    }
}
