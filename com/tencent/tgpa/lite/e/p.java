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
public interface p extends IInterface {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class a extends Binder implements p {

        /* compiled from: P */
        /* renamed from: com.tencent.tgpa.lite.e.p$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        private static class C9912a implements p {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            private IBinder f375960a;

            C9912a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f375960a = iBinder;
                }
            }

            @Override // com.tencent.tgpa.lite.e.p
            public String a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.samsung.android.deviceidservice.IDeviceIdService");
                        OaidMonitor.binderTransact(this.f375960a, 1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        return "";
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return this.f375960a;
            }
        }

        public static p a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof p)) {
                return (p) queryLocalInterface;
            }
            return new C9912a(iBinder);
        }
    }

    String a();
}
