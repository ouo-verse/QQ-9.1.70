package com.tencent.guild.aio.article.msglist;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000b\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000eB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000b\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "<init>", "()V", "ArticleMsgListUpdated", "FirstPageMsgInitCompleted", "HideUnreadNavigateBubble", "MainMsgIdGet", "MainMsgInfoUpdated", "MainMsgRecordGet", "MainMsgRecordInitCompleted", "MainMsgSeqGet", "MainMsgViewScreenPositionChanged", "UpdateCanScrollUpState", "UpdateMsgItemState", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$ArticleMsgListUpdated;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$FirstPageMsgInitCompleted;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$HideUnreadNavigateBubble;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$MainMsgIdGet;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$MainMsgInfoUpdated;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$MainMsgRecordGet;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$MainMsgRecordInitCompleted;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$MainMsgSeqGet;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$MainMsgViewScreenPositionChanged;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$UpdateCanScrollUpState;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$UpdateMsgItemState;", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class GuildArticleMsgListEvent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$ArticleMsgListUpdated;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent;", "", "Lcom/tencent/aio/data/msglist/a;", "d", "Ljava/util/List;", "b", "()Ljava/util/List;", "list", "", "e", "I", "a", "()I", "lastPosition", "<init>", "(Ljava/util/List;I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class ArticleMsgListUpdated extends GuildArticleMsgListEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<com.tencent.aio.data.msglist.a> list;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int lastPosition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ArticleMsgListUpdated(@NotNull List<? extends com.tencent.aio.data.msglist.a> list, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
            this.lastPosition = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getLastPosition() {
            return this.lastPosition;
        }

        @NotNull
        public final List<com.tencent.aio.data.msglist.a> b() {
            return this.list;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$FirstPageMsgInitCompleted;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent;", "", "d", "Z", "a", "()Z", "isSuccess", "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class FirstPageMsgInitCompleted extends GuildArticleMsgListEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isSuccess;

        public FirstPageMsgInitCompleted(boolean z16) {
            super(null);
            this.isSuccess = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$HideUnreadNavigateBubble;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class HideUnreadNavigateBubble extends GuildArticleMsgListEvent {
        public HideUnreadNavigateBubble() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$MainMsgIdGet;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class MainMsgIdGet extends GuildArticleMsgListEvent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final MainMsgIdGet f109913d = new MainMsgIdGet();

        MainMsgIdGet() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$MainMsgInfoUpdated;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class MainMsgInfoUpdated extends GuildArticleMsgListEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final MsgRecord msgRecord;

        public MainMsgInfoUpdated(@Nullable MsgRecord msgRecord) {
            super(null);
            this.msgRecord = msgRecord;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final MsgRecord getMsgRecord() {
            return this.msgRecord;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$MainMsgRecordGet;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class MainMsgRecordGet extends GuildArticleMsgListEvent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final MainMsgRecordGet f109915d = new MainMsgRecordGet();

        MainMsgRecordGet() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$MainMsgRecordInitCompleted;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent;", "", "d", "Z", "b", "()Z", "isSuccess", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "(ZLcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class MainMsgRecordInitCompleted extends GuildArticleMsgListEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isSuccess;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final MsgRecord msgRecord;

        public MainMsgRecordInitCompleted(boolean z16, @Nullable MsgRecord msgRecord) {
            super(null);
            this.isSuccess = z16;
            this.msgRecord = msgRecord;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final MsgRecord getMsgRecord() {
            return this.msgRecord;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$MainMsgSeqGet;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class MainMsgSeqGet extends GuildArticleMsgListEvent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final MainMsgSeqGet f109918d = new MainMsgSeqGet();

        MainMsgSeqGet() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$MainMsgViewScreenPositionChanged;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent;", "", "d", "Z", "c", "()Z", "isShowing", "", "e", "I", "b", "()I", "topScreenPosition", "f", "a", "bottomScreenPosition", "<init>", "(ZII)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class MainMsgViewScreenPositionChanged extends GuildArticleMsgListEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isShowing;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int topScreenPosition;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int bottomScreenPosition;

        public MainMsgViewScreenPositionChanged(boolean z16, int i3, int i16) {
            super(null);
            this.isShowing = z16;
            this.topScreenPosition = i3;
            this.bottomScreenPosition = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getBottomScreenPosition() {
            return this.bottomScreenPosition;
        }

        /* renamed from: b, reason: from getter */
        public final int getTopScreenPosition() {
            return this.topScreenPosition;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsShowing() {
            return this.isShowing;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$UpdateCanScrollUpState;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class UpdateCanScrollUpState extends GuildArticleMsgListEvent {
        public UpdateCanScrollUpState() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent$UpdateMsgItemState;", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgListEvent;", "", "d", "I", "a", "()I", "position", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class UpdateMsgItemState extends GuildArticleMsgListEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int position;

        public UpdateMsgItemState(int i3) {
            super(null);
            this.position = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getPosition() {
            return this.position;
        }
    }

    public /* synthetic */ GuildArticleMsgListEvent(DefaultConstructorMarker defaultConstructorMarker) {
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

    GuildArticleMsgListEvent() {
    }
}
