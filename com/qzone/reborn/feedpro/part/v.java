package com.qzone.reborn.feedpro.part;

import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.qzone.reborn.feedpro.banner.topbanner.item.FeedProBaseTopBanner;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/feedpro/part/v;", "Lcom/qzone/reborn/feedpro/part/b;", "Lsd/b;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/FrameLayout;", "D9", "", "onInitView", "Lcom/qzone/reborn/feedpro/banner/topbanner/item/FeedProBaseTopBanner;", "banner", "J4", "e2", "Lsd/a;", "d", "Lsd/a;", "topBannerManagerIoc", "e", "Landroid/widget/FrameLayout;", "topBannerContainer", "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class v extends b implements sd.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private sd.a topBannerManagerIoc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout topBannerContainer;

    private final FrameLayout D9(View rootView) {
        FrameLayout frameLayout = this.topBannerContainer;
        if (frameLayout != null) {
            return frameLayout;
        }
        ViewStub viewStub = (ViewStub) rootView.findViewById(R.id.mxh);
        if (viewStub != null) {
            FrameLayout frameLayout2 = (FrameLayout) viewStub.inflate().findViewById(R.id.mxg);
            this.topBannerContainer = frameLayout2;
            if (frameLayout2 == null) {
                QLog.e("QzoneFeedProTopBannerPart", 1, "getBannerContainer fail, view stub is null");
            }
            return this.topBannerContainer;
        }
        QLog.e("QzoneFeedProTopBannerPart", 1, "getBannerContainer fail, view stub is null");
        return null;
    }

    @Override // sd.b
    public void J4(FeedProBaseTopBanner banner) {
        Intrinsics.checkNotNullParameter(banner, "banner");
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        FrameLayout D9 = D9(rootView);
        if (D9 != null) {
            D9.removeAllViews();
            D9.addView(banner);
        }
    }

    @Override // sd.b
    public void e2(FeedProBaseTopBanner banner) {
        Intrinsics.checkNotNullParameter(banner, "banner");
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        FrameLayout D9 = D9(rootView);
        if (D9 != null) {
            D9.removeView(banner);
        }
    }

    @Override // com.qzone.reborn.feedpro.part.b, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        registerIoc(this, sd.b.class);
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        td.a aVar = new td.a(activity, this);
        this.topBannerManagerIoc = aVar;
        registerIoc(aVar, sd.a.class);
    }
}
