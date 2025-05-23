package com.tencent.ecommerce.biz.consumer.view.bigcard;

import ah0.a;
import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.videnevent.api.IECVideoControlDelegate;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.ECGoodsCommonUtils;
import com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.bigcard.ECBigCardView;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.ecommerce.repo.consumer.resp.ButtonInfo;
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
import kotlin.jvm.internal.Intrinsics;
import nh0.a;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ~2\u00020\u0001:\u0001\u007fB\u0017\u0012\u0006\u0010{\u001a\u00020z\u0012\u0006\u0010y\u001a\u00020v\u00a2\u0006\u0004\b|\u0010}J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0014J*\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017JF\u0010#\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!Jn\u0010/\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020-2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!J6\u00103\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!J\u0006\u00104\u001a\u00020\u0004R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010:\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010=R\u0014\u0010B\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010=R\u0014\u0010D\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010=R\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010J\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010GR\u0014\u0010L\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u00107R\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010R\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010=R\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010OR\u0014\u0010Z\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010OR\u0014\u0010\\\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010=R\u0014\u0010^\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010OR\u0014\u0010`\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010OR\u0014\u0010b\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010OR\u0014\u0010d\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010=R\u0014\u0010f\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010=R\u0014\u0010h\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010=R\u0014\u0010l\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0014\u0010n\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010kR\u0016\u0010q\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010u\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0014\u0010y\u001a\u00020v8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bw\u0010x\u00a8\u0006\u0080\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/bigcard/ECBigCardView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", "", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "imageWidth", "imageHeight", "", "url", ReportConstant.COSTREPORT_PREFIX, "molecule", "", "denominator", "p", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "uiType", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "clickListener", "Landroid/view/View$OnClickListener;", "closeListener", "o", "", "smallIBgLoc", "smallImageWidth", "smallImageHeight", "smallICardBgWidth", "smallICardBgHeight", "fromUiType", "Landroid/animation/Animator$AnimatorListener;", "listener", "w", "mediumCardBgWidth", "mediumCardBgHeight", "mediumImageWidth", "mediumImageHeight", "mediumBuyLayoutWidth", "mediumBuyLayoutHeight", "mediumBuyLayoutLoc", "mediumBgLoc", "mediumTitleLoc", "", "isMediumBuyButtonShow", "v", "smallBgLoc", "smallCardBgWidth", "smallCardBgHeight", "u", "r", "Landroid/view/View;", "d", "Landroid/view/View;", "parentView", "e", "biCardBgView", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "bigContainerLayout", h.F, "bigTitleLayout", "i", "bigSubTitleLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "bigImageLayout", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "bigImageView", "D", "bigCloseImageView", "E", "bigBuyButtonBg", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "bigBuyText", "G", "bigBuyLayout", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "bigStartLayout", "I", "bigStartText", "J", "bigStartDefaultText", "K", "bigGuideLayout", "L", "bigGuidePriceText", "M", "bigGuideDescText", "N", "bigGuideBuyText", "P", "bigRichContainerLayout", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "bigRichLayout", BdhLogUtil.LogTag.Tag_Req, "bigSubRichLayout", "Lnh0/a;", ExifInterface.LATITUDE_SOUTH, "Lnh0/a;", "bigRichTitleModel", "T", "bigRichSubTitleModel", "U", "Z", "isRichModelInit", "Lah0/a;", "V", "Lah0/a;", "ecAnimationSet", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "W", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;)V", "h0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECBigCardView extends FrameLayout {

    /* renamed from: a0, reason: collision with root package name */
    private static final Lazy f101820a0;

    /* renamed from: b0, reason: collision with root package name */
    private static final Lazy f101821b0;

    /* renamed from: c0, reason: collision with root package name */
    private static final Lazy f101822c0;

    /* renamed from: d0, reason: collision with root package name */
    private static final Lazy f101823d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final Lazy f101824e0;

    /* renamed from: f0, reason: collision with root package name */
    private static final Lazy f101825f0;

    /* renamed from: g0, reason: collision with root package name */
    private static final ah0.b f101826g0;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final ImageView bigImageView;

    /* renamed from: D, reason: from kotlin metadata */
    private final ImageView bigCloseImageView;

    /* renamed from: E, reason: from kotlin metadata */
    private final View bigBuyButtonBg;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView bigBuyText;

    /* renamed from: G, reason: from kotlin metadata */
    private final ViewGroup bigBuyLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private final LinearLayout bigStartLayout;

    /* renamed from: I, reason: from kotlin metadata */
    private final TextView bigStartText;

    /* renamed from: J, reason: from kotlin metadata */
    private final TextView bigStartDefaultText;

    /* renamed from: K, reason: from kotlin metadata */
    private final ViewGroup bigGuideLayout;

    /* renamed from: L, reason: from kotlin metadata */
    private final TextView bigGuidePriceText;

    /* renamed from: M, reason: from kotlin metadata */
    private final TextView bigGuideDescText;

    /* renamed from: N, reason: from kotlin metadata */
    private final TextView bigGuideBuyText;

    /* renamed from: P, reason: from kotlin metadata */
    private final ViewGroup bigRichContainerLayout;

    /* renamed from: Q, reason: from kotlin metadata */
    private final ViewGroup bigRichLayout;

    /* renamed from: R, reason: from kotlin metadata */
    private final ViewGroup bigSubRichLayout;

    /* renamed from: S, reason: from kotlin metadata */
    private final a bigRichTitleModel;

    /* renamed from: T, reason: from kotlin metadata */
    private final a bigRichSubTitleModel;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isRichModelInit;

    /* renamed from: V, reason: from kotlin metadata */
    private ah0.a ecAnimationSet;

    /* renamed from: W, reason: from kotlin metadata */
    public final ECContentInfo contentInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View parentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View biCardBgView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup bigContainerLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup bigTitleLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup bigSubTitleLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup bigImageLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000f\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u000bR\u001b\u0010\u0012\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u000bR\u001b\u0010\u0015\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001b\u0010\u0018\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u0014\u0010\u001a\u001a\u00020\u00198\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00198\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00198\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0014\u0010 \u001a\u00020\u001f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006$"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/bigcard/ECBigCardView$a;", "", "", "MAX_WIDTH$delegate", "Lkotlin/Lazy;", "f", "()I", "MAX_WIDTH", "", "BIG_CARD_MARGIN_FLOAT$delegate", "a", "()F", "BIG_CARD_MARGIN_FLOAT", "BIG_MEDIUN_GAP_CARD_MARGIN_FLOAT$delegate", "c", "BIG_MEDIUN_GAP_CARD_MARGIN_FLOAT", "BIG_MEDIUN_GAP_TWO_CARD_MARGIN_FLOAT$delegate", "d", "BIG_MEDIUN_GAP_TWO_CARD_MARGIN_FLOAT", "BIG_RICH_TITLE_MARGIN$delegate", "e", "BIG_RICH_TITLE_MARGIN", "BIG_CARD_MIN_WIDTH$delegate", "b", "BIG_CARD_MIN_WIDTH", "", "ALPHA_ANIMATION_DURATION", "J", "ANIMATION_DURATION", "DELAY_ALPHA_ANIMATION_DURATION", "DELAY_ALPHA_BUY_ANIMATION_DURATION", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.consumer.view.bigcard.ECBigCardView$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final float a() {
            return ((Number) ECBigCardView.f101821b0.getValue()).floatValue();
        }

        public final int b() {
            return ((Number) ECBigCardView.f101825f0.getValue()).intValue();
        }

        public final float c() {
            return ((Number) ECBigCardView.f101822c0.getValue()).floatValue();
        }

        public final float d() {
            return ((Number) ECBigCardView.f101823d0.getValue()).floatValue();
        }

        public final int e() {
            return ((Number) ECBigCardView.f101824e0.getValue()).intValue();
        }

        public final int f() {
            return ((Number) ECBigCardView.f101820a0.getValue()).intValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f101835e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ IECGoodsCardView.IGoodsCardClickListener f101836f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ UIInfo f101837h;

        b(int i3, IECGoodsCardView.IGoodsCardClickListener iGoodsCardClickListener, UIInfo uIInfo) {
            this.f101835e = i3;
            this.f101836f = iGoodsCardClickListener;
            this.f101837h = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECBigCardView.this.setTag(R.id.nte, Integer.valueOf(this.f101835e));
            IECGoodsCardView.IGoodsCardClickListener iGoodsCardClickListener = this.f101836f;
            if (iGoodsCardClickListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(iGoodsCardClickListener, ECBigCardView.this, ECGoodsCommonUtils.f101579a.o(this.f101837h.getJumpInfoArray()), null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class c implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f101839e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f101840f;

        c(int i3, View.OnClickListener onClickListener) {
            this.f101839e = i3;
            this.f101840f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECBigCardView.this.setTag(R.id.nte, Integer.valueOf(this.f101839e));
            View.OnClickListener onClickListener = this.f101840f;
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
        Lazy lazy5;
        Lazy lazy6;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.bigcard.ECBigCardView$Companion$MAX_WIDTH$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                int f16 = (int) ((ECDeviceUtils.f104857e.f() * 0.72f) - e.c(12.0f));
                if (f16 > 0) {
                    return f16;
                }
                cg0.a.a("ECNGCardView", "MAX_WIDTH", "getScreenWidth is zero");
                return Integer.MAX_VALUE;
            }
        });
        f101820a0 = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.bigcard.ECBigCardView$Companion$BIG_CARD_MARGIN_FLOAT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(12.0f);
            }
        });
        f101821b0 = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.bigcard.ECBigCardView$Companion$BIG_MEDIUN_GAP_CARD_MARGIN_FLOAT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(4.0f);
            }
        });
        f101822c0 = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.bigcard.ECBigCardView$Companion$BIG_MEDIUN_GAP_TWO_CARD_MARGIN_FLOAT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(2.0f);
            }
        });
        f101823d0 = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.bigcard.ECBigCardView$Companion$BIG_RICH_TITLE_MARGIN$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(31.0f);
            }
        });
        f101824e0 = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.bigcard.ECBigCardView$Companion$BIG_CARD_MIN_WIDTH$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(268.0f);
            }
        });
        f101825f0 = lazy6;
        f101826g0 = new ah0.b(0.4f, 0.0f, 0.68f, 0.06f);
    }

    public ECBigCardView(Context context, ECContentInfo eCContentInfo) {
        super(context);
        this.contentInfo = eCContentInfo;
        this.bigRichTitleModel = new a(false, 1, null);
        this.bigRichSubTitleModel = new a(false, 1, null);
        this.parentView = LayoutInflater.from(context).inflate(R.layout.crj, (ViewGroup) this, true);
        this.biCardBgView = findViewById(R.id.nqu);
        this.bigContainerLayout = (ViewGroup) findViewById(R.id.nqz);
        this.bigTitleLayout = (ViewGroup) findViewById(R.id.nri);
        this.bigCloseImageView = (ImageView) findViewById(R.id.nqy);
        this.bigRichLayout = (ViewGroup) findViewById(R.id.nr9);
        this.bigSubRichLayout = (ViewGroup) findViewById(R.id.nr7);
        this.bigStartText = (TextView) findViewById(R.id.nrg);
        this.bigSubTitleLayout = (ViewGroup) findViewById(R.id.nrh);
        this.bigImageLayout = (ViewGroup) findViewById(R.id.f162997nr2);
        this.bigImageView = (ImageView) findViewById(R.id.f162996nr1);
        this.bigBuyLayout = (ViewGroup) findViewById(R.id.nqw);
        this.bigBuyText = (TextView) findViewById(R.id.nqx);
        this.bigBuyButtonBg = findViewById(R.id.nqv);
        this.bigStartDefaultText = (TextView) findViewById(R.id.nra);
        this.bigStartLayout = (LinearLayout) findViewById(R.id.nr_);
        this.bigGuidePriceText = (TextView) findViewById(R.id.nr5);
        this.bigGuideDescText = (TextView) findViewById(R.id.f162998nr3);
        this.bigGuideLayout = (ViewGroup) findViewById(R.id.f162999nr4);
        this.bigGuideBuyText = (TextView) findViewById(R.id.nr6);
        this.bigRichContainerLayout = (ViewGroup) findViewById(R.id.nr8);
    }

    private final float p(int molecule, float denominator) {
        if (denominator == 0.0f) {
            return 0.0f;
        }
        return molecule / denominator;
    }

    private final void q(final UIInfo uiInfo) {
        if (this.isRichModelInit) {
            cg0.a.b("ECBigCardView", "initBigRichModelOnSubThread return has init");
        } else {
            ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.view.bigcard.ECBigCardView$initBigRichModelOnSubThread$1
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
                    ViewGroup viewGroup;
                    a aVar;
                    a aVar2;
                    cg0.a.b("ECBigCardView", "initBigRichModelOnSubThread richTitle:" + uiInfo.getRichTitle() + " , richSubTitle:" + uiInfo.getRichSubTitle());
                    if (TextUtils.isEmpty(uiInfo.getRichTitle()) || TextUtils.isEmpty(uiInfo.getRichSubTitle())) {
                        return;
                    }
                    ECBigCardView.Companion companion = ECBigCardView.INSTANCE;
                    float a16 = companion.a();
                    viewGroup = ECBigCardView.this.bigImageLayout;
                    float a17 = viewGroup.getLayoutParams().width + companion.a() + companion.a();
                    float f16 = companion.f() - ((companion.e() + a16) + a17);
                    JSONObject jSONObject = new JSONObject(uiInfo.getRichTitle());
                    aVar = ECBigCardView.this.bigRichTitleModel;
                    a.d(aVar, jSONObject, f16, 0, 4, null);
                    JSONObject jSONObject2 = new JSONObject(uiInfo.getRichSubTitle());
                    aVar2 = ECBigCardView.this.bigRichSubTitleModel;
                    a.d(aVar2, jSONObject2, companion.f() - (a17 + a16), 0, 4, null);
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.view.bigcard.ECBigCardView$initBigRichModelOnSubThread$1.1
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
                            a aVar3;
                            a aVar4;
                            View view;
                            ViewGroup viewGroup2;
                            ViewGroup viewGroup3;
                            ViewGroup viewGroup4;
                            ViewGroup viewGroup5;
                            ViewGroup viewGroup6;
                            ViewGroup viewGroup7;
                            cg0.a.b("ECBigCardView", "initBigRichModelOnSubThread addView start");
                            aVar3 = ECBigCardView.this.bigRichTitleModel;
                            View b16 = aVar3.b(ECBigCardView.this.getContext());
                            if (b16 != null) {
                                viewGroup6 = ECBigCardView.this.bigRichLayout;
                                if (viewGroup6.indexOfChild(b16) == -1) {
                                    viewGroup7 = ECBigCardView.this.bigRichLayout;
                                    viewGroup7.addView(b16);
                                    cg0.a.b("ECBigCardView", "initBigRichModelOnSubThread addView richTitleView success");
                                }
                            }
                            aVar4 = ECBigCardView.this.bigRichSubTitleModel;
                            View b17 = aVar4.b(ECBigCardView.this.getContext());
                            if (b17 != null) {
                                viewGroup4 = ECBigCardView.this.bigSubRichLayout;
                                if (viewGroup4.indexOfChild(b17) == -1) {
                                    viewGroup5 = ECBigCardView.this.bigSubRichLayout;
                                    viewGroup5.addView(b17);
                                    cg0.a.b("ECBigCardView", "initBigRichModelOnSubThread addView richSubTitleView success");
                                }
                            }
                            cg0.a.b("ECBigCardView", "initBigRichModelOnSubThread addView end");
                            if (b16 == null || b17 == null) {
                                return;
                            }
                            ECGoodsCommonUtils eCGoodsCommonUtils = ECGoodsCommonUtils.f101579a;
                            float k3 = eCGoodsCommonUtils.k(b17);
                            if (uiInfo.getIsShowScore()) {
                                view = uiInfo.getRatingScore() == 0.0f ? ECBigCardView.this.bigStartDefaultText : ECBigCardView.this.bigStartLayout;
                            } else {
                                view = null;
                            }
                            if (view != null) {
                                view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                                k3 = Math.max(k3, view.getMeasuredWidth());
                            }
                            float k16 = eCGoodsCommonUtils.k(b16);
                            ECBigCardView.Companion companion2 = ECBigCardView.INSTANCE;
                            float max = Math.max(k3, k16 + companion2.e());
                            int b18 = companion2.b();
                            viewGroup2 = ECBigCardView.this.bigImageLayout;
                            float a18 = (((b18 - viewGroup2.getLayoutParams().width) - companion2.a()) - companion2.a()) - companion2.a();
                            viewGroup3 = ECBigCardView.this.bigRichContainerLayout;
                            viewGroup3.getLayoutParams().width = Math.max((int) max, (int) a18);
                        }
                    });
                }
            });
            this.isRichModelInit = true;
        }
    }

    private final void t(UIInfo uiInfo) {
        if (uiInfo.getIsShowScore()) {
            if (uiInfo.getRatingScore() == 0.0f) {
                this.bigStartDefaultText.setVisibility(0);
                return;
            }
            this.bigStartLayout.setVisibility(0);
            this.bigStartText.setText(String.valueOf(uiInfo.getRatingScore()));
            float ratingScore = uiInfo.getRatingScore();
            int i3 = (int) (ratingScore / 2);
            if (i3 >= 5) {
                i3 = 5;
            }
            float f16 = ratingScore % 2.0f;
            for (int i16 = 0; i16 < i3; i16++) {
                View childAt = this.bigStartLayout.getChildAt(i16);
                if (childAt != null) {
                    ((ImageView) childAt).setImageDrawable(getContext().getDrawable(R.drawable.e7a));
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
                }
            }
            if (f16 >= 1.0f) {
                View childAt2 = this.bigStartLayout.getChildAt(i3);
                if (childAt2 != null) {
                    ((ImageView) childAt2).setImageDrawable(getContext().getDrawable(R.drawable.dot));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            }
        }
    }

    public final void o(int uiType, UIInfo uiInfo, IECGoodsCardView.IGoodsCardClickListener clickListener, View.OnClickListener closeListener) {
        cg0.a.b("ECBigCardView", "configBigCardUI uiType:" + uiType);
        String str = "linear-gradient(to right, #FF46A0 0%, #FF3355 100%)";
        if (uiType == 10200) {
            ButtonInfo buttonInfo = uiInfo.getButtonInfo();
            if (!TextUtils.isEmpty(buttonInfo != null ? buttonInfo.getButtonText() : null)) {
                this.bigBuyLayout.setVisibility(0);
                TextView textView = this.bigBuyText;
                ButtonInfo buttonInfo2 = uiInfo.getButtonInfo();
                textView.setText(buttonInfo2 != null ? buttonInfo2.getButtonText() : null);
            } else {
                this.bigBuyLayout.setVisibility(8);
            }
            if (!TextUtils.isEmpty(uiInfo.getPicUrl())) {
                if (uiInfo.getIsRectangleCover()) {
                    ECVideoFeedsGoodsCardView.Companion companion = ECVideoFeedsGoodsCardView.INSTANCE;
                    s(companion.e(), companion.d(), uiInfo.getPicUrl());
                } else {
                    ECVideoFeedsGoodsCardView.Companion companion2 = ECVideoFeedsGoodsCardView.INSTANCE;
                    s(companion2.e(), companion2.e(), uiInfo.getPicUrl());
                }
            }
            ButtonInfo buttonInfo3 = uiInfo.getButtonInfo();
            if (!TextUtils.isEmpty(buttonInfo3 != null ? buttonInfo3.getButtonBgColor() : null)) {
                ButtonInfo buttonInfo4 = uiInfo.getButtonInfo();
                Intrinsics.checkNotNull(buttonInfo4);
                str = buttonInfo4.getButtonBgColor();
            }
            ECGoodsCommonUtils.f101579a.q(this.bigBuyButtonBg, str);
        } else if (uiType == 10201) {
            if (!TextUtils.isEmpty(uiInfo.getPicUrl())) {
                if (uiInfo.getIsRectangleCover()) {
                    ECVideoFeedsGoodsCardView.Companion companion3 = ECVideoFeedsGoodsCardView.INSTANCE;
                    s(companion3.e(), companion3.d(), uiInfo.getPicUrl());
                } else {
                    ECVideoFeedsGoodsCardView.Companion companion4 = ECVideoFeedsGoodsCardView.INSTANCE;
                    s(companion4.c(), companion4.c(), uiInfo.getPicUrl());
                }
            }
            if (!TextUtils.isEmpty(uiInfo.getPrice())) {
                this.bigGuideLayout.setVisibility(0);
                TextView textView2 = this.bigGuidePriceText;
                textView2.setVisibility(0);
                textView2.setText(uiInfo.getPrice());
            } else if (!TextUtils.isEmpty(uiInfo.getPromotionText())) {
                this.bigGuideLayout.setVisibility(0);
                TextView textView3 = this.bigGuideDescText;
                textView3.setVisibility(0);
                textView3.setText(uiInfo.getPromotionText());
            }
            ButtonInfo buttonInfo5 = uiInfo.getButtonInfo();
            if (!TextUtils.isEmpty(buttonInfo5 != null ? buttonInfo5.getButtonText() : null)) {
                this.bigGuideLayout.setVisibility(0);
                ButtonInfo buttonInfo6 = uiInfo.getButtonInfo();
                if (!TextUtils.isEmpty(buttonInfo6 != null ? buttonInfo6.getButtonBgColor() : null)) {
                    ButtonInfo buttonInfo7 = uiInfo.getButtonInfo();
                    Intrinsics.checkNotNull(buttonInfo7);
                    str = buttonInfo7.getButtonBgColor();
                }
                TextView textView4 = this.bigGuideBuyText;
                textView4.setVisibility(0);
                ButtonInfo buttonInfo8 = uiInfo.getButtonInfo();
                textView4.setText(buttonInfo8 != null ? buttonInfo8.getButtonText() : null);
                ECGoodsCommonUtils.f101579a.q(this.bigGuideBuyText, str);
            }
        }
        t(uiInfo);
        setOnClickListener(new b(uiType, clickListener, uiInfo));
        this.bigCloseImageView.setOnClickListener(new c(uiType, closeListener));
        q(uiInfo);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        Companion companion = INSTANCE;
        if (size > companion.f()) {
            cg0.a.b("ECBigCardView", "adjust width " + size + " to " + companion.f());
            size = companion.f();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), heightMeasureSpec);
    }

    public final void r() {
        this.parentView.setTranslationX(0.0f);
        this.parentView.setTranslationY(0.0f);
        this.bigImageLayout.setScaleX(1.0f);
        this.bigImageLayout.setScaleY(1.0f);
        this.bigContainerLayout.setTranslationX(0.0f);
        this.bigContainerLayout.setTranslationY(0.0f);
        this.biCardBgView.setScaleX(1.0f);
        this.biCardBgView.setScaleY(1.0f);
        this.bigCloseImageView.setAlpha(1.0f);
        this.bigTitleLayout.setAlpha(1.0f);
        this.bigImageLayout.setAlpha(1.0f);
        this.bigBuyLayout.setAlpha(1.0f);
    }

    public final void v(int mediumCardBgWidth, int mediumCardBgHeight, int mediumImageWidth, int mediumImageHeight, int mediumBuyLayoutWidth, int mediumBuyLayoutHeight, int[] mediumBuyLayoutLoc, int[] mediumBgLoc, int[] mediumTitleLoc, boolean isMediumBuyButtonShow, int fromUiType, int uiType, Animator.AnimatorListener listener) {
        a.C0035a a16;
        a.C0035a a17;
        a.C0035a a18;
        cg0.a.b("ECBigCardView", "startAnimMediumChangeToBig uiType:" + uiType + "\uff0cfromUiType:" + fromUiType);
        int[] iArr = new int[2];
        this.biCardBgView.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        this.bigBuyLayout.getLocationInWindow(iArr2);
        this.bigBuyButtonBg.getLocationInWindow(new int[2]);
        int i3 = mediumBgLoc[1] - iArr[1];
        this.bigTitleLayout.getLocationInWindow(new int[2]);
        ah0.b bVar = f101826g0;
        a16 = r20.a(this.bigSubTitleLayout, 0.0f, 1.0f, (r26 & 8) != 0 ? a.C0035a.j(a.C0035a.f(a.C0035a.j(new a.C0035a(700L), this.parentView, mediumBgLoc[0] - iArr[0], i3, 0.0f, 0.0f, 0L, false, bVar, null, g.CTRL_INDEX, null), this.bigImageLayout, mediumImageWidth / r8.getWidth(), 1.0f, mediumImageHeight / this.bigImageLayout.getHeight(), 1.0f, 0.0f, 0.0f, 0L, false, bVar, null, 0L, 3488, null), this.bigSubTitleLayout, 0.0f, e.c(20.0f), 0.0f, 0.0f, 0L, false, bVar, null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : bVar, (r26 & 256) != 0 ? null : null);
        a17 = r20.a(this.bigGuideLayout, 0.0f, 1.0f, (r26 & 8) != 0 ? a.C0035a.j(a16, this.bigGuideLayout, 0.0f, e.c(20.0f), 0.0f, 0.0f, 0L, false, bVar, null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : bVar, (r26 & 256) != 0 ? null : null);
        a18 = a17.a(this.bigCloseImageView, 0.0f, 1.0f, (r26 & 8) != 0 ? a17.duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : bVar, (r26 & 256) != 0 ? null : null);
        if (fromUiType == 10401) {
            ViewGroup viewGroup = this.bigContainerLayout;
            Companion companion = INSTANCE;
            a.C0035a.j(a.C0035a.j(a18, viewGroup, -companion.a(), -companion.a(), 0.0f, 0.0f, 0L, false, bVar, null, g.CTRL_INDEX, null), this.bigTitleLayout, (mediumTitleLoc[0] - r9[0]) + companion.a(), companion.d(), 0.0f, 0.0f, 0L, false, bVar, null, g.CTRL_INDEX, null);
        } else if (fromUiType != 10600) {
            ViewGroup viewGroup2 = this.bigContainerLayout;
            Companion companion2 = INSTANCE;
            a.C0035a.j(a.C0035a.j(a18, viewGroup2, -companion2.c(), -companion2.c(), 0.0f, 0.0f, 0L, false, bVar, null, g.CTRL_INDEX, null), this.bigTitleLayout, (mediumTitleLoc[0] - r9[0]) + companion2.c(), -companion2.d(), 0.0f, 0.0f, 0L, false, bVar, null, g.CTRL_INDEX, null);
        } else {
            a.C0035a.j(a.C0035a.j(a18, this.bigContainerLayout, -e.c(8.0f), -e.c(8.0f), 0.0f, 0.0f, 0L, false, bVar, null, g.CTRL_INDEX, null), this.bigTitleLayout, (mediumTitleLoc[0] - r9[0]) + e.c(8.0f), INSTANCE.d(), 0.0f, 0.0f, 0L, false, bVar, null, g.CTRL_INDEX, null);
        }
        if (uiType == 10200) {
            if (isMediumBuyButtonShow) {
                a.C0035a f16 = a.C0035a.f(a18, this.bigBuyButtonBg, mediumBuyLayoutWidth / r2.getWidth(), 1.0f, mediumBuyLayoutHeight / this.bigBuyButtonBg.getHeight(), 1.0f, this.bigBuyButtonBg.getWidth() / 2.0f, this.bigBuyButtonBg.getHeight() / 2.0f, 0L, false, bVar, null, 0L, 3456, null);
                ViewGroup viewGroup3 = this.bigBuyLayout;
                float width = (mediumBuyLayoutLoc[0] - iArr2[0]) - ((this.bigBuyButtonBg.getWidth() - mediumBuyLayoutWidth) / 2);
                Companion companion3 = INSTANCE;
                a.C0035a.j(f16, viewGroup3, width + companion3.c(), (-(this.parentView.getHeight() - e.c(55.0f))) + companion3.c(), 0.0f, 0.0f, 0L, false, bVar, null, g.CTRL_INDEX, null);
            } else {
                a18.a(this.bigBuyLayout, 0.0f, 1.0f, (r26 & 8) != 0 ? a18.duration : 500L, (r26 & 16) != 0 ? 0L : 400L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : bVar, (r26 & 256) != 0 ? null : null);
            }
        }
        Unit unit = Unit.INSTANCE;
        this.ecAnimationSet = a.C0035a.f(a18, this.biCardBgView, p(mediumCardBgWidth, r1.getWidth()), 1.0f, p(mediumCardBgHeight, this.biCardBgView.getHeight()), 1.0f, 0.0f, 0.0f, 0L, false, bVar, listener, 0L, 2464, null).c().b();
        IECVideoControlDelegate videoControl = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVideoControl();
        if (videoControl != null) {
            videoControl.sendVideoInfoViewShowEvent(this.contentInfo.getContentId(), false, true);
        }
    }

    private final void s(int imageWidth, int imageHeight, String url) {
        ViewGroup.LayoutParams layoutParams = this.bigImageLayout.getLayoutParams();
        layoutParams.width = imageWidth;
        layoutParams.height = imageHeight;
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(getContext(), url, this.bigImageView, new IECImageLoader.ImageLoaderOption(imageWidth, imageHeight, 0, null, null, null, false, false, null, 508, null));
    }

    public final void u(int[] smallBgLoc, int smallCardBgWidth, int smallCardBgHeight, int smallImageWidth, int smallImageHeight, Animator.AnimatorListener listener) {
        a.C0035a a16;
        a.C0035a a17;
        a.C0035a a18;
        a.C0035a a19;
        int[] iArr = new int[2];
        this.biCardBgView.getLocationInWindow(iArr);
        int i3 = smallBgLoc[1] - iArr[1];
        ah0.b bVar = f101826g0;
        a.C0035a f16 = a.C0035a.f(a.C0035a.j(new a.C0035a(700L), this.parentView, 0.0f, 0.0f, smallBgLoc[0] - iArr[0], i3, 0L, false, bVar, null, g.CTRL_INDEX, null), this.bigImageLayout, 1.0f, smallImageWidth / r2.getWidth(), 1.0f, smallImageHeight / this.bigImageLayout.getHeight(), 0.0f, 0.0f, 0L, false, bVar, null, 0L, 3488, null);
        ViewGroup viewGroup = this.bigContainerLayout;
        Companion companion = INSTANCE;
        a16 = r13.a(this.bigCloseImageView, 1.0f, 0.0f, (r26 & 8) != 0 ? a.C0035a.j(f16, viewGroup, 0.0f, 0.0f, -companion.a(), -companion.a(), 0L, false, bVar, null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : bVar, (r26 & 256) != 0 ? null : null);
        a17 = a16.a(this.bigTitleLayout, 1.0f, 0.0f, (r26 & 8) != 0 ? a16.duration : 500L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : bVar, (r26 & 256) != 0 ? null : null);
        a18 = a17.a(this.bigImageLayout, 1.0f, 0.0f, (r26 & 8) != 0 ? a17.duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : bVar, (r26 & 256) != 0 ? null : null);
        a19 = a18.a(this.bigBuyLayout, 1.0f, 0.0f, (r26 & 8) != 0 ? a18.duration : 500L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : bVar, (r26 & 256) != 0 ? null : null);
        this.ecAnimationSet = a.C0035a.f(a19, this.biCardBgView, 1.0f, smallCardBgWidth / r1.getWidth(), 1.0f, smallCardBgHeight / this.biCardBgView.getHeight(), 0.0f, 0.0f, 0L, false, bVar, new d(listener), 0L, 2464, null).c().b();
    }

    public final void w(int[] smallIBgLoc, int smallImageWidth, int smallImageHeight, int smallICardBgWidth, int smallICardBgHeight, int fromUiType, int uiType, Animator.AnimatorListener listener) {
        a.C0035a a16;
        a.C0035a a17;
        a.C0035a a18;
        a.C0035a a19;
        cg0.a.b("ECBigCardView", "startAnimSmallChangeToBig uiType:" + uiType + "\uff0cfromUiType:" + fromUiType);
        int[] iArr = new int[2];
        this.biCardBgView.getLocationInWindow(iArr);
        this.bigBuyLayout.getLocationInWindow(new int[2]);
        this.bigBuyButtonBg.getLocationInWindow(new int[2]);
        int i3 = smallIBgLoc[1] - iArr[1];
        ah0.b bVar = f101826g0;
        a16 = r16.a(this.bigSubTitleLayout, 0.0f, 1.0f, (r26 & 8) != 0 ? a.C0035a.j(a.C0035a.f(a.C0035a.j(new a.C0035a(700L), this.parentView, smallIBgLoc[0] - iArr[0], i3, 0.0f, 0.0f, 0L, false, bVar, null, g.CTRL_INDEX, null), this.bigImageLayout, smallImageWidth / r4.getWidth(), 1.0f, smallImageHeight / this.bigImageLayout.getHeight(), 1.0f, 0.0f, 0.0f, 0L, false, bVar, null, 0L, 3488, null), this.bigSubTitleLayout, 0.0f, e.c(20.0f), 0.0f, 0.0f, 0L, false, bVar, null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : bVar, (r26 & 256) != 0 ? null : null);
        a17 = r16.a(this.bigGuideLayout, 0.0f, 1.0f, (r26 & 8) != 0 ? a.C0035a.j(a16, this.bigGuideLayout, 0.0f, e.c(20.0f), 0.0f, 0.0f, 0L, false, bVar, null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : bVar, (r26 & 256) != 0 ? null : null);
        a18 = a17.a(this.bigCloseImageView, 0.0f, 1.0f, (r26 & 8) != 0 ? a17.duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : bVar, (r26 & 256) != 0 ? null : null);
        ViewGroup viewGroup = this.bigContainerLayout;
        Companion companion = INSTANCE;
        a19 = r16.a(this.bigRichLayout, 0.0f, 1.0f, (r26 & 8) != 0 ? a.C0035a.j(a18, viewGroup, -companion.a(), -companion.a(), 0.0f, 0.0f, 0L, false, bVar, null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : bVar, (r26 & 256) != 0 ? null : null);
        if (uiType == 10200) {
            a19.a(this.bigBuyLayout, 0.0f, 1.0f, (r26 & 8) != 0 ? a19.duration : 500L, (r26 & 16) != 0 ? 0L : 400L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : bVar, (r26 & 256) != 0 ? null : null);
        }
        Unit unit = Unit.INSTANCE;
        this.ecAnimationSet = a.C0035a.f(a19, this.biCardBgView, p(smallICardBgWidth, r1.getWidth()), 1.0f, p(smallICardBgHeight, this.biCardBgView.getHeight()), 1.0f, 0.0f, 0.0f, 0L, false, bVar, listener, 0L, 2464, null).c().b();
        IECVideoControlDelegate videoControl = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVideoControl();
        if (videoControl != null) {
            videoControl.sendVideoInfoViewShowEvent(this.contentInfo.getContentId(), false, true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/bigcard/ECBigCardView$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Animator.AnimatorListener f101841d;

        d(Animator.AnimatorListener animatorListener) {
            this.f101841d = animatorListener;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f101841d.onAnimationEnd(animation);
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
}
