package okhttp3.internal.http2;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 :2\u00020\u0001:\u0001:B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0006\u0010\u0015\u001a\u00020\u0011J(\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u000fJ(\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u000fJ\u0006\u0010\u001e\u001a\u00020\u0011J&\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fJ\u001e\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J$\u0010(\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*J\u0006\u0010,\u001a\u00020\u000fJ\u001e\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000fJ$\u00101\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u000f2\f\u00103\u001a\b\u0012\u0004\u0012\u00020+0*J\u0016\u00104\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%J\u000e\u00105\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u0013J\u0016\u00106\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u00107\u001a\u000208J\u0018\u00109\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u000208H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lokhttp3/internal/http2/Http2Writer;", "Ljava/io/Closeable;", "sink", "Lokio/BufferedSink;", "client", "", "(Lokio/BufferedSink;Z)V", AudioContext.State.CLOSED, "hpackBuffer", "Lokio/Buffer;", "hpackWriter", "Lokhttp3/internal/http2/Hpack$Writer;", "getHpackWriter", "()Lokhttp3/internal/http2/Hpack$Writer;", "maxFrameSize", "", "applyAndAckSettings", "", "peerSettings", "Lokhttp3/internal/http2/Settings;", "close", "connectionPreface", "data", "outFinished", "streamId", "source", "byteCount", "dataFrame", WadlProxyConsts.FLAGS, "buffer", HippyQQPagView.FunctionName.FLUSH, "frameHeader", "length", "type", "goAway", "lastGoodStreamId", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "debugData", "", "headers", "headerBlock", "", "Lokhttp3/internal/http2/Header;", "maxDataLength", "ping", "ack", "payload1", "payload2", "pushPromise", "promisedStreamId", "requestHeaders", "rstStream", QCircleDaTongConstant.ElementParamValue.SETTINGS, "windowUpdate", "windowSizeIncrement", "", "writeContinuationFrames", "Companion", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class Http2Writer implements Closeable {
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;

    @NotNull
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    public Http2Writer(@NotNull BufferedSink sink, boolean z16) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.sink = sink;
        this.client = z16;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.maxFrameSize = 16384;
        this.hpackWriter = new Hpack.Writer(0, false, buffer, 3, null);
    }

    private final void writeContinuationFrames(int streamId, long byteCount) throws IOException {
        int i3;
        while (byteCount > 0) {
            long min = Math.min(this.maxFrameSize, byteCount);
            byteCount -= min;
            int i16 = (int) min;
            if (byteCount == 0) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            frameHeader(streamId, i16, 9, i3);
            this.sink.write(this.hpackBuffer, min);
        }
    }

    public final synchronized void applyAndAckSettings(@NotNull Settings peerSettings) throws IOException {
        Intrinsics.checkNotNullParameter(peerSettings, "peerSettings");
        if (!this.closed) {
            this.maxFrameSize = peerSettings.getMaxFrameSize(this.maxFrameSize);
            if (peerSettings.getHeaderTableSize() != -1) {
                this.hpackWriter.resizeHeaderTable(peerSettings.getHeaderTableSize());
            }
            frameHeader(0, 0, 4, 1);
            this.sink.flush();
        } else {
            throw new IOException(AudioContext.State.CLOSED);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void connectionPreface() throws IOException {
        if (!this.closed) {
            if (!this.client) {
                return;
            }
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Util.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
            }
            this.sink.write(Http2.CONNECTION_PREFACE);
            this.sink.flush();
            return;
        }
        throw new IOException(AudioContext.State.CLOSED);
    }

    public final synchronized void data(boolean outFinished, int streamId, @Nullable Buffer source, int byteCount) throws IOException {
        if (!this.closed) {
            dataFrame(streamId, outFinished ? 1 : 0, source, byteCount);
        } else {
            throw new IOException(AudioContext.State.CLOSED);
        }
    }

    public final void dataFrame(int streamId, int flags, @Nullable Buffer buffer, int byteCount) throws IOException {
        frameHeader(streamId, byteCount, 0, flags);
        if (byteCount > 0) {
            BufferedSink bufferedSink = this.sink;
            Intrinsics.checkNotNull(buffer);
            bufferedSink.write(buffer, byteCount);
        }
    }

    public final synchronized void flush() throws IOException {
        if (!this.closed) {
            this.sink.flush();
        } else {
            throw new IOException(AudioContext.State.CLOSED);
        }
    }

    public final void frameHeader(int streamId, int length, int type, int flags) throws IOException {
        boolean z16;
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.INSTANCE.frameLog(false, streamId, length, type, flags));
        }
        boolean z17 = true;
        if (length <= this.maxFrameSize) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if ((((int) 2147483648L) & streamId) != 0) {
                z17 = false;
            }
            if (z17) {
                Util.writeMedium(this.sink, length);
                this.sink.writeByte(type & 255);
                this.sink.writeByte(flags & 255);
                this.sink.writeInt(streamId & Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException(("reserved bit set: " + streamId).toString());
        }
        throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + MsgSummary.STR_COLON + length).toString());
    }

    @NotNull
    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void goAway(int lastGoodStreamId, @NotNull ErrorCode errorCode, @NotNull byte[] debugData) throws IOException {
        boolean z16;
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(debugData, "debugData");
        if (!this.closed) {
            boolean z17 = false;
            if (errorCode.getHttpCode() != -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                frameHeader(0, debugData.length + 8, 7, 0);
                this.sink.writeInt(lastGoodStreamId);
                this.sink.writeInt(errorCode.getHttpCode());
                if (debugData.length == 0) {
                    z17 = true;
                }
                if (!z17) {
                    this.sink.write(debugData);
                }
                this.sink.flush();
            } else {
                throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
            }
        } else {
            throw new IOException(AudioContext.State.CLOSED);
        }
    }

    public final synchronized void headers(boolean outFinished, int streamId, @NotNull List<Header> headerBlock) throws IOException {
        int i3;
        Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
        if (!this.closed) {
            this.hpackWriter.writeHeaders(headerBlock);
            long size = this.hpackBuffer.size();
            long min = Math.min(this.maxFrameSize, size);
            if (size == min) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            if (outFinished) {
                i3 |= 1;
            }
            frameHeader(streamId, (int) min, 1, i3);
            this.sink.write(this.hpackBuffer, min);
            if (size > min) {
                writeContinuationFrames(streamId, size - min);
            }
        } else {
            throw new IOException(AudioContext.State.CLOSED);
        }
    }

    /* renamed from: maxDataLength, reason: from getter */
    public final int getMaxFrameSize() {
        return this.maxFrameSize;
    }

    public final synchronized void ping(boolean ack, int payload1, int payload2) throws IOException {
        int i3;
        if (!this.closed) {
            if (ack) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            frameHeader(0, 8, 6, i3);
            this.sink.writeInt(payload1);
            this.sink.writeInt(payload2);
            this.sink.flush();
        } else {
            throw new IOException(AudioContext.State.CLOSED);
        }
    }

    public final synchronized void pushPromise(int streamId, int promisedStreamId, @NotNull List<Header> requestHeaders) throws IOException {
        int i3;
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        if (!this.closed) {
            this.hpackWriter.writeHeaders(requestHeaders);
            long size = this.hpackBuffer.size();
            int min = (int) Math.min(this.maxFrameSize - 4, size);
            int i16 = min + 4;
            long j3 = min;
            if (size == j3) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            frameHeader(streamId, i16, 5, i3);
            this.sink.writeInt(promisedStreamId & Integer.MAX_VALUE);
            this.sink.write(this.hpackBuffer, j3);
            if (size > j3) {
                writeContinuationFrames(streamId, size - j3);
            }
        } else {
            throw new IOException(AudioContext.State.CLOSED);
        }
    }

    public final synchronized void rstStream(int streamId, @NotNull ErrorCode errorCode) throws IOException {
        boolean z16;
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (!this.closed) {
            if (errorCode.getHttpCode() != -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                frameHeader(streamId, 4, 3, 0);
                this.sink.writeInt(errorCode.getHttpCode());
                this.sink.flush();
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            throw new IOException(AudioContext.State.CLOSED);
        }
    }

    public final synchronized void settings(@NotNull Settings settings) throws IOException {
        int i3;
        Intrinsics.checkNotNullParameter(settings, "settings");
        if (!this.closed) {
            frameHeader(0, settings.size() * 6, 4, 0);
            for (int i16 = 0; i16 < 10; i16++) {
                if (settings.isSet(i16)) {
                    if (i16 != 4) {
                        if (i16 != 7) {
                            i3 = i16;
                        } else {
                            i3 = 4;
                        }
                    } else {
                        i3 = 3;
                    }
                    this.sink.writeShort(i3);
                    this.sink.writeInt(settings.get(i16));
                }
            }
            this.sink.flush();
        } else {
            throw new IOException(AudioContext.State.CLOSED);
        }
    }

    public final synchronized void windowUpdate(int streamId, long windowSizeIncrement) throws IOException {
        boolean z16;
        if (!this.closed) {
            if (windowSizeIncrement != 0 && windowSizeIncrement <= TTL.MAX_VALUE) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                frameHeader(streamId, 4, 8, 0);
                this.sink.writeInt((int) windowSizeIncrement);
                this.sink.flush();
            } else {
                throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + windowSizeIncrement).toString());
            }
        } else {
            throw new IOException(AudioContext.State.CLOSED);
        }
    }
}
