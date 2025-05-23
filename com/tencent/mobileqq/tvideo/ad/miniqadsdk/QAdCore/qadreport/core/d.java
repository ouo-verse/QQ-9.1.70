package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core;

import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParamKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public AdReport f304048a;

    /* renamed from: b, reason: collision with root package name */
    public String f304049b;

    /* renamed from: c, reason: collision with root package name */
    public String f304050c;

    /* renamed from: d, reason: collision with root package name */
    public String f304051d;

    /* renamed from: e, reason: collision with root package name */
    public String f304052e;

    /* renamed from: i, reason: collision with root package name */
    private Map<String, String> f304056i;

    /* renamed from: j, reason: collision with root package name */
    protected String f304057j;

    /* renamed from: l, reason: collision with root package name */
    private String f304059l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f304060m;

    /* renamed from: n, reason: collision with root package name */
    private Map<String, String> f304061n;

    /* renamed from: f, reason: collision with root package name */
    protected int f304053f = 1;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f304054g = true;

    /* renamed from: h, reason: collision with root package name */
    private int f304055h = 0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f304058k = true;

    public d(AdReport adReport, String str, String str2, String str3, String str4) {
        this.f304048a = adReport;
        this.f304049b = str;
        this.f304050c = str2;
        this.f304051d = str3;
        this.f304052e = str4;
    }

    @Nullable
    private JSONObject c(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    private String d(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return null;
        }
        String str = "";
        if (arrayList.size() == 0) {
            return "";
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            if (str.length() > 0) {
                next = "," + next;
            }
            sb5.append(next);
            str = sb5.toString();
        }
        return str;
    }

    private AdReport f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        AdReport adReport = new AdReport();
        adReport.reportKey = jSONObject.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY);
        adReport.reportParam = jSONObject.optString("reportParam");
        adReport.url = jSONObject.optString("url");
        adReport.apiReportUrl = n(jSONObject.optString("apiReportUrl"));
        adReport.sdkReportUrl = n(jSONObject.optString("sdkReportUrl"));
        adReport.reportTime = jSONObject.optInt("reportTime");
        return adReport;
    }

    private JSONObject g() {
        if (this.f304048a == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY, this.f304048a.reportKey);
            jSONObject.put("reportParam", this.f304048a.reportParam);
            jSONObject.put("url", this.f304048a.url);
            jSONObject.put("apiReportUrl", d(this.f304048a.apiReportUrl));
            jSONObject.put("sdkReportUrl", d(this.f304048a.sdkReportUrl));
            jSONObject.put("reportTime", this.f304048a.reportTime);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    private ArrayList<String> n(String str) {
        if (!TextUtils.isEmpty(str)) {
            return new ArrayList<>(Arrays.asList(str.split(",")));
        }
        return null;
    }

    private Map<String, String> o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, jSONObject.optString(str));
        }
        return hashMap;
    }

    private JSONObject p() {
        return c(this.f304056i);
    }

    public HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        String q16 = q();
        if (q16 != null) {
            hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_URL, q16);
        }
        String str = this.f304051d;
        if (str != null) {
            hashMap.put(QAdReportDefine$AdReporterParamKey.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY, str);
        }
        String str2 = this.f304052e;
        if (str2 != null) {
            hashMap.put(QAdReportDefine$AdReporterParamKey.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAM, str2);
        }
        if (!y.i(this.f304056i)) {
            hashMap.putAll(this.f304056i);
        }
        return hashMap;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f304048a = f(jSONObject.optJSONObject("adReport"));
        this.f304049b = jSONObject.optString("adId", null);
        this.f304050c = jSONObject.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_POS, null);
        this.f304051d = jSONObject.optString(QAdReportDefine$AdReporterParamKey.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY, null);
        this.f304052e = jSONObject.optString(QAdReportDefine$AdReporterParamKey.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAM, null);
        this.f304053f = jSONObject.optInt("requestMethod", 1);
        this.f304054g = jSONObject.optBoolean("needRetry", true);
        this.f304055h = jSONObject.optInt("dp3Scenario", 0);
        this.f304056i = o(jSONObject.optJSONObject("pbMTAReportMap"));
        this.f304057j = jSONObject.optString("body", null);
        this.f304058k = jSONObject.optBoolean("needAppendRetryToUrl", true);
        this.f304059l = jSONObject.optString("destUrl", null);
        this.f304060m = jSONObject.optBoolean("useDestUrl", false);
        this.f304061n = o(jSONObject.optJSONObject("headerParams"));
    }

    public String h() {
        return this.f304057j;
    }

    public String i() {
        return this.f304059l;
    }

    public int j() {
        return this.f304055h;
    }

    public Map<String, String> k() {
        return this.f304061n;
    }

    public int l() {
        return this.f304053f;
    }

    public JSONObject m() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adReport", g());
            jSONObject.put("adId", this.f304049b);
            jSONObject.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_POS, this.f304050c);
            jSONObject.put(QAdReportDefine$AdReporterParamKey.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY, this.f304051d);
            jSONObject.put(QAdReportDefine$AdReporterParamKey.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAM, this.f304052e);
            jSONObject.put("requestMethod", this.f304053f);
            jSONObject.put("needRetry", this.f304054g);
            jSONObject.put("dp3Scenario", this.f304055h);
            jSONObject.put("pbMTAReportMap", p());
            jSONObject.put("body", this.f304057j);
            jSONObject.put("needAppendRetryToUrl", this.f304058k);
            jSONObject.put("destUrl", this.f304059l);
            jSONObject.put("useDestUrl", this.f304060m);
            JSONObject c16 = c(this.f304061n);
            if (c16 != null) {
                jSONObject.put("headerParams", c16);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    public abstract String q();

    public boolean r() {
        return this.f304060m;
    }

    public HashMap<String, String> s() {
        return b();
    }

    public abstract void t(g gVar);

    public void u(int i3) {
        this.f304055h = i3;
    }

    public void v(Map<String, String> map) {
        this.f304061n = map;
    }

    public void w(boolean z16) {
        this.f304054g = z16;
    }

    public void x(Map<String, String> map) {
        this.f304056i = map;
    }
}
