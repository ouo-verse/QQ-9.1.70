package com.vivo.vms;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.vivo.vms.IPCCallback;

/* loaded from: classes22.dex */
public interface IPCInvoke extends IInterface {
    public static final String DESCRIPTOR = "com.vivo.vms.IPCInvoke";

    /* loaded from: classes22.dex */
    public static class Default implements IPCInvoke {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.vivo.vms.IPCInvoke
        public Bundle asyncCall(Bundle bundle, IPCCallback iPCCallback) throws RemoteException {
            return null;
        }
    }

    Bundle asyncCall(Bundle bundle, IPCCallback iPCCallback) throws RemoteException;

    /* loaded from: classes22.dex */
    public static abstract class Stub extends Binder implements IPCInvoke {
        static final int TRANSACTION_asyncCall = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes22.dex */
        public static class Proxy implements IPCInvoke {
            public static IPCInvoke sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.vivo.vms.IPCInvoke
            public Bundle asyncCall(Bundle bundle, IPCCallback iPCCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IPCInvoke.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    Bundle bundle2 = null;
                    if (iPCCallback != null) {
                        iBinder = iPCCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().asyncCall(bundle, iPCCallback);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    }
                    return bundle2;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                return IPCInvoke.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IPCInvoke.DESCRIPTOR);
        }

        public static IPCInvoke asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IPCInvoke.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPCInvoke)) {
                return (IPCInvoke) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IPCInvoke getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IPCInvoke iPCInvoke) {
            if (Proxy.sDefaultImpl == null) {
                if (iPCInvoke != null) {
                    Proxy.sDefaultImpl = iPCInvoke;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            Bundle bundle;
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel.enforceInterface(IPCInvoke.DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                Bundle asyncCall = asyncCall(bundle, IPCCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (asyncCall != null) {
                    parcel2.writeInt(1);
                    asyncCall.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            parcel2.writeString(IPCInvoke.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
