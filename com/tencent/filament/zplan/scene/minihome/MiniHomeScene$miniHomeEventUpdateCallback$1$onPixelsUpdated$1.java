package com.tencent.filament.zplan.scene.minihome;

import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.filament.zplanservice.util.log.FLog;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.minihome.MiniHomeScene$miniHomeEventUpdateCallback$1$onPixelsUpdated$1", f = "MiniHomeScene.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class MiniHomeScene$miniHomeEventUpdateCallback$1$onPixelsUpdated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $height;
    final /* synthetic */ String $imagePath;
    final /* synthetic */ byte[] $pixels;
    final /* synthetic */ int $width;
    int label;
    final /* synthetic */ MiniHomeScene$miniHomeEventUpdateCallback$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeScene$miniHomeEventUpdateCallback$1$onPixelsUpdated$1(MiniHomeScene$miniHomeEventUpdateCallback$1 miniHomeScene$miniHomeEventUpdateCallback$1, byte[] bArr, int i3, int i16, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = miniHomeScene$miniHomeEventUpdateCallback$1;
        this.$pixels = bArr;
        this.$width = i3;
        this.$height = i16;
        this.$imagePath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new MiniHomeScene$miniHomeEventUpdateCallback$1$onPixelsUpdated$1(this.this$0, this.$pixels, this.$width, this.$height, this.$imagePath, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniHomeScene$miniHomeEventUpdateCallback$1$onPixelsUpdated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            boolean writePixelsToPNG = FilamentFileUtil.writePixelsToPNG(this.$pixels, this.$width, this.$height, this.$imagePath);
            FLog.INSTANCE.i("MiniHomeScene", "writePixelsToPNG isSuccess: " + writePixelsToPNG + '.');
            FilamentNativeAppV2305 filamentNativeAppV2305 = (FilamentNativeAppV2305) this.this$0.f105968b.get();
            if (filamentNativeAppV2305 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imagePath", this.$imagePath);
                Unit unit = Unit.INSTANCE;
                filamentNativeAppV2305.dispatchEvent(null, "onFirstFrameImageReady", jSONObject.toString());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
