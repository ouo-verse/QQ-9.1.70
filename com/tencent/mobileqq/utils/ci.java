package com.tencent.mobileqq.utils;

import com.tencent.commonsdk.pool.ByteArrayPool;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ci extends ByteArrayOutputStream {

    /* renamed from: d, reason: collision with root package name */
    private final ByteArrayPool f307531d;

    public ci(ByteArrayPool byteArrayPool, int i3) {
        this.f307531d = byteArrayPool;
        ((ByteArrayOutputStream) this).buf = byteArrayPool.getBuf(Math.max(i3, 256));
    }

    private void a(int i3) {
        int i16 = ((ByteArrayOutputStream) this).count;
        if (i16 + i3 <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] buf = this.f307531d.getBuf((i16 + i3) * 2);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, buf, 0, ((ByteArrayOutputStream) this).count);
        this.f307531d.returnBuf(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = buf;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f307531d.returnBuf(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i3, int i16) {
        a(i16);
        super.write(bArr, i3, i16);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i3) {
        a(1);
        super.write(i3);
    }
}
