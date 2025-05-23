package com.tencent.mobileqq.springhb.entry.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes18.dex */
public class PreviewEntryData implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SpringHb_PreviewEntryData";
    public String bgImgUrl;
    public String logoImgUrl;

    public PreviewEntryData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.logoImgUrl = "";
            this.bgImgUrl = "";
        }
    }

    public void parseJson(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
        } else {
            if (jSONObject == null) {
                return;
            }
            this.logoImgUrl = jSONObject.optString("LogoImgUrl", this.logoImgUrl);
            this.bgImgUrl = jSONObject.optString("ShuaAvoidPeakBgUrl_AND", this.bgImgUrl);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "PreviewEntryData{logoImgUrl='" + this.logoImgUrl + "'bgImgUrl='" + this.bgImgUrl + "'}";
    }
}
