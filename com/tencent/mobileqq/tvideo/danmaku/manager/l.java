package com.tencent.mobileqq.tvideo.danmaku.manager;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Size;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.common.screen.ScreenUtils;
import feedcloud.FeedCloudMeta$StBarrage;
import l70.a;

/* compiled from: P */
/* loaded from: classes19.dex */
public class l {
    private static int a(com.tencent.rfw.barrage.data.a aVar) {
        return (int) ((c(aVar) / 64.0f) * 1000.0f);
    }

    private static int b(com.tencent.rfw.barrage.data.a aVar) {
        String str;
        if (aVar == null) {
            wz3.b.a("TVideoBarrageTimeUtils", "[getBarrageDrawWidth] barrage should not be null.");
            return 0;
        }
        if (!(aVar.l() instanceof m70.a)) {
            return 0;
        }
        FeedCloudMeta$StBarrage a16 = ((m70.a) aVar.l()).a();
        if (a16 == null) {
            str = "";
        } else {
            str = a16.content.get();
        }
        tz3.k l3 = tz3.i.l();
        return g() + ((int) (wz3.f.f(l3.l(), str) + l3.g() + l3.g()));
    }

    private static int c(com.tencent.rfw.barrage.data.a aVar) {
        return wz3.e.b(b(aVar));
    }

    public static Size d() {
        return e(ScreenUtils.isPortrait());
    }

    public static Size e(boolean z16) {
        DisplayMetrics displayMetrics = wz3.g.a().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int i16 = displayMetrics.heightPixels;
        int max = Math.max(i3, i16);
        int min = Math.min(i3, i16);
        if (z16) {
            return new Size(min, max);
        }
        return new Size(max, min);
    }

    private static int f(com.tencent.rfw.barrage.data.a aVar) {
        return (int) ((c(aVar) / 58.0f) * 1000.0f);
    }

    public static int g() {
        return d().getWidth();
    }

    public static boolean h(com.tencent.rfw.barrage.data.a aVar) {
        Object l3 = aVar.l();
        if (!(l3 instanceof m70.a)) {
            return false;
        }
        return i(((m70.a) l3).a());
    }

    public static boolean i(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
        String str;
        if (feedCloudMeta$StBarrage == null) {
            str = null;
        } else {
            str = feedCloudMeta$StBarrage.f398446id.get();
        }
        if (!TextUtils.isEmpty(str) && str.contains("mater_Id_")) {
            return true;
        }
        return false;
    }

    public static void j(a.C10708a c10708a, boolean z16) {
        if (c10708a == null) {
            wz3.b.c("TVideoBarrageTimeUtils", "[updateBarrageTime] barrage time param should not be null.");
        } else {
            k(c10708a.a(), c10708a.b(), z16);
        }
    }

    private static void k(com.tencent.rfw.barrage.data.a aVar, float f16, boolean z16) {
        int a16;
        FeedCloudMeta$StBarrage feedCloudMeta$StBarrage;
        long j3;
        if (aVar == null) {
            wz3.b.a("TVideoBarrageTimeUtils", "[updateBarrageDistribute] barrage should not be null.");
            return;
        }
        int b16 = b(aVar);
        if (z16) {
            a16 = f(aVar);
        } else {
            a16 = a(aVar);
        }
        long j16 = a16;
        Object l3 = aVar.l();
        PBUInt64Field pBUInt64Field = null;
        if (l3 instanceof m70.a) {
            feedCloudMeta$StBarrage = ((m70.a) l3).a();
        } else {
            feedCloudMeta$StBarrage = null;
        }
        if (feedCloudMeta$StBarrage != null) {
            pBUInt64Field = feedCloudMeta$StBarrage.feedPlayTime;
        }
        if (pBUInt64Field == null) {
            j3 = 0;
        } else {
            j3 = pBUInt64Field.get();
        }
        aVar.A0(j3);
        aVar.r0(new vz3.f(j16));
        aVar.s0(1.0f / f16);
        if (aVar instanceof com.tencent.rfw.barrage.data.d) {
            ((com.tencent.rfw.barrage.data.d) aVar).E0(b16 / ((float) j16));
        }
    }
}
