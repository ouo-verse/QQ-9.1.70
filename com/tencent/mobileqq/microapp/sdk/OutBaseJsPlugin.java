package com.tencent.mobileqq.microapp.sdk;

import android.app.Activity;
import com.tencent.mobileqq.microapp.MiniAppInterface;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes15.dex */
public abstract class OutBaseJsPlugin {
    static IPatchRedirector $redirector_;
    protected MiniAppInterface appInterface;
    boolean isDestroy;

    public OutBaseJsPlugin(MiniAppInterface miniAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) miniAppInterface);
        } else {
            this.isDestroy = false;
            this.appInterface = miniAppInterface;
        }
    }

    public boolean canHandleJsRequest(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        Set eventMap = getEventMap();
        if (eventMap != null) {
            return eventMap.contains(str);
        }
        return false;
    }

    protected String gernerateStateResultParams(JSONObject jSONObject, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, jSONObject, str, str2);
        }
        return c.a(jSONObject, "errMsg", str + ":" + str2).toString();
    }

    public abstract Set getEventMap();

    public String handleNativeRequest(Activity activity, String str, String str2, String str3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, activity, str, str2, str3, Integer.valueOf(i3));
        }
        return "";
    }

    public void handleNativeResponse(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, Integer.valueOf(i3));
        } else {
            MiniAppController.getInstance().handleNativeResponse(this, str, str2, i3);
        }
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.isDestroy = true;
        }
    }
}
