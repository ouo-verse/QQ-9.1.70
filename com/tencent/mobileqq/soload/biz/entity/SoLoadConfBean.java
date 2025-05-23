package com.tencent.mobileqq.soload.biz.entity;

import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SoLoadConfBean {
    static IPatchRedirector $redirector_;
    public ai[] confFiles;

    public SoLoadConfBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.confFiles = new ai[0];
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder("SoLoadConfBean:");
        ai[] aiVarArr = this.confFiles;
        if (aiVarArr != null) {
            for (ai aiVar : aiVarArr) {
                if (aiVar != null) {
                    sb5.append("confItem ");
                    sb5.append(aiVar.f202267a);
                    sb5.append(":");
                    sb5.append(aiVar.f202268b);
                    sb5.append("\n");
                }
            }
        }
        return sb5.toString();
    }
}
