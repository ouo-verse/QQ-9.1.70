package com.tencent.mobileqq.faultreport.contextinfo;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference<Activity> f205801f;

    public a(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        this.f205807e = activity.getClass().getName();
        this.f205806d = System.currentTimeMillis();
        this.f205804b = activity.hashCode();
        this.f205801f = new WeakReference<>(activity);
    }

    public JSONObject a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f205807e);
            jSONObject.put("startTime", this.f205806d);
            jSONObject.put("hashCode", this.f205804b);
            jSONObject.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_FLOW_ID, this.f205803a);
            jSONObject.put("extraInfo", new JSONObject(this.f205805c));
        } catch (JSONException e16) {
            QLog.e("FaultTracker.ActivityInfo", 1, e16, new Object[0]);
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return a().toString();
    }

    public a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f205807e = jSONObject.optString("name");
            this.f205806d = jSONObject.optLong("startTime");
            this.f205804b = jSONObject.optInt("hashCode");
            this.f205803a = jSONObject.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_FLOW_ID);
            JSONObject optJSONObject = jSONObject.optJSONObject("extraInfo");
            if (optJSONObject != null) {
                ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    concurrentHashMap.put(str2, optJSONObject.optString(str2));
                }
                this.f205805c = concurrentHashMap;
            }
        } catch (Exception e16) {
            QLog.e("FaultTracker.ActivityInfo", 1, e16, new Object[0]);
        }
    }
}
