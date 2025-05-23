package com.tencent.mobileqq.nearby.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.nearby.ipc.f;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface d extends IInterface {
    BasicTypeDataParcel W2(BasicTypeDataParcel basicTypeDataParcel) throws RemoteException;

    void i3(f fVar) throws RemoteException;

    Message j3(Message message) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static abstract class a extends Binder implements d {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.nearby.ipc.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes33.dex */
        public static class C8138a implements d {

            /* renamed from: e, reason: collision with root package name */
            public static d f252624e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f252625d;

            C8138a(IBinder iBinder) {
                this.f252625d = iBinder;
            }

            @Override // com.tencent.mobileqq.nearby.ipc.d
            public BasicTypeDataParcel W2(BasicTypeDataParcel basicTypeDataParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
                    if (basicTypeDataParcel != null) {
                        obtain.writeInt(1);
                        basicTypeDataParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f252625d, 1, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().W2(basicTypeDataParcel);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? BasicTypeDataParcel.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f252625d;
            }

            @Override // com.tencent.mobileqq.nearby.ipc.d
            public void i3(f fVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
                    obtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                    if (!OaidMonitor.binderTransact(this.f252625d, 3, obtain, obtain2, 0) && a.v() != null) {
                        a.v().i3(fVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.nearby.ipc.d
            public Message j3(Message message) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
                    if (message != null) {
                        obtain.writeInt(1);
                        message.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f252625d, 2, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().j3(message);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Message) Message.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
        }

        public static d v() {
            return C8138a.f252624e;
        }

        public static d j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                return (d) queryLocalInterface;
            }
            return new C8138a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 == 1598968902) {
                parcel2.writeString("com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
                return true;
            }
            if (i3 == 1) {
                parcel.enforceInterface("com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
                BasicTypeDataParcel W2 = W2(parcel.readInt() != 0 ? BasicTypeDataParcel.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (W2 != null) {
                    parcel2.writeInt(1);
                    W2.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel.enforceInterface("com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
                i3(f.a.j(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface("com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
            Message j3 = j3(parcel.readInt() != 0 ? (Message) Message.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            if (j3 != null) {
                parcel2.writeInt(1);
                j3.writeToParcel(parcel2, 1);
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
