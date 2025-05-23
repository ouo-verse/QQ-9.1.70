package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f\u001a,\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\b0\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f\"'\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u000f"}, d2 = {"identityOrNull", "E", "Lcom/squareup/wire/WireEnum;", "Ljava/lang/Class;", "getIdentityOrNull", "(Ljava/lang/Class;)Lcom/squareup/wire/WireEnum;", "redactElements", "", "T", "list", "Ljava/util/List;", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "map", "Ljava/util/Map;", "wire-runtime"}, k = 5, mv = {1, 4, 0}, xs = "com/squareup/wire/internal/Internal")
/* loaded from: classes3.dex */
public final /* synthetic */ class Internal__InternalJvmKt {
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
    
        return r3;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E extends WireEnum> E getIdentityOrNull(@NotNull Class<E> identityOrNull) {
        E e16;
        boolean z16;
        Intrinsics.checkNotNullParameter(identityOrNull, "$this$identityOrNull");
        E[] enumConstants = identityOrNull.getEnumConstants();
        Intrinsics.checkNotNullExpressionValue(enumConstants, "enumConstants");
        int length = enumConstants.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                e16 = enumConstants[i3];
                E e17 = e16;
                if (e17 != null) {
                    if (e17.getValue() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                    i3++;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.squareup.wire.WireEnum");
                }
            } else {
                e16 = null;
                break;
            }
        }
    }

    public static final <T> void redactElements(@NotNull List<T> list, @NotNull ProtoAdapter<T> adapter) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            list.set(i3, adapter.redact(list.get(i3)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void redactElements(@NotNull Map<?, T> map, @NotNull ProtoAdapter<T> adapter) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        for (Map.Entry entry : map.entrySet()) {
            entry.setValue(adapter.redact(entry.getValue()));
        }
    }
}
