package com.tencent.guildlive.aio.reserve2;

import com.tencent.guild.aio.reserve2.holder.GuildReserve2UIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guildlive/aio/reserve2/LiveVideoScreenChangeUIState;", "Lcom/tencent/guild/aio/reserve2/holder/GuildReserve2UIState;", "", "d", "I", "getVideoScreenState", "()I", "videoScreenState", "<init>", "(I)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class LiveVideoScreenChangeUIState implements GuildReserve2UIState {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int videoScreenState;

    public LiveVideoScreenChangeUIState(int i3) {
        this.videoScreenState = i3;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }
}
