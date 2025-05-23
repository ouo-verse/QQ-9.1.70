package com.tencent.mobileqq.mini.launch;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface IMiniAppMainServiceApi extends IInterface {
    public static final String DESCRIPTOR = "com.tencent.mobileqq.mini.launch.IMiniAppMainServiceApi";

    void preloadMiniApp() throws RemoteException;

    void preloadMiniAppLibs() throws RemoteException;

    void sendCmd(String str, Bundle bundle, CmdCallback cmdCallback) throws RemoteException;

    void startMiniApp(MiniAppConfig miniAppConfig, ResultReceiver resultReceiver) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static abstract class Stub extends Binder implements IMiniAppMainServiceApi {
        static final int TRANSACTION_preloadMiniApp = 1;
        static final int TRANSACTION_preloadMiniAppLibs = 2;
        static final int TRANSACTION_sendCmd = 4;
        static final int TRANSACTION_startMiniApp = 3;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes33.dex */
        public static class Proxy implements IMiniAppMainServiceApi {
            public static IMiniAppMainServiceApi sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IMiniAppMainServiceApi.DESCRIPTOR;
            }

            @Override // com.tencent.mobileqq.mini.launch.IMiniAppMainServiceApi
            public void preloadMiniApp() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IMiniAppMainServiceApi.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().preloadMiniApp();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.mini.launch.IMiniAppMainServiceApi
            public void preloadMiniAppLibs() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IMiniAppMainServiceApi.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().preloadMiniAppLibs();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.mini.launch.IMiniAppMainServiceApi
            public void sendCmd(String str, Bundle bundle, CmdCallback cmdCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IMiniAppMainServiceApi.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(cmdCallback != null ? cmdCallback.asBinder() : null);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendCmd(str, bundle, cmdCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.mini.launch.IMiniAppMainServiceApi
            public void startMiniApp(MiniAppConfig miniAppConfig, ResultReceiver resultReceiver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IMiniAppMainServiceApi.DESCRIPTOR);
                    if (miniAppConfig != null) {
                        obtain.writeInt(1);
                        miniAppConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (resultReceiver != null) {
                        obtain.writeInt(1);
                        resultReceiver.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().startMiniApp(miniAppConfig, resultReceiver);
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
            attachInterface(this, IMiniAppMainServiceApi.DESCRIPTOR);
        }

        public static IMiniAppMainServiceApi getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMiniAppMainServiceApi iMiniAppMainServiceApi) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iMiniAppMainServiceApi == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMiniAppMainServiceApi;
            return true;
        }

        public static IMiniAppMainServiceApi asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IMiniAppMainServiceApi.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMiniAppMainServiceApi)) {
                return (IMiniAppMainServiceApi) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 == 1598968902) {
                parcel2.writeString(IMiniAppMainServiceApi.DESCRIPTOR);
                return true;
            }
            if (i3 == 1) {
                parcel.enforceInterface(IMiniAppMainServiceApi.DESCRIPTOR);
                preloadMiniApp();
                parcel2.writeNoException();
                return true;
            }
            if (i3 == 2) {
                parcel.enforceInterface(IMiniAppMainServiceApi.DESCRIPTOR);
                preloadMiniAppLibs();
                parcel2.writeNoException();
                return true;
            }
            if (i3 == 3) {
                parcel.enforceInterface(IMiniAppMainServiceApi.DESCRIPTOR);
                startMiniApp(parcel.readInt() != 0 ? MiniAppConfig.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i3 != 4) {
                return super.onTransact(i3, parcel, parcel2, i16);
            }
            parcel.enforceInterface(IMiniAppMainServiceApi.DESCRIPTOR);
            sendCmd(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, CmdCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class Default implements IMiniAppMainServiceApi {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.mobileqq.mini.launch.IMiniAppMainServiceApi
        public void preloadMiniApp() throws RemoteException {
        }

        @Override // com.tencent.mobileqq.mini.launch.IMiniAppMainServiceApi
        public void preloadMiniAppLibs() throws RemoteException {
        }

        @Override // com.tencent.mobileqq.mini.launch.IMiniAppMainServiceApi
        public void startMiniApp(MiniAppConfig miniAppConfig, ResultReceiver resultReceiver) throws RemoteException {
        }

        @Override // com.tencent.mobileqq.mini.launch.IMiniAppMainServiceApi
        public void sendCmd(String str, Bundle bundle, CmdCallback cmdCallback) throws RemoteException {
        }
    }
}
