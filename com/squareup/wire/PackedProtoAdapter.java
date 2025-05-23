package com.squareup.wire;

import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J(\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J\u0016\u0010\u0011\u001a\u00020\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J \u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/squareup/wire/PackedProtoAdapter;", "E", "Lcom/squareup/wire/ProtoAdapter;", "", "originalAdapter", "(Lcom/squareup/wire/ProtoAdapter;)V", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodeWithTag", "tag", "", "encodedSize", "encodedSizeWithTag", "redact", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class PackedProtoAdapter<E> extends ProtoAdapter<List<? extends E>> {
    private final ProtoAdapter<E> originalAdapter;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PackedProtoAdapter(@NotNull ProtoAdapter<E> originalAdapter) {
        super(r2, (KClass<?>) r3, (String) null, r5, r6);
        List emptyList;
        Intrinsics.checkNotNullParameter(originalAdapter, "originalAdapter");
        FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(List.class);
        Syntax syntax = originalAdapter.getSyntax();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.originalAdapter = originalAdapter;
    }

    @Override // com.squareup.wire.ProtoAdapter
    @NotNull
    public List<E> decode(@NotNull ProtoReader reader) throws IOException {
        List<E> listOf;
        Intrinsics.checkNotNullParameter(reader, "reader");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(this.originalAdapter.decode(reader));
        return listOf;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(@NotNull ProtoWriter writer, @NotNull List<? extends E> value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        int size = value.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.originalAdapter.encode(writer, (ProtoWriter) value.get(i3));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.ProtoAdapter
    public void encodeWithTag(@NotNull ProtoWriter writer, int tag, @Nullable List<? extends E> value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value == 0 || !(!value.isEmpty())) {
            return;
        }
        super.encodeWithTag(writer, tag, (int) value);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSize(@NotNull List<? extends E> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        int size = value.size();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            i3 += this.originalAdapter.encodedSize(value.get(i16));
        }
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSizeWithTag(int tag, @Nullable List<? extends E> value) {
        if (value == 0 || value.isEmpty()) {
            return 0;
        }
        return super.encodedSizeWithTag(tag, (int) value);
    }

    @Override // com.squareup.wire.ProtoAdapter
    @NotNull
    public List<E> redact(@NotNull List<? extends E> value) {
        List<E> emptyList;
        Intrinsics.checkNotNullParameter(value, "value");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }
}
