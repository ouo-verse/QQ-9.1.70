package com.tencent.luggage.wxa.q7;

import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f138048a = new r();

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f138049b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f138050c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f138051d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f138052e;

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f138053f;

    /* JADX WARN: Code restructure failed: missing block: B:4:0x001b, code lost:
    
        if (r0 != false) goto L6;
     */
    static {
        boolean z16;
        boolean contains$default;
        if (!a()) {
            z16 = false;
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) "4.0.0", (CharSequence) "-wxg", false, 2, (Object) null);
        }
        z16 = true;
        f138049b = z16;
        f138050c = true;
        f138051d = a();
        f138052e = a();
        f138053f = z16;
    }

    public static final boolean a() {
        boolean contains$default;
        boolean contains$default2;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) "4.0.0", (CharSequence) "-SNAPSHOT", false, 2, (Object) null);
        if (!contains$default) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) "4.0.0", (CharSequence) "-snapshot", false, 2, (Object) null);
            if (!contains$default2) {
                return false;
            }
        }
        return true;
    }

    public final boolean b() {
        return f138049b;
    }

    public final boolean c() {
        return f138050c;
    }

    public final boolean d() {
        return f138051d;
    }

    public final boolean e() {
        return f138053f;
    }

    public final boolean f() {
        return f138052e;
    }
}
