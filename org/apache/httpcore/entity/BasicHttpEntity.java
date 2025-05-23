package org.apache.httpcore.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.httpcore.impl.io.EmptyInputStream;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.Asserts;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BasicHttpEntity extends AbstractHttpEntity {
    private InputStream content;
    private long length = -1;

    @Override // org.apache.httpcore.HttpEntity
    public InputStream getContent() throws IllegalStateException {
        boolean z16;
        if (this.content != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Asserts.check(z16, "Content has not been provided");
        return this.content;
    }

    @Override // org.apache.httpcore.HttpEntity
    public long getContentLength() {
        return this.length;
    }

    @Override // org.apache.httpcore.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // org.apache.httpcore.HttpEntity
    public boolean isStreaming() {
        InputStream inputStream = this.content;
        if (inputStream != null && inputStream != EmptyInputStream.INSTANCE) {
            return true;
        }
        return false;
    }

    public void setContent(InputStream inputStream) {
        this.content = inputStream;
    }

    public void setContentLength(long j3) {
        this.length = j3;
    }

    @Override // org.apache.httpcore.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        InputStream content = getContent();
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = content.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        } finally {
            content.close();
        }
    }
}
