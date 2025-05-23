package com.tencent.mobileqq.config.business;

import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f202645a = false;

    /* renamed from: b, reason: collision with root package name */
    private long f202646b = 86400000;

    /* renamed from: c, reason: collision with root package name */
    private long f202647c = 2500;

    /* renamed from: d, reason: collision with root package name */
    private long f202648d = 2500;

    /* renamed from: e, reason: collision with root package name */
    private int f202649e = 90;

    /* renamed from: f, reason: collision with root package name */
    private boolean f202650f = false;

    /* renamed from: g, reason: collision with root package name */
    private int f202651g = 2000;

    public static c h(com.tencent.mobileqq.config.ai[] aiVarArr) {
        c cVar = new c();
        if (aiVarArr != null && aiVarArr.length > 0) {
            for (com.tencent.mobileqq.config.ai aiVar : aiVarArr) {
                if (aiVar != null) {
                    String str = aiVar.f202268b;
                    try {
                        i(new JSONObject(str).getJSONObject("and"), cVar);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                        QLog.e("AvifDownloadBean", 2, "parse: " + str + " bean:" + cVar, e16);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("AvifDownloadBean", 2, "parse: " + str + " bean:" + cVar);
                    }
                }
            }
        }
        return cVar;
    }

    private static void i(JSONObject jSONObject, c cVar) {
        if (jSONObject.has(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH)) {
            cVar.f202645a = jSONObject.optBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
        }
        if (jSONObject.has("req_cap_time")) {
            cVar.f202646b = jSONObject.optInt("req_cap_time") * 3600000;
        }
        if (jSONObject.has("img_w")) {
            cVar.f202647c = jSONObject.optInt("img_w");
        }
        if (jSONObject.has("img_h")) {
            cVar.f202648d = jSONObject.optInt("img_h");
        }
        if (jSONObject.has(CustomImageProps.QUALITY)) {
            cVar.f202649e = jSONObject.optInt(CustomImageProps.QUALITY);
        }
        if (jSONObject.has("yuv_to_jpg")) {
            cVar.f202650f = jSONObject.optBoolean("yuv_to_jpg", false);
        }
        if (jSONObject.has("report_max_cost")) {
            cVar.f202651g = jSONObject.optInt("report_max_cost");
        }
    }

    public long a() {
        return this.f202648d;
    }

    public long b() {
        return this.f202647c;
    }

    public int c() {
        return Math.max(this.f202649e, 70);
    }

    public int d() {
        return this.f202651g;
    }

    public long e() {
        return Math.max(this.f202646b, 3600000L);
    }

    public boolean f() {
        return this.f202645a;
    }

    public boolean g() {
        return this.f202650f;
    }

    public String toString() {
        return "AvifDownloadBean{mSwitch=" + this.f202645a + ", mReqCapTime=" + this.f202646b + ", mMaxWidth=" + this.f202647c + ", mMaxHeight=" + this.f202648d + ", mQuality=" + this.f202649e + ", mYuvToJpg=" + this.f202650f + ", mReportMaxCost=" + this.f202651g + '}';
    }
}
