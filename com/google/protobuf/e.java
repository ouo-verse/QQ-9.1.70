package com.google.protobuf;

/* compiled from: P */
/* loaded from: classes2.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f35844a = a("libcore.io.Memory");

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f35845b;

    static {
        boolean z16;
        if (a("org.robolectric.Robolectric") != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        f35845b = z16;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> b() {
        return f35844a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        if (f35844a != null && !f35845b) {
            return true;
        }
        return false;
    }
}
