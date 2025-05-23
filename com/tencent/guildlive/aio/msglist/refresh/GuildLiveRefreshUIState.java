package com.tencent.guildlive.aio.msglist.refresh;

import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/refresh/GuildLiveRefreshUIState;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "<init>", "()V", "ExcellentMsgViewVisibleChangeUIState", "NotifyMsgList", "PanelVisibleChange", "VideoScreenChange", "Lcom/tencent/guildlive/aio/msglist/refresh/GuildLiveRefreshUIState$ExcellentMsgViewVisibleChangeUIState;", "Lcom/tencent/guildlive/aio/msglist/refresh/GuildLiveRefreshUIState$NotifyMsgList;", "Lcom/tencent/guildlive/aio/msglist/refresh/GuildLiveRefreshUIState$PanelVisibleChange;", "Lcom/tencent/guildlive/aio/msglist/refresh/GuildLiveRefreshUIState$VideoScreenChange;", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class GuildLiveRefreshUIState implements MsgListUiState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/refresh/GuildLiveRefreshUIState$ExcellentMsgViewVisibleChangeUIState;", "Lcom/tencent/guildlive/aio/msglist/refresh/GuildLiveRefreshUIState;", "", "d", "I", "a", "()I", "heightSpace", "<init>", "(I)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class ExcellentMsgViewVisibleChangeUIState extends GuildLiveRefreshUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int heightSpace;

        public ExcellentMsgViewVisibleChangeUIState(int i3) {
            super(null);
            this.heightSpace = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getHeightSpace() {
            return this.heightSpace;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/refresh/GuildLiveRefreshUIState$NotifyMsgList;", "Lcom/tencent/guildlive/aio/msglist/refresh/GuildLiveRefreshUIState;", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class NotifyMsgList extends GuildLiveRefreshUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final NotifyMsgList f112933d = new NotifyMsgList();

        NotifyMsgList() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/refresh/GuildLiveRefreshUIState$PanelVisibleChange;", "Lcom/tencent/guildlive/aio/msglist/refresh/GuildLiveRefreshUIState;", "", "d", "Z", "a", "()Z", "show", "<init>", "(Z)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class PanelVisibleChange extends GuildLiveRefreshUIState {

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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/refresh/GuildLiveRefreshUIState$VideoScreenChange;", "Lcom/tencent/guildlive/aio/msglist/refresh/GuildLiveRefreshUIState;", "", "d", "I", "a", "()I", "videoState", "<init>", "(I)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class VideoScreenChange extends GuildLiveRefreshUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int videoState;

        public VideoScreenChange(int i3) {
            super(null);
            this.videoState = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getVideoState() {
            return this.videoState;
        }
    }

    public /* synthetic */ GuildLiveRefreshUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    GuildLiveRefreshUIState() {
    }
}
