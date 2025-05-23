package com.tencent.av.perfstat;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.utils.m;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class MemoryPerfStat implements Handler.Callback {
    private static MemoryPerfStat F;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f74182f = new int[1];

    /* renamed from: i, reason: collision with root package name */
    private int f74184i = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f74185m = 0;
    private long C = 0;
    private int D = 0;
    private String E = null;

    /* renamed from: e, reason: collision with root package name */
    private final WeakReferenceHandler f74181e = new WeakReferenceHandler(Looper.getMainLooper(), this);

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, a> f74180d = new HashMap<>(5);

    /* renamed from: h, reason: collision with root package name */
    private long f74183h = m.c() / 124;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f74186a;

        /* renamed from: b, reason: collision with root package name */
        public long f74187b;

        /* renamed from: c, reason: collision with root package name */
        public long f74188c;

        /* renamed from: d, reason: collision with root package name */
        public long f74189d;

        public a(String str, long j3) {
            this.f74186a = str;
            this.f74187b = j3;
            this.f74188c = j3;
            this.f74189d = j3;
        }

        public void a(long j3) {
            if (this.f74187b < j3) {
                this.f74187b = j3;
            }
            if (this.f74188c > j3) {
                this.f74188c = j3;
            }
            this.f74189d = (this.f74189d + j3) / 2;
        }
    }

    MemoryPerfStat() {
    }

    public static void e(int i3, int i16) {
        if (i16 != 0) {
            if ((i16 == 1 || i16 == 2) && i3 == 0) {
                f().j();
                return;
            }
            return;
        }
        if (i3 != 0) {
            f().k();
        }
    }

    public static MemoryPerfStat f() {
        if (F == null) {
            F = new MemoryPerfStat();
        }
        return F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    public void g(Context context) {
        ActivityManager activityManager;
        Debug.MemoryInfo[] memoryInfoArr;
        long j3;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (context == null || (activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)) == null) {
            return;
        }
        this.f74184i++;
        this.f74182f[0] = Process.myPid();
        Debug.MemoryInfo memoryInfo = null;
        try {
            memoryInfoArr = SystemMethodProxy.getProcessMemoryInfo(activityManager, this.f74182f);
        } catch (Throwable unused) {
            memoryInfoArr = null;
        }
        if (memoryInfoArr != null && memoryInfoArr.length > 0) {
            memoryInfo = memoryInfoArr[0];
        }
        if (memoryInfo == null) {
            return;
        }
        Map<String, String> memoryStats = memoryInfo.getMemoryStats();
        for (String str : memoryStats.keySet()) {
            String str2 = memoryStats.get(str);
            if (str2 != null && str2.length() != 0) {
                try {
                    j3 = Long.parseLong(str2);
                } catch (NumberFormatException unused2) {
                    j3 = 0;
                }
                if (j3 != 0) {
                    l(str, j3);
                }
            }
        }
        long abs = Math.abs(SystemClock.elapsedRealtime() - elapsedRealtime);
        long j16 = this.C;
        if (j16 == 0) {
            this.C = abs;
        } else {
            this.C = (j16 + abs) / 2;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(200);
            sb5.append("getMemoryInfoFromAM, cost[");
            sb5.append(abs);
            sb5.append("], avgCost[");
            sb5.append(this.C);
            sb5.append("], cnt[");
            sb5.append(this.f74184i);
            sb5.append("], flag[");
            sb5.append(this.D);
            sb5.append("], \n{");
            try {
                for (String str3 : this.f74180d.keySet()) {
                    a aVar = this.f74180d.get(str3);
                    if (aVar != null) {
                        sb5.append(String.format("%s : [avg:%s, max: %s, min: %s]  KB \n", str3, Long.valueOf(aVar.f74189d), Long.valueOf(aVar.f74187b), Long.valueOf(aVar.f74188c)));
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            sb5.append("}");
            if (QLog.isColorLevel()) {
                QLog.i("MemoryPerfStat", 2, sb5.toString());
            }
        }
    }

    private void l(String str, long j3) {
        if (j3 != 0 && !TextUtils.isEmpty(str)) {
            a aVar = this.f74180d.get(str);
            if (aVar == null) {
                this.f74180d.put(str, new a(str, j3));
            } else {
                aVar.a(j3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        String str = n.e().f().f73091w;
        this.E = h();
        if (QLog.isColorLevel()) {
            QLog.i("MemoryPerfStat", 2, String.format("updatePerfInfo, peer[%s], key[%s], value[%s]", str, "PerfInfo", this.E));
        }
        if (!TextUtils.isEmpty(str)) {
            r.h0().M3(str, "PerfInfo", this.E);
        }
    }

    public String h() {
        StringBuilder sb5 = new StringBuilder(100);
        sb5.append(this.f74183h);
        a aVar = this.f74180d.get("summary.total-pss");
        if (aVar != null) {
            sb5.append(';');
            sb5.append(aVar.f74189d);
            sb5.append(';');
            sb5.append(aVar.f74187b);
            sb5.append(';');
            sb5.append(aVar.f74188c);
            sb5.append(';');
            sb5.append(this.D);
        }
        if (QLog.isColorLevel()) {
            QLog.i("MemoryPerfStat", 2, "getStatsInfo, [" + sb5.toString() + "]");
        }
        return sb5.toString();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1 && this.f74185m == 1) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.perfstat.MemoryPerfStat.1
                @Override // java.lang.Runnable
                public void run() {
                    MemoryPerfStat.this.g(BaseApplicationImpl.getApplication());
                    MemoryPerfStat.this.m();
                    if (MemoryPerfStat.this.f74185m == 1) {
                        MemoryPerfStat.this.f74181e.sendEmptyMessageDelayed(1, 30000L);
                    }
                }
            }, 16, null, false);
        }
        return true;
    }

    public void i(int i3) {
        int i16 = this.D;
        if ((i16 & 1) == 0) {
            this.D = i16 | 1;
        }
        if ((i3 & 8) == 8) {
            int i17 = this.D;
            if ((i17 & 4) == 0) {
                this.D = i17 | 4;
            }
        }
        if ((i3 & 16) == 16) {
            int i18 = this.D;
            if ((i18 & 8) == 0) {
                this.D = i18 | 8;
            }
        }
        if ((i3 & 32) == 32) {
            int i19 = this.D;
            if ((i19 & 16) == 0) {
                this.D = i19 | 16;
            }
        }
        if ((i3 & 256) == 256) {
            int i26 = this.D;
            if ((i26 & 32) == 0) {
                this.D = i26 | 32;
            }
        }
    }

    public void j() {
        if (this.f74185m == 1) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MemoryPerfStat", 2, "start");
        }
        this.f74185m = 1;
        this.D = 0;
        this.f74180d.clear();
        this.f74181e.sendEmptyMessageDelayed(1, 200L);
    }

    public void k() {
        if (this.f74185m != 1) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MemoryPerfStat", 2, "stop");
        }
        this.f74185m = -1;
        this.f74181e.removeMessages(1);
        this.E = h();
    }
}
