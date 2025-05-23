package com.tencent.qmsp.oaid2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface y extends IInterface {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static abstract class a extends Binder implements y {

        /* compiled from: P */
        /* renamed from: com.tencent.qmsp.oaid2.y$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        private static class C9346a implements y {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            private IBinder f344314a;

            C9346a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f344314a = iBinder;
                }
            }

            @Override // com.tencent.qmsp.oaid2.y
            public String a() {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (String) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.bun.lib.MsaIdInterface");
                        OaidMonitor.binderTransact(this.f344314a, 3, obtain, obtain2, 0);
                        obtain2.readException();
                        str = obtain2.readString();
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        str = "";
                    }
                    return str;
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
                return this.f344314a;
            }

            @Override // com.tencent.qmsp.oaid2.y
            public boolean c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                boolean z16 = false;
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.bun.lib.MsaIdInterface");
                        OaidMonitor.binderTransact(this.f344314a, 2, obtain, obtain2, 0);
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z16 = true;
                        }
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qmsp.oaid2.y
            public String d() {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (String) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.bun.lib.MsaIdInterface");
                        OaidMonitor.binderTransact(this.f344314a, 5, obtain, obtain2, 0);
                        obtain2.readException();
                        str = obtain2.readString();
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        str = "";
                    }
                    return str;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qmsp.oaid2.y
            public void f() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.bun.lib.MsaIdInterface");
                    OaidMonitor.binderTransact(this.f344314a, 6, obtain, obtain2, 0);
                    obtain2.readException();
                } catch (RemoteException e16) {
                    e16.printStackTrace();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qmsp.oaid2.y
            public boolean g() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                boolean z16 = false;
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.bun.lib.MsaIdInterface");
                        OaidMonitor.binderTransact(this.f344314a, 1, obtain, obtain2, 0);
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z16 = true;
                        }
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public static y a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof y)) {
                return (y) queryLocalInterface;
            }
            return new C9346a(iBinder);
        }
    }

    String a();

    boolean c();

    String d();

    void f();

    boolean g();
}
