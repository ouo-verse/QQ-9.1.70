package com.tencent.mobileqq.zplan.card.impl.view.halfbanner;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.card.impl.view.banner.ZPlanInnerLineIndicatorView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.sqshow.zootopia.card.view.banner.ZPlanBaseBannerCard;
import com.tencent.sqshow.zootopia.portal.home.banner.Banner;
import com.tencent.sqshow.zootopia.portal.home.banner.indicator.Direction;
import com.tencent.sqshow.zootopia.portal.home.banner.indicator.b;
import com.tencent.sqshow.zootopia.portal.home.banner.indicator.c;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oa4.a;
import pv4.s;
import t74.u;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001)B/\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010%\u001a\u00020\t\u00a2\u0006\u0004\b&\u0010'J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004R\u00020\u00010\u0002H\u0016J \u0010\b\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004R\u00020\u00010\u0002H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/halfbanner/ZPlanHalfBannerCard;", "Lcom/tencent/sqshow/zootopia/card/view/banner/ZPlanBaseBannerCard;", "Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner;", "Lpv4/s;", "Lcom/tencent/sqshow/zootopia/card/view/banner/ZPlanBaseBannerCard$d;", "bannerView", "", "V", BdhLogUtil.LogTag.Tag_Req, "", "f0", "I", NodeProps.MARGIN_LEFT, "g0", "itemMargin", "h0", "itemWidth", "i0", "itemHeight", "j0", "rightItemShownWidth", "k0", "indicatorHeight", "l0", "indicatorMarginTop", "Landroidx/viewpager2/widget/MarginPageTransformer;", "m0", "Landroidx/viewpager2/widget/MarginPageTransformer;", "marginTransformer", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "itemViewType", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", "n0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanHalfBannerCard extends ZPlanBaseBannerCard {

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final int marginLeft;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private final int itemMargin;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final int itemWidth;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private final int itemHeight;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private final int rightItemShownWidth;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private final int indicatorHeight;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private final int indicatorMarginTop;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private MarginPageTransformer marginTransformer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanHalfBannerCard(Context context, LifecycleOwner owner, a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.marginLeft = getResources().getDimensionPixelSize(R.dimen.f12226w);
        this.itemMargin = getResources().getDimensionPixelSize(R.dimen.f12216v);
        this.itemWidth = getResources().getDimensionPixelSize(R.dimen.f12256z);
        this.itemHeight = getResources().getDimensionPixelSize(R.dimen.f12246y);
        this.rightItemShownWidth = getResources().getDimensionPixelSize(R.dimen.f12236x);
        this.indicatorHeight = getResources().getDimensionPixelSize(R.dimen.f12196t);
        this.indicatorMarginTop = getResources().getDimensionPixelSize(R.dimen.f12206u);
    }

    @Override // com.tencent.sqshow.zootopia.card.view.banner.ZPlanBaseBannerCard
    public void R(Banner<s, ZPlanBaseBannerCard.d> bannerView) {
        Intrinsics.checkNotNullParameter(bannerView, "bannerView");
        Context context = bannerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ZPlanInnerLineIndicatorView zPlanInnerLineIndicatorView = new ZPlanInnerLineIndicatorView(context);
        b helper = zPlanInnerLineIndicatorView.getHelper();
        helper.y(Color.parseColor("#8c94a7"));
        helper.w(Color.parseColor("#d5d8e0"));
        bannerView.setIndicator(zPlanInnerLineIndicatorView);
        bannerView.setIndicatorMargin(new c(0, this.indicatorMarginTop, 0, 0));
        bannerView.setIndicatorGravity(Direction.BELOW_BANNER);
    }

    @Override // com.tencent.sqshow.zootopia.card.view.banner.ZPlanBaseBannerCard
    public void V(Banner<s, ZPlanBaseBannerCard.d> bannerView) {
        Intrinsics.checkNotNullParameter(bannerView, "bannerView");
        int c16 = u.INSTANCE.c(getContext());
        float f16 = c16 - (this.marginLeft * 2);
        int i3 = this.itemWidth;
        int i16 = (int) (f16 * (i3 / (this.rightItemShownWidth + i3)));
        int i17 = (int) (i16 * (this.itemHeight / i3));
        bannerView.setLayoutParams(new FrameLayout.LayoutParams(-1, this.indicatorMarginTop + i17 + this.indicatorHeight));
        bannerView.K(this.marginTransformer);
        MarginPageTransformer marginPageTransformer = new MarginPageTransformer(this.itemMargin);
        this.marginTransformer = marginPageTransformer;
        bannerView.w(marginPageTransformer);
        ViewPager2 E = bannerView.E();
        E.setOffscreenPageLimit(4);
        E.setClipToPadding(false);
        E.setClipChildren(false);
        View childAt = E.getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
        if (recyclerView != null) {
            recyclerView.setClipToPadding(false);
            recyclerView.setClipChildren(false);
            int i18 = this.marginLeft;
            recyclerView.setPadding(i18, 0, (c16 - i18) - i16, 0);
        }
        for (ZPlanMediaView zPlanMediaView : P()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i16, i17);
            layoutParams.leftMargin = this.marginLeft;
            zPlanMediaView.setLayoutParams(layoutParams);
        }
    }
}
