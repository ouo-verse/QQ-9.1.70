package com.tencent.avcore.netchannel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class AbstractNetChannel implements IDavNetChannel, IDavNetCallback, IMavNetChannel, IMavNetCallback {
    static IPatchRedirector $redirector_ = null;
    public static final byte RCV_FAIL = 1;
    public static final byte RCV_OK = 0;
    public static final byte RCV_UN_IMPL = 3;
    public static final byte RCV_WRONG_PKG = 2;
    public static final byte VIDEO_MSG_SUB_TYPE_ACCEPT = 2;
    public static final byte VIDEO_MSG_SUB_TYPE_CANCEL = 3;
    public static final byte VIDEO_MSG_SUB_TYPE_INFO = 4;
    public static final byte VIDEO_MSG_SUB_TYPE_NOTIFY_ACCEPT = 5;
    public static final byte VIDEO_MSG_SUB_TYPE_NOTIFY_REJECT = 6;
    public static final byte VIDEO_MSG_SUB_TYPE_PAUSE_AV = 7;
    public static final byte VIDEO_MSG_SUB_TYPE_RECEIVE_REQ = 8;
    public static final byte VIDEO_MSG_SUB_TYPE_REMOTE_ADDR = 17;
    public static final byte VIDEO_MSG_SUB_TYPE_REQUEST = 1;
    private IDavNetCallback mDavNetCallback;
    private IMavNetCallback mMavNetCallback;

    public AbstractNetChannel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mDavNetCallback = null;
            this.mMavNetCallback = null;
        }
    }

    @Override // com.tencent.avcore.netchannel.IDavNetCallback
    public final void receiveGatewayMsg(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
            return;
        }
        IDavNetCallback iDavNetCallback = this.mDavNetCallback;
        if (iDavNetCallback != null) {
            iDavNetCallback.receiveGatewayMsg(str, i3);
        }
        IMavNetCallback iMavNetCallback = this.mMavNetCallback;
        if (iMavNetCallback != null) {
            iMavNetCallback.receiveGatewayMsg(str, i3);
        }
    }

    @Override // com.tencent.avcore.netchannel.IMavNetCallback
    public final int receiveMultiVideoMsg(int i3, byte[] bArr, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), bArr, Boolean.valueOf(z16))).intValue();
        }
        IMavNetCallback iMavNetCallback = this.mMavNetCallback;
        if (iMavNetCallback == null) {
            return 3;
        }
        try {
            return iMavNetCallback.receiveMultiVideoMsg(i3, bArr, z16);
        } catch (Throwable unused) {
            return 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        if (r0.receiveSharpVideoAck(r7, r9, r10) >= 0) goto L16;
     */
    @Override // com.tencent.avcore.netchannel.IDavNetCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte receiveSharpVideoAck(long j3, byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        byte b16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Byte) iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), bArr, bArr2)).byteValue();
        }
        IDavNetCallback iDavNetCallback = this.mDavNetCallback;
        if (iDavNetCallback == null) {
            return (byte) 3;
        }
        if (bArr != null) {
            try {
            } catch (Throwable unused) {
                return (byte) 1;
            }
        }
        b16 = 1;
        return b16;
    }

    @Override // com.tencent.avcore.netchannel.IDavNetCallback
    public final byte receiveSharpVideoCall(long j3, byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Byte) iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), bArr, bArr2)).byteValue();
        }
        IDavNetCallback iDavNetCallback = this.mDavNetCallback;
        if (iDavNetCallback == null) {
            return (byte) 3;
        }
        if (bArr != null) {
            try {
                if (iDavNetCallback.receiveSharpVideoCall(j3, bArr, bArr2) >= 0) {
                    return (byte) 0;
                }
            } catch (Throwable unused) {
            }
        }
        return (byte) 1;
    }

    @Override // com.tencent.avcore.netchannel.IDavNetChannel
    public final void setNetCallback(IDavNetCallback iDavNetCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mDavNetCallback = iDavNetCallback;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iDavNetCallback);
        }
    }

    @Override // com.tencent.avcore.netchannel.IMavNetChannel
    public final void setNetCallback(IMavNetCallback iMavNetCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.mMavNetCallback = iMavNetCallback;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iMavNetCallback);
        }
    }
}
