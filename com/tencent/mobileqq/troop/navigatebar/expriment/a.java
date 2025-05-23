package com.tencent.mobileqq.troop.navigatebar.expriment;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f297992a;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f297993b;

    /* renamed from: c, reason: collision with root package name */
    private static long f297994c;

    /* renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<String, ConcurrentSkipListSet<String>> f297995d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50832);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f297992a = false;
            f297995d = new ConcurrentHashMap<>();
        }
    }

    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            StringBuilder sb5 = new StringBuilder(bArr.length);
            for (byte b16 : bArr) {
                sb5.append((char) b16);
            }
            return sb5.toString();
        }
        return "";
    }

    public static String b(int i3, int i16) {
        if (c()) {
            return HardCodeUtil.qqStr(i16);
        }
        return HardCodeUtil.qqStr(i3);
    }

    public static boolean c() {
        return d();
    }

    public static boolean d() {
        Boolean bool = f297993b;
        if (bool == null) {
            if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.valueOf(((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("qq_little_ear"));
            }
            f297993b = bool;
        }
        return bool.booleanValue();
    }

    @SuppressLint({"NewApi"})
    public static void e(String str, String str2, long j3) {
        if (!c()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopNavigationUtil", 2, "putNotificationPullCache: time = " + j3 + ", pullOfflineTime = " + f297994c + ", troopUin = " + str + ", feedId = " + str2);
        }
        long j16 = f297994c;
        if (j3 < j16 || j16 == 0) {
            ConcurrentHashMap<String, ConcurrentSkipListSet<String>> concurrentHashMap = f297995d;
            ConcurrentSkipListSet<String> concurrentSkipListSet = concurrentHashMap.get(str);
            if (concurrentSkipListSet == null) {
                concurrentSkipListSet = new ConcurrentSkipListSet<>();
                concurrentHashMap.put(str, concurrentSkipListSet);
            }
            concurrentSkipListSet.add(str2);
        }
    }

    public static void f() {
        f297994c = 0L;
        f297995d.clear();
    }

    public static void g(boolean z16) {
        if (z16 || f297994c == 0) {
            f297994c = SystemClock.elapsedRealtime();
        }
    }
}
