package com.tencent.luggage.wxa.m9;

import android.text.TextUtils;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.tn.z;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static boolean a(long j3) {
        return j3 >= 2000000;
    }

    public static v b(String str) {
        v vVar = new v(str);
        if (!vVar.e()) {
            try {
                vVar.c();
            } catch (Exception e16) {
                b.a("MicroMsg.Mix.FileUtil", e16, "createNewFile", new Object[0]);
            }
        }
        return vVar;
    }

    public static v c(String str) {
        v vVar = new v(str);
        if (!vVar.e()) {
            try {
                vVar.c();
            } catch (Exception e16) {
                b.a("MicroMsg.Mix.FileUtil", e16, "createNewFile", new Object[0]);
            }
        }
        return vVar;
    }

    public static long d(String str) {
        v vVar = new v(str);
        if (vVar.e()) {
            return vVar.s();
        }
        return 0L;
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        v vVar = new v(str);
        if (!vVar.e() || vVar.p()) {
            return false;
        }
        if (str.endsWith(".wav") && b(vVar)) {
            return false;
        }
        if (!str.endsWith(".wav") && a(vVar)) {
            return false;
        }
        return true;
    }

    public static v a() {
        v a16 = v.a(z.c().getExternalCacheDir());
        if (a16 == null) {
            a16 = v.a(z.c().getCacheDir());
        }
        v vVar = new v(a16, "MixAudio");
        vVar.w();
        return vVar;
    }

    public static String b(String str, String str2) {
        v a16 = a();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(c.a("" + str2.hashCode()));
        sb5.append("_cache.pcm");
        String sb6 = sb5.toString();
        v vVar = new v(a16.m() + "/" + str);
        if (!vVar.e()) {
            vVar.w();
        }
        b.b("MicroMsg.Mix.FileUtil", "path:%s, appId:%s", vVar.m(), str);
        return new v(vVar, sb6).m();
    }

    public static String a(String str) {
        return new v(a(), c.a("" + str.hashCode()) + "_convert.pcm").m();
    }

    public static void a(String str, ArrayList arrayList) {
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String b16 = b(str, (String) it.next());
                v vVar = new v(b16);
                if (vVar.e()) {
                    vVar.d();
                    b.b("MicroMsg.Mix.FileUtil", "delete pcm cache file, file:%s", b16);
                }
            }
        }
    }

    public static boolean b(v vVar) {
        return vVar.s() >= 5000000;
    }

    public static boolean a(v vVar) {
        return vVar.s() >= 2000000;
    }

    public static String a(String str, String str2) {
        v vVar = new v(a().m() + "/" + str);
        if (!vVar.e()) {
            vVar.w();
        }
        b.b("MicroMsg.Mix.FileUtil", "path:%s, appId:%s", vVar.m(), str);
        return new v(vVar, str2).m();
    }
}
