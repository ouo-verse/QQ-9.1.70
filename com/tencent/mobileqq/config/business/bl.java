package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class bl {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, a> f202622a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        double f202623a;

        a() {
        }
    }

    public static bl b(String str) {
        bl blVar = new bl();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
                a aVar = new a();
                aVar.f202623a = jSONObject2.optDouble("execute_rate_second");
                blVar.f202622a.put(str2, aVar);
            }
            QLog.d("WVFrequencyConfProcessor", 2, "confBean = " + blVar.toString());
            return blVar;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("WVFrequencyConfProcessor", 1, "parse e:", e16.toString());
            }
            return blVar;
        }
    }

    public boolean a(String str, long j3) {
        if (!this.f202622a.containsKey(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - j3;
        if (currentTimeMillis <= 0 || currentTimeMillis >= this.f202622a.get(str).f202623a * 1000.0d) {
            return false;
        }
        QLog.d("WVFrequencyConfProcessor", 1, "is too frequent");
        return true;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(100);
        sb5.append(this.f202622a.toString());
        return sb5.toString();
    }
}
