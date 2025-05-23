package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class as {

    /* renamed from: a, reason: collision with root package name */
    public int f202526a = -1;

    public static as a(com.tencent.mobileqq.config.ai[] aiVarArr) {
        as asVar = new as();
        if (aiVarArr != null && aiVarArr.length > 0) {
            for (com.tencent.mobileqq.config.ai aiVar : aiVarArr) {
                if (aiVar != null) {
                    String str = aiVar.f202268b;
                    try {
                        b(new JSONObject(str), asVar);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("PhotoListPanelBean", 2, "parse: " + str + " bean:" + asVar);
                    }
                }
            }
        }
        return asVar;
    }

    private static void b(JSONObject jSONObject, as asVar) {
        if (jSONObject.has("dragMode")) {
            asVar.f202526a = jSONObject.optInt("dragMode");
        }
    }

    public String toString() {
        return "PhotoListPanelBean{dragMode=" + this.f202526a + '}';
    }
}
