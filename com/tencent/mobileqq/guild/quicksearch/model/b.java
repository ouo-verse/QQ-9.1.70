package com.tencent.mobileqq.guild.quicksearch.model;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/model/GuildSearchActionSource;", "", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {
    public static final boolean a(@NotNull GuildSearchActionSource guildSearchActionSource) {
        Set of5;
        Intrinsics.checkNotNullParameter(guildSearchActionSource, "<this>");
        of5 = SetsKt__SetsKt.setOf((Object[]) new GuildSearchActionSource[]{GuildSearchActionSource.DEFAULT, GuildSearchActionSource.SOFT_KEYBOARD, GuildSearchActionSource.HISTORY_BOARD});
        return of5.contains(guildSearchActionSource);
    }
}
