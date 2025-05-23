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
public interface u extends IInterface {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class a extends Binder implements u {

        /* compiled from: P */
        /* renamed from: com.tencent.tmsqmsp.oaid2.u$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        static class C10013a implements u {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f380889d;

            C10013a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f380889d = iBinder;
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.f380889d;
            }

            @Override // com.tencent.tmsqmsp.oaid2.u
            public final boolean h() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    boolean z16 = false;
                    OaidMonitor.binderTransact(this.f380889d, 2, obtain, obtain2, 0);
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

            @Override // com.tencent.tmsqmsp.oaid2.u
            public final String m() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    OaidMonitor.binderTransact(this.f380889d, 1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public static u a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof u)) {
                return (u) queryLocalInterface;
            }
            return new C10013a(iBinder);
        }
    }

    boolean h() throws RemoteException;

    String m() throws RemoteException;
}
