package com.tencent.mobileqq.mini.launch;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface CmdCallback extends IInterface {
    public static final String DESCRIPTOR = "com.tencent.mobileqq.mini.launch.CmdCallback";

    void onCmdResult(boolean z16, Bundle bundle) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static abstract class Stub extends Binder implements CmdCallback {
        static final int TRANSACTION_onCmdResult = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes33.dex */
        public static class Proxy implements CmdCallback {
            public static CmdCallback sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return CmdCallback.DESCRIPTOR;
            }

            @Override // com.tencent.mobileqq.mini.launch.CmdCallback
            public void onCmdResult(boolean z16, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, CmdCallback.DESCRIPTOR);
                    obtain.writeInt(z16 ? 1 : 0);
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
            attachInterface(this, CmdCallback.DESCRIPTOR);
        }

        public static CmdCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(CmdCallback cmdCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (cmdCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = cmdCallback;
            return true;
        }

        public static CmdCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(CmdCallback.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof CmdCallback)) {
                return (CmdCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 == 1598968902) {
                parcel2.writeString(CmdCallback.DESCRIPTOR);
                return true;
            }
            if (i3 != 1) {
                return super.onTransact(i3, parcel, parcel2, i16);
            }
            parcel.enforceInterface(CmdCallback.DESCRIPTOR);
            onCmdResult(parcel.readInt() != 0, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class Default implements CmdCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.mobileqq.mini.launch.CmdCallback
        public void onCmdResult(boolean z16, Bundle bundle) throws RemoteException {
        }
    }
}
