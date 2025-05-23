package com.tencent.mobileqq.wink.magicstudio;

import com.heytap.databaseengine.type.DataTableNameType;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPrompt;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioUploadImgAndStyle;
import java.util.ArrayList;
import java.util.List;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$updateImageAndUpload$1", f = "MagicStudioCreationViewModel.kt", i = {}, l = {DataTableNameType.TABLE_WRIST_TEMPERATURE_STAT, DataTableNameType.TABLE_SPORT_METADATA}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel$updateImageAndUpload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MagicStudioUploadImgAndStyle $info;
    int label;
    final /* synthetic */ MagicStudioCreationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioCreationViewModel$updateImageAndUpload$1(MagicStudioCreationViewModel magicStudioCreationViewModel, MagicStudioUploadImgAndStyle magicStudioUploadImgAndStyle, Continuation<? super MagicStudioCreationViewModel$updateImageAndUpload$1> continuation) {
        super(2, continuation);
        this.this$0 = magicStudioCreationViewModel;
        this.$info = magicStudioUploadImgAndStyle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicStudioCreationViewModel$updateImageAndUpload$1(this.this$0, this.$info, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        r5 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r5);
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MagicStudioDataManager I2;
        List list;
        MutableStateFlow mutableStateFlow;
        MutableSharedFlow mutableSharedFlow;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            I2 = this.this$0.I2();
            I2.n(this.$info);
            ArrayList<MagicStudioPrompt> recommendTopicList = this.$info.getRecommendTopicList();
            if (recommendTopicList != null && list != null) {
                mutableStateFlow = this.this$0._tagData;
                this.label = 1;
                if (mutableStateFlow.emit(list, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        ArrayList<String> recommendStyleList = this.$info.getRecommendStyleList();
        if (recommendStyleList != null) {
            mutableSharedFlow = this.this$0._selectEvent;
            MagicStudioCreationViewModel.c.StyleSuccess styleSuccess = new MagicStudioCreationViewModel.c.StyleSuccess(recommendStyleList);
            this.label = 2;
            if (mutableSharedFlow.emit(styleSuccess, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioCreationViewModel$updateImageAndUpload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
