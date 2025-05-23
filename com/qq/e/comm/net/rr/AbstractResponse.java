package com.qq.e.comm.net.rr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class AbstractResponse implements Response {

    /* renamed from: a, reason: collision with root package name */
    private final HttpURLConnection f38313a;

    /* renamed from: b, reason: collision with root package name */
    private int f38314b;

    public AbstractResponse(HttpURLConnection httpURLConnection) {
        this.f38314b = 0;
        if (httpURLConnection != null) {
            this.f38313a = httpURLConnection;
            try {
                this.f38314b = httpURLConnection.getResponseCode();
                return;
            } catch (IOException e16) {
                throw new AssertionError(e16);
            }
        }
        throw new AssertionError("AbstractResponse parameter is null");
    }

    @Override // com.qq.e.comm.net.rr.Response
    public void close() throws IllegalStateException, IOException {
        this.f38313a.disconnect();
    }

    @Override // com.qq.e.comm.net.rr.Response
    public byte[] getBytesContent() throws IllegalStateException, IOException {
        if (200 != getStatusCode()) {
            return null;
        }
        InputStream streamContent = getStreamContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = streamContent.read(bArr);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                streamContent.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    @Override // com.qq.e.comm.net.rr.Response
    public int getStatusCode() {
        return this.f38314b;
    }

    @Override // com.qq.e.comm.net.rr.Response
    public InputStream getStreamContent() throws IllegalStateException, IOException {
        return this.f38313a.getInputStream();
    }

    @Override // com.qq.e.comm.net.rr.Response
    public String getStringContent() throws IOException {
        return getStringContent("UTF-8");
    }

    @Override // com.qq.e.comm.net.rr.Response
    public String getStringContent(String str) throws IOException {
        byte[] bytesContent = getBytesContent();
        String str2 = null;
        if (bytesContent == null) {
            return null;
        }
        if (bytesContent.length == 0) {
            return "";
        }
        try {
            str2 = this.f38313a.getContentEncoding();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (str2 != null) {
            str = str2;
        }
        return new String(bytesContent, str);
    }
}
