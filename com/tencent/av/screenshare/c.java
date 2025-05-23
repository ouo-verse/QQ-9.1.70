package com.tencent.av.screenshare;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.n;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f74293a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f74294a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f74295b = 0;

        a() {
        }

        public boolean a() {
            if (this.f74295b != 0 && Math.abs(SystemClock.elapsedRealtime() - this.f74295b) < 5000) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "{lastFromType: " + this.f74294a + ", lastStartTime: " + this.f74295b + "}";
        }
    }

    public static void a(String str) {
        b(str, d(n.e().f()));
    }

    public static void b(String str, int i3) {
        c(str, i3, "");
    }

    public static void c(String str, int i3, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i("ScreenShareReportHelper", 2, String.format("doScreenShareReport, tag[%s], fromType[%s], r2[%s]", str, Integer.valueOf(i3), str2));
        }
        ReportController.o(null, "dc00898", "", "", str, str, i3, 0, str2, "", "", "");
    }

    public static int d(SessionInfo sessionInfo) {
        int i3 = sessionInfo.f73035i;
        String str = sessionInfo.f73030h;
        if (str != null && str.startsWith(String.valueOf(100))) {
            if (i3 == 3) {
                return 1;
            }
            if (i3 == 4) {
                return 2;
            }
            return i3;
        }
        return i3;
    }

    public static int e(String str) {
        a f16 = f(str, false);
        if (f16 == null) {
            return 0;
        }
        return f16.f74294a;
    }

    private static a f(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ConcurrentHashMap<String, a> concurrentHashMap = f74293a;
        a aVar = concurrentHashMap.get(str);
        if (aVar == null && z16) {
            a aVar2 = new a();
            concurrentHashMap.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    public static void g(String str, String str2) {
        a f16 = f(str, false);
        long j3 = 0;
        if (f16 != null) {
            long j16 = f16.f74295b;
            if (j16 != 0) {
                j3 = Math.abs(j16 - SystemClock.elapsedRealtime()) / 1000;
                c("0X800BA73", 0, String.valueOf(j3));
            }
            f74293a.remove(str);
        }
        if (QLog.isColorLevel()) {
            QLog.i("ScreenShareReportHelper", 2, "markScreenShareEnd, sessionId: " + str + ", from: " + str2 + ", cost: " + j3 + ", info: " + f16);
        }
    }

    public static void h(String str, String str2) {
        a f16 = f(str, true);
        if (f16 != null && f16.f74294a == 0) {
            f16.f74294a = 2;
        }
        if (f16 != null && !f16.a()) {
            f16.f74295b = SystemClock.elapsedRealtime();
            if (!ScreenShareCtrl.f(n.e().i(str))) {
                c("0X800BA72", 0, String.valueOf(f16.f74294a));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("ScreenShareReportHelper", 2, "markScreenShareStart, sessionId: " + str + ", from: " + str2 + ", info: " + f16);
        }
    }

    public static void i(String str, int i3, String str2) {
        a f16 = f(str, true);
        if (f16 != null) {
            f16.f74294a = i3;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ScreenShareReportHelper", 2, "saveScreenShareFromType, sessionId: " + str + ", screenShareFromType: " + i3 + ", from: " + str2 + ", info: " + f16);
        }
    }
}
