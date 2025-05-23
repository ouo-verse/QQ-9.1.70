package com.tencent.ecommerce.biz.consumer.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import cg0.a;
import com.tencent.ecommerce.base.ui.ECRoundImageView;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.ECGoodsCommonUtils;
import com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.ecommerce.repo.consumer.resp.UIInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J,\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001bH\u0014R\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/ECNGWeakenCardView;", "Lcom/tencent/ecommerce/biz/consumer/view/ECNGCardView;", "", "uiType", "", "h0", "a0", "U", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "N", "j0", "i0", "k0", "", "updateUIByType", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", "J", "I", "Lcom/tencent/ecommerce/biz/consumer/report/b;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "", "ext", "onWrapperViewDisappear", "", NodeProps.MARGIN_RIGHT, "d0", "Lkotlin/Function0;", "y0", "Lkotlin/jvm/functions/Function0;", "changeColorRunnable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECNGWeakenCardView extends ECNGCardView {

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> changeColorRunnable;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101747e;

        a(UIInfo uIInfo) {
            this.f101747e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECNGWeakenCardView.this.getMediumCardLayout().setTag(R.id.ntd, 1);
            IECGoodsCardView.IGoodsCardClickListener onClickEventListener = ECNGWeakenCardView.this.getOnClickEventListener();
            if (onClickEventListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(onClickEventListener, ECNGWeakenCardView.this.getMediumCardLayout(), ECGoodsCommonUtils.f101579a.o(this.f101747e.getJumpInfoArray()), null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101749e;

        b(UIInfo uIInfo) {
            this.f101749e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String o16;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!this.f101749e.getButtonJumpInfoArray().isEmpty()) {
                o16 = ECGoodsCommonUtils.f101579a.o(this.f101749e.getButtonJumpInfoArray());
            } else {
                o16 = ECGoodsCommonUtils.f101579a.o(this.f101749e.getJumpInfoArray());
            }
            String str = o16;
            ECNGWeakenCardView.this.getMediumCardBuyLayout().setTag(R.id.ntd, 2);
            IECGoodsCardView.IGoodsCardClickListener onClickEventListener = ECNGWeakenCardView.this.getOnClickEventListener();
            if (onClickEventListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(onClickEventListener, ECNGWeakenCardView.this.getMediumCardBuyLayout(), str, null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class c implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101751e;

        c(UIInfo uIInfo) {
            this.f101751e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECNGWeakenCardView.this.getSmallCardLayout().setTag(R.id.ntd, 1);
            IECGoodsCardView.IGoodsCardClickListener onClickEventListener = ECNGWeakenCardView.this.getOnClickEventListener();
            if (onClickEventListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(onClickEventListener, ECNGWeakenCardView.this.getSmallCardLayout(), ECGoodsCommonUtils.f101579a.o(this.f101751e.getJumpInfoArray()), null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECNGWeakenCardView(Context context) {
        super(context);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public void I(ECContentInfo contentInfo, UIInfo uiInfo) {
        String str;
        super.I(contentInfo, uiInfo);
        getMediumCardLayout().getLayoutParams().height = e.c(42.0f);
        ViewGroup.LayoutParams layoutParams = getMediumCardTitleContainerView().getLayoutParams();
        if (layoutParams != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = e.c(6.0f);
            layoutParams2.bottomMargin = e.c(4.0f);
            ImageView mediumCardImageView = getMediumCardImageView();
            if (mediumCardImageView != null) {
                ((ECRoundImageView) mediumCardImageView).setRadius(e.c(4.0f));
                ImageView mediumCardForegroundImageView = getMediumCardForegroundImageView();
                if (mediumCardForegroundImageView != null) {
                    ((ECRoundImageView) mediumCardForegroundImageView).setRadius(e.c(4.0f));
                    ViewGroup.LayoutParams layoutParams3 = getMediumCardImageViewLayout().getLayoutParams();
                    if (layoutParams3 != null) {
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
                        layoutParams4.width = e.c(24.0f);
                        layoutParams4.height = e.c(24.0f);
                        layoutParams4.leftMargin = 0;
                        layoutParams4.topMargin = 0;
                        layoutParams4.bottomMargin = 0;
                        layoutParams4.gravity = 0;
                        getMediumCardLayout().setOnClickListener(new a(uiInfo));
                        getMediumCardBuyLayout().setOnClickListener(new b(uiInfo));
                        if (!TextUtils.isEmpty(uiInfo.getButtonStartColor())) {
                            str = uiInfo.getButtonStartColor();
                        } else if (!TextUtils.isEmpty(uiInfo.getButtonBgColor())) {
                            str = uiInfo.getButtonBgColor();
                        } else {
                            str = "linear-gradient(to right, #FF46A0 0%, #FF3355 100%)";
                        }
                        ECGoodsCommonUtils.f101579a.q(getMediumCardBuyLayout(), str);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.base.ui.ECRoundImageView");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.base.ui.ECRoundImageView");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public void J(ECContentInfo contentInfo, UIInfo uiInfo) {
        super.J(contentInfo, uiInfo);
        getSmallCardLayout().setOnClickListener(new c(uiInfo));
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public int N() {
        return ECNGCardView.INSTANCE.f();
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public int Q() {
        return ECNGCardView.INSTANCE.f();
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public int U() {
        return PlayUI.UIType.WEAKEN_MEDIUM_CARD_NG;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public int a0() {
        return PlayUI.UIType.WEAKEN_SMALL_CARD_NG;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public boolean h0(int uiType) {
        return uiType == super.a0() || uiType == a0();
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public boolean i0() {
        return false;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public boolean j0() {
        return true;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public boolean k0() {
        return true;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView, com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onWrapperViewDisappear(int uiType, com.tencent.ecommerce.biz.consumer.report.b reportParams, Map<String, String> ext) {
        super.onWrapperViewDisappear(uiType, reportParams, ext);
        if (uiType == U()) {
            this.changeColorRunnable = null;
            UIInfo mediumCardUIInfo = getMediumCardUIInfo();
            if (mediumCardUIInfo != null) {
                if (TextUtils.isEmpty(mediumCardUIInfo.getButtonStartColor())) {
                    getMediumCardBuyLayout().setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bjh, null));
                } else {
                    ECGoodsCommonUtils.f101579a.q(getMediumCardBuyLayout(), mediumCardUIInfo.getButtonStartColor());
                }
            }
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView, com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void updateUIByType(int uiType) {
        final UIInfo mediumCardUIInfo;
        super.updateUIByType(uiType);
        if (uiType == U() && this.changeColorRunnable == null && (mediumCardUIInfo = getMediumCardUIInfo()) != null) {
            if (mediumCardUIInfo.getButtonEndColor().length() == 0) {
                return;
            }
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGWeakenCardView$updateUIByType$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ECGoodsCommonUtils.f101579a.q(this.getMediumCardBuyLayout(), UIInfo.this.getButtonEndColor());
                    a.b("ECNGCardView", "configBigCardUI set buttonEndColor");
                }
            };
            this.changeColorRunnable = function0;
            ECThreadUtilKt.b(5000L, function0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public void d0(UIInfo uiInfo, float marginRight) {
        l0(e.c(32.0f));
        super.d0(uiInfo, marginRight);
    }
}
