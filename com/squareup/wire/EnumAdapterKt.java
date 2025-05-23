package com.squareup.wire;

import com.squareup.wire.ProtoAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\u0080\b\u00a2\u0006\u0002\u0010\u0007\u001a \u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0006\u001a\u0002H\u0002H\u0080\b\u00a2\u0006\u0002\u0010\n\u001a \u0010\u000b\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0006\u001a\u0002H\u0002H\u0080\b\u00a2\u0006\u0002\u0010\f\u001aC\u0010\r\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0012H\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0014"}, d2 = {"commonEncode", "", "E", "Lcom/squareup/wire/WireEnum;", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "(Lcom/squareup/wire/ProtoWriter;Lcom/squareup/wire/WireEnum;)V", "commonEncodedSize", "", "(Lcom/squareup/wire/WireEnum;)I", "commonRedact", "(Lcom/squareup/wire/WireEnum;)Lcom/squareup/wire/WireEnum;", "commonDecode", "Lcom/squareup/wire/EnumAdapter;", "reader", "Lcom/squareup/wire/ProtoReader;", "fromValue", "Lkotlin/Function1;", "(Lcom/squareup/wire/EnumAdapter;Lcom/squareup/wire/ProtoReader;Lkotlin/jvm/functions/Function1;)Lcom/squareup/wire/WireEnum;", "wire-runtime"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class EnumAdapterKt {
    @NotNull
    public static final <E extends WireEnum> E commonDecode(@NotNull EnumAdapter<E> commonDecode, @NotNull ProtoReader reader, @NotNull Function1<? super Integer, ? extends E> fromValue) {
        Intrinsics.checkNotNullParameter(commonDecode, "$this$commonDecode");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(fromValue, "fromValue");
        int readVarint32 = reader.readVarint32();
        E invoke = fromValue.invoke(Integer.valueOf(readVarint32));
        if (invoke != null) {
            return invoke;
        }
        throw new ProtoAdapter.EnumConstantNotFoundException(readVarint32, commonDecode.getType());
    }

    public static final <E extends WireEnum> void commonEncode(@NotNull ProtoWriter writer, @NotNull E value) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        writer.writeVarint32(value.getValue());
    }

    public static final <E extends WireEnum> int commonEncodedSize(@NotNull E value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return ProtoWriter.INSTANCE.varint32Size$wire_runtime(value.getValue());
    }

    @NotNull
    public static final <E extends WireEnum> E commonRedact(@NotNull E value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new UnsupportedOperationException();
    }
}
