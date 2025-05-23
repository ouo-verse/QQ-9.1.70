package com.tencent.qphone.base.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IBaseService extends IInterface {
    public static final String DESCRIPTOR = "com.tencent.qphone.base.remote.IBaseService";

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Default implements IBaseService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.qphone.base.remote.IBaseService
        public int getMsfConnectedIPFamily() throws RemoteException {
            return 0;
        }

        @Override // com.tencent.qphone.base.remote.IBaseService
        public int getMsfConnectedNetType() throws RemoteException {
            return 0;
        }

        @Override // com.tencent.qphone.base.remote.IBaseService
        public int onApplicationBackground() throws RemoteException {
            return 0;
        }

        @Override // com.tencent.qphone.base.remote.IBaseService
        public int onApplicationForeground() throws RemoteException {
            return 0;
        }

        @Override // com.tencent.qphone.base.remote.IBaseService
        public int onKillProcess() throws RemoteException {
            return 0;
        }

        @Override // com.tencent.qphone.base.remote.IBaseService
        public int onProcessViewableChanged(boolean z16, long j3, String str) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.qphone.base.remote.IBaseService
        public FromServiceMsg sendSyncToServiceMsg(ToServiceMsg toServiceMsg) throws RemoteException {
            return null;
        }

        @Override // com.tencent.qphone.base.remote.IBaseService
        public int sendToServiceMsg(ToServiceMsg toServiceMsg) throws RemoteException {
            return 0;
        }
    }

    int getMsfConnectedIPFamily() throws RemoteException;

    int getMsfConnectedNetType() throws RemoteException;

    int onApplicationBackground() throws RemoteException;

    int onApplicationForeground() throws RemoteException;

    int onKillProcess() throws RemoteException;

    int onProcessViewableChanged(boolean z16, long j3, String str) throws RemoteException;

    FromServiceMsg sendSyncToServiceMsg(ToServiceMsg toServiceMsg) throws RemoteException;

    int sendToServiceMsg(ToServiceMsg toServiceMsg) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static abstract class Stub extends Binder implements IBaseService {
        static final int TRANSACTION_getMsfConnectedIPFamily = 4;
        static final int TRANSACTION_getMsfConnectedNetType = 3;
        static final int TRANSACTION_onApplicationBackground = 7;
        static final int TRANSACTION_onApplicationForeground = 6;
        static final int TRANSACTION_onKillProcess = 8;
        static final int TRANSACTION_onProcessViewableChanged = 5;
        static final int TRANSACTION_sendSyncToServiceMsg = 1;
        static final int TRANSACTION_sendToServiceMsg = 2;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes22.dex */
        public static class Proxy implements IBaseService {
            public static IBaseService sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IBaseService.DESCRIPTOR;
            }

            @Override // com.tencent.qphone.base.remote.IBaseService
            public int getMsfConnectedIPFamily() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IBaseService.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMsfConnectedIPFamily();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IBaseService
            public int getMsfConnectedNetType() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IBaseService.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMsfConnectedNetType();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IBaseService
            public int onApplicationBackground() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IBaseService.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().onApplicationBackground();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IBaseService
            public int onApplicationForeground() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IBaseService.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().onApplicationForeground();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IBaseService
            public int onKillProcess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IBaseService.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().onKillProcess();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IBaseService
            public int onProcessViewableChanged(boolean z16, long j3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IBaseService.DESCRIPTOR);
                    obtain.writeInt(z16 ? 1 : 0);
                    obtain.writeLong(j3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().onProcessViewableChanged(z16, j3, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IBaseService
            public FromServiceMsg sendSyncToServiceMsg(ToServiceMsg toServiceMsg) throws RemoteException {
                FromServiceMsg fromServiceMsg;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IBaseService.DESCRIPTOR);
                    if (toServiceMsg != null) {
                        obtain.writeInt(1);
                        toServiceMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().sendSyncToServiceMsg(toServiceMsg);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        fromServiceMsg = FromServiceMsg.CREATOR.createFromParcel(obtain2);
                    } else {
                        fromServiceMsg = null;
                    }
                    return fromServiceMsg;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IBaseService
            public int sendToServiceMsg(ToServiceMsg toServiceMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IBaseService.DESCRIPTOR);
                    if (toServiceMsg != null) {
                        obtain.writeInt(1);
                        toServiceMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().sendToServiceMsg(toServiceMsg);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, IBaseService.DESCRIPTOR);
        }

        public static IBaseService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IBaseService.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IBaseService)) {
                return (IBaseService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IBaseService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IBaseService iBaseService) {
            if (Proxy.sDefaultImpl == null) {
                if (iBaseService != null) {
                    Proxy.sDefaultImpl = iBaseService;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                boolean z16 = false;
                ToServiceMsg toServiceMsg = null;
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(IBaseService.DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            toServiceMsg = ToServiceMsg.CREATOR.createFromParcel(parcel);
                        }
                        FromServiceMsg sendSyncToServiceMsg = sendSyncToServiceMsg(toServiceMsg);
                        parcel2.writeNoException();
                        if (sendSyncToServiceMsg != null) {
                            parcel2.writeInt(1);
                            sendSyncToServiceMsg.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface(IBaseService.DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            toServiceMsg = ToServiceMsg.CREATOR.createFromParcel(parcel);
                        }
                        int sendToServiceMsg = sendToServiceMsg(toServiceMsg);
                        parcel2.writeNoException();
                        parcel2.writeInt(sendToServiceMsg);
                        return true;
                    case 3:
                        parcel.enforceInterface(IBaseService.DESCRIPTOR);
                        int msfConnectedNetType = getMsfConnectedNetType();
                        parcel2.writeNoException();
                        parcel2.writeInt(msfConnectedNetType);
                        return true;
                    case 4:
                        parcel.enforceInterface(IBaseService.DESCRIPTOR);
                        int msfConnectedIPFamily = getMsfConnectedIPFamily();
                        parcel2.writeNoException();
                        parcel2.writeInt(msfConnectedIPFamily);
                        return true;
                    case 5:
                        parcel.enforceInterface(IBaseService.DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z16 = true;
                        }
                        int onProcessViewableChanged = onProcessViewableChanged(z16, parcel.readLong(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(onProcessViewableChanged);
                        return true;
                    case 6:
                        parcel.enforceInterface(IBaseService.DESCRIPTOR);
                        int onApplicationForeground = onApplicationForeground();
                        parcel2.writeNoException();
                        parcel2.writeInt(onApplicationForeground);
                        return true;
                    case 7:
                        parcel.enforceInterface(IBaseService.DESCRIPTOR);
                        int onApplicationBackground = onApplicationBackground();
                        parcel2.writeNoException();
                        parcel2.writeInt(onApplicationBackground);
                        return true;
                    case 8:
                        parcel.enforceInterface(IBaseService.DESCRIPTOR);
                        int onKillProcess = onKillProcess();
                        parcel2.writeNoException();
                        parcel2.writeInt(onKillProcess);
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString(IBaseService.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
