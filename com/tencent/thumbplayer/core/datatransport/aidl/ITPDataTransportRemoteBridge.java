package com.tencent.thumbplayer.core.datatransport.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote;
import com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteCommonInfoListener;

/* loaded from: classes26.dex */
public interface ITPDataTransportRemoteBridge extends IInterface {
    int checkFileCacheStatus(int i3, String str, int i16) throws RemoteException;

    boolean clearCache(int i3, String str, int i16) throws RemoteException;

    boolean clearRangeCache(int i3, String str, int i16, int i17) throws RemoteException;

    String getBizAccessibleNativeInfo(int i3, int i16) throws RemoteException;

    long getFileCacheSize(int i3, String str) throws RemoteException;

    String getGlobalAccessibleNativeInfo(int i3) throws RemoteException;

    String getNativeVersion() throws RemoteException;

    ITPDataTransportRemote getRemoteDataTransport() throws RemoteException;

    int initBizId(int i3) throws RemoteException;

    boolean isNativeInit() throws RemoteException;

    int registerAssignedBizId(int i3, String str) throws RemoteException;

    int registerBizId(String str) throws RemoteException;

    void registerCommonInfoListener(ITPDataTransportRemoteCommonInfoListener iTPDataTransportRemoteCommonInfoListener) throws RemoteException;

    boolean setBizOptionalConfigParam(int i3, String str, String str2) throws RemoteException;

    boolean setGlobalOptionalConfigParam(String str, String str2) throws RemoteException;

    void unregisterBizId(int i3) throws RemoteException;

    /* loaded from: classes26.dex */
    public static abstract class Stub extends Binder implements ITPDataTransportRemoteBridge {
        private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge";
        static final int TRANSACTION_checkFileCacheStatus = 14;
        static final int TRANSACTION_clearCache = 13;
        static final int TRANSACTION_clearRangeCache = 12;
        static final int TRANSACTION_getBizAccessibleNativeInfo = 11;
        static final int TRANSACTION_getFileCacheSize = 15;
        static final int TRANSACTION_getGlobalAccessibleNativeInfo = 10;
        static final int TRANSACTION_getNativeVersion = 3;
        static final int TRANSACTION_getRemoteDataTransport = 1;
        static final int TRANSACTION_initBizId = 4;
        static final int TRANSACTION_isNativeInit = 2;
        static final int TRANSACTION_registerAssignedBizId = 6;
        static final int TRANSACTION_registerBizId = 5;
        static final int TRANSACTION_registerCommonInfoListener = 16;
        static final int TRANSACTION_setBizOptionalConfigParam = 9;
        static final int TRANSACTION_setGlobalOptionalConfigParam = 8;
        static final int TRANSACTION_unregisterBizId = 7;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes26.dex */
        public static class Proxy implements ITPDataTransportRemoteBridge {
            public static ITPDataTransportRemoteBridge sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
            public int checkFileCacheStatus(int i3, String str, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.mRemote, 14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().checkFileCacheStatus(i3, str, i16);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
            public boolean clearCache(int i3, String str, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeInt(i16);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().clearCache(i3, str, i16);
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

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
            public boolean clearRangeCache(int i3, String str, int i16, int i17) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeInt(i16);
                    obtain.writeInt(i17);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().clearRangeCache(i3, str, i16, i17);
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

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
            public String getBizAccessibleNativeInfo(int i3, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.mRemote, 11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getBizAccessibleNativeInfo(i3, i16);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
            public long getFileCacheSize(int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFileCacheSize(i3, str);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
            public String getGlobalAccessibleNativeInfo(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getGlobalAccessibleNativeInfo(i3);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
            public String getNativeVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getNativeVersion();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
            public ITPDataTransportRemote getRemoteDataTransport() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRemoteDataTransport();
                    }
                    obtain2.readException();
                    return ITPDataTransportRemote.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
            public int initBizId(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().initBizId(i3);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
            public boolean isNativeInit() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isNativeInit();
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

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
            public int registerAssignedBizId(int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerAssignedBizId(i3, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
            public int registerBizId(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerBizId(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
            public void registerCommonInfoListener(ITPDataTransportRemoteCommonInfoListener iTPDataTransportRemoteCommonInfoListener) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (iTPDataTransportRemoteCommonInfoListener != null) {
                        iBinder = iTPDataTransportRemoteCommonInfoListener.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerCommonInfoListener(iTPDataTransportRemoteCommonInfoListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
            public boolean setBizOptionalConfigParam(int i3, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setBizOptionalConfigParam(i3, str, str2);
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

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
            public boolean setGlobalOptionalConfigParam(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setGlobalOptionalConfigParam(str, str2);
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

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
            public void unregisterBizId(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterBizId(i3);
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

        public static ITPDataTransportRemoteBridge asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITPDataTransportRemoteBridge)) {
                return (ITPDataTransportRemoteBridge) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static ITPDataTransportRemoteBridge getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ITPDataTransportRemoteBridge iTPDataTransportRemoteBridge) {
            if (Proxy.sDefaultImpl == null) {
                if (iTPDataTransportRemoteBridge != null) {
                    Proxy.sDefaultImpl = iTPDataTransportRemoteBridge;
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
                        ITPDataTransportRemote remoteDataTransport = getRemoteDataTransport();
                        parcel2.writeNoException();
                        if (remoteDataTransport != null) {
                            iBinder = remoteDataTransport.asBinder();
                        } else {
                            iBinder = null;
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isNativeInit = isNativeInit();
                        parcel2.writeNoException();
                        parcel2.writeInt(isNativeInit ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        String nativeVersion = getNativeVersion();
                        parcel2.writeNoException();
                        parcel2.writeString(nativeVersion);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        int initBizId = initBizId(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(initBizId);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        int registerBizId = registerBizId(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(registerBizId);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        int registerAssignedBizId = registerAssignedBizId(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(registerAssignedBizId);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        unregisterBizId(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean globalOptionalConfigParam = setGlobalOptionalConfigParam(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(globalOptionalConfigParam ? 1 : 0);
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean bizOptionalConfigParam = setBizOptionalConfigParam(parcel.readInt(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(bizOptionalConfigParam ? 1 : 0);
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        String globalAccessibleNativeInfo = getGlobalAccessibleNativeInfo(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(globalAccessibleNativeInfo);
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        String bizAccessibleNativeInfo = getBizAccessibleNativeInfo(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(bizAccessibleNativeInfo);
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean clearRangeCache = clearRangeCache(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(clearRangeCache ? 1 : 0);
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean clearCache = clearCache(parcel.readInt(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(clearCache ? 1 : 0);
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        int checkFileCacheStatus = checkFileCacheStatus(parcel.readInt(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(checkFileCacheStatus);
                        return true;
                    case 15:
                        parcel.enforceInterface(DESCRIPTOR);
                        long fileCacheSize = getFileCacheSize(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeLong(fileCacheSize);
                        return true;
                    case 16:
                        parcel.enforceInterface(DESCRIPTOR);
                        registerCommonInfoListener(ITPDataTransportRemoteCommonInfoListener.Stub.asInterface(parcel.readStrongBinder()));
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
    public static class Default implements ITPDataTransportRemoteBridge {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
        public int checkFileCacheStatus(int i3, String str, int i16) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
        public boolean clearCache(int i3, String str, int i16) throws RemoteException {
            return false;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
        public boolean clearRangeCache(int i3, String str, int i16, int i17) throws RemoteException {
            return false;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
        public String getBizAccessibleNativeInfo(int i3, int i16) throws RemoteException {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
        public long getFileCacheSize(int i3, String str) throws RemoteException {
            return 0L;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
        public String getGlobalAccessibleNativeInfo(int i3) throws RemoteException {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
        public String getNativeVersion() throws RemoteException {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
        public ITPDataTransportRemote getRemoteDataTransport() throws RemoteException {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
        public int initBizId(int i3) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
        public boolean isNativeInit() throws RemoteException {
            return false;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
        public int registerAssignedBizId(int i3, String str) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
        public int registerBizId(String str) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
        public boolean setBizOptionalConfigParam(int i3, String str, String str2) throws RemoteException {
            return false;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
        public boolean setGlobalOptionalConfigParam(String str, String str2) throws RemoteException {
            return false;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
        public void registerCommonInfoListener(ITPDataTransportRemoteCommonInfoListener iTPDataTransportRemoteCommonInfoListener) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemoteBridge
        public void unregisterBizId(int i3) throws RemoteException {
        }
    }
}
