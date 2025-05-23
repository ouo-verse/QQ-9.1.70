package com.tencent.mobileqq.guild.message;

import com.tencent.mobileqq.app.BusinessObserver;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class n implements BusinessObserver {
    public static final int C;
    public static final int D;

    /* renamed from: d, reason: collision with root package name */
    private static int f230673d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f230674e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static final int f230675f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f230676h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f230677i;

    /* renamed from: m, reason: collision with root package name */
    public static final int f230678m;

    static {
        int i3 = 0 + 1;
        int i16 = i3 + 1;
        f230675f = i3;
        int i17 = i16 + 1;
        f230676h = i16;
        int i18 = i17 + 1;
        f230677i = i17;
        int i19 = i18 + 1;
        f230678m = i18;
        int i26 = i19 + 1;
        C = i19;
        f230673d = i26 + 1;
        D = i26;
    }

    private void h(int i3, boolean z16, Object obj) {
        if (i3 != D) {
            return;
        }
        c();
    }

    private void i(int i3, boolean z16, Object obj) {
        String str;
        if (i3 != f230678m) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 1) {
                str = (String) objArr[0];
                a(str);
            }
        }
        str = "";
        a(str);
    }

    private void j(int i3, boolean z16, Object obj) {
        String str;
        if (i3 != f230674e) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 1) {
                str = (String) objArr[0];
                b(str);
            }
        }
        str = "";
        b(str);
    }

    private void k(int i3, boolean z16, Object obj) {
        String str;
        long j3;
        if (i3 != f230677i) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 2) {
                str = (String) objArr[0];
                j3 = ((Long) objArr[1]).longValue();
                d(z16, str, j3);
            }
        }
        str = "";
        j3 = 0;
        d(z16, str, j3);
    }

    private void l(int i3, boolean z16, Object obj) {
        String str;
        String str2;
        int i16;
        int i17;
        long j3;
        if (i3 != f230676h) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 5) {
                String str3 = (String) objArr[0];
                long longValue = ((Long) objArr[1]).longValue();
                int intValue = ((Integer) objArr[2]).intValue();
                int intValue2 = ((Integer) objArr[3]).intValue();
                str = str3;
                i16 = intValue;
                str2 = (String) objArr[4];
                j3 = longValue;
                i17 = intValue2;
                e(str, j3, i16, i17, str2);
            }
        }
        str = "";
        str2 = str;
        i16 = 0;
        i17 = 0;
        j3 = 0;
        e(str, j3, i16, i17, str2);
    }

    private void m(int i3, boolean z16, Object obj) {
        String str;
        long j3;
        if (i3 != f230675f) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 2) {
                str = (String) objArr[0];
                j3 = ((Long) objArr[1]).longValue();
                f(str, j3);
            }
        }
        str = "";
        j3 = 0;
        f(str, j3);
    }

    private void n(int i3, boolean z16, Object obj) {
        String str;
        long j3;
        if (i3 != C) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 2) {
                str = (String) objArr[0];
                j3 = ((Long) objArr[1]).longValue();
                g(str, j3);
            }
        }
        str = "";
        j3 = 0;
        g(str, j3);
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        j(i3, z16, obj);
        i(i3, z16, obj);
        m(i3, z16, obj);
        l(i3, z16, obj);
        k(i3, z16, obj);
        n(i3, z16, obj);
        h(i3, z16, obj);
    }

    protected void c() {
    }

    protected void a(String str) {
    }

    protected void b(String str) {
    }

    protected void f(String str, long j3) {
    }

    protected void g(String str, long j3) {
    }

    protected void d(boolean z16, String str, long j3) {
    }

    protected void e(String str, long j3, int i3, int i16, String str2) {
    }
}
