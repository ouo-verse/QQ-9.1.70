package com.tencent.tmdownloader.internal.remote;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.e;
import com.tencent.tmassistantbase.util.l;

/* compiled from: P */
/* loaded from: classes26.dex */
public class RemoteOpService extends Service {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private b f380746a;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RemoteOpService.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            l.c();
            GlobalUtil.getInstance().setContext(RemoteOpService.this);
            com.tencent.tmdownloader.f.a.a.a().e();
        }
    }

    public RemoteOpService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f380746a = new b();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        }
        return this.f380746a;
    }

    @Override // android.app.Service
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            new BaseThread(new a(), e.b.f380463a.toString()).start();
            super.onCreate();
        }
    }
}
