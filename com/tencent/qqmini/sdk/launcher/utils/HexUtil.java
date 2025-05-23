package com.tencent.qqmini.sdk.launcher.utils;

import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes23.dex */
public class HexUtil {
    private static final String TAG = "HexUtil";
    public static final byte[] EMPTYBYTES = new byte[0];
    private static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    public static String byte2HexStr(byte b16) {
        char[] cArr = digits;
        return new String(new char[]{cArr[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI], cArr[b16 & RegisterType.DOUBLE_HI]});
    }

    public static String bytes2HexStr(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char[] cArr = new char[bArr.length * 2];
            for (int i3 = 0; i3 < bArr.length; i3++) {
                try {
                    byte b16 = bArr[i3];
                    int i16 = i3 * 2;
                    char[] cArr2 = digits;
                    cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
                    cArr[i16 + 0] = cArr2[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
                } catch (Exception e16) {
                    QMLog.d(TAG, " === bytes2HexStr error === " + e16.toString());
                }
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
                try {
                    bArr[i3] = (byte) ((char2Byte(str.charAt(i16)) * RegisterType.UNINIT_REF) + char2Byte(str.charAt(i16 + 1)));
                } catch (Exception e16) {
                    QMLog.d(TAG, " === hexStr2Bytes error === " + e16.toString());
                    return EMPTYBYTES;
                }
            }
            return bArr;
        }
        return EMPTYBYTES;
    }

    public static String hexString2String(String str) {
        return new String(hexStr2Bytes(str));
    }

    public static void printHexString(String str, byte[] bArr) {
        printHexStringEx(str, bArr);
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
            QMLog.i(str, sb5.toString());
            return;
        }
        QMLog.i(str, "bytes = null or bytes.length = 0");
    }

    public static String string2HexString(String str) {
        return bytes2HexStr(str.getBytes());
    }
}
