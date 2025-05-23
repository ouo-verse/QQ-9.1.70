package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes26.dex */
public interface ITPDownloadProxyInfoCallbackAidl extends IInterface {
    void OnNativeConfigUpdate(String str) throws RemoteException;

    /* loaded from: classes26.dex */
    public static abstract class Stub extends Binder implements ITPDownloadProxyInfoCallbackAidl {
        private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyInfoCallbackAidl";
        static final int TRANSACTION_OnNativeConfigUpdate = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes26.dex */
        public static class Proxy implements ITPDownloadProxyInfoCallbackAidl {
            public static ITPDownloadProxyInfoCallbackAidl sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyInfoCallbackAidl
            public void OnNativeConfigUpdate(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().OnNativeConfigUpdate(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITPDownloadProxyInfoCallbackAidl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITPDownloadProxyInfoCallbackAidl)) {
                return (ITPDownloadProxyInfoCallbackAidl) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static ITPDownloadProxyInfoCallbackAidl getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ITPDownloadProxyInfoCallbackAidl iTPDownloadProxyInfoCallbackAidl) {
            if (Proxy.sDefaultImpl == null) {
                if (iTPDownloadProxyInfoCallbackAidl != null) {
                    Proxy.sDefaultImpl = iTPDownloadProxyInfoCallbackAidl;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1) {
                if (i3 != 1598968902) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            OnNativeConfigUpdate(parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes26.dex */
    public static class Default implements ITPDownloadProxyInfoCallbackAidl {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyInfoCallbackAidl
        public void OnNativeConfigUpdate(String str) throws RemoteException {
        }
    }
}
