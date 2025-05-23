package com.tencent.ecommerce.biz.consumer.view.xinghuan;

import ah0.a;
import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.ECGoodsCommonUtils;
import com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView;
import com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.ecommerce.repo.consumer.resp.UIInfo;
import com.tencent.luggage.wxa.rf.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tl.h;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \\2\u00020\u0001:\u0001]B\u0017\u0012\u0006\u0010Y\u001a\u00020X\u0012\u0006\u0010W\u001a\u00020T\u00a2\u0006\u0004\bZ\u0010[J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J4\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J@\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0016JX\u0010#\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J8\u0010$\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J8\u0010%\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0014\u0010.\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010)R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00104\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010:\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00101R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010D\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010=R\u0014\u0010F\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010=R\u0014\u0010H\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u00101R\u0018\u0010J\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010)R\u0018\u0010L\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010=R\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010V\u00a8\u0006^"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanTopPicCardView;", "Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanBaseBigCardView;", "", "uiType", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", "Lcom/tencent/ecommerce/biz/consumer/xinghuan/IECXingHuanGameButton;", "bigBtn", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "clickListener", "Landroid/view/View$OnClickListener;", "closeListener", "f", "i", "smallBgWidth", "smallBgHeight", "smallIconWidth", "smallIconHeight", "", "smallBgLoc", "smallTitleLoc", "Landroid/animation/Animator$AnimatorListener;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mediumBgWidth", "mediumBgHeight", "mediumCoverWidth", "mediumCoverHeight", "mediumBtnWidth", "mediumBtnHeight", "mediumBgLoc", "mediumBtnLoc", "mediumTitleLoc", "l", "k", "j", h.F, "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "parentView", "D", "bigLayout", "E", "bigBgView", "Landroid/view/ViewGroup;", UserInfo.SEX_FEMALE, "Landroid/view/ViewGroup;", "bigContainer", "G", "bigPicContainer", "Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanPagView;", "H", "Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanPagView;", "bigPagContainer", "I", "bigTitleContainer", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "bigTitleView", "Landroid/widget/ImageView;", "K", "Landroid/widget/ImageView;", "bigCloseImageView", "L", "bigSubtitleView", "M", "bigTagView", "N", "bigBtnLayout", "P", "bigBtnBg", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "bigBtnText", "Lah0/a;", BdhLogUtil.LogTag.Tag_Req, "Lah0/a;", "ecAnimationSet", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "bigCardUIInfo", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "T", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;)V", "b0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECXingHuanTopPicCardView extends ECXingHuanBaseBigCardView {
    private static final Lazy U;
    private static final Lazy V;
    private static final Lazy W;

    /* renamed from: a0, reason: collision with root package name */
    private static final Lazy f101946a0;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final View parentView;

    /* renamed from: D, reason: from kotlin metadata */
    private final View bigLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private final View bigBgView;

    /* renamed from: F, reason: from kotlin metadata */
    private final ViewGroup bigContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private final ViewGroup bigPicContainer;

    /* renamed from: H, reason: from kotlin metadata */
    private final ECXingHuanPagView bigPagContainer;

    /* renamed from: I, reason: from kotlin metadata */
    private final ViewGroup bigTitleContainer;

    /* renamed from: J, reason: from kotlin metadata */
    private final TextView bigTitleView;

    /* renamed from: K, reason: from kotlin metadata */
    private final ImageView bigCloseImageView;

    /* renamed from: L, reason: from kotlin metadata */
    private final TextView bigSubtitleView;

    /* renamed from: M, reason: from kotlin metadata */
    private final TextView bigTagView;

    /* renamed from: N, reason: from kotlin metadata */
    private final ViewGroup bigBtnLayout;

    /* renamed from: P, reason: from kotlin metadata */
    private View bigBtnBg;

    /* renamed from: Q, reason: from kotlin metadata */
    private TextView bigBtnText;

    /* renamed from: R, reason: from kotlin metadata */
    private a ecAnimationSet;

    /* renamed from: S, reason: from kotlin metadata */
    private UIInfo bigCardUIInfo;

    /* renamed from: T, reason: from kotlin metadata */
    public final ECContentInfo contentInfo;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0010\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanTopPicCardView$a;", "", "", "BIG_SMALL_TITLE_MARGIN_LEFT_FLOAT$delegate", "Lkotlin/Lazy;", "c", "()F", "BIG_SMALL_TITLE_MARGIN_LEFT_FLOAT", "BIG_SMALL_TITLE_MARGIN_TOP_FLOAT$delegate", "d", "BIG_SMALL_TITLE_MARGIN_TOP_FLOAT", "BIG_MEDIUM_TITLE_MARGIN_LEFT_FLOAT$delegate", "a", "BIG_MEDIUM_TITLE_MARGIN_LEFT_FLOAT", "BIG_MEDIUM_TITLE_MARGIN_TOP_FLOAT$delegate", "b", "BIG_MEDIUM_TITLE_MARGIN_TOP_FLOAT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanTopPicCardView$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final float a() {
            return ((Number) ECXingHuanTopPicCardView.W.getValue()).floatValue();
        }

        public final float b() {
            return ((Number) ECXingHuanTopPicCardView.f101946a0.getValue()).floatValue();
        }

        public final float c() {
            return ((Number) ECXingHuanTopPicCardView.U.getValue()).floatValue();
        }

        public final float d() {
            return ((Number) ECXingHuanTopPicCardView.V.getValue()).floatValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f101948d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IECGoodsCardView.IGoodsCardClickListener f101949e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ UIInfo f101950f;

        b(int i3, IECGoodsCardView.IGoodsCardClickListener iGoodsCardClickListener, UIInfo uIInfo) {
            this.f101948d = i3;
            this.f101949e = iGoodsCardClickListener;
            this.f101950f = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            view.setTag(R.id.ntd, 1);
            view.setTag(R.id.nte, Integer.valueOf(this.f101948d));
            IECGoodsCardView.IGoodsCardClickListener iGoodsCardClickListener = this.f101949e;
            if (iGoodsCardClickListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(iGoodsCardClickListener, view, ECGoodsCommonUtils.f101579a.o(this.f101950f.getJumpInfoArray()), null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class c implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f101952e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f101953f;

        c(int i3, View.OnClickListener onClickListener) {
            this.f101952e = i3;
            this.f101953f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECXingHuanTopPicCardView.this.setTag(R.id.nte, Integer.valueOf(this.f101952e));
            ECXingHuanTopPicCardView.this.setTag(R.id.o5t, Integer.valueOf(this.f101952e));
            View.OnClickListener onClickListener = this.f101953f;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanTopPicCardView$Companion$BIG_SMALL_TITLE_MARGIN_LEFT_FLOAT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(8.0f);
            }
        });
        U = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanTopPicCardView$Companion$BIG_SMALL_TITLE_MARGIN_TOP_FLOAT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(14.0f);
            }
        });
        V = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanTopPicCardView$Companion$BIG_MEDIUM_TITLE_MARGIN_LEFT_FLOAT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(4.0f);
            }
        });
        W = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanTopPicCardView$Companion$BIG_MEDIUM_TITLE_MARGIN_TOP_FLOAT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(4.0f);
            }
        });
        f101946a0 = lazy4;
    }

    public ECXingHuanTopPicCardView(Context context, ECContentInfo eCContentInfo) {
        super(context);
        this.contentInfo = eCContentInfo;
        this.parentView = LayoutInflater.from(context).inflate(R.layout.cvc, (ViewGroup) this, true);
        this.bigLayout = findViewById(R.id.nqn);
        this.bigBgView = findViewById(R.id.nqi);
        this.bigContainer = (ViewGroup) findViewById(R.id.nql);
        this.bigPicContainer = (ViewGroup) findViewById(R.id.nqp);
        this.bigPagContainer = (ECXingHuanPagView) findViewById(R.id.nqo);
        this.bigTitleContainer = (ViewGroup) findViewById(R.id.nqs);
        this.bigTitleView = (TextView) findViewById(R.id.nqt);
        this.bigCloseImageView = (ImageView) findViewById(R.id.nqk);
        this.bigSubtitleView = (TextView) findViewById(R.id.nqq);
        this.bigTagView = (TextView) findViewById(R.id.nqr);
        this.bigBtnLayout = (ViewGroup) findViewById(R.id.nqj);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView
    public void f(int uiType, UIInfo uiInfo, IECXingHuanGameButton bigBtn, IECGoodsCardView.IGoodsCardClickListener clickListener, View.OnClickListener closeListener) {
        cg0.a.b("ECXingHuanTopPicCardView", "configBigCardUI uiType:" + uiType);
        this.bigCardUIInfo = uiInfo;
        this.bigPagContainer.i(uiInfo.getPagUrl(), uiInfo.getPicUrl());
        this.bigTitleView.setText(uiInfo.getTitle());
        this.bigSubtitleView.setText(uiInfo.getSubtitle());
        this.bigTagView.setVisibility(TextUtils.isEmpty(uiInfo.getActivityTagInfo().getText()) ^ true ? 0 : 8);
        this.bigTagView.setText(uiInfo.getActivityTagInfo().getText());
        this.bigBtnLayout.addView(bigBtn.getView(), new FrameLayout.LayoutParams(-1, -1));
        this.bigBtnBg = bigBtn.getBgView();
        this.bigBtnText = bigBtn.getTipsView();
        this.bigLayout.setOnClickListener(new b(uiType, clickListener, uiInfo));
        this.bigCloseImageView.setOnClickListener(new c(uiType, closeListener));
        s(uiType);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView
    public void h() {
        this.parentView.setTranslationX(0.0f);
        this.parentView.setTranslationY(0.0f);
        this.bigPicContainer.setScaleX(1.0f);
        this.bigPicContainer.setScaleY(1.0f);
        this.bigContainer.setTranslationX(0.0f);
        this.bigContainer.setTranslationY(0.0f);
        this.bigBgView.setScaleX(1.0f);
        this.bigBgView.setScaleY(1.0f);
        this.bigCloseImageView.setAlpha(1.0f);
        this.bigTitleView.setAlpha(1.0f);
        this.bigPicContainer.setAlpha(1.0f);
        this.bigBtnLayout.setAlpha(1.0f);
        this.bigPagContainer.m();
        this.bigPicContainer.invalidate();
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView
    public void i() {
        this.ecAnimationSet = a.C0035a.j(new a.C0035a(700L), this.bigLayout, -r1.getWidth(), 0.0f, 0.0f, 0.0f, 0L, false, ECXingHuanGameCardView.INSTANCE.b(), new d(), 96, null).c().b();
        g(this.contentInfo.getContentId());
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView
    public void l(int mediumBgWidth, int mediumBgHeight, int mediumCoverWidth, int mediumCoverHeight, int mediumBtnWidth, int mediumBtnHeight, int[] mediumBgLoc, int[] mediumBtnLoc, int[] mediumTitleLoc, Animator.AnimatorListener listener) {
        a.C0035a a16;
        a.C0035a a17;
        a.C0035a a18;
        int[] iArr = new int[2];
        this.bigBgView.getLocationInWindow(iArr);
        this.bigBtnLayout.getLocationInWindow(new int[2]);
        this.bigTitleContainer.getLocationInWindow(new int[2]);
        float f16 = mediumBgLoc[0] - iArr[0];
        float f17 = mediumBgLoc[1] - iArr[1];
        a.C0035a c0035a = new a.C0035a(700L);
        View view = this.parentView;
        ECXingHuanBaseBigCardView.Companion companion = ECXingHuanBaseBigCardView.INSTANCE;
        a.C0035a f18 = a.C0035a.f(a.C0035a.f(a.C0035a.j(c0035a, view, f16, f17, 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null), this.bigBgView, mediumBgWidth / r8.getWidth(), 1.0f, mediumBgHeight / this.bigBgView.getHeight(), 1.0f, 0.0f, 0.0f, 0L, false, companion.a(), new e(listener), 0L, 2464, null), this.bigPicContainer, mediumCoverWidth / r8.getWidth(), 1.0f, mediumCoverHeight / this.bigPicContainer.getHeight(), 1.0f, 0.0f, 0.0f, 0L, false, companion.a(), null, 0L, 3488, null);
        ViewGroup viewGroup = this.bigTitleContainer;
        float f19 = (mediumTitleLoc[0] - r5[0]) - f16;
        Companion companion2 = INSTANCE;
        a16 = r23.a(this.bigSubtitleView, 0.0f, 1.0f, (r26 & 8) != 0 ? a.C0035a.j(a.C0035a.f(a.C0035a.j(f18, viewGroup, f19 + companion2.a(), ((mediumTitleLoc[1] - r5[1]) - f17) + companion2.b(), 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null), this.bigTitleView, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f, 0.0f, 0L, false, companion.a(), null, 0L, 3488, null), this.bigSubtitleView, 0.0f, companion.e(), 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a17 = r23.a(this.bigTagView, 0.0f, 1.0f, (r26 & 8) != 0 ? a.C0035a.j(a16, this.bigTagView, 0.0f, companion.e(), 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a18 = a17.a(this.bigCloseImageView, 0.0f, 1.0f, (r26 & 8) != 0 ? a17.duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a.C0035a j3 = a.C0035a.j(a18, this.bigContainer, -companion.d(), -companion.d(), 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null);
        if (this.bigBtnLayout.getVisibility() == 0) {
            TextView textView = this.bigBtnText;
            if (textView != null) {
                a.C0035a.f(j3, textView, 0.85f, 1.0f, 0.85f, 1.0f, 0.0f, 0.0f, 0L, false, companion.a(), null, 0L, 3488, null);
            }
            View view2 = this.bigBtnBg;
            if (view2 != null) {
                a.C0035a.f(j3, view2, mediumBtnWidth / this.bigBtnLayout.getWidth(), 1.0f, mediumBtnHeight / this.bigBtnLayout.getHeight(), 1.0f, this.bigBtnLayout.getWidth() / 2.0f, this.bigBtnLayout.getHeight() / 2.0f, 0L, false, companion.a(), null, 0L, 3456, null);
            }
            a.C0035a.j(j3, this.bigBtnLayout, ((mediumBtnLoc[0] - r4[0]) - ((r9.getWidth() - mediumBtnWidth) / 2)) + companion.d(), (-this.parentView.getHeight()) + companion.c(), 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null);
        }
        Unit unit = Unit.INSTANCE;
        this.ecAnimationSet = j3.c().b();
        g(this.contentInfo.getContentId());
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView
    public void m(int smallBgWidth, int smallBgHeight, int smallIconWidth, int smallIconHeight, int[] smallBgLoc, int[] smallTitleLoc, Animator.AnimatorListener listener) {
        a.C0035a a16;
        a.C0035a a17;
        a.C0035a a18;
        a.C0035a a19;
        int[] iArr = new int[2];
        this.bigBgView.getLocationInWindow(iArr);
        this.bigTitleContainer.getLocationInWindow(new int[2]);
        float f16 = smallBgLoc[0] - iArr[0];
        float f17 = smallBgLoc[1] - iArr[1];
        a.C0035a c0035a = new a.C0035a(700L);
        View view = this.parentView;
        ECXingHuanBaseBigCardView.Companion companion = ECXingHuanBaseBigCardView.INSTANCE;
        a16 = r20.a(this.bigCloseImageView, 0.0f, 1.0f, (r26 & 8) != 0 ? a.C0035a.j(a.C0035a.f(a.C0035a.j(c0035a, view, f16, f17, 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null), this.bigPicContainer, smallIconWidth / r5.getWidth(), 1.0f, smallIconHeight / this.bigPicContainer.getHeight(), 1.0f, 0.0f, 0.0f, 0L, false, companion.a(), null, 0L, 3488, null), this.bigContainer, -companion.b(), -companion.b(), 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        ViewGroup viewGroup = this.bigTitleContainer;
        float f18 = (smallTitleLoc[0] - r1[0]) - f16;
        Companion companion2 = INSTANCE;
        a17 = r20.a(this.bigSubtitleView, 0.0f, 1.0f, (r26 & 8) != 0 ? a.C0035a.j(a.C0035a.f(a.C0035a.j(a16, viewGroup, f18 + companion2.c(), ((smallTitleLoc[1] - r1[1]) - f17) + companion2.d(), 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null), this.bigTitleView, 0.8f, 1.0f, 0.8f, 1.0f, 0.0f, 0.0f, 0L, false, companion.a(), null, 0L, 3488, null), this.bigSubtitleView, 0.0f, companion.e(), 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a18 = r20.a(this.bigTagView, 0.0f, 1.0f, (r26 & 8) != 0 ? a.C0035a.j(a17, this.bigTagView, 0.0f, companion.e(), 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a19 = a18.a(this.bigBtnLayout, 0.0f, 1.0f, (r26 & 8) != 0 ? a18.duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        this.ecAnimationSet = a.C0035a.f(a19, this.bigBgView, smallBgWidth / r1.getWidth(), 1.0f, smallBgHeight / this.bigBgView.getHeight(), 1.0f, 0.0f, 0.0f, 0L, false, companion.a(), new f(listener), 0L, 2464, null).c().b();
        g(this.contentInfo.getContentId());
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView
    public void j(int mediumBgWidth, int mediumBgHeight, int mediumCoverWidth, int mediumCoverHeight, int[] mediumBgLoc, Animator.AnimatorListener listener) {
        a.C0035a a16;
        a.C0035a a17;
        a.C0035a a18;
        a.C0035a a19;
        a.C0035a a26;
        a.C0035a a27;
        int[] iArr = new int[2];
        this.bigBgView.getLocationInWindow(iArr);
        a.C0035a c0035a = new a.C0035a(700L);
        View view = this.parentView;
        float f16 = mediumBgLoc[0] - iArr[0];
        float f17 = mediumBgLoc[1] - iArr[1];
        ECXingHuanBaseBigCardView.Companion companion = ECXingHuanBaseBigCardView.INSTANCE;
        float f18 = mediumCoverWidth;
        a16 = r1.a(this.bigPicContainer, 1.0f, 0.0f, (r26 & 8) != 0 ? a.C0035a.f(a.C0035a.f(a.C0035a.j(c0035a, view, 0.0f, 0.0f, f16, f17, 0L, false, companion.a(), null, g.CTRL_INDEX, null), this.bigBgView, 1.0f, mediumBgWidth / r4.getWidth(), 1.0f, mediumBgHeight / this.bigBgView.getHeight(), 0.0f, 0.0f, 0L, false, companion.a(), listener, 0L, 2464, null), this.bigPicContainer, 1.0f, f18 / r1.getWidth(), 1.0f, f18 / this.bigPicContainer.getHeight(), 0.0f, 0.0f, 0L, false, companion.a(), null, 0L, 3488, null).duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a17 = r4.a(this.bigCloseImageView, 1.0f, 0.0f, (r26 & 8) != 0 ? a.C0035a.j(a16, this.bigContainer, 0.0f, 0.0f, -companion.d(), -companion.d(), 0L, false, companion.a(), null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a18 = a17.a(this.bigTitleView, 1.0f, 0.0f, (r26 & 8) != 0 ? a17.duration : 500L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a19 = a18.a(this.bigSubtitleView, 1.0f, 0.0f, (r26 & 8) != 0 ? a18.duration : 500L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a26 = a19.a(this.bigTagView, 1.0f, 0.0f, (r26 & 8) != 0 ? a19.duration : 500L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a27 = a26.a(this.bigBtnLayout, 1.0f, 0.0f, (r26 & 8) != 0 ? a26.duration : 500L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        this.ecAnimationSet = a27.c().b();
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView
    public void k(int smallBgWidth, int smallBgHeight, int smallIconWidth, int smallIconHeight, int[] smallBgLoc, Animator.AnimatorListener listener) {
        a.C0035a a16;
        a.C0035a a17;
        a.C0035a a18;
        a.C0035a a19;
        a.C0035a a26;
        a.C0035a a27;
        int[] iArr = new int[2];
        this.bigBgView.getLocationInWindow(iArr);
        a.C0035a c0035a = new a.C0035a(700L);
        View view = this.parentView;
        float f16 = smallBgLoc[0] - iArr[0];
        float f17 = smallBgLoc[1] - iArr[1];
        ECXingHuanBaseBigCardView.Companion companion = ECXingHuanBaseBigCardView.INSTANCE;
        a16 = r27.a(this.bigCloseImageView, 1.0f, 0.0f, (r26 & 8) != 0 ? a.C0035a.j(a.C0035a.f(a.C0035a.j(c0035a, view, 0.0f, 0.0f, f16, f17, 0L, false, companion.a(), null, g.CTRL_INDEX, null), this.bigPicContainer, 1.0f, smallIconWidth / r1.getWidth(), 1.0f, smallIconHeight / this.bigPicContainer.getHeight(), 0.0f, 0.0f, 0L, false, companion.a(), null, 0L, 3488, null), this.bigContainer, 0.0f, 0.0f, -companion.b(), -companion.b(), 0L, false, companion.a(), null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a17 = a16.a(this.bigTitleView, 1.0f, 0.0f, (r26 & 8) != 0 ? a16.duration : 500L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a18 = a17.a(this.bigSubtitleView, 1.0f, 0.0f, (r26 & 8) != 0 ? a17.duration : 500L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a19 = a18.a(this.bigTagView, 1.0f, 0.0f, (r26 & 8) != 0 ? a18.duration : 500L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a26 = a19.a(this.bigPicContainer, 1.0f, 0.0f, (r26 & 8) != 0 ? a19.duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a27 = a26.a(this.bigBtnLayout, 1.0f, 0.0f, (r26 & 8) != 0 ? a26.duration : 500L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        this.ecAnimationSet = a.C0035a.f(a27, this.bigBgView, 1.0f, smallBgWidth / r4.getWidth(), 1.0f, smallBgHeight / this.bigBgView.getHeight(), 0.0f, 0.0f, 0L, false, companion.a(), listener, 0L, 2464, null).c().b();
    }

    private final void s(int uiType) {
        if (uiType == 423) {
            this.bigBtnLayout.setVisibility(8);
        } else if (uiType == 425) {
            this.bigTitleContainer.setVisibility(8);
            this.bigSubtitleView.setVisibility(8);
            this.bigBtnLayout.setVisibility(8);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanTopPicCardView$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            ECXingHuanTopPicCardView.this.bigPagContainer.k();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanTopPicCardView$e", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements Animator.AnimatorListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Animator.AnimatorListener f101956e;

        e(Animator.AnimatorListener animatorListener) {
            this.f101956e = animatorListener;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f101956e.onAnimationEnd(animation);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            ECXingHuanTopPicCardView.this.bigPagContainer.k();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanTopPicCardView$f", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements Animator.AnimatorListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Animator.AnimatorListener f101958e;

        f(Animator.AnimatorListener animatorListener) {
            this.f101958e = animatorListener;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f101958e.onAnimationEnd(animation);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            ECXingHuanTopPicCardView.this.bigPagContainer.k();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }
    }
}
