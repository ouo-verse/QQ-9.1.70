package com.tencent.mobileqq.wink.magicstudio;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioViewModel$doAction$1", f = "MagicStudioViewModel.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioViewModel$doAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $action;
    int label;
    final /* synthetic */ MagicStudioViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioViewModel$doAction$1(int i3, MagicStudioViewModel magicStudioViewModel, Continuation<? super MagicStudioViewModel$doAction$1> continuation) {
        super(2, continuation);
        this.$action = i3;
        this.this$0 = magicStudioViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MagicStudioViewModel magicStudioViewModel, int i3) {
        BuildersKt__Builders_commonKt.launch$default(magicStudioViewModel.viewModelScope, null, null, new MagicStudioViewModel$doAction$1$1$1(magicStudioViewModel, i3, null), 3, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicStudioViewModel$doAction$1(this.$action, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
                MagicStudioDataSource magicStudioDataSource = MagicStudioDataSource.f323652a;
                int i16 = this.$action;
                this.label = 1;
                if (magicStudioDataSource.w(i16, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } catch (Exception unused) {
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final MagicStudioViewModel magicStudioViewModel = this.this$0;
        final int i17 = this.$action;
        uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.s
            @Override // java.lang.Runnable
            public final void run() {
                MagicStudioViewModel$doAction$1.b(MagicStudioViewModel.this, i17);
            }
        }, 200L);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioViewModel$doAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
