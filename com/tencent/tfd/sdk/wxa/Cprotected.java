package com.tencent.tfd.sdk.wxa;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.protected, reason: invalid class name */
/* loaded from: classes26.dex */
public interface Cprotected extends IInterface {

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.protected$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static abstract class Cdo extends Binder implements Cprotected {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final String f375767a;

        /* compiled from: P */
        /* renamed from: com.tencent.tfd.sdk.wxa.protected$do$do, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes26.dex */
        public static class C9904do implements Cprotected {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f375768a;

            public C9904do(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f375768a = iBinder;
                }
            }

            @Override // com.tencent.tfd.sdk.wxa.Cprotected
            public final int a() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Cdo.f375767a);
                    OaidMonitor.binderTransact(this.f375768a, 12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.f375768a;
            }

            @Override // com.tencent.tfd.sdk.wxa.Cprotected
            public final boolean b() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Cdo.f375767a);
                    obtain.writeInt(2000);
                    boolean z16 = false;
                    OaidMonitor.binderTransact(this.f375768a, 3, obtain, obtain2, 0);
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

            @Override // com.tencent.tfd.sdk.wxa.Cprotected
            public final int c() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Cdo.f375767a);
                    obtain.writeInt(2000);
                    OaidMonitor.binderTransact(this.f375768a, 1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tfd.sdk.wxa.Cprotected
            public final Arbutus d() throws RemoteException {
                Arbutus arbutus;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (Arbutus) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Cdo.f375767a);
                    obtain.writeInt(2000);
                    OaidMonitor.binderTransact(this.f375768a, 2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        arbutus = new Arbutus(obtain2);
                    } else {
                        arbutus = null;
                    }
                    return arbutus;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tfd.sdk.wxa.Cprotected
            public final int e() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Cdo.f375767a);
                    obtain.writeInt(2000);
                    OaidMonitor.binderTransact(this.f375768a, 7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62877);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f375767a = Cswitch.a(Cswitch.L0);
            }
        }
    }

    int a() throws RemoteException;

    boolean b() throws RemoteException;

    int c() throws RemoteException;

    Arbutus d() throws RemoteException;

    int e() throws RemoteException;
}
