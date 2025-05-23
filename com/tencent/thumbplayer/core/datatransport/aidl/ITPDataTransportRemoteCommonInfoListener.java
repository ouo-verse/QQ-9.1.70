package com.tencent.thumbplayer.core.datatransport.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes26.dex */
public interface ITPDataTransportRemoteCommonInfoListener extends IInterface {
    void onCommonInfoUpdate(int i3, TPDataTransportMessageInfo tPDataTransportMessageInfo) throws RemoteException;

    /* loaded from: classes26.dex */
    public static abstract class Stub extends Binder implements ITPDataTransportRemoteCommonInfoListener {
        private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteCommonInfoListener";
        static final int TRANSACTION_onCommonInfoUpdate = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes26.dex */
        public static class Proxy implements ITPDataTransportRemoteCommonInfoListener {
            public static ITPDataTransportRemoteCommonInfoListener sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteCommonInfoListener
            public void onCommonInfoUpdate(int i3, TPDataTransportMessageInfo tPDataTransportMessageInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (tPDataTransportMessageInfo != null) {
                        obtain.writeInt(1);
                        tPDataTransportMessageInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onCommonInfoUpdate(i3, tPDataTransportMessageInfo);
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
            attachInterface(this, DESCRIPTOR);
        }

        public static ITPDataTransportRemoteCommonInfoListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITPDataTransportRemoteCommonInfoListener)) {
                return (ITPDataTransportRemoteCommonInfoListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static ITPDataTransportRemoteCommonInfoListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ITPDataTransportRemoteCommonInfoListener iTPDataTransportRemoteCommonInfoListener) {
            if (Proxy.sDefaultImpl == null) {
                if (iTPDataTransportRemoteCommonInfoListener != null) {
                    Proxy.sDefaultImpl = iTPDataTransportRemoteCommonInfoListener;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            TPDataTransportMessageInfo tPDataTransportMessageInfo;
            if (i3 != 1) {
                if (i3 != 1598968902) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            int readInt = parcel.readInt();
            if (parcel.readInt() != 0) {
                tPDataTransportMessageInfo = TPDataTransportMessageInfo.CREATOR.createFromParcel(parcel);
            } else {
                tPDataTransportMessageInfo = null;
            }
            onCommonInfoUpdate(readInt, tPDataTransportMessageInfo);
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes26.dex */
    public static class Default implements ITPDataTransportRemoteCommonInfoListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteCommonInfoListener
        public void onCommonInfoUpdate(int i3, TPDataTransportMessageInfo tPDataTransportMessageInfo) throws RemoteException {
        }
    }
}
