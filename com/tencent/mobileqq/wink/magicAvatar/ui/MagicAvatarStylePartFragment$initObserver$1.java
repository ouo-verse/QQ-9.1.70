package com.tencent.mobileqq.wink.magicAvatar.ui;

import com.tencent.mobileqq.wink.magicAvatar.model.f;
import com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel;
import com.tencent.mobileqq.wink.magicAvatar.widget.MagicAvatarNextButton;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarStylePartFragment$initObserver$1", f = "MagicAvatarStylePartFragment.kt", i = {}, l = {425}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicAvatarStylePartFragment$initObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MagicAvatarStylePartFragment this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlowCollector<com.tencent.mobileqq.wink.magicAvatar.model.f> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MagicAvatarStylePartFragment f323566d;

        public a(MagicAvatarStylePartFragment magicAvatarStylePartFragment) {
            this.f323566d = magicAvatarStylePartFragment;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
        
            r2 = r1.f323566d.button;
         */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object emit(com.tencent.mobileqq.wink.magicAvatar.model.f fVar, @NotNull Continuation<? super Unit> continuation) {
            boolean z16;
            MagicAvatarNextButton magicAvatarNextButton;
            MagicAvatarNextButton magicAvatarNextButton2;
            MagicAvatarNextButton magicAvatarNextButton3;
            com.tencent.mobileqq.wink.magicAvatar.model.f fVar2 = fVar;
            if (Intrinsics.areEqual(fVar2, f.e.f323524a)) {
                magicAvatarNextButton3 = this.f323566d.button;
                if (magicAvatarNextButton3 != null) {
                    magicAvatarNextButton3.setStates(MagicAvatarNextButton.a.b.f323604a);
                }
            } else if (fVar2 instanceof f.b) {
                magicAvatarNextButton2 = this.f323566d.button;
                if (magicAvatarNextButton2 != null) {
                    magicAvatarNextButton2.setStates(new MagicAvatarNextButton.a.c(((f.b) fVar2).getVipTotalCount()));
                }
            } else {
                if (fVar2 instanceof f.c) {
                    z16 = true;
                } else {
                    z16 = fVar2 instanceof f.C9055f;
                }
                if (z16 && magicAvatarNextButton != null) {
                    magicAvatarNextButton.setStates(new MagicAvatarNextButton.a.C9059a("\u4f20\u56fe\u7acb\u5373\u751f\u6210"));
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarStylePartFragment$initObserver$1(MagicAvatarStylePartFragment magicAvatarStylePartFragment, Continuation<? super MagicAvatarStylePartFragment$initObserver$1> continuation) {
        super(2, continuation);
        this.this$0 = magicAvatarStylePartFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicAvatarStylePartFragment$initObserver$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MagicAvatarCropViewModel Gh;
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
            Gh = this.this$0.Gh();
            SharedFlow<com.tencent.mobileqq.wink.magicAvatar.model.f> G2 = Gh.G2();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (G2.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicAvatarStylePartFragment$initObserver$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
