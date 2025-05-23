package com.tencent.tdf.text;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFKeyboardCharacterRecognizer {
    static IPatchRedirector $redirector_;
    private int combiningAccent;

    public TDFKeyboardCharacterRecognizer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.combiningAccent = 0;
        }
    }

    public int recognizer(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) keyEvent)).intValue();
        }
        int unicodeChar = keyEvent.getUnicodeChar();
        if ((Integer.MIN_VALUE & unicodeChar) != 0) {
            this.combiningAccent = unicodeChar & Integer.MAX_VALUE;
            return 0;
        }
        int i3 = this.combiningAccent;
        if (i3 != 0) {
            int deadChar = KeyCharacterMap.getDeadChar(i3, unicodeChar);
            this.combiningAccent = 0;
            return deadChar;
        }
        return unicodeChar;
    }
}
