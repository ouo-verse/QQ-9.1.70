package com.tencent.mobileqq.utils.httputils;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes20.dex */
public class URI {
    public static final int NAME = 0;
    public static final short URI_EXT = 7;
    public static final short URI_HTTP = 1;
    public static final short URI_HTTPS = 5;
    public static final short URI_JAVASCRIPT = 4;
    public static final short URI_MAIL = 3;
    public static final short URI_SMS = 6;
    public static final short URI_TEL = 2;
    public static final short URI_UNKNOWN = 0;
    public static final int VALUE = 1;
    private static String homePage = "3g.qq.com";

    public static int convertChar2Utf8(int i3, byte[] bArr, int i16) {
        if (i3 < 128) {
            bArr[i16 + 0] = (byte) i3;
            return 1;
        }
        if (i3 < 2048) {
            bArr[i16 + 0] = (byte) (((i3 >> 6) & 31) | 192);
            bArr[i16 + 1] = (byte) ((i3 & 63) | 128);
            return 2;
        }
        if (i3 < 65536) {
            bArr[i16 + 0] = (byte) (((i3 >> 12) & 15) | 224);
            bArr[i16 + 1] = (byte) (((i3 >> 6) & 63) | 128);
            bArr[i16 + 2] = (byte) ((i3 & 63) | 128);
            return 3;
        }
        if (i3 >= 2097152) {
            return 0;
        }
        bArr[i16 + 0] = (byte) (((i3 >> 18) & 7) | 240);
        bArr[i16 + 1] = (byte) (((i3 >> 12) & 63) | 128);
        bArr[i16 + 2] = (byte) (((i3 >> 6) & 63) | 128);
        bArr[i16 + 3] = (byte) ((i3 & 63) | 128);
        return 4;
    }

    public static String escapePathString(String str, boolean z16) {
        byte[] bytes;
        int i3;
        int i16;
        if (str != null && str.length() > 0) {
            if (z16) {
                bytes = PkgTools.convertUnicode2UTF8Byte(str);
            } else {
                bytes = str.getBytes();
            }
            if (bytes == null) {
                return str;
            }
            byte[] bArr = new byte[(bytes.length * 3) + 1];
            int i17 = 0;
            for (int i18 = 0; i18 < bytes.length; i18++) {
                byte b16 = bytes[i18];
                if (b16 == 32) {
                    int i19 = i17 + 1;
                    bArr[i17] = 37;
                    int i26 = i19 + 1;
                    bArr[i19] = 50;
                    i3 = i26 + 1;
                    bArr[i26] = 48;
                } else if (!isUnreservedWordforPath((char) b16)) {
                    int i27 = i17 + 1;
                    bArr[i17] = 37;
                    int i28 = (bytes[i18] >> 4) & 15;
                    if (i28 < 10) {
                        i16 = i27 + 1;
                        bArr[i27] = (byte) (i28 + 48);
                    } else {
                        i16 = i27 + 1;
                        bArr[i27] = (byte) ((i28 + 65) - 10);
                    }
                    int i29 = bytes[i18] & RegisterType.DOUBLE_HI;
                    if (i29 < 10) {
                        i3 = i16 + 1;
                        bArr[i16] = (byte) (i29 + 48);
                    } else {
                        i3 = i16 + 1;
                        bArr[i16] = (byte) ((i29 + 65) - 10);
                    }
                } else {
                    i3 = i17 + 1;
                    bArr[i17] = bytes[i18];
                }
                i17 = i3;
            }
            return new String(bArr, 0, i17);
        }
        return "";
    }

    public static String escapeString(String str, boolean z16) {
        byte[] bytes;
        int i3;
        int i16;
        if (str != null && str.length() > 0) {
            if (z16) {
                bytes = PkgTools.convertUnicode2UTF8Byte(str);
            } else {
                bytes = str.getBytes();
            }
            byte[] bArr = new byte[(bytes.length * 3) + 1];
            int i17 = 0;
            for (int i18 = 0; i18 < bytes.length; i18++) {
                byte b16 = bytes[i18];
                if ((b16 < 97 || b16 > 122) && ((b16 < 65 || b16 > 90) && ((b16 < 48 || b16 > 57) && b16 != 46 && b16 != 45 && b16 != 42 && b16 != 95))) {
                    if (b16 == 32) {
                        int i19 = i17 + 1;
                        bArr[i17] = 37;
                        int i26 = i19 + 1;
                        bArr[i19] = 50;
                        i16 = i26 + 1;
                        bArr[i26] = 48;
                    } else {
                        int i27 = i17 + 1;
                        bArr[i17] = 37;
                        int i28 = (bytes[i18] >> 4) & 15;
                        if (i28 < 10) {
                            i3 = i27 + 1;
                            bArr[i27] = (byte) (i28 + 48);
                        } else {
                            i3 = i27 + 1;
                            bArr[i27] = (byte) ((i28 + 65) - 10);
                        }
                        int i29 = bytes[i18] & RegisterType.DOUBLE_HI;
                        if (i29 < 10) {
                            i16 = i3 + 1;
                            bArr[i3] = (byte) (i29 + 48);
                        } else {
                            i16 = i3 + 1;
                            bArr[i3] = (byte) ((i29 + 65) - 10);
                        }
                    }
                    i17 = i16;
                } else {
                    bArr[i17] = b16;
                    i17++;
                }
            }
            return new String(bArr, 0, i17);
        }
        return "";
    }

    private static String fixUrl(String str) {
        int length;
        try {
            int indexOf = str.indexOf(63);
            if (str.indexOf("/?") <= 0 && indexOf >= 0) {
                String host = getHost(str);
                int indexOf2 = str.indexOf(host);
                if (indexOf2 < 0) {
                    length = 0;
                } else {
                    length = host.length() + indexOf2;
                }
                if (str.indexOf(47, length) < 0) {
                    StringBuffer stringBuffer = new StringBuffer(str);
                    stringBuffer.insert(indexOf, '/');
                    return stringBuffer.toString();
                }
                return str;
            }
            return str;
        } catch (Exception unused) {
            return str;
        }
    }

    public static String getEscapeString(String str, boolean z16) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf > 0 && indexOf != str.length() - 1) {
            int i3 = indexOf + 1;
            char[] charArray = str.substring(i3, str.length()).toCharArray();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(str.substring(0, i3));
            int i16 = 0;
            boolean z17 = false;
            while (i16 < charArray.length) {
                if (z17) {
                    if (z17) {
                        char c16 = charArray[i16];
                        if (c16 != '&') {
                            if (!isQueryWord(c16)) {
                                if (c16 == '%' && i16 < charArray.length - 2) {
                                    int i17 = i16 + 1;
                                    if (isHexDigit(charArray[i17])) {
                                        int i18 = i16 + 2;
                                        if (isHexDigit(charArray[i18])) {
                                            stringBuffer2.append(charArray[i16]);
                                            stringBuffer2.append(charArray[i17]);
                                            stringBuffer2.append(charArray[i18]);
                                            i16 += 3;
                                        }
                                    }
                                }
                                stringBuffer2.append(escapeString(String.valueOf(charArray[i16]), true));
                            } else {
                                stringBuffer2.append(charArray[i16]);
                            }
                        } else {
                            stringBuffer3.append(stringBuffer);
                            stringBuffer3.append(ContainerUtils.KEY_VALUE_DELIMITER);
                            stringBuffer3.append(stringBuffer2.toString());
                            stringBuffer3.append(ContainerUtils.FIELD_DELIMITER);
                            StringBuffer stringBuffer4 = new StringBuffer();
                            stringBuffer2 = new StringBuffer();
                            stringBuffer = stringBuffer4;
                            z17 = false;
                        }
                    }
                } else {
                    char c17 = charArray[i16];
                    if (c17 != '=') {
                        stringBuffer.append(c17);
                    } else {
                        stringBuffer2 = new StringBuffer();
                        z17 = true;
                    }
                }
                i16++;
            }
            if (z17) {
                stringBuffer3.append(stringBuffer);
                stringBuffer3.append(ContainerUtils.KEY_VALUE_DELIMITER);
                stringBuffer3.append(stringBuffer2.toString());
            } else if (charArray[charArray.length - 1] != '&') {
                stringBuffer3.append(stringBuffer);
            }
            return stringBuffer3.toString();
        }
        return str;
    }

    public static String getHost(String str) {
        int i3;
        int indexOf = str.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        if (indexOf > 0) {
            i3 = indexOf + 3;
        } else {
            i3 = 0;
        }
        int length = str.length();
        for (int i16 = i3; i16 < str.length(); i16++) {
            char charAt = str.charAt(i16);
            if (charAt == ':' || charAt == '/' || charAt == '?') {
                length = i16;
                break;
            }
        }
        return str.substring(i3, length);
    }

    public static short getRequestType(String str) {
        if (str != null && str.length() >= 3) {
            String trim = PkgTools.trim(str);
            if (trim.length() > 5 && PkgTools.equalsIgnoreCase(trim.substring(0, 5), "http:")) {
                return (short) 1;
            }
            if (trim.length() > 6 && PkgTools.equalsIgnoreCase(trim.substring(0, 6), "https:")) {
                return (short) 5;
            }
            if (trim.length() > 5 && PkgTools.equalsIgnoreCase(trim.substring(0, 5), "wtai:")) {
                return (short) 2;
            }
            if (trim.length() > 7 && PkgTools.equalsIgnoreCase(trim.substring(0, 7), "mailto:")) {
                return (short) 3;
            }
            if (trim.length() > 4 && PkgTools.equalsIgnoreCase(trim.substring(0, 4), "sms:")) {
                return (short) 6;
            }
            if (trim.length() > 11 && PkgTools.equalsIgnoreCase(trim.substring(0, 11), a.JAVASCRIPT_PREFIX)) {
                return (short) 6;
            }
            if (trim.length() > 4 && PkgTools.equalsIgnoreCase(trim.substring(0, 4), "ext:")) {
                return (short) 7;
            }
        }
        return (short) 0;
    }

    public static String hotFixUrl(String str) {
        if (str == null) {
            return null;
        }
        String host = getHost(str);
        int indexOf = str.indexOf(host) + host.length();
        String replace = str.replace('\\', '/');
        while (indexOf < replace.length() && replace.charAt(indexOf) != '/') {
            indexOf++;
        }
        int indexOf2 = replace.indexOf(63, indexOf);
        if (indexOf2 < 0) {
            indexOf2 = replace.length();
        }
        try {
            return replace.substring(0, indexOf) + escapePathString(replace.substring(indexOf, indexOf2), false) + replace.substring(indexOf2);
        } catch (Exception unused) {
            return replace;
        }
    }

    public static boolean isHexDigit(char c16) {
        if (!Character.isDigit(c16) && ((c16 < 'A' || c16 > 'F') && (c16 < 'a' || c16 > 'f'))) {
            return false;
        }
        return true;
    }

    public static boolean isIpAddress(String str) {
        String[] split = PkgTools.split(getHost(str), ".");
        if (split.length != 4) {
            return false;
        }
        for (int i3 = 0; i3 < 4; i3++) {
            try {
                int parseInt = Integer.parseInt(split[i3]);
                if (parseInt >= 0 && parseInt <= 255) {
                    if (parseInt == 0 && (i3 == 0 || i3 == 3)) {
                        return false;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return true;
    }

    public static final boolean isQueryWord(char c16) {
        if (!isUnreservedWord(c16) && c16 != '$' && c16 != '\'' && c16 != '(' && c16 != ')' && c16 != '*' && c16 != ',' && c16 != ';' && c16 != '=' && c16 != ':' && c16 != '@' && c16 != '/' && c16 != '?') {
            return false;
        }
        return true;
    }

    public static final boolean isUnreservedWord(char c16) {
        if (!Character.isDigit(c16) && !Character.isLowerCase(c16) && !Character.isUpperCase(c16) && c16 != '-' && c16 != '_' && c16 != '.' && c16 != '!' && c16 != '~' && c16 != '+') {
            return false;
        }
        return true;
    }

    public static final boolean isUnreservedWordforPath(char c16) {
        if (!Character.isDigit(c16) && !Character.isLowerCase(c16) && !Character.isUpperCase(c16) && c16 != '-' && c16 != '_' && c16 != '.' && c16 != '!' && c16 != '~' && c16 != '+' && c16 != '/') {
            return false;
        }
        return true;
    }

    public static void setHomePage(String str) {
        homePage = str;
    }

    public static String unescapeString(String str, boolean z16) {
        int i3;
        int i16;
        int i17;
        int i18;
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[charArray.length * 4];
        int i19 = 0;
        int i26 = 0;
        while (i19 < charArray.length) {
            char c16 = charArray[i19];
            if (c16 == '%' && (i3 = i19 + 2) < charArray.length) {
                int i27 = 0;
                for (int i28 = 1; i28 < 3; i28++) {
                    char c17 = charArray[i19 + i28];
                    if (c17 <= '9' && c17 >= '0') {
                        i16 = i27 * 16;
                        i18 = c17 - '0';
                    } else {
                        if (c17 <= 'F' && c17 >= 'A') {
                            i16 = i27 * 16;
                            i17 = c17 - 'A';
                        } else {
                            if (c17 <= 'f' && c17 >= 'a') {
                                i16 = i27 * 16;
                                i17 = c17 - 'a';
                            }
                        }
                        i18 = i17 + 10;
                    }
                    i27 = i16 + i18;
                }
                bArr[i26] = (byte) i27;
                i26++;
                i19 = i3;
            } else if (z16) {
                i26 += convertChar2Utf8(c16, bArr, i26);
            } else {
                int i29 = i26 + 1;
                bArr[i26] = (byte) (c16 >> '\b');
                i26 = i29 + 1;
                bArr[i29] = (byte) c16;
            }
            i19++;
        }
        if (z16) {
            try {
                return PkgTools.utf8Byte2String(bArr, 0, i26);
            } catch (Exception unused) {
                return null;
            }
        }
        return new String(bArr, 0, i26);
    }
}
