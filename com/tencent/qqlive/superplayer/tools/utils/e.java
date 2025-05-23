package com.tencent.qqlive.superplayer.tools.utils;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qqlive.superplayer.vinfo.TVKPlayerVideoInfo;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f345489a = Arrays.asList("OPPO A79", "OPPO A73", "OPPO A83", "OPPO A73t", "OPPO A79t", "OPPO A79k", "OPPO A79kt");

    /* renamed from: b, reason: collision with root package name */
    private static final String f345490b = Build.MANUFACTURER;

    public static int a(TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, boolean z16) {
        if (g.i(tVKPlayerVideoInfo.getExtraRequestParamValue("hevclv", ""), 0) == 31) {
            return b(tVKPlayerVideoInfo, str, z16);
        }
        int i3 = g.i(tVKPlayerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_ENTER_SYSPLAYER_HEVC_CAP, ""), 0);
        if (1 == i3) {
            i3 = 28;
        } else if (2 == i3) {
            i3 = 33;
        }
        d.d("MediaPlayerMgr[TVKPlayerUtils.java]", "[## hevc request], dealHevcLv:" + i3);
        if (z16) {
            tVKPlayerVideoInfo.getExtraRequestParamsMap().remove("hevclv");
            return 0;
        }
        int e16 = e(str, i3);
        if (e16 > 0) {
            tVKPlayerVideoInfo.addExtraRequestParamsMap("hevclv", String.valueOf(e16));
            d.d("MediaPlayerMgr[TVKPlayerUtils.java]", "[## hevc request], getvinfoHevclv: " + e16);
        } else {
            tVKPlayerVideoInfo.getExtraRequestParamsMap().remove("hevclv");
            d.d("MediaPlayerMgr[TVKPlayerUtils.java]", "[## hevc request], getvinfoHevclv: no take");
        }
        return e16;
    }

    public static int b(TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, boolean z16) {
        int i3;
        if (8 == tVKPlayerVideoInfo.getPlayType()) {
            d.d("MediaPlayerMgr[TVKPlayerUtils.java]", "[## hevc request], loop vod, no take.");
            tVKPlayerVideoInfo.getExtraRequestParamsMap().remove("hevclv");
            return 0;
        }
        int i16 = 31;
        if (z16) {
            tVKPlayerVideoInfo.addExtraRequestParamsMap("hevclv", String.valueOf(31));
            return 0;
        }
        if (!str.equalsIgnoreCase("uhd") && !str.equalsIgnoreCase("auto")) {
            int c16 = c(str, 0);
            if (c16 > 0) {
                i3 = 4;
            } else {
                i3 = 31;
            }
            if (i3 != 4 || (g.b(vt3.d.F0.a(), str) >= 0 && c16 >= vt3.d.H0.a().intValue())) {
                i16 = i3;
            }
            tVKPlayerVideoInfo.addExtraRequestParamsMap("hevclv", String.valueOf(i16));
            if (i16 != 4) {
                return 0;
            }
            return c16;
        }
        tVKPlayerVideoInfo.addExtraRequestParamsMap("hevclv", String.valueOf(31));
        return 31;
    }

    public static int c(String str, int i3) {
        int d16 = d(i3);
        d.d("MediaPlayerMgr[TVKPlayerUtils.java]", "[## hevc Level], use hevc:" + vt3.d.f443373a0.a() + ", def:" + str + ", defLevel:" + com.tencent.qqlive.superplayer.player.tools.a.g(str) + ", maxLevel:" + d16);
        if (!vt3.d.f443373a0.a().booleanValue()) {
            return -1;
        }
        if (TextUtils.isEmpty(str)) {
            if (d16 <= 0) {
                return -1;
            }
            return d16;
        }
        if (d16 < com.tencent.qqlive.superplayer.player.tools.a.g(str)) {
            return -1;
        }
        return d16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        if (com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg.PLAYER_CHOICE_SELF_SOFT.equals(vt3.d.f443420k.a()) != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int d(int i3) {
        Throwable th5;
        int i16;
        int i17;
        int i18 = 0;
        try {
            if (!ut3.b.e(tt3.a.c())) {
                return i3;
            }
            if (ut3.b.d(tt3.a.c()) && vt3.d.I1.a().booleanValue()) {
                i16 = com.tencent.qqlive.superplayer.player.tools.a.h();
            } else {
                i16 = 0;
            }
            try {
                i17 = com.tencent.qqlive.superplayer.player.tools.a.j();
            } catch (Throwable th6) {
                th5 = th6;
            }
            try {
            } catch (Throwable th7) {
                th5 = th7;
                i18 = i17;
                d.d("MediaPlayerMgr[TVKPlayerUtils.java]", "[getHevcLevel] " + th5.toString());
                i17 = i18;
                i18 = i16;
                d.d("MediaPlayerMgr[TVKPlayerUtils.java]", "[## hevc level], softLevel=" + i17 + ", hardwareLevel=" + i18 + ", sysLevel=" + i3);
                return g(i17, i18, i3);
            }
        } catch (Throwable th8) {
            th5 = th8;
            i16 = 0;
        }
    }

    public static int e(String str, int i3) {
        int c16;
        if (vt3.d.f443395e2.a().booleanValue()) {
            c16 = c("", i3);
        } else {
            c16 = c(str, i3);
        }
        if (f()) {
            return 0;
        }
        if (c16 > 0 && vt3.d.f443378b0.a().intValue() > 0) {
            return vt3.d.f443378b0.a().intValue();
        }
        return c16;
    }

    private static boolean f() {
        try {
            if (((h.h().equals("H9") && f345490b.equals("BBK")) || ((h.h().equals("H8S") && f345490b.equals("BBK")) || ((h.h().equals("K1") && f345490b.equals("OKii")) || ((h.h().equals("K2") && f345490b.equals("OKii")) || ((h.h().equals("Kids") && f345490b.equals("EEBBK")) || (h.h().equals("S1") && f345490b.equals("EEBBK"))))))) && Build.VERSION.RELEASE.equals("4.2.2")) {
                return true;
            }
            if (h.h().equals("MI PAD") && f345490b.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI) && Build.VERSION.RELEASE.equals("4.4.4")) {
                return true;
            }
            if (h.h().equals("VPad-A107") && f345490b.equals("KTE")) {
                return true;
            }
            if (f345490b.equals("OPPO")) {
                if (f345489a.contains(h.h())) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception e16) {
            d.b("MediaPlayerMgr[TVKPlayerUtils.java]", e16);
            return false;
        }
    }

    private static int g(int i3, int i16, int i17) {
        if (i3 <= i16) {
            i3 = i16;
        }
        if (i3 > i17) {
            return i3;
        }
        return i17;
    }
}
