package com.heytap.databaseengine.apiv2.device;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.heytap.databaseengine.callback.ICommonListener;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IDeviceInfoManager extends IInterface {
    public static final String DESCRIPTOR = "com.heytap.databaseengine.apiv2.device.IDeviceInfoManager";

    void getUserBoundDevices(ICommonListener iCommonListener) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IDeviceInfoManager {
        static final int TRANSACTION_getUserBoundDevices = 1;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private static class Proxy implements IDeviceInfoManager {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDeviceInfoManager.DESCRIPTOR;
            }

            @Override // com.heytap.databaseengine.apiv2.device.IDeviceInfoManager
            public void getUserBoundDevices(ICommonListener iCommonListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDeviceInfoManager.DESCRIPTOR);
                    obtain.writeStrongInterface(iCommonListener);
                    OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, IDeviceInfoManager.DESCRIPTOR);
        }

        public static IDeviceInfoManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDeviceInfoManager.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDeviceInfoManager)) {
                return (IDeviceInfoManager) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(IDeviceInfoManager.DESCRIPTOR);
            }
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                getUserBoundDevices(ICommonListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString(IDeviceInfoManager.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Default implements IDeviceInfoManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.databaseengine.apiv2.device.IDeviceInfoManager
        public void getUserBoundDevices(ICommonListener iCommonListener) throws RemoteException {
        }
    }
}
