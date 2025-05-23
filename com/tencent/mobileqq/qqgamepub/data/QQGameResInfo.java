package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGameResInfo implements Serializable {
    static IPatchRedirector $redirector_ = null;
    private static final long serialVersionUID = 1;
    public long doneTime;
    public String fileMd5;
    public String filePath;
    public String folderPath;
    public String resId;
    public int type;
    public String url;

    public QQGameResInfo() {
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
        return "QQGameResInfo{url='" + this.url + "', filePath='" + this.filePath + "', fileMd5='" + this.fileMd5 + "', doneTime=" + this.doneTime + ", type=" + this.type + ", folderPath='" + this.folderPath + "', resId='" + this.resId + "'}";
    }
}
