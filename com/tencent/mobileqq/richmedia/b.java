package com.tencent.mobileqq.richmedia;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface b extends IInterface {
    void A4(CompressInfo compressInfo) throws RemoteException;

    Bundle C1(int i3, Bundle bundle) throws RemoteException;

    void M4(int i3, Bundle bundle) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static abstract class a extends Binder implements b {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.richmedia.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public static class C8515a implements b {

            /* renamed from: e, reason: collision with root package name */
            public static b f281325e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f281326d;

            C8515a(IBinder iBinder) {
                this.f281326d = iBinder;
            }

            @Override // com.tencent.mobileqq.richmedia.b
            public void A4(CompressInfo compressInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.richmedia.ICallBack");
                    if (compressInfo != null) {
                        obtain.writeInt(1);
                        compressInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f281326d, 2, obtain, obtain2, 0) && a.v() != null) {
                        a.v().A4(compressInfo);
                        return;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        compressInfo.a(obtain2);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.richmedia.b
            public Bundle C1(int i3, Bundle bundle) throws RemoteException {
                Bundle bundle2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.richmedia.ICallBack");
                    obtain.writeInt(i3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f281326d, 1, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().C1(i3, bundle);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle2 = null;
                    }
                    return bundle2;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.richmedia.b
            public void M4(int i3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.richmedia.ICallBack");
                    obtain.writeInt(i3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f281326d, 3, obtain, obtain2, 0) && a.v() != null) {
                        a.v().M4(i3, bundle);
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
                return this.f281326d;
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mobileqq.richmedia.ICallBack");
        }

        public static b j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.richmedia.ICallBack");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C8515a(iBinder);
        }

        public static b v() {
            return C8515a.f281325e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                Bundle bundle = null;
                Bundle bundle2 = null;
                CompressInfo compressInfo = null;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return super.onTransact(i3, parcel, parcel2, i16);
                        }
                        parcel.enforceInterface("com.tencent.mobileqq.richmedia.ICallBack");
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        M4(readInt, bundle2);
                        parcel2.writeNoException();
                        return true;
                    }
                    parcel.enforceInterface("com.tencent.mobileqq.richmedia.ICallBack");
                    if (parcel.readInt() != 0) {
                        compressInfo = CompressInfo.CREATOR.createFromParcel(parcel);
                    }
                    A4(compressInfo);
                    parcel2.writeNoException();
                    if (compressInfo != null) {
                        parcel2.writeInt(1);
                        compressInfo.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                }
                parcel.enforceInterface("com.tencent.mobileqq.richmedia.ICallBack");
                int readInt2 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                Bundle C1 = C1(readInt2, bundle);
                parcel2.writeNoException();
                if (C1 != null) {
                    parcel2.writeInt(1);
                    C1.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            parcel2.writeString("com.tencent.mobileqq.richmedia.ICallBack");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
