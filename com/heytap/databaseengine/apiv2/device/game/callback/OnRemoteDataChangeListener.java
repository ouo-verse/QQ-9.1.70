package com.heytap.databaseengine.apiv2.device.game.callback;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.heytap.databaseengine.apiv2.device.game.model.GameHealthData;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface OnRemoteDataChangeListener extends IInterface {
    public static final String DESCRIPTOR = "com.heytap.databaseengine.apiv2.device.game.callback.OnRemoteDataChangeListener";

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t16, int i3) {
            if (t16 != null) {
                parcel.writeInt(1);
                t16.writeToParcel(parcel, i3);
            } else {
                parcel.writeInt(0);
            }
        }
    }

    void onChanged(GameHealthData gameHealthData) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements OnRemoteDataChangeListener {
        static final int TRANSACTION_onChanged = 1;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private static class Proxy implements OnRemoteDataChangeListener {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return OnRemoteDataChangeListener.DESCRIPTOR;
            }

            @Override // com.heytap.databaseengine.apiv2.device.game.callback.OnRemoteDataChangeListener
            public void onChanged(GameHealthData gameHealthData) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, OnRemoteDataChangeListener.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, gameHealthData, 0);
                    OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, OnRemoteDataChangeListener.DESCRIPTOR);
        }

        public static OnRemoteDataChangeListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(OnRemoteDataChangeListener.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof OnRemoteDataChangeListener)) {
                return (OnRemoteDataChangeListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(OnRemoteDataChangeListener.DESCRIPTOR);
            }
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                onChanged((GameHealthData) _Parcel.readTypedObject(parcel, GameHealthData.CREATOR));
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString(OnRemoteDataChangeListener.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Default implements OnRemoteDataChangeListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.databaseengine.apiv2.device.game.callback.OnRemoteDataChangeListener
        public void onChanged(GameHealthData gameHealthData) throws RemoteException {
        }
    }
}
