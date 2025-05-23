package com.tencent.thumbplayer.core.datatransport.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes26.dex */
public interface ITPRemoteTaskListener extends IInterface {
    long getCurrentPlayOffset(int i3) throws RemoteException;

    long getCurrentPosition(int i3) throws RemoteException;

    long getPlayerBufferLength(int i3) throws RemoteException;

    long getRemainTimeBeforePlayMs(int i3) throws RemoteException;

    void onCommonMessageCallback(int i3, int i16, TPDataTransportMessageInfo tPDataTransportMessageInfo) throws RemoteException;

    void onDownloadError(int i3, int i16, int i17, String str) throws RemoteException;

    void onDownloadFinished(int i3) throws RemoteException;

    void onDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str) throws RemoteException;

    /* loaded from: classes26.dex */
    public static abstract class Stub extends Binder implements ITPRemoteTaskListener {
        private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener";
        static final int TRANSACTION_getCurrentPlayOffset = 7;
        static final int TRANSACTION_getCurrentPosition = 6;
        static final int TRANSACTION_getPlayerBufferLength = 5;
        static final int TRANSACTION_getRemainTimeBeforePlayMs = 8;
        static final int TRANSACTION_onCommonMessageCallback = 4;
        static final int TRANSACTION_onDownloadError = 3;
        static final int TRANSACTION_onDownloadFinished = 2;
        static final int TRANSACTION_onDownloadProgressUpdate = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes26.dex */
        public static class Proxy implements ITPRemoteTaskListener {
            public static ITPRemoteTaskListener sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
            public long getCurrentPlayOffset(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCurrentPlayOffset(i3);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
            public long getCurrentPosition(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCurrentPosition(i3);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
            public long getPlayerBufferLength(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPlayerBufferLength(i3);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
            public long getRemainTimeBeforePlayMs(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRemainTimeBeforePlayMs(i3);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
            public void onCommonMessageCallback(int i3, int i16, TPDataTransportMessageInfo tPDataTransportMessageInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (tPDataTransportMessageInfo != null) {
                        obtain.writeInt(1);
                        tPDataTransportMessageInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onCommonMessageCallback(i3, i16, tPDataTransportMessageInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
            public void onDownloadError(int i3, int i16, int i17, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeInt(i17);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDownloadError(i3, i16, i17, str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
            public void onDownloadFinished(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDownloadFinished(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
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
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITPRemoteTaskListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITPRemoteTaskListener)) {
                return (ITPRemoteTaskListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static ITPRemoteTaskListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ITPRemoteTaskListener iTPRemoteTaskListener) {
            if (Proxy.sDefaultImpl == null) {
                if (iTPRemoteTaskListener != null) {
                    Proxy.sDefaultImpl = iTPRemoteTaskListener;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            TPDataTransportMessageInfo tPDataTransportMessageInfo;
            if (i3 != 1598968902) {
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDownloadProgressUpdate(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDownloadFinished(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDownloadError(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        int readInt = parcel.readInt();
                        int readInt2 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            tPDataTransportMessageInfo = TPDataTransportMessageInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            tPDataTransportMessageInfo = null;
                        }
                        onCommonMessageCallback(readInt, readInt2, tPDataTransportMessageInfo);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        long playerBufferLength = getPlayerBufferLength(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(playerBufferLength);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        long currentPosition = getCurrentPosition(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(currentPosition);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        long currentPlayOffset = getCurrentPlayOffset(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(currentPlayOffset);
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        long remainTimeBeforePlayMs = getRemainTimeBeforePlayMs(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(remainTimeBeforePlayMs);
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

    /* loaded from: classes26.dex */
    public static class Default implements ITPRemoteTaskListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
        public long getCurrentPlayOffset(int i3) throws RemoteException {
            return 0L;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
        public long getCurrentPosition(int i3) throws RemoteException {
            return 0L;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
        public long getPlayerBufferLength(int i3) throws RemoteException {
            return 0L;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
        public long getRemainTimeBeforePlayMs(int i3) throws RemoteException {
            return 0L;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
        public void onDownloadFinished(int i3) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
        public void onCommonMessageCallback(int i3, int i16, TPDataTransportMessageInfo tPDataTransportMessageInfo) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
        public void onDownloadError(int i3, int i16, int i17, String str) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener
        public void onDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str) throws RemoteException {
        }
    }
}
