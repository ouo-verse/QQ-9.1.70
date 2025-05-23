package com.tencent.trtc.hardwareearmonitor.daisy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IDaisyAudioKaraokeFeature extends IInterface {
    int enableKaraokeFeature(boolean z16) throws RemoteException;

    int getKaraokeLatency() throws RemoteException;

    void init(String str) throws RemoteException;

    boolean isKaraokeFeatureSupport() throws RemoteException;

    int setParameter(String str, int i3) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class Stub extends Binder implements IDaisyAudioKaraokeFeature {
        private static final String DESCRIPTOR = "com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature";
        static final int TRANSACTION_enableKaraokeFeature = 2;
        static final int TRANSACTION_getKaraokeLatency = 3;
        static final int TRANSACTION_init = 5;
        static final int TRANSACTION_isKaraokeFeatureSupport = 1;
        static final int TRANSACTION_setParameter = 4;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        static class a implements IDaisyAudioKaraokeFeature {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f381686a;

            a(IBinder iBinder) {
                this.f381686a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f381686a;
            }

            @Override // com.tencent.trtc.hardwareearmonitor.daisy.IDaisyAudioKaraokeFeature
            public final int enableKaraokeFeature(boolean z16) throws RemoteException {
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
                    OaidMonitor.binderTransact(this.f381686a, 2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.trtc.hardwareearmonitor.daisy.IDaisyAudioKaraokeFeature
            public final int getKaraokeLatency() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    OaidMonitor.binderTransact(this.f381686a, 3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.trtc.hardwareearmonitor.daisy.IDaisyAudioKaraokeFeature
            public final void init(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    OaidMonitor.binderTransact(this.f381686a, 5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.trtc.hardwareearmonitor.daisy.IDaisyAudioKaraokeFeature
            public final boolean isKaraokeFeatureSupport() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    boolean z16 = false;
                    OaidMonitor.binderTransact(this.f381686a, 1, obtain, obtain2, 0);
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

            @Override // com.tencent.trtc.hardwareearmonitor.daisy.IDaisyAudioKaraokeFeature
            public final int setParameter(String str, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    OaidMonitor.binderTransact(this.f381686a, 4, obtain, obtain2, 0);
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

        public static IDaisyAudioKaraokeFeature asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDaisyAudioKaraokeFeature)) {
                return (IDaisyAudioKaraokeFeature) queryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            boolean z16;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 != 1598968902) {
                                    return super.onTransact(i3, parcel, parcel2, i16);
                                }
                                parcel2.writeString(DESCRIPTOR);
                                return true;
                            }
                            parcel.enforceInterface(DESCRIPTOR);
                            init(parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        }
                        parcel.enforceInterface(DESCRIPTOR);
                        int parameter = setParameter(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(parameter);
                        return true;
                    }
                    parcel.enforceInterface(DESCRIPTOR);
                    int karaokeLatency = getKaraokeLatency();
                    parcel2.writeNoException();
                    parcel2.writeInt(karaokeLatency);
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                int enableKaraokeFeature = enableKaraokeFeature(z16);
                parcel2.writeNoException();
                parcel2.writeInt(enableKaraokeFeature);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            boolean isKaraokeFeatureSupport = isKaraokeFeatureSupport();
            parcel2.writeNoException();
            parcel2.writeInt(isKaraokeFeatureSupport ? 1 : 0);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
