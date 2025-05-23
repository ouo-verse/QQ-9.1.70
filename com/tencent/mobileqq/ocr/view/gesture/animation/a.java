package com.tencent.mobileqq.ocr.view.gesture.animation;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f255007e;

    /* renamed from: a, reason: collision with root package name */
    private long f255008a;

    /* renamed from: b, reason: collision with root package name */
    private long f255009b;

    /* renamed from: c, reason: collision with root package name */
    private int f255010c;

    /* renamed from: d, reason: collision with root package name */
    private int f255011d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20956);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f255007e = true;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean a() {
        return f255007e;
    }

    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        if (a()) {
            this.f255011d = i3;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f255008a = uptimeMillis;
            this.f255009b = uptimeMillis;
            this.f255010c = 0;
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (a()) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f255008a;
            if (uptimeMillis > 40) {
                Log.e("GestureFps", "Frame time: " + uptimeMillis);
            } else if (uptimeMillis > 20) {
                Log.w("GestureFps", "Frame time: " + uptimeMillis);
            }
            this.f255010c++;
            this.f255008a = SystemClock.uptimeMillis();
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (a() && this.f255010c > 0) {
            int round = Math.round((this.f255010c * 1000.0f) / ((int) (SystemClock.uptimeMillis() - this.f255009b)));
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("actType", String.valueOf(this.f255011d));
            hashMap.put("actFps", String.valueOf(round));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actOcrGestureFps", true, 0L, 0L, hashMap, null);
            QLog.d("GestureFps", 1, "report ActOcrGestureFps, type:", Integer.valueOf(this.f255011d), " fps:", Integer.valueOf(round));
        }
    }
}
