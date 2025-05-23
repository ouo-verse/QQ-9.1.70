package com.tencent.turingcam;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface Gc2mM extends IInterface {
    int a();

    int a(int i3);

    Ykk0n b(int i3);

    boolean c(int i3);

    int d(int i3);

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class spXPg extends Binder implements Gc2mM {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final String f381831a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15864);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f381831a = LwgsO.a(LwgsO.M0);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.turingcam.Gc2mM$spXPg$spXPg, reason: collision with other inner class name */
        /* loaded from: classes27.dex */
        public static class C10025spXPg implements Gc2mM {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f381832a;

            public C10025spXPg(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f381832a = iBinder;
                }
            }

            @Override // com.tencent.turingcam.Gc2mM
            public int a(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, spXPg.f381831a);
                    obtain.writeInt(i3);
                    OaidMonitor.binderTransact(this.f381832a, 7, obtain, obtain2, 0);
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
                return this.f381832a;
            }

            @Override // com.tencent.turingcam.Gc2mM
            public Ykk0n b(int i3) {
                Ykk0n ykk0n;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (Ykk0n) iPatchRedirector.redirect((short) 4, (Object) this, i3);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, spXPg.f381831a);
                    obtain.writeInt(i3);
                    OaidMonitor.binderTransact(this.f381832a, 2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        ykk0n = new Ykk0n(obtain2);
                    } else {
                        ykk0n = null;
                    }
                    return ykk0n;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.turingcam.Gc2mM
            public boolean c(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, spXPg.f381831a);
                    obtain.writeInt(i3);
                    boolean z16 = false;
                    OaidMonitor.binderTransact(this.f381832a, 3, obtain, obtain2, 0);
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

            @Override // com.tencent.turingcam.Gc2mM
            public int d(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, spXPg.f381831a);
                    obtain.writeInt(i3);
                    OaidMonitor.binderTransact(this.f381832a, 1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.turingcam.Gc2mM
            public int a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, spXPg.f381831a);
                    OaidMonitor.binderTransact(this.f381832a, 12, obtain, obtain2, 0);
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
