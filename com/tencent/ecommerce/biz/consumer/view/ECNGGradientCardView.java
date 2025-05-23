package com.tencent.ecommerce.biz.consumer.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import cg0.a;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.ECGoodsCommonUtils;
import com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.repo.consumer.resp.UIInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J,\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012H\u0016R\u0014\u0010\u0018\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/ECNGGradientCardView;", "Lcom/tencent/ecommerce/biz/consumer/view/ECNGCardView;", "", "uiType", "", "h0", "a0", "U", "", "updateUIByType", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", "J", "I", "Lcom/tencent/ecommerce/biz/consumer/report/b;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "", "ext", "onWrapperViewDisappear", "y0", "Ljava/lang/String;", "TAG", "Lkotlin/Function0;", "z0", "Lkotlin/jvm/functions/Function0;", "changeColorRunnable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECNGGradientCardView extends ECNGCardView {

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> changeColorRunnable;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101740e;

        a(UIInfo uIInfo) {
            this.f101740e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECNGGradientCardView.this.getMediumCardLayout().setTag(R.id.ntd, 1);
            IECGoodsCardView.IGoodsCardClickListener onClickEventListener = ECNGGradientCardView.this.getOnClickEventListener();
            if (onClickEventListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(onClickEventListener, ECNGGradientCardView.this.getMediumCardLayout(), ECGoodsCommonUtils.f101579a.o(this.f101740e.getJumpInfoArray()), null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101742e;

        b(UIInfo uIInfo) {
            this.f101742e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String o16;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!this.f101742e.getButtonJumpInfoArray().isEmpty()) {
                o16 = ECGoodsCommonUtils.f101579a.o(this.f101742e.getButtonJumpInfoArray());
            } else {
                o16 = ECGoodsCommonUtils.f101579a.o(this.f101742e.getJumpInfoArray());
            }
            String str = o16;
            ECNGGradientCardView.this.getMediumCardBuyLayout().setTag(R.id.ntd, 2);
            IECGoodsCardView.IGoodsCardClickListener onClickEventListener = ECNGGradientCardView.this.getOnClickEventListener();
            if (onClickEventListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(onClickEventListener, ECNGGradientCardView.this.getMediumCardBuyLayout(), str, null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class c implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101744e;

        c(UIInfo uIInfo) {
            this.f101744e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECNGGradientCardView.this.getSmallCardLayout().setTag(R.id.ntd, 1);
            IECGoodsCardView.IGoodsCardClickListener onClickEventListener = ECNGGradientCardView.this.getOnClickEventListener();
            if (onClickEventListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(onClickEventListener, ECNGGradientCardView.this.getSmallCardLayout(), ECGoodsCommonUtils.f101579a.o(this.f101744e.getJumpInfoArray()), null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECNGGradientCardView(Context context) {
        super(context);
        this.TAG = "ECNGGradientCardView[" + hashCode() + ']';
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public void I(ECContentInfo contentInfo, UIInfo uiInfo) {
        super.I(contentInfo, uiInfo);
        getMediumCardLayout().setOnClickListener(new a(uiInfo));
        getMediumCardBuyLayout().setOnClickListener(new b(uiInfo));
        if (TextUtils.isEmpty(uiInfo.getButtonStartColor())) {
            return;
        }
        ECGoodsCommonUtils.f101579a.q(getMediumCardBuyLayout(), uiInfo.getButtonStartColor());
        cg0.a.b(this.TAG, "configBigCardUI set buttonStartColor");
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public void J(ECContentInfo contentInfo, UIInfo uiInfo) {
        super.J(contentInfo, uiInfo);
        getSmallCardLayout().setOnClickListener(new c(uiInfo));
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public int U() {
        return 10501;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public int a0() {
        return 10500;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECNGCardView
    public boolean h0(int uiType) {
        return uiType == super.a0() || uiType == a0();
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
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGGradientCardView$updateUIByType$$inlined$let$lambda$1
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
                    String str;
                    ECGoodsCommonUtils.f101579a.q(this.getMediumCardBuyLayout(), UIInfo.this.getButtonEndColor());
                    str = this.TAG;
                    a.b(str, "configBigCardUI set buttonEndColor");
                }
            };
            this.changeColorRunnable = function0;
            ECThreadUtilKt.b(5000L, function0);
        }
    }
}
