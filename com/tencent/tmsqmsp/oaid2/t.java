package com.tencent.tmsqmsp.oaid2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.tmsqmsp.oaid2.r;

/* compiled from: P */
/* loaded from: classes26.dex */
public class t implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f380882a;

    /* renamed from: b, reason: collision with root package name */
    private IVendorCallback f380883b;

    /* renamed from: c, reason: collision with root package name */
    private String f380884c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f380885d;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    final class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) t.this);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                r.a a16 = r.a(t.this.f380882a);
                if (a16 == null) {
                    if (t.this.f380883b != null) {
                        t.this.f380883b.onResult(false, "", "");
                        return;
                    }
                    return;
                }
                t.this.f380884c = a16.a();
                a16.b();
                if (!TextUtils.isEmpty(t.this.f380884c)) {
                    t.this.f380885d = true;
                }
                if (t.this.f380883b != null) {
                    t.this.f380883b.onResult(t.this.f380885d, "", t.this.f380884c);
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                if (TextUtils.isEmpty(t.this.f380884c)) {
                    t.this.f380885d = false;
                }
                if (t.this.f380883b != null) {
                    t.this.f380883b.onResult(t.this.f380885d, "", t.this.f380884c);
                }
            }
        }
    }

    public t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f380884c = null;
            this.f380885d = false;
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? "" : (String) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            new BaseThread(new a()).start();
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) iVendorCallback);
        } else {
            this.f380882a = context;
            this.f380883b = iVendorCallback;
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f380884c : (String) iPatchRedirector.redirect((short) 5, (Object) this);
    }
}
