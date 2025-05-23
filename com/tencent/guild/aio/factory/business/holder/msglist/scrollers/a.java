package com.tencent.guild.aio.factory.business.holder.msglist.scrollers;

import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVM;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/a;", "", "", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/d;", "a", "Ljava/util/List;", "()Ljava/util/List;", "mScrollerList", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM;", "vm", "<init>", "(Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<d> mScrollerList;

    public a(@NotNull GuildMsgListDataVM vm5) {
        List<d> listOf;
        Intrinsics.checkNotNullParameter(vm5, "vm");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new d[]{new GuildChatPicPreloadScrollListener(vm5), new c()});
        this.mScrollerList = listOf;
    }

    @NotNull
    public final List<d> a() {
        return this.mScrollerList;
    }
}
