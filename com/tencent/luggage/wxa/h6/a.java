package com.tencent.luggage.wxa.h6;

import java.io.InputStream;
import java.nio.ByteBuffer;
import org.joor.Reflect;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f126868a;

    /* renamed from: b, reason: collision with root package name */
    public int f126869b;

    public a(ByteBuffer byteBuffer) {
        this.f126868a = byteBuffer;
    }

    public synchronized void a(int i3) {
        this.f126868a.position(i3);
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f126868a.remaining();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        a(this.f126868a);
    }

    public long d() {
        return this.f126868a.limit();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i3) {
        this.f126869b = this.f126868a.position();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f126868a.hasRemaining()) {
            return this.f126868a.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f126868a.position(this.f126869b);
    }

    public ByteBuffer a() {
        return this.f126868a;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) {
        if (!this.f126868a.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i16, this.f126868a.remaining());
        this.f126868a.get(bArr, i3, min);
        return min;
    }

    public static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.getClass().getName().equals("java.nio.DirectByteBuffer")) {
            try {
                Reflect.on(Reflect.on(byteBuffer).call("cleaner").get()).call("clean");
            } catch (Exception unused) {
            }
        }
    }
}
