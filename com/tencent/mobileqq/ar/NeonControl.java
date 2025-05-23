package com.tencent.mobileqq.ar;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class NeonControl {

    /* renamed from: d, reason: collision with root package name */
    private static NeonControl f197456d = null;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f197457e = true;

    /* renamed from: a, reason: collision with root package name */
    private boolean f197458a;

    /* renamed from: b, reason: collision with root package name */
    final Object f197459b;

    /* renamed from: c, reason: collision with root package name */
    a f197460c;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        long f197465a;

        /* renamed from: b, reason: collision with root package name */
        int f197466b;

        /* renamed from: c, reason: collision with root package name */
        int f197467c;

        public a() {
        }
    }

    NeonControl() {
        Object obj = new Object();
        this.f197459b = obj;
        final SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_cpu_neon_support", 4);
        final boolean z16 = false;
        if (!sharedPreferences.contains("sp_cpu_neon_support")) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.NeonControl.1
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.statistics.cpu.a aVar = new com.tencent.mobileqq.statistics.cpu.a();
                    aVar.a();
                    boolean c16 = aVar.c();
                    sharedPreferences.edit().putBoolean("sp_cpu_neon_support", c16).apply();
                    boolean z17 = y.a().f198849i;
                    boolean z18 = true;
                    if (QLog.isColorLevel()) {
                        QLog.i("NeonControl", 2, String.format("dpcNeonCfgSwitch:%d isCpuNeonSupport:%d forceOpenNeon:%d", Integer.valueOf(z17 ? 1 : 0), Integer.valueOf(c16 ? 1 : 0), Integer.valueOf(z16 ? 1 : 0)));
                    }
                    if (z16) {
                        synchronized (NeonControl.this.f197459b) {
                            NeonControl.this.f197458a = c16;
                        }
                        return;
                    }
                    synchronized (NeonControl.this.f197459b) {
                        NeonControl neonControl = NeonControl.this;
                        if (!z17 || !c16) {
                            z18 = false;
                        }
                        neonControl.f197458a = z18;
                    }
                }
            }, 5, null, true);
        }
        boolean z17 = sharedPreferences.getBoolean("sp_cpu_neon_support", false);
        boolean z18 = y.a().f198849i;
        if (QLog.isColorLevel()) {
            QLog.i("NeonControl", 2, String.format("dpcNeonCfgSwitch:%d isNeonSupport:%d forceOpenNeon:%d", Integer.valueOf(z18 ? 1 : 0), Integer.valueOf(z17 ? 1 : 0), 0));
        }
        synchronized (obj) {
            this.f197458a = z18 && z17;
        }
    }

    public static NeonControl d() {
        if (f197456d == null) {
            f197456d = new NeonControl();
        }
        return f197456d;
    }

    public void b(long j3, int i3) {
        if (this.f197460c == null) {
            a aVar = new a();
            this.f197460c = aVar;
            aVar.f197467c = i3;
        }
        a aVar2 = this.f197460c;
        if (aVar2.f197467c != i3) {
            if (aVar2.f197465a > 0 || aVar2.f197466b > 0) {
                c();
            }
            a aVar3 = this.f197460c;
            aVar3.f197467c = i3;
            aVar3.f197465a = 0L;
            aVar3.f197466b = 0;
        }
        a aVar4 = this.f197460c;
        aVar4.f197465a += j3;
        aVar4.f197466b++;
    }

    public void c() {
        int i3;
        final int i16;
        if (this.f197460c == null) {
            return;
        }
        final a aVar = new a();
        a aVar2 = this.f197460c;
        aVar.f197465a = aVar2.f197465a;
        aVar.f197466b = aVar2.f197466b;
        aVar.f197467c = aVar2.f197467c;
        aVar2.f197467c = Integer.MIN_VALUE;
        aVar2.f197465a = 0L;
        aVar2.f197466b = 0;
        long j3 = aVar.f197465a;
        if (j3 > 0 && (i3 = aVar.f197466b) > 0 && aVar.f197467c != Integer.MIN_VALUE && (i16 = (int) (j3 / i3)) >= 0 && i16 < 600000) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.NeonControl.2
                @Override // java.lang.Runnable
                public void run() {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("neon_opened", String.valueOf(aVar.f197467c));
                    hashMap.put("selimg_frame_consume", String.valueOf(i16));
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_selimg_frame_consume", true, 0L, 0L, hashMap, "");
                    if (QLog.isColorLevel()) {
                        QLog.i("NeonControl", 2, String.format("doReport selimg count:%d avgConsume:%dms neonOpened:%d", Integer.valueOf(aVar.f197466b), Integer.valueOf(i16), Integer.valueOf(aVar.f197467c)));
                        com.tencent.mobileqq.ar.a.a().c(i16);
                    }
                }
            }, 5, null, false);
        }
    }

    public boolean e() {
        boolean z16;
        synchronized (this.f197459b) {
            z16 = this.f197458a;
        }
        return z16;
    }
}
