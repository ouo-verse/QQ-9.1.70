package com.tencent.zplan;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes27.dex */
public interface IZPlanEngineStatusCallback extends IInterface {
    void onEngineDestroyed() throws RemoteException;

    void onEngineFirstFrame() throws RemoteException;

    void onEngineInitFinish(boolean z16) throws RemoteException;

    void onEngineInversePurged() throws RemoteException;

    void onEnginePurged() throws RemoteException;

    void onEnginePurging() throws RemoteException;

    void onEngineSuspended() throws RemoteException;

    /* loaded from: classes27.dex */
    public static class Default implements IZPlanEngineStatusCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.zplan.IZPlanEngineStatusCallback
        public void onEngineDestroyed() throws RemoteException {
        }

        @Override // com.tencent.zplan.IZPlanEngineStatusCallback
        public void onEngineFirstFrame() throws RemoteException {
        }

        @Override // com.tencent.zplan.IZPlanEngineStatusCallback
        public void onEngineInversePurged() throws RemoteException {
        }

        @Override // com.tencent.zplan.IZPlanEngineStatusCallback
        public void onEnginePurged() throws RemoteException {
        }

        @Override // com.tencent.zplan.IZPlanEngineStatusCallback
        public void onEnginePurging() throws RemoteException {
        }

        @Override // com.tencent.zplan.IZPlanEngineStatusCallback
        public void onEngineSuspended() throws RemoteException {
        }

        @Override // com.tencent.zplan.IZPlanEngineStatusCallback
        public void onEngineInitFinish(boolean z16) throws RemoteException {
        }
    }

    /* loaded from: classes27.dex */
    public static abstract class Stub extends Binder implements IZPlanEngineStatusCallback {
        private static final String DESCRIPTOR = "com.tencent.zplan.IZPlanEngineStatusCallback";
        static final int TRANSACTION_onEngineDestroyed = 3;
        static final int TRANSACTION_onEngineFirstFrame = 2;
        static final int TRANSACTION_onEngineInitFinish = 1;
        static final int TRANSACTION_onEngineInversePurged = 6;
        static final int TRANSACTION_onEnginePurged = 5;
        static final int TRANSACTION_onEnginePurging = 4;
        static final int TRANSACTION_onEngineSuspended = 7;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes27.dex */
        public static class Proxy implements IZPlanEngineStatusCallback {
            public static IZPlanEngineStatusCallback sDefaultImpl;
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

            @Override // com.tencent.zplan.IZPlanEngineStatusCallback
            public void onEngineDestroyed() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onEngineDestroyed();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.IZPlanEngineStatusCallback
            public void onEngineFirstFrame() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onEngineFirstFrame();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.IZPlanEngineStatusCallback
            public void onEngineInitFinish(boolean z16) throws RemoteException {
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
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onEngineInitFinish(z16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.IZPlanEngineStatusCallback
            public void onEngineInversePurged() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onEngineInversePurged();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.IZPlanEngineStatusCallback
            public void onEnginePurged() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onEnginePurged();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.IZPlanEngineStatusCallback
            public void onEnginePurging() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onEnginePurging();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.IZPlanEngineStatusCallback
            public void onEngineSuspended() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onEngineSuspended();
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

        public static IZPlanEngineStatusCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IZPlanEngineStatusCallback)) {
                return (IZPlanEngineStatusCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IZPlanEngineStatusCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IZPlanEngineStatusCallback iZPlanEngineStatusCallback) {
            if (Proxy.sDefaultImpl == null && iZPlanEngineStatusCallback != null) {
                Proxy.sDefaultImpl = iZPlanEngineStatusCallback;
                return true;
            }
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            boolean z16;
            if (i3 != 1598968902) {
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        onEngineInitFinish(z16);
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        onEngineFirstFrame();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        onEngineDestroyed();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        onEnginePurging();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        onEnginePurged();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        onEngineInversePurged();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        onEngineSuspended();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
