package com.tencent.qqguild.directmessage.service.impl;

import android.os.Handler;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.impl.GProGuildMsgRecvServiceImpl;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.feed.personalbox.IGuildFeedPersonalBoxUnreadService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqguild.directmessage.service.IFeedBoxSummaryService;
import com.tencent.qqguild.directmessage.service.impl.FeedBoxSummaryServiceImpl;
import com.tencent.qqnt.kernelgpro.nativeinterface.FirstViewDirectMsgNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAvChannelStateMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBeaconEventModel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBeaconStageModel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCheckInNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildTopFeedMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProManagerNotice;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNewPostAndSystemPromptNotifyFeedEventData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GuildInteractiveNotificationItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener;
import com.tencent.qqnt.kernelgpro.nativeinterface.e;
import com.tencent.qqnt.msg.data.FeedsBoxEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0001\u0003\u0018\u0000 42\u00020\u00012\u00020\u0002:\u0003567B\u0007\u00a2\u0006\u0004\b2\u00103J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0002J\u001b\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0016R\u001a\u0010 \u001a\u00020\u001f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00160$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010/R\u0014\u00100\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00068"}, d2 = {"Lcom/tencent/qqguild/directmessage/service/impl/FeedBoxSummaryServiceImpl;", "Lcom/tencent/qqguild/directmessage/service/IFeedBoxSummaryService;", "Lkotlinx/coroutines/CoroutineScope;", "com/tencent/qqguild/directmessage/service/impl/FeedBoxSummaryServiceImpl$c", "createKernelMsgObserver", "()Lcom/tencent/qqguild/directmessage/service/impl/FeedBoxSummaryServiceImpl$c;", "", "subscribeFeedsEvent", "Lcom/tencent/qqnt/msg/data/FeedsBoxEvent;", "event", "handleFeedEvent", "", "determineSummary", "", "determineLastEventTime", "summary", "dispatchEventOnMainThread", "(Lcom/tencent/qqnt/msg/data/FeedsBoxEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqguild/directmessage/service/IFeedBoxSummaryService$a;", "listener", "registerSummaryUpdateListener", "unregisterSummaryUpdateListener", "markRead", "", "switchType", "updateRedPointStatus", "latestSummary", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/qqguild/directmessage/service/impl/FeedBoxSummaryServiceImpl$FeedBoxUnreadStore;", "feedBoxUnreadStore", "Lcom/tencent/qqguild/directmessage/service/impl/FeedBoxSummaryServiceImpl$FeedBoxUnreadStore;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "feedBoxStoreDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "latestFeedsBoxEvent", "Lcom/tencent/qqnt/msg/data/FeedsBoxEvent;", "Lmqq/app/AppRuntime;", "kernelObserver", "Lcom/tencent/qqguild/directmessage/service/impl/FeedBoxSummaryServiceImpl$c;", "<init>", "()V", "Companion", "a", "FeedBoxUnreadStore", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class FeedBoxSummaryServiceImpl implements IFeedBoxSummaryService, CoroutineScope {

    @NotNull
    public static final String TAG = "Guild.C2C.AIO.FeedBoxSummaryServiceImpl";
    private AppRuntime appRuntime;

    @Nullable
    private FeedsBoxEvent latestFeedsBoxEvent;

    @NotNull
    private static final AtomicInteger sequenceGenerator = new AtomicInteger(1);

    @NotNull
    private final CoroutineContext coroutineContext = Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));

    @NotNull
    private final CopyOnWriteArrayList<IFeedBoxSummaryService.a> listeners = new CopyOnWriteArrayList<>();

    @NotNull
    private final FeedBoxUnreadStore feedBoxUnreadStore = new FeedBoxUnreadStore();

    @NotNull
    private final ExecutorCoroutineDispatcher feedBoxStoreDispatcher = com.tencent.qqguild.base.mvvm.a.f344983a.a();

    @NotNull
    private final c kernelObserver = createKernelMsgObserver();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0002R\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqguild/directmessage/service/impl/FeedBoxSummaryServiceImpl$FeedBoxUnreadStore;", "", "", "unreadCount", "", "timestamp", "", h.F, "", "feedId", "d", "e", "g", "a", "J", "f", "()J", "setBaseTimestamp", "(J)V", "baseTimestamp", "b", "I", "baseUnreadCount", "Ljava/util/PriorityQueue;", "Lcom/tencent/qqguild/directmessage/service/impl/FeedBoxSummaryServiceImpl$b;", "c", "Ljava/util/PriorityQueue;", "priorityQueue", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class FeedBoxUnreadStore {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long baseTimestamp;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int baseUnreadCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final PriorityQueue<FeedEvent> priorityQueue;

        public FeedBoxUnreadStore() {
            final FeedBoxSummaryServiceImpl$FeedBoxUnreadStore$priorityQueue$1 feedBoxSummaryServiceImpl$FeedBoxUnreadStore$priorityQueue$1 = new Function2<FeedEvent, FeedEvent, Integer>() { // from class: com.tencent.qqguild.directmessage.service.impl.FeedBoxSummaryServiceImpl$FeedBoxUnreadStore$priorityQueue$1
                @Override // kotlin.jvm.functions.Function2
                @NotNull
                public final Integer invoke(FeedBoxSummaryServiceImpl.FeedEvent feedEvent, FeedBoxSummaryServiceImpl.FeedEvent feedEvent2) {
                    return Integer.valueOf(feedEvent.getLastTime() < feedEvent2.getLastTime() ? -1 : feedEvent.getLastTime() > feedEvent2.getLastTime() ? 1 : 0);
                }
            };
            this.priorityQueue = new PriorityQueue<>(100, new Comparator() { // from class: com.tencent.qqguild.directmessage.service.impl.a
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int i3;
                    i3 = FeedBoxSummaryServiceImpl.FeedBoxUnreadStore.i(Function2.this, obj, obj2);
                    return i3;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int i(Function2 tmp0, Object obj, Object obj2) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return ((Number) tmp0.invoke(obj, obj2)).intValue();
        }

        public final void d(@NotNull String feedId, long timestamp) {
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d(FeedBoxSummaryServiceImpl.TAG, 2, "addUnread: " + feedId + ", " + timestamp);
            }
            this.priorityQueue.add(new FeedEvent(timestamp, feedId));
            while (this.priorityQueue.size() > 100) {
                FeedEvent remove = this.priorityQueue.remove();
                Logger logger2 = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger2.d().d(FeedBoxSummaryServiceImpl.TAG, 2, "remove: " + remove);
                }
            }
        }

        public final void e(long timestamp) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d(FeedBoxSummaryServiceImpl.TAG, 2, "clearUnreadByTimestamp(" + timestamp + ")");
            }
            if (timestamp >= this.baseTimestamp) {
                this.baseTimestamp = timestamp;
                this.baseUnreadCount = 0;
                if (QLog.isColorLevel()) {
                    logger.d().d(FeedBoxSummaryServiceImpl.TAG, 2, "clearUnreadByTimestamp: clear base timestamp");
                }
            }
            ArrayList arrayList = new ArrayList();
            while (true) {
                boolean z16 = true;
                if (!(!this.priorityQueue.isEmpty())) {
                    break;
                }
                FeedEvent peek = this.priorityQueue.peek();
                if (peek == null) {
                    z16 = false;
                }
                if (z16) {
                    if (peek.getLastTime() > timestamp) {
                        break;
                    }
                    arrayList.add(Long.valueOf(peek.getLastTime()));
                    this.priorityQueue.remove();
                } else {
                    throw new IllegalStateException("never reach here".toString());
                }
            }
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d(FeedBoxSummaryServiceImpl.TAG, 2, "clearUnreadByTimestamp: removed timestamps: " + arrayList + ", unreadCount is " + g());
            }
        }

        /* renamed from: f, reason: from getter */
        public final long getBaseTimestamp() {
            return this.baseTimestamp;
        }

        public final int g() {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d(FeedBoxSummaryServiceImpl.TAG, 2, "getUnreadCount: " + this.priorityQueue.size() + " + " + this.baseUnreadCount);
            }
            return this.priorityQueue.size() + this.baseUnreadCount;
        }

        public final void h(int unreadCount, long timestamp) {
            this.priorityQueue.clear();
            this.baseUnreadCount = unreadCount;
            this.baseTimestamp = timestamp;
            Logger.f235387a.d().i(FeedBoxSummaryServiceImpl.TAG, 1, "initUnreadState(" + this.baseUnreadCount + ", " + getBaseTimestamp() + "), unreadCount is " + g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqguild/directmessage/service/impl/FeedBoxSummaryServiceImpl$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "lastTime", "b", "Ljava/lang/String;", "getFeedId", "()Ljava/lang/String;", "feedId", "<init>", "(JLjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqguild.directmessage.service.impl.FeedBoxSummaryServiceImpl$b, reason: from toString */
    /* loaded from: classes22.dex */
    public static final /* data */ class FeedEvent {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long lastTime;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String feedId;

        public FeedEvent(long j3, @NotNull String feedId) {
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            this.lastTime = j3;
            this.feedId = feedId;
        }

        /* renamed from: a, reason: from getter */
        public final long getLastTime() {
            return this.lastTime;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeedEvent)) {
                return false;
            }
            FeedEvent feedEvent = (FeedEvent) other;
            if (this.lastTime == feedEvent.lastTime && Intrinsics.areEqual(this.feedId, feedEvent.feedId)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (androidx.fragment.app.a.a(this.lastTime) * 31) + this.feedId.hashCode();
        }

        @NotNull
        public String toString() {
            return "FeedEvent(lastTime=" + this.lastTime + ", feedId=" + this.feedId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqguild/directmessage/service/impl/FeedBoxSummaryServiceImpl$c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGProGuildMsgListener;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/FirstViewDirectMsgNotifyInfo;", "notifyInfo", "", "onFeedEventUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements IKernelGProGuildMsgListener {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(FeedsBoxEvent feedsBoxEvent, FeedBoxSummaryServiceImpl this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            System.currentTimeMillis();
            if (feedsBoxEvent != null) {
                this$0.handleFeedEvent(feedsBoxEvent);
            }
            System.currentTimeMillis();
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onBeaconReportCount(GProBeaconEventModel gProBeaconEventModel, GProBeaconStageModel gProBeaconStageModel) {
            e.a(this, gProBeaconEventModel, gProBeaconStageModel);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onBeaconReportStage(GProBeaconEventModel gProBeaconEventModel, ArrayList arrayList) {
            e.b(this, gProBeaconEventModel, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onFeedEventUpdate(@Nullable FirstViewDirectMsgNotifyInfo notifyInfo) {
            Integer num;
            final FeedsBoxEvent feedsBoxEvent = null;
            if (notifyInfo != null) {
                GProGuildMsgRecvServiceImpl.Companion companion = GProGuildMsgRecvServiceImpl.INSTANCE;
                ArrayList<Integer> feedAtTypes = notifyInfo.getFeedAtTypes();
                Intrinsics.checkNotNullExpressionValue(feedAtTypes, "it.feedAtTypes");
                num = Integer.valueOf(companion.a(feedAtTypes));
            } else {
                num = null;
            }
            if (num == null || num.intValue() != 64) {
                if (notifyInfo != null) {
                    feedsBoxEvent = FeedsBoxEvent.INSTANCE.a(notifyInfo, FeedsBoxEvent.FromType.UPDATE_EVENT_PUSH);
                }
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final FeedBoxSummaryServiceImpl feedBoxSummaryServiceImpl = FeedBoxSummaryServiceImpl.this;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.qqguild.directmessage.service.impl.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        FeedBoxSummaryServiceImpl.c.b(FeedsBoxEvent.this, feedBoxSummaryServiceImpl);
                    }
                });
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildAvChannelOpenUpdate(GProAvChannelStateMsg gProAvChannelStateMsg) {
            e.d(this, gProAvChannelStateMsg);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildCheckInNotify(GProCheckInNotifyInfo gProCheckInNotifyInfo) {
            e.e(this, gProCheckInNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildHelperNotifySwitchUpdate(HashMap hashMap) {
            e.f(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildInteractiveUpdate(GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
            e.g(this, guildInteractiveNotificationItem);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildManagerEventUpdate(GProManagerNotice gProManagerNotice) {
            e.h(this, gProManagerNotice);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildNewPostEvent(GProNewPostAndSystemPromptNotifyFeedEventData gProNewPostAndSystemPromptNotifyFeedEventData) {
            e.i(this, gProNewPostAndSystemPromptNotifyFeedEventData);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildScheduleNotify(GProScheduleNotifyInfo gProScheduleNotifyInfo) {
            e.j(this, gProScheduleNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildTopFeedUpdate(GProGuildTopFeedMsg gProGuildTopFeedMsg) {
            e.k(this, gProGuildTopFeedMsg);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onMsgAbstractUpdate(ArrayList arrayList) {
            e.l(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onUnreadCntAfterFirstView(HashMap hashMap) {
            e.m(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onUnreadCntUpdate(HashMap hashMap) {
            e.n(this, hashMap);
        }
    }

    private final c createKernelMsgObserver() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long determineLastEventTime(FeedsBoxEvent event) {
        if (event.d() == FeedsBoxEvent.FromType.READ_EVENT_PUSH) {
            FeedsBoxEvent feedsBoxEvent = this.latestFeedsBoxEvent;
            if (feedsBoxEvent != null) {
                return feedsBoxEvent.e();
            }
            return event.e();
        }
        return event.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String determineSummary(FeedsBoxEvent event) {
        boolean z16;
        String g16;
        if (event.d() == FeedsBoxEvent.FromType.READ_EVENT_PUSH) {
            if (event.g().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                FeedsBoxEvent feedsBoxEvent = this.latestFeedsBoxEvent;
                if (feedsBoxEvent == null || (g16 = feedsBoxEvent.g()) == null) {
                    return "";
                }
                return g16;
            }
        }
        return event.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object dispatchEventOnMainThread(FeedsBoxEvent feedsBoxEvent, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object withContext = BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new FeedBoxSummaryServiceImpl$dispatchEventOnMainThread$2(this, feedsBoxEvent, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (withContext == coroutine_suspended) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleFeedEvent(FeedsBoxEvent event) {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new FeedBoxSummaryServiceImpl$handleFeedEvent$1(this, event, null), 3, null);
    }

    private final void subscribeFeedsEvent() {
        long currentTimeMillis = System.currentTimeMillis();
        sequenceGenerator.getAndIncrement();
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.addKernelGProGuildMsgListener(this.kernelObserver);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        Logger.f235387a.d().i(TAG, 1, "subscribeFeedsEvent: cost " + currentTimeMillis2 + " ms");
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // com.tencent.qqguild.directmessage.service.IFeedBoxSummaryService
    @Nullable
    /* renamed from: latestSummary, reason: from getter */
    public FeedsBoxEvent getLatestFeedsBoxEvent() {
        return this.latestFeedsBoxEvent;
    }

    @Override // com.tencent.qqguild.directmessage.service.IFeedBoxSummaryService
    public void markRead() {
        FeedsBoxEvent feedsBoxEvent = this.latestFeedsBoxEvent;
        if (feedsBoxEvent == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("markRead: previousFeedBoxEvent is null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it.next(), null);
            }
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d(TAG, 2, "markRead - " + feedsBoxEvent);
        }
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGuildFeedPersonalBoxUnreadService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        ((IGuildFeedPersonalBoxUnreadService) S0).reportFeedRead(feedsBoxEvent.e());
        handleFeedEvent(FeedsBoxEvent.b(feedsBoxEvent, false, 0, null, 0L, null, FeedsBoxEvent.FromType.READ_EVENT_PUSH, 0, 95, null));
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        this.appRuntime = appRuntime;
        subscribeFeedsEvent();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        JobKt__JobKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        this.latestFeedsBoxEvent = null;
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.z(this.kernelObserver);
        }
    }

    @Override // com.tencent.qqguild.directmessage.service.IFeedBoxSummaryService
    public void registerSummaryUpdateListener(@NotNull IFeedBoxSummaryService.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d(TAG, 2, "registerSummaryUpdateListener: " + listener);
        }
        if (!this.listeners.addIfAbsent(listener)) {
            IllegalStateException illegalStateException = new IllegalStateException();
            Logger.b bVar = new Logger.b();
            bVar.a().add("registerSummaryUpdateListener: listener already exist");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it.next(), illegalStateException);
            }
        }
    }

    @Override // com.tencent.qqguild.directmessage.service.IFeedBoxSummaryService
    public void unregisterSummaryUpdateListener(@NotNull IFeedBoxSummaryService.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d(TAG, 2, "unregisterSummaryUpdateListener: " + listener);
        }
        this.listeners.remove(listener);
    }

    @Override // com.tencent.qqguild.directmessage.service.IFeedBoxSummaryService
    public void updateRedPointStatus(int switchType) {
        FeedsBoxEvent feedsBoxEvent = this.latestFeedsBoxEvent;
        if (feedsBoxEvent == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("updateRedPointStatus: previousFeedBoxEvent is null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it.next(), null);
            }
            return;
        }
        handleFeedEvent(FeedsBoxEvent.b(feedsBoxEvent, false, 0, null, 0L, null, FeedsBoxEvent.FromType.NOTIFY_SWITCH_PUSH, switchType, 31, null));
    }
}
