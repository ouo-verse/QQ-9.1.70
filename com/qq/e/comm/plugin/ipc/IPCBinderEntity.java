package com.qq.e.comm.plugin.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes3.dex */
public interface IPCBinderEntity extends IInterface {
    IPCResult async(String str, String str2, Bundle bundle, int i3, int i16) throws RemoteException;

    void callback(int i3, IPCResult iPCResult) throws RemoteException;

    String getProcName() throws RemoteException;

    int setClient(String str, int i3, IPCBinderEntity iPCBinderEntity) throws RemoteException;

    IPCResult sync(String str, String str2, Bundle bundle, int i3) throws RemoteException;

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IPCBinderEntity {
        private static final String DESCRIPTOR = "com.qq.e.comm.plugin.ipc.IPCBinderEntity";
        static final int TRANSACTION_async = 2;
        static final int TRANSACTION_callback = 3;
        static final int TRANSACTION_getProcName = 5;
        static final int TRANSACTION_setClient = 4;
        static final int TRANSACTION_sync = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static class Proxy implements IPCBinderEntity {
            public static IPCBinderEntity sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.qq.e.comm.plugin.ipc.IPCBinderEntity
            public IPCResult async(String str, String str2, Bundle bundle, int i3, int i16) throws RemoteException {
                IPCResult iPCResult;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().async(str, str2, bundle, i3, i16);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        iPCResult = IPCResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        iPCResult = null;
                    }
                    return iPCResult;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.qq.e.comm.plugin.ipc.IPCBinderEntity
            public void callback(int i3, IPCResult iPCResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (iPCResult != null) {
                        obtain.writeInt(1);
                        iPCResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().callback(i3, iPCResult);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.qq.e.comm.plugin.ipc.IPCBinderEntity
            public String getProcName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getProcName();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.qq.e.comm.plugin.ipc.IPCBinderEntity
            public int setClient(String str, int i3, IPCBinderEntity iPCBinderEntity) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (iPCBinderEntity != null) {
                        iBinder = iPCBinderEntity.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setClient(str, i3, iPCBinderEntity);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.qq.e.comm.plugin.ipc.IPCBinderEntity
            public IPCResult sync(String str, String str2, Bundle bundle, int i3) throws RemoteException {
                IPCResult iPCResult;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().sync(str, str2, bundle, i3);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        iPCResult = IPCResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        iPCResult = null;
                    }
                    return iPCResult;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPCBinderEntity asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPCBinderEntity)) {
                return (IPCBinderEntity) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IPCBinderEntity getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IPCBinderEntity iPCBinderEntity) {
            if (Proxy.sDefaultImpl == null) {
                if (iPCBinderEntity != null) {
                    Proxy.sDefaultImpl = iPCBinderEntity;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            Bundle bundle = null;
            IPCResult iPCResult = null;
            Bundle bundle2 = null;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 != 1598968902) {
                                    return super.onTransact(i3, parcel, parcel2, i16);
                                }
                                parcel2.writeString(DESCRIPTOR);
                                return true;
                            }
                            parcel.enforceInterface(DESCRIPTOR);
                            String procName = getProcName();
                            parcel2.writeNoException();
                            parcel2.writeString(procName);
                            return true;
                        }
                        parcel.enforceInterface(DESCRIPTOR);
                        int client = setClient(parcel.readString(), parcel.readInt(), asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(client);
                        return true;
                    }
                    parcel.enforceInterface(DESCRIPTOR);
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        iPCResult = IPCResult.CREATOR.createFromParcel(parcel);
                    }
                    callback(readInt, iPCResult);
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                IPCResult async = async(readString, readString2, bundle2, parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                if (async != null) {
                    parcel2.writeInt(1);
                    async.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            if (parcel.readInt() != 0) {
                bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
            }
            IPCResult sync = sync(readString3, readString4, bundle, parcel.readInt());
            parcel2.writeNoException();
            if (sync != null) {
                parcel2.writeInt(1);
                sync.writeToParcel(parcel2, 1);
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

    /* loaded from: classes3.dex */
    public static class Default implements IPCBinderEntity {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.qq.e.comm.plugin.ipc.IPCBinderEntity
        public IPCResult async(String str, String str2, Bundle bundle, int i3, int i16) throws RemoteException {
            return null;
        }

        @Override // com.qq.e.comm.plugin.ipc.IPCBinderEntity
        public String getProcName() throws RemoteException {
            return null;
        }

        @Override // com.qq.e.comm.plugin.ipc.IPCBinderEntity
        public int setClient(String str, int i3, IPCBinderEntity iPCBinderEntity) throws RemoteException {
            return 0;
        }

        @Override // com.qq.e.comm.plugin.ipc.IPCBinderEntity
        public IPCResult sync(String str, String str2, Bundle bundle, int i3) throws RemoteException {
            return null;
        }

        @Override // com.qq.e.comm.plugin.ipc.IPCBinderEntity
        public void callback(int i3, IPCResult iPCResult) throws RemoteException {
        }
    }
}
