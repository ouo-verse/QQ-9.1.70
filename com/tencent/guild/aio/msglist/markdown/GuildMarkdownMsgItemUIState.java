package com.tencent.guild.aio.msglist.markdown;

import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/GuildMarkdownMsgItemUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "OnConfigurationChangedUIState", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public class GuildMarkdownMsgItemUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/GuildMarkdownMsgItemUIState$OnConfigurationChangedUIState;", "Lcom/tencent/guild/aio/msglist/markdown/GuildMarkdownMsgItemUIState;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class OnConfigurationChangedUIState extends GuildMarkdownMsgItemUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnConfigurationChangedUIState f111725d = new OnConfigurationChangedUIState();

        OnConfigurationChangedUIState() {
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }
}
