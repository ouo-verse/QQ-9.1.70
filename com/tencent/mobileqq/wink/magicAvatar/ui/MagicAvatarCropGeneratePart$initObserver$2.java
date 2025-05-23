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
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarCropGeneratePart$initObserver$2", f = "MagicAvatarCropGeneratePart.kt", i = {}, l = {com.tencent.luggage.wxa.yd.a.CTRL_INDEX}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicAvatarCropGeneratePart$initObserver$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MagicAvatarCropGeneratePart this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlowCollector<com.tencent.mobileqq.wink.magicAvatar.model.f> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MagicAvatarCropGeneratePart f323543d;

        public a(MagicAvatarCropGeneratePart magicAvatarCropGeneratePart) {
            this.f323543d = magicAvatarCropGeneratePart;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v11, types: [android.widget.TextView] */
        /* JADX WARN: Type inference failed for: r5v17, types: [android.widget.TextView] */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(com.tencent.mobileqq.wink.magicAvatar.model.f fVar, @NotNull Continuation<? super Unit> continuation) {
            boolean z16;
            MagicAvatarNextButton magicAvatarNextButton;
            MagicAvatarNextButton magicAvatarNextButton2;
            ?? r56;
            MagicAvatarNextButton magicAvatarNextButton3;
            ?? r57;
            MagicAvatarNextButton magicAvatarNextButton4;
            com.tencent.mobileqq.wink.magicAvatar.model.f fVar2 = fVar;
            MagicAvatarNextButton magicAvatarNextButton5 = null;
            if (Intrinsics.areEqual(fVar2, f.e.f323524a)) {
                magicAvatarNextButton4 = this.f323543d.setHeadBtn;
                if (magicAvatarNextButton4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("setHeadBtn");
                } else {
                    magicAvatarNextButton5 = magicAvatarNextButton4;
                }
                magicAvatarNextButton5.setStates(MagicAvatarNextButton.a.b.f323604a);
            } else if (Intrinsics.areEqual(fVar2, f.a.f323518a)) {
                magicAvatarNextButton3 = this.f323543d.setHeadBtn;
                if (magicAvatarNextButton3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("setHeadBtn");
                    magicAvatarNextButton3 = null;
                }
                magicAvatarNextButton3.setStates(new MagicAvatarNextButton.a.C9059a("\u8bbe\u4e3a\u5934\u50cf"));
                r57 = this.f323543d.countTv;
                if (r57 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("countTv");
                } else {
                    magicAvatarNextButton5 = r57;
                }
                magicAvatarNextButton5.setVisibility(0);
            } else if (fVar2 instanceof f.b) {
                this.f323543d.ea();
                magicAvatarNextButton2 = this.f323543d.setHeadBtn;
                if (magicAvatarNextButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("setHeadBtn");
                    magicAvatarNextButton2 = null;
                }
                magicAvatarNextButton2.setStates(new MagicAvatarNextButton.a.c(((f.b) fVar2).getVipTotalCount()));
                r56 = this.f323543d.countTv;
                if (r56 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("countTv");
                } else {
                    magicAvatarNextButton5 = r56;
                }
                magicAvatarNextButton5.setVisibility(8);
            } else {
                if (fVar2 instanceof f.C9055f) {
                    z16 = true;
                } else {
                    z16 = fVar2 instanceof f.c;
                }
                if (z16) {
                    magicAvatarNextButton = this.f323543d.setHeadBtn;
                    if (magicAvatarNextButton == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("setHeadBtn");
                    } else {
                        magicAvatarNextButton5 = magicAvatarNextButton;
                    }
                    magicAvatarNextButton5.setStates(new MagicAvatarNextButton.a.C9059a("\u8bbe\u4e3a\u5934\u50cf"));
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarCropGeneratePart$initObserver$2(MagicAvatarCropGeneratePart magicAvatarCropGeneratePart, Continuation<? super MagicAvatarCropGeneratePart$initObserver$2> continuation) {
        super(2, continuation);
        this.this$0 = magicAvatarCropGeneratePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicAvatarCropGeneratePart$initObserver$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MagicAvatarCropViewModel magicAvatarCropViewModel;
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
            magicAvatarCropViewModel = this.this$0.magicCropVm;
            SharedFlow<com.tencent.mobileqq.wink.magicAvatar.model.f> y26 = magicAvatarCropViewModel.y2();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (y26.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicAvatarCropGeneratePart$initObserver$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
