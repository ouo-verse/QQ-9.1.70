package com.tencent.mobileqq.ad.cardad.views.guild;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ad.cardad.data.aa;
import com.tencent.mobileqq.ad.cardad.views.CardAdView;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB!\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\b\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/views/guild/CardAdPicForGuildSquareFeed;", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView;", "", "o", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "Y", "f", "o0", "Landroidx/constraintlayout/widget/ConstraintLayout;", "k0", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mMediaContainerLayout", "Landroid/widget/FrameLayout;", "l0", "Landroid/widget/FrameLayout;", "mAdVoiceIconContainer", "Landroid/content/Context;", "context", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "Lcom/tencent/mobileqq/ad/cardad/data/aa;", "reportCallback", "<init>", "(Landroid/content/Context;Lcom/tencent/gdtad/aditem/GdtAd;Lcom/tencent/mobileqq/ad/cardad/data/aa;)V", "m0", "a", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class CardAdPicForGuildSquareFeed extends CardAdView {

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ConstraintLayout mMediaContainerLayout;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout mAdVoiceIconContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardAdPicForGuildSquareFeed(@NotNull Context context, @NotNull GdtAd gdtAd, @Nullable aa aaVar) {
        super(context, gdtAd, aaVar);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void Y() {
        super.Y();
        this.mMediaContainerLayout = (ConstraintLayout) J().findViewById(R.id.tmg);
        this.mAdVoiceIconContainer = (FrameLayout) J().findViewById(R.id.tn_);
        p0(G(), false);
        p0(A(), false);
        p0(this.mAdVoiceIconContainer, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void f() {
        ViewGroup.LayoutParams layoutParams;
        super.f();
        ConstraintLayout constraintLayout = this.mMediaContainerLayout;
        if (constraintLayout != null) {
            layoutParams = constraintLayout.getLayoutParams();
        } else {
            layoutParams = null;
        }
        ViewGroup.LayoutParams layoutParams2 = F().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams2;
        int innerShowType = D().getInnerShowType();
        if (innerShowType != 1) {
            if (innerShowType != 2) {
                if (innerShowType != 6) {
                    if (innerShowType == 8) {
                        if (layoutParams != null) {
                            layoutParams.width = ViewUtils.dpToPx(264.0f);
                        }
                        layoutParams3.dimensionRatio = "4:3";
                    }
                } else {
                    if (layoutParams != null) {
                        layoutParams.width = ViewUtils.dpToPx(264.0f);
                    }
                    layoutParams3.dimensionRatio = "3:2";
                }
            } else {
                if (layoutParams != null) {
                    layoutParams.width = ViewUtils.dpToPx(180.0f);
                }
                layoutParams3.dimensionRatio = "9:16";
            }
        } else {
            if (layoutParams != null) {
                layoutParams.width = ViewUtils.dpToPx(286.0f);
            }
            layoutParams3.dimensionRatio = "16:9";
        }
        FontSettingManager.resetViewSize2Normal(getContext(), this.mMediaContainerLayout);
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    protected int o() {
        return R.layout.e0w;
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    protected void o0() {
        GdtUIUtils.setViewRadius(u(), 15.0f);
        GdtUIUtils.setViewRadius(F(), 8.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    @NotNull
    public String q() {
        return "CardAdPicForGuildSquareFeed";
    }
}
