package com.tencent.luggage.wxa.ic;

import android.os.Build;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.luggage.wxa.uk.x;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class r0 {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements x.e {
        @Override // com.tencent.luggage.wxa.uk.x.e
        public void a(String str) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.SourceMapUtil", "hy: Inject '%s' Script Success: %s", "WASourceMap.js", str);
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void b(String str) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.SourceMapUtil", "hy: Inject '%s' Script Failed: %s", "WASourceMap.js", str);
        }
    }

    public static void a(d dVar, com.tencent.luggage.wxa.ei.j jVar) {
        com.tencent.luggage.wxa.uk.x.a(jVar, a(dVar), new a());
        jVar.evaluateJavascript(a(), null);
    }

    public static String a(d dVar) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.SourceMapUtil", "hy: injecting sourcemap.js");
        if (dVar == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.SourceMapUtil", "hy: not valid runtime");
            return "";
        }
        if (dVar.getRuntime() == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.SourceMapUtil", "hy: runtime not prepared. do not try to inject sourcemap.js. maybe preloading");
            return "";
        }
        if (e.a.b(dVar.getRuntime().l0())) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.SourceMapUtil", "current running type is ReleaseType do not need to inject sourceMap.");
            return "";
        }
        com.tencent.luggage.wxa.rc.q qVar = (com.tencent.luggage.wxa.rc.q) dVar.b(com.tencent.luggage.wxa.rc.q.class);
        if (qVar == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.SourceMapUtil", "execSourceMapScript NULL reader");
            return "";
        }
        return qVar.g("WASourceMap.js");
    }

    public static String a(g gVar, String str, String str2) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.SourceMapUtil", "hy: getting sourcemap %s, %s", str, str2);
        if (gVar != null && str != null && str.length() != 0) {
            if (a(gVar)) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.SourceMapUtil", "current running type is ReleaseType do not need to inject sourceMap.");
                return "";
            }
            String c16 = com.tencent.luggage.wxa.mc.k0.c(gVar, str + ".map");
            if (c16 != null && c16.length() != 0) {
                return String.format("typeof __wxSourceMap !== 'undefined' && (__wxSourceMap['%s'] = %s)", str2 + str, c16);
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.SourceMapUtil", "sourceMap of the script(%s) is null or nil.", str);
            return "";
        }
        com.tencent.luggage.wxa.tn.w.f("MicroMsg.SourceMapUtil", "runtime or jsRuntime or filePath is null.");
        return "";
    }

    public static boolean a(g gVar) {
        return e.a.b(gVar.l0());
    }

    public static String a() {
        return String.format("typeof __wxSourceMap !== 'undefined' && (__wxSourceMap.__system = 'Android %s')", Build.VERSION.RELEASE);
    }
}
