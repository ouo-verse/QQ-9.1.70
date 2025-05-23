package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class Options {
    private static Map<String, String> table;

    static {
        try {
            refresh();
        } catch (SecurityException unused) {
        }
    }

    Options() {
    }

    public static boolean check(String str) {
        Map<String, String> map = table;
        if (map == null || map.get(str.toLowerCase()) == null) {
            return false;
        }
        return true;
    }

    public static void clear() {
        table = null;
    }

    public static int intValue(String str) {
        String value = value(str);
        if (value != null) {
            try {
                int parseInt = Integer.parseInt(value);
                if (parseInt > 0) {
                    return parseInt;
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
        return -1;
    }

    public static void refresh() {
        String property = System.getProperty("dnsjava.options");
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf == -1) {
                    set(nextToken);
                } else {
                    set(nextToken.substring(0, indexOf), nextToken.substring(indexOf + 1));
                }
            }
        }
    }

    public static void set(String str) {
        if (table == null) {
            table = new HashMap();
        }
        table.put(str.toLowerCase(), "true");
    }

    public static void unset(String str) {
        Map<String, String> map = table;
        if (map == null) {
            return;
        }
        map.remove(str.toLowerCase());
    }

    public static String value(String str) {
        Map<String, String> map = table;
        if (map == null) {
            return null;
        }
        return map.get(str.toLowerCase());
    }

    public static void set(String str, String str2) {
        if (table == null) {
            table = new HashMap();
        }
        table.put(str.toLowerCase(), str2.toLowerCase());
    }
}
