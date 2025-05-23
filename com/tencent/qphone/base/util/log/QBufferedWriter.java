package com.tencent.qphone.base.util.log;

import java.io.IOException;
import java.io.Writer;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QBufferedWriter extends QWriter {
    private static int defaultCharBufferSize = 8192;

    /* renamed from: cb, reason: collision with root package name */
    private char[] f344450cb;
    private int nChars;
    private int nextChar;
    private QWriter out;

    public QBufferedWriter(QWriter qWriter) {
        this(qWriter, defaultCharBufferSize);
    }

    private void ensureOpen() throws IOException {
        if (this.out != null) {
        } else {
            throw new IOException("Stream closed");
        }
    }

    private int min(int i3, int i16) {
        if (i3 < i16) {
            return i3;
        }
        return i16;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (((Writer) this).lock) {
            if (this.out == null) {
                return;
            }
            try {
                flushBuffer();
            } finally {
                this.out.close();
                this.out = null;
                this.f344450cb = null;
            }
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        synchronized (((Writer) this).lock) {
            flushBuffer();
            this.out.flush();
        }
    }

    void flushBuffer() throws IOException {
        synchronized (((Writer) this).lock) {
            ensureOpen();
            int i3 = this.nextChar;
            if (i3 == 0) {
                return;
            }
            this.out.write(this.f344450cb, 0, i3);
            this.nextChar = 0;
        }
    }

    @Override // java.io.Writer
    public void write(int i3) throws IOException {
        synchronized (((Writer) this).lock) {
            ensureOpen();
            if (this.nextChar >= this.nChars) {
                flushBuffer();
            }
            char[] cArr = this.f344450cb;
            int i16 = this.nextChar;
            this.nextChar = i16 + 1;
            cArr[i16] = (char) i3;
        }
    }

    public QBufferedWriter(QWriter qWriter, int i3) {
        super(qWriter);
        if (i3 > 0) {
            this.out = qWriter;
            this.f344450cb = new char[i3];
            this.nChars = i3;
            this.nextChar = 0;
            return;
        }
        throw new IllegalArgumentException("Buffer size <= 0");
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i16) throws IOException {
        int i17;
        synchronized (((Writer) this).lock) {
            ensureOpen();
            if (i3 < 0 || i3 > cArr.length || i16 < 0 || (i17 = i3 + i16) > cArr.length || i17 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i16 == 0) {
                return;
            }
            if (i16 >= this.nChars) {
                flushBuffer();
                this.out.write(cArr, i3, i16);
                return;
            }
            while (i3 < i17) {
                int min = min(this.nChars - this.nextChar, i17 - i3);
                System.arraycopy(cArr, i3, this.f344450cb, this.nextChar, min);
                i3 += min;
                int i18 = this.nextChar + min;
                this.nextChar = i18;
                if (i18 >= this.nChars) {
                    flushBuffer();
                }
            }
        }
    }

    @Override // java.io.Writer
    public void write(String str, int i3, int i16) throws IOException {
        synchronized (((Writer) this).lock) {
            ensureOpen();
            int i17 = i16 + i3;
            while (i3 < i17) {
                int min = min(this.nChars - this.nextChar, i17 - i3);
                int i18 = i3 + min;
                str.getChars(i3, i18, this.f344450cb, this.nextChar);
                int i19 = this.nextChar + min;
                this.nextChar = i19;
                if (i19 >= this.nChars) {
                    flushBuffer();
                }
                i3 = i18;
            }
        }
    }

    @Override // com.tencent.qphone.base.util.log.QWriter
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        synchronized (((Writer) this).lock) {
            flushBuffer();
            this.out.write(bArr, i3, i16);
        }
    }
}
