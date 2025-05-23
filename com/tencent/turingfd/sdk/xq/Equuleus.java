package com.tencent.turingfd.sdk.xq;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface Equuleus extends IInterface {
    int a() throws RemoteException;

    int a(int i3) throws RemoteException;

    int b(int i3) throws RemoteException;

    boolean c(int i3) throws RemoteException;

    Pear d(int i3) throws RemoteException;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Equuleus$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static abstract class Cdo extends Binder implements Equuleus {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final String f382737a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11597);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f382737a = Ccontinue.a(Ccontinue.M0);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.turingfd.sdk.xq.Equuleus$do$do, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes27.dex */
        public static class C10031do implements Equuleus {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f382738a;

            public C10031do(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f382738a = iBinder;
                }
            }

            @Override // com.tencent.turingfd.sdk.xq.Equuleus
            public int a(int i3) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Cdo.f382737a);
                    obtain.writeInt(i3);
                    OaidMonitor.binderTransact(this.f382738a, 7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.f382738a;
            }

            @Override // com.tencent.turingfd.sdk.xq.Equuleus
            public int b(int i3) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Cdo.f382737a);
                    obtain.writeInt(i3);
                    OaidMonitor.binderTransact(this.f382738a, 1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.turingfd.sdk.xq.Equuleus
            public boolean c(int i3) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Cdo.f382737a);
                    obtain.writeInt(i3);
                    boolean z16 = false;
                    OaidMonitor.binderTransact(this.f382738a, 3, obtain, obtain2, 0);
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

            @Override // com.tencent.turingfd.sdk.xq.Equuleus
            public Pear d(int i3) throws RemoteException {
                Pear pear;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (Pear) iPatchRedirector.redirect((short) 4, (Object) this, i3);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Cdo.f382737a);
                    obtain.writeInt(i3);
                    OaidMonitor.binderTransact(this.f382738a, 2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        pear = new Pear(obtain2);
                    } else {
                        pear = null;
                    }
                    return pear;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.turingfd.sdk.xq.Equuleus
            public int a() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Cdo.f382737a);
                    OaidMonitor.binderTransact(this.f382738a, 12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }
    }
}
