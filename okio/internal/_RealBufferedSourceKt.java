package okio.internal;

import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.Typography;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.Sink;
import okio.Timeout;
import okio._UtilKt;
import okio.buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a%\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0080\b\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0080\b\u001a\u001d\u0010\r\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\u0002H\u0080\b\u001a-\u0010\u0011\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0080\b\u001a%\u0010\u0016\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0080\b\u001a\u001d\u0010\u0016\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010\u001a\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001bH\u0080\b\u001a\r\u0010\u001c\u001a\u00020\b*\u00020\u0002H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u0018*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001d\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u001f\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\u0015\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0080\b\u001a\u001d\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010!\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010\"\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\r\u0010#\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\r\u0010$\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010%\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010&\u001a\u00020'*\u00020\u0002H\u0080\b\u001a\r\u0010(\u001a\u00020'*\u00020\u0002H\u0080\b\u001a\r\u0010)\u001a\u00020**\u00020\u0002H\u0080\b\u001a\u0015\u0010)\u001a\u00020**\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010+\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\u000f\u0010,\u001a\u0004\u0018\u00010**\u00020\u0002H\u0080\b\u001a\u0015\u0010-\u001a\u00020**\u00020\u00022\u0006\u0010.\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010/\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u00101\u001a\u00020\u0014*\u00020\u00022\u0006\u00102\u001a\u000203H\u0080\b\u001a\u0015\u00104\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u00105\u001a\u000206*\u00020\u0002H\u0080\b\u001a\r\u00107\u001a\u00020**\u00020\u0002H\u0080\b\u00a8\u00068"}, d2 = {"commonClose", "", "Lokio/RealBufferedSource;", "commonExhausted", "", "commonIndexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonPeek", "Lokio/BufferedSource;", "commonRangeEquals", "offset", "bytesOffset", "", "byteCount", "commonRead", "sink", "", "Lokio/Buffer;", "commonReadAll", "Lokio/Sink;", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadIntLe", "commonReadLong", "commonReadLongLe", "commonReadShort", "", "commonReadShortLe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonRequest", "commonRequire", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonTimeout", "Lokio/Timeout;", "commonToString", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class _RealBufferedSourceKt {
    public static final void commonClose(@NotNull buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        if (bufferVar.closed) {
            return;
        }
        bufferVar.closed = true;
        bufferVar.source.close();
        bufferVar.bufferField.clear();
    }

    public static final boolean commonExhausted(@NotNull buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        if (!bufferVar.closed) {
            if (bufferVar.bufferField.exhausted() && bufferVar.source.read(bufferVar.bufferField, 8192L) == -1) {
                return true;
            }
            return false;
        }
        throw new IllegalStateException(AudioContext.State.CLOSED.toString());
    }

    public static final long commonIndexOf(@NotNull buffer bufferVar, byte b16, long j3, long j16) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException(AudioContext.State.CLOSED.toString());
        }
        if (!(0 <= j3 && j3 <= j16)) {
            throw new IllegalArgumentException(("fromIndex=" + j3 + " toIndex=" + j16).toString());
        }
        while (j3 < j16) {
            long indexOf = bufferVar.bufferField.indexOf(b16, j3, j16);
            if (indexOf == -1) {
                long size = bufferVar.bufferField.size();
                if (size >= j16 || bufferVar.source.read(bufferVar.bufferField, 8192L) == -1) {
                    break;
                }
                j3 = Math.max(j3, size);
            } else {
                return indexOf;
            }
        }
        return -1L;
    }

    public static final long commonIndexOfElement(@NotNull buffer bufferVar, @NotNull ByteString targetBytes, long j3) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException(AudioContext.State.CLOSED.toString());
        }
        while (true) {
            long indexOfElement = bufferVar.bufferField.indexOfElement(targetBytes, j3);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            long size = bufferVar.bufferField.size();
            if (bufferVar.source.read(bufferVar.bufferField, 8192L) == -1) {
                return -1L;
            }
            j3 = Math.max(j3, size);
        }
    }

    @NotNull
    public static final BufferedSource commonPeek(@NotNull buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        return Okio.buffer(new PeekSource(bufferVar));
    }

    public static final boolean commonRangeEquals(@NotNull buffer bufferVar, long j3, @NotNull ByteString bytes, int i3, int i16) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (!bufferVar.closed) {
            if (j3 < 0 || i3 < 0 || i16 < 0 || bytes.size() - i3 < i16) {
                return false;
            }
            if (i16 > 0) {
                int i17 = 0;
                while (true) {
                    int i18 = i17 + 1;
                    long j16 = i17 + j3;
                    if (!bufferVar.request(1 + j16) || bufferVar.bufferField.getByte(j16) != bytes.getByte(i17 + i3)) {
                        return false;
                    }
                    if (i18 >= i16) {
                        break;
                    }
                    i17 = i18;
                }
            }
            return true;
        }
        throw new IllegalStateException(AudioContext.State.CLOSED.toString());
    }

    public static final long commonRead(@NotNull buffer bufferVar, @NotNull Buffer sink, long j3) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j3 >= 0) {
            if (!(!bufferVar.closed)) {
                throw new IllegalStateException(AudioContext.State.CLOSED.toString());
            }
            if (bufferVar.bufferField.size() == 0 && bufferVar.source.read(bufferVar.bufferField, 8192L) == -1) {
                return -1L;
            }
            return bufferVar.bufferField.read(sink, Math.min(j3, bufferVar.bufferField.size()));
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j3)).toString());
    }

    public static final long commonReadAll(@NotNull buffer bufferVar, @NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j3 = 0;
        while (bufferVar.source.read(bufferVar.bufferField, 8192L) != -1) {
            long completeSegmentByteCount = bufferVar.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j3 += completeSegmentByteCount;
                sink.write(bufferVar.bufferField, completeSegmentByteCount);
            }
        }
        if (bufferVar.bufferField.size() > 0) {
            long size = j3 + bufferVar.bufferField.size();
            Buffer buffer = bufferVar.bufferField;
            sink.write(buffer, buffer.size());
            return size;
        }
        return j3;
    }

    public static final byte commonReadByte(@NotNull buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.require(1L);
        return bufferVar.bufferField.readByte();
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull buffer bufferVar, long j3) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.require(j3);
        return bufferVar.bufferField.readByteArray(j3);
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull buffer bufferVar, long j3) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.require(j3);
        return bufferVar.bufferField.readByteString(j3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
    
        if (r4 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
    
        r0 = kotlin.text.CharsKt__CharJVMKt.checkRadix(16);
        r0 = kotlin.text.CharsKt__CharJVMKt.checkRadix(r0);
        r0 = java.lang.Integer.toString(r8, r0);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
    
        throw new java.lang.NumberFormatException(kotlin.jvm.internal.Intrinsics.stringPlus("Expected a digit or '-' but was 0x", r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long commonReadDecimalLong(@NotNull buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.require(1L);
        long j3 = 0;
        while (true) {
            long j16 = j3 + 1;
            if (!bufferVar.request(j16)) {
                break;
            }
            byte b16 = bufferVar.bufferField.getByte(j3);
            if ((b16 < ((byte) 48) || b16 > ((byte) 57)) && !(j3 == 0 && b16 == ((byte) 45))) {
                break;
            }
            j3 = j16;
        }
        return bufferVar.bufferField.readDecimalLong();
    }

    public static final void commonReadFully(@NotNull buffer bufferVar, @NotNull byte[] sink) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            bufferVar.require(sink.length);
            bufferVar.bufferField.readFully(sink);
        } catch (EOFException e16) {
            int i3 = 0;
            while (bufferVar.bufferField.size() > 0) {
                Buffer buffer = bufferVar.bufferField;
                int read = buffer.read(sink, i3, (int) buffer.size());
                if (read == -1) {
                    throw new AssertionError();
                }
                i3 += read;
            }
            throw e16;
        }
    }

    public static final long commonReadHexadecimalUnsignedLong(@NotNull buffer bufferVar) {
        byte b16;
        int checkRadix;
        int checkRadix2;
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.require(1L);
        int i3 = 0;
        while (true) {
            int i16 = i3 + 1;
            if (!bufferVar.request(i16)) {
                break;
            }
            b16 = bufferVar.bufferField.getByte(i3);
            if ((b16 < ((byte) 48) || b16 > ((byte) 57)) && ((b16 < ((byte) 97) || b16 > ((byte) 102)) && (b16 < ((byte) 65) || b16 > ((byte) 70)))) {
                break;
            }
            i3 = i16;
        }
        if (i3 == 0) {
            checkRadix = CharsKt__CharJVMKt.checkRadix(16);
            checkRadix2 = CharsKt__CharJVMKt.checkRadix(checkRadix);
            String num = Integer.toString(b16, checkRadix2);
            Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
            throw new NumberFormatException(Intrinsics.stringPlus("Expected leading [0-9a-fA-F] character but was 0x", num));
        }
        return bufferVar.bufferField.readHexadecimalUnsignedLong();
    }

    public static final int commonReadInt(@NotNull buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.require(4L);
        return bufferVar.bufferField.readInt();
    }

    public static final int commonReadIntLe(@NotNull buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.require(4L);
        return bufferVar.bufferField.readIntLe();
    }

    public static final long commonReadLong(@NotNull buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.require(8L);
        return bufferVar.bufferField.readLong();
    }

    public static final long commonReadLongLe(@NotNull buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.require(8L);
        return bufferVar.bufferField.readLongLe();
    }

    public static final short commonReadShort(@NotNull buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.require(2L);
        return bufferVar.bufferField.readShort();
    }

    public static final short commonReadShortLe(@NotNull buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.require(2L);
        return bufferVar.bufferField.readShortLe();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull buffer bufferVar, long j3) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.require(j3);
        return bufferVar.bufferField.readUtf8(j3);
    }

    public static final int commonReadUtf8CodePoint(@NotNull buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.require(1L);
        byte b16 = bufferVar.bufferField.getByte(0L);
        if ((b16 & 224) == 192) {
            bufferVar.require(2L);
        } else if ((b16 & 240) == 224) {
            bufferVar.require(3L);
        } else if ((b16 & 248) == 240) {
            bufferVar.require(4L);
        }
        return bufferVar.bufferField.readUtf8CodePoint();
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        long indexOf = bufferVar.indexOf((byte) 10);
        if (indexOf == -1) {
            if (bufferVar.bufferField.size() != 0) {
                return bufferVar.readUtf8(bufferVar.bufferField.size());
            }
            return null;
        }
        return _BufferKt.readUtf8Line(bufferVar.bufferField, indexOf);
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull buffer bufferVar, long j3) {
        boolean z16;
        long j16;
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        if (j3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (j3 == Long.MAX_VALUE) {
                j16 = Long.MAX_VALUE;
            } else {
                j16 = j3 + 1;
            }
            byte b16 = (byte) 10;
            long indexOf = bufferVar.indexOf(b16, 0L, j16);
            if (indexOf != -1) {
                return _BufferKt.readUtf8Line(bufferVar.bufferField, indexOf);
            }
            if (j16 < Long.MAX_VALUE && bufferVar.request(j16) && bufferVar.bufferField.getByte(j16 - 1) == ((byte) 13) && bufferVar.request(1 + j16) && bufferVar.bufferField.getByte(j16) == b16) {
                return _BufferKt.readUtf8Line(bufferVar.bufferField, j16);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = bufferVar.bufferField;
            buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(bufferVar.bufferField.size(), j3) + " content=" + buffer.readByteString().hex() + Typography.ellipsis);
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("limit < 0: ", Long.valueOf(j3)).toString());
    }

    public static final boolean commonRequest(@NotNull buffer bufferVar, long j3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        if (j3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (!(!bufferVar.closed)) {
                throw new IllegalStateException(AudioContext.State.CLOSED.toString());
            }
            while (bufferVar.bufferField.size() < j3) {
                if (bufferVar.source.read(bufferVar.bufferField, 8192L) == -1) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j3)).toString());
    }

    public static final void commonRequire(@NotNull buffer bufferVar, long j3) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        if (bufferVar.request(j3)) {
        } else {
            throw new EOFException();
        }
    }

    public static final int commonSelect(@NotNull buffer bufferVar, @NotNull Options options) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException(AudioContext.State.CLOSED.toString());
        }
        do {
            int selectPrefix = _BufferKt.selectPrefix(bufferVar.bufferField, options, true);
            if (selectPrefix != -2) {
                if (selectPrefix == -1) {
                    return -1;
                }
                bufferVar.bufferField.skip(options.getByteStrings()[selectPrefix].size());
                return selectPrefix;
            }
        } while (bufferVar.source.read(bufferVar.bufferField, 8192L) != -1);
        return -1;
    }

    public static final void commonSkip(@NotNull buffer bufferVar, long j3) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        if (!bufferVar.closed) {
            while (j3 > 0) {
                if (bufferVar.bufferField.size() == 0 && bufferVar.source.read(bufferVar.bufferField, 8192L) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j3, bufferVar.bufferField.size());
                bufferVar.bufferField.skip(min);
                j3 -= min;
            }
            return;
        }
        throw new IllegalStateException(AudioContext.State.CLOSED.toString());
    }

    @NotNull
    public static final Timeout commonTimeout(@NotNull buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        return bufferVar.source.getTimeout();
    }

    @NotNull
    public static final String commonToString(@NotNull buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        return "buffer(" + bufferVar.source + ')';
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.bufferField.writeAll(bufferVar.source);
        return bufferVar.bufferField.readByteArray();
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.bufferField.writeAll(bufferVar.source);
        return bufferVar.bufferField.readByteString();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        bufferVar.bufferField.writeAll(bufferVar.source);
        return bufferVar.bufferField.readUtf8();
    }

    public static final void commonReadFully(@NotNull buffer bufferVar, @NotNull Buffer sink, long j3) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            bufferVar.require(j3);
            bufferVar.bufferField.readFully(sink, j3);
        } catch (EOFException e16) {
            sink.writeAll(bufferVar.bufferField);
            throw e16;
        }
    }

    public static final long commonIndexOf(@NotNull buffer bufferVar, @NotNull ByteString bytes, long j3) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException(AudioContext.State.CLOSED.toString());
        }
        while (true) {
            long indexOf = bufferVar.bufferField.indexOf(bytes, j3);
            if (indexOf != -1) {
                return indexOf;
            }
            long size = bufferVar.bufferField.size();
            if (bufferVar.source.read(bufferVar.bufferField, 8192L) == -1) {
                return -1L;
            }
            j3 = Math.max(j3, (size - bytes.size()) + 1);
        }
    }

    public static final int commonRead(@NotNull buffer bufferVar, @NotNull byte[] sink, int i3, int i16) {
        Intrinsics.checkNotNullParameter(bufferVar, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j3 = i16;
        _UtilKt.checkOffsetAndCount(sink.length, i3, j3);
        if (bufferVar.bufferField.size() == 0 && bufferVar.source.read(bufferVar.bufferField, 8192L) == -1) {
            return -1;
        }
        return bufferVar.bufferField.read(sink, i3, (int) Math.min(j3, bufferVar.bufferField.size()));
    }
}
