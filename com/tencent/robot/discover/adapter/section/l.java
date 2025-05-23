package com.tencent.robot.discover.adapter.section;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.discover.data.RobotRecentUsedData;
import com.tencent.robot.discover.fragment.RobotRecentUsedFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J*\u0010\u000f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/robot/discover/adapter/section/l;", "Lcom/tencent/robot/discover/adapter/section/e;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "Lk34/a;", "data", "", "position", "", "", "payload", "t", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "recentUsedNum", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "recentUsedLayout", "Landroidx/recyclerview/widget/RecyclerView;", tl.h.F, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Li34/c;", "i", "Li34/c;", "adapter", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class l extends e {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView recentUsedNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup recentUsedLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private i34.c adapter;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(l this$0, k34.a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RobotRecentUsedFragment.Companion companion = RobotRecentUsedFragment.INSTANCE;
        Context context = this$0.mRootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
        companion.a(context, (RobotRecentUsedData) aVar);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f110496io);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026.id.tv_recent_used_count)");
        this.recentUsedNum = (TextView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.yq_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026.id.ll_recent_used_count)");
        this.recentUsedLayout = (ViewGroup) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f70933ms);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026recent_used_recyclerview)");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        this.recyclerView = recyclerView;
        i34.c cVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(containerView.getContext(), 5));
        this.adapter = new i34.c();
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        i34.c cVar2 = this.adapter;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            cVar = cVar2;
        }
        recyclerView2.setAdapter(cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable final k34.a data, int position, @Nullable List<Object> payload) {
        if (data instanceof RobotRecentUsedData) {
            TextView textView = this.recentUsedNum;
            i34.c cVar = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentUsedNum");
                textView = null;
            }
            RobotRecentUsedData robotRecentUsedData = (RobotRecentUsedData) data;
            textView.setText(String.valueOf(robotRecentUsedData.getTotalNum()));
            ViewGroup viewGroup = this.recentUsedLayout;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentUsedLayout");
                viewGroup = null;
            }
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.discover.adapter.section.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.u(l.this, data, view);
                }
            });
            i34.c cVar2 = this.adapter;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                cVar = cVar2;
            }
            cVar.setItems(robotRecentUsedData.getRobots());
        }
    }
}
