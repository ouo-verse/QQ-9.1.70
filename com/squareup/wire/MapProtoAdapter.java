package com.squareup.wire;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B#\b\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J.\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016J\u001c\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J&\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016J(\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/squareup/wire/MapProtoAdapter;", "K", "V", "Lcom/squareup/wire/ProtoAdapter;", "", "keyAdapter", "valueAdapter", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ProtoAdapter;)V", "entryAdapter", "Lcom/squareup/wire/MapEntryProtoAdapter;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodeWithTag", "tag", "", "encodedSize", "encodedSizeWithTag", "redact", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class MapProtoAdapter<K, V> extends ProtoAdapter<Map<K, ? extends V>> {
    private final MapEntryProtoAdapter<K, V> entryAdapter;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MapProtoAdapter(@NotNull ProtoAdapter<K> keyAdapter, @NotNull ProtoAdapter<V> valueAdapter) {
        super(r2, (KClass<?>) r3, (String) null, r5, r6);
        Map emptyMap;
        Intrinsics.checkNotNullParameter(keyAdapter, "keyAdapter");
        Intrinsics.checkNotNullParameter(valueAdapter, "valueAdapter");
        FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Map.class);
        Syntax syntax = valueAdapter.getSyntax();
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.entryAdapter = new MapEntryProtoAdapter<>(keyAdapter, valueAdapter);
    }

    @Override // com.squareup.wire.ProtoAdapter
    @NotNull
    public Map<K, V> decode(@NotNull ProtoReader reader) throws IOException {
        Map<K, V> mapOf;
        Intrinsics.checkNotNullParameter(reader, "reader");
        long beginMessage = reader.beginMessage();
        K k3 = null;
        V v3 = null;
        while (true) {
            int nextTag = reader.nextTag();
            if (nextTag == -1) {
                break;
            }
            if (nextTag == 1) {
                k3 = this.entryAdapter.getKeyAdapter$wire_runtime().decode(reader);
            } else if (nextTag == 2) {
                v3 = this.entryAdapter.getValueAdapter$wire_runtime().decode(reader);
            }
        }
        reader.endMessageAndGetUnknownFields(beginMessage);
        if (!(k3 != null)) {
            throw new IllegalStateException("Map entry with null key".toString());
        }
        if (v3 != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(k3, v3));
            return mapOf;
        }
        throw new IllegalStateException("Map entry with null value".toString());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(@NotNull ProtoWriter writer, @NotNull Map<K, ? extends V> value) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encodeWithTag(@NotNull ProtoWriter writer, int tag, @Nullable Map<K, ? extends V> value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value == null) {
            return;
        }
        Iterator<Map.Entry<K, ? extends V>> it = value.entrySet().iterator();
        while (it.hasNext()) {
            this.entryAdapter.encodeWithTag(writer, tag, it.next());
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSize(@NotNull Map<K, ? extends V> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSizeWithTag(int tag, @Nullable Map<K, ? extends V> value) {
        int i3 = 0;
        if (value == null) {
            return 0;
        }
        Iterator<Map.Entry<K, ? extends V>> it = value.entrySet().iterator();
        while (it.hasNext()) {
            i3 += this.entryAdapter.encodedSizeWithTag(tag, it.next());
        }
        return i3;
    }

    @Override // com.squareup.wire.ProtoAdapter
    @NotNull
    public Map<K, V> redact(@NotNull Map<K, ? extends V> value) {
        Map<K, V> emptyMap;
        Intrinsics.checkNotNullParameter(value, "value");
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }
}
