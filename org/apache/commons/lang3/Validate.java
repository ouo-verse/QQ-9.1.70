package org.apache.commons.lang3;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Validate {
    public static <T> T notNull(T t16, String str, Object... objArr) {
        if (t16 != null) {
            return t16;
        }
        throw new NullPointerException(String.format(str, objArr));
    }
}
