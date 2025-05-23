package com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m84.ViewAdjustObject;
import oa4.a;
import pu4.g;
import pv4.p;
import pv4.s;
import t74.u;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 92\u00020\u0001:\u0002:;B/\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00106\u001a\u00020\b\u00a2\u0006\u0004\b7\u00108J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0013\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0015\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0017\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0014\u0010\u0019\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\rR\u0014\u0010\u001b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\rR\u0014\u0010\u001d\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\rR\u0014\u0010\u001f\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\rR\u0014\u0010!\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\rR\u0014\u0010#\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\rR\u0014\u0010%\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\rR\u0014\u0010'\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\rR\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanHorizontalScrollSmallCard;", "Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "", "J", "", "L", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard$a;", "I", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "W", "itemWidth", "a0", "itemHeight", "b0", "mediaWidth", "c0", "mediaHeight", "d0", "topLeftSize", "e0", "topRightSize", "f0", "topLeftMarginTop", "g0", "topLeftMarginLeft", "h0", "topRightMarginTop", "i0", "topRightMarginRight", "j0", "itemMargin", "k0", NodeProps.MARGIN_LEFT, "Landroid/graphics/drawable/Drawable;", "l0", "Landroid/graphics/drawable/Drawable;", "iconDefaultDrawable", "m0", "transparentDefaultDrawable", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "itemViewType", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", "n0", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanHorizontalScrollSmallCard extends ZPlanBaseHorizontalScrollCard {

    /* renamed from: W, reason: from kotlin metadata */
    private final int itemWidth;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final int itemHeight;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final int mediaWidth;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final int mediaHeight;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final int topLeftSize;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final int topRightSize;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final int topLeftMarginTop;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private final int topLeftMarginLeft;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final int topRightMarginTop;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private final int topRightMarginRight;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private final int itemMargin;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private final int marginLeft;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private Drawable iconDefaultDrawable;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private Drawable transparentDefaultDrawable;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J$\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanHorizontalScrollSmallCard$b;", "Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard$a;", "", "t", "Landroid/view/View;", "itemRootView", "p", "", "itemPos", "Lpv4/s;", "itemData", "Lcom/tencent/sqshow/zootopia/data/c;", "parentCardData", "l", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "E", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "getMediaView", "()Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "setMediaView", "(Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;)V", "mediaView", UserInfo.SEX_FEMALE, "getTopLeftTagImg", "setTopLeftTagImg", "topLeftTagImg", "G", "getTopRightTagImg", "setTopRightTagImg", "topRightTagImg", "view", "<init>", "(Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanHorizontalScrollSmallCard;Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class b extends ZPlanBaseHorizontalScrollCard.a {

        /* renamed from: E, reason: from kotlin metadata */
        private ZPlanMediaView mediaView;

        /* renamed from: F, reason: from kotlin metadata */
        private ZPlanMediaView topLeftTagImg;

        /* renamed from: G, reason: from kotlin metadata */
        private ZPlanMediaView topRightTagImg;
        final /* synthetic */ ZPlanHorizontalScrollSmallCard H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ZPlanHorizontalScrollSmallCard zPlanHorizontalScrollSmallCard, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.H = zPlanHorizontalScrollSmallCard;
        }

        private final void t() {
            u.Companion companion = u.INSTANCE;
            Context context = this.H.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            float c16 = u.Companion.e(companion, context, false, 2, null) ? ((int) (((companion.c(this.H.getContext()) - this.H.marginLeft) - (this.H.itemMargin * 4)) / (4 + 0.25f))) / this.H.itemWidth : 1.0f;
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            m84.b.a(itemView, new ViewAdjustObject(this.itemView, c16, this.H.itemWidth, this.H.itemHeight, null, false, 48, null));
            ZPlanMediaView zPlanMediaView = this.mediaView;
            if (zPlanMediaView != null) {
                m84.b.a(zPlanMediaView, new ViewAdjustObject(zPlanMediaView, c16, this.H.mediaWidth, this.H.mediaHeight, null, false, 48, null));
            }
            ZPlanMediaView zPlanMediaView2 = this.topLeftTagImg;
            if (zPlanMediaView2 != null) {
                m84.b.a(zPlanMediaView2, new ViewAdjustObject(zPlanMediaView2, c16, this.H.topLeftSize, this.H.topLeftSize, new Rect(this.H.topLeftMarginLeft, this.H.topLeftMarginTop, 0, 0), true));
            }
            ZPlanMediaView zPlanMediaView3 = this.topRightTagImg;
            if (zPlanMediaView3 != null) {
                m84.b.a(zPlanMediaView3, new ViewAdjustObject(zPlanMediaView3, c16, this.H.topRightSize, this.H.topRightSize, new Rect(0, this.H.topRightMarginTop, this.H.topRightMarginRight, 0), true));
            }
        }

        @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard.a
        public void l(int itemPos, s itemData, ZootopiaCardData parentCardData) {
            t();
            if (itemData != null) {
                ZPlanMediaView zPlanMediaView = this.mediaView;
                if (zPlanMediaView != null) {
                    g gVar = itemData.f427681b;
                    Intrinsics.checkNotNullExpressionValue(gVar, "itemData.material");
                    zPlanMediaView.e(gVar);
                }
                ZPlanMediaView zPlanMediaView2 = this.topLeftTagImg;
                if (zPlanMediaView2 != null) {
                    zPlanMediaView2.setVisibility(8);
                }
                ZPlanMediaView zPlanMediaView3 = this.topRightTagImg;
                if (zPlanMediaView3 != null) {
                    zPlanMediaView3.setVisibility(8);
                }
                p[] pVarArr = itemData.f427685f;
                if (pVarArr != null) {
                    for (p pVar : pVarArr) {
                        if (pVar.f427651a != null) {
                            int i3 = pVar.f427652b;
                            if (i3 == 0) {
                                ZPlanMediaView zPlanMediaView4 = this.topLeftTagImg;
                                if (zPlanMediaView4 != null) {
                                    zPlanMediaView4.setVisibility(0);
                                }
                                ZPlanMediaView zPlanMediaView5 = this.topLeftTagImg;
                                if (zPlanMediaView5 != null) {
                                    g gVar2 = pVar.f427651a;
                                    Intrinsics.checkNotNullExpressionValue(gVar2, "label.material");
                                    zPlanMediaView5.e(gVar2);
                                }
                            } else if (i3 == 1) {
                                ZPlanMediaView zPlanMediaView6 = this.topRightTagImg;
                                if (zPlanMediaView6 != null) {
                                    zPlanMediaView6.setVisibility(0);
                                }
                                ZPlanMediaView zPlanMediaView7 = this.topRightTagImg;
                                if (zPlanMediaView7 != null) {
                                    g gVar3 = pVar.f427651a;
                                    Intrinsics.checkNotNullExpressionValue(gVar3, "label.material");
                                    zPlanMediaView7.e(gVar3);
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard.a
        public void p(View itemRootView) {
            Intrinsics.checkNotNullParameter(itemRootView, "itemRootView");
            this.mediaView = (ZPlanMediaView) this.itemView.findViewById(R.id.q3b);
            this.topLeftTagImg = (ZPlanMediaView) this.itemView.findViewById(R.id.q3k);
            this.topRightTagImg = (ZPlanMediaView) this.itemView.findViewById(R.id.q3l);
            ZPlanMediaView zPlanMediaView = this.mediaView;
            if (zPlanMediaView != null) {
                zPlanMediaView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            ZPlanMediaView zPlanMediaView2 = this.topLeftTagImg;
            if (zPlanMediaView2 != null) {
                zPlanMediaView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            ZPlanMediaView zPlanMediaView3 = this.topRightTagImg;
            if (zPlanMediaView3 != null) {
                zPlanMediaView3.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            ZPlanMediaView zPlanMediaView4 = this.mediaView;
            if (zPlanMediaView4 != null) {
                zPlanMediaView4.setDefaultDrawable(this.H.iconDefaultDrawable);
            }
            ZPlanMediaView zPlanMediaView5 = this.topLeftTagImg;
            if (zPlanMediaView5 != null) {
                zPlanMediaView5.setDefaultDrawable(this.H.transparentDefaultDrawable);
            }
            ZPlanMediaView zPlanMediaView6 = this.topRightTagImg;
            if (zPlanMediaView6 != null) {
                zPlanMediaView6.setDefaultDrawable(this.H.transparentDefaultDrawable);
            }
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanHorizontalScrollSmallCard$c", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends RecyclerView.ItemDecoration {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            outRect.right = ZPlanHorizontalScrollSmallCard.this.itemMargin;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanHorizontalScrollSmallCard(Context context, LifecycleOwner owner, a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.itemWidth = getResources().getDimensionPixelSize(R.dimen.f119768);
        this.itemHeight = getResources().getDimensionPixelSize(R.dimen.f11885z);
        this.mediaWidth = getResources().getDimensionPixelSize(R.dimen.f119061);
        this.mediaHeight = getResources().getDimensionPixelSize(R.dimen.f118960);
        this.topLeftSize = getResources().getDimensionPixelSize(R.dimen.f119364);
        this.topRightSize = getResources().getDimensionPixelSize(R.dimen.f119667);
        this.topLeftMarginTop = getResources().getDimensionPixelSize(R.dimen.f119263);
        this.topLeftMarginLeft = getResources().getDimensionPixelSize(R.dimen.f119162);
        this.topRightMarginTop = getResources().getDimensionPixelSize(R.dimen.f119566);
        this.topRightMarginRight = getResources().getDimensionPixelSize(R.dimen.f119465);
        this.itemMargin = i.b(4);
        this.marginLeft = getResources().getDimensionPixelSize(R.dimen.f12046e);
        this.iconDefaultDrawable = q.b(R.drawable.h_m);
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard
    public ZPlanBaseHorizontalScrollCard.a I(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return new b(this, view);
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard
    public void J(RecyclerView recyclerView, LinearLayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        recyclerView.addItemDecoration(new c());
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard
    public int L() {
        return R.layout.f167447dd1;
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public String z() {
        return "ZPlanHorizontalScrollSmallCard";
    }
}
