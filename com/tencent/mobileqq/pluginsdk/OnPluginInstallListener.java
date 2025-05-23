package com.tencent.mobileqq.pluginsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes16.dex */
public interface OnPluginInstallListener extends IInterface {
    public static final String DESCRIPTOR = "com.tencent.mobileqq.pluginsdk.OnPluginInstallListener";

    /* loaded from: classes16.dex */
    public static class Default implements OnPluginInstallListener {
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
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (IBinder) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallBegin(String str) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallDownloadProgress(String str, int i3, int i16) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallError(String str, int i3) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallFinish(String str) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
        }
    }

    /* loaded from: classes16.dex */
    public static abstract class Stub extends Binder implements OnPluginInstallListener {
        static IPatchRedirector $redirector_ = null;
        static final int TRANSACTION_onInstallBegin = 1;
        static final int TRANSACTION_onInstallDownloadProgress = 2;
        static final int TRANSACTION_onInstallError = 4;
        static final int TRANSACTION_onInstallFinish = 3;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes16.dex */
        public static class Proxy implements OnPluginInstallListener {
            static IPatchRedirector $redirector_;
            public static OnPluginInstallListener sDefaultImpl;
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

            public String getInterfaceDescriptor() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return OnPluginInstallListener.DESCRIPTOR;
            }

            @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
            public void onInstallBegin(String str) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, OnPluginInstallListener.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onInstallBegin(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
            public void onInstallDownloadProgress(String str, int i3, int i16) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, OnPluginInstallListener.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onInstallDownloadProgress(str, i3, i16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
            public void onInstallError(String str, int i3) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, OnPluginInstallListener.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onInstallError(str, i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
            public void onInstallFinish(String str) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, OnPluginInstallListener.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onInstallFinish(str);
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
                attachInterface(this, OnPluginInstallListener.DESCRIPTOR);
            }
        }

        public static OnPluginInstallListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(OnPluginInstallListener.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof OnPluginInstallListener)) {
                return (OnPluginInstallListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static OnPluginInstallListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(OnPluginInstallListener onPluginInstallListener) {
            if (Proxy.sDefaultImpl == null) {
                if (onPluginInstallListener != null) {
                    Proxy.sDefaultImpl = onPluginInstallListener;
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
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                return super.onTransact(i3, parcel, parcel2, i16);
                            }
                            parcel.enforceInterface(OnPluginInstallListener.DESCRIPTOR);
                            onInstallError(parcel.readString(), parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        }
                        parcel.enforceInterface(OnPluginInstallListener.DESCRIPTOR);
                        onInstallFinish(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    }
                    parcel.enforceInterface(OnPluginInstallListener.DESCRIPTOR);
                    onInstallDownloadProgress(parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface(OnPluginInstallListener.DESCRIPTOR);
                onInstallBegin(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString(OnPluginInstallListener.DESCRIPTOR);
            return true;
        }
    }

    void onInstallBegin(String str) throws RemoteException;

    void onInstallDownloadProgress(String str, int i3, int i16) throws RemoteException;

    void onInstallError(String str, int i3) throws RemoteException;

    void onInstallFinish(String str) throws RemoteException;
}
