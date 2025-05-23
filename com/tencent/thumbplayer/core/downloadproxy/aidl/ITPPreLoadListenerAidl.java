package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes26.dex */
public interface ITPPreLoadListenerAidl extends IInterface {
    void onPcdnDownloadFailed(String str) throws RemoteException;

    void onPrepareDownloadProgressUpdate(int i3, int i16, long j3, long j16, String str) throws RemoteException;

    void onPrepareError(int i3, int i16, String str) throws RemoteException;

    void onPrepareOK() throws RemoteException;

    /* loaded from: classes26.dex */
    public static class Default implements ITPPreLoadListenerAidl {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
        public void onPrepareOK() throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
        public void onPcdnDownloadFailed(String str) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
        public void onPrepareError(int i3, int i16, String str) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
        public void onPrepareDownloadProgressUpdate(int i3, int i16, long j3, long j16, String str) throws RemoteException {
        }
    }

    /* loaded from: classes26.dex */
    public static abstract class Stub extends Binder implements ITPPreLoadListenerAidl {
        private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl";
        static final int TRANSACTION_onPcdnDownloadFailed = 4;
        static final int TRANSACTION_onPrepareDownloadProgressUpdate = 3;
        static final int TRANSACTION_onPrepareError = 2;
        static final int TRANSACTION_onPrepareOK = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes26.dex */
        public static class Proxy implements ITPPreLoadListenerAidl {
            public static ITPPreLoadListenerAidl sDefaultImpl;
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

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
            public void onPcdnDownloadFailed(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPcdnDownloadFailed(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
            public void onPrepareDownloadProgressUpdate(int i3, int i16, long j3, long j16, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeLong(j3);
                    obtain.writeLong(j16);
                    obtain.writeString(str);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPrepareDownloadProgressUpdate(i3, i16, j3, j16, str);
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                    } else {
                        obtain2.readException();
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    throw th;
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
            public void onPrepareError(int i3, int i16, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPrepareError(i3, i16, str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
            public void onPrepareOK() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPrepareOK();
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

        public static ITPPreLoadListenerAidl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITPPreLoadListenerAidl)) {
                return (ITPPreLoadListenerAidl) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static ITPPreLoadListenerAidl getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ITPPreLoadListenerAidl iTPPreLoadListenerAidl) {
            if (Proxy.sDefaultImpl == null) {
                if (iTPPreLoadListenerAidl != null) {
                    Proxy.sDefaultImpl = iTPPreLoadListenerAidl;
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
                        if (i3 != 4) {
                            if (i3 != 1598968902) {
                                return super.onTransact(i3, parcel, parcel2, i16);
                            }
                            parcel2.writeString(DESCRIPTOR);
                            return true;
                        }
                        parcel.enforceInterface(DESCRIPTOR);
                        onPcdnDownloadFailed(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    }
                    parcel.enforceInterface(DESCRIPTOR);
                    onPrepareDownloadProgressUpdate(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                onPrepareError(parcel.readInt(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onPrepareOK();
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
