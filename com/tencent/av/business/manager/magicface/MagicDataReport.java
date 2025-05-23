package com.tencent.av.business.manager.magicface;

import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MagicDataReport {

    /* renamed from: a, reason: collision with root package name */
    static long f73324a = 0;

    /* renamed from: b, reason: collision with root package name */
    static String f73325b = "";

    /* renamed from: c, reason: collision with root package name */
    static String f73326c = "";

    /* renamed from: d, reason: collision with root package name */
    static String f73327d = "";

    /* renamed from: e, reason: collision with root package name */
    static String f73328e = "";

    /* renamed from: f, reason: collision with root package name */
    static int f73329f;

    public static void a(String str) {
        n(str);
        g("0X8008021", null);
    }

    public static void b(String str) {
        n(str);
        g("0X8008131", null);
    }

    public static void c(int i3, String str) {
        int i16;
        if (i3 != 2) {
            i16 = 0;
        } else {
            i16 = 4;
        }
        if (TextUtils.isEmpty(f73328e) || f73328e.equals("0")) {
            f73328e = r.h0().J(n.e().f().f73091w) + "";
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str) && !str.equals(f73326c)) {
            h("dc00898", "0X800BB5E", i16, str);
            f73326c = str;
        }
    }

    public static void d(String str, long j3, int i3) {
        int i16;
        AVCoreLog.printColorLog("MagicDataReport", "DOUBLE SCREEN DataReport onStateReport: |" + str + "|" + j3);
        HashMap hashMap = new HashMap();
        hashMap.put("activeName", str);
        hashMap.put("duration", String.valueOf(j3));
        UserAction.onUserAction("actAVFunChatFace", true, -1L, -1L, hashMap, true);
        try {
            UserAction.flushObjectsToDB(true);
        } catch (Exception e16) {
            AVCoreLog.printErrorLog("MagicDataReport", e16.getMessage());
        }
        if (i3 != 2) {
            i16 = 0;
        } else {
            i16 = 4;
        }
        if (i16 != 0) {
            f(i16, str);
        }
    }

    public static void e(String str) {
        n(str);
        g("0X8008022", null);
    }

    public static void f(int i3, String str) {
        AVCoreLog.printColorLog("MagicDataReport", "WL_DEBUG reportChangeFace fromType = " + i3 + ", id = " + str);
        if (TextUtils.isEmpty(f73328e) || f73328e.equals("0")) {
            f73328e = r.h0().J(n.e().f().f73091w) + "";
        }
        h("dc00898", "0X80088B3", i3, str);
    }

    public static void g(String str, String str2) {
        h("CliOper", str, 0, str2);
    }

    public static void h(final String str, final String str2, final int i3, final String str3) {
        AVCoreLog.printColorLog("MagicDataReport", "reportClickEvent key = " + str2 + ", fromType = " + i3 + ", value = " + str3 + ", mRoomId = " + f73328e);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.business.manager.magicface.MagicDataReport.1
            @Override // java.lang.Runnable
            public void run() {
                String str4 = str;
                String str5 = str2;
                ReportController.o(null, str4, "", "", str5, str5, i3, 0, "", "", MagicDataReport.f73328e, str3);
            }
        }, 16, null, true);
    }

    public static void i(VideoAppInterface videoAppInterface, String str) {
        if (videoAppInterface != null && str != null) {
            n(str);
            com.tencent.av.business.manager.support.a aVar = (com.tencent.av.business.manager.support.a) videoAppInterface.B(5);
            boolean n3 = aVar.n(3, "normal");
            if (!aVar.n(3, "interact") && !n3) {
                g("0X8008027", null);
            } else {
                g("0X8008026", null);
            }
        }
    }

    public static void j(String str, int i3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(f73325b) && !str.equals(f73325b)) {
            d(f73325b, (System.currentTimeMillis() - f73324a) / 1000, f73329f);
        }
        f73325b = str;
        f73329f = i3;
        f73324a = System.currentTimeMillis();
    }

    public static void k(String str, int i3, String str2) {
        n(str2);
        f73327d = str;
    }

    public static void l(int i3) {
        if (!TextUtils.isEmpty(f73325b)) {
            d(f73325b, (System.currentTimeMillis() - f73324a) / 1000, f73329f);
            f73325b = "";
            f73329f = 0;
        }
    }

    public static void m(int i3, String str) {
        n(str);
        if (!TextUtils.isEmpty(f73327d)) {
            g("0X8008025", f73327d);
        }
    }

    static void n(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals("0")) {
            f73328e = str;
        }
    }
}
