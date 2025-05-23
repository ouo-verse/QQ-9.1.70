package com.tencent.av.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.av.service.e;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class k {

    /* renamed from: b, reason: collision with root package name */
    Context f74385b;

    /* renamed from: a, reason: collision with root package name */
    e f74384a = null;

    /* renamed from: c, reason: collision with root package name */
    a f74386c = null;

    /* renamed from: d, reason: collision with root package name */
    b f74387d = new b();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a(k kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a aVar;
            if (QLog.isColorLevel()) {
                QLog.d("QavWrapper", 2, "Qav Service connected!");
            }
            k.this.f74384a = e.a.j(iBinder);
            k kVar = k.this;
            if (kVar.f74384a != null && (aVar = kVar.f74386c) != null) {
                aVar.a(kVar);
            } else {
                QLog.e("QavWrapper", 2, "mQavProxy == null or mOnReadyListener == null");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (QLog.isColorLevel()) {
                QLog.d("QavWrapper", 2, "Qav Service disconnected!");
            }
            k.this.f74384a = null;
        }
    }

    public k(Context context) {
        this.f74385b = context;
    }

    private boolean a(Context context) {
        if (this.f74384a == null) {
            boolean bindService = context.getApplicationContext().bindService(new Intent(context, (Class<?>) AVServiceForQQ.class), this.f74387d, 1);
            if (QLog.isColorLevel() || !bindService) {
                QLog.d("QavWrapper", 2, "bindService result == " + bindService);
            }
            return bindService;
        }
        return false;
    }

    public boolean b(a aVar) {
        this.f74386c = aVar;
        return a(this.f74385b);
    }

    public void c(String str) {
        e eVar = this.f74384a;
        if (eVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QavWrapper", 2, "mQavProxy == null");
            }
        } else {
            try {
                eVar.q0(str);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QavWrapper", 2, "onGetQCallNickName RemoteException", e16);
                }
            }
        }
    }

    public void d(byte[] bArr) {
        e eVar = this.f74384a;
        if (eVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QavWrapper", 2, "mQavProxy == null");
            }
        } else {
            try {
                eVar.processS2C(bArr);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QavWrapper", 2, "RemoteException", e16);
                }
            }
        }
    }

    public void e(int i3, long j3, byte[] bArr) {
        e eVar = this.f74384a;
        if (eVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QavWrapper", 2, "mQavProxy == null");
            }
        } else {
            try {
                eVar.V4(i3, j3, bArr);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QavWrapper", 2, "RemoteException", e16);
                }
            }
        }
    }

    public void f(String str, Bitmap bitmap) {
        e eVar = this.f74384a;
        if (eVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QavWrapper", 2, "mQavProxy == null");
            }
        } else {
            try {
                eVar.k3(str, bitmap);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QavWrapper", 2, "pushStrangeFace RemoteException", e16);
                }
            }
        }
    }

    public void g(Context context) {
        context.getApplicationContext().unbindService(this.f74387d);
        this.f74384a = null;
    }

    public void h() {
        g(this.f74385b);
        this.f74386c = null;
    }
}
