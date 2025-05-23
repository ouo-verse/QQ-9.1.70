package com.qq.e.comm.plugin.tangramsplash.d;

import android.graphics.Point;
import android.text.TextUtils;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.SplashCustomSettingListener;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.splash.SplashDownloadRes;
import com.tencent.ams.fusion.a.i;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a {
    public static String a(boolean z16) {
        return z16 ? "1" : "0";
    }

    public static String b() {
        return new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.getDefault()).format(new Date());
    }

    private static int c() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return (calendar.get(11) * 60) + calendar.get(12);
    }

    public static String a() {
        if (com.qq.e.comm.plugin.j.c.a("use_uuid_for_spalsh", 0, 1)) {
            return UUID.randomUUID().toString();
        }
        return System.nanoTime() + "_" + Math.random();
    }

    public static r.a b(r rVar) {
        if (rVar != null && rVar.bI() != null && rVar.bI().size() != 0) {
            for (r.a aVar : rVar.bI()) {
                List<Point> list = aVar.f39126b;
                if (list != null && list.size() != 0 && a(aVar.f39126b)) {
                    GDTLogger.d("\u65f6\u95f4\u5b9a\u5411\u547d\u4e2d");
                    return aVar;
                }
            }
        }
        return null;
    }

    public static void a(r rVar) {
        if (rVar == null || rVar.bn() == null) {
            return;
        }
        i.d(rVar);
    }

    public static boolean a(LoadAdParams loadAdParams) {
        if (loadAdParams != null && SDKStatus.getSDKVersionCode() >= 60) {
            return loadAdParams.isHotStart();
        }
        return false;
    }

    public static boolean a(List<Point> list) {
        int c16;
        if (list == null || list.size() == 0) {
            return false;
        }
        for (Point point : list) {
            int i3 = point.x;
            int i16 = point.y;
            if (i3 < 0) {
                i3 = 0;
            }
            if (i16 > 1440) {
                i16 = 1440;
            }
            if (i3 < i16 && (c16 = c()) <= i16 && c16 >= i3) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SplashDownloadRes a(File file, r rVar, SplashCustomSettingListener.DownloadCallback downloadCallback) {
        String str;
        String str2;
        String str3 = null;
        if (rVar == null || file == null || !file.exists()) {
            return null;
        }
        int w3 = rVar.w();
        int i3 = 1;
        if (w3 == 0) {
            str3 = rVar.h();
        } else if (w3 == 1) {
            String x16 = rVar.x();
            i3 = 2;
            str2 = x16;
            str = TextUtils.isEmpty(rVar.bt()) ? x16 : rVar.bt();
            int i16 = i3;
            if (SDKStatus.getSDKVersionCode() < 80) {
                return new SplashDownloadRes(str2, file.getAbsolutePath(), str, i16, rVar.s(), rVar.f(), downloadCallback);
            }
            return new SplashDownloadRes(str2, file.getAbsolutePath(), str, i16, rVar.s(), downloadCallback);
        }
        str2 = str3;
        str = str2;
        int i162 = i3;
        if (SDKStatus.getSDKVersionCode() < 80) {
        }
    }

    public static double a(long j3) {
        if (j3 < 0) {
            return j3;
        }
        long currentTimeMillis = System.currentTimeMillis() - j3;
        if (currentTimeMillis < 0) {
            return -2.0d;
        }
        if (currentTimeMillis > 0 && currentTimeMillis < 86400000) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
            return !simpleDateFormat.format(new Date(j3)).equals(simpleDateFormat.format(new Date(System.currentTimeMillis()))) ? 1.0d : 0.0d;
        }
        return Math.ceil(currentTimeMillis / 86400000);
    }
}
