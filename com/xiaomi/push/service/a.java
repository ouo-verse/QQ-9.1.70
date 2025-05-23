package com.xiaomi.push.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.xiaomi.push.fm;
import com.xiaomi.push.hz;
import com.xiaomi.push.ii;
import com.xiaomi.push.io;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: h, reason: collision with root package name */
    private static a f389545h;

    /* renamed from: i, reason: collision with root package name */
    private static String f389546i = fm.a(5) + "-";

    /* renamed from: j, reason: collision with root package name */
    private static long f389547j = 0;

    /* renamed from: a, reason: collision with root package name */
    private Context f389548a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f389550c;

    /* renamed from: g, reason: collision with root package name */
    private Messenger f389554g;

    /* renamed from: b, reason: collision with root package name */
    private Messenger f389549b = null;

    /* renamed from: d, reason: collision with root package name */
    private final BroadcastReceiver f389551d = new C10090a();

    /* renamed from: e, reason: collision with root package name */
    private List<Message> f389552e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private boolean f389553f = false;

    /* compiled from: P */
    /* renamed from: com.xiaomi.push.service.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    class C10090a extends BroadcastReceiver {
        C10090a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.push.au.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.this) {
                a.this.f389554g = new Messenger(iBinder);
                a.this.f389553f = false;
                Iterator it = a.this.f389552e.iterator();
                while (it.hasNext()) {
                    try {
                        a.this.f389554g.send((Message) it.next());
                    } catch (RemoteException e16) {
                        jz4.c.q(e16);
                    }
                }
                a.this.f389552e.clear();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            a.this.f389554g = null;
            a.this.f389553f = false;
        }
    }

    a(Context context) {
        this.f389550c = false;
        Context applicationContext = context.getApplicationContext();
        this.f389548a = applicationContext;
        ii.e(applicationContext);
        e(this.f389548a);
        if (g()) {
            jz4.c.z("use miui push service");
            this.f389550c = true;
        }
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    private void e(Context context) {
        try {
            com.xiaomi.push.au.i(context);
        } catch (Throwable th5) {
            jz4.c.m("add network status listener failed:" + th5);
        }
    }

    private synchronized void f(Intent intent) {
        if (this.f389553f) {
            Message a16 = a(intent);
            if (this.f389552e.size() >= 50) {
                this.f389552e.remove(0);
            }
            this.f389552e.add(a16);
            return;
        }
        if (this.f389554g == null) {
            this.f389548a.bindService(intent, new b(), 1);
            this.f389553f = true;
            this.f389552e.clear();
            this.f389552e.add(a(intent));
        } else {
            try {
                this.f389554g.send(a(intent));
            } catch (RemoteException unused) {
                this.f389554g = null;
                this.f389553f = false;
            }
        }
    }

    private boolean g() {
        if (io.f389427b) {
            return false;
        }
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(this.f389548a.getPackageManager(), "com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            if (packageInfo.versionCode < 104) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static a i(Context context) {
        if (f389545h == null) {
            f389545h = new a(context);
        }
        return f389545h;
    }

    public boolean j(Intent intent) {
        try {
            if (!hz.i() && Build.VERSION.SDK_INT >= 26) {
                f(intent);
                return true;
            }
            this.f389548a.startService(intent);
            return true;
        } catch (Exception e16) {
            jz4.c.q(e16);
            return false;
        }
    }
}
