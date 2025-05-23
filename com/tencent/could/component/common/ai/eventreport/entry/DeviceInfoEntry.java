package com.tencent.could.component.common.ai.eventreport.entry;

import com.tencent.could.component.common.ai.eventreport.api.EventReportConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DeviceInfoEntry {
    static IPatchRedirector $redirector_;
    private String deviceModel;
    private String deviceToken;
    private String osVersion;
    private String packageName;
    private String sdkVersion;

    public DeviceInfoEntry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        String str = EventReportConfig.STRING_INIT;
        this.packageName = str;
        this.sdkVersion = str;
        this.osVersion = str;
        this.deviceModel = str;
        this.deviceToken = str;
    }

    public String getDeviceModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.deviceModel;
    }

    public String getDeviceToken() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.deviceToken;
    }

    public String getOsVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.osVersion;
    }

    public String getPackageName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.packageName;
    }

    public String getSdkVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.sdkVersion;
    }

    public void setDeviceModel(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.deviceModel = str;
        }
    }

    public void setDeviceToken(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.deviceToken = str;
        }
    }

    public void setOsVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.osVersion = str;
        }
    }

    public void setPackageName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.packageName = str;
        }
    }

    public void setSdkVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.sdkVersion = str;
        }
    }

    public String toJsonString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("packageName", this.packageName);
        jSONObject.put("sdkVersion", this.sdkVersion);
        jSONObject.put("osVersion", this.osVersion);
        jSONObject.put("deviceModel", this.deviceModel);
        jSONObject.put("deviceToken", this.deviceToken);
        jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
        return jSONObject.toString();
    }
}
