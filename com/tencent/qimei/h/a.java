package com.tencent.qimei.h;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface a extends IInterface {

    /* compiled from: P */
    /* renamed from: com.tencent.qimei.h.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static abstract class AbstractBinderC9322a extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f343286a = 0;

        /* compiled from: P */
        /* renamed from: com.tencent.qimei.h.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        public static class C9323a implements a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f343287a;

            public C9323a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f343287a = iBinder;
                }
            }

            @Override // com.tencent.qimei.h.a
            public boolean a() {
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
                        OaidMonitor.binderTransact(this.f343287a, 2, obtain, obtain2, 0);
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.f343287a;
            }

            @Override // com.tencent.qimei.h.a
            public String c() {
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
                        OaidMonitor.binderTransact(this.f343287a, 3, obtain, obtain2, 0);
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

            @Override // com.tencent.qimei.h.a
            public boolean d() {
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
                        OaidMonitor.binderTransact(this.f343287a, 1, obtain, obtain2, 0);
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

            @Override // com.tencent.qimei.h.a
            public void i() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.bun.lib.MsaIdInterface");
                        OaidMonitor.binderTransact(this.f343287a, 6, obtain, obtain2, 0);
                        obtain2.readException();
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qimei.h.a
            public String l() {
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
                        OaidMonitor.binderTransact(this.f343287a, 5, obtain, obtain2, 0);
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
        }
    }

    boolean a();

    String c();

    boolean d();

    void i();

    String l();
}
