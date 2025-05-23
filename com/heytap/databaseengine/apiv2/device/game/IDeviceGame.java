package com.heytap.databaseengine.apiv2.device.game;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.heytap.databaseengine.apiv2.device.game.callback.OnRemoteDataChangeListener;
import com.heytap.databaseengine.apiv2.device.game.callback.OnRemoteResponseListener;
import com.heytap.databaseengine.apiv2.device.game.callback.OnRequestGameStatusListener;
import com.heytap.databaseengine.apiv2.device.game.model.GameDataWrapper;
import com.heytap.databaseengine.apiv2.device.game.model.GameInfo;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IDeviceGame extends IInterface {
    public static final String DESCRIPTOR = "com.heytap.databaseengine.apiv2.device.game.IDeviceGame";

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

    int end(GameInfo gameInfo) throws RemoteException;

    void endRound(GameInfo gameInfo) throws RemoteException;

    boolean isConnectGameDevice() throws RemoteException;

    boolean isPlaying() throws RemoteException;

    boolean isWearing() throws RemoteException;

    void onPermissionChanged(boolean z16) throws RemoteException;

    void pause(GameInfo gameInfo) throws RemoteException;

    void resume(GameInfo gameInfo) throws RemoteException;

    void setOnRequestGameStatusListener(OnRequestGameStatusListener onRequestGameStatusListener) throws RemoteException;

    void setOnResponseListener(OnRemoteResponseListener onRemoteResponseListener) throws RemoteException;

    void setSendConfig(boolean z16) throws RemoteException;

    void setVerifyGameSwitch(boolean z16) throws RemoteException;

    boolean shouldCallForwarding() throws RemoteException;

    int start(GameInfo gameInfo) throws RemoteException;

    int startRound(GameInfo gameInfo) throws RemoteException;

    int startWithListener(String str, OnRemoteDataChangeListener onRemoteDataChangeListener) throws RemoteException;

    void updateData(GameInfo gameInfo, GameDataWrapper gameDataWrapper) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IDeviceGame {
        static final int TRANSACTION_end = 7;
        static final int TRANSACTION_endRound = 6;
        static final int TRANSACTION_isConnectGameDevice = 13;
        static final int TRANSACTION_isPlaying = 11;
        static final int TRANSACTION_isWearing = 12;
        static final int TRANSACTION_onPermissionChanged = 16;
        static final int TRANSACTION_pause = 9;
        static final int TRANSACTION_resume = 8;
        static final int TRANSACTION_setOnRequestGameStatusListener = 17;
        static final int TRANSACTION_setOnResponseListener = 5;
        static final int TRANSACTION_setSendConfig = 14;
        static final int TRANSACTION_setVerifyGameSwitch = 15;
        static final int TRANSACTION_shouldCallForwarding = 10;
        static final int TRANSACTION_start = 1;
        static final int TRANSACTION_startRound = 2;
        static final int TRANSACTION_startWithListener = 3;
        static final int TRANSACTION_updateData = 4;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static class Proxy implements IDeviceGame {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
            public int end(GameInfo gameInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDeviceGame.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, gameInfo, 0);
                    OaidMonitor.binderTransact(this.mRemote, 7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
            public void endRound(GameInfo gameInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDeviceGame.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, gameInfo, 0);
                    OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                return IDeviceGame.DESCRIPTOR;
            }

            @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
            public boolean isConnectGameDevice() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDeviceGame.DESCRIPTOR);
                    boolean z16 = false;
                    OaidMonitor.binderTransact(this.mRemote, 13, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
            public boolean isPlaying() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDeviceGame.DESCRIPTOR);
                    boolean z16 = false;
                    OaidMonitor.binderTransact(this.mRemote, 11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
            public boolean isWearing() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDeviceGame.DESCRIPTOR);
                    boolean z16 = false;
                    OaidMonitor.binderTransact(this.mRemote, 12, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
            public void onPermissionChanged(boolean z16) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDeviceGame.DESCRIPTOR);
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    OaidMonitor.binderTransact(this.mRemote, 16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
            public void pause(GameInfo gameInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDeviceGame.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, gameInfo, 0);
                    OaidMonitor.binderTransact(this.mRemote, 9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
            public void resume(GameInfo gameInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDeviceGame.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, gameInfo, 0);
                    OaidMonitor.binderTransact(this.mRemote, 8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
            public void setOnRequestGameStatusListener(OnRequestGameStatusListener onRequestGameStatusListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDeviceGame.DESCRIPTOR);
                    obtain.writeStrongInterface(onRequestGameStatusListener);
                    OaidMonitor.binderTransact(this.mRemote, 17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
            public void setOnResponseListener(OnRemoteResponseListener onRemoteResponseListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDeviceGame.DESCRIPTOR);
                    obtain.writeStrongInterface(onRemoteResponseListener);
                    OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
            public void setSendConfig(boolean z16) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDeviceGame.DESCRIPTOR);
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    OaidMonitor.binderTransact(this.mRemote, 14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
            public void setVerifyGameSwitch(boolean z16) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDeviceGame.DESCRIPTOR);
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    OaidMonitor.binderTransact(this.mRemote, 15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
            public boolean shouldCallForwarding() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDeviceGame.DESCRIPTOR);
                    boolean z16 = false;
                    OaidMonitor.binderTransact(this.mRemote, 10, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
            public int start(GameInfo gameInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDeviceGame.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, gameInfo, 0);
                    OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
            public int startRound(GameInfo gameInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDeviceGame.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, gameInfo, 0);
                    OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
            public int startWithListener(String str, OnRemoteDataChangeListener onRemoteDataChangeListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDeviceGame.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongInterface(onRemoteDataChangeListener);
                    OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
            public void updateData(GameInfo gameInfo, GameDataWrapper gameDataWrapper) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDeviceGame.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, gameInfo, 0);
                    _Parcel.writeTypedObject(obtain, gameDataWrapper, 0);
                    OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, IDeviceGame.DESCRIPTOR);
        }

        public static IDeviceGame asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDeviceGame.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDeviceGame)) {
                return (IDeviceGame) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(IDeviceGame.DESCRIPTOR);
            }
            if (i3 != 1598968902) {
                boolean z16 = false;
                switch (i3) {
                    case 1:
                        int start = start((GameInfo) _Parcel.readTypedObject(parcel, GameInfo.CREATOR));
                        parcel2.writeNoException();
                        parcel2.writeInt(start);
                        return true;
                    case 2:
                        int startRound = startRound((GameInfo) _Parcel.readTypedObject(parcel, GameInfo.CREATOR));
                        parcel2.writeNoException();
                        parcel2.writeInt(startRound);
                        return true;
                    case 3:
                        int startWithListener = startWithListener(parcel.readString(), OnRemoteDataChangeListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(startWithListener);
                        return true;
                    case 4:
                        updateData((GameInfo) _Parcel.readTypedObject(parcel, GameInfo.CREATOR), (GameDataWrapper) _Parcel.readTypedObject(parcel, GameDataWrapper.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        setOnResponseListener(OnRemoteResponseListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        endRound((GameInfo) _Parcel.readTypedObject(parcel, GameInfo.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        int end = end((GameInfo) _Parcel.readTypedObject(parcel, GameInfo.CREATOR));
                        parcel2.writeNoException();
                        parcel2.writeInt(end);
                        return true;
                    case 8:
                        resume((GameInfo) _Parcel.readTypedObject(parcel, GameInfo.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        pause((GameInfo) _Parcel.readTypedObject(parcel, GameInfo.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        boolean shouldCallForwarding = shouldCallForwarding();
                        parcel2.writeNoException();
                        parcel2.writeInt(shouldCallForwarding ? 1 : 0);
                        return true;
                    case 11:
                        boolean isPlaying = isPlaying();
                        parcel2.writeNoException();
                        parcel2.writeInt(isPlaying ? 1 : 0);
                        return true;
                    case 12:
                        boolean isWearing = isWearing();
                        parcel2.writeNoException();
                        parcel2.writeInt(isWearing ? 1 : 0);
                        return true;
                    case 13:
                        boolean isConnectGameDevice = isConnectGameDevice();
                        parcel2.writeNoException();
                        parcel2.writeInt(isConnectGameDevice ? 1 : 0);
                        return true;
                    case 14:
                        if (parcel.readInt() != 0) {
                            z16 = true;
                        }
                        setSendConfig(z16);
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        if (parcel.readInt() != 0) {
                            z16 = true;
                        }
                        setVerifyGameSwitch(z16);
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        if (parcel.readInt() != 0) {
                            z16 = true;
                        }
                        onPermissionChanged(z16);
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        setOnRequestGameStatusListener(OnRequestGameStatusListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString(IDeviceGame.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Default implements IDeviceGame {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
        public int end(GameInfo gameInfo) throws RemoteException {
            return 0;
        }

        @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
        public boolean isConnectGameDevice() throws RemoteException {
            return false;
        }

        @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
        public boolean isPlaying() throws RemoteException {
            return false;
        }

        @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
        public boolean isWearing() throws RemoteException {
            return false;
        }

        @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
        public boolean shouldCallForwarding() throws RemoteException {
            return false;
        }

        @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
        public int start(GameInfo gameInfo) throws RemoteException {
            return 0;
        }

        @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
        public int startRound(GameInfo gameInfo) throws RemoteException {
            return 0;
        }

        @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
        public int startWithListener(String str, OnRemoteDataChangeListener onRemoteDataChangeListener) throws RemoteException {
            return 0;
        }

        @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
        public void endRound(GameInfo gameInfo) throws RemoteException {
        }

        @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
        public void onPermissionChanged(boolean z16) throws RemoteException {
        }

        @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
        public void pause(GameInfo gameInfo) throws RemoteException {
        }

        @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
        public void resume(GameInfo gameInfo) throws RemoteException {
        }

        @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
        public void setOnRequestGameStatusListener(OnRequestGameStatusListener onRequestGameStatusListener) throws RemoteException {
        }

        @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
        public void setOnResponseListener(OnRemoteResponseListener onRemoteResponseListener) throws RemoteException {
        }

        @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
        public void setSendConfig(boolean z16) throws RemoteException {
        }

        @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
        public void setVerifyGameSwitch(boolean z16) throws RemoteException {
        }

        @Override // com.heytap.databaseengine.apiv2.device.game.IDeviceGame
        public void updateData(GameInfo gameInfo, GameDataWrapper gameDataWrapper) throws RemoteException {
        }
    }
}
