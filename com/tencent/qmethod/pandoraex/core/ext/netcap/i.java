package com.tencent.qmethod.pandoraex.core.ext.netcap;

import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: P */
/* loaded from: classes22.dex */
public class i extends HttpsURLConnection {

    /* renamed from: a, reason: collision with root package name */
    final HttpsURLConnection f344094a;

    /* renamed from: b, reason: collision with root package name */
    final p f344095b;

    public i(String str, HttpsURLConnection httpsURLConnection) {
        super(null);
        this.f344094a = httpsURLConnection;
        this.f344095b = new p(str);
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String str, String str2) {
        this.f344094a.addRequestProperty(str, str2);
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        this.f344095b.e(2, this.f344094a);
        this.f344094a.connect();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        this.f344094a.disconnect();
    }

    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        return this.f344094a.getAllowUserInteraction();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        return this.f344094a.getCipherSuite();
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.f344094a.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        this.f344095b.e(4, this.f344094a);
        return this.f344094a.getContent();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return this.f344094a.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return this.f344094a.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return this.f344094a.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        this.f344095b.e(4, this.f344094a);
        return this.f344094a.getErrorStream();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int i3) {
        this.f344095b.e(4, this.f344094a);
        return this.f344094a.getHeaderField(i3);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int i3) {
        return this.f344094a.getHeaderFieldKey(i3);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        this.f344095b.e(4, this.f344094a);
        return this.f344094a.getHeaderFields();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public HostnameVerifier getHostnameVerifier() {
        return this.f344094a.getHostnameVerifier();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return this.f344094a.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        this.f344095b.e(4, this.f344094a);
        return this.f344094a.getInputStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.f344094a.getInstanceFollowRedirects();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        return this.f344094a.getLocalCertificates();
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        this.f344095b.e(2, this.f344094a);
        return this.f344095b.b(this.f344094a);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return this.f344094a.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.f344094a.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return this.f344094a.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return this.f344094a.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return this.f344094a.getRequestProperty(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        this.f344095b.e(4, this.f344094a);
        return this.f344094a.getResponseCode();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        this.f344095b.e(4, this.f344094a);
        return this.f344094a.getResponseMessage();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public SSLSocketFactory getSSLSocketFactory() {
        return this.f344094a.getSSLSocketFactory();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        return this.f344094a.getServerCertificates();
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return this.f344094a.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return this.f344094a.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean z16) {
        this.f344094a.setAllowUserInteraction(z16);
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i3) {
        this.f344094a.setConnectTimeout(i3);
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z16) {
        this.f344094a.setDefaultUseCaches(z16);
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z16) {
        this.f344094a.setDoInput(z16);
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z16) {
        this.f344094a.setDoOutput(z16);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i3) {
        this.f344094a.setFixedLengthStreamingMode(i3);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f344094a.setHostnameVerifier(hostnameVerifier);
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j3) {
        this.f344094a.setIfModifiedSince(j3);
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z16) {
        this.f344094a.setInstanceFollowRedirects(z16);
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i3) {
        this.f344094a.setReadTimeout(i3);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        this.f344095b.f344112a = str;
        this.f344094a.setRequestMethod(str);
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String str, String str2) {
        this.f344094a.setRequestProperty(str, str2);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f344094a.setSSLSocketFactory(sSLSocketFactory);
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z16) {
        this.f344094a.setUseCaches(z16);
    }

    @Override // java.net.URLConnection
    public String toString() {
        return this.f344094a.toString();
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return this.f344094a.usingProxy();
    }

    @Override // java.net.HttpURLConnection
    @RequiresApi(api = 19)
    public void setFixedLengthStreamingMode(long j3) {
        this.f344094a.setFixedLengthStreamingMode(j3);
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        this.f344095b.e(4, this.f344094a);
        return this.f344094a.getContent(clsArr);
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        this.f344095b.e(4, this.f344094a);
        return this.f344094a.getHeaderField(str);
    }
}
