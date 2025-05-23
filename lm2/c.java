package lm2;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    static b f415005a = new a();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class a implements b {
        a() {
        }

        @Override // lm2.b
        public void a(String str, String str2) {
            Log.w(str, str2);
        }

        @Override // lm2.b
        public void b(String str, String str2) {
            Log.i(str, str2);
        }

        @Override // lm2.b
        public void logD(String str, String str2) {
            Log.d(str, str2);
        }
    }

    public static void a(String str, String str2) {
        b bVar = f415005a;
        if (bVar != null) {
            bVar.logD("rmedia.ps." + str, str2);
        }
    }

    public static void b(String str, String str2) {
        b bVar = f415005a;
        if (bVar != null) {
            bVar.b("rmedia.ps." + str, str2);
        }
    }

    public static void c(String str, String str2) {
        b bVar = f415005a;
        if (bVar != null) {
            bVar.a("rmedia.ps." + str, str2);
        }
    }

    public static void d(b bVar) {
        f415005a = bVar;
    }
}
