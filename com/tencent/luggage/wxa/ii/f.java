package com.tencent.luggage.wxa.ii;

import android.util.Pair;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.hn.j0;
import com.tencent.luggage.wxa.hn.r8;
import com.tencent.luggage.wxa.hn.t2;
import com.tencent.luggage.wxa.hn.u2;
import com.tencent.luggage.wxa.ii.k;
import com.tencent.luggage.wxa.ii.l;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {
    public static final void a(t2 t2Var) {
        int intValue;
        Intrinsics.checkNotNullParameter(t2Var, "<this>");
        if (e.a.a(t2Var.f128716d.f128597h)) {
            try {
                r8 r8Var = t2Var.f128716d;
                if (r8Var.f128596g == 6) {
                    intValue = new com.tencent.luggage.wxa.y8.h(v.f130593a.a(r8Var.f128593d, t2Var.f128723k)).intValue();
                } else {
                    h a16 = h.a();
                    r8 r8Var2 = t2Var.f128716d;
                    String a17 = a16.a(r8Var2.f128593d, r8Var2.f128597h);
                    if (a17 == null) {
                        a17 = "";
                    }
                    intValue = new com.tencent.luggage.wxa.y8.h(new JSONObject(a17).optLong("dev_key")).intValue();
                }
                t2Var.f128722j = intValue;
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.CommonPkgFetcherUtils", "GetDownloadUrlReqItem.fillDevUin(" + t2Var.f128716d.f128593d + ", " + t2Var.f128716d.f128597h + "), throwable=" + th5);
            }
        }
    }

    public static final Object b(Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "<this>");
        return entry.getValue();
    }

    public static final Object b(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return pair.second;
    }

    public static final int a(r8 r8Var, Object obj) {
        if (obj instanceof r8) {
            r8 r8Var2 = (r8) obj;
            if (Intrinsics.areEqual(r8Var.f128593d, r8Var2.f128593d) && Intrinsics.areEqual(w0.d(r8Var.f128595f), w0.d(r8Var2.f128595f)) && r8Var.f128596g == r8Var2.f128596g && r8Var.f128597h == r8Var2.f128597h) {
                return 0;
            }
        } else {
            if (!(obj instanceof l.a)) {
                return -1;
            }
            l.a aVar = (l.a) obj;
            if (Intrinsics.areEqual(r8Var.f128593d, aVar.a()) && r8Var.f128596g == aVar.g() && r8Var.f128597h == aVar.j()) {
                if (Intrinsics.areEqual(w0.d(r8Var.f128595f), w0.d(aVar.e()))) {
                    return 0;
                }
                String str = r8Var.f128595f;
                if ((str == null || str.length() == 0) && Intrinsics.areEqual(ModulePkgInfo.MAIN_MODULE_NAME, aVar.e())) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public static final /* synthetic */ u2[] a(j0 j0Var, l.a request) {
        LinkedList linkedList;
        Intrinsics.checkNotNullParameter(request, "request");
        if (((j0Var == null || (linkedList = j0Var.f127924e) == null) ? -1 : linkedList.size()) <= 0) {
            return null;
        }
        u2[] u2VarArr = new u2[3];
        Intrinsics.checkNotNull(j0Var);
        Iterator it = j0Var.f127924e.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "this!!.resp_list.iterator()");
        while (it.hasNext()) {
            u2 u2Var = (u2) it.next();
            if (u2Var == null) {
                it.remove();
            } else {
                r8 r8Var = u2Var.f128799k;
                Intrinsics.checkNotNullExpressionValue(r8Var, "item.req_package_info");
                if (a(r8Var, request) == 0) {
                    it.remove();
                    if (u2Var.f128797i) {
                        u2VarArr[2] = u2Var;
                    } else if (u2Var.f128798j) {
                        u2VarArr[1] = u2Var;
                    } else {
                        u2VarArr[0] = u2Var;
                    }
                }
            }
        }
        return u2VarArr;
    }

    public static final /* synthetic */ k.d a(n0.e eVar, int i3) {
        k.g cVar;
        k.g gVar;
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        String str = eVar.f125909a;
        Intrinsics.checkNotNullExpressionValue(str, "this.provider");
        int i16 = !w0.c(eVar.f125916h) ? 1 : 0;
        if (i3 > 0) {
            cVar = new k.g.c(i3, 0L, 2, null);
        } else {
            if (eVar.f125913e) {
                gVar = new k.g.b(eVar.f125910b, false, 2, null);
            } else if (w0.c(eVar.f125916h)) {
                cVar = new k.g.c(eVar.f125910b, 0L, 2, null);
            } else {
                String str2 = eVar.f125916h;
                Intrinsics.checkNotNullExpressionValue(str2, "this.versionDesc");
                gVar = new k.g.a(str2);
            }
            cVar = gVar;
        }
        return new k.d(str, "", 6, i16, cVar, false, null, 64, null);
    }

    public static final /* synthetic */ WxaPluginPkgInfo a(n0.e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        WxaPluginPkgInfo wxaPluginPkgInfo = new WxaPluginPkgInfo();
        wxaPluginPkgInfo.provider = eVar.f125909a;
        wxaPluginPkgInfo.version = eVar.f125910b;
        wxaPluginPkgInfo.md5 = eVar.f125911c;
        wxaPluginPkgInfo.prefixPath = eVar.f125912d;
        wxaPluginPkgInfo.contexts = eVar.f125914f;
        return wxaPluginPkgInfo;
    }

    public static final /* synthetic */ List a(List list) {
        int collectionSizeOrDefault;
        if (list == null || list.isEmpty()) {
            return null;
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a((n0.e) it.next()));
        }
        return arrayList;
    }

    public static final Object a(Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "<this>");
        return entry.getKey();
    }

    public static final Object a(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return pair.first;
    }
}
