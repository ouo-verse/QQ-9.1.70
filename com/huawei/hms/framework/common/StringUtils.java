package com.huawei.hms.framework.common;

import android.text.TextUtils;
import com.huawei.secure.android.common.util.SafeString;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes2.dex */
public class StringUtils {
    private static final int INIT_CAPACITY = 1024;
    private static boolean IS_AEGIS_STRING_LIBRARY_LOADED = false;
    private static final String SAFE_STRING_PATH = "com.huawei.secure.android.common.util.SafeString";
    private static final String TAG = "StringUtils";

    public static String anonymizeMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            if (i3 % 2 != 0) {
                charArray[i3] = '*';
            }
        }
        return new String(charArray);
    }

    public static String byte2Str(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            Logger.w("StringUtils.byte2str error: UnsupportedEncodingException", anonymizeMessage(e16.getMessage()));
            return "";
        }
    }

    private static boolean checkCompatible(String str) {
        ClassLoader classLoader = SecurityBase64Utils.class.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        try {
            classLoader.loadClass(str);
            synchronized (StringUtils.class) {
                IS_AEGIS_STRING_LIBRARY_LOADED = true;
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static String collection2String(Collection<String> collection) {
        if (collection != null && !collection.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                sb5.append(it.next());
                sb5.append(";");
            }
            return sb5.toString().substring(0, sb5.length() - 1);
        }
        return null;
    }

    public static String format(String str, Object... objArr) {
        if (str == null) {
            return "";
        }
        return String.format(Locale.ROOT, str, objArr);
    }

    public static byte[] getBytes(long j3) {
        return getBytes(String.valueOf(j3));
    }

    public static String getTraceInfo(Throwable th5) {
        StackTraceElement[] stackTrace = th5.getStackTrace();
        StringBuilder sb5 = new StringBuilder(1024);
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb5.append("at ");
            sb5.append(stackTraceElement.toString());
            sb5.append(";");
        }
        return sb5.toString();
    }

    public static String replace(String str, CharSequence charSequence, CharSequence charSequence2) {
        if (IS_AEGIS_STRING_LIBRARY_LOADED || checkCompatible(SAFE_STRING_PATH)) {
            try {
                return SafeString.replace(str, charSequence, charSequence2);
            } catch (Throwable unused) {
                Logger.w(TAG, "SafeString.substring error");
            }
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(charSequence)) {
            try {
                return str.replace(charSequence, charSequence2);
            } catch (Exception unused2) {
                return str;
            }
        }
        return str;
    }

    public static byte[] str2Byte(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e16) {
            Logger.w("StringUtils.str2Byte error: UnsupportedEncodingException", anonymizeMessage(e16.getMessage()));
            return new byte[0];
        }
    }

    public static boolean strEquals(String str, String str2) {
        if (str != str2 && (str == null || !str.equals(str2))) {
            return false;
        }
        return true;
    }

    public static boolean stringToBoolean(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return z16;
        }
        try {
            return Boolean.valueOf(str).booleanValue();
        } catch (NumberFormatException e16) {
            Logger.w(TAG, "String to Integer catch NumberFormatException." + anonymizeMessage(e16.getMessage()));
            return z16;
        }
    }

    public static int stringToInteger(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return i3;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e16) {
            Logger.w(TAG, "String to Integer catch NumberFormatException." + anonymizeMessage(e16.getMessage()));
            return i3;
        }
    }

    public static long stringToLong(String str, long j3) {
        if (TextUtils.isEmpty(str)) {
            return j3;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e16) {
            Logger.w(TAG, "String to Long catch NumberFormatException." + anonymizeMessage(e16.getMessage()));
            return j3;
        }
    }

    public static String substring(String str, int i3) {
        if (checkCompatible(SAFE_STRING_PATH)) {
            try {
                return SafeString.substring(str, i3);
            } catch (Throwable unused) {
                Logger.w(TAG, "SafeString.substring error");
            }
        }
        if (!TextUtils.isEmpty(str) && str.length() >= i3 && i3 >= 0) {
            try {
                return str.substring(i3);
            } catch (Exception unused2) {
            }
        }
        return "";
    }

    public static String toLowerCase(String str) {
        if (str == null) {
            return "";
        }
        return str.toLowerCase(Locale.ROOT);
    }

    public static byte[] getBytes(String str) {
        byte[] bArr = new byte[0];
        if (str == null) {
            return bArr;
        }
        try {
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            Logger.w(TAG, "the content has error while it is converted to bytes");
            return bArr;
        }
    }

    public static String substring(String str, int i3, int i16) {
        if (IS_AEGIS_STRING_LIBRARY_LOADED || checkCompatible(SAFE_STRING_PATH)) {
            try {
                return SafeString.substring(str, i3, i16);
            } catch (Throwable unused) {
                Logger.w(TAG, "SafeString.substring error");
            }
        }
        if (!TextUtils.isEmpty(str) && i3 >= 0 && i16 <= str.length() && i16 >= i3) {
            try {
                return str.substring(i3, i16);
            } catch (Exception unused2) {
            }
        }
        return "";
    }
}
