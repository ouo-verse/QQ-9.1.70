package com.tencent.upgrade.download;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* loaded from: classes27.dex */
public class DownloadParam implements Serializable {
    static IPatchRedirector $redirector_ = null;
    private static final long serialVersionUID = 7854074956509171666L;
    int downLoadedSize;
    int status;
    int totalSize;

    public DownloadParam(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.totalSize = i3;
        this.downLoadedSize = i16;
        this.status = i17;
    }

    public static DownloadParam getDefaultParam() {
        return new DownloadParam(0, 0, -1);
    }

    public int getDownLoadedSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.downLoadedSize;
    }

    public int getTotalSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.totalSize;
    }
}
