package com.tencent.luggage.wxa.n0;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : str.split(",")) {
            String b16 = b(str2);
            if (b16 != null && g(b16)) {
                return b16;
            }
        }
        return null;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (!trim.startsWith("avc1") && !trim.startsWith("avc3")) {
            if (!trim.startsWith("hev1") && !trim.startsWith("hvc1")) {
                if (!trim.startsWith("vp9") && !trim.startsWith("vp09")) {
                    if (!trim.startsWith("vp8") && !trim.startsWith("vp08")) {
                        if (trim.startsWith("mp4a")) {
                            return "audio/mp4a-latm";
                        }
                        if (!trim.startsWith("ac-3") && !trim.startsWith("dac3")) {
                            if (!trim.startsWith("ec-3") && !trim.startsWith("dec3")) {
                                if (!trim.startsWith("dtsc") && !trim.startsWith("dtse")) {
                                    if (!trim.startsWith("dtsh") && !trim.startsWith("dtsl")) {
                                        if (trim.startsWith("opus")) {
                                            return "audio/opus";
                                        }
                                        if (!trim.startsWith("vorbis")) {
                                            return null;
                                        }
                                        return "audio/vorbis";
                                    }
                                    return "audio/vnd.dts.hd";
                                }
                                return "audio/vnd.dts";
                            }
                            return "audio/eac3";
                        }
                        return "audio/ac3";
                    }
                    return "video/x-vnd.on2.vp8";
                }
                return "video/x-vnd.on2.vp9";
            }
            return "video/hevc";
        }
        return "video/avc";
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        throw new IllegalArgumentException("Invalid mime type: " + str);
    }

    public static int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (g(str)) {
            return 1;
        }
        if (i(str)) {
            return 2;
        }
        if (!h(str) && !"application/cea-608".equals(str) && !"application/cea-708".equals(str) && !"application/x-mp4-cea-608".equals(str) && !"application/x-subrip".equals(str) && !"application/ttml+xml".equals(str) && !"application/x-quicktime-tx3g".equals(str) && !"application/x-mp4-vtt".equals(str) && !"application/x-rawcc".equals(str) && !"application/vobsub".equals(str) && !"application/pgs".equals(str) && !"application/dvbsubs".equals(str)) {
            if (!"application/id3".equals(str) && !"application/x-emsg".equals(str) && !"application/x-scte35".equals(str) && !"application/x-camera-motion".equals(str)) {
                return -1;
            }
            return 4;
        }
        return 3;
    }

    public static int e(String str) {
        return d(b(str));
    }

    public static String f(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : str.split(",")) {
            String b16 = b(str2);
            if (b16 != null && i(b16)) {
                return b16;
            }
        }
        return null;
    }

    public static boolean g(String str) {
        return "audio".equals(c(str));
    }

    public static boolean h(String str) {
        return "text".equals(c(str));
    }

    public static boolean i(String str) {
        return "video".equals(c(str));
    }
}
