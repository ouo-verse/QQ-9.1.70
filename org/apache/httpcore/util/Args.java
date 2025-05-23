package org.apache.httpcore.util;

import java.util.Collection;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Args {
    public static void check(boolean z16, String str) {
        if (!z16) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T extends CharSequence> T containsNoBlanks(T t16, String str) {
        if (t16 != null) {
            if (t16.length() != 0) {
                if (!TextUtils.containsBlanks(t16)) {
                    return t16;
                }
                throw new IllegalArgumentException(str + " may not contain blanks");
            }
            throw new IllegalArgumentException(str + " may not be empty");
        }
        throw new IllegalArgumentException(str + " may not be null");
    }

    public static <T extends CharSequence> T notBlank(T t16, String str) {
        if (t16 != null) {
            if (!TextUtils.isBlank(t16)) {
                return t16;
            }
            throw new IllegalArgumentException(str + " may not be blank");
        }
        throw new IllegalArgumentException(str + " may not be null");
    }

    public static <T extends CharSequence> T notEmpty(T t16, String str) {
        if (t16 != null) {
            if (!TextUtils.isEmpty(t16)) {
                return t16;
            }
            throw new IllegalArgumentException(str + " may not be empty");
        }
        throw new IllegalArgumentException(str + " may not be null");
    }

    public static int notNegative(int i3, String str) {
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalArgumentException(str + " may not be negative");
    }

    public static <T> T notNull(T t16, String str) {
        if (t16 != null) {
            return t16;
        }
        throw new IllegalArgumentException(str + " may not be null");
    }

    public static int positive(int i3, String str) {
        if (i3 > 0) {
            return i3;
        }
        throw new IllegalArgumentException(str + " may not be negative or zero");
    }

    public static void check(boolean z16, String str, Object... objArr) {
        if (!z16) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static long notNegative(long j3, String str) {
        if (j3 >= 0) {
            return j3;
        }
        throw new IllegalArgumentException(str + " may not be negative");
    }

    public static long positive(long j3, String str) {
        if (j3 > 0) {
            return j3;
        }
        throw new IllegalArgumentException(str + " may not be negative or zero");
    }

    public static void check(boolean z16, String str, Object obj) {
        if (!z16) {
            throw new IllegalArgumentException(String.format(str, obj));
        }
    }

    public static <E, T extends Collection<E>> T notEmpty(T t16, String str) {
        if (t16 != null) {
            if (!t16.isEmpty()) {
                return t16;
            }
            throw new IllegalArgumentException(str + " may not be empty");
        }
        throw new IllegalArgumentException(str + " may not be null");
    }
}
