package com.tencent.mobileqq.webview.nightmask;

import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f314003a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f314003a = 1;
        }
    }

    public static a b(ai[] aiVarArr) {
        a aVar = new a();
        try {
            aVar.f314003a = new JSONObject(aiVarArr[0].f202268b).optInt("showNightMask", 1);
        } catch (JSONException e16) {
            QLog.e("NightMaskConfBean", 1, "parse error e=" + e16);
        }
        return aVar;
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f314003a == 0) {
            return true;
        }
        return false;
    }
}
