package com.tencent.tmdownloader.notify;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class DownloadTaskInfo {
    static IPatchRedirector $redirector_;
    public String pkgName;
    public String source;
    public String stackInfo;
    public String url;
    public int versionCode;

    public DownloadTaskInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        String replace;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.versionCode);
        sb5.append("||");
        sb5.append(this.source);
        sb5.append("||");
        sb5.append(this.pkgName);
        sb5.append("||");
        sb5.append(this.url);
        sb5.append("||");
        String str = this.stackInfo;
        if (str == null) {
            replace = "";
        } else {
            replace = str.replace("\r", " ").replace("\n", " ");
        }
        sb5.append(replace);
        return sb5.toString();
    }
}
