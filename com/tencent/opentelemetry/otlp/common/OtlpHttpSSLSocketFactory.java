package com.tencent.opentelemetry.otlp.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OtlpHttpSSLSocketFactory extends SSLSocketFactory {
    static IPatchRedirector $redirector_;
    private String[] ciphers;
    private String[] protocols;
    private SSLContext sslContext;

    public OtlpHttpSSLSocketFactory() throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            initSSLSocketFactory();
        }
    }

    private void initSSLSocketFactory() throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
        OtlpHttpX509TrustManager otlpHttpX509TrustManager = new OtlpHttpX509TrustManager();
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
        this.sslContext = sSLContext;
        sSLContext.init(null, new TrustManager[]{otlpHttpX509TrustManager}, new SecureRandom());
        this.protocols = getProtocolList();
        this.ciphers = getCipherList();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i3, boolean z16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Socket) iPatchRedirector.redirect((short) 4, this, socket, str, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        SSLSocket sSLSocket = (SSLSocket) this.sslContext.getSocketFactory().createSocket(socket, str, i3, z16);
        sSLSocket.setEnabledProtocols(this.protocols);
        sSLSocket.setEnabledCipherSuites(this.ciphers);
        return sSLSocket;
    }

    protected String[] getCipherList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String[]) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, this.sslContext.getSocketFactory().getSupportedCipherSuites());
        arrayList.add("TLS_RSA_WITH_AES_128_CBC_SHA");
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.ciphers;
    }

    protected String[] getProtocolList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        String[] strArr = {"TLSv1", "TLSv1.1", "TLSv1.2", "TLSv1.3", "TLS_RSA_WITH_AES_128_CBC_SHA"};
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) this.sslContext.getSocketFactory().createSocket();
                try {
                    String[] supportedProtocols = sSLSocket2.getSupportedProtocols();
                    try {
                        sSLSocket2.close();
                    } catch (IOException unused) {
                        if (DefaultPrintLogger.isDebug()) {
                            DefaultPrintLogger.d("OtlpHttpSSLSocketFactory", "getProtocolList socket.close error");
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < 5; i3++) {
                        String str = strArr[i3];
                        if (Arrays.binarySearch(supportedProtocols, str) >= 0) {
                            arrayList.add(str);
                        }
                    }
                    return (String[]) arrayList.toArray(new String[0]);
                } catch (Exception unused2) {
                    sSLSocket = sSLSocket2;
                    String[] strArr2 = {"TLSv1.2"};
                    if (sSLSocket != null) {
                        try {
                            sSLSocket.close();
                        } catch (IOException unused3) {
                            if (DefaultPrintLogger.isDebug()) {
                                DefaultPrintLogger.d("OtlpHttpSSLSocketFactory", "getProtocolList socket.close error");
                            }
                        }
                    }
                    return strArr2;
                } catch (Throwable th5) {
                    th = th5;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        try {
                            sSLSocket.close();
                        } catch (IOException unused4) {
                            if (DefaultPrintLogger.isDebug()) {
                                DefaultPrintLogger.d("OtlpHttpSSLSocketFactory", "getProtocolList socket.close error");
                            }
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.ciphers;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3, InetAddress inetAddress2, int i16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Socket) iPatchRedirector.redirect((short) 5, this, inetAddress, Integer.valueOf(i3), inetAddress2, Integer.valueOf(i16));
        }
        SSLSocket sSLSocket = (SSLSocket) this.sslContext.getSocketFactory().createSocket(inetAddress, i3, inetAddress2, i16);
        sSLSocket.setEnabledProtocols(this.protocols);
        sSLSocket.setEnabledCipherSuites(this.ciphers);
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3, InetAddress inetAddress, int i16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Socket) iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), inetAddress, Integer.valueOf(i16));
        }
        SSLSocket sSLSocket = (SSLSocket) this.sslContext.getSocketFactory().createSocket(str, i3, inetAddress, i16);
        sSLSocket.setEnabledProtocols(this.protocols);
        sSLSocket.setEnabledCipherSuites(this.ciphers);
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Socket) iPatchRedirector.redirect((short) 7, (Object) this, (Object) inetAddress, i3);
        }
        SSLSocket sSLSocket = (SSLSocket) this.sslContext.getSocketFactory().createSocket(inetAddress, i3);
        sSLSocket.setEnabledProtocols(this.protocols);
        sSLSocket.setEnabledCipherSuites(this.ciphers);
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Socket) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, i3);
        }
        SSLSocket sSLSocket = (SSLSocket) this.sslContext.getSocketFactory().createSocket(str, i3);
        sSLSocket.setEnabledProtocols(this.protocols);
        sSLSocket.setEnabledCipherSuites(this.ciphers);
        return sSLSocket;
    }
}
