package com.github.luben.zstd;

import java.io.Closeable;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class b implements Closeable {

    /* renamed from: d, reason: collision with root package name */
    protected long f32914d;

    /* renamed from: e, reason: collision with root package name */
    protected ByteBuffer f32915e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f32916f;

    abstract long a(long j3);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f32916f) {
            try {
                a(this.f32914d);
            } finally {
                this.f32916f = true;
                this.f32915e = null;
            }
        }
    }
}
