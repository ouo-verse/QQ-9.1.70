package com.tencent.mobileqq.nearby.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface f extends IInterface {
    BasicTypeDataParcel I4(BasicTypeDataParcel basicTypeDataParcel) throws RemoteException;

    Message J2(Message message) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static abstract class a extends Binder implements f {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.nearby.ipc.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes33.dex */
        public static class C8139a implements f {

            /* renamed from: e, reason: collision with root package name */
            public static f f252634e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f252635d;

            C8139a(IBinder iBinder) {
                this.f252635d = iBinder;
            }

            @Override // com.tencent.mobileqq.nearby.ipc.f
            public BasicTypeDataParcel I4(BasicTypeDataParcel basicTypeDataParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
                    if (basicTypeDataParcel != null) {
                        obtain.writeInt(1);
                        basicTypeDataParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f252635d, 1, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().I4(basicTypeDataParcel);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? BasicTypeDataParcel.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.nearby.ipc.f
            public Message J2(Message message) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
                    if (message != null) {
                        obtain.writeInt(1);
                        message.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f252635d, 2, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().J2(message);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Message) Message.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f252635d;
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
        }

        public static f v() {
            return C8139a.f252634e;
        }

        public static f j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof f)) {
                return (f) queryLocalInterface;
            }
            return new C8139a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 == 1598968902) {
                parcel2.writeString("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
                return true;
            }
            if (i3 == 1) {
                parcel.enforceInterface("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
                BasicTypeDataParcel I4 = I4(parcel.readInt() != 0 ? BasicTypeDataParcel.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (I4 != null) {
                    parcel2.writeInt(1);
                    I4.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i3 != 2) {
                return super.onTransact(i3, parcel, parcel2, i16);
            }
            parcel.enforceInterface("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
            Message J2 = J2(parcel.readInt() != 0 ? (Message) Message.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            if (J2 != null) {
                parcel2.writeInt(1);
                J2.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
