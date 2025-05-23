package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IAIDLCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.core.aidl.IAIDLCallback";

    void call(DataBuffer dataBuffer) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IAIDLCallback {
        static final int TRANSACTION_call = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static class a implements IAIDLCallback {

            /* renamed from: b, reason: collision with root package name */
            public static IAIDLCallback f36901b;

            /* renamed from: a, reason: collision with root package name */
            private IBinder f36902a;

            a(IBinder iBinder) {
                this.f36902a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f36902a;
            }

            @Override // com.huawei.hms.core.aidl.IAIDLCallback
            public void call(DataBuffer dataBuffer) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IAIDLCallback.DESCRIPTOR);
                    if (dataBuffer != null) {
                        obtain.writeInt(1);
                        dataBuffer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f36902a, 1, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().call(dataBuffer);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, IAIDLCallback.DESCRIPTOR);
        }

        public static IAIDLCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IAIDLCallback.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IAIDLCallback)) {
                return (IAIDLCallback) queryLocalInterface;
            }
            return new a(iBinder);
        }

        public static IAIDLCallback getDefaultImpl() {
            return a.f36901b;
        }

        public static boolean setDefaultImpl(IAIDLCallback iAIDLCallback) {
            if (a.f36901b == null) {
                if (iAIDLCallback != null) {
                    a.f36901b = iAIDLCallback;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            DataBuffer dataBuffer;
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel.enforceInterface(IAIDLCallback.DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    dataBuffer = DataBuffer.CREATOR.createFromParcel(parcel);
                } else {
                    dataBuffer = null;
                }
                call(dataBuffer);
                return true;
            }
            parcel2.writeString(IAIDLCallback.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
