package com.tencent.mobileqq.perf.thread.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f258116a;

    /* renamed from: b, reason: collision with root package name */
    public double f258117b;

    /* renamed from: c, reason: collision with root package name */
    public double f258118c;

    /* renamed from: d, reason: collision with root package name */
    public int f258119d;

    /* renamed from: e, reason: collision with root package name */
    public int f258120e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f258121f;

    a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f258119d = 180000;
        this.f258120e = Integer.MAX_VALUE;
        this.f258116a = str;
    }

    public static a a(String str, int i3) {
        a aVar = new a(str);
        aVar.f258119d = i3;
        aVar.f258117b = 1.0d;
        aVar.f258118c = 1.0d;
        aVar.f258121f = true;
        aVar.f258120e = 100;
        return aVar;
    }

    public static a b(String str, JSONObject jSONObject) {
        boolean z16;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a(str);
        QLog.d("[TM]ThreadBlockCfgItem", 2, "[config] parse: invoked. name:" + aVar.f258116a + " cfgJson: " + jSONObject.toString());
        try {
            if (jSONObject.has("userSampleRatio")) {
                aVar.f258117b = jSONObject.getDouble("userSampleRatio");
            }
            if (Math.random() <= aVar.f258117b) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.f258121f = z16;
            if (jSONObject.has("eventSampleRatio")) {
                aVar.f258118c = jSONObject.getDouble("eventSampleRatio");
            }
            if (jSONObject.has("threshold")) {
                aVar.f258119d = jSONObject.getInt("threshold");
            }
            if (jSONObject.has("maxReportNum")) {
                aVar.f258120e = jSONObject.getInt("maxReportNum");
            }
        } catch (JSONException e16) {
            QLog.e("[TM]ThreadBlockCfgItem", 1, e16, new Object[0]);
        }
        return aVar;
    }
}
