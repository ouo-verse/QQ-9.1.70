package com.tencent.tfd.sdk.wxa;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.package, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Cpackage {

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.package$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static final class Cdo {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f375762a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f375763b;

        public Cdo(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16));
            } else {
                this.f375762a = str;
                this.f375763b = z16;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.package$if, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static final class Cif implements ServiceConnection {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f375764a;

        /* renamed from: b, reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f375765b;

        public Cif() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f375764a = false;
                this.f375765b = new LinkedBlockingQueue<>(1);
            }
        }

        public final IBinder a() throws InterruptedException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (IBinder) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            if (!this.f375764a) {
                this.f375764a = true;
                return this.f375765b.take();
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
            } else {
                try {
                    this.f375765b.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            }
        }
    }

    public static Cdo a(Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            boolean z16 = false;
            InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.android.vending", 0);
            Cif cif = new Cif();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, cif, 1)) {
                try {
                    IBinder a16 = cif.a();
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        OaidMonitor.binderTransact(a16, 1, obtain, obtain2, 0);
                        obtain2.readException();
                        String readString = obtain2.readString();
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        obtain = Parcel.obtain();
                        obtain2 = Parcel.obtain();
                        try {
                            OaidMonitor.writeParcelToken(obtain, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                            obtain.writeInt(1);
                            OaidMonitor.binderTransact(a16, 2, obtain, obtain2, 0);
                            obtain2.readException();
                            if (obtain2.readInt() != 0) {
                                z16 = true;
                            }
                            OaidMonitor.parcelRecycle(obtain2);
                            OaidMonitor.parcelRecycle(obtain);
                            return new Cdo(readString, z16);
                        } finally {
                        }
                    } finally {
                    }
                } catch (Exception unused) {
                } finally {
                    context.unbindService(cif);
                }
            }
        } catch (Exception unused2) {
        }
        return null;
    }
}
