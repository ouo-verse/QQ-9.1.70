package com.squareup.wire.internal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireEnumConstant;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ActionScope;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\tH\u0016\u00a2\u0006\u0002\u0010\rJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u000fR\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/squareup/wire/internal/EnumJsonFormatter;", "E", "Lcom/squareup/wire/WireEnum;", "Lcom/squareup/wire/internal/JsonFormatter;", "adapter", "Lcom/squareup/wire/EnumAdapter;", "(Lcom/squareup/wire/EnumAdapter;)V", "stringToValue", "", "", "valueToString", "fromString", "value", "(Ljava/lang/String;)Lcom/squareup/wire/WireEnum;", "toStringOrNumber", "(Lcom/squareup/wire/WireEnum;)Ljava/lang/String;", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class EnumJsonFormatter<E extends WireEnum> implements JsonFormatter<E> {
    private final Map<String, E> stringToValue;
    private final Map<E, String> valueToString;

    /* JADX WARN: Multi-variable type inference failed */
    public EnumJsonFormatter(@NotNull EnumAdapter<E> adapter) {
        boolean z16;
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        KClass<?> type = adapter.getType();
        Intrinsics.checkNotNull(type);
        Class javaClass = JvmClassMappingKt.getJavaClass((KClass) type);
        if (javaClass != null) {
            for (ActionScope actionScope : (WireEnum[]) javaClass.getEnumConstants()) {
                if (actionScope != 0) {
                    String name = actionScope.name();
                    linkedHashMap.put(name, actionScope);
                    linkedHashMap.put(String.valueOf(actionScope.getValue()), actionScope);
                    linkedHashMap2.put(actionScope, name);
                    WireEnumConstant wireEnumConstant = (WireEnumConstant) javaClass.getDeclaredField(name).getAnnotation(WireEnumConstant.class);
                    if (wireEnumConstant != null) {
                        if (wireEnumConstant.declaredName().length() > 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            linkedHashMap.put(wireEnumConstant.declaredName(), actionScope);
                            linkedHashMap2.put(actionScope, wireEnumConstant.declaredName());
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Enum<*>");
                }
            }
            this.stringToValue = linkedHashMap;
            this.valueToString = linkedHashMap2;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<E>");
    }

    @Override // com.squareup.wire.internal.JsonFormatter
    @Nullable
    public E fromString(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return this.stringToValue.get(value);
    }

    @Override // com.squareup.wire.internal.JsonFormatter
    @NotNull
    public String toStringOrNumber(@NotNull E value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String str = this.valueToString.get(value);
        Intrinsics.checkNotNull(str);
        return str;
    }
}
