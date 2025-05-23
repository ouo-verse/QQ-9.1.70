package com.tencent.gamematrix.gmcg.webrtc.gamepad.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes6.dex */
public class Misc {
    public static String encodeToken(String str) {
        if (str != null && str.length() != 0) {
            if (str.indexOf(37) == -1) {
                StringBuilder sb5 = new StringBuilder();
                int length = str.length();
                for (int i3 = 0; i3 < length; i3++) {
                    Character valueOf = Character.valueOf(str.charAt(i3));
                    if (valueOf.compareTo((Character) '+') == 0) {
                        sb5.append("%2B");
                    } else if (valueOf.compareTo((Character) '/') == 0) {
                        sb5.append("%2F");
                    } else {
                        sb5.append(valueOf);
                    }
                }
                return sb5.toString();
            }
            return str;
        }
        return "unknown";
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String extractVirtualGamepadGate(String str) {
        String str2;
        Matcher matcher;
        String str3 = "0000";
        try {
            matcher = Pattern.compile("gmve-([a-z0-9_-]+)\\.").matcher(str);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (matcher.find()) {
            String group = matcher.group(1);
            if (group != null) {
                Matcher matcher2 = Pattern.compile("\\.com:(\\d+)").matcher(str);
                if (matcher2.find()) {
                    str3 = matcher2.group(1);
                }
            }
            str2 = str3;
            str3 = group;
            if (str3.equals("goc-cucc-tj")) {
                str3 = str3 + "-j";
            }
            return String.format("&url=%1$s&port=%2$s", str3, str2);
        }
        str2 = "0000";
        if (str3.equals("goc-cucc-tj")) {
        }
        return String.format("&url=%1$s&port=%2$s", str3, str2);
    }

    public static String parseVirtualGamepadParams(String str) {
        if (str != null) {
            try {
                Matcher matcher = Pattern.compile("i=\\d+\\.\\d+\\.\\d+\\.\\d+").matcher(str);
                if (!matcher.find()) {
                    return null;
                }
                String substring = matcher.group(0).substring(2);
                Matcher matcher2 = Pattern.compile("p=\\d+").matcher(str);
                if (!matcher2.find()) {
                    return null;
                }
                String substring2 = matcher2.group().substring(2);
                if (substring != null && substring2 != null) {
                    return String.format("ws=0&ip=%1$s&port=%2$s", substring, substring2);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }
}
