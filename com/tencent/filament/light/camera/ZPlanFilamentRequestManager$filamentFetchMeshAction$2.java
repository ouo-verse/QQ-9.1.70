package com.tencent.filament.light.camera;

import android.text.TextUtils;
import com.tencent.filament.zplanservice.download.ZPlanAvatarInterfaceResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.light.camera.ZPlanFilamentRequestManager$filamentFetchMeshAction$2", f = "ZPlanFilamentRequestManager.kt", i = {}, l = {269}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class ZPlanFilamentRequestManager$filamentFetchMeshAction$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $animationBpPath;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanFilamentRequestManager$filamentFetchMeshAction$2(String str, Continuation continuation) {
        super(2, continuation);
        this.$animationBpPath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        ZPlanFilamentRequestManager$filamentFetchMeshAction$2 zPlanFilamentRequestManager$filamentFetchMeshAction$2 = new ZPlanFilamentRequestManager$filamentFetchMeshAction$2(this.$animationBpPath, completion);
        zPlanFilamentRequestManager$filamentFetchMeshAction$2.L$0 = obj;
        return zPlanFilamentRequestManager$filamentFetchMeshAction$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((ZPlanFilamentRequestManager$filamentFetchMeshAction$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult;
        String meshAnimPath;
        boolean z16;
        Deferred async$default;
        String result;
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
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            String str = this.$animationBpPath;
            zPlanAvatarInterfaceResult = null;
            if (str != null && !TextUtils.isEmpty(str)) {
                meshAnimPath = ZPlanFilamentRequestManager.INSTANCE.toMeshAnimPath(this.$animationBpPath);
                if (meshAnimPath.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ZPlanFilamentRequestManager$filamentFetchMeshAction$2$actionPathDeferred$1(meshAnimPath, null), 3, null);
                } else {
                    async$default = null;
                }
                if (async$default != null) {
                    this.label = 1;
                    obj = async$default.await(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (zPlanAvatarInterfaceResult != null || (result = zPlanAvatarInterfaceResult.getResult()) == null) {
                    return "";
                }
                return result;
            }
            return null;
        }
        zPlanAvatarInterfaceResult = (ZPlanAvatarInterfaceResult) obj;
        if (zPlanAvatarInterfaceResult != null) {
        }
        return "";
    }
}
