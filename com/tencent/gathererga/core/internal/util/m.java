package com.tencent.gathererga.core.internal.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes6.dex */
public class m {
    static IPatchRedirector $redirector_;

    private static void a(StringBuffer stringBuffer, byte b16) {
        stringBuffer.append("0123456789ABCDEF".charAt((b16 >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b16 & RegisterType.DOUBLE_HI));
    }

    public static byte[] b(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = i3 * 2;
            bArr[i3] = Integer.valueOf(str.substring(i16, i16 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static String c(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b16 : bArr) {
            a(stringBuffer, b16);
        }
        return stringBuffer.toString();
    }
}
