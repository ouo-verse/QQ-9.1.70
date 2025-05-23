package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation;

import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.immersive.QFSBlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0006\u0010\u000e\u001a\u00020\u0004R\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/aa;", "Lcom/tencent/biz/richframework/part/block/BlockMerger;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "position", "onBindItemViewHolder", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartStop", "k0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", HippyTKDListViewAdapter.SCROLL_STATE, "", BdhLogUtil.LogTag.Tag_Conn, "Z", "shouldCheckPreloadOnScrollIdle", "Ljava/lang/Runnable;", "D", "Ljava/lang/Runnable;", "triggerLoadMoreRunnable", "Lcom/tencent/biz/qqcircle/immersive/QFSBlockContainer;", ParseCommon.CONTAINER, "<init>", "(Lcom/tencent/biz/qqcircle/immersive/QFSBlockContainer;)V", "E", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class aa extends BlockMerger {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean shouldCheckPreloadOnScrollIdle;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Runnable triggerLoadMoreRunnable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int scrollState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/aa$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            aa.this.scrollState = newState;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(@NotNull QFSBlockContainer container) {
        super(container);
        Intrinsics.checkNotNullParameter(container, "container");
        this.shouldCheckPreloadOnScrollIdle = true;
        this.triggerLoadMoreRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.z
            @Override // java.lang.Runnable
            public final void run() {
                aa.l0(aa.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(aa this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QFSPublicAccountStaggeredBlockMerger", 1, "trigger loadMore");
        try {
            this$0.triggerToLoadMore();
        } catch (Throwable th5) {
            QLog.e("QFSPublicAccountStaggeredBlockMerger", 1, "trigger loadMore error, e=" + th5.getMessage(), th5);
        }
    }

    public final void k0() {
        QLog.i("QFSPublicAccountStaggeredBlockMerger", 1, "resetShouldCheckPreloadOnScrollIdle");
        this.shouldCheckPreloadOnScrollIdle = true;
    }

    @Override // com.tencent.biz.richframework.part.block.BlockMerger, com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.BlockMerger, com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter
    public void onBindItemViewHolder(@Nullable RecyclerView.ViewHolder holder, int position) {
        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        super.onBindItemViewHolder(holder, position);
        if (this.scrollState == 0 && this.shouldCheckPreloadOnScrollIdle && (recyclerView = getRecyclerView()) != null && (adapter = recyclerView.getAdapter()) != null) {
            int itemCount = adapter.getItemCount();
            int extraCount = ((itemCount - getExtraCount()) - getStaggeredRemainCountToTriggerPreload(2)) - 1;
            QLog.i("QFSPublicAccountStaggeredBlockMerger", 1, "onViewAttach pos=" + position + " itemCount=" + itemCount + " extraCount=" + getExtraCount());
            if (position >= extraCount) {
                this.shouldCheckPreloadOnScrollIdle = false;
                RecyclerView recyclerView2 = getRecyclerView();
                if (recyclerView2 != null) {
                    recyclerView2.post(this.triggerLoadMoreRunnable);
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.block.BlockMerger, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartStop(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartStop(activity);
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            recyclerView.removeCallbacks(this.triggerLoadMoreRunnable);
        }
    }
}
