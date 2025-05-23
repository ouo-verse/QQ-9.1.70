package com.tencent.minibox.contract;

import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.minibox.contract.IMiniBoxPluginCallback;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.List;

/* loaded from: classes9.dex */
public interface IMiniBoxPlugin extends IInterface {
    boolean deletePackage(String str, int i3) throws RemoteException;

    IBinder getBinder(String str) throws RemoteException;

    List<PluginPkgInfo> getInstalledPackages(int i3) throws RemoteException;

    PluginPkgInfo getPackageInfo(String str, int i3) throws RemoteException;

    void installApp(PackageInfo packageInfo, Uri uri, IMiniBoxPluginCallback iMiniBoxPluginCallback) throws RemoteException;

    boolean isReady() throws RemoteException;

    /* loaded from: classes9.dex */
    public static abstract class Stub extends Binder implements IMiniBoxPlugin {
        private static final String DESCRIPTOR = "com.tencent.minibox.contract.IMiniBoxPlugin";
        static final int TRANSACTION_deletePackage = 5;
        static final int TRANSACTION_getBinder = 6;
        static final int TRANSACTION_getInstalledPackages = 4;
        static final int TRANSACTION_getPackageInfo = 3;
        static final int TRANSACTION_installApp = 2;
        static final int TRANSACTION_isReady = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes9.dex */
        public static class Proxy implements IMiniBoxPlugin {
            public static IMiniBoxPlugin sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.minibox.contract.IMiniBoxPlugin
            public boolean deletePackage(String str, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
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

            @Override // com.tencent.minibox.contract.IMiniBoxPlugin
            public IBinder getBinder(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getBinder(str);
                    }
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.contract.IMiniBoxPlugin
            public List<PluginPkgInfo> getInstalledPackages(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getInstalledPackages(i3);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(PluginPkgInfo.INSTANCE);
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.tencent.minibox.contract.IMiniBoxPlugin
            public PluginPkgInfo getPackageInfo(String str, int i3) throws RemoteException {
                PluginPkgInfo pluginPkgInfo;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPackageInfo(str, i3);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        pluginPkgInfo = PluginPkgInfo.INSTANCE.createFromParcel(obtain2);
                    } else {
                        pluginPkgInfo = null;
                    }
                    return pluginPkgInfo;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.contract.IMiniBoxPlugin
            public void installApp(PackageInfo packageInfo, Uri uri, IMiniBoxPluginCallback iMiniBoxPluginCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (packageInfo != null) {
                        obtain.writeInt(1);
                        packageInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iMiniBoxPluginCallback != null) {
                        iBinder = iMiniBoxPluginCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().installApp(packageInfo, uri, iMiniBoxPluginCallback);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.minibox.contract.IMiniBoxPlugin
            public boolean isReady() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isReady();
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

        public static IMiniBoxPlugin asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMiniBoxPlugin)) {
                return (IMiniBoxPlugin) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IMiniBoxPlugin getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMiniBoxPlugin iMiniBoxPlugin) {
            if (Proxy.sDefaultImpl == null && iMiniBoxPlugin != null) {
                Proxy.sDefaultImpl = iMiniBoxPlugin;
                return true;
            }
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            PackageInfo packageInfo;
            if (i3 != 1598968902) {
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isReady = isReady();
                        parcel2.writeNoException();
                        parcel2.writeInt(isReady ? 1 : 0);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        Uri uri = null;
                        if (parcel.readInt() != 0) {
                            packageInfo = (PackageInfo) PackageInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            packageInfo = null;
                        }
                        if (parcel.readInt() != 0) {
                            uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                        }
                        installApp(packageInfo, uri, IMiniBoxPluginCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        PluginPkgInfo packageInfo2 = getPackageInfo(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        if (packageInfo2 != null) {
                            parcel2.writeInt(1);
                            packageInfo2.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        List<PluginPkgInfo> installedPackages = getInstalledPackages(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(installedPackages);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean deletePackage = deletePackage(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(deletePackage ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        IBinder binder = getBinder(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(binder);
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

    /* loaded from: classes9.dex */
    public static class Default implements IMiniBoxPlugin {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.minibox.contract.IMiniBoxPlugin
        public boolean deletePackage(String str, int i3) throws RemoteException {
            return false;
        }

        @Override // com.tencent.minibox.contract.IMiniBoxPlugin
        public IBinder getBinder(String str) throws RemoteException {
            return null;
        }

        @Override // com.tencent.minibox.contract.IMiniBoxPlugin
        public List<PluginPkgInfo> getInstalledPackages(int i3) throws RemoteException {
            return null;
        }

        @Override // com.tencent.minibox.contract.IMiniBoxPlugin
        public PluginPkgInfo getPackageInfo(String str, int i3) throws RemoteException {
            return null;
        }

        @Override // com.tencent.minibox.contract.IMiniBoxPlugin
        public boolean isReady() throws RemoteException {
            return false;
        }

        @Override // com.tencent.minibox.contract.IMiniBoxPlugin
        public void installApp(PackageInfo packageInfo, Uri uri, IMiniBoxPluginCallback iMiniBoxPluginCallback) throws RemoteException {
        }
    }
}
