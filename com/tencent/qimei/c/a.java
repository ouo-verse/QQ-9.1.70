package com.tencent.qimei.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.c.b;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final Context f343210a;

    /* renamed from: b, reason: collision with root package name */
    public final b f343211b;

    /* renamed from: c, reason: collision with root package name */
    public ServiceConnection f343212c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.qimei.c.b f343213d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f343214e;

    /* compiled from: P */
    /* renamed from: com.tencent.qimei.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class ServiceConnectionC9313a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f343215a;

        public ServiceConnectionC9313a(b bVar) {
            this.f343215a = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) bVar);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.tencent.qimei.c.b c9314a;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            synchronized (this) {
                a aVar = a.this;
                int i3 = b.a.f343217a;
                if (iBinder == null) {
                    c9314a = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (queryLocalInterface != null && (queryLocalInterface instanceof com.tencent.qimei.c.b)) {
                        c9314a = (com.tencent.qimei.c.b) queryLocalInterface;
                    }
                    c9314a = new b.a.C9314a(iBinder);
                }
                aVar.f343213d = c9314a;
                b bVar = this.f343215a;
                if (bVar != null) {
                    ((c) bVar).b();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            } else {
                a.this.f343213d = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface b {
    }

    public a(Context context, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) bVar);
            return;
        }
        this.f343214e = false;
        if (context != null) {
            this.f343210a = context;
            this.f343211b = bVar;
            this.f343212c = new ServiceConnectionC9313a(bVar);
            return;
        }
        throw new NullPointerException("context can not be null");
    }
}
