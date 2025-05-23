package com.tencent.guildlive.api.intent;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"com/tencent/guildlive/api/intent/GuildLiveOuterMsgIntent$LiveRoomTitleUpdateMsgIntent", "Lcom/tencent/mvi/base/route/MsgIntent;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "roomName", "<init>", "(Ljava/lang/String;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveOuterMsgIntent$LiveRoomTitleUpdateMsgIntent implements MsgIntent {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String roomName;

    public GuildLiveOuterMsgIntent$LiveRoomTitleUpdateMsgIntent(@NotNull String roomName) {
        Intrinsics.checkNotNullParameter(roomName, "roomName");
        this.roomName = roomName;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getRoomName() {
        return this.roomName;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }
}
