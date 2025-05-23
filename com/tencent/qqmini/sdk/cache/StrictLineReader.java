package com.tencent.qqmini.sdk.cache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes23.dex */
class StrictLineReader implements Closeable {
    private static final byte CR = 13;
    private static final byte LF = 10;
    private byte[] buf;
    private final Charset charset;
    private int end;

    /* renamed from: in, reason: collision with root package name */
    private final InputStream f348016in;
    private int pos;

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void fillBuf() throws IOException {
        InputStream inputStream = this.f348016in;
        byte[] bArr = this.buf;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.pos = 0;
            this.end = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f348016in) {
            if (this.buf != null) {
                this.buf = null;
                this.f348016in.close();
            }
        }
    }

    public boolean hasUnterminatedLine() {
        if (this.end == -1) {
            return true;
        }
        return false;
    }

    public String readLine() throws IOException {
        int i3;
        byte[] bArr;
        int i16;
        synchronized (this.f348016in) {
            if (this.buf != null) {
                if (this.pos >= this.end) {
                    fillBuf();
                }
                for (int i17 = this.pos; i17 != this.end; i17++) {
                    byte[] bArr2 = this.buf;
                    if (bArr2[i17] == 10) {
                        int i18 = this.pos;
                        if (i17 != i18) {
                            i16 = i17 - 1;
                            if (bArr2[i16] == 13) {
                                String str = new String(bArr2, i18, i16 - i18, this.charset.name());
                                this.pos = i17 + 1;
                                return str;
                            }
                        }
                        i16 = i17;
                        String str2 = new String(bArr2, i18, i16 - i18, this.charset.name());
                        this.pos = i17 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.end - this.pos) + 80) { // from class: com.tencent.qqmini.sdk.cache.StrictLineReader.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i19 = ((ByteArrayOutputStream) this).count;
                        if (i19 > 0 && ((ByteArrayOutputStream) this).buf[i19 - 1] == 13) {
                            i19--;
                        }
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, i19, StrictLineReader.this.charset.name());
                        } catch (UnsupportedEncodingException e16) {
                            throw new AssertionError(e16);
                        }
                    }
                };
                loop1: while (true) {
                    byte[] bArr3 = this.buf;
                    int i19 = this.pos;
                    byteArrayOutputStream.write(bArr3, i19, this.end - i19);
                    this.end = -1;
                    fillBuf();
                    i3 = this.pos;
                    while (i3 != this.end) {
                        bArr = this.buf;
                        if (bArr[i3] == 10) {
                            break loop1;
                        }
                        i3++;
                    }
                }
                int i26 = this.pos;
                if (i3 != i26) {
                    byteArrayOutputStream.write(bArr, i26, i3 - i26);
                }
                this.pos = i3 + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public StrictLineReader(InputStream inputStream, int i3, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i3 >= 0) {
            if (charset.equals(DiskLruCacheUtil.US_ASCII)) {
                this.f348016in = inputStream;
                this.charset = charset;
                this.buf = new byte[i3];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
