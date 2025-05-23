package com.squareup.wire;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\b*\n\u0010\u0006\"\u00020\u00012\u00020\u0001\u00a8\u0006\u0007"}, d2 = {"durationOfSeconds", "Ljava/time/Duration;", "Lcom/squareup/wire/Duration;", "seconds", "", "nano", "Duration", "wire-runtime"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class DurationKt {
    @NotNull
    public static final Duration durationOfSeconds(long j3, long j16) {
        Duration ofSeconds;
        ofSeconds = Duration.ofSeconds(j3, j16);
        Intrinsics.checkNotNullExpressionValue(ofSeconds, "Duration.ofSeconds(seconds, nano)");
        return ofSeconds;
    }
}
