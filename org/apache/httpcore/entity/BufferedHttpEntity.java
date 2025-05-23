package org.apache.httpcore.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.httpcore.HttpEntity;
import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BufferedHttpEntity extends HttpEntityWrapper {
    private final byte[] buffer;

    public BufferedHttpEntity(HttpEntity httpEntity) throws IOException {
        super(httpEntity);
        if (httpEntity.isRepeatable() && httpEntity.getContentLength() >= 0) {
            this.buffer = null;
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        httpEntity.writeTo(byteArrayOutputStream);
        byteArrayOutputStream.flush();
        this.buffer = byteArrayOutputStream.toByteArray();
    }

    @Override // org.apache.httpcore.entity.HttpEntityWrapper, org.apache.httpcore.HttpEntity
    public InputStream getContent() throws IOException {
        if (this.buffer != null) {
            return new ByteArrayInputStream(this.buffer);
        }
        return super.getContent();
    }

    @Override // org.apache.httpcore.entity.HttpEntityWrapper, org.apache.httpcore.HttpEntity
    public long getContentLength() {
        if (this.buffer != null) {
            return r0.length;
        }
        return super.getContentLength();
    }

    @Override // org.apache.httpcore.entity.HttpEntityWrapper, org.apache.httpcore.HttpEntity
    public boolean isChunked() {
        if (this.buffer == null && super.isChunked()) {
            return true;
        }
        return false;
    }

    @Override // org.apache.httpcore.entity.HttpEntityWrapper, org.apache.httpcore.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // org.apache.httpcore.entity.HttpEntityWrapper, org.apache.httpcore.HttpEntity
    public boolean isStreaming() {
        if (this.buffer == null && super.isStreaming()) {
            return true;
        }
        return false;
    }

    @Override // org.apache.httpcore.entity.HttpEntityWrapper, org.apache.httpcore.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        byte[] bArr = this.buffer;
        if (bArr != null) {
            outputStream.write(bArr);
        } else {
            super.writeTo(outputStream);
        }
    }
}
