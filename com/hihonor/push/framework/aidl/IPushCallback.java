package com.hihonor.push.framework.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes2.dex */
public interface IPushCallback extends IInterface {
    void onResult(DataBuffer dataBuffer);

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IPushCallback {
        private static final String DESCRIPTOR = "com.hihonor.push.framework.aidl.IPushCallback";
        public static final int TRANSACTION_onResult = 1;

        /* loaded from: classes2.dex */
        public static class Proxy implements IPushCallback {
            public static IPushCallback sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.hihonor.push.framework.aidl.IPushCallback
            public void onResult(DataBuffer dataBuffer) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (dataBuffer != null) {
                        obtain.writeInt(1);
                        dataBuffer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onResult(dataBuffer);
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

        public static IPushCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPushCallback)) {
                return (IPushCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IPushCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IPushCallback iPushCallback) {
            if (Proxy.sDefaultImpl == null) {
                if (iPushCallback != null) {
                    Proxy.sDefaultImpl = iPushCallback;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) {
            DataBuffer dataBuffer;
            if (i3 != 1) {
                if (i3 != 1598968902) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            if (parcel.readInt() != 0) {
                dataBuffer = DataBuffer.CREATOR.createFromParcel(parcel);
            } else {
                dataBuffer = null;
            }
            onResult(dataBuffer);
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class Default implements IPushCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.hihonor.push.framework.aidl.IPushCallback
        public void onResult(DataBuffer dataBuffer) {
        }
    }
}
