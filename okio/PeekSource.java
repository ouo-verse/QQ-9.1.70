package okio;

import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lokio/PeekSource;", "Lokio/Source;", "upstream", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "buffer", "Lokio/Buffer;", AudioContext.State.CLOSED, "", "expectedPos", "", "expectedSegment", "Lokio/Segment;", com.tencent.luggage.wxa.c8.c.G, "", "close", "", com.tencent.mobileqq.msf.core.auth.k.f247491e, "sink", "byteCount", "timeout", "Lokio/Timeout;", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class PeekSource implements Source {

    @NotNull
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;

    @Nullable
    private Segment expectedSegment;
    private long pos;

    @NotNull
    private final BufferedSource upstream;

    public PeekSource(@NotNull BufferedSource upstream) {
        int i3;
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        this.upstream = upstream;
        Buffer buffer = upstream.getBuffer();
        this.buffer = buffer;
        Segment segment = buffer.head;
        this.expectedSegment = segment;
        if (segment == null) {
            i3 = -1;
        } else {
            i3 = segment.pos;
        }
        this.expectedPos = i3;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        if (r5 == r6.pos) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    @Override // okio.Source
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long read(@NotNull Buffer sink, long byteCount) {
        boolean z16;
        Segment segment;
        Intrinsics.checkNotNullParameter(sink, "sink");
        boolean z17 = false;
        if (byteCount >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (!this.closed) {
                Segment segment2 = this.expectedSegment;
                if (segment2 != null) {
                    Segment segment3 = this.buffer.head;
                    if (segment2 == segment3) {
                        int i3 = this.expectedPos;
                        Intrinsics.checkNotNull(segment3);
                    }
                    if (!z17) {
                        if (byteCount == 0) {
                            return 0L;
                        }
                        if (!this.upstream.request(this.pos + 1)) {
                            return -1L;
                        }
                        if (this.expectedSegment == null && (segment = this.buffer.head) != null) {
                            this.expectedSegment = segment;
                            Intrinsics.checkNotNull(segment);
                            this.expectedPos = segment.pos;
                        }
                        long min = Math.min(byteCount, this.buffer.size() - this.pos);
                        this.buffer.copyTo(sink, this.pos, min);
                        this.pos += min;
                        return min;
                    }
                    throw new IllegalStateException("Peek source is invalid because upstream source was used".toString());
                }
                z17 = true;
                if (!z17) {
                }
            } else {
                throw new IllegalStateException(AudioContext.State.CLOSED.toString());
            }
        } else {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
        }
    }

    @Override // okio.Source
    @NotNull
    /* renamed from: timeout */
    public Timeout getTimeout() {
        return this.upstream.getTimeout();
    }
}
