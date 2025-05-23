package com.squareup.wire.internal;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.OneOf;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B)\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b\u00a2\u0006\u0002\u0010\fJ\u0018\u0010-\u001a\u0004\u0018\u00010$2\u0006\u0010.\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010/J\u0017\u00100\u001a\u0004\u0018\u00010$2\u0006\u00101\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u00102J\u001f\u00103\u001a\u0002042\u0006\u00101\u001a\u00028\u00012\b\u00105\u001a\u0004\u0018\u00010$H\u0016\u00a2\u0006\u0002\u00106J\u001d\u00105\u001a\u0002042\u0006\u00101\u001a\u00028\u00012\u0006\u00105\u001a\u00020$H\u0016\u00a2\u0006\u0002\u00106R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014R\u0012\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011R\u0014\u0010 \u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0014R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010\u0011\u00a8\u00067"}, d2 = {"Lcom/squareup/wire/internal/OneOfBinding;", "M", "Lcom/squareup/wire/Message;", "B", "Lcom/squareup/wire/Message$Builder;", "Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "messageField", "Ljava/lang/reflect/Field;", "builderType", "Ljava/lang/Class;", "key", "Lcom/squareup/wire/OneOf$Key;", "(Ljava/lang/reflect/Field;Ljava/lang/Class;Lcom/squareup/wire/OneOf$Key;)V", "builderField", "declaredName", "", "getDeclaredName", "()Ljava/lang/String;", "isMap", "", "()Z", "isMessage", "keyAdapter", "", "getKeyAdapter", "()Ljava/lang/Void;", "label", "Lcom/squareup/wire/WireField$Label;", "getLabel", "()Lcom/squareup/wire/WireField$Label;", "name", "getName", "redacted", "getRedacted", "singleAdapter", "Lcom/squareup/wire/ProtoAdapter;", "", "getSingleAdapter", "()Lcom/squareup/wire/ProtoAdapter;", "tag", "", "getTag", "()I", "wireFieldJsonName", "getWireFieldJsonName", "get", "message", "(Lcom/squareup/wire/Message;)Ljava/lang/Object;", "getFromBuilder", "builder", "(Lcom/squareup/wire/Message$Builder;)Ljava/lang/Object;", "set", "", "value", "(Lcom/squareup/wire/Message$Builder;Ljava/lang/Object;)V", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class OneOfBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> extends FieldOrOneOfBinding<M, B> {
    private final Field builderField;
    private final OneOf.Key<?> key;
    private final Field messageField;

    public OneOfBinding(@NotNull Field messageField, @NotNull Class<B> builderType, @NotNull OneOf.Key<?> key) {
        Intrinsics.checkNotNullParameter(messageField, "messageField");
        Intrinsics.checkNotNullParameter(builderType, "builderType");
        Intrinsics.checkNotNullParameter(key, "key");
        this.messageField = messageField;
        this.key = key;
        Field declaredField = builderType.getDeclaredField(messageField.getName());
        Intrinsics.checkNotNullExpressionValue(declaredField, "builderType.getDeclaredField(messageField.name)");
        this.builderField = declaredField;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    @NotNull
    public String getDeclaredName() {
        return this.key.getDeclaredName();
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public /* bridge */ /* synthetic */ ProtoAdapter getKeyAdapter() {
        return (ProtoAdapter) m91getKeyAdapter();
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    @NotNull
    public WireField.Label getLabel() {
        return WireField.Label.OPTIONAL;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    @NotNull
    public String getName() {
        return this.key.getDeclaredName();
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean getRedacted() {
        return this.key.getRedacted();
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    @NotNull
    public ProtoAdapter<Object> getSingleAdapter() {
        ProtoAdapter<?> adapter = this.key.getAdapter();
        if (adapter != null) {
            return adapter;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public int getTag() {
        return this.key.getTag();
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    @NotNull
    public String getWireFieldJsonName() {
        return this.key.getJsonName();
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean isMap() {
        return false;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean isMessage() {
        Class cls;
        KClass<?> type = getSingleAdapter().getType();
        if (type != null) {
            cls = JvmClassMappingKt.getJavaObjectType(type);
        } else {
            cls = null;
        }
        return Message.class.isAssignableFrom(cls);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    @Nullable
    public Object get(@NotNull M message) {
        Intrinsics.checkNotNullParameter(message, "message");
        OneOf oneOf = (OneOf) this.messageField.get(message);
        if (oneOf != null) {
            return oneOf.getOrNull(this.key);
        }
        return null;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    @Nullable
    public Object getFromBuilder(@NotNull B builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        OneOf oneOf = (OneOf) this.builderField.get(builder);
        if (oneOf != null) {
            return oneOf.getOrNull(this.key);
        }
        return null;
    }

    @NotNull
    /* renamed from: getKeyAdapter, reason: collision with other method in class */
    public Void m91getKeyAdapter() {
        throw new IllegalStateException("not a map".toString());
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public void set(@NotNull B builder, @Nullable Object value) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Field field = this.builderField;
        OneOf.Key<?> key = this.key;
        if (key == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.squareup.wire.OneOf.Key<kotlin.Any>");
        }
        Intrinsics.checkNotNull(value);
        field.set(builder, new OneOf(key, value));
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public void value(@NotNull B builder, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(value, "value");
        set((OneOfBinding<M, B>) builder, value);
    }
}
