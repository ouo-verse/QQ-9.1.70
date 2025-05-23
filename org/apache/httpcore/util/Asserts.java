package org.apache.httpcore.util;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Asserts {
    public static void check(boolean z16, String str) {
        if (!z16) {
            throw new IllegalStateException(str);
        }
    }

    public static void notBlank(CharSequence charSequence, String str) {
        if (!TextUtils.isBlank(charSequence)) {
            return;
        }
        throw new IllegalStateException(str + " is blank");
    }

    public static void notEmpty(CharSequence charSequence, String str) {
        if (!TextUtils.isEmpty(charSequence)) {
            return;
        }
        throw new IllegalStateException(str + " is empty");
    }

    public static void notNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new IllegalStateException(str + " is null");
    }

    public static void check(boolean z16, String str, Object... objArr) {
        if (!z16) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static void check(boolean z16, String str, Object obj) {
        if (!z16) {
            throw new IllegalStateException(String.format(str, obj));
        }
    }
}
