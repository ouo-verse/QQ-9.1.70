package com.tencent.richframework.argus;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.IRecyclerViewMonitor;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWReporter;
import com.tencent.biz.richframework.monitor.window.WindowPerformanceData;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/richframework/argus/ArgusRecyclerMonitor;", "Landroidx/recyclerview/widget/IRecyclerViewMonitor;", "()V", "onScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "addRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getActivityContext", "Landroid/app/Activity;", "view", "Landroid/view/View;", "getActivityForView", "removeRecyclerView", "report", "performanceData", "Lcom/tencent/biz/richframework/monitor/window/WindowPerformanceData;", "Companion", "argus-monitor_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ArgusRecyclerMonitor implements IRecyclerViewMonitor {
    private final RecyclerView.OnScrollListener onScrollListener = new ArgusRecyclerMonitor$onScrollListener$1(this);

    private final Activity getActivityContext(View view) {
        Context context;
        View view2;
        View childAt;
        Context context2 = null;
        if (Intrinsics.areEqual(view.getClass().getName(), "com.android.internal.policy.DecorView")) {
            if (!(view instanceof ViewGroup)) {
                view2 = null;
            } else {
                view2 = view;
            }
            ViewGroup viewGroup = (ViewGroup) view2;
            if (viewGroup == null || (childAt = viewGroup.getChildAt(0)) == null || (context = childAt.getContext()) == null) {
                context = view.getContext();
            }
        } else {
            context = view.getContext();
        }
        if (context instanceof Activity) {
            context2 = context;
        }
        return (Activity) context2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity getActivityForView(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
        return getActivityContext(rootView);
    }

    @Override // androidx.recyclerview.widget.IRecyclerViewMonitor
    public void addRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        recyclerView.addOnScrollListener(this.onScrollListener);
    }

    @Override // androidx.recyclerview.widget.IRecyclerViewMonitor
    public void removeRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        recyclerView.removeOnScrollListener(this.onScrollListener);
    }

    public final void report(@Nullable WindowPerformanceData performanceData) {
        if (performanceData == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("performance_data", performanceData);
        RFWReporter.report("recyclerViewStopScroll", hashMap);
    }
}
