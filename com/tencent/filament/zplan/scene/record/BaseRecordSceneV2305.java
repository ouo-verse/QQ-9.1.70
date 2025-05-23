package com.tencent.filament.zplan.scene.record;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import cl0.FilamentRecordSizeConfig;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.app.scene.BaseSceneV2305;
import com.tencent.filament.zplan.avatar.exception.BlackListResourceException;
import com.tencent.filament.zplan.avatar.exception.FetchFileException;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.record.FilamentRecordHelper;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.zplan.common.utils.h;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001%\b&\u0018\u0000 \u00032\u00020\u0001:\u00012B\u001f\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J%\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0015H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010)\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00063"}, d2 = {"Lcom/tencent/filament/zplan/scene/record/BaseRecordSceneV2305;", "Lcom/tencent/filament/zplan/app/scene/BaseSceneV2305;", "", "L", "Lorg/json/JSONObject;", "recordData", "N", DomainData.DOMAIN_NAME, "", "errorCode", "", "errorMessage", "o", "data", "statistic", "Lcom/tencent/filament/zplan/scene/record/b;", "M", "(Lorg/json/JSONObject;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "frameTime", "J", "", "totalTime", "d", "Lcl0/e;", "G", "Lcl0/e;", "surfaceSizeConfig", "H", "Lorg/json/JSONObject;", "Landroid/graphics/SurfaceTexture;", "I", "Landroid/graphics/SurfaceTexture;", "texture", "Landroid/view/Surface;", "Landroid/view/Surface;", "surface", "com/tencent/filament/zplan/scene/record/BaseRecordSceneV2305$c", "K", "Lcom/tencent/filament/zplan/scene/record/BaseRecordSceneV2305$c;", "filamentCoroutineScope", "()I", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "app", "<init>", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/ref/WeakReference;)V", "b", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public abstract class BaseRecordSceneV2305 extends BaseSceneV2305 {

    /* renamed from: G, reason: from kotlin metadata */
    private final FilamentRecordSizeConfig surfaceSizeConfig;

    /* renamed from: H, reason: from kotlin metadata */
    private JSONObject data;

    /* renamed from: I, reason: from kotlin metadata */
    private SurfaceTexture texture;

    /* renamed from: J, reason: from kotlin metadata */
    private Surface surface;

    /* renamed from: K, reason: from kotlin metadata */
    private c filamentCoroutineScope;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/filament/zplan/scene/record/BaseRecordSceneV2305$a", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a implements sk0.b {
        a() {
        }

        @Override // sk0.b
        public void handleEvent(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull String type, @Nullable String data) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (!Intrinsics.areEqual(type, "BaseRecordSceneV2305.LOAD")) {
                return;
            }
            JSONObject b16 = h.f385294a.b(data);
            if (b16 != null) {
                BaseRecordSceneV2305.this.N(b16);
                return;
            }
            FLog.INSTANCE.e("[zplan][MemePlayer-SDK][BaseRecordSceneV2305]", "handleEvent: data is not a valid json string, data:" + data);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"com/tencent/filament/zplan/scene/record/BaseRecordSceneV2305$c", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "d", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class c implements CoroutineScope {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CoroutineContext coroutineContext;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes6.dex */
        public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ c f105985d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(CoroutineContext.Key key, c cVar) {
                super(key);
                this.f105985d = cVar;
            }

            @Override // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
                FLog.INSTANCE.e("[zplan][MemePlayer-SDK][BaseRecordSceneV2305]", "there is an error in coroutine.", exception);
                String str = "";
                if (exception instanceof FetchFileException) {
                    BaseRecordSceneV2305 baseRecordSceneV2305 = BaseRecordSceneV2305.this;
                    FetchFileException fetchFileException = (FetchFileException) exception;
                    int errorCode = fetchFileException.getErrorCode();
                    String errorMessage = fetchFileException.getErrorMessage();
                    if (errorMessage != null) {
                        str = errorMessage;
                    }
                    baseRecordSceneV2305.o(errorCode, str);
                    return;
                }
                if (exception instanceof BlackListResourceException) {
                    BaseRecordSceneV2305 baseRecordSceneV23052 = BaseRecordSceneV2305.this;
                    String message = exception.getMessage();
                    if (message != null) {
                        str = message;
                    }
                    baseRecordSceneV23052.o(201005, str);
                    return;
                }
                BaseRecordSceneV2305 baseRecordSceneV23053 = BaseRecordSceneV2305.this;
                String message2 = exception.getMessage();
                if (message2 != null) {
                    str = message2;
                }
                baseRecordSceneV23053.o(201000, str);
            }
        }

        c() {
            this.coroutineContext = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(BaseRecordSceneV2305.this.k().c()).plus(new a(CoroutineExceptionHandler.INSTANCE, this));
        }

        @Override // kotlinx.coroutines.CoroutineScope
        @NotNull
        public CoroutineContext getCoroutineContext() {
            return this.coroutineContext;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseRecordSceneV2305(@Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull WeakReference<FilamentNativeAppV2305> app) {
        super(cVar, app);
        Context context;
        FilamentRecordSizeConfig filamentRecordSizeConfig;
        sk0.a configuration;
        Intrinsics.checkNotNullParameter(app, "app");
        this.filamentCoroutineScope = new c();
        FilamentNativeAppV2305 filamentNativeAppV2305 = app.get();
        if (filamentNativeAppV2305 != null && (configuration = filamentNativeAppV2305.getConfiguration()) != null) {
            context = configuration.getViewContext();
        } else {
            context = null;
        }
        if (context != null) {
            filamentRecordSizeConfig = FilamentRecordHelper.f105779a.d(context);
        } else {
            FLog.INSTANCE.e("[zplan][MemePlayer-SDK][BaseRecordSceneV2305]", "init: viewContext is null");
            filamentRecordSizeConfig = new FilamentRecordSizeConfig(0, 0);
        }
        this.surfaceSizeConfig = filamentRecordSizeConfig;
        FilamentNativeAppV2305 filamentNativeAppV23052 = app.get();
        if (filamentNativeAppV23052 != null) {
            filamentNativeAppV23052.addEventListener("BaseRecordSceneV2305.LOAD", new a());
        }
        k().d("initEngineSurface", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.record.BaseRecordSceneV2305.2
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
                BaseRecordSceneV2305.this.L();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int K() {
        JSONObject jSONObject = this.data;
        if (jSONObject != null) {
            return jSONObject.optInt(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        int width = this.surfaceSizeConfig.getWidth();
        int height = this.surfaceSizeConfig.getHeight();
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(width, height);
        Surface surface = new Surface(surfaceTexture);
        FilamentViewerV2305 viewer = getViewer();
        if (viewer != null) {
            viewer.attach(surface, surfaceTexture, width, height);
        }
        this.texture = surfaceTexture;
        this.surface = surface;
        FLog.INSTANCE.i("[zplan][MemePlayer-SDK][BaseRecordSceneV2305]", "initEngineSurface, size:" + this.surfaceSizeConfig + ", texture:" + this.texture + ", surface:" + this.surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(JSONObject recordData) {
        this.data = recordData;
        BuildersKt__Builders_commonKt.launch$default(this.filamentCoroutineScope, null, null, new BaseRecordSceneV2305$startRecord$1(this, recordData, null), 3, null);
    }

    public abstract void J(double frameTime);

    @Nullable
    public abstract Object M(@NotNull JSONObject jSONObject, @NotNull JSONObject jSONObject2, @NotNull Continuation<? super RecordInfo> continuation);

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2305, com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void n() {
        super.n();
        SurfaceTexture surfaceTexture = this.texture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
        }
        this.texture = null;
        this.surface = null;
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void o(int errorCode, @Nullable String errorMessage) {
        super.o(errorCode, errorMessage);
        FilamentNativeAppV2305 filamentNativeAppV2305 = j().get();
        if (filamentNativeAppV2305 != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, K());
            jSONObject.put("errorCode", errorCode);
            jSONObject.put("errorMessage", errorMessage);
            Unit unit = Unit.INSTANCE;
            filamentNativeAppV2305.dispatchEvent(null, "BaseRecordSceneV2305.END", jSONObject.toString());
        }
    }

    @Override // com.tencent.filament.zplan.util.vsync.b
    public void d(long totalTime, long frameTime) {
    }
}
