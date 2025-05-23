package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ac {

    /* renamed from: a, reason: collision with root package name */
    public int f202483a = 1;

    public static ac a(com.tencent.mobileqq.config.ai[] aiVarArr) {
        ac acVar = new ac();
        try {
            for (com.tencent.mobileqq.config.ai aiVar : aiVarArr) {
                JSONObject jSONObject = new JSONObject(aiVar.f202268b);
                if (jSONObject.has("cameraSwitchOnMessageTab")) {
                    acVar.f202483a = Integer.valueOf(jSONObject.optString("cameraSwitchOnMessageTab")).intValue();
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgTabCameraConfBean", 2, "onParsed switch= " + acVar.f202483a);
            }
        } catch (Throwable th5) {
            QLog.e("MsgTabCameraConfBean", 1, "MsgTabCameraConfBean parse error, ", th5);
        }
        return acVar;
    }
}
