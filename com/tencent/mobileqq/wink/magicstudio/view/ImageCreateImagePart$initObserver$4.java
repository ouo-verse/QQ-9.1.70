package com.tencent.mobileqq.wink.magicstudio.view;

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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.view.ImageCreateImagePart$initObserver$4", f = "ImageCreateImagePart.kt", i = {}, l = {331}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class ImageCreateImagePart$initObserver$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ImageCreateImagePart this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlowCollector<Pair<? extends String, ? extends String>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageCreateImagePart f323902d;

        public a(ImageCreateImagePart imageCreateImagePart) {
            this.f323902d = imageCreateImagePart;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(Pair<? extends String, ? extends String> pair, @NotNull Continuation<? super Unit> continuation) {
            EditText editText;
            EditText editText2;
            boolean z16;
            EditText editText3;
            EditText editText4;
            EditText editText5;
            EditText editText6;
            EditText editText7;
            char last;
            EditText editText8;
            EditText editText9;
            EditText editText10;
            EditText editText11;
            Pair<? extends String, ? extends String> pair2 = pair;
            String second = pair2.getSecond();
            editText = this.f323902d.promptDesc;
            EditText editText12 = null;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("promptDesc");
                editText = null;
            }
            if (!Intrinsics.areEqual(second, editText.getText().toString())) {
                editText2 = this.f323902d.promptDesc;
                if (editText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("promptDesc");
                    editText2 = null;
                }
                Editable text = editText2.getText();
                Intrinsics.checkNotNullExpressionValue(text, "promptDesc.text");
                if (text.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    editText7 = this.f323902d.promptDesc;
                    if (editText7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("promptDesc");
                        editText7 = null;
                    }
                    Editable text2 = editText7.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "promptDesc.text");
                    last = StringsKt___StringsKt.last(text2);
                    if (Character.isLetterOrDigit(last)) {
                        editText10 = this.f323902d.promptDesc;
                        if (editText10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("promptDesc");
                            editText10 = null;
                        }
                        editText11 = this.f323902d.promptDesc;
                        if (editText11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("promptDesc");
                            editText11 = null;
                        }
                        editText10.setText(editText11.getText().append((CharSequence) "\uff0c").append((CharSequence) pair2.getSecond()));
                    } else {
                        editText8 = this.f323902d.promptDesc;
                        if (editText8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("promptDesc");
                            editText8 = null;
                        }
                        editText9 = this.f323902d.promptDesc;
                        if (editText9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("promptDesc");
                            editText9 = null;
                        }
                        editText8.setText(editText9.getText().append((CharSequence) pair2.getSecond()));
                    }
                } else {
                    editText3 = this.f323902d.promptDesc;
                    if (editText3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("promptDesc");
                        editText3 = null;
                    }
                    editText4 = this.f323902d.promptDesc;
                    if (editText4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("promptDesc");
                        editText4 = null;
                    }
                    editText3.setText(editText4.getText().append((CharSequence) pair2.getSecond()));
                }
                editText5 = this.f323902d.promptDesc;
                if (editText5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("promptDesc");
                    editText5 = null;
                }
                editText6 = this.f323902d.promptDesc;
                if (editText6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("promptDesc");
                } else {
                    editText12 = editText6;
                }
                editText5.setSelection(editText12.getText().length());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCreateImagePart$initObserver$4(ImageCreateImagePart imageCreateImagePart, Continuation<? super ImageCreateImagePart$initObserver$4> continuation) {
        super(2, continuation);
        this.this$0 = imageCreateImagePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ImageCreateImagePart$initObserver$4(this.this$0, continuation);
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
            StateFlow<Pair<String, String>> J2 = this.this$0.vm.J2();
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
        return ((ImageCreateImagePart$initObserver$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
