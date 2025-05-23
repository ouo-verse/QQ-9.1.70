package com.tencent.qqnt.chats.core.adapter.itemdata;

import com.tencent.qqnt.kernel.nativeinterface.GuildContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "", "a", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;)Z", "hasGuildDraft", "chats_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class h {
    public static final boolean a(@NotNull g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        GuildContactInfo guildContactInfo = gVar.s().guildContactInfo;
        if (guildContactInfo == null || guildContactInfo.abstractIconType != 1) {
            return false;
        }
        return true;
    }
}
