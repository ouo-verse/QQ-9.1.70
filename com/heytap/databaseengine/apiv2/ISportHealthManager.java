package com.heytap.databaseengine.apiv2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.heytap.databaseengine.apiv3.DataInsertRequest;
import com.heytap.databaseengine.apiv3.DataReadRequest;
import com.heytap.databaseengine.callback.IDataOperateListener;
import com.heytap.databaseengine.callback.IDataReadResultListener;
import com.heytap.databaseengine.option.DataReadOption;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface ISportHealthManager extends IInterface {
    public static final String DESCRIPTOR = "com.heytap.databaseengine.apiv2.ISportHealthManager";

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t16, int i3) {
            if (t16 != null) {
                parcel.writeInt(1);
                t16.writeToParcel(parcel, i3);
            } else {
                parcel.writeInt(0);
            }
        }
    }

    void insert(DataInsertRequest dataInsertRequest, IDataOperateListener iDataOperateListener) throws RemoteException;

    void query(String str, IDataReadResultListener iDataReadResultListener) throws RemoteException;

    void read(DataReadOption dataReadOption, IDataReadResultListener iDataReadResultListener) throws RemoteException;

    void readv2(DataReadRequest dataReadRequest, IDataReadResultListener iDataReadResultListener) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements ISportHealthManager {
        static final int TRANSACTION_insert = 4;
        static final int TRANSACTION_query = 2;
        static final int TRANSACTION_read = 1;
        static final int TRANSACTION_readv2 = 3;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static class Proxy implements ISportHealthManager {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISportHealthManager.DESCRIPTOR;
            }

            @Override // com.heytap.databaseengine.apiv2.ISportHealthManager
            public void insert(DataInsertRequest dataInsertRequest, IDataOperateListener iDataOperateListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, ISportHealthManager.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, dataInsertRequest, 0);
                    obtain.writeStrongInterface(iDataOperateListener);
                    OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.apiv2.ISportHealthManager
            public void query(String str, IDataReadResultListener iDataReadResultListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, ISportHealthManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongInterface(iDataReadResultListener);
                    OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.apiv2.ISportHealthManager
            public void read(DataReadOption dataReadOption, IDataReadResultListener iDataReadResultListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, ISportHealthManager.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, dataReadOption, 0);
                    obtain.writeStrongInterface(iDataReadResultListener);
                    OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.apiv2.ISportHealthManager
            public void readv2(DataReadRequest dataReadRequest, IDataReadResultListener iDataReadResultListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, ISportHealthManager.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, dataReadRequest, 0);
                    obtain.writeStrongInterface(iDataReadResultListener);
                    OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, ISportHealthManager.DESCRIPTOR);
        }

        public static ISportHealthManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ISportHealthManager.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ISportHealthManager)) {
                return (ISportHealthManager) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(ISportHealthManager.DESCRIPTOR);
            }
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                return super.onTransact(i3, parcel, parcel2, i16);
                            }
                            insert((DataInsertRequest) _Parcel.readTypedObject(parcel, DataInsertRequest.CREATOR), IDataOperateListener.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                        } else {
                            readv2((DataReadRequest) _Parcel.readTypedObject(parcel, DataReadRequest.CREATOR), IDataReadResultListener.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                        }
                    } else {
                        query(parcel.readString(), IDataReadResultListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                    }
                } else {
                    read((DataReadOption) _Parcel.readTypedObject(parcel, DataReadOption.CREATOR), IDataReadResultListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(ISportHealthManager.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Default implements ISportHealthManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.databaseengine.apiv2.ISportHealthManager
        public void insert(DataInsertRequest dataInsertRequest, IDataOperateListener iDataOperateListener) throws RemoteException {
        }

        @Override // com.heytap.databaseengine.apiv2.ISportHealthManager
        public void query(String str, IDataReadResultListener iDataReadResultListener) throws RemoteException {
        }

        @Override // com.heytap.databaseengine.apiv2.ISportHealthManager
        public void read(DataReadOption dataReadOption, IDataReadResultListener iDataReadResultListener) throws RemoteException {
        }

        @Override // com.heytap.databaseengine.apiv2.ISportHealthManager
        public void readv2(DataReadRequest dataReadRequest, IDataReadResultListener iDataReadResultListener) throws RemoteException {
        }
    }
}
