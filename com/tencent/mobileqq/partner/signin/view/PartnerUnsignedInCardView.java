package com.tencent.mobileqq.partner.signin.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.m;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.widget.RoundRectImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/partner/signin/view/PartnerUnsignedInCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "initView", "", "bgImageUrl", "B0", "Lcom/tencent/mobileqq/util/m$a;", "param", "C0", "Lcom/tencent/widget/RoundRectImageView;", "d", "Lcom/tencent/widget/RoundRectImageView;", "bgIv", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tipsTv", "Landroid/widget/Button;", "f", "Landroid/widget/Button;", "signInBtn", "", h.F, "Z", "hasInitView", "Landroid/view/View$OnClickListener;", "i", "Landroid/view/View$OnClickListener;", "getOnSignInClickListener", "()Landroid/view/View$OnClickListener;", "setOnSignInClickListener", "(Landroid/view/View$OnClickListener;)V", "onSignInClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PartnerUnsignedInCardView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RoundRectImageView bgIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tipsTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Button signInBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasInitView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener onSignInClickListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PartnerUnsignedInCardView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(PartnerUnsignedInCardView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoReport.reportEvent("dt_clck", this$0.signInBtn, null);
        View.OnClickListener onClickListener = this$0.onSignInClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    private final void B0(String bgImageUrl) {
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

    private final void initView() {
        if (this.hasInitView) {
            return;
        }
        this.hasInitView = true;
        LayoutInflater.from(getContext()).inflate(R.layout.f167358cw1, (ViewGroup) this, true);
        RoundRectImageView roundRectImageView = (RoundRectImageView) findViewById(R.id.oh7);
        this.bgIv = roundRectImageView;
        if (roundRectImageView != null) {
            roundRectImageView.setCornerRadiusAndMode(ViewUtils.dpToPx(16.0f), 1);
        }
        this.tipsTv = (TextView) findViewById(R.id.ohw);
        Button button = (Button) findViewById(R.id.f163134oh3);
        this.signInBtn = button;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.partner.signin.view.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PartnerUnsignedInCardView.A0(PartnerUnsignedInCardView.this, view);
                }
            });
        }
        VideoReport.setPageId(this, "pg_bas_surname_clock_superposed_layer");
        VideoReport.setPageReportPolicy(this, PageReportPolicy.REPORT_NONE);
        VideoReport.setElementId(this.signInBtn, "em_bas_punch_button");
        VideoReport.setElementClickPolicy(this.signInBtn, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.signInBtn, ExposurePolicy.REPORT_NONE);
    }

    public final void C0(m.PartnerReportData param) {
        String str;
        Intrinsics.checkNotNullParameter(param, "param");
        initView();
        TextView textView = this.tipsTv;
        if (textView != null) {
            com.tencent.mobileqq.partner.signin.b signInData = param.getSignInData();
            textView.setText(signInData != null ? signInData.a() : null);
        }
        Button button = this.signInBtn;
        if (button != null) {
            com.tencent.mobileqq.partner.signin.b signInData2 = param.getSignInData();
            button.setText(signInData2 != null ? signInData2.c() : null);
        }
        com.tencent.mobileqq.partner.signin.b signInData3 = param.getSignInData();
        if (signInData3 == null || (str = signInData3.b()) == null) {
            str = "";
        }
        B0(str);
        VideoReport.setPageParams(this, new PageParams(m.f306784a.a(param)));
        VideoReport.reportPgIn(this);
        VideoReport.reportEvent("dt_imp", this.signInBtn, null);
    }

    public final void setOnSignInClickListener(View.OnClickListener onClickListener) {
        this.onSignInClickListener = onClickListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PartnerUnsignedInCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PartnerUnsignedInCardView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PartnerUnsignedInCardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
