package com.squareup.wire.internal;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u00c6\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\b\u001a\u00020\t2\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/squareup/wire/internal/InstantJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "Ljava/time/Instant;", "Lcom/squareup/wire/Instant;", "()V", "fromString", "value", "", "toStringOrNumber", "", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class InstantJsonFormatter implements JsonFormatter<Instant> {
    public static final InstantJsonFormatter INSTANCE = new InstantJsonFormatter();

    InstantJsonFormatter() {
    }

    @Override // com.squareup.wire.internal.JsonFormatter
    @NotNull
    public Instant fromString(@NotNull String value) {
        DateTimeFormatter dateTimeFormatter;
        TemporalAccessor parse;
        Instant from;
        Intrinsics.checkNotNullParameter(value, "value");
        dateTimeFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        parse = dateTimeFormatter.parse(value);
        from = Instant.from(parse);
        Intrinsics.checkNotNullExpressionValue(from, "Instant.from(parsed)");
        return from;
    }

    @Override // com.squareup.wire.internal.JsonFormatter
    @NotNull
    public Object toStringOrNumber(@NotNull Instant value) {
        DateTimeFormatter dateTimeFormatter;
        String format;
        Intrinsics.checkNotNullParameter(value, "value");
        dateTimeFormatter = DateTimeFormatter.ISO_INSTANT;
        format = dateTimeFormatter.format(value);
        Intrinsics.checkNotNullExpressionValue(format, "ISO_INSTANT.format(value)");
        return format;
    }
}
