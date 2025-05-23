package com.qzone.reborn.feedpro.widget.header;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedpro.widget.header.QzoneFeedProRefreshHeaderView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/ad;", "Lcom/qzone/reborn/feedpro/widget/header/d;", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProRefreshHeaderView$b;", "", "onInit", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "N", "g0", "", "d", "offsetY", "e", "f", "a", "Lcom/qzone/reborn/feedpro/viewmodel/n;", "Lcom/qzone/reborn/feedpro/viewmodel/n;", "scrollViewModel", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "refreshLoadingIcon", "i", "I", "defaultRefreshMarginTop", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "needMoveRefreshIcon", "Landroid/view/View;", "containerView", "<init>", "(Landroid/view/View;Lcom/qzone/reborn/feedpro/viewmodel/n;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ad extends d implements QzoneFeedProRefreshHeaderView.b {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final com.qzone.reborn.feedpro.viewmodel.n scrollViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ImageView refreshLoadingIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int defaultRefreshMarginTop;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean needMoveRefreshIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(View containerView, com.qzone.reborn.feedpro.viewmodel.n nVar) {
        super(containerView);
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.scrollViewModel = nVar;
        View findViewById = containerView.findViewById(R.id.mwg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026_pro_header_refresh_icon)");
        this.refreshLoadingIcon = (ImageView) findViewById;
        this.defaultRefreshMarginTop = com.qzone.reborn.util.r.f59560a.e(5);
    }

    @Override // com.qzone.reborn.feedpro.widget.header.d, com.qzone.reborn.feedpro.widget.header.c
    public void N(RecyclerView.ViewHolder holder) {
        super.N(holder);
        RFWLog.d(k(), RFWLog.USR, "onAttachToWindow: ");
        com.qzone.reborn.feedpro.viewmodel.n nVar = this.scrollViewModel;
        if (nVar != null) {
            nVar.Z1(this);
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.header.QzoneFeedProRefreshHeaderView.b
    public void a() {
        this.refreshLoadingIcon.setVisibility(8);
    }

    @Override // com.qzone.reborn.feedpro.widget.header.QzoneFeedProRefreshHeaderView.b
    public int d() {
        int coerceAtLeast;
        if (!this.needMoveRefreshIcon) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = this.refreshLoadingIcon.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((ViewGroup.MarginLayoutParams) layoutParams).topMargin - this.defaultRefreshMarginTop, 0);
        return coerceAtLeast;
    }

    @Override // com.qzone.reborn.feedpro.widget.header.QzoneFeedProRefreshHeaderView.b
    public void e(int offsetY) {
        int coerceAtLeast;
        if (this.needMoveRefreshIcon) {
            int i3 = this.defaultRefreshMarginTop;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(offsetY, 0);
            int i16 = i3 + coerceAtLeast;
            ImageView imageView = this.refreshLoadingIcon;
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                int i17 = layoutParams2 != null ? layoutParams2.width : -2;
                ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i17, layoutParams3 != null ? layoutParams3.height : -2);
            }
            if (i16 != marginLayoutParams.topMargin) {
                marginLayoutParams.topMargin = i16;
                imageView.setLayoutParams(marginLayoutParams);
            }
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.header.QzoneFeedProRefreshHeaderView.b
    public void f() {
        this.refreshLoadingIcon.setVisibility(0);
    }

    @Override // com.qzone.reborn.feedpro.widget.header.d, com.qzone.reborn.feedpro.widget.header.c
    public void g0(RecyclerView.ViewHolder holder) {
        super.g0(holder);
        RFWLog.d(k(), RFWLog.USR, "onDetachToWindow: ");
        com.qzone.reborn.feedpro.viewmodel.n nVar = this.scrollViewModel;
        if (nVar != null) {
            nVar.Z1(null);
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void onInit() {
        ImageView imageView = this.refreshLoadingIcon;
        imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(imageView.getContext(), 4));
    }
}
