package com.tencent.mobileqq.utils.httputils;

import android.net.ConnectivityManager;
import android.net.Uri;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.apache.httpcore.message.TokenParser;
import org.jf.dexlib2.analysis.RegisterType;

/* loaded from: classes20.dex */
public class PkgTools {
    public static final char EMO_HEAD_CODE = 20;
    public static final int PREREAD_LEVEL_NEXTPAGE_HIGH = 4;
    public static final int PREREAD_LEVEL_NEXTPAGE_LOW = 3;
    public static final int PREREAD_LEVEL_NEXTSECTION_HIGH = 2;
    public static final int PREREAD_LEVEL_NEXTSECTION_LOW = 1;
    public static final int PREREAD_LEVEL_NONE = 0;
    private static ConnectivityManager conMgr;
    private static Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
    public static String APN_TYPE_CTNET = "ctnet";
    public static String APN_TYPE_CTWAP = "ctwap";
    public static String APN_TYPE_CMNET = "cmnet";
    public static String APN_TYPE_CMWAP = "cmwap";
    public static String APN_TYPE_UNINET = "uninet";
    public static String APN_TYPE_UNIWAP = "uniwap";
    public static String APN_TYPE_3GNET = "3gnet";
    public static String APN_TYPE_3GWAP = "3gwap";

    @Deprecated
    /* loaded from: classes20.dex */
    public static class XOnlineHost {
        public String host;
        public String path;

        public XOnlineHost(String str, String str2) {
            this.host = str;
            this.path = str2;
        }
    }

    PkgTools() {
    }

    public static Long ascByteToLong(byte[] bArr, int i3, int i16) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i17 = 0; i17 < i16; i17++) {
            stringBuffer.append((char) bArr[i3 + i17]);
        }
        return Long.valueOf(Long.parseLong(stringBuffer.toString().trim()));
    }

    public static long ascStringToInt(String str, String str2) {
        str.replace(" ", "");
        return Integer.valueOf(str).intValue();
    }

    public static long ascStringToLong(String str, String str2) {
        str.replace(" ", "");
        return Long.valueOf(str).longValue();
    }

    public static String byte2Unicode(byte[] bArr, int i3, int i16) {
        if (i3 + i16 <= bArr.length && i16 % 2 == 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i17 = i3; i17 < (i16 / 2) + i3; i17++) {
                int i18 = ((i17 - i3) * 2) + i3;
                stringBuffer.append((char) ((bArr[i18 + 1] & 255) | (bArr[i18] << 8)));
            }
            return stringBuffer.toString();
        }
        throw new IllegalArgumentException();
    }

    public static String[] byteArray2StringArray(byte[] bArr) {
        String str;
        ArrayList arrayList = new ArrayList();
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        while (dataInputStream.available() > 0) {
            try {
                int readInt = dataInputStream.readInt();
                if (readInt > dataInputStream.available()) {
                    return null;
                }
                byte[] bArr2 = new byte[readInt];
                dataInputStream.read(bArr2);
                try {
                    str = new String(bArr2, "utf-8");
                } catch (UnsupportedEncodingException unused) {
                    str = new String(bArr2);
                }
                arrayList.add(str);
            } catch (IOException unused2) {
                return null;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static int bytesToInt(byte[] bArr, int i3) {
        return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
    }

    public static byte[] convertUnicode2UTF8Byte(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        byte[] bArr = new byte[length << 2];
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            char charAt = str.charAt(i16);
            if (charAt < '\u0080') {
                bArr[i3] = (byte) charAt;
                i3++;
            } else if (charAt < '\u0800') {
                int i17 = i3 + 1;
                bArr[i3] = (byte) (((charAt >> 6) & 31) | 192);
                i3 = i17 + 1;
                bArr[i17] = (byte) ((charAt & '?') | 128);
            } else if (charAt < 0) {
                int i18 = i3 + 1;
                bArr[i3] = (byte) (((charAt >> '\f') & 15) | 224);
                int i19 = i18 + 1;
                bArr[i18] = (byte) (((charAt >> 6) & 63) | 128);
                bArr[i19] = (byte) ((charAt & '?') | 128);
                i3 = i19 + 1;
            } else if (charAt < 0) {
                int i26 = i3 + 1;
                bArr[i3] = (byte) (((charAt >> 18) & 7) | 240);
                int i27 = i26 + 1;
                bArr[i26] = (byte) (((charAt >> '\f') & 63) | 128);
                int i28 = i27 + 1;
                bArr[i27] = (byte) (((charAt >> 6) & 63) | 128);
                i3 = i28 + 1;
                bArr[i28] = (byte) ((charAt & '?') | 128);
            }
        }
        byte[] bArr2 = new byte[i3];
        for (int i29 = 0; i29 < i3; i29++) {
            bArr2[i29] = bArr[i29];
        }
        return bArr2;
    }

    public static void copyData(byte[] bArr, int i3, byte[] bArr2, int i16) {
        copyData(bArr, i3, bArr2, 0, i16);
    }

    public static void dWord2Byte(byte[] bArr, int i3, long j3) {
        bArr[i3] = (byte) (j3 >> 24);
        bArr[i3 + 1] = (byte) (j3 >> 16);
        bArr[i3 + 2] = (byte) (j3 >> 8);
        bArr[i3 + 3] = (byte) j3;
    }

    public static void dWordTo2Bytes(byte[] bArr, int i3, int i16) {
        bArr[i3] = (byte) (i16 >> 8);
        bArr[i3 + 1] = (byte) i16;
    }

    public static String dealString(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes("utf-8");
            for (int i3 = 0; i3 < bytes.length; i3++) {
                if (bytes[i3] == 13) {
                    bytes[i3] = 32;
                }
            }
            return new String(bytes, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String decodeCgi(String str) {
        char[] charArray;
        int length;
        char c16;
        StringBuffer stringBuffer = new StringBuffer();
        if (str == null || (length = (charArray = str.toCharArray()).length) == 0) {
            return "";
        }
        int i3 = 0;
        while (i3 < length) {
            char c17 = charArray[i3];
            if (c17 == '%') {
                try {
                    c16 = (char) Integer.parseInt(String.valueOf(charArray, i3 + 1, 2), 16);
                } catch (Exception unused) {
                    c16 = TokenParser.SP;
                }
                stringBuffer.append(c16);
                i3 += 3;
            } else {
                stringBuffer.append(c17);
                i3++;
            }
        }
        return stringBuffer.toString();
    }

    public static String deleteReturn(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        int i3 = 0;
        while (i3 < stringBuffer.length() && stringBuffer.length() > 0) {
            if (stringBuffer.charAt(i3) < ' ') {
                stringBuffer.deleteCharAt(i3);
            } else {
                i3++;
            }
        }
        return stringBuffer.toString();
    }

    public static String encodeCgi(String str) {
        char[] charArray;
        int length;
        StringBuffer stringBuffer = new StringBuffer();
        if (str == null || (length = (charArray = str.toCharArray()).length) == 0) {
            return "";
        }
        for (int i3 = 0; i3 < length; i3++) {
            char c16 = charArray[i3];
            if (c16 != ' ' && c16 != '&' && c16 != ',' && c16 != '\r' && c16 != '\t' && c16 != '\n' && c16 != '%' && c16 != '=') {
                if (c16 == 20) {
                    stringBuffer.append(toUrlCode(c16));
                } else if (i3 > 0 && charArray[i3 - 1] == 20) {
                    stringBuffer.append(toUrlCode(c16));
                } else {
                    stringBuffer.append(c16);
                }
            } else {
                stringBuffer.append(toUrlCode(c16));
            }
        }
        return stringBuffer.toString();
    }

    public static boolean equals(byte[] bArr, byte[] bArr2) {
        if (bArr == null && bArr2 == null) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        return memcmp(bArr, bArr2, bArr.length);
    }

    public static boolean equalsIgnoreCase(String str, String str2) {
        char upperCase;
        char upperCase2;
        if (str != null && str2 != null && str.length() == str2.length()) {
            int length = str.length();
            char[] charArray = str.toCharArray();
            char[] charArray2 = str2.toCharArray();
            long j3 = 0;
            long j16 = length;
            if (j3 <= str.length() - j16 && j3 <= str2.length() - j16) {
                int i3 = 0;
                int i16 = 0;
                while (true) {
                    int i17 = length - 1;
                    if (length <= 0) {
                        return true;
                    }
                    int i18 = i3 + 1;
                    char c16 = charArray[i3];
                    int i19 = i16 + 1;
                    char c17 = charArray2[i16];
                    if (c16 != c17 && (upperCase = Character.toUpperCase(c16)) != (upperCase2 = Character.toUpperCase(c17)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                        return false;
                    }
                    i3 = i18;
                    length = i17;
                    i16 = i19;
                }
            }
        }
        return false;
    }

    public static String getApnType(String str) {
        String str2;
        if (str == null) {
            return "nomatch";
        }
        try {
            if (str.startsWith(APN_TYPE_CTNET)) {
                str2 = APN_TYPE_CTNET;
            } else if (str.startsWith(APN_TYPE_CTWAP)) {
                str2 = APN_TYPE_CTWAP;
            } else if (str.startsWith(APN_TYPE_CMNET)) {
                str2 = APN_TYPE_CMNET;
            } else if (str.startsWith(APN_TYPE_CMWAP)) {
                str2 = APN_TYPE_CMWAP;
            } else if (str.startsWith(APN_TYPE_UNINET)) {
                str2 = APN_TYPE_UNINET;
            } else if (str.startsWith(APN_TYPE_UNIWAP)) {
                str2 = APN_TYPE_UNIWAP;
            } else if (str.startsWith(APN_TYPE_3GNET)) {
                str2 = APN_TYPE_3GNET;
            } else {
                if (!str.startsWith(APN_TYPE_3GWAP)) {
                    return "nomatch";
                }
                str2 = APN_TYPE_3GWAP;
            }
            return str2;
        } catch (Exception unused) {
            return "nomatch";
        }
    }

    public static void getBytesData(byte[] bArr, int i3, byte[] bArr2, int i16) {
        copyData(bArr2, 0, bArr, i3, i16);
    }

    public static HttpURLConnection getConnectionWithDefaultProxy(String str, String str2, int i3) throws MalformedURLException, IOException {
        return (HttpURLConnection) new URL(str).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str2, i3)));
    }

    @Deprecated
    public static HttpURLConnection getConnectionWithXOnlineHost(String str, String str2, int i3) throws MalformedURLException, IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) getURLWithXOnlineHost(str, str2, i3).openConnection();
        httpURLConnection.setRequestProperty("X-Online-Host", getHostWithXOnlineHost(str).host);
        return httpURLConnection;
    }

    public static short getHShortData(byte[] bArr, int i3) {
        return (short) (((bArr[i3 + 1] & 255) << 8) + ((bArr[i3] & 255) << 0));
    }

    @Deprecated
    public static XOnlineHost getHostWithXOnlineHost(String str) {
        String substring;
        String str2;
        int indexOf = str.indexOf(47, 7);
        if (indexOf < 0) {
            str2 = str.substring(7);
            substring = "";
        } else {
            String substring2 = str.substring(7, indexOf);
            substring = str.substring(indexOf);
            str2 = substring2;
        }
        return new XOnlineHost(str2, substring);
    }

    public static String getLastParaVal(String str, String str2) {
        int indexOf;
        if (str == null || str2 == null) {
            return "";
        }
        String str3 = str + ContainerUtils.KEY_VALUE_DELIMITER;
        int length = str3.length();
        if (str2.length() == 0 || length == 0 || (indexOf = str2.indexOf(str3)) == -1) {
            return "";
        }
        int i3 = indexOf;
        while (indexOf != -1) {
            int i16 = indexOf;
            indexOf = str2.indexOf(str3, indexOf + 1);
            i3 = i16;
        }
        int indexOf2 = str2.indexOf(38, i3);
        if (indexOf2 == -1) {
            return str2.substring(i3 + length);
        }
        return str2.substring(i3 + length, indexOf2);
    }

    public static long getLittleIndianData(byte[] bArr, int i3) {
        return ((bArr[i3] & 255) << 0) + ((bArr[i3 + 1] & 255) << 8) + ((bArr[i3 + 2] & 255) << 16) + ((bArr[i3 + 3] & 255) << 24);
    }

    public static long getLongData(byte[] bArr, int i3) {
        if (bArr == null) {
            return 0L;
        }
        return ((bArr[i3] & 255) << 24) + ((bArr[i3 + 1] & 255) << 16) + ((bArr[i3 + 2] & 255) << 8) + ((bArr[i3 + 3] & 255) << 0);
    }

    public static long getLongLongData(byte[] bArr, int i3) {
        return ((bArr[i3 + 4] & 255) << 56) + ((bArr[i3 + 5] & 255) << 48) + ((bArr[i3 + 6] & 255) << 40) + ((bArr[i3 + 7] & 255) << 32) + ((bArr[i3] & 255) << 24) + ((bArr[i3 + 1] & 255) << 16) + ((bArr[i3 + 2] & 255) << 8) + (bArr[i3 + 3] & 255);
    }

    public static int getMultiPara(String[] strArr, String str) {
        if (strArr == null || str == null || str.length() >= 2560) {
            return -1;
        }
        int indexOf = str.indexOf(44);
        if (indexOf == -1) {
            strArr[0] = str;
            return 1;
        }
        strArr[0] = str.substring(0, indexOf);
        if (1 == strArr.length) {
            return 1;
        }
        String substring = str.substring(indexOf + 1);
        int i3 = 1;
        while (true) {
            int indexOf2 = substring.indexOf(44);
            if (indexOf2 != -1) {
                strArr[i3] = substring.substring(0, indexOf2);
                i3++;
                if (i3 == strArr.length) {
                    return i3;
                }
                substring = substring.substring(indexOf2 + 1);
            } else {
                strArr[i3] = substring;
                return i3 + 1;
            }
        }
    }

    public static String getParaVal(String str, String str2) {
        int i3;
        if (str != null && str2 != null && str.length() != 0 && str2.length() != 0) {
            int length = str.length();
            int indexOf = str2.indexOf(str + ContainerUtils.KEY_VALUE_DELIMITER);
            int indexOf2 = str2.indexOf(ContainerUtils.FIELD_DELIMITER + str + ContainerUtils.KEY_VALUE_DELIMITER);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            boolean startsWith = str2.startsWith(sb5.toString());
            if (indexOf != -1) {
                i3 = indexOf + length + 1;
            } else if (indexOf2 != -1) {
                i3 = indexOf2 + 1 + length + 1;
            } else if (startsWith) {
                i3 = length + 1;
            }
            int indexOf3 = str2.indexOf(38, i3);
            if (indexOf3 == -1) {
                return str2.substring(i3);
            }
            return str2.substring(i3, indexOf3);
        }
        return "";
    }

    public static Vector getParas(String str) {
        Vector vector = new Vector();
        if (str == null) {
            return vector;
        }
        int indexOf = str.indexOf(38);
        if (indexOf == -1) {
            vector.addElement(str);
            return vector;
        }
        vector.addElement(str.substring(0, indexOf));
        String substring = str.substring(indexOf + 1);
        while (true) {
            int indexOf2 = substring.indexOf(38);
            if (indexOf2 != -1) {
                vector.addElement(substring.substring(0, indexOf2));
                substring = substring.substring(indexOf2 + 1);
            } else {
                vector.addElement(substring);
                return vector;
            }
        }
    }

    public static short getShortData(byte[] bArr, int i3) {
        if (bArr == null) {
            return (short) 0;
        }
        return (short) (((bArr[i3] & 255) << 8) + ((bArr[i3 + 1] & 255) << 0));
    }

    @Deprecated
    public static URL getURLWithXOnlineHost(String str, String str2, int i3) throws IOException {
        String str3 = getHostWithXOnlineHost(str).path;
        if (i3 != 80) {
            return new URL("http://" + str2 + ":" + i3 + str3);
        }
        return new URL("http://" + str2 + str3);
    }

    public static String getUTFString(byte[] bArr, int i3, int i16) {
        return utf8Byte2String(bArr, i3, i16);
    }

    public static int getUnsignedByte(byte b16) {
        return b16 & 255;
    }

    public static byte[] hexToBytes(String str) {
        int i3;
        int i16;
        if (str == null) {
            return null;
        }
        int length = str.length();
        String upperCase = str.toUpperCase();
        if (length % 2 != 0 || length == 0) {
            return null;
        }
        int i17 = length / 2;
        byte[] bArr = new byte[i17];
        for (int i18 = 0; i18 < i17; i18++) {
            int i19 = i18 * 2;
            char charAt = upperCase.charAt(i19);
            char charAt2 = upperCase.charAt(i19 + 1);
            if (charAt < '0' || charAt > '9') {
                if (charAt >= 'A' && charAt <= 'F') {
                    i3 = (charAt - 'A') + 10;
                }
                return null;
            }
            i3 = charAt - '0';
            int i26 = (i3 << 4) + 0;
            if (charAt2 < '0' || charAt2 > '9') {
                if (charAt2 >= 'A' && charAt2 <= 'F') {
                    i16 = (charAt2 - 'A') + 10;
                }
                return null;
            }
            i16 = charAt2 - '0';
            bArr[i18] = (byte) (i26 + i16);
        }
        return bArr;
    }

    public static String int2IP(long j3) {
        StringBuffer stringBuffer = new StringBuffer(16);
        for (int i3 = 3; i3 >= 0; i3--) {
            stringBuffer = stringBuffer.insert(0, 255 & (j3 % 256));
            j3 /= 256;
            if (i3 != 0) {
                stringBuffer.insert(0, '.');
            }
        }
        return stringBuffer.toString();
    }

    public static String int2IPNet(long j3) {
        StringBuffer stringBuffer = new StringBuffer(16);
        for (int i3 = 3; i3 >= 0; i3--) {
            stringBuffer.append(255 & (j3 % 256));
            j3 /= 256;
            if (i3 != 0) {
                stringBuffer.append('.');
            }
        }
        return stringBuffer.toString();
    }

    public static void intToAscString(int i3, byte[] bArr, int i16, int i17, String str) {
        longToAscString(i3, bArr, i16, i17, str);
    }

    public static byte[] intToBytes(int i3) {
        return new byte[]{(byte) (i3 & 255), (byte) ((i3 >> 8) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 24) & 255)};
    }

    public static byte[] intToBytes2(int i3) {
        return new byte[]{(byte) ((i3 >> 24) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 8) & 255), (byte) (i3 & 255)};
    }

    public static byte[] intToHL(int i3) {
        return new byte[]{(byte) ((i3 >> 24) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 8) & 255), (byte) (i3 & 255)};
    }

    public static int ipToInt(String str) {
        byte[] bArr = new byte[4];
        try {
            String[] split = str.split("\\.");
            bArr[0] = (byte) (Integer.parseInt(split[0]) & 255);
            bArr[1] = (byte) (Integer.parseInt(split[1]) & 255);
            bArr[2] = (byte) (Integer.parseInt(split[2]) & 255);
            byte parseInt = (byte) (Integer.parseInt(split[3]) & 255);
            bArr[3] = parseInt;
            return (parseInt & 255) | ((bArr[2] << 8) & 65280) | ((bArr[1] << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT) | ((bArr[0] << 24) & (-16777216));
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    public static int isNext(String str) {
        int i3;
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i16 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            if (charArray[i17] == '\u4e0b' && (i3 = i17 + 2) <= length) {
                char c16 = charArray[i17 + 1];
                if (c16 != '\u4e00') {
                    if (c16 != '\u7ae0') {
                        if (c16 == '\u9875') {
                            i16 = 3;
                        }
                    } else {
                        i16 = 1;
                    }
                } else if (i17 + 3 <= length) {
                    char c17 = charArray[i3];
                    if (c17 != '\u7ae0') {
                        if (c17 == '\u9875') {
                            i16 = 4;
                        }
                    } else {
                        i16 = 2;
                    }
                }
            }
            if (i16 > 0) {
                break;
            }
        }
        return i16;
    }

    public static void littleIndianDw2Byte(byte[] bArr, int i3, long j3) {
        bArr[i3] = (byte) j3;
        bArr[i3 + 1] = (byte) (j3 >> 8);
        bArr[i3 + 2] = (byte) (j3 >> 16);
        bArr[i3 + 3] = (byte) (j3 >> 24);
    }

    public static void longToAscString(long j3, byte[] bArr, int i3, int i16, String str) {
        try {
            byte[] bArr2 = new byte[i16];
            byte[] bytes = (j3 + "").getBytes(str);
            for (int i17 = 0; i17 < i16; i17++) {
                bArr2[i17] = " ".getBytes(str)[0];
            }
            copyData(bArr2, i16 - bytes.length, bytes, bytes.length);
            copyData(bArr, i3, bArr2, i16);
        } catch (Exception unused) {
        }
    }

    public static boolean memcmp(byte[] bArr, byte[] bArr2, int i3) {
        if (bArr == null && bArr2 == null) {
            return true;
        }
        if (bArr == null || bArr2 == null) {
            return false;
        }
        if (bArr == bArr2) {
            return true;
        }
        for (int i16 = 0; i16 < bArr.length && i16 < bArr2.length && i16 < i3; i16++) {
            if (bArr[i16] != bArr2[i16]) {
                return false;
            }
        }
        return true;
    }

    public static String readUCS2(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int readShort = dataInputStream.readShort();
        byte[] bArr = new byte[readShort];
        dataInputStream.readFully(bArr);
        return byte2Unicode(bArr, 0, readShort);
    }

    public static String replace(String str, String str2, String str3) {
        int length = str2.length();
        int length2 = str3.length() - length;
        StringBuffer stringBuffer = new StringBuffer(str);
        int i3 = 0;
        int i16 = 0;
        while (true) {
            int indexOf = str.indexOf(str2, i3);
            if (indexOf != -1) {
                int i17 = indexOf + length;
                int i18 = indexOf + i16;
                stringBuffer.delete(i18, i17 + i16);
                stringBuffer.insert(i18, str3);
                i16 += length2;
                i3 = i17;
            } else {
                return stringBuffer.toString();
            }
        }
    }

    public static String short2Port(byte[] bArr) {
        getShortData(bArr, 0);
        if (bArr == null || bArr.length != 2) {
            return "";
        }
        byte[] bArr2 = new byte[4];
        copyData(bArr2, 2, bArr, 2);
        return getLongData(bArr2, 0) + "";
    }

    public static byte[] shortToHL(short s16) {
        return new byte[]{(byte) ((s16 >> 8) & 255), (byte) (s16 & 255)};
    }

    public static String[] split(String str, String str2) {
        Vector vector = new Vector();
        int i3 = 0;
        while (true) {
            int indexOf = str.indexOf(str2, i3);
            if (indexOf == -1) {
                break;
            }
            vector.addElement(str.substring(i3, indexOf));
            i3 = str2.length() + indexOf;
        }
        vector.addElement(str.substring(i3, str.length()));
        int size = vector.size();
        String[] strArr = new String[size];
        for (int i16 = 0; i16 < size; i16++) {
            strArr[i16] = (String) vector.elementAt(i16);
        }
        return strArr;
    }

    public static byte[] stringArray2byteArray(String[] strArr) {
        byte[] bytes;
        if (strArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (int i3 = 0; i3 < strArr.length; i3++) {
            try {
                try {
                    bytes = strArr[i3].getBytes("utf-8");
                } catch (UnsupportedEncodingException unused) {
                    bytes = strArr[i3].getBytes();
                }
                dataOutputStream.writeInt(bytes.length);
                dataOutputStream.write(bytes);
            } catch (IOException unused2) {
                return null;
            }
        }
        dataOutputStream.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        dataOutputStream.close();
        byteArrayOutputStream.close();
        return byteArray;
    }

    public static String toHexStr(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b16 : bArr) {
            int i3 = (b16 & 240) >>> 4;
            int i16 = b16 & RegisterType.DOUBLE_HI;
            char c16 = (char) (i3 > 9 ? (i3 - 10) + 65 : i3 + 48);
            int i17 = i16 > 9 ? (i16 - 10) + 65 : i16 + 48;
            stringBuffer.append(c16);
            stringBuffer.append((char) i17);
        }
        return stringBuffer.toString();
    }

    public static String toUrlCode(char c16) {
        String hexString = Integer.toHexString(c16);
        if (hexString.length() == 1) {
            return "%0" + hexString;
        }
        return "%" + hexString;
    }

    public static String trim(String str) {
        int length = str.length();
        char[] charArray = str.toCharArray();
        int i3 = 0;
        while (i3 < length && charArray[0 + i3] <= ' ') {
            i3++;
        }
        while (i3 < length && charArray[(0 + length) - 1] <= ' ') {
            length--;
        }
        if (i3 > 0 || length < str.length()) {
            return str.substring(i3, length);
        }
        return str;
    }

    public static byte[] u2b(String str) {
        int length = str.length();
        byte[] bArr = new byte[length << 1];
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            char charAt = str.charAt(i16);
            int i17 = i3 + 1;
            bArr[i3] = (byte) (charAt & '\u00ff');
            i3 = i17 + 1;
            bArr[i17] = (byte) (charAt >> '\b');
        }
        return bArr;
    }

    public static byte[] unicode2Byte(String str) {
        int length = str.length();
        byte[] bArr = new byte[length << 1];
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            char charAt = str.charAt(i16);
            int i17 = i3 + 1;
            bArr[i3] = (byte) (charAt >> '\b');
            i3 = i17 + 1;
            bArr[i17] = (byte) (charAt & '\u00ff');
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
    
        if (r4 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0044, code lost:
    
        if (r4 == null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String utf8Byte2String(byte[] bArr, int i3, int i16) {
        ByteArrayInputStream byteArrayInputStream;
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        try {
            byte[] bArr2 = new byte[i16 + 2];
            bArr2[0] = (byte) (i16 >> 8);
            bArr2[1] = (byte) i16;
            System.arraycopy(bArr, i3, bArr2, 2, i16);
            byteArrayInputStream = new ByteArrayInputStream(bArr2);
            try {
                dataInputStream = new DataInputStream(byteArrayInputStream);
            } catch (IOException unused) {
            } catch (Exception unused2) {
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (IOException unused3) {
            byteArrayInputStream = null;
        } catch (Exception unused4) {
            byteArrayInputStream = null;
        } catch (Throwable th6) {
            th = th6;
            byteArrayInputStream = null;
        }
        try {
            String readUTF = dataInputStream.readUTF();
            try {
                dataInputStream.close();
            } catch (IOException unused5) {
            }
            try {
                byteArrayInputStream.close();
            } catch (IOException unused6) {
                return readUTF;
            }
        } catch (IOException unused7) {
            dataInputStream2 = dataInputStream;
            if (dataInputStream2 != null) {
                try {
                    dataInputStream2.close();
                } catch (IOException unused8) {
                }
            }
        } catch (Exception unused9) {
            dataInputStream2 = dataInputStream;
            if (dataInputStream2 != null) {
                try {
                    dataInputStream2.close();
                } catch (IOException unused10) {
                }
            }
        } catch (Throwable th7) {
            th = th7;
            dataInputStream2 = dataInputStream;
            if (dataInputStream2 != null) {
                try {
                    dataInputStream2.close();
                } catch (IOException unused11) {
                }
            }
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                    throw th;
                } catch (IOException unused12) {
                    throw th;
                }
            }
            throw th;
        }
    }

    public static byte[] vectorString2byteArray(List list) {
        String[] strArr = new String[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            strArr[i3] = (String) list.get(i3);
        }
        return stringArray2byteArray(strArr);
    }

    public static void word2Byte(byte[] bArr, int i3, short s16) {
        bArr[i3] = (byte) (s16 >> 8);
        bArr[i3 + 1] = (byte) s16;
    }

    public static void writeUCS2(String str, OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        byte[] unicode2Byte = unicode2Byte(str);
        dataOutputStream.writeShort(unicode2Byte.length);
        dataOutputStream.write(unicode2Byte);
    }

    public static void copyData(byte[] bArr, int i3, byte[] bArr2, int i16, int i17) {
        System.arraycopy(bArr2, i16, bArr, i3, i17);
    }

    public static String toHexStr(byte b16) {
        int i3 = (b16 & 240) >>> 4;
        int i16 = b16 & RegisterType.DOUBLE_HI;
        return String.valueOf((char) (i3 > 9 ? (i3 - 10) + 65 : i3 + 48)) + String.valueOf((char) (i16 > 9 ? (i16 - 10) + 65 : i16 + 48));
    }

    public static String replace(String str, int i3, String str2, String str3) {
        int indexOf = str.indexOf(str2, i3);
        if (indexOf == -1) {
            return str.substring(i3);
        }
        int length = str2.length();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.substring(i3, indexOf));
        stringBuffer.append(str3);
        stringBuffer.append(replace(str, indexOf + length, str2, str3));
        return stringBuffer.toString();
    }
}
