package com.tencent.luggage.wxa.aa;

import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static b f121003a = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements b {
        @Override // com.tencent.luggage.wxa.aa.e.b
        public boolean a() {
            return com.tencent.luggage.wxa.tn.e.f141569k;
        }

        @Override // com.tencent.luggage.wxa.aa.e.b
        public boolean b(String str) {
            w.d("MicroMsg.exp.ExpansionsProxy", " System.loadLibrary(), name = " + str);
            System.loadLibrary(str);
            return true;
        }

        @Override // com.tencent.luggage.wxa.aa.e.b
        public boolean a(String str) {
            return !com.tencent.luggage.wxa.tn.e.f141569k;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        boolean a();

        boolean a(String str);

        boolean b(String str);
    }

    public static boolean a() {
        return f121003a.a();
    }

    public static boolean b(String str) {
        return f121003a.b(str);
    }

    public static boolean a(String str) {
        return f121003a.a(str);
    }
}
