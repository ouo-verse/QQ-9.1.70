package com.tencent.thumbplayer.common;

import androidx.annotation.NonNull;

/* loaded from: classes26.dex */
public class TPStringUtils {
    private static final String POSTFIX_TRUNCATED = "...[truncated]";

    @NonNull
    public static String truncate(String str, int i3) {
        if (str != null && i3 > 0) {
            if (str.length() > i3) {
                return str.substring(0, i3) + POSTFIX_TRUNCATED;
            }
            return str;
        }
        return "";
    }

    @NonNull
    public static String wrap(String str, int i3) {
        if (str != null && i3 > 0) {
            StringBuilder sb5 = new StringBuilder();
            int length = str.length() / i3;
            int i16 = 0;
            int i17 = 0;
            while (i16 < length) {
                int i18 = i17 + i3;
                sb5.append(str.substring(i17, i18));
                sb5.append("\n");
                i16++;
                i17 = i18;
            }
            sb5.append(str.substring(i17));
            return sb5.toString();
        }
        return "";
    }
}
