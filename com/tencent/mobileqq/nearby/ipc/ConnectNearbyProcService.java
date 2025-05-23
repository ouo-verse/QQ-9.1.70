package com.tencent.mobileqq.nearby.ipc;

import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.h;
import com.tencent.mobileqq.nearby.ipc.d;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.AppService;

/* loaded from: classes33.dex */
public class ConnectNearbyProcService extends AppService {

    /* renamed from: f, reason: collision with root package name */
    private static f f252607f;

    /* renamed from: h, reason: collision with root package name */
    private static Object f252608h = new Object();

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.nearby.api.a f252609d;

    /* renamed from: e, reason: collision with root package name */
    private d f252610e = new a();

    public static Object[] B(int i3, Object... objArr) {
        if (f252607f == null) {
            return null;
        }
        try {
            synchronized (f252608h) {
                f fVar = f252607f;
                if (fVar == null) {
                    return null;
                }
                BasicTypeDataParcel I4 = fVar.I4(new BasicTypeDataParcel(i3, objArr));
                if (I4 == null) {
                    return null;
                }
                return I4.f252606e;
            }
        } catch (RemoteException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message v(Message message) {
        com.tencent.mobileqq.nearby.api.a aVar = this.f252609d;
        if (aVar != null) {
            return aVar.e(this, message);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] w(int i3, Object... objArr) {
        com.tencent.mobileqq.nearby.api.a aVar = this.f252609d;
        if (aVar != null) {
            return aVar.b(this, i3, objArr);
        }
        return null;
    }

    private void x() {
        AppRuntime appRuntime = this.app;
        if (appRuntime != null && (appRuntime instanceof QQAppInterface)) {
            this.f252609d = h.b((QQAppInterface) appRuntime);
            return;
        }
        throw new IllegalArgumentException("not QQAppInterface. wrong.");
    }

    public static boolean y() {
        boolean z16;
        synchronized (f252608h) {
            z16 = f252607f != null;
        }
        return z16;
    }

    public static Message z(Message message) {
        if (f252607f != null && message != null) {
            try {
                synchronized (f252608h) {
                    f fVar = f252607f;
                    if (fVar == null) {
                        return null;
                    }
                    return fVar.J2(message);
                }
            } catch (RemoteException e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    @Override // mqq.app.AppService, android.app.Service
    public IBinder onBind(Intent intent) {
        x();
        return this.f252610e.asBinder();
    }

    @Override // mqq.app.AppService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        synchronized (f252608h) {
            f252607f = null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("nearby_ipc_log_tag", 2, "ConnectNearbyProcService onUnbind.");
        }
        this.f252609d = null;
        return super.onUnbind(intent);
    }

    public static Object[] A(int i3) {
        return B(i3, new Object[0]);
    }

    /* loaded from: classes33.dex */
    class a extends d.a {
        a() {
        }

        @Override // com.tencent.mobileqq.nearby.ipc.d
        public void i3(f fVar) throws RemoteException {
            ConnectNearbyProcService.f252607f = fVar;
            if (ConnectNearbyProcService.this.f252609d != null) {
                ConnectNearbyProcService.this.f252609d.f();
            }
        }

        @Override // com.tencent.mobileqq.nearby.ipc.d
        public BasicTypeDataParcel W2(BasicTypeDataParcel basicTypeDataParcel) throws RemoteException {
            if (basicTypeDataParcel == null) {
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.i("nearby_ipc_log_tag", 2, basicTypeDataParcel.toString());
            }
            Object[] w3 = ConnectNearbyProcService.this.w(basicTypeDataParcel.f252605d, basicTypeDataParcel.f252606e);
            if (w3 == null) {
                return null;
            }
            return new BasicTypeDataParcel(basicTypeDataParcel.f252605d, w3);
        }

        @Override // com.tencent.mobileqq.nearby.ipc.d
        public Message j3(Message message) throws RemoteException {
            if (message == null) {
                return null;
            }
            return ConnectNearbyProcService.this.v(message);
        }
    }
}
