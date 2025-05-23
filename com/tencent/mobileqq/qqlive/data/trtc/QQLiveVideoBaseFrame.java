package com.tencent.mobileqq.qqlive.data.trtc;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class QQLiveVideoBaseFrame {
    static IPatchRedirector $redirector_;

    public QQLiveVideoBaseFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public byte[] getBitmapArray() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return null;
    }

    public abstract int getHeight();

    public abstract int getTextureId();

    public abstract int getVideoFrameType();

    public abstract int getWidth();

    public abstract void setTextureId(int i3);
}
