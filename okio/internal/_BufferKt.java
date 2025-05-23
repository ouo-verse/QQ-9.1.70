package okio.internal;

import com.tencent.image.SafeBitmapFactory;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio._JvmPlatformKt;
import okio._UtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0000\u001a\r\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H\u0080\b\u001a\r\u0010\u0016\u001a\u00020\u0014*\u00020\u0017H\u0080\b\u001a\r\u0010\u0018\u001a\u00020\u0007*\u00020\u0015H\u0080\b\u001a\r\u0010\u0019\u001a\u00020\u0015*\u00020\u0015H\u0080\b\u001a%\u0010\u001a\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\u0017\u0010\u001e\u001a\u00020\f*\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0080\b\u001a\u0015\u0010!\u001a\u00020\u0007*\u00020\u00172\u0006\u0010\"\u001a\u00020\nH\u0080\b\u001a\u0015\u0010#\u001a\u00020$*\u00020\u00152\u0006\u0010%\u001a\u00020\u0007H\u0080\b\u001a\r\u0010&\u001a\u00020\n*\u00020\u0015H\u0080\b\u001a%\u0010'\u001a\u00020\u0007*\u00020\u00152\u0006\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0080\b\u001a\u001d\u0010'\u001a\u00020\u0007*\u00020\u00152\u0006\u0010\u0010\u001a\u00020+2\u0006\u0010)\u001a\u00020\u0007H\u0080\b\u001a\u001d\u0010,\u001a\u00020\u0007*\u00020\u00152\u0006\u0010-\u001a\u00020+2\u0006\u0010)\u001a\u00020\u0007H\u0080\b\u001a\r\u0010.\u001a\u00020\n*\u00020\u0017H\u0080\b\u001a-\u0010/\u001a\u00020\f*\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u0015\u00100\u001a\u00020\n*\u00020\u00152\u0006\u00101\u001a\u00020\u0001H\u0080\b\u001a%\u00100\u001a\u00020\n*\u00020\u00152\u0006\u00101\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u001d\u00100\u001a\u00020\u0007*\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\u0015\u00102\u001a\u00020\u0007*\u00020\u00152\u0006\u00101\u001a\u000203H\u0080\b\u001a\u0014\u00104\u001a\u00020\u0017*\u00020\u00152\u0006\u00105\u001a\u00020\u0017H\u0000\u001a\r\u00106\u001a\u00020$*\u00020\u0015H\u0080\b\u001a\r\u00107\u001a\u00020\u0001*\u00020\u0015H\u0080\b\u001a\u0015\u00107\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u00108\u001a\u00020+*\u00020\u0015H\u0080\b\u001a\u0015\u00108\u001a\u00020+*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u00109\u001a\u00020\u0007*\u00020\u0015H\u0080\b\u001a\u0015\u0010:\u001a\u00020\u0014*\u00020\u00152\u0006\u00101\u001a\u00020\u0001H\u0080\b\u001a\u001d\u0010:\u001a\u00020\u0014*\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u0010;\u001a\u00020\u0007*\u00020\u0015H\u0080\b\u001a\r\u0010<\u001a\u00020\n*\u00020\u0015H\u0080\b\u001a\r\u0010=\u001a\u00020\u0007*\u00020\u0015H\u0080\b\u001a\r\u0010>\u001a\u00020?*\u00020\u0015H\u0080\b\u001a\u0014\u0010@\u001a\u00020\u0017*\u00020\u00152\u0006\u00105\u001a\u00020\u0017H\u0000\u001a\u0015\u0010A\u001a\u00020B*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u0010C\u001a\u00020\n*\u00020\u0015H\u0080\b\u001a\u000f\u0010D\u001a\u0004\u0018\u00010B*\u00020\u0015H\u0080\b\u001a\u0015\u0010E\u001a\u00020B*\u00020\u00152\u0006\u0010F\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010G\u001a\u00020\u0007*\u00020\u00172\u0006\u0010H\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010I\u001a\u00020\n*\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010J\u001a\u00020\n*\u00020\u00152\u0006\u0010K\u001a\u00020LH\u0080\b\u001a\u0015\u0010M\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\r\u0010N\u001a\u00020+*\u00020\u0015H\u0080\b\u001a\u0015\u0010N\u001a\u00020+*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u0015\u0010O\u001a\u00020\u000e*\u00020\u00152\u0006\u0010P\u001a\u00020\nH\u0080\b\u001a\u0015\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020\u0001H\u0080\b\u001a%\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u001d\u0010Q\u001a\u00020\u0014*\u00020\u00152\u0006\u0010R\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a)\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010S\u001a\u00020+2\b\b\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\nH\u0080\b\u001a\u001d\u0010Q\u001a\u00020\u0015*\u00020\u00152\u0006\u0010R\u001a\u00020T2\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010U\u001a\u00020\u0007*\u00020\u00152\u0006\u0010R\u001a\u00020TH\u0080\b\u001a\u0015\u0010V\u001a\u00020\u0015*\u00020\u00152\u0006\u0010(\u001a\u00020\nH\u0080\b\u001a\u0015\u0010W\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010Y\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010Z\u001a\u00020\u0015*\u00020\u00152\u0006\u0010[\u001a\u00020\nH\u0080\b\u001a\u0015\u0010\\\u001a\u00020\u0015*\u00020\u00152\u0006\u0010X\u001a\u00020\u0007H\u0080\b\u001a\u0015\u0010]\u001a\u00020\u0015*\u00020\u00152\u0006\u0010^\u001a\u00020\nH\u0080\b\u001a%\u0010_\u001a\u00020\u0015*\u00020\u00152\u0006\u0010`\u001a\u00020B2\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\nH\u0080\b\u001a\u0015\u0010c\u001a\u00020\u0015*\u00020\u00152\u0006\u0010d\u001a\u00020\nH\u0080\b\u001a\u0014\u0010e\u001a\u00020B*\u00020\u00152\u0006\u0010f\u001a\u00020\u0007H\u0000\u001a?\u0010g\u001a\u0002Hh\"\u0004\b\u0000\u0010h*\u00020\u00152\u0006\u0010)\u001a\u00020\u00072\u001a\u0010i\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002Hh0jH\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010k\u001a\u001e\u0010l\u001a\u00020\n*\u00020\u00152\u0006\u0010K\u001a\u00020L2\b\b\u0002\u0010m\u001a\u00020\fH\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0080T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006n"}, d2 = {"HEX_DIGIT_BYTES", "", "getHEX_DIGIT_BYTES$annotations", "()V", "getHEX_DIGIT_BYTES", "()[B", "OVERFLOW_DIGIT_START", "", "OVERFLOW_ZONE", "SEGMENTING_THRESHOLD", "", "rangeEquals", "", "segment", "Lokio/Segment;", "segmentPos", "bytes", "bytesOffset", "bytesLimit", "commonClear", "", "Lokio/Buffer;", "commonClose", "Lokio/Buffer$UnsafeCursor;", "commonCompleteSegmentByteCount", "commonCopy", "commonCopyTo", "out", "offset", "byteCount", "commonEquals", "other", "", "commonExpandBuffer", "minByteCount", "commonGet", "", c.G, "commonHashCode", "commonIndexOf", "b", "fromIndex", "toIndex", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonNext", "commonRangeEquals", "commonRead", "sink", "commonReadAll", "Lokio/Sink;", "commonReadAndWriteUnsafe", "unsafeCursor", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadLong", "commonReadShort", "", "commonReadUnsafe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonResizeBuffer", "newSize", "commonSeek", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonSnapshot", "commonWritableSegment", "minimumCapacity", "commonWrite", "source", "byteString", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", "i", "commonWriteLong", "commonWriteShort", ReportConstant.COSTREPORT_PREFIX, "commonWriteUtf8", HippyControllerProps.STRING, "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "readUtf8Line", "newline", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "T", "lambda", "Lkotlin/Function2;", "(Lokio/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "selectPrefix", "selectTruncated", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class _BufferKt {

    @NotNull
    private static final byte[] HEX_DIGIT_BYTES = _JvmPlatformKt.asUtf8ToByteArray("0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static final void commonClear(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        buffer.skip(buffer.size());
    }

    public static final void commonClose(@NotNull Buffer.UnsafeCursor unsafeCursor) {
        boolean z16;
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        if (unsafeCursor.buffer != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            unsafeCursor.buffer = null;
            unsafeCursor.setSegment$okio(null);
            unsafeCursor.offset = -1L;
            unsafeCursor.data = null;
            unsafeCursor.start = -1;
            unsafeCursor.end = -1;
            return;
        }
        throw new IllegalStateException("not attached to a buffer".toString());
    }

    public static final long commonCompleteSegmentByteCount(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        long size = buffer.size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = segment.prev;
        Intrinsics.checkNotNull(segment2);
        if (segment2.limit < 8192 && segment2.owner) {
            return size - (r2 - segment2.pos);
        }
        return size;
    }

    @NotNull
    public static final Buffer commonCopy(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Buffer buffer2 = new Buffer();
        if (buffer.size() == 0) {
            return buffer2;
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        Segment sharedCopy = segment.sharedCopy();
        buffer2.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = sharedCopy.prev;
            Intrinsics.checkNotNull(segment3);
            Intrinsics.checkNotNull(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer2.setSize$okio(buffer.size());
        return buffer2;
    }

    @NotNull
    public static final Buffer commonCopyTo(@NotNull Buffer buffer, @NotNull Buffer out, long j3, long j16) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        _UtilKt.checkOffsetAndCount(buffer.size(), j3, j16);
        if (j16 == 0) {
            return buffer;
        }
        out.setSize$okio(out.size() + j16);
        Segment segment = buffer.head;
        while (true) {
            Intrinsics.checkNotNull(segment);
            int i3 = segment.limit;
            int i16 = segment.pos;
            if (j3 < i3 - i16) {
                break;
            }
            j3 -= i3 - i16;
            segment = segment.next;
        }
        while (j16 > 0) {
            Intrinsics.checkNotNull(segment);
            Segment sharedCopy = segment.sharedCopy();
            int i17 = sharedCopy.pos + ((int) j3);
            sharedCopy.pos = i17;
            sharedCopy.limit = Math.min(i17 + ((int) j16), sharedCopy.limit);
            Segment segment2 = out.head;
            if (segment2 == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy;
                out.head = sharedCopy;
            } else {
                Intrinsics.checkNotNull(segment2);
                Segment segment3 = segment2.prev;
                Intrinsics.checkNotNull(segment3);
                segment3.push(sharedCopy);
            }
            j16 -= sharedCopy.limit - sharedCopy.pos;
            segment = segment.next;
            j3 = 0;
        }
        return buffer;
    }

    public static final boolean commonEquals(@NotNull Buffer buffer, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer2 = (Buffer) obj;
        if (buffer.size() != buffer2.size()) {
            return false;
        }
        if (buffer.size() == 0) {
            return true;
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = buffer2.head;
        Intrinsics.checkNotNull(segment2);
        int i3 = segment.pos;
        int i16 = segment2.pos;
        long j3 = 0;
        while (j3 < buffer.size()) {
            long min = Math.min(segment.limit - i3, segment2.limit - i16);
            if (0 < min) {
                long j16 = 0;
                while (true) {
                    j16++;
                    int i17 = i3 + 1;
                    int i18 = i16 + 1;
                    if (segment.data[i3] != segment2.data[i16]) {
                        return false;
                    }
                    if (j16 >= min) {
                        i3 = i17;
                        i16 = i18;
                        break;
                    }
                    i3 = i17;
                    i16 = i18;
                }
            }
            if (i3 == segment.limit) {
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                i3 = segment.pos;
            }
            if (i16 == segment2.limit) {
                segment2 = segment2.next;
                Intrinsics.checkNotNull(segment2);
                i16 = segment2.pos;
            }
            j3 += min;
        }
        return true;
    }

    public static final long commonExpandBuffer(@NotNull Buffer.UnsafeCursor unsafeCursor, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        boolean z17 = true;
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (i3 > 8192) {
                z17 = false;
            }
            if (z17) {
                Buffer buffer = unsafeCursor.buffer;
                if (buffer != null) {
                    if (unsafeCursor.readWrite) {
                        long size = buffer.size();
                        Segment writableSegment$okio = buffer.writableSegment$okio(i3);
                        int i16 = 8192 - writableSegment$okio.limit;
                        writableSegment$okio.limit = 8192;
                        long j3 = i16;
                        buffer.setSize$okio(size + j3);
                        unsafeCursor.setSegment$okio(writableSegment$okio);
                        unsafeCursor.offset = size;
                        unsafeCursor.data = writableSegment$okio.data;
                        unsafeCursor.start = 8192 - i16;
                        unsafeCursor.end = 8192;
                        return j3;
                    }
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
                }
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("minByteCount > Segment.SIZE: ", Integer.valueOf(i3)).toString());
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("minByteCount <= 0: ", Integer.valueOf(i3)).toString());
    }

    public static final byte commonGet(@NotNull Buffer buffer, long j3) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        _UtilKt.checkOffsetAndCount(buffer.size(), j3, 1L);
        Segment segment = buffer.head;
        if (segment != null) {
            if (buffer.size() - j3 < j3) {
                long size = buffer.size();
                while (size > j3) {
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    size -= segment.limit - segment.pos;
                }
                Intrinsics.checkNotNull(segment);
                return segment.data[(int) ((segment.pos + j3) - size)];
            }
            long j16 = 0;
            while (true) {
                long j17 = (segment.limit - segment.pos) + j16;
                if (j17 > j3) {
                    Intrinsics.checkNotNull(segment);
                    return segment.data[(int) ((segment.pos + j3) - j16)];
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j16 = j17;
            }
        } else {
            Intrinsics.checkNotNull(null);
            throw null;
        }
    }

    public static final int commonHashCode(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment segment = buffer.head;
        if (segment == null) {
            return 0;
        }
        int i3 = 1;
        do {
            int i16 = segment.limit;
            for (int i17 = segment.pos; i17 < i16; i17++) {
                i3 = (i3 * 31) + segment.data[i17];
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
        } while (segment != buffer.head);
        return i3;
    }

    public static final long commonIndexOf(@NotNull Buffer buffer, byte b16, long j3, long j16) {
        Segment segment;
        int i3;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        long j17 = 0;
        boolean z16 = false;
        if (0 <= j3 && j3 <= j16) {
            z16 = true;
        }
        if (!z16) {
            throw new IllegalArgumentException(("size=" + buffer.size() + " fromIndex=" + j3 + " toIndex=" + j16).toString());
        }
        if (j16 > buffer.size()) {
            j16 = buffer.size();
        }
        long j18 = j16;
        if (j3 == j18 || (segment = buffer.head) == null) {
            return -1L;
        }
        if (buffer.size() - j3 < j3) {
            j17 = buffer.size();
            while (j17 > j3) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                j17 -= segment.limit - segment.pos;
            }
            while (j17 < j18) {
                byte[] bArr = segment.data;
                int min = (int) Math.min(segment.limit, (segment.pos + j18) - j17);
                i3 = (int) ((segment.pos + j3) - j17);
                while (i3 < min) {
                    if (bArr[i3] != b16) {
                        i3++;
                    }
                }
                j17 += segment.limit - segment.pos;
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j3 = j17;
            }
            return -1L;
        }
        while (true) {
            long j19 = (segment.limit - segment.pos) + j17;
            if (j19 > j3) {
                break;
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            j17 = j19;
        }
        while (j17 < j18) {
            byte[] bArr2 = segment.data;
            int min2 = (int) Math.min(segment.limit, (segment.pos + j18) - j17);
            i3 = (int) ((segment.pos + j3) - j17);
            while (i3 < min2) {
                if (bArr2[i3] != b16) {
                    i3++;
                }
            }
            j17 += segment.limit - segment.pos;
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            j3 = j17;
        }
        return -1L;
        return (i3 - segment.pos) + j17;
    }

    public static final long commonIndexOfElement(@NotNull Buffer buffer, @NotNull ByteString targetBytes, long j3) {
        boolean z16;
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        long j16 = 0;
        if (j3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Segment segment = buffer.head;
            if (segment == null) {
                return -1L;
            }
            if (buffer.size() - j3 < j3) {
                j16 = buffer.size();
                while (j16 > j3) {
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    j16 -= segment.limit - segment.pos;
                }
                if (targetBytes.size() == 2) {
                    byte b16 = targetBytes.getByte(0);
                    byte b17 = targetBytes.getByte(1);
                    while (j16 < buffer.size()) {
                        byte[] bArr = segment.data;
                        i3 = (int) ((segment.pos + j3) - j16);
                        int i17 = segment.limit;
                        while (i3 < i17) {
                            byte b18 = bArr[i3];
                            if (b18 != b16 && b18 != b17) {
                                i3++;
                            }
                            i16 = segment.pos;
                        }
                        j16 += segment.limit - segment.pos;
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j3 = j16;
                    }
                } else {
                    byte[] internalArray$okio = targetBytes.internalArray$okio();
                    while (j16 < buffer.size()) {
                        byte[] bArr2 = segment.data;
                        i3 = (int) ((segment.pos + j3) - j16);
                        int i18 = segment.limit;
                        while (i3 < i18) {
                            byte b19 = bArr2[i3];
                            int length = internalArray$okio.length;
                            int i19 = 0;
                            while (i19 < length) {
                                byte b26 = internalArray$okio[i19];
                                i19++;
                                if (b19 == b26) {
                                    i16 = segment.pos;
                                }
                            }
                            i3++;
                        }
                        j16 += segment.limit - segment.pos;
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j3 = j16;
                    }
                }
                return -1L;
            }
            while (true) {
                long j17 = (segment.limit - segment.pos) + j16;
                if (j17 > j3) {
                    break;
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j16 = j17;
            }
            if (targetBytes.size() == 2) {
                byte b27 = targetBytes.getByte(0);
                byte b28 = targetBytes.getByte(1);
                while (j16 < buffer.size()) {
                    byte[] bArr3 = segment.data;
                    i3 = (int) ((segment.pos + j3) - j16);
                    int i26 = segment.limit;
                    while (i3 < i26) {
                        byte b29 = bArr3[i3];
                        if (b29 != b27 && b29 != b28) {
                            i3++;
                        }
                        i16 = segment.pos;
                    }
                    j16 += segment.limit - segment.pos;
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j3 = j16;
                }
            } else {
                byte[] internalArray$okio2 = targetBytes.internalArray$okio();
                while (j16 < buffer.size()) {
                    byte[] bArr4 = segment.data;
                    i3 = (int) ((segment.pos + j3) - j16);
                    int i27 = segment.limit;
                    while (i3 < i27) {
                        byte b36 = bArr4[i3];
                        int length2 = internalArray$okio2.length;
                        int i28 = 0;
                        while (i28 < length2) {
                            byte b37 = internalArray$okio2[i28];
                            i28++;
                            if (b36 == b37) {
                                i16 = segment.pos;
                            }
                        }
                        i3++;
                    }
                    j16 += segment.limit - segment.pos;
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j3 = j16;
                }
            }
            return -1L;
            return (i3 - i16) + j16;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("fromIndex < 0: ", Long.valueOf(j3)).toString());
    }

    public static final int commonNext(@NotNull Buffer.UnsafeCursor unsafeCursor) {
        boolean z16;
        long j3;
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        long j16 = unsafeCursor.offset;
        Buffer buffer = unsafeCursor.buffer;
        Intrinsics.checkNotNull(buffer);
        if (j16 != buffer.size()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            long j17 = unsafeCursor.offset;
            if (j17 == -1) {
                j3 = 0;
            } else {
                j3 = j17 + (unsafeCursor.end - unsafeCursor.start);
            }
            return unsafeCursor.seek(j3);
        }
        throw new IllegalStateException("no more bytes".toString());
    }

    public static final boolean commonRangeEquals(@NotNull Buffer buffer, long j3, @NotNull ByteString bytes, int i3, int i16) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (j3 < 0 || i3 < 0 || i16 < 0 || buffer.size() - j3 < i16 || bytes.size() - i3 < i16) {
            return false;
        }
        if (i16 > 0) {
            int i17 = 0;
            while (true) {
                int i18 = i17 + 1;
                if (buffer.getByte(i17 + j3) != bytes.getByte(i17 + i3)) {
                    return false;
                }
                if (i18 < i16) {
                    i17 = i18;
                } else {
                    return true;
                }
            }
        } else {
            return true;
        }
    }

    public static final int commonRead(@NotNull Buffer buffer, @NotNull byte[] sink) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        return buffer.read(sink, 0, sink.length);
    }

    public static final long commonReadAll(@NotNull Buffer buffer, @NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long size = buffer.size();
        if (size > 0) {
            sink.write(buffer, size);
        }
        return size;
    }

    @NotNull
    public static final Buffer.UnsafeCursor commonReadAndWriteUnsafe(@NotNull Buffer buffer, @NotNull Buffer.UnsafeCursor unsafeCursor) {
        boolean z16;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor resolveDefaultParameter = _UtilKt.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            resolveDefaultParameter.buffer = buffer;
            resolveDefaultParameter.readWrite = true;
            return resolveDefaultParameter;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static final byte commonReadByte(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() != 0) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i3 = segment.pos;
            int i16 = segment.limit;
            int i17 = i3 + 1;
            byte b16 = segment.data[i3];
            buffer.setSize$okio(buffer.size() - 1);
            if (i17 == i16) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i17;
            }
            return b16;
        }
        throw new EOFException();
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return buffer.readByteArray(buffer.size());
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return buffer.readByteString(buffer.size());
    }

    public static final long commonReadDecimalLong(@NotNull Buffer buffer) {
        int i3;
        String str;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() != 0) {
            int i16 = 0;
            boolean z16 = false;
            long j3 = 0;
            long j16 = -7;
            boolean z17 = false;
            do {
                Segment segment = buffer.head;
                Intrinsics.checkNotNull(segment);
                byte[] bArr = segment.data;
                int i17 = segment.pos;
                int i18 = segment.limit;
                while (i17 < i18) {
                    byte b16 = bArr[i17];
                    byte b17 = (byte) 48;
                    if (b16 >= b17 && b16 <= ((byte) 57)) {
                        int i19 = b17 - b16;
                        if (j3 >= OVERFLOW_ZONE && (j3 != OVERFLOW_ZONE || i19 >= j16)) {
                            j3 = (j3 * 10) + i19;
                        } else {
                            Buffer writeByte = new Buffer().writeDecimalLong(j3).writeByte((int) b16);
                            if (!z16) {
                                writeByte.readByte();
                            }
                            throw new NumberFormatException(Intrinsics.stringPlus("Number too large: ", writeByte.readUtf8()));
                        }
                    } else if (b16 == ((byte) 45) && i16 == 0) {
                        j16--;
                        z16 = true;
                    } else {
                        z17 = true;
                        break;
                    }
                    i17++;
                    i16++;
                }
                if (i17 == i18) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                } else {
                    segment.pos = i17;
                }
                if (z17) {
                    break;
                }
            } while (buffer.head != null);
            buffer.setSize$okio(buffer.size() - i16);
            if (z16) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            if (i16 < i3) {
                if (buffer.size() != 0) {
                    if (z16) {
                        str = "Expected a digit";
                    } else {
                        str = "Expected a digit or '-'";
                    }
                    throw new NumberFormatException(str + " but was 0x" + _UtilKt.toHexString(buffer.getByte(0L)));
                }
                throw new EOFException();
            }
            if (!z16) {
                return -j3;
            }
            return j3;
        }
        throw new EOFException();
    }

    public static final void commonReadFully(@NotNull Buffer buffer, @NotNull byte[] sink) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        int i3 = 0;
        while (i3 < sink.length) {
            int read = buffer.read(sink, i3, sink.length - i3);
            if (read == -1) {
                throw new EOFException();
            }
            i3 += read;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a0 A[EDGE_INSN: B:39:0x00a0->B:36:0x00a0 BREAK  A[LOOP:0: B:4:0x0013->B:38:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long commonReadHexadecimalUnsignedLong(@NotNull Buffer buffer) {
        int i3;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() != 0) {
            int i16 = 0;
            boolean z16 = false;
            long j3 = 0;
            do {
                Segment segment = buffer.head;
                Intrinsics.checkNotNull(segment);
                byte[] bArr = segment.data;
                int i17 = segment.pos;
                int i18 = segment.limit;
                while (i17 < i18) {
                    byte b16 = bArr[i17];
                    byte b17 = (byte) 48;
                    if (b16 >= b17 && b16 <= ((byte) 57)) {
                        i3 = b16 - b17;
                    } else {
                        byte b18 = (byte) 97;
                        if ((b16 >= b18 && b16 <= ((byte) 102)) || (b16 >= (b18 = (byte) 65) && b16 <= ((byte) 70))) {
                            i3 = (b16 - b18) + 10;
                        } else if (i16 != 0) {
                            z16 = true;
                            if (i17 != i18) {
                                buffer.head = segment.pop();
                                SegmentPool.recycle(segment);
                            } else {
                                segment.pos = i17;
                            }
                            if (!z16) {
                                break;
                            }
                        } else {
                            throw new NumberFormatException(Intrinsics.stringPlus("Expected leading [0-9a-fA-F] character but was 0x", _UtilKt.toHexString(b16)));
                        }
                    }
                    if (((-1152921504606846976L) & j3) == 0) {
                        j3 = (j3 << 4) | i3;
                        i17++;
                        i16++;
                    } else {
                        throw new NumberFormatException(Intrinsics.stringPlus("Number too large: ", new Buffer().writeHexadecimalUnsignedLong(j3).writeByte((int) b16).readUtf8()));
                    }
                }
                if (i17 != i18) {
                }
                if (!z16) {
                }
            } while (buffer.head != null);
            buffer.setSize$okio(buffer.size() - i16);
            return j3;
        }
        throw new EOFException();
    }

    public static final int commonReadInt(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() >= 4) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i3 = segment.pos;
            int i16 = segment.limit;
            if (i16 - i3 < 4) {
                return (buffer.readByte() & 255) | ((buffer.readByte() & 255) << 24) | ((buffer.readByte() & 255) << 16) | ((buffer.readByte() & 255) << 8);
            }
            byte[] bArr = segment.data;
            int i17 = i3 + 1;
            int i18 = i17 + 1;
            int i19 = ((bArr[i3] & 255) << 24) | ((bArr[i17] & 255) << 16);
            int i26 = i18 + 1;
            int i27 = i19 | ((bArr[i18] & 255) << 8);
            int i28 = i26 + 1;
            int i29 = i27 | (bArr[i26] & 255);
            buffer.setSize$okio(buffer.size() - 4);
            if (i28 == i16) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i28;
            }
            return i29;
        }
        throw new EOFException();
    }

    public static final long commonReadLong(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() >= 8) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i3 = segment.pos;
            int i16 = segment.limit;
            if (i16 - i3 < 8) {
                return ((buffer.readInt() & 4294967295L) << 32) | (4294967295L & buffer.readInt());
            }
            byte[] bArr = segment.data;
            long j3 = (bArr[i3] & 255) << 56;
            int i17 = i3 + 1 + 1 + 1;
            long j16 = j3 | ((bArr[r7] & 255) << 48) | ((bArr[r1] & 255) << 40);
            long j17 = j16 | ((bArr[i17] & 255) << 32) | ((bArr[r1] & 255) << 24);
            long j18 = j17 | ((bArr[r8] & 255) << 16);
            long j19 = j18 | ((bArr[r1] & 255) << 8);
            int i18 = i17 + 1 + 1 + 1 + 1 + 1;
            long j26 = j19 | (bArr[r8] & 255);
            buffer.setSize$okio(buffer.size() - 8);
            if (i18 == i16) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i18;
            }
            return j26;
        }
        throw new EOFException();
    }

    public static final short commonReadShort(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() >= 2) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i3 = segment.pos;
            int i16 = segment.limit;
            if (i16 - i3 < 2) {
                return (short) ((buffer.readByte() & 255) | ((buffer.readByte() & 255) << 8));
            }
            byte[] bArr = segment.data;
            int i17 = i3 + 1;
            int i18 = i17 + 1;
            int i19 = ((bArr[i3] & 255) << 8) | (bArr[i17] & 255);
            buffer.setSize$okio(buffer.size() - 2);
            if (i18 == i16) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i18;
            }
            return (short) i19;
        }
        throw new EOFException();
    }

    @NotNull
    public static final Buffer.UnsafeCursor commonReadUnsafe(@NotNull Buffer buffer, @NotNull Buffer.UnsafeCursor unsafeCursor) {
        boolean z16;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor resolveDefaultParameter = _UtilKt.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            resolveDefaultParameter.buffer = buffer;
            resolveDefaultParameter.readWrite = false;
            return resolveDefaultParameter;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull Buffer buffer, long j3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j3 >= 0 && j3 <= TTL.MAX_VALUE) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (buffer.size() >= j3) {
                if (j3 == 0) {
                    return "";
                }
                Segment segment = buffer.head;
                Intrinsics.checkNotNull(segment);
                int i3 = segment.pos;
                if (i3 + j3 > segment.limit) {
                    return _Utf8Kt.commonToUtf8String$default(buffer.readByteArray(j3), 0, 0, 3, null);
                }
                int i16 = (int) j3;
                String commonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, i3, i3 + i16);
                segment.pos += i16;
                buffer.setSize$okio(buffer.size() - j3);
                if (segment.pos == segment.limit) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
                return commonToUtf8String;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount: ", Long.valueOf(j3)).toString());
    }

    public static final int commonReadUtf8CodePoint(@NotNull Buffer buffer) {
        int i3;
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() != 0) {
            byte b16 = buffer.getByte(0L);
            boolean z16 = false;
            if ((b16 & 128) == 0) {
                i3 = b16 & Byte.MAX_VALUE;
                i17 = 0;
                i16 = 1;
            } else if ((b16 & 224) == 192) {
                i3 = b16 & 31;
                i16 = 2;
                i17 = 128;
            } else if ((b16 & 240) == 224) {
                i3 = b16 & RegisterType.DOUBLE_HI;
                i16 = 3;
                i17 = 2048;
            } else if ((b16 & 248) == 240) {
                i3 = b16 & 7;
                i16 = 4;
                i17 = 65536;
            } else {
                buffer.skip(1L);
                return 65533;
            }
            long j3 = i16;
            if (buffer.size() >= j3) {
                if (1 < i16) {
                    int i18 = 1;
                    while (true) {
                        int i19 = i18 + 1;
                        long j16 = i18;
                        byte b17 = buffer.getByte(j16);
                        if ((b17 & 192) == 128) {
                            i3 = (i3 << 6) | (b17 & 63);
                            if (i19 >= i16) {
                                break;
                            }
                            i18 = i19;
                        } else {
                            buffer.skip(j16);
                            return 65533;
                        }
                    }
                }
                buffer.skip(j3);
                if (i3 > 1114111) {
                    return 65533;
                }
                if (55296 <= i3 && i3 <= 57343) {
                    z16 = true;
                }
                if (z16 || i3 < i17) {
                    return 65533;
                }
                return i3;
            }
            throw new EOFException("size < " + i16 + MsgSummary.STR_COLON + buffer.size() + " (to read code point prefixed 0x" + _UtilKt.toHexString(b16) + ')');
        }
        throw new EOFException();
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        long indexOf = buffer.indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(buffer, indexOf);
        }
        if (buffer.size() != 0) {
            return buffer.readUtf8(buffer.size());
        }
        return null;
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull Buffer buffer, long j3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            long j16 = Long.MAX_VALUE;
            if (j3 != Long.MAX_VALUE) {
                j16 = j3 + 1;
            }
            byte b16 = (byte) 10;
            long indexOf = buffer.indexOf(b16, 0L, j16);
            if (indexOf != -1) {
                return readUtf8Line(buffer, indexOf);
            }
            if (j16 < buffer.size() && buffer.getByte(j16 - 1) == ((byte) 13) && buffer.getByte(j16) == b16) {
                return readUtf8Line(buffer, j16);
            }
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0L, Math.min(32, buffer.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(buffer.size(), j3) + " content=" + buffer2.readByteString().hex() + Typography.ellipsis);
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("limit < 0: ", Long.valueOf(j3)).toString());
    }

    public static final long commonResizeBuffer(@NotNull Buffer.UnsafeCursor unsafeCursor, long j3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        Buffer buffer = unsafeCursor.buffer;
        if (buffer != null) {
            if (unsafeCursor.readWrite) {
                long size = buffer.size();
                int i3 = 1;
                if (j3 <= size) {
                    if (j3 >= 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        long j16 = size - j3;
                        while (true) {
                            if (j16 <= 0) {
                                break;
                            }
                            Segment segment = buffer.head;
                            Intrinsics.checkNotNull(segment);
                            Segment segment2 = segment.prev;
                            Intrinsics.checkNotNull(segment2);
                            int i16 = segment2.limit;
                            long j17 = i16 - segment2.pos;
                            if (j17 <= j16) {
                                buffer.head = segment2.pop();
                                SegmentPool.recycle(segment2);
                                j16 -= j17;
                            } else {
                                segment2.limit = i16 - ((int) j16);
                                break;
                            }
                        }
                        unsafeCursor.setSegment$okio(null);
                        unsafeCursor.offset = j3;
                        unsafeCursor.data = null;
                        unsafeCursor.start = -1;
                        unsafeCursor.end = -1;
                    } else {
                        throw new IllegalArgumentException(Intrinsics.stringPlus("newSize < 0: ", Long.valueOf(j3)).toString());
                    }
                } else if (j3 > size) {
                    long j18 = j3 - size;
                    boolean z17 = true;
                    while (j18 > 0) {
                        Segment writableSegment$okio = buffer.writableSegment$okio(i3);
                        int min = (int) Math.min(j18, 8192 - writableSegment$okio.limit);
                        writableSegment$okio.limit += min;
                        j18 -= min;
                        if (z17) {
                            unsafeCursor.setSegment$okio(writableSegment$okio);
                            unsafeCursor.offset = size;
                            unsafeCursor.data = writableSegment$okio.data;
                            int i17 = writableSegment$okio.limit;
                            unsafeCursor.start = i17 - min;
                            unsafeCursor.end = i17;
                            z17 = false;
                        }
                        i3 = 1;
                    }
                }
                buffer.setSize$okio(j3);
                return size;
            }
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        }
        throw new IllegalStateException("not attached to a buffer".toString());
    }

    public static final int commonSeek(@NotNull Buffer.UnsafeCursor unsafeCursor, long j3) {
        Segment segment;
        Intrinsics.checkNotNullParameter(unsafeCursor, "<this>");
        Buffer buffer = unsafeCursor.buffer;
        if (buffer != null) {
            if (j3 >= -1 && j3 <= buffer.size()) {
                if (j3 != -1 && j3 != buffer.size()) {
                    long size = buffer.size();
                    Segment segment2 = buffer.head;
                    long j16 = 0;
                    if (unsafeCursor.getSegment() != null) {
                        long j17 = unsafeCursor.offset;
                        int i3 = unsafeCursor.start;
                        Intrinsics.checkNotNull(unsafeCursor.getSegment());
                        long j18 = j17 - (i3 - r9.pos);
                        if (j18 > j3) {
                            segment = segment2;
                            segment2 = unsafeCursor.getSegment();
                            size = j18;
                        } else {
                            segment = unsafeCursor.getSegment();
                            j16 = j18;
                        }
                    } else {
                        segment = segment2;
                    }
                    if (size - j3 > j3 - j16) {
                        while (true) {
                            Intrinsics.checkNotNull(segment);
                            int i16 = segment.limit;
                            int i17 = segment.pos;
                            if (j3 < (i16 - i17) + j16) {
                                break;
                            }
                            j16 += i16 - i17;
                            segment = segment.next;
                        }
                    } else {
                        while (size > j3) {
                            Intrinsics.checkNotNull(segment2);
                            segment2 = segment2.prev;
                            Intrinsics.checkNotNull(segment2);
                            size -= segment2.limit - segment2.pos;
                        }
                        j16 = size;
                        segment = segment2;
                    }
                    if (unsafeCursor.readWrite) {
                        Intrinsics.checkNotNull(segment);
                        if (segment.shared) {
                            Segment unsharedCopy = segment.unsharedCopy();
                            if (buffer.head == segment) {
                                buffer.head = unsharedCopy;
                            }
                            segment = segment.push(unsharedCopy);
                            Segment segment3 = segment.prev;
                            Intrinsics.checkNotNull(segment3);
                            segment3.pop();
                        }
                    }
                    unsafeCursor.setSegment$okio(segment);
                    unsafeCursor.offset = j3;
                    Intrinsics.checkNotNull(segment);
                    unsafeCursor.data = segment.data;
                    int i18 = segment.pos + ((int) (j3 - j16));
                    unsafeCursor.start = i18;
                    int i19 = segment.limit;
                    unsafeCursor.end = i19;
                    return i19 - i18;
                }
                unsafeCursor.setSegment$okio(null);
                unsafeCursor.offset = j3;
                unsafeCursor.data = null;
                unsafeCursor.start = -1;
                unsafeCursor.end = -1;
                return -1;
            }
            throw new ArrayIndexOutOfBoundsException("offset=" + j3 + " > size=" + buffer.size());
        }
        throw new IllegalStateException("not attached to a buffer".toString());
    }

    public static final int commonSelect(@NotNull Buffer buffer, @NotNull Options options) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        int selectPrefix$default = selectPrefix$default(buffer, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        buffer.skip(options.getByteStrings()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public static final void commonSkip(@NotNull Buffer buffer, long j3) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        while (j3 > 0) {
            Segment segment = buffer.head;
            if (segment != null) {
                int min = (int) Math.min(j3, segment.limit - segment.pos);
                long j16 = min;
                buffer.setSize$okio(buffer.size() - j16);
                j3 -= j16;
                int i3 = segment.pos + min;
                segment.pos = i3;
                if (i3 == segment.limit) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (buffer.size() <= TTL.MAX_VALUE) {
            return buffer.snapshot((int) buffer.size());
        }
        throw new IllegalStateException(Intrinsics.stringPlus("size > Int.MAX_VALUE: ", Long.valueOf(buffer.size())).toString());
    }

    @NotNull
    public static final Segment commonWritableSegment(@NotNull Buffer buffer, int i3) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        boolean z16 = true;
        if (i3 < 1 || i3 > 8192) {
            z16 = false;
        }
        if (z16) {
            Segment segment = buffer.head;
            if (segment == null) {
                Segment take = SegmentPool.take();
                buffer.head = take;
                take.prev = take;
                take.next = take;
                return take;
            }
            Intrinsics.checkNotNull(segment);
            Segment segment2 = segment.prev;
            Intrinsics.checkNotNull(segment2);
            if (segment2.limit + i3 > 8192 || !segment2.owner) {
                return segment2.push(SegmentPool.take());
            }
            return segment2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer, @NotNull ByteString byteString, int i3, int i16) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(buffer, i3, i16);
        return buffer;
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer buffer, ByteString byteString, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        if ((i17 & 4) != 0) {
            i16 = byteString.size();
        }
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(buffer, i3, i16);
        return buffer;
    }

    public static final long commonWriteAll(@NotNull Buffer buffer, @NotNull Source source) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        long j3 = 0;
        while (true) {
            long read = source.read(buffer, 8192L);
            if (read == -1) {
                return j3;
            }
            j3 += read;
        }
    }

    @NotNull
    public static final Buffer commonWriteByte(@NotNull Buffer buffer, int i3) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i16 = writableSegment$okio.limit;
        writableSegment$okio.limit = i16 + 1;
        bArr[i16] = (byte) i3;
        buffer.setSize$okio(buffer.size() + 1);
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteDecimalLong(@NotNull Buffer buffer, long j3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j3 == 0) {
            return buffer.writeByte(48);
        }
        int i3 = 1;
        if (j3 < 0) {
            j3 = -j3;
            if (j3 < 0) {
                return buffer.writeUtf8("-9223372036854775808");
            }
            z16 = true;
        } else {
            z16 = false;
        }
        if (j3 < SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            if (j3 < 10000) {
                if (j3 < 100) {
                    if (j3 >= 10) {
                        i3 = 2;
                    }
                } else if (j3 < 1000) {
                    i3 = 3;
                } else {
                    i3 = 4;
                }
            } else if (j3 < 1000000) {
                if (j3 < JsonGrayBusiId.UI_RESERVE_100000_110000) {
                    i3 = 5;
                } else {
                    i3 = 6;
                }
            } else if (j3 < 10000000) {
                i3 = 7;
            } else {
                i3 = 8;
            }
        } else if (j3 < 1000000000000L) {
            if (j3 < RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                if (j3 < 1000000000) {
                    i3 = 9;
                } else {
                    i3 = 10;
                }
            } else if (j3 < 100000000000L) {
                i3 = 11;
            } else {
                i3 = 12;
            }
        } else if (j3 < 1000000000000000L) {
            if (j3 < 10000000000000L) {
                i3 = 13;
            } else if (j3 < 100000000000000L) {
                i3 = 14;
            } else {
                i3 = 15;
            }
        } else if (j3 < 100000000000000000L) {
            if (j3 < 10000000000000000L) {
                i3 = 16;
            } else {
                i3 = 17;
            }
        } else if (j3 < 1000000000000000000L) {
            i3 = 18;
        } else {
            i3 = 19;
        }
        if (z16) {
            i3++;
        }
        Segment writableSegment$okio = buffer.writableSegment$okio(i3);
        byte[] bArr = writableSegment$okio.data;
        int i16 = writableSegment$okio.limit + i3;
        while (j3 != 0) {
            long j16 = 10;
            i16--;
            bArr[i16] = getHEX_DIGIT_BYTES()[(int) (j3 % j16)];
            j3 /= j16;
        }
        if (z16) {
            bArr[i16 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i3;
        buffer.setSize$okio(buffer.size() + i3);
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteHexadecimalUnsignedLong(@NotNull Buffer buffer, long j3) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j3 == 0) {
            return buffer.writeByte(48);
        }
        long j16 = (j3 >>> 1) | j3;
        long j17 = j16 | (j16 >>> 2);
        long j18 = j17 | (j17 >>> 4);
        long j19 = j18 | (j18 >>> 8);
        long j26 = j19 | (j19 >>> 16);
        long j27 = j26 | (j26 >>> 32);
        long j28 = j27 - ((j27 >>> 1) & 6148914691236517205L);
        long j29 = ((j28 >>> 2) & 3689348814741910323L) + (j28 & 3689348814741910323L);
        long j36 = ((j29 >>> 4) + j29) & 1085102592571150095L;
        long j37 = j36 + (j36 >>> 8);
        long j38 = j37 + (j37 >>> 16);
        int i3 = (int) ((((j38 & 63) + ((j38 >>> 32) & 63)) + 3) / 4);
        Segment writableSegment$okio = buffer.writableSegment$okio(i3);
        byte[] bArr = writableSegment$okio.data;
        int i16 = writableSegment$okio.limit;
        for (int i17 = (i16 + i3) - 1; i17 >= i16; i17--) {
            bArr[i17] = getHEX_DIGIT_BYTES()[(int) (15 & j3)];
            j3 >>>= 4;
        }
        writableSegment$okio.limit += i3;
        buffer.setSize$okio(buffer.size() + i3);
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteInt(@NotNull Buffer buffer, int i3) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i16 = writableSegment$okio.limit;
        int i17 = i16 + 1;
        bArr[i16] = (byte) ((i3 >>> 24) & 255);
        int i18 = i17 + 1;
        bArr[i17] = (byte) ((i3 >>> 16) & 255);
        int i19 = i18 + 1;
        bArr[i18] = (byte) ((i3 >>> 8) & 255);
        bArr[i19] = (byte) (i3 & 255);
        writableSegment$okio.limit = i19 + 1;
        buffer.setSize$okio(buffer.size() + 4);
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteLong(@NotNull Buffer buffer, long j3) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i3 = writableSegment$okio.limit;
        int i16 = i3 + 1;
        bArr[i3] = (byte) ((j3 >>> 56) & 255);
        int i17 = i16 + 1;
        bArr[i16] = (byte) ((j3 >>> 48) & 255);
        int i18 = i17 + 1;
        bArr[i17] = (byte) ((j3 >>> 40) & 255);
        int i19 = i18 + 1;
        bArr[i18] = (byte) ((j3 >>> 32) & 255);
        int i26 = i19 + 1;
        bArr[i19] = (byte) ((j3 >>> 24) & 255);
        int i27 = i26 + 1;
        bArr[i26] = (byte) ((j3 >>> 16) & 255);
        int i28 = i27 + 1;
        bArr[i27] = (byte) ((j3 >>> 8) & 255);
        bArr[i28] = (byte) (j3 & 255);
        writableSegment$okio.limit = i28 + 1;
        buffer.setSize$okio(buffer.size() + 8);
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteShort(@NotNull Buffer buffer, int i3) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i16 = writableSegment$okio.limit;
        int i17 = i16 + 1;
        bArr[i16] = (byte) ((i3 >>> 8) & 255);
        bArr[i17] = (byte) (i3 & 255);
        writableSegment$okio.limit = i17 + 1;
        buffer.setSize$okio(buffer.size() + 2);
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteUtf8(@NotNull Buffer buffer, @NotNull String string, int i3, int i16) {
        boolean z16;
        boolean z17;
        boolean z18;
        char charAt;
        char c16;
        boolean z19;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (i3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (i16 >= i3) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (i16 <= string.length()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    while (i3 < i16) {
                        char charAt2 = string.charAt(i3);
                        if (charAt2 < '\u0080') {
                            Segment writableSegment$okio = buffer.writableSegment$okio(1);
                            byte[] bArr = writableSegment$okio.data;
                            int i17 = writableSegment$okio.limit - i3;
                            int min = Math.min(i16, 8192 - i17);
                            int i18 = i3 + 1;
                            bArr[i3 + i17] = (byte) charAt2;
                            while (true) {
                                i3 = i18;
                                if (i3 >= min || (charAt = string.charAt(i3)) >= '\u0080') {
                                    break;
                                }
                                i18 = i3 + 1;
                                bArr[i3 + i17] = (byte) charAt;
                            }
                            int i19 = writableSegment$okio.limit;
                            int i26 = (i17 + i3) - i19;
                            writableSegment$okio.limit = i19 + i26;
                            buffer.setSize$okio(buffer.size() + i26);
                        } else {
                            if (charAt2 < '\u0800') {
                                Segment writableSegment$okio2 = buffer.writableSegment$okio(2);
                                byte[] bArr2 = writableSegment$okio2.data;
                                int i27 = writableSegment$okio2.limit;
                                bArr2[i27] = (byte) ((charAt2 >> 6) | 192);
                                bArr2[i27 + 1] = (byte) ((charAt2 & '?') | 128);
                                writableSegment$okio2.limit = i27 + 2;
                                buffer.setSize$okio(buffer.size() + 2);
                            } else if (charAt2 >= '\ud800' && charAt2 <= '\udfff') {
                                int i28 = i3 + 1;
                                if (i28 < i16) {
                                    c16 = string.charAt(i28);
                                } else {
                                    c16 = 0;
                                }
                                if (charAt2 <= '\udbff') {
                                    if ('\udc00' <= c16 && c16 <= '\udfff') {
                                        z19 = true;
                                    } else {
                                        z19 = false;
                                    }
                                    if (z19) {
                                        int i29 = (((charAt2 & '\u03ff') << 10) | (c16 & '\u03ff')) + 65536;
                                        Segment writableSegment$okio3 = buffer.writableSegment$okio(4);
                                        byte[] bArr3 = writableSegment$okio3.data;
                                        int i36 = writableSegment$okio3.limit;
                                        bArr3[i36] = (byte) ((i29 >> 18) | 240);
                                        bArr3[i36 + 1] = (byte) (((i29 >> 12) & 63) | 128);
                                        bArr3[i36 + 2] = (byte) (((i29 >> 6) & 63) | 128);
                                        bArr3[i36 + 3] = (byte) ((i29 & 63) | 128);
                                        writableSegment$okio3.limit = i36 + 4;
                                        buffer.setSize$okio(buffer.size() + 4);
                                        i3 += 2;
                                    }
                                }
                                buffer.writeByte(63);
                                i3 = i28;
                            } else {
                                Segment writableSegment$okio4 = buffer.writableSegment$okio(3);
                                byte[] bArr4 = writableSegment$okio4.data;
                                int i37 = writableSegment$okio4.limit;
                                bArr4[i37] = (byte) ((charAt2 >> '\f') | 224);
                                bArr4[i37 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                                bArr4[i37 + 2] = (byte) ((charAt2 & '?') | 128);
                                writableSegment$okio4.limit = i37 + 3;
                                buffer.setSize$okio(buffer.size() + 3);
                            }
                            i3++;
                        }
                    }
                    return buffer;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i16 + " > " + string.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i16 + " < " + i3).toString());
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("beginIndex < 0: ", Integer.valueOf(i3)).toString());
    }

    @NotNull
    public static final Buffer commonWriteUtf8CodePoint(@NotNull Buffer buffer, int i3) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (i3 < 128) {
            buffer.writeByte(i3);
        } else if (i3 < 2048) {
            Segment writableSegment$okio = buffer.writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i16 = writableSegment$okio.limit;
            bArr[i16] = (byte) ((i3 >> 6) | 192);
            bArr[i16 + 1] = (byte) ((i3 & 63) | 128);
            writableSegment$okio.limit = i16 + 2;
            buffer.setSize$okio(buffer.size() + 2);
        } else {
            boolean z16 = false;
            if (55296 <= i3 && i3 <= 57343) {
                z16 = true;
            }
            if (z16) {
                buffer.writeByte(63);
            } else if (i3 < 65536) {
                Segment writableSegment$okio2 = buffer.writableSegment$okio(3);
                byte[] bArr2 = writableSegment$okio2.data;
                int i17 = writableSegment$okio2.limit;
                bArr2[i17] = (byte) ((i3 >> 12) | 224);
                bArr2[i17 + 1] = (byte) (((i3 >> 6) & 63) | 128);
                bArr2[i17 + 2] = (byte) ((i3 & 63) | 128);
                writableSegment$okio2.limit = i17 + 3;
                buffer.setSize$okio(buffer.size() + 3);
            } else if (i3 <= 1114111) {
                Segment writableSegment$okio3 = buffer.writableSegment$okio(4);
                byte[] bArr3 = writableSegment$okio3.data;
                int i18 = writableSegment$okio3.limit;
                bArr3[i18] = (byte) ((i3 >> 18) | 240);
                bArr3[i18 + 1] = (byte) (((i3 >> 12) & 63) | 128);
                bArr3[i18 + 2] = (byte) (((i3 >> 6) & 63) | 128);
                bArr3[i18 + 3] = (byte) ((i3 & 63) | 128);
                writableSegment$okio3.limit = i18 + 4;
                buffer.setSize$okio(buffer.size() + 4);
            } else {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected code point: 0x", _UtilKt.toHexString(i3)));
            }
        }
        return buffer;
    }

    @NotNull
    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(@NotNull Segment segment, int i3, @NotNull byte[] bytes, int i16, int i17) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        int i18 = segment.limit;
        byte[] bArr = segment.data;
        while (i16 < i17) {
            if (i3 == i18) {
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i3 = segment.pos;
                i18 = segment.limit;
            }
            if (bArr[i3] != bytes[i16]) {
                return false;
            }
            i3++;
            i16++;
        }
        return true;
    }

    @NotNull
    public static final String readUtf8Line(@NotNull Buffer buffer, long j3) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j3 > 0) {
            long j16 = j3 - 1;
            if (buffer.getByte(j16) == ((byte) 13)) {
                String readUtf8 = buffer.readUtf8(j16);
                buffer.skip(2L);
                return readUtf8;
            }
        }
        String readUtf82 = buffer.readUtf8(j3);
        buffer.skip(1L);
        return readUtf82;
    }

    public static final <T> T seek(@NotNull Buffer buffer, long j3, @NotNull Function2<? super Segment, ? super Long, ? extends T> lambda) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(lambda, "lambda");
        Segment segment = buffer.head;
        if (segment == null) {
            return lambda.invoke(null, -1L);
        }
        if (buffer.size() - j3 < j3) {
            long size = buffer.size();
            while (size > j3) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size -= segment.limit - segment.pos;
            }
            return lambda.invoke(segment, Long.valueOf(size));
        }
        long j16 = 0;
        while (true) {
            long j17 = (segment.limit - segment.pos) + j16;
            if (j17 > j3) {
                return lambda.invoke(segment, Long.valueOf(j16));
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            j16 = j17;
        }
    }

    public static final int selectPrefix(@NotNull Buffer buffer, @NotNull Options options, boolean z16) {
        int i3;
        int i16;
        boolean z17;
        int i17;
        int i18;
        Segment segment;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Segment segment2 = buffer.head;
        if (segment2 == null) {
            if (z16) {
                return -2;
            }
            return -1;
        }
        byte[] bArr = segment2.data;
        int i19 = segment2.pos;
        int i26 = segment2.limit;
        int[] trie = options.getTrie();
        Segment segment3 = segment2;
        int i27 = -1;
        int i28 = 0;
        loop0: while (true) {
            int i29 = i28 + 1;
            int i36 = trie[i28];
            int i37 = i29 + 1;
            int i38 = trie[i29];
            if (i38 != -1) {
                i27 = i38;
            }
            if (segment3 == null) {
                break;
            }
            if (i36 < 0) {
                int i39 = i37 + (i36 * (-1));
                while (true) {
                    int i46 = i19 + 1;
                    int i47 = i37 + 1;
                    if ((bArr[i19] & 255) != trie[i37]) {
                        return i27;
                    }
                    if (i47 == i39) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (i46 == i26) {
                        Intrinsics.checkNotNull(segment3);
                        Segment segment4 = segment3.next;
                        Intrinsics.checkNotNull(segment4);
                        i18 = segment4.pos;
                        byte[] bArr2 = segment4.data;
                        i17 = segment4.limit;
                        if (segment4 == segment2) {
                            if (!z17) {
                                break loop0;
                            }
                            bArr = bArr2;
                            segment = null;
                        } else {
                            segment = segment4;
                            bArr = bArr2;
                        }
                    } else {
                        Segment segment5 = segment3;
                        i17 = i26;
                        i18 = i46;
                        segment = segment5;
                    }
                    if (z17) {
                        i16 = trie[i47];
                        i3 = i18;
                        i26 = i17;
                        segment3 = segment;
                        break;
                    }
                    i19 = i18;
                    i26 = i17;
                    i37 = i47;
                    segment3 = segment;
                }
            } else {
                i3 = i19 + 1;
                int i48 = bArr[i19] & 255;
                int i49 = i37 + i36;
                while (i37 != i49) {
                    if (i48 == trie[i37]) {
                        i16 = trie[i37 + i36];
                        if (i3 == i26) {
                            segment3 = segment3.next;
                            Intrinsics.checkNotNull(segment3);
                            i3 = segment3.pos;
                            bArr = segment3.data;
                            i26 = segment3.limit;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        }
                    } else {
                        i37++;
                    }
                }
                return i27;
            }
            if (i16 >= 0) {
                return i16;
            }
            i28 = -i16;
            i19 = i3;
        }
        if (z16) {
            return -2;
        }
        return i27;
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return selectPrefix(buffer, options, z16);
    }

    public static final int commonRead(@NotNull Buffer buffer, @NotNull byte[] sink, int i3, int i16) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        _UtilKt.checkOffsetAndCount(sink.length, i3, i16);
        Segment segment = buffer.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i16, segment.limit - segment.pos);
        byte[] bArr = segment.data;
        int i17 = segment.pos;
        ArraysKt___ArraysJvmKt.copyInto(bArr, sink, i3, i17, i17 + min);
        segment.pos += min;
        buffer.setSize$okio(buffer.size() - min);
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer buffer, long j3) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (!(j3 >= 0 && j3 <= TTL.MAX_VALUE)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount: ", Long.valueOf(j3)).toString());
        }
        if (buffer.size() >= j3) {
            byte[] bArr = new byte[(int) j3];
            buffer.readFully(bArr);
            return bArr;
        }
        throw new EOFException();
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer buffer, long j3) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (!(j3 >= 0 && j3 <= TTL.MAX_VALUE)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount: ", Long.valueOf(j3)).toString());
        }
        if (buffer.size() < j3) {
            throw new EOFException();
        }
        if (j3 >= 4096) {
            ByteString snapshot = buffer.snapshot((int) j3);
            buffer.skip(j3);
            return snapshot;
        }
        return new ByteString(buffer.readByteArray(j3));
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer, @NotNull byte[] source) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        return buffer.write(source, 0, source.length);
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer, @NotNull byte[] source, int i3, int i16) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        long j3 = i16;
        _UtilKt.checkOffsetAndCount(source.length, i3, j3);
        int i17 = i16 + i3;
        while (i3 < i17) {
            Segment writableSegment$okio = buffer.writableSegment$okio(1);
            int min = Math.min(i17 - i3, 8192 - writableSegment$okio.limit);
            int i18 = i3 + min;
            ArraysKt___ArraysJvmKt.copyInto(source, writableSegment$okio.data, writableSegment$okio.limit, i3, i18);
            writableSegment$okio.limit += min;
            i3 = i18;
        }
        buffer.setSize$okio(buffer.size() + j3);
        return buffer;
    }

    public static final void commonReadFully(@NotNull Buffer buffer, @NotNull Buffer sink, long j3) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (buffer.size() >= j3) {
            sink.write(buffer, j3);
        } else {
            sink.write(buffer, buffer.size());
            throw new EOFException();
        }
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer buffer, int i3) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (i3 == 0) {
            return ByteString.EMPTY;
        }
        _UtilKt.checkOffsetAndCount(buffer.size(), 0L, i3);
        Segment segment = buffer.head;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i17 < i3) {
            Intrinsics.checkNotNull(segment);
            int i19 = segment.limit;
            int i26 = segment.pos;
            if (i19 != i26) {
                i17 += i19 - i26;
                i18++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i18];
        int[] iArr = new int[i18 * 2];
        Segment segment2 = buffer.head;
        int i27 = 0;
        while (i16 < i3) {
            Intrinsics.checkNotNull(segment2);
            bArr[i27] = segment2.data;
            i16 += segment2.limit - segment2.pos;
            iArr[i27] = Math.min(i16, i3);
            iArr[i27 + i18] = segment2.pos;
            segment2.shared = true;
            i27++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer, @NotNull Source source, long j3) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        while (j3 > 0) {
            long read = source.read(buffer, j3);
            if (read == -1) {
                throw new EOFException();
            }
            j3 -= read;
        }
        return buffer;
    }

    public static final long commonRead(@NotNull Buffer buffer, @NotNull Buffer sink, long j3) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!(j3 >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j3)).toString());
        }
        if (buffer.size() == 0) {
            return -1L;
        }
        if (j3 > buffer.size()) {
            j3 = buffer.size();
        }
        sink.write(buffer, j3);
        return j3;
    }

    public static final void commonWrite(@NotNull Buffer buffer, @NotNull Buffer source, long j3) {
        Segment segment;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        if (source != buffer) {
            _UtilKt.checkOffsetAndCount(source.size(), 0L, j3);
            while (j3 > 0) {
                Segment segment2 = source.head;
                Intrinsics.checkNotNull(segment2);
                int i3 = segment2.limit;
                Intrinsics.checkNotNull(source.head);
                if (j3 < i3 - r2.pos) {
                    Segment segment3 = buffer.head;
                    if (segment3 != null) {
                        Intrinsics.checkNotNull(segment3);
                        segment = segment3.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((segment.limit + j3) - (segment.shared ? 0 : segment.pos) <= 8192) {
                            Segment segment4 = source.head;
                            Intrinsics.checkNotNull(segment4);
                            segment4.writeTo(segment, (int) j3);
                            source.setSize$okio(source.size() - j3);
                            buffer.setSize$okio(buffer.size() + j3);
                            return;
                        }
                    }
                    Segment segment5 = source.head;
                    Intrinsics.checkNotNull(segment5);
                    source.head = segment5.split((int) j3);
                }
                Segment segment6 = source.head;
                Intrinsics.checkNotNull(segment6);
                long j16 = segment6.limit - segment6.pos;
                source.head = segment6.pop();
                Segment segment7 = buffer.head;
                if (segment7 == null) {
                    buffer.head = segment6;
                    segment6.prev = segment6;
                    segment6.next = segment6;
                } else {
                    Intrinsics.checkNotNull(segment7);
                    Segment segment8 = segment7.prev;
                    Intrinsics.checkNotNull(segment8);
                    segment8.push(segment6).compact();
                }
                source.setSize$okio(source.size() - j16);
                buffer.setSize$okio(buffer.size() + j16);
                j3 -= j16;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public static /* synthetic */ void getHEX_DIGIT_BYTES$annotations() {
    }

    public static final long commonIndexOf(@NotNull Buffer buffer, @NotNull ByteString bytes, long j3) {
        long j16;
        Segment segment;
        int i3;
        boolean z16;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        boolean z17 = true;
        if (!(bytes.size() > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long j17 = 0;
        if (j3 >= 0) {
            Segment segment2 = buffer.head;
            long j18 = -1;
            if (segment2 == null) {
                return -1L;
            }
            if (buffer.size() - j3 < j3) {
                long size = buffer.size();
                while (size > j3) {
                    segment2 = segment2.prev;
                    Intrinsics.checkNotNull(segment2);
                    size -= segment2.limit - segment2.pos;
                }
                byte[] internalArray$okio = bytes.internalArray$okio();
                byte b16 = internalArray$okio[0];
                int size2 = bytes.size();
                long size3 = (buffer.size() - size2) + 1;
                j16 = size;
                segment = segment2;
                long j19 = j3;
                loop1: while (j16 < size3) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min(segment.limit, (segment.pos + size3) - j16);
                    i3 = (int) ((segment.pos + j19) - j16);
                    if (i3 < min) {
                        while (true) {
                            int i16 = i3 + 1;
                            if (bArr[i3] == b16 && rangeEquals(segment, i16, internalArray$okio, 1, size2)) {
                                break loop1;
                            }
                            if (i16 >= min) {
                                break;
                            }
                            i3 = i16;
                        }
                    }
                    j16 += segment.limit - segment.pos;
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j19 = j16;
                    j18 = -1;
                }
                return j18;
            }
            while (true) {
                long j26 = (segment2.limit - segment2.pos) + j17;
                if (j26 > j3) {
                    break;
                }
                segment2 = segment2.next;
                Intrinsics.checkNotNull(segment2);
                j17 = j26;
                z17 = z17;
            }
            byte[] internalArray$okio2 = bytes.internalArray$okio();
            byte b17 = internalArray$okio2[0];
            int size4 = bytes.size();
            long size5 = (buffer.size() - size4) + 1;
            j16 = j17;
            Segment segment3 = segment2;
            long j27 = j3;
            loop4: while (j16 < size5) {
                byte[] bArr2 = segment3.data;
                int min2 = (int) Math.min(segment3.limit, (segment3.pos + size5) - j16);
                segment = segment3;
                i3 = (int) ((segment.pos + j27) - j16);
                if (i3 < min2) {
                    while (true) {
                        int i17 = i3 + 1;
                        if (bArr2[i3] == b17) {
                            z16 = true;
                            if (rangeEquals(segment, i17, internalArray$okio2, 1, size4)) {
                                break loop4;
                            }
                        } else {
                            z16 = true;
                        }
                        if (i17 >= min2) {
                            break;
                        }
                        i3 = i17;
                    }
                } else {
                    z16 = true;
                }
                j16 += segment.limit - segment.pos;
                segment3 = segment.next;
                Intrinsics.checkNotNull(segment3);
                j27 = j16;
            }
            return -1L;
            return (i3 - segment.pos) + j16;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("fromIndex < 0: ", Long.valueOf(j3)).toString());
    }
}
