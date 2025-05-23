package com.tencent.luggage.wxa.ck;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.wxa.ck.g;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.fd.j0;
import com.tencent.luggage.wxa.fd.m;
import com.tencent.luggage.wxa.fd.n;
import com.tencent.luggage.wxa.fd.x;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.luggage.wxa.tn.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f123597a;

        static {
            int[] iArr = new int[e.d.values().length];
            f123597a = iArr;
            try {
                iArr[e.d.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f123597a[e.d.BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f123597a[e.d.HANG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f123597a[e.d.LAUNCH_MINI_PROGRAM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void a(com.tencent.luggage.wxa.c5.e eVar, JSONObject jSONObject) {
        try {
            w.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "debugType\uff1a%d, debugLaunchInfo:%s", Integer.valueOf(eVar.S().f125811d), eVar.S().f130791c0);
            if (!e.a.a(eVar.S().f125811d) || TextUtils.isEmpty(eVar.S().f130791c0)) {
                return;
            }
            jSONObject.put("debugLaunchInfo", new JSONObject(eVar.S().f130791c0));
        } catch (JSONException e16) {
            w.b("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillDebugLaunchInfo ex = %s", e16);
        }
    }

    public static void b(com.tencent.luggage.wxa.c5.e eVar, JSONObject jSONObject) {
        try {
            jSONObject.put("isTransparentBackgroundSupport", eVar.S().t() == j0.TRANSPARENT && !eVar.S1());
        } catch (JSONException e16) {
            w.b("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillTransparentBackground ex = %s", e16);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void c(com.tencent.luggage.wxa.c5.e eVar, JSONObject jSONObject) {
        JSONObject jSONObject2;
        com.tencent.luggage.wxa.rc.l lVar;
        int i3;
        char c16;
        jSONObject.put("scene", eVar.L1().f122984c);
        jSONObject.put(StartupReportKey.SCENE_NOTE, eVar.L1().f122985d);
        jSONObject.put("sessionId", eVar.S().j());
        jSONObject.put("usedState", eVar.L1().f122986e);
        jSONObject.put("prescene", eVar.L1().f122982a);
        jSONObject.put("prescene_note", eVar.L1().f122983b);
        String str = eVar.S().f130805q0;
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("chatroomUsername", str);
        }
        String str2 = eVar.S().f130807s0;
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put("chatUsername", str2);
        }
        String str3 = eVar.S().f130806r0;
        if (!TextUtils.isEmpty(str3)) {
            jSONObject.put("shortLink", str3);
        }
        int i16 = eVar.S().i().f122992k;
        if (i16 == -1 && !w0.c(str2)) {
            i16 = eVar.S().f130808t0;
        }
        if (i16 != -1) {
            jSONObject.put("chatType", i16);
        }
        int i17 = eVar.S().i().f122993l;
        if (i17 > 0) {
            jSONObject.put("codeScene", i17);
        }
        if (!TextUtils.isEmpty(eVar.S().f130790b0)) {
            String str4 = eVar.S().f130790b0;
            if (1173 == eVar.L1().f122984c) {
                if (StringUtils.startsWith(eVar.L1().f122985d, "1")) {
                    str4 = com.tencent.luggage.wxa.jj.c.a(eVar, str4);
                } else {
                    str4 = a(eVar, str4);
                }
            } else if (1338 != eVar.L1().f122984c && 1339 != eVar.L1().f122984c) {
                if (1330 == eVar.L1().f122984c || 1331 == eVar.L1().f122984c) {
                    str4 = com.tencent.luggage.wxa.jj.c.a(eVar, str4);
                }
            } else {
                str4 = b(eVar, str4);
            }
            jSONObject2 = new JSONObject(str4);
        } else {
            jSONObject2 = null;
        }
        int i18 = eVar.L1().f122984c;
        if (1343 == i18 || 1345 == i18) {
            String str5 = eVar.S().f125813f;
            if (!TextUtils.isEmpty(str5)) {
                try {
                    Uri parse = Uri.parse(str5);
                    String queryParameter = parse.getQueryParameter("filePath");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
                        if (!queryParameter.startsWith("wxfile://")) {
                            lVar = eVar.P().createTempFileFrom(new v(queryParameter), "", false, iVar);
                        } else {
                            iVar.f141499a = queryParameter;
                            lVar = com.tencent.luggage.wxa.rc.l.OK;
                        }
                        if (lVar == com.tencent.luggage.wxa.rc.l.OK && !TextUtils.isEmpty((CharSequence) iVar.f141499a)) {
                            try {
                                String uri = a(parse, "filePath", (String) iVar.f141499a).toString();
                                eVar.S().f125813f = uri;
                                jSONObject.put("rawPath", uri);
                                jSONObject.getJSONObject("query").put("filePath", iVar.f141499a);
                                w.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "[+] ChatBot: img file path, orig:%s, converted:%s", queryParameter, iVar.f141499a);
                            } catch (Throwable th5) {
                                w.a("MicroMsg.AppBrandPageVisitStatisticsHelper", th5, "[-] failure.", new Object[0]);
                            }
                        } else {
                            w.b("MicroMsg.AppBrandPageVisitStatisticsHelper", "[-] ChatBot: fail to convert img file path. %s,%s,%s", lVar, queryParameter, iVar.f141499a);
                        }
                    } else {
                        w.b("MicroMsg.AppBrandPageVisitStatisticsHelper", "[-] ChatBot: img file path was not specified.");
                    }
                } catch (Throwable th6) {
                    w.a("MicroMsg.AppBrandPageVisitStatisticsHelper", th6, "[-] failure.", new Object[0]);
                }
            }
        }
        if (j0.TRANSPARENT == eVar.S().t() && !TextUtils.isEmpty(eVar.S().r())) {
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            f(eVar, jSONObject2);
        }
        if (jSONObject2 != null) {
            try {
                jSONObject.put("nativeExtraData", jSONObject2);
            } catch (JSONException e16) {
                w.a("MicroMsg.AppBrandPageVisitStatisticsHelper", e16, "", new Object[0]);
            }
        }
        PersistableBundle persistableBundle = eVar.S().f130792d0;
        if (persistableBundle != null && persistableBundle.size() > 0) {
            try {
                jSONObject.put("transitExtraData", com.tencent.luggage.wxa.h6.f.a(eVar.S().f130792d0));
            } catch (JSONException e17) {
                w.a("MicroMsg.AppBrandPageVisitStatisticsHelper", e17, "", new Object[0]);
            }
        }
        if (e.a.a(eVar.S().f125811d)) {
            i3 = 0;
        } else {
            i3 = eVar.S().V;
        }
        jSONObject.put("appversion", i3);
        String a16 = a(eVar);
        jSONObject.put("mode", a16);
        a16.hashCode();
        switch (a16.hashCode()) {
            case -54180510:
                if (a16.equals("halfPage")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case 785848970:
                if (a16.equals("embedded")) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case 913503991:
                if (a16.equals("singlePage")) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1544803905:
                if (a16.equals("default")) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
            case 3:
                if (eVar.S().f130813y0.a() && eVar.S().f130813y0.b() && !eVar.P0 && !eVar.Q0) {
                    jSONObject.put("appearance", "nativeFunctionalized");
                    break;
                } else {
                    jSONObject.put("appearance", "default");
                    break;
                }
                break;
            case 1:
                jSONObject.put("appearance", "default");
                break;
            case 2:
                if (eVar.S().A0 == 0) {
                    jSONObject.put("appearance", "default");
                    break;
                } else {
                    jSONObject.put("appearance", "banned");
                    break;
                }
        }
        com.tencent.luggage.wxa.k0.d.a(eVar.f(com.tencent.luggage.wxa.ed.a.class));
        jSONObject.put("runningModeParams", new m().a());
    }

    public static void d(com.tencent.luggage.wxa.c5.e eVar, JSONObject jSONObject) {
        try {
            String str = eVar.S().f130793e0;
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("hostExtraData", str);
            }
        } catch (JSONException e16) {
            w.a("MicroMsg.AppBrandPageVisitStatisticsHelper", e16, "fillWithHostNativeExtraData", new Object[0]);
        }
    }

    public static void e(com.tencent.luggage.wxa.c5.e eVar, JSONObject jSONObject) {
        try {
            c(eVar, jSONObject);
            jSONObject.put("referpagepath", a(eVar.S().N));
            jSONObject.put("clickTimestamp", eVar.S().S);
        } catch (Exception e16) {
            w.b("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillWxConfigLaunchInfo ex = %s", e16);
        }
    }

    public static void f(com.tencent.luggage.wxa.c5.e eVar, JSONObject jSONObject) {
        String r16 = eVar.S().r();
        String extension = FilenameUtils.getExtension(r16);
        com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
        if (com.tencent.luggage.wxa.rc.l.OK != eVar.P().createTempFileFrom(new v(r16), extension, false, iVar)) {
            return;
        }
        try {
            jSONObject.put("windowBackgroundImageFilePath", (String) iVar.f141499a);
            jSONObject.put("isWindowTransparencyDisabledByCompatibilityIssues", eVar.S1());
        } catch (JSONException e16) {
            w.b("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4WindowBackgroundImage put extra fields get exception %s", e16);
        }
    }

    public static String b(com.tencent.luggage.wxa.c5.e eVar, String str) {
        com.tencent.luggage.wxa.ob.a a16;
        if (w0.c(str) || (a16 = com.tencent.luggage.wxa.ob.a.a(str)) == null || a16.a().isEmpty()) {
            return str;
        }
        ArrayList arrayList = new ArrayList();
        List a17 = a16.a();
        for (int i3 = 0; i3 < a17.size(); i3++) {
            com.tencent.luggage.wxa.ob.c cVar = (com.tencent.luggage.wxa.ob.c) a17.get(i3);
            String trim = cVar.a().trim();
            w.a("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4PersonalProfile, imagePath: " + trim);
            if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                String d16 = cVar.d();
                String name = (d16.startsWith("image") || d16.startsWith("video")) ? "" : FilenameUtils.getName(trim);
                String extension = FilenameUtils.getExtension(trim);
                v vVar = new v(trim);
                int s16 = (int) vVar.s();
                com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
                com.tencent.luggage.wxa.rc.l createTempFileFrom = eVar.P().createTempFileFrom(vVar, extension, false, iVar);
                w.a("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4PersonalProfile, result: " + createTempFileFrom);
                if (com.tencent.luggage.wxa.rc.l.OK == createTempFileFrom) {
                    arrayList.add(new com.tencent.luggage.wxa.ob.c(d16, (String) iVar.f141499a, name, s16));
                }
            }
        }
        return new com.tencent.luggage.wxa.ob.a(arrayList).b();
    }

    public static String a(com.tencent.luggage.wxa.c5.e eVar) {
        if (eVar.S().f130813y0.a()) {
            return eVar.S().f130813y0.M == x.j.EMBED ? eVar.P0 ? "default" : "embedded" : (eVar.S().f130813y0.f125991a == -1 || eVar.Q0) ? "default" : "halfPage";
        }
        if (eVar.S().f130812x0 == 1) {
            return "singlePage";
        }
        return "default";
    }

    public static void a(com.tencent.luggage.wxa.c5.e eVar, JSONObject jSONObject, boolean z16) {
        try {
            jSONObject.put("scene", eVar.G1());
        } catch (JSONException unused) {
        }
        try {
            JSONObject q16 = eVar.S().q();
            if (q16 != null) {
                jSONObject.put("shareInfo", q16);
            }
        } catch (JSONException unused2) {
        }
        g a16 = eVar.Y().getReporter().a();
        if (z16) {
            e(eVar, jSONObject);
            b(eVar, jSONObject);
            try {
                jSONObject.put("isEntrance", a16.a(eVar.O()));
                return;
            } catch (Exception e16) {
                w.a("MicroMsg.AppBrandPageVisitStatisticsHelper", e16, "fillEventOnAppEnterForeground", new Object[0]);
                return;
            }
        }
        try {
            c(eVar, jSONObject);
            b(eVar, jSONObject);
            g.c cVar = eVar.Y().getReporter().a().peek().f123602d;
            jSONObject.put("referpagepath", cVar == null ? null : cVar.f123603a);
            jSONObject.put("clickTimestamp", eVar.S().S);
            jSONObject.put("isEntrance", a16.a(eVar.Y().getCurrentUrl()));
        } catch (Exception e17) {
            w.a("MicroMsg.AppBrandPageVisitStatisticsHelper", e17, "fillEventOnAppEnterForeground", new Object[0]);
        }
    }

    public static Uri a(Uri uri, String str, String str2) {
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.clearQuery();
        for (String str3 : uri.getQueryParameterNames()) {
            buildUpon.appendQueryParameter(str3, str.equals(str3) ? str2 : uri.getQueryParameter(str3));
        }
        return buildUpon.build();
    }

    public static e b(com.tencent.luggage.wxa.m4.b bVar) {
        return bVar.getRuntime().Y().getReporter();
    }

    public static String a(com.tencent.luggage.wxa.c5.e eVar, String str) {
        com.tencent.luggage.wxa.ij.a a16;
        if (w0.c(str) || (a16 = com.tencent.luggage.wxa.ij.a.a(str)) == null) {
            return str;
        }
        String trim = a16.a().trim();
        w.a("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, originMaterialPath: " + trim);
        if (trim.startsWith("http://") || trim.startsWith("https://")) {
            return str;
        }
        String b16 = a16.b();
        String name = (b16.startsWith("image") || b16.startsWith("video")) ? "" : FilenameUtils.getName(trim);
        String extension = FilenameUtils.getExtension(trim);
        v vVar = new v(trim);
        int s16 = (int) vVar.s();
        w.a("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, fileName: %s, fileExt: %s\uff0cfileSize: %d", name, extension, Integer.valueOf(s16));
        if (com.tencent.luggage.wxa.uk.l.f142757a.a(trim)) {
            w.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "originMaterialPath is wxam file");
            v allocTempFile = eVar.P().allocTempFile("appbrand_temp_" + System.currentTimeMillis());
            try {
                allocTempFile.c();
                w.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "tempFile exist:%b, path %s", Boolean.valueOf(allocTempFile.e()), allocTempFile.g());
                com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.hm.a.class));
                allocTempFile.g();
                throw null;
            } catch (Exception e16) {
                w.a("MicroMsg.AppBrandPageVisitStatisticsHelper", e16, "", new Object[0]);
                w.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "break, use origin Material Path");
            }
        }
        com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
        com.tencent.luggage.wxa.rc.l createTempFileFrom = eVar.P().createTempFileFrom(vVar, extension, false, iVar);
        w.a("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, result: " + createTempFileFrom);
        if (com.tencent.luggage.wxa.rc.l.OK != createTempFileFrom) {
            return str;
        }
        String str2 = (String) iVar.f141499a;
        w.a("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, newMaterialPath: " + str2);
        return new com.tencent.luggage.wxa.ij.a(b16, str2, name, s16).c();
    }

    public static void a(com.tencent.luggage.wxa.ic.g gVar, JSONObject jSONObject) {
        try {
            Pair a16 = a((com.tencent.luggage.wxa.m4.b) gVar.Y().getCurrentPage().getCurrentPageView());
            int intValue = ((Integer) a16.first).intValue();
            String str = (String) a16.second;
            jSONObject.put("targetAction", intValue);
            jSONObject.put("targetPagePath", str);
            jSONObject.put("usedState", ((com.tencent.luggage.wxa.c5.e) gVar).L1().f122986e);
            jSONObject.put("isEntrance", ((com.tencent.luggage.wxa.c5.e) gVar).Y().getReporter().a().a(gVar.Y().getCurrentUrl()));
        } catch (Exception e16) {
            w.b("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillEventOnAppEnterBackground ex = %s", e16);
        }
    }

    public static Pair a(com.tencent.luggage.wxa.m4.b bVar) {
        int i3;
        String className;
        int i16 = a.f123597a[com.tencent.luggage.wxa.ic.e.d(bVar.getAppId()).ordinal()];
        int i17 = 4;
        String str = null;
        if (i16 != 1) {
            i3 = 7;
            if (i16 == 2) {
                i17 = bVar.u1().f() ? 5 : 7;
            } else {
                if (i16 == 3) {
                    i3 = 6;
                } else if (i16 != 4) {
                    Intent c16 = b(bVar).c();
                    if (c16 != null) {
                        if (c16.getComponent() == null) {
                            w.b("MicroMsg.AppBrandPageVisitStatisticsHelper", "onBackground, intent %s, get null cmp name", c16);
                            className = "";
                        } else {
                            className = c16.getComponent().getClassName();
                        }
                        if (className.contains("WebViewUI")) {
                            str = r.a(c16, "appbrand_report_key_target_url");
                            i3 = 10;
                        } else {
                            str = w0.b(r.a(c16, "appbrand_report_key_target_activity"), className);
                            i3 = 8;
                        }
                    }
                } else {
                    str = com.tencent.luggage.wxa.ic.k.b(bVar.getAppId()).f129902e + ":" + com.tencent.luggage.wxa.aa.m.a(w0.d(com.tencent.luggage.wxa.ic.k.b(bVar.getAppId()).f129903f));
                    i3 = 9;
                }
                return Pair.create(Integer.valueOf(i3), str);
            }
        } else if (!bVar.u1().f()) {
            i17 = 3;
        }
        i3 = i17;
        return Pair.create(Integer.valueOf(i3), str);
    }

    public static String a(n nVar) {
        if (nVar == null) {
            return null;
        }
        int i3 = nVar.f125847a;
        if (1 == i3 || 3 == i3) {
            return nVar.f125848b;
        }
        return 2 == i3 ? nVar.f125852f : "";
    }
}
