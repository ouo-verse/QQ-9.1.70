package com.tencent.mobileqq.springhb.entry.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SpringH5ResourceData implements Serializable {
    static IPatchRedirector $redirector_;
    public String filePath;
    public String musicClosePath;
    public String musicOpenPath;
    public String skipPath;

    public SpringH5ResourceData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "SpringH5ResourceData{filePath='" + this.filePath + "', skipPath=" + this.skipPath + ", musicOpenPath=" + this.musicOpenPath + ", musicClosePath=" + this.musicClosePath + '}';
    }
}
