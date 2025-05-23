package com.tencent.mobileqq.zplan.aio.couple;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305;
import com.tencent.filament.zplan.avatar.model.AvatarSlot;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.filament.zplan.scene.couple.CoupleAvatarScene;
import com.tencent.filament.zplan.view.controller.FilamentTouchController;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplan.view.event.TouchEventType;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.perf.report.PerfFeature;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarLayout$jsEventListener$2;
import com.tencent.mobileqq.zplan.model.ZPlanUserInfo;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanCoupleAvatarBodyTypeConfig;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanCoupleAvatarRenderConfig;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.LoadingUtil;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import dl0.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;
import t74.r;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0002\u0088\u0001B>\b\u0007\u0012\u0006\u0010A\u001a\u00020\u000b\u0012\u0006\u0010H\u001a\u00020\u000f\u0012\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001\u0012\f\b\u0002\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001\u0012\t\b\u0002\u0010\u0085\u0001\u001a\u00020\u000f\u00a2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J$\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bJ\u001b\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0002J\u0016\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fJ\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\u0014J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aJ\u0012\u0010\u001d\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u0002H\u0002J\b\u0010!\u001a\u00020\u0002H\u0002J\b\u0010\"\u001a\u00020\u0002H\u0002J\b\u0010#\u001a\u00020\u0002H\u0002J\b\u0010%\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010(\u001a\u00020'H\u0002J\u001b\u0010*\u001a\u00020)2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010\u0012J\f\u0010+\u001a\u00020\u0002*\u00020)H\u0002J\u000e\u0010,\u001a\u00020\u000b*\u0004\u0018\u00010)H\u0002J\u0012\u0010-\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002J$\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b002\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u000fH\u0002J\u0010\u00104\u001a\u00020\u000b2\u0006\u00103\u001a\u000202H\u0002J\b\u00105\u001a\u00020\u000bH\u0002J<\u0010<\u001a\u00020\u00022\b\b\u0002\u00106\u001a\u00020\u000f2\b\b\u0002\u00107\u001a\u00020\u000b2\u0006\u00109\u001a\u0002082\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010:\u001a\u0002022\u0006\u0010;\u001a\u000202H\u0002R\u0017\u0010A\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\"\u0010H\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010\u000eR\u0016\u0010X\u001a\u00020T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010\u000eR\u0016\u0010Z\u001a\u00020T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010\u000eR\u0016\u0010\\\u001a\u00020T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\u000eR\u0018\u0010_\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010^R\u0016\u0010`\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010CR\u0018\u0010c\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010bR\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010bR\u0016\u0010e\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001dR#\u0010j\u001a\n f*\u0004\u0018\u00010]0]8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010g\u001a\u0004\bh\u0010iR\u0014\u0010m\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010lR\u0014\u0010p\u001a\u00020n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010oR\u0018\u0010r\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010qR\u0016\u0010t\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010sR\u0016\u0010v\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010uR\u0016\u0010x\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010>R\u0016\u0010y\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001dR\u0016\u0010z\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010\u001dR\u0014\u0010}\u001a\u00020{8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010|R\u001c\u0010\u0080\u0001\u001a\u00020~8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010g\u001a\u0004\bw\u0010\u007f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0089\u0001"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarLayout;", "Landroid/widget/RelativeLayout;", "", "d0", "c0", "b0", "Lcom/tencent/mobileqq/zplan/aio/couple/g;", "listener", "setEventListener", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "J", "", WadlProxyConsts.SCENE_ID, "H", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "G", "width", "height", "setViewport", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarSubScene;", "scene", "setSubScene", "Z", "Landroid/view/View$OnTouchListener;", "V", "a0", "h0", "g0", "X", "Landroid/widget/RelativeLayout$LayoutParams;", ExifInterface.LATITUDE_SOUTH, "f0", "Lcom/tencent/zplan/common/model/AppTheme;", "L", "Lorg/json/JSONObject;", "K", UserInfo.SEX_FEMALE, "N", "W", "actionType", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "", "M", "", "isHost", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "P", "errorCode", "errorMessage", "Lcom/tencent/mobileqq/zplan/aio/couple/ActionSource;", "actionSource", "hasNetProcess", "hasPaused", "e0", "d", "Ljava/lang/String;", "U", "()Ljava/lang/String;", "peerUin", "e", "I", "O", "()I", "setCurSceneId", "(I)V", "curSceneId", "f", "Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarSubScene;", "subScene", "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", tl.h.F, "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", "nativeApp", "Lcom/tencent/zplan/zplantracing/b;", "i", "Lcom/tencent/zplan/zplantracing/b;", "rootSpan", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "startTimeMillis", BdhLogUtil.LogTag.Tag_Conn, "beforeNetWorkTimeStamp", "D", "afterNetWorkTimeStamp", "E", "dataReadyTimeStamp", "Landroid/view/View;", "Landroid/view/View;", "textureView", NodeProps.MAX_HEIGHT, "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "leftGender", "rightGender", "hasRequestedForGuestAvatarCharacter", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "T", "()Landroid/view/View;", "loadingView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "loadingFirstFrameImageView", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "errorBtn", "Lcom/tencent/mobileqq/zplan/aio/couple/g;", "coupleAvatarEventListener", "Lcom/tencent/zplan/common/model/AppTheme;", "currentAppTheme", "Lcom/tencent/mobileqq/zplan/aio/couple/ActionSource;", "currentActionSource", BdhLogUtil.LogTag.Tag_Req, "peerDressKey", "firstRenderDone", "firstRenderImageSaveDone", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "changeSceneLoadingRunnable", "Lsk0/b;", "()Lsk0/b;", "jsEventListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyle", "<init>", "(Ljava/lang/String;ILandroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CoupleAvatarLayout extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private long beforeNetWorkTimeStamp;

    /* renamed from: D, reason: from kotlin metadata */
    private long afterNetWorkTimeStamp;

    /* renamed from: E, reason: from kotlin metadata */
    private long dataReadyTimeStamp;

    /* renamed from: F, reason: from kotlin metadata */
    private View textureView;

    /* renamed from: G, reason: from kotlin metadata */
    private int maxHeight;

    /* renamed from: H, reason: from kotlin metadata */
    private EnumUserGender leftGender;

    /* renamed from: I, reason: from kotlin metadata */
    private EnumUserGender rightGender;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean hasRequestedForGuestAvatarCharacter;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy loadingView;

    /* renamed from: L, reason: from kotlin metadata */
    private final ImageView loadingFirstFrameImageView;

    /* renamed from: M, reason: from kotlin metadata */
    private final QUIButton errorBtn;

    /* renamed from: N, reason: from kotlin metadata */
    private g coupleAvatarEventListener;

    /* renamed from: P, reason: from kotlin metadata */
    private AppTheme currentAppTheme;

    /* renamed from: Q, reason: from kotlin metadata */
    private ActionSource currentActionSource;

    /* renamed from: R, reason: from kotlin metadata */
    private String peerDressKey;

    /* renamed from: S, reason: from kotlin metadata */
    private volatile boolean firstRenderDone;

    /* renamed from: T, reason: from kotlin metadata */
    private volatile boolean firstRenderImageSaveDone;

    /* renamed from: U, reason: from kotlin metadata */
    private final Runnable changeSceneLoadingRunnable;

    /* renamed from: V, reason: from kotlin metadata */
    private final Lazy jsEventListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String peerUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int curSceneId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CoupleAvatarSubScene subScene;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private IFilamentNativeAppV2305 nativeApp;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.zplan.zplantracing.b rootSpan;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long startTimeMillis;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f330975a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f330976b;

        static {
            int[] iArr = new int[EnumUserGender.values().length];
            try {
                iArr[EnumUserGender.GENDER_FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumUserGender.GENDER_MALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f330975a = iArr;
            int[] iArr2 = new int[CoupleAvatarSubScene.values().length];
            try {
                iArr2[CoupleAvatarSubScene.AIO.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[CoupleAvatarSubScene.IntimateInfo.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            f330976b = iArr2;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aio/couple/CoupleAvatarLayout$d", "Lcom/tencent/filament/zplan/view/controller/FilamentTouchController$b;", "Lcom/tencent/filament/zplan/view/event/TouchEvent;", "event", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements FilamentTouchController.b {
        d() {
        }

        @Override // com.tencent.filament.zplan.view.controller.FilamentTouchController.b
        public void q(TouchEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            IFilamentNativeAppV2305 iFilamentNativeAppV2305 = CoupleAvatarLayout.this.nativeApp;
            if (iFilamentNativeAppV2305 != null) {
                iFilamentNativeAppV2305.dispatchEvent(null, "onTouchEvent", new Gson().toJson(event));
            }
        }
    }

    public /* synthetic */ CoupleAvatarLayout(String str, int i3, Context context, AttributeSet attributeSet, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, context, (i17 & 8) != 0 ? null : attributeSet, (i17 & 16) != 0 ? 0 : i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
    
        r10 = kotlin.sequences.SequencesKt__SequenceBuilderKt.sequence(new com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarLayout$changeBodyTypeIfNeed$$inlined$asSequence$1(r10, null));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void F(JSONObject jSONObject) {
        String forceBodyTypeGirl;
        JSONObject optJSONObject;
        Sequence sequence;
        ZPlanCoupleAvatarBodyTypeConfig coupleAvatarBodyTypeConfig = ZPlanQQMC.INSTANCE.getCoupleAvatarBodyTypeConfig();
        if (coupleAvatarBodyTypeConfig.getEnable()) {
            int i3 = b.f330975a[EnumUserGender.INSTANCE.a(jSONObject.optInt("gender")).ordinal()];
            JSONObject jSONObject2 = null;
            if (i3 != 1) {
                forceBodyTypeGirl = i3 != 2 ? null : coupleAvatarBodyTypeConfig.getForceBodyTypeBoy();
            } else {
                forceBodyTypeGirl = coupleAvatarBodyTypeConfig.getForceBodyTypeGirl();
            }
            if (forceBodyTypeGirl == null || forceBodyTypeGirl.length() == 0) {
                return;
            }
            QLog.i("CoupleAvatarLayout", 1, "changeBodyType to " + forceBodyTypeGirl);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("makeup_info");
            JSONArray optJSONArray = optJSONObject2 != null ? optJSONObject2.optJSONArray("slot_arr") : null;
            if (optJSONArray != null && sequence != null) {
                Iterator it = sequence.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((JSONObject) next).optLong(MiniAppReportManager2.KEY_SLOT_ID) == AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_BODY.getValue()) {
                        jSONObject2 = next;
                        break;
                    }
                }
                jSONObject2 = jSONObject2;
            }
            if (jSONObject2 == null || (optJSONObject = jSONObject2.optJSONObject("item_data")) == null) {
                return;
            }
            optJSONObject.put("model", forceBodyTypeGirl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(CoupleAvatarLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.firstRenderDone) {
            return;
        }
        this$0.g0();
        View view = this$0.textureView;
        if (view == null) {
            return;
        }
        view.setAlpha(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object K(int i3, Continuation<? super JSONObject> continuation) {
        CoupleAvatarLayout$genLoadSceneEventData$1 coupleAvatarLayout$genLoadSceneEventData$1;
        Object coroutine_suspended;
        int i16;
        Ref.ObjectRef objectRef;
        CoupleAvatarLayout coupleAvatarLayout;
        Ref.ObjectRef objectRef2;
        T t16;
        Ref.ObjectRef objectRef3;
        CoupleAvatarLayout coupleAvatarLayout2;
        Ref.ObjectRef objectRef4;
        JSONObject jSONObject;
        EnumUserGender enumUserGender;
        JSONObject jSONObject2;
        Object fetchMyAvatarInfo;
        Ref.ObjectRef objectRef5;
        CoupleAvatarLayout coupleAvatarLayout3;
        T t17;
        Object obj;
        JSONObject jSONObject3;
        String N;
        if (continuation instanceof CoupleAvatarLayout$genLoadSceneEventData$1) {
            coupleAvatarLayout$genLoadSceneEventData$1 = (CoupleAvatarLayout$genLoadSceneEventData$1) continuation;
            int i17 = coupleAvatarLayout$genLoadSceneEventData$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                coupleAvatarLayout$genLoadSceneEventData$1.label = i17 - Integer.MIN_VALUE;
                Object obj2 = coupleAvatarLayout$genLoadSceneEventData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = coupleAvatarLayout$genLoadSceneEventData$1.label;
                EnumUserGender enumUserGender2 = null;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    this.beforeNetWorkTimeStamp = System.currentTimeMillis();
                    objectRef = new Ref.ObjectRef();
                    IZPlanAvatarInfoHelper iZPlanAvatarInfoHelper = (IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class);
                    String str = this.peerUin;
                    coupleAvatarLayout$genLoadSceneEventData$1.L$0 = this;
                    coupleAvatarLayout$genLoadSceneEventData$1.L$1 = objectRef;
                    coupleAvatarLayout$genLoadSceneEventData$1.L$2 = objectRef;
                    coupleAvatarLayout$genLoadSceneEventData$1.I$0 = i3;
                    coupleAvatarLayout$genLoadSceneEventData$1.label = 1;
                    Object fetchOtherAvatarInfoCache = iZPlanAvatarInfoHelper.fetchOtherAvatarInfoCache(str, coupleAvatarLayout$genLoadSceneEventData$1);
                    if (fetchOtherAvatarInfoCache == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coupleAvatarLayout = this;
                    objectRef2 = objectRef;
                    t16 = fetchOtherAvatarInfoCache;
                } else {
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 == 3) {
                                i3 = coupleAvatarLayout$genLoadSceneEventData$1.I$0;
                                objectRef5 = (Ref.ObjectRef) coupleAvatarLayout$genLoadSceneEventData$1.L$1;
                                coupleAvatarLayout3 = (CoupleAvatarLayout) coupleAvatarLayout$genLoadSceneEventData$1.L$0;
                                ResultKt.throwOnFailure(obj2);
                                obj = obj2;
                                jSONObject3 = (JSONObject) obj;
                                if (jSONObject3 == null) {
                                    coupleAvatarLayout3.F(jSONObject3);
                                } else {
                                    jSONObject3 = null;
                                }
                                if (jSONObject3 != null) {
                                    enumUserGender2 = EnumUserGender.INSTANCE.a(jSONObject3.optInt("gender"));
                                }
                                coupleAvatarLayout3.rightGender = enumUserGender2;
                                coupleAvatarLayout3.afterNetWorkTimeStamp = System.currentTimeMillis();
                                N = coupleAvatarLayout3.N((JSONObject) objectRef5.element);
                                String N2 = coupleAvatarLayout3.N(jSONObject3);
                                String str2 = "BodyType40";
                                if (Intrinsics.areEqual(N, "BodyType40") || !Intrinsics.areEqual(N2, "BodyType40")) {
                                    str2 = "GirlStretchConfig";
                                }
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put(CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_LEFT.toString(), objectRef5.element);
                                jSONObject4.put(CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_RIGHT.toString(), jSONObject3);
                                jSONObject4.put(WadlProxyConsts.SCENE_ID, i3);
                                jSONObject4.put("bodyTypeName", str2);
                                jSONObject4.put("enableCrossFade", true);
                                jSONObject4.put("needRecordFrame", true);
                                jSONObject4.put("theme", AppTheme.INSTANCE.b(coupleAvatarLayout3.currentAppTheme));
                                return jSONObject4;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i3 = coupleAvatarLayout$genLoadSceneEventData$1.I$0;
                        objectRef4 = (Ref.ObjectRef) coupleAvatarLayout$genLoadSceneEventData$1.L$2;
                        objectRef3 = (Ref.ObjectRef) coupleAvatarLayout$genLoadSceneEventData$1.L$1;
                        coupleAvatarLayout2 = (CoupleAvatarLayout) coupleAvatarLayout$genLoadSceneEventData$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        t17 = obj2;
                        objectRef4.element = t17;
                        coupleAvatarLayout2.hasRequestedForGuestAvatarCharacter = true;
                        jSONObject = (JSONObject) objectRef3.element;
                        if (jSONObject != null) {
                            enumUserGender = EnumUserGender.INSTANCE.a(jSONObject.optInt("gender"));
                        } else {
                            enumUserGender = null;
                        }
                        coupleAvatarLayout2.leftGender = enumUserGender;
                        jSONObject2 = (JSONObject) objectRef3.element;
                        if (jSONObject2 != null) {
                            coupleAvatarLayout2.F(jSONObject2);
                        }
                        IZPlanAvatarInfoHelper iZPlanAvatarInfoHelper2 = (IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class);
                        coupleAvatarLayout$genLoadSceneEventData$1.L$0 = coupleAvatarLayout2;
                        coupleAvatarLayout$genLoadSceneEventData$1.L$1 = objectRef3;
                        coupleAvatarLayout$genLoadSceneEventData$1.L$2 = null;
                        coupleAvatarLayout$genLoadSceneEventData$1.I$0 = i3;
                        coupleAvatarLayout$genLoadSceneEventData$1.label = 3;
                        fetchMyAvatarInfo = iZPlanAvatarInfoHelper2.fetchMyAvatarInfo(coupleAvatarLayout$genLoadSceneEventData$1);
                        if (fetchMyAvatarInfo == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef5 = objectRef3;
                        coupleAvatarLayout3 = coupleAvatarLayout2;
                        obj = fetchMyAvatarInfo;
                        jSONObject3 = (JSONObject) obj;
                        if (jSONObject3 == null) {
                        }
                        if (jSONObject3 != null) {
                        }
                        coupleAvatarLayout3.rightGender = enumUserGender2;
                        coupleAvatarLayout3.afterNetWorkTimeStamp = System.currentTimeMillis();
                        N = coupleAvatarLayout3.N((JSONObject) objectRef5.element);
                        String N22 = coupleAvatarLayout3.N(jSONObject3);
                        String str22 = "BodyType40";
                        if (Intrinsics.areEqual(N, "BodyType40")) {
                        }
                        str22 = "GirlStretchConfig";
                        JSONObject jSONObject42 = new JSONObject();
                        jSONObject42.put(CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_LEFT.toString(), objectRef5.element);
                        jSONObject42.put(CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_RIGHT.toString(), jSONObject3);
                        jSONObject42.put(WadlProxyConsts.SCENE_ID, i3);
                        jSONObject42.put("bodyTypeName", str22);
                        jSONObject42.put("enableCrossFade", true);
                        jSONObject42.put("needRecordFrame", true);
                        jSONObject42.put("theme", AppTheme.INSTANCE.b(coupleAvatarLayout3.currentAppTheme));
                        return jSONObject42;
                    }
                    i3 = coupleAvatarLayout$genLoadSceneEventData$1.I$0;
                    objectRef = (Ref.ObjectRef) coupleAvatarLayout$genLoadSceneEventData$1.L$2;
                    objectRef2 = (Ref.ObjectRef) coupleAvatarLayout$genLoadSceneEventData$1.L$1;
                    coupleAvatarLayout = (CoupleAvatarLayout) coupleAvatarLayout$genLoadSceneEventData$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    t16 = obj2;
                }
                objectRef.element = t16;
                if (objectRef2.element != 0) {
                    IZPlanAvatarInfoHelper iZPlanAvatarInfoHelper3 = (IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class);
                    String str3 = coupleAvatarLayout.peerUin;
                    coupleAvatarLayout$genLoadSceneEventData$1.L$0 = coupleAvatarLayout;
                    coupleAvatarLayout$genLoadSceneEventData$1.L$1 = objectRef2;
                    coupleAvatarLayout$genLoadSceneEventData$1.L$2 = objectRef2;
                    coupleAvatarLayout$genLoadSceneEventData$1.I$0 = i3;
                    coupleAvatarLayout$genLoadSceneEventData$1.label = 2;
                    Object fetchOtherAvatarInfoWithUin = iZPlanAvatarInfoHelper3.fetchOtherAvatarInfoWithUin(str3, coupleAvatarLayout$genLoadSceneEventData$1);
                    if (fetchOtherAvatarInfoWithUin == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef4 = objectRef2;
                    objectRef3 = objectRef4;
                    coupleAvatarLayout2 = coupleAvatarLayout;
                    t17 = fetchOtherAvatarInfoWithUin;
                    objectRef4.element = t17;
                    coupleAvatarLayout2.hasRequestedForGuestAvatarCharacter = true;
                    jSONObject = (JSONObject) objectRef3.element;
                    if (jSONObject != null) {
                    }
                    coupleAvatarLayout2.leftGender = enumUserGender;
                    jSONObject2 = (JSONObject) objectRef3.element;
                    if (jSONObject2 != null) {
                    }
                    IZPlanAvatarInfoHelper iZPlanAvatarInfoHelper22 = (IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class);
                    coupleAvatarLayout$genLoadSceneEventData$1.L$0 = coupleAvatarLayout2;
                    coupleAvatarLayout$genLoadSceneEventData$1.L$1 = objectRef3;
                    coupleAvatarLayout$genLoadSceneEventData$1.L$2 = null;
                    coupleAvatarLayout$genLoadSceneEventData$1.I$0 = i3;
                    coupleAvatarLayout$genLoadSceneEventData$1.label = 3;
                    fetchMyAvatarInfo = iZPlanAvatarInfoHelper22.fetchMyAvatarInfo(coupleAvatarLayout$genLoadSceneEventData$1);
                    if (fetchMyAvatarInfo == coroutine_suspended) {
                    }
                } else {
                    objectRef3 = objectRef2;
                    coupleAvatarLayout2 = coupleAvatarLayout;
                    jSONObject = (JSONObject) objectRef3.element;
                    if (jSONObject != null) {
                    }
                    coupleAvatarLayout2.leftGender = enumUserGender;
                    jSONObject2 = (JSONObject) objectRef3.element;
                    if (jSONObject2 != null) {
                    }
                    IZPlanAvatarInfoHelper iZPlanAvatarInfoHelper222 = (IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class);
                    coupleAvatarLayout$genLoadSceneEventData$1.L$0 = coupleAvatarLayout2;
                    coupleAvatarLayout$genLoadSceneEventData$1.L$1 = objectRef3;
                    coupleAvatarLayout$genLoadSceneEventData$1.L$2 = null;
                    coupleAvatarLayout$genLoadSceneEventData$1.I$0 = i3;
                    coupleAvatarLayout$genLoadSceneEventData$1.label = 3;
                    fetchMyAvatarInfo = iZPlanAvatarInfoHelper222.fetchMyAvatarInfo(coupleAvatarLayout$genLoadSceneEventData$1);
                    if (fetchMyAvatarInfo == coroutine_suspended) {
                    }
                }
            }
        }
        coupleAvatarLayout$genLoadSceneEventData$1 = new CoupleAvatarLayout$genLoadSceneEventData$1(this, continuation);
        Object obj22 = coupleAvatarLayout$genLoadSceneEventData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = coupleAvatarLayout$genLoadSceneEventData$1.label;
        EnumUserGender enumUserGender22 = null;
        if (i16 != 0) {
        }
        objectRef.element = t16;
        if (objectRef2.element != 0) {
        }
    }

    private final AppTheme L() {
        if (QQTheme.isNowThemeIsNight()) {
            return AppTheme.NIGHT;
        }
        return AppTheme.DAY;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        r8 = kotlin.sequences.SequencesKt__SequenceBuilderKt.sequence(new com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarLayout$getBodyType$$inlined$asSequence$1(r8, null));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String N(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject optJSONObject;
        Sequence sequence;
        Object obj;
        if (jSONObject == null) {
            return "BodyType40";
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("makeup_info");
        String str = null;
        JSONArray optJSONArray = optJSONObject2 != null ? optJSONObject2.optJSONArray("slot_arr") : null;
        if (optJSONArray == null || sequence == null) {
            jSONObject2 = null;
        } else {
            Iterator it = sequence.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((JSONObject) obj).optLong(MiniAppReportManager2.KEY_SLOT_ID) == AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_BODY.getValue()) {
                    break;
                }
            }
            jSONObject2 = (JSONObject) obj;
        }
        if (jSONObject2 != null && (optJSONObject = jSONObject2.optJSONObject("item_data")) != null) {
            str = optJSONObject.optString("model");
        }
        if (str == null) {
            return "BodyType40";
        }
        if (Intrinsics.areEqual(str, "CMShow/Assets/Character/AvatarV2/BodyType/BoyStretchConfig")) {
            return "BoyStretchConfig";
        }
        if (!Intrinsics.areEqual(str, "CMShow/Assets/Character/AvatarV2/BodyType/GirlStretchConfig")) {
            return "BodyType40";
        }
        return "GirlStretchConfig";
    }

    private final String P() {
        int i3 = b.f330976b[this.subScene.ordinal()];
        if (i3 == 1) {
            return "pg_aio";
        }
        if (i3 == 2) {
            return "pg_zplan_friend_time";
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String Q(boolean isHost) {
        String e16 = bb.f335811a.e();
        if (e16 == null) {
            return "0";
        }
        ZPlanUserInfo userZPlanInfoFromCache = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfoFromCache(this.peerUin);
        ZPlanUserInfo userZPlanInfoFromCache2 = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfoFromCache(e16);
        Boolean bool = null;
        if (isHost) {
            if (userZPlanInfoFromCache2 != null) {
                bool = Boolean.valueOf(userZPlanInfoFromCache2.hasCustomDressUp());
            }
        } else if (userZPlanInfoFromCache != null) {
            bool = Boolean.valueOf(userZPlanInfoFromCache.hasCustomDressUp());
        }
        if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return "0";
        }
        return "1";
    }

    private final sk0.b R() {
        return (sk0.b) this.jsEventListener.getValue();
    }

    private final RelativeLayout.LayoutParams S() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View T() {
        return (View) this.loadingView.getValue();
    }

    private final View.OnTouchListener V() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new c(new FilamentTouchController(context, new d()));
    }

    private final void X() {
        try {
            this.errorBtn.setType(2);
            this.errorBtn.setText("\u91cd\u65b0\u52a0\u8f7d");
            this.errorBtn.setTextColor(-1);
            this.errorBtn.setThemeId(1001);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.tencent.sqshow.zootopia.utils.i.b(88), com.tencent.sqshow.zootopia.utils.i.b(30));
            layoutParams.addRule(13);
            this.errorBtn.setVisibility(8);
            aa.d(this.errorBtn, new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aio.couple.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CoupleAvatarLayout.Y(CoupleAvatarLayout.this, view);
                }
            });
            addView(this.errorBtn, layoutParams);
        } catch (Exception e16) {
            QLog.e("CoupleAvatarLayout", 1, "initErrorView error:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(CoupleAvatarLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f0(this$0.curSceneId);
        this$0.g0();
        View view2 = this$0.textureView;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        this$0.errorBtn.setVisibility(8);
        QLog.i("CoupleAvatarLayout", 1, "errorBtn onClick show loading");
    }

    private final void Z(com.tencent.zplan.zplantracing.c spanContext) {
        ZPlanCoupleAvatarRenderConfig coupleAvatarRenderConfig = ZPlanQQMC.INSTANCE.getCoupleAvatarRenderConfig();
        QLog.i("CoupleAvatarLayout", 1, "initNativeApp coupleRenderConfig:" + coupleAvatarRenderConfig);
        FilamentUrlTemplate F = FilamentFeatureUtil.f106409g.F();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        int fps = coupleAvatarRenderConfig.getFps();
        fl0.a aVar = fl0.a.f399763a;
        IFilamentNativeAppV2305 c16 = FilamentRenderFactory.f105773b.c(new sk0.a(F, false, context, fps, (k) aVar.a(k.class), (dl0.d) aVar.a(dl0.d.class), (dl0.g) aVar.a(dl0.g.class)));
        this.nativeApp = c16;
        if (c16 != null) {
            c16.addEventListener("onFirstFrameRenderEnd", R());
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.addEventListener("onFirstFrameImageReady", R());
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23052 = this.nativeApp;
        if (iFilamentNativeAppV23052 != null) {
            iFilamentNativeAppV23052.addEventListener("CoupleAvatarScene.Touch", R());
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23053 = this.nativeApp;
        if (iFilamentNativeAppV23053 != null) {
            iFilamentNativeAppV23053.addEventListener("onGetNodePoint", R());
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23054 = this.nativeApp;
        if (iFilamentNativeAppV23054 != null) {
            iFilamentNativeAppV23054.addEventListener("onFilamentRenderFail", R());
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23055 = this.nativeApp;
        if (iFilamentNativeAppV23055 != null) {
            iFilamentNativeAppV23055.startWithEntry(spanContext, "bundle/scenes/multi_avatar/main.js");
        }
    }

    private final void a0() {
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        View view = iFilamentNativeAppV2305 != null ? iFilamentNativeAppV2305.getView() : null;
        this.textureView = view;
        if (view != null) {
            Intrinsics.checkNotNull(view);
            view.setAlpha(0.0f);
            view.setOnTouchListener(V());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(14);
            addView(view, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(int errorCode, String errorMessage, ActionSource actionSource, int sceneId, boolean hasNetProcess, boolean hasPaused) {
        long currentTimeMillis = System.currentTimeMillis() - this.startTimeMillis;
        long currentTimeMillis2 = System.currentTimeMillis() - this.dataReadyTimeStamp;
        long j3 = this.afterNetWorkTimeStamp - this.beforeNetWorkTimeStamp;
        HashMap hashMap = new HashMap();
        hashMap.put("timeCost", String.valueOf(currentTimeMillis));
        hashMap.put("engineTimeCost", String.valueOf(currentTimeMillis2));
        hashMap.put("netTimeCost", String.valueOf(j3));
        hashMap.put("errorCode", String.valueOf(errorCode));
        hashMap.put("errorMessage", errorMessage);
        hashMap.put("source", actionSource.toString());
        hashMap.put(WadlProxyConsts.SCENE_ID, String.valueOf(sceneId));
        hashMap.put("hasAnyNetProcess", String.valueOf(hasNetProcess));
        hashMap.put("hasPaused", String.valueOf(hasPaused));
        r.d("0AND0YAG6R40RLM6", "zplanCoupleAvatarShow", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(int sceneId) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CoupleAvatarLayout$runAPP$1(this, sceneId, null), 3, null);
    }

    private final void g0() {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        String e16 = bb.f335811a.e();
        if (e16 == null) {
            return;
        }
        String str = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(e16).appearanceKey;
        if (!(e16.length() == 0)) {
            if (!(str.length() == 0)) {
                if (!(this.peerDressKey.length() == 0)) {
                    String c16 = e.f331005a.c(this.peerDressKey, str, this.curSceneId, this.currentAppTheme);
                    if (c16 == null || c16.length() == 0) {
                        this.loadingFirstFrameImageView.setVisibility(8);
                        h0();
                        return;
                    }
                    this.loadingFirstFrameImageView.setImageDrawable(URLDrawable.getFileDrawable(c16, obtain));
                    this.loadingFirstFrameImageView.setVisibility(0);
                    T().setVisibility(8);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    if (this.loadingFirstFrameImageView.getParent() == null) {
                        addView(this.loadingFirstFrameImageView, layoutParams);
                    }
                    QLog.i("CoupleAvatarLayout", 1, "show first frame hide loading firstFramePath:" + c16);
                    return;
                }
            }
        }
        QLog.e("CoupleAvatarLayout", 1, "uin empty");
        this.loadingFirstFrameImageView.setVisibility(8);
        h0();
    }

    private final void h0() {
        T().setVisibility(0);
        if (T().getParent() == null) {
            addView(T(), S());
        }
    }

    public final void G() {
        CoroutineScope f16;
        if (this.firstRenderImageSaveDone && (f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e)) != null) {
            CorountineFunKt.e(f16, "CoupleAvatarLayout_changeDress", null, null, null, new CoupleAvatarLayout$changeDress$1(this, null), 14, null);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(8:5|6|7|(1:(2:10|11)(2:23|24))(3:25|26|(1:28)(1:29))|12|(3:14|(1:16)(1:19)|17)|20|21))|32|6|7|(0)(0)|12|(0)|20|21) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0080, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0081, code lost:
    
        com.tencent.qphone.base.util.QLog.e("CoupleAvatarLayout", 1, "changeScene failed t:" + r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006b A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:11:0x0029, B:12:0x005f, B:14:0x006b, B:16:0x006f, B:17:0x0075, B:26:0x0053), top: B:7:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object H(int i3, Continuation<? super Unit> continuation) {
        CoupleAvatarLayout$changeScene$1 coupleAvatarLayout$changeScene$1;
        Object coroutine_suspended;
        int i16;
        CoupleAvatarLayout coupleAvatarLayout;
        IFilamentNativeAppV2305 iFilamentNativeAppV2305;
        if (continuation instanceof CoupleAvatarLayout$changeScene$1) {
            coupleAvatarLayout$changeScene$1 = (CoupleAvatarLayout$changeScene$1) continuation;
            int i17 = coupleAvatarLayout$changeScene$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                coupleAvatarLayout$changeScene$1.label = i17 - Integer.MIN_VALUE;
                Object obj = coupleAvatarLayout$changeScene$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = coupleAvatarLayout$changeScene$1.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    this.curSceneId = i3;
                    this.currentActionSource = ActionSource.CHANGE_SCENE;
                    this.startTimeMillis = System.currentTimeMillis();
                    this.firstRenderDone = false;
                    ThreadManagerV2.getUIHandlerV2().postDelayed(this.changeSceneLoadingRunnable, 600L);
                    coupleAvatarLayout$changeScene$1.L$0 = this;
                    coupleAvatarLayout$changeScene$1.label = 1;
                    obj = K(i3, coupleAvatarLayout$changeScene$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coupleAvatarLayout = this;
                } else if (i16 == 1) {
                    coupleAvatarLayout = (CoupleAvatarLayout) coupleAvatarLayout$changeScene$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                JSONObject jSONObject = (JSONObject) obj;
                coupleAvatarLayout.dataReadyTimeStamp = System.currentTimeMillis();
                iFilamentNativeAppV2305 = coupleAvatarLayout.nativeApp;
                if (iFilamentNativeAppV2305 != null) {
                    com.tencent.zplan.zplantracing.b bVar = coupleAvatarLayout.rootSpan;
                    iFilamentNativeAppV2305.dispatchEvent(bVar != null ? bVar.c() : null, "CoupleAvatarScene.ChangeScene", jSONObject.toString());
                }
                return Unit.INSTANCE;
            }
        }
        coupleAvatarLayout$changeScene$1 = new CoupleAvatarLayout$changeScene$1(this, continuation);
        Object obj2 = coupleAvatarLayout$changeScene$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = coupleAvatarLayout$changeScene$1.label;
        if (i16 != 0) {
        }
        JSONObject jSONObject2 = (JSONObject) obj2;
        coupleAvatarLayout.dataReadyTimeStamp = System.currentTimeMillis();
        iFilamentNativeAppV2305 = coupleAvatarLayout.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
        }
        return Unit.INSTANCE;
    }

    public final void J(com.tencent.zplan.zplantracing.c spanContext, String type, String data) {
        Intrinsics.checkNotNullParameter(type, "type");
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.dispatchEvent(spanContext, type, data);
        }
    }

    /* renamed from: O, reason: from getter */
    public final int getCurSceneId() {
        return this.curSceneId;
    }

    /* renamed from: U, reason: from getter */
    public final String getPeerUin() {
        return this.peerUin;
    }

    public final void b0() {
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.removeEventListener("onFirstFrameRenderEnd");
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23052 = this.nativeApp;
        if (iFilamentNativeAppV23052 != null) {
            iFilamentNativeAppV23052.removeEventListener("onFirstFrameImageReady");
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23053 = this.nativeApp;
        if (iFilamentNativeAppV23053 != null) {
            iFilamentNativeAppV23053.removeEventListener("CoupleAvatarScene.Touch");
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23054 = this.nativeApp;
        if (iFilamentNativeAppV23054 != null) {
            iFilamentNativeAppV23054.removeEventListener("onGetNodePoint");
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23055 = this.nativeApp;
        if (iFilamentNativeAppV23055 != null) {
            iFilamentNativeAppV23055.removeEventListener("onFilamentRenderFail");
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV23056 = this.nativeApp;
        if (iFilamentNativeAppV23056 != null) {
            iFilamentNativeAppV23056.destroy();
        }
        this.nativeApp = null;
        this.textureView = null;
        this.errorBtn.setBackground(null);
        this.coupleAvatarEventListener = null;
    }

    public final void c0() {
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.pause();
        }
    }

    public final void d0() {
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.resume();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        if (mode == 0 || (mode == Integer.MIN_VALUE && size > this.maxHeight)) {
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.maxHeight, Integer.MIN_VALUE);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void setCurSceneId(int i3) {
        this.curSceneId = i3;
    }

    public final void setEventListener(g listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.coupleAvatarEventListener = listener;
    }

    public final void setSubScene(CoupleAvatarSubScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.subScene = scene;
    }

    public final void setViewport(int width, int height) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", width);
        jSONObject.put("height", height);
        this.maxHeight = height;
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            com.tencent.zplan.zplantracing.b bVar = this.rootSpan;
            iFilamentNativeAppV2305.dispatchEvent(bVar != null ? bVar.c() : null, "CoupleAvatarScene.SetViewport", jSONObject.toString());
        }
        View view = this.textureView;
        if (view != null) {
            Intrinsics.checkNotNull(view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = width;
            layoutParams2.height = height;
            layoutParams2.addRule(14);
            view.setLayoutParams(layoutParams2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarLayout(String peerUin, int i3, final Context context, AttributeSet attributeSet, int i16) {
        super(context, attributeSet, i16);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        Intrinsics.checkNotNullParameter(context, "context");
        this.peerUin = peerUin;
        this.curSceneId = i3;
        this.subScene = CoupleAvatarSubScene.AIO;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarLayout$loadingView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                Context context2 = context;
                ViewUtils viewUtils = ViewUtils.f352270a;
                return LoadingUtil.getLoadingView(context2, viewUtils.a(20.0f), viewUtils.a(20.0f), 2);
            }
        });
        this.loadingView = lazy;
        this.loadingFirstFrameImageView = new ImageView(context);
        this.errorBtn = new QUIButton(context);
        this.currentAppTheme = L();
        this.currentActionSource = ActionSource.FIRST_INIT_APP;
        this.peerDressKey = "";
        this.changeSceneLoadingRunnable = new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.couple.b
            @Override // java.lang.Runnable
            public final void run() {
                CoupleAvatarLayout.I(CoupleAvatarLayout.this);
            }
        };
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<CoupleAvatarLayout$jsEventListener$2.AnonymousClass1>() { // from class: com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarLayout$jsEventListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarLayout$jsEventListener$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final CoupleAvatarLayout coupleAvatarLayout = CoupleAvatarLayout.this;
                return new sk0.b() { // from class: com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarLayout$jsEventListener$2.1
                    /* JADX WARN: Code restructure failed: missing block: B:95:0x02bd, code lost:
                    
                        r1 = r1.coupleAvatarEventListener;
                     */
                    @Override // sk0.b
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void handleEvent(com.tencent.zplan.zplantracing.c spanContext, String type, String data) {
                        g gVar;
                        g gVar2;
                        g gVar3;
                        Map M;
                        String optString;
                        String str;
                        String str2;
                        String str3;
                        AppTheme appTheme;
                        boolean z16;
                        Runnable runnable;
                        com.tencent.zplan.zplantracing.b bVar;
                        ActionSource actionSource;
                        long j3;
                        long j16;
                        long j17;
                        long j18;
                        g gVar4;
                        Map M2;
                        Intrinsics.checkNotNullParameter(type, "type");
                        int i17 = 1;
                        QLog.i("CoupleAvatarLayout", 1, "handleEvent, type: " + type + ", data: " + data);
                        switch (type.hashCode()) {
                            case -1885461129:
                                if (type.equals("onGetNodePoint") && gVar != null) {
                                    gVar.h(CoupleAvatarLayoutEvent.GET_NODE_POINT, data);
                                    return;
                                }
                                return;
                            case -1565730423:
                                if (type.equals("onFilamentRenderFail")) {
                                    QLog.i("CoupleAvatarLayout", 1, "IntimateCoupleScene_Launch renderFail");
                                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CoupleAvatarLayout$jsEventListener$2$1$handleEvent$2(CoupleAvatarLayout.this, null), 3, null);
                                    CoupleAvatarLayout.this.W(data);
                                    gVar2 = CoupleAvatarLayout.this.coupleAvatarEventListener;
                                    if (gVar2 != null) {
                                        gVar2.h(CoupleAvatarLayoutEvent.RENDER_FAIL, data);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            case -514598876:
                                if (type.equals("CoupleAvatarScene.Touch")) {
                                    gVar3 = CoupleAvatarLayout.this.coupleAvatarEventListener;
                                    if (gVar3 != null) {
                                        gVar3.h(CoupleAvatarLayoutEvent.TOUCH_EVENT, data);
                                    }
                                    JSONObject b16 = com.tencent.zplan.common.utils.h.f385294a.b(data);
                                    if (b16 == null) {
                                        return;
                                    }
                                    CoupleAvatarScene.AvatarTarget q16 = CoupleAvatarScene.INSTANCE.q(b16.optString("touchEventTarget"));
                                    if (q16 == CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_RIGHT || q16 == CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_LEFT) {
                                        String optString2 = b16.optString("touchEventType");
                                        if (!Intrinsics.areEqual(optString2, TouchEventType.TapUp.toString())) {
                                            if (Intrinsics.areEqual(optString2, TouchEventType.DoubleTap.toString())) {
                                                i17 = 2;
                                            } else {
                                                i17 = Intrinsics.areEqual(optString2, TouchEventType.LongPress.toString()) ? q16 == CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_LEFT ? 3 : 4 : 0;
                                            }
                                        }
                                        M = CoupleAvatarLayout.this.M("click", i17);
                                        VideoReport.reportEvent("ev_zplan_avatar_action", M);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            case 361827844:
                                if (type.equals("onFirstFrameImageReady")) {
                                    QLog.i("CoupleAvatarLayout", 1, "onEvent FIRST_FRAME_IMAGE_READY, data=" + data);
                                    JSONObject b17 = com.tencent.zplan.common.utils.h.f385294a.b(data);
                                    if (b17 == null || (optString = b17.optString("imagePath")) == null) {
                                        return;
                                    }
                                    int optInt = b17.optInt(WadlProxyConsts.SCENE_ID);
                                    if (optString.length() == 0) {
                                        QLog.e("CoupleAvatarLayout", 1, "pngPath empty");
                                        return;
                                    }
                                    String e16 = bb.f335811a.e();
                                    if (e16 == null) {
                                        return;
                                    }
                                    String str4 = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(e16).appearanceKey;
                                    str = CoupleAvatarLayout.this.peerDressKey;
                                    if (!(str.length() == 0) && optInt != 0) {
                                        if (!(str4.length() == 0)) {
                                            e eVar = e.f331005a;
                                            str3 = CoupleAvatarLayout.this.peerDressKey;
                                            appTheme = CoupleAvatarLayout.this.currentAppTheme;
                                            eVar.d(optString, str3, str4, optInt, appTheme);
                                            CoupleAvatarLayout.this.firstRenderImageSaveDone = true;
                                            z16 = CoupleAvatarLayout.this.hasRequestedForGuestAvatarCharacter;
                                            if (z16) {
                                                return;
                                            }
                                            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
                                            if (f16 != null) {
                                                CorountineFunKt.e(f16, "CoupleAvatarLayout_fetchOtherAvatarInfoWithUin", null, null, null, new CoupleAvatarLayout$jsEventListener$2$1$handleEvent$3(CoupleAvatarLayout.this, null), 14, null);
                                            }
                                            CoupleAvatarLayout.this.hasRequestedForGuestAvatarCharacter = true;
                                            return;
                                        }
                                    }
                                    str2 = CoupleAvatarLayout.this.peerDressKey;
                                    QLog.e("CoupleAvatarLayout", 1, "uin empty peerDressKey:" + str2 + " peerUin:" + CoupleAvatarLayout.this.getPeerUin() + " sceneId:" + optInt);
                                    return;
                                }
                                return;
                            case 1621140201:
                                if (type.equals("onFirstFrameRenderEnd")) {
                                    CoupleAvatarLayout.this.firstRenderDone = true;
                                    Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                                    runnable = CoupleAvatarLayout.this.changeSceneLoadingRunnable;
                                    uIHandlerV2.removeCallbacks(runnable);
                                    bVar = CoupleAvatarLayout.this.rootSpan;
                                    if (bVar != null) {
                                        bVar.b();
                                    }
                                    JSONObject b18 = com.tencent.zplan.common.utils.h.f385294a.b(data);
                                    if (b18 == null) {
                                        return;
                                    }
                                    boolean optBoolean = b18.optBoolean("hasNetProcess");
                                    boolean optBoolean2 = b18.optBoolean("hasPaused");
                                    int optInt2 = b18.optInt(WadlProxyConsts.SCENE_ID);
                                    CoupleAvatarLayout coupleAvatarLayout2 = CoupleAvatarLayout.this;
                                    actionSource = coupleAvatarLayout2.currentActionSource;
                                    coupleAvatarLayout2.e0(0, "", actionSource, optInt2, optBoolean, optBoolean2);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    j3 = CoupleAvatarLayout.this.startTimeMillis;
                                    long j19 = currentTimeMillis - j3;
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    j16 = CoupleAvatarLayout.this.dataReadyTimeStamp;
                                    long j26 = currentTimeMillis2 - j16;
                                    j17 = CoupleAvatarLayout.this.afterNetWorkTimeStamp;
                                    j18 = CoupleAvatarLayout.this.beforeNetWorkTimeStamp;
                                    QLog.i("CoupleAvatarLayout", 1, "IntimateCoupleScene_Launch firstRender, costTime:" + j19 + " engineCostTime:" + j26 + " netCostTime:" + (j17 - j18));
                                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CoupleAvatarLayout$jsEventListener$2$1$handleEvent$1(CoupleAvatarLayout.this, null), 3, null);
                                    gVar4 = CoupleAvatarLayout.this.coupleAvatarEventListener;
                                    if (gVar4 != null) {
                                        gVar4.h(CoupleAvatarLayoutEvent.FIRST_RENDER, data);
                                    }
                                    M2 = CoupleAvatarLayout.this.M("imp", 0);
                                    VideoReport.reportEvent("ev_zplan_avatar_action", M2);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                };
            }
        });
        this.jsEventListener = lazy2;
        this.startTimeMillis = System.currentTimeMillis();
        this.peerDressKey = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(peerUin).appearanceKey;
        PerfFeature.a(PerfFeature.CustomFlag.ZPlanFilamentCoupleAvatar);
        QLog.i("CoupleAvatarLayout", 1, "IntimateCoupleScene_Launch start, startTimeMillis:" + this.startTimeMillis);
        com.tencent.zplan.zplantracing.b startRootSpan = ZPlanSpanFactory.INSTANCE.startRootSpan("IntimateCoupleScene_Launch");
        this.rootSpan = startRootSpan;
        Z(startRootSpan != null ? startRootSpan.c() : null);
        a0();
        g0();
        X();
        f0(this.curSceneId);
        d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> M(String actionType, int clickType) {
        Map<String, String> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_current_scene", String.valueOf(this.curSceneId)), TuplesKt.to("zplan_current_page", P()), TuplesKt.to("zplan_action_type", actionType), TuplesKt.to("zplan_is_dress_up_user", Q(true)), TuplesKt.to("zplan_other_is_dress_up", Q(false)), TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY));
        if (Intrinsics.areEqual(actionType, "click")) {
            mutableMapOf.put("zplan_avatar_click_type", String.valueOf(clickType));
        }
        if (Intrinsics.areEqual(actionType, "imp")) {
            mutableMapOf.put(SquareReportConst.Key.KEY_ZPLAN_INTIMATE_UIN, this.peerUin);
        }
        return mutableMapOf;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/aio/couple/CoupleAvatarLayout$c", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FilamentTouchController f330977d;

        c(FilamentTouchController filamentTouchController) {
            this.f330977d = filamentTouchController;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v3, MotionEvent event) {
            if (event == null) {
                return true;
            }
            if (event.getY() <= com.tencent.sqshow.zootopia.utils.i.b(30)) {
                return false;
            }
            if (event.getPointerCount() == 1) {
                GestureDetector m3 = this.f330977d.m();
                if (m3 != null) {
                    m3.onTouchEvent(event);
                }
            } else {
                ScaleGestureDetector o16 = this.f330977d.o();
                if (o16 != null) {
                    o16.onTouchEvent(event);
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(String data) {
        JSONObject b16 = data != null ? com.tencent.zplan.common.utils.h.f385294a.b(data) : null;
        int optInt = b16 != null ? b16.optInt("errorCode") : -1;
        String optString = b16 != null ? b16.optString("errorMessage") : null;
        if (optString == null) {
            optString = "";
        }
        e0(optInt, optString, this.currentActionSource, b16 != null ? b16.optInt(WadlProxyConsts.SCENE_ID) : -1, b16 != null ? b16.optBoolean("hasNetProcess") : true, b16 != null ? b16.optBoolean("hasPaused") : false);
    }
}
