package com.tencent.qqmini.sdk.launcher.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IAppMainService extends IInterface {
    void onAppLifecycle(int i3, String str, MiniAppInfo miniAppInfo, Bundle bundle) throws RemoteException;

    void preloadDownloadPackage(MiniAppInfo miniAppInfo) throws RemoteException;

    void preloadMiniApp() throws RemoteException;

    Bundle requestAync(String str, String str2, Bundle bundle) throws RemoteException;

    void sendCmd(String str, String str2, Bundle bundle, MiniCmdCallback miniCmdCallback) throws RemoteException;

    void startMiniApp(MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver) throws RemoteException;

    void stopAllMiniApp() throws RemoteException;

    void stopMiniApp(MiniAppInfo miniAppInfo) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Default implements IAppMainService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.IAppMainService
        public Bundle requestAync(String str, String str2, Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.IAppMainService
        public void preloadMiniApp() throws RemoteException {
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.IAppMainService
        public void stopAllMiniApp() throws RemoteException {
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.IAppMainService
        public void preloadDownloadPackage(MiniAppInfo miniAppInfo) throws RemoteException {
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.IAppMainService
        public void stopMiniApp(MiniAppInfo miniAppInfo) throws RemoteException {
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.IAppMainService
        public void startMiniApp(MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver) throws RemoteException {
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.IAppMainService
        public void onAppLifecycle(int i3, String str, MiniAppInfo miniAppInfo, Bundle bundle) throws RemoteException {
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.IAppMainService
        public void sendCmd(String str, String str2, Bundle bundle, MiniCmdCallback miniCmdCallback) throws RemoteException {
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static abstract class Stub extends Binder implements IAppMainService {
        private static final String DESCRIPTOR = "com.tencent.qqmini.sdk.launcher.ipc.IAppMainService";
        static final int TRANSACTION_onAppLifecycle = 6;
        static final int TRANSACTION_preloadDownloadPackage = 5;
        static final int TRANSACTION_preloadMiniApp = 1;
        static final int TRANSACTION_requestAync = 8;
        static final int TRANSACTION_sendCmd = 7;
        static final int TRANSACTION_startMiniApp = 2;
        static final int TRANSACTION_stopAllMiniApp = 4;
        static final int TRANSACTION_stopMiniApp = 3;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes23.dex */
        public static class Proxy implements IAppMainService {
            public static IAppMainService sDefaultImpl;
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

            @Override // com.tencent.qqmini.sdk.launcher.ipc.IAppMainService
            public void onAppLifecycle(int i3, String str, MiniAppInfo miniAppInfo, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (miniAppInfo != null) {
                        obtain.writeInt(1);
                        miniAppInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAppLifecycle(i3, str, miniAppInfo, bundle);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.ipc.IAppMainService
            public void preloadDownloadPackage(MiniAppInfo miniAppInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (miniAppInfo != null) {
                        obtain.writeInt(1);
                        miniAppInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().preloadDownloadPackage(miniAppInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.ipc.IAppMainService
            public void preloadMiniApp() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
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

            @Override // com.tencent.qqmini.sdk.launcher.ipc.IAppMainService
            public Bundle requestAync(String str, String str2, Bundle bundle) throws RemoteException {
                Bundle bundle2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().requestAync(str, str2, bundle);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle2 = null;
                    }
                    return bundle2;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.ipc.IAppMainService
            public void sendCmd(String str, String str2, Bundle bundle, MiniCmdCallback miniCmdCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (miniCmdCallback != null) {
                        iBinder = miniCmdCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendCmd(str, str2, bundle, miniCmdCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.ipc.IAppMainService
            public void startMiniApp(MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (miniAppInfo != null) {
                        obtain.writeInt(1);
                        miniAppInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (resultReceiver != null) {
                        obtain.writeInt(1);
                        resultReceiver.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().startMiniApp(miniAppInfo, bundle, resultReceiver);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.ipc.IAppMainService
            public void stopAllMiniApp() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().stopAllMiniApp();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.ipc.IAppMainService
            public void stopMiniApp(MiniAppInfo miniAppInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (miniAppInfo != null) {
                        obtain.writeInt(1);
                        miniAppInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().stopMiniApp(miniAppInfo);
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

        public static IAppMainService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IAppMainService)) {
                return (IAppMainService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IAppMainService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAppMainService iAppMainService) {
            if (Proxy.sDefaultImpl == null && iAppMainService != null) {
                Proxy.sDefaultImpl = iAppMainService;
                return true;
            }
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            MiniAppInfo miniAppInfo;
            Bundle bundle;
            MiniAppInfo miniAppInfo2;
            if (i3 != 1598968902) {
                ResultReceiver resultReceiver = null;
                Bundle bundle2 = null;
                Bundle bundle3 = null;
                Bundle bundle4 = null;
                MiniAppInfo miniAppInfo3 = null;
                MiniAppInfo miniAppInfo4 = null;
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        preloadMiniApp();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            miniAppInfo = MiniAppInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            miniAppInfo = null;
                        }
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        } else {
                            bundle = null;
                        }
                        if (parcel.readInt() != 0) {
                            resultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
                        }
                        startMiniApp(miniAppInfo, bundle, resultReceiver);
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            miniAppInfo4 = MiniAppInfo.CREATOR.createFromParcel(parcel);
                        }
                        stopMiniApp(miniAppInfo4);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        stopAllMiniApp();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            miniAppInfo3 = MiniAppInfo.CREATOR.createFromParcel(parcel);
                        }
                        preloadDownloadPackage(miniAppInfo3);
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        int readInt = parcel.readInt();
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            miniAppInfo2 = MiniAppInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            miniAppInfo2 = null;
                        }
                        if (parcel.readInt() != 0) {
                            bundle4 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        onAppLifecycle(readInt, readString, miniAppInfo2, bundle4);
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString2 = parcel.readString();
                        String readString3 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        sendCmd(readString2, readString3, bundle3, MiniCmdCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString4 = parcel.readString();
                        String readString5 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        Bundle requestAync = requestAync(readString4, readString5, bundle2);
                        parcel2.writeNoException();
                        if (requestAync != null) {
                            parcel2.writeInt(1);
                            requestAync.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
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
