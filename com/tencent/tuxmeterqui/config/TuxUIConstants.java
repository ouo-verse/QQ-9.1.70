package com.tencent.tuxmeterqui.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxUIConstants {
    static IPatchRedirector $redirector_ = null;
    public static final String POP_BTN_TEXT = "btnText";
    public static final String POP_ICON_URL = "iconUrl";
    public static final String POP_SUB_TITLE = "subtitle";
    public static final String POP_TITLE = "title";
    public static final String SENSITIVE_ANSWER_URL = "https://tux.qq.com/cos/tux_ui/static/img/const/SENSITIVE_ANSWER_URL.png";
    public static final String SENSITIVE_INFO_URL = "https://rule.tencent.com/rule/3fd52bde-6555-453b-9ab8-c5f1f3d22c62";
    public static final int TRIGGER_STYLE_DIALOG_FLOAT = 5;
    public static final int TRIGGER_STYLE_DIALOG_FULLSCREEN = 0;
    public static final int TRIGGER_STYLE_EMBEDDED_FLOAT = 4;
    public static final int TRIGGER_STYLE_EMBEDDED_HIPPY_FLOAT = 3;
    public static final int TRIGGER_STYLE_HIPPY = 2;
    public static final int TRIGGER_STYLE_NATIVE = 6;
    public static final int TRIGGER_STYLE_TIPS = 1;

    public TuxUIConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isDialogTrigger(int i3) {
        if (i3 == 0 || i3 == 1 || i3 == 5) {
            return true;
        }
        return false;
    }

    public static boolean isEmbeddedTrigger(int i3) {
        if (i3 != 3 && i3 != 4) {
            return false;
        }
        return true;
    }

    public static boolean isNativeTrigger(int i3) {
        if (i3 == 6) {
            return true;
        }
        return false;
    }

    public static boolean isTriggerStyleTips(int i3) {
        if (i3 == 1) {
            return true;
        }
        return false;
    }
}
