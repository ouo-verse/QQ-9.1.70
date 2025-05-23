package com.tencent.mobileqq.manager;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.p;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static b a(Context context, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("QSafeDialogBean", 2, String.format("parse content=%s", str2));
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            p.g(context, str, true, "identitymaxlimit", Integer.valueOf(jSONObject.getInt("totalcount")));
            JSONArray jSONArray = jSONObject.getJSONArray("biz");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                p.g(context, str, true, "identitybusiness" + jSONObject2.getInt("id"), Integer.valueOf(jSONObject2.getInt("count")));
            }
        } catch (Throwable th5) {
            QLog.e("QSafeDialogBean", 1, "QSafeDialogBean parse err: " + th5.getMessage());
        }
        return null;
    }
}
