package com.tencent.robot.adelie.homepage.ugc.viewmodel;

import com.tencent.robot.adelie.homepage.AdelieUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/robot/adelie/homepage/AdelieUtils$a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.adelie.homepage.ugc.viewmodel.AdelieUgcImageViewModel$uploadAvatarAndGetUrl$1$originUrlJob$1", f = "AdelieUgcImageViewModel.kt", i = {}, l = {394}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
final class AdelieUgcImageViewModel$uploadAvatarAndGetUrl$1$originUrlJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AdelieUtils.UploadResult>, Object> {
    final /* synthetic */ String $localPath;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieUgcImageViewModel$uploadAvatarAndGetUrl$1$originUrlJob$1(String str, Continuation<? super AdelieUgcImageViewModel$uploadAvatarAndGetUrl$1$originUrlJob$1> continuation) {
        super(2, continuation);
        this.$localPath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AdelieUgcImageViewModel$uploadAvatarAndGetUrl$1$originUrlJob$1(this.$localPath, continuation);
    }

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
            AdelieUtils adelieUtils = AdelieUtils.f365929a;
            String str = this.$localPath;
            this.label = 1;
            obj = adelieUtils.i0(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super AdelieUtils.UploadResult> continuation) {
        return ((AdelieUgcImageViewModel$uploadAvatarAndGetUrl$1$originUrlJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
