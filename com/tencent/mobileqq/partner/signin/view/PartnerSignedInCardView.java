package com.tencent.mobileqq.partner.signin.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.m;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.widget.RoundRectImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0016\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/partner/signin/view/PartnerSignedInCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "initView", "", "bgImageUrl", "z0", "friendUin", "Lcom/tencent/mobileqq/partner/signin/b;", "signInData", "B0", "Lcom/tencent/mobileqq/util/m$a;", "param", "A0", "", "d", "Z", "hasInitView", "Lcom/tencent/widget/RoundRectImageView;", "e", "Lcom/tencent/widget/RoundRectImageView;", "bgIv", "Lcom/tencent/mobileqq/partner/signin/view/PartnerSignInInfoView;", "f", "Lcom/tencent/mobileqq/partner/signin/view/PartnerSignInInfoView;", "infoView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PartnerSignedInCardView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean hasInitView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RoundRectImageView bgIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private PartnerSignInInfoView infoView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PartnerSignedInCardView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initView() {
        if (this.hasInitView) {
            return;
        }
        this.hasInitView = true;
        LayoutInflater.from(getContext()).inflate(R.layout.f167357cw0, (ViewGroup) this, true);
        RoundRectImageView roundRectImageView = (RoundRectImageView) findViewById(R.id.oh7);
        this.bgIv = roundRectImageView;
        if (roundRectImageView != null) {
            roundRectImageView.setCornerRadiusAndMode(ViewUtils.dpToPx(16.0f), 1);
        }
        this.infoView = (PartnerSignInInfoView) findViewById(R.id.ohe);
        VideoReport.setPageId(this, "pg_bas_surname_clock_superposed_layer");
        VideoReport.setPageReportPolicy(this, PageReportPolicy.REPORT_NONE);
    }

    private final void z0(String bgImageUrl) {
        if (bgImageUrl.length() > 0) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            URLDrawable drawable2 = URLDrawable.getDrawable(bgImageUrl, obtain);
            RoundRectImageView roundRectImageView = this.bgIv;
            if (roundRectImageView != null) {
                roundRectImageView.setImageDrawable(drawable2);
            }
        }
    }

    public final void A0(String friendUin, m.PartnerReportData param) {
        String str;
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(param, "param");
        initView();
        com.tencent.mobileqq.partner.signin.b signInData = param.getSignInData();
        if (signInData == null || (str = signInData.b()) == null) {
            str = "";
        }
        z0(str);
        B0(friendUin, param.getSignInData());
        VideoReport.setPageParams(this, new PageParams(m.f306784a.a(param)));
        VideoReport.reportPgIn(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PartnerSignedInCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PartnerSignedInCardView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PartnerSignedInCardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void B0(String friendUin, com.tencent.mobileqq.partner.signin.b signInData) {
        if (signInData == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        PartnerSignInInfoView partnerSignInInfoView = this.infoView;
        if (partnerSignInInfoView != null) {
            partnerSignInInfoView.J0(currentAccountUin, friendUin, signInData);
        }
    }
}
