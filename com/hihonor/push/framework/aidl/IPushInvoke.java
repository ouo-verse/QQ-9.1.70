package com.hihonor.push.framework.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hihonor.push.framework.aidl.IPushCallback;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes2.dex */
public interface IPushInvoke extends IInterface {
    void call(DataBuffer dataBuffer, IPushCallback iPushCallback);

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IPushInvoke {
        private static final String DESCRIPTOR = "com.hihonor.push.framework.aidl.IPushInvoke";
        public static final int TRANSACTION_call = 1;

        /* loaded from: classes2.dex */
        public static class Proxy implements IPushInvoke {
            public static IPushInvoke sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.hihonor.push.framework.aidl.IPushInvoke
            public void call(DataBuffer dataBuffer, IPushCallback iPushCallback) {
                IBinder iBinder;
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
                    if (iPushCallback != null) {
                        iBinder = iPushCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().call(dataBuffer, iPushCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPushInvoke asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPushInvoke)) {
                return (IPushInvoke) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IPushInvoke getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IPushInvoke iPushInvoke) {
            if (Proxy.sDefaultImpl == null) {
                if (iPushInvoke != null) {
                    Proxy.sDefaultImpl = iPushInvoke;
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
            call(dataBuffer, IPushCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class Default implements IPushInvoke {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.hihonor.push.framework.aidl.IPushInvoke
        public void call(DataBuffer dataBuffer, IPushCallback iPushCallback) {
        }
    }
}
