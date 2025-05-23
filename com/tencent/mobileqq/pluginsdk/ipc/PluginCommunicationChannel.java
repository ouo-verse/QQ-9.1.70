package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes16.dex */
public interface PluginCommunicationChannel extends IInterface {
    public static final String DESCRIPTOR = "com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel";

    /* loaded from: classes16.dex */
    public static class Default implements PluginCommunicationChannel {
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

        @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
        public String getNickName() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
        public String getSKey() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
        public String getSid() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
        public long getUin() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return 0L;
        }

        @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
        public Bundle transfer(String str, Bundle bundle) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Bundle) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) bundle);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
        public void transferAsync(String str, Bundle bundle, RemoteCallback remoteCallback) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, str, bundle, remoteCallback);
            }
        }
    }

    /* loaded from: classes16.dex */
    public static abstract class Stub extends Binder implements PluginCommunicationChannel {
        static IPatchRedirector $redirector_ = null;
        static final int TRANSACTION_getNickName = 2;
        static final int TRANSACTION_getSKey = 3;
        static final int TRANSACTION_getSid = 4;
        static final int TRANSACTION_getUin = 1;
        static final int TRANSACTION_transfer = 5;
        static final int TRANSACTION_transferAsync = 6;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes16.dex */
        public static class Proxy implements PluginCommunicationChannel {
            static IPatchRedirector $redirector_;
            public static PluginCommunicationChannel sDefaultImpl;
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
                return PluginCommunicationChannel.DESCRIPTOR;
            }

            @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
            public String getNickName() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (String) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, PluginCommunicationChannel.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getNickName();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
            public String getSKey() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return (String) iPatchRedirector.redirect((short) 6, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, PluginCommunicationChannel.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSKey();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
            public String getSid() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return (String) iPatchRedirector.redirect((short) 7, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, PluginCommunicationChannel.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSid();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
            public long getUin() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, PluginCommunicationChannel.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUin();
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
            public Bundle transfer(String str, Bundle bundle) throws RemoteException {
                Bundle bundle2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    return (Bundle) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) bundle);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, PluginCommunicationChannel.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().transfer(str, bundle);
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

            @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
            public void transferAsync(String str, Bundle bundle, RemoteCallback remoteCallback) throws RemoteException {
                IBinder iBinder;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                    iPatchRedirector.redirect((short) 9, this, str, bundle, remoteCallback);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, PluginCommunicationChannel.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (remoteCallback != null) {
                        iBinder = remoteCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().transferAsync(str, bundle, remoteCallback);
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
                attachInterface(this, PluginCommunicationChannel.DESCRIPTOR);
            }
        }

        public static PluginCommunicationChannel asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(PluginCommunicationChannel.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof PluginCommunicationChannel)) {
                return (PluginCommunicationChannel) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static PluginCommunicationChannel getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(PluginCommunicationChannel pluginCommunicationChannel) {
            if (Proxy.sDefaultImpl == null) {
                if (pluginCommunicationChannel != null) {
                    Proxy.sDefaultImpl = pluginCommunicationChannel;
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
                Bundle bundle = null;
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(PluginCommunicationChannel.DESCRIPTOR);
                        long uin = getUin();
                        parcel2.writeNoException();
                        parcel2.writeLong(uin);
                        return true;
                    case 2:
                        parcel.enforceInterface(PluginCommunicationChannel.DESCRIPTOR);
                        String nickName = getNickName();
                        parcel2.writeNoException();
                        parcel2.writeString(nickName);
                        return true;
                    case 3:
                        parcel.enforceInterface(PluginCommunicationChannel.DESCRIPTOR);
                        String sKey = getSKey();
                        parcel2.writeNoException();
                        parcel2.writeString(sKey);
                        return true;
                    case 4:
                        parcel.enforceInterface(PluginCommunicationChannel.DESCRIPTOR);
                        String sid = getSid();
                        parcel2.writeNoException();
                        parcel2.writeString(sid);
                        return true;
                    case 5:
                        parcel.enforceInterface(PluginCommunicationChannel.DESCRIPTOR);
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        Bundle transfer = transfer(readString, bundle);
                        parcel2.writeNoException();
                        if (transfer != null) {
                            parcel2.writeInt(1);
                            transfer.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 6:
                        parcel.enforceInterface(PluginCommunicationChannel.DESCRIPTOR);
                        String readString2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        transferAsync(readString2, bundle, RemoteCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString(PluginCommunicationChannel.DESCRIPTOR);
            return true;
        }
    }

    String getNickName() throws RemoteException;

    String getSKey() throws RemoteException;

    String getSid() throws RemoteException;

    long getUin() throws RemoteException;

    Bundle transfer(String str, Bundle bundle) throws RemoteException;

    void transferAsync(String str, Bundle bundle, RemoteCallback remoteCallback) throws RemoteException;
}
