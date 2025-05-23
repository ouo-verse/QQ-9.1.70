package com.tencent.mobileqq.msf.core.f0.c.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g extends com.tencent.mobileqq.msf.core.x.f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: j, reason: collision with root package name */
    public static final String f248204j = "PacketCombineConfig_isOpen";

    /* renamed from: k, reason: collision with root package name */
    public static final String f248205k = "PacketCombineConfig_maxPacketCount";

    /* renamed from: l, reason: collision with root package name */
    public static final String f248206l = "PacketCombineConfig_maxPacketSize";

    /* renamed from: m, reason: collision with root package name */
    public static final String f248207m = "PacketCombineConfig_minPacketSize";

    /* renamed from: n, reason: collision with root package name */
    public static final String f248208n = "PacketCombineConfig_maxPacketDelayTime";

    /* renamed from: o, reason: collision with root package name */
    public static final String f248209o = "PacketCombineConfig_maxCombineWindowTime";

    /* renamed from: p, reason: collision with root package name */
    public static final String f248210p = "PacketCombineConfig_isSupportNTRequest";

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248211c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248212d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248213e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248214f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248215g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248216h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248217i;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248211c = new AtomicBoolean(a(f248204j, true));
        this.f248212d = new AtomicInteger(a(f248205k, 10));
        this.f248213e = new AtomicInteger(a(f248206l, 3072));
        this.f248214f = new AtomicInteger(a(f248207m, 300));
        this.f248215g = new AtomicInteger(a(f248208n, 1000));
        this.f248216h = new AtomicInteger(a(f248209o, 6000));
        this.f248217i = new AtomicBoolean(a(f248210p, false));
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
            QLog.d("MSFConfig", 1, "update MSFCorePacketCombineConfig, config = " + str);
            JSONObject jSONObject = new JSONObject(str);
            a(str, jSONObject, this.f248211c, f248204j);
            a(str, jSONObject, this.f248212d, f248205k);
            a(str, jSONObject, this.f248213e, f248206l);
            a(str, jSONObject, this.f248214f, f248207m);
            a(str, jSONObject, this.f248215g, f248208n);
            a(str, jSONObject, this.f248216h, f248209o);
            a(str, jSONObject, this.f248217i, f248210p);
        } catch (Exception e16) {
            QLog.d("MSFConfig", 2, "update MSFCorePacketCombineConfig error, ", e16);
        }
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f248217i.get();
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f248216h.get();
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f248212d.get();
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f248215g.get();
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f248213e.get();
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f248214f.get();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "MSFCorePacketCombineConfig{mIsOpen=" + this.f248211c + ", mMaxPacketCount=" + this.f248212d + ", mMaxPacketSize=" + this.f248213e + ", mMinPacketSize=" + this.f248214f + ", mMaxPacketDelayTime=" + this.f248215g + ", mMaxCombineWindowTime=" + this.f248216h + ", mIsSupportNTRequest=" + this.f248217i + '}';
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f248211c.get() : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
    }
}
