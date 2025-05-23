package com.tencent.av.service;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface f extends IInterface {
    void E4(RecvGVideoLevelInfo[] recvGVideoLevelInfoArr) throws RemoteException;

    void K1(boolean z16, String str, String str2, String str3) throws RemoteException;

    Bundle U2(String str, int i3, int i16, Bundle bundle) throws RemoteException;

    void c1(String str, int i3, byte[] bArr) throws RemoteException;

    void j4(String str, int i3, int i16, byte[] bArr) throws RemoteException;

    void x2(RecvMsg recvMsg) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements f {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.av.service.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0745a implements f {

            /* renamed from: e, reason: collision with root package name */
            public static f f74374e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f74375d;

            C0745a(IBinder iBinder) {
                this.f74375d = iBinder;
            }

            @Override // com.tencent.av.service.f
            public void E4(RecvGVideoLevelInfo[] recvGVideoLevelInfoArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceCallback");
                    obtain.writeTypedArray(recvGVideoLevelInfoArr, 0);
                    if (!OaidMonitor.binderTransact(this.f74375d, 2, obtain, null, 1) && a.v() != null) {
                        a.v().E4(recvGVideoLevelInfoArr);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.f
            public void K1(boolean z16, String str, String str2, String str3) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceCallback");
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (!OaidMonitor.binderTransact(this.f74375d, 4, obtain, obtain2, 0) && a.v() != null) {
                        a.v().K1(z16, str, str2, str3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.f
            public Bundle U2(String str, int i3, int i16, Bundle bundle) throws RemoteException {
                Bundle bundle2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceCallback");
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f74375d, 5, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().U2(str, i3, i16, bundle);
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f74375d;
            }

            @Override // com.tencent.av.service.f
            public void c1(String str, int i3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceCallback");
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeByteArray(bArr);
                    if (!OaidMonitor.binderTransact(this.f74375d, 6, obtain, obtain2, 0) && a.v() != null) {
                        a.v().c1(str, i3, bArr);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.f
            public void j4(String str, int i3, int i16, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceCallback");
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeByteArray(bArr);
                    if (!OaidMonitor.binderTransact(this.f74375d, 3, obtain, obtain2, 0) && a.v() != null) {
                        a.v().j4(str, i3, i16, bArr);
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
            attachInterface(this, "com.tencent.av.service.IQQServiceCallback");
        }

        public static f j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.av.service.IQQServiceCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof f)) {
                return (f) queryLocalInterface;
            }
            return new C0745a(iBinder);
        }

        public static f v() {
            return C0745a.f74374e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                boolean z16 = false;
                RecvMsg recvMsg = null;
                Bundle bundle = null;
                switch (i3) {
                    case 1:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceCallback");
                        if (parcel.readInt() != 0) {
                            recvMsg = RecvMsg.CREATOR.createFromParcel(parcel);
                        }
                        x2(recvMsg);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceCallback");
                        E4((RecvGVideoLevelInfo[]) parcel.createTypedArray(RecvGVideoLevelInfo.CREATOR));
                        return true;
                    case 3:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceCallback");
                        j4(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceCallback");
                        if (parcel.readInt() != 0) {
                            z16 = true;
                        }
                        K1(z16, parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceCallback");
                        String readString = parcel.readString();
                        int readInt = parcel.readInt();
                        int readInt2 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        Bundle U2 = U2(readString, readInt, readInt2, bundle);
                        parcel2.writeNoException();
                        if (U2 != null) {
                            parcel2.writeInt(1);
                            U2.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 6:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceCallback");
                        c1(parcel.readString(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString("com.tencent.av.service.IQQServiceCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
