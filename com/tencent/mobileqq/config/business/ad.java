package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.info.b;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ad implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public String f202484d = "aHR0cDovL2QudXJsLmNuL215YXBwL3FxX2Rlc2svcXFfdGVybS9URVNULzEwNzQvc2hpcEFuaW1hdGlvbi56aXA=";

    /* renamed from: e, reason: collision with root package name */
    public String f202485e = "518EB9C3CA09942475B9F0A7424CD33E";

    /* renamed from: f, reason: collision with root package name */
    public String f202486f = "aHR0cHM6Ly90aS5xcS5jb20vaHlicmlkLWg1L2ludGVyYWN0aXZlX2xvZ28vaW50ZXI/dGFyZ2V0X3Vpbj14eHgmX3d2PTY3MTA4ODY3Jl93dng9MiZfbmF2X3R4dGNscj0wMDAwMDAmX3d2U2I9MA==";

    /* renamed from: h, reason: collision with root package name */
    public String f202487h = "aHR0cHM6Ly90aS5xcS5jb20vaHlicmlkLWg1L2ludGVyYWN0aXZlX2xvZ28vYWxsP193dj02NzEwODg2NyZfbmF2X3R4dGNscj0wMDAwMDAmX3d2U2I9MA==";

    /* renamed from: i, reason: collision with root package name */
    public String f202488i = "aHR0cHM6Ly90aS5xcS5jb20vdjIvaW50ZXJhY3RpdmUvc2V0dGluZw==";

    /* renamed from: m, reason: collision with root package name */
    public HashMap<Long, com.tencent.mobileqq.mutualmark.info.b> f202489m = new HashMap<>();
    public ArrayList<Long> C = new ArrayList<>();
    public ArrayList<Long> D = new ArrayList<>();
    public ArrayList<Long> E = new ArrayList<>();
    public ArrayList<Long> F = new ArrayList<>();
    public String G = "https://static-res.qq.com/static-res/interactiveResource";

    public static ad a() {
        if (QLog.isColorLevel()) {
            QLog.i("MutualMarkConfBean", 2, "defaultBean");
        }
        return j(com.tencent.mobileqq.mutualmark.g.q());
    }

    private static void i(JSONArray jSONArray, ArrayList<Long> arrayList) {
        if (jSONArray == null) {
            return;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            arrayList.add(Long.valueOf(jSONArray.optLong(i3)));
        }
    }

    public static ad j(String str) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        ad adVar = new ad();
        if (!TextUtils.isEmpty(str)) {
            if (QLog.isDebugVersion()) {
                QLog.d("MutualMarkConfBean", 4, "parse content: " + str);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("IRResource")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("IRResource");
                    adVar.f202484d = optJSONObject.optString("path");
                    adVar.f202485e = optJSONObject.optString("md5");
                    adVar.f202486f = optJSONObject.optString("c2cIntimateUrl");
                    adVar.f202487h = optJSONObject.optString("intimateListUrl");
                    if (!TextUtils.isEmpty(optJSONObject.optString("emojieggSettingUrl"))) {
                        adVar.f202488i = optJSONObject.optString("emojieggSettingUrl");
                    }
                }
                if (jSONObject.has("sort")) {
                    jSONArray = jSONObject.getJSONArray("sort");
                } else {
                    jSONArray = new JSONArray("[7, 12, 8, 6, 4, 1, 2, 3, 5]");
                }
                if (jSONObject.has("aio_left_sort")) {
                    jSONArray2 = jSONObject.getJSONArray("aio_left_sort");
                } else {
                    jSONArray2 = new JSONArray("[7, 12, 4, 5, 8, 6]");
                }
                if (jSONObject.has("aio_right_sort")) {
                    jSONArray3 = jSONObject.getJSONArray("aio_right_sort");
                } else {
                    jSONArray3 = new JSONArray("[1, 2, 3]");
                }
                i(jSONArray, adVar.D);
                i(jSONArray2, adVar.E);
                i(jSONArray3, adVar.F);
                if (jSONObject.has("IRType")) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("IRType");
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        com.tencent.mobileqq.mutualmark.info.b f16 = com.tencent.mobileqq.mutualmark.info.b.f(optJSONArray.getJSONObject(i3));
                        if (f16 != null) {
                            if (adVar.F.contains(Long.valueOf(f16.f252068a))) {
                                f16.f252071d = true;
                                f16.f252072e = adVar.F.indexOf(Long.valueOf(f16.f252068a));
                            } else {
                                int indexOf = adVar.E.indexOf(Long.valueOf(f16.f252068a));
                                if (indexOf >= 0) {
                                    f16.f252072e = indexOf;
                                }
                            }
                            int indexOf2 = adVar.D.indexOf(Long.valueOf(f16.f252068a));
                            if (indexOf2 >= 0) {
                                f16.f252070c = indexOf2;
                            }
                            adVar.f202489m.put(Long.valueOf(f16.f252068a), f16);
                            adVar.C.add(Long.valueOf(f16.f252068a));
                        }
                    }
                }
                if (jSONObject.has("resourceDomain")) {
                    adVar.G = new String(PluginBaseInfoHelper.Base64Helper.decode(jSONObject.optString("resourceDomain"), 0));
                }
            } catch (JSONException e16) {
                QLog.e("MutualMarkConfBean", 1, "parse error->" + e16.toString());
            }
        } else {
            RuntimeException runtimeException = new RuntimeException("524 manager content null\uff1a");
            runtimeException.fillInStackTrace();
            QLog.d("MutualMarkConfBean", 1, "parse content may null: " + str + ", bean:" + adVar + "\uff0cstack = " + runtimeException);
        }
        return adVar;
    }

    public String b(String str) {
        String str2 = new String(PluginBaseInfoHelper.Base64Helper.decode(MutualMarkConfProcessor.a().f202486f, 0));
        if (((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isElegantVersion()) {
            str2 = "https://ti.qq.com/interactive_new/index/?source=1&_wv=67108867&_nav_txtclr=000000&_wvSb=0&target_uin=xxx";
        }
        return str2.replace("xxx", str);
    }

    public String c() {
        return new String(PluginBaseInfoHelper.Base64Helper.decode(MutualMarkConfProcessor.a().f202488i, 0));
    }

    public ArrayList<com.tencent.mobileqq.mutualmark.info.b> d(long j3) {
        ArrayList<com.tencent.mobileqq.mutualmark.info.b> arrayList = new ArrayList<>();
        com.tencent.mobileqq.mutualmark.info.b bVar = this.f202489m.get(Long.valueOf(j3));
        if (bVar != null && !TextUtils.isEmpty(bVar.f252069b)) {
            Iterator<Map.Entry<Long, com.tencent.mobileqq.mutualmark.info.b>> it = this.f202489m.entrySet().iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.mutualmark.info.b value = it.next().getValue();
                if (value != null && value.f252068a != j3 && TextUtils.equals(bVar.f252069b, value.f252069b)) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public com.tencent.mobileqq.mutualmark.info.b e(long j3) {
        return this.f202489m.get(Long.valueOf(j3));
    }

    public b.C8128b f(long j3, long j16) {
        com.tencent.mobileqq.mutualmark.info.b bVar = this.f202489m.get(Long.valueOf(j3));
        if (bVar != null) {
            return bVar.b(j16);
        }
        return null;
    }

    public b.C8128b g(String str) {
        return f(com.tencent.mobileqq.mutualmark.g.i(str), com.tencent.mobileqq.mutualmark.g.g(str));
    }

    public int h(String str) {
        HashMap<Long, com.tencent.mobileqq.mutualmark.info.b> hashMap = this.f202489m;
        if (hashMap != null) {
            for (Map.Entry<Long, com.tencent.mobileqq.mutualmark.info.b> entry : hashMap.entrySet()) {
                if (!TextUtils.isEmpty(entry.getValue().f252069b) && entry.getValue().f252069b.equals(str)) {
                    return (int) entry.getValue().f252068a;
                }
            }
            return 0;
        }
        return 0;
    }

    public String toString() {
        return "MutualMarkConfBean{iRResourcePath='" + this.f202484d + "', iRResourcePathMd5='" + this.f202485e + "', iRResourceC2cIntimateUrl='" + this.f202486f + "', iRResourceIntimateListUrl='" + this.f202487h + "', iRResourceEmojiEggSettingUrl='" + this.f202488i + "', iRTypes=" + this.f202489m + ", iRTypesSortForShowReactivePage=" + this.C + ", iRTypesSortForNormal=" + this.D + ", iRTypesSortForAIOTitleLeft1=" + this.E + ", iRTypesSortForAIOTitleLeft2=" + this.F + ", resourceDomain='" + this.G + "'}";
    }
}
