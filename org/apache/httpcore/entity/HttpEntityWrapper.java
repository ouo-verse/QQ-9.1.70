package org.apache.httpcore.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.httpcore.Header;
import org.apache.httpcore.HttpEntity;
import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public class HttpEntityWrapper implements HttpEntity {
    protected HttpEntity wrappedEntity;

    public HttpEntityWrapper(HttpEntity httpEntity) {
        this.wrappedEntity = (HttpEntity) Args.notNull(httpEntity, "Wrapped entity");
    }

    @Override // org.apache.httpcore.HttpEntity
    @Deprecated
    public void consumeContent() throws IOException {
        this.wrappedEntity.consumeContent();
    }

    @Override // org.apache.httpcore.HttpEntity
    public InputStream getContent() throws IOException {
        return this.wrappedEntity.getContent();
    }

    @Override // org.apache.httpcore.HttpEntity
    public Header getContentEncoding() {
        return this.wrappedEntity.getContentEncoding();
    }

    @Override // org.apache.httpcore.HttpEntity
    public long getContentLength() {
        return this.wrappedEntity.getContentLength();
    }

    @Override // org.apache.httpcore.HttpEntity
    public Header getContentType() {
        return this.wrappedEntity.getContentType();
    }

    @Override // org.apache.httpcore.HttpEntity
    public boolean isChunked() {
        return this.wrappedEntity.isChunked();
    }

    @Override // org.apache.httpcore.HttpEntity
    public boolean isRepeatable() {
        return this.wrappedEntity.isRepeatable();
    }

    @Override // org.apache.httpcore.HttpEntity
    public boolean isStreaming() {
        return this.wrappedEntity.isStreaming();
    }

    @Override // org.apache.httpcore.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        this.wrappedEntity.writeTo(outputStream);
    }
}
