package com.tencent.commonsdk.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.EmotcationConstants;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes5.dex */
public class HexUtil {
    static IPatchRedirector $redirector_;
    private static final char[] digits;
    public static final byte[] emptybytes;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13166);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
            emptybytes = new byte[0];
        }
    }

    public HexUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String byte2HexStr(byte b16) {
        char[] cArr = digits;
        return new String(new char[]{cArr[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI], cArr[b16 & RegisterType.DOUBLE_HI]});
    }

    public static String bytes2HexStr(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char[] cArr = new char[bArr.length * 2];
            for (int i3 = 0; i3 < bArr.length; i3++) {
                byte b16 = bArr[i3];
                int i16 = i3 * 2;
                char[] cArr2 = digits;
                cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
                cArr[i16 + 0] = cArr2[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        }
        return null;
    }

    public static byte char2Byte(char c16) {
        int i3;
        if (c16 >= '0' && c16 <= '9') {
            i3 = c16 - '0';
        } else {
            char c17 = 'a';
            if (c16 < 'a' || c16 > 'f') {
                c17 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET;
                if (c16 < 'A' || c16 > 'F') {
                    return (byte) 0;
                }
            }
            i3 = (c16 - c17) + 10;
        }
        return (byte) i3;
    }

    public static byte hexStr2Byte(String str) {
        if (str == null || str.length() != 1) {
            return (byte) 0;
        }
        return char2Byte(str.charAt(0));
    }

    public static byte[] hexStr2Bytes(String str) {
        if (str != null && !str.equals("")) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i3 = 0; i3 < length; i3++) {
                int i16 = i3 * 2;
                bArr[i3] = (byte) ((char2Byte(str.charAt(i16)) * RegisterType.UNINIT_REF) + char2Byte(str.charAt(i16 + 1)));
            }
            return bArr;
        }
        return emptybytes;
    }
}
