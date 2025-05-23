package com.tencent.mobileqq.vas.adv.kuikly.cardad;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.util.SsoReporter;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.ad.cardad.data.aa;
import com.tencent.mobileqq.ad.cardad.data.y;
import com.tencent.mobileqq.ad.cardad.views.CardAdView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdClickHelper;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tenpay.sdk.util.QWSoterConstans;
import i01.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\b\n*\u0002\u0088\u0001\b\u0017\u0018\u0000 \u008f\u00012\u00020\u00012\u00020\u0002:\u0002\u0090\u0001B\u0010\u0012\u0006\u0010G\u001a\u00020\"\u00a2\u0006\u0005\b\u008e\u0001\u0010FJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\"\u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J4\u0010!\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010 \u001a\u00020\u0014H\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010#\u001a\u00020\"H\u0002J\b\u0010&\u001a\u00020\u0005H\u0002J\b\u0010'\u001a\u00020\u0005H\u0002J\u0018\u0010+\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010*\u001a\u00020)H\u0016JI\u00103\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032+\u00102\u001a'\u0012\u0015\u0012\u0013\u0018\u00010)\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u0005\u0018\u00010-j\u0004\u0018\u0001`1H\u0016J\u0010\u00104\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0006\u00105\u001a\u00020\u0005J\u0010\u00106\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0006\u00107\u001a\u00020\u0005J\u000e\u00109\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u000bJ\u0010\u0010;\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u000bH\u0014J\b\u0010<\u001a\u00020\u0005H\u0014J\b\u0010=\u001a\u00020\u0005H\u0014J\b\u0010>\u001a\u00020\u0005H\u0016J\u0006\u0010?\u001a\u00020\u0005J\u0006\u0010@\u001a\u00020\u0005R\"\u0010G\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010&R\u0016\u0010P\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010OR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010W\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010&R\u0016\u0010X\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010&R\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00030Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010]R\u0016\u0010_\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010&R\u0018\u0010`\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010OR\u0016\u0010a\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010]R\u0016\u0010b\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010OR\u0016\u0010c\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010OR\u0016\u0010d\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010OR\u0016\u0010g\u001a\u00020e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010fR\u0016\u0010i\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010OR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010p\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010t\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR;\u0010w\u001a'\u0012\u0015\u0012\u0013\u0018\u00010)\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u0005\u0018\u00010-j\u0004\u0018\u0001`18\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR;\u0010y\u001a'\u0012\u0015\u0012\u0013\u0018\u00010)\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u0005\u0018\u00010-j\u0004\u0018\u0001`18\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010vR;\u0010{\u001a'\u0012\u0015\u0012\u0013\u0018\u00010)\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u0005\u0018\u00010-j\u0004\u0018\u0001`18\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010vR;\u0010}\u001a'\u0012\u0015\u0012\u0013\u0018\u00010)\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u0005\u0018\u00010-j\u0004\u0018\u0001`18\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010vR;\u0010\u007f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010)\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u0005\u0018\u00010-j\u0004\u0018\u0001`18\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010vR\u0018\u0010\u0081\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010]R\u0018\u0010\u0083\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0082\u0001\u0010]R\u0018\u0010\u0085\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0084\u0001\u0010]R\u0018\u0010\u0087\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0086\u0001\u0010]R\u0018\u0010\u008b\u0001\u001a\u00030\u0088\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0013\u0010\u008d\u0001\u001a\u00020\t8F\u00a2\u0006\u0007\u001a\u0005\bZ\u0010\u008c\u0001\u00a8\u0006\u0091\u0001"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/kuikly/cardad/VasKuiklyCardAdView;", "Landroid/widget/FrameLayout;", "Li01/c;", "", "params", "", HippyTKDListViewAdapter.X, "G", "B", "", "M", "", "retCode", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "Ltencent/gdt/access$UserActionReportInfo;", "userActionReportInfo", "L", BdhLogUtil.LogTag.Tag_Conn, "D", "Landroid/view/ViewGroup;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "advCallback", "enableShowMask", "J", "Lcom/tencent/mobileqq/vas/adv/kuikly/cardad/e;", "rspCallback", "v", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "ad", "parentView", "t", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "I", "K", "propKey", "", "propValue", "b", "method", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "w", "setPageAppear", "y", "u", "adIndex", "H", "visibility", "onWindowVisibilityChanged", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mContext", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView;", "e", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView;", "mCardAdView", "f", "mCardAdStyle", h.F, "Ljava/lang/String;", "mBtnBgColor", "i", "mBtnTextColor", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "mAdRadius", "mAdExpoType", "mAdBusiType", "", "E", "Ljava/util/List;", "mAdExtIds", "Z", "mEnableShake", "mAdIndex", "mPosId", "mShowMaskAd", "mMaskPosId", "mTianShuMaskPosId", "mBusinessName", "Lcom/tencent/mobileqq/vas/adv/common/data/MaskAdvName;", "Lcom/tencent/mobileqq/vas/adv/common/data/MaskAdvName;", "mMaskAdvName", "N", "mSourceFrom", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "P", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "mAdInfo", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/gdtad/aditem/GdtAd;", "mGdtAd", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView$b;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView$b;", "mCardAdFeedbackListener", ExifInterface.LATITUDE_SOUTH, "Lkotlin/jvm/functions/Function1;", "mLoadCompletionCallback", "T", "mFeedbackCallback", "U", "mAdOriExpoCallback", "V", "mAdValidExpoCallback", "W", "mAdClickCallback", "a0", "mMaskShowIng", "b0", "mIsLoadCompletionDelay", "c0", "mIsValidExpoCallbackDelay", "d0", "mIsPageAppear", "com/tencent/mobileqq/vas/adv/kuikly/cardad/VasKuiklyCardAdView$b", "e0", "Lcom/tencent/mobileqq/vas/adv/kuikly/cardad/VasKuiklyCardAdView$b;", "mAdReportCallback", "()Z", "isAdInit", "<init>", "f0", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes20.dex */
public class VasKuiklyCardAdView extends FrameLayout implements i01.c {

    /* renamed from: C, reason: from kotlin metadata */
    private int mAdExpoType;

    /* renamed from: D, reason: from kotlin metadata */
    private int mAdBusiType;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private List<String> mAdExtIds;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mEnableShake;

    /* renamed from: G, reason: from kotlin metadata */
    private int mAdIndex;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private String mPosId;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mShowMaskAd;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private String mMaskPosId;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String mTianShuMaskPosId;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String mBusinessName;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private MaskAdvName mMaskAdvName;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private String mSourceFrom;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private qq_ad_get.QQAdGetRsp.AdInfo mAdInfo;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private GdtAd mGdtAd;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private CardAdView.b mCardAdFeedbackListener;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> mLoadCompletionCallback;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> mFeedbackCallback;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> mAdOriExpoCallback;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> mAdValidExpoCallback;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> mAdClickCallback;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mMaskShowIng;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mIsLoadCompletionDelay;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mIsValidExpoCallbackDelay;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context mContext;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsPageAppear;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CardAdView mCardAdView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAdReportCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mCardAdStyle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mBtnBgColor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mBtnTextColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float mAdRadius;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/vas/adv/kuikly/cardad/VasKuiklyCardAdView$b", "Lcom/tencent/mobileqq/ad/cardad/data/aa;", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "", "e", "a", "b", "f", "g", "c", "d", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements aa {
        b() {
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void a(@NotNull GdtAd gdtAd) {
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
            QLog.d("VasKuiklyCardAdView", 1, "adReportCallback onAdOriginExposure");
            Function1 function1 = VasKuiklyCardAdView.this.mAdOriExpoCallback;
            if (function1 != null) {
                function1.invoke(new JSONObject());
            }
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void b(@NotNull GdtAd gdtAd) {
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
            QLog.d("VasKuiklyCardAdView", 1, "adReportCallback onAdValidExposure");
            VasKuiklyCardAdView.this.D();
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void c(@NotNull GdtAd gdtAd) {
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
            QLog.d("VasKuiklyCardAdView", 1, "adReportCallback onAdComplaint");
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void d(@NotNull GdtAd gdtAd) {
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
            QLog.d("VasKuiklyCardAdView", 1, "adReportCallback onAdCarousel");
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void e(@NotNull GdtAd gdtAd) {
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
            QLog.d("VasKuiklyCardAdView", 1, "adReportCallback onAdLoad");
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void f(@NotNull GdtAd gdtAd) {
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
            QLog.d("VasKuiklyCardAdView", 1, "adReportCallback onAdClick");
            Function1 function1 = VasKuiklyCardAdView.this.mAdClickCallback;
            if (function1 != null) {
                function1.invoke(new JSONObject());
            }
        }

        @Override // com.tencent.mobileqq.ad.cardad.data.aa
        public void g(@NotNull GdtAd gdtAd) {
            Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
            QLog.d("VasKuiklyCardAdView", 1, "adReportCallback onAdClose");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/vas/adv/kuikly/cardad/VasKuiklyCardAdView$c", "Lcom/tencent/mobileqq/vas/adv/kuikly/cardad/e;", "", "retCode", "Ljava/util/ArrayList;", "Lcom/tencent/gdtad/aditem/GdtAd;", "Lkotlin/collections/ArrayList;", "adList", "Ltencent/gdt/access$UserActionReportInfo;", "userActionReportInfo", "", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements e {
        c() {
        }

        @Override // com.tencent.mobileqq.vas.adv.kuikly.cardad.e
        public void a(int retCode, @NotNull ArrayList<GdtAd> adList, @Nullable access.UserActionReportInfo userActionReportInfo) {
            Intrinsics.checkNotNullParameter(adList, "adList");
            if (adList.isEmpty()) {
                return;
            }
            GdtAd gdtAd = adList.get(0);
            Intrinsics.checkNotNullExpressionValue(gdtAd, "adList[0]");
            VasKuiklyCardAdView.this.L(retCode, gdtAd, userActionReportInfo);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasKuiklyCardAdView(@NotNull Context mContext) {
        super(mContext);
        List<String> listOf;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mBtnBgColor = "";
        this.mBtnTextColor = "";
        this.mAdRadius = -1.0f;
        this.mAdBusiType = -1;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("");
        this.mAdExtIds = listOf;
        this.mEnableShake = true;
        this.mAdIndex = -1;
        this.mShowMaskAd = true;
        this.mMaskPosId = "";
        this.mTianShuMaskPosId = "";
        this.mBusinessName = "";
        this.mMaskAdvName = MaskAdvName.QQ_HEALTH;
        this.mSourceFrom = "";
        this.mIsPageAppear = true;
        this.mAdReportCallback = new b();
    }

    private final ViewGroup A() {
        View view;
        Window window;
        Activity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            view = window.getDecorView();
        } else {
            view = null;
        }
        if (view != null) {
            return (ViewGroup) view;
        }
        ViewGroup F = F();
        Intrinsics.checkNotNull(F, "null cannot be cast to non-null type android.view.ViewGroup");
        return F;
    }

    private final void B() {
        GdtAd gdtAd;
        VasKuiklyCardAdManager vasKuiklyCardAdManager = VasKuiklyCardAdManager.f308031a;
        if (vasKuiklyCardAdManager.l(this.mAdIndex) && !E()) {
            QLog.d("VasKuiklyCardAdView", 2, "async ad request triggered when initAd");
            gdtAd = vasKuiklyCardAdManager.h(this.mAdIndex);
            if (gdtAd == null) {
                return;
            }
        } else if (this.mAdInfo != null) {
            gdtAd = new GdtAd(this.mAdInfo);
        } else {
            gdtAd = null;
        }
        if (gdtAd != null) {
            M();
            if (TextUtils.equals(this.mPosId, "7085109922408095") && this.mShowMaskAd) {
                vz2.b.f443772a.f(MaskAdvName.QQ_SHOP);
            }
            L(0, gdtAd, null);
            return;
        }
        K();
    }

    private final void C() {
        String str;
        if (this.mLoadCompletionCallback == null) {
            QLog.d("VasKuiklyCardAdView", 1, "mLoadCompletionCallback is null");
            this.mIsLoadCompletionDelay = true;
            return;
        }
        JSONObject put = new JSONObject().put("isSuccess", true);
        GdtAd gdtAd = this.mGdtAd;
        if (gdtAd == null || (str = gdtAd.toString()) == null) {
            str = "";
        }
        JSONObject put2 = put.put("adInfoJson", str);
        QLog.d("VasKuiklyCardAdView", 1, "loadCompletion invoke");
        Function1<Object, Unit> function1 = this.mLoadCompletionCallback;
        if (function1 != null) {
            function1.invoke(put2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        if (this.mAdValidExpoCallback == null) {
            QLog.d("VasKuiklyCardAdView", 1, "mAdValidExpoCallback is null");
            this.mIsValidExpoCallbackDelay = true;
            return;
        }
        QLog.d("VasKuiklyCardAdView", 1, "onAdValidExposure invoke");
        Function1<Object, Unit> function1 = this.mAdValidExpoCallback;
        if (function1 != null) {
            function1.invoke(new JSONObject());
        }
    }

    private final void G(String params) {
        if (TextUtils.isEmpty(params)) {
            QLog.e("VasKuiklyCardAdView", 1, "parseAdReqParams is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(params);
            String optString = jSONObject.optString(SsoReporter.POS_ID_KEY);
            int optInt = jSONObject.optInt(QWSoterConstans.CGI_KEY_BUSI_TYPE, -1);
            JSONArray optJSONArray = jSONObject.optJSONArray("exp_ids");
            this.mPosId = optString;
            this.mAdBusiType = optInt;
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String str = optJSONArray.getString(i3);
                    Intrinsics.checkNotNullExpressionValue(str, "str");
                    arrayList.add(str);
                }
                this.mAdExtIds = arrayList;
            }
            B();
        } catch (Exception e16) {
            QLog.e("VasKuiklyCardAdView", 1, "parseAdReqParams error:", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I() {
        Lifecycle lifecycle;
        LifecycleOwner z16 = z(this.mContext);
        if (z16 != null && (lifecycle = z16.getLifecycle()) != null) {
            lifecycle.addObserver(new LifecycleObserver() { // from class: com.tencent.mobileqq.vas.adv.kuikly.cardad.VasKuiklyCardAdView$registerLifeObserver$1
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                public final void onDestroy() {
                    VasKuiklyCardAdView.this.x(null);
                }
            });
        }
    }

    private final void J(VasAdCallback advCallback, boolean enableShowMask) {
        VasKuiklyCardAdReqParams vasKuiklyCardAdReqParams = new VasKuiklyCardAdReqParams(this.mPosId, this.mAdBusiType, enableShowMask, this.mSourceFrom, this.mAdExtIds);
        int i3 = this.mAdIndex;
        if (i3 >= 0) {
            VasKuiklyCardAdManager.f308031a.g(i3, advCallback, vasKuiklyCardAdReqParams);
        } else {
            VasKuiklyCardAdManager.f308031a.q(advCallback, vasKuiklyCardAdReqParams);
        }
    }

    private final void K() {
        J(v(new c()), M());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(int retCode, GdtAd gdtAd, access.UserActionReportInfo userActionReportInfo) {
        if (this.mCardAdView == null) {
            QLog.d("VasKuiklyCardAdView", 1, "create new CardAd");
            CardAdView c16 = com.tencent.mobileqq.ad.cardad.manager.a.f186722a.c(getActivity(), this, gdtAd, this.mPosId, this.mCardAdStyle, this.mAdReportCallback);
            this.mCardAdView = c16;
            if (c16 != null) {
                c16.y0(this.mBtnBgColor);
            }
            CardAdView cardAdView = this.mCardAdView;
            if (cardAdView != null) {
                cardAdView.z0(this.mBtnTextColor);
            }
            CardAdView cardAdView2 = this.mCardAdView;
            if (cardAdView2 != null) {
                cardAdView2.setEnableShake(this.mEnableShake);
            }
            CardAdView cardAdView3 = this.mCardAdView;
            if (cardAdView3 != null) {
                cardAdView3.setExpoType(this.mAdExpoType);
            }
        } else {
            QLog.d("VasKuiklyCardAdView", 1, "update CardAd");
            CardAdView cardAdView4 = this.mCardAdView;
            if (cardAdView4 != null) {
                cardAdView4.A0(new y(gdtAd, this.mBtnBgColor, this.mBtnTextColor, this.mAdRadius, this.mEnableShake, this.mAdExpoType));
            }
        }
        this.mGdtAd = gdtAd;
        com.tencent.mobileqq.ad.cardad.utils.d.f186735a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.adv.kuikly.cardad.VasKuiklyCardAdView$updateAd$1
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
                VasKuiklyCardAdView.this.I();
            }
        });
        C();
        d dVar = new d();
        this.mCardAdFeedbackListener = dVar;
        CardAdView cardAdView5 = this.mCardAdView;
        if (cardAdView5 != null) {
            cardAdView5.setFeedbackHideAdListener(dVar);
        }
        w(null);
        QLog.d("VasKuiklyCardAdView", 1, "updateAd:", Long.valueOf(gdtAd.getAId()));
        t(getActivity(), retCode, gdtAd, userActionReportInfo, A());
    }

    private final boolean M() {
        if (!TextUtils.isEmpty(this.mPosId) && TextUtils.equals(this.mPosId, "1082214467882419")) {
            boolean isShowMaskAdForHealth = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).isShowMaskAdForHealth();
            this.mMaskPosId = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getHealthPosId();
            this.mMaskAdvName = MaskAdvName.QQ_HEALTH;
            this.mTianShuMaskPosId = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getHealthTianShuPosId();
            return isShowMaskAdForHealth;
        }
        if ((!TextUtils.isEmpty(this.mPosId) && TextUtils.equals(this.mPosId, "7085109922408095")) || TextUtils.equals(this.mPosId, "6070053621217196")) {
            this.mMaskPosId = "7085109922408095";
            this.mMaskAdvName = MaskAdvName.QQ_SHOP;
            return true;
        }
        return false;
    }

    private final void t(Activity activity, int retCode, GdtAd ad5, access.UserActionReportInfo userActionReportInfo, ViewGroup parentView) {
        String str;
        if (!this.mShowMaskAd || this.mMaskShowIng || !MaskAdClickHelper.INSTANCE.isMaskAd(ad5.getInnerShowType())) {
            return;
        }
        boolean z16 = false;
        VasKuiklyCardAdManager vasKuiklyCardAdManager = VasKuiklyCardAdManager.f308031a;
        QLog.d("VasKuiklyCardAdView", 1, "hasCheckedShowMaskAd:", Boolean.valueOf(vasKuiklyCardAdManager.i()));
        if (vasKuiklyCardAdManager.i()) {
            return;
        }
        if (TextUtils.equals(this.mMaskPosId, "7085109922408095")) {
            com.tencent.mobileqq.vas.adv.maskad.a aVar = com.tencent.mobileqq.vas.adv.maskad.a.f308093a;
            String traceId = ad5.getTraceId();
            if (traceId == null) {
                traceId = "";
            }
            if (!aVar.c(traceId)) {
                QLog.d("VasKuiklyCardAdView", 1, "checkShowMaskAd freq, return");
                return;
            }
        }
        vasKuiklyCardAdManager.s(true);
        this.mMaskShowIng = true;
        String a16 = vz2.b.f443772a.a(ad5);
        QLog.d("VasKuiklyCardAdView", 2, "getAdResPath:", a16);
        if (retCode == 0) {
            z16 = true;
        }
        if (z16) {
            str = AdHippyFragment.MASK_AD_DISPLAY_REQUEST_SUCCESS;
        } else {
            str = AdHippyFragment.MASK_AD_DISPLAY_REQUEST_FAILED;
        }
        vz2.c cVar = vz2.c.f443777a;
        cVar.a(this.mMaskAdvName, str, cVar.c(activity, ad5, userActionReportInfo, this.mMaskPosId, this.mTianShuMaskPosId, a16, this.mBusinessName, this.mMaskAdvName, parentView));
    }

    private final VasAdCallback v(e rspCallback) {
        return new VasKuiklyCardAdView$createAdReqCallback$1(this, System.currentTimeMillis(), rspCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(String params) {
        CardAdView cardAdView = this.mCardAdView;
        if (cardAdView != null) {
            cardAdView.onDestroy();
        }
        this.mCardAdFeedbackListener = null;
        this.mLoadCompletionCallback = null;
        this.mFeedbackCallback = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LifecycleOwner z(Context context) {
        if (context instanceof LifecycleOwner) {
            return (LifecycleOwner) context;
        }
        return null;
    }

    public final boolean E() {
        if (this.mCardAdView != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public ViewGroup F() {
        return c.a.h(this);
    }

    public final void H(int adIndex) {
        QLog.d("VasKuiklyCardAdView", 1, "refreshAdData index:", Integer.valueOf(adIndex));
        if (adIndex >= 0 && adIndex == this.mAdIndex) {
            B();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0016. Please report as an issue. */
    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case -1996465159:
                if (propKey.equals("adInfoJson")) {
                    String str = (String) propValue;
                    if (TextUtils.isEmpty(str)) {
                        return true;
                    }
                    this.mAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(str));
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1749778795:
                if (propKey.equals("adRadius")) {
                    float floatValue = ((Float) propValue).floatValue();
                    this.mAdRadius = floatValue;
                    QLog.d("VasKuiklyCardAdView", 2, "setProp adRadius:", Float.valueOf(floatValue));
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1237508785:
                if (propKey.equals("onAdOriginExposure")) {
                    this.mAdOriExpoCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1172747665:
                if (propKey.equals("adIndex")) {
                    int intValue = ((Integer) propValue).intValue();
                    this.mAdIndex = intValue;
                    QLog.d("VasKuiklyCardAdView", 2, "setProp adIndex:", Integer.valueOf(intValue));
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1163313330:
                if (propKey.equals("adStyle")) {
                    int intValue2 = ((Integer) propValue).intValue();
                    this.mCardAdStyle = intValue2;
                    QLog.d("VasKuiklyCardAdView", 2, "setProp adStyle:", Integer.valueOf(intValue2));
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1111855515:
                if (propKey.equals(GetAdInfoRequest.SOURCE_FROM)) {
                    this.mSourceFrom = (String) propValue;
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1008622190:
                if (propKey.equals("adRequestParams")) {
                    String str2 = (String) propValue;
                    QLog.d("VasKuiklyCardAdView", 2, "setProp adRequestParams:", str2);
                    G(str2);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -191501435:
                if (propKey.equals("feedback")) {
                    this.mFeedbackCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 106854031:
                if (propKey.equals("posId")) {
                    String str3 = (String) propValue;
                    this.mPosId = str3;
                    QLog.d("VasKuiklyCardAdView", 2, "setProp posId:", str3);
                    B();
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 157935686:
                if (propKey.equals("onAdClick")) {
                    this.mAdClickCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 193925519:
                if (propKey.equals("adExpoType")) {
                    int intValue3 = ((Integer) propValue).intValue();
                    this.mAdExpoType = intValue3;
                    QLog.d("VasKuiklyCardAdView", 2, "setProp adExpoType:", Integer.valueOf(intValue3));
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 513154402:
                if (propKey.equals("loadCompletion")) {
                    this.mLoadCompletionCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    QLog.d("VasKuiklyCardAdView", 2, "setEvent loadCompletion");
                    if (!this.mIsLoadCompletionDelay) {
                        return true;
                    }
                    C();
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 593811852:
                if (propKey.equals("showMaskAd")) {
                    boolean booleanValue = ((Boolean) propValue).booleanValue();
                    this.mShowMaskAd = booleanValue;
                    QLog.d("VasKuiklyCardAdView", 2, "setProp showMaskAd:", Boolean.valueOf(booleanValue));
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 1510506286:
                if (propKey.equals("adButtonColor")) {
                    this.mBtnBgColor = (String) propValue;
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 1625923713:
                if (propKey.equals("adButtonTextColor")) {
                    String str4 = (String) propValue;
                    this.mBtnTextColor = str4;
                    QLog.d("VasKuiklyCardAdView", 2, "setProp adButtonTextColor:", str4);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 1855646496:
                if (propKey.equals("adEnableShake")) {
                    boolean booleanValue2 = ((Boolean) propValue).booleanValue();
                    this.mEnableShake = booleanValue2;
                    QLog.d("VasKuiklyCardAdView", 2, "setProp adEnableShake:", Boolean.valueOf(booleanValue2));
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 2053454305:
                if (propKey.equals("onAdValidExposure")) {
                    this.mAdValidExpoCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    QLog.d("VasKuiklyCardAdView", 2, "setEvent onAdValidExposure");
                    if (!this.mIsValidExpoCallbackDelay) {
                        return true;
                    }
                    D();
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            default:
                return c.a.p(this, propKey, propValue);
        }
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QLog.d("VasKuiklyCardAdView", 1, "onAttachedToWindow:", Integer.valueOf(this.mAdIndex));
        VasKuiklyCardAdManager.f308031a.c(this.mAdIndex, this);
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        x(null);
        c.a.k(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.d("VasKuiklyCardAdView", 1, "onDetachedFromWindow:", Integer.valueOf(this.mAdIndex));
        VasKuiklyCardAdManager.f308031a.o(this.mAdIndex);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (visibility == 0 && this.mIsPageAppear) {
            QLog.d("VasKuiklyCardAdView", 1, "onWindowVisibilityChanged: check visibility");
            w(null);
        }
    }

    public final void q() {
        K();
    }

    public final void r() {
        B();
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    public final void setMContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mContext = context;
    }

    public final void setPageAppear() {
        QLog.d("VasKuiklyCardAdView", 1, "setPageAppear:", Integer.valueOf(this.mAdIndex));
        this.mIsPageAppear = true;
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b bVar) {
        c.a.q(this, bVar);
    }

    public final void u() {
        QLog.d("VasKuiklyCardAdView", 1, "checkViewVisibility:", Integer.valueOf(this.mAdIndex));
        CardAdView cardAdView = this.mCardAdView;
        if (cardAdView != null) {
            cardAdView.j();
        }
    }

    public final void w(@Nullable String params) {
        CardAdView cardAdView;
        QLog.d("VasKuiklyCardAdView", 1, "dispatchAppearEvent:", Integer.valueOf(this.mAdIndex));
        CardAdView cardAdView2 = this.mCardAdView;
        if (cardAdView2 != null) {
            cardAdView2.f0();
        }
        double d16 = com.tencent.mobileqq.ad.cardad.utils.d.d(com.tencent.mobileqq.ad.cardad.utils.d.f186735a, this, false, 2, null);
        if (d16 > 0.0d && (cardAdView = this.mCardAdView) != null) {
            cardAdView.i();
        }
        if (d16 > 0.5d) {
            CardAdView cardAdView3 = this.mCardAdView;
            if (cardAdView3 != null) {
                cardAdView3.r0();
            }
            CardAdView cardAdView4 = this.mCardAdView;
            if (cardAdView4 != null) {
                cardAdView4.q0();
            }
        }
    }

    public final void y(@Nullable String params) {
        QLog.d("VasKuiklyCardAdView", 1, "dispatchDisAppearEvent:", Integer.valueOf(this.mAdIndex));
        this.mIsPageAppear = false;
        CardAdView cardAdView = this.mCardAdView;
        if (cardAdView != null) {
            cardAdView.e0();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1411068523:
                if (method.equals("appear")) {
                    w(params);
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            case -545819969:
                if (method.equals("checkViewVisibility")) {
                    u();
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            case 110948657:
                if (method.equals("diaAppear")) {
                    y(params);
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            case 1557372922:
                if (method.equals("destroy")) {
                    x(params);
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            default:
                return c.a.b(this, method, params, callback);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/vas/adv/kuikly/cardad/VasKuiklyCardAdView$d", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView$b;", "", "b", "g", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements CardAdView.b {
        d() {
        }

        @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView.b
        public void g() {
            QLog.d("VasKuiklyCardAdView", 1, "feedback onHideAd");
            Function1 function1 = VasKuiklyCardAdView.this.mFeedbackCallback;
            if (function1 != null) {
                function1.invoke(new JSONObject());
            }
        }

        @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView.b
        public void b() {
        }
    }
}
