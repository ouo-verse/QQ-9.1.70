package com.tencent.trtc.hardwareearmonitor.honor;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IHonorAdvancedRecordService extends IInterface {
    void destroy() throws RemoteException;

    boolean disableAdvancedRecord() throws RemoteException;

    boolean enableAdvancedRecord() throws RemoteException;

    int enableRecordDenoise(boolean z16, int i3, int i16, int i17, IBinder iBinder) throws RemoteException;

    void init(String str) throws RemoteException;

    boolean isSupported(int i3) throws RemoteException;

    void unbind(int i3) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Default implements IHonorAdvancedRecordService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAdvancedRecordService
        public boolean disableAdvancedRecord() throws RemoteException {
            return false;
        }

        @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAdvancedRecordService
        public boolean enableAdvancedRecord() throws RemoteException {
            return false;
        }

        @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAdvancedRecordService
        public int enableRecordDenoise(boolean z16, int i3, int i16, int i17, IBinder iBinder) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAdvancedRecordService
        public boolean isSupported(int i3) throws RemoteException {
            return false;
        }

        @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAdvancedRecordService
        public void destroy() throws RemoteException {
        }

        @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAdvancedRecordService
        public void init(String str) throws RemoteException {
        }

        @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAdvancedRecordService
        public void unbind(int i3) throws RemoteException {
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class Stub extends Binder implements IHonorAdvancedRecordService {
        private static final String DESCRIPTOR = "com.hihonor.android.magicx.media.audioengine.IHnAdvancedRecordService";
        static final int TRANSACTION_destroy = 2;
        static final int TRANSACTION_disableAdvancedRecord = 4;
        static final int TRANSACTION_enableAdvancedRecord = 3;
        static final int TRANSACTION_enableRecordDenoise = 6;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_isSupported = 5;
        static final int TRANSACTION_unbind = 7;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static class Proxy implements IHonorAdvancedRecordService {
            public static IHonorAdvancedRecordService sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAdvancedRecordService
            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().destroy();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAdvancedRecordService
            public boolean disableAdvancedRecord() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean disableAdvancedRecord = Stub.getDefaultImpl().disableAdvancedRecord();
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        return disableAdvancedRecord;
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

            @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAdvancedRecordService
            public boolean enableAdvancedRecord() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean enableAdvancedRecord = Stub.getDefaultImpl().enableAdvancedRecord();
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        return enableAdvancedRecord;
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

            @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAdvancedRecordService
            public int enableRecordDenoise(boolean z16, int i3, int i16, int i17, IBinder iBinder) throws RemoteException {
                int i18;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (z16) {
                        i18 = 1;
                    } else {
                        i18 = 0;
                    }
                    obtain.writeInt(i18);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeInt(i17);
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().enableRecordDenoise(z16, i3, i16, i17, iBinder);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAdvancedRecordService
            public void init(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().init(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAdvancedRecordService
            public boolean isSupported(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean isSupported = Stub.getDefaultImpl().isSupported(i3);
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        return isSupported;
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

            @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAdvancedRecordService
            public void unbind(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unbind(i3);
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

        public static IHonorAdvancedRecordService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IHonorAdvancedRecordService)) {
                return (IHonorAdvancedRecordService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IHonorAdvancedRecordService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IHonorAdvancedRecordService iHonorAdvancedRecordService) {
            if (Proxy.sDefaultImpl == null) {
                if (iHonorAdvancedRecordService != null) {
                    Proxy.sDefaultImpl = iHonorAdvancedRecordService;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            boolean z16;
            if (i3 != 1598968902) {
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        init(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        destroy();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean enableAdvancedRecord = enableAdvancedRecord();
                        parcel2.writeNoException();
                        parcel2.writeInt(enableAdvancedRecord ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean disableAdvancedRecord = disableAdvancedRecord();
                        parcel2.writeNoException();
                        parcel2.writeInt(disableAdvancedRecord ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isSupported = isSupported(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(isSupported ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        int enableRecordDenoise = enableRecordDenoise(z16, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readStrongBinder());
                        parcel2.writeNoException();
                        parcel2.writeInt(enableRecordDenoise);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        unbind(parcel.readInt());
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
}
