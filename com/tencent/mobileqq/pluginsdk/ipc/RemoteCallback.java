package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface RemoteCallback extends IInterface {
    public static final String DESCRIPTOR = "com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback";

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class Default implements RemoteCallback {
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
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback
        public void onRemoteCallback(Bundle bundle) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static abstract class Stub extends Binder implements RemoteCallback {
        static IPatchRedirector $redirector_ = null;
        static final int TRANSACTION_onRemoteCallback = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes16.dex */
        public static class Proxy implements RemoteCallback {
            static IPatchRedirector $redirector_;
            public static RemoteCallback sDefaultImpl;
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
                return RemoteCallback.DESCRIPTOR;
            }

            @Override // com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback
            public void onRemoteCallback(Bundle bundle) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, RemoteCallback.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRemoteCallback(bundle);
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
                attachInterface(this, RemoteCallback.DESCRIPTOR);
            }
        }

        public static RemoteCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(RemoteCallback.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof RemoteCallback)) {
                return (RemoteCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static RemoteCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(RemoteCallback remoteCallback) {
            if (Proxy.sDefaultImpl == null) {
                if (remoteCallback != null) {
                    Proxy.sDefaultImpl = remoteCallback;
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
            Bundle bundle;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), parcel, parcel2, Integer.valueOf(i16))).booleanValue();
            }
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel.enforceInterface(RemoteCallback.DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                onRemoteCallback(bundle);
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString(RemoteCallback.DESCRIPTOR);
            return true;
        }
    }

    void onRemoteCallback(Bundle bundle) throws RemoteException;
}
