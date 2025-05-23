package com.tencent.mobileqq.ar.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface b extends IInterface {
    void H4(int i3, int i16) throws RemoteException;

    void R3(int i3) throws RemoteException;

    void X0(int i3, int i16) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static abstract class a extends Binder implements b {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.ar.aidl.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C7401a implements b {

            /* renamed from: e, reason: collision with root package name */
            public static b f197719e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f197720d;

            C7401a(IBinder iBinder) {
                this.f197720d = iBinder;
            }

            @Override // com.tencent.mobileqq.ar.aidl.b
            public void H4(int i3, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArFaceCallback");
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.f197720d, 3, obtain, obtain2, 0) && a.v() != null) {
                        a.v().H4(i3, i16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.ar.aidl.b
            public void R3(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArFaceCallback");
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f197720d, 1, obtain, obtain2, 0) && a.v() != null) {
                        a.v().R3(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.ar.aidl.b
            public void X0(int i3, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.ar.aidl.IArFaceCallback");
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.f197720d, 2, obtain, obtain2, 0) && a.v() != null) {
                        a.v().X0(i3, i16);
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
                return this.f197720d;
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mobileqq.ar.aidl.IArFaceCallback");
        }

        public static b j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.ar.aidl.IArFaceCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C7401a(iBinder);
        }

        public static b v() {
            return C7401a.f197719e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return super.onTransact(i3, parcel, parcel2, i16);
                        }
                        parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArFaceCallback");
                        H4(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    }
                    parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArFaceCallback");
                    X0(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface("com.tencent.mobileqq.ar.aidl.IArFaceCallback");
                R3(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("com.tencent.mobileqq.ar.aidl.IArFaceCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
