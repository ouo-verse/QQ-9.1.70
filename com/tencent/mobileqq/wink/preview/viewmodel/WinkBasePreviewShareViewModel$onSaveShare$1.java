package com.tencent.mobileqq.wink.preview.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel;
import com.tencent.tavcut.core.session.ICutSession;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel$onSaveShare$1", f = "WinkBasePreviewShareViewModel.kt", i = {}, l = {288}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkBasePreviewShareViewModel$onSaveShare$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ICutSession $cutSession;
    final /* synthetic */ WinkBasePreviewShareViewModel.PreviewData $previewData;
    final /* synthetic */ WinkEditDataWrapper $wrapper;
    int label;
    final /* synthetic */ WinkBasePreviewShareViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkBasePreviewShareViewModel$onSaveShare$1(WinkBasePreviewShareViewModel winkBasePreviewShareViewModel, WinkBasePreviewShareViewModel.PreviewData previewData, ICutSession iCutSession, WinkEditDataWrapper winkEditDataWrapper, Continuation<? super WinkBasePreviewShareViewModel$onSaveShare$1> continuation) {
        super(2, continuation);
        this.this$0 = winkBasePreviewShareViewModel;
        this.$previewData = previewData;
        this.$cutSession = iCutSession;
        this.$wrapper = winkEditDataWrapper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkBasePreviewShareViewModel$onSaveShare$1(this.this$0, this.$previewData, this.$cutSession, this.$wrapper, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
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
            CoroutineDispatcher b16 = WinkCoroutineScopes.f317652a.b();
            WinkBasePreviewShareViewModel$onSaveShare$1$coverPath$1 winkBasePreviewShareViewModel$onSaveShare$1$coverPath$1 = new WinkBasePreviewShareViewModel$onSaveShare$1$coverPath$1(this.this$0, this.$cutSession, this.$wrapper, null);
            this.label = 1;
            obj = BuildersKt.withContext(b16, winkBasePreviewShareViewModel$onSaveShare$1$coverPath$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        mutableLiveData = this.this$0._previewEvent;
        t73.b.b(mutableLiveData, new WinkBasePreviewShareViewModel.c.SaveShare(this.$previewData.getWinkEditDataWrapper(), this.$previewData.getMaterial(), (String) obj));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkBasePreviewShareViewModel$onSaveShare$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
