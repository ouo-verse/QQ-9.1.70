package com.tencent.mobileqq.troop.trooptodo;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, Long> f301766a;

    /* renamed from: b, reason: collision with root package name */
    private static Pair<String, Long> f301767b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65097);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f301766a = new HashMap<>();
            f301767b = null;
        }
    }

    public static boolean a(String str) {
        Long l3;
        Pair<String, Long> pair = f301767b;
        if (pair != null && TextUtils.equals(str, (CharSequence) pair.first)) {
            l3 = (Long) f301767b.second;
        } else {
            l3 = null;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (l3 != null && elapsedRealtime - l3.longValue() < 1000) {
            if (QLog.isColorLevel()) {
                QLog.w("FastClickUtils", 2, "fast click ,tag  = " + str + ", intervalTime = " + (elapsedRealtime - l3.longValue()));
                return true;
            }
            return true;
        }
        f301767b = new Pair<>(str, Long.valueOf(elapsedRealtime));
        return false;
    }

    public static boolean b(String str, long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (f301766a == null) {
            f301766a = new HashMap<>();
        }
        Long l3 = f301766a.get(str);
        if (l3 != null) {
            if (f301766a.size() > 10) {
                f301766a.clear();
            }
            f301766a.put(str, Long.valueOf(elapsedRealtime));
            QLog.d("FastClickUtils", 4, "fast click ,tag  = " + str + ", currentTime = " + elapsedRealtime + " lastTime" + l3 + " intervalTime = " + (elapsedRealtime - l3.longValue()));
            if (elapsedRealtime - l3.longValue() >= j3) {
                return false;
            }
            return true;
        }
        f301766a.put(str, Long.valueOf(elapsedRealtime));
        return false;
    }
}
