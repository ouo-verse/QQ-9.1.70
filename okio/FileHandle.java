package okio;

import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002()B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u000eH$J\b\u0010\u0016\u001a\u00020\u000eH$J(\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH$J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0011H$J\b\u0010\u001f\u001a\u00020\u0011H$J(\u0010 \u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH$J&\u0010!\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bJ\u001e\u0010!\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0011J \u0010#\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0011H\u0002J\u0016\u0010$\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010$\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010%\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u001e\u001a\u00020\u0011J\u0010\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u0011J&\u0010&\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bJ\u001e\u0010&\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0011J \u0010'\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0011H\u0002R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006*"}, d2 = {"Lokio/FileHandle;", "Ljava/io/Closeable;", "Lokio/Closeable;", "readWrite", "", "(Z)V", AudioContext.State.CLOSED, "openStreamCount", "", "getReadWrite", "()Z", "appendingSink", "Lokio/Sink;", "close", "", HippyQQPagView.FunctionName.FLUSH, "position", "", "sink", "source", "Lokio/Source;", "protectedClose", "protectedFlush", "protectedRead", "fileOffset", HippyControllerProps.ARRAY, "", "arrayOffset", "byteCount", "protectedResize", "size", "protectedSize", "protectedWrite", com.tencent.mobileqq.msf.core.auth.k.f247491e, "Lokio/Buffer;", "readNoCloseCheck", "reposition", "resize", com.tencent.mobileqq.msf.core.auth.k.f247492f, "writeNoCloseCheck", "FileHandleSink", "FileHandleSource", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public abstract class FileHandle implements Closeable {
    private boolean closed;
    private int openStreamCount;
    private final boolean readWrite;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lokio/FileHandle$FileHandleSink;", "Lokio/Sink;", "fileHandle", "Lokio/FileHandle;", "position", "", "(Lokio/FileHandle;J)V", AudioContext.State.CLOSED, "", "getClosed", "()Z", "setClosed", "(Z)V", "getFileHandle", "()Lokio/FileHandle;", "getPosition", "()J", "setPosition", "(J)V", "close", "", HippyQQPagView.FunctionName.FLUSH, "timeout", "Lokio/Timeout;", com.tencent.mobileqq.msf.core.auth.k.f247492f, "source", "Lokio/Buffer;", "byteCount", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes29.dex */
    public static final class FileHandleSink implements Sink {
        private boolean closed;

        @NotNull
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSink(@NotNull FileHandle fileHandle, long j3) {
            Intrinsics.checkNotNullParameter(fileHandle, "fileHandle");
            this.fileHandle = fileHandle;
            this.position = j3;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            synchronized (this.fileHandle) {
                FileHandle fileHandle = getFileHandle();
                fileHandle.openStreamCount--;
                if (getFileHandle().openStreamCount == 0 && getFileHandle().closed) {
                    Unit unit = Unit.INSTANCE;
                    this.fileHandle.protectedClose();
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (!this.closed) {
                this.fileHandle.protectedFlush();
                return;
            }
            throw new IllegalStateException(AudioContext.State.CLOSED.toString());
        }

        public final boolean getClosed() {
            return this.closed;
        }

        @NotNull
        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public final void setClosed(boolean z16) {
            this.closed = z16;
        }

        public final void setPosition(long j3) {
            this.position = j3;
        }

        @Override // okio.Sink
        @NotNull
        /* renamed from: timeout */
        public Timeout getThis$0() {
            return Timeout.NONE;
        }

        @Override // okio.Sink
        public void write(@NotNull Buffer source, long byteCount) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!this.closed) {
                this.fileHandle.writeNoCloseCheck(this.position, source, byteCount);
                this.position += byteCount;
                return;
            }
            throw new IllegalStateException(AudioContext.State.CLOSED.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Lokio/FileHandle$FileHandleSource;", "Lokio/Source;", "fileHandle", "Lokio/FileHandle;", "position", "", "(Lokio/FileHandle;J)V", AudioContext.State.CLOSED, "", "getClosed", "()Z", "setClosed", "(Z)V", "getFileHandle", "()Lokio/FileHandle;", "getPosition", "()J", "setPosition", "(J)V", "close", "", com.tencent.mobileqq.msf.core.auth.k.f247491e, "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes29.dex */
    public static final class FileHandleSource implements Source {
        private boolean closed;

        @NotNull
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSource(@NotNull FileHandle fileHandle, long j3) {
            Intrinsics.checkNotNullParameter(fileHandle, "fileHandle");
            this.fileHandle = fileHandle;
            this.position = j3;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            synchronized (this.fileHandle) {
                FileHandle fileHandle = getFileHandle();
                fileHandle.openStreamCount--;
                if (getFileHandle().openStreamCount == 0 && getFileHandle().closed) {
                    Unit unit = Unit.INSTANCE;
                    this.fileHandle.protectedClose();
                }
            }
        }

        public final boolean getClosed() {
            return this.closed;
        }

        @NotNull
        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        @Override // okio.Source
        public long read(@NotNull Buffer sink, long byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!this.closed) {
                long readNoCloseCheck = this.fileHandle.readNoCloseCheck(this.position, sink, byteCount);
                if (readNoCloseCheck != -1) {
                    this.position += readNoCloseCheck;
                }
                return readNoCloseCheck;
            }
            throw new IllegalStateException(AudioContext.State.CLOSED.toString());
        }

        public final void setClosed(boolean z16) {
            this.closed = z16;
        }

        public final void setPosition(long j3) {
            this.position = j3;
        }

        @Override // okio.Source
        @NotNull
        /* renamed from: timeout */
        public Timeout getThis$0() {
            return Timeout.NONE;
        }
    }

    public FileHandle(boolean z16) {
        this.readWrite = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long readNoCloseCheck(long fileOffset, Buffer sink, long byteCount) {
        boolean z16;
        if (byteCount >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            long j3 = fileOffset + byteCount;
            long j16 = fileOffset;
            while (true) {
                if (j16 >= j3) {
                    break;
                }
                Segment writableSegment$okio = sink.writableSegment$okio(1);
                int protectedRead = protectedRead(j16, writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j3 - j16, 8192 - r9));
                if (protectedRead == -1) {
                    if (writableSegment$okio.pos == writableSegment$okio.limit) {
                        sink.head = writableSegment$okio.pop();
                        SegmentPool.recycle(writableSegment$okio);
                    }
                    if (fileOffset == j16) {
                        return -1L;
                    }
                } else {
                    writableSegment$okio.limit += protectedRead;
                    long j17 = protectedRead;
                    j16 += j17;
                    sink.setSize$okio(sink.size() + j17);
                }
            }
            return j16 - fileOffset;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
    }

    public static /* synthetic */ Sink sink$default(FileHandle fileHandle, long j3, int i3, Object obj) throws IOException {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                j3 = 0;
            }
            return fileHandle.sink(j3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    public static /* synthetic */ Source source$default(FileHandle fileHandle, long j3, int i3, Object obj) throws IOException {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                j3 = 0;
            }
            return fileHandle.source(j3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: source");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeNoCloseCheck(long fileOffset, Buffer source, long byteCount) {
        _UtilKt.checkOffsetAndCount(source.size(), 0L, byteCount);
        long j3 = byteCount + fileOffset;
        while (fileOffset < j3) {
            Segment segment = source.head;
            Intrinsics.checkNotNull(segment);
            int min = (int) Math.min(j3 - fileOffset, segment.limit - segment.pos);
            protectedWrite(fileOffset, segment.data, segment.pos, min);
            segment.pos += min;
            long j16 = min;
            fileOffset += j16;
            source.setSize$okio(source.size() - j16);
            if (segment.pos == segment.limit) {
                source.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    @NotNull
    public final Sink appendingSink() throws IOException {
        return sink(size());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.openStreamCount != 0) {
                return;
            }
            Unit unit = Unit.INSTANCE;
            protectedClose();
        }
    }

    public final void flush() throws IOException {
        if (this.readWrite) {
            synchronized (this) {
                if (!this.closed) {
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException(AudioContext.State.CLOSED.toString());
                }
            }
            protectedFlush();
            return;
        }
        throw new IllegalStateException("file handle is read-only".toString());
    }

    public final boolean getReadWrite() {
        return this.readWrite;
    }

    public final long position(@NotNull Source source) throws IOException {
        long j3;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source instanceof buffer) {
            buffer bufferVar = (buffer) source;
            j3 = bufferVar.bufferField.size();
            source = bufferVar.source;
        } else {
            j3 = 0;
        }
        if ((source instanceof FileHandleSource) && ((FileHandleSource) source).getFileHandle() == this) {
            FileHandleSource fileHandleSource = (FileHandleSource) source;
            if (!fileHandleSource.getClosed()) {
                return fileHandleSource.getPosition() - j3;
            }
            throw new IllegalStateException(AudioContext.State.CLOSED.toString());
        }
        throw new IllegalArgumentException("source was not created by this FileHandle".toString());
    }

    protected abstract void protectedClose() throws IOException;

    protected abstract void protectedFlush() throws IOException;

    protected abstract int protectedRead(long fileOffset, @NotNull byte[] array, int arrayOffset, int byteCount) throws IOException;

    protected abstract void protectedResize(long size) throws IOException;

    protected abstract long protectedSize() throws IOException;

    protected abstract void protectedWrite(long fileOffset, @NotNull byte[] array, int arrayOffset, int byteCount) throws IOException;

    public final int read(long fileOffset, @NotNull byte[] array, int arrayOffset, int byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(array, "array");
        synchronized (this) {
            if (!this.closed) {
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException(AudioContext.State.CLOSED.toString());
            }
        }
        return protectedRead(fileOffset, array, arrayOffset, byteCount);
    }

    public final void reposition(@NotNull Source source, long position) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        boolean z16 = false;
        if (source instanceof buffer) {
            buffer bufferVar = (buffer) source;
            Source source2 = bufferVar.source;
            if ((source2 instanceof FileHandleSource) && ((FileHandleSource) source2).getFileHandle() == this) {
                FileHandleSource fileHandleSource = (FileHandleSource) source2;
                if (!fileHandleSource.getClosed()) {
                    long size = bufferVar.bufferField.size();
                    long position2 = position - (fileHandleSource.getPosition() - size);
                    if (0 <= position2 && position2 < size) {
                        z16 = true;
                    }
                    if (z16) {
                        bufferVar.skip(position2);
                        return;
                    } else {
                        bufferVar.bufferField.clear();
                        fileHandleSource.setPosition(position);
                        return;
                    }
                }
                throw new IllegalStateException(AudioContext.State.CLOSED.toString());
            }
            throw new IllegalArgumentException("source was not created by this FileHandle".toString());
        }
        if ((source instanceof FileHandleSource) && ((FileHandleSource) source).getFileHandle() == this) {
            z16 = true;
        }
        if (z16) {
            FileHandleSource fileHandleSource2 = (FileHandleSource) source;
            if (!fileHandleSource2.getClosed()) {
                fileHandleSource2.setPosition(position);
                return;
            }
            throw new IllegalStateException(AudioContext.State.CLOSED.toString());
        }
        throw new IllegalArgumentException("source was not created by this FileHandle".toString());
    }

    public final void resize(long size) throws IOException {
        if (this.readWrite) {
            synchronized (this) {
                if (!this.closed) {
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException(AudioContext.State.CLOSED.toString());
                }
            }
            protectedResize(size);
            return;
        }
        throw new IllegalStateException("file handle is read-only".toString());
    }

    @NotNull
    public final Sink sink(long fileOffset) throws IOException {
        if (this.readWrite) {
            synchronized (this) {
                if (!this.closed) {
                    this.openStreamCount++;
                } else {
                    throw new IllegalStateException(AudioContext.State.CLOSED.toString());
                }
            }
            return new FileHandleSink(this, fileOffset);
        }
        throw new IllegalStateException("file handle is read-only".toString());
    }

    public final long size() throws IOException {
        synchronized (this) {
            if (!this.closed) {
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException(AudioContext.State.CLOSED.toString());
            }
        }
        return protectedSize();
    }

    @NotNull
    public final Source source(long fileOffset) throws IOException {
        synchronized (this) {
            if (!this.closed) {
                this.openStreamCount++;
            } else {
                throw new IllegalStateException(AudioContext.State.CLOSED.toString());
            }
        }
        return new FileHandleSource(this, fileOffset);
    }

    public final void write(long fileOffset, @NotNull byte[] array, int arrayOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (this.readWrite) {
            synchronized (this) {
                if (!this.closed) {
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException(AudioContext.State.CLOSED.toString());
                }
            }
            protectedWrite(fileOffset, array, arrayOffset, byteCount);
            return;
        }
        throw new IllegalStateException("file handle is read-only".toString());
    }

    public final long read(long fileOffset, @NotNull Buffer sink, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        synchronized (this) {
            if (!this.closed) {
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException(AudioContext.State.CLOSED.toString());
            }
        }
        return readNoCloseCheck(fileOffset, sink, byteCount);
    }

    public final void write(long fileOffset, @NotNull Buffer source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.readWrite) {
            synchronized (this) {
                if (!this.closed) {
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException(AudioContext.State.CLOSED.toString());
                }
            }
            writeNoCloseCheck(fileOffset, source, byteCount);
            return;
        }
        throw new IllegalStateException("file handle is read-only".toString());
    }

    public final long position(@NotNull Sink sink) throws IOException {
        long j3;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (sink instanceof buffer) {
            buffer bufferVar = (buffer) sink;
            j3 = bufferVar.bufferField.size();
            sink = bufferVar.sink;
        } else {
            j3 = 0;
        }
        if ((sink instanceof FileHandleSink) && ((FileHandleSink) sink).getFileHandle() == this) {
            FileHandleSink fileHandleSink = (FileHandleSink) sink;
            if (!fileHandleSink.getClosed()) {
                return fileHandleSink.getPosition() + j3;
            }
            throw new IllegalStateException(AudioContext.State.CLOSED.toString());
        }
        throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
    }

    public final void reposition(@NotNull Sink sink, long position) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        boolean z16 = false;
        if (sink instanceof buffer) {
            buffer bufferVar = (buffer) sink;
            Sink sink2 = bufferVar.sink;
            if ((sink2 instanceof FileHandleSink) && ((FileHandleSink) sink2).getFileHandle() == this) {
                z16 = true;
            }
            if (z16) {
                FileHandleSink fileHandleSink = (FileHandleSink) sink2;
                if (!fileHandleSink.getClosed()) {
                    bufferVar.emit();
                    fileHandleSink.setPosition(position);
                    return;
                }
                throw new IllegalStateException(AudioContext.State.CLOSED.toString());
            }
            throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
        }
        if ((sink instanceof FileHandleSink) && ((FileHandleSink) sink).getFileHandle() == this) {
            z16 = true;
        }
        if (z16) {
            FileHandleSink fileHandleSink2 = (FileHandleSink) sink;
            if (!fileHandleSink2.getClosed()) {
                fileHandleSink2.setPosition(position);
                return;
            }
            throw new IllegalStateException(AudioContext.State.CLOSED.toString());
        }
        throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
    }
}
