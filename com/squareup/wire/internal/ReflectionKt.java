package com.squareup.wire.internal;

import com.squareup.wire.Message;
import com.squareup.wire.OneOf;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aL\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\"\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a^\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\"\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b\u001aH\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\"\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0002\u001aF\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000e\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\"\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u00a8\u0006\u0012"}, d2 = {"createRuntimeMessageAdapter", "Lcom/squareup/wire/internal/RuntimeMessageAdapter;", "M", "B", "Lcom/squareup/wire/Message;", "Lcom/squareup/wire/Message$Builder;", "messageType", "Ljava/lang/Class;", "typeUrl", "", "syntax", "Lcom/squareup/wire/Syntax;", "getBuilderType", "getKeys", "", "Lcom/squareup/wire/OneOf$Key;", "messageField", "Ljava/lang/reflect/Field;", "wire-runtime"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class ReflectionKt {
    @NotNull
    public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> createRuntimeMessageAdapter(@NotNull Class<M> messageType, @Nullable String str, @NotNull Syntax syntax) {
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        Intrinsics.checkNotNullParameter(syntax, "syntax");
        Class builderType = getBuilderType(messageType);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Field messageField : messageType.getDeclaredFields()) {
            WireField wireField = (WireField) messageField.getAnnotation(WireField.class);
            if (wireField != null) {
                Integer valueOf = Integer.valueOf(wireField.tag());
                Intrinsics.checkNotNullExpressionValue(messageField, "messageField");
                linkedHashMap.put(valueOf, new FieldBinding(wireField, messageField, builderType));
            } else {
                Intrinsics.checkNotNullExpressionValue(messageField, "messageField");
                if (Intrinsics.areEqual(messageField.getType(), OneOf.class)) {
                    for (OneOf.Key<?> key : getKeys(messageField)) {
                        linkedHashMap.put(Integer.valueOf(key.getTag()), new OneOfBinding(messageField, builderType, key));
                    }
                }
            }
        }
        KClass kotlinClass = JvmClassMappingKt.getKotlinClass(messageType);
        Map unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "Collections.unmodifiableMap(fields)");
        return new RuntimeMessageAdapter<>(new RuntimeMessageBinding(kotlinClass, builderType, unmodifiableMap, str, syntax));
    }

    private static final <M extends Message<M, B>, B extends Message.Builder<M, B>> Class<B> getBuilderType(Class<M> cls) {
        try {
            return (Class<B>) Class.forName(cls.getName() + "$Builder");
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
        }
    }

    private static final <M extends Message<M, B>, B extends Message.Builder<M, B>> Set<OneOf.Key<?>> getKeys(Field field) {
        Class<?> declaringClass = field.getDeclaringClass();
        String name = field.getName();
        Intrinsics.checkNotNullExpressionValue(name, "messageField.name");
        Field keysField = declaringClass.getDeclaredField(Internal.boxedOneOfKeysFieldName(name));
        Intrinsics.checkNotNullExpressionValue(keysField, "keysField");
        keysField.setAccessible(true);
        Object obj = keysField.get(null);
        if (obj != null) {
            return (Set) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<com.squareup.wire.OneOf.Key<*>>");
    }

    @NotNull
    public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> createRuntimeMessageAdapter(@NotNull Class<M> messageType) {
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        ProtoAdapter protoAdapter = ProtoAdapter.INSTANCE.get(messageType);
        return createRuntimeMessageAdapter(messageType, protoAdapter.getTypeUrl(), protoAdapter.getSyntax());
    }
}
