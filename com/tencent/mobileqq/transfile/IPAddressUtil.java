package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes19.dex */
public class IPAddressUtil {
    static IPatchRedirector $redirector_ = null;
    private static final int INADDR16SZ = 16;
    private static final int INADDR4SZ = 4;
    private static final int INT16SZ = 2;

    public IPAddressUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static byte[] convertFromIPv4MappedAddress(byte[] bArr) {
        if (isIPv4MappedAddress(bArr)) {
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 12, bArr2, 0, 4);
            return bArr2;
        }
        return null;
    }

    public static boolean isIPv4LiteralAddress(String str) {
        if (textToNumericFormatV4(str) != null) {
            return true;
        }
        return false;
    }

    private static boolean isIPv4MappedAddress(byte[] bArr) {
        if (bArr.length < 16 || bArr[0] != 0 || bArr[1] != 0 || bArr[2] != 0 || bArr[3] != 0 || bArr[4] != 0 || bArr[5] != 0 || bArr[6] != 0 || bArr[7] != 0 || bArr[8] != 0 || bArr[9] != 0 || bArr[10] != -1 || bArr[11] != -1) {
            return false;
        }
        return true;
    }

    public static boolean isIPv6LiteralAddress(String str) {
        if (textToNumericFormatV6(str) != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0063, code lost:
    
        if (r9 != 3) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] textToNumericFormatV4(String str) {
        byte[] bArr = new byte[4];
        int length = str.length();
        if (length != 0 && length <= 15) {
            long j3 = 0;
            int i3 = 0;
            for (int i16 = 0; i16 < length; i16++) {
                char charAt = str.charAt(i16);
                if (charAt == '.') {
                    if (j3 < 0 || j3 > 255 || i3 == 3) {
                        return null;
                    }
                    bArr[i3] = (byte) (j3 & 255);
                    j3 = 0;
                    i3++;
                } else {
                    int digit = Character.digit(charAt, 10);
                    if (digit < 0) {
                        return null;
                    }
                    j3 = (j3 * 10) + digit;
                }
            }
            if (j3 >= 0 && j3 < (1 << ((4 - i3) * 8))) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                        }
                        bArr[2] = (byte) ((j3 >> 8) & 255);
                        bArr[3] = (byte) ((j3 >> 0) & 255);
                        return bArr;
                    }
                } else {
                    bArr[0] = (byte) ((j3 >> 24) & 255);
                }
                bArr[1] = (byte) ((j3 >> 16) & 255);
                bArr[2] = (byte) ((j3 >> 8) & 255);
                bArr[3] = (byte) ((j3 >> 0) & 255);
                return bArr;
            }
        }
        return null;
    }

    public static byte[] textToNumericFormatV6(String str) {
        int i3;
        byte[] textToNumericFormatV4;
        if (str.length() < 2) {
            return null;
        }
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[16];
        int length = charArray.length;
        int indexOf = str.indexOf("%");
        if (indexOf == length - 1) {
            return null;
        }
        if (indexOf != -1) {
            length = indexOf;
        }
        if (charArray[0] == ':') {
            if (charArray[1] != ':') {
                return null;
            }
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i16 = 0;
        boolean z16 = false;
        int i17 = 0;
        int i18 = -1;
        int i19 = i3;
        while (true) {
            if (i3 >= length) {
                break;
            }
            int i26 = i3 + 1;
            char c16 = charArray[i3];
            int digit = Character.digit(c16, 16);
            if (digit != -1) {
                i16 = (i16 << 4) | digit;
                if (i16 > 65535) {
                    return null;
                }
                i3 = i26;
                z16 = true;
            } else if (c16 == ':') {
                if (!z16) {
                    if (i18 != -1) {
                        return null;
                    }
                    i3 = i26;
                    i19 = i3;
                    i18 = i17;
                } else {
                    if (i26 == length || i17 + 2 > 16) {
                        return null;
                    }
                    int i27 = i17 + 1;
                    bArr[i17] = (byte) ((i16 >> 8) & 255);
                    i17 = i27 + 1;
                    bArr[i27] = (byte) (i16 & 255);
                    i3 = i26;
                    i19 = i3;
                    i16 = 0;
                    z16 = false;
                }
            } else {
                if (c16 != '.' || i17 + 4 > 16) {
                    return null;
                }
                String substring = str.substring(i19, length);
                int i28 = 0;
                int i29 = 0;
                while (true) {
                    int indexOf2 = substring.indexOf(46, i28);
                    if (indexOf2 == -1) {
                        break;
                    }
                    i29++;
                    i28 = indexOf2 + 1;
                }
                if (i29 != 3 || (textToNumericFormatV4 = textToNumericFormatV4(substring)) == null) {
                    return null;
                }
                int i36 = 0;
                while (i36 < 4) {
                    bArr[i17] = textToNumericFormatV4[i36];
                    i36++;
                    i17++;
                }
                z16 = false;
            }
        }
        if (z16) {
            if (i17 + 2 > 16) {
                return null;
            }
            int i37 = i17 + 1;
            bArr[i17] = (byte) ((i16 >> 8) & 255);
            i17 = i37 + 1;
            bArr[i37] = (byte) (i16 & 255);
        }
        if (i18 != -1) {
            int i38 = i17 - i18;
            if (i17 == 16) {
                return null;
            }
            for (int i39 = 1; i39 <= i38; i39++) {
                int i46 = (i18 + i38) - i39;
                bArr[16 - i39] = bArr[i46];
                bArr[i46] = 0;
            }
            i17 = 16;
        }
        if (i17 != 16) {
            return null;
        }
        byte[] convertFromIPv4MappedAddress = convertFromIPv4MappedAddress(bArr);
        if (convertFromIPv4MappedAddress != null) {
            return convertFromIPv4MappedAddress;
        }
        return bArr;
    }
}
