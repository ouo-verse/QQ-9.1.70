package com.tencent.mobileqq.msf.core.f0.c.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c extends com.tencent.mobileqq.msf.core.x.f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: j, reason: collision with root package name */
    public static final String f248150j = "msf_modify_version_9080_new";

    /* renamed from: k, reason: collision with root package name */
    public static final String f248151k = "msf_modify_version_9080_old";

    /* renamed from: l, reason: collision with root package name */
    public static final String f248152l = "msf_modify_version_9085";

    /* renamed from: m, reason: collision with root package name */
    public static final String f248153m = "msf_modify_version_9090";

    /* renamed from: n, reason: collision with root package name */
    public static final String f248154n = "msf_modify_version_9095";

    /* renamed from: o, reason: collision with root package name */
    public static final String f248155o = "msf_monitor_packet_send";

    /* renamed from: p, reason: collision with root package name */
    public static final String f248156p = "msf_tcp_connect_init";

    /* renamed from: q, reason: collision with root package name */
    public static final boolean f248157q = false;

    /* renamed from: r, reason: collision with root package name */
    public static final boolean f248158r = true;

    /* renamed from: s, reason: collision with root package name */
    public static final boolean f248159s = true;

    /* renamed from: t, reason: collision with root package name */
    public static final boolean f248160t = true;

    /* renamed from: u, reason: collision with root package name */
    public static final boolean f248161u = true;

    /* renamed from: v, reason: collision with root package name */
    public static final boolean f248162v = true;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248163c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248164d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248165e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248166f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248167g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248168h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248169i;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248163c = new AtomicBoolean(a(f248150j, false));
        this.f248164d = new AtomicBoolean(a(f248151k, true));
        this.f248165e = new AtomicBoolean(a(f248152l, true));
        this.f248166f = new AtomicBoolean(a(f248153m, true));
        this.f248167g = new AtomicBoolean(a(f248154n, true));
        this.f248168h = new AtomicBoolean(a(f248155o, !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()));
        this.f248169i = new AtomicBoolean(a(f248156p, true));
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
            QLog.d("MSFConfig", 1, "update MSFCoreModifyConfig, config = " + str);
            JSONObject jSONObject = new JSONObject(str);
            a(str, jSONObject, this.f248163c, f248150j);
            a(str, jSONObject, this.f248164d, f248151k);
            a(str, jSONObject, this.f248165e, f248152l);
            a(str, jSONObject, this.f248166f, f248153m);
            a(str, jSONObject, this.f248167g, f248154n);
            a(str, jSONObject, this.f248168h, f248155o);
            a(str, jSONObject, this.f248169i, f248156p);
        } catch (Exception e16) {
            QLog.d("MSFConfig", 2, "update MSFCoreModifyConfig error, ", e16);
        }
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f248163c.get();
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f248164d.get();
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f248165e.get();
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f248166f.get();
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f248167g.get();
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f248168h.get();
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f248169i.get();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "MSFCoreModifyConfig{mModifyVersion9080New=" + this.f248163c + ", mModifyVersion9080Old=" + this.f248164d + ", mModifyVersion9085=" + this.f248165e + ", mModifyVersion9090=" + this.f248166f + ", mModifyVersion9090=" + this.f248167g + ", mPacketSendMonitor=" + this.f248168h + ", mTcpConnectInit=" + this.f248169i + '}';
    }

    public HashMap<String, Boolean> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (HashMap) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        HashMap<String, Boolean> hashMap = new HashMap<>();
        hashMap.put(f248150j, Boolean.valueOf(b()));
        hashMap.put(f248151k, Boolean.valueOf(c()));
        hashMap.put(f248152l, Boolean.valueOf(d()));
        hashMap.put(f248153m, Boolean.valueOf(e()));
        hashMap.put(f248154n, Boolean.valueOf(f()));
        hashMap.put(f248155o, Boolean.valueOf(g()));
        hashMap.put(f248156p, Boolean.valueOf(h()));
        return hashMap;
    }
}
