package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.msgintent;

import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.msgintent.FeedSectionListPartCallerMsgIntent;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import do1.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\u0015\b\u0004\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\n\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", "d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", "getSession", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", SessionDbHelper.SESSION_ID, "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;)V", "GetFeedListAdapterPosMsgIntent", "GetFeedListSortModeMsgIntent", "OnFeedListDifferCompleteMsgIntent", "OnFeedListLoadedMsgIntent", "OnFeedSendBoxListDifferCompleteMsgIntent", "OnRefreshFinishMsgIntent", "OnRefreshMsgIntent", "OnScrollStateChangeMsgIntent", "OnScrolledChangeMsgIntent", "OnSortModeChangedMsgIntent", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$GetFeedListAdapterPosMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$GetFeedListSortModeMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnFeedListDifferCompleteMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnFeedListLoadedMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnFeedSendBoxListDifferCompleteMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnRefreshFinishMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnRefreshMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnScrollStateChangeMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnScrolledChangeMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnSortModeChangedMsgIntent;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class FeedSectionListPartMsgIntent implements MsgIntent {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i<?> session;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$GetFeedListAdapterPosMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", SessionDbHelper.SESSION_ID, "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class GetFeedListAdapterPosMsgIntent extends FeedSectionListPartMsgIntent {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetFeedListAdapterPosMsgIntent(@NotNull i<?> session) {
            super(session, null);
            Intrinsics.checkNotNullParameter(session, "session");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$GetFeedListSortModeMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", SessionDbHelper.SESSION_ID, "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class GetFeedListSortModeMsgIntent extends FeedSectionListPartMsgIntent {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetFeedListSortModeMsgIntent(@NotNull i<?> session) {
            super(session, null);
            Intrinsics.checkNotNullParameter(session, "session");
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BE\u0012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012(\u0010\u000f\u001a$\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00020\bj\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\t`\n\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R9\u0010\u000f\u001a$\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00020\bj\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\t`\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnFeedListDifferCompleteMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent;", "", "e", "Z", "a", "()Z", QAdRewardDefine$VideoParams.ISCACHE, "Ldo1/a;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/IFeedCollectionViewState;", "f", "Ldo1/a;", "getState", "()Ldo1/a;", "state", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", SessionDbHelper.SESSION_ID, "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;ZLdo1/a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class OnFeedListDifferCompleteMsgIntent extends FeedSectionListPartMsgIntent {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isCache;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a<? extends List<?>, Boolean> state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnFeedListDifferCompleteMsgIntent(@NotNull i<?> session, boolean z16, @NotNull a<? extends List<?>, Boolean> state) {
            super(session, null);
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(state, "state");
            this.isCache = z16;
            this.state = state;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsCache() {
            return this.isCache;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BE\u0012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012(\u0010\u000f\u001a$\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00020\bj\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\t`\n\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R9\u0010\u000f\u001a$\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00020\bj\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\t`\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnFeedListLoadedMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent;", "", "e", "Z", "b", "()Z", QAdRewardDefine$VideoParams.ISCACHE, "Ldo1/a;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/IFeedCollectionViewState;", "f", "Ldo1/a;", "a", "()Ldo1/a;", "state", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", SessionDbHelper.SESSION_ID, "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;ZLdo1/a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class OnFeedListLoadedMsgIntent extends FeedSectionListPartMsgIntent {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isCache;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a<? extends List<?>, Boolean> state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnFeedListLoadedMsgIntent(@NotNull i<?> session, boolean z16, @NotNull a<? extends List<?>, Boolean> state) {
            super(session, null);
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(state, "state");
            this.isCache = z16;
            this.state = state;
        }

        @NotNull
        public final a<? extends List<?>, Boolean> a() {
            return this.state;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsCache() {
            return this.isCache;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnFeedSendBoxListDifferCompleteMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent;", "", "e", "I", "a", "()I", "modifyType", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class OnFeedSendBoxListDifferCompleteMsgIntent extends FeedSectionListPartMsgIntent {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int modifyType;

        /* renamed from: a, reason: from getter */
        public final int getModifyType() {
            return this.modifyType;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0013\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnRefreshFinishMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent;", "", "e", "Z", "isSuccess", "()Z", "", "f", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "errorMsg", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartCallerMsgIntent$CallRefreshMsgIntent;", h.F, "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartCallerMsgIntent$CallRefreshMsgIntent;", "getRequestEvent", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartCallerMsgIntent$CallRefreshMsgIntent;", "requestEvent", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", SessionDbHelper.SESSION_ID, "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;ZLjava/lang/String;Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartCallerMsgIntent$CallRefreshMsgIntent;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class OnRefreshFinishMsgIntent extends FeedSectionListPartMsgIntent {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isSuccess;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String errorMsg;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FeedSectionListPartCallerMsgIntent.CallRefreshMsgIntent requestEvent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnRefreshFinishMsgIntent(@NotNull i<?> session, boolean z16, @NotNull String errorMsg, @NotNull FeedSectionListPartCallerMsgIntent.CallRefreshMsgIntent requestEvent) {
            super(session, null);
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            Intrinsics.checkNotNullParameter(requestEvent, "requestEvent");
            this.isSuccess = z16;
            this.errorMsg = errorMsg;
            this.requestEvent = requestEvent;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnRefreshMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartCallerMsgIntent$CallRefreshMsgIntent;", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartCallerMsgIntent$CallRefreshMsgIntent;", "getRequestEvent", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartCallerMsgIntent$CallRefreshMsgIntent;", "requestEvent", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", SessionDbHelper.SESSION_ID, "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartCallerMsgIntent$CallRefreshMsgIntent;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class OnRefreshMsgIntent extends FeedSectionListPartMsgIntent {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FeedSectionListPartCallerMsgIntent.CallRefreshMsgIntent requestEvent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnRefreshMsgIntent(@NotNull i<?> session, @NotNull FeedSectionListPartCallerMsgIntent.CallRefreshMsgIntent requestEvent) {
            super(session, null);
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(requestEvent, "requestEvent");
            this.requestEvent = requestEvent;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BY\u0012\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b\u0012(\u0010\u0016\u001a$\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00020\u000fj\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0010`\u0011\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR9\u0010\u0016\u001a$\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00020\u000fj\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0010`\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnScrollStateChangeMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent;", "", "e", "Z", "c", "()Z", "isScrolling", "Lkotlin/Pair;", "", "f", "Lkotlin/Pair;", "b", "()Lkotlin/Pair;", "visiblePositionPair", "Ldo1/a;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/IFeedCollectionViewState;", h.F, "Ldo1/a;", "a", "()Ldo1/a;", "state", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", SessionDbHelper.SESSION_ID, "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;ZLkotlin/Pair;Ldo1/a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class OnScrollStateChangeMsgIntent extends FeedSectionListPartMsgIntent {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isScrolling;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Pair<Integer, Integer> visiblePositionPair;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a<? extends List<?>, Boolean> state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnScrollStateChangeMsgIntent(@NotNull i<?> session, boolean z16, @NotNull Pair<Integer, Integer> visiblePositionPair, @NotNull a<? extends List<?>, Boolean> state) {
            super(session, null);
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(visiblePositionPair, "visiblePositionPair");
            Intrinsics.checkNotNullParameter(state, "state");
            this.isScrolling = z16;
            this.visiblePositionPair = visiblePositionPair;
            this.state = state;
        }

        @NotNull
        public final a<? extends List<?>, Boolean> a() {
            return this.state;
        }

        @NotNull
        public final Pair<Integer, Integer> b() {
            return this.visiblePositionPair;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsScrolling() {
            return this.isScrolling;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B;\u0012\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnScrolledChangeMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent;", "Lkotlin/Pair;", "", "e", "Lkotlin/Pair;", "b", "()Lkotlin/Pair;", "visiblePositionPair", "f", "a", "completelyVisiblePositionPair", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", SessionDbHelper.SESSION_ID, "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;Lkotlin/Pair;Lkotlin/Pair;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class OnScrolledChangeMsgIntent extends FeedSectionListPartMsgIntent {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Pair<Integer, Integer> visiblePositionPair;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Pair<Integer, Integer> completelyVisiblePositionPair;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnScrolledChangeMsgIntent(@NotNull i<?> session, @NotNull Pair<Integer, Integer> visiblePositionPair, @NotNull Pair<Integer, Integer> completelyVisiblePositionPair) {
            super(session, null);
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(visiblePositionPair, "visiblePositionPair");
            Intrinsics.checkNotNullParameter(completelyVisiblePositionPair, "completelyVisiblePositionPair");
            this.visiblePositionPair = visiblePositionPair;
            this.completelyVisiblePositionPair = completelyVisiblePositionPair;
        }

        @NotNull
        public final Pair<Integer, Integer> a() {
            return this.completelyVisiblePositionPair;
        }

        @NotNull
        public final Pair<Integer, Integer> b() {
            return this.visiblePositionPair;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnSortModeChangedMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent;", "", "e", "I", "a", "()I", "sortMode", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", SessionDbHelper.SESSION_ID, "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class OnSortModeChangedMsgIntent extends FeedSectionListPartMsgIntent {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int sortMode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSortModeChangedMsgIntent(@NotNull i<?> session, int i3) {
            super(session, null);
            Intrinsics.checkNotNullParameter(session, "session");
            this.sortMode = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getSortMode() {
            return this.sortMode;
        }
    }

    public /* synthetic */ FeedSectionListPartMsgIntent(i iVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(iVar);
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    FeedSectionListPartMsgIntent(i<?> iVar) {
        this.session = iVar;
    }
}
