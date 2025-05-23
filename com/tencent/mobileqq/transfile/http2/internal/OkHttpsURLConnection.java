package com.tencent.mobileqq.transfile.http2.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Handshake;
import okhttp3.OkHttpClient;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class OkHttpsURLConnection extends DelegatingHttpsURLConnection {
    static IPatchRedirector $redirector_;
    private final OkHttpURLConnection delegate;

    public OkHttpsURLConnection(URL url, OkHttpClient okHttpClient) {
        this(new OkHttpURLConnection(url, okHttpClient));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) url, (Object) okHttpClient);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void addRequestProperty(String str, String str2) {
        super.addRequestProperty(str, str2);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void connect() throws IOException {
        super.connect();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ void disconnect() {
        super.disconnect();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ boolean getAllowUserInteraction() {
        return super.getAllowUserInteraction();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public /* bridge */ /* synthetic */ String getCipherSuite() {
        return super.getCipherSuite();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ int getConnectTimeout() {
        return super.getConnectTimeout();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ Object getContent() throws IOException {
        return super.getContent();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ String getContentEncoding() {
        return super.getContentEncoding();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ int getContentLength() {
        return super.getContentLength();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ long getContentLengthLong() {
        return super.getContentLengthLong();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ String getContentType() {
        return super.getContentType();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ long getDate() {
        return super.getDate();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ boolean getDefaultUseCaches() {
        return super.getDefaultUseCaches();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ boolean getDoInput() {
        return super.getDoInput();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ boolean getDoOutput() {
        return super.getDoOutput();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ InputStream getErrorStream() {
        return super.getErrorStream();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ long getExpiration() {
        return super.getExpiration();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.HttpURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ String getHeaderField(int i3) {
        return super.getHeaderField(i3);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.HttpURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ long getHeaderFieldDate(String str, long j3) {
        return super.getHeaderFieldDate(str, j3);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ int getHeaderFieldInt(String str, int i3) {
        return super.getHeaderFieldInt(str, i3);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.HttpURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ String getHeaderFieldKey(int i3) {
        return super.getHeaderFieldKey(i3);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ long getHeaderFieldLong(String str, long j3) {
        return super.getHeaderFieldLong(str, j3);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ Map getHeaderFields() {
        return super.getHeaderFields();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (HostnameVerifier) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.delegate.client.hostnameVerifier();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ long getIfModifiedSince() {
        return super.getIfModifiedSince();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ InputStream getInputStream() throws IOException {
        return super.getInputStream();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ boolean getInstanceFollowRedirects() {
        return super.getInstanceFollowRedirects();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ long getLastModified() {
        return super.getLastModified();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public /* bridge */ /* synthetic */ Certificate[] getLocalCertificates() {
        return super.getLocalCertificates();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public /* bridge */ /* synthetic */ Principal getLocalPrincipal() {
        return super.getLocalPrincipal();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ OutputStream getOutputStream() throws IOException {
        return super.getOutputStream();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public /* bridge */ /* synthetic */ Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return super.getPeerPrincipal();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.HttpURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ Permission getPermission() throws IOException {
        return super.getPermission();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ int getReadTimeout() {
        return super.getReadTimeout();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ String getRequestMethod() {
        return super.getRequestMethod();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ Map getRequestProperties() {
        return super.getRequestProperties();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ String getRequestProperty(String str) {
        return super.getRequestProperty(str);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ int getResponseCode() throws IOException {
        return super.getResponseCode();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ String getResponseMessage() throws IOException {
        return super.getResponseMessage();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SSLSocketFactory) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.delegate.client.sslSocketFactory();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public /* bridge */ /* synthetic */ Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        return super.getServerCertificates();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ URL getURL() {
        return super.getURL();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ boolean getUseCaches() {
        return super.getUseCaches();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection
    protected Handshake handshake() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Handshake) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        OkHttpURLConnection okHttpURLConnection = this.delegate;
        if (okHttpURLConnection.call != null) {
            return okHttpURLConnection.handshake;
        }
        throw new IllegalStateException("Connection has not yet been established");
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setAllowUserInteraction(boolean z16) {
        super.setAllowUserInteraction(z16);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ void setChunkedStreamingMode(int i3) {
        super.setChunkedStreamingMode(i3);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setConnectTimeout(int i3) {
        super.setConnectTimeout(i3);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setDefaultUseCaches(boolean z16) {
        super.setDefaultUseCaches(z16);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setDoInput(boolean z16) {
        super.setDoInput(z16);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setDoOutput(boolean z16) {
        super.setDoOutput(z16);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ void setFixedLengthStreamingMode(int i3) {
        super.setFixedLengthStreamingMode(i3);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) hostnameVerifier);
        } else {
            OkHttpURLConnection okHttpURLConnection = this.delegate;
            okHttpURLConnection.client = okHttpURLConnection.client.newBuilder().hostnameVerifier(hostnameVerifier).build();
        }
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setIfModifiedSince(long j3) {
        super.setIfModifiedSince(j3);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ void setInstanceFollowRedirects(boolean z16) {
        super.setInstanceFollowRedirects(z16);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setReadTimeout(int i3) {
        super.setReadTimeout(i3);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ void setRequestMethod(String str) throws ProtocolException {
        super.setRequestMethod(str);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setRequestProperty(String str, String str2) {
        super.setRequestProperty(str, str2);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) sSLSocketFactory);
        } else {
            if (sSLSocketFactory != null) {
                OkHttpURLConnection okHttpURLConnection = this.delegate;
                okHttpURLConnection.client = okHttpURLConnection.client.newBuilder().sslSocketFactory(sSLSocketFactory).build();
                return;
            }
            throw new IllegalArgumentException("sslSocketFactory == null");
        }
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setUseCaches(boolean z16) {
        super.setUseCaches(z16);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ boolean usingProxy() {
        return super.usingProxy();
    }

    public OkHttpsURLConnection(OkHttpURLConnection okHttpURLConnection) {
        super(okHttpURLConnection);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.delegate = okHttpURLConnection;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) okHttpURLConnection);
        }
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ Object getContent(Class[] clsArr) throws IOException {
        return super.getContent(clsArr);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ String getHeaderField(String str) {
        return super.getHeaderField(str);
    }

    @Override // com.tencent.mobileqq.transfile.http2.internal.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ void setFixedLengthStreamingMode(long j3) {
        super.setFixedLengthStreamingMode(j3);
    }
}
