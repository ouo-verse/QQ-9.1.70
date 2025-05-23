package com.tencent.luggage.wxa.ii;

import android.text.TextUtils;
import com.tencent.luggage.wxa.mc.j0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i extends com.tencent.luggage.wxa.xn.c {

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f130504g = {com.tencent.luggage.wxa.xn.c.a(g.f130501u, "DevPkgLaunchExtInfo")};

    public i(com.tencent.luggage.wxa.xn.b bVar) {
        super(bVar, g.f130501u, "DevPkgLaunchExtInfo", com.tencent.luggage.wxa.q9.e.f138332m);
    }

    public boolean a(String str, int i3, String str2) {
        return a(str, i3, str2, true);
    }

    public final boolean b(String str, int i3, String str2) {
        if (w0.c(str)) {
            return false;
        }
        g gVar = new g();
        gVar.f138339b = str;
        gVar.f138341d = i3;
        String[] strArr = g.f130500t;
        if (super.b(gVar, strArr)) {
            if (StringUtils.equals(gVar.f138343f, str2)) {
                return false;
            }
            gVar.f138343f = w0.b(str2, "{}");
            return super.c(gVar, strArr);
        }
        gVar.f138343f = w0.b(str2, "{}");
        return super.a(gVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, int i3, String str2, boolean z16) {
        JSONObject jSONObject;
        String str3;
        boolean b16 = b(str, i3, str2);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", "setExtInfo() appId:%s,versionType:%s,ret:%b,updatePkgManifests:%b,extInfo:%s", str, Integer.valueOf(i3), Boolean.valueOf(b16), Boolean.valueOf(z16), str2);
        if (b16 && z16) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    jSONObject = new JSONObject(str2);
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", "setExtInfo parse failed, appId[%s], type[%d], e[%s]", str, Integer.valueOf(i3), e16);
                }
                if (jSONObject != null) {
                    try {
                        JSONArray optJSONArray = jSONObject.optJSONArray("module_list");
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            j0.a().a(str, i3, -1, optJSONArray.toString());
                        } else {
                            j0.a().a(str, i3, -1);
                        }
                    } catch (Exception e17) {
                        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", e17, "extract module_list with appId[%s], type[%d]", str, Integer.valueOf(i3));
                    }
                    try {
                        str3 = jSONObject.optString("without_lib_md5");
                    } catch (Exception unused) {
                        str3 = null;
                    }
                    try {
                        if (!w0.c(str3)) {
                            j0.a().a(str, ModulePkgInfo.MODULE_WITHOUT_PLUGIN_CODE, 0, i3, str3, 12);
                        }
                    } catch (Exception e18) {
                        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", e18, "extract withoutLibMd5 with appId[%s], type[%d]", str, Integer.valueOf(i3));
                    }
                    try {
                        String optString = jSONObject.optString("widget_list");
                        if (!TextUtils.isEmpty(optString)) {
                            j0.a().a(str, "", 0, i3, optString);
                        }
                    } catch (Exception e19) {
                        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", e19, "extract widget_list with appId[%s], type[%d]", str, Integer.valueOf(i3));
                    }
                }
            }
            jSONObject = null;
            if (jSONObject != null) {
            }
        }
        return b16;
    }
}
