package com.tencent.mobileqq.qmethodmonitor.monitor;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.privacy.PrivacyPolicyHelper;
import com.tencent.qmethod.pandoraex.api.f;
import com.tencent.qmethod.pandoraex.api.j;
import com.tencent.qmethod.pandoraex.api.o;
import com.tencent.qmethod.pandoraex.api.q;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class PrivacyProtectionManager {

    /* renamed from: a, reason: collision with root package name */
    private static final String f261907a = MobileQQ.processName;

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f261908b = new HashSet<String>() { // from class: com.tencent.mobileqq.qmethodmonitor.monitor.PrivacyProtectionManager.1
        {
            add("NI#G_TY_NAME");
            add("IA#GET_H_A");
            add("type su");
        }
    };

    /* renamed from: c, reason: collision with root package name */
    protected static final j f261909c = new a();

    /* renamed from: d, reason: collision with root package name */
    protected static final o f261910d = new b();

    /* renamed from: e, reason: collision with root package name */
    protected static final f f261911e = new c();

    /* loaded from: classes16.dex */
    class a implements j {
        a() {
        }

        @Override // com.tencent.qmethod.pandoraex.api.j
        public void d(String str, String str2) {
            if (PrivacyProtectionManager.d(str, str2)) {
                QLog.d(str, 1, str2);
            }
        }

        @Override // com.tencent.qmethod.pandoraex.api.j
        public void e(String str, String str2) {
            QLog.e(str, 1, str2);
        }

        @Override // com.tencent.qmethod.pandoraex.api.j
        public void i(String str, String str2) {
            QLog.i(str, 1, str2);
        }

        @Override // com.tencent.qmethod.pandoraex.api.j
        public void e(String str, String str2, Throwable th5) {
            QLog.e(str, 1, str2, th5);
        }

        @Override // com.tencent.qmethod.pandoraex.api.j
        public void i(String str, String str2, Throwable th5) {
            QLog.i(str, 1, str2, th5);
        }

        @Override // com.tencent.qmethod.pandoraex.api.j
        public void d(String str, String str2, Throwable th5) {
            QLog.d(str, 1, str2, th5);
        }
    }

    /* loaded from: classes16.dex */
    class b implements o {
        b() {
        }

        @Override // com.tencent.qmethod.pandoraex.api.o
        public void a(Runnable runnable, long j3) {
            ThreadManagerV2.executeDelay(runnable, 16, null, false, j3);
        }
    }

    /* loaded from: classes16.dex */
    class c implements f {
        c() {
        }

        @Override // com.tencent.qmethod.pandoraex.api.f
        public boolean d() {
            return com.tencent.mobileqq.qmethodmonitor.a.a(BaseApplication.getContext());
        }
    }

    private static boolean b(String str) {
        Iterator<String> it = f261908b.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void c(Context context) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            com.tencent.mobileqq.qmethodmonitor.monitor.b.b();
            q.u(com.tencent.mobileqq.qmethodmonitor.pandoraevent.a.b());
            e();
            QLog.d("PrivacyProtectionManager", 1, f261907a + " init PMonitor successful cost:" + Math.abs(SystemClock.uptimeMillis() - uptimeMillis));
        } catch (Exception e16) {
            QLog.d("PrivacyProtectionManager", 1, "initPrivacyProtection error.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(String str, String str2) {
        boolean z16 = false;
        if (TextUtils.isEmpty(str2) || str2.contains("ignore report:") || TextUtils.isEmpty(str2) || str2.contains("convertAndUpdateConfig:")) {
            return false;
        }
        if (TextUtils.isEmpty(str) || !str.contains("MonitorReporter") || !b(str2)) {
            return true;
        }
        if (new Random().nextInt(100) < 1) {
            z16 = true;
        }
        return z16;
    }

    private static void e() {
        if (PrivacyPolicyHelper.isUserAllow()) {
            try {
                f(true);
            } catch (Throwable th5) {
                QLog.e("PrivacyProtectionManager", 1, "setAllowPrivacyPolicy failed, ", th5);
            }
        }
    }

    public static void f(boolean z16) {
        com.tencent.qmethod.monitor.a.p(z16);
    }
}
