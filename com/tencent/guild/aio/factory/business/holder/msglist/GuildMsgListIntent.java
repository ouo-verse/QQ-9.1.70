package com.tencent.guild.aio.factory.business.holder.msglist;

import android.view.View;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:#\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001#'()*+,-./0123456789:;<=>?@ABCDEFGHI\u00a8\u0006J"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "<init>", "()V", "AfterLoadFirstPageFinEvent", "ExposureVisibleMsgListEvent", "GetAIOBottomMsgEvent", "GetAIOExtremalMsgEvent", "GetAIORichMediaMsgListEvent", "GetAIOTopMsgEvent", "GetDelayAnimTimeEvent", "GetLastMsgPosEvent", "GetLatestDbMsgsEvent", "GetLoadFirstPageFin", "GetSkeletonState", "GuildAioLastShowMsgLower", "GuildApngPlayEvent", "GuildGiftHeadUpdateEvent", "GuildGiftPlayEvent", "GuildInputBarHeightChangEvent", "GuildMsgItemContentViewClickEvent", "GuildMsgListCombineEvent", "GuildMsgListRefreshEvent", "GuildMsgListScrollEvent", "GuildMsgListTopMarginUpdateEvent", "GuildMultiSelectCountChangeEvent", "GuildMultiSelectModeChangeEvent", "GuildRefreshNickEvent", "GuildVideoPlayEvent", "HandleFirstPageDelayed", "LoadFirstPageFinEvent", "NavigateToDeletedMsgEvent", "NewMsgLineMsgGet", "OnSkeletonHide", "OnSkeletonLastEnoughTime", "OnSkeletonShow", "StartGiftAnimationEvent", "StopGiftAnimationByUserEvent", "UpdateReeditRecallMsgListEvent", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$AfterLoadFirstPageFinEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$ExposureVisibleMsgListEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GetAIOBottomMsgEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GetAIOExtremalMsgEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GetAIORichMediaMsgListEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GetAIOTopMsgEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GetDelayAnimTimeEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GetLastMsgPosEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GetLatestDbMsgsEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GetLoadFirstPageFin;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GetSkeletonState;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildAioLastShowMsgLower;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildApngPlayEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildGiftHeadUpdateEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildGiftPlayEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildInputBarHeightChangEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildMsgItemContentViewClickEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildMsgListCombineEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildMsgListRefreshEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildMsgListScrollEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildMsgListTopMarginUpdateEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildMultiSelectCountChangeEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildMultiSelectModeChangeEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildRefreshNickEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildVideoPlayEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$HandleFirstPageDelayed;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$LoadFirstPageFinEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$NavigateToDeletedMsgEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$NewMsgLineMsgGet;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$OnSkeletonHide;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$OnSkeletonLastEnoughTime;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$OnSkeletonShow;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$StartGiftAnimationEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$StopGiftAnimationByUserEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$UpdateReeditRecallMsgListEvent;", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class GuildMsgListIntent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$AfterLoadFirstPageFinEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class AfterLoadFirstPageFinEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final AfterLoadFirstPageFinEvent f110403d = new AfterLoadFirstPageFinEvent();

        AfterLoadFirstPageFinEvent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$ExposureVisibleMsgListEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "", "d", "I", "a", "()I", "firstPosition", "e", "b", "lastPosition", "", "Lcom/tencent/aio/data/msglist/a;", "f", "Ljava/util/List;", "c", "()Ljava/util/List;", "msgItemList", "<init>", "(IILjava/util/List;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class ExposureVisibleMsgListEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int firstPosition;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int lastPosition;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<com.tencent.aio.data.msglist.a> msgItemList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ExposureVisibleMsgListEvent(int i3, int i16, @NotNull List<? extends com.tencent.aio.data.msglist.a> msgItemList) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItemList, "msgItemList");
            this.firstPosition = i3;
            this.lastPosition = i16;
            this.msgItemList = msgItemList;
        }

        /* renamed from: a, reason: from getter */
        public final int getFirstPosition() {
            return this.firstPosition;
        }

        /* renamed from: b, reason: from getter */
        public final int getLastPosition() {
            return this.lastPosition;
        }

        @NotNull
        public final List<com.tencent.aio.data.msglist.a> c() {
            return this.msgItemList;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GetAIOBottomMsgEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GetAIOBottomMsgEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GetAIOBottomMsgEvent f110407d = new GetAIOBottomMsgEvent();

        GetAIOBottomMsgEvent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GetAIOExtremalMsgEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GetAIOExtremalMsgEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GetAIOExtremalMsgEvent f110408d = new GetAIOExtremalMsgEvent();

        GetAIOExtremalMsgEvent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GetAIORichMediaMsgListEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GetAIORichMediaMsgListEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MsgRecord msgRecord;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetAIORichMediaMsgListEvent(@NotNull MsgRecord msgRecord) {
            super(null);
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            this.msgRecord = msgRecord;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final MsgRecord getMsgRecord() {
            return this.msgRecord;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GetAIOTopMsgEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GetAIOTopMsgEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GetAIOTopMsgEvent f110410d = new GetAIOTopMsgEvent();

        GetAIOTopMsgEvent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GetDelayAnimTimeEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "", "d", "I", "a", "()I", "b", "(I)V", "delayTime", "<init>", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GetDelayAnimTimeEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int delayTime;

        public GetDelayAnimTimeEvent(int i3) {
            super(null);
            this.delayTime = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getDelayTime() {
            return this.delayTime;
        }

        public final void b(int i3) {
            this.delayTime = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GetLastMsgPosEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GetLastMsgPosEvent extends GuildMsgListIntent {
        public GetLastMsgPosEvent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GetLatestDbMsgsEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GetLatestDbMsgsEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GetLatestDbMsgsEvent f110412d = new GetLatestDbMsgsEvent();

        GetLatestDbMsgsEvent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GetLoadFirstPageFin;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GetLoadFirstPageFin extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GetLoadFirstPageFin f110413d = new GetLoadFirstPageFin();

        GetLoadFirstPageFin() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GetSkeletonState;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GetSkeletonState extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GetSkeletonState f110414d = new GetSkeletonState();

        GetSkeletonState() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildAioLastShowMsgLower;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/aio/data/msglist/a;", "d", "Lcom/tencent/aio/data/msglist/a;", "a", "()Lcom/tencent/aio/data/msglist/a;", "aioLastShowMsg", "<init>", "(Lcom/tencent/aio/data/msglist/a;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class GuildAioLastShowMsgLower extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final com.tencent.aio.data.msglist.a aioLastShowMsg;

        public GuildAioLastShowMsgLower(@Nullable com.tencent.aio.data.msglist.a aVar) {
            super(null);
            this.aioLastShowMsg = aVar;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final com.tencent.aio.data.msglist.a getAioLastShowMsg() {
            return this.aioLastShowMsg;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof GuildAioLastShowMsgLower) && Intrinsics.areEqual(this.aioLastShowMsg, ((GuildAioLastShowMsgLower) other).aioLastShowMsg)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            com.tencent.aio.data.msglist.a aVar = this.aioLastShowMsg;
            if (aVar == null) {
                return 0;
            }
            return aVar.hashCode();
        }

        @NotNull
        public String toString() {
            return "GuildAioLastShowMsgLower(aioLastShowMsg=" + this.aioLastShowMsg + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildApngPlayEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "", "d", "Z", "a", "()Z", "play", "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildApngPlayEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean play;

        public GuildApngPlayEvent(boolean z16) {
            super(null);
            this.play = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getPlay() {
            return this.play;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildGiftHeadUpdateEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "guildId", "e", "b", "tinyId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildGiftHeadUpdateEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String guildId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String tinyId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildGiftHeadUpdateEvent(@NotNull String guildId, @NotNull String tinyId) {
            super(null);
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            this.guildId = guildId;
            this.tinyId = tinyId;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getTinyId() {
            return this.tinyId;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildGiftPlayEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "", "d", "Z", "a", "()Z", "stop", "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildGiftPlayEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean stop;

        public GuildGiftPlayEvent(boolean z16) {
            super(null);
            this.stop = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getStop() {
            return this.stop;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildInputBarHeightChangEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "height", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class GuildInputBarHeightChangEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int height;

        public GuildInputBarHeightChangEvent(int i3) {
            super(null);
            this.height = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof GuildInputBarHeightChangEvent) && this.height == ((GuildInputBarHeightChangEvent) other).height) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.height;
        }

        @NotNull
        public String toString() {
            return "GuildInputBarHeightChangEvent(height=" + this.height + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildMsgItemContentViewClickEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "Lcom/tencent/aio/data/msglist/a;", "d", "Lcom/tencent/aio/data/msglist/a;", "b", "()Lcom/tencent/aio/data/msglist/a;", "msgItem", "Landroid/view/View;", "e", "Landroid/view/View;", "a", "()Landroid/view/View;", "msgBubbleView", "<init>", "(Lcom/tencent/aio/data/msglist/a;Landroid/view/View;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildMsgItemContentViewClickEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.aio.data.msglist.a msgItem;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final View msgBubbleView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildMsgItemContentViewClickEvent(@NotNull com.tencent.aio.data.msglist.a msgItem, @Nullable View view) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            this.msgItem = msgItem;
            this.msgBubbleView = view;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final View getMsgBubbleView() {
            return this.msgBubbleView;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final com.tencent.aio.data.msglist.a getMsgItem() {
            return this.msgItem;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildMsgListCombineEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "getPosition", "()I", "position", "Lcom/tencent/aio/data/msglist/a;", "e", "Lcom/tencent/aio/data/msglist/a;", "getMsgItem", "()Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "f", "Ljava/util/List;", "getPayloads", "()Ljava/util/List;", "payloads", "<init>", "(ILcom/tencent/aio/data/msglist/a;Ljava/util/List;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class GuildMsgListCombineEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int position;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final com.tencent.aio.data.msglist.a msgItem;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<Object> payloads;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildMsgListCombineEvent(int i3, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            this.position = i3;
            this.msgItem = msgItem;
            this.payloads = payloads;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildMsgListCombineEvent)) {
                return false;
            }
            GuildMsgListCombineEvent guildMsgListCombineEvent = (GuildMsgListCombineEvent) other;
            if (this.position == guildMsgListCombineEvent.position && Intrinsics.areEqual(this.msgItem, guildMsgListCombineEvent.msgItem) && Intrinsics.areEqual(this.payloads, guildMsgListCombineEvent.payloads)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.position * 31) + this.msgItem.hashCode()) * 31) + this.payloads.hashCode();
        }

        @NotNull
        public String toString() {
            return "GuildMsgListCombineEvent(position=" + this.position + ", msgItem=" + this.msgItem + ", payloads=" + this.payloads + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildMsgListRefreshEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "source", "", "e", "Ljava/util/List;", "a", "()Ljava/util/List;", "payloads", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class GuildMsgListRefreshEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String source;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<Object> payloads;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildMsgListRefreshEvent(@NotNull String source, @NotNull List<Object> payloads) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            this.source = source;
            this.payloads = payloads;
        }

        @NotNull
        public final List<Object> a() {
            return this.payloads;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildMsgListRefreshEvent)) {
                return false;
            }
            GuildMsgListRefreshEvent guildMsgListRefreshEvent = (GuildMsgListRefreshEvent) other;
            if (Intrinsics.areEqual(this.source, guildMsgListRefreshEvent.source) && Intrinsics.areEqual(this.payloads, guildMsgListRefreshEvent.payloads)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.source.hashCode() * 31) + this.payloads.hashCode();
        }

        @NotNull
        public String toString() {
            return "GuildMsgListRefreshEvent(source=" + this.source + ", payloads=" + this.payloads + ")";
        }

        public /* synthetic */ GuildMsgListRefreshEvent(String str, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? new ArrayList() : list);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildMsgListScrollEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "source", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "e", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "b", "()Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "aioTopMsg", "f", "a", "aioBottomMsg", tl.h.F, "c", "latestAioMsg", "<init>", "(Ljava/lang/String;Lcom/tencent/guild/api/data/msglist/GuildMsgItem;Lcom/tencent/guild/api/data/msglist/GuildMsgItem;Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class GuildMsgListScrollEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String source;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final GuildMsgItem aioTopMsg;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final GuildMsgItem aioBottomMsg;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final GuildMsgItem latestAioMsg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildMsgListScrollEvent(@NotNull String source, @Nullable GuildMsgItem guildMsgItem, @Nullable GuildMsgItem guildMsgItem2, @Nullable GuildMsgItem guildMsgItem3) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
            this.aioTopMsg = guildMsgItem;
            this.aioBottomMsg = guildMsgItem2;
            this.latestAioMsg = guildMsgItem3;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final GuildMsgItem getAioBottomMsg() {
            return this.aioBottomMsg;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final GuildMsgItem getAioTopMsg() {
            return this.aioTopMsg;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final GuildMsgItem getLatestAioMsg() {
            return this.latestAioMsg;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildMsgListScrollEvent)) {
                return false;
            }
            GuildMsgListScrollEvent guildMsgListScrollEvent = (GuildMsgListScrollEvent) other;
            if (Intrinsics.areEqual(this.source, guildMsgListScrollEvent.source) && Intrinsics.areEqual(this.aioTopMsg, guildMsgListScrollEvent.aioTopMsg) && Intrinsics.areEqual(this.aioBottomMsg, guildMsgListScrollEvent.aioBottomMsg) && Intrinsics.areEqual(this.latestAioMsg, guildMsgListScrollEvent.latestAioMsg)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3 = this.source.hashCode() * 31;
            GuildMsgItem guildMsgItem = this.aioTopMsg;
            int i3 = 0;
            if (guildMsgItem == null) {
                hashCode = 0;
            } else {
                hashCode = guildMsgItem.hashCode();
            }
            int i16 = (hashCode3 + hashCode) * 31;
            GuildMsgItem guildMsgItem2 = this.aioBottomMsg;
            if (guildMsgItem2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = guildMsgItem2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            GuildMsgItem guildMsgItem3 = this.latestAioMsg;
            if (guildMsgItem3 != null) {
                i3 = guildMsgItem3.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "GuildMsgListScrollEvent(source=" + this.source + ", aioTopMsg=" + this.aioTopMsg + ", aioBottomMsg=" + this.aioBottomMsg + ", latestAioMsg=" + this.latestAioMsg + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildMsgListTopMarginUpdateEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "", "d", "I", "a", "()I", "topMargin", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildMsgListTopMarginUpdateEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int topMargin;

        public GuildMsgListTopMarginUpdateEvent(int i3) {
            super(null);
            this.topMargin = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getTopMargin() {
            return this.topMargin;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildMultiSelectCountChangeEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GuildMultiSelectCountChangeEvent extends GuildMsgListIntent {
        public GuildMultiSelectCountChangeEvent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildMultiSelectModeChangeEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "source", "e", "Z", "a", "()Z", "isSelectMode", "<init>", "(Ljava/lang/String;Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class GuildMultiSelectModeChangeEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String source;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSelectMode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildMultiSelectModeChangeEvent(@NotNull String source, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
            this.isSelectMode = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsSelectMode() {
            return this.isSelectMode;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildMultiSelectModeChangeEvent)) {
                return false;
            }
            GuildMultiSelectModeChangeEvent guildMultiSelectModeChangeEvent = (GuildMultiSelectModeChangeEvent) other;
            if (Intrinsics.areEqual(this.source, guildMultiSelectModeChangeEvent.source) && this.isSelectMode == guildMultiSelectModeChangeEvent.isSelectMode) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.source.hashCode() * 31;
            boolean z16 = this.isSelectMode;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "GuildMultiSelectModeChangeEvent(source=" + this.source + ", isSelectMode=" + this.isSelectMode + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildRefreshNickEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "", "d", "I", "b", "()I", "type", "", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "tinyId", "<init>", "(ILjava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildRefreshNickEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int type;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String tinyId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildRefreshNickEvent(int i3, @NotNull String tinyId) {
            super(null);
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            this.type = i3;
            this.tinyId = tinyId;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getTinyId() {
            return this.tinyId;
        }

        /* renamed from: b, reason: from getter */
        public final int getType() {
            return this.type;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildVideoPlayEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "", "d", "Z", "b", "()Z", "pause", "e", "a", "mute", "<init>", "(ZZ)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildVideoPlayEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean pause;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean mute;

        public GuildVideoPlayEvent(boolean z16, boolean z17) {
            super(null);
            this.pause = z16;
            this.mute = z17;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getMute() {
            return this.mute;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getPause() {
            return this.pause;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$HandleFirstPageDelayed;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class HandleFirstPageDelayed extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final HandleFirstPageDelayed f110439d = new HandleFirstPageDelayed();

        HandleFirstPageDelayed() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$LoadFirstPageFinEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class LoadFirstPageFinEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final LoadFirstPageFinEvent f110440d = new LoadFirstPageFinEvent();

        LoadFirstPageFinEvent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$NavigateToDeletedMsgEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class NavigateToDeletedMsgEvent extends GuildMsgListIntent {
        public NavigateToDeletedMsgEvent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$NewMsgLineMsgGet;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/aio/data/msglist/a;", "d", "Lcom/tencent/aio/data/msglist/a;", "getMsgItem", "()Lcom/tencent/aio/data/msglist/a;", "msgItem", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class NewMsgLineMsgGet extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final com.tencent.aio.data.msglist.a msgItem;

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof NewMsgLineMsgGet) && Intrinsics.areEqual(this.msgItem, ((NewMsgLineMsgGet) other).msgItem)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.msgItem.hashCode();
        }

        @NotNull
        public String toString() {
            return "NewMsgLineMsgGet(msgItem=" + this.msgItem + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$OnSkeletonHide;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class OnSkeletonHide extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnSkeletonHide f110442d = new OnSkeletonHide();

        OnSkeletonHide() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$OnSkeletonLastEnoughTime;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class OnSkeletonLastEnoughTime extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnSkeletonLastEnoughTime f110443d = new OnSkeletonLastEnoughTime();

        OnSkeletonLastEnoughTime() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$OnSkeletonShow;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "J", "a", "()J", "startTime", "<init>", "(J)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class OnSkeletonShow extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final long startTime;

        public OnSkeletonShow(long j3) {
            super(null);
            this.startTime = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getStartTime() {
            return this.startTime;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnSkeletonShow) && this.startTime == ((OnSkeletonShow) other).startTime) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.startTime);
        }

        @NotNull
        public String toString() {
            return "OnSkeletonShow(startTime=" + this.startTime + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u000b\u0010\u0013R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$StartGiftAnimationEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "d", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "b", "()Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "guildMsgItem", "e", "Z", "c", "()Z", "isClick", "f", "isNewGiftMessage", tl.h.F, "Ljava/lang/String;", "a", "()Ljava/lang/String;", "guildId", "<init>", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;ZZLjava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class StartGiftAnimationEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final GuildMsgItem guildMsgItem;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isClick;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isNewGiftMessage;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StartGiftAnimationEvent(@NotNull GuildMsgItem guildMsgItem, boolean z16, boolean z17, @NotNull String guildId) {
            super(null);
            Intrinsics.checkNotNullParameter(guildMsgItem, "guildMsgItem");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            this.guildMsgItem = guildMsgItem;
            this.isClick = z16;
            this.isNewGiftMessage = z17;
            this.guildId = guildId;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final GuildMsgItem getGuildMsgItem() {
            return this.guildMsgItem;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsClick() {
            return this.isClick;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsNewGiftMessage() {
            return this.isNewGiftMessage;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StartGiftAnimationEvent)) {
                return false;
            }
            StartGiftAnimationEvent startGiftAnimationEvent = (StartGiftAnimationEvent) other;
            if (Intrinsics.areEqual(this.guildMsgItem, startGiftAnimationEvent.guildMsgItem) && this.isClick == startGiftAnimationEvent.isClick && this.isNewGiftMessage == startGiftAnimationEvent.isNewGiftMessage && Intrinsics.areEqual(this.guildId, startGiftAnimationEvent.guildId)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.guildMsgItem.hashCode() * 31;
            boolean z16 = this.isClick;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode + i16) * 31;
            boolean z17 = this.isNewGiftMessage;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return ((i17 + i3) * 31) + this.guildId.hashCode();
        }

        @NotNull
        public String toString() {
            return "StartGiftAnimationEvent(guildMsgItem=" + this.guildMsgItem + ", isClick=" + this.isClick + ", isNewGiftMessage=" + this.isNewGiftMessage + ", guildId=" + this.guildId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$StopGiftAnimationByUserEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class StopGiftAnimationByUserEvent extends GuildMsgListIntent {
        public StopGiftAnimationByUserEvent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$UpdateReeditRecallMsgListEvent;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class UpdateReeditRecallMsgListEvent extends GuildMsgListIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MsgRecord msgRecord;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateReeditRecallMsgListEvent(@NotNull MsgRecord msgRecord) {
            super(null);
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            this.msgRecord = msgRecord;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final MsgRecord getMsgRecord() {
            return this.msgRecord;
        }
    }

    public /* synthetic */ GuildMsgListIntent(DefaultConstructorMarker defaultConstructorMarker) {
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

    GuildMsgListIntent() {
    }
}
