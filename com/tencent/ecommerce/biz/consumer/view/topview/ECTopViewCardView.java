package com.tencent.ecommerce.biz.consumer.view.topview;

import ah0.a;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.event.api.IECEventDispatcherDelegate;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.ECGoodsCommonUtils;
import com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsPrivatePolicyView;
import com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.IECPrivatePolicyView;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.repo.consumer.resp.ButtonInfo;
import com.tencent.ecommerce.repo.consumer.resp.GamePrivilegeInfo;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.ecommerce.repo.consumer.resp.UIInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONObject;
import org.libpag.PAGView;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b9\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001r\u0018\u0000 z2\u00020\u00012\u00020\u0002:\u0001{B\u000f\u0012\u0006\u0010w\u001a\u00020v\u00a2\u0006\u0004\bx\u0010yJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0017J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0016J,\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\t\u001a\u00020\bH\u0016J,\u0010\u0019\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J$\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u001c\u0010\u001f\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0016J\u000e\u0010\"\u001a\u00020\r2\u0006\u0010!\u001a\u00020 J\u0010\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H\u0002J\u0010\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0006H\u0002J \u0010+\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020\rH\u0002J\b\u0010-\u001a\u00020\rH\u0002J\b\u0010.\u001a\u00020\rH\u0002J\b\u0010/\u001a\u00020\rH\u0002J\b\u00100\u001a\u00020\rH\u0002J\b\u00101\u001a\u00020\rH\u0002J\b\u00102\u001a\u00020\rH\u0002J\b\u00103\u001a\u00020\rH\u0002J\b\u00104\u001a\u00020\rH\u0002J\b\u00105\u001a\u00020\rH\u0002J\u001a\u00108\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00062\b\b\u0002\u00107\u001a\u000206H\u0002R\u0016\u0010\f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b;\u0010:R\u0014\u0010>\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b=\u0010:R\u0014\u0010A\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010C\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u0014\u0010E\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010@R\u0014\u0010F\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010@R\u0014\u0010I\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010HR\u0014\u0010L\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010R\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010KR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010OR\u0018\u0010Z\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010:R\u0018\u0010_\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010b\u001a\u00020\u00168\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020d0c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010o\u001a\u00020l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010q\u001a\u00020l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010nR\u0014\u0010u\u001a\u00020r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bs\u0010t\u00a8\u0006|"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/topview/ECTopViewCardView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView;", "Landroid/view/View;", "getView", "getBigView", "", "getUIType", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", "uiType", "", "configCardUI", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "listener", "setGoodsCardClickListener", "updateUIByType", "Lcom/tencent/ecommerce/biz/consumer/report/b;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "", "ext", "onWrapperViewAppear", "onWrapperViewDisappear", "onClickReport", "resetToSmallCardIfNeed", "Landroid/view/View$OnClickListener;", "animStartListener", "animEndListener", "setCloseClickEventListener", "Llh0/b;", "event", "v", "Lcom/tencent/ecommerce/repo/consumer/resp/GamePrivilegeInfo;", "privilege", "", "p", "action", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "clickArea", "view", "w", "u", "E", BdhLogUtil.LogTag.Tag_Conn, "t", ReportConstant.COSTREPORT_PREFIX, "r", "B", "D", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lorg/json/JSONObject;", "param", HippyTKDListViewAdapter.X, "d", "I", "e", "entryStartColor", "f", "entryEndColor", tl.h.F, "Landroid/view/View;", "topViewCardLayout", "i", "topViewShadowLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "fadeShadowTop", "fadeShadowBottom", "Lcom/tencent/ecommerce/biz/consumer/view/IECPrivatePolicyView;", "Lcom/tencent/ecommerce/biz/consumer/view/IECPrivatePolicyView;", "topViewPrivatePolicyView", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "topViewPrivatePolicyViewLayout", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "topViewSkipTextView", "G", "topViewAnimationLayout", "Lorg/libpag/PAGView;", "H", "Lorg/libpag/PAGView;", "topViewAnimationView", "topViewEntry", "J", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "onClickEventListener", "K", "countDownCount", "L", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "currentUIInfo", "M", "Ljava/lang/String;", "defaultEntryButtonTxt", "Landroid/util/SparseArray;", "", "N", "Landroid/util/SparseArray;", "exposePositionMap", "Lah0/a;", "P", "Lah0/a;", "ecAnimationSet", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "[I", "goodsCardWH", BdhLogUtil.LogTag.Tag_Req, "goodsCardLoc", "com/tencent/ecommerce/biz/consumer/view/topview/ECTopViewCardView$g", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/biz/consumer/view/topview/ECTopViewCardView$g;", "handler", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "U", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECTopViewCardView extends FrameLayout implements IECGoodsCardView {

    /* renamed from: C, reason: from kotlin metadata */
    private final View fadeShadowBottom;

    /* renamed from: D, reason: from kotlin metadata */
    private final IECPrivatePolicyView topViewPrivatePolicyView;

    /* renamed from: E, reason: from kotlin metadata */
    private final ViewGroup topViewPrivatePolicyViewLayout;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView topViewSkipTextView;

    /* renamed from: G, reason: from kotlin metadata */
    private final ViewGroup topViewAnimationLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private PAGView topViewAnimationView;

    /* renamed from: I, reason: from kotlin metadata */
    private final TextView topViewEntry;

    /* renamed from: J, reason: from kotlin metadata */
    private IECGoodsCardView.IGoodsCardClickListener onClickEventListener;

    /* renamed from: K, reason: from kotlin metadata */
    private int countDownCount;

    /* renamed from: L, reason: from kotlin metadata */
    private UIInfo currentUIInfo;

    /* renamed from: M, reason: from kotlin metadata */
    private final String defaultEntryButtonTxt;

    /* renamed from: N, reason: from kotlin metadata */
    private final SparseArray<Long> exposePositionMap;

    /* renamed from: P, reason: from kotlin metadata */
    private a ecAnimationSet;

    /* renamed from: Q, reason: from kotlin metadata */
    private final int[] goodsCardWH;

    /* renamed from: R, reason: from kotlin metadata */
    private final int[] goodsCardLoc;

    /* renamed from: S, reason: from kotlin metadata */
    private final g handler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int uiType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int entryStartColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int entryEndColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final View topViewCardLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final View topViewShadowLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final View fadeShadowTop;
    private static final ah0.b T = new ah0.b(0.5f, 0.0f, 0.5f, 1.0f);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101853e;

        b(UIInfo uIInfo) {
            this.f101853e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.f101853e.getAction() == 2) {
                ECTopViewCardView.this.w(1, view, this.f101853e);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showContentNeedAnimation", false);
            jSONObject.put("immediateHideContent", true);
            ECTopViewCardView.this.x(3, jSONObject);
            ECTopViewCardView.this.D();
            ECTopViewCardView.this.handler.removeCallbacksAndMessages(null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class d implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UIInfo f101856e;

        d(UIInfo uIInfo) {
            this.f101856e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECTopViewCardView.this.w(2, view, this.f101856e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (ECTopViewCardView.this.topViewEntry.getBackground() instanceof GradientDrawable) {
                Drawable background = ECTopViewCardView.this.topViewEntry.getBackground();
                if (background != null) {
                    GradientDrawable gradientDrawable = (GradientDrawable) background;
                    Object animatedValue = valueAnimator.getAnimatedValue();
                    if (animatedValue != null) {
                        gradientDrawable.setColor(((Integer) animatedValue).intValue());
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/topview/ECTopViewCardView$g", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g extends Handler {
        g(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            super.handleMessage(msg2);
            int i3 = msg2.what;
            if (i3 == 1) {
                ECTopViewCardView.this.u();
            } else if (i3 == 2) {
                ECTopViewCardView.this.r();
            } else {
                if (i3 != 3) {
                    return;
                }
                ECTopViewCardView.this.C();
            }
        }
    }

    public ECTopViewCardView(Context context) {
        super(context);
        this.uiType = PlayUI.UIType.TOP_VIEW;
        this.entryStartColor = 436207615;
        this.entryEndColor = -52395;
        this.defaultEntryButtonTxt = "\u4e0b\u8f7d\u6e38\u620f";
        this.exposePositionMap = new SparseArray<>();
        this.goodsCardWH = new int[2];
        this.goodsCardLoc = new int[2];
        this.handler = new g(Looper.getMainLooper());
        com.tencent.ecommerce.base.device.a.f100685b.f(context, LayoutInflater.from(context).inflate(R.layout.cv5, (ViewGroup) this, true));
        this.topViewCardLayout = findViewById(R.id.ocp);
        this.topViewShadowLayout = findViewById(R.id.nxt);
        this.fadeShadowTop = findViewById(R.id.nxu);
        this.fadeShadowBottom = findViewById(R.id.nxs);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.nxr);
        this.topViewPrivatePolicyViewLayout = viewGroup;
        this.topViewSkipTextView = (TextView) findViewById(R.id.nxv);
        this.topViewAnimationLayout = (ViewGroup) findViewById(R.id.nxp);
        this.topViewEntry = (TextView) findViewById(R.id.nxq);
        ECVideoFeedsPrivatePolicyView eCVideoFeedsPrivatePolicyView = new ECVideoFeedsPrivatePolicyView(context);
        this.topViewPrivatePolicyView = eCVideoFeedsPrivatePolicyView;
        viewGroup.addView(eCVideoFeedsPrivatePolicyView.getView());
        cg0.a.b("ECTopViewCardView", "init");
    }

    private final void A() {
        float d16 = ECDeviceUtils.f104857e.d() / 2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(d16 / 2, d16);
        ofFloat.setDuration(1000);
        ofFloat.addUpdateListener(new h());
        ofFloat.addListener(new i());
        ofFloat.start();
    }

    private final void B() {
        PAGView pAGView = this.topViewAnimationView;
        if (pAGView != null) {
            pAGView.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        PAGView pAGView = this.topViewAnimationView;
        if (pAGView != null) {
            pAGView.stop();
        }
    }

    private final void E() {
        this.topViewSkipTextView.setText("\u8df3\u8fc7 " + this.countDownCount);
    }

    private final boolean p(GamePrivilegeInfo privilege) {
        return (TextUtils.isEmpty(privilege.getDeveloper()) || TextUtils.isEmpty(privilege.getVersion()) || TextUtils.isEmpty(privilege.getAppName())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("showContentNeedAnimation", true);
        jSONObject.put("immediateHideContent", true);
        x(2, jSONObject);
    }

    private final void t() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("showContentNeedAnimation", true);
        jSONObject.put("immediateHideContent", false);
        x(6, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        int i3 = this.countDownCount - 1;
        this.countDownCount = i3;
        if (i3 <= 0) {
            this.topViewAnimationLayout.setVisibility(8);
            D();
            t();
        } else {
            E();
            this.handler.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(int clickArea, View view, UIInfo uiInfo) {
        cg0.a.b("ECTopViewCardView", "invoke jump to page. action=" + uiInfo.getAction());
        view.setTag(R.id.ntd, Integer.valueOf(clickArea));
        ButtonInfo buttonInfo = uiInfo.getButtonInfo();
        if (buttonInfo != null) {
            IECGoodsCardView.IGoodsCardClickListener iGoodsCardClickListener = this.onClickEventListener;
            if (iGoodsCardClickListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(iGoodsCardClickListener, view, ECGoodsCommonUtils.f101579a.o(buttonInfo.getJumpInfoArray()), null, 4, null);
                return;
            }
            return;
        }
        cg0.a.a("ECTopViewCardView", "jumpToPage", "buttonInfo is empty.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(int action, JSONObject param) {
        cg0.a.b("ECTopViewCardView", "notifyShowContent action=" + action + ", param=" + param);
        IECEventDispatcherDelegate eventDispatcherDelegate = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getEventDispatcherDelegate();
        if (eventDispatcherDelegate != null) {
            eventDispatcherDelegate.sendEvent(action, param);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x006d, code lost:
    
        if (r0 != null) goto L17;
     */
    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void configCardUI(ECContentInfo contentInfo, UIInfo uiInfo, int uiType) {
        String str;
        cg0.a.b("ECTopViewCardView", "configCardUI uiType=" + uiType + ", uiInfo=" + uiInfo);
        this.currentUIInfo = uiInfo;
        this.topViewCardLayout.setVisibility(0);
        if (p(uiInfo.getGameInfo().getPrivilege())) {
            this.topViewPrivatePolicyView.configUI(uiInfo.getGameInfo());
        }
        this.topViewCardLayout.setOnClickListener(new b(uiInfo));
        this.topViewSkipTextView.setOnClickListener(new c());
        TextView textView = this.topViewEntry;
        ButtonInfo buttonInfo = uiInfo.getButtonInfo();
        if (buttonInfo != null && (str = buttonInfo.getButtonText()) != null) {
            if (str.length() == 0) {
                str = this.defaultEntryButtonTxt;
            }
        }
        str = this.defaultEntryButtonTxt;
        textView.setText(str);
        this.topViewEntry.setOnClickListener(new d(uiInfo));
        q(uiInfo.getAction());
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
        String str;
        String str2;
        String buttonText;
        com.tencent.ecommerce.biz.consumer.report.a aVar = com.tencent.ecommerce.biz.consumer.report.a.f101632a;
        UIInfo uIInfo = this.currentUIInfo;
        String str3 = "";
        if (uIInfo == null || (str = uIInfo.getPrice()) == null) {
            str = "";
        }
        reportParams.r(str);
        UIInfo uIInfo2 = this.currentUIInfo;
        if (uIInfo2 == null || (str2 = uIInfo2.getTitle()) == null) {
            str2 = "";
        }
        reportParams.q(str2);
        UIInfo uIInfo3 = this.currentUIInfo;
        if (uIInfo3 != null && (buttonText = uIInfo3.getButtonText()) != null) {
            str3 = buttonText;
        }
        reportParams.f(str3);
        Unit unit = Unit.INSTANCE;
        aVar.b(reportParams, ext);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onWrapperViewAppear(com.tencent.ecommerce.biz.consumer.report.b reportParams, Map<String, String> ext, ECContentInfo contentInfo) {
        String str;
        String str2;
        String title;
        this.exposePositionMap.put(this.uiType, Long.valueOf(System.currentTimeMillis()));
        com.tencent.ecommerce.biz.consumer.report.a aVar = com.tencent.ecommerce.biz.consumer.report.a.f101632a;
        UIInfo uIInfo = this.currentUIInfo;
        String str3 = "";
        if (uIInfo == null || (str = uIInfo.getPrice()) == null) {
            str = "";
        }
        reportParams.r(str);
        UIInfo uIInfo2 = this.currentUIInfo;
        if (uIInfo2 != null && (title = uIInfo2.getTitle()) != null) {
            str3 = title;
        }
        reportParams.q(str3);
        UIInfo uIInfo3 = this.currentUIInfo;
        if (uIInfo3 == null || (str2 = uIInfo3.getButtonText()) == null) {
            str2 = this.defaultEntryButtonTxt;
        }
        reportParams.f(str2);
        reportParams.s(com.tencent.ecommerce.biz.util.b.a(contentInfo.getIsContinuation()));
        Unit unit = Unit.INSTANCE;
        aVar.d(reportParams, ext);
        cg0.a.b("ECTopViewCardView", "onWrapperViewAppear");
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onWrapperViewDisappear(int uiType, com.tencent.ecommerce.biz.consumer.report.b reportParams, Map<String, String> ext) {
        String str;
        String str2;
        String title;
        D();
        long currentTimeMillis = this.exposePositionMap.get(uiType) != null ? System.currentTimeMillis() - this.exposePositionMap.get(uiType).longValue() : -1L;
        this.exposePositionMap.remove(uiType);
        com.tencent.ecommerce.biz.consumer.report.a aVar = com.tencent.ecommerce.biz.consumer.report.a.f101632a;
        UIInfo uIInfo = this.currentUIInfo;
        String str3 = "";
        if (uIInfo == null || (str = uIInfo.getPrice()) == null) {
            str = "";
        }
        reportParams.r(str);
        UIInfo uIInfo2 = this.currentUIInfo;
        if (uIInfo2 != null && (title = uIInfo2.getTitle()) != null) {
            str3 = title;
        }
        reportParams.q(str3);
        UIInfo uIInfo3 = this.currentUIInfo;
        if (uIInfo3 == null || (str2 = uIInfo3.getButtonText()) == null) {
            str2 = this.defaultEntryButtonTxt;
        }
        reportParams.f(str2);
        reportParams.l(currentTimeMillis);
        Unit unit = Unit.INSTANCE;
        aVar.c(reportParams, ext);
        a aVar2 = this.ecAnimationSet;
        if (aVar2 != null) {
            aVar2.a();
        }
        cg0.a.b("ECTopViewCardView", "onWrapperViewDisappear");
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void setGoodsCardClickListener(IECGoodsCardView.IGoodsCardClickListener listener) {
        this.onClickEventListener = listener;
    }

    public final void v(lh0.b event) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleEvent event.action=");
        sb5.append(event.getAction());
        sb5.append(" event.params=");
        sb5.append(event.getParams());
        sb5.append(" uiInfo.action=");
        UIInfo uIInfo = this.currentUIInfo;
        sb5.append(uIInfo != null ? Integer.valueOf(uIInfo.getAction()) : null);
        cg0.a.b("ECTopViewCardView", sb5.toString());
        int action = event.getAction();
        if (action == 1) {
            this.countDownCount = 3;
            E();
            B();
            A();
            this.handler.sendEmptyMessageDelayed(1, 1000L);
            this.handler.sendEmptyMessageDelayed(2, 1000L);
            return;
        }
        if (action == 5) {
            UIInfo uIInfo2 = this.currentUIInfo;
            if (uIInfo2 == null || uIInfo2.getAction() != 3) {
                return;
            }
            w(1, this.topViewCardLayout, uIInfo2);
            return;
        }
        if (action == 7) {
            UIInfo uIInfo3 = this.currentUIInfo;
            if (uIInfo3 == null || uIInfo3.getAction() != 4) {
                return;
            }
            w(1, this.topViewCardLayout, uIInfo3);
            return;
        }
        if (action != 8) {
            return;
        }
        if (event.getParams().length() > 0) {
            this.goodsCardWH[0] = event.getParams().optInt("goods_card_width");
            this.goodsCardWH[1] = event.getParams().optInt("goods_card_height");
            this.goodsCardLoc[0] = event.getParams().optInt("location_x");
            this.goodsCardLoc[1] = event.getParams().optInt("location_y");
        }
        this.handler.sendEmptyMessage(3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "onAnimationUpdate"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator != null) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue != null) {
                    float floatValue = ((Float) animatedValue).floatValue();
                    ECTopViewCardView.this.fadeShadowTop.setTranslationY(-floatValue);
                    ECTopViewCardView.this.fadeShadowBottom.setTranslationY(floatValue);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        ValueAnimator ofArgb = ValueAnimator.ofArgb(this.entryStartColor, this.entryEndColor);
        ofArgb.setDuration(2000L);
        ofArgb.addUpdateListener(new e());
        ofArgb.addListener(new f());
        ofArgb.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        a.C0035a a16;
        a.C0035a a17;
        a.C0035a a18;
        int[] iArr = this.goodsCardLoc;
        if (iArr[0] == 0 && iArr[1] == 0) {
            cg0.a.b("ECTopViewCardView", "entryOutAnimationStart");
            s();
            return;
        }
        int[] iArr2 = new int[2];
        this.topViewEntry.getLocationInWindow(iArr2);
        int[] iArr3 = {this.topViewEntry.getWidth(), this.topViewEntry.getHeight()};
        cg0.a.b("ECTopViewCardView", "startAnimToGoodsCard goodsCardWH[0] = " + this.goodsCardWH[0] + TokenParser.SP + "goodsCardWH[1] = " + this.goodsCardWH[1] + TokenParser.SP + "goodsCardLoc[0] = " + this.goodsCardLoc[0] + TokenParser.SP + "goodsCardLoc[1] = " + this.goodsCardLoc[1] + TokenParser.SP + "topViewEntryWH[0] = " + iArr3[0] + TokenParser.SP + "topViewEntryWH[1] = " + iArr3[1] + TokenParser.SP + "topViewEntryLoc[0] = " + iArr2[0] + TokenParser.SP + "topViewEntryLoc[0] = " + iArr2[1] + TokenParser.SP);
        float f16 = (((float) this.goodsCardWH[0]) + ((float) 10)) / ((float) iArr3[0]);
        int i3 = iArr2[0];
        int[] iArr4 = this.goodsCardLoc;
        float f17 = -((float) (i3 - iArr4[0]));
        float f18 = -((float) (iArr2[1] - iArr4[1]));
        a16 = r12.a(this.topViewPrivatePolicyViewLayout, 1.0f, 0.0f, (r26 & 8) != 0 ? new a.C0035a(500L).duration : 330L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
        a17 = a16.a(this.topViewSkipTextView, 1.0f, 0.0f, (r26 & 8) != 0 ? a16.duration : 330L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
        TextView textView = this.topViewEntry;
        float translationX = textView.getTranslationX();
        float translationY = this.topViewEntry.getTranslationY();
        ah0.b bVar = T;
        a18 = r27.a(this.topViewEntry, 1.0f, 0.0f, (r26 & 8) != 0 ? a.C0035a.f(a.C0035a.j(a17, textView, translationX, translationY, f17, f18, 0L, false, bVar, null, com.tencent.luggage.wxa.rf.g.CTRL_INDEX, null), this.topViewEntry, 1.0f, f16, 1.0f, f16, 0.0f, 0.0f, 0L, false, bVar, null, 0L, 3552, null).duration : 0L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : bVar, (r26 & 256) != 0 ? null : null);
        this.ecAnimationSet = a18.d(new j()).c().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        y(this, 4, null, 2, null);
        this.fadeShadowTop.setTranslationY(0.0f);
        this.fadeShadowBottom.setTranslationY(0.0f);
        this.topViewShadowLayout.setVisibility(4);
        this.topViewSkipTextView.setVisibility(0);
        E();
    }

    static /* synthetic */ void y(ECTopViewCardView eCTopViewCardView, int i3, JSONObject jSONObject, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            jSONObject = new JSONObject();
        }
        eCTopViewCardView.x(i3, jSONObject);
    }

    private final void q(int action) {
        final String str;
        if (action == 2) {
            str = "assets://pag/ecommerce_top_view_bottom_click.pag";
        } else if (action == 3) {
            str = "assets://pag/ecommerce_top_view_bottom_shake.pag";
        } else if (action != 4) {
            str = "";
        } else {
            str = "assets://pag/ecommerce_top_view_bottom_slide.pag";
        }
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPagSoLoader().loadPagSoAsync(new Function1<Boolean, Unit>() { // from class: com.tencent.ecommerce.biz.consumer.view.topview.ECTopViewCardView$configAnimationView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (z16) {
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.view.topview.ECTopViewCardView$configAnimationView$1.1
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
                            ViewGroup viewGroup2;
                            PAGView pAGView;
                            ECTopViewCardView eCTopViewCardView = ECTopViewCardView.this;
                            PAGView pAGView2 = new PAGView(ECTopViewCardView.this.getContext());
                            cg0.a.b("ECTopViewCardView", "topViewAnimationView setPath result=" + pAGView2.setPath(str));
                            pAGView2.setRepeatCount(-1);
                            Unit unit = Unit.INSTANCE;
                            eCTopViewCardView.topViewAnimationView = pAGView2;
                            viewGroup = ECTopViewCardView.this.topViewAnimationLayout;
                            viewGroup.removeAllViews();
                            viewGroup2 = ECTopViewCardView.this.topViewAnimationLayout;
                            pAGView = ECTopViewCardView.this.topViewAnimationView;
                            viewGroup2.addView(pAGView);
                        }
                    });
                } else {
                    cg0.a.a("ECTopViewCardView", "topViewAnimationView init", "pag so load failure.");
                }
            }
        });
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public View getView() {
        return this;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/topview/ECTopViewCardView$f", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements Animator.AnimatorListener {
        f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            cg0.a.b("ECTopViewCardView", "entryAnimation onAnimationEnd");
            ECTopViewCardView.this.topViewEntry.setBackground(ECTopViewCardView.this.getResources().getDrawable(R.drawable.f159689bl4));
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/topview/ECTopViewCardView$i", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i implements Animator.AnimatorListener {
        i() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            ECTopViewCardView.this.z();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            ECTopViewCardView.this.z();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/topview/ECTopViewCardView$j", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class j implements Animator.AnimatorListener {
        j() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            ECTopViewCardView.this.s();
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

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void resetToSmallCardIfNeed(int uiType) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void updateUIByType(int uiType) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void setCloseClickEventListener(View.OnClickListener animStartListener, View.OnClickListener animEndListener) {
    }
}
