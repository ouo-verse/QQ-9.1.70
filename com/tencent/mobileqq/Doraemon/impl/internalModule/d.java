package com.tencent.mobileqq.Doraemon.impl.internalModule;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.e;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d extends e {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.e
    public boolean c(int i3, String str, JSONObject jSONObject, @NonNull com.tencent.mobileqq.Doraemon.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, jSONObject, aVar)).booleanValue();
        }
        switch (i3) {
            case 31:
                DoraemonUtil.e(aVar, null);
                return true;
            case 32:
                DoraemonUtil.e(aVar, null);
                return true;
            case 33:
                DoraemonUtil.e(aVar, null);
                return true;
            default:
                return false;
        }
    }
}
