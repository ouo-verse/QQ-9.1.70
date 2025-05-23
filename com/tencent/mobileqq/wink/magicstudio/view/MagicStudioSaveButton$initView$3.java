package com.tencent.mobileqq.wink.magicstudio.view;

import com.tencent.mobileqq.wink.magicstudio.MagicStudioMultiViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.view.MagicStudioSaveButton$initView$3", f = "MagicStudioSaveButton.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioSaveButton$initView$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MagicStudioSaveButton this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlowCollector<Pair<? extends Integer, ? extends MagicStudioButtonInfo>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MagicStudioSaveButton f323931d;

        public a(MagicStudioSaveButton magicStudioSaveButton) {
            this.f323931d = magicStudioSaveButton;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(Pair<? extends Integer, ? extends MagicStudioButtonInfo> pair, @NotNull Continuation<? super Unit> continuation) {
            String str;
            String str2;
            Pair<? extends Integer, ? extends MagicStudioButtonInfo> pair2 = pair;
            int intValue = pair2.getFirst().intValue();
            MagicStudioButtonInfo second = pair2.getSecond();
            if (intValue == 3) {
                if (second == null) {
                    str2 = this.f323931d.TAG;
                    w53.b.c(str2, "get save button info is null");
                    MagicStudioSaveButton.B(this.f323931d, false, null, 2, null);
                } else {
                    str = this.f323931d.TAG;
                    w53.b.f(str, "get save button info: " + second.getSubtitleString());
                    this.f323931d.C(second);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioSaveButton$initView$3(MagicStudioSaveButton magicStudioSaveButton, Continuation<? super MagicStudioSaveButton$initView$3> continuation) {
        super(2, continuation);
        this.this$0 = magicStudioSaveButton;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicStudioSaveButton$initView$3(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MagicStudioMultiViewModel magicStudioMultiViewModel;
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
            magicStudioMultiViewModel = this.this$0.vm;
            SharedFlow<Pair<Integer, MagicStudioButtonInfo>> U1 = magicStudioMultiViewModel.U1();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (U1.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioSaveButton$initView$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
