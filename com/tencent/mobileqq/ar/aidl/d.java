package com.tencent.mobileqq.ar.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface d extends IInterface {
    void F(int i3) throws RemoteException;

    void p() throws RemoteException;

    void t() throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static abstract class a extends Binder implements d {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.ar.aidl.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C7403a implements d {

            /* renamed from: e, reason: collision with root package name */
            public static d f197723e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f197724d;

            C7403a(IBinder iBinder) {
                this.f197724d = iBinder;
            }

            @Override // com.tencent.mobileqq.ar.aidl.d
            public void F(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArSoCallback");
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f197724d, 3, obtain, obtain2, 0) && a.v() != null) {
                        a.v().F(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f197724d;
            }

            @Override // com.tencent.mobileqq.ar.aidl.d
            public void p() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArSoCallback");
                    if (!OaidMonitor.binderTransact(this.f197724d, 2, obtain, obtain2, 0) && a.v() != null) {
                        a.v().p();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.ar.aidl.d
            public void t() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArSoCallback");
                    if (!OaidMonitor.binderTransact(this.f197724d, 1, obtain, obtain2, 0) && a.v() != null) {
                        a.v().t();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mobileqq.ar.aidl.IArSoCallback");
        }

        public static d j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.ar.aidl.IArSoCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                return (d) queryLocalInterface;
            }
            return new C7403a(iBinder);
        }

        public static d v() {
            return C7403a.f197723e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return super.onTransact(i3, parcel, parcel2, i16);
                        }
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArSoCallback");
                        F(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    }
                    parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArSoCallback");
                    p();
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArSoCallback");
                t();
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("com.tencent.mobileqq.ar.aidl.IArSoCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
