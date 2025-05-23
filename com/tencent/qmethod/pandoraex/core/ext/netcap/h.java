package com.tencent.qmethod.pandoraex.core.ext.netcap;

import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class h extends HttpURLConnection {

    /* renamed from: a, reason: collision with root package name */
    final HttpURLConnection f344092a;

    /* renamed from: b, reason: collision with root package name */
    final p f344093b;

    public h(String str, HttpURLConnection httpURLConnection) {
        super(null);
        this.f344092a = httpURLConnection;
        this.f344093b = new p(str);
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String str, String str2) {
        this.f344092a.addRequestProperty(str, str2);
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        this.f344093b.e(2, this.f344092a);
        this.f344092a.connect();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        this.f344092a.disconnect();
    }

    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        return this.f344092a.getAllowUserInteraction();
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.f344092a.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        this.f344093b.e(4, this.f344092a);
        return this.f344092a.getContent();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return this.f344092a.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return this.f344092a.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return this.f344092a.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        this.f344093b.e(4, this.f344092a);
        return this.f344093b.a(this.f344092a);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int i3) {
        this.f344093b.e(4, this.f344092a);
        return this.f344092a.getHeaderField(i3);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int i3) {
        this.f344093b.e(4, this.f344092a);
        return this.f344092a.getHeaderFieldKey(i3);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        this.f344093b.e(4, this.f344092a);
        return this.f344092a.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return this.f344092a.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        this.f344093b.e(4, this.f344092a);
        return this.f344092a.getInputStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.f344092a.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        this.f344093b.e(2, this.f344092a);
        return this.f344093b.b(this.f344092a);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return this.f344092a.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.f344092a.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return this.f344092a.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return this.f344092a.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return this.f344092a.getRequestProperty(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        this.f344093b.e(4, this.f344092a);
        return this.f344092a.getResponseCode();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        this.f344093b.e(4, this.f344092a);
        return this.f344092a.getResponseMessage();
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return this.f344092a.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return this.f344092a.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean z16) {
        this.f344092a.setAllowUserInteraction(z16);
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i3) {
        this.f344092a.setConnectTimeout(i3);
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z16) {
        this.f344092a.setDefaultUseCaches(z16);
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z16) {
        this.f344092a.setDoInput(z16);
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z16) {
        this.f344092a.setDoOutput(z16);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i3) {
        this.f344092a.setFixedLengthStreamingMode(i3);
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j3) {
        this.f344092a.setIfModifiedSince(j3);
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z16) {
        this.f344092a.setInstanceFollowRedirects(z16);
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i3) {
        this.f344092a.setReadTimeout(i3);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        this.f344092a.setRequestMethod(str);
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String str, String str2) {
        this.f344092a.setRequestProperty(str, str2);
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z16) {
        this.f344092a.setUseCaches(z16);
    }

    @Override // java.net.URLConnection
    public String toString() {
        return this.f344092a.toString();
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return this.f344092a.usingProxy();
    }

    @Override // java.net.HttpURLConnection
    @RequiresApi(api = 19)
    public void setFixedLengthStreamingMode(long j3) {
        this.f344092a.setFixedLengthStreamingMode(j3);
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) throws IOException {
        this.f344093b.e(4, this.f344092a);
        return this.f344092a.getContent(clsArr);
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        this.f344093b.e(4, this.f344092a);
        return this.f344092a.getHeaderField(str);
    }
}
