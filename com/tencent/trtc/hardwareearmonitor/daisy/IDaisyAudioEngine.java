package com.tencent.trtc.hardwareearmonitor.daisy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IDaisyAudioEngine extends IInterface {
    List getSupportedFeatures() throws RemoteException;

    void init(String str, String str2) throws RemoteException;

    boolean isFeatureSupported(int i3) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class Stub extends Binder implements IDaisyAudioEngine {
        private static final String DESCRIPTOR = "com.huawei.multimedia.audioengine.IHwAudioEngine";
        static final int TRANSACTION_getSupportedFeatures = 1;
        static final int TRANSACTION_init = 3;
        static final int TRANSACTION_isFeatureSupported = 2;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        static class a implements IDaisyAudioEngine {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f381685a;

            a(IBinder iBinder) {
                this.f381685a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f381685a;
            }

            @Override // com.tencent.trtc.hardwareearmonitor.daisy.IDaisyAudioEngine
            public final List getSupportedFeatures() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    OaidMonitor.binderTransact(this.f381685a, 1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readArrayList(a.class.getClassLoader());
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.trtc.hardwareearmonitor.daisy.IDaisyAudioEngine
            public final void init(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    OaidMonitor.binderTransact(this.f381685a, 3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.trtc.hardwareearmonitor.daisy.IDaisyAudioEngine
            public final boolean isFeatureSupported(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    boolean z16 = false;
                    OaidMonitor.binderTransact(this.f381685a, 2, obtain, obtain2, 0);
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

        public static IDaisyAudioEngine asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDaisyAudioEngine)) {
                return (IDaisyAudioEngine) queryLocalInterface;
            }
            return new a(iBinder);
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
                boolean isFeatureSupported = isFeatureSupported(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(isFeatureSupported ? 1 : 0);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            List supportedFeatures = getSupportedFeatures();
            parcel2.writeNoException();
            parcel2.writeList(supportedFeatures);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
