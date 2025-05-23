package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class bm {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public boolean f202624a = false;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public boolean f202625b = false;

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public boolean f202626c = true;

    /* renamed from: d, reason: collision with root package name */
    public String f202627d = "0";

    /* renamed from: e, reason: collision with root package name */
    public String f202628e = "0";

    /* renamed from: f, reason: collision with root package name */
    public String f202629f = "0";

    /* renamed from: g, reason: collision with root package name */
    public String f202630g = "0";

    /* renamed from: h, reason: collision with root package name */
    public String f202631h = "0";

    /* renamed from: i, reason: collision with root package name */
    public String f202632i = "";

    public static bm a(String str) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (str == null) {
            return null;
        }
        try {
            bm bmVar = new bm();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("wvShouldReportPerf")) {
                if (jSONObject.optInt("wvShouldReportPerf") == 1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                bmVar.f202624a = z18;
            }
            if (jSONObject.has("wvShouldReportJsapiCall")) {
                if (jSONObject.optInt("wvShouldReportJsapiCall") == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                bmVar.f202625b = z17;
            }
            if (jSONObject.has("wvShouldReportOpenapiCall")) {
                if (jSONObject.optInt("wvShouldReportOpenapiCall") == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                bmVar.f202626c = z16;
            }
            if (jSONObject.has("wvPerformanceRate")) {
                bmVar.f202627d = jSONObject.optString("wvPerformanceRate");
            }
            if (jSONObject.has("wvJsapiCallRate")) {
                bmVar.f202628e = jSONObject.optString("wvJsapiCallRate");
            }
            if (jSONObject.has("wvOpenapiCallRate")) {
                bmVar.f202631h = jSONObject.optString("wvOpenapiCallRate");
            }
            if (jSONObject.has("wvWhitelistUpdateRate")) {
                bmVar.f202629f = jSONObject.optString("wvWhitelistUpdateRate");
            }
            if (jSONObject.has("wvSchemeRate")) {
                bmVar.f202630g = jSONObject.optString("wvSchemeRate");
            }
            if (jSONObject.has("recogniseText")) {
                bmVar.f202632i = jSONObject.optString("recogniseText");
            }
            QLog.d("ConfBean", 2, "confBean = " + bmVar.toString());
            return bmVar;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ConfBean", 1, "parse e:", e16.toString());
                return null;
            }
            return null;
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(100);
        sb5.append(" performanceRate:");
        sb5.append(this.f202627d);
        sb5.append(" jsapiRate:");
        sb5.append(this.f202628e);
        sb5.append(" reportOpenapiRate:");
        sb5.append(this.f202631h);
        sb5.append(" whitelistUpdateRate:");
        sb5.append(this.f202629f);
        sb5.append(" schemeRate:");
        sb5.append(this.f202630g);
        sb5.append(" recogniseText:");
        sb5.append(this.f202632i);
        return sb5.toString();
    }
}
