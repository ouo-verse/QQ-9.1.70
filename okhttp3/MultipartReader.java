package okhttp3;

import com.tencent.mobileqq.msf.core.auth.k;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http1.HeadersReader;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001c\u001d\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u0013\u0010\u0007\u001a\u00020\b8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0018\u00010\u0010R\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lokhttp3/MultipartReader;", "Ljava/io/Closeable;", "response", "Lokhttp3/ResponseBody;", "(Lokhttp3/ResponseBody;)V", "source", "Lokio/BufferedSource;", "boundary", "", "(Lokio/BufferedSource;Ljava/lang/String;)V", "()Ljava/lang/String;", AudioContext.State.CLOSED, "", "crlfDashDashBoundary", "Lokio/ByteString;", "currentPart", "Lokhttp3/MultipartReader$PartSource;", "dashDashBoundary", "noMoreParts", "partCount", "", "close", "", "currentPartBytesRemaining", "", "maxResult", "nextPart", "Lokhttp3/MultipartReader$Part;", "Companion", "Part", "PartSource", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class MultipartReader implements Closeable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Options afterBoundaryOptions;

    @NotNull
    private final String boundary;
    private boolean closed;
    private final ByteString crlfDashDashBoundary;
    private PartSource currentPart;
    private final ByteString dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    private final BufferedSource source;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lokhttp3/MultipartReader$Companion;", "", "()V", "afterBoundaryOptions", "Lokio/Options;", "getAfterBoundaryOptions", "()Lokio/Options;", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final Options getAfterBoundaryOptions() {
            return MultipartReader.afterBoundaryOptions;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0096\u0001R\u0013\u0010\u0004\u001a\u00020\u00058\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lokhttp3/MultipartReader$Part;", "Ljava/io/Closeable;", "headers", "Lokhttp3/Headers;", "body", "Lokio/BufferedSource;", "(Lokhttp3/Headers;Lokio/BufferedSource;)V", "()Lokio/BufferedSource;", "()Lokhttp3/Headers;", "close", "", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class Part implements Closeable {

        @NotNull
        private final BufferedSource body;

        @NotNull
        private final Headers headers;

        public Part(@NotNull Headers headers, @NotNull BufferedSource body) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(body, "body");
            this.headers = headers;
            this.body = body;
        }

        @JvmName(name = "body")
        @NotNull
        /* renamed from: body, reason: from getter */
        public final BufferedSource getBody() {
            return this.body;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.body.close();
        }

        @JvmName(name = "headers")
        @NotNull
        /* renamed from: headers, reason: from getter */
        public final Headers getHeaders() {
            return this.headers;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\u0003\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lokhttp3/MultipartReader$PartSource;", "Lokio/Source;", "(Lokhttp3/MultipartReader;)V", "timeout", "Lokio/Timeout;", "close", "", k.f247491e, "", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    private final class PartSource implements Source {
        private final Timeout timeout = new Timeout();

        public PartSource() {
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (Intrinsics.areEqual(MultipartReader.this.currentPart, this)) {
                MultipartReader.this.currentPart = null;
            }
        }

        @Override // okio.Source
        public long read(@NotNull Buffer sink, long byteCount) {
            boolean z16;
            long read;
            long read2;
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (byteCount >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (Intrinsics.areEqual(MultipartReader.this.currentPart, this)) {
                    Timeout timeout = MultipartReader.this.source.getTimeout();
                    Timeout timeout2 = this.timeout;
                    long timeoutNanos = timeout.getTimeoutNanos();
                    long minTimeout = Timeout.INSTANCE.minTimeout(timeout2.getTimeoutNanos(), timeout.getTimeoutNanos());
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    timeout.timeout(minTimeout, timeUnit);
                    if (timeout.getHasDeadline()) {
                        long deadlineNanoTime = timeout.deadlineNanoTime();
                        if (timeout2.getHasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            long currentPartBytesRemaining = MultipartReader.this.currentPartBytesRemaining(byteCount);
                            if (currentPartBytesRemaining == 0) {
                                read2 = -1;
                            } else {
                                read2 = MultipartReader.this.source.read(sink, currentPartBytesRemaining);
                            }
                            timeout.timeout(timeoutNanos, timeUnit);
                            if (timeout2.getHasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                            }
                            return read2;
                        } catch (Throwable th5) {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.getHasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                            }
                            throw th5;
                        }
                    }
                    if (timeout2.getHasDeadline()) {
                        timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                    }
                    try {
                        long currentPartBytesRemaining2 = MultipartReader.this.currentPartBytesRemaining(byteCount);
                        if (currentPartBytesRemaining2 == 0) {
                            read = -1;
                        } else {
                            read = MultipartReader.this.source.read(sink, currentPartBytesRemaining2);
                        }
                        timeout.timeout(timeoutNanos, timeUnit);
                        if (timeout2.getHasDeadline()) {
                            timeout.clearDeadline();
                        }
                        return read;
                    } catch (Throwable th6) {
                        timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (timeout2.getHasDeadline()) {
                            timeout.clearDeadline();
                        }
                        throw th6;
                    }
                }
                throw new IllegalStateException(AudioContext.State.CLOSED.toString());
            }
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }

        @Override // okio.Source
        @NotNull
        /* renamed from: timeout, reason: from getter */
        public Timeout getTimeout() {
            return this.timeout;
        }
    }

    static {
        Options.Companion companion = Options.INSTANCE;
        ByteString.Companion companion2 = ByteString.INSTANCE;
        afterBoundaryOptions = companion.of(companion2.encodeUtf8("\r\n"), companion2.encodeUtf8("--"), companion2.encodeUtf8(" "), companion2.encodeUtf8("\t"));
    }

    public MultipartReader(@NotNull BufferedSource source, @NotNull String boundary) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(boundary, "boundary");
        this.source = source;
        this.boundary = boundary;
        this.dashDashBoundary = new Buffer().writeUtf8("--").writeUtf8(boundary).readByteString();
        this.crlfDashDashBoundary = new Buffer().writeUtf8("\r\n--").writeUtf8(boundary).readByteString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long currentPartBytesRemaining(long maxResult) {
        this.source.require(this.crlfDashDashBoundary.size());
        long indexOf = this.source.getBuffer().indexOf(this.crlfDashDashBoundary);
        if (indexOf == -1) {
            return Math.min(maxResult, (this.source.getBuffer().size() - this.crlfDashDashBoundary.size()) + 1);
        }
        return Math.min(maxResult, indexOf);
    }

    @JvmName(name = "boundary")
    @NotNull
    /* renamed from: boundary, reason: from getter */
    public final String getBoundary() {
        return this.boundary;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.currentPart = null;
        this.source.close();
    }

    @Nullable
    public final Part nextPart() throws IOException {
        if (!this.closed) {
            if (this.noMoreParts) {
                return null;
            }
            if (this.partCount == 0 && this.source.rangeEquals(0L, this.dashDashBoundary)) {
                this.source.skip(this.dashDashBoundary.size());
            } else {
                while (true) {
                    long currentPartBytesRemaining = currentPartBytesRemaining(8192L);
                    if (currentPartBytesRemaining == 0) {
                        break;
                    }
                    this.source.skip(currentPartBytesRemaining);
                }
                this.source.skip(this.crlfDashDashBoundary.size());
            }
            boolean z16 = false;
            while (true) {
                int select = this.source.select(afterBoundaryOptions);
                if (select != -1) {
                    if (select != 0) {
                        if (select != 1) {
                            if (select == 2 || select == 3) {
                                z16 = true;
                            }
                        } else {
                            if (!z16) {
                                if (this.partCount != 0) {
                                    this.noMoreParts = true;
                                    return null;
                                }
                                throw new ProtocolException("expected at least 1 part");
                            }
                            throw new ProtocolException("unexpected characters after boundary");
                        }
                    } else {
                        this.partCount++;
                        Headers readHeaders = new HeadersReader(this.source).readHeaders();
                        PartSource partSource = new PartSource();
                        this.currentPart = partSource;
                        return new Part(readHeaders, Okio.buffer(partSource));
                    }
                } else {
                    throw new ProtocolException("unexpected characters after boundary");
                }
            }
        } else {
            throw new IllegalStateException(AudioContext.State.CLOSED.toString());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MultipartReader(@NotNull ResponseBody response) throws IOException {
        this(r0, r3);
        String parameter;
        Intrinsics.checkNotNullParameter(response, "response");
        BufferedSource bodySource = response.getBodySource();
        MediaType mediaType = response.get$contentType();
        if (mediaType != null && (parameter = mediaType.parameter("boundary")) != null) {
            return;
        }
        throw new ProtocolException("expected the Content-Type to have a boundary parameter");
    }
}
