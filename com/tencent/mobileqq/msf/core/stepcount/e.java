package com.tencent.mobileqq.msf.core.stepcount;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: g, reason: collision with root package name */
    private static final String f250010g = "health_step_counter_config";

    /* renamed from: h, reason: collision with root package name */
    private static final String f250011h = "enable_helper";

    /* renamed from: i, reason: collision with root package name */
    private static final boolean f250012i = false;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f250013a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f250014b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicInteger f250015c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicInteger f250016d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicInteger f250017e;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f250018f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final e f250019a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28064);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f250019a = new e(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ e(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    public static e a() {
        return b.f250019a;
    }

    private SharedPreferences c() {
        return MsfService.core.getSharedPreferences(f250010g, 4);
    }

    private void i() {
        SharedPreferences c16 = c();
        this.f250013a.set(c16.getInt(StepCounterConstants.ATTR_STEP_COUNTER_MODE, 0));
        this.f250014b.set(c16.getInt(StepCounterConstants.ATTR_STEP_CADENCE, 300));
        this.f250015c.set(c16.getInt(StepCounterConstants.ATTR_ACTIVE_REPORT_INTERVAL, 600));
        this.f250016d.set(c16.getInt(StepCounterConstants.ATTR_PASSIVE_REPORT_INTERVAL, 1200));
        this.f250017e.set(c16.getInt(StepCounterConstants.ATTR_MAX_RECORD_DAYS, 7));
        this.f250018f.set(c16.getBoolean(f250011h, false));
    }

    private void j() {
        c().edit().putInt(StepCounterConstants.ATTR_STEP_COUNTER_MODE, this.f250013a.get()).putInt(StepCounterConstants.ATTR_STEP_CADENCE, this.f250014b.get()).putInt(StepCounterConstants.ATTR_ACTIVE_REPORT_INTERVAL, this.f250015c.get()).putInt(StepCounterConstants.ATTR_PASSIVE_REPORT_INTERVAL, this.f250016d.get()).putInt(StepCounterConstants.ATTR_MAX_RECORD_DAYS, this.f250017e.get()).putBoolean(f250011h, this.f250018f.get()).apply();
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f250015c.get();
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f250017e.get();
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f250016d.get();
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f250014b.get();
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f250013a.get();
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f250018f.get();
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f250013a = new AtomicInteger(0);
        this.f250014b = new AtomicInteger(300);
        this.f250015c = new AtomicInteger(600);
        this.f250016d = new AtomicInteger(1200);
        this.f250017e = new AtomicInteger(7);
        this.f250018f = new AtomicBoolean(false);
        i();
    }

    public void a(@NonNull ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg);
            return;
        }
        Object attribute = toServiceMsg.getAttribute(StepCounterConstants.ATTR_STEP_COUNTER_MODE);
        if (attribute instanceof Integer) {
            this.f250013a.set(((Integer) attribute).intValue());
        }
        Object attribute2 = toServiceMsg.getAttribute(StepCounterConstants.ATTR_STEP_CADENCE);
        if (attribute2 instanceof Integer) {
            this.f250014b.set(((Integer) attribute2).intValue());
        }
        Object attribute3 = toServiceMsg.getAttribute(StepCounterConstants.ATTR_ACTIVE_REPORT_INTERVAL);
        if (attribute3 instanceof Integer) {
            this.f250015c.set(((Integer) attribute3).intValue());
        }
        Object attribute4 = toServiceMsg.getAttribute(StepCounterConstants.ATTR_PASSIVE_REPORT_INTERVAL);
        if (attribute4 instanceof Integer) {
            this.f250016d.set(((Integer) attribute4).intValue());
        }
        Object attribute5 = toServiceMsg.getAttribute(StepCounterConstants.ATTR_MAX_RECORD_DAYS);
        if (attribute5 instanceof Integer) {
            this.f250017e.set(((Integer) attribute5).intValue());
        }
        j();
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f250018f.set(z16);
            c().edit().putBoolean(f250011h, z16).apply();
        }
    }
}
