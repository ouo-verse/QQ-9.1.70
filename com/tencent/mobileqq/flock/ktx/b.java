package com.tencent.mobileqq.flock.ktx;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\u0002\u001a\f\u0010\u0005\u001a\u00020\u0004*\u0004\u0018\u00010\u0000\u00a8\u0006\u0006"}, d2 = {"Ljava/util/Date;", "other", "Lcom/tencent/mobileqq/flock/ktx/d;", "a", "", "b", "qq-flock-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b {
    @NotNull
    public static final d a(@NotNull Date date, @NotNull Date other) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return new d(date, other, 0, 4, null);
    }

    public static final long b(@Nullable Date date) {
        if (date == null) {
            return 0L;
        }
        return date.getTime() / 1000;
    }
}
