package com.tencent.mobileqq.mqsafeedit;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes15.dex */
public class StringUtil {
    static IPatchRedirector $redirector_;

    public StringUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String toSemiAngleString(String str) {
        char[] charArray = str.toCharArray();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            char c16 = charArray[i3];
            if (c16 == '\u3000') {
                charArray[i3] = TokenParser.SP;
            } else if (c16 > '\uff00' && c16 < '\uff5f') {
                charArray[i3] = (char) (c16 - '\ufee0');
            }
        }
        return String.valueOf(charArray);
    }
}
