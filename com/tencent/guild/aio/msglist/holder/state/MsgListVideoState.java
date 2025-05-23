package com.tencent.guild.aio.msglist.holder.state;

import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/state/MsgListVideoState;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "", "d", "Z", "b", "()Z", "pause", "e", "a", "mute", "<init>", "(ZZ)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class MsgListVideoState implements MsgListUiState {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean pause;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean mute;

    public MsgListVideoState(boolean z16, boolean z17) {
        this.pause = z16;
        this.mute = z17;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getMute() {
        return this.mute;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getPause() {
        return this.pause;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }
}
