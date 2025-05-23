package com.heytap.databaseengine.apiv2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.heytap.databaseengine.callback.ICommonListener;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IUserInfoManager extends IInterface {
    public static final String DESCRIPTOR = "com.heytap.databaseengine.apiv2.IUserInfoManager";

    void readUserInfo(ICommonListener iCommonListener) throws RemoteException;

    void readV2(ICommonListener iCommonListener) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IUserInfoManager {
        static final int TRANSACTION_readUserInfo = 1;
        static final int TRANSACTION_readV2 = 2;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private static class Proxy implements IUserInfoManager {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IUserInfoManager.DESCRIPTOR;
            }

            @Override // com.heytap.databaseengine.apiv2.IUserInfoManager
            public void readUserInfo(ICommonListener iCommonListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IUserInfoManager.DESCRIPTOR);
                    obtain.writeStrongInterface(iCommonListener);
                    OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.apiv2.IUserInfoManager
            public void readV2(ICommonListener iCommonListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IUserInfoManager.DESCRIPTOR);
                    obtain.writeStrongInterface(iCommonListener);
                    OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, IUserInfoManager.DESCRIPTOR);
        }

        public static IUserInfoManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IUserInfoManager.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IUserInfoManager)) {
                return (IUserInfoManager) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(IUserInfoManager.DESCRIPTOR);
            }
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return super.onTransact(i3, parcel, parcel2, i16);
                    }
                    readV2(ICommonListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                } else {
                    readUserInfo(ICommonListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(IUserInfoManager.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Default implements IUserInfoManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.databaseengine.apiv2.IUserInfoManager
        public void readUserInfo(ICommonListener iCommonListener) throws RemoteException {
        }

        @Override // com.heytap.databaseengine.apiv2.IUserInfoManager
        public void readV2(ICommonListener iCommonListener) throws RemoteException {
        }
    }
}
