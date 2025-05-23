package com.tencent.mobileqq.msf.core.h0;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.x.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b extends f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: k, reason: collision with root package name */
    public static final String f248396k = "key_wake_lock_switch";

    /* renamed from: l, reason: collision with root package name */
    public static final String f248397l = "key_foreground_switch";

    /* renamed from: m, reason: collision with root package name */
    public static final String f248398m = "key_foreground_lock_time";

    /* renamed from: n, reason: collision with root package name */
    public static final String f248399n = "key_background_lock_time";

    /* renamed from: o, reason: collision with root package name */
    public static final String f248400o = "key_conn_open_lock_time";

    /* renamed from: p, reason: collision with root package name */
    public static final String f248401p = "key_heart_beat_lock_time";

    /* renamed from: q, reason: collision with root package name */
    public static final String f248402q = "key_message_push_lock_time";

    /* renamed from: r, reason: collision with root package name */
    public static final String f248403r = "key_msf_wake_lock_interval_time";

    /* renamed from: s, reason: collision with root package name */
    public static final boolean f248404s = false;

    /* renamed from: t, reason: collision with root package name */
    public static final boolean f248405t = false;

    /* renamed from: u, reason: collision with root package name */
    public static final int f248406u = 8000;

    /* renamed from: v, reason: collision with root package name */
    public static final int f248407v = 60000;

    /* renamed from: w, reason: collision with root package name */
    public static final int f248408w = 8000;

    /* renamed from: x, reason: collision with root package name */
    public static final int f248409x = 8000;

    /* renamed from: y, reason: collision with root package name */
    public static final int f248410y = 8000;

    /* renamed from: z, reason: collision with root package name */
    public static final int f248411z = 300000;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f248412c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f248413d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicInteger f248414e;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicInteger f248415f;

    /* renamed from: g, reason: collision with root package name */
    private final AtomicInteger f248416g;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicInteger f248417h;

    /* renamed from: i, reason: collision with root package name */
    private final AtomicInteger f248418i;

    /* renamed from: j, reason: collision with root package name */
    private final AtomicInteger f248419j;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248412c = new AtomicBoolean(a(f248396k, false));
        this.f248413d = new AtomicBoolean(a(f248397l, false));
        this.f248414e = new AtomicInteger(a(f248398m, 8000));
        this.f248415f = new AtomicInteger(a(f248399n, 60000));
        this.f248416g = new AtomicInteger(a(f248400o, 8000));
        this.f248417h = new AtomicInteger(a(f248401p, 8000));
        this.f248418i = new AtomicInteger(a(f248402q, 8000));
        this.f248419j = new AtomicInteger(a(f248403r, 300000));
        QLog.d("MSFConfig", 1, toString());
    }

    @Override // com.tencent.mobileqq.msf.core.x.f
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            QLog.d("MSFConfig", 1, "update MSFWakeLockConfig config = " + str);
            JSONObject jSONObject = new JSONObject(str);
            a(str, jSONObject, this.f248412c, f248396k);
            a(str, jSONObject, this.f248413d, f248397l);
            a(str, jSONObject, this.f248414e, f248398m);
            a(str, jSONObject, this.f248415f, f248399n);
            a(str, jSONObject, this.f248416g, f248400o);
            a(str, jSONObject, this.f248417h, f248401p);
            a(str, jSONObject, this.f248418i, f248402q);
            a(str, jSONObject, this.f248419j, f248403r);
        } catch (Exception e16) {
            QLog.d("MSFConfig", 1, "MSFWakeLockConfig onUpdateConfig error, ", e16);
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f248416g.get();
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f248414e.get();
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f248417h.get();
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f248419j.get();
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f248418i.get();
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f248413d.get();
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f248412c.get();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "MSFWakeLockConfig{wakeLockEnable=" + this.f248412c.get() + ", foregroundEnable=" + this.f248413d.get() + ", foregroundLockTime=" + this.f248414e.get() + ", backgroundLockTime=" + this.f248415f.get() + ", connOpenLockTime=" + this.f248416g.get() + ", heartBeatLockTime=" + this.f248417h.get() + ", msgPushLockTime=" + this.f248418i.get() + '}';
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.f248415f.get() : ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
    }
}
