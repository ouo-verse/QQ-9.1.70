package com.tencent.qqnt.troopmemberlist;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0016\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"", "groupUin", "memberUin", "a", "qqtroop-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {
    @NotNull
    public static final String a(@NotNull String groupUin, @NotNull String memberUin) {
        Intrinsics.checkNotNullParameter(groupUin, "groupUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        return groupUin + " - " + memberUin;
    }
}
