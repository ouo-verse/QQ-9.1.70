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
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
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
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tl.h;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 T2\u00020\u0001:\u0001UB\u0017\u0012\u0006\u0010Q\u001a\u00020P\u0012\u0006\u0010O\u001a\u00020L\u00a2\u0006\u0004\bR\u0010SJ4\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J@\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0016JX\u0010\"\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J8\u0010#\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J8\u0010$\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010%\u001a\u00020\fH\u0016R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010-\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00107\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00100R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010=\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u00104R\u0014\u0010?\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010:R\u0014\u0010A\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010:R\u0014\u0010C\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u00100R\u0018\u0010E\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010(R\u0018\u0010G\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010:R\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010N\u00a8\u0006V"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanLeftPicCardView;", "Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanBaseBigCardView;", "", "uiType", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", "Lcom/tencent/ecommerce/biz/consumer/xinghuan/IECXingHuanGameButton;", "bigBtn", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "clickListener", "Landroid/view/View$OnClickListener;", "closeListener", "", "f", "i", "smallBgWidth", "smallBgHeight", "smallIconWidth", "smallIconHeight", "", "smallBgLoc", "smallTitleLoc", "Landroid/animation/Animator$AnimatorListener;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mediumBgWidth", "mediumBgHeight", "mediumCoverWidth", "mediumCoverHeight", "mediumBtnWidth", "mediumBtnHeight", "mediumBgLoc", "mediumBtnLoc", "mediumTitleLoc", "l", "k", "j", h.F, "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "parentView", "D", "bigLayout", "E", "bigBgView", "Landroid/view/ViewGroup;", UserInfo.SEX_FEMALE, "Landroid/view/ViewGroup;", "bigContainer", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "bigCoverView", "H", "bigTitleContainer", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "bigTitleView", "J", "bigCloseImageView", "K", "bigSubtitleView", "L", "bigTagView", "M", "bigBtnLayout", "N", "bigBtnBg", "P", "bigBtnText", "Lah0/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lah0/a;", "ecAnimationSet", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;)V", "V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECXingHuanLeftPicCardView extends ECXingHuanBaseBigCardView {
    private static final Lazy S;
    private static final Lazy T;
    private static final Lazy U;

    /* renamed from: V, reason: from kotlin metadata */
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
    private final ImageView bigCoverView;

    /* renamed from: H, reason: from kotlin metadata */
    private final ViewGroup bigTitleContainer;

    /* renamed from: I, reason: from kotlin metadata */
    private final TextView bigTitleView;

    /* renamed from: J, reason: from kotlin metadata */
    private final ImageView bigCloseImageView;

    /* renamed from: K, reason: from kotlin metadata */
    private final TextView bigSubtitleView;

    /* renamed from: L, reason: from kotlin metadata */
    private final TextView bigTagView;

    /* renamed from: M, reason: from kotlin metadata */
    private final ViewGroup bigBtnLayout;

    /* renamed from: N, reason: from kotlin metadata */
    private View bigBtnBg;

    /* renamed from: P, reason: from kotlin metadata */
    private TextView bigBtnText;

    /* renamed from: Q, reason: from kotlin metadata */
    private a ecAnimationSet;

    /* renamed from: R, reason: from kotlin metadata */
    public final ECContentInfo contentInfo;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000f\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanLeftPicCardView$a;", "", "", "COVER_IMAGE_SIZE$delegate", "Lkotlin/Lazy;", "c", "()I", "COVER_IMAGE_SIZE", "", "BIG_SMALL_TITLE_MARGIN_LEFT_FLOAT$delegate", "a", "()F", "BIG_SMALL_TITLE_MARGIN_LEFT_FLOAT", "BIG_SMALL_TITLE_MARGIN_TOP_FLOAT$delegate", "b", "BIG_SMALL_TITLE_MARGIN_TOP_FLOAT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanLeftPicCardView$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final float a() {
            return ((Number) ECXingHuanLeftPicCardView.T.getValue()).floatValue();
        }

        public final float b() {
            return ((Number) ECXingHuanLeftPicCardView.U.getValue()).floatValue();
        }

        public final int c() {
            return ((Number) ECXingHuanLeftPicCardView.S.getValue()).intValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f101923d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IECGoodsCardView.IGoodsCardClickListener f101924e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ UIInfo f101925f;

        b(int i3, IECGoodsCardView.IGoodsCardClickListener iGoodsCardClickListener, UIInfo uIInfo) {
            this.f101923d = i3;
            this.f101924e = iGoodsCardClickListener;
            this.f101925f = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            view.setTag(R.id.ntd, 1);
            view.setTag(R.id.nte, Integer.valueOf(this.f101923d));
            IECGoodsCardView.IGoodsCardClickListener iGoodsCardClickListener = this.f101924e;
            if (iGoodsCardClickListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(iGoodsCardClickListener, view, ECGoodsCommonUtils.f101579a.o(this.f101925f.getJumpInfoArray()), null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class c implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f101927e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f101928f;

        c(int i3, View.OnClickListener onClickListener) {
            this.f101927e = i3;
            this.f101928f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECXingHuanLeftPicCardView.this.setTag(R.id.nte, Integer.valueOf(this.f101927e));
            ECXingHuanLeftPicCardView.this.setTag(R.id.o5t, Integer.valueOf(this.f101927e));
            View.OnClickListener onClickListener = this.f101928f;
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
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanLeftPicCardView$Companion$COVER_IMAGE_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(56.0f);
            }
        });
        S = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanLeftPicCardView$Companion$BIG_SMALL_TITLE_MARGIN_LEFT_FLOAT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(10.0f);
            }
        });
        T = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanLeftPicCardView$Companion$BIG_SMALL_TITLE_MARGIN_TOP_FLOAT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(11.0f);
            }
        });
        U = lazy3;
    }

    public ECXingHuanLeftPicCardView(Context context, ECContentInfo eCContentInfo) {
        super(context);
        this.contentInfo = eCContentInfo;
        this.parentView = LayoutInflater.from(context).inflate(R.layout.cv9, (ViewGroup) this, true);
        this.bigLayout = findViewById(R.id.nqn);
        this.bigBgView = findViewById(R.id.nqi);
        this.bigContainer = (ViewGroup) findViewById(R.id.nql);
        this.bigCoverView = (ImageView) findViewById(R.id.nqm);
        this.bigTitleContainer = (ViewGroup) findViewById(R.id.nqs);
        this.bigTitleView = (TextView) findViewById(R.id.nqt);
        this.bigCloseImageView = (ImageView) findViewById(R.id.nqk);
        this.bigSubtitleView = (TextView) findViewById(R.id.nqq);
        this.bigTagView = (TextView) findViewById(R.id.nqr);
        this.bigBtnLayout = (ViewGroup) findViewById(R.id.nqj);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView
    public void h() {
        this.parentView.setTranslationX(0.0f);
        this.parentView.setTranslationY(0.0f);
        this.bigCoverView.setScaleX(1.0f);
        this.bigCoverView.setScaleY(1.0f);
        this.bigContainer.setTranslationX(0.0f);
        this.bigContainer.setTranslationY(0.0f);
        this.bigBgView.setScaleX(1.0f);
        this.bigBgView.setScaleY(1.0f);
        this.bigCloseImageView.setAlpha(1.0f);
        this.bigTitleView.setAlpha(1.0f);
        this.bigSubtitleView.setAlpha(1.0f);
        this.bigTagView.setAlpha(1.0f);
        this.bigCoverView.setAlpha(1.0f);
        this.bigBtnLayout.setAlpha(1.0f);
        this.bigCoverView.invalidate();
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView
    public void i() {
        this.ecAnimationSet = a.C0035a.j(new a.C0035a(700L), this.bigLayout, -r1.getWidth(), 0.0f, 0.0f, 0.0f, 0L, false, ECXingHuanGameCardView.INSTANCE.b(), null, g.CTRL_INDEX, null).c().b();
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
        a.C0035a c0035a = new a.C0035a(700L);
        View view = this.parentView;
        float f16 = mediumBgLoc[0] - iArr[0];
        float f17 = mediumBgLoc[1] - iArr[1];
        ECXingHuanBaseBigCardView.Companion companion = ECXingHuanBaseBigCardView.INSTANCE;
        a16 = r31.a(this.bigSubtitleView, 0.0f, 1.0f, (r26 & 8) != 0 ? a.C0035a.j(a.C0035a.f(a.C0035a.f(a.C0035a.j(c0035a, view, f16, f17, 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null), this.bigBgView, mediumBgWidth / r4.getWidth(), 1.0f, mediumBgHeight / this.bigBgView.getHeight(), 1.0f, 0.0f, 0.0f, 0L, false, companion.a(), listener, 0L, 2464, null), this.bigCoverView, mediumCoverWidth / r2.getWidth(), 1.0f, mediumCoverHeight / this.bigCoverView.getHeight(), 1.0f, 0.0f, 0.0f, 0L, false, companion.a(), null, 0L, 3488, null), this.bigSubtitleView, 0.0f, companion.e(), 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a17 = r31.a(this.bigTagView, 0.0f, 1.0f, (r26 & 8) != 0 ? a.C0035a.j(a16, this.bigTagView, 0.0f, companion.e(), 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a18 = a17.a(this.bigCloseImageView, 0.0f, 1.0f, (r26 & 8) != 0 ? a17.duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a.C0035a j3 = a.C0035a.j(a.C0035a.f(a.C0035a.j(a.C0035a.j(a18, this.bigContainer, -companion.d(), -companion.d(), 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null), this.bigTitleContainer, (mediumTitleLoc[0] - r12[0]) + companion.d(), 0.0f, 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null), this.bigTitleView, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f, 0.0f, 0L, false, companion.a(), null, 0L, 3488, null), this.bigBtnLayout, ((mediumBtnLoc[0] - r13[0]) - ((r3.getWidth() - mediumBtnWidth) / 2)) + companion.d(), (-this.parentView.getHeight()) + companion.c() + companion.d(), 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null);
        TextView textView = this.bigBtnText;
        if (textView != null) {
            a.C0035a.f(j3, textView, 0.85f, 1.0f, 0.85f, 1.0f, 0.0f, 0.0f, 0L, false, companion.a(), null, 0L, 3488, null);
        }
        View view2 = this.bigBtnBg;
        if (view2 != null) {
            a.C0035a.f(j3, view2, mediumBtnWidth / this.bigBtnLayout.getWidth(), 1.0f, mediumBtnHeight / this.bigBtnLayout.getHeight(), 1.0f, this.bigBtnLayout.getWidth() / 2.0f, this.bigBtnLayout.getHeight() / 2.0f, 0L, false, companion.a(), null, 0L, 3456, null);
        }
        Unit unit = Unit.INSTANCE;
        this.ecAnimationSet = j3.c().b();
        g(this.contentInfo.getContentId());
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView
    public void f(int uiType, UIInfo uiInfo, IECXingHuanGameButton bigBtn, IECGoodsCardView.IGoodsCardClickListener clickListener, View.OnClickListener closeListener) {
        cg0.a.b("ECXingHuanLeftPicCardView", "configBigCardUI uiType:" + uiType);
        if (!TextUtils.isEmpty(uiInfo.getPicUrl())) {
            Companion companion = INSTANCE;
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(getContext(), uiInfo.getPicUrl(), this.bigCoverView, new IECImageLoader.ImageLoaderOption(companion.c(), companion.c(), 0, null, null, null, false, false, null, 508, null));
        }
        this.bigTitleView.setText(uiInfo.getTitle());
        this.bigSubtitleView.setText(uiInfo.getSubtitle());
        this.bigTagView.setVisibility(TextUtils.isEmpty(uiInfo.getActivityTagInfo().getText()) ^ true ? 0 : 8);
        this.bigTagView.setText(uiInfo.getActivityTagInfo().getText());
        this.bigBtnLayout.addView(bigBtn.getView(), new FrameLayout.LayoutParams(-1, -1));
        this.bigBtnBg = bigBtn.getBgView();
        this.bigBtnText = bigBtn.getTipsView();
        this.bigLayout.setOnClickListener(new b(uiType, clickListener, uiInfo));
        this.bigCloseImageView.setOnClickListener(new c(uiType, closeListener));
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
        a16 = r1.a(this.bigCoverView, 1.0f, 0.0f, (r26 & 8) != 0 ? a.C0035a.f(a.C0035a.f(a.C0035a.j(c0035a, view, 0.0f, 0.0f, f16, f17, 0L, false, companion.a(), null, g.CTRL_INDEX, null), this.bigBgView, 1.0f, mediumBgWidth / r4.getWidth(), 1.0f, mediumBgHeight / this.bigBgView.getHeight(), 0.0f, 0.0f, 0L, false, companion.a(), listener, 0L, 2464, null), this.bigCoverView, 1.0f, mediumCoverWidth / r1.getWidth(), 1.0f, mediumCoverHeight / this.bigCoverView.getHeight(), 0.0f, 0.0f, 0L, false, companion.a(), null, 0L, 3488, null).duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
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
        a16 = r27.a(this.bigCloseImageView, 1.0f, 0.0f, (r26 & 8) != 0 ? a.C0035a.j(a.C0035a.f(a.C0035a.j(c0035a, view, 0.0f, 0.0f, f16, f17, 0L, false, companion.a(), null, g.CTRL_INDEX, null), this.bigCoverView, 1.0f, smallIconWidth / r1.getWidth(), 1.0f, smallIconHeight / this.bigCoverView.getHeight(), 0.0f, 0.0f, 0L, false, companion.a(), null, 0L, 3488, null), this.bigContainer, 0.0f, 0.0f, -companion.b(), -companion.b(), 0L, false, companion.a(), null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a17 = a16.a(this.bigTitleView, 1.0f, 0.0f, (r26 & 8) != 0 ? a16.duration : 500L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a18 = a17.a(this.bigSubtitleView, 1.0f, 0.0f, (r26 & 8) != 0 ? a17.duration : 500L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a19 = a18.a(this.bigTagView, 1.0f, 0.0f, (r26 & 8) != 0 ? a18.duration : 500L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a26 = a19.a(this.bigCoverView, 1.0f, 0.0f, (r26 & 8) != 0 ? a19.duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a27 = a26.a(this.bigBtnLayout, 1.0f, 0.0f, (r26 & 8) != 0 ? a26.duration : 500L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        this.ecAnimationSet = a.C0035a.f(a27, this.bigBgView, 1.0f, smallBgWidth / r4.getWidth(), 1.0f, smallBgHeight / this.bigBgView.getHeight(), 0.0f, 0.0f, 0L, false, companion.a(), listener, 0L, 2464, null).c().b();
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
        a16 = r27.a(this.bigCloseImageView, 0.0f, 1.0f, (r26 & 8) != 0 ? a.C0035a.j(a.C0035a.f(a.C0035a.j(c0035a, view, f16, f17, 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null), this.bigCoverView, smallIconWidth / r6.getWidth(), 1.0f, smallIconHeight / this.bigCoverView.getHeight(), 1.0f, 0.0f, 0.0f, 0L, false, companion.a(), null, 0L, 3488, null), this.bigContainer, -companion.b(), -companion.b(), 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        ViewGroup viewGroup = this.bigTitleContainer;
        float f18 = (smallTitleLoc[0] - r1[0]) - f16;
        Companion companion2 = INSTANCE;
        a17 = r27.a(this.bigSubtitleView, 0.0f, 1.0f, (r26 & 8) != 0 ? a.C0035a.j(a.C0035a.f(a.C0035a.j(a16, viewGroup, f18 + companion2.a(), ((smallTitleLoc[1] - r1[1]) - f17) + companion2.b(), 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null), this.bigTitleView, 0.8f, 1.0f, 0.8f, 1.0f, 0.0f, 0.0f, 0L, false, companion.a(), null, 0L, 3488, null), this.bigSubtitleView, 0.0f, companion.e(), 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a18 = r27.a(this.bigTagView, 0.0f, 1.0f, (r26 & 8) != 0 ? a.C0035a.j(a17, this.bigTagView, 0.0f, companion.e(), 0.0f, 0.0f, 0L, false, companion.a(), null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        a19 = a18.a(this.bigBtnLayout, 0.0f, 1.0f, (r26 & 8) != 0 ? a18.duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        this.ecAnimationSet = a.C0035a.f(a19, this.bigBgView, smallBgWidth / r3.getWidth(), 1.0f, smallBgHeight / this.bigBgView.getHeight(), 1.0f, 0.0f, 0.0f, 0L, false, companion.a(), listener, 0L, 2464, null).c().b();
        g(this.contentInfo.getContentId());
    }
}
