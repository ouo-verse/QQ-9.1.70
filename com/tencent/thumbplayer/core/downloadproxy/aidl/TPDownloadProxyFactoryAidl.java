package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyInfoCallbackAidl;

/* loaded from: classes26.dex */
public interface TPDownloadProxyFactoryAidl extends IInterface {
    String getNativeVersion() throws RemoteException;

    ITPDownloadProxyAidl getTPDownloadProxy(int i3) throws RemoteException;

    boolean isReadyForDownload() throws RemoteException;

    boolean isReadyForPlay() throws RemoteException;

    boolean pushEvent(int i3) throws RemoteException;

    void registerProxyInfoCallback(ITPDownloadProxyInfoCallbackAidl iTPDownloadProxyInfoCallbackAidl) throws RemoteException;

    /* loaded from: classes26.dex */
    public static abstract class Stub extends Binder implements TPDownloadProxyFactoryAidl {
        private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl";
        static final int TRANSACTION_getNativeVersion = 4;
        static final int TRANSACTION_getTPDownloadProxy = 1;
        static final int TRANSACTION_isReadyForDownload = 3;
        static final int TRANSACTION_isReadyForPlay = 2;
        static final int TRANSACTION_pushEvent = 5;
        static final int TRANSACTION_registerProxyInfoCallback = 6;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes26.dex */
        public static class Proxy implements TPDownloadProxyFactoryAidl {
            public static TPDownloadProxyFactoryAidl sDefaultImpl;
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

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
            public String getNativeVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getNativeVersion();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
            public ITPDownloadProxyAidl getTPDownloadProxy(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getTPDownloadProxy(i3);
                    }
                    obtain2.readException();
                    return ITPDownloadProxyAidl.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
            public boolean isReadyForDownload() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isReadyForDownload();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
            public boolean isReadyForPlay() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isReadyForPlay();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
            public boolean pushEvent(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().pushEvent(i3);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
            public void registerProxyInfoCallback(ITPDownloadProxyInfoCallbackAidl iTPDownloadProxyInfoCallbackAidl) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (iTPDownloadProxyInfoCallbackAidl != null) {
                        iBinder = iTPDownloadProxyInfoCallbackAidl.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerProxyInfoCallback(iTPDownloadProxyInfoCallbackAidl);
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

        public static TPDownloadProxyFactoryAidl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof TPDownloadProxyFactoryAidl)) {
                return (TPDownloadProxyFactoryAidl) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static TPDownloadProxyFactoryAidl getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(TPDownloadProxyFactoryAidl tPDownloadProxyFactoryAidl) {
            if (Proxy.sDefaultImpl == null) {
                if (tPDownloadProxyFactoryAidl != null) {
                    Proxy.sDefaultImpl = tPDownloadProxyFactoryAidl;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            IBinder iBinder;
            if (i3 != 1598968902) {
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        ITPDownloadProxyAidl tPDownloadProxy = getTPDownloadProxy(parcel.readInt());
                        parcel2.writeNoException();
                        if (tPDownloadProxy != null) {
                            iBinder = tPDownloadProxy.asBinder();
                        } else {
                            iBinder = null;
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isReadyForPlay = isReadyForPlay();
                        parcel2.writeNoException();
                        parcel2.writeInt(isReadyForPlay ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isReadyForDownload = isReadyForDownload();
                        parcel2.writeNoException();
                        parcel2.writeInt(isReadyForDownload ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        String nativeVersion = getNativeVersion();
                        parcel2.writeNoException();
                        parcel2.writeString(nativeVersion);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean pushEvent = pushEvent(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(pushEvent ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        registerProxyInfoCallback(ITPDownloadProxyInfoCallbackAidl.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
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
    public static class Default implements TPDownloadProxyFactoryAidl {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
        public String getNativeVersion() throws RemoteException {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
        public ITPDownloadProxyAidl getTPDownloadProxy(int i3) throws RemoteException {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
        public boolean isReadyForDownload() throws RemoteException {
            return false;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
        public boolean isReadyForPlay() throws RemoteException {
            return false;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
        public boolean pushEvent(int i3) throws RemoteException {
            return false;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
        public void registerProxyInfoCallback(ITPDownloadProxyInfoCallbackAidl iTPDownloadProxyInfoCallbackAidl) throws RemoteException {
        }
    }
}
