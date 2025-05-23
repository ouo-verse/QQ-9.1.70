package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.core.aidl.IAIDLCallback;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IAIDLInvoke extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.core.aidl.IAIDLInvoke";

    void asyncCall(DataBuffer dataBuffer, IAIDLCallback iAIDLCallback) throws RemoteException;

    void syncCall(DataBuffer dataBuffer) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IAIDLInvoke {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static class a implements IAIDLInvoke {

            /* renamed from: b, reason: collision with root package name */
            public static IAIDLInvoke f36903b;

            /* renamed from: a, reason: collision with root package name */
            private IBinder f36904a;

            a(IBinder iBinder) {
                this.f36904a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f36904a;
            }

            @Override // com.huawei.hms.core.aidl.IAIDLInvoke
            public void asyncCall(DataBuffer dataBuffer, IAIDLCallback iAIDLCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IAIDLInvoke.DESCRIPTOR);
                    if (dataBuffer != null) {
                        obtain.writeInt(1);
                        dataBuffer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iAIDLCallback != null) {
                        iBinder = iAIDLCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f36904a, 2, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().asyncCall(dataBuffer, iAIDLCallback);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.core.aidl.IAIDLInvoke
            public void syncCall(DataBuffer dataBuffer) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IAIDLInvoke.DESCRIPTOR);
                    if (dataBuffer != null) {
                        obtain.writeInt(1);
                        dataBuffer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f36904a, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().syncCall(dataBuffer);
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
            attachInterface(this, IAIDLInvoke.DESCRIPTOR);
        }

        public static IAIDLInvoke asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IAIDLInvoke.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IAIDLInvoke)) {
                return (IAIDLInvoke) queryLocalInterface;
            }
            return new a(iBinder);
        }

        public static IAIDLInvoke getDefaultImpl() {
            return a.f36903b;
        }

        public static boolean setDefaultImpl(IAIDLInvoke iAIDLInvoke) {
            if (a.f36903b == null) {
                if (iAIDLInvoke != null) {
                    a.f36903b = iAIDLInvoke;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                DataBuffer dataBuffer = null;
                if (i3 != 1) {
                    if (i3 != 2) {
                        return super.onTransact(i3, parcel, parcel2, i16);
                    }
                    parcel.enforceInterface(IAIDLInvoke.DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        dataBuffer = DataBuffer.CREATOR.createFromParcel(parcel);
                    }
                    asyncCall(dataBuffer, IAIDLCallback.Stub.asInterface(parcel.readStrongBinder()));
                    return true;
                }
                parcel.enforceInterface(IAIDLInvoke.DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    dataBuffer = DataBuffer.CREATOR.createFromParcel(parcel);
                }
                syncCall(dataBuffer);
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString(IAIDLInvoke.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
