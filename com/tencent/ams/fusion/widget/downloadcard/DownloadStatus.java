package com.tencent.ams.fusion.widget.downloadcard;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DownloadStatus {
    static IPatchRedirector $redirector_ = null;
    public static final int DOWNLOADING = 1;
    public static final int DOWNLOAD_FAILED = 7;
    public static final int DOWNLOAD_FINISH = 3;
    public static final int DOWNLOAD_PAUSE = 2;
    public static final int INSTALLING = 4;
    public static final int INSTALL_FAILED = 6;
    public static final int INSTALL_SUCCESS = 5;
    public static final int NOT_DOWNLOAD = 0;
    public static final int UNKOWN = -1;
    private float mProgress;
    private int mStatus;

    public DownloadStatus(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.mStatus = i3;
        }
    }

    public float getProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }
        int i3 = this.mStatus;
        if (i3 != 1 && i3 != 2) {
            return 100.0f;
        }
        return this.mProgress;
    }

    public int getStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mStatus;
    }

    public void setProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
            return;
        }
        if (f16 < 0.0f) {
            this.mProgress = 0.0f;
        } else if (f16 > 100.0f) {
            this.mProgress = 100.0f;
        } else {
            this.mProgress = f16;
        }
    }

    public void setStatus(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.mStatus = i3;
        }
    }
}
