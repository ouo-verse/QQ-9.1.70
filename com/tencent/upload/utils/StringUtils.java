package com.tencent.upload.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes27.dex */
public class StringUtils {
    static IPatchRedirector $redirector_ = null;
    private static final char[] HEX_DIGITS;
    private static final Pattern IPV4_REGEX;
    private static final Pattern IPV6_COMPRESS_REGEX;
    private static final Pattern IPV6_COMPRESS_REGEX_BORDER;
    private static final Pattern IPV6_STD_REGEX;
    public static final String sfEmptyString = "";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34643);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        IPV4_REGEX = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        IPV6_STD_REGEX = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        IPV6_COMPRESS_REGEX = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4})*)?)::((?:([0-9A-Fa-f]{1,4}:)*[0-9A-Fa-f]{1,4})?)$");
        IPV6_COMPRESS_REGEX_BORDER = Pattern.compile("^(::(?:[0-9A-Fa-f]{1,4})(?::[0-9A-Fa-f]{1,4}){5})|((?:[0-9A-Fa-f]{1,4})(?::[0-9A-Fa-f]{1,4}){5}::)$");
    }

    public StringUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String bytesToAscii(byte[] bArr, int i3) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < i3; i16++) {
            try {
                sb5.append((char) ((bArr[i16] + 256) % 256));
            } catch (Exception unused) {
                return null;
            }
        }
        return sb5.toString();
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

    public static String getEmptyString(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static byte[] hexStr2Bytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = i3 * 2;
            bArr[i3] = (byte) ((char2Byte(str.charAt(i16)) * RegisterType.UNINIT_REF) + char2Byte(str.charAt(i16 + 1)));
        }
        return bArr;
    }

    public static boolean isIpv4String(String str) {
        String[] split;
        int parseInt;
        int parseInt2;
        if (str != null && (split = str.split("\\.")) != null && split.length == 4) {
            try {
                int parseInt3 = Integer.parseInt(split[0]);
                if (parseInt3 > 0 && parseInt3 <= 255 && (parseInt = Integer.parseInt(split[1])) >= 0 && parseInt <= 255 && (parseInt2 = Integer.parseInt(split[2])) >= 0 && parseInt2 <= 255) {
                    int parseInt4 = Integer.parseInt(split[3]);
                    if (parseInt4 >= 0 && parseInt4 <= 255) {
                        return true;
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public static boolean isIpv6String(String str) {
        int i3 = 0;
        for (int i16 = 0; i16 < str.length(); i16++) {
            if (str.charAt(i16) == ':') {
                i3++;
            }
        }
        if (i3 > 7) {
            return false;
        }
        if (IPV6_STD_REGEX.matcher(str).matches()) {
            return true;
        }
        if (i3 == 7) {
            return IPV6_COMPRESS_REGEX_BORDER.matcher(str).matches();
        }
        return IPV6_COMPRESS_REGEX.matcher(str).matches();
    }

    public static String md5String(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            if (messageDigest == null) {
                return "";
            }
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b16 : digest) {
                int i3 = b16 & 255;
                if (i3 < 16) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(i3));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String toHexString(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (int i3 = 0; i3 < bArr.length; i3++) {
            char[] cArr = HEX_DIGITS;
            sb5.append(cArr[(bArr[i3] & 240) >>> 4]);
            sb5.append(cArr[bArr[i3] & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }
}
