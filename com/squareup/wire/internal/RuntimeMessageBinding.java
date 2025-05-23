package com.squareup.wire.internal;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.Syntax;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005BS\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r0\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J/\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u00012\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016\u00a2\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010'J\u0015\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010*J\r\u0010+\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010,J\u001d\u0010-\u001a\u00020\u001c2\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00020\fH\u0016\u00a2\u0006\u0002\u0010/J\u0015\u00100\u001a\u0002012\u0006\u0010)\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00102R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r0\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u00063"}, d2 = {"Lcom/squareup/wire/internal/RuntimeMessageBinding;", "M", "Lcom/squareup/wire/Message;", "B", "Lcom/squareup/wire/Message$Builder;", "Lcom/squareup/wire/internal/MessageBinding;", "messageType", "Lkotlin/reflect/KClass;", "builderType", "Ljava/lang/Class;", "fields", "", "", "Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "typeUrl", "", "syntax", "Lcom/squareup/wire/Syntax;", "(Lkotlin/reflect/KClass;Ljava/lang/Class;Ljava/util/Map;Ljava/lang/String;Lcom/squareup/wire/Syntax;)V", "getFields", "()Ljava/util/Map;", "getMessageType", "()Lkotlin/reflect/KClass;", "getSyntax", "()Lcom/squareup/wire/Syntax;", "getTypeUrl", "()Ljava/lang/String;", "addUnknownField", "", "builder", "tag", "fieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "value", "", "(Lcom/squareup/wire/Message$Builder;ILcom/squareup/wire/FieldEncoding;Ljava/lang/Object;)V", "build", "(Lcom/squareup/wire/Message$Builder;)Lcom/squareup/wire/Message;", "clearUnknownFields", "(Lcom/squareup/wire/Message$Builder;)V", "getCachedSerializedSize", "message", "(Lcom/squareup/wire/Message;)I", "newBuilder", "()Lcom/squareup/wire/Message$Builder;", "setCachedSerializedSize", "size", "(Lcom/squareup/wire/Message;I)V", "unknownFields", "Lokio/ByteString;", "(Lcom/squareup/wire/Message;)Lokio/ByteString;", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class RuntimeMessageBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> implements MessageBinding<M, B> {
    private final Class<B> builderType;

    @NotNull
    private final Map<Integer, FieldOrOneOfBinding<M, B>> fields;

    @NotNull
    private final KClass<M> messageType;

    @NotNull
    private final Syntax syntax;

    @Nullable
    private final String typeUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public RuntimeMessageBinding(@NotNull KClass<M> messageType, @NotNull Class<B> builderType, @NotNull Map<Integer, ? extends FieldOrOneOfBinding<M, B>> fields, @Nullable String str, @NotNull Syntax syntax) {
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        Intrinsics.checkNotNullParameter(builderType, "builderType");
        Intrinsics.checkNotNullParameter(fields, "fields");
        Intrinsics.checkNotNullParameter(syntax, "syntax");
        this.messageType = messageType;
        this.builderType = builderType;
        this.fields = fields;
        this.typeUrl = str;
        this.syntax = syntax;
    }

    @Override // com.squareup.wire.internal.MessageBinding
    @NotNull
    public Map<Integer, FieldOrOneOfBinding<M, B>> getFields() {
        return this.fields;
    }

    @Override // com.squareup.wire.internal.MessageBinding
    @NotNull
    public KClass<M> getMessageType() {
        return this.messageType;
    }

    @Override // com.squareup.wire.internal.MessageBinding
    @NotNull
    public Syntax getSyntax() {
        return this.syntax;
    }

    @Override // com.squareup.wire.internal.MessageBinding
    @Nullable
    public String getTypeUrl() {
        return this.typeUrl;
    }

    @Override // com.squareup.wire.internal.MessageBinding
    public void addUnknownField(@NotNull B builder, int tag, @NotNull FieldEncoding fieldEncoding, @Nullable Object value) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
        builder.addUnknownField(tag, fieldEncoding, value);
    }

    @Override // com.squareup.wire.internal.MessageBinding
    @NotNull
    public M build(@NotNull B builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return (M) builder.build();
    }

    @Override // com.squareup.wire.internal.MessageBinding
    public void clearUnknownFields(@NotNull B builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.clearUnknownFields();
    }

    @Override // com.squareup.wire.internal.MessageBinding
    public int getCachedSerializedSize(@NotNull M message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return message.getCachedSerializedSize();
    }

    @Override // com.squareup.wire.internal.MessageBinding
    @NotNull
    public B newBuilder() {
        B newInstance = this.builderType.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "builderType.newInstance()");
        return newInstance;
    }

    @Override // com.squareup.wire.internal.MessageBinding
    public void setCachedSerializedSize(@NotNull M message, int size) {
        Intrinsics.checkNotNullParameter(message, "message");
        message.setCachedSerializedSize$wire_runtime(size);
    }

    @Override // com.squareup.wire.internal.MessageBinding
    @NotNull
    public ByteString unknownFields(@NotNull M message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return message.unknownFields();
    }
}
