package com.tencent.richframework.argus;

import android.app.Activity;
import android.view.Window;
import androidx.core.util.Consumer;
import androidx.fragment.app.Argus;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.monitor.window.RFWWindowPerformanceMonitor;
import com.tencent.biz.richframework.monitor.window.WindowPerformanceData;
import com.tencent.richframework.argus.node.ArgusNode;
import com.tencent.richframework.argus.util.UtilsKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J \u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"com/tencent/richframework/argus/ArgusRecyclerMonitor$onScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "totalDistance", "", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "argus-monitor_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ArgusRecyclerMonitor$onScrollListener$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ ArgusRecyclerMonitor this$0;
    private int totalDistance;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArgusRecyclerMonitor$onScrollListener$1(ArgusRecyclerMonitor argusRecyclerMonitor) {
        this.this$0 = argusRecyclerMonitor;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
    
        r4 = r3.this$0.getActivityForView(r4);
     */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onScrollStateChanged(@NotNull final RecyclerView recyclerView, int newState) {
        Activity activityForView;
        Activity activityForView2;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == 0) {
            activityForView2 = this.this$0.getActivityForView(recyclerView);
            if (activityForView2 != null) {
                RFWWindowPerformanceMonitor rFWWindowPerformanceMonitor = RFWWindowPerformanceMonitor.INSTANCE;
                Window window = activityForView2.getWindow();
                Intrinsics.checkNotNullExpressionValue(window, "activity.window");
                rFWWindowPerformanceMonitor.stopMonitor(window, "argus_recyclerview_monitor", new Consumer<WindowPerformanceData>() { // from class: com.tencent.richframework.argus.ArgusRecyclerMonitor$onScrollListener$1$onScrollStateChanged$1
                    @Override // androidx.core.util.Consumer
                    public final void accept(@Nullable WindowPerformanceData windowPerformanceData) {
                        ArgusNode<?> findViewBlockNode;
                        int i3;
                        if (windowPerformanceData == null || (findViewBlockNode = Argus.INSTANCE.findViewBlockNode(recyclerView, false)) == null) {
                            return;
                        }
                        HashMap<String, Object> extMap = windowPerformanceData.getExtMap();
                        Object nodeTreeTag = findViewBlockNode.getNodeTreeTag();
                        if (nodeTreeTag == null) {
                            nodeTreeTag = "";
                        }
                        extMap.put("block_msg", nodeTreeTag);
                        windowPerformanceData.getExtMap().put("monitor_report_business_ext_params", UtilsKt.getReportBusinessExtMap(findViewBlockNode));
                        HashMap<String, Object> extMap2 = windowPerformanceData.getExtMap();
                        i3 = ArgusRecyclerMonitor$onScrollListener$1.this.totalDistance;
                        extMap2.put("recyclerview_performance_scroll_distance", Integer.valueOf(i3));
                        ArgusRecyclerMonitor$onScrollListener$1.this.this$0.report(windowPerformanceData);
                    }
                });
                return;
            }
            return;
        }
        if (newState == 1 && activityForView != null) {
            this.totalDistance = 0;
            RFWWindowPerformanceMonitor rFWWindowPerformanceMonitor2 = RFWWindowPerformanceMonitor.INSTANCE;
            Window window2 = activityForView.getWindow();
            Intrinsics.checkNotNullExpressionValue(window2, "activity.window");
            rFWWindowPerformanceMonitor2.startMonitor(window2, "argus_recyclerview_monitor");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx5, dy5);
        this.totalDistance += Math.abs(dx5) + Math.abs(dy5);
    }
}
