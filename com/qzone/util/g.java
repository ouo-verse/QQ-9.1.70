package com.qzone.util;

import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.util.VersionUtils;

/* compiled from: P */
/* loaded from: classes37.dex */
public class g {
    public static String a(String str) {
        if (VersionUtils.isIceScreamSandwich()) {
            return str;
        }
        if (str == null || str.length() <= 0) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int codePointAt = str.codePointAt(i3);
            if (EmotcationConstants.EMOJI_MAP.get(codePointAt, -1) != -1) {
                if (codePointAt > 65535) {
                    i3++;
                }
                sb5.append("*");
            } else {
                sb5.append(str.charAt(i3));
            }
            i3++;
        }
        return sb5.toString();
    }

    public static String b(String str, String str2) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str2 == null) {
            str2 = "";
        }
        StringBuilder sb5 = new StringBuilder();
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int codePointAt = str.codePointAt(i3);
            if (EmotcationConstants.EMOJI_MAP.get(codePointAt, -1) != -1) {
                if (codePointAt > 65535) {
                    i3++;
                }
                sb5.append(str2);
            } else if (codePointAt == 20) {
                i3++;
                sb5.append(str2);
            } else {
                sb5.append(str.charAt(i3));
            }
            i3++;
        }
        return sb5.toString();
    }
}
