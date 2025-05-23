package com.tencent.guild.aio.msglist.holder.component;

import com.tencent.guild.aio.msglist.holder.component.GuildBubbleAvatarComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\n\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/g;", "Lol3/b;", "Lcom/tencent/guild/aio/msglist/holder/component/GuildBubbleAvatarComponent$b;", "d", "Lcom/tencent/guild/aio/msglist/holder/component/GuildBubbleAvatarComponent$b;", "a", "()Lcom/tencent/guild/aio/msglist/holder/component/GuildBubbleAvatarComponent$b;", "b", "(Lcom/tencent/guild/aio/msglist/holder/component/GuildBubbleAvatarComponent$b;)V", "viewStyle", "<init>", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class g implements ol3.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildBubbleAvatarComponent.b viewStyle;

    public g() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final GuildBubbleAvatarComponent.b getViewStyle() {
        return this.viewStyle;
    }

    public final void b(@Nullable GuildBubbleAvatarComponent.b bVar) {
        this.viewStyle = bVar;
    }

    public g(@Nullable GuildBubbleAvatarComponent.b bVar) {
        this.viewStyle = bVar;
    }

    public /* synthetic */ g(GuildBubbleAvatarComponent.b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bVar);
    }
}
