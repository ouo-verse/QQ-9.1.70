package com.tencent.filament.zplan.scene.tofu;

import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.app.scene.BaseSceneV2305;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.Directional;
import com.tencent.filament.zplan.avatar.Exposure;
import com.tencent.filament.zplan.avatar.IndirectLight;
import com.tencent.filament.zplan.avatar.LensProjection;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.LookAt;
import com.tencent.filament.zplan.avatar.SpotLight;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.exception.BlackListResourceException;
import com.tencent.filament.zplan.avatar.exception.FetchFileException;
import com.tencent.filament.zplan.avatar.exception.IllegalViewerException;
import com.tencent.filament.zplan.avatar.model.BootResourceModel;
import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplan.avatar.model.Resource;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.filament.zplan.scene.couple.config.AvatarConfig;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import sk0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bb\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001`\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001nB\u001f\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\f\u0010k\u001a\b\u0012\u0004\u0012\u00020j0i\u00a2\u0006\u0004\bl\u0010mJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J-\u0010\u000e\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\u001a\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010\u001c\u001a\u00020\u001b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0002J2\u0010$\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\rH\u0002J6\u0010)\u001a\u00020'2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010&\u001a\u00020%2\u0006\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'H\u0002J \u0010,\u001a\b\u0012\u0004\u0012\u00020\u001d0+2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010*\u001a\u00020\nH\u0002J\"\u0010-\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\nH\u0002J\"\u00100\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\nH\u0002J \u00102\u001a\b\u0012\u0004\u0012\u00020\u001f0+2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u00101\u001a\u00020!H\u0002J(\u00105\u001a\b\u0012\u0004\u0012\u00020\r0+2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\nH\u0002J\"\u00106\u001a\u00020!2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0002J\b\u00107\u001a\u00020\u0006H\u0002J\b\u00108\u001a\u00020\u0006H\u0002J\u0010\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u000209H\u0002R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010E\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010BR\u0018\u0010H\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010M\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010BR\u0014\u0010O\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010BR\u0016\u0010R\u001a\u00020P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u00107R\u0016\u0010T\u001a\u00020P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u00107R\u0016\u0010V\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010FR\u0016\u0010X\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010BR\u0018\u0010[\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010c\u001a\u00020`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u001a\u0010h\u001a\u00020d8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010e\u001a\u0004\bf\u0010g\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006o"}, d2 = {"Lcom/tencent/filament/zplan/scene/tofu/TofuScene;", "Lcom/tencent/filament/zplan/app/scene/BaseSceneV2305;", "Lkotlinx/coroutines/CoroutineScope;", "", "totalTime", "frameTime", "", "d", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "faceAnimUrl", "bodyAnimUrl", "Lcom/tencent/filament/zplan/scene/couple/config/a;", "d0", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "errorCode", "errorMessage", "o", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "B", "", "now", "V", "eventData", "Lkotlinx/coroutines/Job;", "i0", "Lcom/tencent/filament/zplan/avatar/model/BootResourceModel;", "bootResource", "Lcom/tencent/filament/zplan/avatar/model/ReloadAvatarResourceModel;", "avatarResourceModel", "Lorg/json/JSONObject;", "avatarCharacter", "avatarConfig", "a0", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", "viewer", "Lxk0/a;", "oldAvatarAsset", "b0", "bodyTypeName", "Lkotlinx/coroutines/Deferred;", "e0", "W", "Lcom/tencent/zplan/zplantracing/b;", "bootSpan", "c0", "avatarInfo", "f0", "headAnimation", "bodyAnimation", "g0", "X", "Z", "Y", "", "throwable", "h0", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "G", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "Ljava/util/concurrent/atomic/AtomicBoolean;", "H", "Ljava/util/concurrent/atomic/AtomicBoolean;", "booted", "I", "avatarCreated", "J", "Lxk0/a;", "avatar", "K", "D", "animationBeginTime", "L", "needRecordFrame", "M", "hasRecordFrame", "", "N", "hasDownloadFromNet", "P", "hasPaused", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "animationGapTime", BdhLogUtil.LogTag.Tag_Req, "hasDestroyed", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/Double;", "animationTraceDuration", "Landroid/os/Handler;", "T", "Landroid/os/Handler;", "mainHandler", "com/tencent/filament/zplan/scene/tofu/TofuScene$d", "U", "Lcom/tencent/filament/zplan/scene/tofu/TofuScene$d;", "recordFrameListener", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "app", "<init>", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/ref/WeakReference;)V", "b", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class TofuScene extends BaseSceneV2305 implements CoroutineScope {

    /* renamed from: G, reason: from kotlin metadata */
    private final FilamentUrlTemplate urlTemplate;

    /* renamed from: H, reason: from kotlin metadata */
    private final AtomicBoolean booted;

    /* renamed from: I, reason: from kotlin metadata */
    private final AtomicBoolean avatarCreated;

    /* renamed from: J, reason: from kotlin metadata */
    private xk0.a avatar;

    /* renamed from: K, reason: from kotlin metadata */
    private double animationBeginTime;

    /* renamed from: L, reason: from kotlin metadata */
    private final AtomicBoolean needRecordFrame;

    /* renamed from: M, reason: from kotlin metadata */
    private final AtomicBoolean hasRecordFrame;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean hasDownloadFromNet;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean hasPaused;

    /* renamed from: Q, reason: from kotlin metadata */
    private long animationGapTime;

    /* renamed from: R, reason: from kotlin metadata */
    private AtomicBoolean hasDestroyed;

    /* renamed from: S, reason: from kotlin metadata */
    private Double animationTraceDuration;

    /* renamed from: T, reason: from kotlin metadata */
    private final Handler mainHandler;

    /* renamed from: U, reason: from kotlin metadata */
    private final d recordFrameListener;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final CoroutineContext coroutineContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TofuScene f106121d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CoroutineContext.Key key, TofuScene tofuScene) {
            super(key);
            this.f106121d = tofuScene;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            FLog.INSTANCE.e("TofuScene", "there is an error in coroutine.", exception);
            this.f106121d.h0(exception);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/filament/zplan/scene/tofu/TofuScene$c", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class c implements b {
        c() {
        }

        @Override // sk0.b
        public void handleEvent(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull String type, @Nullable String data) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (type.hashCode() == 1114800698 && type.equals("TofuScene.LoadScene")) {
                TofuScene.this.i0(spanContext, data);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/filament/zplan/scene/tofu/TofuScene$d", "Lcom/tencent/filament/zplan/d;", "", "pixels", "", "width", "height", "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class d implements com.tencent.filament.zplan.d {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WeakReference f106124b;

        d(WeakReference weakReference) {
            this.f106124b = weakReference;
        }

        @Override // com.tencent.filament.zplan.d
        public void a(@Nullable byte[] pixels, int width, int height) {
            FLog.INSTANCE.i("TofuScene", "onRecordFrame, width:" + width + ", height:" + height);
            FilamentNativeAppV2305 filamentNativeAppV2305 = (FilamentNativeAppV2305) this.f106124b.get();
            if (filamentNativeAppV2305 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("hasNetProcess", TofuScene.this.hasDownloadFromNet);
                jSONObject.put("hasPaused", TofuScene.this.hasPaused);
                Unit unit = Unit.INSTANCE;
                filamentNativeAppV2305.dispatchEvent(null, "onFirstFrameRenderEnd", jSONObject.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TofuScene(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull WeakReference<FilamentNativeAppV2305> app) {
        super(cVar, app);
        sk0.a configuration;
        FilamentUrlTemplate urlTemplate;
        Intrinsics.checkNotNullParameter(app, "app");
        FilamentNativeAppV2305 filamentNativeAppV2305 = app.get();
        this.urlTemplate = (filamentNativeAppV2305 == null || (configuration = filamentNativeAppV2305.getConfiguration()) == null || (urlTemplate = configuration.getUrlTemplate()) == null) ? FilamentFeatureUtil.f106409g.F() : urlTemplate;
        this.booted = new AtomicBoolean(false);
        this.avatarCreated = new AtomicBoolean(false);
        this.needRecordFrame = new AtomicBoolean(true);
        this.hasRecordFrame = new AtomicBoolean(false);
        this.animationGapTime = 3000L;
        this.hasDestroyed = new AtomicBoolean(false);
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.recordFrameListener = new d(app);
        c cVar2 = new c();
        FilamentNativeAppV2305 filamentNativeAppV23052 = app.get();
        if (filamentNativeAppV23052 != null) {
            filamentNativeAppV23052.addEventListener("TofuScene.LoadScene", cVar2);
        }
        this.coroutineContext = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()).plus(new a(CoroutineExceptionHandler.INSTANCE, this));
    }

    private final void V(double now, com.tencent.zplan.zplantracing.c spanContext) {
        xk0.a aVar;
        double d16 = this.animationBeginTime;
        double d17 = 0.0d;
        if (d16 == 0.0d) {
            this.animationBeginTime = now;
        } else {
            d17 = now - d16;
        }
        Double d18 = this.animationTraceDuration;
        if (d18 != null) {
            Intrinsics.checkNotNull(d18);
            if (d17 > d18.doubleValue()) {
                q();
                this.mainHandler.postDelayed(new Runnable() { // from class: com.tencent.filament.zplan.scene.tofu.TofuScene$animate$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AtomicBoolean atomicBoolean;
                        atomicBoolean = TofuScene.this.hasDestroyed;
                        if (!atomicBoolean.get()) {
                            TofuScene.this.r();
                            TofuScene.this.animationBeginTime = 0.0d;
                        }
                    }
                }, this.animationGapTime);
            }
        }
        FilamentViewerV2305 viewer = getViewer();
        if (viewer != null && (aVar = this.avatar) != null) {
            aVar.a(viewer, d17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(com.tencent.zplan.zplantracing.c spanContext, final BootResourceModel bootResource, final String bodyTypeName) {
        if (this.booted.get()) {
            return;
        }
        final com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("boot", spanContext);
        k().d("boot", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.tofu.TofuScene$bootAsync$1
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
                TofuScene.this.c0(startSpan, bootResource, bodyTypeName);
            }
        });
    }

    private final JSONObject X(com.tencent.zplan.zplantracing.c spanContext, ReloadAvatarResourceModel avatarResourceModel, JSONObject avatarCharacter) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put("HandHeldSlot");
        Unit unit = Unit.INSTANCE;
        jSONObject.put("hideSlotPart", jSONArray);
        JSONObject o16 = ZPlanAvatarResourceHelper.f105660o.o(avatarResourceModel, avatarCharacter, false, false, false, spanContext);
        o16.put("avatarMask", jSONObject);
        return o16;
    }

    private final void Y() {
        String str;
        boolean z16;
        FilamentViewerV2305 viewer = getViewer();
        if (viewer != null) {
            CameraParams cameraParams = new CameraParams(null, null, null, null, null, 31, null);
            cameraParams.setExposure(new Exposure(16, 100.0d, 0.008d));
            cameraParams.setLookAt(new LookAt(new float[]{0.0f, 1.0f, 9.102006f}, new float[]{0.0f, 0.7090301f, 0.0f}, new float[]{0.0f, 1.0f, 0.0f}));
            cameraParams.setLensProjection(new LensProjection(1.0f, 1000.0f, 120, 0.05f));
            try {
                str = new Gson().toJson(cameraParams);
            } catch (Throwable unused) {
                FLog.INSTANCE.e("TofuScene", "configCamera failed");
                str = "";
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return;
            }
            viewer.setCamera(str);
        }
    }

    private final void Z() {
        List mutableListOf;
        SpotLight spotLight = new SpotLight("spotLight1", new float[]{1.017f, 1.017f, 0.905f}, new float[]{-0.61f, 0.281f, -0.741f}, new float[]{0.8f, 0.8f, 1.0f}, 123380.0f, 10.0d, 10, 50, false);
        SpotLight spotLight2 = new SpotLight("spotLight2", new float[]{0.152f, 0.273f, -1.897f}, new float[]{-0.307f, -0.237f, 0.922f}, new float[]{0.5f, 0.5f, 1.0f}, 48330.0f, 30.0d, 10, 40, false);
        Directional directional = new Directional(new float[]{1.0f, 0.94f, 0.99f}, 0, 67000.0f, new float[]{0.5f, -0.246f, -0.856f}, true, 2, null);
        IndirectLight indirectLight = new IndirectLight(null, 5000.0f, 1, null);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(spotLight, spotLight2);
        LightsParams lightsParams = new LightsParams(directional, indirectLight, mutableListOf);
        FilamentViewerV2305 viewer = getViewer();
        if (viewer != null) {
            viewer.setLights(lightsParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(com.tencent.zplan.zplantracing.c spanContext, BootResourceModel bootResource, ReloadAvatarResourceModel avatarResourceModel, JSONObject avatarCharacter, AvatarConfig avatarConfig) throws IllegalViewerException {
        Y();
        Z();
        FilamentViewerV2305 viewer = getViewer();
        if (viewer != null) {
            xk0.a b06 = b0(spanContext, viewer, avatarCharacter, avatarResourceModel, this.avatar);
            avatarConfig.l(true);
            Unit unit = Unit.INSTANCE;
            b06.m(spanContext, viewer, avatarConfig, false);
            this.avatar = b06;
            this.animationTraceDuration = b06.i();
            this.avatarCreated.set(true);
            this.hasRecordFrame.set(false);
            return;
        }
        throw new IllegalViewerException();
    }

    private final xk0.a b0(com.tencent.zplan.zplantracing.c spanContext, FilamentViewerV2305 viewer, JSONObject avatarCharacter, ReloadAvatarResourceModel avatarResourceModel, xk0.a oldAvatarAsset) {
        if (oldAvatarAsset != null) {
            viewer.updateRenderObjectAvatar(spanContext, oldAvatarAsset.getRenderObjectId(), X(spanContext, avatarResourceModel, avatarCharacter));
        } else {
            long createAvatarRenderObject = viewer.createAvatarRenderObject(spanContext);
            oldAvatarAsset = new xk0.a(createAvatarRenderObject, avatarCharacter);
            viewer.updateRenderObjectAvatar(spanContext, createAvatarRenderObject, X(spanContext, avatarResourceModel, avatarCharacter));
        }
        viewer.setRenderObjectHittable(oldAvatarAsset.getRenderObjectId(), true);
        return oldAvatarAsset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void c0(com.tencent.zplan.zplantracing.b bootSpan, BootResourceModel bootResource, String bodyTypeName) {
        boolean z16;
        if (this.booted.get()) {
            return;
        }
        FilamentViewerV2305 viewer = getViewer();
        if (viewer != null) {
            boolean z17 = !Intrinsics.areEqual(bodyTypeName, "BodyType40");
            FilamentFeatureUtil filamentFeatureUtil = FilamentFeatureUtil.f106409g;
            z16 = viewer.boot(bootResource, "", false, false, z17, filamentFeatureUtil.K(), filamentFeatureUtil.j());
        } else {
            z16 = false;
        }
        if (!z16) {
            if (bootSpan != null) {
                bootSpan.a("boot fail");
            }
            o(201024, "boot fail");
        } else {
            if (bootSpan != null) {
                bootSpan.b();
            }
            this.booted.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Deferred<BootResourceModel> e0(com.tencent.zplan.zplantracing.c spanContext, String bodyTypeName) {
        Deferred<BootResourceModel> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(this, null, null, new TofuScene$fetchBootResourceAndBootAsync$1(this, spanContext, bodyTypeName, null), 3, null);
        return async$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Deferred<ReloadAvatarResourceModel> f0(com.tencent.zplan.zplantracing.c spanContext, JSONObject avatarInfo) {
        Deferred<ReloadAvatarResourceModel> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(this, null, null, new TofuScene$fetchReloadAvatarResourceAsync$1(this, spanContext, avatarInfo, null), 3, null);
        return async$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Deferred<AvatarConfig> g0(com.tencent.zplan.zplantracing.c spanContext, String headAnimation, String bodyAnimation) {
        Deferred<AvatarConfig> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(this, null, null, new TofuScene$fetchSingleAnimResourceAsync$1(this, headAnimation, bodyAnimation, spanContext, null), 3, null);
        return async$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(Throwable throwable) {
        String str = "";
        if (throwable instanceof FetchFileException) {
            FetchFileException fetchFileException = (FetchFileException) throwable;
            int errorCode = fetchFileException.getErrorCode();
            String errorMessage = fetchFileException.getErrorMessage();
            if (errorMessage != null) {
                str = errorMessage;
            }
            o(errorCode, str);
            return;
        }
        if (throwable instanceof BlackListResourceException) {
            String message = throwable.getMessage();
            if (message != null) {
                str = message;
            }
            o(201005, str);
            return;
        }
        if (throwable instanceof IllegalViewerException) {
            String message2 = throwable.getMessage();
            if (message2 != null) {
                str = message2;
            }
            o(201025, str);
            return;
        }
        String message3 = throwable.getMessage();
        if (message3 != null) {
            str = message3;
        }
        o(201000, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job i0(com.tencent.zplan.zplantracing.c spanContext, String eventData) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, null, null, new TofuScene$loadScene$1(this, eventData, spanContext, null), 3, null);
        return launch$default;
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2305
    public long B() {
        return FilamentFeatureUtil.f106409g.r().getSurfaceDestroyTimeout();
    }

    @Override // com.tencent.filament.zplan.util.vsync.b
    public void d(long totalTime, long frameTime) {
        FilamentViewerV2305 viewer = getViewer();
        if (viewer != null && getAttached().get() && this.avatarCreated.get()) {
            V(frameTime / 1000000000, null);
            if (this.needRecordFrame.get() && !this.hasRecordFrame.get()) {
                this.hasRecordFrame.set(true);
                viewer.recordFrame(this.recordFrameListener);
                FilamentViewerV2.render$default(viewer, true, null, 2, null);
                return;
            }
            FilamentViewerV2.render$default(viewer, false, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object d0(com.tencent.zplan.zplantracing.c cVar, String str, String str2, Continuation<? super AvatarConfig> continuation) {
        TofuScene$fetchAvatarConfig$1 tofuScene$fetchAvatarConfig$1;
        Object coroutine_suspended;
        int i3;
        com.tencent.zplan.zplantracing.c cVar2;
        String str3;
        TofuScene tofuScene;
        Object h06;
        Resource resource;
        TofuScene tofuScene2;
        if (continuation instanceof TofuScene$fetchAvatarConfig$1) {
            tofuScene$fetchAvatarConfig$1 = (TofuScene$fetchAvatarConfig$1) continuation;
            int i16 = tofuScene$fetchAvatarConfig$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                tofuScene$fetchAvatarConfig$1.label = i16 - Integer.MIN_VALUE;
                Object obj = tofuScene$fetchAvatarConfig$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = tofuScene$fetchAvatarConfig$1.label;
                boolean z16 = true;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            resource = (Resource) tofuScene$fetchAvatarConfig$1.L$1;
                            tofuScene2 = (TofuScene) tofuScene$fetchAvatarConfig$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            Resource resource2 = (Resource) obj;
                            if (!tofuScene2.hasDownloadFromNet && !resource.d() && !resource2.d()) {
                                z16 = false;
                            }
                            tofuScene2.hasDownloadFromNet = z16;
                            FilamentFileUtil filamentFileUtil = FilamentFileUtil.INSTANCE;
                            return new AvatarConfig(FilamentFileUtil.filePathInDir$default(filamentFileUtil, resource.e(), null, "gltf", 2, null), FilamentFileUtil.filePathInDir$default(filamentFileUtil, resource2.e(), null, "gltf", 2, null), null, null, false, false, 60, null);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    String str4 = (String) tofuScene$fetchAvatarConfig$1.L$2;
                    cVar2 = (com.tencent.zplan.zplantracing.c) tofuScene$fetchAvatarConfig$1.L$1;
                    TofuScene tofuScene3 = (TofuScene) tofuScene$fetchAvatarConfig$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    tofuScene = tofuScene3;
                    str3 = str4;
                } else {
                    ResultKt.throwOnFailure(obj);
                    ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                    FilamentUrlTemplate filamentUrlTemplate = this.urlTemplate;
                    tofuScene$fetchAvatarConfig$1.L$0 = this;
                    tofuScene$fetchAvatarConfig$1.L$1 = cVar;
                    tofuScene$fetchAvatarConfig$1.L$2 = str2;
                    tofuScene$fetchAvatarConfig$1.label = 1;
                    Object h07 = ZPlanAvatarResourceHelper.h0(zPlanAvatarResourceHelper, cVar, str, filamentUrlTemplate, false, tofuScene$fetchAvatarConfig$1, 8, null);
                    if (h07 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cVar2 = cVar;
                    obj = h07;
                    str3 = str2;
                    tofuScene = this;
                }
                Resource resource3 = (Resource) obj;
                ZPlanAvatarResourceHelper zPlanAvatarResourceHelper2 = ZPlanAvatarResourceHelper.f105660o;
                FilamentUrlTemplate filamentUrlTemplate2 = tofuScene.urlTemplate;
                tofuScene$fetchAvatarConfig$1.L$0 = tofuScene;
                tofuScene$fetchAvatarConfig$1.L$1 = resource3;
                tofuScene$fetchAvatarConfig$1.L$2 = null;
                tofuScene$fetchAvatarConfig$1.label = 2;
                h06 = ZPlanAvatarResourceHelper.h0(zPlanAvatarResourceHelper2, cVar2, str3, filamentUrlTemplate2, false, tofuScene$fetchAvatarConfig$1, 8, null);
                if (h06 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                resource = resource3;
                obj = h06;
                tofuScene2 = tofuScene;
                Resource resource22 = (Resource) obj;
                if (!tofuScene2.hasDownloadFromNet) {
                    z16 = false;
                }
                tofuScene2.hasDownloadFromNet = z16;
                FilamentFileUtil filamentFileUtil2 = FilamentFileUtil.INSTANCE;
                return new AvatarConfig(FilamentFileUtil.filePathInDir$default(filamentFileUtil2, resource.e(), null, "gltf", 2, null), FilamentFileUtil.filePathInDir$default(filamentFileUtil2, resource22.e(), null, "gltf", 2, null), null, null, false, false, 60, null);
            }
        }
        tofuScene$fetchAvatarConfig$1 = new TofuScene$fetchAvatarConfig$1(this, continuation);
        Object obj2 = tofuScene$fetchAvatarConfig$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = tofuScene$fetchAvatarConfig$1.label;
        boolean z162 = true;
        if (i3 == 0) {
        }
        Resource resource32 = (Resource) obj2;
        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper22 = ZPlanAvatarResourceHelper.f105660o;
        FilamentUrlTemplate filamentUrlTemplate22 = tofuScene.urlTemplate;
        tofuScene$fetchAvatarConfig$1.L$0 = tofuScene;
        tofuScene$fetchAvatarConfig$1.L$1 = resource32;
        tofuScene$fetchAvatarConfig$1.L$2 = null;
        tofuScene$fetchAvatarConfig$1.label = 2;
        h06 = ZPlanAvatarResourceHelper.h0(zPlanAvatarResourceHelper22, cVar2, str3, filamentUrlTemplate22, false, tofuScene$fetchAvatarConfig$1, 8, null);
        if (h06 != coroutine_suspended) {
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2305, com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void n() {
        super.n();
        this.hasDestroyed.set(true);
        this.booted.set(false);
        this.avatarCreated.set(false);
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void o(int errorCode, @Nullable String errorMessage) {
        super.o(errorCode, errorMessage);
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void q() {
        super.q();
        this.hasPaused = true;
    }
}
