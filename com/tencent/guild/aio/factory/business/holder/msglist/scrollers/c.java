package com.tencent.guild.aio.factory.business.holder.msglist.scrollers;

import android.util.Log;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J8\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/c;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/d;", "", "firstVisiblePos", "lastVisiblePos", "firstCompletelyVisible", "lastCompletelyVisible", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/ScrollDirection;", "direction", "", "b", "dx", "dy", "c", "newState", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c implements d {
    @Override // com.tencent.guild.aio.factory.business.holder.msglist.scrollers.d
    public void a(int newState, int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, @NotNull ScrollDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Logger.f235387a.d().i("GuildMsgListScrollLogger", 1, "onScrollStateChanged newState: " + newState + " firstVisiblePos: " + firstVisiblePos + " lastVisiblePos: " + lastVisiblePos + "  firstCompletelyVisible: " + firstCompletelyVisible + "  lastCompletelyVisible: " + lastCompletelyVisible + " direction: " + direction);
    }

    @Override // com.tencent.guild.aio.factory.business.holder.msglist.scrollers.d
    public void b(int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, @NotNull ScrollDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Logger.f235387a.d().i("GuildMsgListScrollLogger", 1, "onSlowScroll firstVisiblePos: " + firstVisiblePos + " lastVisiblePos: " + lastVisiblePos + " firstCompletelyVisible: " + firstCompletelyVisible + " lastCompletelyVisible: " + lastCompletelyVisible + " direction: " + direction);
    }

    @Override // com.tencent.guild.aio.factory.business.holder.msglist.scrollers.d
    public void c(int dx5, int dy5, @NotNull ScrollDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildMsgListScrollLogger", "onScroll view: dx: " + dx5 + " dy: " + dy5 + " direction: " + direction);
        }
    }
}
