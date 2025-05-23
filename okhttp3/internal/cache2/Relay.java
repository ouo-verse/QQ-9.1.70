package okhttp3.internal.cache2;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.msf.core.auth.k;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 :2\u00020\u0001:\u0002:;B3\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u000bJ\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\b\u00105\u001a\u0004\u0018\u00010\u0005J \u00106\u001a\u0002032\u0006\u00107\u001a\u00020\t2\u0006\u00104\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J\u0010\u00109\u001a\u0002032\u0006\u00104\u001a\u00020\u0007H\u0002R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u0006<"}, d2 = {"Lokhttp3/internal/cache2/Relay;", "", "file", "Ljava/io/RandomAccessFile;", "upstream", "Lokio/Source;", "upstreamPos", "", TtmlNode.TAG_METADATA, "Lokio/ByteString;", "bufferMaxSize", "(Ljava/io/RandomAccessFile;Lokio/Source;JLokio/ByteString;J)V", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "getBufferMaxSize", "()J", "complete", "", "getComplete", "()Z", "setComplete", "(Z)V", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "isClosed", "sourceCount", "", "getSourceCount", "()I", "setSourceCount", "(I)V", "getUpstream", "()Lokio/Source;", "setUpstream", "(Lokio/Source;)V", "upstreamBuffer", "getUpstreamBuffer", "getUpstreamPos", "setUpstreamPos", "(J)V", "upstreamReader", "Ljava/lang/Thread;", "getUpstreamReader", "()Ljava/lang/Thread;", "setUpstreamReader", "(Ljava/lang/Thread;)V", "commit", "", "upstreamSize", "newSource", "writeHeader", "prefix", "metadataSize", "writeMetadata", "Companion", "RelaySource", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class Relay {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long FILE_HEADER_SIZE = 32;

    @JvmField
    @NotNull
    public static final ByteString PREFIX_CLEAN;

    @JvmField
    @NotNull
    public static final ByteString PREFIX_DIRTY;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;

    @NotNull
    private final Buffer buffer;
    private final long bufferMaxSize;
    private boolean complete;

    @Nullable
    private RandomAccessFile file;
    private final ByteString metadata;
    private int sourceCount;

    @Nullable
    private Source upstream;

    @NotNull
    private final Buffer upstreamBuffer;
    private long upstreamPos;

    @Nullable
    private Thread upstreamReader;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lokhttp3/internal/cache2/Relay$Companion;", "", "()V", "FILE_HEADER_SIZE", "", "PREFIX_CLEAN", "Lokio/ByteString;", "PREFIX_DIRTY", "SOURCE_FILE", "", "SOURCE_UPSTREAM", "edit", "Lokhttp3/internal/cache2/Relay;", "file", "Ljava/io/File;", "upstream", "Lokio/Source;", TtmlNode.TAG_METADATA, "bufferMaxSize", k.f247491e, "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final Relay edit(@NotNull File file, @NotNull Source upstream, @NotNull ByteString metadata, long bufferMaxSize) throws IOException {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(upstream, "upstream");
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, upstream, 0L, metadata, bufferMaxSize, null);
            randomAccessFile.setLength(0L);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1L, -1L);
            return relay;
        }

        @NotNull
        public final Relay read(@NotNull File file) throws IOException {
            Intrinsics.checkNotNullParameter(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "randomAccessFile.channel");
            FileOperator fileOperator = new FileOperator(channel);
            Buffer buffer = new Buffer();
            fileOperator.read(0L, buffer, 32L);
            ByteString byteString = Relay.PREFIX_CLEAN;
            if (!(!Intrinsics.areEqual(buffer.readByteString(byteString.size()), byteString))) {
                long readLong = buffer.readLong();
                long readLong2 = buffer.readLong();
                Buffer buffer2 = new Buffer();
                fileOperator.read(readLong + 32, buffer2, readLong2);
                return new Relay(randomAccessFile, null, readLong, buffer2.readByteString(), 0L, null);
            }
            throw new IOException("unreadable cache file");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lokhttp3/internal/cache2/Relay$RelaySource;", "Lokio/Source;", "(Lokhttp3/internal/cache2/Relay;)V", "fileOperator", "Lokhttp3/internal/cache2/FileOperator;", "sourcePos", "", "timeout", "Lokio/Timeout;", "close", "", k.f247491e, "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public final class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        public RelaySource() {
            RandomAccessFile file = Relay.this.getFile();
            Intrinsics.checkNotNull(file);
            FileChannel channel = file.getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "file!!.channel");
            this.fileOperator = new FileOperator(channel);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                Relay.this.setSourceCount(r2.getSourceCount() - 1);
                if (Relay.this.getSourceCount() == 0) {
                    RandomAccessFile file = Relay.this.getFile();
                    Relay.this.setFile(null);
                    randomAccessFile = file;
                }
                Unit unit = Unit.INSTANCE;
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x008c, code lost:
        
            if (r4 != 2) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x008e, code lost:
        
            r8 = java.lang.Math.min(r21, r19.this$0.getUpstreamPos() - r19.sourcePos);
            r2 = r19.fileOperator;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
            r2.read(r19.sourcePos + 32, r20, r8);
            r19.sourcePos += r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x00ae, code lost:
        
            return r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00b0, code lost:
        
            r0 = r19.this$0.getUpstream();
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
            r14 = r0.read(r19.this$0.getUpstreamBuffer(), r19.this$0.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00cb, code lost:
        
            if (r14 != (-1)) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00cd, code lost:
        
            r0 = r19.this$0;
            r0.commit(r0.getUpstreamPos());
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00d6, code lost:
        
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00d8, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00d9, code lost:
        
            r19.this$0.setUpstreamReader(null);
            r0 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00e0, code lost:
        
            if (r0 == null) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00e2, code lost:
        
            r0.notifyAll();
            r0 = kotlin.Unit.INSTANCE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00e7, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00e8, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00f1, code lost:
        
            throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00f5, code lost:
        
            r9 = java.lang.Math.min(r14, r21);
            r19.this$0.getUpstreamBuffer().copyTo(r20, 0, r9);
            r19.sourcePos += r9;
            r13 = r19.fileOperator;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13);
            r13.write(r19.this$0.getUpstreamPos() + 32, r19.this$0.getUpstreamBuffer().clone(), r14);
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x012c, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x012d, code lost:
        
            r19.this$0.getBuffer().write(r19.this$0.getUpstreamBuffer(), r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x014e, code lost:
        
            if (r19.this$0.getBuffer().size() <= r19.this$0.getBufferMaxSize()) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0150, code lost:
        
            r19.this$0.getBuffer().skip(r19.this$0.getBuffer().size() - r19.this$0.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x016a, code lost:
        
            r0 = r19.this$0;
            r0.setUpstreamPos(r0.getUpstreamPos() + r14);
            r0 = kotlin.Unit.INSTANCE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0176, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0177, code lost:
        
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0179, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x017a, code lost:
        
            r19.this$0.setUpstreamReader(null);
            r0 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0181, code lost:
        
            if (r0 == null) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0183, code lost:
        
            r0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0186, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0187, code lost:
        
            return r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0190, code lost:
        
            throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0197, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x019a, code lost:
        
            monitor-enter(r19.this$0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x019b, code lost:
        
            r19.this$0.setUpstreamReader(null);
            r3 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x01a2, code lost:
        
            if (r3 == null) goto L73;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x01ac, code lost:
        
            throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x01ad, code lost:
        
            r3.notifyAll();
            r3 = kotlin.Unit.INSTANCE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x01b3, code lost:
        
            throw r0;
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long read(@NotNull Buffer sink, long byteCount) throws IOException {
            boolean z16;
            Intrinsics.checkNotNullParameter(sink, "sink");
            char c16 = 1;
            if (this.fileOperator != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                synchronized (Relay.this) {
                    while (true) {
                        if (this.sourcePos != Relay.this.getUpstreamPos()) {
                            long upstreamPos = Relay.this.getUpstreamPos() - Relay.this.getBuffer().size();
                            if (this.sourcePos < upstreamPos) {
                                c16 = 2;
                            } else {
                                long min = Math.min(byteCount, Relay.this.getUpstreamPos() - this.sourcePos);
                                Relay.this.getBuffer().copyTo(sink, this.sourcePos - upstreamPos, min);
                                this.sourcePos += min;
                                return min;
                            }
                        } else {
                            if (Relay.this.getComplete()) {
                                return -1L;
                            }
                            if (Relay.this.getUpstreamReader() != null) {
                                this.timeout.waitUntilNotified(Relay.this);
                            } else {
                                Relay.this.setUpstreamReader(Thread.currentThread());
                                break;
                            }
                        }
                    }
                }
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        @Override // okio.Source
        @NotNull
        /* renamed from: timeout, reason: from getter */
        public Timeout getTimeout() {
            return this.timeout;
        }
    }

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        PREFIX_CLEAN = companion.encodeUtf8("OkHttp cache v1\n");
        PREFIX_DIRTY = companion.encodeUtf8("OkHttp DIRTY :(\n");
    }

    Relay(RandomAccessFile randomAccessFile, Source source, long j3, ByteString byteString, long j16) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.upstreamPos = j3;
        this.metadata = byteString;
        this.bufferMaxSize = j16;
        this.upstreamBuffer = new Buffer();
        this.complete = this.upstream == null;
        this.buffer = new Buffer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeHeader(ByteString prefix, long upstreamSize, long metadataSize) throws IOException {
        boolean z16;
        Buffer buffer = new Buffer();
        buffer.write(prefix);
        buffer.writeLong(upstreamSize);
        buffer.writeLong(metadataSize);
        if (buffer.size() == 32) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            RandomAccessFile randomAccessFile = this.file;
            Intrinsics.checkNotNull(randomAccessFile);
            FileChannel channel = randomAccessFile.getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "file!!.channel");
            new FileOperator(channel).write(0L, buffer, 32L);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final void writeMetadata(long upstreamSize) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.checkNotNull(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        Intrinsics.checkNotNullExpressionValue(channel, "file!!.channel");
        new FileOperator(channel).write(32 + upstreamSize, buffer, this.metadata.size());
    }

    public final void commit(long upstreamSize) throws IOException {
        writeMetadata(upstreamSize);
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.checkNotNull(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, upstreamSize, this.metadata.size());
        RandomAccessFile randomAccessFile2 = this.file;
        Intrinsics.checkNotNull(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
            Unit unit = Unit.INSTANCE;
        }
        Source source = this.upstream;
        if (source != null) {
            Util.closeQuietly(source);
        }
        this.upstream = null;
    }

    @NotNull
    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    @Nullable
    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    @Nullable
    public final Source getUpstream() {
        return this.upstream;
    }

    @NotNull
    public final Buffer getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    @Nullable
    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        if (this.file == null) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: metadata, reason: from getter */
    public final ByteString getMetadata() {
        return this.metadata;
    }

    @Nullable
    public final Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    public final void setComplete(boolean z16) {
        this.complete = z16;
    }

    public final void setFile(@Nullable RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i3) {
        this.sourceCount = i3;
    }

    public final void setUpstream(@Nullable Source source) {
        this.upstream = source;
    }

    public final void setUpstreamPos(long j3) {
        this.upstreamPos = j3;
    }

    public final void setUpstreamReader(@Nullable Thread thread) {
        this.upstreamReader = thread;
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, Source source, long j3, ByteString byteString, long j16, DefaultConstructorMarker defaultConstructorMarker) {
        this(randomAccessFile, source, j3, byteString, j16);
    }
}
