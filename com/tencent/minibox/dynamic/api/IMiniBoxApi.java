package com.tencent.minibox.dynamic.api;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.minibox.contract.IMiniBoxPluginCallback;
import com.tencent.minibox.contract.IMiniBoxServiceConnection;
import com.tencent.minibox.contract.LaunchAppInfo;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface IMiniBoxApi extends IInterface {
    void bindService(Intent intent, String str, IMiniBoxServiceConnection iMiniBoxServiceConnection) throws RemoteException;

    void checkAvailable(String str) throws RemoteException;

    boolean deletePackage(String str, int i3) throws RemoteException;

    String getApkPath(String str) throws RemoteException;

    IBinder getAppApi() throws RemoteException;

    long getAppDataStorageSpace(String str) throws RemoteException;

    long getAppExternalStorageSpace(String str) throws RemoteException;

    void getAppExtraInfo(String str, String str2, Bundle bundle, IMiniBoxPluginCallback iMiniBoxPluginCallback) throws RemoteException;

    LaunchAppInfo getAppInfo() throws RemoteException;

    List<PackageInfo> getInstalledPackages(int i3) throws RemoteException;

    PackageInfo getPackageInfo(String str, int i3) throws RemoteException;

    void installApp(String str, IMiniBoxPluginCallback iMiniBoxPluginCallback) throws RemoteException;

    void killMiniBoxAppProcess() throws RemoteException;

    void killMiniBoxEngineProcess() throws RemoteException;

    boolean launchApp(LaunchAppInfo launchAppInfo) throws RemoteException;

    boolean notifyClient(int i3, String str, Bundle bundle) throws RemoteException;

    boolean preLaunchApp(String str) throws RemoteException;

    void stopApp(String str, IMiniBoxPluginCallback iMiniBoxPluginCallback) throws RemoteException;

    void unbindService(IMiniBoxServiceConnection iMiniBoxServiceConnection) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class Default implements IMiniBoxApi {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public boolean deletePackage(String str, int i3) throws RemoteException {
            return false;
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public String getApkPath(String str) throws RemoteException {
            return null;
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public IBinder getAppApi() throws RemoteException {
            return null;
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public long getAppDataStorageSpace(String str) throws RemoteException {
            return 0L;
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public long getAppExternalStorageSpace(String str) throws RemoteException {
            return 0L;
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public LaunchAppInfo getAppInfo() throws RemoteException {
            return null;
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public List<PackageInfo> getInstalledPackages(int i3) throws RemoteException {
            return null;
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public PackageInfo getPackageInfo(String str, int i3) throws RemoteException {
            return null;
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public boolean launchApp(LaunchAppInfo launchAppInfo) throws RemoteException {
            return false;
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public boolean notifyClient(int i3, String str, Bundle bundle) throws RemoteException {
            return false;
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public boolean preLaunchApp(String str) throws RemoteException {
            return false;
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public void checkAvailable(String str) throws RemoteException {
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public void killMiniBoxAppProcess() throws RemoteException {
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public void killMiniBoxEngineProcess() throws RemoteException {
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public void unbindService(IMiniBoxServiceConnection iMiniBoxServiceConnection) throws RemoteException {
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public void installApp(String str, IMiniBoxPluginCallback iMiniBoxPluginCallback) throws RemoteException {
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public void stopApp(String str, IMiniBoxPluginCallback iMiniBoxPluginCallback) throws RemoteException {
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public void bindService(Intent intent, String str, IMiniBoxServiceConnection iMiniBoxServiceConnection) throws RemoteException {
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public void getAppExtraInfo(String str, String str2, Bundle bundle, IMiniBoxPluginCallback iMiniBoxPluginCallback) throws RemoteException {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class Stub extends Binder implements IMiniBoxApi {
        private static final String DESCRIPTOR = "com.tencent.minibox.dynamic.api.IMiniBoxApi";
        static final int TRANSACTION_bindService = 16;
        static final int TRANSACTION_checkAvailable = 18;
        static final int TRANSACTION_deletePackage = 7;
        static final int TRANSACTION_getApkPath = 15;
        static final int TRANSACTION_getAppApi = 8;
        static final int TRANSACTION_getAppDataStorageSpace = 9;
        static final int TRANSACTION_getAppExternalStorageSpace = 10;
        static final int TRANSACTION_getAppExtraInfo = 19;
        static final int TRANSACTION_getAppInfo = 14;
        static final int TRANSACTION_getInstalledPackages = 6;
        static final int TRANSACTION_getPackageInfo = 5;
        static final int TRANSACTION_installApp = 1;
        static final int TRANSACTION_killMiniBoxAppProcess = 12;
        static final int TRANSACTION_killMiniBoxEngineProcess = 11;
        static final int TRANSACTION_launchApp = 3;
        static final int TRANSACTION_notifyClient = 13;
        static final int TRANSACTION_preLaunchApp = 2;
        static final int TRANSACTION_stopApp = 4;
        static final int TRANSACTION_unbindService = 17;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static class Proxy implements IMiniBoxApi {
            public static IMiniBoxApi sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
            public void bindService(Intent intent, String str, IMiniBoxServiceConnection iMiniBoxServiceConnection) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (iMiniBoxServiceConnection != null) {
                        iBinder = iMiniBoxServiceConnection.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().bindService(intent, str, iMiniBoxServiceConnection);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
            public void checkAvailable(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 18, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().checkAvailable(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
            public boolean deletePackage(String str, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().deletePackage(str, i3);
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

            @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
            public String getApkPath(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getApkPath(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
            public IBinder getAppApi() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAppApi();
                    }
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
            public long getAppDataStorageSpace(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAppDataStorageSpace(str);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
            public long getAppExternalStorageSpace(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAppExternalStorageSpace(str);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
            public void getAppExtraInfo(String str, String str2, Bundle bundle, IMiniBoxPluginCallback iMiniBoxPluginCallback) throws RemoteException {
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
                    if (iMiniBoxPluginCallback != null) {
                        iBinder = iMiniBoxPluginCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 19, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().getAppExtraInfo(str, str2, bundle, iMiniBoxPluginCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
            public LaunchAppInfo getAppInfo() throws RemoteException {
                LaunchAppInfo launchAppInfo;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAppInfo();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        launchAppInfo = LaunchAppInfo.INSTANCE.createFromParcel(obtain2);
                    } else {
                        launchAppInfo = null;
                    }
                    return launchAppInfo;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
            public List<PackageInfo> getInstalledPackages(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getInstalledPackages(i3);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(PackageInfo.CREATOR);
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
            public PackageInfo getPackageInfo(String str, int i3) throws RemoteException {
                PackageInfo packageInfo;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPackageInfo(str, i3);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        packageInfo = (PackageInfo) PackageInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        packageInfo = null;
                    }
                    return packageInfo;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
            public void installApp(String str, IMiniBoxPluginCallback iMiniBoxPluginCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (iMiniBoxPluginCallback != null) {
                        iBinder = iMiniBoxPluginCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().installApp(str, iMiniBoxPluginCallback);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
            public void killMiniBoxAppProcess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().killMiniBoxAppProcess();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
            public void killMiniBoxEngineProcess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().killMiniBoxEngineProcess();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
            public boolean launchApp(LaunchAppInfo launchAppInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    boolean z16 = true;
                    if (launchAppInfo != null) {
                        obtain.writeInt(1);
                        launchAppInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().launchApp(launchAppInfo);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z16 = false;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
            public boolean notifyClient(int i3, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    boolean z16 = true;
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().notifyClient(i3, str, bundle);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z16 = false;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
            public boolean preLaunchApp(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().preLaunchApp(str);
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

            @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
            public void stopApp(String str, IMiniBoxPluginCallback iMiniBoxPluginCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (iMiniBoxPluginCallback != null) {
                        iBinder = iMiniBoxPluginCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().stopApp(str, iMiniBoxPluginCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
            public void unbindService(IMiniBoxServiceConnection iMiniBoxServiceConnection) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (iMiniBoxServiceConnection != null) {
                        iBinder = iMiniBoxServiceConnection.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 17, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unbindService(iMiniBoxServiceConnection);
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

        public static IMiniBoxApi asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMiniBoxApi)) {
                return (IMiniBoxApi) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IMiniBoxApi getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMiniBoxApi iMiniBoxApi) {
            if (Proxy.sDefaultImpl == null && iMiniBoxApi != null) {
                Proxy.sDefaultImpl = iMiniBoxApi;
                return true;
            }
            return false;
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public abstract /* synthetic */ void bindService(Intent intent, String str, IMiniBoxServiceConnection iMiniBoxServiceConnection) throws RemoteException;

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public abstract /* synthetic */ void checkAvailable(String str) throws RemoteException;

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public abstract /* synthetic */ boolean deletePackage(String str, int i3) throws RemoteException;

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public abstract /* synthetic */ String getApkPath(String str) throws RemoteException;

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public abstract /* synthetic */ IBinder getAppApi() throws RemoteException;

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public abstract /* synthetic */ long getAppDataStorageSpace(String str) throws RemoteException;

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public abstract /* synthetic */ long getAppExternalStorageSpace(String str) throws RemoteException;

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public abstract /* synthetic */ void getAppExtraInfo(String str, String str2, Bundle bundle, IMiniBoxPluginCallback iMiniBoxPluginCallback) throws RemoteException;

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public abstract /* synthetic */ LaunchAppInfo getAppInfo() throws RemoteException;

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public abstract /* synthetic */ List<PackageInfo> getInstalledPackages(int i3) throws RemoteException;

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public abstract /* synthetic */ PackageInfo getPackageInfo(String str, int i3) throws RemoteException;

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public abstract /* synthetic */ void installApp(String str, IMiniBoxPluginCallback iMiniBoxPluginCallback) throws RemoteException;

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public abstract /* synthetic */ void killMiniBoxAppProcess() throws RemoteException;

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public abstract /* synthetic */ void killMiniBoxEngineProcess() throws RemoteException;

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public abstract /* synthetic */ boolean launchApp(LaunchAppInfo launchAppInfo) throws RemoteException;

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public abstract /* synthetic */ boolean notifyClient(int i3, String str, Bundle bundle) throws RemoteException;

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                LaunchAppInfo launchAppInfo = null;
                Bundle bundle = null;
                Intent intent = null;
                Bundle bundle2 = null;
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        installApp(parcel.readString(), IMiniBoxPluginCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean preLaunchApp = preLaunchApp(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(preLaunchApp ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            launchAppInfo = LaunchAppInfo.INSTANCE.createFromParcel(parcel);
                        }
                        boolean launchApp = launchApp(launchAppInfo);
                        parcel2.writeNoException();
                        parcel2.writeInt(launchApp ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        stopApp(parcel.readString(), IMiniBoxPluginCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        PackageInfo packageInfo = getPackageInfo(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        if (packageInfo != null) {
                            parcel2.writeInt(1);
                            packageInfo.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        List<PackageInfo> installedPackages = getInstalledPackages(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(installedPackages);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean deletePackage = deletePackage(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(deletePackage ? 1 : 0);
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        IBinder appApi = getAppApi();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(appApi);
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        long appDataStorageSpace = getAppDataStorageSpace(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeLong(appDataStorageSpace);
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        long appExternalStorageSpace = getAppExternalStorageSpace(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeLong(appExternalStorageSpace);
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        killMiniBoxEngineProcess();
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        killMiniBoxAppProcess();
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        int readInt = parcel.readInt();
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        boolean notifyClient = notifyClient(readInt, readString, bundle2);
                        parcel2.writeNoException();
                        parcel2.writeInt(notifyClient ? 1 : 0);
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        LaunchAppInfo appInfo = getAppInfo();
                        parcel2.writeNoException();
                        if (appInfo != null) {
                            parcel2.writeInt(1);
                            appInfo.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 15:
                        parcel.enforceInterface(DESCRIPTOR);
                        String apkPath = getApkPath(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(apkPath);
                        return true;
                    case 16:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                        }
                        bindService(intent, parcel.readString(), IMiniBoxServiceConnection.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel.enforceInterface(DESCRIPTOR);
                        unbindService(IMiniBoxServiceConnection.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel.enforceInterface(DESCRIPTOR);
                        checkAvailable(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString2 = parcel.readString();
                        String readString3 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        getAppExtraInfo(readString2, readString3, bundle, IMiniBoxPluginCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public abstract /* synthetic */ boolean preLaunchApp(String str) throws RemoteException;

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public abstract /* synthetic */ void stopApp(String str, IMiniBoxPluginCallback iMiniBoxPluginCallback) throws RemoteException;

        @Override // com.tencent.minibox.dynamic.api.IMiniBoxApi
        public abstract /* synthetic */ void unbindService(IMiniBoxServiceConnection iMiniBoxServiceConnection) throws RemoteException;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
