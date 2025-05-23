package com.tencent.bugly.common.utils;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCKeyGenerator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes5.dex */
public class OSVersionFormatUtil {
    private static final String OS_VERSION_UNKNOWN = "unknown";
    private static final Pattern OS_FORMAT_PATTERN = Pattern.compile("(([1-9]\\d*|0)\\.){0,2}([1-9]\\d*)");
    private static final SparseArray<String> API_LEVEL_OS_VERSION_MAP = new SparseArray<String>() { // from class: com.tencent.bugly.common.utils.OSVersionFormatUtil.1
        {
            append(15, "4.0.3");
            append(16, TVKCKeyGenerator.ENCRYPT_VER_4);
            append(17, TVKCKeyGenerator.ENCRYPT_VER_4_2);
            append(18, "4.3");
            append(19, "4.4");
            append(20, "4.4");
            append(21, "5");
            append(22, TVKCKeyGenerator.ENCRYPT_VER_5);
            append(23, "6");
            append(24, "7");
            append(25, "7.1");
            append(26, "8");
            append(27, "8.1");
            append(28, "9");
            append(29, "10");
            append(30, "11");
            append(31, "12");
        }
    };

    private static String apiLevelToOSVersion(int i3) {
        String str = API_LEVEL_OS_VERSION_MAP.get(i3);
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        return str;
    }

    public static String formatOSVersion(int i3, String str) {
        String str2;
        if (str != null) {
            str = str.trim();
        }
        if (TextUtils.isEmpty(str)) {
            return apiLevelToOSVersion(i3);
        }
        Matcher matcher = OS_FORMAT_PATTERN.matcher(str);
        if (matcher.find()) {
            str2 = matcher.group();
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return apiLevelToOSVersion(i3);
        }
        return str2;
    }

    public static String makeFullOSVersion(int i3, String str) {
        if (str != null) {
            str = str.trim();
        }
        return "Android " + str + ",level " + i3;
    }
}
