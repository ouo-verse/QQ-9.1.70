package com.tencent.mobileqq.vas.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface IDownloadListener extends IInterface {
    public static final String DESCRIPTOR = "com.tencent.mobileqq.vas.aidl.IDownloadListener";

    void onComplete(String str, int i3) throws RemoteException;

    void onProgress(String str, long j3, long j16) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static abstract class Stub extends Binder implements IDownloadListener {
        static final int TRANSACTION_onComplete = 2;
        static final int TRANSACTION_onProgress = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes20.dex */
        public static class Proxy implements IDownloadListener {
            public static IDownloadListener sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDownloadListener.DESCRIPTOR;
            }

            @Override // com.tencent.mobileqq.vas.aidl.IDownloadListener
            public void onComplete(String str, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDownloadListener.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onComplete(str, i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.vas.aidl.IDownloadListener
            public void onProgress(String str, long j3, long j16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IDownloadListener.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeLong(j3);
                    obtain.writeLong(j16);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onProgress(str, j3, j16);
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
            attachInterface(this, IDownloadListener.DESCRIPTOR);
        }

        public static IDownloadListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDownloadListener.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDownloadListener)) {
                return (IDownloadListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IDownloadListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDownloadListener iDownloadListener) {
            if (Proxy.sDefaultImpl == null) {
                if (iDownloadListener != null) {
                    Proxy.sDefaultImpl = iDownloadListener;
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
                        return super.onTransact(i3, parcel, parcel2, i16);
                    }
                    parcel.enforceInterface(IDownloadListener.DESCRIPTOR);
                    onComplete(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface(IDownloadListener.DESCRIPTOR);
                onProgress(parcel.readString(), parcel.readLong(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString(IDownloadListener.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class Default implements IDownloadListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.mobileqq.vas.aidl.IDownloadListener
        public void onComplete(String str, int i3) throws RemoteException {
        }

        @Override // com.tencent.mobileqq.vas.aidl.IDownloadListener
        public void onProgress(String str, long j3, long j16) throws RemoteException {
        }
    }
}
