package com.tencent.qphone.base.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.Socket;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.util.ByteArrayBuffer;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MsfSocketInputBuffer extends AbsSessionInputBuffer {
    private static final Class SOCKET_TIMEOUT_CLASS = SocketTimeoutExceptionClass();
    private int inputBufferSize = 0;
    public InputStream instream;
    private final Socket socket;

    public MsfSocketInputBuffer(Socket socket, int i3, String str, int i16) throws IOException {
        if (socket != null) {
            this.socket = socket;
            i3 = i3 < 0 ? socket.getReceiveBufferSize() : i3;
            i3 = i3 < 1024 ? 1024 : i3;
            InputStream inputStream = socket.getInputStream();
            if (!com.tencent.mobileqq.msf.core.net.n.f248797a0.contains(inputStream.toString())) {
                com.tencent.mobileqq.msf.core.net.n.f248797a0.add(inputStream.toString());
            }
            init(inputStream, i3, str, i16);
            return;
        }
        throw new IllegalArgumentException("Socket may not be null");
    }

    private static Class SocketTimeoutExceptionClass() {
        try {
            return Class.forName("java.net.SocketTimeoutException");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static boolean isSocketTimeoutException(InterruptedIOException interruptedIOException) {
        Class cls = SOCKET_TIMEOUT_CLASS;
        if (cls != null) {
            return cls.isInstance(interruptedIOException);
        }
        return true;
    }

    @Override // com.tencent.qphone.base.util.AbsSessionInputBuffer
    protected int fillBuffer() throws IOException {
        int i3 = this.bufferpos;
        if (i3 > 0) {
            int i16 = this.bufferlen - i3;
            if (i16 > 0) {
                byte[] bArr = this.buffer;
                System.arraycopy(bArr, i3, bArr, 0, i16);
            }
            this.bufferpos = 0;
            this.bufferlen = i16;
        }
        int i17 = this.bufferlen;
        byte[] bArr2 = this.buffer;
        int read = this.instream.read(bArr2, i17, bArr2.length - i17);
        if (read == -1) {
            return -1;
        }
        this.bufferlen = i17 + read;
        this.metrics.incrementBytesTransferred(read);
        return read;
    }

    protected void init(InputStream inputStream, int i3, String str, int i16) {
        if (inputStream != null) {
            if (i3 > 0) {
                this.instream = inputStream;
                this.inputBufferSize = i3;
                this.buffer = new byte[i3];
                boolean z16 = false;
                this.bufferpos = 0;
                this.bufferlen = 0;
                this.linebuffer = new ByteArrayBuffer(i3);
                this.charset = str;
                if (str.equalsIgnoreCase("US-ASCII") || this.charset.equalsIgnoreCase("ASCII")) {
                    z16 = true;
                }
                this.ascii = z16;
                this.maxLineLen = i16;
                this.metrics = new HttpTransportMetricsImpl();
                return;
            }
            throw new IllegalArgumentException("Buffer size may not be negative or zero");
        }
        throw new IllegalArgumentException("Input stream may not be null");
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public boolean isDataAvailable(int i3) throws IOException {
        boolean hasBufferedData = hasBufferedData();
        if (!hasBufferedData) {
            int soTimeout = this.socket.getSoTimeout();
            try {
                this.socket.setSoTimeout(i3);
                if (fillBuffer() != -1) {
                    hasBufferedData = hasBufferedData();
                } else {
                    throw new IOException("readData return -1");
                }
            } catch (InterruptedIOException e16) {
                if (!isSocketTimeoutException(e16)) {
                    throw e16;
                }
            } finally {
                this.socket.setSoTimeout(soTimeout);
            }
        }
        return hasBufferedData;
    }

    public void reset() {
        if (this.buffer == null) {
            this.buffer = new byte[this.inputBufferSize];
        }
        this.bufferpos = 0;
        this.bufferlen = 0;
        ByteArrayBuffer byteArrayBuffer = this.linebuffer;
        if (byteArrayBuffer != null) {
            byteArrayBuffer.clear();
        }
    }
}
