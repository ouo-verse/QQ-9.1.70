package com.tencent.upload.network.base;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.uinterface.IUploadSoLoader;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.UploadLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ConnectionImpl {
    static IPatchRedirector $redirector_ = null;
    private static final String DEF_SO_VERSION = "v1.3";
    private static final int MSG_ID_ON_CONNECT = 1;
    private static final int MSG_ID_ON_DISCONNECT = 2;
    private static final int MSG_ID_ON_ERROR = 3;
    private static final int MSG_ID_ON_MSGPROC = 8;
    private static final int MSG_ID_ON_RECV = 5;
    private static final int MSG_ID_ON_SENDBEGIN = 6;
    private static final int MSG_ID_ON_SENDEND = 7;
    private static final int MSG_ID_ON_START = 0;
    private static final int MSG_ID_ON_TIMEOUT = 4;
    private static final int PROTOCOL_TYPE_HTTP = 2;
    private static final int PROTOCOL_TYPE_TCP = 1;
    private static final int PROTOCOL_TYPE_TCP_EPOLL = 3;
    private static final int PROTOCOL_TYPE_TCP_EPOLL_LT = 4;
    private static final String SO_LIB_C_SHARED = "c++_shared";
    private static final String SO_LIB_NETBASE = "networkbase";
    private static final String SO_LIB_UPLOAD = "uploadnetwork";
    private static final String TAG = "ConnectionImpl";
    private static volatile boolean sIsLibraryPrepared;
    private IConnectionCallback mCallback;
    private final String mId;
    private IMsgCallback mMsgCallback;
    private long mNativeContext;

    static {
        String str;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11203);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        boolean z16 = false;
        sIsLibraryPrepared = false;
        try {
            IUploadSoLoader uploadSoLoader = UploadGlobalConfig.getUploadSoLoader();
            if (uploadSoLoader != null) {
                boolean loadLibrary = uploadSoLoader.loadLibrary(SO_LIB_C_SHARED);
                if (uploadSoLoader.getSoVersion() != null) {
                    str = "_" + uploadSoLoader.getSoVersion();
                } else {
                    str = "_v1.3";
                }
                String str2 = SO_LIB_NETBASE + str;
                String str3 = SO_LIB_UPLOAD + str;
                boolean loadLibrary2 = uploadSoLoader.loadLibrary(str2);
                boolean loadLibrary3 = uploadSoLoader.loadLibrary(str3);
                if (!loadLibrary2 && loadLibrary3) {
                    loadLibrary2 = uploadSoLoader.loadLibrary(str2);
                }
                if (loadLibrary2 && loadLibrary3) {
                    z16 = true;
                }
                sIsLibraryPrepared = z16;
                UploadLog.w(TAG, "sIsLibraryPrepared = " + sIsLibraryPrepared + " isSharedLoaded = " + loadLibrary + " isLib1Loaded = " + loadLibrary2 + " isLib2Loaded = " + loadLibrary3);
                if (sIsLibraryPrepared) {
                    native_init();
                }
            }
        } catch (Throwable th5) {
            UploadLog.e(TAG, th5.toString());
        }
    }

    public ConnectionImpl(int i3, String str, Const.ConnectType connectType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, connectType);
            return;
        }
        this.mMsgCallback = null;
        this.mCallback = null;
        this.mId = str;
        int i16 = connectType != Const.ConnectType.Epoll ? 1 : 4;
        native_setup2(new WeakReference(this), i16, i3, Integer.parseInt(str));
        UploadLog.d(TAG, "ConnectionImpl constructor : id = " + str + " connectType:" + i16);
    }

    private static final String getActionNameById(int i3) {
        switch (i3) {
            case 0:
                return "onStart";
            case 1:
                return "onConnect";
            case 2:
                return "onDisconnect";
            case 3:
                return "onError";
            case 4:
                return "onTimeout";
            case 5:
                return "onRecv";
            case 6:
                return "sendBegin";
            case 7:
                return "sendEnd";
            case 8:
                return "msgProc";
            default:
                return "unknown msg";
        }
    }

    public static native int getIpStack();

    public static final boolean isLibraryPrepared() {
        return sIsLibraryPrepared;
    }

    private static final native void native_init();

    private final native void native_setup(Object obj, int i3, int i16);

    private final native void native_setup2(Object obj, int i3, int i16, int i17);

    private void onConnect(boolean z16, int i3, String str) {
        IConnectionCallback iConnectionCallback = this.mCallback;
        if (iConnectionCallback != null) {
            iConnectionCallback.onConnect(iConnectionCallback, z16, i3, str);
        }
    }

    private void onDisconnect() {
        IConnectionCallback iConnectionCallback = this.mCallback;
        if (iConnectionCallback != null) {
            iConnectionCallback.onDisconnect(iConnectionCallback);
        }
    }

    private void onError(int i3) {
        IConnectionCallback iConnectionCallback = this.mCallback;
        if (iConnectionCallback != null) {
            iConnectionCallback.onError(iConnectionCallback, i3);
        }
    }

    private void onMsgProc(int i3, Object obj, int i16) {
        IMsgCallback iMsgCallback = this.mMsgCallback;
        if (iMsgCallback != null) {
            iMsgCallback.onMsgCallback(iMsgCallback, i3, obj, i16);
        }
    }

    private void onRecv(byte[] bArr) {
        IConnectionCallback iConnectionCallback = this.mCallback;
        if (iConnectionCallback != null) {
            iConnectionCallback.onRecv(iConnectionCallback, bArr);
        }
    }

    private void onSendBegin(int i3) {
        IConnectionCallback iConnectionCallback = this.mCallback;
        if (iConnectionCallback != null) {
            iConnectionCallback.onSendBegin(iConnectionCallback, i3);
        }
    }

    private void onSendEnd(int i3) {
        IConnectionCallback iConnectionCallback = this.mCallback;
        if (iConnectionCallback != null) {
            iConnectionCallback.onSendEnd(iConnectionCallback, i3);
        }
    }

    private void onStart() {
        IConnectionCallback iConnectionCallback = this.mCallback;
        if (iConnectionCallback != null) {
            iConnectionCallback.onStart(iConnectionCallback);
        }
    }

    private void onTimeOut(int i3, int i16) {
        IConnectionCallback iConnectionCallback = this.mCallback;
        if (iConnectionCallback != null) {
            iConnectionCallback.onSendTimeOut(iConnectionCallback, i3, i16);
        }
    }

    private static void postEventFromNative(Object obj, int i3, int i16, int i17, Object obj2) {
        boolean z16;
        if (!(obj instanceof WeakReference)) {
            UploadLog.w(TAG, "fromNative: !(ConnectionImpl_ref instanceof WeakReference<?>) what:" + getActionNameById(i3) + " arg1:" + i16 + " arg2:" + i17);
            return;
        }
        Object obj3 = ((WeakReference) obj).get();
        if (!(obj3 instanceof ConnectionImpl)) {
            UploadLog.w(TAG, "fromNative: !(ref instanceof ConnectionImpl) what:" + getActionNameById(i3) + " arg1:" + i16 + " arg2:" + i17 + "ref:" + obj3);
            return;
        }
        ConnectionImpl connectionImpl = (ConnectionImpl) obj3;
        String hashCode = connectionImpl.getHashCode();
        UploadLog.d(TAG, hashCode + " fromNative:" + getActionNameById(i3));
        switch (i3) {
            case 0:
                connectionImpl.onStart();
                return;
            case 1:
                if (i16 != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                connectionImpl.onConnect(z16, i17, (String) obj2);
                return;
            case 2:
                connectionImpl.onDisconnect();
                return;
            case 3:
                connectionImpl.onError(i16);
                return;
            case 4:
                connectionImpl.onTimeOut(i16, i17);
                return;
            case 5:
                connectionImpl.onRecv((byte[]) obj2);
                return;
            case 6:
                connectionImpl.onSendBegin(i16);
                return;
            case 7:
                connectionImpl.onSendEnd(i16);
                return;
            case 8:
                connectionImpl.onMsgProc(i16, obj2, i17);
                return;
            default:
                UploadLog.e(TAG, hashCode + " Unknown message type " + i3);
                return;
        }
    }

    public static void printLog(int i3, String str) {
        UploadLog.d("jni", str);
    }

    public native boolean PostMessage(int i3, Object obj, int i16);

    public native boolean SendData(byte[] bArr, int i3, int i16, int i17);

    public native boolean connect(String str, int i3, String str2, int i16, int i17, int i18);

    public native boolean disconnect();

    protected void finalize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        UploadLog.w(TAG, this.mId + " finalize");
        try {
            disconnect();
            super.finalize();
        } catch (Throwable unused) {
        }
    }

    public final String getHashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mId;
    }

    public native boolean isRunning();

    public native boolean isSendDone(int i3);

    public final native void native_finalize();

    public native void removeAllSendData();

    public native void removeSendData(int i3);

    public void setCallback(IConnectionCallback iConnectionCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iConnectionCallback);
        } else {
            this.mCallback = iConnectionCallback;
        }
    }

    public void setMsgCallback(IMsgCallback iMsgCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iMsgCallback);
        } else {
            this.mMsgCallback = iMsgCallback;
        }
    }

    public native boolean start();

    public native boolean stop();

    public native void wakeUp();
}
