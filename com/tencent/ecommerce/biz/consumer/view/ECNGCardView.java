package com.tencent.ecommerce.biz.consumer.view;

import ah0.a;
import ah0.b;
import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewKt;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.videnevent.api.IECVideoControlDelegate;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.ECGoodsCommonUtils;
import com.tencent.ecommerce.biz.consumer.view.ECNGCardView;
import com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.bigcard.ECBigCardView;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.ecommerce.repo.consumer.resp.JumpInfo;
import com.tencent.ecommerce.repo.consumer.resp.UIInfo;
import com.tencent.luggage.wxa.rf.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00a3\u00012\u00020\u00012\u00020\u0002:\u0002\u00a4\u0001B\u0013\u0012\b\u0010\u00a0\u0001\u001a\u00030\u009f\u0001\u00a2\u0006\u0006\b\u00a1\u0001\u0010\u00a2\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J2\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J\u0012\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u0003H\u0002J \u0010 \u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010#\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0014J\u0010\u0010$\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J \u0010%\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010'\u001a\u00020&H\u0016J\n\u0010(\u001a\u0004\u0018\u00010&H\u0016J\b\u0010)\u001a\u00020\u0003H\u0016J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010+\u001a\u00020\u0003H\u0016J\b\u0010,\u001a\u00020\u0003H\u0016J\b\u0010-\u001a\u00020\u0003H\u0016J\b\u0010.\u001a\u00020\u0003H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\b\u00100\u001a\u00020\u0005H\u0016J\b\u00101\u001a\u00020\u0005H\u0016J\u0018\u00103\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u0014H\u0014J\u0018\u00104\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0012\u00108\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u000106H\u0016J\u001c\u0010;\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010\n2\b\u0010:\u001a\u0004\u0018\u00010\nH\u0016J,\u0010@\u001a\u00020\f2\u0006\u0010=\u001a\u00020<2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120>2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010A\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J,\u0010B\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010=\u001a\u00020<2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120>H\u0016J$\u0010C\u001a\u00020\f2\u0006\u0010=\u001a\u00020<2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120>H\u0016R\u001a\u0010H\u001a\u00020&8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0014\u0010J\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010ER\u0014\u0010M\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010O\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010ER\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010Y\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010ER\u001a\u0010\\\u001a\u00020&8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bZ\u0010E\u001a\u0004\b[\u0010GR\u0014\u0010^\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010ER\u0014\u0010`\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010ER\u0014\u0010b\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010LR\u001a\u0010e\u001a\u00020\u000e8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b \u0010L\u001a\u0004\bc\u0010dR\u001a\u0010h\u001a\u00020P8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b5\u0010R\u001a\u0004\bf\u0010gR\u001a\u0010j\u001a\u00020P8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b4\u0010R\u001a\u0004\bi\u0010gR\u0014\u0010l\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010LR\u001a\u0010n\u001a\u00020\u000e8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bm\u0010L\u001a\u0004\bm\u0010dR\u001a\u0010q\u001a\u00020T8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bi\u0010V\u001a\u0004\bo\u0010pR\u001a\u0010s\u001a\u00020&8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b.\u0010E\u001a\u0004\br\u0010GR\u0014\u0010t\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010RR\u001a\u0010v\u001a\u00020P8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b-\u0010R\u001a\u0004\bu\u0010gR\u0018\u0010y\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010xR\u0016\u0010z\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u00105R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u00105R\u0018\u0010}\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010|R&\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0013\n\u0004\bu\u0010|\u001a\u0004\b{\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0083\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0082\u0001\u0010FR\u0017\u0010\u0084\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010FR'\u0010\u0089\u0001\u001a\u00020\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0016\n\u0005\b\u0085\u0001\u00105\u001a\u0005\bk\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001e\u0010\u008d\u0001\u001a\n\u0012\u0005\u0012\u00030\u008b\u00010\u008a\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u001d\u0010\u008c\u0001R\u001b\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b3\u0010\u008f\u0001R*\u0010\u0096\u0001\u001a\u0004\u0018\u0001068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b\u0017\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001a\u0010\u0098\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0007\u0010\u0097\u0001R\u001f\u0010\u009b\u0001\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0006\u0010\u0099\u0001\u001a\u0006\b\u0085\u0001\u0010\u009a\u0001R\u001f\u0010\u009d\u0001\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b*\u0010\u0099\u0001\u001a\u0006\b\u009c\u0001\u0010\u009a\u0001R\u001f\u0010\u009e\u0001\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b0\u0010\u0099\u0001\u001a\u0006\b\u0082\u0001\u0010\u009a\u0001\u00a8\u0006\u00a5\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/ECNGCardView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView;", "", "uiType", "", "g0", "f0", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "Landroid/view/View$OnClickListener;", "onCloseClick", "", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lnh0/a;", "richModel", "", "richTitle", "", NodeProps.MAX_WIDTH, "tag", "e0", "q0", "o0", "p0", "n0", "length", "c0", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", "H", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "updateUIByType", "configCardUI", "Landroid/view/View;", "getView", "getBigView", "getUIType", "h0", "a0", "U", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "N", "j0", "i0", "k0", NodeProps.MARGIN_RIGHT, "d0", "J", "I", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "listener", "setGoodsCardClickListener", "animStartListener", "animEndListener", "setCloseClickEventListener", "Lcom/tencent/ecommerce/biz/consumer/report/b;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "ext", "onWrapperViewAppear", "resetToSmallCardIfNeed", "onWrapperViewDisappear", "onClickReport", "d", "Landroid/view/View;", "Z", "()Landroid/view/View;", "smallCardLayout", "e", "smallCardBgView", "f", "Landroid/view/ViewGroup;", "smallCardTitleLayout", h.F, "smallCardTitleContainerView", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "smallCardImageView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "smallCardTipsView", BdhLogUtil.LogTag.Tag_Conn, "smallCardDivisionView", "D", BdhLogUtil.LogTag.Tag_Req, "mediumCardLayout", "E", "mediumCardContainer", UserInfo.SEX_FEMALE, "mediumCardBgView", "G", "mediumCardTitleLayout", "P", "()Landroid/view/ViewGroup;", "mediumCardImageViewLayout", "O", "()Landroid/widget/ImageView;", "mediumCardImageView", "M", "mediumCardForegroundImageView", "K", "mediumCardSubTitleLayout", "L", "mediumCardBuyLayout", "getMediumCardBuyText", "()Landroid/widget/TextView;", "mediumCardBuyText", ExifInterface.LATITUDE_SOUTH, "mediumCardTitleContainerView", "mediumCardCloseView", "V", "mediumCardVideoImageView", "Lcom/tencent/ecommerce/biz/consumer/view/bigcard/ECBigCardView;", "Lcom/tencent/ecommerce/biz/consumer/view/bigcard/ECBigCardView;", "bigCardLayout", "originUIType", "T", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "smallCardUIInfo", "()Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "setMediumCardUIInfo", "(Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;)V", "mediumCardUIInfo", "W", "isMediumCardUIConfig", "isRichModelInit", "b0", "()I", "l0", "(I)V", "BIGCARD_TEXT_MARGIN_TO_LEFT", "Landroid/util/SparseArray;", "", "Landroid/util/SparseArray;", "exposePositionMap", "Lah0/a;", "Lah0/a;", "ecAnimationSet", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "Y", "()Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "setOnClickEventListener", "(Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;)V", "onClickEventListener", "Landroid/view/View$OnClickListener;", "onCloseClickEventListener", "Lkotlin/Lazy;", "()Lnh0/a;", "smallRichTitleModel", "X", "mediumRichTitleModel", "mediumRichSubTitleModel", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "x0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public class ECNGCardView extends FrameLayout implements IECGoodsCardView {

    /* renamed from: j0, reason: collision with root package name */
    private static final Lazy f101685j0;

    /* renamed from: k0, reason: collision with root package name */
    private static final Lazy f101686k0;

    /* renamed from: l0, reason: collision with root package name */
    private static final Lazy f101687l0;

    /* renamed from: m0, reason: collision with root package name */
    private static final Lazy f101688m0;

    /* renamed from: n0, reason: collision with root package name */
    private static final Lazy f101689n0;

    /* renamed from: o0, reason: collision with root package name */
    private static final Lazy f101690o0;

    /* renamed from: p0, reason: collision with root package name */
    private static final Lazy f101691p0;

    /* renamed from: q0, reason: collision with root package name */
    private static final Lazy f101692q0;

    /* renamed from: r0, reason: collision with root package name */
    private static final Lazy f101693r0;

    /* renamed from: s0, reason: collision with root package name */
    private static final Lazy f101694s0;

    /* renamed from: t0, reason: collision with root package name */
    private static final Lazy f101695t0;

    /* renamed from: u0, reason: collision with root package name */
    private static final ah0.b f101696u0;

    /* renamed from: v0, reason: collision with root package name */
    private static final ah0.b f101697v0;

    /* renamed from: w0, reason: collision with root package name */
    private static final ah0.b f101698w0;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final View smallCardDivisionView;

    /* renamed from: D, reason: from kotlin metadata */
    private final View mediumCardLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private final View mediumCardContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private final View mediumCardBgView;

    /* renamed from: G, reason: from kotlin metadata */
    private final ViewGroup mediumCardTitleLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private final ViewGroup mediumCardImageViewLayout;

    /* renamed from: I, reason: from kotlin metadata */
    private final ImageView mediumCardImageView;

    /* renamed from: J, reason: from kotlin metadata */
    private final ImageView mediumCardForegroundImageView;

    /* renamed from: K, reason: from kotlin metadata */
    private final ViewGroup mediumCardSubTitleLayout;

    /* renamed from: L, reason: from kotlin metadata */
    private final ViewGroup mediumCardBuyLayout;

    /* renamed from: M, reason: from kotlin metadata */
    private final TextView mediumCardBuyText;

    /* renamed from: N, reason: from kotlin metadata */
    private final View mediumCardTitleContainerView;

    /* renamed from: P, reason: from kotlin metadata */
    private final ImageView mediumCardCloseView;

    /* renamed from: Q, reason: from kotlin metadata */
    private final ImageView mediumCardVideoImageView;

    /* renamed from: R, reason: from kotlin metadata */
    private ECBigCardView bigCardLayout;

    /* renamed from: S, reason: from kotlin metadata */
    private int originUIType;

    /* renamed from: T, reason: from kotlin metadata */
    private int uiType;

    /* renamed from: U, reason: from kotlin metadata */
    private UIInfo smallCardUIInfo;

    /* renamed from: V, reason: from kotlin metadata */
    private UIInfo mediumCardUIInfo;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isMediumCardUIConfig;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean isRichModelInit;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int BIGCARD_TEXT_MARGIN_TO_LEFT;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final SparseArray<Long> exposePositionMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View smallCardLayout;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private a ecAnimationSet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View smallCardBgView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private IECGoodsCardView.IGoodsCardClickListener onClickEventListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup smallCardTitleLayout;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener onCloseClickEventListener;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private final Lazy smallRichTitleModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final View smallCardTitleContainerView;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final Lazy mediumRichTitleModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ImageView smallCardImageView;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private final Lazy mediumRichSubTitleModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final TextView smallCardTipsView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b7\u00108R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0010\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001b\u0010\u0013\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001b\u0010\u0016\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001b\u0010\u0019\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001b\u0010\u001c\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001b\u0010\u001f\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001b\u0010\"\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001b\u0010%\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u0017\u0010'\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010+\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b+\u0010(\u001a\u0004\b,\u0010*R\u0017\u0010-\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010*R\u0014\u00100\u001a\u00020/8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u00020/8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b5\u00101R\u0014\u00106\u001a\u0002028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b6\u00104\u00a8\u00069"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/ECNGCardView$a;", "", "", "MAX_WIDTH$delegate", "Lkotlin/Lazy;", "i", "()I", "MAX_WIDTH", "COVER_IMAGE_SIZE$delegate", h.F, "COVER_IMAGE_SIZE", "COVER_IMAGE_HEIGHT_SIZE_54$delegate", "g", "COVER_IMAGE_HEIGHT_SIZE_54", "CART_IMAGE_SIZE$delegate", "f", "CART_IMAGE_SIZE", "ONE_WORD_WIDTH$delegate", "l", "ONE_WORD_WIDTH", "SMALLCARD_TEXT_MARGIN_TO_LEFT$delegate", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "SMALLCARD_TEXT_MARGIN_TO_LEFT", "SMALLCARD_TEXT_MARGIN_TO_RIGHT$delegate", DomainData.DOMAIN_NAME, "SMALLCARD_TEXT_MARGIN_TO_RIGHT", "BIGCARD_TEXT_MARGIN_TO_RIGHT$delegate", "e", "BIGCARD_TEXT_MARGIN_TO_RIGHT", "BIGCARD_CLOSE_IMAGEVIEW_MARGIN_TO_RIGHT$delegate", "d", "BIGCARD_CLOSE_IMAGEVIEW_MARGIN_TO_RIGHT", "MEDIUMCARD_VIDEO_VIEW_HEIGHT$delegate", "k", "MEDIUMCARD_VIDEO_VIEW_HEIGHT", "MEDIUMCARD_VIDEO_MARGIN$delegate", "j", "MEDIUMCARD_VIDEO_MARGIN", "Lah0/b;", "BEZIER_INTERPOLATOR_TRANSLATION", "Lah0/b;", "b", "()Lah0/b;", "BEZIER_INTERPOLATOR_SCALE", "a", "BEZIER_WEAKEN_INTERPOLATOR_TRANSLATION", "c", "", "ANIMATION_DURATION", "J", "", "BUTTON_DEFAULT_COLOR", "Ljava/lang/String;", "HALF_ANIMATION_DURATION", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ah0.b a() {
            return ECNGCardView.f101697v0;
        }

        public final ah0.b b() {
            return ECNGCardView.f101696u0;
        }

        public final ah0.b c() {
            return ECNGCardView.f101698w0;
        }

        public final int d() {
            return ((Number) ECNGCardView.f101693r0.getValue()).intValue();
        }

        public final int e() {
            return ((Number) ECNGCardView.f101692q0.getValue()).intValue();
        }

        public final int f() {
            return ((Number) ECNGCardView.f101688m0.getValue()).intValue();
        }

        public final int g() {
            return ((Number) ECNGCardView.f101687l0.getValue()).intValue();
        }

        public final int h() {
            return ((Number) ECNGCardView.f101686k0.getValue()).intValue();
        }

        public final int i() {
            return ((Number) ECNGCardView.f101685j0.getValue()).intValue();
        }

        public final int j() {
            return ((Number) ECNGCardView.f101695t0.getValue()).intValue();
        }

        public final int k() {
            return ((Number) ECNGCardView.f101694s0.getValue()).intValue();
        }

        public final int l() {
            return ((Number) ECNGCardView.f101689n0.getValue()).intValue();
        }

        public final int m() {
            return ((Number) ECNGCardView.f101690o0.getValue()).intValue();
        }

        public final int n() {
            return ((Number) ECNGCardView.f101691p0.getValue()).intValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/consumer/view/ECNGCardView$configBigCardUI$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f101715d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECNGCardView f101716e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f101717f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ECContentInfo f101718h;

        b(View.OnClickListener onClickListener, ECNGCardView eCNGCardView, Ref.ObjectRef objectRef, ECContentInfo eCContentInfo) {
            this.f101715d = onClickListener;
            this.f101716e = eCNGCardView;
            this.f101717f = objectRef;
            this.f101718h = eCContentInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f101716e.m0(this.f101718h, this.f101715d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101720e;

        c(UIInfo uIInfo) {
            this.f101720e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECNGCardView.this.getMediumCardLayout().setTag(R.id.ntd, 1);
            IECGoodsCardView.IGoodsCardClickListener onClickEventListener = ECNGCardView.this.getOnClickEventListener();
            if (onClickEventListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(onClickEventListener, ECNGCardView.this.getMediumCardLayout(), null, this.f101720e.getJumpInfoArray(), 2, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECNGCardView.this.o0();
            View.OnClickListener onClickListener = ECNGCardView.this.onCloseClickEventListener;
            if (onClickListener != null) {
                onClickListener.onClick(ECNGCardView.this.mediumCardCloseView);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101723e;

        e(UIInfo uIInfo) {
            this.f101723e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECNGCardView.this.getMediumCardBuyLayout().setTag(R.id.ntd, 2);
            IECGoodsCardView.IGoodsCardClickListener onClickEventListener = ECNGCardView.this.getOnClickEventListener();
            if (onClickEventListener != null) {
                ViewGroup mediumCardBuyLayout = ECNGCardView.this.getMediumCardBuyLayout();
                ArrayList<JumpInfo> buttonJumpInfoArray = this.f101723e.getButtonJumpInfoArray();
                if (buttonJumpInfoArray.isEmpty()) {
                    buttonJumpInfoArray = this.f101723e.getJumpInfoArray();
                }
                IECGoodsCardView.IGoodsCardClickListener.a.a(onClickEventListener, mediumCardBuyLayout, null, buttonJumpInfoArray, 2, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101725e;

        f(UIInfo uIInfo) {
            this.f101725e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECNGCardView.this.getSmallCardLayout().setTag(R.id.ntd, 1);
            IECGoodsCardView.IGoodsCardClickListener onClickEventListener = ECNGCardView.this.getOnClickEventListener();
            if (onClickEventListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(onClickEventListener, ECNGCardView.this.getSmallCardLayout(), null, this.f101725e.getJumpInfoArray(), 2, null);
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
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$Companion$MAX_WIDTH$2
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
                cg0.a.a("ECNGCardView", "MAX_WIDTH", "getScreenWidth is zero");
                return Integer.MAX_VALUE;
            }
        });
        f101685j0 = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$Companion$COVER_IMAGE_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(36.0f);
            }
        });
        f101686k0 = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$Companion$COVER_IMAGE_HEIGHT_SIZE_54$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(54.0f);
            }
        });
        f101687l0 = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$Companion$CART_IMAGE_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(24.0f);
            }
        });
        f101688m0 = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$Companion$ONE_WORD_WIDTH$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(12.0f);
            }
        });
        f101689n0 = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$Companion$SMALLCARD_TEXT_MARGIN_TO_LEFT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(57.0f);
            }
        });
        f101690o0 = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$Companion$SMALLCARD_TEXT_MARGIN_TO_RIGHT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(20.0f);
            }
        });
        f101691p0 = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$Companion$BIGCARD_TEXT_MARGIN_TO_RIGHT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(96.0f);
            }
        });
        f101692q0 = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$Companion$BIGCARD_CLOSE_IMAGEVIEW_MARGIN_TO_RIGHT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(21.6f);
            }
        });
        f101693r0 = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$Companion$MEDIUMCARD_VIDEO_VIEW_HEIGHT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(62.0f);
            }
        });
        f101694s0 = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$Companion$MEDIUMCARD_VIDEO_MARGIN$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(4.0f);
            }
        });
        f101695t0 = lazy11;
        f101696u0 = new ah0.b(0.32f, 0.94f, 0.6f, 1.0f);
        f101697v0 = new ah0.b(0.26f, 1.0f, 0.48f, 1.0f);
        f101698w0 = new ah0.b(0.48f, 0.04f, 0.52f, 0.96f);
    }

    public ECNGCardView(Context context) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        this.originUIType = -1;
        this.uiType = -1;
        this.BIGCARD_TEXT_MARGIN_TO_LEFT = com.tencent.ecommerce.biz.util.e.c(52.0f);
        this.exposePositionMap = new SparseArray<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<nh0.a>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$smallRichTitleModel$2
            @Override // kotlin.jvm.functions.Function0
            public final nh0.a invoke() {
                return new nh0.a(false, 1, null);
            }
        });
        this.smallRichTitleModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<nh0.a>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$mediumRichTitleModel$2
            @Override // kotlin.jvm.functions.Function0
            public final nh0.a invoke() {
                return new nh0.a(false, 1, null);
            }
        });
        this.mediumRichTitleModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<nh0.a>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$mediumRichSubTitleModel$2
            @Override // kotlin.jvm.functions.Function0
            public final nh0.a invoke() {
                return new nh0.a(false, 1, null);
            }
        });
        this.mediumRichSubTitleModel = lazy3;
        com.tencent.ecommerce.base.device.a.f100685b.f(context, LayoutInflater.from(context).inflate(R.layout.csb, (ViewGroup) this, true));
        this.smallCardImageView = (ImageView) findViewById(R.id.oak);
        View findViewById = findViewById(R.id.oao);
        this.smallCardLayout = findViewById;
        this.smallCardTitleLayout = (ViewGroup) findViewById(R.id.oav);
        this.smallCardTipsView = (TextView) findViewById(R.id.oal);
        this.smallCardBgView = findViewById(R.id.oat);
        this.smallCardDivisionView = findViewById(R.id.oau);
        this.smallCardTitleContainerView = findViewById(R.id.oaw);
        this.mediumCardImageViewLayout = (ViewGroup) findViewById(R.id.o4m);
        this.mediumCardImageView = (ImageView) findViewById(R.id.o4l);
        this.mediumCardForegroundImageView = (ImageView) findViewById(R.id.o4k);
        View findViewById2 = findViewById(R.id.o4n);
        this.mediumCardLayout = findViewById2;
        this.mediumCardBgView = findViewById(R.id.o4d);
        this.mediumCardTitleLayout = (ViewGroup) findViewById(R.id.o4q);
        this.mediumCardSubTitleLayout = (ViewGroup) findViewById(R.id.o4p);
        this.mediumCardBuyLayout = (ViewGroup) findViewById(R.id.o4f);
        this.mediumCardBuyText = (TextView) findViewById(R.id.o4g);
        this.mediumCardTitleContainerView = findViewById(R.id.o4u);
        this.mediumCardCloseView = (ImageView) findViewById(R.id.o4h);
        this.mediumCardContainer = findViewById(R.id.o4i);
        this.mediumCardVideoImageView = (ImageView) findViewById(R.id.o4w);
        findViewById.setVisibility(8);
        findViewById2.setVisibility(8);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.tencent.ecommerce.biz.consumer.view.ECNGCardView$b] */
    private final void H(ECContentInfo contentInfo, UIInfo uiInfo, int uiType) {
        if (this.bigCardLayout == null) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            this.bigCardLayout = new ECBigCardView(getContext(), contentInfo);
            View.OnClickListener onClickListener = this.onCloseClickEventListener;
            if (onClickListener != null) {
                objectRef.element = new b(onClickListener, this, objectRef, contentInfo);
            }
            ECBigCardView eCBigCardView = this.bigCardLayout;
            if (eCBigCardView != null) {
                eCBigCardView.setVisibility(8);
            }
            ECBigCardView eCBigCardView2 = this.bigCardLayout;
            if (eCBigCardView2 != null) {
                eCBigCardView2.o(uiType, uiInfo, this.onClickEventListener, (View.OnClickListener) objectRef.element);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final nh0.a W() {
        return (nh0.a) this.mediumRichSubTitleModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final nh0.a X() {
        return (nh0.a) this.mediumRichTitleModel.getValue();
    }

    private final nh0.a b0() {
        return (nh0.a) this.smallRichTitleModel.getValue();
    }

    private final int c0(int length) {
        return INSTANCE.l() * length;
    }

    private final void e0(final ViewGroup parent, final nh0.a richModel, final String richTitle, final float maxWidth, String tag) {
        cg0.a.b("ECNGCardView", "initRichLayout tag:" + tag + " maxWidth:" + maxWidth);
        if (TextUtils.isEmpty(richTitle)) {
            cg0.a.b("ECNGCardView", "initRichLayout return by richTitle null ,tag:" + tag + " maxWidth:" + maxWidth);
            return;
        }
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$initSmallRichModelOnSubThread$1
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
                nh0.a.d(richModel, new JSONObject(richTitle), maxWidth, 0, 4, null);
                ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$initSmallRichModelOnSubThread$1.1
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
                        ECNGCardView$initSmallRichModelOnSubThread$1 eCNGCardView$initSmallRichModelOnSubThread$1 = ECNGCardView$initSmallRichModelOnSubThread$1.this;
                        View b16 = richModel.b(ECNGCardView.this.getContext());
                        if (b16 == null || parent.indexOfChild(b16) != -1) {
                            return;
                        }
                        parent.addView(b16);
                        cg0.a.b("ECNGCardView", "configRichTextUI richTitleView success");
                    }
                });
            }
        });
    }

    private final boolean f0(int uiType) {
        if (uiType != 10200 && uiType != 10201) {
            return false;
        }
        return true;
    }

    private final boolean g0(int uiType) {
        return uiType == U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(final ECContentInfo contentInfo, View.OnClickListener onCloseClick) {
        this.smallCardLayout.setVisibility(4);
        post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$startAnimBigChangeToSmall$1
            @Override // java.lang.Runnable
            public final void run() {
                View view;
                ECBigCardView eCBigCardView;
                View view2;
                View view3;
                ImageView imageView;
                ImageView imageView2;
                int[] iArr = new int[2];
                view = ECNGCardView.this.smallCardBgView;
                view.getLocationInWindow(iArr);
                eCBigCardView = ECNGCardView.this.bigCardLayout;
                if (eCBigCardView != null) {
                    view2 = ECNGCardView.this.smallCardBgView;
                    int width = view2.getWidth();
                    view3 = ECNGCardView.this.smallCardBgView;
                    int height = view3.getHeight();
                    imageView = ECNGCardView.this.smallCardImageView;
                    int width2 = imageView.getWidth();
                    imageView2 = ECNGCardView.this.smallCardImageView;
                    eCBigCardView.u(iArr, width, height, width2, imageView2.getHeight(), new a());
                }
                IECVideoControlDelegate videoControl = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVideoControl();
                if (videoControl != null) {
                    videoControl.sendVideoInfoViewShowEvent(contentInfo.getContentId(), true, true);
                }
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/ECNGCardView$startAnimBigChangeToSmall$1$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static final class a implements Animator.AnimatorListener {
                a() {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ECBigCardView eCBigCardView;
                    ECBigCardView eCBigCardView2;
                    ECNGCardView.this.getSmallCardLayout().setVisibility(0);
                    ECNGCardView.this.getMediumCardLayout().setVisibility(8);
                    eCBigCardView = ECNGCardView.this.bigCardLayout;
                    if (eCBigCardView != null) {
                        ViewKt.setVisible(eCBigCardView, false);
                    }
                    eCBigCardView2 = ECNGCardView.this.bigCardLayout;
                    if (eCBigCardView2 != null) {
                        eCBigCardView2.r();
                    }
                    ECNGCardView eCNGCardView = ECNGCardView.this;
                    eCNGCardView.uiType = eCNGCardView.a0();
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
        });
        onCloseClick.onClick(this.bigCardLayout);
    }

    private final void n0() {
        ECBigCardView eCBigCardView = this.bigCardLayout;
        if (eCBigCardView != null) {
            eCBigCardView.setVisibility(4);
        }
        final int[] iArr = new int[2];
        this.mediumCardBgView.getLocationInWindow(iArr);
        final int[] iArr2 = new int[2];
        this.mediumCardBuyLayout.getLocationInWindow(iArr2);
        this.mediumCardBuyText.getLocationInWindow(new int[2]);
        final int[] iArr3 = new int[2];
        this.mediumCardTitleLayout.getLocationInWindow(iArr3);
        post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$startAnimMediumChangeToBig$1
            @Override // java.lang.Runnable
            public final void run() {
                ECBigCardView eCBigCardView2;
                ECBigCardView eCBigCardView3;
                View view;
                View view2;
                int i3;
                ECNGCardView.this.getMediumCardLayout().setVisibility(4);
                eCBigCardView2 = ECNGCardView.this.bigCardLayout;
                if (eCBigCardView2 != null) {
                    eCBigCardView2.setVisibility(0);
                }
                eCBigCardView3 = ECNGCardView.this.bigCardLayout;
                if (eCBigCardView3 != null) {
                    view = ECNGCardView.this.mediumCardBgView;
                    int width = view.getWidth();
                    view2 = ECNGCardView.this.mediumCardBgView;
                    int height = view2.getHeight();
                    int width2 = ECNGCardView.this.getMediumCardImageView().getWidth();
                    int height2 = ECNGCardView.this.getMediumCardImageView().getHeight();
                    int width3 = ECNGCardView.this.getMediumCardBuyLayout().getWidth();
                    int height3 = ECNGCardView.this.getMediumCardBuyLayout().getHeight();
                    int[] iArr4 = iArr2;
                    int[] iArr5 = iArr;
                    int[] iArr6 = iArr3;
                    boolean z16 = ECNGCardView.this.getMediumCardBuyLayout().getVisibility() == 0;
                    i3 = ECNGCardView.this.originUIType;
                    eCBigCardView3.v(width, height, width2, height2, width3, height3, iArr4, iArr5, iArr6, z16, i3, ECNGCardView.this.getUiType(), new a());
                }
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/ECNGCardView$startAnimMediumChangeToBig$1$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static final class a implements Animator.AnimatorListener {
                a() {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ECNGCardView.this.getMediumCardLayout().setVisibility(8);
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
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0() {
        this.smallCardLayout.setVisibility(0);
        this.smallCardLayout.setAlpha(0.0f);
        post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$startAnimMediumChangeToSmall$1
            @Override // java.lang.Runnable
            public final void run() {
                ViewGroup viewGroup;
                ViewGroup viewGroup2;
                ImageView imageView;
                TextView textView;
                View view;
                a.C0035a a16;
                ImageView imageView2;
                a.C0035a a17;
                a.C0035a a18;
                View view2;
                View view3;
                View view4;
                float height;
                View view5;
                b a19;
                TextView textView2;
                ViewGroup viewGroup3;
                String activityMaskUrl;
                View view6;
                ImageView imageView3;
                ECNGCardView.this.getSmallCardLayout().setAlpha(1.0f);
                viewGroup = ECNGCardView.this.mediumCardTitleLayout;
                viewGroup.getLocationOnScreen(new int[2]);
                viewGroup2 = ECNGCardView.this.smallCardTitleLayout;
                viewGroup2.getLocationOnScreen(new int[2]);
                int[] iArr = new int[2];
                imageView = ECNGCardView.this.smallCardImageView;
                imageView.getLocationInWindow(iArr);
                int[] iArr2 = new int[2];
                ECNGCardView.this.getMediumCardImageView().getLocationInWindow(iArr2);
                textView = ECNGCardView.this.smallCardTipsView;
                textView.getLocationInWindow(new int[2]);
                ECNGCardView eCNGCardView = ECNGCardView.this;
                a.C0035a c0035a = new a.C0035a(400L);
                view = ECNGCardView.this.smallCardDivisionView;
                a16 = c0035a.a(view, 0.0f, 1.0f, (r26 & 8) != 0 ? c0035a.duration : 200L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                imageView2 = ECNGCardView.this.smallCardImageView;
                a17 = a16.a(imageView2, 0.0f, 1.0f, (r26 & 8) != 0 ? a16.duration : 200L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                a18 = a17.a(ECNGCardView.this.mediumCardCloseView, 1.0f, 0.0f, (r26 & 8) != 0 ? a17.duration : 1L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                view2 = ECNGCardView.this.mediumCardBgView;
                float width = ECNGCardView.this.getSmallCardLayout().getWidth();
                view3 = ECNGCardView.this.mediumCardBgView;
                float width2 = width / view3.getWidth();
                float height2 = ECNGCardView.this.getSmallCardLayout().getHeight();
                view4 = ECNGCardView.this.mediumCardBgView;
                height = height2 / view4.getHeight();
                view5 = ECNGCardView.this.mediumCardBgView;
                float height3 = view5.getHeight();
                if (ECNGCardView.this.k0()) {
                    a19 = ECNGCardView.INSTANCE.c();
                } else {
                    a19 = ECNGCardView.INSTANCE.a();
                }
                a.C0035a f16 = a.C0035a.f(a18, view2, 1.0f, width2, 1.0f, height, 0.0f, height3, 0L, false, a19, new a(iArr, iArr2), 0L, 2464, null);
                if (ECNGCardView.this.i0()) {
                    imageView3 = ECNGCardView.this.smallCardImageView;
                    f16.a(imageView3, 0.0f, 1.0f, (r26 & 8) != 0 ? f16.duration : 400L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                }
                if (ECNGCardView.this.k0()) {
                    view6 = ECNGCardView.this.smallCardTitleContainerView;
                    a.C0035a.j(f16, view6, r2[0] - r1[0], r2[1] - r1[1], 0.0f, 0.0f, 0L, false, ECNGCardView.INSTANCE.c(), null, g.CTRL_INDEX, null);
                } else {
                    textView2 = ECNGCardView.this.smallCardTipsView;
                    f16.a(textView2, 0.0f, 1.0f, (r26 & 8) != 0 ? f16.duration : 200L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                    float bottom = ECNGCardView.this.getMediumCardImageView().getBottom();
                    ECNGCardView.Companion companion = ECNGCardView.INSTANCE;
                    a.C0035a.f(f16, ECNGCardView.this.getMediumCardImageView(), 1.0f, 0.0f, 1.0f, 0.0f, -ECNGCardView.this.getMediumCardImageView().getLeft(), bottom, 0L, false, companion.a(), null, 0L, 3456, null);
                    viewGroup3 = ECNGCardView.this.smallCardTitleLayout;
                    a.C0035a.j(f16, viewGroup3, r2[0] - r3[0], r2[1] - r3[1], 0.0f, 0.0f, 0L, false, companion.b(), null, g.CTRL_INDEX, null);
                    UIInfo mediumCardUIInfo = ECNGCardView.this.getMediumCardUIInfo();
                    if (mediumCardUIInfo != null && (activityMaskUrl = mediumCardUIInfo.getActivityMaskUrl()) != null) {
                        if (activityMaskUrl.length() > 0) {
                            a.C0035a.f(f16, ECNGCardView.this.getMediumCardForegroundImageView(), 1.0f, 0.0f, 1.0f, 0.0f, -ECNGCardView.this.getMediumCardForegroundImageView().getLeft(), ECNGCardView.this.getMediumCardForegroundImageView().getBottom(), 0L, false, companion.a(), null, 0L, 3456, null);
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
                eCNGCardView.ecAnimationSet = f16.c().b();
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/ECNGCardView$startAnimMediumChangeToSmall$1$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static final class a implements Animator.AnimatorListener {

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int[] f101733e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int[] f101734f;

                a(int[] iArr, int[] iArr2) {
                    this.f101733e = iArr;
                    this.f101734f = iArr2;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    View view;
                    ViewGroup viewGroup;
                    ViewGroup viewGroup2;
                    view = ECNGCardView.this.smallCardBgView;
                    view.setVisibility(0);
                    ECNGCardView.this.getMediumCardBuyLayout().setAlpha(1.0f);
                    viewGroup = ECNGCardView.this.mediumCardTitleLayout;
                    viewGroup.setAlpha(1.0f);
                    viewGroup2 = ECNGCardView.this.mediumCardSubTitleLayout;
                    viewGroup2.setAlpha(1.0f);
                    ECNGCardView.this.getMediumCardLayout().setVisibility(8);
                    ECNGCardView eCNGCardView = ECNGCardView.this;
                    eCNGCardView.uiType = eCNGCardView.a0();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    View view;
                    ViewGroup viewGroup;
                    ViewGroup viewGroup2;
                    String activityMaskUrl;
                    if (ECNGCardView.this.j0()) {
                        int i3 = this.f101733e[0];
                        int[] iArr = this.f101734f;
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, i3 - iArr[0], r1[1] - iArr[1]);
                        translateAnimation.setDuration(400L);
                        translateAnimation.setInterpolator(ECNGCardView.INSTANCE.c());
                        ECNGCardView.this.getMediumCardImageView().startAnimation(translateAnimation);
                        UIInfo mediumCardUIInfo = ECNGCardView.this.getMediumCardUIInfo();
                        if (mediumCardUIInfo != null && (activityMaskUrl = mediumCardUIInfo.getActivityMaskUrl()) != null) {
                            if (activityMaskUrl.length() > 0) {
                                ECNGCardView.this.getMediumCardForegroundImageView().startAnimation(translateAnimation);
                            }
                        }
                    }
                    view = ECNGCardView.this.smallCardBgView;
                    view.setVisibility(8);
                    ECNGCardView.this.getMediumCardBuyLayout().setAlpha(0.0f);
                    viewGroup = ECNGCardView.this.mediumCardTitleLayout;
                    viewGroup.setAlpha(0.0f);
                    viewGroup2 = ECNGCardView.this.mediumCardSubTitleLayout;
                    viewGroup2.setAlpha(0.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                }
            }
        });
    }

    private final void p0() {
        ECBigCardView eCBigCardView = this.bigCardLayout;
        if (eCBigCardView != null) {
            eCBigCardView.setVisibility(4);
        }
        final int[] iArr = new int[2];
        this.smallCardBgView.getLocationInWindow(iArr);
        post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$startAnimSmallChangeToBig$1
            @Override // java.lang.Runnable
            public final void run() {
                ECBigCardView eCBigCardView2;
                ECBigCardView eCBigCardView3;
                ImageView imageView;
                ImageView imageView2;
                View view;
                View view2;
                int i3;
                ECNGCardView.this.getSmallCardLayout().setVisibility(4);
                eCBigCardView2 = ECNGCardView.this.bigCardLayout;
                if (eCBigCardView2 != null) {
                    eCBigCardView2.setVisibility(0);
                }
                eCBigCardView3 = ECNGCardView.this.bigCardLayout;
                if (eCBigCardView3 != null) {
                    int[] iArr2 = iArr;
                    imageView = ECNGCardView.this.smallCardImageView;
                    int width = imageView.getWidth();
                    imageView2 = ECNGCardView.this.smallCardImageView;
                    int height = imageView2.getHeight();
                    view = ECNGCardView.this.smallCardBgView;
                    int width2 = view.getWidth();
                    view2 = ECNGCardView.this.smallCardBgView;
                    int height2 = view2.getHeight();
                    i3 = ECNGCardView.this.originUIType;
                    eCBigCardView3.w(iArr2, width, height, width2, height2, i3, ECNGCardView.this.getUiType(), new a());
                }
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/ECNGCardView$startAnimSmallChangeToBig$1$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static final class a implements Animator.AnimatorListener {
                a() {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ECNGCardView.this.getSmallCardLayout().setVisibility(8);
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
        });
    }

    private final void q0() {
        this.mediumCardLayout.setVisibility(4);
        post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$startAnimSmallChangeToMedium$1
            @Override // java.lang.Runnable
            public final void run() {
                ViewGroup viewGroup;
                ViewGroup viewGroup2;
                ImageView imageView;
                TextView textView;
                a.C0035a a16;
                a.C0035a a17;
                ViewGroup viewGroup3;
                a.C0035a a18;
                a.C0035a a19;
                View view;
                View view2;
                View view3;
                View view4;
                b a26;
                char c16;
                ViewGroup viewGroup4;
                ImageView imageView2;
                ImageView imageView3;
                String activityMaskUrl;
                ImageView imageView4;
                ImageView imageView5;
                ViewGroup viewGroup5;
                ECNGCardView.this.getMediumCardLayout().setVisibility(0);
                ECNGCardView.this.getSmallCardLayout().setVisibility(8);
                viewGroup = ECNGCardView.this.mediumCardTitleLayout;
                viewGroup.getLocationInWindow(new int[2]);
                viewGroup2 = ECNGCardView.this.smallCardTitleLayout;
                viewGroup2.getLocationInWindow(new int[2]);
                ECNGCardView.this.getMediumCardImageView().getLocationInWindow(new int[2]);
                imageView = ECNGCardView.this.smallCardImageView;
                imageView.getLocationInWindow(new int[2]);
                textView = ECNGCardView.this.smallCardTipsView;
                textView.getLocationInWindow(new int[2]);
                ECNGCardView eCNGCardView = ECNGCardView.this;
                a16 = r8.a(ECNGCardView.this.getMediumCardVideoImageView(), 0.0f, 1.0f, (r26 & 8) != 0 ? new a.C0035a(400L).duration : 200L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                a17 = a16.a(ECNGCardView.this.getMediumCardBuyLayout(), 0.0f, 1.0f, (r26 & 8) != 0 ? a16.duration : 200L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                viewGroup3 = ECNGCardView.this.mediumCardSubTitleLayout;
                a18 = a17.a(viewGroup3, 0.0f, 1.0f, (r26 & 8) != 0 ? a17.duration : 200L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                a19 = a18.a(ECNGCardView.this.mediumCardCloseView, 0.0f, 1.0f, (r26 & 8) != 0 ? a18.duration : 200L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                view = ECNGCardView.this.mediumCardBgView;
                float width = ECNGCardView.this.getSmallCardLayout().getWidth();
                view2 = ECNGCardView.this.mediumCardBgView;
                float width2 = width / view2.getWidth();
                float height = ECNGCardView.this.getSmallCardLayout().getHeight();
                view3 = ECNGCardView.this.mediumCardBgView;
                float height2 = height / view3.getHeight();
                view4 = ECNGCardView.this.mediumCardBgView;
                float height3 = view4.getHeight();
                if (ECNGCardView.this.k0()) {
                    a26 = ECNGCardView.INSTANCE.c();
                } else {
                    a26 = ECNGCardView.INSTANCE.a();
                }
                a.C0035a f16 = a.C0035a.f(a19, view, width2, 1.0f, height2, 1.0f, 0.0f, height3, 0L, false, a26, null, 0L, 3488, null);
                if (ECNGCardView.this.j0()) {
                    a.C0035a.j(f16, ECNGCardView.this.getMediumCardImageView(), r6[0] - r5[0], r6[1] - r5[1], 0.0f, 0.0f, 0L, false, ECNGCardView.INSTANCE.c(), null, g.CTRL_INDEX, null);
                }
                if (ECNGCardView.this.i0()) {
                    f16.a(ECNGCardView.this.getMediumCardImageView(), 0.0f, 1.0f, (r26 & 8) != 0 ? f16.duration : 400L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                }
                if (ECNGCardView.this.k0()) {
                    viewGroup5 = ECNGCardView.this.mediumCardTitleLayout;
                    a.C0035a.j(f16, viewGroup5, r1[0] - r3[0], r1[1] - r3[1], 0.0f, 0.0f, 0L, false, ECNGCardView.INSTANCE.c(), null, g.CTRL_INDEX, null);
                    c16 = 1;
                } else {
                    c16 = 1;
                    viewGroup4 = ECNGCardView.this.mediumCardTitleLayout;
                    a.C0035a.j(f16, viewGroup4, r4[0] - r3[0], r4[1] - r3[1], 0.0f, 0.0f, 0L, false, ECNGCardView.INSTANCE.b(), null, g.CTRL_INDEX, null);
                }
                Unit unit = Unit.INSTANCE;
                ImageView mediumCardImageView = ECNGCardView.this.getMediumCardImageView();
                imageView2 = ECNGCardView.this.smallCardImageView;
                float width3 = imageView2.getWidth() / ECNGCardView.this.getMediumCardImageView().getWidth();
                imageView3 = ECNGCardView.this.smallCardImageView;
                float bottom = ECNGCardView.this.getMediumCardImageView().getBottom();
                ECNGCardView.Companion companion = ECNGCardView.INSTANCE;
                a.C0035a f17 = a.C0035a.f(f16, mediumCardImageView, width3, 1.0f, imageView3.getHeight() / ECNGCardView.this.getMediumCardImageView().getHeight(), 1.0f, -ECNGCardView.this.getMediumCardImageView().getLeft(), bottom, 0L, false, companion.a(), null, 0L, 3456, null);
                UIInfo mediumCardUIInfo = ECNGCardView.this.getMediumCardUIInfo();
                if (mediumCardUIInfo != null && (activityMaskUrl = mediumCardUIInfo.getActivityMaskUrl()) != null) {
                    if ((activityMaskUrl.length() > 0 ? c16 : (char) 0) == c16) {
                        ImageView mediumCardForegroundImageView = ECNGCardView.this.getMediumCardForegroundImageView();
                        imageView4 = ECNGCardView.this.smallCardImageView;
                        float width4 = imageView4.getWidth() / ECNGCardView.this.getMediumCardForegroundImageView().getWidth();
                        imageView5 = ECNGCardView.this.smallCardImageView;
                        a.C0035a.f(f17, mediumCardForegroundImageView, width4, 1.0f, imageView5.getHeight() / ECNGCardView.this.getMediumCardForegroundImageView().getHeight(), 1.0f, -ECNGCardView.this.getMediumCardForegroundImageView().getLeft(), ECNGCardView.this.getMediumCardForegroundImageView().getBottom(), 0L, false, ECVideoFeedsGoodsCardView.INSTANCE.a(), null, 0L, 3456, null);
                        if (ECNGCardView.this.j0()) {
                            a.C0035a.j(f17, ECNGCardView.this.getMediumCardForegroundImageView(), r6[0] - r5[0], r6[c16] - r5[c16], 0.0f, 0.0f, 0L, false, companion.c(), null, g.CTRL_INDEX, null);
                        }
                        if (ECNGCardView.this.i0()) {
                            f17.a(ECNGCardView.this.getMediumCardForegroundImageView(), 0.0f, 1.0f, (r26 & 8) != 0 ? f17.duration : 400L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
                        }
                    }
                }
                eCNGCardView.ecAnimationSet = f17.c().b();
            }
        });
    }

    public void J(ECContentInfo contentInfo, UIInfo uiInfo) {
        this.smallCardUIInfo = uiInfo;
        Companion companion = INSTANCE;
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(getContext(), uiInfo.getPicUrl(), this.smallCardImageView, new IECImageLoader.ImageLoaderOption(companion.f(), companion.f(), 0, null, null, ResourcesCompat.getDrawable(getResources(), R.drawable.dhv, null), false, false, null, com.tencent.luggage.wxa.j2.c.CTRL_INDEX, null));
        this.smallCardTipsView.setText(uiInfo.getButtonText());
        e0(this.smallCardTitleLayout, b0(), uiInfo.getRichTitle(), companion.i() - ((companion.m() + c0(uiInfo.getButtonText().length())) + com.tencent.ecommerce.biz.util.e.c(8.0f)), "smallTitleView");
        this.smallCardLayout.setOnClickListener(new f(uiInfo));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: K, reason: from getter */
    public final int getBIGCARD_TEXT_MARGIN_TO_LEFT() {
        return this.BIGCARD_TEXT_MARGIN_TO_LEFT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: L, reason: from getter */
    public final ViewGroup getMediumCardBuyLayout() {
        return this.mediumCardBuyLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: M, reason: from getter */
    public final ImageView getMediumCardForegroundImageView() {
        return this.mediumCardForegroundImageView;
    }

    public int N() {
        return INSTANCE.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: O, reason: from getter */
    public final ImageView getMediumCardImageView() {
        return this.mediumCardImageView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: P, reason: from getter */
    public final ViewGroup getMediumCardImageViewLayout() {
        return this.mediumCardImageViewLayout;
    }

    public int Q() {
        return INSTANCE.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: R, reason: from getter */
    public final View getMediumCardLayout() {
        return this.mediumCardLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: S, reason: from getter */
    public final View getMediumCardTitleContainerView() {
        return this.mediumCardTitleContainerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: T, reason: from getter */
    public final UIInfo getMediumCardUIInfo() {
        return this.mediumCardUIInfo;
    }

    public int U() {
        return 10100;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: V, reason: from getter */
    public final ImageView getMediumCardVideoImageView() {
        return this.mediumCardVideoImageView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Y, reason: from getter */
    public final IECGoodsCardView.IGoodsCardClickListener getOnClickEventListener() {
        return this.onClickEventListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Z, reason: from getter */
    public final View getSmallCardLayout() {
        return this.smallCardLayout;
    }

    public int a0() {
        return 10000;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void configCardUI(ECContentInfo contentInfo, UIInfo uiInfo, int uiType) {
        if (h0(uiType)) {
            J(contentInfo, uiInfo);
        } else if (g0(uiType)) {
            I(contentInfo, uiInfo);
        } else if (f0(uiType)) {
            H(contentInfo, uiInfo, uiType);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d0(final UIInfo uiInfo, final float marginRight) {
        if (this.isRichModelInit) {
            cg0.a.b("ECNGCardView", "initRichModelOnSubThread return has init");
        } else {
            ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$initBigRichModelOnSubThread$1
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
                    nh0.a X;
                    nh0.a W;
                    cg0.a.b("ECNGCardView", "initRichModelOnSubThread richTitle:" + uiInfo.getRichTitle() + " , richSubTitle:" + uiInfo.getRichSubTitle());
                    if (TextUtils.isEmpty(uiInfo.getRichTitle()) || TextUtils.isEmpty(uiInfo.getRichSubTitle())) {
                        return;
                    }
                    float i3 = ECNGCardView.INSTANCE.i() - (ECNGCardView.this.getBIGCARD_TEXT_MARGIN_TO_LEFT() + marginRight);
                    JSONObject jSONObject = new JSONObject(uiInfo.getRichTitle());
                    X = ECNGCardView.this.X();
                    nh0.a.d(X, jSONObject, i3, 0, 4, null);
                    JSONObject jSONObject2 = new JSONObject(uiInfo.getRichSubTitle());
                    W = ECNGCardView.this.W();
                    nh0.a.d(W, jSONObject2, i3, 0, 4, null);
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECNGCardView$initBigRichModelOnSubThread$1.1
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
                            nh0.a X2;
                            nh0.a W2;
                            ViewGroup viewGroup;
                            ViewGroup viewGroup2;
                            ViewGroup viewGroup3;
                            ViewGroup viewGroup4;
                            cg0.a.b("ECNGCardView", "initRichModelOnSubThread addView start");
                            X2 = ECNGCardView.this.X();
                            View b16 = X2.b(ECNGCardView.this.getContext());
                            if (b16 != null) {
                                viewGroup3 = ECNGCardView.this.mediumCardTitleLayout;
                                if (viewGroup3.indexOfChild(b16) == -1) {
                                    viewGroup4 = ECNGCardView.this.mediumCardTitleLayout;
                                    viewGroup4.addView(b16);
                                    cg0.a.b("ECNGCardView", "initRichModelOnSubThread addView richTitleView success");
                                }
                            }
                            W2 = ECNGCardView.this.W();
                            View b17 = W2.b(ECNGCardView.this.getContext());
                            if (b17 != null) {
                                viewGroup = ECNGCardView.this.mediumCardSubTitleLayout;
                                if (viewGroup.indexOfChild(b17) == -1) {
                                    viewGroup2 = ECNGCardView.this.mediumCardSubTitleLayout;
                                    viewGroup2.addView(b17);
                                    cg0.a.b("ECNGCardView", "initRichModelOnSubThread addView richSubTitleView success");
                                }
                            }
                            cg0.a.b("ECNGCardView", "initRichModelOnSubThread addView richTitleView success");
                        }
                    });
                }
            });
            this.isRichModelInit = true;
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public View getBigView() {
        return this.bigCardLayout;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    /* renamed from: getUIType, reason: from getter */
    public int getUiType() {
        return this.uiType;
    }

    public boolean h0(int uiType) {
        return uiType == a0();
    }

    public boolean i0() {
        return true;
    }

    public boolean j0() {
        return false;
    }

    public boolean k0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l0(int i3) {
        this.BIGCARD_TEXT_MARGIN_TO_LEFT = i3;
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
        if (size > companion.i()) {
            cg0.a.b("ECNGCardView", "adjust width " + size + " to " + companion.i());
            size = companion.i();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), heightMeasureSpec);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
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

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
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

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void resetToSmallCardIfNeed(int uiType) {
        if (this.smallCardUIInfo != null) {
            if (this.originUIType == a0() || this.originUIType == U()) {
                this.smallCardLayout.setVisibility(0);
                this.smallCardLayout.setAlpha(1.0f);
                this.smallCardTitleLayout.setVisibility(0);
                this.mediumCardLayout.setVisibility(8);
                this.uiType = a0();
                ECBigCardView eCBigCardView = this.bigCardLayout;
                if (eCBigCardView != null) {
                    ViewKt.setVisible(eCBigCardView, false);
                }
            }
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void setCloseClickEventListener(View.OnClickListener animStartListener, View.OnClickListener animEndListener) {
        this.onCloseClickEventListener = animStartListener;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void setGoodsCardClickListener(IECGoodsCardView.IGoodsCardClickListener listener) {
        this.onClickEventListener = listener;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void updateUIByType(int uiType) {
        this.originUIType = this.uiType;
        this.uiType = uiType;
        if (h0(uiType)) {
            this.smallCardLayout.setVisibility(0);
            this.mediumCardLayout.setVisibility(8);
            ECBigCardView eCBigCardView = this.bigCardLayout;
            if (eCBigCardView != null) {
                ViewKt.setVisible(eCBigCardView, false);
                return;
            }
            return;
        }
        if (g0(uiType)) {
            if (h0(this.originUIType)) {
                q0();
                return;
            }
            this.smallCardLayout.setVisibility(8);
            this.mediumCardLayout.setVisibility(0);
            ECBigCardView eCBigCardView2 = this.bigCardLayout;
            if (eCBigCardView2 != null) {
                ViewKt.setVisible(eCBigCardView2, false);
                return;
            }
            return;
        }
        if (f0(uiType)) {
            if (h0(this.originUIType)) {
                p0();
                return;
            }
            if (g0(this.originUIType)) {
                n0();
                return;
            }
            this.smallCardLayout.setVisibility(8);
            this.mediumCardLayout.setVisibility(8);
            ECBigCardView eCBigCardView3 = this.bigCardLayout;
            if (eCBigCardView3 != null) {
                ViewKt.setVisible(eCBigCardView3, true);
            }
        }
    }

    public void I(ECContentInfo contentInfo, UIInfo uiInfo) {
        Boolean bool;
        String str;
        int n3;
        if (this.isMediumCardUIConfig) {
            return;
        }
        this.mediumCardUIInfo = uiInfo;
        ViewGroup.LayoutParams layoutParams = this.mediumCardImageViewLayout.getLayoutParams();
        layoutParams.width = Q();
        layoutParams.height = N();
        if (!TextUtils.isEmpty(uiInfo.getPicUrl())) {
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(getContext(), uiInfo.getPicUrl(), this.mediumCardImageView, new IECImageLoader.ImageLoaderOption(Q(), N(), 0, null, null, null, false, false, null, 508, null));
        }
        String activityMaskUrl = uiInfo.getActivityMaskUrl();
        if (activityMaskUrl != null) {
            bool = Boolean.valueOf(activityMaskUrl.length() > 0);
        } else {
            bool = null;
        }
        if (bool.booleanValue()) {
            this.mediumCardForegroundImageView.setVisibility(0);
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(getContext(), uiInfo.getActivityMaskUrl(), this.mediumCardForegroundImageView, new IECImageLoader.ImageLoaderOption(Q(), N(), 0, null, null, null, false, false, null, 508, null));
        }
        if (!TextUtils.isEmpty(uiInfo.getButtonText())) {
            this.mediumCardBuyText.setText(uiInfo.getButtonText());
        } else {
            this.mediumCardBuyLayout.setVisibility(8);
        }
        if (!TextUtils.isEmpty(uiInfo.getButtonBgColor())) {
            str = uiInfo.getButtonBgColor();
        } else {
            str = "linear-gradient(to right, #FF46A0 0%, #FF3355 100%)";
        }
        ECGoodsCommonUtils.f101579a.q(this.mediumCardBuyLayout, str);
        this.mediumCardLayout.setOnClickListener(new c(uiInfo));
        if (!TextUtils.isEmpty(uiInfo.getButtonText())) {
            n3 = INSTANCE.e();
        } else {
            n3 = INSTANCE.n();
        }
        if (uiInfo.getBackbuttonSwitch()) {
            this.mediumCardCloseView.setVisibility(0);
            this.mediumCardCloseView.setOnClickListener(new d());
            n3 += INSTANCE.d();
        }
        d0(uiInfo, n3);
        this.mediumCardBuyLayout.setOnClickListener(new e(uiInfo));
        this.isMediumCardUIConfig = true;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public View getView() {
        return this;
    }
}
