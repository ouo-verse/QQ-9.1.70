package com.tencent.guildlive.aio.excellentdetail;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guildlive/aio/excellentdetail/GuildLiveAnnounceMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "ShowRemoveFirstAnnounceMenu", "Lcom/tencent/guildlive/aio/excellentdetail/GuildLiveAnnounceMsgIntent$ShowRemoveFirstAnnounceMenu;", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class GuildLiveAnnounceMsgIntent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guildlive/aio/excellentdetail/GuildLiveAnnounceMsgIntent$ShowRemoveFirstAnnounceMenu;", "Lcom/tencent/guildlive/aio/excellentdetail/GuildLiveAnnounceMsgIntent;", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class ShowRemoveFirstAnnounceMenu extends GuildLiveAnnounceMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ShowRemoveFirstAnnounceMenu f112687d = new ShowRemoveFirstAnnounceMenu();

        ShowRemoveFirstAnnounceMenu() {
            super(null);
        }
    }

    public /* synthetic */ GuildLiveAnnounceMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    GuildLiveAnnounceMsgIntent() {
    }
}
