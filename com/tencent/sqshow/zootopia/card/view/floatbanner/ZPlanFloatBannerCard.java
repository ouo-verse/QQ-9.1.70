package com.tencent.sqshow.zootopia.card.view.floatbanner;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.sqshow.zootopia.card.view.banner.ZPlanBaseBannerCard;
import com.tencent.sqshow.zootopia.card.view.banner.ZplanInnerIndicatorView;
import com.tencent.sqshow.zootopia.portal.home.banner.Banner;
import com.tencent.sqshow.zootopia.portal.home.banner.indicator.Direction;
import com.tencent.sqshow.zootopia.portal.home.banner.indicator.b;
import com.tencent.sqshow.zootopia.portal.home.banner.indicator.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pv4.s;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004R\u00020\u00010\u0002H\u0016J \u0010\b\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004R\u00020\u00010\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/floatbanner/ZPlanFloatBannerCard;", "Lcom/tencent/sqshow/zootopia/card/view/banner/ZPlanBaseBannerCard;", "Lcom/tencent/sqshow/zootopia/portal/home/banner/Banner;", "Lpv4/s;", "Lcom/tencent/sqshow/zootopia/card/view/banner/ZPlanBaseBannerCard$d;", "bannerView", "", "V", BdhLogUtil.LogTag.Tag_Req, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "f0", "I", "itemWidth", "g0", "itemHeight", "h0", "indicatorMarginTop", "Landroidx/viewpager2/widget/MarginPageTransformer;", "i0", "Landroidx/viewpager2/widget/MarginPageTransformer;", "marginTransformer", "j0", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFloatBannerCard extends ZPlanBaseBannerCard {

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final int itemWidth;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private final int itemHeight;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final int indicatorMarginTop;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private MarginPageTransformer marginTransformer;

    @Override // com.tencent.sqshow.zootopia.card.view.banner.ZPlanBaseBannerCard
    public void R(Banner<s, ZPlanBaseBannerCard.d> bannerView) {
        Intrinsics.checkNotNullParameter(bannerView, "bannerView");
        Context context = bannerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ZplanInnerIndicatorView zplanInnerIndicatorView = new ZplanInnerIndicatorView(context);
        b helper = zplanInnerIndicatorView.getHelper();
        helper.y(Color.parseColor("#8c94a7"));
        helper.w(Color.parseColor("#d5d8e0"));
        bannerView.setIndicator(zplanInnerIndicatorView);
        bannerView.setIndicatorMargin(new c(0, this.indicatorMarginTop, 0, 0));
        bannerView.setIndicatorGravity(Direction.BELOW_BANNER);
    }

    @Override // com.tencent.sqshow.zootopia.card.view.banner.ZPlanBaseBannerCard
    public void V(Banner<s, ZPlanBaseBannerCard.d> bannerView) {
        Intrinsics.checkNotNullParameter(bannerView, "bannerView");
        bannerView.setLayoutParams(new FrameLayout.LayoutParams(this.itemWidth, this.itemHeight));
        bannerView.K(this.marginTransformer);
        MarginPageTransformer marginPageTransformer = new MarginPageTransformer(0);
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
        }
    }

    @Override // com.tencent.sqshow.zootopia.card.view.banner.ZPlanBaseBannerCard, com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public String z() {
        return "ZPlanHalfBannerCard";
    }
}
