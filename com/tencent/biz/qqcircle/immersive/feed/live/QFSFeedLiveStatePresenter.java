package com.tencent.biz.qqcircle.immersive.feed.live;

import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSTurnPageEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqlive.api.room.IRequestRoomStatus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import feedcloud.FeedCloudMeta$RoomInfoData;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLive;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u00016\u0018\u0000 B2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001CB\u0007\u00a2\u0006\u0004\b@\u0010AJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0017\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010\u001f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u001eH\u0016J\u0016\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001e0!0 H\u0016R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010-\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0016\u0010/\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010'R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010?\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010<\u00a8\u0006D"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/live/QFSFeedLiveStatePresenter;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Lcom/tencent/biz/qqcircle/immersive/feed/live/PlayerErrorEvent;", "event", "", "t1", "q1", "", "lastTime", "", "u1", "w1", "r1", "x1", "", "w0", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedSelected", "data", "", "position", "v1", "onResumed", "onPaused", "onFeedUnSelected", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onViewHolderDetachedFromWindow", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "I", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "log", "J", "Z", "isSelected", "K", "isOnResume", "L", "isLiveOver", "M", "lastRefreshTime", "Lcom/tencent/mobileqq/qqlive/api/room/IRequestRoomStatus;", "N", "Lkotlin/Lazy;", ICustomDataEditor.STRING_PARAM_1, "()Lcom/tencent/mobileqq/qqlive/api/room/IRequestRoomStatus;", "roomStatusApi", "com/tencent/biz/qqcircle/immersive/feed/live/QFSFeedLiveStatePresenter$b", "P", "Lcom/tencent/biz/qqcircle/immersive/feed/live/QFSFeedLiveStatePresenter$b;", "liveStatusCallback", "Ljava/lang/Runnable;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/Runnable;", "delayTurnRunnable", BdhLogUtil.LogTag.Tag_Req, "delayDeleteRunnable", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSFeedLiveStatePresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final IAegisLogApi log;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isSelected;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isOnResume;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isLiveOver;

    /* renamed from: M, reason: from kotlin metadata */
    private long lastRefreshTime;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy roomStatusApi;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final b liveStatusCallback;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Runnable delayTurnRunnable;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Runnable delayDeleteRunnable;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/live/QFSFeedLiveStatePresenter$b", "Lcom/tencent/mobileqq/qqlive/api/room/IRequestRoomStatus$IRoomResult;", "", "roomId", "", "isLiving", "", "errCode", "", "errMsg", "", "onResult", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements IRequestRoomStatus.IRoomResult {
        b() {
        }

        @Override // com.tencent.mobileqq.qqlive.api.room.IRequestRoomStatus.IRoomResult
        public void onResult(long roomId, boolean isLiving, int errCode, @Nullable String errMsg) {
            QFSFeedLiveStatePresenter.this.log.i("LiveStatePresenter", "liveStatus onResult, roomId " + roomId + ", isLiving " + isLiving + ", code " + errCode + ", msg " + errMsg);
            if (errCode != 0 || QFSFeedLiveStatePresenter.this.isLiveOver == (!isLiving)) {
                return;
            }
            QFSFeedLiveStatePresenter.this.isLiveOver = !isLiving;
            QFSFeedLiveStatePresenter.this.log.i("LiveStatePresenter", "liveStatus onResult, isLiveOver " + QFSFeedLiveStatePresenter.this.isLiveOver + ", isSelected " + QFSFeedLiveStatePresenter.this.isSelected + ", isOnResume " + QFSFeedLiveStatePresenter.this.isOnResume);
            if (QFSFeedLiveStatePresenter.this.isLiveOver && QFSFeedLiveStatePresenter.this.isSelected) {
                QFSFeedLiveStatePresenter.this.x1();
            }
            SimpleEventBus.getInstance().dispatchEvent(new AnchorLiveStateChangeEvent(roomId, isLiving));
        }
    }

    public QFSFeedLiveStatePresenter() {
        Lazy lazy;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.log = (IAegisLogApi) api;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IRequestRoomStatus>() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.QFSFeedLiveStatePresenter$roomStatusApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IRequestRoomStatus invoke() {
                return (IRequestRoomStatus) QRoute.api(IRequestRoomStatus.class);
            }
        });
        this.roomStatusApi = lazy;
        this.liveStatusCallback = new b();
        this.delayTurnRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.u
            @Override // java.lang.Runnable
            public final void run() {
                QFSFeedLiveStatePresenter.p1(QFSFeedLiveStatePresenter.this);
            }
        };
        this.delayDeleteRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.v
            @Override // java.lang.Runnable
            public final void run() {
                QFSFeedLiveStatePresenter.o1(QFSFeedLiveStatePresenter.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void o1(QFSFeedLiveStatePresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.log.i("LiveStatePresenter", "execute delete runnable");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) this$0.f85017h;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        String str = feedCloudMeta$StFeed.f398449id.get();
        this$0.log.i("LiveStatePresenter", "delete id " + str);
        QCircleFeedEvent qCircleFeedEvent = new QCircleFeedEvent(3);
        qCircleFeedEvent.mTargetId = feedCloudMeta$StFeed.f398449id.get();
        SimpleEventBus.getInstance().dispatchEvent(qCircleFeedEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(QFSFeedLiveStatePresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.log.i("LiveStatePresenter", "execute turn page runnable");
        QCircleToast.i(QCircleToast.f91646f, R.string.f1914144q, 0);
        SimpleEventBus.getInstance().dispatchEvent(new QFSTurnPageEvent(1));
    }

    private final void q1() {
        if (!u1(this.lastRefreshTime)) {
            this.log.i("LiveStatePresenter", "Do not need refresh live status.");
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            this.log.i("LiveStatePresenter", "network not available return");
            return;
        }
        long r16 = r1();
        if (r16 == 0) {
            this.log.i("LiveStatePresenter", "illegal roomId, return");
        } else {
            this.lastRefreshTime = SystemClock.elapsedRealtime();
            s1().request(r16, this.liveStatusCallback);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long r1() {
        FeedCloudMeta$StLive feedCloudMeta$StLive;
        FeedCloudMeta$RoomInfoData feedCloudMeta$RoomInfoData;
        PBUInt64Field pBUInt64Field;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) this.f85017h;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StLive = feedCloudMeta$StFeed.live) != null && (feedCloudMeta$RoomInfoData = feedCloudMeta$StLive.room) != null && (pBUInt64Field = feedCloudMeta$RoomInfoData.roomId) != null) {
            return pBUInt64Field.get();
        }
        return 0L;
    }

    private final IRequestRoomStatus s1() {
        return (IRequestRoomStatus) this.roomStatusApi.getValue();
    }

    private final void t1(PlayerErrorEvent event) {
        this.log.i("LiveStatePresenter", "handlePlayerError");
        if (event.getRoomId() != r1()) {
            this.log.i("LiveStatePresenter", "handlePlayerError, roomId not match");
        } else {
            q1();
        }
    }

    private final boolean u1(long lastTime) {
        if (SystemClock.elapsedRealtime() - lastTime > 5000) {
            return true;
        }
        return false;
    }

    private final void w1() {
        if (this.isLiveOver) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.delayDeleteRunnable);
            RFWThreadManager.getUIHandler().postDelayed(this.delayDeleteRunnable, 500L);
        }
        this.isSelected = false;
        this.isLiveOver = false;
        RFWThreadManager.getUIHandler().removeCallbacks(this.delayTurnRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1() {
        this.log.i("LiveStatePresenter", "start turnPage");
        RFWThreadManager.getUIHandler().removeCallbacks(this.delayTurnRunnable);
        RFWThreadManager.getUIHandler().postDelayed(this.delayTurnRunnable, 500L);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(PlayerErrorEvent.class);
        Intrinsics.checkNotNullExpressionValue(eventClass, "super.getEventClass().ap\u2026nt::class.java)\n        }");
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedSelected(selectInfo);
        this.isSelected = true;
        q1();
        RFWThreadManager.getUIHandler().removeCallbacks(this.delayDeleteRunnable);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedUnSelected(selectInfo);
        w1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onPaused(selectInfo);
        this.isOnResume = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        super.onReceiveEvent(event);
        if (event instanceof PlayerErrorEvent) {
            t1((PlayerErrorEvent) event);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onResumed(selectInfo);
        this.isOnResume = true;
        q1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewHolderDetachedFromWindow(holder);
        w1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: v1, reason: merged with bridge method [inline-methods] */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        super.L0(data, position);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "LiveStatePresenter";
    }
}
