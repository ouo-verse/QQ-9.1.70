package com.tencent.mobileqq.config;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class au implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public boolean f202339d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f202340e = 1000;

    public static au a(String str) {
        au auVar = new au();
        if (TextUtils.isEmpty(str)) {
            return auVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("is_open_thread_monitor")) {
                auVar.f202339d = jSONObject.getBoolean("is_open_thread_monitor");
            }
            if (jSONObject.has("report_sample")) {
                auVar.f202340e = jSONObject.getInt("report_sample");
            }
        } catch (JSONException e16) {
            QLog.e("ThreadMonitorConfigBean", 1, e16, new Object[0]);
        }
        return auVar;
    }

    public String toString() {
        return "ThreadMonitorConfigBean{isOpenThreadMonitor=" + this.f202339d + ", reportSample=" + this.f202340e + '}';
    }
}
