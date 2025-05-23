package okio;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B/\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0000J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000J\u0006\u0010\u0013\u001a\u00020\u0000J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0000J\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lokio/Segment;", "", "()V", "data", "", com.tencent.luggage.wxa.c8.c.G, "", "limit", "shared", "", "owner", "([BIIZZ)V", "next", "prev", "compact", "", "pop", "push", "segment", "sharedCopy", "split", "byteCount", "unsharedCopy", "writeTo", "sink", "Companion", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class Segment {
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;

    @JvmField
    @NotNull
    public final byte[] data;

    @JvmField
    public int limit;

    @JvmField
    @Nullable
    public Segment next;

    @JvmField
    public boolean owner;

    @JvmField
    public int pos;

    @JvmField
    @Nullable
    public Segment prev;

    @JvmField
    public boolean shared;

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        boolean z16;
        Segment segment = this.prev;
        int i3 = 0;
        if (segment != this) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Intrinsics.checkNotNull(segment);
            if (!segment.owner) {
                return;
            }
            int i16 = this.limit - this.pos;
            Segment segment2 = this.prev;
            Intrinsics.checkNotNull(segment2);
            int i17 = 8192 - segment2.limit;
            Segment segment3 = this.prev;
            Intrinsics.checkNotNull(segment3);
            if (!segment3.shared) {
                Segment segment4 = this.prev;
                Intrinsics.checkNotNull(segment4);
                i3 = segment4.pos;
            }
            if (i16 > i17 + i3) {
                return;
            }
            Segment segment5 = this.prev;
            Intrinsics.checkNotNull(segment5);
            writeTo(segment5, i16);
            pop();
            SegmentPool.recycle(this);
            return;
        }
        throw new IllegalStateException("cannot compact".toString());
    }

    @Nullable
    public final Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.prev;
        Intrinsics.checkNotNull(segment2);
        segment2.next = this.next;
        Segment segment3 = this.next;
        Intrinsics.checkNotNull(segment3);
        segment3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment;
    }

    @NotNull
    public final Segment push(@NotNull Segment segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        Intrinsics.checkNotNull(segment2);
        segment2.prev = segment;
        this.next = segment;
        return segment;
    }

    @NotNull
    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    @NotNull
    public final Segment split(int byteCount) {
        boolean z16;
        Segment take;
        if (byteCount > 0 && byteCount <= this.limit - this.pos) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (byteCount >= 1024) {
                take = sharedCopy();
            } else {
                take = SegmentPool.take();
                byte[] bArr = this.data;
                byte[] bArr2 = take.data;
                int i3 = this.pos;
                ArraysKt___ArraysJvmKt.copyInto$default(bArr, bArr2, 0, i3, i3 + byteCount, 2, (Object) null);
            }
            take.limit = take.pos + byteCount;
            this.pos += byteCount;
            Segment segment = this.prev;
            Intrinsics.checkNotNull(segment);
            segment.push(take);
            return take;
        }
        throw new IllegalArgumentException("byteCount out of range".toString());
    }

    @NotNull
    public final Segment unsharedCopy() {
        byte[] bArr = this.data;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new Segment(copyOf, this.pos, this.limit, false, true);
    }

    public final void writeTo(@NotNull Segment sink, int byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (sink.owner) {
            int i3 = sink.limit;
            if (i3 + byteCount > 8192) {
                if (!sink.shared) {
                    int i16 = sink.pos;
                    if ((i3 + byteCount) - i16 <= 8192) {
                        byte[] bArr = sink.data;
                        ArraysKt___ArraysJvmKt.copyInto$default(bArr, bArr, 0, i16, i3, 2, (Object) null);
                        sink.limit -= sink.pos;
                        sink.pos = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            byte[] bArr2 = this.data;
            byte[] bArr3 = sink.data;
            int i17 = sink.limit;
            int i18 = this.pos;
            ArraysKt___ArraysJvmKt.copyInto(bArr2, bArr3, i17, i18, i18 + byteCount);
            sink.limit += byteCount;
            this.pos += byteCount;
            return;
        }
        throw new IllegalStateException("only owner can write".toString());
    }

    public Segment(@NotNull byte[] data, int i3, int i16, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.pos = i3;
        this.limit = i16;
        this.shared = z16;
        this.owner = z17;
    }
}
