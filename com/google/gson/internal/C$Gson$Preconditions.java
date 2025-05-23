package com.google.gson.internal;

/* renamed from: com.google.gson.internal.$Gson$Preconditions, reason: invalid class name */
/* loaded from: classes2.dex */
public final class C$Gson$Preconditions {
    C$Gson$Preconditions() {
        throw new UnsupportedOperationException();
    }

    public static void checkArgument(boolean z16) {
        if (z16) {
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T checkNotNull(T t16) {
        t16.getClass();
        return t16;
    }
}
