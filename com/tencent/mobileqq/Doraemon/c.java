package com.tencent.mobileqq.Doraemon;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final JSONObject f154094a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29780);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f154094a = new JSONObject();
        }
    }

    public static JSONObject a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null) {
            return f154094a;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                obj = a((Bundle) obj);
            }
            try {
                jSONObject.put(str, obj);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("APIParam", 2, e16.getMessage(), e16);
                }
            }
        }
        return jSONObject;
    }
}
