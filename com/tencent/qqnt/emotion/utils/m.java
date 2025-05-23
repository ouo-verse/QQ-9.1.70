package com.tencent.qqnt.emotion.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes24.dex */
public class m {
    static IPatchRedirector $redirector_;

    public static String a(byte[] bArr) {
        int i3;
        int i16;
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b16 : bArr) {
            int i17 = (b16 & 240) >>> 4;
            int i18 = b16 & RegisterType.DOUBLE_HI;
            if (i17 > 9) {
                i3 = (i17 - 10) + 65;
            } else {
                i3 = i17 + 48;
            }
            char c16 = (char) i3;
            if (i18 > 9) {
                i16 = (i18 - 10) + 65;
            } else {
                i16 = i18 + 48;
            }
            stringBuffer.append(c16);
            stringBuffer.append((char) i16);
        }
        return stringBuffer.toString();
    }
}
