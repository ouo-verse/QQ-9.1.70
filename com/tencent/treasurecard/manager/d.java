package com.tencent.treasurecard.manager;

import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.treasurecard.common.NetworkReceiver;
import so4.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d implements so4.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static so4.b f381219f;

    /* renamed from: a, reason: collision with root package name */
    private c f381220a;

    /* renamed from: b, reason: collision with root package name */
    private a f381221b;

    /* renamed from: c, reason: collision with root package name */
    private NetworkReceiver f381222c;

    /* renamed from: d, reason: collision with root package name */
    private Context f381223d;

    /* renamed from: e, reason: collision with root package name */
    private b.a f381224e;

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f381221b = new a();
            this.f381220a = new c();
        }
    }

    public static so4.b i() {
        if (f381219f == null) {
            synchronized (d.class) {
                if (f381219f == null) {
                    f381219f = new d();
                }
            }
        }
        return f381219f;
    }

    @Override // so4.b
    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else {
            a.f381202b = j3;
        }
    }

    @Override // so4.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f381221b.d("");
        }
    }

    @Override // so4.b
    public void c(to4.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
        } else {
            this.f381220a.i(aVar);
        }
    }

    @Override // so4.b
    public void d(b.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) aVar);
        } else {
            this.f381224e = aVar;
        }
    }

    @Override // so4.b
    public void e(to4.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            this.f381220a.k(bVar);
        }
    }

    public void f(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        b.a aVar = this.f381224e;
        if (aVar != null) {
            aVar.a(i3, i16);
        }
    }

    public Context g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Context) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f381223d;
    }

    public a h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f381221b;
    }

    @Override // so4.b
    public void init(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
            return;
        }
        if (context == null) {
            Log.e("TcSdkManager", "SDK init error, Context is must", null);
            return;
        }
        this.f381223d = context.getApplicationContext();
        com.tencent.treasurecard.util.a.d();
        if (this.f381222c == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.intent.action.SIM_STATE_CHANGED");
            NetworkReceiver networkReceiver = new NetworkReceiver();
            this.f381222c = networkReceiver;
            this.f381223d.registerReceiver(networkReceiver, intentFilter);
        }
    }

    public c j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (c) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f381220a;
    }
}
