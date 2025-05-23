package com.tencent.mapsdk.internal;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class gg {

    /* renamed from: a, reason: collision with root package name */
    public static final gg f148487a = a(0, 0);

    /* renamed from: b, reason: collision with root package name */
    public final int f148488b;

    /* renamed from: c, reason: collision with root package name */
    public final int f148489c;

    gg(int i3, int i16) {
        this.f148488b = i3;
        this.f148489c = i16;
    }

    public static gg a(int i3, int i16) {
        if (i3 <= i16) {
            return new gg(i3, i16);
        }
        throw new IllegalStateException("Range\u7684\u8303\u56f4\u6700\u5c0f\u503c\u4e0d\u80fd\u5927\u4e8e\u6700\u5927\u503c");
    }

    private gg b(gg ggVar) {
        return a(Math.min(this.f148488b, ggVar.f148488b), Math.max(this.f148489c, ggVar.f148489c));
    }

    private int b() {
        return this.f148489c;
    }

    public final boolean a(int i3) {
        return this.f148488b <= i3 && i3 <= this.f148489c;
    }

    private gg a(gg ggVar) {
        int i3;
        int i16 = this.f148489c;
        int i17 = ggVar.f148488b;
        if (i16 >= i17 && (i3 = this.f148488b) <= ggVar.f148489c) {
            return a(Math.max(i3, i17), Math.min(this.f148489c, ggVar.f148489c));
        }
        return f148487a;
    }

    private int a() {
        return this.f148488b;
    }
}
