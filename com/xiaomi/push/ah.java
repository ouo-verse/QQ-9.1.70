package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public class ah implements j {

    /* renamed from: h, reason: collision with root package name */
    private static boolean f388158h;

    /* renamed from: a, reason: collision with root package name */
    private Context f388159a;

    /* renamed from: b, reason: collision with root package name */
    private ServiceConnection f388160b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f388161c = 0;

    /* renamed from: d, reason: collision with root package name */
    private volatile String f388162d = null;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f388163e = false;

    /* renamed from: f, reason: collision with root package name */
    private volatile String f388164f = null;

    /* renamed from: g, reason: collision with root package name */
    private final Object f388165g = new Object();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static class c {
        static String a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                OaidMonitor.writeParcelToken(obtain, "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                OaidMonitor.binderTransact(iBinder, 1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                OaidMonitor.parcelRecycle(obtain2);
                OaidMonitor.parcelRecycle(obtain);
            }
        }

        static boolean b(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                OaidMonitor.writeParcelToken(obtain, "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                boolean z16 = false;
                OaidMonitor.binderTransact(iBinder, 2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    z16 = true;
                }
                return z16;
            } finally {
                OaidMonitor.parcelRecycle(obtain2);
                OaidMonitor.parcelRecycle(obtain);
            }
        }
    }

    public ah(Context context) {
        this.f388159a = context;
        d();
    }

    private void d() {
        boolean z16;
        this.f388160b = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        int i3 = 1;
        try {
            z16 = this.f388159a.bindService(intent, this.f388160b, 1);
        } catch (Exception unused) {
            z16 = false;
        }
        if (!z16) {
            i3 = 2;
        }
        this.f388161c = i3;
    }

    private void f(String str) {
        if (this.f388161c == 1 && Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (this.f388165g) {
                try {
                    jz4.c.m("huawei's " + str + " wait...");
                    this.f388165g.wait(3000L);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static boolean g(Context context) {
        boolean z16;
        boolean z17;
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.huawei.hwid", 128);
            if ((packageInfo.applicationInfo.flags & 1) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (packageInfo.versionCode >= 20602000) {
                z17 = true;
            } else {
                z17 = false;
            }
            f388158h = z17;
        } catch (Exception unused) {
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        ServiceConnection serviceConnection = this.f388160b;
        if (serviceConnection != null) {
            try {
                this.f388159a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.j
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo299a() {
        return f388158h;
    }

    @Override // com.xiaomi.push.j
    public String a() {
        f(com.tencent.luggage.wxa.q2.e.NAME);
        return this.f388162d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            new BaseThread(new Runnable() { // from class: com.xiaomi.push.ah.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ah.this.f388162d = c.a(iBinder);
                        ah.this.f388163e = c.b(iBinder);
                        ah.this.i();
                        ah.this.f388161c = 2;
                        synchronized (ah.this.f388165g) {
                            try {
                                ah.this.f388165g.notifyAll();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        ah.this.i();
                        ah.this.f388161c = 2;
                        synchronized (ah.this.f388165g) {
                            try {
                                ah.this.f388165g.notifyAll();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable th5) {
                        ah.this.i();
                        ah.this.f388161c = 2;
                        synchronized (ah.this.f388165g) {
                            try {
                                ah.this.f388165g.notifyAll();
                            } catch (Exception unused4) {
                            }
                            throw th5;
                        }
                    }
                }
            }).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
