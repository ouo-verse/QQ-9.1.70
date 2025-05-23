package com.tencent.mobileqq.wink.magicstudio.qzone;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.qzone.WinkQZoneMagicStudioViewModel$doAction$1", f = "WinkQZoneMagicStudioViewModel.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkQZoneMagicStudioViewModel$doAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $actionType;
    int label;
    final /* synthetic */ WinkQZoneMagicStudioViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkQZoneMagicStudioViewModel$doAction$1(int i3, WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel, Continuation<? super WinkQZoneMagicStudioViewModel$doAction$1> continuation) {
        super(2, continuation);
        this.$actionType = i3;
        this.this$0 = winkQZoneMagicStudioViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel) {
        winkQZoneMagicStudioViewModel.S1(1);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkQZoneMagicStudioViewModel$doAction$1(this.$actionType, this.this$0, continuation);
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
                int i16 = this.$actionType;
                this.label = 1;
                if (magicStudioDataSource.w(i16, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } catch (Exception e16) {
            w53.b.d("WinkQZoneMagicStudioViewModel", "doAction error", e16);
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel = this.this$0;
        uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.d
            @Override // java.lang.Runnable
            public final void run() {
                WinkQZoneMagicStudioViewModel$doAction$1.b(WinkQZoneMagicStudioViewModel.this);
            }
        }, 200L);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkQZoneMagicStudioViewModel$doAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
