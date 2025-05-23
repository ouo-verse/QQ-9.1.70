package eipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes28.dex */
public interface EIPCCallback extends IInterface {
    void callback(EIPCResult eIPCResult) throws RemoteException;

    /* loaded from: classes28.dex */
    public static abstract class Stub extends Binder implements EIPCCallback {
        private static final String DESCRIPTOR = "eipc.EIPCCallback";
        static final int TRANSACTION_callback = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes28.dex */
        public static class Proxy implements EIPCCallback {
            public static EIPCCallback sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // eipc.EIPCCallback
            public void callback(EIPCResult eIPCResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (eIPCResult != null) {
                        obtain.writeInt(1);
                        eIPCResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().callback(eIPCResult);
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
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static EIPCCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof EIPCCallback)) {
                return (EIPCCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static EIPCCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(EIPCCallback eIPCCallback) {
            if (Proxy.sDefaultImpl == null) {
                if (eIPCCallback != null) {
                    Proxy.sDefaultImpl = eIPCCallback;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            EIPCResult eIPCResult;
            if (i3 != 1) {
                if (i3 != 1598968902) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            if (parcel.readInt() != 0) {
                eIPCResult = EIPCResult.CREATOR.createFromParcel(parcel);
            } else {
                eIPCResult = null;
            }
            callback(eIPCResult);
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes28.dex */
    public static class Default implements EIPCCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // eipc.EIPCCallback
        public void callback(EIPCResult eIPCResult) throws RemoteException {
        }
    }
}
