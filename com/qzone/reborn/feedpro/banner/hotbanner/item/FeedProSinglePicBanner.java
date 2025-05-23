package com.qzone.reborn.feedpro.banner.hotbanner.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qzone.reborn.feedpro.banner.hotbanner.constant.FeedProHotBannerType;
import com.qzone.reborn.feedpro.banner.hotbanner.item.FeedProSinglePicBanner;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ef.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ld.b;
import pl.a;
import tl.h;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 #2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0014J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\tH\u0014R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001d\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/feedpro/banner/hotbanner/item/FeedProSinglePicBanner;", "Lcom/qzone/reborn/feedpro/banner/hotbanner/item/FeedProBaseHotBanner;", "", "v0", "Lld/b;", "bannerData", "x0", "Landroid/content/Context;", "context", "", "viewType", "initView", "Lcom/qzone/reborn/feedpro/banner/hotbanner/constant/FeedProHotBannerType;", "n0", "m0", "", "r0", "Landroid/view/View;", "v", "o0", "getLayoutId", c.G, "u0", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "e", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", ParseCommon.CONTAINER, "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "picIv", h.F, "closeIv", "<init>", "(Landroid/content/Context;)V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class FeedProSinglePicBanner extends FeedProBaseHotBanner {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RoundCorneredFrameLayout container;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView picIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView closeIv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedProSinglePicBanner(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void v0() {
        ImageView imageView = this.closeIv;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: od.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedProSinglePicBanner.w0(FeedProSinglePicBanner.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(FeedProSinglePicBanner this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void x0(b bannerData) {
        ViewGroup.LayoutParams layoutParams;
        int o16 = a.f426446a.o(getContext()) - 32;
        int i3 = (int) (o16 / 3.7547169f);
        ImageView imageView = this.picIv;
        if (imageView != null && (layoutParams = imageView.getLayoutParams()) != null) {
            layoutParams.width = -1;
            layoutParams.height = i3;
            ImageView imageView2 = this.picIv;
            if (imageView2 != null) {
                imageView2.setLayoutParams(layoutParams);
            }
        }
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl("https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qzone/test/qecommerce_qzone_banner_test_v1.png").setTargetView(this.picIv).setLoadingDrawable(null).setLoadingDrawableId(R.drawable.trans).setRequestWidth(o16).setRequestHeight(i3));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f130318f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void initView(Context context, int viewType) {
        super.initView(context, viewType);
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) findViewById(R.id.d1r);
        this.container = roundCorneredFrameLayout;
        if (roundCorneredFrameLayout != null) {
            roundCorneredFrameLayout.setRadius(d.b(14));
        }
        this.picIv = (ImageView) findViewById(R.id.d2_);
        this.closeIv = (ImageView) findViewById(R.id.d1q);
        v0();
    }

    @Override // com.qzone.reborn.feedpro.banner.hotbanner.item.FeedProBaseHotBanner
    public int m0() {
        return 2;
    }

    @Override // com.qzone.reborn.feedpro.banner.hotbanner.item.FeedProBaseHotBanner
    public FeedProHotBannerType n0() {
        return FeedProHotBannerType.TYPE_SINGLE_PIC_BANNER;
    }

    @Override // com.qzone.reborn.feedpro.banner.hotbanner.item.FeedProBaseHotBanner
    public boolean r0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public void bindData(b bannerData, int pos) {
        if (bannerData != null) {
            x0(bannerData);
        }
    }

    @Override // com.qzone.reborn.feedpro.banner.hotbanner.item.FeedProBaseHotBanner
    public void o0(View v3) {
    }
}
