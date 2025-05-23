package com.tencent.halley.common.b.a;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public class e extends SSLSocketFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static final String f113319b;

    /* renamed from: a, reason: collision with root package name */
    public boolean f113320a;

    /* renamed from: c, reason: collision with root package name */
    private String f113321c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10028);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f113319b = e.class.getSimpleName();
        }
    }

    public e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f113320a = false;
            this.f113321c = str;
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return null;
        }
        return (Socket) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, obj)).booleanValue();
        }
        if (TextUtils.isEmpty(this.f113321c) || !(obj instanceof e)) {
            return false;
        }
        String str = ((e) obj).f113321c;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f113321c.equals(str);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new String[0];
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return null;
        }
        return (Socket) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3, InetAddress inetAddress, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return null;
        }
        return (Socket) iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), inetAddress, Integer.valueOf(i16));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return null;
        }
        return (Socket) iPatchRedirector.redirect((short) 5, (Object) this, (Object) inetAddress, i3);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3, InetAddress inetAddress2, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return null;
        }
        return (Socket) iPatchRedirector.redirect((short) 6, this, inetAddress, Integer.valueOf(i3), inetAddress2, Integer.valueOf(i16));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Socket) iPatchRedirector.redirect((short) 7, this, socket, str, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        if (TextUtils.isEmpty(this.f113321c)) {
            throw new IOException("Halley set empty bizHost");
        }
        com.tencent.halley.common.utils.d.c(f113319b, "customized createSocket. host: " + this.f113321c);
        try {
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(10000, new SSLSessionCache(com.tencent.halley.common.a.a()));
            SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, this.f113321c, i3, z16);
            sSLCertificateSocketFactory.setUseSessionTickets(sSLSocket, true);
            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
            sSLCertificateSocketFactory.setHostname(sSLSocket, this.f113321c);
            sSLSocket.startHandshake();
            return sSLSocket;
        } catch (Throwable th5) {
            this.f113320a = true;
            if (th5 instanceof IOException) {
                throw th5;
            }
            throw new IOException("HalleySNI exception: ".concat(String.valueOf(th5)));
        }
    }
}
