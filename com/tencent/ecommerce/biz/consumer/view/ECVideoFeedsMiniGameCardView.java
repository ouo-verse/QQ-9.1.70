package com.tencent.ecommerce.biz.consumer.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import cg0.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.ECGoodsCommonUtils;
import com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.ecommerce.repo.consumer.resp.GameDownLoadInfo;
import com.tencent.ecommerce.repo.consumer.resp.UIInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0001WB\u000f\u0012\u0006\u0010S\u001a\u00020R\u00a2\u0006\u0004\bT\u0010UJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0014J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J \u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J,\u0010!\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001d2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J,\u0010\"\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001d2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001fH\u0016J$\u0010#\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001d2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001fH\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u001c\u0010(\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010'\u001a\u0004\u0018\u00010%H\u0016R\u0014\u0010+\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00101\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010*R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u00103R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u00103R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010;R\u0018\u0010L\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010KR\u0016\u0010M\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010CR\u0016\u0010O\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010CR\u0016\u0010Q\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010C\u00a8\u0006X"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/ECVideoFeedsMiniGameCardView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView;", "", "enable", "", "j", "", "color", "i", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", h.F, "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "uiType", "updateUIByType", "Landroid/view/View;", "getView", "getBigView", "getUIType", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "configCardUI", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "listener", "setGoodsCardClickListener", "Lcom/tencent/ecommerce/biz/consumer/report/b;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "ext", "onWrapperViewAppear", "onWrapperViewDisappear", "onClickReport", "resetToSmallCardIfNeed", "Landroid/view/View$OnClickListener;", "animStartListener", "animEndListener", "setCloseClickEventListener", "d", "Landroid/view/View;", "cardLayout", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "gameImageView", "f", "cardTitleContainerView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "titleView", "subtitleView", "Landroid/widget/Button;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/Button;", "button", BdhLogUtil.LogTag.Tag_Conn, "I", "D", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "cardUIInfo", "E", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "onClickEventListener", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "accentButtonColor", "", "G", "J", "exposeTime", "H", "currPlayPlan", "Ljava/lang/Boolean;", "buttonEnable", "appId", "K", "taskKey", "L", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Req, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECVideoFeedsMiniGameCardView extends FrameLayout implements IECGoodsCardView {
    private static final Lazy M;
    private static final Lazy N;
    private static final Lazy P;
    private static final Lazy Q;

    /* renamed from: R, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private int uiType;

    /* renamed from: D, reason: from kotlin metadata */
    private UIInfo cardUIInfo;

    /* renamed from: E, reason: from kotlin metadata */
    private IECGoodsCardView.IGoodsCardClickListener onClickEventListener;

    /* renamed from: F, reason: from kotlin metadata */
    private String accentButtonColor;

    /* renamed from: G, reason: from kotlin metadata */
    private long exposeTime;

    /* renamed from: H, reason: from kotlin metadata */
    private int currPlayPlan;

    /* renamed from: I, reason: from kotlin metadata */
    private Boolean buttonEnable;

    /* renamed from: J, reason: from kotlin metadata */
    private String appId;

    /* renamed from: K, reason: from kotlin metadata */
    private String taskKey;

    /* renamed from: L, reason: from kotlin metadata */
    private String taskId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View cardLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ImageView gameImageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final View cardTitleContainerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final TextView titleView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final TextView subtitleView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Button button;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/ECVideoFeedsMiniGameCardView$a;", "", "", "MAX_WIDTH$delegate", "Lkotlin/Lazy;", "g", "()I", "MAX_WIDTH", "MIN_TITLE_RIGHT_PADDING$delegate", h.F, "MIN_TITLE_RIGHT_PADDING", "COVER_IMAGE_SIZE$delegate", "f", "COVER_IMAGE_SIZE", "", "BUTTON_CORNER_RADIUS$delegate", "e", "()F", "BUTTON_CORNER_RADIUS", "PLAY_PLAN_NONE", "I", "PLAY_PLAN_ONE", "PLAY_PLAN_TWO", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsMiniGameCardView$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float e() {
            return ((Number) ECVideoFeedsMiniGameCardView.Q.getValue()).floatValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int f() {
            return ((Number) ECVideoFeedsMiniGameCardView.P.getValue()).intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int g() {
            return ((Number) ECVideoFeedsMiniGameCardView.M.getValue()).intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int h() {
            return ((Number) ECVideoFeedsMiniGameCardView.N.getValue()).intValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class c implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101802e;

        c(UIInfo uIInfo) {
            this.f101802e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECVideoFeedsMiniGameCardView.this.button.setTag(R.id.ntd, 2);
            IECGoodsCardView.IGoodsCardClickListener iGoodsCardClickListener = ECVideoFeedsMiniGameCardView.this.onClickEventListener;
            if (iGoodsCardClickListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(iGoodsCardClickListener, ECVideoFeedsMiniGameCardView.this.button, ECGoodsCommonUtils.f101579a.p(this.f101802e.getRedirectLinkInfo().getRedirectLinkMap()), null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsMiniGameCardView$Companion$MAX_WIDTH$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                int f16 = (int) (ECDeviceUtils.f104857e.f() * 0.72f);
                if (f16 > 0) {
                    return f16;
                }
                a.a("ECMiniGameCardView", "MAX_WIDTH", "getScreenWidth is zero");
                return Integer.MAX_VALUE;
            }
        });
        M = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsMiniGameCardView$Companion$MIN_TITLE_RIGHT_PADDING$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(10.0f);
            }
        });
        N = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsMiniGameCardView$Companion$COVER_IMAGE_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(34.0f);
            }
        });
        P = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsMiniGameCardView$Companion$BUTTON_CORNER_RADIUS$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(4.0f);
            }
        });
        Q = lazy4;
    }

    public ECVideoFeedsMiniGameCardView(Context context) {
        super(context);
        this.uiType = -1;
        this.accentButtonColor = "";
        this.appId = "";
        this.taskKey = "";
        this.taskId = "";
        LayoutInflater.from(context).inflate(R.layout.crh, (ViewGroup) this, true);
        this.cardLayout = findViewById(R.id.o2g);
        this.gameImageView = (ImageView) findViewById(R.id.o1j);
        this.cardTitleContainerView = findViewById(R.id.nsz);
        this.titleView = (TextView) findViewById(R.id.oer);
        this.subtitleView = (TextView) findViewById(R.id.oeg);
        Button button = (Button) findViewById(R.id.nrs);
        this.button = button;
        button.setText(context.getResources().getString(R.string.wnz));
    }

    private final void h(UIInfo uiInfo) {
        this.appId = String.valueOf(uiInfo.getGameInfo().getBasic().getAppId());
        GameDownLoadInfo download = uiInfo.getGameInfo().getDownload();
        this.taskKey = download.getTaskKey();
        this.taskId = download.getTaskId();
    }

    private final void i(String color) {
        if (TextUtils.isEmpty(color)) {
            return;
        }
        Button button = this.button;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(INSTANCE.e());
        gradientDrawable.setColor(Color.parseColor(color));
        Unit unit = Unit.INSTANCE;
        button.setBackground(gradientDrawable);
    }

    private final void j(boolean enable) {
        String buttonColor;
        if (!Intrinsics.areEqual(this.buttonEnable, Boolean.valueOf(enable))) {
            this.buttonEnable = Boolean.valueOf(enable);
            if (enable) {
                buttonColor = this.accentButtonColor;
            } else {
                UIInfo uIInfo = this.cardUIInfo;
                buttonColor = uIInfo != null ? uIInfo.getButtonColor() : null;
            }
            i(buttonColor);
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void configCardUI(ECContentInfo contentInfo, UIInfo uiInfo, int uiType) {
        if (this.cardUIInfo != null) {
            this.accentButtonColor = uiInfo.getButtonColor();
            return;
        }
        this.cardUIInfo = uiInfo;
        h(uiInfo);
        if (!TextUtils.isEmpty(uiInfo.getPicUrl())) {
            Companion companion = INSTANCE;
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(getContext(), uiInfo.getPicUrl(), this.gameImageView, new IECImageLoader.ImageLoaderOption(companion.f(), companion.f(), 0, null, null, null, false, false, null, 508, null));
        }
        this.titleView.setText(uiInfo.getTitle());
        this.subtitleView.setText(uiInfo.getSubtitle());
        this.cardLayout.setOnClickListener(b.f101800d);
        this.button.setOnClickListener(new c(uiInfo));
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

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onClickReport(com.tencent.ecommerce.biz.consumer.report.b reportParams, Map<String, String> ext) {
        com.tencent.ecommerce.biz.consumer.report.a aVar = com.tencent.ecommerce.biz.consumer.report.a.f101632a;
        reportParams.w(this.taskKey);
        reportParams.v(this.taskId);
        reportParams.b(this.appId);
        reportParams.i(reportParams.getCom.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem.KEY_VIDEO_TIME java.lang.String());
        Unit unit = Unit.INSTANCE;
        aVar.b(reportParams, ext);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        Companion companion = INSTANCE;
        if (size > companion.g()) {
            size = companion.g();
            a.b("ECMiniGameCardView", "adjust width " + size + " to " + companion.g());
            post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsMiniGameCardView$onMeasure$1
                @Override // java.lang.Runnable
                public final void run() {
                    View view;
                    View view2;
                    View view3;
                    int h16;
                    View view4;
                    view = ECVideoFeedsMiniGameCardView.this.cardTitleContainerView;
                    view2 = ECVideoFeedsMiniGameCardView.this.cardTitleContainerView;
                    int paddingLeft = view2.getPaddingLeft();
                    view3 = ECVideoFeedsMiniGameCardView.this.cardTitleContainerView;
                    int paddingTop = view3.getPaddingTop();
                    h16 = ECVideoFeedsMiniGameCardView.INSTANCE.h();
                    view4 = ECVideoFeedsMiniGameCardView.this.cardTitleContainerView;
                    view.setPadding(paddingLeft, paddingTop, h16, view4.getPaddingBottom());
                }
            });
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), heightMeasureSpec);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onWrapperViewAppear(com.tencent.ecommerce.biz.consumer.report.b reportParams, Map<String, String> ext, ECContentInfo contentInfo) {
        this.exposeTime = System.currentTimeMillis();
        com.tencent.ecommerce.biz.consumer.report.a aVar = com.tencent.ecommerce.biz.consumer.report.a.f101632a;
        reportParams.w(this.taskKey);
        reportParams.v(this.taskId);
        reportParams.b(this.appId);
        reportParams.m(reportParams.getCom.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem.KEY_VIDEO_TIME java.lang.String());
        reportParams.s(com.tencent.ecommerce.biz.util.b.a(contentInfo.getIsContinuation()));
        Unit unit = Unit.INSTANCE;
        aVar.d(reportParams, ext);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onWrapperViewDisappear(int uiType, com.tencent.ecommerce.biz.consumer.report.b reportParams, Map<String, String> ext) {
        long currentTimeMillis = System.currentTimeMillis() - this.exposeTime;
        com.tencent.ecommerce.biz.consumer.report.a aVar = com.tencent.ecommerce.biz.consumer.report.a.f101632a;
        reportParams.w(this.taskKey);
        reportParams.v(this.taskId);
        reportParams.b(this.appId);
        reportParams.k(reportParams.getCom.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem.KEY_VIDEO_TIME java.lang.String());
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
        if (this.uiType != -1) {
            this.currPlayPlan = 2;
        } else {
            this.uiType = uiType;
            this.currPlayPlan = 1;
        }
        j(this.currPlayPlan == 2);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public View getView() {
        return this;
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        public static final b f101800d = new b();

        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void resetToSmallCardIfNeed(int uiType) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void setCloseClickEventListener(View.OnClickListener animStartListener, View.OnClickListener animEndListener) {
    }
}
