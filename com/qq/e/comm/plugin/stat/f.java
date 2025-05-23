package com.qq.e.comm.plugin.stat;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.k.ad;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f39709a = false;

    /* renamed from: b, reason: collision with root package name */
    private static int f39710b = 5;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f39711c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static final Random f39712d = new Random(System.currentTimeMillis());

    public static int a() {
        if (GDTADManager.getInstance().getSM() != null) {
            return GDTADManager.getInstance().getSM().getInteger("maxSingleSize", 1024);
        }
        return 1024;
    }

    public static int b() {
        return GDTADManager.getInstance().getSM() != null ? GDTADManager.getInstance().getSM().getInteger("maxSingleSizeForErrorJSON", MiniAppRealTimeLogReporter.MAX_CONTENT_SIZE) : MiniAppRealTimeLogReporter.MAX_CONTENT_SIZE;
    }

    public static int c() {
        return GDTADManager.getInstance().getSM() != null ? GDTADManager.getInstance().getSM().getInteger("maxSingleSizeForErrorWXParams", MiniAppRealTimeLogReporter.MAX_CONTENT_SIZE) : MiniAppRealTimeLogReporter.MAX_CONTENT_SIZE;
    }

    public static int d() {
        if (GDTADManager.getInstance().getSM() == null) {
            return 30;
        }
        return GDTADManager.getInstance().getSM().getInteger("maxCount", 30);
    }

    public static int e() {
        if (GDTADManager.getInstance().getSM() == null) {
            return 5;
        }
        return GDTADManager.getInstance().getSM().getInteger("eventRate", 5);
    }

    public static boolean f() {
        if (GDTADManager.getInstance().getSM() == null || GDTADManager.getInstance().getSM().getInteger("eventInstant", 0) != 1) {
            return false;
        }
        return true;
    }

    public static int g() {
        if (GDTADManager.getInstance().getSM() == null) {
            return 600;
        }
        return GDTADManager.getInstance().getSM().getInteger("eventPeriod", 600);
    }

    public static int h() {
        if (GDTADManager.getInstance().getSM() == null) {
            return 30;
        }
        return GDTADManager.getInstance().getSM().getInteger("eventBatchCount", 30);
    }

    public static boolean i() {
        int i3 = 158;
        if (GDTADManager.getInstance().getSM() != null) {
            i3 = GDTADManager.getInstance().getSM().getInteger("eventNetPer", 158);
        }
        if ((GDTADManager.getInstance().getDeviceStatus().getNetworkType().getPermValue() & i3) > 0) {
            return true;
        }
        return false;
    }

    public static boolean a(int i3) {
        boolean b16 = b(i3);
        if ((i3 >= 4000000 && i3 <= 4999999) || b16) {
            GDTLogger.d("need add Event:  eventId is " + i3);
            return true;
        }
        return f39709a;
    }

    public static boolean b(int i3) {
        try {
            String[] split = com.qq.e.comm.plugin.j.c.a((String) null, "qq_must_report_event_id_list", "").split(",");
            if (!com.qq.e.comm.plugin.k.g.a(split)) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(i3))) {
                        GDTLogger.d("ignore sample event \uff1a" + i3);
                        return true;
                    }
                }
            }
        } catch (Throwable th5) {
            GDTLogger.e(" isIgnoreSampleEvent throwable." + th5);
        }
        return false;
    }

    public static boolean c(int i3) {
        String string = GDTADManager.getInstance().getSM() != null ? GDTADManager.getInstance().getSM().getString("real_time_report_event_id_list") : null;
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        String[] split = string.trim().split(",");
        if (com.qq.e.comm.plugin.k.g.a(split)) {
            return false;
        }
        for (String str : split) {
            if (!TextUtils.isEmpty(str)) {
                return ad.a(str, -1) == i3;
            }
        }
        return false;
    }

    public static void a(boolean z16) {
        synchronized (f39711c) {
            boolean z17 = true;
            if (z16) {
                int e16 = e();
                GDTLogger.d("updateEventRateState: from Wuji -- currentRate " + e16 + " ;sLastEventRate = " + f39710b);
                if (f39710b != e16) {
                    if (f39712d.nextInt(10000) >= e16) {
                        z17 = false;
                    }
                    f39709a = z17;
                    f39710b = e16;
                    GDTLogger.d("updateEventRateState from Wuji -- sCanReportByEventRate = " + f39709a);
                }
            } else {
                f39710b = e();
                if (f39712d.nextInt(10000) >= f39710b) {
                    z17 = false;
                }
                f39709a = z17;
                GDTLogger.d("updateEventRateState from init -- sLastEventRate = " + f39710b + "; sCanReportByEventRate = " + f39709a);
            }
        }
    }
}
