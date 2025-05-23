package com.tencent.trtc.hardwareearmonitor.honor;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IHonorEarReturnService extends IInterface {
    void destroy() throws RemoteException;

    int enableEarReturn(boolean z16) throws RemoteException;

    int getEarReturnLatency() throws RemoteException;

    void init(String str) throws RemoteException;

    boolean isSupported(int i3) throws RemoteException;

    int setParameter(String str, int i3) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Default implements IHonorEarReturnService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorEarReturnService
        public int enableEarReturn(boolean z16) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorEarReturnService
        public int getEarReturnLatency() throws RemoteException {
            return 0;
        }

        @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorEarReturnService
        public boolean isSupported(int i3) throws RemoteException {
            return false;
        }

        @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorEarReturnService
        public int setParameter(String str, int i3) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorEarReturnService
        public void destroy() throws RemoteException {
        }

        @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorEarReturnService
        public void init(String str) throws RemoteException {
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class Stub extends Binder implements IHonorEarReturnService {
        private static final String DESCRIPTOR = "com.hihonor.android.magicx.media.audioengine.IHnEarReturnService";
        static final int TRANSACTION_destroy = 6;
        static final int TRANSACTION_enableEarReturn = 2;
        static final int TRANSACTION_getEarReturnLatency = 3;
        static final int TRANSACTION_init = 5;
        static final int TRANSACTION_isSupported = 1;
        static final int TRANSACTION_setParameter = 4;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static class Proxy implements IHonorEarReturnService {
            public static IHonorEarReturnService sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorEarReturnService
            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().destroy();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorEarReturnService
            public int enableEarReturn(boolean z16) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().enableEarReturn(z16);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorEarReturnService
            public int getEarReturnLatency() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getEarReturnLatency();
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

            @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorEarReturnService
            public void init(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().init(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorEarReturnService
            public boolean isSupported(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
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

            @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorEarReturnService
            public int setParameter(String str, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setParameter(str, i3);
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

        public static IHonorEarReturnService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IHonorEarReturnService)) {
                return (IHonorEarReturnService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IHonorEarReturnService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IHonorEarReturnService iHonorEarReturnService) {
            if (Proxy.sDefaultImpl == null) {
                if (iHonorEarReturnService != null) {
                    Proxy.sDefaultImpl = iHonorEarReturnService;
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
                        boolean isSupported = isSupported(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(isSupported ? 1 : 0);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        int enableEarReturn = enableEarReturn(z16);
                        parcel2.writeNoException();
                        parcel2.writeInt(enableEarReturn);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        int earReturnLatency = getEarReturnLatency();
                        parcel2.writeNoException();
                        parcel2.writeInt(earReturnLatency);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        int parameter = setParameter(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(parameter);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        init(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        destroy();
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
