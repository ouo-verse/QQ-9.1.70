package com.tencent.mobileqq.pluginsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes16.dex */
public interface RemotePluginManager extends IInterface {
    public static final String DESCRIPTOR = "com.tencent.mobileqq.pluginsdk.RemotePluginManager";

    /* loaded from: classes16.dex */
    public static class Default implements RemotePluginManager {
        static IPatchRedirector $redirector_;

        public Default() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (IBinder) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
        public void cancelInstall(String str) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
        public void installPlugin(String str, OnPluginInstallListener onPluginInstallListener) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) onPluginInstallListener);
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
        public boolean isPlugininstalled(String str) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
        public boolean isReady() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
        public PluginBaseInfo queryPlugin(String str) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (PluginBaseInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
        public void setListener(RemotePluginManager remotePluginManager) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) remotePluginManager);
            }
        }
    }

    /* loaded from: classes16.dex */
    public static abstract class Stub extends Binder implements RemotePluginManager {
        static IPatchRedirector $redirector_ = null;
        static final int TRANSACTION_cancelInstall = 4;
        static final int TRANSACTION_installPlugin = 1;
        static final int TRANSACTION_isPlugininstalled = 2;
        static final int TRANSACTION_isReady = 5;
        static final int TRANSACTION_queryPlugin = 3;
        static final int TRANSACTION_setListener = 6;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes16.dex */
        public static class Proxy implements RemotePluginManager {
            static IPatchRedirector $redirector_;
            public static RemotePluginManager sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.mRemote = iBinder;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.mRemote;
            }

            @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
            public void cancelInstall(String str) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, RemotePluginManager.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().cancelInstall(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return RemotePluginManager.DESCRIPTOR;
            }

            @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
            public void installPlugin(String str, OnPluginInstallListener onPluginInstallListener) throws RemoteException {
                IBinder iBinder;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) onPluginInstallListener);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, RemotePluginManager.DESCRIPTOR);
                    obtain.writeString(str);
                    if (onPluginInstallListener != null) {
                        iBinder = onPluginInstallListener.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().installPlugin(str, onPluginInstallListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
            public boolean isPlugininstalled(String str) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, RemotePluginManager.DESCRIPTOR);
                    obtain.writeString(str);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isPlugininstalled(str);
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

            @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
            public boolean isReady() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, RemotePluginManager.DESCRIPTOR);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
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

            @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
            public PluginBaseInfo queryPlugin(String str) throws RemoteException {
                PluginBaseInfo pluginBaseInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return (PluginBaseInfo) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, RemotePluginManager.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().queryPlugin(str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        pluginBaseInfo = PluginBaseInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        pluginBaseInfo = null;
                    }
                    return pluginBaseInfo;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
            public void setListener(RemotePluginManager remotePluginManager) throws RemoteException {
                IBinder iBinder;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                    iPatchRedirector.redirect((short) 9, (Object) this, (Object) remotePluginManager);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, RemotePluginManager.DESCRIPTOR);
                    if (remotePluginManager != null) {
                        iBinder = remotePluginManager.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setListener(remotePluginManager);
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                attachInterface(this, RemotePluginManager.DESCRIPTOR);
            }
        }

        public static RemotePluginManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(RemotePluginManager.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof RemotePluginManager)) {
                return (RemotePluginManager) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static RemotePluginManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(RemotePluginManager remotePluginManager) {
            if (Proxy.sDefaultImpl == null) {
                if (remotePluginManager != null) {
                    Proxy.sDefaultImpl = remotePluginManager;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), parcel, parcel2, Integer.valueOf(i16))).booleanValue();
            }
            if (i3 != 1598968902) {
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(RemotePluginManager.DESCRIPTOR);
                        installPlugin(parcel.readString(), OnPluginInstallListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(RemotePluginManager.DESCRIPTOR);
                        boolean isPlugininstalled = isPlugininstalled(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(isPlugininstalled ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface(RemotePluginManager.DESCRIPTOR);
                        PluginBaseInfo queryPlugin = queryPlugin(parcel.readString());
                        parcel2.writeNoException();
                        if (queryPlugin != null) {
                            parcel2.writeInt(1);
                            queryPlugin.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 4:
                        parcel.enforceInterface(RemotePluginManager.DESCRIPTOR);
                        cancelInstall(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(RemotePluginManager.DESCRIPTOR);
                        boolean isReady = isReady();
                        parcel2.writeNoException();
                        parcel2.writeInt(isReady ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface(RemotePluginManager.DESCRIPTOR);
                        setListener(asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString(RemotePluginManager.DESCRIPTOR);
            return true;
        }
    }

    void cancelInstall(String str) throws RemoteException;

    void installPlugin(String str, OnPluginInstallListener onPluginInstallListener) throws RemoteException;

    boolean isPlugininstalled(String str) throws RemoteException;

    boolean isReady() throws RemoteException;

    PluginBaseInfo queryPlugin(String str) throws RemoteException;

    void setListener(RemotePluginManager remotePluginManager) throws RemoteException;
}
