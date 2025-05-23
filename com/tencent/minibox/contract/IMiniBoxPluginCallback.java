package com.tencent.minibox.contract;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes9.dex */
public interface IMiniBoxPluginCallback extends IInterface {
    void onResult(Bundle bundle) throws RemoteException;

    /* loaded from: classes9.dex */
    public static class Default implements IMiniBoxPluginCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.minibox.contract.IMiniBoxPluginCallback
        public void onResult(Bundle bundle) throws RemoteException {
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class Stub extends Binder implements IMiniBoxPluginCallback {
        private static final String DESCRIPTOR = "com.tencent.minibox.contract.IMiniBoxPluginCallback";
        static final int TRANSACTION_onResult = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes9.dex */
        public static class Proxy implements IMiniBoxPluginCallback {
            public static IMiniBoxPluginCallback sDefaultImpl;
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

            @Override // com.tencent.minibox.contract.IMiniBoxPluginCallback
            public void onResult(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onResult(bundle);
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

        public static IMiniBoxPluginCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMiniBoxPluginCallback)) {
                return (IMiniBoxPluginCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IMiniBoxPluginCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMiniBoxPluginCallback iMiniBoxPluginCallback) {
            if (Proxy.sDefaultImpl == null && iMiniBoxPluginCallback != null) {
                Proxy.sDefaultImpl = iMiniBoxPluginCallback;
                return true;
            }
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            Bundle bundle;
            if (i3 != 1) {
                if (i3 != 1598968902) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            if (parcel.readInt() != 0) {
                bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
            } else {
                bundle = null;
            }
            onResult(bundle);
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
