package com.tencent.filament.zplan.scene.record;

import cl0.FilamentRecordSizeConfig;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.record.BaseRecordSceneV2305$startRecord$1", f = "BaseRecordSceneV2305.kt", i = {0}, l = {114}, m = "invokeSuspend", n = {"statistics"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class BaseRecordSceneV2305$startRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $recordData;
    Object L$0;
    int label;
    final /* synthetic */ BaseRecordSceneV2305 this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J0\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/filament/zplan/scene/record/BaseRecordSceneV2305$startRecord$1$a", "Lcom/tencent/filament/zplan/scene/record/a;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "frameTime", "", "a", "", "pixelsAddress", "pixelsSize", "width", "height", "b", "c", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a implements com.tencent.filament.zplan.scene.record.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f105987b;

        a(JSONObject jSONObject) {
            this.f105987b = jSONObject;
        }

        @Override // com.tencent.filament.zplan.scene.record.a
        public void a(int taskId, double frameTime) {
            int K;
            K = BaseRecordSceneV2305$startRecord$1.this.this$0.K();
            if (taskId != K) {
                return;
            }
            BaseRecordSceneV2305$startRecord$1.this.this$0.J(frameTime);
        }

        @Override // com.tencent.filament.zplan.scene.record.a
        public void b(int taskId, long pixelsAddress, long pixelsSize, int width, int height) {
            int K;
            K = BaseRecordSceneV2305$startRecord$1.this.this$0.K();
            if (taskId != K) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, taskId);
            jSONObject.put("width", width);
            jSONObject.put("height", height);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", String.valueOf(pixelsAddress));
            jSONObject2.put("size", pixelsSize);
            jSONObject2.put("__ArrayBuffer__", true);
            Unit unit = Unit.INSTANCE;
            jSONObject.put("buffer", jSONObject2);
            FilamentNativeAppV2305 filamentNativeAppV2305 = BaseRecordSceneV2305$startRecord$1.this.this$0.j().get();
            if (filamentNativeAppV2305 != null) {
                filamentNativeAppV2305.dispatchEvent(null, "BaseRecordSceneV2305.FRAME", jSONObject.toString());
            }
        }

        @Override // com.tencent.filament.zplan.scene.record.a
        public void c(int taskId) {
            int K;
            FilamentNativeAppV2305 filamentNativeAppV2305;
            K = BaseRecordSceneV2305$startRecord$1.this.this$0.K();
            if (taskId == K && (filamentNativeAppV2305 = BaseRecordSceneV2305$startRecord$1.this.this$0.j().get()) != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, taskId);
                jSONObject.put("errorCode", 0);
                jSONObject.put("statistics", this.f105987b);
                Unit unit = Unit.INSTANCE;
                filamentNativeAppV2305.dispatchEvent(null, "BaseRecordSceneV2305.END", jSONObject.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseRecordSceneV2305$startRecord$1(BaseRecordSceneV2305 baseRecordSceneV2305, JSONObject jSONObject, Continuation continuation) {
        super(2, continuation);
        this.this$0 = baseRecordSceneV2305;
        this.$recordData = jSONObject;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new BaseRecordSceneV2305$startRecord$1(this.this$0, this.$recordData, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseRecordSceneV2305$startRecord$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        JSONObject jSONObject;
        FilamentRecordSizeConfig filamentRecordSizeConfig;
        FilamentRecordSizeConfig filamentRecordSizeConfig2;
        FilamentRecordSizeConfig filamentRecordSizeConfig3;
        FilamentViewerV2305 viewer;
        int K;
        FilamentViewerV2305 viewer2;
        int K2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                jSONObject = (JSONObject) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            JSONObject jSONObject2 = new JSONObject();
            BaseRecordSceneV2305 baseRecordSceneV2305 = this.this$0;
            JSONObject jSONObject3 = this.$recordData;
            this.L$0 = jSONObject2;
            this.label = 1;
            Object M = baseRecordSceneV2305.M(jSONObject3, jSONObject2, this);
            if (M == coroutine_suspended) {
                return coroutine_suspended;
            }
            jSONObject = jSONObject2;
            obj = M;
        }
        RecordInfo recordInfo = (RecordInfo) obj;
        if (recordInfo != null) {
            int width = recordInfo.getWidth();
            filamentRecordSizeConfig = this.this$0.surfaceSizeConfig;
            if (width <= filamentRecordSizeConfig.getWidth()) {
                int height = recordInfo.getHeight();
                filamentRecordSizeConfig3 = this.this$0.surfaceSizeConfig;
                if (height <= filamentRecordSizeConfig3.getHeight()) {
                    viewer = this.this$0.getViewer();
                    if (viewer != null) {
                        viewer.setViewPort(recordInfo.getWidth(), recordInfo.getHeight());
                    }
                    FLog.INSTANCE.d("[zplan][MemePlayer-SDK][BaseRecordSceneV2305]", "startRecord: " + recordInfo);
                    FilamentNativeAppV2305 filamentNativeAppV2305 = this.this$0.j().get();
                    if (filamentNativeAppV2305 != null) {
                        JSONObject jSONObject4 = new JSONObject();
                        K2 = this.this$0.K();
                        jSONObject4.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, K2);
                        jSONObject4.put("fps", recordInfo.getFps());
                        jSONObject4.put("totalFrameCount", recordInfo.getTotalFrameCount());
                        jSONObject4.put("errorCode", 0);
                        Unit unit = Unit.INSTANCE;
                        filamentNativeAppV2305.dispatchEvent(null, "BaseRecordSceneV2305.START", jSONObject4.toString());
                    }
                    a aVar = new a(jSONObject);
                    K = this.this$0.K();
                    viewer2 = this.this$0.getViewer();
                    new FrameRecorder(K, viewer2, this.this$0.k(), recordInfo.getTotalFrameCount(), recordInfo.getFrameDuration(), aVar).k();
                    return Unit.INSTANCE;
                }
            }
            FLog fLog = FLog.INSTANCE;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("startRecord: record size exceed, recordInfo.width}x");
            sb5.append(recordInfo.getHeight());
            sb5.append(" > ");
            filamentRecordSizeConfig2 = this.this$0.surfaceSizeConfig;
            sb5.append(filamentRecordSizeConfig2);
            fLog.e("[zplan][MemePlayer-SDK][BaseRecordSceneV2305]", sb5.toString());
            this.this$0.o(201020, "record size exceed");
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
