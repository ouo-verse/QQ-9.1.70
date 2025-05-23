package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo;

import com.tencent.biz.qqcircle.events.QCirclePushAnimationEvent;
import com.tencent.biz.qqcircle.events.QCircleShareItemClickEvent;
import com.tencent.biz.qqcircle.events.QFSCommentSendEvent;
import com.tencent.biz.qqcircle.events.QFSPushTenTimesEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSLikeStateChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSDoublePraiseEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSSendFollowedReqEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoFeedPlayEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggerPositiveActionCollector;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000e\u000f\u0005B\u0007\u00a2\u0006\u0004\b$\u0010%J\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0012\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r*\u00020\fH\u0002J\f\u0010\u000f\u001a\u00020\u0006*\u00020\fH\u0002J$\u0010\u0013\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\u0010j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0011`\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J-\u0010\u001c\u001a\u00020\n2%\u0010\u001b\u001a!\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n0\u0016j\u0002`\u001aJ\u0006\u0010\u001d\u001a\u00020\nJ\u0016\u0010 \u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0006R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010!R9\u0010\u001b\u001a%\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010#\u00a8\u0006&"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/b$b;", "", "c", "", "action", "d", "actionType", "", "g", "Lfeedcloud/FeedCloudMeta$StFeed;", "", "a", "b", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "event", "onReceiveEvent", "Lkotlin/Function1;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/b$c;", "Lkotlin/ParameterName;", "name", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/PositiveActionTriggerCallback;", "triggerCallback", "e", "f", "feed", com.tencent.luggage.wxa.c8.c.G, tl.h.F, "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/b$b;", "curFeedInfo", "Lkotlin/jvm/functions/Function1;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CurFeedInfo curFeedInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super PositiveAction, Unit> triggerCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\n\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/b$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lfeedcloud/FeedCloudMeta$StFeed;", "a", "Lfeedcloud/FeedCloudMeta$StFeed;", "b", "()Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "I", "d", "()I", "feedPos", "", "c", "Ljava/util/List;", "()Ljava/util/List;", "actionList", "feedPlayTimeThresholdInSec", "<init>", "(Lfeedcloud/FeedCloudMeta$StFeed;ILjava/util/List;I)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes4.dex */
    public static final /* data */ class CurFeedInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FeedCloudMeta$StFeed feed;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int feedPos;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<Integer> actionList;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int feedPlayTimeThresholdInSec;

        public CurFeedInfo(@NotNull FeedCloudMeta$StFeed feed, int i3, @NotNull List<Integer> actionList, int i16) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            Intrinsics.checkNotNullParameter(actionList, "actionList");
            this.feed = feed;
            this.feedPos = i3;
            this.actionList = actionList;
            this.feedPlayTimeThresholdInSec = i16;
        }

        @NotNull
        public final List<Integer> a() {
            return this.actionList;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final FeedCloudMeta$StFeed getFeed() {
            return this.feed;
        }

        /* renamed from: c, reason: from getter */
        public final int getFeedPlayTimeThresholdInSec() {
            return this.feedPlayTimeThresholdInSec;
        }

        /* renamed from: d, reason: from getter */
        public final int getFeedPos() {
            return this.feedPos;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CurFeedInfo)) {
                return false;
            }
            CurFeedInfo curFeedInfo = (CurFeedInfo) other;
            if (Intrinsics.areEqual(this.feed, curFeedInfo.feed) && this.feedPos == curFeedInfo.feedPos && Intrinsics.areEqual(this.actionList, curFeedInfo.actionList) && this.feedPlayTimeThresholdInSec == curFeedInfo.feedPlayTimeThresholdInSec) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.feed.hashCode() * 31) + this.feedPos) * 31) + this.actionList.hashCode()) * 31) + this.feedPlayTimeThresholdInSec;
        }

        @NotNull
        public String toString() {
            String joinToString$default;
            String str = this.feed.f398449id.get();
            int i3 = this.feedPos;
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.actionList, null, null, null, 0, null, null, 63, null);
            return "CurFeedInfo(feed=" + str + ", feedPos=" + i3 + ", actionList=" + joinToString$default + ", feedPlayTimeThresholdInSec=" + this.feedPlayTimeThresholdInSec + " )";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0012\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/b$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "actionType", "Lfeedcloud/FeedCloudMeta$StFeed;", "b", "Lfeedcloud/FeedCloudMeta$StFeed;", "()Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "c", com.tencent.luggage.wxa.c8.c.G, "<init>", "(ILfeedcloud/FeedCloudMeta$StFeed;I)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.b$c, reason: from toString */
    /* loaded from: classes4.dex */
    public static final /* data */ class PositiveAction {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int actionType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FeedCloudMeta$StFeed feed;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int pos;

        public PositiveAction(int i3, @NotNull FeedCloudMeta$StFeed feed, int i16) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            this.actionType = i3;
            this.feed = feed;
            this.pos = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getActionType() {
            return this.actionType;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final FeedCloudMeta$StFeed getFeed() {
            return this.feed;
        }

        /* renamed from: c, reason: from getter */
        public final int getPos() {
            return this.pos;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PositiveAction)) {
                return false;
            }
            PositiveAction positiveAction = (PositiveAction) other;
            if (this.actionType == positiveAction.actionType && Intrinsics.areEqual(this.feed, positiveAction.feed) && this.pos == positiveAction.pos) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.actionType * 31) + this.feed.hashCode()) * 31) + this.pos;
        }

        @NotNull
        public String toString() {
            return "PositiveAction(actionType=" + this.actionType + ", pos=" + this.pos + ", feed=" + this.feed.f398449id.get() + ")";
        }
    }

    private final List<Integer> a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        List<Integer> emptyList;
        List<Integer> emptyList2;
        JSONArray optJSONArray;
        try {
            JSONObject a16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.a(feedCloudMeta$StFeed);
            if (a16 == null || (optJSONArray = a16.optJSONArray("actions")) == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList2;
            }
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(Integer.valueOf(optJSONArray.getInt(i3)));
            }
            return arrayList;
        } catch (JSONException e16) {
            QLog.e("QFSPublicAccountPositiveAction_Collector", 1, "getActionList, feed=" + feedCloudMeta$StFeed.f398449id.get() + ", e=" + e16.getMessage(), e16);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    private final int b(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        JSONObject a16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.a(feedCloudMeta$StFeed);
        if (a16 == null) {
            return Integer.MAX_VALUE;
        }
        return a16.optInt("play_time_threshold", Integer.MAX_VALUE);
    }

    private final boolean c(CurFeedInfo curFeedInfo) {
        return a.f86964a.a().contains(curFeedInfo.getFeed().f398449id.get());
    }

    private final boolean d(int action) {
        if (action == 0 || action == 1 || action == 2 || action == 3 || action == 14 || action == 26 || action == 27 || action == 28) {
            return true;
        }
        return false;
    }

    private final void g(int actionType) {
        QLog.i("QFSPublicAccountPositiveAction_Collector", 1, "triggerPositiveAction, actionType=" + actionType + ", curFeedInfo=" + this.curFeedInfo);
        CurFeedInfo curFeedInfo = this.curFeedInfo;
        if (curFeedInfo == null || curFeedInfo.a().isEmpty() || !curFeedInfo.a().contains(Integer.valueOf(actionType))) {
            return;
        }
        List<String> a16 = a.f86964a.a();
        String str = curFeedInfo.getFeed().f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str, "feedInfo.feed.id.get()");
        a16.add(str);
        PositiveAction positiveAction = new PositiveAction(actionType, curFeedInfo.getFeed(), curFeedInfo.getFeedPos());
        Function1<? super PositiveAction, Unit> function1 = this.triggerCallback;
        if (function1 != null) {
            function1.invoke(positiveAction);
        }
        QFSPublicAccountStaggerPositiveActionCollector.f86891a.e(positiveAction);
    }

    public final void e(@NotNull Function1<? super PositiveAction, Unit> triggerCallback) {
        Intrinsics.checkNotNullParameter(triggerCallback, "triggerCallback");
        QLog.i("QFSPublicAccountPositiveAction_Collector", 1, "startCollect");
        SimpleEventBus.getInstance().registerReceiver(this);
        this.triggerCallback = triggerCallback;
    }

    public final void f() {
        QLog.i("QFSPublicAccountPositiveAction_Collector", 1, "stopCollect");
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSVideoFeedPlayEvent.class, QFSSendFollowedReqEvent.class, QFSLikeStateChangeEvent.class, QFSDoublePraiseEvent.class, QCircleShareItemClickEvent.class, QFSCommentSendEvent.class, QFSPushTenTimesEvent.class, QCirclePushAnimationEvent.class);
        return arrayListOf;
    }

    public final void h(@NotNull FeedCloudMeta$StFeed feed, int pos) {
        String str;
        FeedCloudMeta$StFeed feed2;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(feed, "feed");
        String str2 = feed.f398449id.get();
        CurFeedInfo curFeedInfo = this.curFeedInfo;
        if (curFeedInfo != null && (feed2 = curFeedInfo.getFeed()) != null && (pBStringField = feed2.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str2, str)) {
            return;
        }
        CurFeedInfo curFeedInfo2 = new CurFeedInfo(feed, pos, a(feed), b(feed));
        this.curFeedInfo = curFeedInfo2;
        QLog.i("QFSPublicAccountPositiveAction_Collector", 1, "updateCurFeed, feedInfo=" + curFeedInfo2);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        CurFeedInfo curFeedInfo;
        if (event == null || (curFeedInfo = this.curFeedInfo) == null || c(curFeedInfo)) {
            return;
        }
        String str = curFeedInfo.getFeed().f398449id.get();
        if (event instanceof QFSVideoFeedPlayEvent) {
            QFSVideoFeedPlayEvent qFSVideoFeedPlayEvent = (QFSVideoFeedPlayEvent) event;
            if (!Intrinsics.areEqual(qFSVideoFeedPlayEvent.feedId, str) || qFSVideoFeedPlayEvent.progress / 1000 < curFeedInfo.getFeedPlayTimeThresholdInSec()) {
                return;
            }
            g(1);
            return;
        }
        if (event instanceof QFSSendFollowedReqEvent) {
            if (!Intrinsics.areEqual(((QFSSendFollowedReqEvent) event).getFeedId(), str)) {
                return;
            }
            g(2);
            return;
        }
        if (event instanceof QFSDoublePraiseEvent) {
            if (!Intrinsics.areEqual(((QFSDoublePraiseEvent) event).getFeedId(), str)) {
                return;
            }
            g(3);
            return;
        }
        if (event instanceof QFSLikeStateChangeEvent) {
            QFSLikeStateChangeEvent qFSLikeStateChangeEvent = (QFSLikeStateChangeEvent) event;
            if (Intrinsics.areEqual(qFSLikeStateChangeEvent.getFeedId(), str) && qFSLikeStateChangeEvent.getIsLike()) {
                g(3);
                return;
            }
            return;
        }
        if (event instanceof QCircleShareItemClickEvent) {
            if (d(((QCircleShareItemClickEvent) event).getAction())) {
                g(4);
            }
        } else if (event instanceof QFSCommentSendEvent) {
            if (!Intrinsics.areEqual(((QFSCommentSendEvent) event).mFeed.f398449id.get(), str)) {
                return;
            }
            g(5);
        } else if (event instanceof QFSPushTenTimesEvent) {
            if (!Intrinsics.areEqual(((QFSPushTenTimesEvent) event).mFeed.f398449id.get(), str)) {
                return;
            }
            g(6);
        } else {
            if (!(event instanceof QCirclePushAnimationEvent) || !Intrinsics.areEqual(((QCirclePushAnimationEvent) event).mTargetFeedId, str)) {
                return;
            }
            g(6);
        }
    }
}
