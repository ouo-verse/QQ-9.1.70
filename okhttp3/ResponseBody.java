package okhttp3;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.msf.core.auth.k;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.DebugKt;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J@\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002H\u00110\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00170\u0014H\u0082\b\u00a2\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\b\u0010\u001d\u001a\u00020\u0015H&J\u0006\u0010\u001e\u001a\u00020\u001fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lokhttp3/ResponseBody;", "Ljava/io/Closeable;", "()V", "reader", "Ljava/io/Reader;", "byteStream", "Ljava/io/InputStream;", "byteString", "Lokio/ByteString;", "bytes", "", "charStream", HttpMsg.CHARSET, "Ljava/nio/charset/Charset;", "close", "", "consumeSource", "T", "", "consumer", "Lkotlin/Function1;", "Lokio/BufferedSource;", "sizeMapper", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "source", HippyControllerProps.STRING, "", "BomAwareReader", "Companion", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public abstract class ResponseBody implements Closeable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private Reader reader;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lokhttp3/ResponseBody$BomAwareReader;", "Ljava/io/Reader;", "source", "Lokio/BufferedSource;", HttpMsg.CHARSET, "Ljava/nio/charset/Charset;", "(Lokio/BufferedSource;Ljava/nio/charset/Charset;)V", AudioContext.State.CLOSED, "", "delegate", "close", "", k.f247491e, "", "cbuf", "", DebugKt.DEBUG_PROPERTY_VALUE_OFF, c.E, "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final BufferedSource source;

        public BomAwareReader(@NotNull BufferedSource source, @NotNull Charset charset) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(charset, "charset");
            this.source = source;
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }

        @Override // java.io.Reader
        public int read(@NotNull char[] cbuf, int off, int len) throws IOException {
            Intrinsics.checkNotNullParameter(cbuf, "cbuf");
            if (!this.closed) {
                Reader reader = this.delegate;
                if (reader == null) {
                    reader = new InputStreamReader(this.source.inputStream(), Util.readBomAsCharset(this.source, this.charset));
                    this.delegate = reader;
                }
                return reader.read(cbuf, off, len);
            }
            throw new IOException("Stream closed");
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000bH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\fH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\rH\u0007J'\u0010\u000e\u001a\u00020\u0004*\u00020\u000b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u00a2\u0006\u0002\b\u0003J\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\b\u0003J\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\b\u0003J\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\r2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\b\u0003\u00a8\u0006\u0010"}, d2 = {"Lokhttp3/ResponseBody$Companion;", "", "()V", OperateCustomButton.OPERATE_CREATE, "Lokhttp3/ResponseBody;", "contentType", "Lokhttp3/MediaType;", "content", "", "contentLength", "", "Lokio/BufferedSource;", "", "Lokio/ByteString;", "asResponseBody", "toResponseBody", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class Companion {
        Companion() {
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, String str, MediaType mediaType, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        @JvmStatic
        @JvmName(name = OperateCustomButton.OPERATE_CREATE)
        @NotNull
        public final ResponseBody create(@NotNull String toResponseBody, @Nullable MediaType mediaType) {
            Intrinsics.checkNotNullParameter(toResponseBody, "$this$toResponseBody");
            Charset charset = Charsets.UTF_8;
            if (mediaType != null) {
                Charset charset$default = MediaType.charset$default(mediaType, null, 1, null);
                if (charset$default == null) {
                    mediaType = MediaType.INSTANCE.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charset$default;
                }
            }
            Buffer writeString = new Buffer().writeString(toResponseBody, charset);
            return create(writeString, mediaType, writeString.size());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(bArr, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, BufferedSource bufferedSource, MediaType mediaType, long j3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            if ((i3 & 2) != 0) {
                j3 = -1;
            }
            return companion.create(bufferedSource, mediaType, j3);
        }

        @JvmStatic
        @JvmName(name = OperateCustomButton.OPERATE_CREATE)
        @NotNull
        public final ResponseBody create(@NotNull byte[] toResponseBody, @Nullable MediaType mediaType) {
            Intrinsics.checkNotNullParameter(toResponseBody, "$this$toResponseBody");
            return create(new Buffer().write(toResponseBody), mediaType, toResponseBody.length);
        }

        @JvmStatic
        @JvmName(name = OperateCustomButton.OPERATE_CREATE)
        @NotNull
        public final ResponseBody create(@NotNull ByteString toResponseBody, @Nullable MediaType mediaType) {
            Intrinsics.checkNotNullParameter(toResponseBody, "$this$toResponseBody");
            return create(new Buffer().write(toResponseBody), mediaType, toResponseBody.size());
        }

        @JvmStatic
        @JvmName(name = OperateCustomButton.OPERATE_CREATE)
        @NotNull
        public final ResponseBody create(@NotNull final BufferedSource asResponseBody, @Nullable final MediaType mediaType, final long j3) {
            Intrinsics.checkNotNullParameter(asResponseBody, "$this$asResponseBody");
            return new ResponseBody() { // from class: okhttp3.ResponseBody$Companion$asResponseBody$1
                @Override // okhttp3.ResponseBody
                /* renamed from: contentLength, reason: from getter */
                public long get$contentLength() {
                    return j3;
                }

                @Override // okhttp3.ResponseBody
                @Nullable
                /* renamed from: contentType, reason: from getter */
                public MediaType get$contentType() {
                    return mediaType;
                }

                @Override // okhttp3.ResponseBody
                @NotNull
                /* renamed from: source, reason: from getter */
                public BufferedSource get$this_asResponseBody() {
                    return BufferedSource.this;
                }
            };
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @JvmStatic
        @NotNull
        public final ResponseBody create(@Nullable MediaType contentType, @NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, contentType);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @JvmStatic
        @NotNull
        public final ResponseBody create(@Nullable MediaType contentType, @NotNull byte[] content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, contentType);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @JvmStatic
        @NotNull
        public final ResponseBody create(@Nullable MediaType contentType, @NotNull ByteString content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, contentType);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}))
        @JvmStatic
        @NotNull
        public final ResponseBody create(@Nullable MediaType contentType, long contentLength, @NotNull BufferedSource content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, contentType, contentLength);
        }
    }

    private final Charset charset() {
        Charset charset;
        MediaType mediaType = get$contentType();
        if (mediaType == null || (charset = mediaType.charset(Charsets.UTF_8)) == null) {
            return Charsets.UTF_8;
        }
        return charset;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Object] */
    private final <T> T consumeSource(Function1<? super BufferedSource, ? extends T> consumer, Function1<? super T, Integer> sizeMapper) {
        long j3 = get$contentLength();
        if (j3 <= Integer.MAX_VALUE) {
            BufferedSource bufferedSource = get$this_asResponseBody();
            try {
                T invoke = consumer.invoke(bufferedSource);
                InlineMarker.finallyStart(1);
                CloseableKt.closeFinally(bufferedSource, null);
                InlineMarker.finallyEnd(1);
                int intValue = sizeMapper.invoke(invoke).intValue();
                if (j3 != -1 && j3 != intValue) {
                    throw new IOException("Content-Length (" + j3 + ") and stream length (" + intValue + ") disagree");
                }
                return invoke;
            } finally {
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + j3);
        }
    }

    @JvmStatic
    @JvmName(name = OperateCustomButton.OPERATE_CREATE)
    @NotNull
    public static final ResponseBody create(@NotNull String str, @Nullable MediaType mediaType) {
        return INSTANCE.create(str, mediaType);
    }

    @NotNull
    public final InputStream byteStream() {
        return get$this_asResponseBody().inputStream();
    }

    @NotNull
    public final ByteString byteString() throws IOException {
        long j3 = get$contentLength();
        if (j3 <= Integer.MAX_VALUE) {
            BufferedSource bufferedSource = get$this_asResponseBody();
            try {
                ByteString readByteString = bufferedSource.readByteString();
                CloseableKt.closeFinally(bufferedSource, null);
                int size = readByteString.size();
                if (j3 != -1 && j3 != size) {
                    throw new IOException("Content-Length (" + j3 + ") and stream length (" + size + ") disagree");
                }
                return readByteString;
            } finally {
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + j3);
        }
    }

    @NotNull
    public final byte[] bytes() throws IOException {
        long j3 = get$contentLength();
        if (j3 <= Integer.MAX_VALUE) {
            BufferedSource bufferedSource = get$this_asResponseBody();
            try {
                byte[] readByteArray = bufferedSource.readByteArray();
                CloseableKt.closeFinally(bufferedSource, null);
                int length = readByteArray.length;
                if (j3 != -1 && j3 != length) {
                    throw new IOException("Content-Length (" + j3 + ") and stream length (" + length + ") disagree");
                }
                return readByteArray;
            } finally {
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + j3);
        }
    }

    @NotNull
    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader == null) {
            BomAwareReader bomAwareReader = new BomAwareReader(get$this_asResponseBody(), charset());
            this.reader = bomAwareReader;
            return bomAwareReader;
        }
        return reader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(get$this_asResponseBody());
    }

    /* renamed from: contentLength */
    public abstract long get$contentLength();

    @Nullable
    /* renamed from: contentType */
    public abstract MediaType get$contentType();

    @NotNull
    /* renamed from: source */
    public abstract BufferedSource get$this_asResponseBody();

    @NotNull
    public final String string() throws IOException {
        BufferedSource bufferedSource = get$this_asResponseBody();
        try {
            String readString = bufferedSource.readString(Util.readBomAsCharset(bufferedSource, charset()));
            CloseableKt.closeFinally(bufferedSource, null);
            return readString;
        } finally {
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}))
    @JvmStatic
    @NotNull
    public static final ResponseBody create(@Nullable MediaType mediaType, long j3, @NotNull BufferedSource bufferedSource) {
        return INSTANCE.create(mediaType, j3, bufferedSource);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    @NotNull
    public static final ResponseBody create(@Nullable MediaType mediaType, @NotNull String str) {
        return INSTANCE.create(mediaType, str);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    @NotNull
    public static final ResponseBody create(@Nullable MediaType mediaType, @NotNull ByteString byteString) {
        return INSTANCE.create(mediaType, byteString);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    @NotNull
    public static final ResponseBody create(@Nullable MediaType mediaType, @NotNull byte[] bArr) {
        return INSTANCE.create(mediaType, bArr);
    }

    @JvmStatic
    @JvmName(name = OperateCustomButton.OPERATE_CREATE)
    @NotNull
    public static final ResponseBody create(@NotNull BufferedSource bufferedSource, @Nullable MediaType mediaType, long j3) {
        return INSTANCE.create(bufferedSource, mediaType, j3);
    }

    @JvmStatic
    @JvmName(name = OperateCustomButton.OPERATE_CREATE)
    @NotNull
    public static final ResponseBody create(@NotNull ByteString byteString, @Nullable MediaType mediaType) {
        return INSTANCE.create(byteString, mediaType);
    }

    @JvmStatic
    @JvmName(name = OperateCustomButton.OPERATE_CREATE)
    @NotNull
    public static final ResponseBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType) {
        return INSTANCE.create(bArr, mediaType);
    }
}
