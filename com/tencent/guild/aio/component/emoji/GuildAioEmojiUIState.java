package com.tencent.guild.aio.component.emoji;

import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/aio/component/emoji/GuildAioEmojiUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "", "d", "Z", "a", "()Z", "setEmoPanelShowing", "(Z)V", "emoPanelShowing", "<init>", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAioEmojiUIState implements MviUIState {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean emoPanelShowing;

    public GuildAioEmojiUIState() {
        this(false, 1, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEmoPanelShowing() {
        return this.emoPanelShowing;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    public GuildAioEmojiUIState(boolean z16) {
        this.emoPanelShowing = z16;
    }

    public /* synthetic */ GuildAioEmojiUIState(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}
