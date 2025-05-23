package com.qq.e.comm.plugin.base.ad.c;

import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.model.l;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoErrorCode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f extends a {
    public static boolean a(JSONObject jSONObject, l lVar, String str) {
        return a(jSONObject, lVar, str, (JSONArray) null);
    }

    @Override // com.qq.e.comm.plugin.base.ad.c.a
    protected void b(JSONArray jSONArray, String str) {
        if (!b()) {
            GDTLogger.i("ReltargetInstalledReporter Switch close");
            return;
        }
        if (jSONArray != null && str.length() > 0) {
            l lVar = new l(str, com.qq.e.comm.plugin.base.ad.b.NATIVEUNIFIEDAD, (com.qq.e.comm.plugin.base.ad.definition.a) null);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    a(jSONArray.getJSONObject(i3), lVar, (String) null);
                } catch (JSONException e16) {
                    GDTLogger.e("ReltargetInstalledReporter error", e16);
                }
            }
            return;
        }
        GDTLogger.e("ReltargetInstalledReporter preload params error");
    }

    public static boolean a(JSONObject jSONObject, l lVar, String str, JSONArray jSONArray) {
        String str2;
        boolean z16 = true;
        if (com.qq.e.comm.plugin.k.d.a(jSONObject) || a(jSONObject)) {
            boolean a16 = com.qq.e.comm.plugin.k.c.a(GDTADManager.getInstance().getAppContext(), com.qq.e.comm.plugin.k.b.a(jSONObject));
            int b16 = com.qq.e.comm.plugin.k.b.b(jSONObject);
            str2 = "1";
            if (com.qq.e.comm.plugin.k.d.a(jSONObject)) {
                if (a16 && b16 == 1) {
                    z16 = false;
                } else if (a16 || b16 != 2) {
                    str2 = "";
                } else {
                    z16 = false;
                    str2 = "0";
                }
                if (!z16) {
                    a(jSONObject, lVar, str, str2, jSONArray);
                }
            } else {
                a(jSONObject, lVar, str, a16 ? "1" : "0", jSONArray);
            }
        }
        return z16;
    }

    public static void a(JSONObject jSONObject, l lVar, String str, String str2, JSONArray jSONArray) {
        try {
            com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c(new JSONObject(a(com.qq.e.comm.plugin.k.b.a(jSONObject), y.a(jSONObject) ? jSONObject.optString("traceid") : "", lVar, str, str2, null), new String[]{"package_name", "timestamp", "install_status"}));
            cVar.a("threadid", str);
            cVar.a(Constants.KEYS.PLCINFO, com.qq.e.comm.plugin.base.ad.e.d.a(lVar));
            if (jSONArray != null) {
                jSONArray.mo162put(cVar);
            }
            com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
            if (lVar != null) {
                bVar.a(lVar.a());
            }
            bVar.b(jSONObject.optString("cl"));
            bVar.c(jSONObject.optString("traceid"));
            StatTracer.trackEvent(WiFiPhotoErrorCode.ERR_FILEBRIDGE_GET_FOLDER_CONTENT_FAIL, com.qq.e.comm.plugin.k.b.b(jSONObject), bVar, cVar);
            if (lVar == null || lVar.b() == null) {
                return;
            }
            StatTracer.trackEvent(100212, lVar.b().b(), bVar, cVar);
        } catch (Exception e16) {
            GDTLogger.d("reportInstallStatus exception. " + e16.getMessage());
        }
    }

    private boolean b() {
        return GDTADManager.getInstance().getSM().getInteger("is_target_install_report", 0) == 1;
    }

    public static JSONObject a(String str, String str2, l lVar, String str3, String str4, String str5) {
        JSONObject a16 = y.a();
        y.a(a16, "muidtype", "imei");
        String hashDeviceId = ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getHashDeviceId();
        y.a(a16, "muid", hashDeviceId);
        y.a(a16, "package_name", str);
        y.a(a16, "timestamp", System.currentTimeMillis() + "");
        y.a(a16, "install_status", str4);
        y.a(a16, "traceid", str2);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(110, String.valueOf(hashDeviceId));
        com.qq.e.comm.plugin.base.ad.e.d.a(1006, a16, lVar, str3, concurrentHashMap, str5);
        return a16;
    }

    public static boolean a(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.optInt("producttype") == 25;
    }

    public static List<JSONObject> a(JSONArray jSONArray, l lVar, String str) {
        return a(jSONArray, lVar, str, (boolean[]) null);
    }

    public static List<JSONObject> a(JSONArray jSONArray, l lVar, String str, boolean[] zArr) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray2 = new JSONArray();
        if (jSONArray != null) {
            if (zArr != null && jSONArray.length() != zArr.length) {
                GDTLogger.e("ad.len != filter.len!!");
                return arrayList;
            }
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                boolean a16 = a(optJSONObject, lVar, str, jSONArray2);
                if (a16) {
                    arrayList.add(optJSONObject);
                }
                if (zArr != null) {
                    zArr[i3] = !a16;
                }
            }
        }
        if (jSONArray != null && jSONArray.length() > 0 && arrayList.size() == 0) {
            com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
            cVar.a("filters", jSONArray2);
            StatTracer.trackEvent(100222, lVar.b().b(), new com.qq.e.comm.plugin.stat.b().a(lVar.a()), cVar);
        }
        return arrayList;
    }
}
