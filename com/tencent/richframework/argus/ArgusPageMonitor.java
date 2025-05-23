package com.tencent.richframework.argus;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;
import android.view.View;
import android.view.Window;
import androidx.core.util.Consumer;
import androidx.fragment.app.Argus;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.IRecyclerViewMonitor;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.delegate.impl.RFWReporter;
import com.tencent.biz.richframework.monitor.window.RFWWindowPerformanceMonitor;
import com.tencent.biz.richframework.monitor.window.WindowPerformanceData;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.argus.node.ActivityNode;
import com.tencent.richframework.argus.node.ArgusNode;
import com.tencent.richframework.argus.node.RecyclerViewNode;
import com.tencent.richframework.argus.page.PageInfo;
import com.tencent.richframework.argus.page.PageInfoPO;
import com.tencent.richframework.argus.page.db.HistoryPageChange;
import com.tencent.richframework.argus.util.UtilsKt;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0002<=B\t\b\u0002\u00a2\u0006\u0004\b:\u0010;J2\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J0\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0002J\u001a\u0010\u0019\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u001a\u0010\u001b\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\"\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J>\u0010\"\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010'\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J\u0010\u0010*\u001a\u00020\f2\u0006\u0010)\u001a\u00020(H\u0016J\u0010\u0010+\u001a\u00020\f2\u0006\u0010)\u001a\u00020(H\u0016R\u0018\u0010,\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R \u00102\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\n018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006>"}, d2 = {"Lcom/tencent/richframework/argus/ArgusPageMonitor;", "Landroidx/fragment/app/Argus$ComponentCallback;", "Landroidx/recyclerview/widget/IRecyclerViewMonitor;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/richframework/argus/page/PageInfo;", "fromPageInfo", "newPageInfo", "Landroidx/fragment/app/Argus$MergeResult;", "mergeResult", "", "startTime", "", "startMonitor", "newPage", "Lcom/tencent/richframework/argus/PagePerformanceDataInfo;", "reportDataInfo", "windUpRecyclerView", "stopTime", "", "isDeadlineUpdate", "stopMonitor", "Lcom/tencent/biz/richframework/monitor/window/WindowPerformanceData;", "performanceData", "fragmentInfo", "report", "fromPage", "isAggregationBlock", "newContext", "continueMonitor", "Lcom/tencent/richframework/argus/page/PageInfoPO;", "fromPagePO", "newPagePO", "groupPO", "onPageChange", "currentPageInfo", "", "Lcom/tencent/richframework/argus/page/db/HistoryPageChange;", "historyPageChanges", "onPredictResult", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "addRecyclerView", "removeRecyclerView", "pageInfo", "Lcom/tencent/richframework/argus/PagePerformanceDataInfo;", "", "screenHeight", "I", "Landroid/util/LruCache;", "recyclerViewAttachMap", "Landroid/util/LruCache;", "Lcom/tencent/richframework/argus/ArgusPageMonitor$NormalRunnable;", "delayRunnable", "Lcom/tencent/richframework/argus/ArgusPageMonitor$NormalRunnable;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "<init>", "()V", "NormalRunnable", "RecyclerViewChildOnAttachListener", "argus-monitor_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ArgusPageMonitor implements Argus.ComponentCallback, IRecyclerViewMonitor {
    private static PagePerformanceDataInfo pageInfo;

    @NotNull
    public static final ArgusPageMonitor INSTANCE = new ArgusPageMonitor();
    private static final int screenHeight = DisplayUtil.getScreenHeight();
    private static final LruCache<Integer, Long> recyclerViewAttachMap = new LruCache<>(32);
    private static final NormalRunnable delayRunnable = new NormalRunnable();
    private static final Handler handler = new Handler(Looper.getMainLooper());

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016R*\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/richframework/argus/ArgusPageMonitor$NormalRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "contextWeakReference", "Ljava/lang/ref/WeakReference;", "getContextWeakReference", "()Ljava/lang/ref/WeakReference;", "setContextWeakReference", "(Ljava/lang/ref/WeakReference;)V", "Lcom/tencent/richframework/argus/page/PageInfo;", "newPageInfo", "Lcom/tencent/richframework/argus/page/PageInfo;", "getNewPageInfo", "()Lcom/tencent/richframework/argus/page/PageInfo;", "setNewPageInfo", "(Lcom/tencent/richframework/argus/page/PageInfo;)V", "<init>", "()V", "argus-monitor_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class NormalRunnable implements Runnable {

        @Nullable
        private WeakReference<Activity> contextWeakReference;

        @Nullable
        private PageInfo newPageInfo;

        @Nullable
        public final WeakReference<Activity> getContextWeakReference() {
            return this.contextWeakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity it;
            WeakReference<Activity> weakReference = this.contextWeakReference;
            if (weakReference != null && (it = weakReference.get()) != null) {
                ArgusPageMonitor argusPageMonitor = ArgusPageMonitor.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                ArgusPageMonitor.stopMonitor$default(argusPageMonitor, it, this.newPageInfo, 0L, true, 4, null);
            }
        }

        public final void setContextWeakReference(@Nullable WeakReference<Activity> weakReference) {
            this.contextWeakReference = weakReference;
        }

        public final void setNewPageInfo(@Nullable PageInfo pageInfo) {
            this.newPageInfo = pageInfo;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/richframework/argus/ArgusPageMonitor$RecyclerViewChildOnAttachListener;", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onChildViewAttachedToWindow", "", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", "argus-monitor_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class RecyclerViewChildOnAttachListener implements RecyclerView.OnChildAttachStateChangeListener {
        private final RecyclerView recyclerView;

        public RecyclerViewChildOnAttachListener(@NotNull RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            this.recyclerView = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ArgusPageMonitor.access$getRecyclerViewAttachMap$p(ArgusPageMonitor.INSTANCE).put(Integer.valueOf(this.recyclerView.hashCode()), Long.valueOf(System.currentTimeMillis()));
            this.recyclerView.removeOnChildAttachStateChangeListener(this);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    ArgusPageMonitor() {
    }

    public static final /* synthetic */ LruCache access$getRecyclerViewAttachMap$p(ArgusPageMonitor argusPageMonitor) {
        return recyclerViewAttachMap;
    }

    private final void continueMonitor(Activity newContext, PageInfo newPage, long startTime) {
        Activity activity;
        Handler handler2 = handler;
        NormalRunnable normalRunnable = delayRunnable;
        handler2.removeCallbacks(normalRunnable);
        PagePerformanceDataInfo pagePerformanceDataInfo = pageInfo;
        if (pagePerformanceDataInfo != null) {
            pagePerformanceDataInfo.setNewPageInfo(UtilsKt.getAllVisibleBlockMsg(newPage));
            WeakReference<Activity> contextWeakReference = normalRunnable.getContextWeakReference();
            if (contextWeakReference != null) {
                activity = contextWeakReference.get();
            } else {
                activity = null;
            }
            if (!Intrinsics.areEqual(activity, newContext)) {
                if (activity != null) {
                    RFWWindowPerformanceMonitor rFWWindowPerformanceMonitor = RFWWindowPerformanceMonitor.INSTANCE;
                    Window window = activity.getWindow();
                    Intrinsics.checkNotNullExpressionValue(window, "activity.window");
                    RFWWindowPerformanceMonitor.stopMonitor$default(rFWWindowPerformanceMonitor, window, "argus_page_monitor", null, 4, null);
                }
                RFWWindowPerformanceMonitor rFWWindowPerformanceMonitor2 = RFWWindowPerformanceMonitor.INSTANCE;
                Window window2 = newContext.getWindow();
                Intrinsics.checkNotNullExpressionValue(window2, "newContext.window");
                rFWWindowPerformanceMonitor2.startMonitor(window2, "argus_page_monitor");
                normalRunnable.setContextWeakReference(new WeakReference<>(newContext));
                pagePerformanceDataInfo.setStartMonitorTime(startTime);
            }
        }
        normalRunnable.setNewPageInfo(newPage);
        handler2.postDelayed(normalRunnable, 3000L);
    }

    private final boolean isAggregationBlock(PageInfo fromPage, PageInfo newPage) {
        if (fromPage == null) {
            return true;
        }
        Iterator<ArgusNode<?>> it = fromPage.getAllVisibleNode().iterator();
        Iterator<ArgusNode<?>> it5 = newPage.getAllVisibleNode().iterator();
        while (it.hasNext() && it5.hasNext()) {
            if (!Intrinsics.areEqual(it.next(), it5.next())) {
                return false;
            }
        }
        return !it.hasNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void report(WindowPerformanceData performanceData, PagePerformanceDataInfo fragmentInfo) {
        if (performanceData == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("performance_data", performanceData);
        hashMap.put("argus_ext_performdata", fragmentInfo);
        RFWLog.d("ArgusPageMonitor", RFWLog.DEV, "reportParams:", hashMap);
        RFWReporter.report("argus_page_performance_report", hashMap);
    }

    private final void startMonitor(Activity activity, PageInfo fromPageInfo, PageInfo newPageInfo, Argus.MergeResult mergeResult, long startTime) {
        RFWWindowPerformanceMonitor rFWWindowPerformanceMonitor = RFWWindowPerformanceMonitor.INSTANCE;
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "activity.window");
        rFWWindowPerformanceMonitor.startMonitor(window, "argus_page_monitor");
        pageInfo = new PagePerformanceDataInfo(UtilsKt.getAllVisibleBlockMsg(fromPageInfo), UtilsKt.getAllVisibleBlockMsg(newPageInfo), mergeResult, 0L, startTime, 0L, false, 0L, null, 480, null);
        NormalRunnable normalRunnable = delayRunnable;
        normalRunnable.setNewPageInfo(newPageInfo);
        normalRunnable.setContextWeakReference(new WeakReference<>(activity));
        handler.postDelayed(normalRunnable, 3000L);
    }

    private final void stopMonitor(Activity activity, PageInfo newPageInfo, long stopTime, boolean isDeadlineUpdate) {
        final PagePerformanceDataInfo copy$default;
        handler.removeCallbacks(delayRunnable);
        PagePerformanceDataInfo pagePerformanceDataInfo = pageInfo;
        if (pagePerformanceDataInfo != null) {
            pagePerformanceDataInfo.setNewPageInfo(UtilsKt.getAllVisibleBlockMsg(newPageInfo));
        }
        PagePerformanceDataInfo pagePerformanceDataInfo2 = pageInfo;
        if (pagePerformanceDataInfo2 != null && (copy$default = PagePerformanceDataInfo.copy$default(pagePerformanceDataInfo2, null, null, null, 0L, 0L, 0L, false, 0L, null, 511, null)) != null) {
            pageInfo = null;
            if (newPageInfo == null) {
                return;
            }
            windUpRecyclerView(newPageInfo, copy$default);
            copy$default.setDeadlineUpdate(isDeadlineUpdate);
            copy$default.setStopMonitorTime(stopTime);
            final HashMap<String, Object> reportBusinessExtMap = UtilsKt.getReportBusinessExtMap(newPageInfo);
            RFWWindowPerformanceMonitor rFWWindowPerformanceMonitor = RFWWindowPerformanceMonitor.INSTANCE;
            Window window = activity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "activity.window");
            rFWWindowPerformanceMonitor.stopMonitor(window, "argus_page_monitor", new Consumer<WindowPerformanceData>() { // from class: com.tencent.richframework.argus.ArgusPageMonitor$stopMonitor$1
                @Override // androidx.core.util.Consumer
                public final void accept(@Nullable WindowPerformanceData windowPerformanceData) {
                    HashMap<String, Object> extMap;
                    if (windowPerformanceData != null && (extMap = windowPerformanceData.getExtMap()) != null) {
                        extMap.put("monitor_report_business_ext_params", reportBusinessExtMap);
                    }
                    ArgusPageMonitor.INSTANCE.report(windowPerformanceData, copy$default);
                }
            });
        }
    }

    static /* synthetic */ void stopMonitor$default(ArgusPageMonitor argusPageMonitor, Activity activity, PageInfo pageInfo2, long j3, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            pageInfo2 = null;
        }
        PageInfo pageInfo3 = pageInfo2;
        if ((i3 & 4) != 0) {
            j3 = System.currentTimeMillis();
        }
        long j16 = j3;
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        argusPageMonitor.stopMonitor(activity, pageInfo3, j16, z16);
    }

    private final void windUpRecyclerView(PageInfo newPage, PagePerformanceDataInfo reportDataInfo) {
        RecyclerView container;
        Long l3;
        if (reportDataInfo.getRecyclerViewFirstItemAttachWindowTime() != 0) {
            return;
        }
        Iterator<T> it = newPage.getAllVisibleNode().iterator();
        while (it.hasNext()) {
            ArgusNode argusNode = (ArgusNode) it.next();
            if (!(argusNode instanceof RecyclerViewNode)) {
                argusNode = null;
            }
            RecyclerViewNode recyclerViewNode = (RecyclerViewNode) argusNode;
            if (recyclerViewNode != null && (container = recyclerViewNode.getContainer()) != null && container.getHeight() >= screenHeight / 2 && (l3 = recyclerViewAttachMap.get(Integer.valueOf(container.hashCode()))) != null && l3.longValue() != 0) {
                reportDataInfo.setRecyclerViewFirstItemAttachWindowTime(l3.longValue());
                reportDataInfo.setRecyclerView(recyclerViewNode.getNodeTreeTag());
            }
        }
    }

    @Override // androidx.recyclerview.widget.IRecyclerViewMonitor
    public void addRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (recyclerView.getChildCount() == 0) {
            recyclerView.addOnChildAttachStateChangeListener(new RecyclerViewChildOnAttachListener(recyclerView));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Argus.ComponentCallback
    public void onPageChange(@Nullable PageInfo fromPage, @Nullable PageInfoPO fromPagePO, @NotNull PageInfo newPage, @NotNull PageInfoPO newPagePO, @Nullable PageInfoPO groupPO, @NotNull Argus.MergeResult mergeResult) {
        ArgusNode<?> argusNode;
        Activity activity;
        Activity container;
        Intrinsics.checkNotNullParameter(newPage, "newPage");
        Intrinsics.checkNotNullParameter(newPagePO, "newPagePO");
        Intrinsics.checkNotNullParameter(mergeResult, "mergeResult");
        long currentTimeMillis = System.currentTimeMillis();
        ArgusNode<?> argusNode2 = null;
        if (fromPage != null) {
            argusNode = fromPage.getRootNode();
        } else {
            argusNode = null;
        }
        if (!(argusNode instanceof ActivityNode)) {
            argusNode = null;
        }
        ActivityNode activityNode = (ActivityNode) argusNode;
        if (activityNode != null) {
            activity = activityNode.getContainer();
        } else {
            activity = null;
        }
        ArgusNode<?> rootNode = newPage.getRootNode();
        if (rootNode instanceof ActivityNode) {
            argusNode2 = rootNode;
        }
        ActivityNode activityNode2 = (ActivityNode) argusNode2;
        if (activityNode2 != null && (container = activityNode2.getContainer()) != 0) {
            Lifecycle lifecycle = ((LifecycleOwner) container).getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "(newContext as LifecycleOwner).lifecycle");
            Lifecycle.State currentState = lifecycle.getCurrentState();
            Intrinsics.checkNotNullExpressionValue(currentState, "(newContext as Lifecycle\u2026r).lifecycle.currentState");
            if (currentState != Lifecycle.State.RESUMED && currentState != Lifecycle.State.STARTED) {
                return;
            }
            if (activity != null && (!Intrinsics.areEqual(activity, container))) {
                stopMonitor$default(this, activity, fromPage, currentTimeMillis, false, 8, null);
                startMonitor(container, fromPage, newPage, mergeResult, currentTimeMillis);
            } else {
                if (isAggregationBlock(fromPage, newPage)) {
                    continueMonitor(container, newPage, currentTimeMillis);
                    return;
                }
                if (activity != null) {
                    stopMonitor$default(INSTANCE, activity, fromPage, currentTimeMillis, false, 8, null);
                }
                startMonitor(container, fromPage, newPage, mergeResult, currentTimeMillis);
            }
        }
    }

    @Override // androidx.fragment.app.Argus.ComponentCallback
    public void onPredictResult(@Nullable PageInfo currentPageInfo, @NotNull List<? extends HistoryPageChange> historyPageChanges) {
        Intrinsics.checkNotNullParameter(historyPageChanges, "historyPageChanges");
    }

    @Override // androidx.recyclerview.widget.IRecyclerViewMonitor
    public void removeRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        recyclerViewAttachMap.remove(Integer.valueOf(recyclerView.hashCode()));
    }
}
