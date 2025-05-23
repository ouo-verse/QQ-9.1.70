package com.tencent.guild.aio.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0005\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u00a8\u0006\u0006"}, d2 = {"", "", "tag", "", "a", "b", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class n {
    public static final void a(@Nullable Object obj, @NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        new m().d(tag, String.valueOf(obj));
    }

    public static final void b(@Nullable Object obj, @NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        new m().i(tag, String.valueOf(obj));
    }
}
