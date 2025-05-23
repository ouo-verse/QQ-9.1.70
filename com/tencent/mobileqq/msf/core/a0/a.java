package com.tencent.mobileqq.msf.core.a0;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.core.y.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: e, reason: collision with root package name */
    private static final String f247336e = "MemoryCeilingMonitor";

    /* renamed from: f, reason: collision with root package name */
    private static final int f247337f = 10000;

    /* renamed from: g, reason: collision with root package name */
    private static final int f247338g = 30000;

    /* renamed from: h, reason: collision with root package name */
    public static final int f247339h = 1;

    /* renamed from: i, reason: collision with root package name */
    public static final int f247340i = 2;

    /* renamed from: j, reason: collision with root package name */
    public static final int f247341j = 3;

    /* renamed from: k, reason: collision with root package name */
    public static final float f247342k = 0.85f;

    /* renamed from: a, reason: collision with root package name */
    private Handler f247343a;

    /* renamed from: b, reason: collision with root package name */
    private long f247344b;

    /* renamed from: c, reason: collision with root package name */
    private long f247345c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f247346d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.a0.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C8068a implements c {
        static IPatchRedirector $redirector_;

        C8068a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.y.c
        public void f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                a.this.i();
            }
        }

        @Override // com.tencent.mobileqq.msf.core.y.c
        public void h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                a.this.h();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final a f247348a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29482);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f247348a = new a();
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f247344b = 10000L;
        }
    }

    public static a b() {
        return b.f247348a;
    }

    private void c() {
        QLog.d(f247336e, 1, "[handleMemoryCalculate]");
        if (g()) {
            a(this.f247345c);
        }
        this.f247343a.sendEmptyMessageDelayed(1, this.f247344b);
    }

    private void d() {
        QLog.d(f247336e, 1, "[handleReportCeiling]");
        j jVar = MsfCore.sCore.statReporter;
        if (jVar != null) {
            TreeMap treeMap = new TreeMap();
            long j3 = Runtime.getRuntime().totalMemory();
            long maxMemory = Runtime.getRuntime().maxMemory();
            long freeMemory = Runtime.getRuntime().freeMemory();
            treeMap.put("Percent", (((j3 - freeMemory) * 1.0d) / maxMemory) + "");
            treeMap.put("TotalMemory", j3 + "");
            treeMap.put("FreeMemory", freeMemory + "");
            treeMap.put("MaxMemory", maxMemory + "");
            treeMap.put("IsForeground", f() + "");
            jVar.a("MSF_MEM_Celling", true, 0L, 0L, (Map<String, String>) treeMap, false, false);
        }
    }

    private void e() {
        QLog.d(f247336e, 1, "[handleReportStart]");
        j jVar = MsfCore.sCore.statReporter;
        if (jVar != null) {
            jVar.a(g.f247770x3, true, 0L, 0L, (Map<String, String>) new TreeMap(), false, false);
        }
    }

    private boolean f() {
        if (this.f247344b == 10000) {
            return true;
        }
        return false;
    }

    private boolean g() {
        long j3 = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        this.f247345c = j3 - freeMemory;
        QLog.d(f247336e, 1, "[calculate] tot: ", Long.valueOf(j3), ", max: ", Long.valueOf(maxMemory), ", free: ", Long.valueOf(freeMemory), ", heap: ", Long.valueOf(this.f247345c), ", per: ", Double.valueOf((this.f247345c * 1.0d) / maxMemory));
        if (((float) this.f247345c) <= ((float) Runtime.getRuntime().maxMemory()) * 0.85f) {
            return false;
        }
        return true;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.d(f247336e, 1, "[detect] start detect memory.");
        if (this.f247343a == null) {
            this.f247343a = new Handler(q.t().getLooper(), this);
            com.tencent.mobileqq.msf.core.y.a.h().a(new C8068a());
            this.f247343a.sendEmptyMessage(2);
        }
        this.f247343a.removeMessages(1);
        this.f247343a.sendEmptyMessageDelayed(1, this.f247344b);
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f247344b = 30000L;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 1) {
            c();
        } else if (i3 == 3) {
            d();
        } else if (i3 == 2) {
            e();
        }
        return true;
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f247344b = 10000L;
        }
    }

    private void a(long j3) {
        QLog.d(f247336e, 1, "[onLowMemory] memory: ", Long.valueOf(j3), ", free: ", Long.valueOf(Runtime.getRuntime().freeMemory()));
        if (this.f247346d) {
            return;
        }
        this.f247343a.sendEmptyMessage(3);
        this.f247346d = true;
    }
}
