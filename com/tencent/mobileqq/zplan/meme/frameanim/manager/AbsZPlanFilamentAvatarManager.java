package com.tencent.mobileqq.zplan.meme.frameanim.manager;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.meme.frameanim.c;
import com.tencent.mobileqq.zplan.meme.frameanim.j;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.utils.am;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.zplan.common.model.AppTheme;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import t74.l;
import t74.s;

@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u001f2\u00020\u0001:\u0002\u0090\u0001B#\u0012\u0007\u0010\u008c\u0001\u001a\u00020J\u0012\u0007\u0010\u008d\u0001\u001a\u00020C\u0012\u0006\u0010A\u001a\u00020\u0013\u00a2\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0004J\b\u0010\t\u001a\u00020\u0005H\u0004J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0004J\b\u0010\u000f\u001a\u00020\u000eH\u0004J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0004J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0013H\u0004J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0004J\b\u0010\u001a\u001a\u00020\u0005H\u0004J\b\u0010\u001b\u001a\u00020\u000eH\u0004J\u0012\u0010\u001c\u001a\u00020\u00132\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0004J\u0012\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0004J\b\u0010 \u001a\u00020\u0005H\u0004J\u0012\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\nH$J\b\u0010#\u001a\u00020\u0005H$J\b\u0010$\u001a\u00020\u0005H$J\b\u0010%\u001a\u00020\u0005H\u0004J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\nH\u0016J\u0010\u0010-\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u000eH\u0016J\n\u0010/\u001a\u0004\u0018\u00010.H\u0016J\n\u00100\u001a\u0004\u0018\u00010.H\u0016J\u0012\u00103\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u000101H\u0016J\b\u00104\u001a\u00020\u0005H\u0016J\b\u00105\u001a\u00020\u0005H\u0016J\b\u00106\u001a\u00020\u0005H\u0016J\u0010\u00109\u001a\u00020\u00052\u0006\u00108\u001a\u000207H\u0016J\u0010\u0010<\u001a\u00020\u00052\u0006\u0010;\u001a\u00020:H\u0016J\b\u0010=\u001a\u00020\nH\u0016R\u0017\u0010A\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b+\u0010>\u001a\u0004\b?\u0010@R%\u0010I\u001a\u0010\u0012\f\u0012\n D*\u0004\u0018\u00010C0C0B8\u0006\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR0\u0010N\u001a\u0010\u0012\f\u0012\n D*\u0004\u0018\u00010J0J0B8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010F\u001a\u0004\bK\u0010H\"\u0004\bL\u0010MR\u0017\u0010S\u001a\u00020O8\u0006\u00a2\u0006\f\n\u0004\b/\u0010P\u001a\u0004\bQ\u0010RR#\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130T8\u0006\u00a2\u0006\f\n\u0004\b3\u0010U\u001a\u0004\bV\u0010WR*\u0010\\\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010B8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010F\u001a\u0004\bZ\u0010H\"\u0004\b[\u0010MR$\u0010b\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0017\u0010g\u001a\u00020c8\u0006\u00a2\u0006\f\n\u0004\bG\u0010d\u001a\u0004\be\u0010fR\"\u0010m\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u0010t\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\"\u0010w\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010h\u001a\u0004\bu\u0010j\"\u0004\bv\u0010lR$\u0010~\u001a\u0004\u0018\u00010x8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\bn\u0010{\"\u0004\b|\u0010}R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b?\u0010\u0080\u0001R+\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\t\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0017\u0010\u008b\u0001\u001a\u00030\u0089\u00018&X\u00a6\u0004\u00a2\u0006\u0007\u001a\u0005\by\u0010\u008a\u0001\u00a8\u0006\u0091\u0001"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/manager/AbsZPlanFilamentAvatarManager;", "Lcom/tencent/mobileqq/zplan/meme/frameanim/g;", "Landroid/widget/FrameLayout$LayoutParams;", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "L", "O", "V", "J", "", "show", "f", "M", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Y", "Lcom/tencent/mobileqq/zplan/meme/frameanim/c$b;", "staticAvatarParam", "", "G", "path", "T", "Lcom/tencent/image/URLDrawable;", "drawable", "W", "X", "o", HippyTKDListViewAdapter.X, "Landroid/view/View;", "view", "K", "a0", "report", ReportConstant.COSTREPORT_PREFIX, "N", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "resume", "pause", "stop", "release", "onTabQzone", "d", "scene", "g", "", tl.h.F, "j", "Lcom/tencent/mobileqq/zplan/meme/frameanim/e;", "avatarOverlayViewWiringHelper", "i", "b", "onAccountChanged", "onThemeChange", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Lcom/tencent/mobileqq/zplan/meme/frameanim/d;", "listener", "k", "r", "Ljava/lang/String;", "I", "()Ljava/lang/String;", "uin", "Ljava/lang/ref/WeakReference;", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "e", "Ljava/lang/ref/WeakReference;", "D", "()Ljava/lang/ref/WeakReference;", "rootViewRef", "Landroid/content/Context;", "u", "setContextWeak", "(Ljava/lang/ref/WeakReference;)V", "contextWeak", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "B", "()Ljava/util/concurrent/locks/ReentrantLock;", "reportLock", "", "Ljava/util/Map;", BdhLogUtil.LogTag.Tag_Conn, "()Ljava/util/Map;", "reportMap", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getLoadingHelper", "setLoadingHelper", "loadingHelper", "Lcom/tencent/mobileqq/zplan/meme/frameanim/d;", "v", "()Lcom/tencent/mobileqq/zplan/meme/frameanim/d;", "setExitFilamentListener", "(Lcom/tencent/mobileqq/zplan/meme/frameanim/d;)V", "exitFilamentListener", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "E", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "showAvatar", "Z", "getLoading", "()Z", "setLoading", "(Z)V", ToastView.ICON_LOADING, UserInfo.SEX_FEMALE, "Landroid/view/View;", "w", "()Landroid/view/View;", BdhLogUtil.LogTag.Tag_Req, "(Landroid/view/View;)V", "filamentTextureView", "getStaticImageShowing", "setStaticImageShowing", "staticImageShowing", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "U", "(Landroid/widget/ImageView;)V", "staticBannerView", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "guardListener", "Landroid/graphics/Point;", "Landroid/graphics/Point;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Landroid/graphics/Point;", ExifInterface.LATITUDE_SOUTH, "(Landroid/graphics/Point;)V", "handPosition", "Loi3/a;", "()Loi3/a;", "statistic", "context", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/content/Context;Landroid/widget/FrameLayout;Ljava/lang/String;)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class AbsZPlanFilamentAvatarManager implements com.tencent.mobileqq.zplan.meme.frameanim.g {

    /* renamed from: K, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String L = "zplan_dynamic_avatar_position_" + bb.f335811a.e();

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.mobileqq.zplan.meme.frameanim.d exitFilamentListener;

    /* renamed from: D, reason: from kotlin metadata */
    private final AtomicBoolean showAvatar;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean loading;

    /* renamed from: F, reason: from kotlin metadata */
    private View filamentTextureView;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean staticImageShowing;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView staticBannerView;

    /* renamed from: I, reason: from kotlin metadata */
    private IGuardInterface guardListener;

    /* renamed from: J, reason: from kotlin metadata */
    private Point handPosition;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String uin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<FrameLayout> rootViewRef;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private WeakReference<Context> contextWeak;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ReentrantLock reportLock;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Map<String, String> reportMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private WeakReference<com.tencent.mobileqq.zplan.meme.frameanim.e> loadingHelper;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/manager/AbsZPlanFilamentAvatarManager$a;", "", "", "KEY_ZPLAN_DYNAMIC_AVATAR_POSITION", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setKEY_ZPLAN_DYNAMIC_AVATAR_POSITION", "(Ljava/lang/String;)V", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return AbsZPlanFilamentAvatarManager.L;
        }

        Companion() {
        }
    }

    public AbsZPlanFilamentAvatarManager(Context context, FrameLayout rootView, String uin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.rootViewRef = new WeakReference<>(rootView);
        this.contextWeak = new WeakReference<>(context);
        this.reportLock = new ReentrantLock();
        this.reportMap = new LinkedHashMap();
        this.showAvatar = new AtomicBoolean(false);
        L();
    }

    private final void L() {
        if (GuardManager.sInstance == null) {
            QLog.e("FilamentAvatar", 1, "initGuardManager sInstance us null, return.");
            return;
        }
        if (this.guardListener == null) {
            final WeakReference weakReference = new WeakReference(this);
            final boolean t16 = ZPlanFeatureSwitch.f369852a.t();
            IGuardInterface iGuardInterface = new IGuardInterface() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager$initGuardManager$1
                @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
                public void onApplicationBackground() {
                    l lVar = l.f435563a;
                    final WeakReference<AbsZPlanFilamentAvatarManager> weakReference2 = weakReference;
                    final boolean z16 = t16;
                    lVar.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager$initGuardManager$1$onApplicationBackground$1
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
                            AbsZPlanFilamentAvatarManager absZPlanFilamentAvatarManager = weakReference2.get();
                            if (absZPlanFilamentAvatarManager == null) {
                                return;
                            }
                            QLog.i("FilamentAvatar", 1, "GuardManager onApplicationBackground, pauseOnBackground:" + z16);
                            if (z16) {
                                absZPlanFilamentAvatarManager.pause();
                            }
                            absZPlanFilamentAvatarManager.N();
                        }
                    });
                }

                @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
                public void onApplicationForeground() {
                    QLog.i("FilamentAvatar", 1, "GuardManager onApplicationForeground");
                }

                @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
                public void onBackgroundTimeTick(long tick) {
                }

                @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
                public void onBackgroundUnguardTimeTick(long tick) {
                }

                @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
                public void onLiteTimeTick(long tick) {
                }

                @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
                public void onScreensStateChanged(boolean isEnabled) {
                }
            };
            this.guardListener = iGuardInterface;
            s sVar = s.f435588a;
            Intrinsics.checkNotNull(iGuardInterface);
            sVar.b(iGuardInterface);
        }
    }

    private final void O() {
        if (this.guardListener != null) {
            QLog.i("FilamentAvatar", 1, "releaseGuardManager");
            GuardManager.sInstance.unregisterCallback(this.guardListener);
            this.guardListener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(final AbsZPlanFilamentAvatarManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c.Param d16 = c.Companion.d(com.tencent.mobileqq.zplan.meme.frameanim.c.INSTANCE, this$0.uin, null, null, 6, null);
        final String G = this$0.G(d16);
        QLog.i("FilamentAvatar", 1, "updateStaticBannerView avatar path:" + G + ", staticAvatarParam:" + d16);
        if (G == null) {
            this$0.V();
        } else {
            l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager$updateStaticBannerView$1$1
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
                    AbsZPlanFilamentAvatarManager.this.T(G);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout.LayoutParams p() {
        FrameLayout frameLayout = this.rootViewRef.get();
        int width = frameLayout != null ? frameLayout.getWidth() : 0;
        int realHeight = ScreenUtil.getRealHeight(BaseApplication.getContext());
        QLog.i("FilamentAvatar", 1, "createLayoutParams rootViewWith : " + width + ", rootViewHeight: " + realHeight);
        int i3 = realHeight / 2;
        int i16 = (i3 / 4) * 3;
        int i17 = (width - i16) / 2;
        if (r()) {
            return new FrameLayout.LayoutParams(-1, -1);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i16, i3);
        layoutParams.leftMargin = i17;
        return layoutParams;
    }

    private final FrameLayout.LayoutParams q() {
        int realWidth = ScreenUtil.getRealWidth(BaseApplication.getContext());
        int realHeight = ScreenUtil.getRealHeight(BaseApplication.getContext()) / 2;
        int i3 = (realHeight / 4) * 3;
        int i16 = (realWidth - i3) / 2;
        if (r()) {
            return new FrameLayout.LayoutParams(-1, -1);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, realHeight);
        layoutParams.leftMargin = i16;
        return layoutParams;
    }

    protected final int A() {
        FrameLayout frameLayout = this.rootViewRef.get();
        if (frameLayout == null) {
            return -1;
        }
        int childCount = frameLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = frameLayout.getChildAt(i3);
            if (childAt != null) {
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                if (Intrinsics.areEqual("loadingView", childAt.getTag())) {
                    return i3;
                }
            }
        }
        return -1;
    }

    /* renamed from: B, reason: from getter */
    public final ReentrantLock getReportLock() {
        return this.reportLock;
    }

    public final Map<String, String> C() {
        return this.reportMap;
    }

    public final WeakReference<FrameLayout> D() {
        return this.rootViewRef;
    }

    /* renamed from: E, reason: from getter */
    public final AtomicBoolean getShowAvatar() {
        return this.showAvatar;
    }

    /* renamed from: F, reason: from getter */
    public final ImageView getStaticBannerView() {
        return this.staticBannerView;
    }

    protected final String G(c.Param staticAvatarParam) {
        Intrinsics.checkNotNullParameter(staticAvatarParam, "staticAvatarParam");
        String x16 = x(staticAvatarParam);
        if (com.tencent.zplan.common.utils.c.f385288a.h(x16)) {
            return x16;
        }
        return null;
    }

    public abstract oi3.a H();

    /* renamed from: I, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void J() {
        com.tencent.mobileqq.zplan.meme.frameanim.e eVar;
        if (this.loading) {
            WeakReference<com.tencent.mobileqq.zplan.meme.frameanim.e> weakReference = this.loadingHelper;
            if (weakReference != null && (eVar = weakReference.get()) != null) {
                eVar.a();
            }
            this.loading = false;
            QLog.i("FilamentAvatar", 1, UIJsPlugin.EVENT_HIDE_LOADING);
        }
    }

    protected final void M() {
        if (((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableZPlanFilamentStaticImageview()) {
            Context context = this.contextWeak.get();
            if (this.staticBannerView != null || context == null) {
                return;
            }
            QLog.i("FilamentAvatar", 1, "initStaticBannerView");
            this.staticBannerView = new ImageView(context);
            int A = A();
            QLog.i("FilamentAvatar", 1, "initStaticBannerView loadingIndex: " + A);
            if (A == -1) {
                FrameLayout frameLayout = this.rootViewRef.get();
                if (frameLayout != null) {
                    frameLayout.addView(this.staticBannerView);
                }
            } else {
                FrameLayout frameLayout2 = this.rootViewRef.get();
                if (frameLayout2 != null) {
                    frameLayout2.addView(this.staticBannerView, A - 1);
                }
            }
            Y(true);
            X();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void N();

    protected abstract void P();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Q() {
        ReentrantLock reentrantLock = this.reportLock;
        reentrantLock.lock();
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(this.reportMap);
            this.reportMap.clear();
            reentrantLock.unlock();
            QLog.i("FilamentAvatar", 1, "report: " + linkedHashMap + ", statistic:\n" + H());
            H().c(linkedHashMap);
            H().d();
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    public final void R(View view) {
        this.filamentTextureView = view;
    }

    public final void S(Point point) {
        this.handPosition = point;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void T(String path) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(path, "path");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        try {
            URLDrawable uRLDrawable = null;
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, "http", false, 2, null);
            if (startsWith$default) {
                uRLDrawable = URLDrawable.getDrawable(path, obtain);
            } else if (com.tencent.zplan.common.utils.c.f385288a.h(path)) {
                uRLDrawable = URLDrawable.getFileDrawable(path, obtain);
            }
            W(uRLDrawable);
        } catch (Throwable th5) {
            QLog.w("FilamentAvatar", 1, "setImageDrawable error for: " + path, th5);
        }
    }

    public final void U(ImageView imageView) {
        this.staticBannerView = imageView;
    }

    protected final void V() {
        com.tencent.mobileqq.zplan.meme.frameanim.e eVar;
        QLog.i("FilamentAvatar", 1, "showLoading showAvatar: " + this.showAvatar.get());
        if (this.showAvatar.get()) {
            this.loading = true;
            WeakReference<com.tencent.mobileqq.zplan.meme.frameanim.e> weakReference = this.loadingHelper;
            if (weakReference != null && (eVar = weakReference.get()) != null) {
                eVar.d(false);
            }
            QLog.i("FilamentAvatar", 1, UIJsPlugin.EVENT_SHOW_LOADING);
        }
    }

    protected final void W(URLDrawable drawable) {
        boolean z16 = this.showAvatar.get();
        QLog.w("FilamentAvatar", 1, "trySetDrawable staticBannerView: " + this.staticBannerView + ", drawable: " + drawable + ", showAvatar:" + z16);
        if (z16) {
            this.staticImageShowing = true;
            ImageView imageView = this.staticBannerView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            QLog.w("FilamentAvatar", 1, "trySetDrawable. staticBannerView.visibility = View.VISIBLE");
            ImageView imageView2 = this.staticBannerView;
            if (imageView2 != null) {
                imageView2.setImageDrawable(drawable);
            }
            if (drawable != null) {
                J();
            }
        }
    }

    protected final void X() {
        if (AppSetting.o(BaseApplication.getContext())) {
            l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager$updateStaticBannerLayoutParams$1
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
                    FrameLayout.LayoutParams p16;
                    ImageView staticBannerView = AbsZPlanFilamentAvatarManager.this.getStaticBannerView();
                    if (staticBannerView != null) {
                        p16 = AbsZPlanFilamentAvatarManager.this.p();
                        staticBannerView.setLayoutParams(p16);
                    }
                    QLog.i("FilamentAvatar", 1, "getUIHandlerV2 updateStaticBannerLayoutParams");
                    ImageView staticBannerView2 = AbsZPlanFilamentAvatarManager.this.getStaticBannerView();
                    if (staticBannerView2 != null) {
                        staticBannerView2.requestLayout();
                    }
                }
            });
        } else {
            ImageView imageView = this.staticBannerView;
            if (imageView != null) {
                imageView.setLayoutParams(q());
            }
            ImageView imageView2 = this.staticBannerView;
            if (imageView2 != null) {
                imageView2.requestLayout();
            }
        }
        if (!this.showAvatar.get()) {
            ImageView imageView3 = this.staticBannerView;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
            QLog.w("FilamentAvatar", 1, "updateStaticBannerLayoutParams. staticBannerView.visibility = View.Gone");
        }
        ImageView imageView4 = this.staticBannerView;
        if (imageView4 == null) {
            return;
        }
        imageView4.setTranslationY(r() ? o() : 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Y(boolean show) {
        boolean z16 = this.showAvatar.get();
        QLog.w("FilamentAvatar", 1, "updateStaticBannerView: " + show + ", staticBannerView: " + this.staticBannerView + ", showAvatar: " + z16);
        if (z16) {
            if (!show) {
                J();
                this.staticImageShowing = false;
                ImageView imageView = this.staticBannerView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                QLog.w("FilamentAvatar", 1, "updateStaticBannerView. staticBannerView.visibility = View.GONE");
                return;
            }
            l.f435563a.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.a
                @Override // java.lang.Runnable
                public final void run() {
                    AbsZPlanFilamentAvatarManager.Z(AbsZPlanFilamentAvatarManager.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a0() {
        if (AppSetting.o(BaseApplication.getContext())) {
            l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager$updateViewLayoutParams$1
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
                    FrameLayout.LayoutParams p16;
                    View filamentTextureView = AbsZPlanFilamentAvatarManager.this.getFilamentTextureView();
                    if (filamentTextureView == null) {
                        return;
                    }
                    p16 = AbsZPlanFilamentAvatarManager.this.p();
                    filamentTextureView.setLayoutParams(p16);
                }
            });
        } else {
            View view = this.filamentTextureView;
            if (view != null) {
                view.setLayoutParams(q());
            }
            View view2 = this.filamentTextureView;
            if (view2 != null) {
                view2.requestLayout();
            }
        }
        View view3 = this.filamentTextureView;
        if (view3 == null) {
            return;
        }
        view3.setTranslationY(r() ? o() : 0.0f);
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.g
    public void f(boolean show) {
        this.showAvatar.set(show);
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.g
    public boolean g(int scene) {
        return false;
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.g
    public Object h() {
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.g
    public void i(com.tencent.mobileqq.zplan.meme.frameanim.e avatarOverlayViewWiringHelper) {
        this.loadingHelper = new WeakReference<>(avatarOverlayViewWiringHelper);
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.g
    public Object j() {
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.g
    public void k(com.tencent.mobileqq.zplan.meme.frameanim.d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.exitFilamentListener = listener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int o() {
        j jVar;
        Point point = this.handPosition;
        if (point != null) {
            int dpToPx = ViewUtils.dpToPx(6.0f);
            FrameLayout frameLayout = this.rootViewRef.get();
            if (frameLayout == null) {
                return 0;
            }
            int height = frameLayout.getHeight();
            Integer e16 = ni3.a.f420201a.e();
            if (e16 == null || point.y <= 0) {
                return 0;
            }
            return (point.y - (height - e16.intValue())) - dpToPx;
        }
        String string = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(L, "");
        if (string.length() == 0) {
            return 0;
        }
        try {
            jVar = (j) new Gson().fromJson(string, j.class);
        } catch (Exception unused) {
            jVar = new j();
        }
        return jVar.getOffset();
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.g
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        QLog.i("FilamentAvatar", 1, "onConfigurationChanged " + newConfig);
        a0();
        X();
    }

    public boolean r() {
        return false;
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.g
    public void release() {
        O();
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.g
    public void resume() {
        L();
        P();
        M();
        a0();
        X();
    }

    protected abstract void s(boolean report);

    public final WeakReference<Context> u() {
        return this.contextWeak;
    }

    /* renamed from: v, reason: from getter */
    public final com.tencent.mobileqq.zplan.meme.frameanim.d getExitFilamentListener() {
        return this.exitFilamentListener;
    }

    /* renamed from: w, reason: from getter */
    public final View getFilamentTextureView() {
        return this.filamentTextureView;
    }

    protected final String x(c.Param staticAvatarParam) {
        String str;
        Intrinsics.checkNotNullParameter(staticAvatarParam, "staticAvatarParam");
        AppTheme appTheme = staticAvatarParam.getAppTheme();
        int gender = staticAvatarParam.getGender();
        String str2 = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(this.uin).appearanceKey;
        if (r()) {
            str = "_1";
        } else {
            str = "";
        }
        String str3 = am.f335779a.a() + "/frame/" + str2 + "_" + gender + "_" + appTheme + "_" + com.tencent.mobileqq.zplan.lite.b.f333795a.c() + str + ".png";
        Intrinsics.checkNotNullExpressionValue(str3, "StringBuilder(ZPlanFilam\u2026append(\".png\").toString()");
        QLog.i("FilamentAvatar", 1, "getFrameSavePath: " + str3);
        return str3;
    }

    /* renamed from: z, reason: from getter */
    public final Point getHandPosition() {
        return this.handPosition;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void K(View view) {
        if (view != null && this.filamentTextureView == null) {
            this.filamentTextureView = view;
            int A = A();
            QLog.i("FilamentAvatar", 1, "initFilamentView start, loadingIndex: " + A);
            View view2 = this.filamentTextureView;
            if (view2 != null) {
                QLog.i("FilamentAvatar", 1, "initFilamentView. filamentTextureView.visibility = View.VISIBLE");
                view2.setVisibility(0);
                if (A == -1) {
                    FrameLayout frameLayout = this.rootViewRef.get();
                    if (frameLayout != null) {
                        frameLayout.addView(view2);
                    }
                } else {
                    FrameLayout frameLayout2 = this.rootViewRef.get();
                    if (frameLayout2 != null) {
                        frameLayout2.addView(view2, A - 1);
                    }
                }
                a0();
            }
        }
    }

    public static /* synthetic */ String y(AbsZPlanFilamentAvatarManager absZPlanFilamentAvatarManager, c.Param param, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                param = c.Companion.d(com.tencent.mobileqq.zplan.meme.frameanim.c.INSTANCE, absZPlanFilamentAvatarManager.uin, null, null, 6, null);
            }
            return absZPlanFilamentAvatarManager.x(param);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFrameSavePath");
    }

    public static /* synthetic */ void t(AbsZPlanFilamentAvatarManager absZPlanFilamentAvatarManager, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = true;
            }
            absZPlanFilamentAvatarManager.s(z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: forceExitFilament");
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.g
    public void b() {
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.g
    public void onAccountChanged() {
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.g
    public void onThemeChange() {
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.g
    public void pause() {
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.g
    public void stop() {
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.g
    public void d(boolean onTabQzone) {
    }
}
