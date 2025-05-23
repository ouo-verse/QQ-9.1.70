package com.tencent.mobileqq.config.business;

import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class at {

    /* renamed from: a, reason: collision with root package name */
    public boolean f202527a = true;

    /* renamed from: b, reason: collision with root package name */
    public int f202528b = 8;

    /* renamed from: c, reason: collision with root package name */
    public long f202529c = SafeBitmapFactory.PX_THRESHOID_DEFAULTS;

    /* renamed from: d, reason: collision with root package name */
    public int f202530d = 7;

    /* renamed from: e, reason: collision with root package name */
    public long f202531e = 16777216;

    /* renamed from: f, reason: collision with root package name */
    public long f202532f = 16777216;

    /* renamed from: g, reason: collision with root package name */
    public int f202533g = -1;

    public static at a(com.tencent.mobileqq.config.ai[] aiVarArr) {
        at atVar = new at();
        if (aiVarArr != null && aiVarArr.length > 0) {
            for (com.tencent.mobileqq.config.ai aiVar : aiVarArr) {
                if (aiVar != null) {
                    String str = aiVar.f202268b;
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        c(jSONObject, atVar);
                        d(jSONObject, atVar);
                        b(jSONObject, atVar);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("PicCommonBean", 2, "parse: " + str + " bean:" + atVar);
                    }
                }
            }
        }
        if (atVar.f202528b < 0) {
            atVar.f202528b = 8;
        }
        if (atVar.f202529c < 0) {
            atVar.f202529c = SafeBitmapFactory.PX_THRESHOID_DEFAULTS;
        }
        if (atVar.f202530d < 1) {
            atVar.f202529c = 7L;
        }
        return atVar;
    }

    private static void b(JSONObject jSONObject, at atVar) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("switchEXIF");
        if (jSONObject2.has(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH)) {
            atVar.f202533g = jSONObject2.optInt(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
        }
    }

    private static void c(JSONObject jSONObject, at atVar) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("regionDecode");
        if (jSONObject2.has("ramThreshold")) {
            atVar.f202528b = jSONObject2.optInt("ramThreshold");
        }
        if (jSONObject2.has("pxThreshold")) {
            atVar.f202529c = jSONObject2.optLong("pxThreshold");
        }
        if (jSONObject2.has("threadCount")) {
            atVar.f202530d = jSONObject2.optInt("threadCount");
        }
        if (jSONObject2.has("needRegionDecode")) {
            atVar.f202527a = jSONObject2.optBoolean("needRegionDecode");
        }
    }

    private static void d(JSONObject jSONObject, at atVar) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("uploadLimit");
        if (jSONObject2.has("c2c")) {
            atVar.f202531e = jSONObject2.optInt("c2c");
        }
        if (jSONObject2.has(VipFunCallConstants.KEY_GROUP)) {
            atVar.f202532f = jSONObject2.optInt(VipFunCallConstants.KEY_GROUP);
        }
    }

    public String toString() {
        return "PicCommonBean{needRegionDecode=" + this.f202527a + ", ramThreshold=" + this.f202528b + ", pxThreshold=" + this.f202529c + ", threadCount=" + this.f202530d + ", C2C_FileSize_Limit=" + this.f202531e + ", GROUP_FileSize_Limit=" + this.f202532f + ", EXIF_SWITCH=" + this.f202533g + '}';
    }
}
