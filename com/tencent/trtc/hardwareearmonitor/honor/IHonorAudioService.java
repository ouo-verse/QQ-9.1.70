package com.tencent.trtc.hardwareearmonitor.honor;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IHonorAudioService extends IInterface {
    List getSupportedServices() throws RemoteException;

    void init(String str, String str2) throws RemoteException;

    boolean isServiceSupported(int i3) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class Stub extends Binder implements IHonorAudioService {
        private static final String DESCRIPTOR = "com.hihonor.android.magicx.media.audioengine.IHnAudioService";
        static final int TRANSACTION_getSupportedServices = 1;
        static final int TRANSACTION_init = 3;
        static final int TRANSACTION_isServiceSupported = 2;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static class Proxy implements IHonorAudioService {
            public static IHonorAudioService sDefaultImpl;
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

            @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAudioService
            public List getSupportedServices() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSupportedServices();
                    }
                    obtain2.readException();
                    return obtain2.readArrayList(getClass().getClassLoader());
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAudioService
            public void init(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().init(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAudioService
            public boolean isServiceSupported(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean isServiceSupported = Stub.getDefaultImpl().isServiceSupported(i3);
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        return isServiceSupported;
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
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IHonorAudioService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IHonorAudioService)) {
                return (IHonorAudioService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IHonorAudioService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IHonorAudioService iHonorAudioService) {
            if (Proxy.sDefaultImpl == null) {
                if (iHonorAudioService != null) {
                    Proxy.sDefaultImpl = iHonorAudioService;
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
                    init(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                boolean isServiceSupported = isServiceSupported(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(isServiceSupported ? 1 : 0);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            List supportedServices = getSupportedServices();
            parcel2.writeNoException();
            parcel2.writeList(supportedServices);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Default implements IHonorAudioService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAudioService
        public List getSupportedServices() throws RemoteException {
            return null;
        }

        @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAudioService
        public boolean isServiceSupported(int i3) throws RemoteException {
            return false;
        }

        @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAudioService
        public void init(String str, String str2) throws RemoteException {
        }
    }
}
