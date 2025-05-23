package com.tencent.mobileqq.zplan.sharedengine.part;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.app.AppInterface;
import com.tencent.filament.zplan.business.api.IBusinessScene;
import com.tencent.filament.zplan.business.api.SceneType;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.image.URLDrawable;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.api.IDrawerApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.de;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.meme.frameanim.e;
import com.tencent.mobileqq.zplan.sharedengine.drawer.DrawerBusinessScene;
import com.tencent.mobileqq.zplan.sharedengine.part.QQSettingMeZPlanFilamentPart;
import com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.sharedengine.ZPlanShareEngineScene;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import vk0.b;
import wk0.b;

@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t*\u0006\u008c\u0001\u0090\u0001\u0094\u0001\u0018\u0000 \u009e\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u009f\u0001\u00a0\u0001B\t\u00a2\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\bH\u0002J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0002J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\bH\u0002J\b\u0010&\u001a\u00020\u0004H\u0002J\b\u0010'\u001a\u00020\u0004H\u0002J\b\u0010(\u001a\u00020\u0004H\u0002J\b\u0010)\u001a\u00020\u0004H\u0002J\b\u0010*\u001a\u00020\u0004H\u0002J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0014H\u0002J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u0014H\u0002J\u0010\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0014H\u0002J\u0018\u00103\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u0014H\u0002J\u0012\u00105\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u000206H\u0016J\u0012\u0010;\u001a\u00020\u00042\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010<\u001a\u00020\u00042\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\b\u0010=\u001a\u00020\u0004H\u0016J\b\u0010>\u001a\u00020\u0004H\u0016J\b\u0010?\u001a\u00020\u0004H\u0016J\u0012\u0010@\u001a\u00020\u00042\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u0018\u0010C\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000bH\u0016R\u001b\u0010I\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001b\u0010L\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010F\u001a\u0004\bK\u0010HR\u0018\u0010O\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010R\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u001b\u0010V\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010F\u001a\u0004\bT\u0010UR$\u0010^\u001a\u0004\u0018\u00010W8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010l\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010QR\u0016\u0010n\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010mR\u0016\u0010p\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010dR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010v\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010mR\u0018\u0010z\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010}\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001b\u0010\u0083\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0080\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u0010\u0089\u0001\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0088\u0001\u0010oR\u0018\u0010\u008b\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008a\u0001\u0010QR\u0018\u0010\u008f\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0018\u0010\u0093\u0001\u001a\u00030\u0090\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0018\u0010\u0097\u0001\u001a\u00030\u0094\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0018\u0010\u009b\u0001\u001a\u00030\u0098\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u00a8\u0006\u00a1\u0001"}, d2 = {"Lcom/tencent/mobileqq/zplan/sharedengine/part/QQSettingMeZPlanFilamentPart;", "Lcom/tencent/mobileqq/part/a;", "Lvk0/d;", "Ls74/a;", "", "hideLoadingView", "Aa", LocaleUtils.L_JAPANESE, "", "za", "ua", "Lcom/tencent/filament/zplan/business/api/IBusinessScene;", "pa", "Ea", "Qa", "Landroid/view/View;", "view", "ta", "xa", "wa", "", "ia", "", "picPath", "Na", "Ra", "ga", "Ma", "ea", "Ka", "isShowStatic", "ha", "Sa", "Lcom/tencent/image/URLDrawable;", "drawable", "Pa", "loadingCompleted", "Ya", "Ha", "La", "Fa", "Ga", "Ja", "y", "la", "offset", "panelHeight", "na", "status", "ma", NodeProps.MAX_HEIGHT, "oa", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "progress", "Z6", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "B9", "A9", "onPostThemeChanged", "onPartDestroy", "oldScene", "newScene", "C4", "", "f", "Lkotlin/Lazy;", "sa", "()J", "SHOW_STATIC_DELAY_TIME", tl.h.F, "qa", "JUMP_PORTAL_DELAY_TIME", "i", "Ljava/lang/String;", "jsBundleUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isReleaseEngine", BdhLogUtil.LogTag.Tag_Conn, "ra", "()I", "relHeight", "Landroid/graphics/Point;", "D", "Landroid/graphics/Point;", "getHandPosition", "()Landroid/graphics/Point;", "Oa", "(Landroid/graphics/Point;)V", "handPosition", "Lwk0/a;", "E", "Lwk0/a;", "filamentNativeApp", "Lcom/tencent/sqshow/sharedengine/ZPlanShareEngineScene;", UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/sharedengine/ZPlanShareEngineScene;", "currScene", "Lcom/tencent/mobileqq/zplan/sharedengine/drawer/DrawerBusinessScene;", "G", "Lcom/tencent/mobileqq/zplan/sharedengine/drawer/DrawerBusinessScene;", "drawerScene", "H", "sceneChanged", "I", "lastNativeAppId", "J", "cameraProgress", "Ljava/util/concurrent/atomic/AtomicBoolean;", "K", "Ljava/util/concurrent/atomic/AtomicBoolean;", "enableSetCamera", "L", "currentAnimationStatus", "Landroid/widget/FrameLayout;", "M", "Landroid/widget/FrameLayout;", "avatarContainer", "N", "Landroid/view/View;", "filamentTextureView", "Landroid/widget/ImageView;", "P", "Landroid/widget/ImageView;", "staticImageView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "loadingImageView", "Lcom/tencent/mobileqq/zplan/meme/frameanim/e;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/zplan/meme/frameanim/e;", "avatarOverlayViewWiringHelper", ExifInterface.LATITUDE_SOUTH, "startTime", "T", "isResume", "com/tencent/mobileqq/zplan/sharedengine/part/QQSettingMeZPlanFilamentPart$cacheCleanBroadcastReceiver$1", "U", "Lcom/tencent/mobileqq/zplan/sharedengine/part/QQSettingMeZPlanFilamentPart$cacheCleanBroadcastReceiver$1;", "cacheCleanBroadcastReceiver", "com/tencent/mobileqq/zplan/sharedengine/part/QQSettingMeZPlanFilamentPart$c", "V", "Lcom/tencent/mobileqq/zplan/sharedengine/part/QQSettingMeZPlanFilamentPart$c;", "mZPlanRequestObserver", "com/tencent/mobileqq/zplan/sharedengine/part/QQSettingMeZPlanFilamentPart$b", "W", "Lcom/tencent/mobileqq/zplan/sharedengine/part/QQSettingMeZPlanFilamentPart$b;", "jsEventListener", "Ljava/lang/Runnable;", "X", "Ljava/lang/Runnable;", "releaseEngine", "<init>", "()V", "Y", "a", "ZPlanAvatarUpdateRunnable", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class QQSettingMeZPlanFilamentPart extends com.tencent.mobileqq.part.a implements vk0.d, s74.a {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy relHeight;

    /* renamed from: D, reason: from kotlin metadata */
    private Point handPosition;

    /* renamed from: E, reason: from kotlin metadata */
    private wk0.a filamentNativeApp;

    /* renamed from: F, reason: from kotlin metadata */
    private ZPlanShareEngineScene currScene;

    /* renamed from: G, reason: from kotlin metadata */
    private DrawerBusinessScene drawerScene;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean sceneChanged;

    /* renamed from: I, reason: from kotlin metadata */
    private int lastNativeAppId;

    /* renamed from: J, reason: from kotlin metadata */
    private float cameraProgress;

    /* renamed from: K, reason: from kotlin metadata */
    private AtomicBoolean enableSetCamera;

    /* renamed from: L, reason: from kotlin metadata */
    private int currentAnimationStatus;

    /* renamed from: M, reason: from kotlin metadata */
    private FrameLayout avatarContainer;

    /* renamed from: N, reason: from kotlin metadata */
    private View filamentTextureView;

    /* renamed from: P, reason: from kotlin metadata */
    private ImageView staticImageView;

    /* renamed from: Q, reason: from kotlin metadata */
    private ImageView loadingImageView;

    /* renamed from: R, reason: from kotlin metadata */
    private com.tencent.mobileqq.zplan.meme.frameanim.e avatarOverlayViewWiringHelper;

    /* renamed from: S, reason: from kotlin metadata */
    private long startTime;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isResume;

    /* renamed from: U, reason: from kotlin metadata */
    private final QQSettingMeZPlanFilamentPart$cacheCleanBroadcastReceiver$1 cacheCleanBroadcastReceiver;

    /* renamed from: V, reason: from kotlin metadata */
    private final c mZPlanRequestObserver;

    /* renamed from: W, reason: from kotlin metadata */
    private final b jsEventListener;

    /* renamed from: X, reason: from kotlin metadata */
    private final Runnable releaseEngine;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy SHOW_STATIC_DELAY_TIME;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy JUMP_PORTAL_DELAY_TIME;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String jsBundleUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isReleaseEngine;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/sharedengine/part/QQSettingMeZPlanFilamentPart$ZPlanAvatarUpdateRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "d", "Z", "isShowStatic", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/zplan/sharedengine/part/QQSettingMeZPlanFilamentPart;", "e", "Ljava/lang/ref/WeakReference;", "partRef", "part", "<init>", "(Lcom/tencent/mobileqq/zplan/sharedengine/part/QQSettingMeZPlanFilamentPart;Z)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class ZPlanAvatarUpdateRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isShowStatic;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<QQSettingMeZPlanFilamentPart> partRef;

        public ZPlanAvatarUpdateRunnable(QQSettingMeZPlanFilamentPart part, boolean z16) {
            Intrinsics.checkNotNullParameter(part, "part");
            this.isShowStatic = z16;
            this.partRef = new WeakReference<>(part);
        }

        @Override // java.lang.Runnable
        public void run() {
            QQSettingMeZPlanFilamentPart qQSettingMeZPlanFilamentPart = this.partRef.get();
            if (qQSettingMeZPlanFilamentPart != null) {
                qQSettingMeZPlanFilamentPart.Sa(this.isShowStatic);
            } else {
                QLog.e("QQSettingMeZPlanFilamentPart", 1, "ZPlanAvatarUpdateRunnable processor is null");
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/sharedengine/part/QQSettingMeZPlanFilamentPart$c", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zplan.servlet.b {
        c() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            List emptyList;
            if (type == 27405) {
                try {
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String?>");
                    emptyList = (List) data;
                } catch (Throwable th5) {
                    QLog.e("QQSettingMeZPlanFilamentPart", 1, "onUpdate PROFILE_APPEARANCE_KEY exception " + th5);
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    QLog.e("QQSettingMeZPlanFilamentPart", 1, "appRuntime is null when zplan appearanceKey changed!");
                    return;
                }
                if (!emptyList.contains(peekAppRuntime.getCurrentUin())) {
                    QLog.i("QQSettingMeZPlanFilamentPart", 1, "current uin's appearanceKey not changed.");
                    return;
                }
                QLog.i("QQSettingMeZPlanFilamentPart", 1, " onAppearanceKeyChanged");
                wk0.a aVar = QQSettingMeZPlanFilamentPart.this.filamentNativeApp;
                if (aVar != null) {
                    b.a.a(aVar, "onCostumeChange", null, null, 4, null);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.tencent.mobileqq.zplan.sharedengine.part.QQSettingMeZPlanFilamentPart$cacheCleanBroadcastReceiver$1] */
    public QQSettingMeZPlanFilamentPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.zplan.sharedengine.part.QQSettingMeZPlanFilamentPart$SHOW_STATIC_DELAY_TIME$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(ZPlanQQMC.INSTANCE.getDrawerShowStaticDelayTime());
            }
        });
        this.SHOW_STATIC_DELAY_TIME = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.zplan.sharedengine.part.QQSettingMeZPlanFilamentPart$JUMP_PORTAL_DELAY_TIME$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(ZPlanQQMC.INSTANCE.getDrawerJumpPortalDelayTime());
            }
        });
        this.JUMP_PORTAL_DELAY_TIME = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.zplan.sharedengine.part.QQSettingMeZPlanFilamentPart$relHeight$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ScreenUtil.getRealHeight(BaseApplication.getContext()) / 2);
            }
        });
        this.relHeight = lazy3;
        this.enableSetCamera = new AtomicBoolean(false);
        this.cacheCleanBroadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.zplan.sharedengine.part.QQSettingMeZPlanFilamentPart$cacheCleanBroadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                QLog.i("QQSettingMeZPlanFilamentPart", 1, "clean cache");
                QQSettingMeZPlanFilamentPart.this.Fa();
            }
        };
        this.mZPlanRequestObserver = new c();
        this.jsEventListener = new b();
        this.releaseEngine = new Runnable() { // from class: com.tencent.mobileqq.zplan.sharedengine.part.i
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeZPlanFilamentPart.Ia(QQSettingMeZPlanFilamentPart.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Aa() {
        if (za()) {
            La();
            if (this.filamentNativeApp == null) {
                ua();
            }
            wk0.a aVar = this.filamentNativeApp;
            if (aVar != null) {
                aVar.onResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Ea() {
        try {
            BaseApplication.getContext().registerReceiver(this.cacheCleanBroadcastReceiver, new IntentFilter("filament_cache_clean"));
        } catch (Exception e16) {
            QLog.e("QQSettingMeZPlanFilamentPart", 1, "registerCacheCleanBroadcastReceiver error:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fa() {
        FrameLayout frameLayout;
        Ja();
        Qa();
        ImageView imageView = this.staticImageView;
        if (imageView != null && (frameLayout = this.avatarContainer) != null) {
            frameLayout.removeView(imageView);
        }
        this.staticImageView = null;
    }

    private final void Ga() {
        La();
        Ja();
        Qa();
        ha(true);
    }

    private final void Ha() {
        if (this.isReleaseEngine) {
            return;
        }
        this.isReleaseEngine = true;
        QLog.i("QQSettingMeZPlanFilamentPart", 1, "releaseEngine");
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.releaseEngine, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ia(QQSettingMeZPlanFilamentPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isResume) {
            return;
        }
        QLog.i("QQSettingMeZPlanFilamentPart", 1, "releaseEngine running.");
        this$0.Ga();
    }

    private final void Ka() {
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.t("onFilamentRenderFail", this.jsEventListener);
        }
        wk0.a aVar2 = this.filamentNativeApp;
        if (aVar2 != null) {
            aVar2.t("onFirstFrameRenderEnd", this.jsEventListener);
        }
        wk0.a aVar3 = this.filamentNativeApp;
        if (aVar3 != null) {
            aVar3.t("onFirstFrameImageReady", this.jsEventListener);
        }
    }

    private final void Ma() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null) {
            appInterface.removeObserver(this.mZPlanRequestObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Na(String picPath) {
        View view = this.filamentTextureView;
        if (view != null) {
            int width = view.getWidth();
            View view2 = this.filamentTextureView;
            if (view2 != null) {
                int height = view2.getHeight();
                Point point = this.handPosition;
                if (point != null) {
                    int ia5 = ia();
                    com.tencent.mobileqq.zplan.meme.frameanim.j jVar = new com.tencent.mobileqq.zplan.meme.frameanim.j();
                    jVar.e(width);
                    jVar.b(height);
                    jVar.c(ia5);
                    jVar.d(picPath);
                    IZPlanMMKVApi iZPlanMMKVApi = (IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class);
                    String json = new Gson().toJson(jVar);
                    Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(data)");
                    iZPlanMMKVApi.setString("zplan_drawer_avatar_position", json);
                    int i3 = point.y;
                    View view3 = this.filamentTextureView;
                    Integer valueOf = view3 != null ? Integer.valueOf(view3.getWidth()) : null;
                    View view4 = this.filamentTextureView;
                    QLog.i("QQSettingMeZPlanFilamentPart", 1, "first render handPosition.y=" + i3 + ", filamentTextureView.width=" + valueOf + ", filamentTextureView.height=" + (view4 != null ? Integer.valueOf(view4.getHeight()) : null) + ", offset=" + ia5 + ", picPath=" + picPath);
                }
            }
        }
    }

    private final void Pa(URLDrawable drawable) {
        Ra();
        ImageView imageView = this.staticImageView;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
        ImageView imageView2 = this.staticImageView;
        if (imageView2 == null) {
            return;
        }
        imageView2.setVisibility(0);
    }

    private final void Qa() {
        try {
            BaseApplication.getContext().unregisterReceiver(this.cacheCleanBroadcastReceiver);
        } catch (Exception unused) {
        }
    }

    private final void Ra() {
        if (this.sceneChanged) {
            return;
        }
        int ia5 = ia();
        View view = this.filamentTextureView;
        if (view != null) {
            view.setTranslationY(ia5);
        }
        ImageView imageView = this.staticImageView;
        if (imageView == null) {
            return;
        }
        imageView.setTranslationY(ia5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sa(boolean isShowStatic) {
        final boolean z16 = true;
        QLog.i("QQSettingMeZPlanFilamentPart", 1, "isShowStatic :" + isShowStatic);
        if (isShowStatic) {
            String staticFrameSavePath = ((IDrawerApi) QRoute.api(IDrawerApi.class)).getStaticFrameSavePath();
            if (new File(staticFrameSavePath).exists()) {
                try {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mLoadingDrawable = new ColorDrawable(0);
                    obtain.mFailedDrawable = new ColorDrawable(0);
                    final URLDrawable fileDrawable = URLDrawable.getFileDrawable(staticFrameSavePath, obtain);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.sharedengine.part.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            QQSettingMeZPlanFilamentPart.Ta(QQSettingMeZPlanFilamentPart.this, fileDrawable);
                        }
                    });
                    QLog.i("QQSettingMeZPlanFilamentPart", 1, "showStaticImageView");
                } catch (OutOfMemoryError e16) {
                    QLog.e("QQSettingMeZPlanFilamentPart", 1, "decode avatar error", e16);
                }
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.sharedengine.part.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQSettingMeZPlanFilamentPart.Va(QQSettingMeZPlanFilamentPart.this);
                    }
                });
                z16 = false;
            }
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.sharedengine.part.g
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeZPlanFilamentPart.Wa(QQSettingMeZPlanFilamentPart.this);
                }
            });
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.sharedengine.part.h
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeZPlanFilamentPart.Xa(QQSettingMeZPlanFilamentPart.this, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ta(final QQSettingMeZPlanFilamentPart this$0, final URLDrawable drawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.loadingImageView;
        boolean z16 = false;
        if (imageView != null && imageView.getVisibility() == 0) {
            z16 = true;
        }
        QLog.i("QQSettingMeZPlanFilamentPart", 1, "updateZPlanAvatar showStaticImageView, isShowingLoadingView=" + z16 + ", SHOW_STATIC_DELAY_TIME=" + this$0.sa());
        if (z16) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.sharedengine.part.j
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeZPlanFilamentPart.Ua(QQSettingMeZPlanFilamentPart.this, drawable);
                }
            }, this$0.sa());
        } else {
            Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
            this$0.Pa(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ua(QQSettingMeZPlanFilamentPart this$0, URLDrawable drawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isResume) {
            QLog.i("QQSettingMeZPlanFilamentPart", 1, "updateZPlanAvatar showStaticImageView is resume. return");
        } else {
            Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
            this$0.Pa(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Va(QQSettingMeZPlanFilamentPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.staticImageView;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wa(QQSettingMeZPlanFilamentPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ra();
        ImageView imageView = this$0.staticImageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        View view = this$0.filamentTextureView;
        if (view == null) {
            return;
        }
        view.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xa(QQSettingMeZPlanFilamentPart this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ya(z16);
    }

    private final void Ya(boolean loadingCompleted) {
        View f16;
        FrameLayout frameLayout;
        if (za()) {
            if (loadingCompleted) {
                com.tencent.mobileqq.zplan.meme.frameanim.e eVar = this.avatarOverlayViewWiringHelper;
                if (eVar != null) {
                    eVar.a();
                    LiveData<Boolean> c16 = eVar.c();
                    Activity activity = getActivity();
                    Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
                    c16.removeObservers((QBaseActivity) activity);
                    eVar.release();
                    View f17 = eVar.f();
                    FrameLayout frameLayout2 = this.avatarContainer;
                    if (frameLayout2 != null) {
                        frameLayout2.removeView(f17);
                    }
                    this.avatarOverlayViewWiringHelper = null;
                    return;
                }
                return;
            }
            if (this.isResume) {
                if (this.avatarOverlayViewWiringHelper == null) {
                    IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                    LayoutInflater from = LayoutInflater.from(getActivity());
                    Intrinsics.checkNotNullExpressionValue(from, "from(activity)");
                    Activity activity2 = getActivity();
                    Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
                    this.avatarOverlayViewWiringHelper = iZPlanApi.createAvatarLoadingViewHelper(from, (QBaseActivity) activity2, ((IZPlanClassObjectFactory) QRoute.api(IZPlanClassObjectFactory.class)).getZPlanSettingMeAvatarOverlayViewModelClass());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    com.tencent.mobileqq.zplan.meme.frameanim.e eVar2 = this.avatarOverlayViewWiringHelper;
                    if (eVar2 != null && (f16 = eVar2.f()) != null && (frameLayout = this.avatarContainer) != null) {
                        frameLayout.addView(f16, layoutParams);
                    }
                }
                com.tencent.mobileqq.zplan.meme.frameanim.e eVar3 = this.avatarOverlayViewWiringHelper;
                if (eVar3 != null) {
                    e.a.a(eVar3, false, 1, null);
                }
            }
        }
    }

    private final void ea() {
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.c("onFilamentRenderFail", this.jsEventListener);
        }
        wk0.a aVar2 = this.filamentNativeApp;
        if (aVar2 != null) {
            aVar2.c("onFirstFrameRenderEnd", this.jsEventListener);
        }
        wk0.a aVar3 = this.filamentNativeApp;
        if (aVar3 != null) {
            aVar3.c("onFirstFrameImageReady", this.jsEventListener);
        }
    }

    private final void ga() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null) {
            appInterface.addObserver(this.mZPlanRequestObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ha(boolean isShowStatic) {
        ThreadManagerV2.excute(new ZPlanAvatarUpdateRunnable(this, isShowStatic), 16, null, false);
    }

    private final void hideLoadingView() {
        ImageView imageView;
        ImageView imageView2 = this.loadingImageView;
        boolean z16 = false;
        if (imageView2 != null && imageView2.getVisibility() == 0) {
            z16 = true;
        }
        if (!z16 || (imageView = this.loadingImageView) == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int ia() {
        com.tencent.mobileqq.zplan.meme.frameanim.j jVar;
        Point point = this.handPosition;
        if (point != null) {
            int dpToPx = ViewUtils.dpToPx(6.0f);
            FrameLayout frameLayout = this.avatarContainer;
            if (frameLayout == null) {
                return 0;
            }
            int height = frameLayout.getHeight();
            int b16 = com.tencent.mobileqq.activity.qqsettingme.utils.b.b();
            int i3 = point.y;
            if (i3 > 0) {
                return (i3 - (height - b16)) - dpToPx;
            }
            return 0;
        }
        String string = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString("zplan_drawer_avatar_position", "");
        if (string.length() == 0) {
            return 0;
        }
        try {
            jVar = (com.tencent.mobileqq.zplan.meme.frameanim.j) new Gson().fromJson(string, com.tencent.mobileqq.zplan.meme.frameanim.j.class);
        } catch (Exception unused) {
            jVar = new com.tencent.mobileqq.zplan.meme.frameanim.j();
        }
        return jVar.getOffset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ja() {
        FrameLayout frameLayout;
        QLog.i("QQSettingMeZPlanFilamentPart", 1, "destroyFilamentApp, sceneChanged=" + this.sceneChanged + ", filamentNativeApp=" + this.filamentNativeApp);
        if (!this.sceneChanged) {
            wk0.a aVar = this.filamentNativeApp;
            if (aVar != null) {
                aVar.onDestroy();
            }
            this.lastNativeAppId = 0;
        }
        this.filamentNativeApp = null;
        View view = this.filamentTextureView;
        if (view != null && (frameLayout = this.avatarContainer) != null) {
            frameLayout.removeView(view);
        }
        ZPlanShareEngineScene zPlanShareEngineScene = this.currScene;
        if (zPlanShareEngineScene != null) {
            zPlanShareEngineScene.setCameraChangeListener(null);
        }
        this.filamentTextureView = null;
        this.currScene = null;
        this.drawerScene = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void la(int y16) {
        int b16 = com.tencent.mobileqq.activity.qqsettingme.utils.b.b();
        int i3 = y16 - b16;
        int ra5 = ra() - b16;
        if (1 <= i3 && i3 <= ra5) {
            ma(1);
            oa(i3, ra() - b16);
            FrameLayout frameLayout = this.avatarContainer;
            Intrinsics.checkNotNull(frameLayout);
            na(i3, frameLayout.getHeight() - b16);
            return;
        }
        if (i3 > ra5) {
            ma(2);
            FrameLayout frameLayout2 = this.avatarContainer;
            Intrinsics.checkNotNull(frameLayout2);
            na(i3, frameLayout2.getHeight() - b16);
            return;
        }
        ma(0);
        FrameLayout frameLayout3 = this.avatarContainer;
        Intrinsics.checkNotNull(frameLayout3);
        na(0, frameLayout3.getHeight() - b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ma(int status) {
        if (this.filamentNativeApp == null || this.currentAnimationStatus == status) {
            return;
        }
        QLog.d("QQSettingMeZPlanFilamentPart", 1, "event change to:" + status + " ");
        this.currentAnimationStatus = status;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", status);
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            b.a.a(aVar, "DrawerPageAvatar.onPlayStateChanged", jSONObject.toString(), null, 4, null);
        }
    }

    private final void oa(int offset, int maxHeight) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NodeProps.MAX_HEIGHT, maxHeight);
        jSONObject.put("offset", offset);
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            b.a.a(aVar, "DrawerPageAvatar.onScrollOffsetChanged", jSONObject.toString(), null, 4, null);
        }
        wk0.a aVar2 = this.filamentNativeApp;
        if (aVar2 != null) {
            b.a.a(aVar2, "onDrawFrame", null, null, 4, null);
        }
    }

    private final IBusinessScene pa() {
        ZPlanShareEngineScene zPlanShareEngineScene;
        IBusinessScene scene;
        DrawerBusinessScene drawerBusinessScene = this.drawerScene;
        if (drawerBusinessScene == null) {
            drawerBusinessScene = new DrawerBusinessScene();
        }
        this.drawerScene = drawerBusinessScene;
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null && (scene = aVar.getScene()) != null) {
            if (scene instanceof ZPlanShareEngineScene) {
                zPlanShareEngineScene = (ZPlanShareEngineScene) scene;
            } else {
                zPlanShareEngineScene = new ZPlanShareEngineScene();
            }
        } else {
            zPlanShareEngineScene = new ZPlanShareEngineScene();
        }
        this.currScene = zPlanShareEngineScene;
        Intrinsics.checkNotNull(zPlanShareEngineScene);
        DrawerBusinessScene drawerBusinessScene2 = this.drawerScene;
        Intrinsics.checkNotNull(drawerBusinessScene2);
        zPlanShareEngineScene.initScene(drawerBusinessScene2);
        ZPlanShareEngineScene zPlanShareEngineScene2 = this.currScene;
        Intrinsics.checkNotNull(zPlanShareEngineScene2);
        zPlanShareEngineScene2.addSceneChangeListener(this);
        ZPlanShareEngineScene zPlanShareEngineScene3 = this.currScene;
        Intrinsics.checkNotNull(zPlanShareEngineScene3);
        zPlanShareEngineScene3.setCameraChangeListener(this);
        this.sceneChanged = false;
        ZPlanShareEngineScene zPlanShareEngineScene4 = this.currScene;
        Intrinsics.checkNotNull(zPlanShareEngineScene4);
        return zPlanShareEngineScene4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long qa() {
        return ((Number) this.JUMP_PORTAL_DELAY_TIME.getValue()).longValue();
    }

    private final int ra() {
        return ((Number) this.relHeight.getValue()).intValue();
    }

    private final long sa() {
        return ((Number) this.SHOW_STATIC_DELAY_TIME.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va() {
        ReportController.y(MobileQQ.sMobileQQ.peekAppRuntime(), "0X800C460");
    }

    private final void wa() {
        if (this.loadingImageView == null) {
            ImageView imageView = new ImageView(getActivity());
            this.loadingImageView = imageView;
            FrameLayout frameLayout = this.avatarContainer;
            if (frameLayout != null) {
                frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            }
        }
        ImageView imageView2 = this.loadingImageView;
        if (imageView2 == null) {
            return;
        }
        imageView2.setVisibility(8);
    }

    private final void xa() {
        if (this.staticImageView == null) {
            ImageView imageView = new ImageView(getActivity());
            this.staticImageView = imageView;
            FrameLayout frameLayout = this.avatarContainer;
            if (frameLayout != null) {
                frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            }
            ha(true);
        }
    }

    private final boolean za() {
        de deVar = de.f307628a;
        return deVar.c() && deVar.a();
    }

    @Override // com.tencent.mobileqq.part.a
    public void A9() {
        super.A9();
        QLog.i("QQSettingMeZPlanFilamentPart", 1, "onDrawerOpened");
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.onResume();
        }
    }

    @Override // com.tencent.mobileqq.part.a
    public void B9() {
        super.B9();
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    @Override // vk0.d
    public void C4(IBusinessScene oldScene, IBusinessScene newScene) {
        Intrinsics.checkNotNullParameter(oldScene, "oldScene");
        Intrinsics.checkNotNullParameter(newScene, "newScene");
        QLog.i("QQSettingMeZPlanFilamentPart", 1, "onSceneChange, oldScene=" + oldScene + ", newScene=" + newScene);
        if (newScene.getSceneType() == SceneType.DRAWER) {
            this.sceneChanged = false;
            return;
        }
        this.sceneChanged = true;
        DrawerBusinessScene drawerBusinessScene = this.drawerScene;
        if (drawerBusinessScene != null) {
            drawerBusinessScene.resetAnim();
        }
        Ka();
        Ga();
    }

    public final void Oa(Point point) {
        this.handPosition = point;
    }

    @Override // s74.a
    public void Z6(float progress) {
        this.cameraProgress = progress;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        String string;
        super.onInitView(rootView);
        QLog.i("QQSettingMeZPlanFilamentPart", 1, "onInitView");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IFeatureRuntimeService iFeatureRuntimeService = peekAppRuntime != null ? (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all") : null;
        String str = "";
        if (iFeatureRuntimeService != null && (string = iFeatureRuntimeService.getString("zplan_drawer_page_filament_js_bundle", "")) != null) {
            str = string;
        }
        this.jsBundleUrl = str;
        this.avatarContainer = rootView != null ? (FrameLayout) rootView.findViewById(R.id.yg7) : null;
        QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
        MutableLiveData<Float> T1 = qQSettingMeViewModel.T1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: com.tencent.mobileqq.zplan.sharedengine.part.QQSettingMeZPlanFilamentPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                invoke2(f16);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Float f16) {
                QQSettingMeZPlanFilamentPart.this.la((int) f16.floatValue());
            }
        };
        T1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.sharedengine.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeZPlanFilamentPart.Ba(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> mutableLiveData = qQSettingMeViewModel.f312697f0;
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.sharedengine.part.QQSettingMeZPlanFilamentPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                boolean z16;
                if (num != null && num.intValue() == 0) {
                    QQSettingMeZPlanFilamentPart.this.ja();
                    return;
                }
                if (num != null && num.intValue() == 1) {
                    z16 = QQSettingMeZPlanFilamentPart.this.isResume;
                    if (z16 && QQSettingMeZPlanFilamentPart.this.filamentNativeApp == null) {
                        QQSettingMeZPlanFilamentPart.this.Aa();
                    }
                }
            }
        };
        mutableLiveData.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.zplan.sharedengine.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeZPlanFilamentPart.Ca(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> mutableLiveData2 = qQSettingMeViewModel.V;
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final QQSettingMeZPlanFilamentPart$onInitView$3 qQSettingMeZPlanFilamentPart$onInitView$3 = new QQSettingMeZPlanFilamentPart$onInitView$3(this);
        mutableLiveData2.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.zplan.sharedengine.part.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeZPlanFilamentPart.Da(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        ja();
        Qa();
        Ma();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QLog.i("QQSettingMeZPlanFilamentPart", 1, "onPartPause");
        this.isResume = false;
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.onPause();
        }
        Ha();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QLog.i("QQSettingMeZPlanFilamentPart", 1, "onPartResume");
        this.isResume = true;
        hideLoadingView();
        Aa();
    }

    @Override // com.tencent.mobileqq.part.a
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        QLog.i("QQSettingMeZPlanFilamentPart", 1, "onPostThemeChanged");
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            b.a.a(aVar, "onThemeChanged", null, null, 4, null);
        }
    }

    private final void La() {
        this.isReleaseEngine = false;
        QLog.i("QQSettingMeZPlanFilamentPart", 1, "removeReleaseEngine");
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.releaseEngine);
    }

    private final void ua() {
        QLog.i("QQSettingMeZPlanFilamentPart", 1, "initJsApp");
        ga();
        Ea();
        wk0.a b16 = FilamentRenderFactory.b(FilamentRenderFactory.f105773b, null, 30, Boolean.TRUE, Integer.valueOf(this.lastNativeAppId), 1, null);
        this.filamentNativeApp = b16;
        Intrinsics.checkNotNull(b16);
        this.lastNativeAppId = b16.A();
        this.enableSetCamera.set(false);
        ea();
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.y("bundle/scenes/drawer-page/main.js", pa());
        }
        View view = null;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.sharedengine.part.a
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeZPlanFilamentPart.va();
            }
        }, 16, null, false);
        this.startTime = System.currentTimeMillis();
        wk0.a aVar2 = this.filamentNativeApp;
        if (aVar2 != null) {
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            view = b.a.a(aVar2, activity, null, 2, null);
        }
        ta(view);
        xa();
        wa();
    }

    private final void Ja() {
        this.isReleaseEngine = false;
        ja();
        Ma();
        if (this.startTime == 0) {
            return;
        }
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C461", "0X800C461", 0, 0, String.valueOf(System.currentTimeMillis() - this.startTime), "", "", "");
        this.startTime = 0L;
    }

    private final void ta(View view) {
        if (view != null && this.filamentTextureView == null) {
            QLog.i("QQSettingMeZPlanFilamentPart", 1, "initFilamentView");
            this.filamentTextureView = view;
            FrameLayout frameLayout = this.avatarContainer;
            if (frameLayout != null) {
                frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
            }
            View view2 = this.filamentTextureView;
            if (view2 == null) {
                return;
            }
            view2.setAlpha(0.0f);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/sharedengine/part/QQSettingMeZPlanFilamentPart$b", "Luk0/e;", "", "type", "eventData", "", "onEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements uk0.e {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(String pngPath, QQSettingMeZPlanFilamentPart this$0) {
            Intrinsics.checkNotNullParameter(pngPath, "$pngPath");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            String staticFrameSavePath = ((IDrawerApi) QRoute.api(IDrawerApi.class)).getStaticFrameSavePath();
            FileUtils.copyFile(pngPath, staticFrameSavePath);
            this$0.Na(staticFrameSavePath);
            QLog.i("QQSettingMeZPlanFilamentPart", 1, "saveStaticImagePath");
            ((QQSettingMeViewModel) this$0.getViewModel(QQSettingMeViewModel.class)).W.postValue(Integer.valueOf(this$0.ia()));
        }

        @Override // uk0.e
        public void onEvent(String type, String eventData) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            QLog.i("QQSettingMeZPlanFilamentPart", 1, "onJsEvent. type: " + type + ", eventData: " + eventData);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            long currentTimeMillis = System.currentTimeMillis() - QQSettingMeZPlanFilamentPart.this.startTime;
            int hashCode = type.hashCode();
            if (hashCode == -1565730423) {
                if (type.equals("onFilamentRenderFail")) {
                    ReportController.y(peekAppRuntime, "0X800C463");
                    return;
                }
                return;
            }
            if (hashCode != 361827844) {
                if (hashCode == 1621140201 && type.equals("onFirstFrameRenderEnd")) {
                    QQSettingMeZPlanFilamentPart qQSettingMeZPlanFilamentPart = QQSettingMeZPlanFilamentPart.this;
                    ZPlanShareEngineScene zPlanShareEngineScene = qQSettingMeZPlanFilamentPart.currScene;
                    qQSettingMeZPlanFilamentPart.Oa(zPlanShareEngineScene != null ? zPlanShareEngineScene.getHandPosition() : null);
                    QQSettingMeZPlanFilamentPart.this.enableSetCamera.set(true);
                    QQSettingMeZPlanFilamentPart.this.ha(false);
                    ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800C462", "0X800C462", 0, 0, "1", String.valueOf(currentTimeMillis), "", "");
                    return;
                }
                return;
            }
            if (type.equals("onFirstFrameImageReady")) {
                JSONObject b16 = com.tencent.zplan.common.utils.h.f385294a.b(eventData);
                final String optString = b16 != null ? b16.optString("imagePath") : null;
                if (optString == null) {
                    return;
                }
                final QQSettingMeZPlanFilamentPart qQSettingMeZPlanFilamentPart2 = QQSettingMeZPlanFilamentPart.this;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.sharedengine.part.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQSettingMeZPlanFilamentPart.b.b(optString, qQSettingMeZPlanFilamentPart2);
                    }
                }, 64, null, true);
                ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800C462", "0X800C462", 0, 0, "0", String.valueOf(currentTimeMillis), "", "");
            }
        }
    }

    private final void na(int offset, int panelHeight) {
        wk0.a aVar;
        float ia5 = ia();
        float abs = ia5 + Math.abs(((offset * 1.0f) / panelHeight) * ia5);
        if (abs > 0.0f) {
            abs = 0.0f;
        }
        View view = this.filamentTextureView;
        if (view != null) {
            view.setTranslationY(abs);
        }
        ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).X.postValue(Integer.valueOf((int) abs));
        int i3 = panelHeight / 2;
        int min = Math.min(offset, i3);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("now", min);
        jSONObject.put("duration", i3);
        if (!this.enableSetCamera.get() || (aVar = this.filamentNativeApp) == null) {
            return;
        }
        b.a.a(aVar, "ZPlanShareEngineScene_OnSetCamera", jSONObject.toString(), null, 4, null);
    }
}
