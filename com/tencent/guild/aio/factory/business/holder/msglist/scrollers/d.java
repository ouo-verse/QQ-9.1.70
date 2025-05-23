package com.tencent.guild.aio.factory.business.holder.msglist.scrollers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J8\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/d;", "", "", "firstVisiblePos", "lastVisiblePos", "firstCompletelyVisible", "lastCompletelyVisible", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/ScrollDirection;", "direction", "", "b", "dx", "dy", "c", "newState", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface d {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class a {
        public static void a(@NotNull d dVar, int i3, int i16, @NotNull ScrollDirection direction) {
            Intrinsics.checkNotNullParameter(direction, "direction");
        }
    }

    void a(int newState, int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, @NotNull ScrollDirection direction);

    void b(int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, @NotNull ScrollDirection direction);

    void c(int dx5, int dy5, @NotNull ScrollDirection direction);
}
