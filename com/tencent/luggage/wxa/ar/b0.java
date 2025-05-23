package com.tencent.luggage.wxa.ar;

import com.tencent.xweb.util.HPatch;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b0 {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final b0 f121615a = new e();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b0 f121616a = new t();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static final b0 f121617a = new HPatch();
    }

    public static b0 a(int i3) {
        if (i3 == 1) {
            return a.f121615a;
        }
        if (i3 == 2) {
            return c.f121617a;
        }
        return b.f121616a;
    }

    public abstract int a(String str, String str2, String str3);
}
