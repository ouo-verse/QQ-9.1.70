package com.tencent.qmethod.pandoraex.core.ext.netcap;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a implements HttpEntity, j {

    /* renamed from: d, reason: collision with root package name */
    protected final HttpEntity f344074d;

    /* renamed from: e, reason: collision with root package name */
    protected d f344075e;

    public a(HttpEntity httpEntity, d dVar) {
        this.f344074d = httpEntity;
        this.f344075e = dVar;
    }

    @Override // org.apache.http.HttpEntity
    public void consumeContent() throws IOException {
        try {
            this.f344074d.consumeContent();
        } catch (IOException e16) {
            throw e16;
        }
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() throws IOException, IllegalStateException {
        try {
            b bVar = new b(this.f344074d.getContent());
            bVar.e(this);
            return bVar;
        } catch (IOException e16) {
            throw e16;
        } catch (IllegalStateException e17) {
            throw e17;
        }
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        return this.f344074d.getContentEncoding();
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.f344074d.getContentLength();
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentType() {
        return this.f344074d.getContentType();
    }

    @Override // org.apache.http.HttpEntity
    public boolean isChunked() {
        return this.f344074d.isChunked();
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return this.f344074d.isRepeatable();
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return this.f344074d.isStreaming();
    }
}
