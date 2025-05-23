package com.squareup.wire;

import com.squareup.wire.OneOf.Key;
import com.squareup.wire.internal.Internal;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\u0010\b\u0000\u0010\u0001 \u0001*\b\u0012\u0004\u0012\u0002H\u00030\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004:\u0001!B\u0015\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\u000e\u001a\u00028\u0000H\u00c6\u0003\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\u000f\u001a\u00028\u0001H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJ.\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u0001H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u00d6\u0003J!\u0010\u001b\u001a\u0004\u0018\u0001H\u001c\"\u0004\b\u0002\u0010\u001c2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u0002\u00a2\u0006\u0002\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u0017H\u00d6\u0001J\b\u0010\u001f\u001a\u00020 H\u0016R\u0013\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u00028\u0001\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\""}, d2 = {"Lcom/squareup/wire/OneOf;", "K", "Lcom/squareup/wire/OneOf$Key;", "T", "", "key", "value", "(Lcom/squareup/wire/OneOf$Key;Ljava/lang/Object;)V", "getKey", "()Lcom/squareup/wire/OneOf$Key;", "Lcom/squareup/wire/OneOf$Key;", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Lcom/squareup/wire/OneOf$Key;Ljava/lang/Object;)Lcom/squareup/wire/OneOf;", "encodeWithTag", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "encodedSizeWithTag", "", "equals", "", "other", "getOrNull", "X", "(Lcom/squareup/wire/OneOf$Key;)Ljava/lang/Object;", "hashCode", "toString", "", "Key", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final /* data */ class OneOf<K extends Key<T>, T> {

    @NotNull
    private final K key;
    private final T value;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b&\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0002\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/squareup/wire/OneOf$Key;", "T", "", "tag", "", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "declaredName", "", "redacted", "", "jsonName", "(ILcom/squareup/wire/ProtoAdapter;Ljava/lang/String;ZLjava/lang/String;)V", "getAdapter", "()Lcom/squareup/wire/ProtoAdapter;", "getDeclaredName", "()Ljava/lang/String;", "getJsonName", "getRedacted", "()Z", "getTag", "()I", "wire-runtime"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static abstract class Key<T> {

        @NotNull
        private final ProtoAdapter<T> adapter;

        @NotNull
        private final String declaredName;

        @NotNull
        private final String jsonName;
        private final boolean redacted;
        private final int tag;

        public Key(int i3, @NotNull ProtoAdapter<T> adapter, @NotNull String declaredName, boolean z16, @NotNull String jsonName) {
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            Intrinsics.checkNotNullParameter(declaredName, "declaredName");
            Intrinsics.checkNotNullParameter(jsonName, "jsonName");
            this.tag = i3;
            this.adapter = adapter;
            this.declaredName = declaredName;
            this.redacted = z16;
            this.jsonName = jsonName;
        }

        @NotNull
        public final ProtoAdapter<T> getAdapter() {
            return this.adapter;
        }

        @NotNull
        public final String getDeclaredName() {
            return this.declaredName;
        }

        @NotNull
        public final String getJsonName() {
            return this.jsonName;
        }

        public final boolean getRedacted() {
            return this.redacted;
        }

        public final int getTag() {
            return this.tag;
        }

        public /* synthetic */ Key(int i3, ProtoAdapter protoAdapter, String str, boolean z16, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, protoAdapter, str, (i16 & 8) != 0 ? false : z16, (i16 & 16) != 0 ? "" : str2);
        }
    }

    public OneOf(@NotNull K key, T t16) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.value = t16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OneOf copy$default(OneOf oneOf, Key key, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            key = oneOf.key;
        }
        if ((i3 & 2) != 0) {
            obj = oneOf.value;
        }
        return oneOf.copy(key, obj);
    }

    @NotNull
    public final K component1() {
        return this.key;
    }

    public final T component2() {
        return this.value;
    }

    @NotNull
    public final OneOf<K, T> copy(@NotNull K key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new OneOf<>(key, value);
    }

    public final void encodeWithTag(@NotNull ProtoWriter writer) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.key.getAdapter().encodeWithTag(writer, this.key.getTag(), this.value);
    }

    public final int encodedSizeWithTag() {
        return this.key.getAdapter().encodedSizeWithTag(this.key.getTag(), this.value);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof OneOf) {
                OneOf oneOf = (OneOf) other;
                if (!Intrinsics.areEqual(this.key, oneOf.key) || !Intrinsics.areEqual(this.value, oneOf.value)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final K getKey() {
        return this.key;
    }

    @Nullable
    public final <X> X getOrNull(@NotNull Key<X> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(this.key, key)) {
            return this.value;
        }
        return null;
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        int i3;
        K k3 = this.key;
        int i16 = 0;
        if (k3 != null) {
            i3 = k3.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        T t16 = this.value;
        if (t16 != null) {
            i16 = t16.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        String sanitize;
        ProtoAdapter<T> adapter = this.key.getAdapter();
        if (Intrinsics.areEqual(adapter, ProtoAdapter.STRING) || Intrinsics.areEqual(adapter, ProtoAdapter.STRING_VALUE)) {
            sanitize = Internal.sanitize(String.valueOf(this.value));
        } else {
            sanitize = String.valueOf(this.value);
        }
        return this.key.getDeclaredName() + '=' + sanitize;
    }
}
