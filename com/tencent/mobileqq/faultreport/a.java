package com.tencent.mobileqq.faultreport;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.faultreport.contextinfo.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f205794a;

    /* renamed from: b, reason: collision with root package name */
    public int f205795b;

    /* renamed from: c, reason: collision with root package name */
    public String f205796c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.mobileqq.faultreport.contextinfo.a f205797d;

    /* renamed from: e, reason: collision with root package name */
    public b f205798e;

    /* renamed from: f, reason: collision with root package name */
    public ConcurrentHashMap<String, String> f205799f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f205800g;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f205794a = "default";
        this.f205795b = 0;
        this.f205796c = "";
        this.f205799f = new ConcurrentHashMap<>();
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new JSONObject(this.f205799f).toString();
    }

    public String b() {
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_FLOW_ID, this.f205794a);
            jSONObject2.put("succeededTime", this.f205795b);
            jSONObject2.put("id", this.f205796c);
            com.tencent.mobileqq.faultreport.contextinfo.a aVar = this.f205797d;
            JSONObject jSONObject3 = null;
            if (aVar != null) {
                jSONObject = aVar.a();
            } else {
                jSONObject = null;
            }
            jSONObject2.put("currentActivityInfo", jSONObject);
            b bVar = this.f205798e;
            if (bVar != null) {
                jSONObject3 = bVar.a();
            }
            jSONObject2.put("currentFragmentInfo", jSONObject3);
            jSONObject2.put("extraInfo", new JSONObject(this.f205799f));
            jSONObject2.put("isBackground", this.f205800g);
        } catch (JSONException e16) {
            QLog.e("FaultTracker.FaultTrackerReportParam", 1, e16, new Object[0]);
        }
        return jSONObject2.toString();
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return b();
    }

    public a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        this.f205794a = "default";
        this.f205795b = 0;
        this.f205796c = "";
        this.f205799f = new ConcurrentHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f205794a = jSONObject.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_FLOW_ID);
            this.f205795b = jSONObject.optInt("succeededTime");
            this.f205796c = jSONObject.optString("id");
            JSONObject optJSONObject = jSONObject.optJSONObject("currentActivityInfo");
            if (optJSONObject != null) {
                this.f205797d = new com.tencent.mobileqq.faultreport.contextinfo.a(optJSONObject.toString());
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("currentFragmentInfo");
            if (optJSONObject2 != null) {
                this.f205798e = new b(optJSONObject2.toString());
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("extraInfo");
            if (optJSONObject3 != null) {
                ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
                Iterator keys = optJSONObject3.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    concurrentHashMap.put(str2, optJSONObject3.optString(str2));
                }
                this.f205799f = concurrentHashMap;
            }
            this.f205800g = jSONObject.optBoolean("isBackground");
        } catch (Exception e16) {
            QLog.e("FaultTracker.FaultTrackerReportParam", 1, e16, new Object[0]);
        }
    }
}
