package com.tencent.thumbplayer.core.datatransport.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes26.dex */
public interface ITPRemoteDataTransportResourceLoaderListener extends IInterface {

    /* loaded from: classes26.dex */
    public static class Default implements ITPRemoteDataTransportResourceLoaderListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener
        public String getContentType(int i3, String str) throws RemoteException {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener
        public String getDataFilePath(int i3, String str) throws RemoteException {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener
        public long getDataTotalSize(int i3, String str) throws RemoteException {
            return 0L;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener
        public int onReadData(int i3, String str, long j3, long j16) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener
        public int onStartReadData(int i3, String str, long j3, long j16) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener
        public int onStopReadData(int i3, String str, int i16) throws RemoteException {
            return 0;
        }
    }

    String getContentType(int i3, String str) throws RemoteException;

    String getDataFilePath(int i3, String str) throws RemoteException;

    long getDataTotalSize(int i3, String str) throws RemoteException;

    int onReadData(int i3, String str, long j3, long j16) throws RemoteException;

    int onStartReadData(int i3, String str, long j3, long j16) throws RemoteException;

    int onStopReadData(int i3, String str, int i16) throws RemoteException;

    /* loaded from: classes26.dex */
    public static abstract class Stub extends Binder implements ITPRemoteDataTransportResourceLoaderListener {
        private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener";
        static final int TRANSACTION_getContentType = 6;
        static final int TRANSACTION_getDataFilePath = 5;
        static final int TRANSACTION_getDataTotalSize = 4;
        static final int TRANSACTION_onReadData = 2;
        static final int TRANSACTION_onStartReadData = 1;
        static final int TRANSACTION_onStopReadData = 3;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes26.dex */
        public static class Proxy implements ITPRemoteDataTransportResourceLoaderListener {
            public static ITPRemoteDataTransportResourceLoaderListener sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener
            public String getContentType(int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getContentType(i3, str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener
            public String getDataFilePath(int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDataFilePath(i3, str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener
            public long getDataTotalSize(int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDataTotalSize(i3, str);
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

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener
            public int onReadData(int i3, String str, long j3, long j16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeLong(j3);
                    obtain.writeLong(j16);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        int onReadData = Stub.getDefaultImpl().onReadData(i3, str, j3, j16);
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        return onReadData;
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return readInt;
                } catch (Throwable th6) {
                    th = th6;
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    throw th;
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener
            public int onStartReadData(int i3, String str, long j3, long j16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeLong(j3);
                    obtain.writeLong(j16);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        int onStartReadData = Stub.getDefaultImpl().onStartReadData(i3, str, j3, j16);
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        return onStartReadData;
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return readInt;
                } catch (Throwable th6) {
                    th = th6;
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    throw th;
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener
            public int onStopReadData(int i3, String str, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().onStopReadData(i3, str, i16);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITPRemoteDataTransportResourceLoaderListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITPRemoteDataTransportResourceLoaderListener)) {
                return (ITPRemoteDataTransportResourceLoaderListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static ITPRemoteDataTransportResourceLoaderListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ITPRemoteDataTransportResourceLoaderListener iTPRemoteDataTransportResourceLoaderListener) {
            if (Proxy.sDefaultImpl == null) {
                if (iTPRemoteDataTransportResourceLoaderListener != null) {
                    Proxy.sDefaultImpl = iTPRemoteDataTransportResourceLoaderListener;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        int onStartReadData = onStartReadData(parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(onStartReadData);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        int onReadData = onReadData(parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(onReadData);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        int onStopReadData = onStopReadData(parcel.readInt(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(onStopReadData);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        long dataTotalSize = getDataTotalSize(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeLong(dataTotalSize);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        String dataFilePath = getDataFilePath(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(dataFilePath);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        String contentType = getContentType(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(contentType);
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
}
