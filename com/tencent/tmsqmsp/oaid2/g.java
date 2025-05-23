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
public interface g extends IInterface {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class a extends Binder implements g {

        /* compiled from: P */
        /* renamed from: com.tencent.tmsqmsp.oaid2.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        static class C10009a implements g {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f380813d;

            C10009a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f380813d = iBinder;
                }
            }

            @Override // com.tencent.tmsqmsp.oaid2.g
            public final String a(String str) {
                String str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.coolpad.deviceidsupport.IDeviceIdManager");
                        obtain.writeString(str);
                        OaidMonitor.binderTransact(this.f380813d, 4, obtain, obtain2, 0);
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
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (IBinder) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                return null;
            }

            @Override // com.tencent.tmsqmsp.oaid2.g
            public final String b(String str) {
                String str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.coolpad.deviceidsupport.IDeviceIdManager");
                        obtain.writeString(str);
                        OaidMonitor.binderTransact(this.f380813d, 2, obtain, obtain2, 0);
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
        }

        public static g a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof g)) {
                return (g) queryLocalInterface;
            }
            return new C10009a(iBinder);
        }
    }

    String a(String str);

    String b(String str);
}
