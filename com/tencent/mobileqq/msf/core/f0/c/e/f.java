package com.tencent.mobileqq.msf.core.f0.c.e;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f extends com.tencent.mobileqq.msf.core.x.f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: h, reason: collision with root package name */
    public static final String f248194h = "network_conn_mode";

    /* renamed from: i, reason: collision with root package name */
    public static final String f248195i = "enable_quic_revert_to_tcp_on_conn_fail";

    /* renamed from: j, reason: collision with root package name */
    public static final String f248196j = "enable_quic_revert_to_tcp_on_ipv6";

    /* renamed from: k, reason: collision with root package name */
    public static final String f248197k = "default_connect_mode";

    /* renamed from: l, reason: collision with root package name */
    public static final String f248198l = "quic_idle_check_timeout";

    /* renamed from: c, reason: collision with root package name */
    private int f248199c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248200d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248201e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248202f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248203g;

    public f() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248199c = 1;
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            SharedPreferences sharedPreferences = MsfService.getCore().getSharedPreferences("msf_config", 4);
            if (sharedPreferences.contains(f248197k)) {
                this.f248199c = sharedPreferences.getInt(f248197k, 1);
            } else {
                if (new Random().nextBoolean()) {
                    i3 = 6;
                } else {
                    i3 = 1;
                }
                this.f248199c = i3;
                sharedPreferences.edit().putInt(f248197k, this.f248199c).apply();
            }
        }
        this.f248200d = new AtomicInteger(a(f248194h, this.f248199c));
        this.f248201e = new AtomicBoolean(a(f248195i, true));
        this.f248202f = new AtomicBoolean(a(f248195i, true));
        this.f248203g = new AtomicInteger(a(f248198l, 2000));
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
            QLog.d("MSFConfig", 1, "update MSFCoreNetworkConfig, config = " + str);
            JSONObject jSONObject = new JSONObject(str);
            a(str, jSONObject, this.f248200d, f248194h);
            a(str, jSONObject, this.f248201e, f248195i);
            a(str, jSONObject, this.f248202f, f248196j);
            a(str, jSONObject, this.f248203g, f248198l);
        } catch (Exception e16) {
            QLog.d("MSFConfig", 2, "update MSFCoreNetworkConfig error, ", e16);
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f248203g.get();
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f248201e.get();
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f248202f.get();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "MSFCoreNetworkConfig{connMode=" + this.f248200d + ", isQuicRevertTCPOnConnFail=" + this.f248201e + ", isQuicRevertTCPOnIPv6=" + this.f248202f + ", quickIdleCheckTimeout=" + this.f248203g + '}';
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f248200d.get() : ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
    }
}
