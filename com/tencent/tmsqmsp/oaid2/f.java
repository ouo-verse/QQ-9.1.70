package com.tencent.tmsqmsp.oaid2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmsqmsp.oaid2.g;

/* compiled from: P */
/* loaded from: classes26.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Context f380799a;

    /* renamed from: b, reason: collision with root package name */
    private final b f380800b;

    /* renamed from: c, reason: collision with root package name */
    private ServiceConnection f380801c;

    /* renamed from: d, reason: collision with root package name */
    private g f380802d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f380803e;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    final class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f380804d;

        a(b bVar) {
            this.f380804d = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this, (Object) bVar);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            synchronized (this) {
                f.this.f380802d = g.a.a(iBinder);
                b bVar = this.f380804d;
                if (bVar != null) {
                    bVar.b();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                f.this.f380802d = null;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface b {
        void b();
    }

    public f(Context context, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) bVar);
            return;
        }
        this.f380803e = false;
        if (context != null) {
            this.f380799a = context;
            this.f380800b = bVar;
            this.f380801c = new a(bVar);
            return;
        }
        throw new NullPointerException("context can not be null");
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Context context = this.f380799a;
        if (context != null) {
            String packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                try {
                    g gVar = this.f380802d;
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
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        this.f380803e = this.f380799a.bindService(intent, this.f380801c, 1);
        if (!this.f380803e && (bVar = this.f380800b) != null) {
            bVar.b();
        }
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.f380802d != null) {
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
        if (this.f380799a != null && this.f380803e) {
            try {
                this.f380799a.unbindService(this.f380801c);
            } catch (Exception unused) {
            } finally {
                this.f380803e = false;
                this.f380802d = null;
            }
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Context context = this.f380799a;
        if (context != null) {
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                return null;
            }
            try {
                g gVar = this.f380802d;
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
