package com.tencent.tmsqmsp.oaid2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface q0 extends IInterface {
    String a();

    String a(String str);

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class a extends Binder implements q0 {
        public static q0 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof q0)) {
                return (q0) queryLocalInterface;
            }
            return new C10012a(iBinder);
        }

        /* compiled from: P */
        /* renamed from: com.tencent.tmsqmsp.oaid2.q0$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        static class C10012a implements q0 {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f380865d;

            C10012a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f380865d = iBinder;
                }
            }

            @Override // com.tencent.tmsqmsp.oaid2.q0
            public final String a(String str) {
                String str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.samsung.android.deviceidservice.IDeviceIdService");
                        obtain.writeString(str);
                        OaidMonitor.binderTransact(this.f380865d, 3, obtain, obtain2, 0);
                        obtain2.readException();
                        str2 = obtain2.readString();
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        str2 = null;
                    }
                    return str2;
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
                return this.f380865d;
            }

            @Override // com.tencent.tmsqmsp.oaid2.q0
            public final String a() {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (String) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.samsung.android.deviceidservice.IDeviceIdService");
                        OaidMonitor.binderTransact(this.f380865d, 1, obtain, obtain2, 0);
                        obtain2.readException();
                        str = obtain2.readString();
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        str = null;
                    }
                    return str;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }
    }
}
