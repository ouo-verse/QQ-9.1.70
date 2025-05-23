package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class an {

    /* renamed from: a, reason: collision with root package name */
    private boolean f202514a;

    public static an b(com.tencent.mobileqq.config.ai[] aiVarArr) {
        boolean z16;
        an anVar = new an();
        StringBuilder sb5 = new StringBuilder();
        try {
            for (com.tencent.mobileqq.config.ai aiVar : aiVarArr) {
                String str = aiVar.f202268b;
                QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, "content=", str);
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("enable_fake_msg")) {
                    if (jSONObject.optInt("enable_fake_msg", 0) == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    anVar.f202514a = z16;
                }
                sb5.append("config: ");
                sb5.append(str);
                sb5.append(",");
            }
            QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, "parse, content:" + sb5.toString());
            return anVar;
        } catch (JSONException e16) {
            QLog.e("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, "JSONException", e16);
            return null;
        }
    }

    public boolean a() {
        return this.f202514a;
    }

    public String toString() {
        return super.toString();
    }
}
