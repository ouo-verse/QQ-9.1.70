package com.tencent.luggage.wxa.th;

import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f141334a = new d();

    public final void a(v vVar, String str) {
        f0 e16 = f0.e("AppBrandResCacheMeta");
        String str2 = "metaData_dir_" + vVar.g();
        w.a("MicroMsg.AppBrand.AppBrandResCacheChecker", "saveDirMeta, key: " + str2);
        e16.putString(str2, str);
    }

    public final long b(v vVar) {
        f0 e16 = f0.e("AppBrandResCacheMeta");
        String str = "metaData_file_" + vVar.g();
        w.a("MicroMsg.AppBrand.AppBrandResCacheChecker", "getFileLastModified, key: " + str);
        return e16.getLong(str, -1L);
    }

    public final boolean c(v cacheFile) {
        Intrinsics.checkNotNullParameter(cacheFile, "cacheFile");
        if (cacheFile.p()) {
            return h(cacheFile);
        }
        return i(cacheFile);
    }

    public final boolean d(v cacheFile) {
        Intrinsics.checkNotNullParameter(cacheFile, "cacheFile");
        if (cacheFile.p()) {
            return e(cacheFile);
        }
        return f(cacheFile);
    }

    public final boolean e(v vVar) {
        String str;
        boolean z16;
        w.a("MicroMsg.AppBrand.AppBrandResCacheChecker", "recordDir, cacheDir: " + vVar);
        g a16 = g.f141342e.a(vVar);
        if (a16 == null) {
            w.f("MicroMsg.AppBrand.AppBrandResCacheChecker", "recordDir, metaData is null");
            return false;
        }
        JSONObject c16 = a16.c();
        if (c16 != null) {
            str = c16.toString();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            w.f("MicroMsg.AppBrand.AppBrandResCacheChecker", "recordDir, metaDataStr is empty");
            return false;
        }
        a(vVar, str);
        return true;
    }

    public final boolean f(v vVar) {
        g(vVar);
        return true;
    }

    public final void g(v vVar) {
        f0 e16 = f0.e("AppBrandResCacheMeta");
        String str = "metaData_file_" + vVar.g();
        long r16 = vVar.r();
        w.a("MicroMsg.AppBrand.AppBrandResCacheChecker", "saveFileLastModified, key: " + str + ", lastModified: " + r16);
        e16.putLong(str, r16);
    }

    public final boolean h(v vVar) {
        boolean z16;
        h hVar;
        w.a("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, cacheDir: " + vVar);
        String a16 = a(vVar);
        if (a16 != null && a16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            w.f("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, metaDataStr is empty");
            return false;
        }
        try {
            hVar = h.f141344c.a(new JSONObject(a16));
        } catch (Exception e16) {
            w.a("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, get metaData fail since " + e16);
            hVar = null;
        }
        if (hVar == null) {
            w.f("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, metaData is null");
            return false;
        }
        v k3 = vVar.k();
        Intrinsics.checkNotNull(k3);
        if (a(hVar, k3)) {
            return true;
        }
        w.f("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, validateMeta fail");
        return false;
    }

    public final boolean i(v vVar) {
        long b16 = b(vVar);
        long r16 = vVar.r();
        w.a("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateFile, cacheFile: " + vVar + ", savedLastModified: " + b16 + ", realLastModified: " + r16);
        if (b16 == r16) {
            return true;
        }
        return false;
    }

    public final String a(v vVar) {
        f0 e16 = f0.e("AppBrandResCacheMeta");
        String str = "metaData_dir_" + vVar.g();
        w.a("MicroMsg.AppBrand.AppBrandResCacheChecker", "getDirMeta, key: " + str);
        return e16.getString(str, null);
    }

    public final boolean a(h hVar, v vVar) {
        v vVar2 = new v(vVar, hVar.b());
        w.a("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateMeta, unzipFile: " + vVar2);
        if (!(hVar instanceof g)) {
            return vVar2.e() && vVar2.q() && hVar.a() == vVar2.r();
        }
        List d16 = ((g) hVar).d();
        if ((d16 instanceof Collection) && d16.isEmpty()) {
            return true;
        }
        Iterator it = d16.iterator();
        while (it.hasNext()) {
            if (!f141334a.a((h) it.next(), vVar2)) {
                return false;
            }
        }
        return true;
    }
}
