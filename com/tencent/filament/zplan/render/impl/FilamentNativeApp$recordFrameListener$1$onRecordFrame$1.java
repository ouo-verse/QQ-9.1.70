package com.tencent.filament.zplan.render.impl;

import com.tencent.filament.zplan.engine.js.FilamentEventDispatcher;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
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
@DebugMetadata(c = "com.tencent.filament.zplan.render.impl.FilamentNativeApp$recordFrameListener$1$onRecordFrame$1", f = "FilamentNativeApp.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FilamentNativeApp$recordFrameListener$1$onRecordFrame$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $height;
    final /* synthetic */ String $imagePath;
    final /* synthetic */ byte[] $pixels;
    final /* synthetic */ int $width;
    int label;
    final /* synthetic */ FilamentNativeApp$recordFrameListener$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentNativeApp$recordFrameListener$1$onRecordFrame$1(FilamentNativeApp$recordFrameListener$1 filamentNativeApp$recordFrameListener$1, byte[] bArr, int i3, int i16, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filamentNativeApp$recordFrameListener$1;
        this.$pixels = bArr;
        this.$width = i3;
        this.$height = i16;
        this.$imagePath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new FilamentNativeApp$recordFrameListener$1$onRecordFrame$1(this.this$0, this.$pixels, this.$width, this.$height, this.$imagePath, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilamentNativeApp$recordFrameListener$1$onRecordFrame$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FilamentEventDispatcher t06;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("writePixelsToPNG", this.this$0.f105867a.getZplanSpanContext());
            boolean writePixelsToPNG = FilamentFileUtil.writePixelsToPNG(this.$pixels, this.$width, this.$height, this.$imagePath);
            FLog.INSTANCE.i("FilamentNativeApp", "writePixelsToPNG isSuccess: " + writePixelsToPNG + '.');
            if (!writePixelsToPNG) {
                if (startSpan != null) {
                    startSpan.a("write failed");
                }
                return Unit.INSTANCE;
            }
            if (startSpan != null) {
                startSpan.b();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("imagePath", this.$imagePath);
            t06 = this.this$0.f105867a.t0();
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "data.toString()");
            t06.onEvent("onFirstFrameImageReady", jSONObject2);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
