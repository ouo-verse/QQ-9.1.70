package h0;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes.dex */
public final class d extends InputStream {

    /* renamed from: f, reason: collision with root package name */
    @GuardedBy("POOL")
    private static final Queue<d> f403949f = k.e(0);

    /* renamed from: d, reason: collision with root package name */
    private InputStream f403950d;

    /* renamed from: e, reason: collision with root package name */
    private IOException f403951e;

    d() {
    }

    @NonNull
    public static d b(@NonNull InputStream inputStream) {
        d poll;
        Queue<d> queue = f403949f;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new d();
        }
        poll.c(inputStream);
        return poll;
    }

    @Nullable
    public IOException a() {
        return this.f403951e;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f403950d.available();
    }

    void c(@NonNull InputStream inputStream) {
        this.f403950d = inputStream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f403950d.close();
    }

    @Override // java.io.InputStream
    public void mark(int i3) {
        this.f403950d.mark(i3);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f403950d.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f403950d.read();
        } catch (IOException e16) {
            this.f403951e = e16;
            throw e16;
        }
    }

    public void release() {
        this.f403951e = null;
        this.f403950d = null;
        Queue<d> queue = f403949f;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f403950d.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j3) throws IOException {
        try {
            return this.f403950d.skip(j3);
        } catch (IOException e16) {
            this.f403951e = e16;
            throw e16;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f403950d.read(bArr);
        } catch (IOException e16) {
            this.f403951e = e16;
            throw e16;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        try {
            return this.f403950d.read(bArr, i3, i16);
        } catch (IOException e16) {
            this.f403951e = e16;
            throw e16;
        }
    }
}
