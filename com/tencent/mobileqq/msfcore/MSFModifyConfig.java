package com.tencent.mobileqq.msfcore;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFModifyConfig implements MSFConfig {
    static IPatchRedirector $redirector_;
    HashMap<String, Boolean> mConfigMap;
    int mType;

    public MSFModifyConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mConfigMap = new HashMap<>();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NonNull
    public HashMap<String, Boolean> getConfigMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mConfigMap;
    }

    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mType;
    }

    @NonNull
    public void setConfigMap(HashMap<String, Boolean> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) hashMap);
        } else {
            this.mConfigMap = hashMap;
        }
    }

    public void setType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mType = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "MSFModifyConfig{mType=" + this.mType + ",mConfigMap=" + this.mConfigMap + ",}";
    }

    public MSFModifyConfig(int i3, @NonNull HashMap<String, Boolean> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) hashMap);
            return;
        }
        new HashMap();
        this.mType = i3;
        this.mConfigMap = hashMap;
    }
}
