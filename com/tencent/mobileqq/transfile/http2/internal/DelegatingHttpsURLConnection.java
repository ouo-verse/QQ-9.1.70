package com.tencent.mobileqq.transfile.http2.internal;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Handshake;

/* compiled from: P */
/* loaded from: classes19.dex */
abstract class DelegatingHttpsURLConnection extends HttpsURLConnection {
    static IPatchRedirector $redirector_;
    private final HttpURLConnection delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DelegatingHttpsURLConnection(HttpURLConnection httpURLConnection) {
        super(httpURLConnection.getURL());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) httpURLConnection);
        } else {
            this.delegate = httpURLConnection;
        }
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str, (Object) str2);
        } else {
            this.delegate.addRequestProperty(str, str2);
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            ((HttpsURLConnection) this).connected = true;
            this.delegate.connect();
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.delegate.disconnect();
        }
    }

    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.delegate.getAllowUserInteraction();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Handshake handshake = handshake();
        if (handshake != null) {
            return handshake.cipherSuite().javaName();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Integer) iPatchRedirector.redirect((short) 55, (Object) this)).intValue();
        }
        return this.delegate.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) ? this.delegate.getContent() : iPatchRedirector.redirect((short) 18, (Object) this);
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.delegate.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.delegate.getContentLength();
    }

    @Override // java.net.URLConnection
    public long getContentLengthLong() {
        long contentLengthLong;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Long) iPatchRedirector.redirect((short) 22, (Object) this)).longValue();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            contentLengthLong = this.delegate.getContentLengthLong();
            return contentLengthLong;
        }
        return -1L;
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.delegate.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Long) iPatchRedirector.redirect((short) 24, (Object) this)).longValue();
        }
        return this.delegate.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return this.delegate.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.delegate.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return this.delegate.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (InputStream) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.delegate.getErrorStream();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Long) iPatchRedirector.redirect((short) 28, (Object) this)).longValue();
        }
        return this.delegate.getExpiration();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 29)) ? this.delegate.getHeaderField(i3) : (String) iPatchRedirector.redirect((short) 29, (Object) this, i3);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Long) iPatchRedirector.redirect((short) 35, this, str, Long.valueOf(j3))).longValue();
        }
        return this.delegate.getHeaderFieldDate(str, j3);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, (Object) this, (Object) str, i3)).intValue();
        }
        return this.delegate.getHeaderFieldInt(str, i3);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this, i3);
        }
        return this.delegate.getHeaderFieldKey(i3);
    }

    @Override // java.net.URLConnection
    public long getHeaderFieldLong(String str, long j3) {
        long headerFieldLong;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Long) iPatchRedirector.redirect((short) 34, this, str, Long.valueOf(j3))).longValue();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            headerFieldLong = this.delegate.getHeaderFieldLong(str, j3);
            return headerFieldLong;
        }
        return j3;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (Map) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.delegate.getHeaderFields();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public abstract HostnameVerifier getHostnameVerifier();

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Long) iPatchRedirector.redirect((short) 38, (Object) this)).longValue();
        }
        return this.delegate.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (InputStream) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return this.delegate.getInputStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.delegate.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Long) iPatchRedirector.redirect((short) 40, (Object) this)).longValue();
        }
        return this.delegate.getLastModified();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Certificate[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Handshake handshake = handshake();
        if (handshake == null) {
            return null;
        }
        List<Certificate> localCertificates = handshake.localCertificates();
        if (localCertificates.isEmpty()) {
            return null;
        }
        return (Certificate[]) localCertificates.toArray(new Certificate[localCertificates.size()]);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getLocalPrincipal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Principal) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        Handshake handshake = handshake();
        if (handshake != null) {
            return handshake.localPrincipal();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (OutputStream) iPatchRedirector.redirect((short) 41, (Object) this);
        }
        return this.delegate.getOutputStream();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Principal) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Handshake handshake = handshake();
        if (handshake != null) {
            return handshake.peerPrincipal();
        }
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (Permission) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return this.delegate.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Integer) iPatchRedirector.redirect((short) 57, (Object) this)).intValue();
        }
        return this.delegate.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.delegate.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (Map) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return this.delegate.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (String) iPatchRedirector.redirect((short) 43, (Object) this, (Object) str);
        }
        return this.delegate.getRequestProperty(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.delegate.getResponseCode();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.delegate.getResponseMessage();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public abstract SSLSocketFactory getSSLSocketFactory();

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Certificate[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Handshake handshake = handshake();
        if (handshake == null) {
            return null;
        }
        List<Certificate> peerCertificates = handshake.peerCertificates();
        if (peerCertificates.isEmpty()) {
            return null;
        }
        return (Certificate[]) peerCertificates.toArray(new Certificate[peerCertificates.size()]);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (URL) iPatchRedirector.redirect((short) 44, (Object) this);
        }
        return this.delegate.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this)).booleanValue();
        }
        return this.delegate.getUseCaches();
    }

    protected abstract Handshake handshake();

    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, z16);
        } else {
            this.delegate.setAllowUserInteraction(z16);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, i3);
        } else {
            this.delegate.setChunkedStreamingMode(i3);
        }
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, i3);
        } else {
            this.delegate.setConnectTimeout(i3);
        }
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, z16);
        } else {
            this.delegate.setDefaultUseCaches(z16);
        }
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, z16);
        } else {
            this.delegate.setDoInput(z16);
        }
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, z16);
        } else {
            this.delegate.setDoOutput(z16);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 50)) {
            this.delegate.setFixedLengthStreamingMode(j3);
        } else {
            iPatchRedirector.redirect((short) 50, (Object) this, j3);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public abstract void setHostnameVerifier(HostnameVerifier hostnameVerifier);

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, j3);
        } else {
            this.delegate.setIfModifiedSince(j3);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.delegate.setInstanceFollowRedirects(z16);
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, i3);
        } else {
            this.delegate.setReadTimeout(i3);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.delegate.setRequestMethod(str);
        }
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) str, (Object) str2);
        } else {
            this.delegate.setRequestProperty(str, str2);
        }
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public abstract void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory);

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, z16);
        } else {
            this.delegate.setUseCaches(z16);
        }
    }

    @Override // java.net.URLConnection
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (String) iPatchRedirector.redirect((short) 58, (Object) this);
        }
        return this.delegate.toString();
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.delegate.usingProxy();
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) ? this.delegate.getContent(clsArr) : iPatchRedirector.redirect((short) 19, (Object) this, (Object) clsArr);
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 33)) ? this.delegate.getHeaderField(str) : (String) iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 59)) {
            this.delegate.setFixedLengthStreamingMode(i3);
        } else {
            iPatchRedirector.redirect((short) 59, (Object) this, i3);
        }
    }
}
