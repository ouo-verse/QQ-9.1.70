package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
final class p {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i3, double d16) {
        int max = Math.max(i3, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max > ((int) (d16 * highestOneBit))) {
            int i16 = highestOneBit << 1;
            if (i16 <= 0) {
                return 1073741824;
            }
            return i16;
        }
        return highestOneBit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i3) {
        return (int) (Integer.rotateLeft((int) (i3 * (-862048943)), 15) * 461845907);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(@NullableDecl Object obj) {
        int hashCode;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return b(hashCode);
    }
}
