package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class eo {

    /* renamed from: a, reason: collision with root package name */
    static final int f388756a = b(1, 3);

    /* renamed from: b, reason: collision with root package name */
    static final int f388757b = b(1, 4);

    /* renamed from: c, reason: collision with root package name */
    static final int f388758c = b(2, 0);

    /* renamed from: d, reason: collision with root package name */
    static final int f388759d = b(3, 2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i3) {
        return i3 & 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i3, int i16) {
        return (i3 << 3) | i16;
    }

    public static int c(int i3) {
        return i3 >>> 3;
    }
}
