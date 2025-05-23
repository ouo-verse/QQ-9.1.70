package com.tencent.replacemonitor.replace.st;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmassistant.st.a;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class ReplaceBaseLog extends a {
    static IPatchRedirector $redirector_;
    public String downloadUrl;
    public Map<String, String> externalParams;
    public boolean isTDownloadApp;
    public String packageName;
    public String traceId;
    public int versionCode;
    public long yybApkId;
    public long yybAppId;

    public ReplaceBaseLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.tmassistant.st.a
    public String build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.packageName + "|" + this.versionCode + "|" + filterSplitStr(this.downloadUrl) + "|" + this.yybApkId + "|" + this.yybAppId + "|" + this.traceId + "|" + this.isTDownloadApp;
    }
}
