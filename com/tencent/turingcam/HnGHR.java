package com.tencent.turingcam;

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
/* loaded from: classes27.dex */
public class HnGHR {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ShGzN implements ServiceConnection {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f381833a;

        /* renamed from: b, reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f381834b;

        public ShGzN() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f381833a = false;
                this.f381834b = new LinkedBlockingQueue<>(1);
            }
        }

        public IBinder a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (IBinder) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            if (!this.f381833a) {
                this.f381833a = true;
                return this.f381834b.take();
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
            } else {
                try {
                    this.f381834b.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class spXPg {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f381835a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f381836b;

        public spXPg(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16));
            } else {
                this.f381835a = str;
                this.f381836b = z16;
            }
        }
    }

    public static spXPg a() {
        Context context;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        synchronized (eh5ma.class) {
            context = eh5ma.f382207a;
        }
        try {
            boolean z16 = false;
            InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.android.vending", 0);
            ShGzN shGzN = new ShGzN();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, shGzN, 1)) {
                try {
                    IBinder a16 = shGzN.a();
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
                            return new spXPg(readString, z16);
                        } finally {
                        }
                    } finally {
                    }
                } catch (Exception unused) {
                } finally {
                    context.unbindService(shGzN);
                }
            }
        } catch (Exception unused2) {
        }
        return null;
    }
}
