package com.tencent.could.huiyansdk.entity;

import com.tencent.could.huiyansdk.enums.HuiYanLiveMode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class HuiYanBaseConfig {
    static IPatchRedirector $redirector_;
    private HuiYanLiveMode huiYanLiveMode;
    private String license;
    private String modelPath;

    public HuiYanBaseConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.license = "";
        this.modelPath = "";
        this.huiYanLiveMode = HuiYanLiveMode.ACTION_REFLECT_MODE;
    }

    public HuiYanLiveMode getHuiYanLiveMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HuiYanLiveMode) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.huiYanLiveMode;
    }

    public String getLicense() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.license;
    }

    public String getModelPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.modelPath;
    }

    public void setHuiYanLiveMode(HuiYanLiveMode huiYanLiveMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) huiYanLiveMode);
        } else {
            this.huiYanLiveMode = huiYanLiveMode;
        }
    }

    public void setLicense(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.license = str;
        }
    }

    public void setModelPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.modelPath = str;
        }
    }
}
