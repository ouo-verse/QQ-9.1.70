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
import androidx.exifinterface.media.ExifInterface;
import cg0.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.ECGoodsCommonUtils;
import com.tencent.ecommerce.biz.consumer.IECGameProxy;
import com.tencent.ecommerce.biz.consumer.event.IECGameEventReceiver;
import com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.ecommerce.repo.consumer.resp.GameBasicInfo;
import com.tencent.ecommerce.repo.consumer.resp.GameDownLoadInfo;
import com.tencent.ecommerce.repo.consumer.resp.UIInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.vivo.push.PushClientConstants;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0084\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0085\u0001B\u0013\u0012\b\u0010\u0081\u0001\u001a\u00030\u0080\u0001\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014J \u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0014J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J,\u0010%\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070#2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J,\u0010&\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070#H\u0016J$\u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070#H\u0016J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u001c\u0010,\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010+\u001a\u0004\u0018\u00010)H\u0016J\b\u0010-\u001a\u00020\u0004H\u0002J\b\u0010.\u001a\u00020\u0004H\u0002J\b\u0010/\u001a\u00020\u0004H\u0002J\u0010\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u000200H\u0002J\u0012\u00104\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u00105\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u00106\u001a\u00020\u0004H\u0002J\b\u00107\u001a\u00020\u0004H\u0002J\b\u00108\u001a\u00020\u0004H\u0002J\b\u00109\u001a\u00020\u0004H\u0002J\b\u0010:\u001a\u00020\u0004H\u0002J\u001e\u0010>\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u00072\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00040<H\u0002J\b\u0010?\u001a\u00020\u0004H\u0002J\b\u0010@\u001a\u00020\tH\u0002J\b\u0010A\u001a\u00020\tH\u0002R\u0014\u0010D\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010J\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010CR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010P\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010MR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010\u0013\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010UR\u0018\u0010W\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010VR\u0018\u0010Y\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010XR\u0016\u0010\\\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010UR\u0016\u0010b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010UR\u0018\u0010d\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010cR\u0016\u0010\r\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010UR\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010UR\u0018\u0010i\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR$\u0010l\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010[R\u0016\u0010q\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010[R\u0016\u0010s\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010[R\u0016\u0010u\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010[R\u0016\u0010w\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010[R\u0016\u0010y\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010[R\u0016\u0010{\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010[R\u0016\u0010}\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010[R\u0016\u0010\u007f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010[\u00a8\u0006\u0086\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/ECVideoFeedsGameCardView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView;", "Lcom/tencent/ecommerce/biz/consumer/event/IECGameEventReceiver;", "", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "", "appId", "", "progress", "taskStatus", "onDownloadStatusChanged", "subscribeStatus", "followStatus", "onSubscribeStatus", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "uiType", "updateUIByType", "Landroid/view/View;", "getView", "getBigView", "getUIType", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", "configCardUI", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "listener", "setGoodsCardClickListener", "Lcom/tencent/ecommerce/biz/consumer/report/b;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "ext", "onWrapperViewAppear", "onWrapperViewDisappear", "onClickReport", "resetToSmallCardIfNeed", "Landroid/view/View$OnClickListener;", "animStartListener", "animEndListener", "setCloseClickEventListener", BdhLogUtil.LogTag.Tag_Conn, "D", "E", "", "enable", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "color", "y", "v", "w", "t", "u", HippyTKDListViewAdapter.X, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "noticeContent", "Lkotlin/Function0;", "runnable", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "B", "r", ReportConstant.COSTREPORT_PREFIX, "d", "Landroid/view/View;", "cardLayout", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "gameImageView", "f", "cardTitleContainerView", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "titleView", "i", "subtitleView", "Landroid/widget/Button;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/Button;", "button", "I", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "cardUIInfo", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "onClickEventListener", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "accentButtonColor", "", "G", "J", "exposeTime", "H", "currPlayPlan", "Ljava/lang/Boolean;", "buttonEnable", "K", "L", "M", "Lcom/tencent/ecommerce/biz/consumer/report/b;", "exposeReportParams", "N", "Ljava/util/Map;", "exposeExt", "P", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, PushClientConstants.TAG_PKG_NAME, ExifInterface.LATITUDE_SOUTH, "appName", "T", "channelId", "U", "taskKey", "V", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "W", "downloadUrl", "a0", VirtualAppProxy.KEY_PKG_SIZE, "b0", "contentId", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "g0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECVideoFeedsGameCardView extends FrameLayout implements IECGoodsCardView, IECGameEventReceiver {

    /* renamed from: c0, reason: collision with root package name */
    private static final Lazy f101752c0;

    /* renamed from: d0, reason: collision with root package name */
    private static final Lazy f101753d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final Lazy f101754e0;

    /* renamed from: f0, reason: collision with root package name */
    private static final Lazy f101755f0;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
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
    private int progress;

    /* renamed from: I, reason: from kotlin metadata */
    private int currPlayPlan;

    /* renamed from: J, reason: from kotlin metadata */
    private Boolean buttonEnable;

    /* renamed from: K, reason: from kotlin metadata */
    private int subscribeStatus;

    /* renamed from: L, reason: from kotlin metadata */
    private int taskStatus;

    /* renamed from: M, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.consumer.report.b exposeReportParams;

    /* renamed from: N, reason: from kotlin metadata */
    private Map<String, String> exposeExt;

    /* renamed from: P, reason: from kotlin metadata */
    private ECContentInfo contentInfo;

    /* renamed from: Q, reason: from kotlin metadata */
    private String appId;

    /* renamed from: R, reason: from kotlin metadata */
    private String pkgName;

    /* renamed from: S, reason: from kotlin metadata */
    private String appName;

    /* renamed from: T, reason: from kotlin metadata */
    private String channelId;

    /* renamed from: U, reason: from kotlin metadata */
    private String taskKey;

    /* renamed from: V, reason: from kotlin metadata */
    private String taskId;

    /* renamed from: W, reason: from kotlin metadata */
    private String downloadUrl;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private String pkgSize;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private String contentId;

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
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/ECVideoFeedsGameCardView$a;", "", "", "MAX_WIDTH$delegate", "Lkotlin/Lazy;", "g", "()I", "MAX_WIDTH", "MIN_TITLE_RIGHT_PADDING$delegate", h.F, "MIN_TITLE_RIGHT_PADDING", "COVER_IMAGE_SIZE$delegate", "f", "COVER_IMAGE_SIZE", "", "BUTTON_CORNER_RADIUS$delegate", "e", "()F", "BUTTON_CORNER_RADIUS", "PLAY_PLAN_NONE", "I", "PLAY_PLAN_ONE", "PLAY_PLAN_TWO", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGameCardView$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float e() {
            return ((Number) ECVideoFeedsGameCardView.f101755f0.getValue()).floatValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int f() {
            return ((Number) ECVideoFeedsGameCardView.f101754e0.getValue()).intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int g() {
            return ((Number) ECVideoFeedsGameCardView.f101752c0.getValue()).intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int h() {
            return ((Number) ECVideoFeedsGameCardView.f101753d0.getValue()).intValue();
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
        final /* synthetic */ UIInfo f101766e;

        b(UIInfo uIInfo) {
            this.f101766e = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECVideoFeedsGameCardView.this.cardLayout.setTag(R.id.ntd, 1);
            IECGoodsCardView.IGoodsCardClickListener iGoodsCardClickListener = ECVideoFeedsGameCardView.this.onClickEventListener;
            if (iGoodsCardClickListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(iGoodsCardClickListener, ECVideoFeedsGameCardView.this.cardLayout, ECGoodsCommonUtils.f101579a.p(this.f101766e.getRedirectLinkInfo().getRedirectLinkMap()), null, 4, null);
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
            ECVideoFeedsGameCardView.this.t();
            ECVideoFeedsGameCardView.this.button.setTag(R.id.ntd, 2);
            IECGoodsCardView.IGoodsCardClickListener iGoodsCardClickListener = ECVideoFeedsGameCardView.this.onClickEventListener;
            if (iGoodsCardClickListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(iGoodsCardClickListener, ECVideoFeedsGameCardView.this.button, null, null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGameCardView$Companion$MAX_WIDTH$2
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
                a.a("ECGameCardView", "MAX_WIDTH", "getScreenWidth is zero");
                return Integer.MAX_VALUE;
            }
        });
        f101752c0 = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGameCardView$Companion$MIN_TITLE_RIGHT_PADDING$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(10.0f);
            }
        });
        f101753d0 = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGameCardView$Companion$COVER_IMAGE_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(34.0f);
            }
        });
        f101754e0 = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGameCardView$Companion$BUTTON_CORNER_RADIUS$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                return e.c(4.0f);
            }
        });
        f101755f0 = lazy4;
    }

    public ECVideoFeedsGameCardView(Context context) {
        super(context);
        this.uiType = -1;
        this.accentButtonColor = "";
        this.appId = "";
        this.pkgName = "";
        this.appName = "";
        this.channelId = "";
        this.taskKey = "";
        this.taskId = "";
        this.downloadUrl = "";
        this.pkgSize = "";
        this.contentId = "";
        LayoutInflater.from(context).inflate(R.layout.crh, (ViewGroup) this, true);
        this.cardLayout = findViewById(R.id.o2g);
        this.gameImageView = (ImageView) findViewById(R.id.o1j);
        this.cardTitleContainerView = findViewById(R.id.nsz);
        this.titleView = (TextView) findViewById(R.id.oer);
        this.subtitleView = (TextView) findViewById(R.id.oeg);
        this.button = (Button) findViewById(R.id.nrs);
    }

    private final void A() {
        String string;
        if (TextUtils.isEmpty(this.pkgSize)) {
            string = getContext().getResources().getString(R.string.wkh, this.pkgSize);
        } else {
            string = getContext().getResources().getString(R.string.wkg);
        }
        q(string, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGameCardView$startDownload$1
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
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                String str8;
                String str9;
                QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
                IECGameProxy gameProxy = qQEcommerceSdk.getGlobalInternalSdk().getGameProxy();
                str = ECVideoFeedsGameCardView.this.appId;
                str2 = ECVideoFeedsGameCardView.this.pkgName;
                str3 = ECVideoFeedsGameCardView.this.appName;
                str4 = ECVideoFeedsGameCardView.this.channelId;
                str5 = ECVideoFeedsGameCardView.this.downloadUrl;
                gameProxy.doDownloadAction(str, str2, str3, str4, str5);
                IECGameProxy gameProxy2 = qQEcommerceSdk.getGlobalInternalSdk().getGameProxy();
                str6 = ECVideoFeedsGameCardView.this.taskKey;
                str7 = ECVideoFeedsGameCardView.this.channelId;
                str8 = ECVideoFeedsGameCardView.this.appId;
                str9 = ECVideoFeedsGameCardView.this.contentId;
                gameProxy2.subscribe(2, str6, str7, str8, str9);
            }
        });
    }

    private final void B() {
        ECContentInfo eCContentInfo = this.contentInfo;
        boolean isContinuation = eCContentInfo != null ? eCContentInfo.getIsContinuation() : false;
        com.tencent.ecommerce.biz.consumer.report.b bVar = this.exposeReportParams;
        if (bVar == null || this.exposeExt == null) {
            return;
        }
        com.tencent.ecommerce.biz.consumer.report.a aVar = com.tencent.ecommerce.biz.consumer.report.a.f101632a;
        Intrinsics.checkNotNull(bVar);
        bVar.w(this.taskKey);
        bVar.v(this.taskId);
        bVar.d(r());
        bVar.b(this.appId);
        com.tencent.ecommerce.biz.consumer.report.b bVar2 = this.exposeReportParams;
        Intrinsics.checkNotNull(bVar2);
        bVar.m(bVar2.getCom.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem.KEY_VIDEO_TIME java.lang.String());
        bVar.s(com.tencent.ecommerce.biz.util.b.a(isContinuation));
        Unit unit = Unit.INSTANCE;
        Map<String, String> map = this.exposeExt;
        Intrinsics.checkNotNull(map);
        aVar.d(bVar, map);
        this.exposeReportParams = null;
        this.exposeExt = null;
    }

    private final void C() {
        QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
        if (qQEcommerceSdk.getGlobalInternalSdk().getGameProxy().isAppInstalled(getContext(), this.pkgName)) {
            this.taskStatus = 9;
            B();
        } else {
            qQEcommerceSdk.getGlobalInternalSdk().getGameProxy().doQueryAllTask();
        }
    }

    private final void D() {
        int i3 = this.subscribeStatus;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    E();
                    return;
                } else if (i3 != 1995001) {
                    return;
                }
            }
            z(false);
            this.button.setText(getContext().getResources().getString(R.string.wkp));
            return;
        }
        z(this.currPlayPlan == 2);
        this.button.setText(getContext().getResources().getString(R.string.wko));
    }

    private final void E() {
        int i3 = this.taskStatus;
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 == 9) {
                    z(this.currPlayPlan == 2);
                    this.button.setText(getContext().getResources().getString(R.string.wkn));
                    return;
                }
                if (i3 != 12) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            z(false);
                            this.button.setText(getContext().getResources().getString(R.string.wkm));
                            return;
                        } else if (i3 == 6) {
                            z(this.currPlayPlan == 2);
                            this.button.setText(getContext().getResources().getString(R.string.wkl));
                            return;
                        } else if (i3 != 7) {
                            return;
                        }
                    }
                }
            }
            z(false);
            this.button.setText(getContext().getResources().getString(R.string.wki, Integer.valueOf(this.progress)));
            return;
        }
        z(this.currPlayPlan == 2);
        this.button.setText(getContext().getResources().getString(R.string.wkj));
    }

    private final void q(String noticeContent, final Function0<Unit> runnable) {
        QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
        if (qQEcommerceSdk.getGlobalInternalSdk().getGameProxy().isWifiConnected(getContext())) {
            runnable.invoke();
        } else {
            a.b("ECGameCardView", "gameCard showNoWifiDialog");
            qQEcommerceSdk.getGlobalInternalSdk().getGameProxy().showNoWifiDialog(getRootView().getContext(), noticeContent, new Function1<Boolean, Unit>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGameCardView$checkWifiAndRun$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                        Function0.this.invoke();
                    }
                }
            });
        }
    }

    private final int r() {
        int i3 = this.subscribeStatus;
        if (i3 == 1) {
            return 100;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                return s();
            }
            if (i3 != 1995001) {
                return 1;
            }
        }
        return 101;
    }

    private final int s() {
        int i3 = this.taskStatus;
        if (i3 == 2) {
            return 2;
        }
        if (i3 == 9) {
            return 5;
        }
        if (i3 == 4) {
            return 2;
        }
        if (i3 != 5) {
            return i3 != 6 ? 1 : 4;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        a.b("ECGameCardView", "gameCard clickBtn, subscribeStatus:" + this.subscribeStatus + ", taskStatus:" + this.taskStatus);
        B();
        int i3 = this.subscribeStatus;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    u();
                    return;
                }
                if (i3 != 1995001) {
                    a.a("ECGameCardView", "onClickBtn", "wrong subscribeStatus:" + this.subscribeStatus);
                    QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy().registerGameListener(this);
                    w();
                    return;
                }
            }
            a.b("ECGameCardView", "onClickBtn isSubscribed");
            return;
        }
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy().subscribe(1, this.taskKey, this.channelId, this.appId, this.contentId);
    }

    private final void u() {
        int i3 = this.taskStatus;
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 == 9) {
                    QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
                    qQEcommerceSdk.getGlobalInternalSdk().getGameProxy().subscribe(3, this.taskKey, this.channelId, this.appId, this.contentId);
                    qQEcommerceSdk.getGlobalInternalSdk().getGameProxy().startApp(getContext(), this.pkgName);
                    return;
                }
                if (i3 != 12) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            x();
                            return;
                        }
                        if (i3 == 6) {
                            QQEcommerceSdk qQEcommerceSdk2 = QQEcommerceSdk.INSTANCE;
                            qQEcommerceSdk2.getGlobalInternalSdk().getGameProxy().subscribe(4, this.taskKey, this.channelId, this.appId, this.contentId);
                            qQEcommerceSdk2.getGlobalInternalSdk().getGameProxy().doInstallAction(this.appId, this.pkgName, this.appName, this.channelId, this.downloadUrl);
                            return;
                        } else if (i3 != 7) {
                            a.a("ECGameCardView", "onClickBtnByTaskStatus", "wrong taskStatus:" + this.taskStatus);
                            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy().registerGameListener(this);
                            C();
                            return;
                        }
                    }
                }
            }
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy().doPauseAction(this.appId);
            return;
        }
        A();
    }

    private final void v(UIInfo uiInfo) {
        GameBasicInfo basic = uiInfo.getGameInfo().getBasic();
        this.appId = String.valueOf(basic.getAppId());
        this.appName = basic.getAppName();
        GameDownLoadInfo download = uiInfo.getGameInfo().getDownload();
        this.pkgName = download.getPkgName();
        this.channelId = download.getChannelId();
        this.taskKey = download.getTaskKey();
        this.taskId = download.getTaskId();
        this.downloadUrl = download.getAndroidDownloadUrl();
        this.pkgSize = download.getAndroidPkgSize();
        this.contentId = download.getContentId();
        a.b("ECGameCardView", "parseGameInfo, appId:" + this.appId + ", appName:" + this.appName + ", pkgName:" + this.pkgName + ", channelId:" + this.channelId + ", taskKey:" + this.taskKey + ", taskId:" + this.taskId + ", downloadUrl:" + this.downloadUrl + ", pkgSize:" + this.pkgSize + ", contentId:" + this.contentId);
    }

    private final void w() {
        if (ECGoodsCommonUtils.f101579a.b(this.appId, this.channelId)) {
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy().querySubscribeStatus(this.appId, this.channelId);
        }
    }

    private final void x() {
        q(getContext().getResources().getString(R.string.wkg), new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGameCardView$resumeDownload$1
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
                String str;
                IECGameProxy gameProxy = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy();
                str = ECVideoFeedsGameCardView.this.appId;
                gameProxy.doResumeAction(str);
            }
        });
    }

    private final void y(String color) {
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

    private final void z(boolean enable) {
        String buttonColor;
        if (!Intrinsics.areEqual(this.buttonEnable, Boolean.valueOf(enable))) {
            this.buttonEnable = Boolean.valueOf(enable);
            if (enable) {
                buttonColor = this.accentButtonColor;
            } else {
                UIInfo uIInfo = this.cardUIInfo;
                buttonColor = uIInfo != null ? uIInfo.getButtonColor() : null;
            }
            y(buttonColor);
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void configCardUI(ECContentInfo contentInfo, UIInfo uiInfo, int uiType) {
        if (this.cardUIInfo != null) {
            this.accentButtonColor = uiInfo.getButtonColor();
            return;
        }
        this.cardUIInfo = uiInfo;
        v(uiInfo);
        w();
        if (!TextUtils.isEmpty(uiInfo.getPicUrl())) {
            Companion companion = INSTANCE;
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(getContext(), uiInfo.getPicUrl(), this.gameImageView, new IECImageLoader.ImageLoaderOption(companion.f(), companion.f(), 0, null, null, null, false, false, null, 508, null));
        }
        this.titleView.setText(uiInfo.getTitle());
        this.subtitleView.setText(uiInfo.getSubtitle());
        this.cardLayout.setOnClickListener(new b(uiInfo));
        this.button.setOnClickListener(new c());
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

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy().registerGameListener(this);
        w();
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onClickReport(com.tencent.ecommerce.biz.consumer.report.b reportParams, Map<String, String> ext) {
        com.tencent.ecommerce.biz.consumer.report.a aVar = com.tencent.ecommerce.biz.consumer.report.a.f101632a;
        reportParams.w(this.taskKey);
        reportParams.v(this.taskId);
        reportParams.d(r());
        reportParams.b(this.appId);
        reportParams.i(reportParams.getCom.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem.KEY_VIDEO_TIME java.lang.String());
        Unit unit = Unit.INSTANCE;
        aVar.b(reportParams, ext);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy().unRegisterGameListener(this);
    }

    @Override // com.tencent.ecommerce.biz.consumer.event.IECGameEventReceiver
    public void onDownloadStatusChanged(String appId, int progress, int taskStatus) {
        if (Intrinsics.areEqual(this.appId, appId)) {
            a.b("ECGameCardView", "onDownloadStatusChanged progress=" + progress + ", taskStatus=" + taskStatus);
            this.progress = progress;
            this.taskStatus = taskStatus;
            D();
            B();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        Companion companion = INSTANCE;
        if (size > companion.g()) {
            a.b("ECGameCardView", "adjust width " + size + " to " + companion.g());
            size = companion.g();
            post(new Runnable() { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGameCardView$onMeasure$1
                @Override // java.lang.Runnable
                public final void run() {
                    View view;
                    View view2;
                    View view3;
                    int h16;
                    View view4;
                    view = ECVideoFeedsGameCardView.this.cardTitleContainerView;
                    view2 = ECVideoFeedsGameCardView.this.cardTitleContainerView;
                    int paddingLeft = view2.getPaddingLeft();
                    view3 = ECVideoFeedsGameCardView.this.cardTitleContainerView;
                    int paddingTop = view3.getPaddingTop();
                    h16 = ECVideoFeedsGameCardView.INSTANCE.h();
                    view4 = ECVideoFeedsGameCardView.this.cardTitleContainerView;
                    view.setPadding(paddingLeft, paddingTop, h16, view4.getPaddingBottom());
                }
            });
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), heightMeasureSpec);
    }

    @Override // com.tencent.ecommerce.biz.consumer.event.IECGameEventReceiver
    public void onSubscribeStatus(String appId, int subscribeStatus, int followStatus) {
        if (!Intrinsics.areEqual(appId, this.appId)) {
            return;
        }
        a.b("ECGameCardView", "onSubscribeStatus subscribeStatus=" + subscribeStatus + ", followStatus:" + followStatus);
        this.subscribeStatus = subscribeStatus;
        if (subscribeStatus == 3) {
            C();
        } else {
            B();
        }
        D();
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onWrapperViewAppear(com.tencent.ecommerce.biz.consumer.report.b reportParams, Map<String, String> ext, ECContentInfo contentInfo) {
        this.exposeTime = System.currentTimeMillis();
        this.exposeReportParams = reportParams;
        this.exposeExt = ext;
        this.contentInfo = contentInfo;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onWrapperViewDisappear(int uiType, com.tencent.ecommerce.biz.consumer.report.b reportParams, Map<String, String> ext) {
        B();
        long currentTimeMillis = System.currentTimeMillis() - this.exposeTime;
        com.tencent.ecommerce.biz.consumer.report.a aVar = com.tencent.ecommerce.biz.consumer.report.a.f101632a;
        reportParams.w(this.taskKey);
        reportParams.v(this.taskId);
        reportParams.d(r());
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
        D();
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
