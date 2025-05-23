package com.tencent.mobileqq.vas.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface ISwitchCallback extends IInterface {
    public static final String DESCRIPTOR = "com.tencent.mobileqq.vas.aidl.ISwitchCallback";

    void beginSwitch() throws RemoteException;

    void doSwitch(String str, String str2) throws RemoteException;

    void onProgress(long j3, long j16) throws RemoteException;

    void postSwitch(int i3) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class Default implements ISwitchCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.mobileqq.vas.aidl.ISwitchCallback
        public void beginSwitch() throws RemoteException {
        }

        @Override // com.tencent.mobileqq.vas.aidl.ISwitchCallback
        public void postSwitch(int i3) throws RemoteException {
        }

        @Override // com.tencent.mobileqq.vas.aidl.ISwitchCallback
        public void doSwitch(String str, String str2) throws RemoteException {
        }

        @Override // com.tencent.mobileqq.vas.aidl.ISwitchCallback
        public void onProgress(long j3, long j16) throws RemoteException {
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static abstract class Stub extends Binder implements ISwitchCallback {
        static final int TRANSACTION_beginSwitch = 1;
        static final int TRANSACTION_doSwitch = 3;
        static final int TRANSACTION_onProgress = 2;
        static final int TRANSACTION_postSwitch = 4;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes20.dex */
        public static class Proxy implements ISwitchCallback {
            public static ISwitchCallback sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mobileqq.vas.aidl.ISwitchCallback
            public void beginSwitch() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, ISwitchCallback.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().beginSwitch();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.vas.aidl.ISwitchCallback
            public void doSwitch(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, ISwitchCallback.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().doSwitch(str, str2);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                return ISwitchCallback.DESCRIPTOR;
            }

            @Override // com.tencent.mobileqq.vas.aidl.ISwitchCallback
            public void onProgress(long j3, long j16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, ISwitchCallback.DESCRIPTOR);
                    obtain.writeLong(j3);
                    obtain.writeLong(j16);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onProgress(j3, j16);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.vas.aidl.ISwitchCallback
            public void postSwitch(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, ISwitchCallback.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().postSwitch(i3);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, ISwitchCallback.DESCRIPTOR);
        }

        public static ISwitchCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ISwitchCallback.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ISwitchCallback)) {
                return (ISwitchCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static ISwitchCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ISwitchCallback iSwitchCallback) {
            if (Proxy.sDefaultImpl == null) {
                if (iSwitchCallback != null) {
                    Proxy.sDefaultImpl = iSwitchCallback;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                return super.onTransact(i3, parcel, parcel2, i16);
                            }
                            parcel.enforceInterface(ISwitchCallback.DESCRIPTOR);
                            postSwitch(parcel.readInt());
                            return true;
                        }
                        parcel.enforceInterface(ISwitchCallback.DESCRIPTOR);
                        doSwitch(parcel.readString(), parcel.readString());
                        return true;
                    }
                    parcel.enforceInterface(ISwitchCallback.DESCRIPTOR);
                    onProgress(parcel.readLong(), parcel.readLong());
                    return true;
                }
                parcel.enforceInterface(ISwitchCallback.DESCRIPTOR);
                beginSwitch();
                return true;
            }
            parcel2.writeString(ISwitchCallback.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
