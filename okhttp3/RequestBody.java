package okhttp3;

import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000f"}, d2 = {"Lokhttp3/RequestBody;", "", "()V", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "isDuplex", "", "isOneShot", "writeTo", "", "sink", "Lokio/BufferedSink;", "Companion", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public abstract class RequestBody {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u000eH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u000fH\u0007J\u001d\u0010\u0010\u001a\u00020\u0004*\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\b\u0003J1\u0010\u0011\u001a\u00020\u0004*\u00020\n2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007\u00a2\u0006\u0002\b\u0003J\u001d\u0010\u0011\u001a\u00020\u0004*\u00020\u000e2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\b\u0003J\u001d\u0010\u0011\u001a\u00020\u0004*\u00020\u000f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\b\u0003\u00a8\u0006\u0012"}, d2 = {"Lokhttp3/RequestBody$Companion;", "", "()V", OperateCustomButton.OPERATE_CREATE, "Lokhttp3/RequestBody;", "contentType", "Lokhttp3/MediaType;", "file", "Ljava/io/File;", "content", "", "offset", "", "byteCount", "", "Lokio/ByteString;", "asRequestBody", "toRequestBody", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class Companion {
        Companion() {
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String str, MediaType mediaType, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        @JvmStatic
        @NotNull
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmOverloads
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] bArr) {
            return create$default(this, mediaType, bArr, 0, 0, 12, (Object) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        @JvmStatic
        @NotNull
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmOverloads
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] bArr, int i3) {
            return create$default(this, mediaType, bArr, i3, 0, 8, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i3, int i16, int i17, Object obj) {
            if ((i17 & 1) != 0) {
                mediaType = null;
            }
            if ((i17 & 2) != 0) {
                i3 = 0;
            }
            if ((i17 & 4) != 0) {
                i16 = bArr.length;
            }
            return companion.create(bArr, mediaType, i3, i16);
        }

        @JvmStatic
        @JvmName(name = OperateCustomButton.OPERATE_CREATE)
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull byte[] bArr) {
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        @JvmStatic
        @JvmName(name = OperateCustomButton.OPERATE_CREATE)
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType) {
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i3, int i16, int i17, Object obj) {
            if ((i17 & 4) != 0) {
                i3 = 0;
            }
            if ((i17 & 8) != 0) {
                i16 = bArr.length;
            }
            return companion.create(mediaType, bArr, i3, i16);
        }

        @JvmStatic
        @JvmName(name = OperateCustomButton.OPERATE_CREATE)
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType, int i3) {
            return create$default(this, bArr, mediaType, i3, 0, 4, (Object) null);
        }

        @JvmStatic
        @JvmName(name = OperateCustomButton.OPERATE_CREATE)
        @NotNull
        public final RequestBody create(@NotNull String toRequestBody, @Nullable MediaType mediaType) {
            Intrinsics.checkNotNullParameter(toRequestBody, "$this$toRequestBody");
            Charset charset = Charsets.UTF_8;
            if (mediaType != null) {
                Charset charset$default = MediaType.charset$default(mediaType, null, 1, null);
                if (charset$default == null) {
                    mediaType = MediaType.INSTANCE.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charset$default;
                }
            }
            byte[] bytes = toRequestBody.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return create(bytes, mediaType, 0, bytes.length);
        }

        @JvmStatic
        @JvmName(name = OperateCustomButton.OPERATE_CREATE)
        @NotNull
        public final RequestBody create(@NotNull final ByteString toRequestBody, @Nullable final MediaType mediaType) {
            Intrinsics.checkNotNullParameter(toRequestBody, "$this$toRequestBody");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return ByteString.this.size();
                }

                @Override // okhttp3.RequestBody
                @Nullable
                /* renamed from: contentType, reason: from getter */
                public MediaType get$contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(@NotNull BufferedSink sink) {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    sink.write(ByteString.this);
                }
            };
        }

        @JvmStatic
        @JvmName(name = OperateCustomButton.OPERATE_CREATE)
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull final byte[] toRequestBody, @Nullable final MediaType mediaType, final int i3, final int i16) {
            Intrinsics.checkNotNullParameter(toRequestBody, "$this$toRequestBody");
            Util.checkOffsetAndCount(toRequestBody.length, i3, i16);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$2
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return i16;
                }

                @Override // okhttp3.RequestBody
                @Nullable
                /* renamed from: contentType, reason: from getter */
                public MediaType get$contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(@NotNull BufferedSink sink) {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    sink.write(toRequestBody, i3, i16);
                }
            };
        }

        @JvmStatic
        @JvmName(name = OperateCustomButton.OPERATE_CREATE)
        @NotNull
        public final RequestBody create(@NotNull final File asRequestBody, @Nullable final MediaType mediaType) {
            Intrinsics.checkNotNullParameter(asRequestBody, "$this$asRequestBody");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return asRequestBody.length();
                }

                @Override // okhttp3.RequestBody
                @Nullable
                /* renamed from: contentType, reason: from getter */
                public MediaType get$contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(@NotNull BufferedSink sink) {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    Source source = Okio.source(asRequestBody);
                    try {
                        sink.writeAll(source);
                        CloseableKt.closeFinally(source, null);
                    } finally {
                    }
                }
            };
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, mediaType);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull ByteString content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, mediaType);
        }

        @JvmStatic
        @NotNull
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmOverloads
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] content, int i3, int i16) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, mediaType, i3, i16);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @ReplaceWith(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
        @JvmStatic
        @NotNull
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return create(file, mediaType);
        }
    }

    @JvmStatic
    @JvmName(name = OperateCustomButton.OPERATE_CREATE)
    @NotNull
    public static final RequestBody create(@NotNull File file, @Nullable MediaType mediaType) {
        return INSTANCE.create(file, mediaType);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    @Nullable
    /* renamed from: contentType */
    public abstract MediaType get$contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(@NotNull BufferedSink sink) throws IOException;

    @JvmStatic
    @JvmName(name = OperateCustomButton.OPERATE_CREATE)
    @NotNull
    public static final RequestBody create(@NotNull String str, @Nullable MediaType mediaType) {
        return INSTANCE.create(str, mediaType);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @ReplaceWith(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
    @JvmStatic
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull File file) {
        return INSTANCE.create(mediaType, file);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull String str) {
        return INSTANCE.create(mediaType, str);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull ByteString byteString) {
        return INSTANCE.create(mediaType, byteString);
    }

    @JvmStatic
    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmOverloads
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] bArr) {
        return Companion.create$default(INSTANCE, mediaType, bArr, 0, 0, 12, (Object) null);
    }

    @JvmStatic
    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmOverloads
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] bArr, int i3) {
        return Companion.create$default(INSTANCE, mediaType, bArr, i3, 0, 8, (Object) null);
    }

    @JvmStatic
    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmOverloads
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] bArr, int i3, int i16) {
        return INSTANCE.create(mediaType, bArr, i3, i16);
    }

    @JvmStatic
    @JvmName(name = OperateCustomButton.OPERATE_CREATE)
    @NotNull
    public static final RequestBody create(@NotNull ByteString byteString, @Nullable MediaType mediaType) {
        return INSTANCE.create(byteString, mediaType);
    }

    @JvmStatic
    @JvmName(name = OperateCustomButton.OPERATE_CREATE)
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] bArr) {
        return Companion.create$default(INSTANCE, bArr, (MediaType) null, 0, 0, 7, (Object) null);
    }

    @JvmStatic
    @JvmName(name = OperateCustomButton.OPERATE_CREATE)
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType) {
        return Companion.create$default(INSTANCE, bArr, mediaType, 0, 0, 6, (Object) null);
    }

    @JvmStatic
    @JvmName(name = OperateCustomButton.OPERATE_CREATE)
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType, int i3) {
        return Companion.create$default(INSTANCE, bArr, mediaType, i3, 0, 4, (Object) null);
    }

    @JvmStatic
    @JvmName(name = OperateCustomButton.OPERATE_CREATE)
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType, int i3, int i16) {
        return INSTANCE.create(bArr, mediaType, i3, i16);
    }
}
