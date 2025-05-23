package com.tencent.zplan;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.zplan.world.model.ZPlanWorld;

/* loaded from: classes27.dex */
public interface IZPlanWorldCallback extends IInterface {
    void onGetZPlanWorld(ZPlanWorld zPlanWorld) throws RemoteException;

    /* loaded from: classes27.dex */
    public static abstract class Stub extends Binder implements IZPlanWorldCallback {
        private static final String DESCRIPTOR = "com.tencent.zplan.IZPlanWorldCallback";
        static final int TRANSACTION_onGetZPlanWorld = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes27.dex */
        public static class Proxy implements IZPlanWorldCallback {
            public static IZPlanWorldCallback sDefaultImpl;
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

            @Override // com.tencent.zplan.IZPlanWorldCallback
            public void onGetZPlanWorld(ZPlanWorld zPlanWorld) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (zPlanWorld != null) {
                        obtain.writeInt(1);
                        zPlanWorld.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onGetZPlanWorld(zPlanWorld);
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

        public static IZPlanWorldCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IZPlanWorldCallback)) {
                return (IZPlanWorldCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IZPlanWorldCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IZPlanWorldCallback iZPlanWorldCallback) {
            if (Proxy.sDefaultImpl == null && iZPlanWorldCallback != null) {
                Proxy.sDefaultImpl = iZPlanWorldCallback;
                return true;
            }
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            ZPlanWorld zPlanWorld;
            if (i3 != 1) {
                if (i3 != 1598968902) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            if (parcel.readInt() != 0) {
                zPlanWorld = ZPlanWorld.CREATOR.createFromParcel(parcel);
            } else {
                zPlanWorld = null;
            }
            onGetZPlanWorld(zPlanWorld);
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes27.dex */
    public static class Default implements IZPlanWorldCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.zplan.IZPlanWorldCallback
        public void onGetZPlanWorld(ZPlanWorld zPlanWorld) throws RemoteException {
        }
    }
}
