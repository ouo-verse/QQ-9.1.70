package com.tencent.mobileqq.wink.magicstudio;

import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioUploadImgInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$prepareGenerateData$4", f = "MagicStudioCreationViewModel.kt", i = {}, l = {646}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel$prepareGenerateData$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MagicStudioUploadImgInfo $currentImg;
    final /* synthetic */ String $imagePath;
    Object L$0;
    int label;
    final /* synthetic */ MagicStudioCreationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioCreationViewModel$prepareGenerateData$4(MagicStudioUploadImgInfo magicStudioUploadImgInfo, MagicStudioCreationViewModel magicStudioCreationViewModel, String str, Continuation<? super MagicStudioCreationViewModel$prepareGenerateData$4> continuation) {
        super(2, continuation);
        this.$currentImg = magicStudioUploadImgInfo;
        this.this$0 = magicStudioCreationViewModel;
        this.$imagePath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicStudioCreationViewModel$prepareGenerateData$4(this.$currentImg, this.this$0, this.$imagePath, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object y26;
        MagicStudioUploadImgInfo magicStudioUploadImgInfo;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                magicStudioUploadImgInfo = (MagicStudioUploadImgInfo) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            MagicStudioUploadImgInfo magicStudioUploadImgInfo2 = this.$currentImg;
            MagicStudioCreationViewModel magicStudioCreationViewModel = this.this$0;
            String str = this.$imagePath;
            this.L$0 = magicStudioUploadImgInfo2;
            this.label = 1;
            y26 = magicStudioCreationViewModel.y2(str, this);
            if (y26 == coroutine_suspended) {
                return coroutine_suspended;
            }
            magicStudioUploadImgInfo = magicStudioUploadImgInfo2;
            obj = y26;
        }
        String str2 = (String) obj;
        if (str2 == null) {
            str2 = "";
        }
        magicStudioUploadImgInfo.p(str2);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioCreationViewModel$prepareGenerateData$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
