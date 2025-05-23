package com.tencent.mobileqq.troop.temporaryban.config;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.temporaryban.b;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public b f299219a;

    /* renamed from: b, reason: collision with root package name */
    public b f299220b;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a a(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("TemporarilyBannedTroopTipsConfig", 2, "content: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            b b16 = b(jSONObject, "owner");
            b b17 = b(jSONObject, "member");
            a aVar = new a();
            aVar.f299219a = b16;
            aVar.f299220b = b17;
            return aVar;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static b b(JSONObject jSONObject, String str) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray(str);
        if (jSONArray != null && jSONArray.length() != 0) {
            b bVar = new b();
            JSONObject jSONObject2 = jSONArray.getJSONObject(0);
            bVar.f299206a = jSONObject2.optString("title", "");
            bVar.f299207b = jSONObject2.optString("text", "");
            JSONArray jSONArray2 = jSONObject2.getJSONArray("btns");
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                bVar.f299208c.add(new com.tencent.mobileqq.troop.temporaryban.a(jSONObject3.getString("text"), jSONObject3.getString("action")));
            }
            return bVar;
        }
        return null;
    }
}
