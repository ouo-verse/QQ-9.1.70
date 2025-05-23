package org.apache.httpcore.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public class EntityTemplate extends AbstractHttpEntity {
    private final ContentProducer contentproducer;

    public EntityTemplate(ContentProducer contentProducer) {
        this.contentproducer = (ContentProducer) Args.notNull(contentProducer, "Content producer");
    }

    @Override // org.apache.httpcore.HttpEntity
    public InputStream getContent() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        writeTo(byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    @Override // org.apache.httpcore.HttpEntity
    public long getContentLength() {
        return -1L;
    }

    @Override // org.apache.httpcore.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // org.apache.httpcore.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override // org.apache.httpcore.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        this.contentproducer.writeTo(outputStream);
    }
}
