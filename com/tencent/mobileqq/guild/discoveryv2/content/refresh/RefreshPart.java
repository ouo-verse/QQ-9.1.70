package com.tencent.mobileqq.guild.discoveryv2.content.refresh;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.guild.api.util.IGuildUtilApi;
import com.tencent.hippy.qq.view.scroll.HippyHeaderScrollViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDiscoverApi;
import com.tencent.mobileqq.guild.discoveryv2.content.base.f;
import com.tencent.mobileqq.guild.discoveryv2.content.model.LoadMoreType;
import com.tencent.mobileqq.guild.discoveryv2.content.model.k;
import com.tencent.mobileqq.guild.discoveryv2.content.part.MVPFeedsPart;
import com.tencent.mobileqq.guild.discoveryv2.content.util.ContentMessage;
import com.tencent.mobileqq.guild.discoveryv2.util.ExtKt;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshHeader;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import com.tencent.richframework.widget.refresh.layout.simple.SimpleMultiListener;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qh1.LastFetchFeedTime;
import qh1.MVPFeedsRefreshUIState;
import qh1.MVPFeedsUIState;
import qh1.d;
import tl.h;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ;2\u00020\u0001:\u0002<=B\u000f\u0012\u0006\u0010$\u001a\u00020\u001f\u00a2\u0006\u0004\b9\u0010:J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u001c\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00040\u001bR\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001c\u00108\u001a\b\u0012\u0004\u0012\u000205048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/RefreshPart;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/part/MVPFeedsPart;", "", "args", "", "L9", "", "callSource", "J9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartPause", "onPartResume", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Lqh1/e;", "viewState", "O9", "action", "handleBroadcastMessage", "onPartDestroy", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lkotlin/Function1;", "", "lockImpl", "P9", "Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/RefreshPart$b;", "e", "Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/RefreshPart$b;", "getConfig", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/RefreshPart$b;", DownloadInfo.spKey_Config, "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "f", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/f;", h.F, "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/f;", "contentLoadMoreAdapter", "i", "Z", "isPaused", "Lhr0/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lhr0/c;", "guardManagerDelegate", "Lkotlinx/coroutines/flow/StateFlow;", "Lqh1/a;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlinx/coroutines/flow/StateFlow;", "lastFetchTimeFLow", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/RefreshPart$b;)V", "D", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RefreshPart extends MVPFeedsPart {
    private static float E = 1.0f;

    /* renamed from: C, reason: from kotlin metadata */
    private StateFlow<LastFetchFeedTime> lastFetchTimeFLow;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b config;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private f contentLoadMoreAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isPaused;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private hr0.c guardManagerDelegate;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/RefreshPart$b;", "", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "", "b", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes13.dex */
        public static final class a {
            public static boolean a(@NotNull b bVar) {
                return false;
            }

            public static void b(@NotNull b bVar, @NotNull SmartRefreshLayout refreshLayout) {
                Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            }
        }

        void b(@NotNull SmartRefreshLayout refreshLayout);

        boolean c();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/refresh/RefreshPart$c", "Lhr0/b;", "", "isAppOnForeground", "", "onAppForegroundChange", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements hr0.b {
        c() {
        }

        @Override // hr0.b
        public void onAppForegroundChange(boolean isAppOnForeground) {
            if (!RefreshPart.this.isPaused && isAppOnForeground) {
                RefreshPart.this.J9("onAppForegroundChange");
            }
        }
    }

    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J:\u0010\u0013\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/refresh/RefreshPart$e", "Lcom/tencent/richframework/widget/refresh/layout/simple/SimpleMultiListener;", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshLayout;", "refreshLayout", "Lcom/tencent/richframework/widget/refresh/layout/constant/RefreshState;", "oldState", "newState", "", "onStateChanged", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshHeader;", "header", "", "isDragging", "", "percent", "", "offset", HippyHeaderScrollViewController.HEADER_HEIGHT, "maxDragHeight", "onHeaderMoving", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e extends SimpleMultiListener {
        final /* synthetic */ int C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView f217382d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f217383e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Job> f217384f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f217385h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<LifecycleCoroutineScope> f217386i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ long f217387m;

        /* JADX WARN: Multi-variable type inference failed */
        e(RecyclerView recyclerView, Ref.BooleanRef booleanRef, Ref.ObjectRef<Job> objectRef, Function1<? super Boolean, Unit> function1, Ref.ObjectRef<LifecycleCoroutineScope> objectRef2, long j3, int i3) {
            this.f217382d = recyclerView;
            this.f217383e = booleanRef;
            this.f217384f = objectRef;
            this.f217385h = function1;
            this.f217386i = objectRef2;
            this.f217387m = j3;
            this.C = i3;
        }

        @Override // com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener
        public void onHeaderMoving(@Nullable IRefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
            Log.d("renderAutoLock", "onHeaderMoving: " + isDragging + " " + percent + " " + offset);
            s sVar = s.f235620a;
            int i3 = this.C;
            Ref.BooleanRef booleanRef = this.f217383e;
            Ref.ObjectRef<Job> objectRef = this.f217384f;
            Function1<Boolean, Unit> function1 = this.f217385h;
            if (!isDragging && offset <= i3) {
                try {
                    RefreshPart.R9(booleanRef, objectRef, function1, "headHeightThreshold");
                } catch (Exception e16) {
                    s.f("DiscoveryV2.ContentRefreshPart", "".toString(), e16);
                }
            }
        }

        @Override // com.tencent.richframework.widget.refresh.layout.listener.OnStateChangedListener
        public void onStateChanged(@NotNull IRefreshLayout refreshLayout, @NotNull RefreshState oldState, @NotNull RefreshState newState) {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(newState, "newState");
            s sVar = s.f235620a;
            RecyclerView recyclerView = this.f217382d;
            Ref.BooleanRef booleanRef = this.f217383e;
            Ref.ObjectRef<Job> objectRef = this.f217384f;
            Function1<Boolean, Unit> function1 = this.f217385h;
            Ref.ObjectRef<LifecycleCoroutineScope> objectRef2 = this.f217386i;
            long j3 = this.f217387m;
            try {
                QLog.i("DiscoveryV2.ContentRefreshPart", 1, oldState + " -> " + newState);
                if (newState == RefreshState.None) {
                    RefreshPart.R9(booleanRef, objectRef, function1, "state");
                } else if (newState == RefreshState.PullDownCanceled && recyclerView.getChildCount() > 5) {
                    RefreshPart.Q9(booleanRef, objectRef, objectRef2, function1, j3, "PullDownCanceled");
                } else if (newState == RefreshState.RefreshReleased && recyclerView.getChildCount() > 5) {
                    RefreshPart.Q9(booleanRef, objectRef, objectRef2, function1, j3, "RefreshReleased");
                }
            } catch (Exception e16) {
                s.f("DiscoveryV2.ContentRefreshPart", "".toString(), e16);
            }
        }
    }

    public RefreshPart(@NotNull b config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(final String callSource) {
        int a16 = th1.a.INSTANCE.a().a("discoverCacheRefreshInterval", 60) * 60 * 1000;
        long currentTimeMillis = System.currentTimeMillis();
        StateFlow<LastFetchFeedTime> stateFlow = this.lastFetchTimeFLow;
        if (stateFlow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lastFetchTimeFLow");
            stateFlow = null;
        }
        long time = currentTimeMillis - stateFlow.getValue().getTime();
        if (time > a16) {
            QLog.i("DiscoveryV2.ContentRefreshPart", 1, "checkForceRefresh timeInterval = " + time + ", refreshInterval: " + a16);
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                L9(new ContentMessage.TriggerJumpTopAndPullToRefresh(callSource));
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.refresh.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        RefreshPart.K9(RefreshPart.this, callSource);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(RefreshPart this$0, String callSource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callSource, "$callSource");
        this$0.L9(new ContentMessage.TriggerJumpTopAndPullToRefresh(callSource));
    }

    private final void L9(Object args) {
        broadcastMessage("message_scroll_to_top_position", new ContentMessage.ScrollToPositionMessage(0, "DiscoveryV2.ContentRefreshPart"));
        Logger logger = Logger.f235387a;
        Logger.a d16 = logger.d();
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        SmartRefreshLayout smartRefreshLayout2 = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        d16.i("DiscoveryV2.ContentRefreshPart", 1, "handleTriggerJumpAndPullToRefresh state " + smartRefreshLayout.getState());
        SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout3 = null;
        }
        if (smartRefreshLayout3.getState() != RefreshState.Refreshing) {
            SmartRefreshLayout smartRefreshLayout4 = this.refreshLayout;
            if (smartRefreshLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout4 = null;
            }
            if (smartRefreshLayout4.getState() != RefreshState.PullDownToRefresh) {
                SmartRefreshLayout smartRefreshLayout5 = this.refreshLayout;
                if (smartRefreshLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                } else {
                    smartRefreshLayout2 = smartRefreshLayout5;
                }
                smartRefreshLayout2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.refresh.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        RefreshPart.M9(RefreshPart.this);
                    }
                });
                return;
            }
        }
        logger.d().i("DiscoveryV2.ContentRefreshPart", 1, "handleTriggerJumpAndPullToRefresh isRefreshing");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(RefreshPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SmartRefreshLayout smartRefreshLayout = this$0.refreshLayout;
        SmartRefreshLayout smartRefreshLayout2 = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        if (smartRefreshLayout.autoRefresh(0, 300, E, false)) {
            Logger.f235387a.d().i("DiscoveryV2.ContentRefreshPart", 1, "handleTriggerJumpAndPullToRefresh autoRefresh Success");
            return;
        }
        SmartRefreshLayout smartRefreshLayout3 = this$0.refreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.closeHeaderOrFooter();
        SmartRefreshLayout smartRefreshLayout4 = this$0.refreshLayout;
        if (smartRefreshLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            smartRefreshLayout2 = smartRefreshLayout4;
        }
        boolean autoRefresh = smartRefreshLayout2.autoRefresh(0, 300, E, false);
        Logger.f235387a.d().i("DiscoveryV2.ContentRefreshPart", 1, "handleTriggerJumpAndPullToRefresh autoRefresh Failed retry " + autoRefresh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(RefreshPart this$0, IRefreshLayout it) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("dt_pgid", ci1.a.c()), TuplesKt.to("cur_pg", ci1.a.d()), TuplesKt.to("eid", "em_sgrp_discover_mine_pulldown_update"));
        VideoReport.reportEvent("clck", mapOf);
        this$0.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v6, types: [T, kotlinx.coroutines.Job] */
    public static final void Q9(Ref.BooleanRef booleanRef, Ref.ObjectRef<Job> objectRef, Ref.ObjectRef<LifecycleCoroutineScope> objectRef2, Function1<? super Boolean, Unit> function1, long j3, String str) {
        ?? launch$default;
        if (booleanRef.element) {
            return;
        }
        booleanRef.element = true;
        Job job = objectRef.element;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(objectRef2.element, null, null, new RefreshPart$renderAutoLock$lock$1(j3, booleanRef, objectRef, function1, null), 3, null);
        objectRef.element = launch$default;
        function1.invoke(Boolean.TRUE);
        QLog.i("DiscoveryV2.ContentRefreshPart", 1, "renderAutoLock lock " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Ref.BooleanRef booleanRef, Ref.ObjectRef<Job> objectRef, Function1<? super Boolean, Unit> function1, String str) {
        if (!booleanRef.element) {
            return;
        }
        booleanRef.element = false;
        Job job = objectRef.element;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        objectRef.element = null;
        function1.invoke(Boolean.FALSE);
        QLog.i("DiscoveryV2.ContentRefreshPart", 1, "renderAutoLock unlock " + str);
    }

    public final void O9(@NotNull MVPFeedsUIState viewState) {
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        MVPFeedsRefreshUIState refreshState = viewState.getRefreshState();
        k refreshType = refreshState.getRefreshType();
        f fVar = null;
        boolean z16 = false;
        if (refreshType instanceof k.b) {
            if (viewState.f() instanceof d.c) {
                SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
                if (smartRefreshLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                    smartRefreshLayout = null;
                }
                smartRefreshLayout.autoRefresh(0, 0, E, false);
            }
        } else if (refreshType instanceof k.RefreshFinish) {
            SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
            if (smartRefreshLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout2 = null;
            }
            smartRefreshLayout2.finishRefresh();
        }
        f fVar2 = this.contentLoadMoreAdapter;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLoadMoreAdapter");
        } else {
            fVar = fVar2;
        }
        if (refreshState.getLoadMoreType() != LoadMoreType.NONE) {
            z16 = true;
        }
        fVar.j0(z16, viewState.getRefreshState().getIsEnd(), viewState.getRefreshState().getEndMsg());
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.lifecycle.LifecycleCoroutineScope, T] */
    public final void P9(@NotNull RecyclerView recyclerView, @NotNull Function1<? super Boolean, Unit> lockImpl) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(lockImpl, "lockImpl");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = com.tencent.mobileqq.guild.discoveryv2.content.part.d.b(this);
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setOnMultiListener(new e(recyclerView, booleanRef, objectRef2, lockImpl, objectRef, 2000L, 3));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "message_guild_tab_selected")) {
            J9("onSwitchToGuildTab");
        } else if (Intrinsics.areEqual(action, "message_trigger_jump_and_pull_to_refresh")) {
            L9(args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        ViewGroup.LayoutParams layoutParams;
        View view;
        View view2;
        if (QQGuildUIUtil.z()) {
            SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
            SmartRefreshLayout smartRefreshLayout2 = null;
            if (smartRefreshLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout = null;
            }
            IRefreshHeader refreshHeader = smartRefreshLayout.getRefreshHeader();
            if (refreshHeader != null && (view2 = refreshHeader.getView()) != null) {
                layoutParams = view2.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.width = x9().getContentWidth();
            }
            SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
            if (smartRefreshLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            } else {
                smartRefreshLayout2 = smartRefreshLayout3;
            }
            IRefreshHeader refreshHeader2 = smartRefreshLayout2.getRefreshHeader();
            if (refreshHeader2 != null && (view = refreshHeader2.getView()) != null) {
                view.requestLayout();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        View view2;
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = null;
        Object broadcastGetMessage = broadcastGetMessage("message_get_load_more_adapter", null);
        Intrinsics.checkNotNull(broadcastGetMessage, "null cannot be cast to non-null type com.tencent.mobileqq.guild.discoveryv2.content.base.ContentLoadMoreAdapter");
        this.contentLoadMoreAdapter = (f) broadcastGetMessage;
        Object broadcastGetMessage2 = broadcastGetMessage(Reflection.getOrCreateKotlinClass(LastFetchFeedTime.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(LastFetchFeedTime.class));
        Intrinsics.checkNotNull(broadcastGetMessage2, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of com.tencent.mobileqq.guild.discoveryv2.content.part.MVPFeedsPart.getStateFlow>");
        this.lastFetchTimeFLow = (StateFlow) broadcastGetMessage2;
        hr0.c createGuardManagerDelegate = ((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).createGuardManagerDelegate(new c());
        this.guardManagerDelegate = createGuardManagerDelegate;
        if (createGuardManagerDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guardManagerDelegate");
            createGuardManagerDelegate = null;
        }
        createGuardManagerDelegate.onCreate();
        View findViewById = rootView.findViewById(R.id.uix);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026iscovery_v2_refresh_root)");
        this.refreshLayout = (SmartRefreshLayout) findViewById;
        Object broadcastGetMessage3 = broadcastGetMessage(Reflection.getOrCreateKotlinClass(MVPFeedsUIState.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(MVPFeedsUIState.class));
        Intrinsics.checkNotNull(broadcastGetMessage3, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of com.tencent.mobileqq.guild.discoveryv2.content.part.MVPFeedsPart.getStateFlow>");
        final StateFlow stateFlow = (StateFlow) broadcastGetMessage3;
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        Flow<Unit> a16 = ExtKt.a(smartRefreshLayout);
        LifecycleOwner a17 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        Lifecycle.State state = Lifecycle.State.STARTED;
        Lifecycle lifecycle = a17.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "owner.lifecycle");
        LifecycleKt.getCoroutineScope(lifecycle).launchWhenCreated(new RefreshPart$onInitView$$inlined$collectIn$default$1(lifecycle, state, a16, null, this, stateFlow));
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.setOnRefreshListener(new OnRefreshListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.refresh.c
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                RefreshPart.N9(RefreshPart.this, iRefreshLayout);
            }
        });
        f fVar = this.contentLoadMoreAdapter;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLoadMoreAdapter");
            fVar = null;
        }
        fVar.registerLoadMoreListener(new d());
        Flow distinctUntilChangedBy = FlowKt.distinctUntilChangedBy(stateFlow, new Function1<MVPFeedsUIState, MVPFeedsRefreshUIState>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.refresh.RefreshPart$onInitView$5
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final MVPFeedsRefreshUIState invoke(@NotNull MVPFeedsUIState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getRefreshState();
            }
        });
        Lifecycle lifecycle2 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this).getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle2, "owner.lifecycle");
        LifecycleKt.getCoroutineScope(lifecycle2).launchWhenCreated(new RefreshPart$onInitView$$inlined$collectIn$default$2(lifecycle2, state, distinctUntilChangedBy, null, this));
        if (this.config.c()) {
            SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
            if (smartRefreshLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout3 = null;
            }
            Iterator<View> it = ViewGroupKt.getChildren(smartRefreshLayout3).iterator();
            while (true) {
                if (it.hasNext()) {
                    view2 = it.next();
                    if (view2 instanceof RecyclerView) {
                        break;
                    }
                } else {
                    view2 = null;
                    break;
                }
            }
            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            final RecyclerView recyclerView = (RecyclerView) view2;
            P9(recyclerView, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.refresh.RefreshPart$onInitView$7
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    Object m476constructorimpl;
                    QLog.i("DiscoveryV2.ContentRefreshPart", 1, "renderAutoLock lockImpl: " + z16);
                    RecyclerView recyclerView2 = recyclerView;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        recyclerView2.suppressLayout(z16);
                        m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th5) {
                        Result.Companion companion2 = Result.INSTANCE;
                        m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                    }
                    Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                    if (m479exceptionOrNullimpl != null) {
                        QLog.i("DiscoveryV2.ContentRefreshPart", 1, "renderAutoLock " + m479exceptionOrNullimpl);
                    }
                    if (z16 || stateFlow.getValue().getListState().getSource() != 2) {
                        return;
                    }
                    QLog.i("DiscoveryV2.ContentRefreshPart", 1, "renderAutoLock postGuildTabLoadingFinished");
                    ((IGuildDiscoverApi) QRoute.api(IGuildDiscoverApi.class)).postGuildTabLoadingFinished();
                }
            });
        }
        b bVar = this.config;
        SmartRefreshLayout smartRefreshLayout4 = this.refreshLayout;
        if (smartRefreshLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout4 = null;
        }
        bVar.b(smartRefreshLayout4);
        if (QQGuildUIUtil.z()) {
            SmartRefreshLayout smartRefreshLayout5 = this.refreshLayout;
            if (smartRefreshLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout5 = null;
            }
            IRefreshHeader refreshHeader = smartRefreshLayout5.getRefreshHeader();
            if (refreshHeader != null && (view = refreshHeader.getView()) != null) {
                layoutParams = view.getLayoutParams();
            }
            if (layoutParams != null) {
                layoutParams.width = x9().getContentWidth();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        hr0.c cVar = this.guardManagerDelegate;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guardManagerDelegate");
            cVar = null;
        }
        cVar.onDestroy();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        this.isPaused = true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        this.isPaused = false;
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/refresh/RefreshPart$d", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements ILoadMoreProvider$LoadMoreListener {
        d() {
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        public void onLoadMoreStart() {
            QLog.i("DiscoveryV2.ContentRefreshPart", 1, "onLoadMoreStart");
            RefreshPart.this.z9();
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        public void onLoadMoreEnd(boolean hasMore) {
        }
    }
}
