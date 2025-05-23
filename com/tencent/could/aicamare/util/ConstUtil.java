package com.tencent.could.aicamare.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ConstUtil {
    static IPatchRedirector $redirector_ = null;
    public static final int ERROR_CAMERA_ID_NUMBER = -808;
    public static final int ERROR_DO_NOT_NEED_TIPS = 6;
    public static final int ERROR_EVENT_AUTO_FOCUS = 4;
    public static final int ERROR_EVENT_CLOSE_CAMERA = 2;
    public static final int ERROR_EVENT_OPEN_CAMERA = 1;
    public static final int ERROR_EVENT_SET_DISPLAY_ORIENTATION = 7;
    public static final int ERROR_EVENT_START_PREVIEW = 3;
    public static final int ERROR_EVENT_ZOOM_ERROR = 5;

    public ConstUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
