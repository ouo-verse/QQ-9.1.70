package com.tencent.aelight.camera.ae.flashshow.zshow;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.flashshow.zshow.FilamentPreviewView$reloadAvatarListener$2;
import com.tencent.aelight.camera.ae.flashshow.zshow.WinkZShowContext;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.filament.api.BaseZShowFilamentPreviewView;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.filament.light.camera.ZPlanFilamentRequestManager;
import com.tencent.filament.zplan.animation.GYZPlanAnimation;
import com.tencent.filament.zplan.data.RenderSize;
import com.tencent.filament.zplan.listener.GYScreenShotCallback;
import com.tencent.filament.zplan.listener.IAnimationSetListener;
import com.tencent.filament.zplan.view.GYFZPlanTextureView;
import com.tencent.filament.zplan.view.controller.GYFZPlanController;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.SupervisorKt;
import uk0.d;

@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001I\u0018\u0000 X2\u00020\u0001:\u0001\u000eB\u0011\b\u0016\u0012\u0006\u0010P\u001a\u00020O\u00a2\u0006\u0004\bQ\u0010RB\u001d\b\u0016\u0012\u0006\u0010P\u001a\u00020O\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010S\u00a2\u0006\u0004\bQ\u0010UB'\b\u0016\u0012\u0006\u0010P\u001a\u00020O\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010S\u0012\b\b\u0002\u0010V\u001a\u00020\u0005\u00a2\u0006\u0004\bQ\u0010WJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0013\u0010\u0018\u001a\u00020\u0017H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010!\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0005H\u0002J\b\u0010\"\u001a\u00020\u0007H\u0002R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00104\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010/R\u0016\u00105\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010/R\u0016\u00107\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010/R\u0016\u00109\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u00108R\u0016\u0010:\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u00108R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u00108R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0016\u0010;\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001dR\u0016\u0010<\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001dR\u0016\u0010>\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010\u001dR\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010\u001dR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u001b\u0010N\u001a\u00020I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006Y"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/zshow/FilamentPreviewView;", "Lcom/tencent/aelight/camera/filament/api/BaseZShowFilamentPreviewView;", "", "uin", "templateDirPath", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "setupBaseTemplate", "Lcom/tencent/aelight/camera/filament/api/BaseZShowFilamentPreviewView$a;", "listener", "setOnStatusListener", "localPath", "setMoodType", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Conn, "H", "event", "", "costTime", "I", "", HippyTKDListViewAdapter.X, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "errorCode", "E", UserInfo.SEX_FEMALE, "J", "Lcom/tencent/filament/zplan/animation/GYZPlanAnimation;", "animations", "result", "G", "w", "Lcom/tencent/filament/zplan/view/GYFZPlanTextureView;", "d", "Lcom/tencent/filament/zplan/view/GYFZPlanTextureView;", "previewView", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController;", "e", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController;", "previewController", "f", "Lcom/tencent/aelight/camera/filament/api/BaseZShowFilamentPreviewView$a;", "filamentStatusListener", tl.h.F, "Z", "isBaseMoodLoaded", "i", "isSurfaceCreate", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isBaseTemplateApply", "isLoadTemplateForDataReport", "D", "isFilamentResExit", "Ljava/lang/String;", "templatePath", "animationPath", "setupStartTime", "setMoodStartTime", "K", "loadResStartTime", "Landroid/os/CountDownTimer;", "L", "Landroid/os/CountDownTimer;", "setupCountDownTimer", "M", "setupMaxWaitingTime", "Lcom/tencent/aelight/camera/ae/flashshow/zshow/WinkZShowContext$FilamentState;", "N", "Lcom/tencent/aelight/camera/ae/flashshow/zshow/WinkZShowContext$FilamentState;", "filamentState", "com/tencent/aelight/camera/ae/flashshow/zshow/FilamentPreviewView$reloadAvatarListener$2$a", "P", "Lkotlin/Lazy;", "y", "()Lcom/tencent/aelight/camera/ae/flashshow/zshow/FilamentPreviewView$reloadAvatarListener$2$a;", "reloadAvatarListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class FilamentPreviewView extends BaseZShowFilamentPreviewView {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isLoadTemplateForDataReport;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isFilamentResExit;

    /* renamed from: E, reason: from kotlin metadata */
    private String templatePath;

    /* renamed from: F, reason: from kotlin metadata */
    private String animationPath;

    /* renamed from: G, reason: from kotlin metadata */
    private String uin;

    /* renamed from: H, reason: from kotlin metadata */
    private int requestId;

    /* renamed from: I, reason: from kotlin metadata */
    private long setupStartTime;

    /* renamed from: J, reason: from kotlin metadata */
    private long setMoodStartTime;

    /* renamed from: K, reason: from kotlin metadata */
    private long loadResStartTime;

    /* renamed from: L, reason: from kotlin metadata */
    private CountDownTimer setupCountDownTimer;

    /* renamed from: M, reason: from kotlin metadata */
    private long setupMaxWaitingTime;

    /* renamed from: N, reason: from kotlin metadata */
    private WinkZShowContext.FilamentState filamentState;

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy reloadAvatarListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GYFZPlanTextureView previewView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GYFZPlanController previewController;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private BaseZShowFilamentPreviewView.a filamentStatusListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isBaseMoodLoaded;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isSurfaceCreate;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isBaseTemplateApply;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/zshow/FilamentPreviewView$b", "Luk0/d;", "Landroid/view/Surface;", "surface", "", "width", "height", "", "a", "b", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements uk0.d {
        b() {
        }

        @Override // uk0.d
        public void a(Surface surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            ms.a.a("FilamentPreviewView", "onSurfaceTextureAvailable ");
            FilamentPreviewView.this.isSurfaceCreate = true;
            if (FilamentPreviewView.this.isBaseMoodLoaded && FilamentPreviewView.this.isSurfaceCreate) {
                FilamentPreviewView filamentPreviewView = FilamentPreviewView.this;
                filamentPreviewView.J(filamentPreviewView.templatePath, FilamentPreviewView.this.uin, FilamentPreviewView.this.requestId);
            }
        }

        @Override // uk0.d
        public void b(Surface surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            ms.a.f("FilamentPreviewView", "onSurfaceTextureDestroyed ");
            FilamentPreviewView.this.isSurfaceCreate = false;
        }

        @Override // uk0.d
        public void onSurfaceChanged(Surface surface) {
            d.a.a(this, surface);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/zshow/FilamentPreviewView$c", "Lcom/tencent/filament/zplan/listener/GYScreenShotCallback;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "onScreenShot", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class c implements GYScreenShotCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f65177a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FilamentPreviewView f65178b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f65179c;

        c(long j3, FilamentPreviewView filamentPreviewView, int i3) {
            this.f65177a = j3;
            this.f65178b = filamentPreviewView;
            this.f65179c = i3;
        }

        @Override // com.tencent.filament.zplan.listener.GYScreenShotCallback
        public void onScreenShot(Bitmap bitmap) {
            long currentTimeMillis = System.currentTimeMillis() - this.f65177a;
            ms.a.a("FilamentPreviewView", "onScreenShot duration: " + currentTimeMillis);
            this.f65178b.I("performance#filament_view#take_frame", currentTimeMillis);
            BaseZShowFilamentPreviewView.a aVar = this.f65178b.filamentStatusListener;
            if (aVar != null) {
                aVar.d(this.f65179c, this.f65178b.animationPath, bitmap);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/zshow/FilamentPreviewView$d", "Lcom/tencent/filament/zplan/listener/IAnimationSetListener;", "Lcom/tencent/filament/zplan/animation/GYZPlanAnimation;", "animations", "", "result", "", "onSetAnimationResult", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class d implements IAnimationSetListener {
        d() {
        }

        @Override // com.tencent.filament.zplan.listener.IAnimationSetListener
        public void onSetAnimationResult(GYZPlanAnimation gYZPlanAnimation, int i3, int i16) {
            IAnimationSetListener.a.a(this, gYZPlanAnimation, i3, i16);
        }

        @Override // com.tencent.filament.zplan.listener.IAnimationSetListener
        public void onSetAnimationResult(GYZPlanAnimation animations, int result) {
            Intrinsics.checkNotNullParameter(animations, "animations");
            FilamentPreviewView.this.G(animations, result);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/zshow/FilamentPreviewView$e", "Luk0/a;", "", "result", "", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class e implements uk0.a {
        e() {
        }

        @Override // uk0.a
        public void a(int result) {
            long currentTimeMillis = System.currentTimeMillis() - FilamentPreviewView.this.setMoodStartTime;
            ms.a.f("FilamentPreviewView", "onFirstFrameFinish " + result + ", duration: " + currentTimeMillis);
            FilamentPreviewView.this.I("performance#filament_view#setup_animation", currentTimeMillis);
            BaseZShowFilamentPreviewView.a aVar = FilamentPreviewView.this.filamentStatusListener;
            if (aVar != null) {
                aVar.b(result, FilamentPreviewView.this.animationPath);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentPreviewView(Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.templatePath = "";
        this.animationPath = "";
        this.uin = "";
        this.requestId = -1;
        this.setupMaxWaitingTime = 10000L;
        this.filamentState = WinkZShowContext.FilamentState.PREPARE;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FilamentPreviewView$reloadAvatarListener$2.a>() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.FilamentPreviewView$reloadAvatarListener$2

            @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/zshow/FilamentPreviewView$reloadAvatarListener$2$a", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$c;", "", "result", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes32.dex */
            public static final class a implements GYFZPlanController.c {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ FilamentPreviewView f65184a;

                a(FilamentPreviewView filamentPreviewView) {
                    this.f65184a = filamentPreviewView;
                }

                @Override // com.tencent.filament.zplan.view.controller.GYFZPlanController.c
                public void a(int result, int requestId) {
                    ms.a.a("FilamentPreviewView", "onSetAvatarResult result " + result + " requestId " + requestId);
                    if (result == 0) {
                        this.f65184a.F(requestId);
                    } else {
                        this.f65184a.E(requestId, result);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(FilamentPreviewView.this);
            }
        });
        this.reloadAvatarListener = lazy;
        ms.a.f("FilamentPreviewView", "init ");
        this.setupMaxWaitingTime = QzoneConfig.getFilamentPreviewMaxLoadingDuration();
        C();
    }

    private final void A() {
        ms.a.f("FilamentPreviewView", "initView ");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.b
            @Override // java.lang.Runnable
            public final void run() {
                FilamentPreviewView.B(FilamentPreviewView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(FilamentPreviewView this$0) {
        GYFZPlanTextureView gYFZPlanTextureView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GYFZPlanTextureView gYFZPlanTextureView2 = new GYFZPlanTextureView(context, new RenderSize(720, 720), false, Boolean.FALSE);
        this$0.previewView = gYFZPlanTextureView2;
        gYFZPlanTextureView2.setOpaque(false);
        GYFZPlanController gYFZPlanController = this$0.previewController;
        if (gYFZPlanController != null && (gYFZPlanTextureView = this$0.previewView) != null) {
            Intrinsics.checkNotNull(gYFZPlanController);
            gYFZPlanTextureView.setController(gYFZPlanController);
        }
        GYFZPlanTextureView gYFZPlanTextureView3 = this$0.previewView;
        if (gYFZPlanTextureView3 != null) {
            gYFZPlanTextureView3.setAutoInitFilament(false);
        }
        GYFZPlanTextureView gYFZPlanTextureView4 = this$0.previewView;
        if (gYFZPlanTextureView4 != null) {
            gYFZPlanTextureView4.setFilamentRenderListener(new b());
        }
        this$0.addView(this$0.previewView);
        long currentTimeMillis = System.currentTimeMillis() - this$0.loadResStartTime;
        this$0.I("performance#filament_view#load_filament", currentTimeMillis);
        ms.a.f("FilamentPreviewView", "init view duration: " + currentTimeMillis);
    }

    private final void C() {
        ms.a.f("FilamentPreviewView", "loadFilament ");
        this.loadResStartTime = System.currentTimeMillis();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.a
            @Override // java.lang.Runnable
            public final void run() {
                FilamentPreviewView.D(FilamentPreviewView.this);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(FilamentPreviewView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        BuildersKt__BuildersKt.runBlocking$default(null, new FilamentPreviewView$loadFilament$1$1(booleanRef, this$0, null), 1, null);
        boolean loadOnlyFilament = booleanRef.element ? ((IAEResUtil) QRoute.api(IAEResUtil.class)).loadOnlyFilament() : false;
        this$0.H();
        if (booleanRef.element && loadOnlyFilament) {
            this$0.z();
            this$0.A();
        } else {
            this$0.E(this$0.requestId, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(int requestId, int errorCode) {
        ms.a.f("FilamentPreviewView", "onLoadingFailed " + errorCode);
        this.filamentState = WinkZShowContext.FilamentState.FAILED;
        BaseZShowFilamentPreviewView.a aVar = this.filamentStatusListener;
        if (aVar != null) {
            aVar.c(requestId, errorCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(int requestId) {
        String str;
        long currentTimeMillis = System.currentTimeMillis() - this.setupStartTime;
        if (this.isLoadTemplateForDataReport) {
            str = "performance#filament_view#setup_base_uin";
        } else {
            str = "performance#filament_view#setup_uin";
        }
        I(str, currentTimeMillis);
        ms.a.a("FilamentPreviewView", "onLoadingSucc duration: " + currentTimeMillis);
        this.filamentState = WinkZShowContext.FilamentState.SUCC;
        BaseZShowFilamentPreviewView.a aVar = this.filamentStatusListener;
        if (aVar != null) {
            aVar.a(requestId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(GYZPlanAnimation animations, int result) {
        ms.a.a("FilamentPreviewView", "onSetAnimationResult " + result + "  duration " + (System.currentTimeMillis() - this.setMoodStartTime));
        String moodPath = animations.getMoodPath();
        this.animationPath = moodPath;
        if (result == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            GYFZPlanController gYFZPlanController = this.previewController;
            if (gYFZPlanController != null) {
                gYFZPlanController.u0(new c(currentTimeMillis, this, result));
            }
            GYFZPlanController gYFZPlanController2 = this.previewController;
            if (gYFZPlanController2 != null) {
                gYFZPlanController2.Z();
                return;
            }
            return;
        }
        BaseZShowFilamentPreviewView.a aVar = this.filamentStatusListener;
        if (aVar != null) {
            aVar.b(result, moodPath);
        }
    }

    private final void H() {
        ZPlanFilamentRequestManager.Light3DFilamentRegisterDownloadImpl(new xq.e(null, 1, 0 == true ? 1 : 0), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(String event, long costTime) {
        HashMap hashMap = new HashMap();
        hashMap.put("filament_view_cost_time", String.valueOf(costTime));
        if (Intrinsics.areEqual(event, "performance#filament_view#load_filament")) {
            hashMap.put("filament_view_is_first_time", Integer.valueOf(!this.isFilamentResExit ? 1 : 0));
        }
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportWinkCommonEvents(event, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(final String templateDirPath, final String uin, final int requestId) {
        ms.a.a("FilamentPreviewView", "updateTemplate " + templateDirPath + " " + uin + " " + requestId);
        this.setupStartTime = System.currentTimeMillis();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.c
            @Override // java.lang.Runnable
            public final void run() {
                FilamentPreviewView.K(FilamentPreviewView.this, templateDirPath, uin, requestId);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(FilamentPreviewView this$0, String templateDirPath, String uin, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(templateDirPath, "$templateDirPath");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        GYFZPlanController gYFZPlanController = this$0.previewController;
        if (gYFZPlanController != null) {
            gYFZPlanController.Y();
        }
        boolean z16 = this$0.isBaseTemplateApply;
        this$0.isLoadTemplateForDataReport = !z16;
        if (!z16) {
            GYFZPlanController gYFZPlanController2 = this$0.previewController;
            if (gYFZPlanController2 != null) {
                gYFZPlanController2.m0(templateDirPath);
            }
            this$0.isBaseTemplateApply = true;
        }
        GYFZPlanController gYFZPlanController3 = this$0.previewController;
        if (gYFZPlanController3 != null) {
            gYFZPlanController3.j0(uin, i3);
        }
    }

    private final void w() {
        ms.a.a("FilamentPreviewView", "cancelCountDown ");
        CountDownTimer countDownTimer = this.setupCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.setupCountDownTimer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object x(Continuation<? super Boolean> continuation) {
        return SupervisorKt.supervisorScope(new FilamentPreviewView$fetchFilamentRes$2(this, null), continuation);
    }

    private final FilamentPreviewView$reloadAvatarListener$2.a y() {
        return (FilamentPreviewView$reloadAvatarListener$2.a) this.reloadAvatarListener.getValue();
    }

    private final void z() {
        ms.a.f("FilamentPreviewView", "initPreviewController ");
        GYFZPlanController gYFZPlanController = new GYFZPlanController(new RenderSize(0, 0), "{\n  \"enableParticleSystem\": true,\n  \"showSurroundSlot\": true\n}", false, false, 12, null);
        this.previewController = gYFZPlanController;
        gYFZPlanController.n0(y());
    }

    @Override // com.tencent.aelight.camera.filament.api.BaseZShowFilamentPreviewView
    public void a() {
        ms.a.f("FilamentPreviewView", "release ");
        GYFZPlanTextureView gYFZPlanTextureView = this.previewView;
        if (gYFZPlanTextureView != null) {
            gYFZPlanTextureView.d();
        }
        w();
    }

    @Override // com.tencent.aelight.camera.filament.api.BaseZShowFilamentPreviewView
    public void setMoodType(String localPath) {
        ms.a.a("FilamentPreviewView", "setMoodType " + localPath);
        this.setMoodStartTime = System.currentTimeMillis();
        if (localPath == null) {
            return;
        }
        GYFZPlanController gYFZPlanController = this.previewController;
        if (gYFZPlanController != null) {
            gYFZPlanController.g0(localPath, new d());
        }
        GYFZPlanController gYFZPlanController2 = this.previewController;
        if (gYFZPlanController2 != null) {
            gYFZPlanController2.o0(new e());
        }
    }

    @Override // com.tencent.aelight.camera.filament.api.BaseZShowFilamentPreviewView
    public void setOnStatusListener(BaseZShowFilamentPreviewView.a listener) {
        ms.a.a("FilamentPreviewView", "setOnStatusListener");
        this.filamentStatusListener = listener;
    }

    @Override // com.tencent.aelight.camera.filament.api.BaseZShowFilamentPreviewView
    public void setupBaseTemplate(String uin, String templateDirPath, int requestId) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(templateDirPath, "templateDirPath");
        ms.a.a("FilamentPreviewView", "setupBaseTemplate " + templateDirPath + " " + uin + " " + requestId + " ");
        this.filamentState = WinkZShowContext.FilamentState.LOADING;
        this.templatePath = templateDirPath;
        this.uin = uin;
        this.requestId = requestId;
        this.isBaseMoodLoaded = true;
        if (this.isSurfaceCreate) {
            J(templateDirPath, uin, requestId);
        }
        w();
        long j3 = this.setupMaxWaitingTime;
        f fVar = new f(requestId, j3, j3);
        this.setupCountDownTimer = fVar;
        fVar.start();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.templatePath = "";
        this.animationPath = "";
        this.uin = "";
        this.requestId = -1;
        this.setupMaxWaitingTime = 10000L;
        this.filamentState = WinkZShowContext.FilamentState.PREPARE;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FilamentPreviewView$reloadAvatarListener$2.a>() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.FilamentPreviewView$reloadAvatarListener$2

            @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/zshow/FilamentPreviewView$reloadAvatarListener$2$a", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$c;", "", "result", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes32.dex */
            public static final class a implements GYFZPlanController.c {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ FilamentPreviewView f65184a;

                a(FilamentPreviewView filamentPreviewView) {
                    this.f65184a = filamentPreviewView;
                }

                @Override // com.tencent.filament.zplan.view.controller.GYFZPlanController.c
                public void a(int result, int requestId) {
                    ms.a.a("FilamentPreviewView", "onSetAvatarResult result " + result + " requestId " + requestId);
                    if (result == 0) {
                        this.f65184a.F(requestId);
                    } else {
                        this.f65184a.E(requestId, result);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(FilamentPreviewView.this);
            }
        });
        this.reloadAvatarListener = lazy;
        ms.a.f("FilamentPreviewView", "init ");
        this.setupMaxWaitingTime = QzoneConfig.getFilamentPreviewMaxLoadingDuration();
        C();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentPreviewView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.templatePath = "";
        this.animationPath = "";
        this.uin = "";
        this.requestId = -1;
        this.setupMaxWaitingTime = 10000L;
        this.filamentState = WinkZShowContext.FilamentState.PREPARE;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FilamentPreviewView$reloadAvatarListener$2.a>() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.FilamentPreviewView$reloadAvatarListener$2

            @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/zshow/FilamentPreviewView$reloadAvatarListener$2$a", "Lcom/tencent/filament/zplan/view/controller/GYFZPlanController$c;", "", "result", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes32.dex */
            public static final class a implements GYFZPlanController.c {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ FilamentPreviewView f65184a;

                a(FilamentPreviewView filamentPreviewView) {
                    this.f65184a = filamentPreviewView;
                }

                @Override // com.tencent.filament.zplan.view.controller.GYFZPlanController.c
                public void a(int result, int requestId) {
                    ms.a.a("FilamentPreviewView", "onSetAvatarResult result " + result + " requestId " + requestId);
                    if (result == 0) {
                        this.f65184a.F(requestId);
                    } else {
                        this.f65184a.E(requestId, result);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(FilamentPreviewView.this);
            }
        });
        this.reloadAvatarListener = lazy;
        ms.a.f("FilamentPreviewView", "init ");
        this.setupMaxWaitingTime = QzoneConfig.getFilamentPreviewMaxLoadingDuration();
        C();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/zshow/FilamentPreviewView$f", "Landroid/os/CountDownTimer;", "", "onFinish", "", "p0", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class f extends CountDownTimer {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f65183b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(int i3, long j3, long j16) {
            super(j3, j16);
            this.f65183b = i3;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ms.a.f("FilamentPreviewView", "onFinish " + FilamentPreviewView.this.setupMaxWaitingTime);
            if (FilamentPreviewView.this.filamentState == WinkZShowContext.FilamentState.LOADING) {
                if (FilamentPreviewView.this.isSurfaceCreate) {
                    FilamentPreviewView.this.E(this.f65183b, 7);
                } else {
                    FilamentPreviewView.this.E(this.f65183b, 6);
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long p06) {
        }
    }
}
