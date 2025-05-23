package com.tencent.mobileqq.zootopia.recommend.common;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.recommend.common.base.ZplanBaseCardFeedsListView;
import com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZplanHorizontalScrollSmallIconCard;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u001a\u0010\f\u001a\u00020\u00078\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zootopia/recommend/common/ZplanCardFeedsListView;", "Lcom/tencent/mobileqq/zootopia/recommend/common/base/ZplanBaseCardFeedsListView;", "", "k", "Lcom/tencent/mobileqq/zootopia/recommend/common/c;", "adapter", "setAdapter", "", "E", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "TAG", "", UserInfo.SEX_FEMALE, "I", "itemDecorationMargin", "G", "MARGIN_BUBBLE", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanCardFeedsListView extends ZplanBaseCardFeedsListView {

    /* renamed from: E, reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: F, reason: from kotlin metadata */
    private final int itemDecorationMargin;

    /* renamed from: G, reason: from kotlin metadata */
    private final int MARGIN_BUBBLE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/recommend/common/ZplanCardFeedsListView$a", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroid/support/v7/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/support/v7/widget/RecyclerView$State;", "state", "", "getItemOffsets", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if ((view instanceof ZootopiaBaseCard) && ((ZootopiaBaseCard) view).A()) {
                outRect.bottom = 0;
            } else {
                outRect.bottom = ZplanCardFeedsListView.this.itemDecorationMargin;
            }
            if (view instanceof ZplanHorizontalScrollSmallIconCard) {
                outRect.top = ZplanCardFeedsListView.this.MARGIN_BUBBLE;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZplanCardFeedsListView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.zootopia.recommend.common.base.ZplanBaseCardFeedsListView
    /* renamed from: e, reason: from getter */
    protected String getTAG() {
        return this.TAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.zootopia.recommend.common.base.ZplanBaseCardFeedsListView
    public void k() {
        super.k();
        c().addItemDecoration(new a());
    }

    public final void setAdapter(c adapter) {
        c().setClipChildren(false);
        c().setAdapter(adapter);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZplanCardFeedsListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZplanCardFeedsListView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanCardFeedsListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "ZPlanCardFeedsList";
        this.itemDecorationMargin = getResources().getDimensionPixelSize(R.dimen.f11996_);
        this.MARGIN_BUBBLE = getResources().getDimensionPixelSize(R.dimen.f119869);
    }
}
