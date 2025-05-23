package com.tencent.guild.aio.factory.business.holder.msglist;

import android.os.Bundle;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001BC\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataState;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState;", "", "forceUpdate", "Z", "getForceUpdate", "()Z", "Lcom/tencent/aio/data/msglist/a;", "latestAIOMsg", "Lcom/tencent/aio/data/msglist/a;", "getLatestAIOMsg", "()Lcom/tencent/aio/data/msglist/a;", "", "curUpdateType", "I", "getCurUpdateType", "()I", "", "list", "Landroid/os/Bundle;", "extra", "<init>", "(Ljava/util/Collection;ZLcom/tencent/aio/data/msglist/a;ILandroid/os/Bundle;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class GuildMsgListDataState extends MsgListState {
    private final int curUpdateType;
    private final boolean forceUpdate;

    @Nullable
    private final com.tencent.aio.data.msglist.a latestAIOMsg;

    public GuildMsgListDataState() {
        this(null, false, null, 0, null, 31, null);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState, com.tencent.mvi.base.route.i
    @androidx.annotation.Nullable
    public /* bridge */ /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    public final int getCurUpdateType() {
        return this.curUpdateType;
    }

    public final boolean getForceUpdate() {
        return this.forceUpdate;
    }

    @Nullable
    public final com.tencent.aio.data.msglist.a getLatestAIOMsg() {
        return this.latestAIOMsg;
    }

    public /* synthetic */ GuildMsgListDataState(Collection collection, boolean z16, com.tencent.aio.data.msglist.a aVar, int i3, Bundle bundle, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? new ArrayList() : collection, (i16 & 2) != 0 ? false : z16, (i16 & 4) != 0 ? null : aVar, (i16 & 8) != 0 ? 3 : i3, (i16 & 16) == 0 ? bundle : null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMsgListDataState(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> list, boolean z16, @Nullable com.tencent.aio.data.msglist.a aVar, int i3, @Nullable Bundle bundle) {
        super(-1L, list, i3, bundle);
        Intrinsics.checkNotNullParameter(list, "list");
        this.forceUpdate = z16;
        this.latestAIOMsg = aVar;
        this.curUpdateType = i3;
    }
}
