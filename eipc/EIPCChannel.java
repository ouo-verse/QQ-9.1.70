package eipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes28.dex */
public interface EIPCChannel extends IInterface {
    void async(String str, String str2, Bundle bundle, int i3, int i16) throws RemoteException;

    void callback(int i3, EIPCResult eIPCResult) throws RemoteException;

    String getProcName() throws RemoteException;

    int setClient(String str, int i3, EIPCChannel eIPCChannel, int i16) throws RemoteException;

    IBinder setStubBinder(int i3, IBinder iBinder) throws RemoteException;

    EIPCResult sync(String str, String str2, Bundle bundle, int i3) throws RemoteException;

    /* loaded from: classes28.dex */
    public static abstract class Stub extends Binder implements EIPCChannel {
        private static final String DESCRIPTOR = "eipc.EIPCChannel";
        static final int TRANSACTION_async = 2;
        static final int TRANSACTION_callback = 6;
        static final int TRANSACTION_getProcName = 3;
        static final int TRANSACTION_setClient = 4;
        static final int TRANSACTION_setStubBinder = 5;
        static final int TRANSACTION_sync = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes28.dex */
        public static class Proxy implements EIPCChannel {
            public static EIPCChannel sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // eipc.EIPCChannel
            public void async(String str, String str2, Bundle bundle, int i3, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
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
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().async(str, str2, bundle, i3, i16);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // eipc.EIPCChannel
            public void callback(int i3, EIPCResult eIPCResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (eIPCResult != null) {
                        obtain.writeInt(1);
                        eIPCResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().callback(i3, eIPCResult);
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

            @Override // eipc.EIPCChannel
            public String getProcName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getProcName();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // eipc.EIPCChannel
            public int setClient(String str, int i3, EIPCChannel eIPCChannel, int i16) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (eIPCChannel != null) {
                        iBinder = eIPCChannel.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setClient(str, i3, eIPCChannel, i16);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // eipc.EIPCChannel
            public IBinder setStubBinder(int i3, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setStubBinder(i3, iBinder);
                    }
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // eipc.EIPCChannel
            public EIPCResult sync(String str, String str2, Bundle bundle, int i3) throws RemoteException {
                EIPCResult eIPCResult;
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
                        eIPCResult = EIPCResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        eIPCResult = null;
                    }
                    return eIPCResult;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static EIPCChannel asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof EIPCChannel)) {
                return (EIPCChannel) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static EIPCChannel getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(EIPCChannel eIPCChannel) {
            if (Proxy.sDefaultImpl == null) {
                if (eIPCChannel != null) {
                    Proxy.sDefaultImpl = eIPCChannel;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                Bundle bundle = null;
                EIPCResult eIPCResult = null;
                Bundle bundle2 = null;
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString = parcel.readString();
                        String readString2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        EIPCResult sync = sync(readString, readString2, bundle, parcel.readInt());
                        parcel2.writeNoException();
                        if (sync != null) {
                            parcel2.writeInt(1);
                            sync.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString3 = parcel.readString();
                        String readString4 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        async(readString3, readString4, bundle2, parcel.readInt(), parcel.readInt());
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        String procName = getProcName();
                        parcel2.writeNoException();
                        parcel2.writeString(procName);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        int client = setClient(parcel.readString(), parcel.readInt(), asInterface(parcel.readStrongBinder()), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(client);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        IBinder stubBinder = setStubBinder(parcel.readInt(), parcel.readStrongBinder());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(stubBinder);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            eIPCResult = EIPCResult.CREATOR.createFromParcel(parcel);
                        }
                        callback(readInt, eIPCResult);
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes28.dex */
    public static class Default implements EIPCChannel {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // eipc.EIPCChannel
        public String getProcName() throws RemoteException {
            return null;
        }

        @Override // eipc.EIPCChannel
        public int setClient(String str, int i3, EIPCChannel eIPCChannel, int i16) throws RemoteException {
            return 0;
        }

        @Override // eipc.EIPCChannel
        public IBinder setStubBinder(int i3, IBinder iBinder) throws RemoteException {
            return null;
        }

        @Override // eipc.EIPCChannel
        public EIPCResult sync(String str, String str2, Bundle bundle, int i3) throws RemoteException {
            return null;
        }

        @Override // eipc.EIPCChannel
        public void callback(int i3, EIPCResult eIPCResult) throws RemoteException {
        }

        @Override // eipc.EIPCChannel
        public void async(String str, String str2, Bundle bundle, int i3, int i16) throws RemoteException {
        }
    }
}
