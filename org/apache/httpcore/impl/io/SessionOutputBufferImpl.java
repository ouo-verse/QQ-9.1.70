package org.apache.httpcore.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import org.apache.httpcore.io.BufferInfo;
import org.apache.httpcore.io.HttpTransportMetrics;
import org.apache.httpcore.io.SessionOutputBuffer;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.Asserts;
import org.apache.httpcore.util.ByteArrayBuffer;
import org.apache.httpcore.util.CharArrayBuffer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SessionOutputBufferImpl implements SessionOutputBuffer, BufferInfo {
    private static final byte[] CRLF = {13, 10};
    private ByteBuffer bbuf;
    private final ByteArrayBuffer buffer;
    private final CharsetEncoder encoder;
    private final int fragementSizeHint;
    private final HttpTransportMetricsImpl metrics;
    private OutputStream outStream;

    public SessionOutputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl, int i3, int i16, CharsetEncoder charsetEncoder) {
        Args.positive(i3, "Buffer size");
        Args.notNull(httpTransportMetricsImpl, "HTTP transport metrcis");
        this.metrics = httpTransportMetricsImpl;
        this.buffer = new ByteArrayBuffer(i3);
        this.fragementSizeHint = i16 < 0 ? 0 : i16;
        this.encoder = charsetEncoder;
    }

    private void flushBuffer() throws IOException {
        int length = this.buffer.length();
        if (length > 0) {
            streamWrite(this.buffer.buffer(), 0, length);
            this.buffer.clear();
            this.metrics.incrementBytesTransferred(length);
        }
    }

    private void flushStream() throws IOException {
        OutputStream outputStream = this.outStream;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    private void handleEncodingResult(CoderResult coderResult) throws IOException {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.bbuf.flip();
        while (this.bbuf.hasRemaining()) {
            write(this.bbuf.get());
        }
        this.bbuf.compact();
    }

    private void streamWrite(byte[] bArr, int i3, int i16) throws IOException {
        Asserts.notNull(this.outStream, "Output stream");
        this.outStream.write(bArr, i3, i16);
    }

    private void writeEncoded(CharBuffer charBuffer) throws IOException {
        if (!charBuffer.hasRemaining()) {
            return;
        }
        if (this.bbuf == null) {
            this.bbuf = ByteBuffer.allocate(1024);
        }
        this.encoder.reset();
        while (charBuffer.hasRemaining()) {
            handleEncodingResult(this.encoder.encode(charBuffer, this.bbuf, true));
        }
        handleEncodingResult(this.encoder.flush(this.bbuf));
        this.bbuf.clear();
    }

    @Override // org.apache.httpcore.io.BufferInfo
    public int available() {
        return capacity() - length();
    }

    public void bind(OutputStream outputStream) {
        this.outStream = outputStream;
    }

    @Override // org.apache.httpcore.io.BufferInfo
    public int capacity() {
        return this.buffer.capacity();
    }

    @Override // org.apache.httpcore.io.SessionOutputBuffer
    public void flush() throws IOException {
        flushBuffer();
        flushStream();
    }

    @Override // org.apache.httpcore.io.SessionOutputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }

    public boolean isBound() {
        if (this.outStream != null) {
            return true;
        }
        return false;
    }

    @Override // org.apache.httpcore.io.BufferInfo
    public int length() {
        return this.buffer.length();
    }

    @Override // org.apache.httpcore.io.SessionOutputBuffer
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        if (bArr == null) {
            return;
        }
        if (i16 <= this.fragementSizeHint && i16 <= this.buffer.capacity()) {
            if (i16 > this.buffer.capacity() - this.buffer.length()) {
                flushBuffer();
            }
            this.buffer.append(bArr, i3, i16);
        } else {
            flushBuffer();
            streamWrite(bArr, i3, i16);
            this.metrics.incrementBytesTransferred(i16);
        }
    }

    @Override // org.apache.httpcore.io.SessionOutputBuffer
    public void writeLine(String str) throws IOException {
        if (str == null) {
            return;
        }
        if (str.length() > 0) {
            if (this.encoder == null) {
                for (int i3 = 0; i3 < str.length(); i3++) {
                    write(str.charAt(i3));
                }
            } else {
                writeEncoded(CharBuffer.wrap(str));
            }
        }
        write(CRLF);
    }

    public SessionOutputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl, int i3) {
        this(httpTransportMetricsImpl, i3, i3, null);
    }

    @Override // org.apache.httpcore.io.SessionOutputBuffer
    public void write(byte[] bArr) throws IOException {
        if (bArr == null) {
            return;
        }
        write(bArr, 0, bArr.length);
    }

    @Override // org.apache.httpcore.io.SessionOutputBuffer
    public void writeLine(CharArrayBuffer charArrayBuffer) throws IOException {
        if (charArrayBuffer == null) {
            return;
        }
        int i3 = 0;
        if (this.encoder == null) {
            int length = charArrayBuffer.length();
            while (length > 0) {
                int min = Math.min(this.buffer.capacity() - this.buffer.length(), length);
                if (min > 0) {
                    this.buffer.append(charArrayBuffer, i3, min);
                }
                if (this.buffer.isFull()) {
                    flushBuffer();
                }
                i3 += min;
                length -= min;
            }
        } else {
            writeEncoded(CharBuffer.wrap(charArrayBuffer.buffer(), 0, charArrayBuffer.length()));
        }
        write(CRLF);
    }

    @Override // org.apache.httpcore.io.SessionOutputBuffer
    public void write(int i3) throws IOException {
        if (this.fragementSizeHint > 0) {
            if (this.buffer.isFull()) {
                flushBuffer();
            }
            this.buffer.append(i3);
        } else {
            flushBuffer();
            this.outStream.write(i3);
        }
    }
}
