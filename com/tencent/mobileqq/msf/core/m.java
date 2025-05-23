package com.tencent.mobileqq.msf.core;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class m {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: i, reason: collision with root package name */
    private static final String f248655i = "MSFToggleManager";

    /* renamed from: j, reason: collision with root package name */
    public static final String f248656j = "sp_msf_toggle";

    /* renamed from: k, reason: collision with root package name */
    public static final String f248657k = "isMSFSupportV20";

    /* renamed from: l, reason: collision with root package name */
    public static final String f248658l = "isAuthWifiNeedPingControl";

    /* renamed from: m, reason: collision with root package name */
    public static final String f248659m = "isUseAppIDFromManifest";

    /* renamed from: n, reason: collision with root package name */
    public static final String f248660n = "isPermittedGetImei";

    /* renamed from: o, reason: collision with root package name */
    public static final String f248661o = "isPermittedGetImsi";

    /* renamed from: p, reason: collision with root package name */
    public static final String f248662p = "isBlockNoLoginSend";

    /* renamed from: q, reason: collision with root package name */
    public static final String f248663q = "isBlockConnectAirPlane";

    /* renamed from: r, reason: collision with root package name */
    public static final String f248664r = "isSocketStatisticReport";

    /* renamed from: s, reason: collision with root package name */
    public static final boolean f248665s = true;

    /* renamed from: t, reason: collision with root package name */
    public static final boolean f248666t = false;

    /* renamed from: u, reason: collision with root package name */
    public static final boolean f248667u = true;

    /* renamed from: v, reason: collision with root package name */
    public static final boolean f248668v = false;

    /* renamed from: w, reason: collision with root package name */
    public static final boolean f248669w = false;

    /* renamed from: x, reason: collision with root package name */
    public static final boolean f248670x = false;

    /* renamed from: y, reason: collision with root package name */
    public static final boolean f248671y = true;

    /* renamed from: z, reason: collision with root package name */
    public static final boolean f248672z = true;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248673a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248674b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248675c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248676d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248677e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248678f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248679g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248680h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final m f248681a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16989);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f248681a = new m(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ m(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    private boolean a(int i3) {
        return i3 != 0;
    }

    public static m i() {
        return b.f248681a;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? this.f248679g.get() : ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f248678f.get();
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f248673a.get();
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f248676d.get();
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f248677e.get();
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.f248680h.get();
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f248675c.get();
    }

    m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248673a = new AtomicBoolean(a(f248657k, true));
        this.f248674b = new AtomicBoolean(a(f248658l, false));
        this.f248675c = new AtomicBoolean(a(f248659m, true));
        this.f248676d = new AtomicBoolean(a(f248660n, false));
        this.f248677e = new AtomicBoolean(a(f248661o, false));
        this.f248678f = new AtomicBoolean(a(f248662p, false));
        this.f248679g = new AtomicBoolean(a(f248663q, true));
        this.f248680h = new AtomicBoolean(a(f248664r, true));
    }

    private void b(String str, boolean z16) {
        MsfService.core.getSharedPreferences(f248656j, 4).edit().putBoolean(str, z16).apply();
    }

    public void a(@NonNull ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg);
            return;
        }
        Object attribute = toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_MSF_TOGGLE);
        if (attribute instanceof String) {
            try {
                String str = (String) attribute;
                if (TextUtils.isEmpty(str)) {
                    QLog.d(f248655i, 1, "[updateMSFToggle], strConfig is empty");
                    return;
                }
                QLog.d(f248655i, 1, "updateMSFToggle, common config = " + str);
                JSONObject jSONObject = new JSONObject((String) attribute);
                a(str, jSONObject, this.f248673a, f248657k);
                a(str, jSONObject, this.f248674b, f248658l);
                a(str, jSONObject, this.f248675c, f248659m);
                a(str, jSONObject, this.f248676d, f248660n);
                a(str, jSONObject, this.f248677e, f248661o);
                a(str, jSONObject, this.f248678f, f248662p);
                a(str, jSONObject, this.f248679g, f248663q);
                a(str, jSONObject, this.f248680h, f248664r);
            } catch (Exception e16) {
                QLog.e(f248655i, 1, "updateMSFToggle throw exception", e16);
            }
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f248674b.get() : ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
    }

    private boolean a(String str, boolean z16) {
        return MsfService.core.getSharedPreferences(f248656j, 4).getBoolean(str, z16);
    }

    private void a(String str, JSONObject jSONObject, @NonNull AtomicBoolean atomicBoolean, String str2) {
        if (str.contains(str2)) {
            int optInt = jSONObject.optInt(str2, a(atomicBoolean));
            if (QLog.isColorLevel()) {
                QLog.d(f248655i, 1, "[updateToggleData], key = " + str2 + ", value = " + optInt);
            }
            atomicBoolean.set(a(optInt));
            b(str2, a(optInt));
        }
    }

    private int a(AtomicBoolean atomicBoolean) {
        return atomicBoolean.get() ? 1 : 0;
    }
}
