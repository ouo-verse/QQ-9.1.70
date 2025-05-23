package com.tencent.mobileqq.qqaudio;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.m;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f262211a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f262212b;

    /* renamed from: c, reason: collision with root package name */
    private static Random f262213c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f262214d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f262215e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36789);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f262211a = false;
        f262212b = false;
        f262213c = new Random();
        f262214d = false;
        f262215e = false;
    }

    public static void a(int i3) {
        if (!f262215e) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_type", i3 + "");
            hashMap.put("param_version", Build.VERSION.SDK_INT + "");
            hashMap.put("param_deviceName", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actRPPttPlayerType", true, 0L, 0L, hashMap, "");
            f262215e = true;
        }
    }

    public static void b(boolean z16, String str) {
        int i3 = 1;
        if (str.equals("codecsilk")) {
            if (z16) {
                f262211a = true;
                i3 = 0;
            } else {
                f262211a = false;
            }
        } else if (z16) {
            f262212b = true;
            i3 = 2;
        } else {
            f262212b = false;
            i3 = 3;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", String.valueOf(i3));
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.PTT_SO_UPDATE_STATISTIC_TAG, false, 0L, 0L, hashMap, "");
    }

    public static void c(boolean z16) {
        String str;
        if (!f262214d) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("param_succ_flag", str);
            hashMap.put("param_version", Build.VERSION.SDK_INT + "");
            hashMap.put("param_deviceName", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actRPSonicSoLoadStatus", true, 0L, 0L, hashMap, "");
            f262214d = true;
        }
    }

    public static void d(long j3, int i3, long j16, int i16) {
        boolean z16;
        if (Math.abs(f262213c.nextInt() % 100) < 10) {
            int c16 = c.c();
            int f16 = c.f();
            long e16 = c.e();
            long c17 = m.c() / 1048576;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("cpuArch", String.valueOf(c16));
            hashMap.put("numCores", String.valueOf(f16));
            hashMap.put("maxFreq", String.valueOf(e16));
            hashMap.put("memory", String.valueOf(c17));
            if (i16 > 2) {
                z16 = f262212b;
            } else {
                z16 = f262211a;
            }
            hashMap.put("v7so", String.valueOf(z16));
            hashMap.put("type", String.valueOf(i16));
            hashMap.put("maxFrameCost", String.valueOf(j16));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.PTT_PROCESS_FRAME_COST_TAG, true, j3, i3, hashMap, "");
        }
    }
}
