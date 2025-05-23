package com.tencent.mobileqq.wink.magicstudio;

import android.text.Editable;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.TextCreationFragment$initObserver$6", f = "TextCreationFragment.kt", i = {}, l = {461}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class TextCreationFragment$initObserver$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TextCreationFragment this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlowCollector<Pair<? extends String, ? extends String>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextCreationFragment f323706d;

        public a(TextCreationFragment textCreationFragment) {
            this.f323706d = textCreationFragment;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(Pair<? extends String, ? extends String> pair, @NotNull Continuation<? super Unit> continuation) {
            EditText Lh;
            EditText Lh2;
            EditText Lh3;
            boolean z16;
            EditText Lh4;
            EditText Lh5;
            EditText Lh6;
            EditText Lh7;
            EditText Lh8;
            char last;
            EditText Lh9;
            EditText Lh10;
            EditText Lh11;
            EditText Lh12;
            Pair<? extends String, ? extends String> pair2 = pair;
            Lh = this.f323706d.Lh();
            Lh.setHint(pair2.getFirst());
            String second = pair2.getSecond();
            Lh2 = this.f323706d.Lh();
            if (!Intrinsics.areEqual(second, Lh2.getText().toString())) {
                Lh3 = this.f323706d.Lh();
                Editable text = Lh3.getText();
                Intrinsics.checkNotNullExpressionValue(text, "promptDesc.text");
                if (text.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    Lh8 = this.f323706d.Lh();
                    Editable text2 = Lh8.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "promptDesc.text");
                    last = StringsKt___StringsKt.last(text2);
                    if (Character.isLetterOrDigit(last)) {
                        Lh11 = this.f323706d.Lh();
                        Lh12 = this.f323706d.Lh();
                        Lh11.setText(Lh12.getText().append((CharSequence) "\uff0c").append((CharSequence) pair2.getSecond()));
                    } else {
                        Lh9 = this.f323706d.Lh();
                        Lh10 = this.f323706d.Lh();
                        Lh9.setText(Lh10.getText().append((CharSequence) pair2.getSecond()));
                    }
                } else {
                    Lh4 = this.f323706d.Lh();
                    Lh5 = this.f323706d.Lh();
                    Lh4.setText(Lh5.getText().append((CharSequence) pair2.getSecond()));
                }
                Lh6 = this.f323706d.Lh();
                Lh7 = this.f323706d.Lh();
                Lh6.setSelection(Lh7.getText().length());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextCreationFragment$initObserver$6(TextCreationFragment textCreationFragment, Continuation<? super TextCreationFragment$initObserver$6> continuation) {
        super(2, continuation);
        this.this$0 = textCreationFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TextCreationFragment$initObserver$6(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            StateFlow<Pair<String, String>> J2 = this.this$0.Sh().J2();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (J2.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TextCreationFragment$initObserver$6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
