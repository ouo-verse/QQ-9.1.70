package com.tencent.qqmini.sdk.launcher.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface MiniCmdCallback extends IInterface {
    void onCmdResult(boolean z16, Bundle bundle) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static abstract class Stub extends Binder implements MiniCmdCallback {
        private static final String DESCRIPTOR = "com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback";
        static final int TRANSACTION_onCmdResult = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes23.dex */
        public static class Proxy implements MiniCmdCallback {
            public static MiniCmdCallback sDefaultImpl;
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

            @Override // com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback
            public void onCmdResult(boolean z16, Bundle bundle) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onCmdResult(z16, bundle);
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

        public static MiniCmdCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof MiniCmdCallback)) {
                return (MiniCmdCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static MiniCmdCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(MiniCmdCallback miniCmdCallback) {
            if (Proxy.sDefaultImpl == null && miniCmdCallback != null) {
                Proxy.sDefaultImpl = miniCmdCallback;
                return true;
            }
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            boolean z16;
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
                z16 = true;
            } else {
                z16 = false;
            }
            if (parcel.readInt() != 0) {
                bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
            } else {
                bundle = null;
            }
            onCmdResult(z16, bundle);
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Default implements MiniCmdCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback
        public void onCmdResult(boolean z16, Bundle bundle) throws RemoteException {
        }
    }
}
