package okhttp3.internal.huc;

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
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: P */
/* loaded from: classes19.dex */
abstract class DelegatingHttpsURLConnection extends HttpsURLConnection {
    private final HttpURLConnection delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DelegatingHttpsURLConnection(HttpURLConnection httpURLConnection) {
        super(httpURLConnection.getURL());
        this.delegate = httpURLConnection;
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String str, String str2) {
        this.delegate.addRequestProperty(str, str2);
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        ((HttpsURLConnection) this).connected = true;
        this.delegate.connect();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        this.delegate.disconnect();
    }

    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        return this.delegate.getAllowUserInteraction();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        Handshake handshake = handshake();
        if (handshake != null) {
            return handshake.cipherSuite().javaName();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.delegate.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        return this.delegate.getContent();
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return this.delegate.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return this.delegate.getContentLength();
    }

    @Override // java.net.URLConnection
    @IgnoreJRERequirement
    public long getContentLengthLong() {
        long contentLengthLong;
        contentLengthLong = this.delegate.getContentLengthLong();
        return contentLengthLong;
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return this.delegate.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return this.delegate.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return this.delegate.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return this.delegate.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return this.delegate.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return this.delegate.getErrorStream();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return this.delegate.getExpiration();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int i3) {
        return this.delegate.getHeaderField(i3);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j3) {
        return this.delegate.getHeaderFieldDate(str, j3);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i3) {
        return this.delegate.getHeaderFieldInt(str, i3);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int i3) {
        return this.delegate.getHeaderFieldKey(i3);
    }

    @Override // java.net.URLConnection
    @IgnoreJRERequirement
    public long getHeaderFieldLong(String str, long j3) {
        long headerFieldLong;
        headerFieldLong = this.delegate.getHeaderFieldLong(str, j3);
        return headerFieldLong;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        return this.delegate.getHeaderFields();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public abstract HostnameVerifier getHostnameVerifier();

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return this.delegate.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        return this.delegate.getInputStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.delegate.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return this.delegate.getLastModified();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
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
        Handshake handshake = handshake();
        if (handshake != null) {
            return handshake.localPrincipal();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return this.delegate.getOutputStream();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Handshake handshake = handshake();
        if (handshake != null) {
            return handshake.peerPrincipal();
        }
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return this.delegate.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.delegate.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return this.delegate.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return this.delegate.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return this.delegate.getRequestProperty(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        return this.delegate.getResponseCode();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        return this.delegate.getResponseMessage();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public abstract SSLSocketFactory getSSLSocketFactory();

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
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
        return this.delegate.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return this.delegate.getUseCaches();
    }

    protected abstract Handshake handshake();

    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean z16) {
        this.delegate.setAllowUserInteraction(z16);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i3) {
        this.delegate.setChunkedStreamingMode(i3);
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i3) {
        this.delegate.setConnectTimeout(i3);
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z16) {
        this.delegate.setDefaultUseCaches(z16);
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z16) {
        this.delegate.setDoInput(z16);
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z16) {
        this.delegate.setDoOutput(z16);
    }

    @Override // java.net.HttpURLConnection
    @IgnoreJRERequirement
    public void setFixedLengthStreamingMode(long j3) {
        this.delegate.setFixedLengthStreamingMode(j3);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public abstract void setHostnameVerifier(HostnameVerifier hostnameVerifier);

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j3) {
        this.delegate.setIfModifiedSince(j3);
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z16) {
        this.delegate.setInstanceFollowRedirects(z16);
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i3) {
        this.delegate.setReadTimeout(i3);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        this.delegate.setRequestMethod(str);
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String str, String str2) {
        this.delegate.setRequestProperty(str, str2);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public abstract void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory);

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z16) {
        this.delegate.setUseCaches(z16);
    }

    @Override // java.net.URLConnection
    public String toString() {
        return this.delegate.toString();
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return this.delegate.usingProxy();
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        return this.delegate.getContent(clsArr);
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        return this.delegate.getHeaderField(str);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i3) {
        this.delegate.setFixedLengthStreamingMode(i3);
    }
}
