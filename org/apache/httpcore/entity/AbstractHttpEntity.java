package org.apache.httpcore.entity;

import java.io.IOException;
import org.apache.httpcore.Header;
import org.apache.httpcore.HttpEntity;
import org.apache.httpcore.message.BasicHeader;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class AbstractHttpEntity implements HttpEntity {
    protected static final int OUTPUT_BUFFER_SIZE = 4096;
    protected boolean chunked;
    protected Header contentEncoding;
    protected Header contentType;

    @Override // org.apache.httpcore.HttpEntity
    public Header getContentEncoding() {
        return this.contentEncoding;
    }

    @Override // org.apache.httpcore.HttpEntity
    public Header getContentType() {
        return this.contentType;
    }

    @Override // org.apache.httpcore.HttpEntity
    public boolean isChunked() {
        return this.chunked;
    }

    public void setChunked(boolean z16) {
        this.chunked = z16;
    }

    public void setContentEncoding(Header header) {
        this.contentEncoding = header;
    }

    public void setContentType(Header header) {
        this.contentType = header;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append('[');
        if (this.contentType != null) {
            sb5.append("Content-Type: ");
            sb5.append(this.contentType.getValue());
            sb5.append(',');
        }
        if (this.contentEncoding != null) {
            sb5.append("Content-Encoding: ");
            sb5.append(this.contentEncoding.getValue());
            sb5.append(',');
        }
        long contentLength = getContentLength();
        if (contentLength >= 0) {
            sb5.append("Content-Length: ");
            sb5.append(contentLength);
            sb5.append(',');
        }
        sb5.append("Chunked: ");
        sb5.append(this.chunked);
        sb5.append(']');
        return sb5.toString();
    }

    public void setContentEncoding(String str) {
        setContentEncoding(str != null ? new BasicHeader("Content-Encoding", str) : null);
    }

    public void setContentType(String str) {
        setContentType(str != null ? new BasicHeader("Content-Type", str) : null);
    }

    @Override // org.apache.httpcore.HttpEntity
    @Deprecated
    public void consumeContent() throws IOException {
    }
}
