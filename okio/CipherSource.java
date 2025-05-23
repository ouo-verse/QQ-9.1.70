package okio;

import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lokio/CipherSource;", "Lokio/Source;", "source", "Lokio/BufferedSource;", "cipher", "Ljavax/crypto/Cipher;", "(Lokio/BufferedSource;Ljavax/crypto/Cipher;)V", "blockSize", "", "buffer", "Lokio/Buffer;", "getCipher", "()Ljavax/crypto/Cipher;", AudioContext.State.CLOSED, "", "final", "close", "", "doFinal", com.tencent.mobileqq.msf.core.auth.k.f247491e, "", "sink", "byteCount", "refill", "timeout", "Lokio/Timeout;", "update", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class CipherSource implements Source {
    private final int blockSize;

    @NotNull
    private final Buffer buffer;

    @NotNull
    private final Cipher cipher;
    private boolean closed;
    private boolean final;

    @NotNull
    private final BufferedSource source;

    public CipherSource(@NotNull BufferedSource source, @NotNull Cipher cipher) {
        boolean z16;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        this.source = source;
        this.cipher = cipher;
        int blockSize = cipher.getBlockSize();
        this.blockSize = blockSize;
        this.buffer = new Buffer();
        if (blockSize > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
        } else {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Block cipher required ", getCipher()).toString());
        }
    }

    private final void doFinal() {
        int outputSize = this.cipher.getOutputSize(0);
        if (outputSize == 0) {
            return;
        }
        Segment writableSegment$okio = this.buffer.writableSegment$okio(outputSize);
        int doFinal = this.cipher.doFinal(writableSegment$okio.data, writableSegment$okio.pos);
        writableSegment$okio.limit += doFinal;
        Buffer buffer = this.buffer;
        buffer.setSize$okio(buffer.size() + doFinal);
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            this.buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    private final void refill() {
        while (this.buffer.size() == 0) {
            if (this.source.exhausted()) {
                this.final = true;
                doFinal();
                return;
            }
            update();
        }
    }

    private final void update() {
        boolean z16;
        Segment segment = this.source.getBuffer().head;
        Intrinsics.checkNotNull(segment);
        int i3 = segment.limit - segment.pos;
        int outputSize = this.cipher.getOutputSize(i3);
        while (outputSize > 8192) {
            int i16 = this.blockSize;
            if (i3 > i16) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 -= i16;
                outputSize = this.cipher.getOutputSize(i3);
            } else {
                throw new IllegalStateException(("Unexpected output size " + outputSize + " for input size " + i3).toString());
            }
        }
        Segment writableSegment$okio = this.buffer.writableSegment$okio(outputSize);
        int update = this.cipher.update(segment.data, segment.pos, i3, writableSegment$okio.data, writableSegment$okio.pos);
        this.source.skip(i3);
        writableSegment$okio.limit += update;
        Buffer buffer = this.buffer;
        buffer.setSize$okio(buffer.size() + update);
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            this.buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        this.source.close();
    }

    @NotNull
    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long byteCount) throws IOException {
        boolean z16;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (true ^ this.closed) {
                if (byteCount == 0) {
                    return 0L;
                }
                if (this.final) {
                    return this.buffer.read(sink, byteCount);
                }
                refill();
                return this.buffer.read(sink, byteCount);
            }
            throw new IllegalStateException(AudioContext.State.CLOSED.toString());
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
    }

    @Override // okio.Source
    @NotNull
    /* renamed from: timeout */
    public Timeout getTimeout() {
        return this.source.getTimeout();
    }
}
