package okio;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.Typography;
import okio.internal._BufferKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\u0001H\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'H\u0016J \u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'2\u0006\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010%\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010-\u001a\u00020\u0012H\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020'H\u0016J\u0018\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010/\u001a\u00020\u0012H\u0016J\b\u00100\u001a\u00020\"H\u0016J\b\u00101\u001a\u00020\"H\u0016J\b\u00102\u001a\u00020\u0012H\u0016J\b\u00103\u001a\u00020\u0012H\u0016J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u00107\u001a\u0002082\u0006\u0010#\u001a\u00020\u00122\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000208H\u0016J\u0010\u0010;\u001a\u0002082\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u00020\"H\u0016J\n\u0010=\u001a\u0004\u0018\u000108H\u0016J\b\u0010>\u001a\u000208H\u0016J\u0010\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020\u0012H\u0016J\u0010\u0010@\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010A\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u000208H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068\u00d6\u0002X\u0096\u0004\u00a2\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2 = {"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "source", "Lokio/Source;", "(Lokio/Source;)V", "buffer", "Lokio/Buffer;", "getBuffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", AudioContext.State.CLOSED, "", "close", "", "exhausted", "indexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "peek", "rangeEquals", "offset", "bytesOffset", "", "byteCount", com.tencent.mobileqq.msf.core.auth.k.f247491e, "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "", HttpMsg.CHARSET, "Ljava/nio/charset/Charset;", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", Const.BUNDLE_KEY_REQUEST, "require", "select", "options", "Lokio/Options;", "skip", "timeout", "Lokio/Timeout;", "toString", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* renamed from: okio.RealBufferedSource, reason: from toString */
/* loaded from: classes29.dex */
public final class buffer implements BufferedSource {

    @JvmField
    @NotNull
    public final Buffer bufferField;

    @JvmField
    public boolean closed;

    @JvmField
    @NotNull
    public final Source source;

    public buffer(@NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.bufferField = new Buffer();
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    /* renamed from: buffer, reason: from getter */
    public Buffer getBufferField() {
        return this.bufferField;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.closed) {
            this.closed = true;
            this.source.close();
            this.bufferField.clear();
        }
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        if (!this.closed) {
            if (this.bufferField.exhausted() && this.source.read(this.bufferField, 8192L) == -1) {
                return true;
            }
            return false;
        }
        throw new IllegalStateException(AudioContext.State.CLOSED.toString());
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b16) {
        return indexOf(b16, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString targetBytes) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0L);
    }

    @Override // okio.BufferedSource
    @NotNull
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.RealBufferedSource$inputStream$1
            @Override // java.io.InputStream
            public int available() {
                buffer bufferVar = buffer.this;
                if (!bufferVar.closed) {
                    return (int) Math.min(bufferVar.bufferField.size(), Integer.MAX_VALUE);
                }
                throw new IOException(AudioContext.State.CLOSED);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                buffer.this.close();
            }

            @Override // java.io.InputStream
            public int read() {
                buffer bufferVar = buffer.this;
                if (!bufferVar.closed) {
                    if (bufferVar.bufferField.size() == 0) {
                        buffer bufferVar2 = buffer.this;
                        if (bufferVar2.source.read(bufferVar2.bufferField, 8192L) == -1) {
                            return -1;
                        }
                    }
                    return buffer.this.bufferField.readByte() & 255;
                }
                throw new IOException(AudioContext.State.CLOSED);
            }

            @NotNull
            public String toString() {
                return buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(@NotNull byte[] data, int offset, int byteCount) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (!buffer.this.closed) {
                    _UtilKt.checkOffsetAndCount(data.length, offset, byteCount);
                    if (buffer.this.bufferField.size() == 0) {
                        buffer bufferVar = buffer.this;
                        if (bufferVar.source.read(bufferVar.bufferField, 8192L) == -1) {
                            return -1;
                        }
                    }
                    return buffer.this.bufferField.read(data, offset, byteCount);
                }
                throw new IOException(AudioContext.State.CLOSED);
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSource
    @NotNull
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long offset, @NotNull ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return rangeEquals(offset, bytes, 0, bytes.size());
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @Override // okio.BufferedSource
    public long readAll(@NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j3 = 0;
        while (this.source.read(this.bufferField, 8192L) != -1) {
            long completeSegmentByteCount = this.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j3 += completeSegmentByteCount;
                sink.write(this.bufferField, completeSegmentByteCount);
            }
        }
        if (this.bufferField.size() > 0) {
            long size = j3 + this.bufferField.size();
            Buffer buffer = this.bufferField;
            sink.write(buffer, buffer.size());
            return size;
        }
        return j3;
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        require(1L);
        return this.bufferField.readByte();
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        if (r4 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        r1 = kotlin.text.CharsKt__CharJVMKt.checkRadix(16);
        r1 = kotlin.text.CharsKt__CharJVMKt.checkRadix(r1);
        r1 = java.lang.Integer.toString(r8, r1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004f, code lost:
    
        throw new java.lang.NumberFormatException(kotlin.jvm.internal.Intrinsics.stringPlus("Expected a digit or '-' but was 0x", r1));
     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readDecimalLong() {
        require(1L);
        long j3 = 0;
        while (true) {
            long j16 = j3 + 1;
            if (!request(j16)) {
                break;
            }
            byte b16 = this.bufferField.getByte(j3);
            if ((b16 < ((byte) 48) || b16 > ((byte) 57)) && !(j3 == 0 && b16 == ((byte) 45))) {
                break;
            }
            j3 = j16;
        }
        return this.bufferField.readDecimalLong();
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull byte[] sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            require(sink.length);
            this.bufferField.readFully(sink);
        } catch (EOFException e16) {
            int i3 = 0;
            while (this.bufferField.size() > 0) {
                Buffer buffer = this.bufferField;
                int read = buffer.read(sink, i3, (int) buffer.size());
                if (read == -1) {
                    throw new AssertionError();
                }
                i3 += read;
            }
            throw e16;
        }
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        byte b16;
        int checkRadix;
        int checkRadix2;
        require(1L);
        int i3 = 0;
        while (true) {
            int i16 = i3 + 1;
            if (!request(i16)) {
                break;
            }
            b16 = this.bufferField.getByte(i3);
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
        return this.bufferField.readHexadecimalUnsignedLong();
    }

    @Override // okio.BufferedSource
    public int readInt() {
        require(4L);
        return this.bufferField.readInt();
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        require(4L);
        return this.bufferField.readIntLe();
    }

    @Override // okio.BufferedSource
    public long readLong() {
        require(8L);
        return this.bufferField.readLong();
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        require(8L);
        return this.bufferField.readLongLe();
    }

    @Override // okio.BufferedSource
    public short readShort() {
        require(2L);
        return this.bufferField.readShort();
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        require(2L);
        return this.bufferField.readShortLe();
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(long byteCount, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        require(byteCount);
        return this.bufferField.readString(byteCount, charset);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() {
        require(1L);
        byte b16 = this.bufferField.getByte(0L);
        if ((b16 & 224) == 192) {
            require(2L);
        } else if ((b16 & 240) == 224) {
            require(3L);
        } else if ((b16 & 248) == 240) {
            require(4L);
        }
        return this.bufferField.readUtf8CodePoint();
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        if (indexOf == -1) {
            if (this.bufferField.size() != 0) {
                return readUtf8(this.bufferField.size());
            }
            return null;
        }
        return _BufferKt.readUtf8Line(this.bufferField, indexOf);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public boolean request(long byteCount) {
        boolean z16;
        if (byteCount >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (!(!this.closed)) {
                throw new IllegalStateException(AudioContext.State.CLOSED.toString());
            }
            while (this.bufferField.size() < byteCount) {
                if (this.source.read(this.bufferField, 8192L) == -1) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
    }

    @Override // okio.BufferedSource
    public void require(long byteCount) {
        if (request(byteCount)) {
        } else {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(@NotNull Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        if (!(!this.closed)) {
            throw new IllegalStateException(AudioContext.State.CLOSED.toString());
        }
        while (true) {
            int selectPrefix = _BufferKt.selectPrefix(this.bufferField, options, true);
            if (selectPrefix != -2) {
                if (selectPrefix != -1) {
                    this.bufferField.skip(options.getByteStrings()[selectPrefix].size());
                    return selectPrefix;
                }
            } else if (this.source.read(this.bufferField, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // okio.BufferedSource
    public void skip(long byteCount) {
        if (!this.closed) {
            while (byteCount > 0) {
                if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192L) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(byteCount, this.bufferField.size());
                this.bufferField.skip(min);
                byteCount -= min;
            }
            return;
        }
        throw new IllegalStateException(AudioContext.State.CLOSED.toString());
    }

    @Override // okio.Source
    @NotNull
    /* renamed from: timeout */
    public Timeout getTimeout() {
        return this.source.getTimeout();
    }

    @NotNull
    public String toString() {
        return "buffer(" + this.source + ')';
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b16, long fromIndex) {
        return indexOf(b16, fromIndex, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString targetBytes, long fromIndex) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        if (!(!this.closed)) {
            throw new IllegalStateException(AudioContext.State.CLOSED.toString());
        }
        while (true) {
            long indexOfElement = this.bufferField.indexOfElement(targetBytes, fromIndex);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            long size = this.bufferField.size();
            if (this.source.read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
            fromIndex = Math.max(fromIndex, size);
        }
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount >= 0) {
            if (!(!this.closed)) {
                throw new IllegalStateException(AudioContext.State.CLOSED.toString());
            }
            if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
            return this.bufferField.read(sink, Math.min(byteCount, this.bufferField.size()));
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict(long limit) {
        if (limit >= 0) {
            long j3 = limit == Long.MAX_VALUE ? Long.MAX_VALUE : limit + 1;
            byte b16 = (byte) 10;
            long indexOf = indexOf(b16, 0L, j3);
            if (indexOf != -1) {
                return _BufferKt.readUtf8Line(this.bufferField, indexOf);
            }
            if (j3 < Long.MAX_VALUE && request(j3) && this.bufferField.getByte(j3 - 1) == ((byte) 13) && request(1 + j3) && this.bufferField.getByte(j3) == b16) {
                return _BufferKt.readUtf8Line(this.bufferField, j3);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = this.bufferField;
            buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), limit) + " content=" + buffer.readByteString().hex() + Typography.ellipsis);
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("limit < 0: ", Long.valueOf(limit)).toString());
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return indexOf(bytes, 0L);
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long offset, @NotNull ByteString bytes, int bytesOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (!this.closed) {
            if (offset >= 0 && bytesOffset >= 0 && byteCount >= 0 && bytes.size() - bytesOffset >= byteCount) {
                if (byteCount <= 0) {
                    return true;
                }
                int i3 = 0;
                while (true) {
                    int i16 = i3 + 1;
                    long j3 = i3 + offset;
                    if (!request(1 + j3) || this.bufferField.getByte(j3) != bytes.getByte(i3 + bytesOffset)) {
                        break;
                    }
                    if (i16 >= byteCount) {
                        return true;
                    }
                    i3 = i16;
                }
            }
            return false;
        }
        throw new IllegalStateException(AudioContext.State.CLOSED.toString());
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b16, long fromIndex, long toIndex) {
        if (!(!this.closed)) {
            throw new IllegalStateException(AudioContext.State.CLOSED.toString());
        }
        if (!(0 <= fromIndex && fromIndex <= toIndex)) {
            throw new IllegalArgumentException(("fromIndex=" + fromIndex + " toIndex=" + toIndex).toString());
        }
        while (fromIndex < toIndex) {
            long indexOf = this.bufferField.indexOf(b16, fromIndex, toIndex);
            if (indexOf != -1) {
                return indexOf;
            }
            long size = this.bufferField.size();
            if (size >= toIndex || this.source.read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
            fromIndex = Math.max(fromIndex, size);
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(@NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset);
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray(long byteCount) {
        require(byteCount);
        return this.bufferField.readByteArray(byteCount);
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString(long byteCount) {
        require(byteCount);
        return this.bufferField.readByteString(byteCount);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8(long byteCount) {
        require(byteCount);
        return this.bufferField.readUtf8(byteCount);
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            require(byteCount);
            this.bufferField.readFully(sink, byteCount);
        } catch (EOFException e16) {
            sink.writeAll(this.bufferField);
            throw e16;
        }
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] sink, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j3 = byteCount;
        _UtilKt.checkOffsetAndCount(sink.length, offset, j3);
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192L) == -1) {
            return -1;
        }
        return this.bufferField.read(sink, offset, (int) Math.min(j3, this.bufferField.size()));
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString bytes, long fromIndex) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (!(!this.closed)) {
            throw new IllegalStateException(AudioContext.State.CLOSED.toString());
        }
        while (true) {
            long indexOf = this.bufferField.indexOf(bytes, fromIndex);
            if (indexOf != -1) {
                return indexOf;
            }
            long size = this.bufferField.size();
            if (this.source.read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
            fromIndex = Math.max(fromIndex, (size - bytes.size()) + 1);
        }
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@NotNull ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192L) == -1) {
            return -1;
        }
        return this.bufferField.read(sink);
    }
}
