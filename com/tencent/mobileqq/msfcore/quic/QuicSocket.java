package com.tencent.mobileqq.msfcore.quic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QuicSocket {
    static IPatchRedirector $redirector_;
    private final int socketFd;

    public QuicSocket() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.socketFd = nativeCreate();
        }
    }

    private native void nativeClose(int i3) throws RuntimeException;

    private native void nativeConnect(int i3, String str, int i16, int i17) throws RuntimeException;

    private native int nativeCreate();

    private native void nativeDestroy(int i3);

    private native int nativeRead(int i3, byte[] bArr, int i16, int i17) throws RuntimeException;

    private native int nativeReadOff(int i3, byte[] bArr, int i16, int i17, int i18) throws RuntimeException;

    private native void nativeWrite(int i3, byte[] bArr, int i16) throws RuntimeException;

    public void close() throws RuntimeException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            nativeClose(this.socketFd);
        }
    }

    public void connect(String str, int i3, int i16) throws RuntimeException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            nativeConnect(this.socketFd, str, i3, i16);
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            nativeDestroy(this.socketFd);
            super.finalize();
        }
    }

    public int getSocketFd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.socketFd;
    }

    public int read(byte[] bArr, int i3) throws RuntimeException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? nativeRead(this.socketFd, bArr, bArr.length, i3) : ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr, i3)).intValue();
    }

    public void write(byte[] bArr) throws RuntimeException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr);
        } else {
            nativeWrite(this.socketFd, bArr, bArr.length);
        }
    }

    public int read(byte[] bArr, int i3, int i16, int i17) throws RuntimeException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? nativeReadOff(this.socketFd, bArr, i3, i16, i17) : ((Integer) iPatchRedirector.redirect((short) 5, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).intValue();
    }
}
