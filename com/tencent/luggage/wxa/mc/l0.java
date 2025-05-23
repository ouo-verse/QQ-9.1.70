package com.tencent.luggage.wxa.mc;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.hn.ce;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l0 implements e, o {

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f134325c = {com.tencent.luggage.wxa.xn.c.a(h0.f134307a0, "AppBrandWxaPkgManifestRecord")};

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.xn.b f134326a;

    /* renamed from: b, reason: collision with root package name */
    public final d f134327b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f134328a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n0.g f134329b;

        public a(String str, n0.g gVar) {
            this.f134328a = str;
            this.f134329b = gVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke() {
            n0.g gVar;
            List list;
            if (!w0.c(this.f134328a) && (gVar = this.f134329b) != null) {
                l0.this.a(this.f134328a, 0, gVar.f125920a, gVar.f125928i);
                l0.this.a(this.f134329b.f125926g);
                if (!w0.c(this.f134329b.f125932m) && (list = this.f134329b.f125926g) != null && list.size() > 0) {
                    l0 l0Var = l0.this;
                    String str = this.f134328a;
                    n0.g gVar2 = this.f134329b;
                    l0Var.a(str, ModulePkgInfo.MODULE_WITHOUT_PLUGIN_CODE, gVar2.f125920a, 0, gVar2.f125932m, 12);
                }
                l0 l0Var2 = l0.this;
                String str2 = this.f134328a;
                n0.g gVar3 = this.f134329b;
                l0Var2.a(str2, gVar3.f125920a, 0, "", gVar3.C);
                l0 l0Var3 = l0.this;
                String str3 = this.f134328a;
                n0.g gVar4 = this.f134329b;
                return Boolean.valueOf(l0Var3.a(str3, 0, gVar4.f125920a, gVar4.f125923d, (String) null));
            }
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfoV2, args invalid appId = %s, vInfo = %s", this.f134328a, this.f134329b);
            return Boolean.FALSE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f134331a;

        public b(Function0 function0) {
            this.f134331a = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke() {
            return (Boolean) l0.this.a(this.f134331a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h0 f134333a;

        public c(h0 h0Var) {
            this.f134333a = h0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke() {
            if (l0.this.a(this.f134333a)) {
                boolean c16 = l0.this.f134327b.c(this.f134333a, h0.Z);
                if (c16 && com.tencent.luggage.wxa.cp.x.d(this.f134333a.f138315l)) {
                    ((l) com.tencent.luggage.wxa.eo.g.a(l.class)).a(this.f134333a.f138315l);
                }
                return Boolean.valueOf(c16);
            }
            boolean a16 = l0.this.f134327b.a(this.f134333a);
            if (a16 && com.tencent.luggage.wxa.cp.x.d(this.f134333a.f138315l)) {
                ((l) com.tencent.luggage.wxa.eo.g.a(l.class)).a(this.f134333a.f138315l);
            }
            return Boolean.valueOf(a16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends com.tencent.luggage.wxa.xn.c {
        public d(com.tencent.luggage.wxa.xn.b bVar) {
            super(bVar, h0.f134307a0, "AppBrandWxaPkgManifestRecord", com.tencent.luggage.wxa.q9.d.K);
        }
    }

    public l0(com.tencent.luggage.wxa.xn.b bVar) {
        this.f134326a = bVar;
        this.f134327b = new d(bVar);
    }

    public String b() {
        return this.f134327b.d();
    }

    public boolean c(h0 h0Var) {
        if (e.a.a(h0Var.f138319p)) {
            h0Var.f138307d = 1;
        }
        return ((Boolean) a(new c(h0Var))).booleanValue();
    }

    public boolean d(h0 h0Var) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWxaPkgStorage", "updateManifest, appId %s, version %d, pkgType %d", h0Var.f138305b, Integer.valueOf(h0Var.f138307d), Integer.valueOf(h0Var.f138319p));
        if (TextUtils.isEmpty(h0Var.f138305b)) {
            return false;
        }
        if (e.a.a(h0Var.f138319p)) {
            h0Var.f138307d = 1;
        }
        boolean b16 = this.f134327b.b(h0Var, true, h0.Z);
        if (b16 && com.tencent.luggage.wxa.cp.x.d(h0Var.f138315l)) {
            ((l) com.tencent.luggage.wxa.eo.g.a(l.class)).a(h0Var.f138315l);
        }
        return b16;
    }

    @Override // com.tencent.luggage.wxa.mc.o
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h0 a(String str, int i3, int i16, String... strArr) {
        StringBuilder sb5 = new StringBuilder();
        for (String str2 : h0.Z) {
            sb5.append(str2);
            sb5.append("=? and ");
        }
        sb5.append("1=1");
        int i17 = e.a.a(i16) ? 1 : i3;
        h0 h0Var = null;
        Cursor a16 = this.f134326a.a("AppBrandWxaPkgManifestRecord", w0.a(strArr) ? null : strArr, sb5.toString(), new String[]{str, String.valueOf(i17), String.valueOf(i16)}, null, null, null, 2);
        if (a16 == null) {
            return null;
        }
        if (a16.moveToFirst()) {
            h0Var = new h0();
            h0Var.a(a16);
            h0Var.f138305b = str;
            if (i17 > 0) {
                h0Var.f138307d = i17;
            }
        }
        a16.close();
        return h0Var;
    }

    public com.tencent.luggage.wxa.xn.b a() {
        return this.f134326a;
    }

    public boolean a(ce ceVar, com.tencent.luggage.wxa.dn.c cVar) {
        if (ceVar.f127422g >= 0 && !w0.c(ceVar.f127420e) && !w0.c(ceVar.f127421f)) {
            if (ceVar.f127424i > 0) {
                int a16 = this.f134326a.a("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s>?", "appId", "debugType", "version"), new String[]{"@LibraryAppId", String.valueOf(0), String.valueOf(ceVar.f127422g)});
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, delete manifest.version > %d, ret = %d", Integer.valueOf(ceVar.f127422g), Integer.valueOf(a16));
                if (cVar != null) {
                    cVar.f124397a = a16;
                }
            }
            return a("@LibraryAppId", 0, ceVar.f127422g, ceVar.f127421f, ceVar.f127420e);
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, invalid resp: version( %d ), url( %s ), md5( %s )", Integer.valueOf(ceVar.f127422g), ceVar.f127420e, ceVar.f127421f);
        return false;
    }

    @Override // com.tencent.luggage.wxa.mc.o
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h0 a(String str, int i3, String... strArr) {
        String format;
        String[] strArr2;
        String str2;
        h0 h0Var = null;
        if (w0.c(str)) {
            return null;
        }
        if (e.a.b(i3)) {
            format = String.format(Locale.US, "%s=? and %s=?", "appId", "debugType");
            strArr2 = new String[]{str, String.valueOf(i3)};
            str2 = "version desc";
        } else if (e.a.a(i3)) {
            format = String.format(Locale.US, "%s=? and %s=? and %s=?", "appId", "debugType", "version");
            strArr2 = new String[]{str, String.valueOf(i3), "1"};
            str2 = "createTime desc";
        } else {
            throw new RuntimeException("Illegal pkgType " + i3);
        }
        Cursor a16 = this.f134326a.a("AppBrandWxaPkgManifestRecord", w0.a(strArr) ? null : strArr, format, strArr2, null, null, str2);
        if (a16 == null) {
            return null;
        }
        if (a16.moveToFirst()) {
            h0Var = new h0();
            h0Var.a(a16);
            h0Var.f138305b = str;
            h0Var.f138319p = i3;
        }
        a16.close();
        return h0Var;
    }

    public boolean a(String str, int i3, String str2, String str3, long j3, long j16) {
        if (w0.c(str)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, null or nil appId");
            return false;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, appId %s, type %d, url %s, md5 %s, lifespan[%d, %d]", str, Integer.valueOf(i3), str2, str3, Long.valueOf(j3), Long.valueOf(j16));
        if (i3 == 999) {
            str = "@LibraryAppId";
        }
        h0 a16 = a(str, 1, i3, new String[0]);
        if (a16 == null) {
            h0 h0Var = new h0();
            h0Var.f138305b = str;
            h0Var.f138307d = 1;
            h0Var.f138319p = i3;
            h0Var.f138321r = str2;
            h0Var.f138309f = str3;
            h0Var.f138323t = j3;
            h0Var.f138325v = j16;
            h0Var.f138317n = w0.d();
            b(h0Var);
            return true;
        }
        boolean z16 = (w0.c(str3) || w0.c(a16.f138309f) || str3.equals(a16.f138309f)) ? false : true;
        boolean z17 = !w0.d(str2).equals(w0.d(a16.f138321r));
        if (!z16) {
            if (z17) {
                a16.f138321r = str2;
                a16.f138323t = j3;
                a16.f138325v = j16;
                d(a16);
            }
            return false;
        }
        a16.f138321r = str2;
        if (com.tencent.luggage.wxa.cp.x.c(a16.f138315l)) {
            ((l) com.tencent.luggage.wxa.eo.g.a(l.class)).l(a16.f138315l);
        }
        a16.f138315l = null;
        a16.f138317n = w0.d();
        a16.f138309f = str3;
        a16.f138323t = j3;
        a16.f138325v = j16;
        a16.f138317n = w0.d();
        d(a16);
        if (w0.a(str.split("$"))) {
            a(str, i3, 1);
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.mc.o
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h0 a(String str, int i3, String str2, String... strArr) {
        return a(str, i3, strArr);
    }

    public boolean b(h0 h0Var) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWxaPkgStorage", "insertManifest, appId %s, type %d, version %d", h0Var.f138305b, Integer.valueOf(h0Var.f138319p), Integer.valueOf(h0Var.f138307d));
        boolean a16 = this.f134327b.a(h0Var);
        if (a16 && com.tencent.luggage.wxa.cp.x.d(h0Var.f138315l)) {
            ((l) com.tencent.luggage.wxa.eo.g.a(l.class)).a(h0Var.f138315l);
        }
        return a16;
    }

    public int b(String str, int i3, int i16) {
        if (!e.a.b(i3)) {
            return 0;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWxaPkgStorage", "deletePkgsBelowVersion, appId %s, versionType %d, pkgVersion %d", str, Integer.valueOf(i3), Integer.valueOf(i16));
        return this.f134326a.a("AppBrandWxaPkgManifestRecord", n0.a(str, i3) + " and version<" + i16, (String[]) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, int i3, int i16, String str2, String str3) {
        boolean z16;
        int i17;
        if (!e.a.b(i3)) {
            if (com.tencent.luggage.wxa.tn.e.f141559a) {
                com.tencent.luggage.wxa.er.a.a("invalid pkgType " + i3);
            }
            return false;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo for release, appId %s, type %d, version %d, md5 %s, url %s", str, Integer.valueOf(i3), Integer.valueOf(i16), str2, str3);
        if ("@LibraryAppId".equals(str) && i16 == (i17 = z.f134409a)) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, given version == local library version %d, skip", Integer.valueOf(i17));
            return false;
        }
        h0 a16 = a(str, i16, i3, new String[0]);
        if (a16 == null) {
            h0 h0Var = new h0();
            h0Var.f138305b = str;
            h0Var.f138307d = i16;
            h0Var.f138309f = str2;
            h0Var.f138311h = null;
            h0Var.f138321r = str3;
            h0Var.f138319p = i3;
            boolean b16 = b(h0Var);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, insert record %b, appId %s, version %d, url %s, md5 %s", Boolean.valueOf(b16), str, Integer.valueOf(h0Var.f138307d), h0Var.f138321r, h0Var.f138309f);
            return b16;
        }
        String str4 = a16.f138321r;
        String str5 = a16.f138309f;
        if (!w0.d(str5).equals(str2)) {
            a16.f138309f = str2;
            a16.f138311h = null;
            a16.f138307d = i16;
            a16.f138321r = str3;
        } else if (!w0.c(str3) && !str3.equals(a16.f138321r)) {
            a16.f138321r = str3;
        } else {
            z16 = false;
            boolean d16 = !z16 ? d(a16) : false;
            Object[] objArr = new Object[8];
            objArr[0] = Boolean.valueOf(!z16 && d16);
            objArr[1] = str;
            objArr[2] = Integer.valueOf(i16);
            objArr[3] = Integer.valueOf(i16);
            objArr[4] = str4;
            objArr[5] = str3;
            objArr[6] = str5;
            objArr[7] = str2;
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, update record %b, appId %s, oldVersion %d, newVersion %d, oldURL %s, newURL %s, oldMd5 %s, newMd5 %s", objArr);
            return z16 && d16;
        }
        z16 = true;
        if (!z16) {
        }
        Object[] objArr2 = new Object[8];
        objArr2[0] = Boolean.valueOf(!z16 && d16);
        objArr2[1] = str;
        objArr2[2] = Integer.valueOf(i16);
        objArr2[3] = Integer.valueOf(i16);
        objArr2[4] = str4;
        objArr2[5] = str3;
        objArr2[6] = str5;
        objArr2[7] = str2;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, update record %b, appId %s, oldVersion %d, newVersion %d, oldURL %s, newURL %s, oldMd5 %s, newMd5 %s", objArr2);
        if (z16) {
            return false;
        }
    }

    public boolean a(String str, int i3, String str2) {
        return a(str, 0, i3, str2, (String) null);
    }

    public boolean a(String str, n0.g gVar) {
        Boolean bool = (Boolean) com.tencent.luggage.wxa.e5.g.a("flushWxaAppVersionInfoV2 " + str, new b(new a(str, gVar)));
        Objects.requireNonNull(bool);
        return bool.booleanValue();
    }

    public void a(String str, String str2, int i3, int i16, String str3, int i17) {
        if (w0.c(str3)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandWxaPkgStorage", "updateWithoutPluginCodeInfo withoutLibMd5 null appid:%s,modulename:%s!", str, str2);
            return;
        }
        String rVar = new r(str, str2, i17).toString();
        if (i16 == 0) {
            a(rVar, i16, i3, str3, (String) null);
        } else {
            a(rVar, i16, "", str3, 0L, 0L);
        }
    }

    public void a(List list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWxaPkgStorage", "updatePluginCodeList size:%s", Integer.valueOf(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            n0.e eVar = (n0.e) it.next();
            String str = eVar.f125909a;
            String str2 = eVar.f125911c;
            int i3 = eVar.f125910b;
            if (!w0.c(str) && !w0.c(str2)) {
                a(str, str2, i3);
            }
        }
    }

    public boolean a(String str, String str2, int i3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return a(new r(str, ModulePkgInfo.PLUGIN_CODE).toString(), 0, i3, str2, (String) null);
    }

    public boolean a(h0 h0Var) {
        boolean z16 = false;
        String format = String.format(Locale.ENGLISH, "select count(%s) from %s where %s=? and %s=? and %s=?", "appId", "AppBrandWxaPkgManifestRecord", "appId", "debugType", "version");
        Cursor a16 = this.f134326a.a(format, new String[]{h0Var.f138305b, h0Var.f138319p + "", h0Var.f138307d + ""});
        if (a16 != null) {
            try {
                if (a16.moveToNext()) {
                    if (a16.getInt(0) > 0) {
                        z16 = true;
                    }
                }
            } catch (Throwable th5) {
                try {
                    a16.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
                throw th5;
            }
        }
        if (a16 != null) {
            a16.close();
        }
        return z16;
    }

    public final synchronized Object a(Function0 function0) {
        long b16 = this.f134326a.b(Thread.currentThread().getId());
        try {
        } finally {
            this.f134326a.a(b16);
        }
        return function0.invoke();
    }

    public void a(String str, int i3, int i16, String str2, List list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            n0.i iVar = (n0.i) it.next();
            int i17 = iVar.f125944a;
            String str3 = iVar.f125945b;
            String rVar = new r(str, str2, i17).toString();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWxaPkgStorage", "multiPkg updatePkgInfoList pkgInfoKey:%s,pkgType:%d,codeType:%d", rVar, Integer.valueOf(i17), Integer.valueOf(i16));
            if (i16 == 0) {
                a(rVar, i16, i3, str3, (String) null);
            } else {
                a(rVar, i16, "", str3, 0L, 0L);
            }
        }
    }

    public int a(String str, int i3) {
        int i16 = 0;
        if (w0.c(str)) {
            return 0;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWxaPkgStorage", "deleteAppPkg, appId %s, debugType %d", str, Integer.valueOf(i3));
        String a16 = n0.a(str, i3);
        Cursor a17 = this.f134326a.a("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath"}, a16, null, null, null, null, 2);
        if (a17 != null) {
            try {
                if (a17.moveToFirst()) {
                    String string = a17.getString(0);
                    if (com.tencent.luggage.wxa.cp.x.c(string)) {
                        ((l) com.tencent.luggage.wxa.eo.g.a(l.class)).l(string);
                        i16 = 1;
                    }
                }
            } finally {
            }
        }
        if (a17 != null) {
            a17.close();
        }
        this.f134326a.a("AppBrandWxaPkgManifestRecord", a16, (String[]) null);
        return i16 + a(str, i3, -1);
    }

    public boolean a(String str, int i3, int i16, List list) {
        n0.h hVar;
        if (w0.c(str) || w0.a(list)) {
            return false;
        }
        int i17 = !e.a.b(i3) ? 1 : i16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append('{');
        Iterator it = list.iterator();
        while (it.hasNext()) {
            n0.h hVar2 = (n0.h) it.next();
            sb5.append(',');
            sb5.append(hVar2.f125933a);
            sb5.append("::");
            sb5.append(hVar2.f125934b);
        }
        sb5.append('}');
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWxaPkgStorage", "updateModuleList, appId %s, type %d, version %d, list %s", str, Integer.valueOf(i3), Integer.valueOf(i17), sb5.toString());
        Iterator it5 = list.iterator();
        while (it5.hasNext()) {
            n0.h hVar3 = (n0.h) it5.next();
            String rVar = new r(str, hVar3.f125933a).toString();
            if (e.a.b(i3)) {
                a(rVar, i3, i17, hVar3.f125934b, (String) null);
            } else {
                a(rVar, i3, (String) null, hVar3.f125934b, 0L, 0L);
            }
            String str2 = hVar3.f125939g;
            if (w0.c(hVar3.f125933a) || w0.c(str2)) {
                hVar = hVar3;
            } else {
                hVar = hVar3;
                a(str, hVar3.f125933a, i17, i3, str2, 13);
            }
            a(str, i17, i3, hVar.f125933a, hVar.f125940h);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0098 A[Catch: all -> 0x009c, TryCatch #3 {all -> 0x009c, blocks: (B:12:0x0098, B:14:0x00a0, B:39:0x0091, B:40:0x0094, B:34:0x008b), top: B:8:0x005e, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a0 A[Catch: all -> 0x009c, TRY_LEAVE, TryCatch #3 {all -> 0x009c, blocks: (B:12:0x0098, B:14:0x00a0, B:39:0x0091, B:40:0x0094, B:34:0x008b), top: B:8:0x005e, inners: #4 }] */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.tencent.luggage.wxa.xn.b] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(String str, int i3, int i16) {
        String str2;
        int i17;
        Throwable th5;
        int i18;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(n0.b(str, i3));
        sb5.append(" and ");
        if (i16 > 0) {
            str2 = "version=" + i16;
        } else {
            str2 = "1=1";
        }
        sb5.append(str2);
        String sb6 = sb5.toString();
        String format = String.format(Locale.ENGLISH, "select %s from %s where %s", "pkgPath", b(), sb6);
        try {
            ?? r112 = this.f134326a;
            Cursor a16 = r112.a(format, null, 2);
            try {
                if (a16 != null) {
                    try {
                        if (a16.moveToFirst()) {
                            i18 = 0;
                            do {
                                try {
                                    String string = a16.getString(0);
                                    i18 = i18;
                                    if (com.tencent.luggage.wxa.cp.x.c(string)) {
                                        ((l) com.tencent.luggage.wxa.eo.g.a(l.class)).l(string);
                                        i18++;
                                    }
                                } catch (Throwable th6) {
                                    th5 = th6;
                                    r112 = i18;
                                    try {
                                        a16.close();
                                        throw th5;
                                    } catch (Throwable th7) {
                                        th5.addSuppressed(th7);
                                        throw th5;
                                    }
                                }
                            } while (a16.moveToNext());
                            if (a16 != null) {
                                a16.close();
                            }
                            if (i18 > 0) {
                                this.f134326a.a(b(), sb6, (String[]) null);
                            }
                            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleList, appId %s, type %d, version %d, return count %d", str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i18));
                            return i18;
                        }
                    } catch (Throwable th8) {
                        th5 = th8;
                        r112 = 0;
                    }
                }
                i18 = 0;
                if (a16 != null) {
                }
                if (i18 > 0) {
                }
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleList, appId %s, type %d, version %d, return count %d", str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i18));
                return i18;
            } catch (Throwable th9) {
                th = th9;
                i17 = r112;
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleList, appId %s, type %d, version %d, return count %d", str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                throw th;
            }
        } catch (Throwable th10) {
            th = th10;
            i17 = 0;
        }
    }
}
