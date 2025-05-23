package org.apache.httpcore.entity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ByteArrayEntity extends AbstractHttpEntity implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f423545b;

    @Deprecated
    protected final byte[] content;
    private final int len;
    private final int off;

    public ByteArrayEntity(byte[] bArr, ContentType contentType) {
        Args.notNull(bArr, "Source byte array");
        this.content = bArr;
        this.f423545b = bArr;
        this.off = 0;
        this.len = bArr.length;
        if (contentType != null) {
            setContentType(contentType.toString());
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // org.apache.httpcore.HttpEntity
    public InputStream getContent() {
        return new ByteArrayInputStream(this.f423545b, this.off, this.len);
    }

    @Override // org.apache.httpcore.HttpEntity
    public long getContentLength() {
        return this.len;
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
        outputStream.write(this.f423545b, this.off, this.len);
        outputStream.flush();
    }

    public ByteArrayEntity(byte[] bArr, int i3, int i16, ContentType contentType) {
        int i17;
        Args.notNull(bArr, "Source byte array");
        if (i3 >= 0 && i3 <= bArr.length && i16 >= 0 && (i17 = i3 + i16) >= 0 && i17 <= bArr.length) {
            this.content = bArr;
            this.f423545b = bArr;
            this.off = i3;
            this.len = i16;
            if (contentType != null) {
                setContentType(contentType.toString());
                return;
            }
            return;
        }
        throw new IndexOutOfBoundsException("off: " + i3 + " len: " + i16 + " b.length: " + bArr.length);
    }

    public ByteArrayEntity(byte[] bArr) {
        this(bArr, null);
    }

    public ByteArrayEntity(byte[] bArr, int i3, int i16) {
        this(bArr, i3, i16, null);
    }
}
