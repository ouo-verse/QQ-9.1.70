package com.squareup.wire.internal;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Syntax;
import java.util.Map;
import kotlin.Metadata;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002J/\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0002\u0010\u001dJ\u0015\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0001H&\u00a2\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0001H&\u00a2\u0006\u0002\u0010!J\u0015\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010$J\r\u0010%\u001a\u00028\u0001H&\u00a2\u0006\u0002\u0010&J\u001d\u0010'\u001a\u00020\u00172\u0006\u0010#\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\u0006H&\u00a2\u0006\u0002\u0010)J\u0015\u0010*\u001a\u00020+2\u0006\u0010#\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010,R*\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006-"}, d2 = {"Lcom/squareup/wire/internal/MessageBinding;", "M", "", "B", "fields", "", "", "Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "getFields", "()Ljava/util/Map;", "messageType", "Lkotlin/reflect/KClass;", "getMessageType", "()Lkotlin/reflect/KClass;", "syntax", "Lcom/squareup/wire/Syntax;", "getSyntax", "()Lcom/squareup/wire/Syntax;", "typeUrl", "", "getTypeUrl", "()Ljava/lang/String;", "addUnknownField", "", "builder", "tag", "fieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "value", "(Ljava/lang/Object;ILcom/squareup/wire/FieldEncoding;Ljava/lang/Object;)V", "build", "(Ljava/lang/Object;)Ljava/lang/Object;", "clearUnknownFields", "(Ljava/lang/Object;)V", "getCachedSerializedSize", "message", "(Ljava/lang/Object;)I", "newBuilder", "()Ljava/lang/Object;", "setCachedSerializedSize", "size", "(Ljava/lang/Object;I)V", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Object;)Lokio/ByteString;", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface MessageBinding<M, B> {
    void addUnknownField(@NotNull B builder, int tag, @NotNull FieldEncoding fieldEncoding, @Nullable Object value);

    @NotNull
    M build(@NotNull B builder);

    void clearUnknownFields(@NotNull B builder);

    int getCachedSerializedSize(@NotNull M message);

    @NotNull
    Map<Integer, FieldOrOneOfBinding<M, B>> getFields();

    @NotNull
    KClass<? super M> getMessageType();

    @NotNull
    Syntax getSyntax();

    @Nullable
    String getTypeUrl();

    @NotNull
    B newBuilder();

    void setCachedSerializedSize(@NotNull M message, int size);

    @NotNull
    ByteString unknownFields(@NotNull M message);
}
