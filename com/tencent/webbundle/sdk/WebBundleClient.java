package com.tencent.webbundle.sdk;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebBundleClient {
    static IPatchRedirector $redirector_;
    private String bizId;

    @Nullable
    private WebBundle webBundle;

    public WebBundleClient(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.bizId = str;
        }
    }

    @Nullable
    public final IWebBundleWebView getValidWebView(@NotNull Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IWebBundleWebView) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) str);
        }
        WebBundle availableWebBundle = WebBundleManager.getInstance(this.bizId).getAvailableWebBundle(context, str);
        this.webBundle = availableWebBundle;
        if (availableWebBundle != null) {
            return availableWebBundle.getWebView();
        }
        return null;
    }

    public final boolean interceptLoadUrl(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent)).booleanValue();
        }
        if (this.webBundle != null) {
            String stringExtra = intent.getStringExtra(WebBundleConstants.WEBBUNDLE_BUNDLE_DATA);
            String stringExtra2 = intent.getStringExtra(WebBundleConstants.WEBBUNDLE_REAL_URL);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", WebBundleConstants.EVENT_TYPE_OF_PUSH_VIEW);
                jSONObject.put("data", new JSONObject(stringExtra));
                jSONObject.put("url", stringExtra2);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            this.webBundle.use(jSONObject);
            return true;
        }
        return false;
    }
}
