package com.tencent.qzonehub.api.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes25.dex */
public class QZoneUploadPhotoPageFinishEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;
    private final boolean mClickUpload;
    private final int mComeFrom;

    public QZoneUploadPhotoPageFinishEvent(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else {
            this.mClickUpload = z16;
            this.mComeFrom = i3;
        }
    }

    public int getComeFrom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mComeFrom;
    }

    public boolean isClickUpload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.mClickUpload;
    }
}
