package org.apache.httpcore.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public class InputStreamEntity extends AbstractHttpEntity {
    private final InputStream content;
    private final long length;

    public InputStreamEntity(InputStream inputStream) {
        this(inputStream, -1L);
    }

    @Override // org.apache.httpcore.HttpEntity
    public InputStream getContent() throws IOException {
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
        return true;
    }

    @Override // org.apache.httpcore.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        int read;
        Args.notNull(outputStream, "Output stream");
        InputStream inputStream = this.content;
        try {
            byte[] bArr = new byte[4096];
            long j3 = this.length;
            if (j3 < 0) {
                while (true) {
                    int read2 = inputStream.read(bArr);
                    if (read2 == -1) {
                        break;
                    } else {
                        outputStream.write(bArr, 0, read2);
                    }
                }
            } else {
                while (j3 > 0 && (read = inputStream.read(bArr, 0, (int) Math.min(4096L, j3))) != -1) {
                    outputStream.write(bArr, 0, read);
                    j3 -= read;
                }
            }
        } finally {
            inputStream.close();
        }
    }

    public InputStreamEntity(InputStream inputStream, long j3) {
        this(inputStream, j3, null);
    }

    public InputStreamEntity(InputStream inputStream, ContentType contentType) {
        this(inputStream, -1L, contentType);
    }

    public InputStreamEntity(InputStream inputStream, long j3, ContentType contentType) {
        this.content = (InputStream) Args.notNull(inputStream, "Source input stream");
        this.length = j3;
        if (contentType != null) {
            setContentType(contentType.toString());
        }
    }
}
