package com.tencent.mobileqq.zootopia.portal.home.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.z1.cloudmod.api.ZPlanCloudGameInfo;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.utils.g;
import com.tencent.mobileqq.zootopia.utils.k;
import com.tencent.mobileqq.zootopia.utils.l;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonBinder;
import com.tencent.mobileqq.zplan.cloudmod.api.CloudModClickListener;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qui.quiblurview.QQBlur;
import com.tencent.qui.quiblurview.QQBlurView;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.data.ZootopiaMapSimpleInfo;
import com.tencent.sqshow.zootopia.mapstatus.ZootopiaMapStatusManager;
import com.tencent.sqshow.zootopia.mapstatus.b;
import com.tencent.sqshow.zootopia.player.ZootopiaPlayerView;
import com.tencent.sqshow.zootopia.portal.home.ParadiseLifecycleAdapter;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.sqshow.zootopia.view.ZootopiaMaskView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import pv4.j;
import si3.c;
import tj3.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 \u0099\u00012\u00020\u00012\u00020\u0002:\u0004\u009a\u0001\u009b\u0001B\u0011\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001B#\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u00103\u001a\u000202\u0012\u0006\u0010K\u001a\u00020D\u00a2\u0006\u0006\b\u0096\u0001\u0010\u0098\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0002J\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J \u0010\u0017\u001a\u00020\u00052\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0014j\b\u0012\u0004\u0012\u00020\u000b`\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0002J\u0006\u0010\u001d\u001a\u00020\u001cJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0014J2\u0010)\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#2\b\b\u0002\u0010&\u001a\u00020%2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010'J\u000e\u0010*\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007J\b\u0010+\u001a\u00020\u0005H\u0014J\b\u0010,\u001a\u00020\u0005H\u0014J\b\u0010-\u001a\u0004\u0018\u00010\u0003J\u000f\u0010/\u001a\u0004\u0018\u00010.\u00a2\u0006\u0004\b/\u00100J\u0006\u00101\u001a\u00020\u0005J\u0012\u00104\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u000102H\u0016J\u0012\u00105\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u000102H\u0016J\u0012\u00106\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u000102H\u0016J\u0012\u00107\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u000102H\u0016J\u0012\u00108\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u000102H\u0016R\"\u0010?\u001a\u00020\u001c8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\"\u0010K\u001a\u00020D8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010Q\u001a\u0002028\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0013\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010SR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010WR\u0018\u0010[\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010ZR\u0018\u0010]\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010\\R\u0018\u0010^\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010\\R\u0018\u0010c\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010e\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010dR\u0016\u0010g\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010fR$\u0010o\u001a\u0004\u0018\u00010h8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001c\u0010s\u001a\b\u0018\u00010pR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR6\u0010x\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010tj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u0001`u8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010wR\"\u0010\u007f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R \u0010\u0085\u0001\u001a\u00030\u0080\u00018\u0004X\u0084\u0004\u00a2\u0006\u0010\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001e\u0010\u0089\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001e\u0010\u008b\u0001\u001a\t\u0012\u0004\u0012\u00020.0\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u0088\u0001R,\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0018\u0010\u0095\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0094\u0001\u0010f\u00a8\u0006\u009c\u0001"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/home/view/ZootopiaMapItemView;", "Landroid/widget/FrameLayout;", "Lpa4/a;", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "buttonStatus", "", "I", "Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "data", "type", "", "", "", "p", ReportConstant.COSTREPORT_PREFIX, "y", "info", "J", BdhLogUtil.LogTag.Tag_Conn, h.F, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "labels", "g", "label", "Landroid/widget/TextView;", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "t", "Lcom/tencent/sqshow/zootopia/player/ZootopiaPlayerView;", "w", "Landroid/content/Context;", "context", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "", "reportByOutSide", "Lkotlin/Function0;", "buttonClickListener", "i", "D", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "o", "", DomainData.DOMAIN_NAME, "()Ljava/lang/Float;", "k", "Landroidx/lifecycle/LifecycleOwner;", "owner", DKHippyEvent.EVENT_STOP, "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Landroid/view/View;", HippyTKDListViewAdapter.X, "()Landroid/view/View;", "G", "(Landroid/view/View;)V", "view", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "labelsView", "Loa4/a;", "f", "Loa4/a;", "v", "()Loa4/a;", UserInfo.SEX_FEMALE, "(Loa4/a;)V", "mapResViewModel", "Landroidx/lifecycle/LifecycleOwner;", "u", "()Landroidx/lifecycle/LifecycleOwner;", "E", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "Lcom/tencent/mobileqq/widget/RoundRelativeLayout;", "Lcom/tencent/mobileqq/widget/RoundRelativeLayout;", "containerView", "headerView", "Lcom/tencent/qui/quiblurview/QQBlurView;", "Lcom/tencent/qui/quiblurview/QQBlurView;", "blurHeaderView", "Lcom/tencent/sqshow/zootopia/view/ZootopiaMaskView;", "Lcom/tencent/sqshow/zootopia/view/ZootopiaMaskView;", "blurFooterView", "Landroid/widget/TextView;", "typeNameView", "titleView", "introView", "Lcom/tencent/image/URLImageView;", "H", "Lcom/tencent/image/URLImageView;", "typeIconView", "Lcom/tencent/sqshow/zootopia/player/ZootopiaPlayerView;", "backgroundView", "Z", "isReportByOutSide", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "K", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "setDownloadButton", "(Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;)V", "downloadButton", "Lcom/tencent/mobileqq/zootopia/portal/home/view/ZootopiaMapItemView$ZootopiaItemDownloadListener;", "L", "Lcom/tencent/mobileqq/zootopia/portal/home/view/ZootopiaMapItemView$ZootopiaItemDownloadListener;", "clickListener", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "M", "Ljava/util/HashMap;", "cardReportParams", "N", "Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "getCurrMapInfo", "()Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "setCurrMapInfo", "(Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;)V", "currMapInfo", "Lid3/d;", "P", "Lid3/d;", "r", "()Lid3/d;", "dtReportHelper", "Landroidx/lifecycle/Observer;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroidx/lifecycle/Observer;", "statusObserver", BdhLogUtil.LogTag.Tag_Req, "progressObserver", "Lcom/tencent/mobileqq/zootopia/portal/home/a;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/zootopia/portal/home/a;", "getMapClickListener", "()Lcom/tencent/mobileqq/zootopia/portal/home/a;", "setMapClickListener", "(Lcom/tencent/mobileqq/zootopia/portal/home/a;)V", "mapClickListener", "T", "isForceDirty", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;)V", "U", "a", "ZootopiaItemDownloadListener", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class ZootopiaMapItemView extends FrameLayout implements pa4.a {

    /* renamed from: C, reason: from kotlin metadata */
    private QQBlurView blurHeaderView;

    /* renamed from: D, reason: from kotlin metadata */
    private ZootopiaMaskView blurFooterView;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView typeNameView;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView titleView;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView introView;

    /* renamed from: H, reason: from kotlin metadata */
    private URLImageView typeIconView;

    /* renamed from: I, reason: from kotlin metadata */
    private ZootopiaPlayerView backgroundView;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isReportByOutSide;

    /* renamed from: K, reason: from kotlin metadata */
    private ZootopiaDownloadButton downloadButton;

    /* renamed from: L, reason: from kotlin metadata */
    private ZootopiaItemDownloadListener clickListener;

    /* renamed from: M, reason: from kotlin metadata */
    private HashMap<String, Object> cardReportParams;

    /* renamed from: N, reason: from kotlin metadata */
    private ZootopiaMapSimpleInfo currMapInfo;

    /* renamed from: P, reason: from kotlin metadata */
    private final id3.d dtReportHelper;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Observer<ButtonStatus> statusObserver;

    /* renamed from: R, reason: from kotlin metadata */
    private final Observer<Float> progressObserver;

    /* renamed from: S, reason: from kotlin metadata */
    private com.tencent.mobileqq.zootopia.portal.home.a mapClickListener;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isForceDirty;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected View view;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout labelsView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected oa4.a mapResViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    protected LifecycleOwner lifecycleOwner;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RoundRelativeLayout containerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RoundRelativeLayout headerView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u001b\u0012\u0006\u0010(\u001a\u00020\u001e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b)\u0010*J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u001f\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/home/view/ZootopiaMapItemView$ZootopiaItemDownloadListener;", "Lcom/tencent/mobileqq/zplan/cloudmod/api/CloudModClickListener;", "Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "info", "", "d", "Landroid/view/View;", "view", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "type", "b", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getButtonClickListener", "()Lkotlin/jvm/functions/Function0;", "buttonClickListener", "", "e", "Z", "isReportByOutSide", "()Z", "setReportByOutSide", "(Z)V", "Ljava/lang/ref/WeakReference;", "f", "Ljava/lang/ref/WeakReference;", "infoReference", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "g", "sourceCurrentReference", "Landroid/content/Context;", h.F, "contextReference", "Lcom/tencent/mobileqq/zootopia/utils/k;", "i", "Lkotlin/Lazy;", "c", "()Lcom/tencent/mobileqq/zootopia/utils/k;", "upgradeUtils", "sourceCurrent", "context", "<init>", "(Lcom/tencent/mobileqq/zootopia/portal/home/view/ZootopiaMapItemView;Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Landroid/content/Context;Lkotlin/jvm/functions/Function0;Z)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class ZootopiaItemDownloadListener extends CloudModClickListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final Function0<Unit> buttonClickListener;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean isReportByOutSide;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private WeakReference<ZootopiaMapSimpleInfo> infoReference;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private WeakReference<ZootopiaSource> sourceCurrentReference;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private WeakReference<Context> contextReference;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final Lazy upgradeUtils;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ ZootopiaMapItemView f328939j;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f328940a;

            static {
                int[] iArr = new int[ButtonStatus.values().length];
                try {
                    iArr[ButtonStatus.INIT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ButtonStatus.LOADED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ButtonStatus.PAUSE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ButtonStatus.UPDATE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ButtonStatus.LOADING.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ButtonStatus.UPDATE_SYSTEM.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[ButtonStatus.WAITING.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[ButtonStatus.CAN_APPOINTMENT.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[ButtonStatus.MAINTENANCE.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[ButtonStatus.ONLY_DOWNLOAD.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[ButtonStatus.APPOINTED.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[ButtonStatus.CLOUD_GAME.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                f328940a = iArr;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/zootopia/portal/home/view/ZootopiaMapItemView$ZootopiaItemDownloadListener$b", "Lcom/tencent/mobileqq/zplan/cloudmod/api/b;", "", "b", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class b implements com.tencent.mobileqq.zplan.cloudmod.api.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ZootopiaMapItemView f328941a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ZootopiaMapSimpleInfo f328942b;

            b(ZootopiaMapItemView zootopiaMapItemView, ZootopiaMapSimpleInfo zootopiaMapSimpleInfo) {
                this.f328941a = zootopiaMapItemView;
                this.f328942b = zootopiaMapSimpleInfo;
            }

            @Override // com.tencent.mobileqq.zplan.cloudmod.api.b
            public void b() {
                this.f328941a.v().U1(this.f328942b, false);
            }

            @Override // com.tencent.mobileqq.zplan.cloudmod.api.b
            public void a() {
                QLog.d("ZootopiaMapItemView", 1, "onEnterMod");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ZootopiaItemDownloadListener(ZootopiaMapItemView zootopiaMapItemView, ZootopiaMapSimpleInfo info, ZootopiaSource sourceCurrent, Context context, Function0<Unit> function0, boolean z16) {
            super(info.getMapID(), sourceCurrent, null, 4, null);
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
            Intrinsics.checkNotNullParameter(context, "context");
            this.f328939j = zootopiaMapItemView;
            this.buttonClickListener = function0;
            this.isReportByOutSide = z16;
            this.infoReference = new WeakReference<>(info);
            this.sourceCurrentReference = new WeakReference<>(sourceCurrent);
            this.contextReference = new WeakReference<>(context);
            this.upgradeUtils = LazyKt.lazy(new Function0<k>() { // from class: com.tencent.mobileqq.zootopia.portal.home.view.ZootopiaMapItemView$ZootopiaItemDownloadListener$upgradeUtils$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final k invoke() {
                    return new k();
                }
            });
        }

        private final k c() {
            return (k) this.upgradeUtils.getValue();
        }

        @Override // com.tencent.mobileqq.zplan.cloudmod.api.CloudModClickListener
        public void b(View view, ButtonStatus type) {
            ZootopiaSource zootopiaSource;
            Context context;
            pv4.k[] kVarArr;
            ZootopiaDownloadButton downloadButton;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(type, "type");
            Function0<Unit> function0 = this.buttonClickListener;
            if (function0 != null) {
                function0.invoke();
            }
            ZootopiaMapSimpleInfo zootopiaMapSimpleInfo = this.infoReference.get();
            if (zootopiaMapSimpleInfo == null || (zootopiaSource = this.sourceCurrentReference.get()) == null || (context = this.contextReference.get()) == null) {
                return;
            }
            if (!this.isReportByOutSide && (downloadButton = this.f328939j.getDownloadButton()) != null) {
                ZootopiaMapItemView zootopiaMapItemView = this.f328939j;
                zootopiaMapItemView.getDtReportHelper().c("clck", downloadButton, zootopiaMapItemView.p(zootopiaMapSimpleInfo, type));
            }
            QLog.i("ZootopiaMapItemView", 1, "click download Button " + type + " and version: " + zootopiaMapSimpleInfo.getSimpleVerInfo().getModVersionSimpleData().getNowMapVer());
            com.tencent.sqshow.zootopia.report.a.f372690a.b(zootopiaMapSimpleInfo.getMapID(), type, zootopiaSource, this.f328939j.cardReportParams);
            int i3 = 0;
            pv4.k kVar = null;
            switch (a.f328940a[type.ordinal()]) {
                case 1:
                    oa4.a.X1(this.f328939j.v(), zootopiaMapSimpleInfo, false, 2, null);
                    return;
                case 2:
                    c.a.a((si3.c) vb3.a.f441346a.a(si3.c.class), zootopiaMapSimpleInfo.getMapID(), zootopiaSource, null, null, 12, null);
                    return;
                case 3:
                case 4:
                    oa4.a.X1(this.f328939j.v(), zootopiaMapSimpleInfo, false, 2, null);
                    return;
                case 5:
                    this.f328939j.v().R1(String.valueOf(zootopiaMapSimpleInfo.getMapID()));
                    return;
                case 6:
                    Activity activity = context instanceof Activity ? (Activity) context : null;
                    if (activity != null) {
                        k.e(c(), activity, null, 2, null);
                        return;
                    }
                    return;
                case 7:
                    this.f328939j.v().R1(String.valueOf(zootopiaMapSimpleInfo.getMapID()));
                    return;
                case 8:
                    j reserveItem = zootopiaMapSimpleInfo.getReserveItem();
                    if (reserveItem != null) {
                        a.C11293a.b((tj3.a) vb3.a.f441346a.a(tj3.a.class), reserveItem, false, null, 6, null);
                        return;
                    }
                    return;
                case 9:
                default:
                    return;
                case 10:
                    String beforeOnlineToast = zootopiaMapSimpleInfo.getBeforeOnlineToast();
                    if (beforeOnlineToast != null) {
                        QQToast.makeText(context, beforeOnlineToast, 0).show();
                        return;
                    }
                    return;
                case 11:
                    j reserveItem2 = zootopiaMapSimpleInfo.getReserveItem();
                    if (reserveItem2 != null) {
                        tj3.a aVar = (tj3.a) vb3.a.f441346a.a(tj3.a.class);
                        String str = reserveItem2.f427619b;
                        Intrinsics.checkNotNullExpressionValue(str, "it.id");
                        j o16 = aVar.o(str, reserveItem2.f427618a);
                        if (o16 == null || (kVarArr = o16.f427623f) == null) {
                            return;
                        }
                        int length = kVarArr.length;
                        while (true) {
                            if (i3 < length) {
                                pv4.k findConfig = kVarArr[i3];
                                Intrinsics.checkNotNullExpressionValue(findConfig, "findConfig");
                                if (g.j(findConfig)) {
                                    kVar = findConfig;
                                } else {
                                    i3++;
                                }
                            }
                        }
                        if (kVar == null || kVar.f427628d) {
                            return;
                        }
                        ((tj3.a) vb3.a.f441346a.a(tj3.a.class)).E0(reserveItem2);
                        return;
                    }
                    return;
                case 12:
                    ZPlanCloudGameInfo cloudGameInfo = zootopiaMapSimpleInfo.getSimpleVerInfo().getCloudGameInfo();
                    if (cloudGameInfo != null) {
                        ((com.tencent.mobileqq.zplan.cloudmod.api.a) vb3.a.f441346a.a(com.tencent.mobileqq.zplan.cloudmod.api.a.class)).S0(cloudGameInfo, zootopiaMapSimpleInfo.getSimpleVerInfo().getMapID(), zootopiaMapSimpleInfo.getSimpleVerInfo().getMapStatus(), context, new b(this.f328939j, zootopiaMapSimpleInfo));
                        return;
                    }
                    return;
            }
        }

        public final void d(ZootopiaMapSimpleInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            this.infoReference = new WeakReference<>(info);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaMapItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        int i3 = 1;
        this.currMapInfo = new ZootopiaMapSimpleInfo(0, i3, null);
        this.dtReportHelper = new id3.d(0 == true ? 1 : 0, i3, 0 == true ? 1 : 0);
        this.statusObserver = new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.home.view.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaMapItemView.H(ZootopiaMapItemView.this, (ButtonStatus) obj);
            }
        };
        this.progressObserver = new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.home.view.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaMapItemView.B(ZootopiaMapItemView.this, (Float) obj);
            }
        };
        A(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(ZootopiaMapItemView this$0, Float it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaDownloadButton zootopiaDownloadButton = this$0.downloadButton;
        if (zootopiaDownloadButton != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            zootopiaDownloadButton.setProcess(it.floatValue());
        }
    }

    private final void C() {
        LiveData<ButtonStatus> P1 = v().P1(String.valueOf(this.currMapInfo.getMapID()));
        if (P1 != null) {
            P1.removeObserver(this.statusObserver);
        }
        LiveData<Float> O1 = v().O1(String.valueOf(this.currMapInfo.getMapID()));
        if (O1 != null) {
            O1.removeObserver(this.progressObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(ZootopiaMapItemView this$0, ButtonStatus it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaDownloadButton zootopiaDownloadButton = this$0.downloadButton;
        if (zootopiaDownloadButton != null) {
            if (!this$0.isReportByOutSide) {
                id3.d.h(this$0.dtReportHelper, zootopiaDownloadButton, "em_zplan_playground_gallery_infocard_enter", this$0.p(this$0.currMapInfo, it), false, false, String.valueOf(this$0.currMapInfo.getMapID()), 24, null);
            }
            if (zootopiaDownloadButton.getIsInitCloudModType()) {
                ZootopiaDownloadButtonBinder.Companion companion = ZootopiaDownloadButtonBinder.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (companion.a(it)) {
                    zootopiaDownloadButton.setStatus(ButtonStatus.CLOUD_GAME);
                    return;
                }
            }
            zootopiaDownloadButton.B();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            zootopiaDownloadButton.setStatus(it);
            this$0.I(it);
        }
    }

    private final void I(ButtonStatus buttonStatus) {
        com.tencent.sqshow.zootopia.mapstatus.b d16;
        b.MapServerStatusResult d17;
        QLog.i("ZootopiaMapItemView", 1, "update mapInfo " + buttonStatus);
        if (buttonStatus != ButtonStatus.UPDATE || (d16 = ZootopiaMapStatusManager.f370743d.d(String.valueOf(this.currMapInfo.getMapID()))) == null || (d17 = d16.d()) == null) {
            return;
        }
        QLog.i("ZootopiaMapItemView", 1, "update button mapId : $" + this.currMapInfo.getMapID() + " Info before: " + this.currMapInfo.getSimpleVerInfo().getModVersionSimpleData().getNowMapVer() + " after: " + d17.getModVersionSimpleData().getNowMapVer());
        this.currMapInfo.updateDataFromMapServerStatusResult(d17);
        ZootopiaDownloadButton zootopiaDownloadButton = this.downloadButton;
        if (zootopiaDownloadButton != null) {
            zootopiaDownloadButton.setDownloadSize(this.currMapInfo);
        }
        ZootopiaItemDownloadListener zootopiaItemDownloadListener = this.clickListener;
        if (zootopiaItemDownloadListener != null) {
            zootopiaItemDownloadListener.d(this.currMapInfo);
        }
    }

    private final void J(ZootopiaMapSimpleInfo info) {
        LiveData<ButtonStatus> P1 = v().P1(String.valueOf(info.getMapID()));
        if (P1 != null) {
            P1.observe(u(), this.statusObserver);
        }
        LiveData<Float> O1 = v().O1(String.valueOf(info.getMapID()));
        if (O1 != null) {
            O1.observe(u(), this.progressObserver);
        }
    }

    private final void g(ArrayList<String> labels) {
        LinearLayout linearLayout = this.labelsView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("labelsView");
            linearLayout = null;
        }
        if (linearLayout.getChildCount() > 0) {
            LinearLayout linearLayout2 = this.labelsView;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("labelsView");
                linearLayout2 = null;
            }
            linearLayout2.removeAllViews();
        }
        Iterator<String> it = labels.iterator();
        while (it.hasNext()) {
            String label = it.next();
            LinearLayout linearLayout3 = this.labelsView;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("labelsView");
                linearLayout3 = null;
            }
            Intrinsics.checkNotNullExpressionValue(label, "label");
            TextView l3 = l(label);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i.h(this), i.b(20));
            layoutParams.rightMargin = i.b(6);
            Unit unit = Unit.INSTANCE;
            linearLayout3.addView(l3, layoutParams);
        }
    }

    private final void h() {
        u().getLifecycle().addObserver(new ParadiseLifecycleAdapter(this, u()));
    }

    private final TextView l(String label) {
        TextView textView = new TextView(getContext());
        textView.setText(label);
        i.i(textView, 12.0f);
        textView.setPadding(i.b(8), i.b(2), i.b(8), i.b(2));
        textView.setTextColor(q.a(R.color.f8196a));
        textView.setGravity(17);
        l.a(textView, i.b(11), q.a(R.color.f85479));
        return textView;
    }

    private final void m() {
        QQBlurView qQBlurView = this.blurHeaderView;
        if (qQBlurView != null) {
            qQBlurView.onDestroy();
        }
        C();
        ZootopiaPlayerView zootopiaPlayerView = this.backgroundView;
        if (zootopiaPlayerView != null) {
            zootopiaPlayerView.onRecycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> p(ZootopiaMapSimpleInfo data, ButtonStatus type) {
        Map<String, Object> s16 = s(data);
        s16.put("zplan_map_infocard_btnstatus", Integer.valueOf(ButtonStatus.INSTANCE.b(type)));
        return s16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        QQBlurView qQBlurView = this.blurHeaderView;
        if (qQBlurView != null) {
            qQBlurView.onDestroy();
        }
        QQBlurView qQBlurView2 = this.blurHeaderView;
        if (qQBlurView2 != null) {
            ZootopiaPlayerView zootopiaPlayerView = this.backgroundView;
            qQBlurView2.j(zootopiaPlayerView != null ? zootopiaPlayerView.n() : null);
            qQBlurView2.m(this.blurHeaderView);
            qQBlurView2.setEnableBlur(true);
            qQBlurView2.A(8.0f);
            qQBlurView2.l(20);
            qQBlurView2.z(new ColorDrawable(q.a(R.color.f8376s)));
            qQBlurView2.setDirtyListener(new QQBlur.a() { // from class: com.tencent.mobileqq.zootopia.portal.home.view.d
                @Override // com.tencent.qui.quiblurview.QQBlur.a
                public final boolean a() {
                    boolean z16;
                    z16 = ZootopiaMapItemView.z(ZootopiaMapItemView.this);
                    return z16;
                }
            });
            qQBlurView2.x();
            qQBlurView2.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z(ZootopiaMapItemView this$0) {
        boolean z16;
        ImageView n3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaPlayerView zootopiaPlayerView = this$0.backgroundView;
        if (!((zootopiaPlayerView == null || (n3 = zootopiaPlayerView.n()) == null) ? false : n3.isDirty())) {
            ZootopiaPlayerView zootopiaPlayerView2 = this$0.backgroundView;
            if (!(zootopiaPlayerView2 != null ? zootopiaPlayerView2.isDirty() : false)) {
                z16 = false;
                if (!z16 || !this$0.isForceDirty) {
                    return z16;
                }
                this$0.isForceDirty = false;
                return true;
            }
        }
        z16 = true;
        if (!z16) {
        }
        return z16;
    }

    protected void A(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.dd8, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026ap_item_view, this, true)");
        G(inflate);
        this.containerView = (RoundRelativeLayout) x().findViewById(R.id.r5w);
        this.backgroundView = (ZootopiaPlayerView) x().findViewById(R.id.r5v);
        this.headerView = (RoundRelativeLayout) x().findViewById(R.id.r5z);
        this.typeIconView = (URLImageView) x().findViewById(R.id.f163637r64);
        this.blurHeaderView = (QQBlurView) x().findViewById(R.id.r5d);
        this.blurFooterView = (ZootopiaMaskView) x().findViewById(R.id.r4r);
        this.typeNameView = (TextView) x().findViewById(R.id.r65);
        this.titleView = (TextView) x().findViewById(R.id.f163636r63);
        this.introView = (TextView) x().findViewById(R.id.f163633r60);
        View findViewById = x().findViewById(R.id.f163634r61);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.zplan_item_labels)");
        this.labelsView = (LinearLayout) findViewById;
        this.downloadButton = (ZootopiaDownloadButton) x().findViewById(R.id.r5y);
        LinearLayout linearLayout = this.labelsView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("labelsView");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        RoundRelativeLayout roundRelativeLayout = this.containerView;
        if (roundRelativeLayout != null) {
            roundRelativeLayout.f316197h = 15;
        }
        if (roundRelativeLayout != null) {
            roundRelativeLayout.f316195e = ViewUtils.dpToPx(16.0f);
        }
        RoundRelativeLayout roundRelativeLayout2 = this.headerView;
        if (roundRelativeLayout2 != null) {
            roundRelativeLayout2.f316197h = 15;
        }
        if (roundRelativeLayout2 == null) {
            return;
        }
        roundRelativeLayout2.f316195e = ViewUtils.dpToPx(15.0f);
    }

    public final void D(ZootopiaMapSimpleInfo info) {
        URLImageView uRLImageView;
        Intrinsics.checkNotNullParameter(info, "info");
        if (this.typeIconView != null) {
            if (TextUtils.isEmpty(info.getTypeIcon())) {
                int type = info.getType();
                if (type == 1) {
                    URLImageView uRLImageView2 = this.typeIconView;
                    if (uRLImageView2 != null) {
                        uRLImageView2.setImageDrawable(q.b(R.drawable.icz));
                    }
                } else if (type == 2 && (uRLImageView = this.typeIconView) != null) {
                    uRLImageView.setImageDrawable(q.b(R.drawable.icy));
                }
            } else {
                URLDrawable.URLDrawableOptions options = URLDrawable.URLDrawableOptions.obtain();
                URLImageView uRLImageView3 = this.typeIconView;
                if (uRLImageView3 != null) {
                    String typeIcon = info.getTypeIcon();
                    Intrinsics.checkNotNullExpressionValue(options, "options");
                    CommonExKt.x(uRLImageView3, typeIcon, options, null, 4, null);
                }
            }
        }
        int screenWidth = ScreenUtils.getScreenWidth(getContext()) - ViewUtils.dpToPx(32.0f);
        int i3 = (int) (screenWidth * 1.28d);
        int backgroundType = info.getBackgroundType();
        if (backgroundType == 1) {
            ZootopiaPlayerView zootopiaPlayerView = this.backgroundView;
            if (zootopiaPlayerView != null) {
                ZootopiaPlayerView.setApngBackgroundUrl$default(zootopiaPlayerView, info.getBackground(), screenWidth, i3, false, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.portal.home.view.ZootopiaMapItemView$renderView$3
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
                        ZootopiaMapItemView.this.y();
                    }
                }, 8, null);
            }
        } else if (backgroundType == 2) {
            ZootopiaPlayerView zootopiaPlayerView2 = this.backgroundView;
            if (zootopiaPlayerView2 != null) {
                zootopiaPlayerView2.setCoverUrl(info.getBackground(), screenWidth, i3, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.portal.home.view.ZootopiaMapItemView$renderView$2
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
                        ZootopiaMapItemView.this.y();
                    }
                });
            }
        } else if (backgroundType != 3) {
            ZootopiaPlayerView zootopiaPlayerView3 = this.backgroundView;
            if (zootopiaPlayerView3 != null) {
                zootopiaPlayerView3.setDefaultBackground();
            }
            y();
        } else {
            ZootopiaPlayerView zootopiaPlayerView4 = this.backgroundView;
            if (zootopiaPlayerView4 != null) {
                zootopiaPlayerView4.setCoverUrl(info.getBackground(), screenWidth, i3, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.portal.home.view.ZootopiaMapItemView$renderView$4
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
                        ZootopiaMapItemView.this.y();
                    }
                });
            }
            ZootopiaPlayerView zootopiaPlayerView5 = this.backgroundView;
            if (zootopiaPlayerView5 != null) {
                zootopiaPlayerView5.setVideoUrl(info.getVideoUrl());
            }
        }
        ZootopiaMaskView zootopiaMaskView = this.blurFooterView;
        LinearLayout linearLayout = null;
        if (zootopiaMaskView != null) {
            ZootopiaMaskView.setMaskBackground$default(zootopiaMaskView, info.getBackColor(), false, 2, null);
        }
        TextView textView = this.typeNameView;
        if (textView != null) {
            textView.setText(info.getTypeName());
        }
        TextView textView2 = this.titleView;
        if (textView2 != null) {
            textView2.setText(info.getName());
        }
        TextView textView3 = this.introView;
        if (textView3 != null) {
            textView3.setText(info.getDesc());
        }
        g(info.getLabels());
        LinearLayout linearLayout2 = this.labelsView;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("labelsView");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setVisibility(0);
        this.isForceDirty = true;
    }

    protected final void E(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<set-?>");
        this.lifecycleOwner = lifecycleOwner;
    }

    protected final void F(oa4.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mapResViewModel = aVar;
    }

    protected final void G(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.view = view;
    }

    public final void i(ZootopiaMapSimpleInfo info, ZootopiaSource sourceCurrent, boolean reportByOutSide, Function0<Unit> buttonClickListener) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.isReportByOutSide = reportByOutSide;
        if (this.currMapInfo.getMapID() != 0) {
            C();
        }
        this.currMapInfo = info;
        ZootopiaDownloadButton zootopiaDownloadButton = this.downloadButton;
        if (zootopiaDownloadButton != null) {
            zootopiaDownloadButton.setCloudModButtonStyle(s84.b.f433495a.a(5));
            zootopiaDownloadButton.setDownloadSize(info);
            QLog.i("ZootopiaMapItemView", 1, "clickListern  --> " + buttonClickListener);
            if (ZPlanCloudGameInfo.INSTANCE.a(info.getSimpleVerInfo().getCloudGameInfo())) {
                zootopiaDownloadButton.setStatus(ButtonStatus.CLOUD_GAME);
                zootopiaDownloadButton.setIsInitCloudModType(true);
            } else {
                zootopiaDownloadButton.setStatusText(ButtonStatus.LOADED, info.getButton());
            }
            Context context = zootopiaDownloadButton.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ZootopiaItemDownloadListener zootopiaItemDownloadListener = new ZootopiaItemDownloadListener(this, info, sourceCurrent, context, buttonClickListener, this.isReportByOutSide);
            this.clickListener = zootopiaItemDownloadListener;
            zootopiaDownloadButton.setButtonStatusListener(zootopiaItemDownloadListener);
        }
        v().M1(String.valueOf(info.getMapID()));
        J(info);
    }

    public final void k() {
        ZootopiaPlayerView zootopiaPlayerView = this.backgroundView;
        if (zootopiaPlayerView != null) {
            zootopiaPlayerView.l();
        }
    }

    public final Float n() {
        ZootopiaDownloadButton zootopiaDownloadButton = this.downloadButton;
        if (zootopiaDownloadButton != null) {
            return Float.valueOf(zootopiaDownloadButton.i());
        }
        return null;
    }

    public final ButtonStatus o() {
        ZootopiaDownloadButton zootopiaDownloadButton = this.downloadButton;
        if (zootopiaDownloadButton != null) {
            return zootopiaDownloadButton.getStatus();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QLog.i("ZootopiaMapItemView", 1, "onAttachedToWindow - " + this);
        this.isForceDirty = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.i("ZootopiaMapItemView", 1, "onDetachedFromWindow - " + this);
        QQBlurView qQBlurView = this.blurHeaderView;
        if (qQBlurView != null) {
            qQBlurView.onDestroy();
        }
    }

    @Override // pa4.a
    public void onPause(LifecycleOwner owner) {
        QQBlurView qQBlurView = this.blurHeaderView;
        if (qQBlurView != null) {
            qQBlurView.onPause();
        }
    }

    @Override // pa4.a
    public void onResume(LifecycleOwner owner) {
        QQBlurView qQBlurView = this.blurHeaderView;
        if (qQBlurView != null) {
            qQBlurView.onResume();
        }
    }

    /* renamed from: q, reason: from getter */
    protected final ZootopiaDownloadButton getDownloadButton() {
        return this.downloadButton;
    }

    /* renamed from: r, reason: from getter */
    protected final id3.d getDtReportHelper() {
        return this.dtReportHelper;
    }

    public final void setCurrMapInfo(ZootopiaMapSimpleInfo zootopiaMapSimpleInfo) {
        Intrinsics.checkNotNullParameter(zootopiaMapSimpleInfo, "<set-?>");
        this.currMapInfo = zootopiaMapSimpleInfo;
    }

    public final void setMapClickListener(com.tencent.mobileqq.zootopia.portal.home.a aVar) {
        this.mapClickListener = aVar;
    }

    public final View t() {
        return x();
    }

    protected final LifecycleOwner u() {
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
        return null;
    }

    protected final oa4.a v() {
        oa4.a aVar = this.mapResViewModel;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mapResViewModel");
        return null;
    }

    /* renamed from: w, reason: from getter */
    public final ZootopiaPlayerView getBackgroundView() {
        return this.backgroundView;
    }

    protected final View x() {
        View view = this.view;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("view");
        return null;
    }

    private final Map<String, Object> s(ZootopiaMapSimpleInfo data) {
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = new Pair("zplan_map_id", Integer.valueOf(data.getMapID()));
        pairArr[1] = new Pair("zplan_module_id", "em_zplan_playground_gallery_infocard");
        j reserveItem = data.getReserveItem();
        pairArr[2] = new Pair("zplan_reserver_type", Integer.valueOf(reserveItem != null ? reserveItem.f427618a : 0));
        j reserveItem2 = data.getReserveItem();
        String str = reserveItem2 != null ? reserveItem2.f427619b : null;
        if (str == null) {
            str = "";
        }
        pairArr[3] = new Pair("zplan_reserver_id", str);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    @Override // pa4.a
    public void onDestroy(LifecycleOwner owner) {
        QLog.i("ZootopiaMapItemView", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        m();
    }

    @Override // pa4.a
    public void onStart(LifecycleOwner owner) {
        QLog.i("ZootopiaMapItemView", 1, DKHippyEvent.EVENT_STOP);
    }

    @Override // pa4.a
    public void onStop(LifecycleOwner owner) {
        QLog.i("ZootopiaMapItemView", 1, DKHippyEvent.EVENT_STOP);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaMapItemView(Context context, LifecycleOwner owner, oa4.a mapResViewModel) {
        this(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        F(mapResViewModel);
        E(owner);
        h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void j(ZootopiaMapItemView zootopiaMapItemView, ZootopiaMapSimpleInfo zootopiaMapSimpleInfo, ZootopiaSource zootopiaSource, boolean z16, Function0 function0, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                z16 = false;
            }
            if ((i3 & 8) != 0) {
                function0 = null;
            }
            zootopiaMapItemView.i(zootopiaMapSimpleInfo, zootopiaSource, z16, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindDownloadRes");
    }
}
