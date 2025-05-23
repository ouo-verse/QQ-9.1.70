package com.tencent.robot.profile.section.story;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.robot.profile.data.RobotProfileStoryInfoData;
import com.tencent.robot.profile.data.g;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import n44.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J*\u0010\u000f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/robot/profile/section/story/RobotStoryListSection;", "Ln44/f;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "p", "Landroid/view/View;", "containerView", "", "onInitView", "Lcom/tencent/robot/profile/data/g;", "data", "", "position", "", "", "payload", "r", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "storyRecyclerView", "Lcom/tencent/robot/profile/section/story/b;", "f", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/robot/profile/section/story/b;", "listItemAdapter", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotStoryListSection extends f {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView storyRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy listItemAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/robot/profile/section/story/RobotStoryListSection$a", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "", "itemPosition", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "getItemOffsets", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, int itemPosition, @NotNull RecyclerView parent) {
            int i3;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(parent, "parent");
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter != null) {
                i3 = adapter.getItemCount();
            } else {
                i3 = 0;
            }
            if (itemPosition == 0) {
                outRect.left = l.b(16);
                outRect.right = l.b(12);
            } else if (itemPosition == i3 - 1) {
                outRect.right = l.b(16);
            } else {
                outRect.right = l.b(12);
            }
        }
    }

    public RobotStoryListSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.robot.profile.section.story.RobotStoryListSection$listItemAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final b invoke() {
                return new b(new a());
            }
        });
        this.listItemAdapter = lazy;
    }

    private final RecyclerView.ItemDecoration p() {
        return new a();
    }

    private final b q() {
        return (b) this.listItemAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f28210ib);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026ofile_story_recyclerView)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.storyRecyclerView = recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyRecyclerView");
            recyclerView = null;
        }
        recyclerView.setAdapter(new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{q()}));
        RecyclerView recyclerView3 = this.storyRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyRecyclerView");
            recyclerView3 = null;
        }
        RecyclerView recyclerView4 = this.storyRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyRecyclerView");
            recyclerView4 = null;
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(recyclerView4.getContext(), 0, false));
        RecyclerView recyclerView5 = this.storyRecyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyRecyclerView");
            recyclerView5 = null;
        }
        recyclerView5.setItemAnimator(null);
        RecyclerView recyclerView6 = this.storyRecyclerView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyRecyclerView");
            recyclerView6 = null;
        }
        recyclerView6.addItemDecoration(p());
        RecyclerView recyclerView7 = this.storyRecyclerView;
        if (recyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storyRecyclerView");
        } else {
            recyclerView2 = recyclerView7;
        }
        recyclerView2.setOverScrollMode(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable g data, int position, @Nullable List<Object> payload) {
        RobotProfileStoryInfoData robotProfileStoryInfoData;
        if (data instanceof RobotProfileStoryInfoData) {
            robotProfileStoryInfoData = (RobotProfileStoryInfoData) data;
        } else {
            robotProfileStoryInfoData = null;
        }
        if (robotProfileStoryInfoData != null) {
            q().setItems(robotProfileStoryInfoData.h());
        }
    }
}
