package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private JSONArray f202839a = new JSONArray();

    public static u a(String str) {
        u uVar = new u();
        if (QLog.isColorLevel()) {
            QLog.d("IceBreakConfBean", 2, "parse content = " + str);
        }
        try {
            uVar.f202839a = new JSONObject(str).optJSONArray("cmShowTemplates");
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("IceBreakConfBean", 2, "parse JSONException", e16);
            }
        }
        return uVar;
    }
}
