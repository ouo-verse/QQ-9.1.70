package com.heytap.databaseengine.apiv2.device.game.callback;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.heytap.databaseengine.apiv2.device.game.model.GameInfo;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface OnRequestGameStatusListener extends IInterface {
    public static final String DESCRIPTOR = "com.heytap.databaseengine.apiv2.device.game.callback.OnRequestGameStatusListener";

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Default implements OnRequestGameStatusListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.databaseengine.apiv2.device.game.callback.OnRequestGameStatusListener
        public GameInfo onRequestGameStatus() throws RemoteException {
            return null;
        }
    }

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

    GameInfo onRequestGameStatus() throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements OnRequestGameStatusListener {
        static final int TRANSACTION_onRequestGameStatus = 1;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private static class Proxy implements OnRequestGameStatusListener {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return OnRequestGameStatusListener.DESCRIPTOR;
            }

            @Override // com.heytap.databaseengine.apiv2.device.game.callback.OnRequestGameStatusListener
            public GameInfo onRequestGameStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, OnRequestGameStatusListener.DESCRIPTOR);
                    OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0);
                    obtain2.readException();
                    return (GameInfo) _Parcel.readTypedObject(obtain2, GameInfo.CREATOR);
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, OnRequestGameStatusListener.DESCRIPTOR);
        }

        public static OnRequestGameStatusListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(OnRequestGameStatusListener.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof OnRequestGameStatusListener)) {
                return (OnRequestGameStatusListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(OnRequestGameStatusListener.DESCRIPTOR);
            }
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                GameInfo onRequestGameStatus = onRequestGameStatus();
                parcel2.writeNoException();
                _Parcel.writeTypedObject(parcel2, onRequestGameStatus, 1);
                return true;
            }
            parcel2.writeString(OnRequestGameStatusListener.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
