package com.tencent.mobileqq.wink.magicAvatar.ui;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel;
import com.tencent.mobileqq.wink.magicAvatar.viewmodel.a;
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
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarCropGeneratePart$initObserver$5", f = "MagicAvatarCropGeneratePart.kt", i = {}, l = {com.tencent.luggage.wxa.yd.a.CTRL_INDEX}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicAvatarCropGeneratePart$initObserver$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MagicAvatarCropGeneratePart this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlowCollector<com.tencent.mobileqq.wink.magicAvatar.viewmodel.a> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MagicAvatarCropGeneratePart f323546d;

        public a(MagicAvatarCropGeneratePart magicAvatarCropGeneratePart) {
            this.f323546d = magicAvatarCropGeneratePart;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(com.tencent.mobileqq.wink.magicAvatar.viewmodel.a aVar, @NotNull Continuation<? super Unit> continuation) {
            ImageView imageView;
            ImageView imageView2;
            TextView textView;
            TextView textView2;
            ImageView imageView3;
            ImageView imageView4;
            TextView textView3;
            TextView textView4;
            com.tencent.mobileqq.wink.magicAvatar.viewmodel.a aVar2 = aVar;
            TextView textView5 = null;
            if (aVar2 instanceof a.c) {
                imageView3 = this.f323546d.changeGenderIcon;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("changeGenderIcon");
                    imageView3 = null;
                }
                imageView3.setEnabled(false);
                imageView4 = this.f323546d.changeGenderIcon;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("changeGenderIcon");
                    imageView4 = null;
                }
                imageView4.setAlpha(0.4f);
                textView3 = this.f323546d.changeGender;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("changeGender");
                    textView3 = null;
                }
                textView3.setEnabled(false);
                textView4 = this.f323546d.changeGender;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("changeGender");
                } else {
                    textView5 = textView4;
                }
                textView5.setAlpha(0.4f);
            } else if (aVar2 instanceof a.d) {
                imageView = this.f323546d.changeGenderIcon;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("changeGenderIcon");
                    imageView = null;
                }
                imageView.setEnabled(true);
                imageView2 = this.f323546d.changeGenderIcon;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("changeGenderIcon");
                    imageView2 = null;
                }
                imageView2.setAlpha(1.0f);
                textView = this.f323546d.changeGender;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("changeGender");
                    textView = null;
                }
                textView.setEnabled(true);
                textView2 = this.f323546d.changeGender;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("changeGender");
                } else {
                    textView5 = textView2;
                }
                textView5.setAlpha(1.0f);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarCropGeneratePart$initObserver$5(MagicAvatarCropGeneratePart magicAvatarCropGeneratePart, Continuation<? super MagicAvatarCropGeneratePart$initObserver$5> continuation) {
        super(2, continuation);
        this.this$0 = magicAvatarCropGeneratePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicAvatarCropGeneratePart$initObserver$5(this.this$0, continuation);
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
            StateFlow<com.tencent.mobileqq.wink.magicAvatar.viewmodel.a> C2 = magicAvatarCropViewModel.C2();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (C2.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicAvatarCropGeneratePart$initObserver$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
