package com.tencent.tmsqmsp.oaid2;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.tmsqmsp.oaid2.l;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes26.dex */
public class m implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f380834a;

    /* renamed from: b, reason: collision with root package name */
    private IVendorCallback f380835b;

    /* renamed from: c, reason: collision with root package name */
    private String f380836c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f380837d;

    /* renamed from: e, reason: collision with root package name */
    private l f380838e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f380839f;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    final class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                m.this.c();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f380836c = "";
        this.f380837d = false;
        this.f380838e = new l();
        this.f380839f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 17)
    public void c() {
        boolean z16;
        if (l.b(this.f380834a)) {
            if (!g() && !f()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                t0.b("honor get oaid success");
            } else {
                t0.b("honor get oaid failed");
            }
        } else {
            t0.a("honor {com.hihonor.id.HnOaIdService} not exist");
        }
        b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004d, code lost:
    
        if (r7.f380839f != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0069, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0062, code lost:
    
        r7.f380838e.c(r7.f380834a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
    
        if (r7.f380839f != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean f() {
        boolean z16;
        boolean z17 = false;
        try {
            l lVar = this.f380838e;
            Context context = this.f380834a;
            Intent intent = new Intent();
            intent.setAction("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            this.f380839f = context.bindService(intent, lVar, 1);
            this.f380838e.f380823d.await(2L, TimeUnit.SECONDS);
            l.a aVar = this.f380838e.f380824e;
            if (!TextUtils.isEmpty(aVar.f380828a) && !aVar.f380829b) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.f380836c = this.f380838e.f380824e.f380828a;
                this.f380837d = !r1.f380829b;
                z17 = true;
            }
        } catch (Exception unused) {
        } catch (Throwable th5) {
            if (this.f380839f) {
                this.f380838e.c(this.f380834a);
            }
            throw th5;
        }
    }

    @RequiresApi(api = 17)
    private boolean g() {
        try {
            String string = Settings.Global.getString(this.f380834a.getContentResolver(), "oaid_limit_state");
            String string2 = Settings.Global.getString(this.f380834a.getContentResolver(), "oaid");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                this.f380837d = !Boolean.parseBoolean(string);
                this.f380836c = string2;
                return true;
            }
        } catch (Throwable th5) {
            t0.a("honor get cache oaid error " + th5.toString());
        }
        return false;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f380837d;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            new BaseThread(new a(), "query-oaid").start();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        IVendorCallback iVendorCallback = this.f380835b;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(this.f380837d, "", this.f380836c);
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) iVendorCallback);
        } else {
            this.f380834a = context;
            this.f380835b = iVendorCallback;
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f380836c : (String) iPatchRedirector.redirect((short) 5, (Object) this);
    }
}
