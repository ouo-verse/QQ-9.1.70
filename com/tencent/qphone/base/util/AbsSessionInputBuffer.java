package com.tencent.qphone.base.util;

import java.io.IOException;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class AbsSessionInputBuffer implements SessionInputBuffer {
    protected byte[] buffer;
    protected int bufferlen;
    protected int bufferpos;
    protected HttpTransportMetricsImpl metrics;
    protected ByteArrayBuffer linebuffer = null;
    protected String charset = "US-ASCII";
    protected boolean ascii = true;
    protected int maxLineLen = -1;

    private int lineFromLineBuffer(CharArrayBuffer charArrayBuffer) throws IOException {
        int length = this.linebuffer.length();
        if (length > 0) {
            if (this.linebuffer.byteAt(length - 1) == 10) {
                length--;
                this.linebuffer.setLength(length);
            }
            if (length > 0 && this.linebuffer.byteAt(length - 1) == 13) {
                this.linebuffer.setLength(length - 1);
            }
        }
        int length2 = this.linebuffer.length();
        if (this.ascii) {
            charArrayBuffer.append(this.linebuffer, 0, length2);
        } else {
            charArrayBuffer.append(new String(this.linebuffer.buffer(), 0, length2, this.charset));
        }
        return length2;
    }

    private int lineFromReadBuffer(CharArrayBuffer charArrayBuffer, int i3) throws IOException {
        int i16 = this.bufferpos;
        this.bufferpos = i3 + 1;
        if (i3 > i16 && this.buffer[i3 - 1] == 13) {
            i3--;
        }
        int i17 = i3 - i16;
        if (this.ascii) {
            charArrayBuffer.append(this.buffer, i16, i17);
        } else {
            charArrayBuffer.append(new String(this.buffer, i16, i17, this.charset));
        }
        return i17;
    }

    private int locateLF() {
        for (int i3 = this.bufferpos; i3 < this.bufferlen; i3++) {
            if (this.buffer[i3] == 10) {
                return i3;
            }
        }
        return -1;
    }

    protected abstract int fillBuffer() throws IOException;

    public byte[] getBuffer() {
        return this.buffer;
    }

    public int getBufferlen() {
        return this.bufferlen;
    }

    public int getBufferpos() {
        return this.bufferpos;
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }

    public boolean hasBufferedData() {
        if (this.bufferpos < this.bufferlen) {
            return true;
        }
        return false;
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public int read() throws IOException {
        while (!hasBufferedData()) {
            if (fillBuffer() == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i3 = this.bufferpos;
        this.bufferpos = i3 + 1;
        return bArr[i3] & 255;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x004b, code lost:
    
        if (r2 == (-1)) goto L13;
     */
    @Override // org.apache.http.io.SessionInputBuffer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int readLine(CharArrayBuffer charArrayBuffer) throws IOException {
        if (charArrayBuffer != null) {
            this.linebuffer.clear();
            boolean z16 = true;
            int i3 = 0;
            while (z16) {
                int locateLF = locateLF();
                if (locateLF != -1) {
                    if (this.linebuffer.isEmpty()) {
                        return lineFromReadBuffer(charArrayBuffer, locateLF);
                    }
                    int i16 = locateLF + 1;
                    int i17 = this.bufferpos;
                    this.linebuffer.append(this.buffer, i17, i16 - i17);
                    this.bufferpos = i16;
                } else {
                    if (hasBufferedData()) {
                        int i18 = this.bufferlen;
                        int i19 = this.bufferpos;
                        this.linebuffer.append(this.buffer, i19, i18 - i19);
                        this.bufferpos = this.bufferlen;
                    }
                    i3 = fillBuffer();
                }
                z16 = false;
                if (this.maxLineLen > 0 && this.linebuffer.length() >= this.maxLineLen) {
                    throw new IOException("Maximum line length limit exceeded");
                }
            }
            if (i3 == -1 && this.linebuffer.isEmpty()) {
                return -1;
            }
            return lineFromLineBuffer(charArrayBuffer);
        }
        throw new IllegalArgumentException("Char array buffer may not be null");
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        if (bArr == null) {
            return 0;
        }
        while (!hasBufferedData()) {
            if (fillBuffer() == -1) {
                return -1;
            }
        }
        int i17 = this.bufferlen;
        int i18 = this.bufferpos;
        int i19 = i17 - i18;
        if (i19 <= i16) {
            i16 = i19;
        }
        System.arraycopy(this.buffer, i18, bArr, i3, i16);
        this.bufferpos += i16;
        return i16;
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public int read(byte[] bArr) throws IOException {
        if (bArr == null) {
            return 0;
        }
        return read(bArr, 0, bArr.length);
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public String readLine() throws IOException {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
        if (readLine(charArrayBuffer) != -1) {
            return charArrayBuffer.toString();
        }
        return null;
    }
}
