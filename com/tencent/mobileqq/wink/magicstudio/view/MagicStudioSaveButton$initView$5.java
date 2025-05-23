package com.tencent.mobileqq.wink.magicstudio.view;

import com.tencent.mobileqq.wink.magicstudio.MagicStudioMultiViewModel;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.view.MagicStudioSaveButton$initView$5", f = "MagicStudioSaveButton.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioSaveButton$initView$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MagicStudioSaveButton this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlowCollector<MagicStudioViewModel.Companion.C9063a> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MagicStudioSaveButton f323932d;

        public a(MagicStudioSaveButton magicStudioSaveButton) {
            this.f323932d = magicStudioSaveButton;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(MagicStudioViewModel.Companion.C9063a c9063a, @NotNull Continuation<? super Unit> continuation) {
            boolean z16;
            String str;
            MagicStudioMultiViewModel magicStudioMultiViewModel;
            MagicStudioViewModel.Companion.C9063a c9063a2 = c9063a;
            boolean z17 = false;
            if (c9063a2 != null && c9063a2.getState() == 3) {
                z17 = true;
            }
            if (z17) {
                z16 = this.f323932d.initSaveState;
                if (z16) {
                    str = this.f323932d.TAG;
                    w53.b.f(str, "done save button action");
                    magicStudioMultiViewModel = this.f323932d.vm;
                    magicStudioMultiViewModel.n2(3);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioSaveButton$initView$5(MagicStudioSaveButton magicStudioSaveButton, Continuation<? super MagicStudioSaveButton$initView$5> continuation) {
        super(2, continuation);
        this.this$0 = magicStudioSaveButton;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicStudioSaveButton$initView$5(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MagicStudioViewModel magicStudioViewModel;
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
            magicStudioViewModel = this.this$0.magicStudioViewModel;
            StateFlow<MagicStudioViewModel.Companion.C9063a> W1 = magicStudioViewModel.W1();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (W1.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioSaveButton$initView$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
