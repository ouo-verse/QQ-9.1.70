package com.tencent.gamematrix.gmcg.base.utils;

import android.net.Uri;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.NonNull;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGStringUtil {
    private static final int HASH_ACCUMULATOR = 17;
    private static final int HASH_MULTIPLIER = 31;
    private static final char[] HEX_CHAR_ARRAY = "0123456789abcdef".toCharArray();
    private static final char[] SHA_256_CHARS = new char[64];

    @NonNull
    private static String bytesToHex(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i16 = bArr[i3] & 255;
            int i17 = i3 * 2;
            char[] cArr2 = HEX_CHAR_ARRAY;
            cArr[i17] = cArr2[i16 >>> 4];
            cArr[i17 + 1] = cArr2[i16 & 15];
        }
        return new String(cArr);
    }

    public static String currentTimeInFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
    }

    public static String decodeFromBase64(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Exception unused) {
            return str;
        }
    }

    public static String encodeToBase64(String str) {
        try {
            return Base64.encodeToString(str.getBytes(), 3);
        } catch (Exception unused) {
            return str;
        }
    }

    public static String format(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }

    public static boolean isEmpty(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }

    public static boolean notEmpty(String str) {
        if (str != null && str.length() > 0) {
            return true;
        }
        return false;
    }

    public static Pair<String, Integer> parseNetworkAddress(String str) {
        if (notEmpty(str)) {
            String[] split = str.split(":");
            if (split.length >= 2) {
                return new Pair<>(split[0], Integer.valueOf(Integer.parseInt(split[1])));
            }
        }
        return new Pair<>("", 0);
    }

    @NonNull
    public static String sha256BytesToHex(@NonNull byte[] bArr) {
        String bytesToHex;
        char[] cArr = SHA_256_CHARS;
        synchronized (cArr) {
            bytesToHex = bytesToHex(bArr, cArr);
        }
        return bytesToHex;
    }

    public static int versionCompare(String str, String str2) {
        String decode = Uri.decode(str);
        String decode2 = Uri.decode(str2);
        String[] split = decode.split("\\.");
        String[] split2 = decode2.split("\\.");
        int i3 = 0;
        while (i3 < split.length && i3 < split2.length && split[i3].equals(split2[i3])) {
            i3++;
        }
        if (i3 < split.length && i3 < split2.length) {
            return Integer.signum(split[i3].compareTo(split2[i3]));
        }
        return Integer.signum(split.length - split2.length);
    }
}
