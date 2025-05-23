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
public interface ICommonListener extends IInterface {
    public static final String DESCRIPTOR = "com.heytap.databaseengine.callback.ICommonListener";

    void onFailure(int i3, List list) throws RemoteException;

    void onSuccess(int i3, List list) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements ICommonListener {
        static final int TRANSACTION_onFailure = 2;
        static final int TRANSACTION_onSuccess = 1;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private static class Proxy implements ICommonListener {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICommonListener.DESCRIPTOR;
            }

            @Override // com.heytap.databaseengine.callback.ICommonListener
            public void onFailure(int i3, List list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, ICommonListener.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeList(list);
                    OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.callback.ICommonListener
            public void onSuccess(int i3, List list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, ICommonListener.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeList(list);
                    OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, ICommonListener.DESCRIPTOR);
        }

        public static ICommonListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ICommonListener.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICommonListener)) {
                return (ICommonListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(ICommonListener.DESCRIPTOR);
            }
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return super.onTransact(i3, parcel, parcel2, i16);
                    }
                    onFailure(parcel.readInt(), parcel.readArrayList(getClass().getClassLoader()));
                    parcel2.writeNoException();
                } else {
                    onSuccess(parcel.readInt(), parcel.readArrayList(getClass().getClassLoader()));
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(ICommonListener.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Default implements ICommonListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.databaseengine.callback.ICommonListener
        public void onFailure(int i3, List list) throws RemoteException {
        }

        @Override // com.heytap.databaseengine.callback.ICommonListener
        public void onSuccess(int i3, List list) throws RemoteException {
        }
    }
}
