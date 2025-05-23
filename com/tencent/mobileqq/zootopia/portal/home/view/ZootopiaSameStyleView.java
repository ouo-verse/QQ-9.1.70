package com.tencent.mobileqq.zootopia.portal.home.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.mobileqq.zootopia.portal.home.model.p;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.widget.ZootopiaRecycleView;
import fi3.ab;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import zb3.ZootopiaSameStyleData;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0001\u001aB'\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010,\u001a\u00020+\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/home/view/ZootopiaSameStyleView;", "Landroid/widget/FrameLayout;", "", "b", "Lzb3/n;", "sameStyleData", "c", "", "d", UserInfo.SEX_FEMALE, "radius", "Lfi3/ab;", "e", "Lfi3/ab;", "binding", "Landroidx/recyclerview/widget/LinearLayoutManager;", "f", "Landroidx/recyclerview/widget/LinearLayoutManager;", "foldedLayoutManager", "Lcom/tencent/mobileqq/zootopia/portal/home/model/p;", h.F, "Lcom/tencent/mobileqq/zootopia/portal/home/model/p;", "foldedAdapter", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "a", "()Landroid/widget/TextView;", "setVisitAllText", "(Landroid/widget/TextView;)V", "visitAllText", "Lcom/tencent/mobileqq/zootopia/portal/home/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zootopia/portal/home/b;", "getSameStyleClickListener", "()Lcom/tencent/mobileqq/zootopia/portal/home/b;", "setSameStyleClickListener", "(Lcom/tencent/mobileqq/zootopia/portal/home/b;)V", "sameStyleClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaSameStyleView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float radius;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ab binding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayoutManager foldedLayoutManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private p foldedAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView visitAllText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zootopia.portal.home.b sameStyleClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/portal/home/view/ZootopiaSameStyleView$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            if (layoutManager == null || !(layoutManager instanceof LinearLayoutManager)) {
                return;
            }
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.left = LayoutAttrsKt.getDp(16);
            } else {
                outRect.left = LayoutAttrsKt.getDp(10);
            }
            if (parent.getChildAdapterPosition(view) == ((LinearLayoutManager) layoutManager).getItemCount() - 1) {
                outRect.right = LayoutAttrsKt.getDp(16);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaSameStyleView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b() {
        RoundCorneredRelativeLayout roundCorneredRelativeLayout = this.binding.f398783c;
        float f16 = this.radius;
        roundCorneredRelativeLayout.setRadius(f16, f16, f16, f16);
        this.visitAllText = this.binding.f398785e;
        this.foldedLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        p pVar = new p(context, null, 2, 0 == true ? 1 : 0);
        this.foldedAdapter = pVar;
        this.binding.f398782b.setAdapter(pVar);
        ZootopiaRecycleView zootopiaRecycleView = this.binding.f398782b;
        zootopiaRecycleView.setLayoutManager(this.foldedLayoutManager);
        zootopiaRecycleView.addItemDecoration(new b());
    }

    /* renamed from: a, reason: from getter */
    public final TextView getVisitAllText() {
        return this.visitAllText;
    }

    public final void c(ZootopiaSameStyleData sameStyleData) {
        Intrinsics.checkNotNullParameter(sameStyleData, "sameStyleData");
        this.binding.f398784d.setText(sameStyleData.getTitleName());
        p pVar = this.foldedAdapter;
        if (pVar != null) {
            pVar.t0(this.sameStyleClickListener);
            pVar.n0(sameStyleData.b());
        }
    }

    public final void setSameStyleClickListener(com.tencent.mobileqq.zootopia.portal.home.b bVar) {
        this.sameStyleClickListener = bVar;
    }

    public final void setVisitAllText(TextView textView) {
        this.visitAllText = textView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaSameStyleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZootopiaSameStyleView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaSameStyleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.radius = ViewUtils.dpToPx(12.0f);
        ab g16 = ab.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        b();
    }
}
