package com.tencent.filament.light.camera;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.light.camera.ZPlanFilamentRequestManager$FilamentRequestResourceAsset$3$particleResourceDeferred$1", f = "ZPlanFilamentRequestManager.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class ZPlanFilamentRequestManager$FilamentRequestResourceAsset$3$particleResourceDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;
    final /* synthetic */ ZPlanFilamentRequestManager$FilamentRequestResourceAsset$3 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanFilamentRequestManager$FilamentRequestResourceAsset$3$particleResourceDeferred$1(ZPlanFilamentRequestManager$FilamentRequestResourceAsset$3 zPlanFilamentRequestManager$FilamentRequestResourceAsset$3, Continuation continuation) {
        super(2, continuation);
        this.this$0 = zPlanFilamentRequestManager$FilamentRequestResourceAsset$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new ZPlanFilamentRequestManager$FilamentRequestResourceAsset$3$particleResourceDeferred$1(this.this$0, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((ZPlanFilamentRequestManager$FilamentRequestResourceAsset$3$particleResourceDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ZPlanFilamentRequestManager zPlanFilamentRequestManager = ZPlanFilamentRequestManager.INSTANCE;
            JSONObject jSONObject = (JSONObject) this.this$0.$avatarJson.element;
            this.label = 1;
            obj = zPlanFilamentRequestManager.fetchParticle(jSONObject, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
