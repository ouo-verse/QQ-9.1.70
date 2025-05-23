package com.tencent.av.app;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.av.service.e;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static String f73130e = "AVServiceProxy";

    /* renamed from: a, reason: collision with root package name */
    protected VideoAppInterface f73131a;

    /* renamed from: b, reason: collision with root package name */
    protected com.tencent.av.service.e f73132b = null;

    /* renamed from: c, reason: collision with root package name */
    protected ServiceConnectionC0731a f73133c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f73134d = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.av.app.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class ServiceConnectionC0731a implements ServiceConnection {
        ServiceConnectionC0731a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (QLog.isColorLevel()) {
                QLog.d(a.f73130e, 2, "AVServiceForQQ onServiceConnected");
            }
            a.this.f73132b = e.a.j(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (QLog.isColorLevel()) {
                QLog.d(a.f73130e, 2, "AVServiceForQQ onServiceDisconnected");
            }
            a.this.f73132b = null;
        }
    }

    public a(VideoAppInterface videoAppInterface) {
        this.f73131a = videoAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        Intent intent = new Intent(this.f73131a.getApplication(), (Class<?>) AVServiceForQQ.class);
        try {
            this.f73131a.getApplication().startService(intent);
        } catch (Throwable th5) {
            AVCoreLog.printErrorLog(f73130e, "bindService " + th5.getMessage());
        }
        this.f73133c = new ServiceConnectionC0731a();
        this.f73131a.getApplication().bindService(intent, this.f73133c, 1);
    }

    public void c(boolean z16, Notification notification) {
        if (QLog.isColorLevel()) {
            QLog.d(f73130e, 1, String.format("setAVServiceForegroud start=%s mAvService=%s", Boolean.valueOf(z16), this.f73132b));
        }
        com.tencent.av.service.e eVar = this.f73132b;
        if (eVar != null) {
            try {
                eVar.v0(z16, notification);
            } catch (RemoteException e16) {
                QLog.d(f73130e, 1, "setAVServiceForegroud fail.", e16);
            } catch (Throwable th5) {
                QLog.d(f73130e, 1, "setAVServiceForegroud fail.", th5);
            }
        } else {
            try {
                MobileQQ application = this.f73131a.getApplication();
                Intent intent = new Intent(application, (Class<?>) AVServiceForQQ.class);
                intent.putExtra("setForeground", true);
                intent.putExtra(com.tencent.mobileqq.msf.core.net.r.a.f248963o, z16);
                intent.putExtra("notification", notification);
                application.startService(intent);
            } catch (Throwable th6) {
                QLog.d(f73130e, 1, "setAVServiceForegroud fail.", th6);
            }
        }
        this.f73134d = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        this.f73131a.getApplication().stopService(new Intent(this.f73131a.getApplication(), (Class<?>) AVServiceForQQ.class));
        if (this.f73132b != null) {
            try {
                this.f73131a.getApplication().unbindService(this.f73133c);
            } catch (Exception e16) {
                AVCoreLog.printErrorLog(f73130e, "disconnect msg = " + e16.getMessage());
            }
        }
    }
}
