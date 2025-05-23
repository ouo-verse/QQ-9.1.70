package com.google.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    static final Class<?> f35947a = c();

    public static t a() {
        t b16 = b("getEmptyRegistry");
        if (b16 == null) {
            return t.f35951e;
        }
        return b16;
    }

    private static final t b(String str) {
        Class<?> cls = f35947a;
        if (cls == null) {
            return null;
        }
        try {
            return (t) cls.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static Class<?> c() {
        try {
            int i3 = r.f35938k;
            return r.class;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
