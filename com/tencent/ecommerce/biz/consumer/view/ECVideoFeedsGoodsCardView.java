package com.tencent.ecommerce.biz.consumer.view;

import ah0.a;
import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.ktx.TextViewKt;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.ECGoodsCommonUtils;
import com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.ecommerce.repo.consumer.resp.UIInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.rf.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
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
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u009a\u00012\u00020\u00012\u00020\u0002:\u0002\u009b\u0001B\u0013\u0012\b\u0010\u0097\u0001\u001a\u00030\u0096\u0001\u00a2\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0014J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u0007H\u0014J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u0007H\u0014J\b\u0010\u0019\u001a\u00020\u0007H\u0014J\b\u0010\u001a\u001a\u00020\u0007H\u0014J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J,\u0010%\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J,\u0010'\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"H\u0016J$\u0010(\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"H\u0016J\u001c\u0010,\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010+\u001a\u0004\u0018\u00010)H\u0016R\u0014\u0010/\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00104\u001a\u00020\r8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001a\u0010:\u001a\u0002058\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u00101R\u0014\u0010B\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u00107R\u001a\u0010E\u001a\u00020\r8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bC\u00101\u001a\u0004\bD\u00103R\u0014\u0010G\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u00101R\u001a\u0010I\u001a\u0002058\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bH\u00107\u001a\u0004\bC\u00109R\u001a\u0010M\u001a\u00020;8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bJ\u0010=\u001a\u0004\bK\u0010LR\u001a\u0010P\u001a\u00020;8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bN\u0010=\u001a\u0004\bO\u0010LR\u001a\u0010R\u001a\u0002058\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b2\u00107\u001a\u0004\bQ\u00109R\u001a\u0010W\u001a\u00020S8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010T\u001a\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00101R\u001a\u0010[\u001a\u0002058\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bY\u00107\u001a\u0004\bZ\u00109R\u001a\u0010a\u001a\u00020\\8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u001a\u0010c\u001a\u0002058\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0018\u00107\u001a\u0004\bb\u00109R\u001a\u0010e\u001a\u0002058\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0017\u00107\u001a\u0004\bd\u00109R\"\u0010j\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010\u0019\u001a\u0004\bN\u0010g\"\u0004\bh\u0010iR\"\u0010\u000b\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0019\u001a\u0004\bY\u0010g\"\u0004\bk\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR$\u0010r\u001a\u0004\u0018\u00010\u00138\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010m\u001a\u0004\bo\u0010p\"\u0004\bl\u0010qR\u001a\u0010v\u001a\b\u0012\u0004\u0012\u00020t0s8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010uR\u0018\u0010y\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010xR$\u0010\u007f\u001a\u0004\u0018\u00010\u001d8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\bF\u0010|\"\u0004\b}\u0010~R*\u0010\u0085\u0001\u001a\u0004\u0018\u00010)8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0005\bJ\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R*\u0010\u0088\u0001\u001a\u0004\u0018\u00010)8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0006\b\u0086\u0001\u0010\u0081\u0001\u001a\u0005\bH\u0010\u0082\u0001\"\u0006\b\u0087\u0001\u0010\u0084\u0001R(\u0010\u008e\u0001\u001a\u00020\u00168\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0005\b]\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R1\u0010\u0095\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u008f\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0005\bf\u0010\u0094\u0001\u00a8\u0006\u009c\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/ECVideoFeedsGoodsCardView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView;", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "T", "U", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "uiType", "updateUIByType", "Landroid/view/View;", "getView", "getBigView", "getUIType", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", "configCardUI", "", "N", "M", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "p", "o", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "listener", "setGoodsCardClickListener", "Lcom/tencent/ecommerce/biz/consumer/report/b;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "", "ext", "onWrapperViewAppear", "resetToSmallCardIfNeed", "onWrapperViewDisappear", "onClickReport", "Landroid/view/View$OnClickListener;", "animStartListener", "animEndListener", "setCloseClickEventListener", "d", "Ljava/lang/String;", "TAG", "e", "Landroid/view/View;", "H", "()Landroid/view/View;", "smallCardLayout", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "J", "()Landroid/widget/TextView;", "smallTitleView", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "smallImageView", "i", "smallIconLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "smallTipsTextView", BdhLogUtil.LogTag.Tag_Conn, HippyTKDListViewAdapter.X, "mediumCardLayout", "D", "mediumCardBgView", "E", "mediumTitleView", UserInfo.SEX_FEMALE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Landroid/widget/ImageView;", "mediumImageView", "G", "w", "mediumCardForegroundImageView", "B", "mediumPriceTextView", "Landroid/widget/Button;", "Landroid/widget/Button;", "v", "()Landroid/widget/Button;", "mediumBuyButton", "mediumTitleContainerView", "K", "t", "mediumActivityTagTextView", "Landroid/widget/LinearLayout;", "L", "Landroid/widget/LinearLayout;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/widget/LinearLayout;", "mediumActivityTagLayout", "u", "mediumActivityTimeTextView", "r", "mediumActivityPromotionTextView", "P", "()I", "setOriginUIType", "(I)V", "originUIType", ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "smallCardUIInfo", "y", "()Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "(Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;)V", "mediumCardUIInfo", "Landroid/util/SparseArray;", "", "Landroid/util/SparseArray;", "exposePositionMap", "Lah0/a;", "Lah0/a;", "ecAnimationSet", "V", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "()Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "setOnClickEventListener", "(Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;)V", "onClickEventListener", "W", "Landroid/view/View$OnClickListener;", "()Landroid/view/View$OnClickListener;", "setOnCloseAnimStartListener", "(Landroid/view/View$OnClickListener;)V", "onCloseAnimStartListener", "a0", "setOnCloseAnimEndListener", "onCloseAnimEndListener", "b0", "Z", "()Z", "O", "(Z)V", "isAnimingSmallToMeduim", "Lkotlin/Function0;", "c0", "Lkotlin/jvm/functions/Function0;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lkotlin/jvm/functions/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "delayTaskDoAfterAnimToMeduim", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "m0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public class ECVideoFeedsGoodsCardView extends FrameLayout implements IECGoodsCardView {

    /* renamed from: d0, reason: collision with root package name */
    private static final Lazy f101768d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final Lazy f101769e0;

    /* renamed from: f0, reason: collision with root package name */
    private static final Lazy f101770f0;

    /* renamed from: g0, reason: collision with root package name */
    private static final Lazy f101771g0;

    /* renamed from: h0, reason: collision with root package name */
    private static final Lazy f101772h0;

    /* renamed from: i0, reason: collision with root package name */
    private static final Lazy f101773i0;

    /* renamed from: j0, reason: collision with root package name */
    private static final Lazy f101774j0;

    /* renamed from: k0, reason: collision with root package name */
    private static final ah0.b f101775k0;

    /* renamed from: l0, reason: collision with root package name */
    private static final ah0.b f101776l0;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final View mediumCardLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private final View mediumCardBgView;

    /* renamed from: E, reason: from kotlin metadata */
    private final TextView mediumTitleView;

    /* renamed from: F, reason: from kotlin metadata */
    private final ImageView mediumImageView;

    /* renamed from: G, reason: from kotlin metadata */
    private final ImageView mediumCardForegroundImageView;

    /* renamed from: H, reason: from kotlin metadata */
    private final TextView mediumPriceTextView;

    /* renamed from: I, reason: from kotlin metadata */
    private final Button mediumBuyButton;

    /* renamed from: J, reason: from kotlin metadata */
    private final View mediumTitleContainerView;

    /* renamed from: K, reason: from kotlin metadata */
    private final TextView mediumActivityTagTextView;

    /* renamed from: L, reason: from kotlin metadata */
    private final LinearLayout mediumActivityTagLayout;

    /* renamed from: M, reason: from kotlin metadata */
    private final TextView mediumActivityTimeTextView;

    /* renamed from: N, reason: from kotlin metadata */
    private final TextView mediumActivityPromotionTextView;

    /* renamed from: P, reason: from kotlin metadata */
    private int originUIType;

    /* renamed from: Q, reason: from kotlin metadata */
    private int uiType;

    /* renamed from: R, reason: from kotlin metadata */
    private UIInfo smallCardUIInfo;

    /* renamed from: S, reason: from kotlin metadata */
    private UIInfo mediumCardUIInfo;

    /* renamed from: T, reason: from kotlin metadata */
    private final SparseArray<Long> exposePositionMap;

    /* renamed from: U, reason: from kotlin metadata */
    private a ecAnimationSet;

    /* renamed from: V, reason: from kotlin metadata */
    private IECGoodsCardView.IGoodsCardClickListener onClickEventListener;

    /* renamed from: W, reason: from kotlin metadata */
    private View.OnClickListener onCloseAnimStartListener;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener onCloseAnimEndListener;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean isAnimingSmallToMeduim;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> delayTaskDoAfterAnimToMeduim;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View smallCardLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final TextView smallTitleView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ImageView smallImageView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final View smallIconLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final TextView smallTipsTextView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0010\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001b\u0010\u0013\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001b\u0010\u0016\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001b\u0010\u0019\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001eR\u0014\u0010\"\u001a\u00020!8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020!8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/ECVideoFeedsGoodsCardView$a;", "", "", "MAX_WIDTH$delegate", "Lkotlin/Lazy;", "f", "()I", "MAX_WIDTH", "MIN_TITLE_RIGHT_PADDING$delegate", h.F, "MIN_TITLE_RIGHT_PADDING", "MEDIUM_IMAGE_SIZE$delegate", "g", "MEDIUM_IMAGE_SIZE", "BIG_IMAGE_SIZE$delegate", "c", "BIG_IMAGE_SIZE", "SMALL_IMAGE_SIZE$delegate", "i", "SMALL_IMAGE_SIZE", "BIG_IMAGE_SPECIAL_WIDTH_SIZE$delegate", "e", "BIG_IMAGE_SPECIAL_WIDTH_SIZE", "BIG_IMAGE_SPECIAL_HEIGHT_SIZE$delegate", "d", "BIG_IMAGE_SPECIAL_HEIGHT_SIZE", "Lah0/b;", "BEZIER_INTERPOLATOR_TRANSLATION", "Lah0/b;", "b", "()Lah0/b;", "BEZIER_INTERPOLATOR_SCALE", "a", "", "ANIMATION_DURATION", "J", "HALF_ANIMATION_DURATION", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ah0.b a() {
            return ECVideoFeedsGoodsCardView.f101776l0;
        }

        public final ah0.b b() {
            return ECVideoFeedsGoodsCardView.f101775k0;
        }

        public final int c() {
            return ((Number) ECVideoFeedsGoodsCardView.f101771g0.getValue()).intValue();
        }

        public final int d() {
            return ((Number) ECVideoFeedsGoodsCardView.f101774j0.getValue()).intValue();
        }

        public final int e() {
            return ((Number) ECVideoFeedsGoodsCardView.f101773i0.getValue()).intValue();
        }

        public final int f() {
            return ((Number) ECVideoFeedsGoodsCardView.f101768d0.getValue()).intValue();
        }

        public final int g() {
            return ((Number) ECVideoFeedsGoodsCardView.f101770f0.getValue()).intValue();
        }

        public final int h() {
            return ((Number) ECVideoFeedsGoodsCardView.f101769e0.getValue()).intValue();
        }

        public final int i() {
            return ((Number) ECVideoFeedsGoodsCardView.f101772h0.getValue()).intValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101788e;

        b(UIInfo uIInfo) {
            this.f101788e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECVideoFeedsGoodsCardView.this.getMediumCardLayout().setTag(R.id.ntd, 1);
            IECGoodsCardView.IGoodsCardClickListener onClickEventListener = ECVideoFeedsGoodsCardView.this.getOnClickEventListener();
            if (onClickEventListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(onClickEventListener, ECVideoFeedsGoodsCardView.this.getMediumCardLayout(), ECGoodsCommonUtils.f101579a.o(this.f101788e.getJumpInfoArray()), null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101790e;

        c(UIInfo uIInfo) {
            this.f101790e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String o16;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!this.f101790e.getButtonJumpInfoArray().isEmpty()) {
                o16 = ECGoodsCommonUtils.f101579a.o(this.f101790e.getButtonJumpInfoArray());
            } else {
                o16 = ECGoodsCommonUtils.f101579a.o(this.f101790e.getJumpInfoArray());
            }
            String str = o16;
            ECVideoFeedsGoodsCardView.this.getMediumBuyButton().setTag(R.id.ntd, 2);
            IECGoodsCardView.IGoodsCardClickListener onClickEventListener = ECVideoFeedsGoodsCardView.this.getOnClickEventListener();
            if (onClickEventListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(onClickEventListener, ECVideoFeedsGoodsCardView.this.getMediumBuyButton(), str, null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101792e;

        d(UIInfo uIInfo) {
            this.f101792e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECVideoFeedsGoodsCardView.this.getSmallCardLayout().setTag(R.id.ntd, 1);
            IECGoodsCardView.IGoodsCardClickListener onClickEventListener = ECVideoFeedsGoodsCardView.this.getOnClickEventListener();
            if (onClickEventListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(onClickEventListener, ECVideoFeedsGoodsCardView.this.getSmallCardLayout(), ECGoodsCommonUtils.f101579a.o(this.f101792e.getJumpInfoArray()), null, 4, null);
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
        Lazy lazy7;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView$Companion$MAX_WIDTH$2
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
                cg0.a.a("ECVideoFeedsGoodsCardView", "MAX_WIDTH", "getScreenWidth is zero");
                return Integer.MAX_VALUE;
            }
        });
        f101768d0 = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView$Companion$MIN_TITLE_RIGHT_PADDING$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(10.0f);
            }
        });
        f101769e0 = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView$Companion$MEDIUM_IMAGE_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(44.0f);
            }
        });
        f101770f0 = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView$Companion$BIG_IMAGE_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(80.0f);
            }
        });
        f101771g0 = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView$Companion$SMALL_IMAGE_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(24.0f);
            }
        });
        f101772h0 = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView$Companion$BIG_IMAGE_SPECIAL_WIDTH_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(56.0f);
            }
        });
        f101773i0 = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView$Companion$BIG_IMAGE_SPECIAL_HEIGHT_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(84.0f);
            }
        });
        f101774j0 = lazy7;
        f101775k0 = new ah0.b(0.32f, 0.94f, 0.6f, 1.0f);
        f101776l0 = new ah0.b(0.26f, 1.0f, 0.48f, 1.0f);
    }

    public ECVideoFeedsGoodsCardView(Context context) {
        super(context);
        this.TAG = "ECVideoFeedsGoodsCardView[" + hashCode() + ']';
        this.originUIType = -1;
        this.uiType = -1;
        this.exposePositionMap = new SparseArray<>();
        com.tencent.ecommerce.base.device.a.f100685b.f(context, LayoutInflater.from(context).inflate(R.layout.crk, (ViewGroup) this, true));
        this.mediumImageView = (ImageView) findViewById(R.id.o4l);
        this.mediumCardForegroundImageView = (ImageView) findViewById(R.id.o4k);
        this.smallImageView = (ImageView) findViewById(R.id.oak);
        View findViewById = findViewById(R.id.oao);
        this.smallCardLayout = findViewById;
        this.smallIconLayout = findViewById(R.id.oan);
        this.smallTitleView = (TextView) findViewById(R.id.oas);
        this.smallTipsTextView = (TextView) findViewById(R.id.oal);
        View findViewById2 = findViewById(R.id.o4n);
        this.mediumCardLayout = findViewById2;
        this.mediumCardBgView = findViewById(R.id.o4d);
        this.mediumTitleView = (TextView) findViewById(R.id.o4v);
        this.mediumPriceTextView = (TextView) findViewById(R.id.o4o);
        this.mediumBuyButton = (Button) findViewById(R.id.o4f);
        this.mediumTitleContainerView = findViewById(R.id.o4u);
        this.mediumActivityTagTextView = (TextView) findViewById(R.id.o4b);
        this.mediumActivityTagLayout = (LinearLayout) findViewById(R.id.o4a);
        this.mediumActivityTimeTextView = (TextView) findViewById(R.id.o4c);
        this.mediumActivityPromotionTextView = (TextView) findViewById(R.id.o4_);
        findViewById.setVisibility(8);
        findViewById2.setVisibility(8);
        Q();
    }

    private final void Q() {
        TextViewKt.a(this.mediumPriceTextView, "fonts/qvideo-digit-Bold.ttf");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U() {
        this.smallCardLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: A, reason: from getter */
    public final ImageView getMediumImageView() {
        return this.mediumImageView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B, reason: from getter */
    public final TextView getMediumPriceTextView() {
        return this.mediumPriceTextView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C, reason: from getter */
    public final TextView getMediumTitleView() {
        return this.mediumTitleView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: D, reason: from getter */
    public final IECGoodsCardView.IGoodsCardClickListener getOnClickEventListener() {
        return this.onClickEventListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: E, reason: from getter */
    public final View.OnClickListener getOnCloseAnimEndListener() {
        return this.onCloseAnimEndListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: F, reason: from getter */
    public final View.OnClickListener getOnCloseAnimStartListener() {
        return this.onCloseAnimStartListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: G, reason: from getter */
    public final int getOriginUIType() {
        return this.originUIType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: H, reason: from getter */
    public final View getSmallCardLayout() {
        return this.smallCardLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int I() {
        return 500;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: J, reason: from getter */
    public final TextView getSmallTitleView() {
        return this.smallTitleView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: K, reason: from getter */
    public final int getUiType() {
        return this.uiType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: L, reason: from getter */
    public final boolean getIsAnimingSmallToMeduim() {
        return this.isAnimingSmallToMeduim;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean M(int uiType) {
        return uiType == z();
    }

    protected boolean N(int uiType) {
        return uiType == I();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void O(boolean z16) {
        this.isAnimingSmallToMeduim = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P(Function0<Unit> function0) {
        this.delayTaskDoAfterAnimToMeduim = function0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void R(UIInfo uIInfo) {
        this.mediumCardUIInfo = uIInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void S(int i3) {
        this.uiType = i3;
    }

    public void configCardUI(ECContentInfo contentInfo, UIInfo uiInfo, int uiType) {
        if (N(uiType)) {
            p(contentInfo, uiInfo);
        } else if (M(uiType)) {
            o(contentInfo, uiInfo);
        }
    }

    public View getBigView() {
        return null;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    /* renamed from: getUIType */
    public int getCurUIType() {
        return this.uiType;
    }

    public void o(ECContentInfo contentInfo, UIInfo uiInfo) {
        Boolean bool;
        String str;
        this.mediumCardUIInfo = uiInfo;
        if (!TextUtils.isEmpty(uiInfo.getPicUrl())) {
            Companion companion = INSTANCE;
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(getContext(), uiInfo.getPicUrl(), this.mediumImageView, new IECImageLoader.ImageLoaderOption(companion.g(), companion.g(), 0, null, null, null, false, false, null, 508, null));
        }
        String activityMaskUrl = uiInfo.getActivityMaskUrl();
        if (activityMaskUrl != null) {
            bool = Boolean.valueOf(activityMaskUrl.length() > 0);
        } else {
            bool = null;
        }
        if (bool.booleanValue()) {
            this.mediumCardForegroundImageView.setVisibility(0);
            Companion companion2 = INSTANCE;
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(getContext(), uiInfo.getActivityMaskUrl(), this.mediumCardForegroundImageView, new IECImageLoader.ImageLoaderOption(companion2.g(), companion2.g(), 0, null, null, null, false, false, null, 508, null));
        }
        this.mediumTitleView.setText(uiInfo.getTitle());
        this.mediumPriceTextView.setText(uiInfo.getPrice());
        if (!TextUtils.isEmpty(uiInfo.getButtonBgColor())) {
            str = uiInfo.getButtonBgColor();
        } else {
            str = "linear-gradient(to right, #FF46A0 0%, #FF3355 100%)";
        }
        ECGoodsCommonUtils.f101579a.q(this.mediumBuyButton, str);
        this.mediumBuyButton.setText(uiInfo.getButtonText());
        this.mediumCardLayout.setOnClickListener(new b(uiInfo));
        this.mediumBuyButton.setOnClickListener(new c(uiInfo));
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onClickReport(com.tencent.ecommerce.biz.consumer.report.b reportParams, Map<String, String> ext) {
        String str;
        String str2;
        String buttonText;
        com.tencent.ecommerce.biz.consumer.report.a aVar = com.tencent.ecommerce.biz.consumer.report.a.f101632a;
        UIInfo uIInfo = this.mediumCardUIInfo;
        String str3 = "";
        if (uIInfo == null || (str = uIInfo.getPrice()) == null) {
            str = "";
        }
        reportParams.r(str);
        UIInfo uIInfo2 = this.mediumCardUIInfo;
        if (uIInfo2 == null || (str2 = uIInfo2.getTitle()) == null) {
            str2 = "";
        }
        reportParams.q(str2);
        UIInfo uIInfo3 = this.mediumCardUIInfo;
        if (uIInfo3 != null && (buttonText = uIInfo3.getButtonText()) != null) {
            str3 = buttonText;
        }
        reportParams.f(str3);
        Unit unit = Unit.INSTANCE;
        aVar.b(reportParams, ext);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        Companion companion = INSTANCE;
        if (size > companion.f()) {
            cg0.a.b(this.TAG, "adjust width " + size + " to " + companion.f());
            size = companion.f();
            post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView$onMeasure$1
                @Override // java.lang.Runnable
                public final void run() {
                    View view;
                    View view2;
                    View view3;
                    View view4;
                    view = ECVideoFeedsGoodsCardView.this.mediumTitleContainerView;
                    view2 = ECVideoFeedsGoodsCardView.this.mediumTitleContainerView;
                    int paddingLeft = view2.getPaddingLeft();
                    view3 = ECVideoFeedsGoodsCardView.this.mediumTitleContainerView;
                    int paddingTop = view3.getPaddingTop();
                    int h16 = ECVideoFeedsGoodsCardView.INSTANCE.h();
                    view4 = ECVideoFeedsGoodsCardView.this.mediumTitleContainerView;
                    view.setPadding(paddingLeft, paddingTop, h16, view4.getPaddingBottom());
                }
            });
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), heightMeasureSpec);
    }

    public void onWrapperViewAppear(com.tencent.ecommerce.biz.consumer.report.b reportParams, Map<String, String> ext, ECContentInfo contentInfo) {
        String str;
        String str2;
        String buttonText;
        this.exposePositionMap.put(this.uiType, Long.valueOf(System.currentTimeMillis()));
        com.tencent.ecommerce.biz.consumer.report.a aVar = com.tencent.ecommerce.biz.consumer.report.a.f101632a;
        UIInfo uIInfo = this.mediumCardUIInfo;
        String str3 = "";
        if (uIInfo == null || (str = uIInfo.getPrice()) == null) {
            str = "";
        }
        reportParams.r(str);
        UIInfo uIInfo2 = this.mediumCardUIInfo;
        if (uIInfo2 == null || (str2 = uIInfo2.getTitle()) == null) {
            str2 = "";
        }
        reportParams.q(str2);
        UIInfo uIInfo3 = this.mediumCardUIInfo;
        if (uIInfo3 != null && (buttonText = uIInfo3.getButtonText()) != null) {
            str3 = buttonText;
        }
        reportParams.f(str3);
        reportParams.s(com.tencent.ecommerce.biz.util.b.a(contentInfo.getIsContinuation()));
        Unit unit = Unit.INSTANCE;
        aVar.d(reportParams, ext);
    }

    public void onWrapperViewDisappear(int uiType, com.tencent.ecommerce.biz.consumer.report.b reportParams, Map<String, String> ext) {
        String str;
        String str2;
        String buttonText;
        long currentTimeMillis = this.exposePositionMap.get(uiType) != null ? System.currentTimeMillis() - this.exposePositionMap.get(uiType).longValue() : -1L;
        this.exposePositionMap.remove(uiType);
        com.tencent.ecommerce.biz.consumer.report.a aVar = com.tencent.ecommerce.biz.consumer.report.a.f101632a;
        UIInfo uIInfo = this.mediumCardUIInfo;
        String str3 = "";
        if (uIInfo == null || (str = uIInfo.getPrice()) == null) {
            str = "";
        }
        reportParams.r(str);
        UIInfo uIInfo2 = this.mediumCardUIInfo;
        if (uIInfo2 == null || (str2 = uIInfo2.getTitle()) == null) {
            str2 = "";
        }
        reportParams.q(str2);
        UIInfo uIInfo3 = this.mediumCardUIInfo;
        if (uIInfo3 != null && (buttonText = uIInfo3.getButtonText()) != null) {
            str3 = buttonText;
        }
        reportParams.f(str3);
        reportParams.l(currentTimeMillis);
        Unit unit = Unit.INSTANCE;
        aVar.c(reportParams, ext);
        a aVar2 = this.ecAnimationSet;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    public void p(ECContentInfo contentInfo, UIInfo uiInfo) {
        String buttonText;
        this.smallCardUIInfo = uiInfo;
        this.smallTitleView.setText(uiInfo.getTitle());
        Companion companion = INSTANCE;
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(getContext(), uiInfo.getPicUrl(), this.smallImageView, new IECImageLoader.ImageLoaderOption(companion.i(), companion.i(), 0, null, null, ResourcesCompat.getDrawable(getResources(), R.drawable.dhv, null), false, false, null, com.tencent.luggage.wxa.j2.c.CTRL_INDEX, null));
        TextView textView = this.smallTipsTextView;
        if (uiInfo.getButtonText().length() == 0) {
            buttonText = "\u8d2d\u7269";
        } else {
            buttonText = uiInfo.getButtonText();
        }
        textView.setText(buttonText);
        this.smallCardLayout.setOnClickListener(new d(uiInfo));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Function0<Unit> q() {
        return this.delayTaskDoAfterAnimToMeduim;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: r, reason: from getter */
    public final TextView getMediumActivityPromotionTextView() {
        return this.mediumActivityPromotionTextView;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void resetToSmallCardIfNeed(int uiType) {
        if (this.smallCardUIInfo != null) {
            if (this.originUIType == I() || uiType == 10302) {
                this.smallCardLayout.setVisibility(0);
                this.smallCardLayout.setAlpha(1.0f);
                this.smallTitleView.setVisibility(0);
                this.mediumCardLayout.setVisibility(8);
                this.uiType = I();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: s, reason: from getter */
    public final LinearLayout getMediumActivityTagLayout() {
        return this.mediumActivityTagLayout;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void setCloseClickEventListener(View.OnClickListener animStartListener, View.OnClickListener animEndListener) {
        this.onCloseAnimStartListener = animStartListener;
        this.onCloseAnimEndListener = animEndListener;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void setGoodsCardClickListener(IECGoodsCardView.IGoodsCardClickListener listener) {
        this.onClickEventListener = listener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: t, reason: from getter */
    public final TextView getMediumActivityTagTextView() {
        return this.mediumActivityTagTextView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: u, reason: from getter */
    public final TextView getMediumActivityTimeTextView() {
        return this.mediumActivityTimeTextView;
    }

    public void updateUIByType(int uiType) {
        this.originUIType = this.uiType;
        this.uiType = uiType;
        cg0.a.b(this.TAG, "updateUIByType originUIType=" + this.originUIType + " uiType=" + uiType);
        if (N(uiType)) {
            this.smallCardLayout.setVisibility(0);
            this.mediumCardLayout.setVisibility(8);
        } else if (M(uiType)) {
            if (N(this.originUIType)) {
                this.mediumCardLayout.setVisibility(4);
                T();
            } else {
                this.smallCardLayout.setVisibility(8);
                this.mediumCardLayout.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: v, reason: from getter */
    public final Button getMediumBuyButton() {
        return this.mediumBuyButton;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: w, reason: from getter */
    public final ImageView getMediumCardForegroundImageView() {
        return this.mediumCardForegroundImageView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: x, reason: from getter */
    public final View getMediumCardLayout() {
        return this.mediumCardLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: y, reason: from getter */
    public final UIInfo getMediumCardUIInfo() {
        return this.mediumCardUIInfo;
    }

    protected int z() {
        return 600;
    }

    private final void T() {
        this.isAnimingSmallToMeduim = true;
        this.delayTaskDoAfterAnimToMeduim = null;
        post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView$startAnimationChangeToMediumCard$1
            @Override // java.lang.Runnable
            public final void run() {
                a.C0035a a16;
                a.C0035a a17;
                a.C0035a a18;
                View view;
                View view2;
                View view3;
                View view4;
                ImageView imageView;
                ImageView imageView2;
                a.C0035a a19;
                String activityMaskUrl;
                ImageView imageView3;
                ImageView imageView4;
                ECVideoFeedsGoodsCardView.this.getMediumCardLayout().setVisibility(0);
                ECVideoFeedsGoodsCardView.this.U();
                ECVideoFeedsGoodsCardView.this.getMediumTitleView().getLocationInWindow(new int[2]);
                ECVideoFeedsGoodsCardView.this.getSmallTitleView().getLocationInWindow(new int[2]);
                ECVideoFeedsGoodsCardView.this.getSmallTitleView().setVisibility(8);
                ECVideoFeedsGoodsCardView eCVideoFeedsGoodsCardView = ECVideoFeedsGoodsCardView.this;
                a16 = r5.a(ECVideoFeedsGoodsCardView.this.getMediumBuyButton(), 0.0f, 1.0f, (r26 & 8) != 0 ? new a.C0035a(400L).duration : 200L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                a17 = a16.a(ECVideoFeedsGoodsCardView.this.getMediumActivityTagLayout(), 0.0f, 1.0f, (r26 & 8) != 0 ? a16.duration : 200L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                a18 = a17.a(ECVideoFeedsGoodsCardView.this.getMediumPriceTextView(), 0.0f, 1.0f, (r26 & 8) != 0 ? a17.duration : 200L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                view = ECVideoFeedsGoodsCardView.this.mediumCardBgView;
                float width = ECVideoFeedsGoodsCardView.this.getSmallCardLayout().getWidth();
                view2 = ECVideoFeedsGoodsCardView.this.mediumCardBgView;
                float width2 = width / view2.getWidth();
                float height = ECVideoFeedsGoodsCardView.this.getSmallCardLayout().getHeight();
                view3 = ECVideoFeedsGoodsCardView.this.mediumCardBgView;
                float height2 = height / view3.getHeight();
                view4 = ECVideoFeedsGoodsCardView.this.mediumCardBgView;
                float height3 = view4.getHeight();
                ECVideoFeedsGoodsCardView.Companion companion = ECVideoFeedsGoodsCardView.INSTANCE;
                a.C0035a j3 = a.C0035a.j(a.C0035a.f(a18, view, width2, 1.0f, height2, 1.0f, 0.0f, height3, 0L, false, companion.a(), null, 0L, 3488, null), ECVideoFeedsGoodsCardView.this.getMediumTitleView(), r1[0] - r3[0], r1[1] - r3[1], 0.0f, 0.0f, 0L, false, companion.b(), null, g.CTRL_INDEX, null);
                ImageView mediumImageView = ECVideoFeedsGoodsCardView.this.getMediumImageView();
                imageView = ECVideoFeedsGoodsCardView.this.smallImageView;
                float width3 = imageView.getWidth() / ECVideoFeedsGoodsCardView.this.getMediumImageView().getWidth();
                imageView2 = ECVideoFeedsGoodsCardView.this.smallImageView;
                a19 = r36.a(ECVideoFeedsGoodsCardView.this.getMediumImageView(), 0.0f, 1.0f, (r26 & 8) != 0 ? a.C0035a.f(j3, mediumImageView, width3, 1.0f, imageView2.getHeight() / ECVideoFeedsGoodsCardView.this.getMediumImageView().getHeight(), 1.0f, -ECVideoFeedsGoodsCardView.this.getMediumImageView().getLeft(), ECVideoFeedsGoodsCardView.this.getMediumImageView().getBottom(), 0L, false, companion.a(), null, 0L, 3456, null).duration : 200L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                UIInfo mediumCardUIInfo = ECVideoFeedsGoodsCardView.this.getMediumCardUIInfo();
                if (mediumCardUIInfo != null && (activityMaskUrl = mediumCardUIInfo.getActivityMaskUrl()) != null) {
                    if (activityMaskUrl.length() > 0) {
                        ImageView mediumCardForegroundImageView = ECVideoFeedsGoodsCardView.this.getMediumCardForegroundImageView();
                        imageView3 = ECVideoFeedsGoodsCardView.this.smallImageView;
                        float width4 = imageView3.getWidth() / ECVideoFeedsGoodsCardView.this.getMediumCardForegroundImageView().getWidth();
                        imageView4 = ECVideoFeedsGoodsCardView.this.smallImageView;
                        a.C0035a.f(a19, mediumCardForegroundImageView, width4, 1.0f, imageView4.getHeight() / ECVideoFeedsGoodsCardView.this.getMediumCardForegroundImageView().getHeight(), 1.0f, -ECVideoFeedsGoodsCardView.this.getMediumCardForegroundImageView().getLeft(), ECVideoFeedsGoodsCardView.this.getMediumCardForegroundImageView().getBottom(), 0L, false, companion.a(), null, 0L, 3456, null);
                        a19.a(ECVideoFeedsGoodsCardView.this.getMediumCardForegroundImageView(), 0.0f, 1.0f, (r26 & 8) != 0 ? a19.duration : 200L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                    }
                }
                Unit unit = Unit.INSTANCE;
                eCVideoFeedsGoodsCardView.ecAnimationSet = a19.d(new a()).c().b();
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/ECVideoFeedsGoodsCardView$startAnimationChangeToMediumCard$1$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static final class a implements Animator.AnimatorListener {
                a() {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    ECVideoFeedsGoodsCardView.this.O(false);
                    Function0<Unit> q16 = ECVideoFeedsGoodsCardView.this.q();
                    if (q16 != null) {
                        q16.invoke();
                    }
                    ECVideoFeedsGoodsCardView.this.P(null);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ECVideoFeedsGoodsCardView.this.O(false);
                    Function0<Unit> q16 = ECVideoFeedsGoodsCardView.this.q();
                    if (q16 != null) {
                        q16.invoke();
                    }
                    ECVideoFeedsGoodsCardView.this.P(null);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                }
            }
        });
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public View getView() {
        return this;
    }
}
