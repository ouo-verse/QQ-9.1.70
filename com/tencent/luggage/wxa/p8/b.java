package com.tencent.luggage.wxa.p8;

import com.tencent.luggage.wxa.h.a;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f137418a = false;

    /* renamed from: b, reason: collision with root package name */
    public static c f137419b = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements c {
        @Override // com.tencent.luggage.wxa.p8.b.c
        public String a(String str) {
            return com.tencent.luggage.wxa.w8.h.a(str);
        }

        @Override // com.tencent.luggage.wxa.p8.b.c
        public void loadLibrary(String str) {
            com.tencent.luggage.wxa.w8.h.a(str, null);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.p8.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6596b implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f137420a;

        public C6596b(c cVar) {
            this.f137420a = cVar;
        }

        @Override // com.tencent.luggage.wxa.h.a.b
        public void loadLibrary(String str) {
            this.f137420a.loadLibrary(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        String a(String str);

        void loadLibrary(String str);
    }

    public static void a(c cVar) {
        if (cVar != null) {
            f137419b = cVar;
            b(cVar);
        }
    }

    public static void b(c cVar) {
        com.tencent.luggage.wxa.h.a.a(new C6596b(cVar));
    }

    public static void b(String str) {
        f137419b.loadLibrary(str);
    }

    public static void a() {
        if (f137418a) {
            f.c("MagicBrush", "library already loaded", new Object[0]);
            return;
        }
        long a16 = com.tencent.luggage.wxa.w8.h.a();
        f.c("MagicBrush", "start loadLibraries", new Object[0]);
        long a17 = com.tencent.luggage.wxa.w8.h.a();
        f137419b.loadLibrary("mmv8");
        long a18 = com.tencent.luggage.wxa.w8.h.a();
        f137419b.loadLibrary("magicbrush");
        f137418a = true;
        f.c("MagicBrush", "total[%d]ms load mmv8 cost [%d]ms, load magicbrush cost [%d]ms", Long.valueOf(com.tencent.luggage.wxa.w8.h.a(a16)), Long.valueOf(a18 - a17), Long.valueOf(com.tencent.luggage.wxa.w8.h.a(a18)));
    }

    public static String a(String str) {
        return f137419b.a(str);
    }
}
