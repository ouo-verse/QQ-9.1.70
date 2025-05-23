package com.tencent.mobileqq.wink.editor.sticker.sticker.p008new;

import com.tencent.mobileqq.wink.editor.sticker.sticker.p008new.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.sticker.sticker.new.WinkEditorStickerViewModel$onContentScrolled$1$1", f = "WinkEditorStickerViewModel.kt", i = {}, l = {310}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkEditorStickerViewModel$onContentScrolled$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $bottomCateIndex;
    final /* synthetic */ int $topTabIndex;
    int label;
    final /* synthetic */ WinkEditorStickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorStickerViewModel$onContentScrolled$1$1(WinkEditorStickerViewModel winkEditorStickerViewModel, int i3, int i16, Continuation<? super WinkEditorStickerViewModel$onContentScrolled$1$1> continuation) {
        super(2, continuation);
        this.this$0 = winkEditorStickerViewModel;
        this.$topTabIndex = i3;
        this.$bottomCateIndex = i16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkEditorStickerViewModel$onContentScrolled$1$1(this.this$0, this.$topTabIndex, this.$bottomCateIndex, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableSharedFlow mutableSharedFlow;
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
            mutableSharedFlow = this.this$0._stickerMenuEvent;
            d.ScrollSelectBottomTab scrollSelectBottomTab = new d.ScrollSelectBottomTab(this.$topTabIndex, this.$bottomCateIndex);
            this.label = 1;
            if (mutableSharedFlow.emit(scrollSelectBottomTab, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkEditorStickerViewModel$onContentScrolled$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
