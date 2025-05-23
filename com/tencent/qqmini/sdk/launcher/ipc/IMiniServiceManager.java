package com.tencent.qqmini.sdk.launcher.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IMiniServiceManager extends IInterface {
    void addService(String str, IBinder iBinder) throws RemoteException;

    IBinder checkService(String str) throws RemoteException;

    IBinder getService(String str) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static abstract class Stub extends Binder implements IMiniServiceManager {
        private static final String DESCRIPTOR = "com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager";
        static final int TRANSACTION_addService = 3;
        static final int TRANSACTION_checkService = 2;
        static final int TRANSACTION_getService = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes23.dex */
        public static class Proxy implements IMiniServiceManager {
            public static IMiniServiceManager sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager
            public void addService(String str, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().addService(str, iBinder);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager
            public IBinder checkService(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().checkService(str);
                    }
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager
            public IBinder getService(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getService(str);
                    }
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMiniServiceManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMiniServiceManager)) {
                return (IMiniServiceManager) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IMiniServiceManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMiniServiceManager iMiniServiceManager) {
            if (Proxy.sDefaultImpl == null && iMiniServiceManager != null) {
                Proxy.sDefaultImpl = iMiniServiceManager;
                return true;
            }
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 1598968902) {
                            return super.onTransact(i3, parcel, parcel2, i16);
                        }
                        parcel2.writeString(DESCRIPTOR);
                        return true;
                    }
                    parcel.enforceInterface(DESCRIPTOR);
                    addService(parcel.readString(), parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                IBinder checkService = checkService(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(checkService);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            IBinder service = getService(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(service);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Default implements IMiniServiceManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager
        public IBinder checkService(String str) throws RemoteException {
            return null;
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager
        public IBinder getService(String str) throws RemoteException {
            return null;
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager
        public void addService(String str, IBinder iBinder) throws RemoteException {
        }
    }
}
