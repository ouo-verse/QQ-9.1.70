package com.tencent.ilinkservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.ilinkservice.IIlinkServiceCallback;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IIlinkServiceInterface extends IInterface {
    byte[] ReqCommFunctionWithResp(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    void SetSmcUin(String str, String str2, String str3, int i3) throws RemoteException;

    void WriteKvData(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    void autoLogin(String str, String str2) throws RemoteException;

    void cancel(String str, String str2, String str3, int i3) throws RemoteException;

    void cancelAppRequest(String str, String str2, String str3, int i3) throws RemoteException;

    int cancelOAuth(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    void cancelRequest(String str, String str2, String str3, int i3) throws RemoteException;

    void checkLoginQrCode(String str, String str2, String str3) throws RemoteException;

    void cloneMultiProcessTdiSession(String str, String str2, String str3, String str4) throws RemoteException;

    void createTdiSession(String str, String str2, String str3) throws RemoteException;

    void destroyMultiProcessTdiSession(String str, String str2, String str3) throws RemoteException;

    void destroyTdiSession(String str, String str2, String str3) throws RemoteException;

    void faceExtVerify(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    void faceLogin(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    void faceRecognize(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    void faceRecognizeConfig(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    void getAppPushToken(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    void getLoginQrCode(String str, String str2, String str3) throws RemoteException;

    int getOAuthCode(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    byte[] getProfile(String str, String str2) throws RemoteException;

    String getToken(String str, String str2) throws RemoteException;

    byte[] getUserInfo(String str, String str2, String str3) throws RemoteException;

    void init(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    boolean isAlreadyGetStrategy(String str, String str2) throws RemoteException;

    String newRegisterCallback(String str, IIlinkServiceCallback iIlinkServiceCallback, byte[] bArr) throws RemoteException;

    String newSendIotMessage(String str, String str2, String str3, String str4, String str5, String str6) throws RemoteException;

    int newgetAppPushToken(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    void newgetLoginQrCode(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    void oauthLogin(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    void qrCodeLogin(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    String registCallbackWithDeviceInfo(String str, IIlinkServiceCallback iIlinkServiceCallback, byte[] bArr) throws RemoteException;

    String registerCallback(String str, IIlinkServiceCallback iIlinkServiceCallback) throws RemoteException;

    void requestMultiProcessCloneTicket(String str, String str2, String str3) throws RemoteException;

    int sendAppRequest(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    String sendIotMessage(String str, String str2, String str3, String str4, String str5) throws RemoteException;

    void setConsoleLogOpen(String str, String str2, boolean z16) throws RemoteException;

    void setLogLevel(String str, String str2, int i3) throws RemoteException;

    void setProxyInfo(String str, String str2, byte[] bArr) throws RemoteException;

    void tdiAutoLogin(String str, String str2, String str3) throws RemoteException;

    void tdiLogOut(String str, String str2, String str3) throws RemoteException;

    void uninit(String str, String str2, String str3) throws RemoteException;

    void unregisterCallback(String str, String str2, IIlinkServiceCallback iIlinkServiceCallback) throws RemoteException;

    void updateDeviceInfo(String str, String str2, byte[] bArr) throws RemoteException;

    void voidCommFunction(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    void writeLogToFile(int i3, String str, String str2) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static abstract class Stub extends Binder implements IIlinkServiceInterface {
        private static final String DESCRIPTOR = "com.tencent.ilinkservice.IIlinkServiceInterface";
        static final int TRANSACTION_ReqCommFunctionWithResp = 46;
        static final int TRANSACTION_SetSmcUin = 33;
        static final int TRANSACTION_WriteKvData = 32;
        static final int TRANSACTION_autoLogin = 23;
        static final int TRANSACTION_cancel = 14;
        static final int TRANSACTION_cancelAppRequest = 16;
        static final int TRANSACTION_cancelOAuth = 38;
        static final int TRANSACTION_cancelRequest = 41;
        static final int TRANSACTION_checkLoginQrCode = 12;
        static final int TRANSACTION_cloneMultiProcessTdiSession = 21;
        static final int TRANSACTION_createTdiSession = 4;
        static final int TRANSACTION_destroyMultiProcessTdiSession = 22;
        static final int TRANSACTION_destroyTdiSession = 5;
        static final int TRANSACTION_faceExtVerify = 9;
        static final int TRANSACTION_faceLogin = 10;
        static final int TRANSACTION_faceRecognize = 8;
        static final int TRANSACTION_faceRecognizeConfig = 17;
        static final int TRANSACTION_getAppPushToken = 27;
        static final int TRANSACTION_getLoginQrCode = 11;
        static final int TRANSACTION_getOAuthCode = 37;
        static final int TRANSACTION_getProfile = 24;
        static final int TRANSACTION_getToken = 25;
        static final int TRANSACTION_getUserInfo = 18;
        static final int TRANSACTION_init = 6;
        static final int TRANSACTION_isAlreadyGetStrategy = 34;
        static final int TRANSACTION_newRegisterCallback = 40;
        static final int TRANSACTION_newSendIotMessage = 42;
        static final int TRANSACTION_newgetAppPushToken = 29;
        static final int TRANSACTION_newgetLoginQrCode = 28;
        static final int TRANSACTION_oauthLogin = 36;
        static final int TRANSACTION_qrCodeLogin = 13;
        static final int TRANSACTION_registCallbackWithDeviceInfo = 45;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_requestMultiProcessCloneTicket = 3;
        static final int TRANSACTION_sendAppRequest = 15;
        static final int TRANSACTION_sendIotMessage = 26;
        static final int TRANSACTION_setConsoleLogOpen = 39;
        static final int TRANSACTION_setLogLevel = 35;
        static final int TRANSACTION_setProxyInfo = 30;
        static final int TRANSACTION_tdiAutoLogin = 19;
        static final int TRANSACTION_tdiLogOut = 20;
        static final int TRANSACTION_uninit = 7;
        static final int TRANSACTION_unregisterCallback = 2;
        static final int TRANSACTION_updateDeviceInfo = 43;
        static final int TRANSACTION_voidCommFunction = 44;
        static final int TRANSACTION_writeLogToFile = 31;

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static class Proxy implements IIlinkServiceInterface {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public byte[] ReqCommFunctionWithResp(String str, String str2, String str3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 46, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void SetSmcUin(String str, String str2, String str3, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i3);
                    OaidMonitor.binderTransact(this.mRemote, 33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void WriteKvData(String str, String str2, String str3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 32, obtain, obtain2, 0);
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

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void autoLogin(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    OaidMonitor.binderTransact(this.mRemote, 23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void cancel(String str, String str2, String str3, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i3);
                    OaidMonitor.binderTransact(this.mRemote, 14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void cancelAppRequest(String str, String str2, String str3, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i3);
                    OaidMonitor.binderTransact(this.mRemote, 16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public int cancelOAuth(String str, String str2, String str3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 38, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void cancelRequest(String str, String str2, String str3, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i3);
                    OaidMonitor.binderTransact(this.mRemote, 41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void checkLoginQrCode(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    OaidMonitor.binderTransact(this.mRemote, 12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void cloneMultiProcessTdiSession(String str, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    OaidMonitor.binderTransact(this.mRemote, 21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void createTdiSession(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void destroyMultiProcessTdiSession(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    OaidMonitor.binderTransact(this.mRemote, 22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void destroyTdiSession(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void faceExtVerify(String str, String str2, String str3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void faceLogin(String str, String str2, String str3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void faceRecognize(String str, String str2, String str3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void faceRecognizeConfig(String str, String str2, String str3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void getAppPushToken(String str, String str2, String str3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void getLoginQrCode(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    OaidMonitor.binderTransact(this.mRemote, 11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public int getOAuthCode(String str, String str2, String str3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 37, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public byte[] getProfile(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    OaidMonitor.binderTransact(this.mRemote, 24, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public String getToken(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    OaidMonitor.binderTransact(this.mRemote, 25, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public byte[] getUserInfo(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    OaidMonitor.binderTransact(this.mRemote, 18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void init(String str, String str2, String str3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public boolean isAlreadyGetStrategy(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z16 = false;
                    OaidMonitor.binderTransact(this.mRemote, 34, obtain, obtain2, 0);
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

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public String newRegisterCallback(String str, IIlinkServiceCallback iIlinkServiceCallback, byte[] bArr) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (iIlinkServiceCallback != null) {
                        iBinder = iIlinkServiceCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 40, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public String newSendIotMessage(String str, String str2, String str3, String str4, String str5, String str6) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                    obtain.writeString(str6);
                    OaidMonitor.binderTransact(this.mRemote, 42, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public int newgetAppPushToken(String str, String str2, String str3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 29, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void newgetLoginQrCode(String str, String str2, String str3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void oauthLogin(String str, String str2, String str3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void qrCodeLogin(String str, String str2, String str3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public String registCallbackWithDeviceInfo(String str, IIlinkServiceCallback iIlinkServiceCallback, byte[] bArr) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (iIlinkServiceCallback != null) {
                        iBinder = iIlinkServiceCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 45, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public String registerCallback(String str, IIlinkServiceCallback iIlinkServiceCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (iIlinkServiceCallback != null) {
                        iBinder = iIlinkServiceCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void requestMultiProcessCloneTicket(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public int sendAppRequest(String str, String str2, String str3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public String sendIotMessage(String str, String str2, String str3, String str4, String str5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                    OaidMonitor.binderTransact(this.mRemote, 26, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void setConsoleLogOpen(String str, String str2, boolean z16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z16 ? 1 : 0);
                    OaidMonitor.binderTransact(this.mRemote, 39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void setLogLevel(String str, String str2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i3);
                    OaidMonitor.binderTransact(this.mRemote, 35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void setProxyInfo(String str, String str2, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void tdiAutoLogin(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    OaidMonitor.binderTransact(this.mRemote, 19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void tdiLogOut(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    OaidMonitor.binderTransact(this.mRemote, 20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void uninit(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    OaidMonitor.binderTransact(this.mRemote, 7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void unregisterCallback(String str, String str2, IIlinkServiceCallback iIlinkServiceCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (iIlinkServiceCallback != null) {
                        iBinder = iIlinkServiceCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void updateDeviceInfo(String str, String str2, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void voidCommFunction(String str, String str2, String str3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeByteArray(bArr);
                    OaidMonitor.binderTransact(this.mRemote, 44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.ilinkservice.IIlinkServiceInterface
            public void writeLogToFile(int i3, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    OaidMonitor.binderTransact(this.mRemote, 31, obtain, obtain2, 0);
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

        public static IIlinkServiceInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IIlinkServiceInterface)) {
                return (IIlinkServiceInterface) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            boolean z16;
            if (i3 != 1598968902) {
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        String registerCallback = registerCallback(parcel.readString(), IIlinkServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeString(registerCallback);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        unregisterCallback(parcel.readString(), parcel.readString(), IIlinkServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        requestMultiProcessCloneTicket(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        createTdiSession(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        destroyTdiSession(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        init(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        uninit(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        faceRecognize(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        faceExtVerify(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        faceLogin(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        getLoginQrCode(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        checkLoginQrCode(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        qrCodeLogin(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        cancel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface(DESCRIPTOR);
                        int sendAppRequest = sendAppRequest(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeInt(sendAppRequest);
                        return true;
                    case 16:
                        parcel.enforceInterface(DESCRIPTOR);
                        cancelAppRequest(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel.enforceInterface(DESCRIPTOR);
                        faceRecognizeConfig(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel.enforceInterface(DESCRIPTOR);
                        byte[] userInfo = getUserInfo(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeByteArray(userInfo);
                        return true;
                    case 19:
                        parcel.enforceInterface(DESCRIPTOR);
                        tdiAutoLogin(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 20:
                        parcel.enforceInterface(DESCRIPTOR);
                        tdiLogOut(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface(DESCRIPTOR);
                        cloneMultiProcessTdiSession(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 22:
                        parcel.enforceInterface(DESCRIPTOR);
                        destroyMultiProcessTdiSession(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        parcel.enforceInterface(DESCRIPTOR);
                        autoLogin(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 24:
                        parcel.enforceInterface(DESCRIPTOR);
                        byte[] profile = getProfile(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeByteArray(profile);
                        return true;
                    case 25:
                        parcel.enforceInterface(DESCRIPTOR);
                        String token = getToken(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(token);
                        return true;
                    case 26:
                        parcel.enforceInterface(DESCRIPTOR);
                        String sendIotMessage = sendIotMessage(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(sendIotMessage);
                        return true;
                    case 27:
                        parcel.enforceInterface(DESCRIPTOR);
                        getAppPushToken(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 28:
                        parcel.enforceInterface(DESCRIPTOR);
                        newgetLoginQrCode(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 29:
                        parcel.enforceInterface(DESCRIPTOR);
                        int newgetAppPushToken = newgetAppPushToken(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeInt(newgetAppPushToken);
                        return true;
                    case 30:
                        parcel.enforceInterface(DESCRIPTOR);
                        setProxyInfo(parcel.readString(), parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 31:
                        parcel.enforceInterface(DESCRIPTOR);
                        writeLogToFile(parcel.readInt(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 32:
                        parcel.enforceInterface(DESCRIPTOR);
                        WriteKvData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 33:
                        parcel.enforceInterface(DESCRIPTOR);
                        SetSmcUin(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 34:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isAlreadyGetStrategy = isAlreadyGetStrategy(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(isAlreadyGetStrategy ? 1 : 0);
                        return true;
                    case 35:
                        parcel.enforceInterface(DESCRIPTOR);
                        setLogLevel(parcel.readString(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 36:
                        parcel.enforceInterface(DESCRIPTOR);
                        oauthLogin(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 37:
                        parcel.enforceInterface(DESCRIPTOR);
                        int oAuthCode = getOAuthCode(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeInt(oAuthCode);
                        return true;
                    case 38:
                        parcel.enforceInterface(DESCRIPTOR);
                        int cancelOAuth = cancelOAuth(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeInt(cancelOAuth);
                        return true;
                    case 39:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString = parcel.readString();
                        String readString2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        setConsoleLogOpen(readString, readString2, z16);
                        parcel2.writeNoException();
                        return true;
                    case 40:
                        parcel.enforceInterface(DESCRIPTOR);
                        String newRegisterCallback = newRegisterCallback(parcel.readString(), IIlinkServiceCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeString(newRegisterCallback);
                        return true;
                    case 41:
                        parcel.enforceInterface(DESCRIPTOR);
                        cancelRequest(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 42:
                        parcel.enforceInterface(DESCRIPTOR);
                        String newSendIotMessage = newSendIotMessage(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(newSendIotMessage);
                        return true;
                    case 43:
                        parcel.enforceInterface(DESCRIPTOR);
                        updateDeviceInfo(parcel.readString(), parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 44:
                        parcel.enforceInterface(DESCRIPTOR);
                        voidCommFunction(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 45:
                        parcel.enforceInterface(DESCRIPTOR);
                        String registCallbackWithDeviceInfo = registCallbackWithDeviceInfo(parcel.readString(), IIlinkServiceCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeString(registCallbackWithDeviceInfo);
                        return true;
                    case 46:
                        parcel.enforceInterface(DESCRIPTOR);
                        byte[] ReqCommFunctionWithResp = ReqCommFunctionWithResp(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeByteArray(ReqCommFunctionWithResp);
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
