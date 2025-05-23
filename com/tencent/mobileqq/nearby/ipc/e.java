package com.tencent.mobileqq.nearby.ipc;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.nearby.ipc.d;
import com.tencent.mobileqq.nearby.ipc.f;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    d f252627b;

    /* renamed from: c, reason: collision with root package name */
    private AppInterface f252628c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.nearby.ipc.b f252629d;

    /* renamed from: a, reason: collision with root package name */
    private Object f252626a = new Object();

    /* renamed from: e, reason: collision with root package name */
    private ServiceConnection f252630e = new a();

    /* renamed from: f, reason: collision with root package name */
    f f252631f = new b();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_NEARBY_MSG_BOX_TAB, 2, "onServiceConnected");
            }
            e.this.f252627b = d.a.j(iBinder);
            try {
                e eVar = e.this;
                eVar.f252627b.i3(eVar.f252631f);
            } catch (RemoteException e16) {
                if (QLog.isDevelopLevel()) {
                    e16.printStackTrace();
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("nearby_ipc_log_tag", 2, "nearbyProcess onServiceConnected.");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_NEARBY_MSG_BOX_TAB, 2, "onServiceDisconnected");
            }
            synchronized (e.this.f252626a) {
                e.this.f252627b = null;
            }
            if (QLog.isColorLevel()) {
                QLog.i("nearby_ipc_log_tag", 2, "nearbyProcess onServiceDisConnected.");
            }
        }
    }

    public e(AppInterface appInterface, com.tencent.mobileqq.nearby.ipc.b bVar) {
        this.f252628c = appInterface;
        this.f252629d = bVar;
    }

    public void b() {
        this.f252628c.getApp().bindService(new Intent(this.f252628c.getApp(), (Class<?>) ConnectNearbyProcService.class), this.f252630e, 1);
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_NEARBY_MSG_BOX_TAB, 2, "bindService");
        }
    }

    Message c(Message message) {
        com.tencent.mobileqq.nearby.ipc.b bVar = this.f252629d;
        if (bVar != null) {
            return bVar.h(message);
        }
        return null;
    }

    Object[] d(int i3, Object... objArr) {
        com.tencent.mobileqq.nearby.ipc.b bVar = this.f252629d;
        if (bVar != null) {
            return bVar.g(i3, objArr);
        }
        return null;
    }

    public Message e(Message message) {
        if (this.f252627b != null && message != null) {
            try {
                synchronized (this.f252626a) {
                    d dVar = this.f252627b;
                    if (dVar == null) {
                        return null;
                    }
                    return dVar.j3(message);
                }
            } catch (RemoteException e16) {
                if (QLog.isDevelopLevel()) {
                    e16.printStackTrace();
                }
            }
        }
        return null;
    }

    public Object[] f(int i3, Object... objArr) {
        if (this.f252627b == null) {
            return null;
        }
        try {
            synchronized (this.f252626a) {
                d dVar = this.f252627b;
                if (dVar == null) {
                    return null;
                }
                BasicTypeDataParcel W2 = dVar.W2(new BasicTypeDataParcel(i3, objArr));
                if (W2 == null) {
                    return null;
                }
                return W2.f252606e;
            }
        } catch (RemoteException e16) {
            if (QLog.isDevelopLevel()) {
                e16.printStackTrace();
            }
            return null;
        }
    }

    public void g() {
        this.f252628c.getApp().unbindService(this.f252630e);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b extends f.a {
        b() {
        }

        @Override // com.tencent.mobileqq.nearby.ipc.f
        public BasicTypeDataParcel I4(BasicTypeDataParcel basicTypeDataParcel) throws RemoteException {
            if (basicTypeDataParcel == null) {
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.i("nearby_ipc_log_tag", 2, basicTypeDataParcel.toString());
            }
            Object[] d16 = e.this.d(basicTypeDataParcel.f252605d, basicTypeDataParcel.f252606e);
            if (d16 == null) {
                return null;
            }
            return new BasicTypeDataParcel(basicTypeDataParcel.f252605d, d16);
        }

        @Override // com.tencent.mobileqq.nearby.ipc.f
        public Message J2(Message message) throws RemoteException {
            if (message == null) {
                return null;
            }
            return e.this.c(message);
        }
    }
}
