package com.tencent.mobileqq.wink.aiavatar.base;

import com.tencent.mobileqq.wink.aigc.utils.WinkAIGCRequestUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarGenerateBtnViewModel$doGenerateBtnAction$1", f = "WinkAIAvatarGenerateBtnViewModel.kt", i = {}, l = {105, 109, 110}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkAIAvatarGenerateBtnViewModel$doGenerateBtnAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $action;
    int label;
    final /* synthetic */ WinkAIAvatarGenerateBtnViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAIAvatarGenerateBtnViewModel$doGenerateBtnAction$1(int i3, WinkAIAvatarGenerateBtnViewModel winkAIAvatarGenerateBtnViewModel, Continuation<? super WinkAIAvatarGenerateBtnViewModel$doGenerateBtnAction$1> continuation) {
        super(2, continuation);
        this.$action = i3;
        this.this$0 = winkAIAvatarGenerateBtnViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAIAvatarGenerateBtnViewModel$doGenerateBtnAction$1(this.$action, this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object Z1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                WinkAIAvatarGenerateBtnViewModel winkAIAvatarGenerateBtnViewModel = this.this$0;
                this.label = 3;
                Z1 = winkAIAvatarGenerateBtnViewModel.Z1(this);
                if (Z1 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            WinkAIGCRequestUtils winkAIGCRequestUtils = WinkAIGCRequestUtils.f317926a;
            int i16 = this.$action;
            this.label = 1;
            if (winkAIGCRequestUtils.d("qzone_ai_avatar", i16, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.label = 2;
        if (DelayKt.delay(200L, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        WinkAIAvatarGenerateBtnViewModel winkAIAvatarGenerateBtnViewModel2 = this.this$0;
        this.label = 3;
        Z1 = winkAIAvatarGenerateBtnViewModel2.Z1(this);
        if (Z1 == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAIAvatarGenerateBtnViewModel$doGenerateBtnAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
