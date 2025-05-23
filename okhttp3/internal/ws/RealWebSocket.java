package okhttp3.internal.ws;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.upload.report.UploadQualityReportBuilder;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.internal.ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import org.apache.httpcore.HttpHeaders;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0005_`abcB?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0002\u0010\u0010J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u000206J\b\u00107\u001a\u000203H\u0016J\u001f\u00108\u001a\u0002032\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0000\u00a2\u0006\u0002\b=J\u001a\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020%2\b\u0010@\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020%2\b\u0010@\u001a\u0004\u0018\u00010\u00182\u0006\u0010A\u001a\u00020\fJ\u000e\u0010B\u001a\u0002032\u0006\u0010C\u001a\u00020DJ\u001c\u0010E\u001a\u0002032\n\u0010F\u001a\u00060Gj\u0002`H2\b\u00109\u001a\u0004\u0018\u00010:J\u0016\u0010I\u001a\u0002032\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+J\u0006\u0010J\u001a\u000203J\u0018\u0010K\u001a\u0002032\u0006\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020\u0018H\u0016J\u0010\u0010L\u001a\u0002032\u0006\u0010M\u001a\u00020\u0018H\u0016J\u0010\u0010L\u001a\u0002032\u0006\u0010N\u001a\u00020 H\u0016J\u0010\u0010O\u001a\u0002032\u0006\u0010P\u001a\u00020 H\u0016J\u0010\u0010Q\u001a\u0002032\u0006\u0010P\u001a\u00020 H\u0016J\u000e\u0010R\u001a\u00020\u00122\u0006\u0010P\u001a\u00020 J\u0006\u0010S\u001a\u00020\u0012J\b\u0010!\u001a\u00020\fH\u0016J\u0006\u0010'\u001a\u00020%J\u0006\u0010(\u001a\u00020%J\b\u0010T\u001a\u00020\u0006H\u0016J\b\u0010U\u001a\u000203H\u0002J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010M\u001a\u00020\u0018H\u0016J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010N\u001a\u00020 H\u0016J\u0018\u0010V\u001a\u00020\u00122\u0006\u0010W\u001a\u00020 2\u0006\u0010X\u001a\u00020%H\u0002J\u0006\u0010)\u001a\u00020%J\u0006\u0010Y\u001a\u000203J\r\u0010Z\u001a\u00020\u0012H\u0000\u00a2\u0006\u0002\b[J\r\u0010\\\u001a\u000203H\u0000\u00a2\u0006\u0002\b]J\f\u0010^\u001a\u00020\u0012*\u00020\u000eH\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006d"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket;", "Lokhttp3/WebSocket;", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "originalRequest", "Lokhttp3/Request;", "listener", "Lokhttp3/WebSocketListener;", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "Ljava/util/Random;", "pingIntervalMillis", "", "extensions", "Lokhttp3/internal/ws/WebSocketExtensions;", "minimumDeflateSize", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/Request;Lokhttp3/WebSocketListener;Ljava/util/Random;JLokhttp3/internal/ws/WebSocketExtensions;J)V", "awaitingPong", "", "call", "Lokhttp3/Call;", "enqueuedClose", "failed", "key", "", "getListener$okhttp", "()Lokhttp3/WebSocketListener;", "messageAndCloseQueue", "Ljava/util/ArrayDeque;", "", "name", "pongQueue", "Lokio/ByteString;", "queueSize", "reader", "Lokhttp3/internal/ws/WebSocketReader;", "receivedCloseCode", "", "receivedCloseReason", "receivedPingCount", "receivedPongCount", "sentPingCount", IjkMediaMeta.IJKM_KEY_STREAMS, "Lokhttp3/internal/ws/RealWebSocket$Streams;", "taskQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "writer", "Lokhttp3/internal/ws/WebSocketWriter;", "writerTask", "Lokhttp3/internal/concurrent/Task;", "awaitTermination", "", "timeout", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "cancel", "checkUpgradeSuccess", "response", "Lokhttp3/Response;", "exchange", "Lokhttp3/internal/connection/Exchange;", "checkUpgradeSuccess$okhttp", "close", "code", "reason", "cancelAfterCloseMillis", UploadQualityReportBuilder.STATE_CONNECT, "client", "Lokhttp3/OkHttpClient;", "failWebSocket", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "initReaderAndWriter", "loopReader", "onReadClose", "onReadMessage", "text", "bytes", "onReadPing", "payload", "onReadPong", "pong", "processNextFrame", Const.BUNDLE_KEY_REQUEST, "runWriter", "send", "data", "formatOpcode", "tearDown", "writeOneFrame", "writeOneFrame$okhttp", "writePingFrame", "writePingFrame$okhttp", AppConstants.Key.COLUMN_IS_VALID, "Close", "Companion", "Message", "Streams", "WriterTask", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1;
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    private WebSocketExtensions extensions;
    private boolean failed;
    private final String key;

    @NotNull
    private final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue;
    private long minimumDeflateSize;
    private String name;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private TaskQueue taskQueue;
    private WebSocketWriter writer;
    private Task writerTask;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Close;", "", "code", "", "reason", "Lokio/ByteString;", "cancelAfterCloseMillis", "", "(ILokio/ByteString;J)V", "getCancelAfterCloseMillis", "()J", "getCode", "()I", "getReason", "()Lokio/ByteString;", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;

        @Nullable
        private final ByteString reason;

        public Close(int i3, @Nullable ByteString byteString, long j3) {
            this.code = i3;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j3;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        @Nullable
        public final ByteString getReason() {
            return this.reason;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Message;", "", "formatOpcode", "", "data", "Lokio/ByteString;", "(ILokio/ByteString;)V", "getData", "()Lokio/ByteString;", "getFormatOpcode", "()I", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    public static final class Message {

        @NotNull
        private final ByteString data;
        private final int formatOpcode;

        public Message(int i3, @NotNull ByteString data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.formatOpcode = i3;
            this.data = data;
        }

        @NotNull
        public final ByteString getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/io/Closeable;", "client", "", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "(ZLokio/BufferedSource;Lokio/BufferedSink;)V", "getClient", "()Z", "getSink", "()Lokio/BufferedSink;", "getSource", "()Lokio/BufferedSource;", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    public static abstract class Streams implements Closeable {
        private final boolean client;

        @NotNull
        private final BufferedSink sink;

        @NotNull
        private final BufferedSource source;

        public Streams(boolean z16, @NotNull BufferedSource source, @NotNull BufferedSink sink) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(sink, "sink");
            this.client = z16;
            this.source = source;
            this.sink = sink;
        }

        public final boolean getClient() {
            return this.client;
        }

        @NotNull
        public final BufferedSink getSink() {
            return this.sink;
        }

        @NotNull
        public final BufferedSource getSource() {
            return this.source;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$WriterTask;", "Lokhttp3/internal/concurrent/Task;", "(Lokhttp3/internal/ws/RealWebSocket;)V", "runOnce", "", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    private final class WriterTask extends Task {
        public WriterTask() {
            super(RealWebSocket.this.name + " writer", false, 2, null);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            try {
                if (RealWebSocket.this.writeOneFrame$okhttp()) {
                    return 0L;
                }
                return -1L;
            } catch (IOException e16) {
                RealWebSocket.this.failWebSocket(e16, null);
                return -1L;
            }
        }
    }

    static {
        List<Protocol> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Protocol.HTTP_1_1);
        ONLY_HTTP1 = listOf;
    }

    public RealWebSocket(@NotNull TaskRunner taskRunner, @NotNull Request originalRequest, @NotNull WebSocketListener listener, @NotNull Random random, long j3, @Nullable WebSocketExtensions webSocketExtensions, long j16) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(random, "random");
        this.originalRequest = originalRequest;
        this.listener = listener;
        this.random = random;
        this.pingIntervalMillis = j3;
        this.extensions = webSocketExtensions;
        this.minimumDeflateSize = j16;
        this.taskQueue = taskRunner.newQueue();
        this.pongQueue = new ArrayDeque<>();
        this.messageAndCloseQueue = new ArrayDeque<>();
        this.receivedCloseCode = -1;
        if (Intrinsics.areEqual("GET", originalRequest.method())) {
            ByteString.Companion companion = ByteString.INSTANCE;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            Unit unit = Unit.INSTANCE;
            this.key = ByteString.Companion.of$default(companion, bArr, 0, 0, 3, null).base64();
            return;
        }
        throw new IllegalArgumentException(("Request must be GET: " + originalRequest.method()).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValid(WebSocketExtensions webSocketExtensions) {
        if (webSocketExtensions.unknownValues || webSocketExtensions.clientMaxWindowBits != null) {
            return false;
        }
        Integer num = webSocketExtensions.serverMaxWindowBits;
        if (num != null) {
            int intValue = num.intValue();
            if (8 > intValue || 15 < intValue) {
                return false;
            }
            return true;
        }
        return true;
    }

    private final void runWriter() {
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb5.append(currentThread.getName());
            sb5.append(" MUST hold lock on ");
            sb5.append(this);
            throw new AssertionError(sb5.toString());
        }
        Task task = this.writerTask;
        if (task != null) {
            TaskQueue.schedule$default(this.taskQueue, task, 0L, 2, null);
        }
    }

    public final void awaitTermination(long timeout, @NotNull TimeUnit timeUnit) throws InterruptedException {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.taskQueue.idleLatch().await(timeout, timeUnit);
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        Call call = this.call;
        Intrinsics.checkNotNull(call);
        call.cancel();
    }

    public final void checkUpgradeSuccess$okhttp(@NotNull Response response, @Nullable Exchange exchange) throws IOException {
        boolean equals;
        boolean equals2;
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.code() == 101) {
            String header$default = Response.header$default(response, "Connection", null, 2, null);
            equals = StringsKt__StringsJVMKt.equals(HttpHeaders.UPGRADE, header$default, true);
            if (equals) {
                String header$default2 = Response.header$default(response, HttpHeaders.UPGRADE, null, 2, null);
                equals2 = StringsKt__StringsJVMKt.equals("websocket", header$default2, true);
                if (equals2) {
                    String header$default3 = Response.header$default(response, "Sec-WebSocket-Accept", null, 2, null);
                    String base64 = ByteString.INSTANCE.encodeUtf8(this.key + WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
                    if (!(!Intrinsics.areEqual(base64, header$default3))) {
                        if (exchange != null) {
                            return;
                        } else {
                            throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
                        }
                    }
                    throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header$default3 + '\'');
                }
                throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header$default2 + '\'');
            }
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header$default + '\'');
        }
        throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + TokenParser.SP + response.message() + '\'');
    }

    @Override // okhttp3.WebSocket
    public boolean close(int code, @Nullable String reason) {
        return close(code, reason, 60000L);
    }

    public final void connect(@NotNull OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        if (this.originalRequest.header("Sec-WebSocket-Extensions") != null) {
            failWebSocket(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
            return;
        }
        OkHttpClient build = client.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request build2 = this.originalRequest.newBuilder().header(HttpHeaders.UPGRADE, "websocket").header("Connection", HttpHeaders.UPGRADE).header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").header("Sec-WebSocket-Extensions", "permessage-deflate").build();
        RealCall realCall = new RealCall(build, build2, true);
        this.call = realCall;
        Intrinsics.checkNotNull(realCall);
        realCall.enqueue(new Callback() { // from class: okhttp3.internal.ws.RealWebSocket$connect$1
            @Override // okhttp3.Callback
            public void onFailure(@NotNull Call call, @NotNull IOException e16) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e16, "e");
                RealWebSocket.this.failWebSocket(e16, null);
            }

            @Override // okhttp3.Callback
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                boolean isValid;
                ArrayDeque arrayDeque;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                Exchange exchange = response.getExchange();
                try {
                    RealWebSocket.this.checkUpgradeSuccess$okhttp(response, exchange);
                    Intrinsics.checkNotNull(exchange);
                    RealWebSocket.Streams newWebSocketStreams = exchange.newWebSocketStreams();
                    WebSocketExtensions parse = WebSocketExtensions.INSTANCE.parse(response.headers());
                    RealWebSocket.this.extensions = parse;
                    isValid = RealWebSocket.this.isValid(parse);
                    if (!isValid) {
                        synchronized (RealWebSocket.this) {
                            arrayDeque = RealWebSocket.this.messageAndCloseQueue;
                            arrayDeque.clear();
                            RealWebSocket.this.close(1010, "unexpected Sec-WebSocket-Extensions in response header");
                        }
                    }
                    try {
                        RealWebSocket.this.initReaderAndWriter(Util.okHttpName + " WebSocket " + build2.url().redact(), newWebSocketStreams);
                        RealWebSocket.this.getListener().onOpen(RealWebSocket.this, response);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e16) {
                        RealWebSocket.this.failWebSocket(e16, null);
                    }
                } catch (IOException e17) {
                    if (exchange != null) {
                        exchange.webSocketUpgradeFailed();
                    }
                    RealWebSocket.this.failWebSocket(e17, response);
                    Util.closeQuietly(response);
                }
            }
        });
    }

    public final void failWebSocket(@NotNull Exception e16, @Nullable Response response) {
        Intrinsics.checkNotNullParameter(e16, "e");
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            Streams streams = this.streams;
            this.streams = null;
            WebSocketReader webSocketReader = this.reader;
            this.reader = null;
            WebSocketWriter webSocketWriter = this.writer;
            this.writer = null;
            this.taskQueue.shutdown();
            Unit unit = Unit.INSTANCE;
            try {
                this.listener.onFailure(this, e16, response);
            } finally {
                if (streams != null) {
                    Util.closeQuietly(streams);
                }
                if (webSocketReader != null) {
                    Util.closeQuietly(webSocketReader);
                }
                if (webSocketWriter != null) {
                    Util.closeQuietly(webSocketWriter);
                }
            }
        }
    }

    @NotNull
    /* renamed from: getListener$okhttp, reason: from getter */
    public final WebSocketListener getListener() {
        return this.listener;
    }

    public final void initReaderAndWriter(@NotNull final String name, @NotNull final Streams streams) throws IOException {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(streams, "streams");
        final WebSocketExtensions webSocketExtensions = this.extensions;
        Intrinsics.checkNotNull(webSocketExtensions);
        synchronized (this) {
            this.name = name;
            this.streams = streams;
            this.writer = new WebSocketWriter(streams.getClient(), streams.getSink(), this.random, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(streams.getClient()), this.minimumDeflateSize);
            this.writerTask = new WriterTask();
            long j3 = this.pingIntervalMillis;
            if (j3 != 0) {
                final long nanos = TimeUnit.MILLISECONDS.toNanos(j3);
                final String str = name + " ping";
                this.taskQueue.schedule(new Task(str) { // from class: okhttp3.internal.ws.RealWebSocket$initReaderAndWriter$$inlined$synchronized$lambda$1
                    @Override // okhttp3.internal.concurrent.Task
                    public long runOnce() {
                        this.writePingFrame$okhttp();
                        return nanos;
                    }
                }, nanos);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
            Unit unit = Unit.INSTANCE;
        }
        this.reader = new WebSocketReader(streams.getClient(), streams.getSource(), this, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(!streams.getClient()));
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.checkNotNull(webSocketReader);
            webSocketReader.processNextFrame();
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int code, @NotNull String reason) {
        boolean z16;
        Streams streams;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        Intrinsics.checkNotNullParameter(reason, "reason");
        boolean z17 = true;
        if (code != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            synchronized (this) {
                if (this.receivedCloseCode != -1) {
                    z17 = false;
                }
                if (z17) {
                    this.receivedCloseCode = code;
                    this.receivedCloseReason = reason;
                    streams = null;
                    if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                        Streams streams2 = this.streams;
                        this.streams = null;
                        webSocketReader = this.reader;
                        this.reader = null;
                        webSocketWriter = this.writer;
                        this.writer = null;
                        this.taskQueue.shutdown();
                        streams = streams2;
                    } else {
                        webSocketReader = null;
                        webSocketWriter = null;
                    }
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("already closed".toString());
                }
            }
            try {
                this.listener.onClosing(this, code, reason);
                if (streams != null) {
                    this.listener.onClosed(this, code, reason);
                }
                if (webSocketWriter != null) {
                    return;
                } else {
                    return;
                }
            } finally {
                if (streams != null) {
                    Util.closeQuietly(streams);
                }
                if (webSocketReader != null) {
                    Util.closeQuietly(webSocketReader);
                }
                if (webSocketWriter != null) {
                    Util.closeQuietly(webSocketWriter);
                }
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(@NotNull String text) throws IOException {
        Intrinsics.checkNotNullParameter(text, "text");
        this.listener.onMessage(this, text);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(@NotNull ByteString payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(payload);
            runWriter();
            this.receivedPingCount++;
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(@NotNull ByteString payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public final synchronized boolean pong(@NotNull ByteString payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(payload);
            runWriter();
            return true;
        }
        return false;
    }

    public final boolean processNextFrame() throws IOException {
        try {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.checkNotNull(webSocketReader);
            webSocketReader.processNextFrame();
            if (this.receivedCloseCode != -1) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            failWebSocket(e16, null);
            return false;
        }
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.queueSize;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @Override // okhttp3.WebSocket
    @NotNull
    /* renamed from: request, reason: from getter */
    public Request getOriginalRequest() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public boolean send(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return send(ByteString.INSTANCE.encodeUtf8(text), 1);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10L, TimeUnit.SECONDS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fd A[Catch: all -> 0x01b3, TRY_ENTER, TryCatch #3 {all -> 0x01b3, blocks: (B:25:0x00fd, B:38:0x0108, B:41:0x0112, B:42:0x0122, B:45:0x0131, B:49:0x0134, B:50:0x0135, B:51:0x0136, B:52:0x013e, B:53:0x013f, B:57:0x0145, B:44:0x0123), top: B:23:0x00fb, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0108 A[Catch: all -> 0x01b3, TryCatch #3 {all -> 0x01b3, blocks: (B:25:0x00fd, B:38:0x0108, B:41:0x0112, B:42:0x0122, B:45:0x0131, B:49:0x0134, B:50:0x0135, B:51:0x0136, B:52:0x013e, B:53:0x013f, B:57:0x0145, B:44:0x0123), top: B:23:0x00fb, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01d2  */
    /* JADX WARN: Type inference failed for: r1v10, types: [okhttp3.internal.ws.WebSocketWriter, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v13, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v15, types: [T, okhttp3.internal.ws.RealWebSocket$Streams] */
    /* JADX WARN: Type inference failed for: r2v16, types: [T, okhttp3.internal.ws.WebSocketReader] */
    /* JADX WARN: Type inference failed for: r2v17, types: [T, okhttp3.internal.ws.WebSocketWriter] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v16, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [okio.ByteString] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean writeOneFrame$okhttp() throws IOException {
        ByteString byteString;
        WebSocketWriter webSocketWriter;
        final Ref.ObjectRef objectRef;
        final Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.IntRef intRef;
        Ref.ObjectRef objectRef5;
        Ref.ObjectRef objectRef6;
        Ref.ObjectRef objectRef7;
        Streams streams;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter2;
        Ref.ObjectRef objectRef8;
        Streams streams2;
        WebSocketReader webSocketReader2;
        WebSocketWriter webSocketWriter3;
        final Ref.ObjectRef objectRef9 = new Ref.ObjectRef();
        objectRef9.element = null;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = -1;
        final Ref.ObjectRef objectRef10 = new Ref.ObjectRef();
        objectRef10.element = null;
        final Ref.ObjectRef objectRef11 = new Ref.ObjectRef();
        objectRef11.element = null;
        Ref.ObjectRef objectRef12 = new Ref.ObjectRef();
        objectRef12.element = null;
        Ref.ObjectRef objectRef13 = new Ref.ObjectRef();
        objectRef13.element = null;
        synchronized (this) {
            if (this.failed) {
                return false;
            }
            final WebSocketWriter webSocketWriter4 = this.writer;
            final ByteString poll = this.pongQueue.poll();
            try {
                if (poll == null) {
                    ?? poll2 = this.messageAndCloseQueue.poll();
                    objectRef9.element = poll2;
                    if (poll2 instanceof Close) {
                        int i3 = this.receivedCloseCode;
                        intRef2.element = i3;
                        objectRef10.element = this.receivedCloseReason;
                        if (i3 != -1) {
                            objectRef11.element = this.streams;
                            this.streams = null;
                            objectRef12.element = this.reader;
                            this.reader = null;
                            objectRef13.element = this.writer;
                            this.writer = null;
                            this.taskQueue.shutdown();
                        } else {
                            T t16 = objectRef9.element;
                            if (t16 != 0) {
                                long cancelAfterCloseMillis = ((Close) t16).getCancelAfterCloseMillis();
                                TaskQueue taskQueue = this.taskQueue;
                                final String str = this.name + " cancel";
                                final boolean z16 = true;
                                byteString = poll;
                                webSocketWriter = webSocketWriter4;
                                objectRef = objectRef13;
                                objectRef2 = objectRef12;
                                objectRef3 = objectRef11;
                                objectRef4 = objectRef10;
                                intRef = intRef2;
                                taskQueue.schedule(new Task(str, z16) { // from class: okhttp3.internal.ws.RealWebSocket$writeOneFrame$$inlined$synchronized$lambda$1
                                    @Override // okhttp3.internal.concurrent.Task
                                    public long runOnce() {
                                        this.cancel();
                                        return -1L;
                                    }
                                }, TimeUnit.MILLISECONDS.toNanos(cancelAfterCloseMillis));
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
                            }
                        }
                    } else {
                        byteString = poll;
                        webSocketWriter = webSocketWriter4;
                        objectRef = objectRef13;
                        objectRef2 = objectRef12;
                        objectRef3 = objectRef11;
                        objectRef4 = objectRef10;
                        intRef = intRef2;
                        if (poll2 == 0) {
                            return false;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    objectRef5 = byteString;
                    if (objectRef5 == 0) {
                        Intrinsics.checkNotNull(webSocketWriter);
                        webSocketWriter.writePong(objectRef5);
                    } else {
                        objectRef7 = webSocketWriter;
                        T t17 = objectRef9.element;
                        if (t17 instanceof Message) {
                            if (t17 != 0) {
                                Message message = (Message) t17;
                                Intrinsics.checkNotNull(objectRef7);
                                objectRef7.writeMessageFrame(message.getFormatOpcode(), message.getData());
                                synchronized (this) {
                                    this.queueSize -= message.getData().size();
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");
                            }
                        } else {
                            objectRef6 = t17 instanceof Close;
                            try {
                                if (objectRef6 != 0) {
                                    if (t17 != 0) {
                                        Close close = (Close) t17;
                                        Intrinsics.checkNotNull(objectRef7);
                                        objectRef7.writeClose(close.getCode(), close.getReason());
                                        objectRef7 = objectRef3;
                                        try {
                                            Streams streams3 = (Streams) objectRef7.element;
                                            objectRef8 = objectRef7;
                                            if (streams3 != null) {
                                                WebSocketListener webSocketListener = this.listener;
                                                int i16 = intRef.element;
                                                String str2 = (String) objectRef4.element;
                                                Intrinsics.checkNotNull(str2);
                                                webSocketListener.onClosed(this, i16, str2);
                                                objectRef8 = objectRef7;
                                            }
                                            streams2 = (Streams) objectRef8.element;
                                            if (streams2 != null) {
                                                Util.closeQuietly(streams2);
                                            }
                                            webSocketReader2 = (WebSocketReader) objectRef2.element;
                                            if (webSocketReader2 != null) {
                                                Util.closeQuietly(webSocketReader2);
                                            }
                                            webSocketWriter3 = (WebSocketWriter) objectRef.element;
                                            if (webSocketWriter3 != null) {
                                                Util.closeQuietly(webSocketWriter3);
                                                return true;
                                            }
                                            return true;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            objectRef5 = objectRef;
                                            objectRef6 = objectRef2;
                                            streams = (Streams) objectRef7.element;
                                            if (streams != null) {
                                                Util.closeQuietly(streams);
                                            }
                                            webSocketReader = (WebSocketReader) objectRef6.element;
                                            if (webSocketReader != null) {
                                                Util.closeQuietly(webSocketReader);
                                            }
                                            webSocketWriter2 = (WebSocketWriter) objectRef5.element;
                                            if (webSocketWriter2 != null) {
                                                Util.closeQuietly(webSocketWriter2);
                                            }
                                            throw th;
                                        }
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
                                }
                                throw new AssertionError();
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        }
                    }
                    objectRef8 = objectRef3;
                    streams2 = (Streams) objectRef8.element;
                    if (streams2 != null) {
                    }
                    webSocketReader2 = (WebSocketReader) objectRef2.element;
                    if (webSocketReader2 != null) {
                    }
                    webSocketWriter3 = (WebSocketWriter) objectRef.element;
                    if (webSocketWriter3 != null) {
                    }
                }
                if (objectRef5 == 0) {
                }
                objectRef8 = objectRef3;
                streams2 = (Streams) objectRef8.element;
                if (streams2 != null) {
                }
                webSocketReader2 = (WebSocketReader) objectRef2.element;
                if (webSocketReader2 != null) {
                }
                webSocketWriter3 = (WebSocketWriter) objectRef.element;
                if (webSocketWriter3 != null) {
                }
            } catch (Throwable th7) {
                th = th7;
                objectRef5 = objectRef;
                objectRef6 = objectRef2;
                objectRef7 = objectRef3;
                streams = (Streams) objectRef7.element;
                if (streams != null) {
                }
                webSocketReader = (WebSocketReader) objectRef6.element;
                if (webSocketReader != null) {
                }
                webSocketWriter2 = (WebSocketWriter) objectRef5.element;
                if (webSocketWriter2 != null) {
                }
                throw th;
            }
            byteString = poll;
            webSocketWriter = webSocketWriter4;
            objectRef = objectRef13;
            objectRef2 = objectRef12;
            objectRef3 = objectRef11;
            objectRef4 = objectRef10;
            intRef = intRef2;
            Unit unit2 = Unit.INSTANCE;
            objectRef5 = byteString;
        }
    }

    public final void writePingFrame$okhttp() {
        int i3;
        synchronized (this) {
            if (this.failed) {
                return;
            }
            WebSocketWriter webSocketWriter = this.writer;
            if (webSocketWriter != null) {
                if (this.awaitingPong) {
                    i3 = this.sentPingCount;
                } else {
                    i3 = -1;
                }
                this.sentPingCount++;
                this.awaitingPong = true;
                Unit unit = Unit.INSTANCE;
                if (i3 != -1) {
                    failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (i3 - 1) + " successful ping/pongs)"), null);
                    return;
                }
                try {
                    webSocketWriter.writePing(ByteString.EMPTY);
                } catch (IOException e16) {
                    failWebSocket(e16, null);
                }
            }
        }
    }

    public final synchronized boolean close(int code, @Nullable String reason, long cancelAfterCloseMillis) {
        ByteString byteString;
        WebSocketProtocol.INSTANCE.validateCloseCode(code);
        if (reason != null) {
            byteString = ByteString.INSTANCE.encodeUtf8(reason);
            if (!(((long) byteString.size()) <= 123)) {
                throw new IllegalArgumentException(("reason.size() > 123: " + reason).toString());
            }
        } else {
            byteString = null;
        }
        if (!this.failed && !this.enqueuedClose) {
            this.enqueuedClose = true;
            this.messageAndCloseQueue.add(new Close(code, byteString, cancelAfterCloseMillis));
            runWriter();
            return true;
        }
        return false;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(@NotNull ByteString bytes) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.listener.onMessage(this, bytes);
    }

    @Override // okhttp3.WebSocket
    public boolean send(@NotNull ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return send(bytes, 2);
    }

    private final synchronized boolean send(ByteString data, int formatOpcode) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + data.size() > 16777216) {
                close(1001, null);
                return false;
            }
            this.queueSize += data.size();
            this.messageAndCloseQueue.add(new Message(formatOpcode, data));
            runWriter();
            return true;
        }
        return false;
    }
}
