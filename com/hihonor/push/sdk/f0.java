package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.b0;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.z;

/* compiled from: P */
/* loaded from: classes2.dex */
public class f0 implements ServiceConnection {

    /* renamed from: e, reason: collision with root package name */
    public static final Object f36374e = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final RemoteServiceBean f36375a;

    /* renamed from: b, reason: collision with root package name */
    public a f36376b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f36377c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f36378d = false;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a {
    }

    public f0(RemoteServiceBean remoteServiceBean) {
        this.f36375a = remoteServiceBean;
    }

    public final void a(int i3) {
        a aVar = this.f36376b;
        if (aVar != null) {
            c0 c0Var = (c0) aVar;
            c0Var.f36361a.f36364a.set(i3 == HonorPushErrorEnum.ERROR_SERVICE_TIME_OUT.statusCode ? 2 : 1);
            c0Var.f36361a.a(i3);
            c0Var.f36361a.f36365b = null;
        }
    }

    public void b() {
        try {
            Log.i("AIDLSrvConnection", "trying to unbind service from " + this);
            l.f36402e.a().unbindService(this);
        } catch (Exception e16) {
            e16.getMessage();
        }
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        Log.i("AIDLSrvConnection", "enter onNullBinding, than unBind.");
        if (this.f36378d) {
            this.f36378d = false;
            return;
        }
        b();
        a();
        a aVar = this.f36376b;
        if (aVar != null) {
            c0 c0Var = (c0) aVar;
            c0Var.f36361a.f36364a.set(1);
            c0Var.f36361a.a(8002005);
            c0Var.f36361a.f36365b = null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.i("AIDLSrvConnection", "enter onServiceConnected.");
        a();
        a aVar = this.f36376b;
        if (aVar != null) {
            c0 c0Var = (c0) aVar;
            c0Var.f36361a.f36365b = IPushInvoke.Stub.asInterface(iBinder);
            if (c0Var.f36361a.f36365b == null) {
                c0Var.f36361a.f36367d.b();
                c0Var.f36361a.f36364a.set(1);
                c0Var.f36361a.a(8002001);
                return;
            }
            c0Var.f36361a.f36364a.set(3);
            b0.a aVar2 = c0Var.f36361a.f36366c;
            if (aVar2 != null) {
                z.a aVar3 = (z.a) aVar2;
                if (Looper.myLooper() == z.this.f36461a.getLooper()) {
                    aVar3.b();
                } else {
                    z.this.f36461a.post(new x(aVar3));
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.i("AIDLSrvConnection", "enter onServiceDisconnected.");
        a aVar = this.f36376b;
        if (aVar != null) {
            c0 c0Var = (c0) aVar;
            c0Var.f36361a.f36364a.set(1);
            c0Var.f36361a.a(8002002);
            c0Var.f36361a.f36365b = null;
        }
    }

    public final void a() {
        synchronized (f36374e) {
            Handler handler = this.f36377c;
            if (handler != null) {
                handler.removeMessages(1001);
                this.f36377c = null;
            }
        }
    }
}
