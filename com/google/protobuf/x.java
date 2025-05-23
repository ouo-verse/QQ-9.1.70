package com.google.protobuf;

/* compiled from: P */
/* loaded from: classes2.dex */
final class x {

    /* renamed from: a, reason: collision with root package name */
    private static final u<?> f35959a = new w();

    /* renamed from: b, reason: collision with root package name */
    private static final u<?> f35960b = c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static u<?> a() {
        u<?> uVar = f35960b;
        if (uVar != null) {
            return uVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static u<?> b() {
        return f35959a;
    }

    private static u<?> c() {
        try {
            int i3 = v.f35956b;
            return (u) v.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
