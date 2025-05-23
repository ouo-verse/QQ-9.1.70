package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
final class h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, Object obj2) {
        if (obj != null) {
            if (obj2 != null) {
                return;
            }
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
        throw new NullPointerException("null key in entry: null=" + obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static int b(int i3, String str) {
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(int i3, String str) {
        if (i3 > 0) {
            return;
        }
        throw new IllegalArgumentException(str + " must be positive but was: " + i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(boolean z16) {
        com.google.common.base.j.t(z16, "no calls to next() since the last call to remove()");
    }
}
