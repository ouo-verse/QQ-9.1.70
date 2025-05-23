package com.heytap.databaseengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes2.dex */
public interface IBinderPool extends IInterface {
    public static final String DESCRIPTOR = "com.heytap.databaseengine.IBinderPool";

    /* loaded from: classes2.dex */
    public static class Default implements IBinderPool {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.databaseengine.IBinderPool
        public IBinder queryBinder(String str) throws RemoteException {
            return null;
        }
    }

    IBinder queryBinder(String str) throws RemoteException;

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IBinderPool {
        static final int TRANSACTION_queryBinder = 1;

        /* loaded from: classes2.dex */
        private static class Proxy implements IBinderPool {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IBinderPool.DESCRIPTOR;
            }

            @Override // com.heytap.databaseengine.IBinderPool
            public IBinder queryBinder(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IBinderPool.DESCRIPTOR);
                    obtain.writeString(str);
                    OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, IBinderPool.DESCRIPTOR);
        }

        public static IBinderPool asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IBinderPool.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IBinderPool)) {
                return (IBinderPool) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(IBinderPool.DESCRIPTOR);
            }
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                IBinder queryBinder = queryBinder(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(queryBinder);
                return true;
            }
            parcel2.writeString(IBinderPool.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
