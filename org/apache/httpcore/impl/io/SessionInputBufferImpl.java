package org.apache.httpcore.impl.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import org.apache.httpcore.MessageConstraintException;
import org.apache.httpcore.config.MessageConstraints;
import org.apache.httpcore.io.BufferInfo;
import org.apache.httpcore.io.HttpTransportMetrics;
import org.apache.httpcore.io.SessionInputBuffer;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.Asserts;
import org.apache.httpcore.util.ByteArrayBuffer;
import org.apache.httpcore.util.CharArrayBuffer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SessionInputBufferImpl implements SessionInputBuffer, BufferInfo {
    private final byte[] buffer;
    private int bufferLen;
    private int bufferPos;
    private CharBuffer cbuf;
    private final MessageConstraints constraints;
    private final CharsetDecoder decoder;
    private InputStream inStream;
    private final ByteArrayBuffer lineBuffer;
    private final HttpTransportMetricsImpl metrics;
    private final int minChunkLimit;

    public SessionInputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl, int i3, int i16, MessageConstraints messageConstraints, CharsetDecoder charsetDecoder) {
        Args.notNull(httpTransportMetricsImpl, "HTTP transport metrcis");
        Args.positive(i3, "Buffer size");
        this.metrics = httpTransportMetricsImpl;
        this.buffer = new byte[i3];
        this.bufferPos = 0;
        this.bufferLen = 0;
        this.minChunkLimit = i16 < 0 ? 512 : i16;
        this.constraints = messageConstraints == null ? MessageConstraints.DEFAULT : messageConstraints;
        this.lineBuffer = new ByteArrayBuffer(i3);
        this.decoder = charsetDecoder;
    }

    private int appendDecoded(CharArrayBuffer charArrayBuffer, ByteBuffer byteBuffer) throws IOException {
        int i3 = 0;
        if (!byteBuffer.hasRemaining()) {
            return 0;
        }
        if (this.cbuf == null) {
            this.cbuf = CharBuffer.allocate(1024);
        }
        this.decoder.reset();
        while (byteBuffer.hasRemaining()) {
            i3 += handleDecodingResult(this.decoder.decode(byteBuffer, this.cbuf, true), charArrayBuffer, byteBuffer);
        }
        int handleDecodingResult = i3 + handleDecodingResult(this.decoder.flush(this.cbuf), charArrayBuffer, byteBuffer);
        this.cbuf.clear();
        return handleDecodingResult;
    }

    private int handleDecodingResult(CoderResult coderResult, CharArrayBuffer charArrayBuffer, ByteBuffer byteBuffer) throws IOException {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.cbuf.flip();
        int remaining = this.cbuf.remaining();
        while (this.cbuf.hasRemaining()) {
            charArrayBuffer.append(this.cbuf.get());
        }
        this.cbuf.compact();
        return remaining;
    }

    private int lineFromLineBuffer(CharArrayBuffer charArrayBuffer) throws IOException {
        int length = this.lineBuffer.length();
        if (length > 0) {
            if (this.lineBuffer.byteAt(length - 1) == 10) {
                length--;
            }
            if (length > 0 && this.lineBuffer.byteAt(length - 1) == 13) {
                length--;
            }
        }
        if (this.decoder == null) {
            charArrayBuffer.append(this.lineBuffer, 0, length);
        } else {
            length = appendDecoded(charArrayBuffer, ByteBuffer.wrap(this.lineBuffer.buffer(), 0, length));
        }
        this.lineBuffer.clear();
        return length;
    }

    private int lineFromReadBuffer(CharArrayBuffer charArrayBuffer, int i3) throws IOException {
        int i16 = this.bufferPos;
        this.bufferPos = i3 + 1;
        if (i3 > i16 && this.buffer[i3 - 1] == 13) {
            i3--;
        }
        int i17 = i3 - i16;
        if (this.decoder == null) {
            charArrayBuffer.append(this.buffer, i16, i17);
            return i17;
        }
        return appendDecoded(charArrayBuffer, ByteBuffer.wrap(this.buffer, i16, i17));
    }

    private int streamRead(byte[] bArr, int i3, int i16) throws IOException {
        Asserts.notNull(this.inStream, "Input stream");
        return this.inStream.read(bArr, i3, i16);
    }

    @Override // org.apache.httpcore.io.BufferInfo
    public int available() {
        return capacity() - length();
    }

    public void bind(InputStream inputStream) {
        this.inStream = inputStream;
    }

    @Override // org.apache.httpcore.io.BufferInfo
    public int capacity() {
        return this.buffer.length;
    }

    public void clear() {
        this.bufferPos = 0;
        this.bufferLen = 0;
    }

    public int fillBuffer() throws IOException {
        int i3 = this.bufferPos;
        if (i3 > 0) {
            int i16 = this.bufferLen - i3;
            if (i16 > 0) {
                byte[] bArr = this.buffer;
                System.arraycopy(bArr, i3, bArr, 0, i16);
            }
            this.bufferPos = 0;
            this.bufferLen = i16;
        }
        int i17 = this.bufferLen;
        byte[] bArr2 = this.buffer;
        int streamRead = streamRead(bArr2, i17, bArr2.length - i17);
        if (streamRead == -1) {
            return -1;
        }
        this.bufferLen = i17 + streamRead;
        this.metrics.incrementBytesTransferred(streamRead);
        return streamRead;
    }

    @Override // org.apache.httpcore.io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }

    public boolean hasBufferedData() {
        if (this.bufferPos < this.bufferLen) {
            return true;
        }
        return false;
    }

    public boolean isBound() {
        if (this.inStream != null) {
            return true;
        }
        return false;
    }

    @Override // org.apache.httpcore.io.SessionInputBuffer
    public boolean isDataAvailable(int i3) throws IOException {
        return hasBufferedData();
    }

    @Override // org.apache.httpcore.io.BufferInfo
    public int length() {
        return this.bufferLen - this.bufferPos;
    }

    @Override // org.apache.httpcore.io.SessionInputBuffer
    public int read() throws IOException {
        while (!hasBufferedData()) {
            if (fillBuffer() == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i3 = this.bufferPos;
        this.bufferPos = i3 + 1;
        return bArr[i3] & 255;
    }

    @Override // org.apache.httpcore.io.SessionInputBuffer
    public int readLine(CharArrayBuffer charArrayBuffer) throws IOException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        int maxLineLength = this.constraints.getMaxLineLength();
        boolean z16 = true;
        int i3 = 0;
        while (z16) {
            int i16 = this.bufferPos;
            while (true) {
                if (i16 >= this.bufferLen) {
                    i16 = -1;
                    break;
                }
                if (this.buffer[i16] == 10) {
                    break;
                }
                i16++;
            }
            if (maxLineLength > 0) {
                if ((this.lineBuffer.length() + (i16 >= 0 ? i16 : this.bufferLen)) - this.bufferPos >= maxLineLength) {
                    throw new MessageConstraintException("Maximum line length limit exceeded");
                }
            }
            if (i16 != -1) {
                if (this.lineBuffer.isEmpty()) {
                    return lineFromReadBuffer(charArrayBuffer, i16);
                }
                int i17 = i16 + 1;
                int i18 = this.bufferPos;
                this.lineBuffer.append(this.buffer, i18, i17 - i18);
                this.bufferPos = i17;
            } else {
                if (hasBufferedData()) {
                    int i19 = this.bufferLen;
                    int i26 = this.bufferPos;
                    this.lineBuffer.append(this.buffer, i26, i19 - i26);
                    this.bufferPos = this.bufferLen;
                }
                i3 = fillBuffer();
                if (i3 == -1) {
                }
            }
            z16 = false;
        }
        if (i3 == -1 && this.lineBuffer.isEmpty()) {
            return -1;
        }
        return lineFromLineBuffer(charArrayBuffer);
    }

    @Override // org.apache.httpcore.io.SessionInputBuffer
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        if (bArr == null) {
            return 0;
        }
        if (hasBufferedData()) {
            int min = Math.min(i16, this.bufferLen - this.bufferPos);
            System.arraycopy(this.buffer, this.bufferPos, bArr, i3, min);
            this.bufferPos += min;
            return min;
        }
        if (i16 > this.minChunkLimit) {
            int streamRead = streamRead(bArr, i3, i16);
            if (streamRead > 0) {
                this.metrics.incrementBytesTransferred(streamRead);
            }
            return streamRead;
        }
        while (!hasBufferedData()) {
            if (fillBuffer() == -1) {
                return -1;
            }
        }
        int min2 = Math.min(i16, this.bufferLen - this.bufferPos);
        System.arraycopy(this.buffer, this.bufferPos, bArr, i3, min2);
        this.bufferPos += min2;
        return min2;
    }

    public SessionInputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl, int i3) {
        this(httpTransportMetricsImpl, i3, i3, null, null);
    }

    @Override // org.apache.httpcore.io.SessionInputBuffer
    public int read(byte[] bArr) throws IOException {
        if (bArr == null) {
            return 0;
        }
        return read(bArr, 0, bArr.length);
    }

    @Override // org.apache.httpcore.io.SessionInputBuffer
    public String readLine() throws IOException {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
        if (readLine(charArrayBuffer) != -1) {
            return charArrayBuffer.toString();
        }
        return null;
    }
}
