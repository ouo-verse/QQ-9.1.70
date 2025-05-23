package com.tencent.maxvideo.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ControlFlagEnum {
    static IPatchRedirector $redirector_;
    public static final ControlFlagEnum NONE;
    public static final ControlFlagEnum OPEN_FILE_AND_WRITE_FRAME_DATA;
    public static final ControlFlagEnum WRITE_FRAME_DATA;
    public static final ControlFlagEnum WRITE_FRAME_DATA_AND_CLOSE_FILE;
    int mValue;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9899);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        NONE = new ControlFlagEnum(0);
        OPEN_FILE_AND_WRITE_FRAME_DATA = new ControlFlagEnum(1);
        WRITE_FRAME_DATA = new ControlFlagEnum(2);
        WRITE_FRAME_DATA_AND_CLOSE_FILE = new ControlFlagEnum(3);
    }

    ControlFlagEnum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.mValue = i3;
        }
    }

    public int getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mValue;
    }
}
