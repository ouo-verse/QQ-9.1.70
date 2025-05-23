package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.mobileqq.ar.aidl.a;
import com.tencent.mobileqq.ar.aidl.d;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    AppInterface f196930a;

    /* renamed from: b, reason: collision with root package name */
    ServiceConnection f196931b = null;

    /* renamed from: c, reason: collision with root package name */
    com.tencent.mobileqq.ar.aidl.a f196932c = null;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.ar.aidl.d f196933d = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a extends d.a {
        a() {
        }

        @Override // com.tencent.mobileqq.ar.aidl.d
        public void F(int i3) throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d(f.f196950a, 2, "onArSoDownloadProcess process=" + i3);
            }
        }

        @Override // com.tencent.mobileqq.ar.aidl.d
        public void p() throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d(f.f196950a, 2, "onArSoDownloadFail");
            }
            b.this.c();
        }

        @Override // com.tencent.mobileqq.ar.aidl.d
        public void t() throws RemoteException {
            if (QLog.isColorLevel()) {
                QLog.d(f.f196950a, 2, "onArSoDownloadSuccess");
            }
            b.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ARPromotionMgr.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class ServiceConnectionC7396b implements ServiceConnection {
        ServiceConnectionC7396b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            QLog.w(f.f196950a, 1, "onServiceConnected, name[" + componentName + "]");
            try {
                b.this.f196932c = a.AbstractBinderC7399a.j(iBinder);
                b bVar = b.this;
                bVar.f196932c.n0(bVar.f196933d);
                b.this.f196932c.A2();
            } catch (Exception e16) {
                QLog.w(f.f196950a, 1, "onServiceConnected, Exception", e16);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            QLog.w(f.f196950a, 1, "onServiceDisconnected, name[" + componentName + "]");
            b.this.c();
        }
    }

    void b() {
        com.tencent.mobileqq.ar.aidl.a aVar = this.f196932c;
        if (aVar != null) {
            try {
                aVar.A2();
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f.f196950a, 2, "downloadArSo Exception", e16);
                    return;
                }
                return;
            }
        }
        this.f196933d = new a();
        this.f196931b = new ServiceConnectionC7396b();
        if (this.f196930a == null) {
            return;
        }
        boolean bindService = this.f196930a.getApp().bindService(new Intent(this.f196930a.getApp(), (Class<?>) ArConfigService.class), this.f196931b, 1);
        QLog.w(f.f196950a, 1, "bindServer, ret[" + bindService + "]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        try {
            com.tencent.mobileqq.ar.aidl.a aVar = this.f196932c;
            if (aVar != null) {
                com.tencent.mobileqq.ar.aidl.d dVar = this.f196933d;
                if (dVar != null) {
                    aVar.N4(dVar);
                    this.f196933d = null;
                }
                if (this.f196931b != null) {
                    this.f196930a.getApp().unbindService(this.f196931b);
                    this.f196931b = null;
                }
                this.f196932c = null;
            }
            this.f196930a = null;
        } catch (Exception e16) {
            QLog.w(f.f196950a, 1, "DownloadDependRes.clean, Exception", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(AppInterface appInterface) {
        this.f196930a = appInterface;
        if (!ArConfigService.w0(BaseApplicationImpl.getApplication().getRuntime())) {
            if (QLog.isDevelopLevel()) {
                QLog.w(f.f196950a, 1, "tryDownload, so\u672a\u51c6\u5907");
            }
            b();
        }
    }
}
