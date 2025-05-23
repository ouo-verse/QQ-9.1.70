package com.tencent.filament.light.camera;

import com.tencent.filament.zplanservice.download.ZPlanAvatarInterfaceResult;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.light.camera.ZPlanFilamentRequestManager$filamentFetchMeshAction$2$actionPathDeferred$1", f = "ZPlanFilamentRequestManager.kt", i = {}, l = {262}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class ZPlanFilamentRequestManager$filamentFetchMeshAction$2$actionPathDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAvatarInterfaceResult>, Object> {
    final /* synthetic */ String $actionPath;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanFilamentRequestManager$filamentFetchMeshAction$2$actionPathDeferred$1(String str, Continuation continuation) {
        super(2, continuation);
        this.$actionPath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new ZPlanFilamentRequestManager$filamentFetchMeshAction$2$actionPathDeferred$1(this.$actionPath, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanAvatarInterfaceResult> continuation) {
        return ((ZPlanFilamentRequestManager$filamentFetchMeshAction$2$actionPathDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String str;
        ZPlanAvatarService zPlanAvatarService;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                ZPlanFilamentRequestManager zPlanFilamentRequestManager = ZPlanFilamentRequestManager.INSTANCE;
                zPlanAvatarService = ZPlanFilamentRequestManager.avatarService;
                if (zPlanAvatarService == null) {
                    return null;
                }
                String str2 = this.$actionPath;
                this.label = 1;
                obj = zPlanAvatarService.x(str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return (ZPlanAvatarInterfaceResult) obj;
        } catch (Throwable th5) {
            FLog fLog = FLog.INSTANCE;
            ZPlanFilamentRequestManager zPlanFilamentRequestManager2 = ZPlanFilamentRequestManager.INSTANCE;
            str = ZPlanFilamentRequestManager.TAG;
            fLog.e(str, th5.toString());
            return null;
        }
    }
}
