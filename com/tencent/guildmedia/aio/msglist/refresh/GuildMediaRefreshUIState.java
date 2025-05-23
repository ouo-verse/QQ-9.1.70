package com.tencent.guildmedia.aio.msglist.refresh;

import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/refresh/GuildMediaRefreshUIState;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "<init>", "()V", "NotifyMsgList", "PanelVisibleChange", "Lcom/tencent/guildmedia/aio/msglist/refresh/GuildMediaRefreshUIState$NotifyMsgList;", "Lcom/tencent/guildmedia/aio/msglist/refresh/GuildMediaRefreshUIState$PanelVisibleChange;", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class GuildMediaRefreshUIState implements MsgListUiState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/refresh/GuildMediaRefreshUIState$NotifyMsgList;", "Lcom/tencent/guildmedia/aio/msglist/refresh/GuildMediaRefreshUIState;", "()V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class NotifyMsgList extends GuildMediaRefreshUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final NotifyMsgList f113155d = new NotifyMsgList();

        NotifyMsgList() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/refresh/GuildMediaRefreshUIState$PanelVisibleChange;", "Lcom/tencent/guildmedia/aio/msglist/refresh/GuildMediaRefreshUIState;", "", "d", "Z", "a", "()Z", "show", "<init>", "(Z)V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class PanelVisibleChange extends GuildMediaRefreshUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean show;

        public PanelVisibleChange(boolean z16) {
            super(null);
            this.show = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getShow() {
            return this.show;
        }
    }

    public /* synthetic */ GuildMediaRefreshUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    GuildMediaRefreshUIState() {
    }
}
