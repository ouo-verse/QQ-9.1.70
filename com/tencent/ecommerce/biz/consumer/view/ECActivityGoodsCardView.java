package com.tencent.ecommerce.biz.consumer.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.videnevent.api.IECVideoControlDelegate;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.ECGoodsCommonUtils;
import com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.bigcard.ECActivityGoodsBigCardView;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.repo.consumer.resp.UIInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00105\u001a\u000204\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0013\u001a\u00020\u0002H\u0014J\b\u0010\u0014\u001a\u00020\u0002H\u0014J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J \u0010\u0017\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J,\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010$\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/ECActivityGoodsCardView;", "Lcom/tencent/ecommerce/biz/consumer/view/ECVideoFeedsGoodsCardView;", "", "uiType", "", "c0", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", "", "Z", "e0", "Y", "f0", "a0", "d0", "b0", "N", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View;", "getBigView", "configCardUI", "updateUIByType", "Lcom/tencent/ecommerce/biz/consumer/report/b;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "", "ext", "onWrapperViewAppear", "onWrapperViewDisappear", "p", "o", "n0", "Ljava/lang/String;", "TAG", "Lkotlin/Function0;", "o0", "Lkotlin/jvm/functions/Function0;", "changeColorRunnable", "Landroid/os/CountDownTimer;", "p0", "Landroid/os/CountDownTimer;", "countDownTimer", "q0", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "bigUiInfo", "Lcom/tencent/ecommerce/biz/consumer/view/bigcard/ECActivityGoodsBigCardView;", "r0", "Lcom/tencent/ecommerce/biz/consumer/view/bigcard/ECActivityGoodsBigCardView;", "bigCardView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECActivityGoodsCardView extends ECVideoFeedsGoodsCardView {

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> changeColorRunnable;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private CountDownTimer countDownTimer;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private UIInfo bigUiInfo;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private ECActivityGoodsBigCardView bigCardView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/ECActivityGoodsCardView$configBigCardCountDown$1$1", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UIInfo f101663a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f101664b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ECActivityGoodsCardView f101665c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(UIInfo uIInfo, long j3, long j16, long j17, ECActivityGoodsCardView eCActivityGoodsCardView) {
            super(j16, j17);
            this.f101663a = uIInfo;
            this.f101664b = j3;
            this.f101665c = eCActivityGoodsCardView;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ECActivityGoodsBigCardView eCActivityGoodsBigCardView = this.f101665c.bigCardView;
            if (eCActivityGoodsBigCardView != null) {
                eCActivityGoodsBigCardView.k(this.f101663a);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            ECActivityGoodsBigCardView eCActivityGoodsBigCardView = this.f101665c.bigCardView;
            if (eCActivityGoodsBigCardView != null) {
                eCActivityGoodsBigCardView.k(this.f101663a);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/ECActivityGoodsCardView$configMediumCardCountDown$1$1", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UIInfo f101666a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f101667b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ECActivityGoodsCardView f101668c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(UIInfo uIInfo, long j3, long j16, long j17, ECActivityGoodsCardView eCActivityGoodsCardView) {
            super(j16, j17);
            this.f101666a = uIInfo;
            this.f101667b = j3;
            this.f101668c = eCActivityGoodsCardView;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f101668c.b0(this.f101666a);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            String c16 = ECGoodsCommonUtils.f101579a.c(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getTicket().getServerTimeMillis() / 1000, Long.parseLong(this.f101666a.getActivityEndTime()));
            this.f101668c.getMediumActivityTimeTextView().setText("\u5269\u4f59 " + c16);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class c implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101670e;

        c(UIInfo uIInfo) {
            this.f101670e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECActivityGoodsCardView.this.getMediumCardLayout().setTag(R.id.ntd, 1);
            IECGoodsCardView.IGoodsCardClickListener onClickEventListener = ECActivityGoodsCardView.this.getOnClickEventListener();
            if (onClickEventListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(onClickEventListener, ECActivityGoodsCardView.this.getMediumCardLayout(), ECGoodsCommonUtils.f101579a.o(this.f101670e.getJumpInfoArray()), null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class d implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101674e;

        d(UIInfo uIInfo) {
            this.f101674e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String o16;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!this.f101674e.getButtonJumpInfoArray().isEmpty()) {
                o16 = ECGoodsCommonUtils.f101579a.o(this.f101674e.getButtonJumpInfoArray());
            } else {
                o16 = ECGoodsCommonUtils.f101579a.o(this.f101674e.getJumpInfoArray());
            }
            String str = o16;
            ECActivityGoodsCardView.this.getMediumBuyButton().setTag(R.id.ntd, 2);
            IECGoodsCardView.IGoodsCardClickListener onClickEventListener = ECActivityGoodsCardView.this.getOnClickEventListener();
            if (onClickEventListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(onClickEventListener, ECActivityGoodsCardView.this.getMediumBuyButton(), str, null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class e implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101676e;

        e(UIInfo uIInfo) {
            this.f101676e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECActivityGoodsCardView.this.getSmallCardLayout().setTag(R.id.ntd, 1);
            IECGoodsCardView.IGoodsCardClickListener onClickEventListener = ECActivityGoodsCardView.this.getOnClickEventListener();
            if (onClickEventListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(onClickEventListener, ECActivityGoodsCardView.this.getSmallCardLayout(), ECGoodsCommonUtils.f101579a.o(this.f101676e.getJumpInfoArray()), null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECActivityGoodsCardView(Context context) {
        super(context);
        this.TAG = "ECActivityGoodsCardView[" + hashCode() + ']';
    }

    private final void Y() {
        UIInfo uIInfo = this.bigUiInfo;
        if (uIInfo != null) {
            if (uIInfo.getActivityEndTime().length() == 0) {
                return;
            }
            long j3 = 1000;
            long parseLong = Long.parseLong(uIInfo.getActivityEndTime()) - (QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getTicket().getServerTimeMillis() / j3);
            if (parseLong <= 0 || this.countDownTimer != null) {
                return;
            }
            a aVar = new a(uIInfo, parseLong, j3 * parseLong, 1000L, this);
            aVar.start();
            Unit unit = Unit.INSTANCE;
            this.countDownTimer = aVar;
        }
    }

    private final void Z(ECContentInfo contentInfo, UIInfo uiInfo, int uiType) {
        this.bigUiInfo = uiInfo;
        if (this.bigCardView == null) {
            this.bigCardView = new ECActivityGoodsBigCardView(getContext(), contentInfo);
        }
        ECActivityGoodsBigCardView eCActivityGoodsBigCardView = this.bigCardView;
        if (eCActivityGoodsBigCardView != null) {
            eCActivityGoodsBigCardView.e(uiType, uiInfo, getOnClickEventListener(), new ECActivityGoodsCardView$configBigCardUI$1(this));
        }
        ECActivityGoodsBigCardView eCActivityGoodsBigCardView2 = this.bigCardView;
        if (eCActivityGoodsBigCardView2 != null) {
            eCActivityGoodsBigCardView2.setVisibility(8);
        }
    }

    private final void a0() {
        UIInfo mediumCardUIInfo = getMediumCardUIInfo();
        if (mediumCardUIInfo != null) {
            if (mediumCardUIInfo.getActivityEndTime().length() == 0) {
                return;
            }
            long j3 = 1000;
            long parseLong = Long.parseLong(mediumCardUIInfo.getActivityEndTime()) - (QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getTicket().getServerTimeMillis() / j3);
            if (parseLong <= 0 || this.countDownTimer != null) {
                return;
            }
            b bVar = new b(mediumCardUIInfo, parseLong, j3 * parseLong, 1000L, this);
            this.countDownTimer = bVar;
            bVar.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(UIInfo uiInfo) {
        getMediumActivityTimeTextView().setVisibility(8);
        getMediumActivityTagTextView().setVisibility(8);
        getMediumActivityTagLayout().setBackground(null);
        if (uiInfo.getPromotionText().length() > 0) {
            getMediumActivityPromotionTextView().setText(uiInfo.getPromotionText());
            getMediumActivityPromotionTextView().setVisibility(0);
            getMediumPriceTextView().setVisibility(8);
        } else {
            getMediumActivityPromotionTextView().setVisibility(8);
            getMediumPriceTextView().setVisibility(0);
        }
    }

    private final boolean c0(int uiType) {
        if (uiType == 10302) {
            return true;
        }
        return false;
    }

    private final void d0(UIInfo uiInfo) {
        long serverTimeMillis = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getTicket().getServerTimeMillis() / 1000;
        getMediumActivityTagTextView().setText(uiInfo.getActivityTagInfo().getText());
        getMediumActivityTagTextView().setVisibility(0);
        getMediumPriceTextView().setVisibility(8);
        getMediumActivityPromotionTextView().setVisibility(8);
        if (!TextUtils.isEmpty(uiInfo.getActivityTagInfo().getFontColor())) {
            getMediumActivityTagTextView().setTextColor(com.tencent.ecommerce.richtext.utils.a.c(uiInfo.getActivityTagInfo().getFontColor()));
        }
        if (uiInfo.getActivityTagInfo().getForegroundColor().length() > 0) {
            ECGoodsCommonUtils.f101579a.q(getMediumActivityTagLayout(), uiInfo.getActivityTagInfo().getForegroundColor());
        }
        getMediumActivityTimeTextView().setText("\u5269\u4f59 " + ECGoodsCommonUtils.f101579a.c(serverTimeMillis, Long.parseLong(uiInfo.getActivityEndTime())));
        getMediumActivityTimeTextView().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        String str;
        ECContentInfo eCContentInfo;
        ECActivityGoodsBigCardView eCActivityGoodsBigCardView = this.bigCardView;
        if (eCActivityGoodsBigCardView != null) {
            eCActivityGoodsBigCardView.setVisibility(4);
        }
        if (N(getOriginUIType())) {
            post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.view.ECActivityGoodsCardView$updateBigCardUI$1
                @Override // java.lang.Runnable
                public final void run() {
                    ECActivityGoodsBigCardView eCActivityGoodsBigCardView2 = ECActivityGoodsCardView.this.bigCardView;
                    if (eCActivityGoodsBigCardView2 != null) {
                        eCActivityGoodsBigCardView2.setVisibility(0);
                    }
                    ECActivityGoodsBigCardView eCActivityGoodsBigCardView3 = ECActivityGoodsCardView.this.bigCardView;
                    if (eCActivityGoodsBigCardView3 != null) {
                        eCActivityGoodsBigCardView3.j(ECActivityGoodsCardView.this.getSmallCardLayout());
                    }
                    ECActivityGoodsCardView.this.getSmallCardLayout().setVisibility(8);
                }
            });
        } else if (M(getOriginUIType())) {
            post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.view.ECActivityGoodsCardView$updateBigCardUI$2
                @Override // java.lang.Runnable
                public final void run() {
                    ECActivityGoodsBigCardView eCActivityGoodsBigCardView2 = ECActivityGoodsCardView.this.bigCardView;
                    if (eCActivityGoodsBigCardView2 != null) {
                        eCActivityGoodsBigCardView2.setVisibility(0);
                    }
                    ECActivityGoodsBigCardView eCActivityGoodsBigCardView3 = ECActivityGoodsCardView.this.bigCardView;
                    if (eCActivityGoodsBigCardView3 != null) {
                        eCActivityGoodsBigCardView3.i(ECActivityGoodsCardView.this.getMediumCardLayout());
                    }
                    ECActivityGoodsCardView.this.getMediumCardLayout().setVisibility(8);
                }
            });
        }
        IECVideoControlDelegate videoControl = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVideoControl();
        if (videoControl != null) {
            ECActivityGoodsBigCardView eCActivityGoodsBigCardView2 = this.bigCardView;
            if (eCActivityGoodsBigCardView2 == null || (eCContentInfo = eCActivityGoodsBigCardView2.contentInfo) == null || (str = eCContentInfo.getContentId()) == null) {
                str = "";
            }
            videoControl.sendVideoInfoViewShowEvent(str, false, true);
        }
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countDownTimer = null;
    }

    private final void f0() {
        try {
            final long serverTimeMillis = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getTicket().getServerTimeMillis() / 1000;
            final UIInfo mediumCardUIInfo = getMediumCardUIInfo();
            if (mediumCardUIInfo != null) {
                if (TextUtils.isEmpty(mediumCardUIInfo.getActivityStartTime()) || TextUtils.isEmpty(mediumCardUIInfo.getActivityEndTime())) {
                    cg0.a.b(this.TAG, "configActivityTimeUI show time is null");
                    b0(mediumCardUIInfo);
                } else if (serverTimeMillis >= Long.parseLong(mediumCardUIInfo.getActivityEndTime())) {
                    b0(mediumCardUIInfo);
                    cg0.a.b(this.TAG, "configActivityTimeUI show time is after activity");
                } else if (serverTimeMillis >= Long.parseLong(mediumCardUIInfo.getActivityStartTime())) {
                    d0(mediumCardUIInfo);
                    cg0.a.b(this.TAG, "configActivityTimeUI show time on activity");
                }
                if (this.changeColorRunnable != null || TextUtils.isEmpty(mediumCardUIInfo.getButtonEndColor())) {
                    return;
                }
                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECActivityGoodsCardView$updateMediumActivityUI$$inlined$let$lambda$1
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
                        ECGoodsCommonUtils.f101579a.q(this.getMediumBuyButton(), UIInfo.this.getButtonEndColor());
                    }
                };
                this.changeColorRunnable = function0;
                ECThreadUtilKt.b(5000L, function0);
            }
        } catch (Exception e16) {
            cg0.a.a(this.TAG, "configActivityTimeUI", "updateUIByType show time on activity error:" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView
    public int I() {
        return 10300;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView
    protected boolean N(int uiType) {
        return uiType == super.I() || uiType == I();
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView, com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void configCardUI(ECContentInfo contentInfo, UIInfo uiInfo, int uiType) {
        if (c0(uiType)) {
            Z(contentInfo, uiInfo, uiType);
        } else {
            super.configCardUI(contentInfo, uiInfo, uiType);
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView, com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public View getBigView() {
        return this.bigCardView;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView
    public void o(ECContentInfo contentInfo, UIInfo uiInfo) {
        Boolean bool;
        String str;
        R(uiInfo);
        if (!TextUtils.isEmpty(uiInfo.getPicUrl())) {
            ECVideoFeedsGoodsCardView.Companion companion = ECVideoFeedsGoodsCardView.INSTANCE;
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(getContext(), uiInfo.getPicUrl(), getMediumImageView(), new IECImageLoader.ImageLoaderOption(companion.g(), companion.g(), 0, null, null, null, false, false, null, 508, null));
        }
        String activityMaskUrl = uiInfo.getActivityMaskUrl();
        if (activityMaskUrl != null) {
            bool = Boolean.valueOf(activityMaskUrl.length() > 0);
        } else {
            bool = null;
        }
        if (bool.booleanValue()) {
            getMediumCardForegroundImageView().setVisibility(0);
            ECVideoFeedsGoodsCardView.Companion companion2 = ECVideoFeedsGoodsCardView.INSTANCE;
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(getContext(), uiInfo.getActivityMaskUrl(), getMediumCardForegroundImageView(), new IECImageLoader.ImageLoaderOption(companion2.g(), companion2.g(), 0, null, null, null, false, false, null, 508, null));
        }
        getMediumTitleView().setText(uiInfo.getTitle());
        getMediumPriceTextView().setText(uiInfo.getPrice());
        if (!TextUtils.isEmpty(uiInfo.getButtonText())) {
            getMediumBuyButton().setText(uiInfo.getButtonText());
        } else {
            getMediumBuyButton().setVisibility(8);
        }
        if (!TextUtils.isEmpty(uiInfo.getButtonStartColor())) {
            str = uiInfo.getButtonStartColor();
        } else if (!TextUtils.isEmpty(uiInfo.getButtonBgColor())) {
            str = uiInfo.getButtonBgColor();
        } else {
            str = "linear-gradient(to right, #FF46A0 0%, #FF3355 100%)";
        }
        ECGoodsCommonUtils.f101579a.q(getMediumBuyButton(), str);
        getMediumCardLayout().setOnClickListener(new c(uiInfo));
        getMediumBuyButton().setOnClickListener(new d(uiInfo));
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView, com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onWrapperViewAppear(com.tencent.ecommerce.biz.consumer.report.b reportParams, Map<String, String> ext, ECContentInfo contentInfo) {
        super.onWrapperViewAppear(reportParams, ext, contentInfo);
        if (this.countDownTimer == null) {
            if (M(getUiType())) {
                a0();
            } else if (c0(getUiType())) {
                Y();
            }
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView, com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onWrapperViewDisappear(int uiType, com.tencent.ecommerce.biz.consumer.report.b reportParams, Map<String, String> ext) {
        super.onWrapperViewDisappear(uiType, reportParams, ext);
        if (uiType == z()) {
            this.changeColorRunnable = null;
            UIInfo mediumCardUIInfo = getMediumCardUIInfo();
            if (mediumCardUIInfo != null) {
                if (TextUtils.isEmpty(mediumCardUIInfo.getButtonStartColor())) {
                    getMediumBuyButton().setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bjh, null));
                } else {
                    ECGoodsCommonUtils.f101579a.q(getMediumBuyButton(), mediumCardUIInfo.getButtonStartColor());
                }
            }
            CountDownTimer countDownTimer = this.countDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.countDownTimer = null;
            return;
        }
        if (c0(uiType)) {
            ECActivityGoodsBigCardView eCActivityGoodsBigCardView = this.bigCardView;
            if (eCActivityGoodsBigCardView != null) {
                eCActivityGoodsBigCardView.f();
            }
            CountDownTimer countDownTimer2 = this.countDownTimer;
            if (countDownTimer2 != null) {
                countDownTimer2.cancel();
            }
            this.countDownTimer = null;
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView
    public void p(ECContentInfo contentInfo, UIInfo uiInfo) {
        super.p(contentInfo, uiInfo);
        getSmallCardLayout().setOnClickListener(new e(uiInfo));
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView, com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void updateUIByType(int uiType) {
        if (c0(getUiType()) && M(uiType)) {
            cg0.a.b(this.TAG, "updateUIByType unsupport big to meduim");
            return;
        }
        super.updateUIByType(uiType);
        if (c0(uiType)) {
            if (getIsAnimingSmallToMeduim()) {
                cg0.a.b(this.TAG, "updateUIByType updateBigCardUI isAnimingSmallToMeduim=true");
                ECActivityGoodsBigCardView eCActivityGoodsBigCardView = this.bigCardView;
                if (eCActivityGoodsBigCardView != null) {
                    eCActivityGoodsBigCardView.setVisibility(4);
                }
                P(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECActivityGoodsCardView$updateUIByType$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        ECActivityGoodsCardView.this.e0();
                    }
                });
                return;
            }
            e0();
            return;
        }
        ECActivityGoodsBigCardView eCActivityGoodsBigCardView2 = this.bigCardView;
        if (eCActivityGoodsBigCardView2 != null) {
            eCActivityGoodsBigCardView2.setVisibility(8);
        }
        if (uiType == z()) {
            f0();
        }
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countDownTimer = null;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView
    protected int z() {
        return 10301;
    }
}
