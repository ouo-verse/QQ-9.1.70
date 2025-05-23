package com.tencent.ilinkservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IIlinkServiceCallback extends IInterface {
    void OnCommonFunctionCallback(String str, byte[] bArr) throws RemoteException;

    void OnRequestUploadLogfiles(String str, byte[] bArr) throws RemoteException;

    void onAppSessionTimeout(String str) throws RemoteException;

    void onCancelOAuthComplete(String str, int i3, int i16) throws RemoteException;

    void onCheckLoginQrCode(String str, int i3, byte[] bArr) throws RemoteException;

    void onCloneMultiProcessTdiSession(int i3, String str) throws RemoteException;

    void onDestroyMultiProcessTdiSession(String str) throws RemoteException;

    void onFaceExtVerifyComplete(String str, int i3, byte[] bArr) throws RemoteException;

    void onFaceRecognizeComplete(String str, int i3, byte[] bArr) throws RemoteException;

    void onFaceRecognizeConfigComplete(String str, int i3, byte[] bArr) throws RemoteException;

    void onFinishGetStrategy() throws RemoteException;

    void onGetAppPushTokenComplete(String str, int i3, byte[] bArr) throws RemoteException;

    void onGetLoginQrCodeComplete(String str, int i3, byte[] bArr) throws RemoteException;

    void onGetOAuthCodeComplete(String str, int i3, int i16, byte[] bArr) throws RemoteException;

    void onLoginComplete(int i3, byte[] bArr, String str) throws RemoteException;

    void onLogoutComplete(String str, int i3) throws RemoteException;

    void onNetStatusChanged(int i3) throws RemoteException;

    void onNewGetAppPushTokenComplete(String str, int i3, int i16, byte[] bArr) throws RemoteException;

    void onNewLoginComplete(int i3, int i16, byte[] bArr, String str) throws RemoteException;

    void onReceiveAppMessage(String str, byte[] bArr) throws RemoteException;

    void onReceiveAppResponse(String str, int i3, int i16, byte[] bArr) throws RemoteException;

    void onReceiveMessage(String str, String str2, String str3, String str4, int i3) throws RemoteException;

    void onReceiveMultiProcessCloneTicket(int i3, String str, String str2) throws RemoteException;

    void onSendMsgResult(int i3, String str) throws RemoteException;

    void onTdiLoginComplete(String str, int i3, byte[] bArr) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static abstract class Stub extends Binder implements IIlinkServiceCallback {
        private static final String DESCRIPTOR = "com.tencent.ilinkservice.IIlinkServiceCallback";
        static final int TRANSACTION_OnCommonFunctionCallback = 25;
        static final int TRANSACTION_OnRequestUploadLogfiles = 24;
        static final int TRANSACTION_onAppSessionTimeout = 12;
        static final int TRANSACTION_onCancelOAuthComplete = 21;
        static final int TRANSACTION_onCheckLoginQrCode = 9;
        static final int TRANSACTION_onCloneMultiProcessTdiSession = 2;
        static final int TRANSACTION_onDestroyMultiProcessTdiSession = 3;
        static final int TRANSACTION_onFaceExtVerifyComplete = 5;
        static final int TRANSACTION_onFaceRecognizeComplete = 4;
        static final int TRANSACTION_onFaceRecognizeConfigComplete = 13;
        static final int TRANSACTION_onFinishGetStrategy = 19;
        static final int TRANSACTION_onGetAppPushTokenComplete = 17;
        static final int TRANSACTION_onGetLoginQrCodeComplete = 8;
        static final int TRANSACTION_onGetOAuthCodeComplete = 20;
        static final int TRANSACTION_onLoginComplete = 14;
        static final int TRANSACTION_onLogoutComplete = 7;
        static final int TRANSACTION_onNetStatusChanged = 22;
        static final int TRANSACTION_onNewGetAppPushTokenComplete = 18;
        static final int TRANSACTION_onNewLoginComplete = 23;
        static final int TRANSACTION_onReceiveAppMessage = 11;
        static final int TRANSACTION_onReceiveAppResponse = 10;
        static final int TRANSACTION_onReceiveMessage = 16;
        static final int TRANSACTION_onReceiveMultiProcessCloneTicket = 1;
        static final int TRANSACTION_onSendMsgResult = 15;
        static final int TRANSACTION_onTdiLoginComplete = 6;

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static class Proxy implements IIlinkServiceCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void OnCommonFunctionCallback(String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void OnRequestUploadLogfiles(String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 24, obtain, obtain2, 0);
                    obtain2.readException();
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

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onAppSessionTimeout(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    OaidMonitor.binderTransact(this.mRemote, 12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onCancelOAuthComplete(String str, int i3, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    OaidMonitor.binderTransact(this.mRemote, 21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onCheckLoginQrCode(String str, int i3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onCloneMultiProcessTdiSession(int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onDestroyMultiProcessTdiSession(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onFaceExtVerifyComplete(String str, int i3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onFaceRecognizeComplete(String str, int i3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onFaceRecognizeConfigComplete(String str, int i3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onFinishGetStrategy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    OaidMonitor.binderTransact(this.mRemote, 19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onGetAppPushTokenComplete(String str, int i3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onGetLoginQrCodeComplete(String str, int i3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onGetOAuthCodeComplete(String str, int i3, int i16, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onLoginComplete(int i3, byte[] bArr, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    OaidMonitor.binderTransact(this.mRemote, 14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onLogoutComplete(String str, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    OaidMonitor.binderTransact(this.mRemote, 7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onNetStatusChanged(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    OaidMonitor.binderTransact(this.mRemote, 22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onNewGetAppPushTokenComplete(String str, int i3, int i16, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onNewLoginComplete(int i3, int i16, byte[] bArr, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    OaidMonitor.binderTransact(this.mRemote, 23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onReceiveAppMessage(String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onReceiveAppResponse(String str, int i3, int i16, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onReceiveMessage(String str, String str2, String str3, String str4, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeInt(i3);
                    OaidMonitor.binderTransact(this.mRemote, 16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onReceiveMultiProcessCloneTicket(int i3, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onSendMsgResult(int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    OaidMonitor.binderTransact(this.mRemote, 15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceCallback
            public void onTdiLoginComplete(String str, int i3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IIlinkServiceCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IIlinkServiceCallback)) {
                return (IIlinkServiceCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        onReceiveMultiProcessCloneTicket(parcel.readInt(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        onCloneMultiProcessTdiSession(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDestroyMultiProcessTdiSession(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        onFaceRecognizeComplete(parcel.readString(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        onFaceExtVerifyComplete(parcel.readString(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        onTdiLoginComplete(parcel.readString(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        onLogoutComplete(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        onGetLoginQrCodeComplete(parcel.readString(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        onCheckLoginQrCode(parcel.readString(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        onReceiveAppResponse(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        onReceiveAppMessage(parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        onAppSessionTimeout(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        onFaceRecognizeConfigComplete(parcel.readString(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        onLoginComplete(parcel.readInt(), parcel.createByteArray(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface(DESCRIPTOR);
                        onSendMsgResult(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface(DESCRIPTOR);
                        onReceiveMessage(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel.enforceInterface(DESCRIPTOR);
                        onGetAppPushTokenComplete(parcel.readString(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel.enforceInterface(DESCRIPTOR);
                        onNewGetAppPushTokenComplete(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        parcel.enforceInterface(DESCRIPTOR);
                        onFinishGetStrategy();
                        parcel2.writeNoException();
                        return true;
                    case 20:
                        parcel.enforceInterface(DESCRIPTOR);
                        onGetOAuthCodeComplete(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface(DESCRIPTOR);
                        onCancelOAuthComplete(parcel.readString(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 22:
                        parcel.enforceInterface(DESCRIPTOR);
                        onNetStatusChanged(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        parcel.enforceInterface(DESCRIPTOR);
                        onNewLoginComplete(parcel.readInt(), parcel.readInt(), parcel.createByteArray(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 24:
                        parcel.enforceInterface(DESCRIPTOR);
                        OnRequestUploadLogfiles(parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        parcel.enforceInterface(DESCRIPTOR);
                        OnCommonFunctionCallback(parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
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
