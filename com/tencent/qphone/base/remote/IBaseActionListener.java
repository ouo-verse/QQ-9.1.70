package com.tencent.qphone.base.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IBaseActionListener extends IInterface {
    public static final String DESCRIPTOR = "com.tencent.qphone.base.remote.IBaseActionListener";

    void onActionResult(FromServiceMsg fromServiceMsg) throws RemoteException;

    void onRecvFromMsg(FromServiceMsg fromServiceMsg) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static abstract class Stub extends Binder implements IBaseActionListener {
        static final int TRANSACTION_onActionResult = 2;
        static final int TRANSACTION_onRecvFromMsg = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes22.dex */
        public static class Proxy implements IBaseActionListener {
            public static IBaseActionListener sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IBaseActionListener.DESCRIPTOR;
            }

            @Override // com.tencent.qphone.base.remote.IBaseActionListener
            public void onActionResult(FromServiceMsg fromServiceMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IBaseActionListener.DESCRIPTOR);
                    if (fromServiceMsg != null) {
                        obtain.writeInt(1);
                        fromServiceMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onActionResult(fromServiceMsg);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IBaseActionListener
            public void onRecvFromMsg(FromServiceMsg fromServiceMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IBaseActionListener.DESCRIPTOR);
                    if (fromServiceMsg != null) {
                        obtain.writeInt(1);
                        fromServiceMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRecvFromMsg(fromServiceMsg);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, IBaseActionListener.DESCRIPTOR);
        }

        public static IBaseActionListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IBaseActionListener.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IBaseActionListener)) {
                return (IBaseActionListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IBaseActionListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IBaseActionListener iBaseActionListener) {
            if (Proxy.sDefaultImpl == null) {
                if (iBaseActionListener != null) {
                    Proxy.sDefaultImpl = iBaseActionListener;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                FromServiceMsg fromServiceMsg = null;
                if (i3 != 1) {
                    if (i3 != 2) {
                        return super.onTransact(i3, parcel, parcel2, i16);
                    }
                    parcel.enforceInterface(IBaseActionListener.DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        fromServiceMsg = FromServiceMsg.CREATOR.createFromParcel(parcel);
                    }
                    onActionResult(fromServiceMsg);
                    return true;
                }
                parcel.enforceInterface(IBaseActionListener.DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    fromServiceMsg = FromServiceMsg.CREATOR.createFromParcel(parcel);
                }
                onRecvFromMsg(fromServiceMsg);
                return true;
            }
            parcel2.writeString(IBaseActionListener.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Default implements IBaseActionListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.qphone.base.remote.IBaseActionListener
        public void onActionResult(FromServiceMsg fromServiceMsg) throws RemoteException {
        }

        @Override // com.tencent.qphone.base.remote.IBaseActionListener
        public void onRecvFromMsg(FromServiceMsg fromServiceMsg) throws RemoteException {
        }
    }
}
