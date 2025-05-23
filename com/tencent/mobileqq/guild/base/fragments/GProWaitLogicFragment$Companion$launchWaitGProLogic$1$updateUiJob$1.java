package com.tencent.mobileqq.guild.base.fragments;

import android.widget.TextView;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.base.fragments.GProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1", f = "GProWaitLogicFragment.kt", i = {0, 0}, l = {129}, m = "invokeSuspend", n = {"$this$launch", "seconds"}, s = {"L$0", "L$1"})
/* loaded from: classes12.dex */
public final class GProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextView $loadingView;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1(TextView textView, Continuation<? super GProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1> continuation) {
        super(2, continuation);
        this.$loadingView = textView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1 gProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1 = new GProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1(this.$loadingView, continuation);
        gProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1.L$0 = obj;
        return gProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0035  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0041 -> B:5:0x0044). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Ref.IntRef intRef;
        CoroutineScope coroutineScope;
        GProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1 gProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                intRef = (Ref.IntRef) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                gProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1 = this;
                int i16 = intRef.element + 1;
                intRef.element = i16;
                gProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1.$loadingView.setText("\u6b63\u5728\u52a0\u8f7d\u4e2d\uff0c\u5df2\u7b49\u5f85 " + i16 + " \u79d2...");
                Logger.f235387a.d().i("GProWaitLogicFragment", 1, "\u7b49\u5f85.. " + intRef.element + ", " + CoroutineScopeKt.isActive(coroutineScope));
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    gProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1.L$0 = coroutineScope;
                    gProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1.L$1 = intRef;
                    gProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1.label = 1;
                    if (DelayKt.delay(1000L, gProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i162 = intRef.element + 1;
                    intRef.element = i162;
                    gProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1.$loadingView.setText("\u6b63\u5728\u52a0\u8f7d\u4e2d\uff0c\u5df2\u7b49\u5f85 " + i162 + " \u79d2...");
                    Logger.f235387a.d().i("GProWaitLogicFragment", 1, "\u7b49\u5f85.. " + intRef.element + ", " + CoroutineScopeKt.isActive(coroutineScope));
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        return Unit.INSTANCE;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            intRef = new Ref.IntRef();
            coroutineScope = coroutineScope2;
            gProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1 = this;
            if (CoroutineScopeKt.isActive(coroutineScope)) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
