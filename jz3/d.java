package jz3;

import com.tencent.raft.standard.log.IRLog;
import com.tencent.rdelivery.reshub.core.j;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d {
    public static void a(String str, String str2) {
        g().d("ResHub." + str, str2);
    }

    public static void b(String str, String str2, Throwable th5) {
        g().d("ResHub." + str, str2, th5);
    }

    public static void c(String str, String str2) {
        g().e("ResHub." + str, str2);
    }

    public static void d(String str, String str2, Throwable th5) {
        g().e("ResHub." + str, str2, th5);
    }

    public static void e(String str, String str2) {
        g().i("ResHub." + str, str2);
    }

    public static void f(String str, String str2, Throwable th5) {
        g().i("ResHub." + str, str2, th5);
    }

    private static IRLog g() {
        return j.L.t();
    }

    public static void h(String str, String str2) {
        g().v("ResHub." + str, str2);
    }

    public static void i(String str, String str2) {
        g().w("ResHub." + str, str2);
    }

    public static void j(String str, String str2, Throwable th5) {
        g().w("ResHub." + str, str2, th5);
    }
}
