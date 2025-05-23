package com.tencent.tdf.text;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFKeyboardEnterKey {
    static IPatchRedirector $redirector_ = null;
    public static final int CONTINUE = 8;
    public static final int DONE = 2;
    public static final int EMERGENCY_CALL = 11;
    public static final int GO = 3;
    public static final int JOIN = 9;
    public static final int NEW_LINE = 1;
    public static final int NEXT = 6;
    public static final int PREVIOUS = 7;
    public static final int ROUTE = 10;
    public static final int SEARCH = 4;
    public static final int SEND = 5;
    public static final int UNSPECIFIED = 0;
    public int value;

    public TDFKeyboardEnterKey(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.value = i3;
        }
    }

    public static TDFKeyboardEnterKey fromIMEAction(int i3) {
        if (i3 != 0) {
            switch (i3) {
                case 2:
                    return new TDFKeyboardEnterKey(3);
                case 3:
                    return new TDFKeyboardEnterKey(4);
                case 4:
                    return new TDFKeyboardEnterKey(5);
                case 5:
                    return new TDFKeyboardEnterKey(6);
                case 6:
                    return new TDFKeyboardEnterKey(2);
                case 7:
                    return new TDFKeyboardEnterKey(7);
                default:
                    return new TDFKeyboardEnterKey(0);
            }
        }
        return new TDFKeyboardEnterKey(0);
    }

    public int toIMEAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        switch (this.value) {
            case 2:
                return 6;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 7;
            default:
                return 0;
        }
    }
}
