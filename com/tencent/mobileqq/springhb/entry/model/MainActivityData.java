package com.tencent.mobileqq.springhb.entry.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.ad;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MainActivityData implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SpringHb_MainActivityData";
    public TimeInfo configTimeInfo;
    public int type;

    public MainActivityData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.configTimeInfo = TimeInfo.newEmpty();
            this.type = 0;
        }
    }

    public static MainActivityData newEmpty() {
        return new MainActivityData();
    }

    public void parseJson(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
        } else {
            if (jSONObject == null) {
                return;
            }
            this.configTimeInfo.begin = ad.d(jSONObject.optString("BeginTime"));
            this.configTimeInfo.end = ad.d(jSONObject.optString("EndTime"));
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "MainActivityData{configTimeInfo=" + this.configTimeInfo + '}';
    }
}
