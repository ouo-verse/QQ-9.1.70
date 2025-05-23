package com.tencent.assistant.sdk.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.assistant.sdk.remote.SDKActionCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface BaseService extends IInterface {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements BaseService {
        static IPatchRedirector $redirector_ = null;
        protected static final String DESCRIPTOR = "com.tencent.assistant.sdk.remote.BaseService";

        /* compiled from: P */
        /* loaded from: classes3.dex */
        private static class Proxy implements BaseService {
            static IPatchRedirector $redirector_;
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
                return Stub.DESCRIPTOR;
            }

            @Override // com.tencent.assistant.sdk.remote.BaseService
            public int registerActionCallback(String str, String str2, SDKActionCallback sDKActionCallback) {
                IBinder iBinder;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Integer) iPatchRedirector.redirect((short) 4, this, str, str2, sDKActionCallback)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (sDKActionCallback != null) {
                        iBinder = sDKActionCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.assistant.sdk.remote.BaseService
            public void sendAsyncData(String str, byte[] bArr) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) bArr);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.assistant.sdk.remote.BaseService
            public byte[] sendSyncData(String str, byte[] bArr) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) bArr);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.assistant.sdk.remote.BaseService
            public int unregisterActionCallback(SDKActionCallback sDKActionCallback) {
                IBinder iBinder;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) sDKActionCallback)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (sDKActionCallback != null) {
                        iBinder = sDKActionCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
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
                attachInterface(this, DESCRIPTOR);
            }
        }

        public static BaseService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof BaseService)) {
                return (BaseService) queryLocalInterface;
            }
            return new Proxy(iBinder);
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
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) {
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
                            parcel.enforceInterface(DESCRIPTOR);
                            sendAsyncData(parcel.readString(), parcel.createByteArray());
                            parcel2.writeNoException();
                            return true;
                        }
                        parcel.enforceInterface(DESCRIPTOR);
                        byte[] sendSyncData = sendSyncData(parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeByteArray(sendSyncData);
                        return true;
                    }
                    parcel.enforceInterface(DESCRIPTOR);
                    int unregisterActionCallback = unregisterActionCallback(SDKActionCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(unregisterActionCallback);
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                int registerActionCallback = registerActionCallback(parcel.readString(), parcel.readString(), SDKActionCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(registerActionCallback);
                return true;
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    int registerActionCallback(String str, String str2, SDKActionCallback sDKActionCallback);

    void sendAsyncData(String str, byte[] bArr);

    byte[] sendSyncData(String str, byte[] bArr);

    int unregisterActionCallback(SDKActionCallback sDKActionCallback);
}
