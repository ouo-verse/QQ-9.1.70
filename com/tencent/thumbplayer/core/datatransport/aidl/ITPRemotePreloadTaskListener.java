package com.tencent.thumbplayer.core.datatransport.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes26.dex */
public interface ITPRemotePreloadTaskListener extends IInterface {
    void onDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str) throws RemoteException;

    void onPrepareError(int i3, int i16, int i17, String str) throws RemoteException;

    void onPrepareFinished(int i3) throws RemoteException;

    /* loaded from: classes26.dex */
    public static abstract class Stub extends Binder implements ITPRemotePreloadTaskListener {
        private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.datatransport.aidl.ITPRemotePreloadTaskListener";
        static final int TRANSACTION_onDownloadProgressUpdate = 1;
        static final int TRANSACTION_onPrepareError = 3;
        static final int TRANSACTION_onPrepareFinished = 2;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes26.dex */
        public static class Proxy implements ITPRemotePreloadTaskListener {
            public static ITPRemotePreloadTaskListener sDefaultImpl;
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

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemotePreloadTaskListener
            public void onDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeInt(i17);
                    obtain.writeLong(j3);
                    obtain.writeLong(j16);
                    obtain.writeString(str);
                    try {
                        if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onDownloadProgressUpdate(i3, i16, i17, j3, j16, str);
                            OaidMonitor.parcelRecycle(obtain2);
                            OaidMonitor.parcelRecycle(obtain);
                        } else {
                            obtain2.readException();
                            OaidMonitor.parcelRecycle(obtain2);
                            OaidMonitor.parcelRecycle(obtain);
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemotePreloadTaskListener
            public void onPrepareError(int i3, int i16, int i17, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeInt(i17);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPrepareError(i3, i16, i17, str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemotePreloadTaskListener
            public void onPrepareFinished(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPrepareFinished(i3);
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

        public static ITPRemotePreloadTaskListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITPRemotePreloadTaskListener)) {
                return (ITPRemotePreloadTaskListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static ITPRemotePreloadTaskListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ITPRemotePreloadTaskListener iTPRemotePreloadTaskListener) {
            if (Proxy.sDefaultImpl == null) {
                if (iTPRemotePreloadTaskListener != null) {
                    Proxy.sDefaultImpl = iTPRemotePreloadTaskListener;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 1598968902) {
                            return super.onTransact(i3, parcel, parcel2, i16);
                        }
                        parcel2.writeString(DESCRIPTOR);
                        return true;
                    }
                    parcel.enforceInterface(DESCRIPTOR);
                    onPrepareError(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                onPrepareFinished(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onDownloadProgressUpdate(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes26.dex */
    public static class Default implements ITPRemotePreloadTaskListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemotePreloadTaskListener
        public void onPrepareFinished(int i3) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemotePreloadTaskListener
        public void onPrepareError(int i3, int i16, int i17, String str) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemotePreloadTaskListener
        public void onDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str) throws RemoteException {
        }
    }
}
