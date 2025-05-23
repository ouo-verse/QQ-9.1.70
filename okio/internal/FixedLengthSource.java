package okio.internal;

import com.tencent.mobileqq.msf.core.auth.k;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lokio/internal/FixedLengthSource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "size", "", "truncate", "", "(Lokio/Source;JZ)V", "bytesReceived", k.f247491e, "sink", "Lokio/Buffer;", "byteCount", "truncateToSize", "", "newSize", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class FixedLengthSource extends ForwardingSource {
    private long bytesReceived;
    private final long size;
    private final boolean truncate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedLengthSource(@NotNull Source delegate, long j3, boolean z16) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.size = j3;
        this.truncate = z16;
    }

    private final void truncateToSize(Buffer buffer, long j3) {
        Buffer buffer2 = new Buffer();
        buffer2.writeAll(buffer);
        buffer.write(buffer2, j3);
        buffer2.clear();
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(@NotNull Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j3 = this.bytesReceived;
        long j16 = this.size;
        if (j3 > j16) {
            byteCount = 0;
        } else if (this.truncate) {
            long j17 = j16 - j3;
            if (j17 == 0) {
                return -1L;
            }
            byteCount = Math.min(byteCount, j17);
        }
        long read = super.read(sink, byteCount);
        if (read != -1) {
            this.bytesReceived += read;
        }
        long j18 = this.bytesReceived;
        long j19 = this.size;
        if ((j18 < j19 && read == -1) || j18 > j19) {
            if (read > 0 && j18 > j19) {
                truncateToSize(sink, sink.size() - (this.bytesReceived - this.size));
            }
            throw new IOException("expected " + this.size + " bytes but got " + this.bytesReceived);
        }
        return read;
    }
}
