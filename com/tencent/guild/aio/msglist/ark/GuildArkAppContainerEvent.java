package com.tencent.guild.aio.msglist.ark;

import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guild/aio/msglist/ark/GuildArkAppContainerEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "GetArkContainerHelper", "Lcom/tencent/guild/aio/msglist/ark/GuildArkAppContainerEvent$GetArkContainerHelper;", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class GuildArkAppContainerEvent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/msglist/ark/GuildArkAppContainerEvent$GetArkContainerHelper;", "Lcom/tencent/guild/aio/msglist/ark/GuildArkAppContainerEvent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GetArkContainerHelper extends GuildArkAppContainerEvent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GetArkContainerHelper f111188d = new GetArkContainerHelper();

        GetArkContainerHelper() {
            super(null);
        }
    }

    public /* synthetic */ GuildArkAppContainerEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    GuildArkAppContainerEvent() {
    }
}
