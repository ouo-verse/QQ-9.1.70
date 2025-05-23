package com.qzone.reborn.feedpro.banner.hotbanner;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.qzone.reborn.feedpro.banner.hotbanner.item.FeedProBaseHotBanner;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import ef.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014B\u001b\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0013\u0010\u0017B#\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u0007H\u0014J\u0006\u0010\f\u001a\u00020\u0003R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/feedpro/banner/hotbanner/QzoneFeedProHotBannerPageContainerView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/qzone/reborn/feedpro/banner/hotbanner/item/FeedProBaseHotBanner;", "", "o0", "banner", "p0", "", "getLayoutId", "data", c.G, "m0", "n0", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "bannerContainer", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProHotBannerPageContainerView extends QZoneBaseWidgetView<FeedProBaseHotBanner> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout bannerContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProHotBannerPageContainerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        o0();
    }

    private final void o0() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        this.bannerContainer = linearLayout;
        addView(linearLayout);
    }

    private final void p0(FeedProBaseHotBanner banner) {
        LinearLayout linearLayout = this.bannerContainer;
        if (linearLayout != null && linearLayout.getLayoutParams() != null) {
            setPadding(d.b(16), 0, d.b(16), d.b(8));
        }
        LinearLayout linearLayout2 = this.bannerContainer;
        if (linearLayout2 != null) {
            linearLayout2.removeAllViews();
        }
        LinearLayout linearLayout3 = this.bannerContainer;
        if (linearLayout3 != null) {
            linearLayout3.addView(banner);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f129957g;
    }

    public final void n0() {
        LinearLayout linearLayout = this.bannerContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProHotBannerPageContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        o0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedProBaseHotBanner data, int pos) {
        if (data == null) {
            n0();
        } else {
            p0(data);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProHotBannerPageContainerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        o0();
    }
}
