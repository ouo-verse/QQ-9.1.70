package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ao {

    /* renamed from: a, reason: collision with root package name */
    private boolean f202515a = true;

    public static ao b(com.tencent.mobileqq.config.ai[] aiVarArr) {
        boolean z16;
        ao aoVar = new ao();
        StringBuilder sb5 = new StringBuilder();
        try {
            for (com.tencent.mobileqq.config.ai aiVar : aiVarArr) {
                String str = aiVar.f202268b;
                QLog.d("OpenSdkD55Processor", 1, "content=", str);
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("enableIframe")) {
                    if (jSONObject.optInt("enableIframe", 1) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    aoVar.f202515a = z16;
                }
                sb5.append("config: ");
                sb5.append(str);
                sb5.append(",");
            }
            QLog.d("OpenSdkIFrameProcessor", 1, "parse, content:" + sb5.toString());
            return aoVar;
        } catch (JSONException e16) {
            QLog.e("OpenSdkIFrameProcessor", 1, "JSONException", e16);
            return null;
        }
    }

    public boolean a() {
        return this.f202515a;
    }
}
