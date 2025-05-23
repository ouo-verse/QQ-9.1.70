package com.tencent.biz.qqcircle.share.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import ub0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b*\u0010+B\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u00a2\u0006\u0004\b*\u0010.B#\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\u0006\u0010/\u001a\u00020\u0007\u00a2\u0006\u0004\b*\u00100J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u000e\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\r\u001a\u00020\u0007H\u0016J\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0007H\u0014J\u0014\u0010\u0014\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u000e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0015R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u00063"}, d2 = {"Lcom/tencent/biz/qqcircle/share/widget/QFSShareSelectMemberHeaderView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "", "", "l0", "Landroid/content/Context;", "context", "", "viewType", "initView", "Landroid/view/View$OnClickListener;", "jumpClickListener", "setJumpClickListener", "getLayoutId", "objData", com.tencent.luggage.wxa.c8.c.G, "bindData", "", "Lo20/a;", "itemsList", "setItemsListData", "", "addedUin", "m0", "removedUin", "n0", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "k0", "()Landroidx/recyclerview/widget/RecyclerView;", "setShareListRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "shareListRecyclerView", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "topWrapper", "Lub0/a;", "f", "Lub0/a;", "adapter", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", h.F, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSShareSelectMemberHeaderView extends QCircleBaseWidgetView<Object> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView shareListRecyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout topWrapper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/biz/qqcircle/share/widget/QFSShareSelectMemberHeaderView$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            outRect.right = cx.a(8.0f);
            outRect.left = cx.a(8.0f);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/biz/qqcircle/share/widget/QFSShareSelectMemberHeaderView$c", "Lcom/tencent/biz/richframework/part/block/base/SafeLinearLayoutManager;", "", "canScrollHorizontally", "canScrollVertically", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class c extends SafeLinearLayoutManager {
        c(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return true;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QFSShareSelectMemberHeaderView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void l0() {
        this.shareListRecyclerView = (RecyclerView) findViewById(R.id.f518829a);
        c cVar = new c(getContext());
        cVar.setOrientation(0);
        RecyclerView recyclerView = this.shareListRecyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(cVar);
        }
        a aVar = new a();
        this.adapter = aVar;
        RecyclerView recyclerView2 = this.shareListRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(aVar);
        }
        RecyclerView recyclerView3 = this.shareListRecyclerView;
        if (recyclerView3 != null) {
            recyclerView3.addItemDecoration(new b());
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gst;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void initView(@Nullable Context context, int viewType) {
        super.initView(context, viewType);
        l0();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f55792iv);
        this.topWrapper = linearLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    @Nullable
    /* renamed from: k0, reason: from getter */
    public final RecyclerView getShareListRecyclerView() {
        return this.shareListRecyclerView;
    }

    public final void m0(@NotNull String addedUin) {
        Intrinsics.checkNotNullParameter(addedUin, "addedUin");
        a aVar = this.adapter;
        if (aVar != null) {
            aVar.i0(addedUin);
        }
    }

    public final void n0(@NotNull String removedUin) {
        Intrinsics.checkNotNullParameter(removedUin, "removedUin");
        a aVar = this.adapter;
        if (aVar != null) {
            aVar.j0(removedUin);
        }
    }

    public final void setItemsListData(@NotNull List<? extends o20.a> itemsList) {
        Intrinsics.checkNotNullParameter(itemsList, "itemsList");
        if (itemsList.isEmpty()) {
            return;
        }
        LinearLayout linearLayout = this.topWrapper;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        if (itemsList.size() > 20) {
            a aVar = this.adapter;
            if (aVar != null) {
                aVar.setData(itemsList.subList(0, 20));
                return;
            }
            return;
        }
        a aVar2 = this.adapter;
        if (aVar2 != null) {
            aVar2.setData(itemsList);
        }
    }

    public final void setJumpClickListener(@NotNull View.OnClickListener jumpClickListener) {
        Intrinsics.checkNotNullParameter(jumpClickListener, "jumpClickListener");
        View findViewById = findViewById(R.id.f44691pv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_jump_choose_group_btn)");
        View findViewById2 = findViewById(R.id.f44701pw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qfs_ju\u2026choose_mutual_follow_btn)");
        ((FrameLayout) findViewById).setOnClickListener(jumpClickListener);
        ((FrameLayout) findViewById2).setOnClickListener(jumpClickListener);
    }

    public final void setShareListRecyclerView(@Nullable RecyclerView recyclerView) {
        this.shareListRecyclerView = recyclerView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QFSShareSelectMemberHeaderView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSShareSelectMemberHeaderView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(@Nullable Object objData, int pos) {
    }
}
