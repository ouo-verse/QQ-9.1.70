package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u0000 $*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0000*\u0014\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004:\u0002#$B\u001d\b\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0013\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0013\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\bJ\r\u0010\u001b\u001a\u00028\u0001H&\u00a2\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u000b\u0010\u001f\u001a\u00028\u0000\u00a2\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\"H\u0004R\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\f8\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u00020\b8G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012\u00a8\u0006%"}, d2 = {"Lcom/squareup/wire/Message;", "M", "B", "Lcom/squareup/wire/Message$Builder;", "Ljava/io/Serializable;", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "unknownFields", "Lokio/ByteString;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/ByteString;)V", "()Lcom/squareup/wire/ProtoAdapter;", "cachedSerializedSize", "", "getCachedSerializedSize$wire_runtime", "()I", "setCachedSerializedSize$wire_runtime", "(I)V", "hashCode", "()Lokio/ByteString;", "encode", "", "", "stream", "Ljava/io/OutputStream;", "sink", "Lokio/BufferedSink;", "encodeByteString", "newBuilder", "()Lcom/squareup/wire/Message$Builder;", "toString", "", "withoutUnknownFields", "()Lcom/squareup/wire/Message;", "writeReplace", "", "Builder", "Companion", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public abstract class Message<M extends Message<M, B>, B extends Builder<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;

    @NotNull
    private final transient ProtoAdapter<M> adapter;
    private transient int cachedSerializedSize;

    @JvmField
    protected transient int hashCode;

    @NotNull
    private final transient ByteString unknownFields;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\u0014\b\u0002\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0003\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00002\u00020\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0005J,\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u0006\u0010\u001f\u001a\u00020\rJ\r\u0010 \u001a\u00028\u0002H&\u00a2\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\rJ\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0000J\b\u0010$\u001a\u00020%H\u0002R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006&"}, d2 = {"Lcom/squareup/wire/Message$Builder;", "M", "Lcom/squareup/wire/Message;", "B", "", "()V", "unknownFieldsBuffer", "Lokio/Buffer;", "getUnknownFieldsBuffer$wire_runtime", "()Lokio/Buffer;", "setUnknownFieldsBuffer$wire_runtime", "(Lokio/Buffer;)V", "unknownFieldsByteString", "Lokio/ByteString;", "getUnknownFieldsByteString$wire_runtime", "()Lokio/ByteString;", "setUnknownFieldsByteString$wire_runtime", "(Lokio/ByteString;)V", "unknownFieldsWriter", "Lcom/squareup/wire/ProtoWriter;", "getUnknownFieldsWriter$wire_runtime", "()Lcom/squareup/wire/ProtoWriter;", "setUnknownFieldsWriter$wire_runtime", "(Lcom/squareup/wire/ProtoWriter;)V", "addUnknownField", "tag", "", "fieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "value", "addUnknownFields", "unknownFields", "build", "()Lcom/squareup/wire/Message;", "buildUnknownFields", "clearUnknownFields", "prepareForNewUnknownFields", "", "wire-runtime"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static abstract class Builder<M extends Message<M, B>, B extends Builder<M, B>> {

        @Nullable
        private transient Buffer unknownFieldsBuffer;

        @NotNull
        private transient ByteString unknownFieldsByteString = ByteString.EMPTY;

        @Nullable
        private transient ProtoWriter unknownFieldsWriter;

        private final void prepareForNewUnknownFields() {
            if (this.unknownFieldsBuffer == null) {
                this.unknownFieldsBuffer = new Buffer();
                Buffer buffer = this.unknownFieldsBuffer;
                Intrinsics.checkNotNull(buffer);
                ProtoWriter protoWriter = new ProtoWriter(buffer);
                this.unknownFieldsWriter = protoWriter;
                Intrinsics.checkNotNull(protoWriter);
                protoWriter.writeBytes(this.unknownFieldsByteString);
                this.unknownFieldsByteString = ByteString.EMPTY;
            }
        }

        @NotNull
        public final Builder<M, B> addUnknownField(int tag, @NotNull FieldEncoding fieldEncoding, @Nullable Object value) {
            Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
            prepareForNewUnknownFields();
            ProtoAdapter<?> rawProtoAdapter = fieldEncoding.rawProtoAdapter();
            if (rawProtoAdapter != null) {
                ProtoWriter protoWriter = this.unknownFieldsWriter;
                Intrinsics.checkNotNull(protoWriter);
                rawProtoAdapter.encodeWithTag(protoWriter, tag, value);
                return this;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
        }

        @NotNull
        public final Builder<M, B> addUnknownFields(@NotNull ByteString unknownFields) {
            Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
            if (unknownFields.size() > 0) {
                prepareForNewUnknownFields();
                ProtoWriter protoWriter = this.unknownFieldsWriter;
                Intrinsics.checkNotNull(protoWriter);
                protoWriter.writeBytes(unknownFields);
            }
            return this;
        }

        @NotNull
        public abstract M build();

        @NotNull
        public final ByteString buildUnknownFields() {
            Buffer buffer = this.unknownFieldsBuffer;
            if (buffer != null) {
                Intrinsics.checkNotNull(buffer);
                this.unknownFieldsByteString = buffer.readByteString();
                this.unknownFieldsBuffer = null;
                this.unknownFieldsWriter = null;
            }
            return this.unknownFieldsByteString;
        }

        @NotNull
        public final Builder<M, B> clearUnknownFields() {
            this.unknownFieldsByteString = ByteString.EMPTY;
            Buffer buffer = this.unknownFieldsBuffer;
            if (buffer != null) {
                Intrinsics.checkNotNull(buffer);
                buffer.clear();
                this.unknownFieldsBuffer = null;
            }
            this.unknownFieldsWriter = null;
            return this;
        }

        @Nullable
        /* renamed from: getUnknownFieldsBuffer$wire_runtime, reason: from getter */
        public final Buffer getUnknownFieldsBuffer() {
            return this.unknownFieldsBuffer;
        }

        @NotNull
        /* renamed from: getUnknownFieldsByteString$wire_runtime, reason: from getter */
        public final ByteString getUnknownFieldsByteString() {
            return this.unknownFieldsByteString;
        }

        @Nullable
        /* renamed from: getUnknownFieldsWriter$wire_runtime, reason: from getter */
        public final ProtoWriter getUnknownFieldsWriter() {
            return this.unknownFieldsWriter;
        }

        public final void setUnknownFieldsBuffer$wire_runtime(@Nullable Buffer buffer) {
            this.unknownFieldsBuffer = buffer;
        }

        public final void setUnknownFieldsByteString$wire_runtime(@NotNull ByteString byteString) {
            Intrinsics.checkNotNullParameter(byteString, "<set-?>");
            this.unknownFieldsByteString = byteString;
        }

        public final void setUnknownFieldsWriter$wire_runtime(@Nullable ProtoWriter protoWriter) {
            this.unknownFieldsWriter = protoWriter;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Message(@NotNull ProtoAdapter<M> adapter, @NotNull ByteString unknownFields) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.adapter = adapter;
        this.unknownFields = unknownFields;
    }

    @JvmName(name = "adapter")
    @NotNull
    public final ProtoAdapter<M> adapter() {
        return this.adapter;
    }

    public final void encode(@NotNull BufferedSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.adapter.encode(sink, (BufferedSink) this);
    }

    @NotNull
    public final ByteString encodeByteString() {
        return this.adapter.encodeByteString(this);
    }

    /* renamed from: getCachedSerializedSize$wire_runtime, reason: from getter */
    public final int getCachedSerializedSize() {
        return this.cachedSerializedSize;
    }

    @NotNull
    public abstract B newBuilder();

    public final void setCachedSerializedSize$wire_runtime(int i3) {
        this.cachedSerializedSize = i3;
    }

    @NotNull
    public String toString() {
        return this.adapter.toString(this);
    }

    @JvmName(name = "unknownFields")
    @NotNull
    public final ByteString unknownFields() {
        ByteString byteString = this.unknownFields;
        if (byteString == null) {
            return ByteString.EMPTY;
        }
        return byteString;
    }

    @NotNull
    public final M withoutUnknownFields() {
        return newBuilder().clearUnknownFields().build();
    }

    @NotNull
    protected final Object writeReplace() throws ObjectStreamException {
        return new MessageSerializedForm(encode(), getClass());
    }

    @NotNull
    public final byte[] encode() {
        return this.adapter.encode(this);
    }

    public final void encode(@NotNull OutputStream stream) throws IOException {
        Intrinsics.checkNotNullParameter(stream, "stream");
        this.adapter.encode(stream, (OutputStream) this);
    }
}
