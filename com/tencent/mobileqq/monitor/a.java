package com.tencent.mobileqq.monitor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import okhttp3.HttpUrl;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f247267a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f247268b;

    /* renamed from: c, reason: collision with root package name */
    public static b f247269c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f247270d;

    /* renamed from: e, reason: collision with root package name */
    public static b f247271e;

    /* renamed from: f, reason: collision with root package name */
    public static b f247272f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42825);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f247267a = "AutoMonitor_Camera";
        f247268b = false;
        f247269c = new b();
        f247270d = true;
        f247271e = new b(3);
        f247272f = new b(5);
    }

    public static int a(int[] iArr, int i3, int i16) {
        if (i16 == 0 || iArr == null || i16 > iArr.length) {
            return 0;
        }
        long j3 = 0;
        for (int i17 = i3; i17 < i16; i17++) {
            j3 += iArr[i17];
        }
        int i18 = i16 - i3;
        if (i18 == 0) {
            return 0;
        }
        return (int) (j3 / i18);
    }

    public static String b(int[] iArr, int i3) {
        if (i3 != 0 && iArr != null && i3 <= iArr.length) {
            int i16 = i3 - 1;
            if (i16 == -1) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append('[');
            int i17 = 0;
            while (true) {
                sb5.append(iArr[i17]);
                if (i17 == i16) {
                    sb5.append(']');
                    return sb5.toString();
                }
                sb5.append(", ");
                i17++;
            }
        } else {
            return "";
        }
    }

    public static void c() {
        if (f247269c.c()) {
            f247269c.f247277e = System.currentTimeMillis();
            b bVar = f247269c;
            long j3 = bVar.f247277e - bVar.f247276d;
            QLog.d(f247267a, 1, String.format("CameraEditStatistic, avgRenderCost=%d, cost=%d, frameCount=%d, frameFreq=%d", Integer.valueOf(a(bVar.f247280h, 0, bVar.f247278f)), Long.valueOf(j3), Integer.valueOf(f247269c.f247278f), Long.valueOf((f247269c.f247278f * 1000) / j3)));
            String str = f247267a;
            b bVar2 = f247269c;
            QLog.d(str, 1, String.format("CameraEditStatistic, render cost: %s", b(bVar2.f247280h, bVar2.f247278f)));
            f247269c.g();
        }
    }
}
