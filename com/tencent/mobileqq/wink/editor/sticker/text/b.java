package com.tencent.mobileqq.wink.editor.sticker.text;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB3\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\r\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/text/b;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/editor/sticker/text/b$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", ReportConstant.COSTREPORT_PREFIX, "holder", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getItemCount", "", "d", "Ljava/util/List;", NodeProps.COLORS, "Lkotlin/Function1;", "e", "Lkotlin/jvm/functions/Function1;", "onColorSelected", "f", "I", "selectedPosition", "initialSelectedPosition", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;I)V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> colors;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Integer, Unit> onColorSelected;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int selectedPosition;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/text/b$a;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/wink/editor/sticker/text/CircleColorView;", "d", "Lcom/tencent/mobileqq/wink/editor/sticker/text/CircleColorView;", "b", "()Lcom/tencent/mobileqq/wink/editor/sticker/text/CircleColorView;", "colorView", "Landroid/view/View;", "e", "Landroid/view/View;", "c", "()Landroid/view/View;", "selectedCircleView", "view", "<init>", "(Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CircleColorView colorView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View selectedCircleView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.u0v);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.colorView)");
            this.colorView = (CircleColorView) findViewById;
            View findViewById2 = view.findViewById(R.id.f82524h4);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.selectedCircleView)");
            this.selectedCircleView = findViewById2;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final CircleColorView getColorView() {
            return this.colorView;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final View getSelectedCircleView() {
            return this.selectedCircleView;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull List<Integer> colors, @NotNull Function1<? super Integer, Unit> onColorSelected, int i3) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(onColorSelected, "onColorSelected");
        this.colors = colors;
        this.onColorSelected = onColorSelected;
        this.selectedPosition = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(b this$0, a holder, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        int i16 = this$0.selectedPosition;
        this$0.selectedPosition = holder.getAdapterPosition();
        this$0.notifyItemChanged(i16);
        this$0.notifyItemChanged(this$0.selectedPosition);
        this$0.onColorSelected.invoke(this$0.colors.get(i3));
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.colors.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull final a holder, final int position) {
        int i3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getColorView().setColor(this.colors.get(position).intValue());
        View selectedCircleView = holder.getSelectedCircleView();
        if (position == this.selectedPosition) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        selectedCircleView.setVisibility(i3);
        ViewParent parent = holder.getColorView().getParent();
        if (parent instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) parent;
            if (frameLayout.getLayoutParams() instanceof RecyclerView.LayoutParams) {
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                if (position == this.colors.size() - 1) {
                    layoutParams2.setMargins(((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin, ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin, ViewUtils.dpToPx(20.0f), ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
                } else {
                    layoutParams2.setMargins(((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin, ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin, ViewUtils.dpToPx(8.0f), ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
                }
                frameLayout.setLayoutParams(layoutParams2);
            }
        }
        holder.getColorView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.r(b.this, holder, position, view);
            }
        });
        EventCollector.getInstance().onRecyclerBindViewHolder(holder, position, getItemId(position));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hfe, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new a(view);
    }
}
