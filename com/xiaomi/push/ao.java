package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.security.MessageDigest;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public class ao implements j {

    /* renamed from: f, reason: collision with root package name */
    private static boolean f388187f;

    /* renamed from: a, reason: collision with root package name */
    private Context f388188a;

    /* renamed from: b, reason: collision with root package name */
    private ServiceConnection f388189b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f388190c = 0;

    /* renamed from: d, reason: collision with root package name */
    private volatile c f388191d = null;

    /* renamed from: e, reason: collision with root package name */
    private final Object f388192e = new Object();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private class c {

        /* renamed from: a, reason: collision with root package name */
        String f388196a;

        /* renamed from: b, reason: collision with root package name */
        String f388197b;

        /* renamed from: c, reason: collision with root package name */
        String f388198c;

        /* renamed from: d, reason: collision with root package name */
        String f388199d;

        c() {
            this.f388196a = null;
            this.f388197b = null;
            this.f388198c = null;
            this.f388199d = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static class d {
        static String a(IBinder iBinder, String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                OaidMonitor.writeParcelToken(obtain, "com.heytap.openid.IOpenID");
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                OaidMonitor.binderTransact(iBinder, 1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                OaidMonitor.parcelRecycle(obtain2);
                OaidMonitor.parcelRecycle(obtain);
            }
        }
    }

    public ao(Context context) {
        this.f388188a = context;
        g();
    }

    private void g() {
        boolean z16;
        this.f388189b = new b();
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        int i3 = 1;
        try {
            z16 = this.f388188a.bindService(intent, this.f388189b, 1);
        } catch (Exception unused) {
            z16 = false;
        }
        if (!z16) {
            i3 = 2;
        }
        this.f388190c = i3;
    }

    private void i(String str) {
        if (this.f388190c == 1 && Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (this.f388192e) {
                try {
                    jz4.c.m("oppo's " + str + " wait...");
                    this.f388192e.wait(3000L);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static boolean j(Context context) {
        long j3;
        boolean z16;
        boolean z17;
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.heytap.openid", 128);
            if (packageInfo != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    j3 = packageInfo.getLongVersionCode();
                } else {
                    j3 = packageInfo.versionCode;
                }
                if ((packageInfo.applicationInfo.flags & 1) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (j3 >= 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                f388187f = z17;
                if (z16) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k() {
        try {
            Signature[] signatureArr = InstalledAppListMonitor.getPackageInfo(this.f388188a.getPackageManager(), this.f388188a.getPackageName(), 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : messageDigest.digest(signatureArr[0].toByteArray())) {
                sb5.append(Integer.toHexString((b16 & 255) | 256).substring(1, 3));
            }
            return sb5.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        ServiceConnection serviceConnection = this.f388189b;
        if (serviceConnection != null) {
            try {
                this.f388188a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.j
    /* renamed from: a */
    public boolean mo299a() {
        return f388187f;
    }

    @Override // com.xiaomi.push.j
    public String a() {
        i(com.tencent.luggage.wxa.q2.e.NAME);
        if (this.f388191d == null) {
            return null;
        }
        return this.f388191d.f388197b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            if (ao.this.f388191d != null) {
                return;
            }
            new BaseThread(new Runnable() { // from class: com.xiaomi.push.ao.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String packageName = ao.this.f388188a.getPackageName();
                        String k3 = ao.this.k();
                        c cVar = new c();
                        cVar.f388197b = d.a(iBinder, packageName, k3, "OUID");
                        ao.this.f388191d = cVar;
                        ao.this.l();
                        ao.this.f388190c = 2;
                        synchronized (ao.this.f388192e) {
                            try {
                                ao.this.f388192e.notifyAll();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        ao.this.l();
                        ao.this.f388190c = 2;
                        synchronized (ao.this.f388192e) {
                            try {
                                ao.this.f388192e.notifyAll();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable th5) {
                        ao.this.l();
                        ao.this.f388190c = 2;
                        synchronized (ao.this.f388192e) {
                            try {
                                ao.this.f388192e.notifyAll();
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
