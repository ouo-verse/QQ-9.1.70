package com.squareup.wire;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\tB\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0002\u0010\nB\u001d\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u000bB\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u00a2\u0006\u0002\u0010\rB\u001d\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u000eB'\b\u0004\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0015\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0016\u00a2\u0006\u0002\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u001cJ\u0017\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0018\u001a\u00020\u001bH$\u00a2\u0006\u0002\u0010\u001eJ\u0015\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010 \u00a8\u0006!"}, d2 = {"Lcom/squareup/wire/EnumAdapter;", "E", "Lcom/squareup/wire/WireEnum;", "Lcom/squareup/wire/ProtoAdapter;", "type", "Ljava/lang/Class;", "syntax", "Lcom/squareup/wire/Syntax;", "identity", "(Ljava/lang/Class;Lcom/squareup/wire/Syntax;Lcom/squareup/wire/WireEnum;)V", "(Ljava/lang/Class;)V", "(Ljava/lang/Class;Lcom/squareup/wire/Syntax;)V", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)V", "(Lkotlin/reflect/KClass;Lcom/squareup/wire/Syntax;)V", "(Lkotlin/reflect/KClass;Lcom/squareup/wire/Syntax;Lcom/squareup/wire/WireEnum;)V", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "(Lcom/squareup/wire/ProtoReader;)Lcom/squareup/wire/WireEnum;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "(Lcom/squareup/wire/ProtoWriter;Lcom/squareup/wire/WireEnum;)V", "encodedSize", "", "(Lcom/squareup/wire/WireEnum;)I", "fromValue", "(I)Lcom/squareup/wire/WireEnum;", "redact", "(Lcom/squareup/wire/WireEnum;)Lcom/squareup/wire/WireEnum;", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public abstract class EnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(@NotNull KClass<E> type, @NotNull Syntax syntax, @Nullable E e16) {
        super(FieldEncoding.VARINT, (KClass<?>) type, (String) null, syntax, e16);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(syntax, "syntax");
    }

    @Nullable
    protected abstract E fromValue(int value);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(@NotNull Class<E> type, @NotNull Syntax syntax, @Nullable E e16) {
        this(JvmClassMappingKt.getKotlinClass(type), syntax, e16);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(syntax, "syntax");
    }

    @Override // com.squareup.wire.ProtoAdapter
    @NotNull
    public E decode(@NotNull ProtoReader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        int readVarint32 = reader.readVarint32();
        E fromValue = fromValue(readVarint32);
        if (fromValue != null) {
            return fromValue;
        }
        throw new ProtoAdapter.EnumConstantNotFoundException(readVarint32, getType());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(@NotNull ProtoWriter writer, @NotNull E value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        writer.writeVarint32(value.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSize(@NotNull E value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return ProtoWriter.INSTANCE.varint32Size$wire_runtime(value.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    @NotNull
    public E redact(@NotNull E value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(@NotNull Class<E> type) {
        this((KClass<WireEnum>) JvmClassMappingKt.getKotlinClass(type), Syntax.PROTO_2, Internal.getIdentityOrNull(type));
        Intrinsics.checkNotNullParameter(type, "type");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(@NotNull Class<E> type, @NotNull Syntax syntax) {
        this((KClass<WireEnum>) JvmClassMappingKt.getKotlinClass(type), syntax, Internal.getIdentityOrNull(type));
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(syntax, "syntax");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(@NotNull KClass<E> type) {
        this(type, Syntax.PROTO_2, Internal.getIdentityOrNull(JvmClassMappingKt.getJavaClass((KClass) type)));
        Intrinsics.checkNotNullParameter(type, "type");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(@NotNull KClass<E> type, @NotNull Syntax syntax) {
        this(type, syntax, Internal.getIdentityOrNull(JvmClassMappingKt.getJavaClass((KClass) type)));
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(syntax, "syntax");
    }
}
