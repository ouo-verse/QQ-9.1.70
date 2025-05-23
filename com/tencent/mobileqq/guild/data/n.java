package com.tencent.mobileqq.guild.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/data/s;", "other", "", "a", "qqguild-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class n {
    public static final boolean a(@NotNull s sVar, @NotNull s other) {
        Intrinsics.checkNotNullParameter(sVar, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(sVar.getGuildId(), other.getGuildId()) && Intrinsics.areEqual(sVar.getChannelId(), other.getChannelId())) {
            return true;
        }
        return false;
    }
}
