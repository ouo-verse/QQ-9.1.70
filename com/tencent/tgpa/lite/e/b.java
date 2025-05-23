package com.tencent.tgpa.lite.e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface b extends IInterface {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class a extends Binder implements b {

        /* compiled from: P */
        /* renamed from: com.tencent.tgpa.lite.e.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static class C9907a implements b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f375920a;

            public C9907a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f375920a = iBinder;
                }
            }

            @Override // com.tencent.tgpa.lite.e.b
            public boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    OaidMonitor.binderTransact(this.f375920a, 1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        return false;
                    }
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return true;
                } finally {
                    try {
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        return false;
                    }
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return this.f375920a;
            }

            @Override // com.tencent.tgpa.lite.e.b
            public String b() {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (String) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    OaidMonitor.binderTransact(this.f375920a, 3, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return str;
                } catch (Throwable th5) {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    try {
                        throw th5;
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                        str = null;
                    }
                }
            }
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C9907a(iBinder);
        }
    }

    boolean a();

    String b();
}
