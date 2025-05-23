package com.tencent.replacemonitor.replace.st;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmassistantbase.util.b;

/* compiled from: P */
/* loaded from: classes25.dex */
public class InstallStartLog extends ReplaceBaseLog {
    static IPatchRedirector $redirector_;
    public long installStartTime;

    public InstallStartLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.replacemonitor.replace.st.ReplaceBaseLog, com.tencent.tmassistant.st.a
    public String build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return super.build() + "|" + this.installStartTime + "|" + b.a(this.externalParams, ContainerUtils.FIELD_DELIMITER);
    }

    @Override // com.tencent.tmassistant.st.a
    protected int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 5004;
    }
}
