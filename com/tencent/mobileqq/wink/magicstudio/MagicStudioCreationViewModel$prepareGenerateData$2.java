package com.tencent.mobileqq.wink.magicstudio;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$prepareGenerateData$2", f = "MagicStudioCreationViewModel.kt", i = {}, l = {632}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel$prepareGenerateData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $cropFaceUrl;
    final /* synthetic */ String $imagePath;
    Object L$0;
    int label;
    final /* synthetic */ MagicStudioCreationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioCreationViewModel$prepareGenerateData$2(Ref.ObjectRef<String> objectRef, MagicStudioCreationViewModel magicStudioCreationViewModel, String str, Continuation<? super MagicStudioCreationViewModel$prepareGenerateData$2> continuation) {
        super(2, continuation);
        this.$cropFaceUrl = objectRef;
        this.this$0 = magicStudioCreationViewModel;
        this.$imagePath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicStudioCreationViewModel$prepareGenerateData$2(this.$cropFaceUrl, this.this$0, this.$imagePath, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object y26;
        Ref.ObjectRef<String> objectRef;
        T t16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                objectRef = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                t16 = obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef<String> objectRef2 = this.$cropFaceUrl;
            MagicStudioCreationViewModel magicStudioCreationViewModel = this.this$0;
            String str = this.$imagePath;
            this.L$0 = objectRef2;
            this.label = 1;
            y26 = magicStudioCreationViewModel.y2(str, this);
            if (y26 == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
            t16 = y26;
        }
        objectRef.element = t16;
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioCreationViewModel$prepareGenerateData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
