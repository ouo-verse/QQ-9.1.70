package com.tencent.qmsp.oaid2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmsp.oaid2.g;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Context f344209a;

    /* renamed from: b, reason: collision with root package name */
    private final b f344210b;

    /* renamed from: c, reason: collision with root package name */
    private ServiceConnection f344211c;

    /* renamed from: d, reason: collision with root package name */
    private g f344212d;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f344213a;

        a(b bVar) {
            this.f344213a = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this, (Object) bVar);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            synchronized (this) {
                f.this.f344212d = g.a.a(iBinder);
                b bVar = this.f344213a;
                if (bVar != null) {
                    bVar.b();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                f.this.f344212d = null;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface b {
        void b();
    }

    public f(Context context, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) bVar);
        } else {
            if (context != null) {
                this.f344209a = context;
                this.f344210b = bVar;
                this.f344211c = new a(bVar);
                return;
            }
            throw new NullPointerException("context can not be null");
        }
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Context context = this.f344209a;
        if (context != null) {
            String packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                try {
                    g gVar = this.f344212d;
                    if (gVar != null) {
                        return gVar.b(packageName);
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("Context is null, must be new SxCore first");
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        if (this.f344209a.bindService(intent, this.f344211c, 1)) {
            return;
        }
        this.f344210b.b();
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.f344212d != null) {
            return true;
        }
        return false;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Context context = this.f344209a;
        if (context != null) {
            context.unbindService(this.f344211c);
            this.f344212d = null;
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Context context = this.f344209a;
        if (context != null) {
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                return null;
            }
            try {
                g gVar = this.f344212d;
                if (gVar != null) {
                    return gVar.a(packageName);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        throw new IllegalArgumentException("Context is null, must be new SxCore first");
    }
}
