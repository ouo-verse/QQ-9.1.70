package com.tencent.mobileqq.zplan.meme.frameanim.manager;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.filament.zplan.business.api.IBusinessScene;
import com.tencent.filament.zplan.business.api.SceneType;
import com.tencent.filament.zplan.business.impl.AbsBusinessScene;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.filament.precompiled.PreCompiledUtilKt;
import com.tencent.mobileqq.zplan.meme.frameanim.j;
import com.tencent.mobileqq.zplan.meme.frameanim.manager.dynamic.DynamicBusinessScene;
import com.tencent.mobileqq.zplan.meme.frameanim.manager.profilecard.FriendProfileCardBusinessScene;
import com.tencent.mobileqq.zplan.meme.frameanim.manager.profilecard.ProfileCardBusinessScene;
import com.tencent.mobileqq.zplan.report.ZPlanMemoryUsageReport;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.sharedengine.ZPlanShareEngineScene;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import cooperation.qzone.api.IZPlanRefreshMoveListener;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t74.l;
import vk0.b;
import wk0.b;

@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001b\u0018\u0000 u2\u00020\u00012\u00020\u0002:\u00010B'\u0012\u0006\u0010o\u001a\u00020n\u0012\u0006\u0010q\u001a\u00020p\u0012\u0006\u0010r\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u00a2\u0006\u0004\bs\u0010tJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0014J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0015H\u0014J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0015H\u0016J\b\u0010%\u001a\u00020\u0005H\u0014J\b\u0010&\u001a\u00020\u0005H\u0014J\b\u0010'\u001a\u00020\u0003H\u0014J\b\u0010)\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u000eH\u0016J\b\u0010/\u001a\u00020\u000eH\u0016J\b\u00100\u001a\u00020\u0005H\u0016J\u0010\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0015H\u0016R\u0017\u0010\u0014\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001a\u0010;\u001a\u0002078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b%\u00108\u001a\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010<R\u001b\u0010P\u001a\u00020K8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001b\u0010T\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u0010M\u001a\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u00104R\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u001b\u0010]\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b[\u0010M\u001a\u0004\b\\\u0010SR\u0016\u0010^\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010<R\u001b\u0010a\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b_\u0010M\u001a\u0004\b`\u00106R\u0014\u0010e\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010i\u001a\u00020f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010m\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010l\u00a8\u0006v"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/manager/ZPlanFilamentAvatarNativeManager;", "Lcom/tencent/mobileqq/zplan/meme/frameanim/manager/AbsZPlanFilamentAvatarManager;", "Lvk0/d;", "", "picPath", "", "E0", "y0", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene;", "s0", "m0", "C0", "n0", "D0", "", "status", "o0", "offset", NodeProps.MAX_HEIGHT, "p0", "scene", "", "g", "r", "A0", "Lcom/tencent/filament/zplan/business/api/IBusinessScene;", "oldScene", "newScene", "C4", "report", ReportConstant.COSTREPORT_PREFIX, "resume", "pause", "stop", "release", "onTabQzone", "d", "N", "P", "v0", "", "j", "b", "onAccountChanged", "onThemeChange", "type", "c", "e", "a", "show", "f", "M", "I", "w0", "()I", "Loi3/b;", "Loi3/b;", "x0", "()Loi3/b;", "statistic", "Z", "hasReportFirstRender", "Lwk0/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lwk0/a;", "filamentNativeApp", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene;", "currScene", "Lcom/tencent/mobileqq/zplan/meme/frameanim/manager/dynamic/DynamicBusinessScene;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/zplan/meme/frameanim/manager/dynamic/DynamicBusinessScene;", "dynamicScene", "T", "isResume", "", "U", "Lkotlin/Lazy;", "r0", "()J", "delayReleaseTime", "V", "t0", "()Z", "enableFilamentRelease", "W", "currentAnimationStatus", "Lcom/tencent/mobileqq/zplan/report/ZPlanMemoryUsageReport;", "X", "Lcom/tencent/mobileqq/zplan/report/ZPlanMemoryUsageReport;", "memoryUsageReporter", "Y", "u0", "enableNativeAppConfig", "isSceneChanged", "a0", "q0", "avatarFps", "com/tencent/mobileqq/zplan/meme/frameanim/manager/ZPlanFilamentAvatarNativeManager$jsEventListener$1", "b0", "Lcom/tencent/mobileqq/zplan/meme/frameanim/manager/ZPlanFilamentAvatarNativeManager$jsEventListener$1;", "jsEventListener", "Lcooperation/qzone/api/IZPlanRefreshMoveListener;", "c0", "Lcooperation/qzone/api/IZPlanRefreshMoveListener;", "refreshMoveListener", "Ljava/lang/Runnable;", "d0", "Ljava/lang/Runnable;", "releaseEngine", "Landroid/content/Context;", "context", "Landroid/widget/FrameLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "uin", "<init>", "(Landroid/content/Context;Landroid/widget/FrameLayout;Ljava/lang/String;I)V", "e0", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFilamentAvatarNativeManager extends AbsZPlanFilamentAvatarManager implements vk0.d {

    /* renamed from: M, reason: from kotlin metadata */
    private final int scene;

    /* renamed from: N, reason: from kotlin metadata */
    private final oi3.b statistic;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean hasReportFirstRender;

    /* renamed from: Q, reason: from kotlin metadata */
    private wk0.a filamentNativeApp;

    /* renamed from: R, reason: from kotlin metadata */
    private AbsBusinessScene currScene;

    /* renamed from: S, reason: from kotlin metadata */
    private DynamicBusinessScene dynamicScene;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isResume;

    /* renamed from: U, reason: from kotlin metadata */
    private final Lazy delayReleaseTime;

    /* renamed from: V, reason: from kotlin metadata */
    private final Lazy enableFilamentRelease;

    /* renamed from: W, reason: from kotlin metadata */
    private int currentAnimationStatus;

    /* renamed from: X, reason: from kotlin metadata */
    private final ZPlanMemoryUsageReport memoryUsageReporter;

    /* renamed from: Y, reason: from kotlin metadata */
    private final Lazy enableNativeAppConfig;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean isSceneChanged;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final Lazy avatarFps;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final ZPlanFilamentAvatarNativeManager$jsEventListener$1 jsEventListener;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final IZPlanRefreshMoveListener refreshMoveListener;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final Runnable releaseEngine;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanFilamentAvatarNativeManager(Context context, FrameLayout rootView, String uin, int i3) {
        super(context, rootView, uin);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.scene = i3;
        this.statistic = new oi3.b(null, null, null, 7, null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.ZPlanFilamentAvatarNativeManager$delayReleaseTime$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(ZPlanFeatureSwitch.f369852a.t2());
            }
        });
        this.delayReleaseTime = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.ZPlanFilamentAvatarNativeManager$enableFilamentRelease$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(ZPlanFeatureSwitch.f369852a.z0());
            }
        });
        this.enableFilamentRelease = lazy2;
        this.memoryUsageReporter = new ZPlanMemoryUsageReport("ZPlanFilamentAvatarNativeManager");
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.ZPlanFilamentAvatarNativeManager$enableNativeAppConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z16 = ZPlanFilamentAvatarNativeManager.this.getScene() == 0 || ZPlanFilamentAvatarNativeManager.this.getScene() == 1;
                QLog.i("FilamentAvatar_NativeV2", 1, "enableZPlanShareNativeAppReuse: " + z16);
                return Boolean.valueOf(z16);
            }
        });
        this.enableNativeAppConfig = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.ZPlanFilamentAvatarNativeManager$avatarFps$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ZPlanQQMC.INSTANCE.getDynamicNativeAppFps());
            }
        });
        this.avatarFps = lazy4;
        this.jsEventListener = new ZPlanFilamentAvatarNativeManager$jsEventListener$1(this);
        this.refreshMoveListener = new b();
        y0();
        this.releaseEngine = new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.f
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanFilamentAvatarNativeManager.B0(ZPlanFilamentAvatarNativeManager.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(ZPlanFilamentAvatarNativeManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isResume) {
            return;
        }
        QLog.i("FilamentAvatar_NativeV2", 1, "running releaseEngine.");
        this$0.n0();
        this$0.D0();
    }

    private final void C0() {
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
        wk0.a aVar4 = this.filamentNativeApp;
        if (aVar4 != null) {
            aVar4.t("onSoLoadFinish", this.jsEventListener);
        }
        wk0.a aVar5 = this.filamentNativeApp;
        if (aVar5 != null) {
            aVar5.t("onAvatarResourceReady", this.jsEventListener);
        }
        wk0.a aVar6 = this.filamentNativeApp;
        if (aVar6 != null) {
            aVar6.t("onAnimationResourceReady", this.jsEventListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(String picPath) {
        View filamentTextureView = getFilamentTextureView();
        if (filamentTextureView != null) {
            int width = filamentTextureView.getWidth();
            View filamentTextureView2 = getFilamentTextureView();
            if (filamentTextureView2 != null) {
                int height = filamentTextureView2.getHeight();
                Point handPosition = getHandPosition();
                if (handPosition != null) {
                    int o16 = o();
                    j jVar = new j();
                    jVar.e(width);
                    jVar.b(height);
                    jVar.c(o16);
                    jVar.d(picPath);
                    IZPlanMMKVApi iZPlanMMKVApi = (IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class);
                    String a16 = AbsZPlanFilamentAvatarManager.INSTANCE.a();
                    String json = new Gson().toJson(jVar);
                    Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(data)");
                    iZPlanMMKVApi.setString(a16, json);
                    int i3 = handPosition.y;
                    View filamentTextureView3 = getFilamentTextureView();
                    Integer valueOf = filamentTextureView3 != null ? Integer.valueOf(filamentTextureView3.getWidth()) : null;
                    View filamentTextureView4 = getFilamentTextureView();
                    QLog.i("FilamentAvatar_NativeV2", 1, "first render handPosition.y=" + i3 + ", filamentTextureView.width=" + valueOf + ", filamentTextureView.height=" + (filamentTextureView4 != null ? Integer.valueOf(filamentTextureView4.getHeight()) : null) + ", offset=" + o16 + ", picPath=" + picPath);
                }
            }
        }
    }

    private final void m0() {
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
        wk0.a aVar4 = this.filamentNativeApp;
        if (aVar4 != null) {
            aVar4.c("onSoLoadFinish", this.jsEventListener);
        }
        wk0.a aVar5 = this.filamentNativeApp;
        if (aVar5 != null) {
            aVar5.c("onAvatarResourceReady", this.jsEventListener);
        }
        wk0.a aVar6 = this.filamentNativeApp;
        if (aVar6 != null) {
            aVar6.c("onAnimationResourceReady", this.jsEventListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() {
        wk0.a aVar;
        QLog.i("FilamentAvatar_NativeV2", 1, "destroyAndResetNativeApp, isSceneChanged=" + this.isSceneChanged + " " + Log.getStackTraceString(new Throwable()));
        if (!this.isSceneChanged && (aVar = this.filamentNativeApp) != null) {
            aVar.onDestroy();
        }
        this.filamentNativeApp = null;
        this.hasReportFirstRender = false;
        AbsBusinessScene absBusinessScene = this.currScene;
        ZPlanShareEngineScene zPlanShareEngineScene = absBusinessScene instanceof ZPlanShareEngineScene ? (ZPlanShareEngineScene) absBusinessScene : null;
        if (zPlanShareEngineScene != null) {
            zPlanShareEngineScene.removeSceneChangeListener(this);
        }
        this.dynamicScene = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(int status) {
        if (this.currentAnimationStatus == status) {
            return;
        }
        this.currentAnimationStatus = status;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", status);
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            b.a.a(aVar, "DynamicPageAvatar.onPlayStateChanged", jSONObject.toString(), null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(int offset, int maxHeight) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NodeProps.MAX_HEIGHT, maxHeight);
        jSONObject.put("offset", offset);
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            b.a.a(aVar, "DynamicPageAvatar.onScrollOffsetChanged", jSONObject.toString(), null, 4, null);
        }
    }

    private final int q0() {
        return ((Number) this.avatarFps.getValue()).intValue();
    }

    private final long r0() {
        return ((Number) this.delayReleaseTime.getValue()).longValue();
    }

    private final AbsBusinessScene s0() {
        ZPlanShareEngineScene zPlanShareEngineScene;
        IBusinessScene scene;
        if (!r()) {
            return new DynamicBusinessScene();
        }
        DynamicBusinessScene dynamicBusinessScene = this.dynamicScene;
        if (dynamicBusinessScene == null) {
            dynamicBusinessScene = new DynamicBusinessScene();
        }
        this.dynamicScene = dynamicBusinessScene;
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
        DynamicBusinessScene dynamicBusinessScene2 = this.dynamicScene;
        Intrinsics.checkNotNull(dynamicBusinessScene2);
        zPlanShareEngineScene.initScene(dynamicBusinessScene2);
        zPlanShareEngineScene.addSceneChangeListener(this);
        return zPlanShareEngineScene;
    }

    private final boolean t0() {
        return ((Boolean) this.enableFilamentRelease.getValue()).booleanValue();
    }

    private final boolean u0() {
        return ((Boolean) this.enableNativeAppConfig.getValue()).booleanValue();
    }

    private final void y0() {
        if (this.filamentNativeApp == null) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.e
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanFilamentAvatarNativeManager.z0(ZPlanFilamentAvatarNativeManager.this);
                }
            });
            wk0.a b16 = FilamentRenderFactory.b(FilamentRenderFactory.f105773b, null, q0(), Boolean.valueOf(r()), null, 9, null);
            PreCompiledUtilKt.e(b16);
            this.filamentNativeApp = b16;
            QLog.i("FilamentAvatar_NativeV2", 1, "create new IFilamentNativeApp:" + this + ", avatarFps=" + q0());
            A0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(ZPlanFilamentAvatarNativeManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.memoryUsageReporter.g();
    }

    protected void A0() {
        AbsBusinessScene profileCardBusinessScene;
        QLog.i("FilamentAvatar_NativeV2", 1, "initFilamentRender");
        m0();
        H().getReloadAvatarStep().l(al0.a.INSTANCE.b());
        int i3 = this.scene;
        if (i3 == 2) {
            profileCardBusinessScene = new ProfileCardBusinessScene();
        } else if (i3 != 3) {
            profileCardBusinessScene = s0();
        } else {
            profileCardBusinessScene = new FriendProfileCardBusinessScene(getUin());
        }
        this.currScene = profileCardBusinessScene;
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            Intrinsics.checkNotNull(profileCardBusinessScene);
            aVar.y("bundle/scenes/dynamic-page/main.js", profileCardBusinessScene);
        }
        Context context = u().get();
        if (context != null) {
            wk0.a aVar2 = this.filamentNativeApp;
            K(aVar2 != null ? b.a.a(aVar2, context, null, 2, null) : null);
            QLog.i("FilamentAvatar_NativeV2", 1, "initFilamentView. filamentTextureView.alpha = 0");
            View filamentTextureView = getFilamentTextureView();
            if (filamentTextureView == null) {
                return;
            }
            filamentTextureView.setAlpha(0.0f);
        }
    }

    @Override // vk0.d
    public void C4(IBusinessScene oldScene, IBusinessScene newScene) {
        Intrinsics.checkNotNullParameter(oldScene, "oldScene");
        Intrinsics.checkNotNullParameter(newScene, "newScene");
        QLog.i("FilamentAvatar_NativeV2", 1, "onSceneChange, oldScene=" + oldScene + ", newScene=" + newScene);
        if (newScene.getSceneType() == SceneType.DYNAMIC) {
            this.isSceneChanged = false;
            return;
        }
        DynamicBusinessScene dynamicBusinessScene = this.dynamicScene;
        if (dynamicBusinessScene != null) {
            dynamicBusinessScene.resetAnim();
        }
        C0();
        l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.ZPlanFilamentAvatarNativeManager$onSceneChange$1
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
                FrameLayout frameLayout;
                ZPlanFilamentAvatarNativeManager.this.Y(true);
                View filamentTextureView = ZPlanFilamentAvatarNativeManager.this.getFilamentTextureView();
                if (filamentTextureView != null && (frameLayout = ZPlanFilamentAvatarNativeManager.this.D().get()) != null) {
                    frameLayout.removeView(filamentTextureView);
                }
                ZPlanFilamentAvatarNativeManager.this.R(null);
            }
        });
        this.isSceneChanged = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager
    public void N() {
        QLog.i("FilamentAvatar_NativeV2", 1, "releaseEngine, enableFilamentRelease:" + t0() + ", isSceneChanged:" + this.isSceneChanged);
        if (this.isSceneChanged) {
            QLog.i("FilamentAvatar_NativeV2", 1, "releaseEngine disable, nativeApp is reused");
        } else if (t0()) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.releaseEngine);
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.releaseEngine, r0());
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager
    protected void P() {
        QLog.i("FilamentAvatar_NativeV2", 1, "removeReleaseEngine, enableFilamentRelease: " + t0());
        if (t0()) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.releaseEngine);
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.g
    public void a() {
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.onResume();
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager, com.tencent.mobileqq.zplan.meme.frameanim.g
    public void b() {
        wk0.a aVar;
        QLog.i("FilamentAvatar_NativeV2", 1, "onAppearanceKeyChanged, sceneChanged=" + this.isSceneChanged);
        if (this.isSceneChanged || (aVar = this.filamentNativeApp) == null) {
            return;
        }
        b.a.a(aVar, "onCostumeChange", null, null, 4, null);
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.g
    public void c(int type) {
        AbsBusinessScene absBusinessScene = this.currScene;
        ZPlanShareEngineScene zPlanShareEngineScene = absBusinessScene instanceof ZPlanShareEngineScene ? (ZPlanShareEngineScene) absBusinessScene : null;
        if (zPlanShareEngineScene != null) {
            zPlanShareEngineScene.dynamicJumpType(type);
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager, com.tencent.mobileqq.zplan.meme.frameanim.g
    public void d(boolean onTabQzone) {
        QLog.i("FilamentAvatar_NativeV2", 1, "onTabQzone : " + onTabQzone);
        if (onTabQzone) {
            return;
        }
        N();
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.g
    public int e() {
        if (!r()) {
            QLog.i("FilamentAvatar_NativeV2", 1, "    , disable");
            return 0;
        }
        DynamicBusinessScene dynamicBusinessScene = this.dynamicScene;
        if (dynamicBusinessScene == null) {
            return 0;
        }
        if (!dynamicBusinessScene.getFirstRenderEnd().get()) {
            QLog.i("FilamentAvatar_NativeV2", 1, "getFilamentNativeAppId, hasFirstFrame == false");
            return 0;
        }
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            return aVar.A();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager, com.tencent.mobileqq.zplan.meme.frameanim.g
    public void f(boolean show) {
        super.f(show);
        if (show) {
            return;
        }
        QLog.i("FilamentAvatar_NativeV2", 1, "hide avatar");
        ImageView staticBannerView = getStaticBannerView();
        if (staticBannerView == null) {
            return;
        }
        staticBannerView.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager, com.tencent.mobileqq.zplan.meme.frameanim.g
    public boolean g(int scene) {
        return com.tencent.mobileqq.zplan.lite.util.e.f333809a.n(scene);
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager, com.tencent.mobileqq.zplan.meme.frameanim.g
    public Object j() {
        return this.refreshMoveListener;
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager, com.tencent.mobileqq.zplan.meme.frameanim.g
    public void pause() {
        super.pause();
        QLog.i("FilamentAvatar_NativeV2", 1, "pause");
        this.isResume = false;
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager
    public boolean r() {
        return u0();
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager, com.tencent.mobileqq.zplan.meme.frameanim.g
    public void release() {
        super.release();
        QLog.i("FilamentAvatar_NativeV2", 1, "release");
        n0();
        D0();
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager, com.tencent.mobileqq.zplan.meme.frameanim.g
    public void resume() {
        if (!getShowAvatar().get()) {
            QLog.i("FilamentAvatar_NativeV2", 1, "resume, showAvatar false return.");
            return;
        }
        y0();
        super.resume();
        QLog.i("FilamentAvatar_NativeV2", 1, "resume");
        this.isResume = true;
        P();
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.onResume();
        }
        if (this.isSceneChanged) {
            A0();
            this.isSceneChanged = false;
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager
    protected void s(boolean report) {
        QLog.i("FilamentAvatar_NativeV2", 1, "forceExitFilament, report:" + report);
        l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.ZPlanFilamentAvatarNativeManager$forceExitFilament$1
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
                ZPlanFilamentAvatarNativeManager.this.n0();
                ZPlanFilamentAvatarNativeManager.this.D0();
            }
        });
        com.tencent.mobileqq.zplan.meme.frameanim.d exitFilamentListener = getExitFilamentListener();
        if (exitFilamentListener != null) {
            exitFilamentListener.a();
        }
        J();
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager, com.tencent.mobileqq.zplan.meme.frameanim.g
    public void stop() {
        super.stop();
        QLog.i("FilamentAvatar_NativeV2", 1, "stop");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String v0() {
        return "nativeV2";
    }

    /* renamed from: w0, reason: from getter */
    public final int getScene() {
        return this.scene;
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager
    /* renamed from: x0, reason: from getter and merged with bridge method [inline-methods] */
    public oi3.b H() {
        return this.statistic;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D0() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        QLog.i("FilamentAvatar_NativeV2", 1, "removeView");
        View filamentTextureView = getFilamentTextureView();
        if (filamentTextureView != null && (frameLayout2 = D().get()) != null) {
            frameLayout2.removeView(filamentTextureView);
        }
        R(null);
        ImageView staticBannerView = getStaticBannerView();
        if (staticBannerView != null && (frameLayout = D().get()) != null) {
            frameLayout.removeView(staticBannerView);
        }
        U(null);
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager, com.tencent.mobileqq.zplan.meme.frameanim.g
    public void onAccountChanged() {
        QLog.i("FilamentAvatar_NativeV2", 1, "onAccountChanged");
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            b.a.a(aVar, "onCostumeChange", null, null, 4, null);
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.manager.AbsZPlanFilamentAvatarManager, com.tencent.mobileqq.zplan.meme.frameanim.g
    public void onThemeChange() {
        QLog.i("FilamentAvatar_NativeV2", 1, "onThemeChange");
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            b.a.a(aVar, "onThemeChanged", null, null, 4, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/meme/frameanim/manager/ZPlanFilamentAvatarNativeManager$b", "Lcooperation/qzone/api/IZPlanRefreshMoveListener;", "", "topHeight", "", "onMove", "state", "onStateChange", "onRelease", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements IZPlanRefreshMoveListener {
        b() {
        }

        @Override // cooperation.qzone.api.IZPlanRefreshMoveListener
        public void onMove(int topHeight) {
            ni3.a aVar = ni3.a.f420201a;
            Integer e16 = aVar.e();
            Integer d16 = aVar.d();
            if (e16 != null && d16 != null) {
                int intValue = topHeight - e16.intValue();
                if (intValue > 0) {
                    ZPlanFilamentAvatarNativeManager.this.o0(1);
                    ZPlanFilamentAvatarNativeManager.this.p0(intValue, d16.intValue() - e16.intValue());
                    return;
                } else {
                    ZPlanFilamentAvatarNativeManager.this.o0(0);
                    return;
                }
            }
            QLog.e("FilamentAvatar_NativeV2", 1, "refreshMoveListener.onMove failed, initHeight: " + e16 + ", fullScreenHeight: " + d16 + ".");
        }

        @Override // cooperation.qzone.api.IZPlanRefreshMoveListener
        public void onRelease() {
            if (ZPlanFilamentAvatarNativeManager.this.r()) {
                return;
            }
            ZPlanFilamentAvatarNativeManager.this.o0(0);
        }

        @Override // cooperation.qzone.api.IZPlanRefreshMoveListener
        public void onStateChange(int state) {
        }
    }
}
