package com.tencent.mobileqq.qrscan.config;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f276616a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f276616a = true;
        }
    }

    public static a a() {
        if (QLog.isColorLevel()) {
            QLog.i("ScannerQQCodeConfBean", 2, "defaultBean");
        }
        return new a();
    }

    public static a b(String str) {
        boolean z16;
        a aVar = new a();
        if (!TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("ScannerQQCodeConfBean", 2, "parse content: " + str);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("useQBarAIModel")) {
                    if (jSONObject.optInt("useQBarAIModel") == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    aVar.f276616a = z16;
                }
            } catch (JSONException e16) {
                QLog.e("ScannerQQCodeConfBean", 1, "parse error->" + e16.toString());
            }
        }
        return aVar;
    }
}
