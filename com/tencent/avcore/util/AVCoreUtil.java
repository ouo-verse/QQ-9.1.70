package com.tencent.avcore.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.smtt.sdk.TbsListener;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVCoreUtil {
    static IPatchRedirector $redirector_ = null;
    static final long MAX_VALUE = -1;
    static final String MIN_VALUE = "-9223372036854775808";
    static final String TAG = "AVCoreUtil";
    static int nVersion;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17120);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            nVersion = -1;
        }
    }

    public AVCoreUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String asUnsignedDecimalString(long j3) {
        long j16 = Long.MAX_VALUE & j3;
        if (j3 == j16) {
            return String.valueOf(j16);
        }
        char[] charArray = MIN_VALUE.toCharArray();
        charArray[0] = '0';
        for (int length = charArray.length - 1; length != 0 && j16 != 0; length--) {
            char c16 = (char) (charArray[length] + (j16 % 10));
            charArray[length] = c16;
            if (c16 > '9') {
                charArray[length] = (char) (c16 - '\n');
                int i3 = length - 1;
                charArray[i3] = (char) (charArray[i3] + 1);
            }
            j16 /= 10;
        }
        int i16 = '1' - charArray[0];
        return new String(charArray, i16, charArray.length - i16);
    }

    public static int getQQVersion() {
        if (nVersion == -1) {
            int strVersionToInt = strVersionToInt(AVCoreLog.getVersion());
            nVersion = strVersionToInt;
            if (strVersionToInt == 0) {
                nVersion = TbsListener.ErrorCode.STATIC_TBS_INSTALL_HAS_INSTALLED_EXCEPTION;
            }
        }
        return nVersion;
    }

    public static void printHexStringEx(String str, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            StringBuilder sb5 = new StringBuilder((((bArr.length + 15) / 16) * 73) + 85);
            sb5.append("buf size: " + bArr.length);
            sb5.append("\r\n");
            sb5.append("______00_01_02_03_04_05_06_07_08_09_0A_0B_0C_0D_0E_0F\r\n");
            StringBuilder sb6 = new StringBuilder(32);
            sb6.append(" ");
            int i3 = 0;
            int i16 = 0;
            boolean z16 = false;
            while (true) {
                if (i3 < bArr.length) {
                    if (i16 == 0) {
                        sb5.append(String.format("%04x: ", Integer.valueOf(i3)));
                    }
                    sb5.append(String.format("%02x ", Byte.valueOf(bArr[i3])));
                    byte b16 = bArr[i3];
                    if (b16 >= 32 && b16 <= Byte.MAX_VALUE) {
                        sb6.append(String.format("%c", Byte.valueOf(b16)));
                    } else {
                        sb6.append(".");
                    }
                } else {
                    if (i16 == 0) {
                        break;
                    }
                    sb5.append("   ");
                    sb6.append(" ");
                    z16 = true;
                }
                i16++;
                if (i16 >= 16) {
                    sb5.append(sb6.toString());
                    sb5.append("\r\n");
                    sb6.setLength(1);
                    if (z16) {
                        break;
                    } else {
                        i16 = 0;
                    }
                }
                i3++;
            }
            AVCoreLog.i(str, sb5.toString());
            return;
        }
        AVCoreLog.i(str, "bytes = null or bytes.length = 0");
    }

    public static int strVersionToInt(String str) {
        int i3;
        try {
            String[] split = str.split("\\.");
            if (split.length > 0) {
                i3 = (Integer.valueOf(split[0]).intValue() * 10000) + 0;
            } else {
                i3 = 0;
            }
            if (split.length > 1) {
                i3 += Integer.valueOf(split[1]).intValue() * 100;
            }
            if (split.length > 2) {
                return i3 + Integer.valueOf(split[2]).intValue();
            }
            return i3;
        } catch (Exception e16) {
            if (AVCoreLog.isDevelopLevel()) {
                AVCoreLog.e(TAG, "strVersionToInt, Exception, version[" + str + "]", e16);
            }
            return 0;
        }
    }
}
