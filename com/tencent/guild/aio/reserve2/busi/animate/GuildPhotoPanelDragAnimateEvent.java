package com.tencent.guild.aio.reserve2.busi.animate;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/animate/GuildPhotoPanelDragAnimateEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "AnimateEvent", "Lcom/tencent/guild/aio/reserve2/busi/animate/GuildPhotoPanelDragAnimateEvent$AnimateEvent;", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class GuildPhotoPanelDragAnimateEvent implements MsgIntent {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/animate/GuildPhotoPanelDragAnimateEvent$AnimateEvent;", "Lcom/tencent/guild/aio/reserve2/busi/animate/GuildPhotoPanelDragAnimateEvent;", "", "d", "Z", "b", "()Z", "show", "", "e", UserInfo.SEX_FEMALE, "a", "()F", "ratio", "<init>", "(ZF)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class AnimateEvent extends GuildPhotoPanelDragAnimateEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean show;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final float ratio;

        public AnimateEvent(boolean z16, float f16) {
            super(null);
            this.show = z16;
            this.ratio = f16;
        }

        /* renamed from: a, reason: from getter */
        public final float getRatio() {
            return this.ratio;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getShow() {
            return this.show;
        }
    }

    public /* synthetic */ GuildPhotoPanelDragAnimateEvent(DefaultConstructorMarker defaultConstructorMarker) {
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

    GuildPhotoPanelDragAnimateEvent() {
    }
}
