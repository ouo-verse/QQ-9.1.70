package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class am {

    /* renamed from: a, reason: collision with root package name */
    private boolean f202513a;

    public static am b(com.tencent.mobileqq.config.ai[] aiVarArr) {
        boolean z16;
        am amVar = new am();
        StringBuilder sb5 = new StringBuilder();
        try {
            for (com.tencent.mobileqq.config.ai aiVar : aiVarArr) {
                String str = aiVar.f202268b;
                QLog.d("OpenSdkD55Processor", 1, "content=", str);
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("enable_d55")) {
                    if (jSONObject.optInt("enable_d55", 0) == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    amVar.f202513a = z16;
                }
                sb5.append("config: ");
                sb5.append(str);
                sb5.append(",");
            }
            QLog.d("OpenSdkD55Processor", 1, "parse, content:" + sb5.toString());
            return amVar;
        } catch (JSONException e16) {
            QLog.e("OpenSdkD55Processor", 1, "JSONException", e16);
            return null;
        }
    }

    public boolean a() {
        return this.f202513a;
    }

    public String toString() {
        return super.toString();
    }
}
