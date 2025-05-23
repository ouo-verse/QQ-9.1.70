package com.tencent.qmsp.oaid2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmsp.oaid2.C11729r;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes22.dex */
public class t implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f344290a;

    /* renamed from: b, reason: collision with root package name */
    private IVendorCallback f344291b;

    /* renamed from: c, reason: collision with root package name */
    private String f344292c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f344293d;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) t.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                C11729r.a a16 = C11729r.a(t.this.f344290a);
                if (a16 == null) {
                    if (t.this.f344291b != null) {
                        t.this.f344291b.onResult(false, "", "");
                        return;
                    }
                    return;
                }
                t.this.f344292c = a16.a();
                a16.b();
                if (!TextUtils.isEmpty(t.this.f344292c)) {
                    t.this.f344293d = true;
                }
                if (t.this.f344291b != null) {
                    t.this.f344291b.onResult(t.this.f344293d, "", t.this.f344292c);
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                if (TextUtils.isEmpty(t.this.f344292c)) {
                    t.this.f344293d = false;
                }
                if (t.this.f344291b != null) {
                    t.this.f344291b.onResult(t.this.f344293d, "", t.this.f344292c);
                }
            }
        }
    }

    public t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f344292c = null;
            this.f344293d = false;
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? "" : (String) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            new BaseThread(new a()).start();
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) iVendorCallback);
        } else {
            this.f344290a = context;
            this.f344291b = iVendorCallback;
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f344292c : (String) iPatchRedirector.redirect((short) 5, (Object) this);
    }
}
