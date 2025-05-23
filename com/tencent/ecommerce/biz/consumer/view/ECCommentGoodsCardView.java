package com.tencent.ecommerce.biz.consumer.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.graphics.ColorUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.ui.ECRoundImageView;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.ECGoodsCommonUtils;
import com.tencent.ecommerce.biz.consumer.report.b;
import com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView;
import com.tencent.ecommerce.biz.res.api.IECResourceApi;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.repo.consumer.resp.UIInfo;
import com.tencent.ecommerce.richtext.ui.dom.style.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt__StringsJVMKt;
import nh0.a;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010L\u001a\u00020K\u00a2\u0006\u0004\bM\u0010NJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J,\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J,\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J$\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u001c\u0010 \u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\n\u0010#\u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016R\u0014\u0010'\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010<\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010.R\u0018\u0010@\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010.R\u0018\u0010C\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010HR\u0016\u0010J\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010,\u00a8\u0006O"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/ECCommentGoodsCardView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView;", "", "l", "", "j", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", "k", h.F, "i", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "uiType", "configCardUI", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "listener", "setGoodsCardClickListener", "updateUIByType", "Lcom/tencent/ecommerce/biz/consumer/report/b;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "", "ext", "onWrapperViewAppear", "resetToSmallCardIfNeed", "onWrapperViewDisappear", "onClickReport", "Landroid/view/View$OnClickListener;", "animStartListener", "animEndListener", "setCloseClickEventListener", "Landroid/view/View;", "getView", "getBigView", "getUIType", "d", "Ljava/lang/String;", "TAG", "e", "I", "", "f", "Z", "isRichModelInit", "Landroid/view/View;", "commentFeedsGoodsCardLayout", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "richTextParent", "Lcom/tencent/ecommerce/base/ui/ECRoundImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/ecommerce/base/ui/ECRoundImageView;", "goodsImageView", "Lnh0/a;", BdhLogUtil.LogTag.Tag_Conn, "Lnh0/a;", "richTitleModel", "D", "richSubTitleModel", "E", "richTitleView", UserInfo.SEX_FEMALE, "richSubTitleView", "G", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "onClickEventListener", "H", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "cardUIInfo", "", "J", "exposeTimeMillis", MiniGamePAHippyBaseFragment.KEY_THEME, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECCommentGoodsCardView extends FrameLayout implements IECGoodsCardView {

    /* renamed from: C, reason: from kotlin metadata */
    private final nh0.a richTitleModel;

    /* renamed from: D, reason: from kotlin metadata */
    private final nh0.a richSubTitleModel;

    /* renamed from: E, reason: from kotlin metadata */
    private View richTitleView;

    /* renamed from: F, reason: from kotlin metadata */
    private View richSubTitleView;

    /* renamed from: G, reason: from kotlin metadata */
    private IECGoodsCardView.IGoodsCardClickListener onClickEventListener;

    /* renamed from: H, reason: from kotlin metadata */
    private UIInfo cardUIInfo;

    /* renamed from: I, reason: from kotlin metadata */
    private long exposeTimeMillis;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isNightMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int uiType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isRichModelInit;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final View commentFeedsGoodsCardLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout richTextParent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ECRoundImageView goodsImageView;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101684e;

        a(UIInfo uIInfo) {
            this.f101684e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECCommentGoodsCardView.this.commentFeedsGoodsCardLayout.setTag(R.id.ntd, 1);
            IECGoodsCardView.IGoodsCardClickListener iGoodsCardClickListener = ECCommentGoodsCardView.this.onClickEventListener;
            if (iGoodsCardClickListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(iGoodsCardClickListener, ECCommentGoodsCardView.this.commentFeedsGoodsCardLayout, ECGoodsCommonUtils.f101579a.o(this.f101684e.getJumpInfoArray()), null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECCommentGoodsCardView(Context context) {
        super(context);
        this.TAG = "ECCommentGoodsCardView[" + hashCode() + ']';
        this.uiType = 700;
        this.richTitleModel = new nh0.a(false, 1, null);
        this.richSubTitleModel = new nh0.a(false, 1, null);
        com.tencent.ecommerce.base.device.a.f100685b.f(context, LayoutInflater.from(context).inflate(R.layout.f167325cp3, (ViewGroup) this, true));
        this.commentFeedsGoodsCardLayout = findViewById(R.id.o2h);
        this.goodsImageView = (ECRoundImageView) findViewById(R.id.o1o);
        this.richTextParent = (LinearLayout) findViewById(R.id.o39);
        this.isNightMode = fg0.a.f398587b.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(UIInfo uiInfo) {
        String replace$default;
        String replace$default2;
        String replace$default3;
        IECResourceApi resourceApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getResourceApi();
        if (resourceApi != null) {
            String hexString = Integer.toHexString(resourceApi.getColor("text_primary"));
            String str = '#' + hexString + "|#" + hexString;
            int color = resourceApi.getColor("text_secondary");
            String str2 = '#' + Integer.toHexString(ColorUtils.setAlphaComponent(color, (int) 76.5d));
            replace$default = StringsKt__StringsJVMKt.replace$default(uiInfo.getRichTitle(), "#000000|rgba(255,255,255,1)", str, false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "#c7c7c7", str2, false, 4, (Object) null);
            uiInfo.setRichTitle(replace$default2);
            String hexString2 = Integer.toHexString(color);
            replace$default3 = StringsKt__StringsJVMKt.replace$default(uiInfo.getRichSubTitle(), "#999999|rgba(255,255,255,0.55)", '#' + hexString2 + "|#" + hexString2, false, 4, (Object) null);
            uiInfo.setRichSubTitle(replace$default3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int j() {
        return this.isNightMode ? 1 : 0;
    }

    private final void k(final UIInfo uiInfo) {
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECCommentGoodsCardView$initRichModelOnSubThread$1
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
                a aVar;
                int j3;
                a aVar2;
                int j16;
                ECCommentGoodsCardView.this.h(uiInfo);
                str = ECCommentGoodsCardView.this.TAG;
                cg0.a.b(str, "init richTitleModel richTitle:" + uiInfo.getRichTitle() + " , richSubTitle:" + uiInfo.getRichSubTitle());
                if (TextUtils.isEmpty(uiInfo.getRichTitle()) || TextUtils.isEmpty(uiInfo.getRichSubTitle())) {
                    return;
                }
                float f16 = ECDeviceUtils.f104857e.f() - (g.i(106) * 1.0f);
                JSONObject jSONObject = new JSONObject(uiInfo.getRichTitle());
                aVar = ECCommentGoodsCardView.this.richTitleModel;
                j3 = ECCommentGoodsCardView.this.j();
                aVar.c(jSONObject, f16, j3);
                JSONObject jSONObject2 = new JSONObject(uiInfo.getRichSubTitle());
                aVar2 = ECCommentGoodsCardView.this.richSubTitleModel;
                j16 = ECCommentGoodsCardView.this.j();
                aVar2.c(jSONObject2, f16, j16);
                ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECCommentGoodsCardView$initRichModelOnSubThread$1.1
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
                        ECCommentGoodsCardView$initRichModelOnSubThread$1 eCCommentGoodsCardView$initRichModelOnSubThread$1 = ECCommentGoodsCardView$initRichModelOnSubThread$1.this;
                        ECCommentGoodsCardView.this.i(uiInfo);
                    }
                });
            }
        });
        this.isRichModelInit = true;
    }

    private final void l() {
        boolean a16 = fg0.a.f398587b.a();
        if (a16 == this.isNightMode) {
            return;
        }
        this.isNightMode = a16;
        this.richTitleModel.g(j());
        this.richSubTitleModel.g(j());
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void configCardUI(ECContentInfo contentInfo, UIInfo uiInfo, int uiType) {
        cg0.a.b(this.TAG, "configCardUI uiType :" + uiType + ",uiInfo :" + uiInfo.toString());
        this.cardUIInfo = uiInfo;
        ECVideoFeedsGoodsCardView.Companion companion = ECVideoFeedsGoodsCardView.INSTANCE;
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(getContext(), uiInfo.getPicUrl(), this.goodsImageView, new IECImageLoader.ImageLoaderOption(companion.g(), companion.g(), 0, null, null, null, false, false, null, 508, null));
        i(uiInfo);
        this.commentFeedsGoodsCardLayout.setOnClickListener(new a(uiInfo));
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public View getBigView() {
        return null;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    /* renamed from: getUIType, reason: from getter */
    public int getUiType() {
        return this.uiType;
    }

    public final void i(UIInfo uiInfo) {
        if (!this.isRichModelInit) {
            cg0.a.b(this.TAG, "configRichTextUI return for initRichModelOnSubThread");
            k(uiInfo);
            return;
        }
        cg0.a.b(this.TAG, "configRichTextUI start");
        if (this.richTitleView == null) {
            View b16 = this.richTitleModel.b(getContext());
            if (b16 != null && this.richTextParent.indexOfChild(b16) == -1) {
                this.richTextParent.addView(b16);
                this.richTitleView = b16;
                cg0.a.b(this.TAG, "configRichTextUI richTitleView success");
            }
        } else {
            cg0.a.b(this.TAG, "configRichTextUI richTitleView ot null");
        }
        if (this.richSubTitleView == null) {
            View b17 = this.richSubTitleModel.b(getContext());
            if (b17 != null && this.richTextParent.indexOfChild(b17) == -1) {
                this.richTextParent.addView(b17);
                this.richSubTitleView = b17;
                cg0.a.b(this.TAG, "configRichTextUI richSubTitleView success");
            }
        } else {
            cg0.a.b(this.TAG, "configRichTextUI richSubTitleView ot null");
        }
        l();
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onClickReport(b reportParams, Map<String, String> ext) {
        String str;
        String str2;
        String buttonText;
        com.tencent.ecommerce.biz.consumer.report.a aVar = com.tencent.ecommerce.biz.consumer.report.a.f101632a;
        UIInfo uIInfo = this.cardUIInfo;
        String str3 = "";
        if (uIInfo == null || (str = uIInfo.getPrice()) == null) {
            str = "";
        }
        reportParams.r(str);
        UIInfo uIInfo2 = this.cardUIInfo;
        if (uIInfo2 == null || (str2 = uIInfo2.getTitle()) == null) {
            str2 = "";
        }
        reportParams.q(str2);
        UIInfo uIInfo3 = this.cardUIInfo;
        if (uIInfo3 != null && (buttonText = uIInfo3.getButtonText()) != null) {
            str3 = buttonText;
        }
        reportParams.f(str3);
        Unit unit = Unit.INSTANCE;
        aVar.b(reportParams, ext);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onWrapperViewAppear(b reportParams, Map<String, String> ext, ECContentInfo contentInfo) {
        String str;
        String str2;
        String buttonText;
        this.exposeTimeMillis = System.currentTimeMillis();
        com.tencent.ecommerce.biz.consumer.report.a aVar = com.tencent.ecommerce.biz.consumer.report.a.f101632a;
        UIInfo uIInfo = this.cardUIInfo;
        String str3 = "";
        if (uIInfo == null || (str = uIInfo.getPrice()) == null) {
            str = "";
        }
        reportParams.r(str);
        UIInfo uIInfo2 = this.cardUIInfo;
        if (uIInfo2 == null || (str2 = uIInfo2.getTitle()) == null) {
            str2 = "";
        }
        reportParams.q(str2);
        UIInfo uIInfo3 = this.cardUIInfo;
        if (uIInfo3 != null && (buttonText = uIInfo3.getButtonText()) != null) {
            str3 = buttonText;
        }
        reportParams.f(str3);
        Unit unit = Unit.INSTANCE;
        aVar.d(reportParams, ext);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onWrapperViewDisappear(int uiType, b reportParams, Map<String, String> ext) {
        String str;
        String str2;
        String buttonText;
        long currentTimeMillis = System.currentTimeMillis() - this.exposeTimeMillis;
        com.tencent.ecommerce.biz.consumer.report.a aVar = com.tencent.ecommerce.biz.consumer.report.a.f101632a;
        UIInfo uIInfo = this.cardUIInfo;
        String str3 = "";
        if (uIInfo == null || (str = uIInfo.getPrice()) == null) {
            str = "";
        }
        reportParams.r(str);
        UIInfo uIInfo2 = this.cardUIInfo;
        if (uIInfo2 == null || (str2 = uIInfo2.getTitle()) == null) {
            str2 = "";
        }
        reportParams.q(str2);
        UIInfo uIInfo3 = this.cardUIInfo;
        if (uIInfo3 != null && (buttonText = uIInfo3.getButtonText()) != null) {
            str3 = buttonText;
        }
        reportParams.f(str3);
        reportParams.l(currentTimeMillis);
        Unit unit = Unit.INSTANCE;
        aVar.c(reportParams, ext);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void setGoodsCardClickListener(IECGoodsCardView.IGoodsCardClickListener listener) {
        this.onClickEventListener = listener;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void updateUIByType(int uiType) {
        this.uiType = uiType;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public View getView() {
        return this;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void resetToSmallCardIfNeed(int uiType) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void setCloseClickEventListener(View.OnClickListener animStartListener, View.OnClickListener animEndListener) {
    }
}
