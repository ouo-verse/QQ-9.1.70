package com.tencent.qimei.f;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface d extends IInterface {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static abstract class a extends Binder implements d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f343272a = 0;

        /* compiled from: P */
        /* renamed from: com.tencent.qimei.f.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        public static class C9319a implements d {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f343273a;

            public C9319a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f343273a = iBinder;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.f343273a;
            }

            @Override // com.tencent.qimei.f.d
            public boolean j() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    boolean z16 = false;
                    OaidMonitor.binderTransact(this.f343273a, 2, obtain, obtain2, 0);
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

            @Override // com.tencent.qimei.f.d
            public String m() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    OaidMonitor.binderTransact(this.f343273a, 1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }
    }

    boolean j() throws RemoteException;

    String m() throws RemoteException;
}
