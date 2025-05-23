package com.heytap.databaseengine.callback;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IDataReadResultListener extends IInterface {
    public static final String DESCRIPTOR = "com.heytap.databaseengine.callback.IDataReadResultListener";

    void onResult(List list, int i3, int i16) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IDataReadResultListener {
        static final int TRANSACTION_onResult = 1;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private static class Proxy implements IDataReadResultListener {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDataReadResultListener.DESCRIPTOR;
            }

            @Override // com.heytap.databaseengine.callback.IDataReadResultListener
            public void onResult(List list, int i3, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDataReadResultListener.DESCRIPTOR);
                    obtain.writeList(list);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, IDataReadResultListener.DESCRIPTOR);
        }

        public static IDataReadResultListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDataReadResultListener.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDataReadResultListener)) {
                return (IDataReadResultListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(IDataReadResultListener.DESCRIPTOR);
            }
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                onResult(parcel.readArrayList(getClass().getClassLoader()), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString(IDataReadResultListener.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Default implements IDataReadResultListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.databaseengine.callback.IDataReadResultListener
        public void onResult(List list, int i3, int i16) throws RemoteException {
        }
    }
}
