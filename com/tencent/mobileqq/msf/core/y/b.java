package com.tencent.mobileqq.msf.core.y;

import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class b implements c, d {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: d, reason: collision with root package name */
    private static final String f250454d = "MSF.C.DeepSleepDetector";

    /* renamed from: e, reason: collision with root package name */
    public static final String f250455e = "backgroundTime";

    /* renamed from: f, reason: collision with root package name */
    public static final String f250456f = "isForeground";

    /* renamed from: g, reason: collision with root package name */
    public static final String f250457g = "msfAliveTime";

    /* renamed from: a, reason: collision with root package name */
    private final a f250458a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f250459b;

    /* renamed from: c, reason: collision with root package name */
    private long f250460c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        long f250461a;

        /* renamed from: b, reason: collision with root package name */
        int f250462b;

        /* renamed from: c, reason: collision with root package name */
        AtomicBoolean f250463c;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            } else {
                this.f250463c = new AtomicBoolean(false);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f250462b++;
            b.this.f250459b.postDelayed(this, com.tencent.mobileqq.msf.core.x.d.h() * 1000);
            QLog.d(b.f250454d, 1, "[run] count after++: ", Integer.valueOf(this.f250462b));
        }

        private void a(long j3) {
            QLog.d(b.f250454d, 1, "setStartTime " + j3);
            this.f250461a = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f250463c.set(false);
            this.f250461a = 0L;
            this.f250462b = 0;
            QLog.d(b.f250454d, 1, "[reset] startTime = 0, count = 0.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            if (this.f250463c.compareAndSet(false, true)) {
                this.f250462b = 0;
                b.this.f250459b.removeCallbacks(b.this.f250458a);
                a(SystemClock.elapsedRealtime());
                b.this.f250459b.post(b.this.f250458a);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            int h16 = com.tencent.mobileqq.msf.core.x.d.h() * 1000;
            if (this.f250461a <= 0) {
                return false;
            }
            if (com.tencent.mobileqq.msf.core.x.d.Z0() && CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER)) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.f250461a;
                long j3 = (this.f250462b - 1) * h16;
                boolean z16 = Math.abs(elapsedRealtime - j3) > ((long) h16);
                QLog.d(b.f250454d, 1, "[hasInDeepSleep] result: ", Boolean.valueOf(z16), ", bgTime: ", Long.valueOf(elapsedRealtime), ", countTime: ", Long.valueOf(j3), ", interval: ", Integer.valueOf(h16));
                return z16;
            }
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - this.f250461a;
            boolean z17 = Math.abs((((int) (elapsedRealtime2 / ((long) h16))) + 1) - this.f250462b) > 1;
            QLog.d(b.f250454d, 1, "[hasInDeepSleep] result: ", Boolean.valueOf(z17), ", bgTime: ", Long.valueOf(elapsedRealtime2), ", mCount: ", Integer.valueOf(this.f250462b), ", interval: ", Integer.valueOf(h16));
            return z17;
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f250460c = 0L;
        this.f250459b = q.b();
        this.f250458a = new a();
    }

    @Override // com.tencent.mobileqq.msf.core.y.c
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f250459b.removeCallbacks(this.f250458a);
        boolean a16 = this.f250458a.a();
        QLog.d(f250454d, 1, "[onAppForeground] isDeepSleep: ", Boolean.valueOf(a16));
        if (a16) {
            b();
        }
        b(a16);
        this.f250460c = 0L;
        this.f250458a.b();
    }

    @Override // com.tencent.mobileqq.msf.core.y.c
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            QLog.d(f250454d, 1, "[onAppBackground]");
            this.f250458a.c();
        }
    }

    @Override // com.tencent.mobileqq.msf.core.y.d
    public void onScreenOff() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!this.f250458a.f250463c.get()) {
            this.f250458a.c();
            QLog.d(f250454d, 1, "onScreenOff start detect deepsleep, startTime: " + this.f250458a.f250461a);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.y.d
    public void onScreenOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            boolean a16 = this.f250458a.a();
            b(a16);
            QLog.d(f250454d, 1, "onScreenOn hasInDeepSleep:" + a16);
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this);
    }

    private void b(boolean z16) {
        j statReporter;
        int i3;
        MsfCore core = MsfService.getCore();
        if (core == null || (statReporter = core.getStatReporter()) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("isForeground", String.valueOf(com.tencent.mobileqq.msf.core.y.a.h().i()));
        long j3 = 0;
        if (this.f250460c != 0) {
            hashMap.put(f250455e, String.valueOf(SystemClock.elapsedRealtime() - this.f250460c));
        }
        a aVar = this.f250458a;
        if (aVar != null && (i3 = aVar.f250462b) > 0) {
            j3 = 1000 * (i3 - 1) * com.tencent.mobileqq.msf.core.x.d.h();
        }
        hashMap.put(f250457g, String.valueOf(j3));
        statReporter.a(g.f247673c3, z16, 0L, 0L, (Map<String, String>) hashMap, false, false);
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            if (z16) {
                return;
            }
            h();
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f250458a.a() : ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
    }

    private void b() {
        try {
            FromServiceMsg fromServiceMsg = new FromServiceMsg(BaseApplication.getContext().getAppId(), MsfService.getCore().getNextSeq(), "0", BaseConstants.CMD_WAKE_FROM_DS);
            fromServiceMsg.setMsgSuccess();
            fromServiceMsg.setRequestSsoSeq(MsfService.getCore().getNextSeq());
            MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
            MsfService.getCore().addRespToQuque(null, fromServiceMsg);
            QLog.d(f250454d, 1, "[sendWakeFromDsMsg] msg: ", com.tencent.mobileqq.msf.core.z.a.a(fromServiceMsg));
        } catch (Exception e16) {
            QLog.e(f250454d, 1, "[sendWakeFromDsMsg] exception: ", e16);
        }
    }
}
