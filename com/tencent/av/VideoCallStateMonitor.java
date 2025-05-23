package com.tencent.av;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoCallStateMonitor {

    /* renamed from: a, reason: collision with root package name */
    private VideoAppInterface f72847a;

    /* renamed from: b, reason: collision with root package name */
    private String f72848b;

    /* renamed from: c, reason: collision with root package name */
    private int f72849c;

    /* renamed from: d, reason: collision with root package name */
    private long f72850d;

    /* renamed from: e, reason: collision with root package name */
    private List<a> f72851e;

    /* renamed from: f, reason: collision with root package name */
    private volatile long f72852f;

    /* renamed from: g, reason: collision with root package name */
    private volatile long f72853g;

    /* renamed from: h, reason: collision with root package name */
    private long f72854h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f72855i;

    /* renamed from: j, reason: collision with root package name */
    private b f72856j;

    /* renamed from: k, reason: collision with root package name */
    private volatile int f72857k;

    /* renamed from: l, reason: collision with root package name */
    private int f72858l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f72860a;

        /* renamed from: b, reason: collision with root package name */
        long f72861b;

        /* renamed from: c, reason: collision with root package name */
        long f72862c;

        /* renamed from: d, reason: collision with root package name */
        long f72863d;

        /* renamed from: e, reason: collision with root package name */
        long f72864e;

        /* renamed from: f, reason: collision with root package name */
        long f72865f;

        /* renamed from: g, reason: collision with root package name */
        long f72866g;

        a(int i3, long j3, long j16, long j17, long j18, long j19, long j26) {
            this.f72860a = i3;
            this.f72861b = j3;
            this.f72862c = j16;
            this.f72863d = j17;
            this.f72864e = j18;
            this.f72865f = j19;
            this.f72866g = j26;
        }

        boolean a() {
            if (this.f72861b > 0 && this.f72862c > 0 && this.f72863d > 0) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<VideoCallStateMonitor> f72867a;

        b(VideoCallStateMonitor videoCallStateMonitor, Looper looper) {
            super(looper);
            this.f72867a = new WeakReference<>(videoCallStateMonitor);
        }

        public void a() {
            sendMessage(obtainMessage(1));
        }

        public void b() {
            sendMessage(obtainMessage(3));
            removeMessages(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            VideoCallStateMonitor videoCallStateMonitor = this.f72867a.get();
            if (videoCallStateMonitor != null) {
                int i3 = message.what;
                if (i3 == 1) {
                    videoCallStateMonitor.g(i3);
                    if (videoCallStateMonitor.f72857k != 2) {
                        sendMessageDelayed(obtainMessage(message.what), 15000L);
                        return;
                    }
                    return;
                }
                if (i3 == 3) {
                    videoCallStateMonitor.h();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoCallStateMonitor(@NonNull VideoAppInterface videoAppInterface, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("VideoCallStateMonitor", 2, "VideoCallStateMonitor <" + this + "> created");
        }
        this.f72847a = videoAppInterface;
        this.f72848b = str;
        if (TextUtils.isEmpty(str)) {
            this.f72848b = "0";
        }
        this.f72849c = 0;
        this.f72850d = 0L;
        this.f72852f = 0L;
        this.f72853g = 0L;
        this.f72851e = new ArrayList();
        this.f72854h = 0L;
        this.f72856j = new b(this, ThreadManagerV2.getQQCommonThreadLooper());
        this.f72857k = 0;
        this.f72858l = 2;
    }

    private int e() {
        int i3 = n.e().f().f73035i;
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2 || i3 != 0) {
            return 2;
        }
        return 0;
    }

    private long f(Map<String, Integer> map, String str) {
        if (map != null && map.containsKey(str)) {
            return map.get(str).intValue();
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i3) {
        Map<String, Integer> O = ah.O(this.f72847a.getApp());
        if (f(O, "summary.total-pss") <= 0) {
            if (QLog.isColorLevel()) {
                QLog.e("VideoCallStateMonitor", 1, "getTotalPss error!");
            }
        } else {
            k(SystemClock.uptimeMillis(), O);
            i(ah.X() / 1000);
        }
        if (this.f72852f > 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f72852f;
            if (uptimeMillis > 0) {
                j(uptimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0176, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0178, code lost:
    
        com.tencent.qphone.base.util.QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, cannot get memory info");
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x017f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h() {
        ArrayList arrayList;
        long j3;
        long j16;
        double d16;
        boolean z16;
        String str;
        String str2;
        int i3 = 2;
        if (QLog.isColorLevel()) {
            QLog.d("VideoCallStateMonitor", 2, "postReportMemory size = " + this.f72851e.size());
        }
        int size = this.f72851e.size();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (size >= 4) {
            int i16 = (size - 1) - 1;
            long j17 = this.f72851e.get(i16).f72861b - this.f72851e.get(1).f72861b;
            long j18 = this.f72851e.get(i16).f72862c - this.f72851e.get(1).f72862c;
            long j19 = this.f72851e.get(i16).f72863d - this.f72851e.get(1).f72863d;
            int i17 = 1;
            while (true) {
                if (i17 < i16) {
                    a aVar = this.f72851e.get(i17);
                    int i18 = i17 + 1;
                    a aVar2 = this.f72851e.get(i18);
                    int i19 = aVar.f72860a;
                    if (i19 != 0 && i19 != aVar2.f72860a) {
                        if (QLog.isColorLevel()) {
                            QLog.d("VideoCallStateMonitor", i3, "postReportMemory failed, session type changed");
                        }
                        arrayList = arrayList2;
                        j3 = j18;
                        j16 = j19;
                        z16 = true;
                        d16 = 0.0d;
                    } else {
                        this.f72858l = aVar2.f72860a;
                        if (!aVar.a() || !aVar2.a()) {
                            break;
                        }
                        ArrayList arrayList5 = arrayList2;
                        double d17 = aVar2.f72866g - aVar.f72866g;
                        j16 = j19;
                        double d18 = aVar2.f72861b - aVar.f72861b;
                        j3 = j18;
                        double d19 = aVar2.f72862c - aVar.f72862c;
                        double d26 = aVar2.f72863d - aVar.f72863d;
                        d16 = 0.0d;
                        if (d17 <= 0.0d) {
                            if (QLog.isColorLevel()) {
                                QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, timestamp fatal error");
                            }
                            arrayList = arrayList5;
                            z16 = true;
                        } else {
                            if ((d18 > 10000.0d || d19 > 10000.0d || d26 > 10000.0d) && QLog.isColorLevel()) {
                                QLog.d("VideoCallStateMonitor", 2, String.format("total pss grow %skb, java pss grow %skb, native pss grow %skb [in %sms]", Double.valueOf(d18), Double.valueOf(d19), Double.valueOf(d26), Double.valueOf(d17)));
                            }
                            arrayList5.add(Double.valueOf((d18 * 1000.0d) / d17));
                            arrayList3.add(Double.valueOf((d19 * 1000.0d) / d17));
                            arrayList4.add(Double.valueOf((d26 * 1000.0d) / d17));
                            arrayList2 = arrayList5;
                            j19 = j16;
                            j18 = j3;
                            i17 = i18;
                            i3 = 2;
                        }
                    }
                } else {
                    arrayList = arrayList2;
                    j3 = j18;
                    j16 = j19;
                    d16 = 0.0d;
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                Iterator it = arrayList.iterator();
                double d27 = d16;
                while (it.hasNext()) {
                    d27 += ((Double) it.next()).doubleValue();
                }
                Iterator it5 = arrayList3.iterator();
                double d28 = d16;
                while (it5.hasNext()) {
                    d28 += ((Double) it5.next()).doubleValue();
                }
                Iterator it6 = arrayList4.iterator();
                while (it6.hasNext()) {
                    d16 += ((Double) it6.next()).doubleValue();
                }
                double size2 = d27 / arrayList.size();
                double size3 = d28 / arrayList3.size();
                double size4 = d16 / arrayList4.size();
                final HashMap hashMap = new HashMap(9);
                hashMap.put("selfUin", this.f72847a.getCurrentAccountUin());
                hashMap.put("peerUin", this.f72848b);
                hashMap.put("sessionId", String.valueOf(this.f72854h));
                hashMap.put("startTimestamp", String.valueOf(this.f72853g));
                if (this.f72855i) {
                    str = "1";
                } else {
                    str = "0";
                }
                hashMap.put("firstChat", str);
                hashMap.put("chatType", String.valueOf(this.f72858l));
                hashMap.put("device_memory", String.valueOf(com.tencent.mobileqq.utils.m.c() / 1024));
                hashMap.put("totalPss_growth", String.valueOf(j17));
                hashMap.put("totalPss_growthRate", String.valueOf(size2));
                hashMap.put("javaPss_growth", String.valueOf(j3));
                hashMap.put("javaPss_growthRate", String.valueOf(size3));
                hashMap.put("nativePss_growth", String.valueOf(j16));
                hashMap.put("nativePss_growthRate", String.valueOf(size4));
                if (this.f72852f > 0) {
                    str2 = String.valueOf(SystemClock.uptimeMillis() - this.f72852f);
                } else {
                    str2 = "";
                }
                hashMap.put("call_dur", str2);
                if (QLog.isColorLevel()) {
                    QLog.d("VideoCallStateMonitor", 2, "postReportMemory success: " + hashMap.toString());
                }
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.av.VideoCallStateMonitor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(VideoCallStateMonitor.this.f72847a.getCurrentAccountUin(), "av_memory_details", true, 0L, 0L, hashMap, "");
                    }
                }, 5, null, false);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, skip");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, node size = " + size);
        }
    }

    private void i(long j3) {
        if (j3 > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoCallStateMonitor", 2, "call avail mem: " + j3 + "kb");
            }
            r.h0().M3(this.f72848b, "availMem2", String.valueOf(j3));
        }
    }

    private void j(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("VideoCallStateMonitor", 2, "call time: " + j3 + "ms");
        }
        r.h0().M3(this.f72848b, "callDur", String.valueOf(j3));
    }

    private void k(long j3, Map<String, Integer> map) {
        if (map == null) {
            return;
        }
        this.f72849c++;
        long f16 = this.f72850d + f(map, "summary.total-pss");
        this.f72850d = f16;
        long j16 = f16 / this.f72849c;
        r.h0().M3(this.f72848b, "avgMemory", String.valueOf(j16));
        if (QLog.isColorLevel()) {
            QLog.d("VideoCallStateMonitor", 2, "call avg pss: " + j16 + "kb");
        }
        if (QLog.isColorLevel()) {
            QLog.d("VideoCallStateMonitor", 2, String.format("report memory type=%s value=%sKB, time=%s", Integer.valueOf(e()), map.toString(), Long.valueOf(j3)));
        }
        this.f72851e.add(new a(e(), f(map, "summary.total-pss"), f(map, "summary.java-heap"), f(map, "summary.native-heap"), f(map, "summary.code"), f(map, "summary.graphics"), j3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        if (this.f72857k == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoCallStateMonitor", 2, "startCallMonitor");
            }
            this.f72855i = r.h0().V0();
            this.f72852f = SystemClock.uptimeMillis();
            this.f72853g = System.currentTimeMillis();
            this.f72854h = r.h0().J(this.f72848b);
            this.f72856j.a();
            this.f72857k = 1;
            return;
        }
        QLog.e("VideoCallStateMonitor", 1, "startCallMonitor state error");
    }

    public void m() {
        if (this.f72857k != 2) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoCallStateMonitor", 2, "stopMonitor " + Log.getStackTraceString(new RuntimeException()));
            }
            this.f72857k = 2;
            this.f72856j.b();
            return;
        }
        QLog.e("VideoCallStateMonitor", 1, "stopMonitor state error");
    }
}
