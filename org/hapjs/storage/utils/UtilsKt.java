package org.hapjs.storage.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"checkDataSize", "", "data", "checkExpiredTime", "", "expiredTime", "storage-sdk_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes29.dex */
public final class UtilsKt {
    @NotNull
    public static final String checkDataSize(@NotNull String data) {
        IntRange until;
        String substring;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.length() > 2048) {
            until = RangesKt___RangesKt.until(0, 2047);
            substring = StringsKt__StringsKt.substring(data, until);
            return substring;
        }
        return data;
    }

    public static final long checkExpiredTime(long j3) {
        if (j3 < 43200000) {
            return 43200000L;
        }
        return j3;
    }
}
