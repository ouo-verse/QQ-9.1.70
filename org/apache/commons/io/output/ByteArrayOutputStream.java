package org.apache.commons.io.output;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.input.ClosedInputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ByteArrayOutputStream extends OutputStream {
    static final int DEFAULT_SIZE = 1024;
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private final List<byte[]> buffers;
    private int count;
    private byte[] currentBuffer;
    private int currentBufferIndex;
    private int filledBufferSum;
    private boolean reuseBuffers;

    public ByteArrayOutputStream() {
        this(1024);
    }

    private void needNewBuffer(int i3) {
        if (this.currentBufferIndex < this.buffers.size() - 1) {
            this.filledBufferSum += this.currentBuffer.length;
            int i16 = this.currentBufferIndex + 1;
            this.currentBufferIndex = i16;
            this.currentBuffer = this.buffers.get(i16);
            return;
        }
        byte[] bArr = this.currentBuffer;
        if (bArr == null) {
            this.filledBufferSum = 0;
        } else {
            i3 = Math.max(bArr.length << 1, i3 - this.filledBufferSum);
            this.filledBufferSum += this.currentBuffer.length;
        }
        this.currentBufferIndex++;
        byte[] bArr2 = new byte[i3];
        this.currentBuffer = bArr2;
        this.buffers.add(bArr2);
    }

    public static InputStream toBufferedInputStream(InputStream inputStream) throws IOException {
        return toBufferedInputStream(inputStream, 1024);
    }

    public synchronized void reset() {
        this.count = 0;
        this.filledBufferSum = 0;
        this.currentBufferIndex = 0;
        if (this.reuseBuffers) {
            this.currentBuffer = this.buffers.get(0);
        } else {
            this.currentBuffer = null;
            int length = this.buffers.get(0).length;
            this.buffers.clear();
            needNewBuffer(length);
            this.reuseBuffers = true;
        }
    }

    public synchronized int size() {
        return this.count;
    }

    public synchronized byte[] toByteArray() {
        int i3 = this.count;
        if (i3 == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[i3];
        int i16 = 0;
        for (byte[] bArr2 : this.buffers) {
            int min = Math.min(bArr2.length, i3);
            System.arraycopy(bArr2, 0, bArr, i16, min);
            i16 += min;
            i3 -= min;
            if (i3 == 0) {
                break;
            }
        }
        return bArr;
    }

    public synchronized InputStream toInputStream() {
        int i3 = this.count;
        if (i3 == 0) {
            return new ClosedInputStream();
        }
        ArrayList arrayList = new ArrayList(this.buffers.size());
        for (byte[] bArr : this.buffers) {
            int min = Math.min(bArr.length, i3);
            arrayList.add(new ByteArrayInputStream(bArr, 0, min));
            i3 -= min;
            if (i3 == 0) {
                break;
            }
        }
        this.reuseBuffers = false;
        return new SequenceInputStream(Collections.enumeration(arrayList));
    }

    @Deprecated
    public String toString() {
        return new String(toByteArray(), Charset.defaultCharset());
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i16) {
        int i17;
        if (i3 < 0 || i3 > bArr.length || i16 < 0 || (i17 = i3 + i16) > bArr.length || i17 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i16 == 0) {
            return;
        }
        synchronized (this) {
            int i18 = this.count;
            int i19 = i18 + i16;
            int i26 = i18 - this.filledBufferSum;
            while (i16 > 0) {
                int min = Math.min(i16, this.currentBuffer.length - i26);
                System.arraycopy(bArr, i17 - i16, this.currentBuffer, i26, min);
                i16 -= min;
                if (i16 > 0) {
                    needNewBuffer(i19);
                    i26 = 0;
                }
            }
            this.count = i19;
        }
    }

    public synchronized void writeTo(OutputStream outputStream) throws IOException {
        int i3 = this.count;
        for (byte[] bArr : this.buffers) {
            int min = Math.min(bArr.length, i3);
            outputStream.write(bArr, 0, min);
            i3 -= min;
            if (i3 == 0) {
                break;
            }
        }
    }

    public ByteArrayOutputStream(int i3) {
        this.buffers = new ArrayList();
        this.reuseBuffers = true;
        if (i3 >= 0) {
            synchronized (this) {
                needNewBuffer(i3);
            }
        } else {
            throw new IllegalArgumentException("Negative initial size: " + i3);
        }
    }

    public static InputStream toBufferedInputStream(InputStream inputStream, int i3) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i3);
        byteArrayOutputStream.write(inputStream);
        return byteArrayOutputStream.toInputStream();
    }

    public String toString(String str) throws UnsupportedEncodingException {
        return new String(toByteArray(), str);
    }

    public String toString(Charset charset) {
        return new String(toByteArray(), charset);
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i3) {
        int i16 = this.count;
        int i17 = i16 - this.filledBufferSum;
        if (i17 == this.currentBuffer.length) {
            needNewBuffer(i16 + 1);
            i17 = 0;
        }
        this.currentBuffer[i17] = (byte) i3;
        this.count++;
    }

    public synchronized int write(InputStream inputStream) throws IOException {
        int i3;
        int i16 = this.count - this.filledBufferSum;
        byte[] bArr = this.currentBuffer;
        int read = inputStream.read(bArr, i16, bArr.length - i16);
        i3 = 0;
        while (read != -1) {
            i3 += read;
            i16 += read;
            this.count += read;
            byte[] bArr2 = this.currentBuffer;
            if (i16 == bArr2.length) {
                needNewBuffer(bArr2.length);
                i16 = 0;
            }
            byte[] bArr3 = this.currentBuffer;
            read = inputStream.read(bArr3, i16, bArr3.length - i16);
        }
        return i3;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }
}
