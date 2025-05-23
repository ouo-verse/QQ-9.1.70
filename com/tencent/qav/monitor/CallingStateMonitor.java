package com.tencent.qav.monitor;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.tencent.av.service.g;
import com.tencent.av.temp.IExternalUtilsApi;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CallingStateMonitor implements PhoneStatusMonitor.a {
    static IPatchRedirector $redirector_;
    private static CallingStateMonitor D;
    private g C;

    /* renamed from: d, reason: collision with root package name */
    private Context f342387d;

    /* renamed from: e, reason: collision with root package name */
    private c f342388e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f342389f;

    /* renamed from: h, reason: collision with root package name */
    private PhoneStatusMonitor f342390h;

    /* renamed from: i, reason: collision with root package name */
    private BroadcastReceiver f342391i;

    /* renamed from: m, reason: collision with root package name */
    private ServiceConnection f342392m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CallingStateMonitor.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            boolean equals = ITroopHWApi.ACTION_START_VIDEO_CHAT.equals(intent.getAction());
            com.tencent.qav.log.a.a("CallingStateMonitor", String.format("onVideoChattingStateChanged isChatting=%s", Boolean.valueOf(equals)));
            if (CallingStateMonitor.this.f342388e != null) {
                CallingStateMonitor.this.f342388e.c(equals);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements ServiceConnection {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CallingStateMonitor.this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
            } else {
                com.tencent.qav.log.a.a("CallingStateMonitor", String.format("onServiceConnected name=%s service=%s", componentName, iBinder));
                CallingStateMonitor.this.C = g.a.j(iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            } else {
                com.tencent.qav.log.a.a("CallingStateMonitor", String.format("onServiceDisconnected name=%s", componentName));
                CallingStateMonitor.this.C = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface c {
        void c(boolean z16);

        void k(boolean z16);
    }

    CallingStateMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f342387d = null;
        this.f342388e = null;
        this.f342389f = false;
        this.f342390h = null;
        this.f342391i = null;
        this.f342392m = null;
        this.C = null;
    }

    private void g() {
        if (QLog.isColorLevel()) {
            QLog.i("CallingStateMonitor", 2, "bindQQServiceForAV");
        }
        if (this.f342392m == null) {
            this.f342392m = new b();
        }
        this.f342387d.bindService(new Intent(this.f342387d, ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getQQServiceForAVClass()), this.f342392m, 1);
    }

    public static CallingStateMonitor k() {
        if (D == null) {
            synchronized (CallingStateMonitor.class) {
                if (D == null) {
                    D = new CallingStateMonitor();
                }
            }
        }
        return D;
    }

    private void n() {
        if (this.f342391i == null) {
            this.f342391i = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
        intentFilter.addAction("tencent.av.v2q.StopVideoChat");
        try {
            this.f342387d.registerReceiver(this.f342391i, intentFilter);
        } catch (Throwable th5) {
            QLog.i("CallingStateMonitor", 2, "registerVideoChatReceiver", th5);
        }
    }

    private void q() {
        ServiceConnection serviceConnection = this.f342392m;
        if (serviceConnection != null) {
            this.f342387d.unbindService(serviceConnection);
            this.f342392m = null;
        }
    }

    private void r() {
        BroadcastReceiver broadcastReceiver = this.f342391i;
        if (broadcastReceiver != null) {
            try {
                this.f342387d.unregisterReceiver(broadcastReceiver);
            } catch (Throwable th5) {
                QLog.i("CallingStateMonitor", 2, "unregisterVideoChatReceiver", th5);
            }
            this.f342391i = null;
        }
    }

    @Override // com.tencent.av.utils.PhoneStatusMonitor.a
    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        com.tencent.qav.log.a.a("CallingStateMonitor", String.format("onPhoneCallingStateChanged isCalling=%s", Boolean.valueOf(z16)));
        c cVar = this.f342388e;
        if (cVar != null) {
            cVar.k(z16);
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        PhoneStatusMonitor phoneStatusMonitor = this.f342390h;
        if (phoneStatusMonitor != null && phoneStatusMonitor.m()) {
            phoneStatusMonitor.k();
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CallingStateMonitor", 2, "clearTillEnd");
        }
        PhoneStatusMonitor phoneStatusMonitor = this.f342390h;
        if (phoneStatusMonitor != null) {
            phoneStatusMonitor.l();
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CallingStateMonitor", 2, "destroy, init[" + this.f342389f + "]");
        }
        PhoneStatusMonitor phoneStatusMonitor = this.f342390h;
        if (phoneStatusMonitor != null) {
            phoneStatusMonitor.o();
            this.f342390h = null;
        }
        r();
        q();
        this.f342388e = null;
        this.f342387d = null;
        this.f342389f = false;
        D = null;
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        boolean z16 = false;
        try {
            PhoneStatusMonitor phoneStatusMonitor = this.f342390h;
            if (phoneStatusMonitor != null) {
                z16 = phoneStatusMonitor.m();
            } else {
                g gVar = this.C;
                if (gVar != null) {
                    z16 = gVar.s();
                }
            }
        } catch (Exception e16) {
            com.tencent.qav.log.a.c("CallingStateMonitor", "isPhoneCalling fail.", e16);
        }
        return z16;
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        try {
            g gVar = this.C;
            if (gVar == null) {
                return false;
            }
            return gVar.n();
        } catch (Exception e16) {
            com.tencent.qav.log.a.c("CallingStateMonitor", "isVideoChatting fail.", e16);
            return false;
        }
    }

    public void o(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            this.f342388e = cVar;
        }
    }

    public void p(Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CallingStateMonitor", 2, "setup, init[" + this.f342389f + "], bBindQQServiceForAV[" + z16 + "]");
        }
        if (!this.f342389f) {
            this.f342387d = context;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.qav.monitor.CallingStateMonitor.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CallingStateMonitor.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("CallingStateMonitor", 2, "begin init PhoneStatusMonitor");
                    }
                    if (CallingStateMonitor.this.f342390h == null) {
                        CallingStateMonitor callingStateMonitor = CallingStateMonitor.this;
                        callingStateMonitor.f342390h = new PhoneStatusMonitor(callingStateMonitor.f342387d, CallingStateMonitor.this);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("CallingStateMonitor", 2, "end init PhoneStatusMonitor");
                    }
                }
            });
            n();
            if (z16) {
                g();
            }
            this.f342389f = true;
        }
    }
}
