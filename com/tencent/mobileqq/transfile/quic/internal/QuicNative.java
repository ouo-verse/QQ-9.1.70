package com.tencent.mobileqq.transfile.quic.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QuicNative {
    static IPatchRedirector $redirector_;
    private QuicCallback callback;
    private boolean cleared;
    private int handleId;
    private byte[] srvMessage;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface QuicCallback {
        void onClose(int i3, int i16, String str);

        void onCompleted(int i3);

        void onConnect(int i3, int i16);

        void onDataReceive(int i3, byte[] bArr, int i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QuicNative() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.cleared = false;
        }
    }

    private native void clear(int i3);

    @Deprecated
    private native void connect(int i3, String str, String str2, int i16, boolean z16, int i17, byte[] bArr);

    private native void connectSupportGlobal0Rtt(int i3, String str, String str2, int i16, boolean z16, int i17, byte[] bArr, boolean z17, String str3);

    private native void connectSupportIpv6(int i3, String str, String str2, int i16, boolean z16, int i17, byte[] bArr, boolean z17);

    private native byte[] getSrvMessage(int i3);

    private native String getState(int i3);

    public static native void init();

    private void onClose(int i3, String str) {
        QuicCallback quicCallback = this.callback;
        if (quicCallback != null) {
            quicCallback.onClose(this.handleId, i3, str);
        }
    }

    private void onCompleted() {
        QuicCallback quicCallback = this.callback;
        if (quicCallback != null) {
            quicCallback.onCompleted(this.handleId);
        }
    }

    private void onConnect(int i3) {
        QuicCallback quicCallback = this.callback;
        if (quicCallback != null) {
            quicCallback.onConnect(this.handleId, i3);
        }
    }

    private void onDataReceive(byte[] bArr, int i3) {
        QuicCallback quicCallback = this.callback;
        if (quicCallback != null) {
            quicCallback.onDataReceive(this.handleId, bArr, i3);
        }
    }

    private native void sendRequest(int i3, byte[] bArr, int i16, boolean z16, int i17);

    public static native void setDebugLog(boolean z16);

    private native void setTransCompleted(int i3, boolean z16);

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            if (this.cleared) {
                return;
            }
            this.cleared = true;
            clear(this.handleId);
        }
    }

    public byte[] getSrvMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.srvMessage;
    }

    public String getState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        this.srvMessage = null;
        if (this.cleared) {
            return "";
        }
        String state = getState(this.handleId);
        this.srvMessage = getSrvMessage(this.handleId);
        return state;
    }

    public void sendRequest(byte[] bArr, int i3, boolean z16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bArr, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
        } else {
            if (this.cleared) {
                return;
            }
            sendRequest(this.handleId, bArr, i3, z16, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCallback(QuicCallback quicCallback) {
        this.callback = quicCallback;
    }

    public void setTransCompleted(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            setTransCompleted(this.handleId, z16);
        }
    }

    public void startConnect(int i3, String str, String str2, int i16, boolean z16, int i17, byte[] bArr, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            startConnect(i3, str, str2, i16, z16, i17, bArr, z17, QuicNetReport.RTT_HOST);
        } else {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17), bArr, Boolean.valueOf(z17));
        }
    }

    public void startConnect(int i3, String str, String str2, int i16, boolean z16, int i17, byte[] bArr, boolean z17, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17), bArr, Boolean.valueOf(z17), str3);
            return;
        }
        if (this.cleared) {
            return;
        }
        this.handleId = i3;
        if (QuicNetReport.RTT_HOST.equals(str3)) {
            connectSupportIpv6(this.handleId, str, str2, i16, z16, i17, bArr, z17);
        } else {
            connectSupportGlobal0Rtt(this.handleId, str, str2, i16, z16, i17, bArr, z17, str3);
        }
    }
}
