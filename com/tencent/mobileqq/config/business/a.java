package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f202478a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f202479b = -1;

    public static a a(com.tencent.mobileqq.config.ai[] aiVarArr) {
        a aVar = new a();
        if (aiVarArr != null && aiVarArr.length > 0) {
            for (com.tencent.mobileqq.config.ai aiVar : aiVarArr) {
                if (aiVar != null) {
                    String str = aiVar.f202268b;
                    try {
                        b(new JSONObject(str), aVar);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("AlbumBean", 2, "parse: " + str + " bean:" + aVar);
                    }
                }
            }
        }
        return aVar;
    }

    private static void b(JSONObject jSONObject, a aVar) {
        if (jSONObject.has("troopFlashPicEnter")) {
            aVar.f202478a = jSONObject.optInt("troopFlashPicEnter");
        }
        if (jSONObject.has("c2cFlashPicEnter")) {
            aVar.f202479b = jSONObject.optInt("c2cFlashPicEnter");
        }
    }

    public String toString() {
        return "AlbumBean{troopFlashPicEnter=" + this.f202478a + "c2cFlashPicEnter=" + this.f202479b + '}';
    }
}
