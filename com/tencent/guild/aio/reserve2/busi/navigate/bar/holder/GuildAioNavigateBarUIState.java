package com.tencent.guild.aio.reserve2.busi.navigate.bar.holder;

import com.tencent.guild.aio.reserve2.holder.GuildReserve2UIState;
import com.tencent.mvi.base.route.h;
import er0.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0006B\u001d\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/navigate/bar/holder/GuildAioNavigateBarUIState;", "Lcom/tencent/guild/aio/reserve2/holder/GuildReserve2UIState;", "", "Ler0/a$a;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "navigateInfoList", "", "e", "J", "b", "()J", "unreadCount", "<init>", "(Ljava/util/List;J)V", "f", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAioNavigateBarUIState implements GuildReserve2UIState {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<a.C10261a> navigateInfoList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long unreadCount;

    public GuildAioNavigateBarUIState(@NotNull List<a.C10261a> navigateInfoList, long j3) {
        Intrinsics.checkNotNullParameter(navigateInfoList, "navigateInfoList");
        this.navigateInfoList = navigateInfoList;
        this.unreadCount = j3;
    }

    @NotNull
    public final List<a.C10261a> a() {
        return this.navigateInfoList;
    }

    /* renamed from: b, reason: from getter */
    public final long getUnreadCount() {
        return this.unreadCount;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }
}
