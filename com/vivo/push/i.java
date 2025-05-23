package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.vivo.push.util.ag;
import com.vivo.vms.IPCInvoke;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class i implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f387709a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, i> f387710b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private boolean f387711c;

    /* renamed from: d, reason: collision with root package name */
    private String f387712d;

    /* renamed from: e, reason: collision with root package name */
    private Context f387713e;

    /* renamed from: g, reason: collision with root package name */
    private volatile IPCInvoke f387715g;

    /* renamed from: i, reason: collision with root package name */
    private String f387717i;

    /* renamed from: j, reason: collision with root package name */
    private Handler f387718j;

    /* renamed from: h, reason: collision with root package name */
    private Object f387716h = new Object();

    /* renamed from: f, reason: collision with root package name */
    private AtomicInteger f387714f = new AtomicInteger(1);

    i(Context context, String str) {
        this.f387712d = null;
        this.f387718j = null;
        this.f387713e = context;
        this.f387717i = str;
        this.f387718j = new Handler(Looper.getMainLooper(), new j(this));
        String a16 = com.vivo.push.util.aa.a(context);
        this.f387712d = a16;
        if (!TextUtils.isEmpty(a16) && !TextUtils.isEmpty(this.f387717i)) {
            this.f387711c = ag.a(context, this.f387712d) >= 1260;
            b();
            return;
        }
        com.vivo.push.util.u.c(this.f387713e, "init error : push pkgname is " + this.f387712d + " ; action is " + this.f387717i);
        this.f387711c = false;
    }

    private void d() {
        this.f387718j.removeMessages(1);
        this.f387718j.sendEmptyMessageDelayed(1, 3000L);
    }

    private void e() {
        this.f387718j.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            this.f387713e.unbindService(this);
        } catch (Exception e16) {
            com.vivo.push.util.u.a("AidlManager", "On unBindServiceException:" + e16.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        com.vivo.push.util.u.b("AidlManager", "onBindingDied : ".concat(String.valueOf(componentName)));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e();
        this.f387715g = IPCInvoke.Stub.asInterface(iBinder);
        if (this.f387715g == null) {
            com.vivo.push.util.u.d("AidlManager", "onServiceConnected error : aidl must not be null.");
            f();
            this.f387714f.set(1);
            return;
        }
        if (this.f387714f.get() == 2) {
            a(4);
        } else if (this.f387714f.get() != 4) {
            f();
        }
        synchronized (this.f387716h) {
            this.f387716h.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f387715g = null;
        a(1);
    }

    public static i a(Context context, String str) {
        i iVar = f387710b.get(str);
        if (iVar == null) {
            synchronized (f387709a) {
                iVar = f387710b.get(str);
                if (iVar == null) {
                    iVar = new i(context, str);
                    f387710b.put(str, iVar);
                }
            }
        }
        return iVar;
    }

    private void b() {
        int i3 = this.f387714f.get();
        com.vivo.push.util.u.d("AidlManager", "Enter connect, Connection Status: ".concat(String.valueOf(i3)));
        if (i3 == 4 || i3 == 2 || i3 == 3 || i3 == 5 || !this.f387711c) {
            return;
        }
        a(2);
        if (!c()) {
            a(1);
            com.vivo.push.util.u.a("AidlManager", "bind core service fail");
        } else {
            d();
        }
    }

    private boolean c() {
        Intent intent = new Intent(this.f387717i);
        intent.setPackage(this.f387712d);
        try {
            return this.f387713e.bindService(intent, this, 1);
        } catch (Exception e16) {
            com.vivo.push.util.u.a("AidlManager", "bind core error", e16);
            return false;
        }
    }

    public final boolean a() {
        String a16 = com.vivo.push.util.aa.a(this.f387713e);
        this.f387712d = a16;
        if (TextUtils.isEmpty(a16)) {
            com.vivo.push.util.u.c(this.f387713e, "push pkgname is null");
            return false;
        }
        boolean z16 = ag.a(this.f387713e, this.f387712d) >= 1260;
        this.f387711c = z16;
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3) {
        this.f387714f.set(i3);
    }

    public final boolean a(Bundle bundle) {
        b();
        if (this.f387714f.get() == 2) {
            synchronized (this.f387716h) {
                try {
                    this.f387716h.wait(2000L);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
        }
        try {
            int i3 = this.f387714f.get();
            if (i3 == 4) {
                this.f387718j.removeMessages(2);
                this.f387718j.sendEmptyMessageDelayed(2, 30000L);
                this.f387715g.asyncCall(bundle, null);
                return true;
            }
            com.vivo.push.util.u.d("AidlManager", "invoke error : connect status = ".concat(String.valueOf(i3)));
            return false;
        } catch (Exception e17) {
            com.vivo.push.util.u.a("AidlManager", "invoke error ", e17);
            int i16 = this.f387714f.get();
            com.vivo.push.util.u.d("AidlManager", "Enter disconnect, Connection Status: ".concat(String.valueOf(i16)));
            if (i16 == 2) {
                e();
                a(1);
                return false;
            }
            if (i16 == 3) {
                a(1);
                return false;
            }
            if (i16 != 4) {
                return false;
            }
            a(1);
            f();
            return false;
        }
    }
}
