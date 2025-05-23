package com.tencent.mobileqq.wink.magicAvatar.ui;

import android.widget.TextView;
import com.tencent.mobileqq.wink.magicAvatar.model.f;
import com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel;
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
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarCropGeneratePart$initObserver$3", f = "MagicAvatarCropGeneratePart.kt", i = {}, l = {com.tencent.luggage.wxa.yd.a.CTRL_INDEX}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicAvatarCropGeneratePart$initObserver$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MagicAvatarCropGeneratePart this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlowCollector<com.tencent.mobileqq.wink.magicAvatar.model.f> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MagicAvatarCropGeneratePart f323544d;

        public a(MagicAvatarCropGeneratePart magicAvatarCropGeneratePart) {
            this.f323544d = magicAvatarCropGeneratePart;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(com.tencent.mobileqq.wink.magicAvatar.model.f fVar, @NotNull Continuation<? super Unit> continuation) {
            boolean z16;
            TextView textView;
            TextView textView2;
            TextView textView3;
            TextView textView4;
            TextView textView5;
            TextView textView6;
            TextView textView7;
            TextView textView8;
            com.tencent.mobileqq.wink.magicAvatar.model.f fVar2 = fVar;
            if (Intrinsics.areEqual(fVar2, f.e.f323524a)) {
                z16 = true;
            } else {
                z16 = fVar2 instanceof f.b;
            }
            TextView textView9 = null;
            if (z16) {
                textView7 = this.f323544d.countTv;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("countTv");
                    textView7 = null;
                }
                textView7.setText("\u4eca\u65e5\u6b21\u6570\u5df2\u7528\u5b8c");
                textView8 = this.f323544d.countTv;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("countTv");
                } else {
                    textView9 = textView8;
                }
                textView9.setVisibility(0);
            } else if (Intrinsics.areEqual(fVar2, f.a.f323518a)) {
                textView6 = this.f323544d.countTv;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("countTv");
                } else {
                    textView9 = textView6;
                }
                textView9.setVisibility(0);
            } else if (fVar2 instanceof f.c) {
                textView4 = this.f323544d.countTv;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("countTv");
                    textView4 = null;
                }
                textView4.setText("\u4eca\u65e5\u514d\u8d39\u4f53\u9a8c\u6b21\u6570" + ((f.c) fVar2).getFree() + "\u6b21");
                textView5 = this.f323544d.countTv;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("countTv");
                } else {
                    textView9 = textView5;
                }
                textView9.setVisibility(0);
            } else if (fVar2 instanceof f.C9055f) {
                f.C9055f c9055f = (f.C9055f) fVar2;
                if (c9055f.getFree() == 0) {
                    textView3 = this.f323544d.countTv;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("countTv");
                        textView3 = null;
                    }
                    textView3.setText("\u4eca\u65e5SVIP\u4e13\u4eab\u6b21\u6570" + c9055f.getVip() + "\u6b21");
                } else {
                    textView = this.f323544d.countTv;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("countTv");
                        textView = null;
                    }
                    textView.setText("\u4eca\u65e5\u603b\u6b21\u6570" + (c9055f.getVip() + c9055f.getFree()) + "\u6b21\uff08\u514d\u8d39" + c9055f.getFree() + "\u6b21+SVIP\u4e13\u4eab" + c9055f.getVip() + "\u6b21\uff09");
                }
                textView2 = this.f323544d.countTv;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("countTv");
                } else {
                    textView9 = textView2;
                }
                textView9.setVisibility(0);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarCropGeneratePart$initObserver$3(MagicAvatarCropGeneratePart magicAvatarCropGeneratePart, Continuation<? super MagicAvatarCropGeneratePart$initObserver$3> continuation) {
        super(2, continuation);
        this.this$0 = magicAvatarCropGeneratePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicAvatarCropGeneratePart$initObserver$3(this.this$0, continuation);
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
            SharedFlow<com.tencent.mobileqq.wink.magicAvatar.model.f> I2 = magicAvatarCropViewModel.I2();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (I2.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicAvatarCropGeneratePart$initObserver$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
