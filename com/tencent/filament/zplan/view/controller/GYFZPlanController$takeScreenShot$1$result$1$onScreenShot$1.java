package com.tencent.filament.zplan.view.controller;

import android.graphics.Bitmap;
import com.tencent.filament.zplan.listener.GYScreenShotCallback;
import com.tencent.filament.zplanservice.util.log.FLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.view.controller.GYFZPlanController$takeScreenShot$1$result$1$onScreenShot$1", f = "GYFZPlanController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class GYFZPlanController$takeScreenShot$1$result$1$onScreenShot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ int $height;
    final /* synthetic */ byte[] $pixels;
    final /* synthetic */ int $width;
    int label;
    final /* synthetic */ GYFZPlanController$takeScreenShot$1$result$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GYFZPlanController$takeScreenShot$1$result$1$onScreenShot$1(GYFZPlanController$takeScreenShot$1$result$1 gYFZPlanController$takeScreenShot$1$result$1, byte[] bArr, int i3, int i16, Bitmap bitmap, Continuation continuation) {
        super(2, continuation);
        this.this$0 = gYFZPlanController$takeScreenShot$1$result$1;
        this.$pixels = bArr;
        this.$width = i3;
        this.$height = i16;
        this.$bitmap = bitmap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new GYFZPlanController$takeScreenShot$1$result$1$onScreenShot$1(this.this$0, this.$pixels, this.$width, this.$height, this.$bitmap, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GYFZPlanController$takeScreenShot$1$result$1$onScreenShot$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Integer num;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FLog fLog = FLog.INSTANCE;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onRecordFrame. pixels size: ");
            byte[] bArr = this.$pixels;
            if (bArr != null) {
                num = Boxing.boxInt(bArr.length);
            } else {
                num = null;
            }
            sb5.append(num);
            sb5.append(" width: ");
            sb5.append(this.$width);
            sb5.append(", height: ");
            sb5.append(this.$height);
            fLog.i("GYFZPlanController", sb5.toString());
            if (this.$bitmap != null) {
                this.this$0.f106341a.this$0.L().post(new Runnable() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$takeScreenShot$1$result$1$onScreenShot$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Bitmap bitmap;
                        GYFZPlanController$takeScreenShot$1$result$1$onScreenShot$1 gYFZPlanController$takeScreenShot$1$result$1$onScreenShot$1 = GYFZPlanController$takeScreenShot$1$result$1$onScreenShot$1.this;
                        GYScreenShotCallback gYScreenShotCallback = gYFZPlanController$takeScreenShot$1$result$1$onScreenShot$1.this$0.f106341a.$callback;
                        if (gYScreenShotCallback != null && (bitmap = gYFZPlanController$takeScreenShot$1$result$1$onScreenShot$1.$bitmap) != null) {
                            gYScreenShotCallback.onScreenShot(bitmap);
                        }
                    }
                });
            } else {
                this.this$0.f106341a.this$0.L().post(new Runnable() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$takeScreenShot$1$result$1$onScreenShot$1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        GYScreenShotCallback gYScreenShotCallback = GYFZPlanController$takeScreenShot$1$result$1$onScreenShot$1.this.this$0.f106341a.$callback;
                        if (gYScreenShotCallback != null) {
                            gYScreenShotCallback.onScreenShot(null);
                        }
                    }
                });
                fLog.i("GYFZPlanController", "recordFrame: bitmap is null?");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
