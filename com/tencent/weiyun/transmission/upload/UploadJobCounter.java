package com.tencent.weiyun.transmission.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploadJobCounter implements Cloneable {
    static IPatchRedirector $redirector_;
    int autoBackup;
    public int compressing;
    public int failed;
    public int running;
    public int suspend;
    public int wait;

    public UploadJobCounter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.wait = 0;
        this.compressing = 0;
        this.running = 0;
        this.suspend = 0;
        this.failed = 0;
        this.autoBackup = 0;
    }

    public synchronized void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.autoBackup = 0;
        this.failed = 0;
        this.suspend = 0;
        this.running = 0;
        this.compressing = 0;
        this.wait = 0;
    }

    public synchronized UploadJobCounter update(UploadJobContext uploadJobContext, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (UploadJobCounter) iPatchRedirector.redirect((short) 4, this, uploadJobContext, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (i3 != i16) {
            if (uploadJobContext.file().autoBackupFlag) {
                if (i16 == 1) {
                    this.autoBackup++;
                } else if (i16 == 6 || i16 == 5) {
                    this.autoBackup--;
                }
            } else {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 == 6) {
                                    this.failed--;
                                }
                            } else {
                                this.suspend--;
                            }
                        } else {
                            this.running--;
                        }
                    } else {
                        this.compressing--;
                    }
                } else {
                    this.wait--;
                }
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 3) {
                            if (i16 != 4) {
                                if (i16 == 6) {
                                    this.failed++;
                                }
                            } else {
                                this.suspend++;
                            }
                        } else {
                            this.running++;
                        }
                    } else {
                        this.compressing++;
                    }
                } else {
                    this.wait++;
                }
            }
        }
        return m293clone();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public synchronized UploadJobCounter m293clone() {
        UploadJobCounter uploadJobCounter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (UploadJobCounter) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            uploadJobCounter = (UploadJobCounter) super.clone();
        } catch (CloneNotSupportedException unused) {
            uploadJobCounter = null;
        }
        return uploadJobCounter;
    }
}
