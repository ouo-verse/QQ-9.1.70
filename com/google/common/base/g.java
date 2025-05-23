package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public final class g extends c {
    public static boolean a(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public static int b(@NullableDecl Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
