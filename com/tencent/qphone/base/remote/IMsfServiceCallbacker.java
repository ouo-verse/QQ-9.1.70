package com.tencent.qphone.base.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IMsfServiceCallbacker extends IInterface {
    public static final String DESCRIPTOR = "com.tencent.qphone.base.remote.IMsfServiceCallbacker";

    void onFirstPkgResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, int i3, int i16, int i17) throws RemoteException;

    void onNextPkgResp(int i3, int i16, byte[] bArr) throws RemoteException;

    void onReceiveFirstPkgPushResp(FromServiceMsg fromServiceMsg, int i3, int i16, int i17) throws RemoteException;

    void onReceiveNextPkgPushResp(int i3, int i16, byte[] bArr) throws RemoteException;

    void onReceivePushResp(FromServiceMsg fromServiceMsg) throws RemoteException;

    void onResponse(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static abstract class Stub extends Binder implements IMsfServiceCallbacker {
        static final int TRANSACTION_onFirstPkgResp = 2;
        static final int TRANSACTION_onNextPkgResp = 3;
        static final int TRANSACTION_onReceiveFirstPkgPushResp = 5;
        static final int TRANSACTION_onReceiveNextPkgPushResp = 6;
        static final int TRANSACTION_onReceivePushResp = 4;
        static final int TRANSACTION_onResponse = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes22.dex */
        public static class Proxy implements IMsfServiceCallbacker {
            public static IMsfServiceCallbacker sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IMsfServiceCallbacker.DESCRIPTOR;
            }

            @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
            public void onFirstPkgResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, int i3, int i16, int i17) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IMsfServiceCallbacker.DESCRIPTOR);
                    if (toServiceMsg != null) {
                        obtain.writeInt(1);
                        toServiceMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (fromServiceMsg != null) {
                        obtain.writeInt(1);
                        fromServiceMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeInt(i17);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onFirstPkgResp(toServiceMsg, fromServiceMsg, i3, i16, i17);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
            public void onNextPkgResp(int i3, int i16, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IMsfServiceCallbacker.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeByteArray(bArr);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onNextPkgResp(i3, i16, bArr);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
            public void onReceiveFirstPkgPushResp(FromServiceMsg fromServiceMsg, int i3, int i16, int i17) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IMsfServiceCallbacker.DESCRIPTOR);
                    if (fromServiceMsg != null) {
                        obtain.writeInt(1);
                        fromServiceMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeInt(i17);
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onReceiveFirstPkgPushResp(fromServiceMsg, i3, i16, i17);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
            public void onReceiveNextPkgPushResp(int i3, int i16, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IMsfServiceCallbacker.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeByteArray(bArr);
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onReceiveNextPkgPushResp(i3, i16, bArr);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
            public void onReceivePushResp(FromServiceMsg fromServiceMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IMsfServiceCallbacker.DESCRIPTOR);
                    if (fromServiceMsg != null) {
                        obtain.writeInt(1);
                        fromServiceMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onReceivePushResp(fromServiceMsg);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
            public void onResponse(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IMsfServiceCallbacker.DESCRIPTOR);
                    if (toServiceMsg != null) {
                        obtain.writeInt(1);
                        toServiceMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (fromServiceMsg != null) {
                        obtain.writeInt(1);
                        fromServiceMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onResponse(toServiceMsg, fromServiceMsg);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, IMsfServiceCallbacker.DESCRIPTOR);
        }

        public static IMsfServiceCallbacker asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IMsfServiceCallbacker.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMsfServiceCallbacker)) {
                return (IMsfServiceCallbacker) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IMsfServiceCallbacker getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMsfServiceCallbacker iMsfServiceCallbacker) {
            if (Proxy.sDefaultImpl == null) {
                if (iMsfServiceCallbacker != null) {
                    Proxy.sDefaultImpl = iMsfServiceCallbacker;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            ToServiceMsg toServiceMsg;
            ToServiceMsg toServiceMsg2;
            if (i3 != 1598968902) {
                FromServiceMsg fromServiceMsg = null;
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(IMsfServiceCallbacker.DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            toServiceMsg = ToServiceMsg.CREATOR.createFromParcel(parcel);
                        } else {
                            toServiceMsg = null;
                        }
                        if (parcel.readInt() != 0) {
                            fromServiceMsg = FromServiceMsg.CREATOR.createFromParcel(parcel);
                        }
                        onResponse(toServiceMsg, fromServiceMsg);
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(IMsfServiceCallbacker.DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            toServiceMsg2 = ToServiceMsg.CREATOR.createFromParcel(parcel);
                        } else {
                            toServiceMsg2 = null;
                        }
                        if (parcel.readInt() != 0) {
                            fromServiceMsg = FromServiceMsg.CREATOR.createFromParcel(parcel);
                        }
                        onFirstPkgResp(toServiceMsg2, fromServiceMsg, parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(IMsfServiceCallbacker.DESCRIPTOR);
                        onNextPkgResp(parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(IMsfServiceCallbacker.DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            fromServiceMsg = FromServiceMsg.CREATOR.createFromParcel(parcel);
                        }
                        onReceivePushResp(fromServiceMsg);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(IMsfServiceCallbacker.DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            fromServiceMsg = FromServiceMsg.CREATOR.createFromParcel(parcel);
                        }
                        onReceiveFirstPkgPushResp(fromServiceMsg, parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(IMsfServiceCallbacker.DESCRIPTOR);
                        onReceiveNextPkgPushResp(parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString(IMsfServiceCallbacker.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Default implements IMsfServiceCallbacker {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
        public void onReceivePushResp(FromServiceMsg fromServiceMsg) throws RemoteException {
        }

        @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
        public void onResponse(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) throws RemoteException {
        }

        @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
        public void onNextPkgResp(int i3, int i16, byte[] bArr) throws RemoteException {
        }

        @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
        public void onReceiveNextPkgPushResp(int i3, int i16, byte[] bArr) throws RemoteException {
        }

        @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
        public void onReceiveFirstPkgPushResp(FromServiceMsg fromServiceMsg, int i3, int i16, int i17) throws RemoteException {
        }

        @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
        public void onFirstPkgResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, int i3, int i16, int i17) throws RemoteException {
        }
    }
}
