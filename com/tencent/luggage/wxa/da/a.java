package com.tencent.luggage.wxa.da;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static b f124167a = new C6137a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.da.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6137a implements b {
        @Override // com.tencent.luggage.wxa.da.a.b
        public void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void loadLibrary(String str);
    }

    public static void a(b bVar) {
        if (bVar != null) {
            f124167a = bVar;
        }
    }

    public static void a() {
        f124167a.loadLibrary("mmlockstep");
    }
}
