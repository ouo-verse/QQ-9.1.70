package com.tencent.minibox.contract;

import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface IMiniBoxServiceConnection extends IInterface {
    String getBindKey() throws RemoteException;

    void onConnectFailed(int i3) throws RemoteException;

    void onConnected(ComponentName componentName, IBinder iBinder, boolean z16) throws RemoteException;

    void onDisconnected() throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class Default implements IMiniBoxServiceConnection {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.minibox.contract.IMiniBoxServiceConnection
        public String getBindKey() throws RemoteException {
            return null;
        }

        @Override // com.tencent.minibox.contract.IMiniBoxServiceConnection
        public void onConnectFailed(int i3) throws RemoteException {
        }

        @Override // com.tencent.minibox.contract.IMiniBoxServiceConnection
        public void onDisconnected() throws RemoteException {
        }

        @Override // com.tencent.minibox.contract.IMiniBoxServiceConnection
        public void onConnected(ComponentName componentName, IBinder iBinder, boolean z16) throws RemoteException {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class Stub extends Binder implements IMiniBoxServiceConnection {
        private static final String DESCRIPTOR = "com.tencent.minibox.contract.IMiniBoxServiceConnection";
        static final int TRANSACTION_getBindKey = 4;
        static final int TRANSACTION_onConnectFailed = 2;
        static final int TRANSACTION_onConnected = 1;
        static final int TRANSACTION_onDisconnected = 3;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static class Proxy implements IMiniBoxServiceConnection {
            public static IMiniBoxServiceConnection sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.minibox.contract.IMiniBoxServiceConnection
            public String getBindKey() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getBindKey();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.tencent.minibox.contract.IMiniBoxServiceConnection
            public void onConnectFailed(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onConnectFailed(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.contract.IMiniBoxServiceConnection
            public void onConnected(ComponentName componentName, IBinder iBinder, boolean z16) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onConnected(componentName, iBinder, z16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.contract.IMiniBoxServiceConnection
            public void onDisconnected() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDisconnected();
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

        public static IMiniBoxServiceConnection asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMiniBoxServiceConnection)) {
                return (IMiniBoxServiceConnection) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IMiniBoxServiceConnection getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMiniBoxServiceConnection iMiniBoxServiceConnection) {
            if (Proxy.sDefaultImpl == null && iMiniBoxServiceConnection != null) {
                Proxy.sDefaultImpl = iMiniBoxServiceConnection;
                return true;
            }
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            ComponentName componentName;
            boolean z16;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 1598968902) {
                                return super.onTransact(i3, parcel, parcel2, i16);
                            }
                            parcel2.writeString(DESCRIPTOR);
                            return true;
                        }
                        parcel.enforceInterface(DESCRIPTOR);
                        String bindKey = getBindKey();
                        parcel2.writeNoException();
                        parcel2.writeString(bindKey);
                        return true;
                    }
                    parcel.enforceInterface(DESCRIPTOR);
                    onDisconnected();
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                onConnectFailed(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            if (parcel.readInt() != 0) {
                componentName = (ComponentName) ComponentName.CREATOR.createFromParcel(parcel);
            } else {
                componentName = null;
            }
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (parcel.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            onConnected(componentName, readStrongBinder, z16);
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
