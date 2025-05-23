package com.squareup.wire.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a2\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/squareup/wire/internal/JsonFormatter;", "W", "", "fromString", "value", "", "(Ljava/lang/String;)Ljava/lang/Object;", "toStringOrNumber", "(Ljava/lang/Object;)Ljava/lang/Object;", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface JsonFormatter<W> {
    @Nullable
    W fromString(@NotNull String value);

    @NotNull
    Object toStringOrNumber(@NotNull W value);
}
