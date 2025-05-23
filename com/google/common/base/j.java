package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public final class j {
    private static String a(int i3, int i16, @NullableDecl String str) {
        if (i3 < 0) {
            return n.a("%s (%s) must not be negative", str, Integer.valueOf(i3));
        }
        if (i16 >= 0) {
            return n.a("%s (%s) must be less than size (%s)", str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        throw new IllegalArgumentException("negative size: " + i16);
    }

    private static String b(int i3, int i16, @NullableDecl String str) {
        if (i3 < 0) {
            return n.a("%s (%s) must not be negative", str, Integer.valueOf(i3));
        }
        if (i16 >= 0) {
            return n.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        throw new IllegalArgumentException("negative size: " + i16);
    }

    private static String c(int i3, int i16, int i17) {
        if (i3 >= 0 && i3 <= i17) {
            if (i16 >= 0 && i16 <= i17) {
                return n.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i16), Integer.valueOf(i3));
            }
            return b(i16, i17, "end index");
        }
        return b(i3, i17, "start index");
    }

    public static void d(boolean z16) {
        if (z16) {
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z16, @NullableDecl Object obj) {
        if (z16) {
        } else {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z16, @NullableDecl String str, int i3) {
        if (z16) {
        } else {
            throw new IllegalArgumentException(n.a(str, Integer.valueOf(i3)));
        }
    }

    public static void g(boolean z16, @NullableDecl String str, long j3) {
        if (z16) {
        } else {
            throw new IllegalArgumentException(n.a(str, Long.valueOf(j3)));
        }
    }

    public static void h(boolean z16, @NullableDecl String str, long j3, @NullableDecl Object obj) {
        if (z16) {
        } else {
            throw new IllegalArgumentException(n.a(str, Long.valueOf(j3), obj));
        }
    }

    public static void i(boolean z16, @NullableDecl String str, @NullableDecl Object obj) {
        if (z16) {
        } else {
            throw new IllegalArgumentException(n.a(str, obj));
        }
    }

    public static void j(boolean z16, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2) {
        if (z16) {
        } else {
            throw new IllegalArgumentException(n.a(str, obj, obj2));
        }
    }

    @CanIgnoreReturnValue
    public static int k(int i3, int i16) {
        return l(i3, i16, "index");
    }

    @CanIgnoreReturnValue
    public static int l(int i3, int i16, @NullableDecl String str) {
        if (i3 >= 0 && i3 < i16) {
            return i3;
        }
        throw new IndexOutOfBoundsException(a(i3, i16, str));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T m(@NonNullDecl T t16) {
        t16.getClass();
        return t16;
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T n(@NonNullDecl T t16, @NullableDecl Object obj) {
        if (t16 != null) {
            return t16;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T o(@NonNullDecl T t16, @NullableDecl String str, @NullableDecl Object obj) {
        if (t16 != null) {
            return t16;
        }
        throw new NullPointerException(n.a(str, obj));
    }

    @CanIgnoreReturnValue
    public static int p(int i3, int i16) {
        return q(i3, i16, "index");
    }

    @CanIgnoreReturnValue
    public static int q(int i3, int i16, @NullableDecl String str) {
        if (i3 >= 0 && i3 <= i16) {
            return i3;
        }
        throw new IndexOutOfBoundsException(b(i3, i16, str));
    }

    public static void r(int i3, int i16, int i17) {
        if (i3 >= 0 && i16 >= i3 && i16 <= i17) {
        } else {
            throw new IndexOutOfBoundsException(c(i3, i16, i17));
        }
    }

    public static void s(boolean z16) {
        if (z16) {
        } else {
            throw new IllegalStateException();
        }
    }

    public static void t(boolean z16, @NullableDecl Object obj) {
        if (z16) {
        } else {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void u(boolean z16, @NullableDecl String str, int i3) {
        if (z16) {
        } else {
            throw new IllegalStateException(n.a(str, Integer.valueOf(i3)));
        }
    }

    public static void v(boolean z16, @NullableDecl String str, long j3) {
        if (z16) {
        } else {
            throw new IllegalStateException(n.a(str, Long.valueOf(j3)));
        }
    }

    public static void w(boolean z16, @NullableDecl String str, @NullableDecl Object obj) {
        if (z16) {
        } else {
            throw new IllegalStateException(n.a(str, obj));
        }
    }
}
