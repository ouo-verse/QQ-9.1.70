package com.tencent.mobileqq.wink.editdraft;

import com.tencent.qphone.base.util.QLog;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editdraft.WinkEditorDraftCleanUtil$deleteDraft$1", f = "WinkEditorDraftCleanUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkEditorDraftCleanUtil$deleteDraft$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WinkEditorDraftDeleteStrategy $deleteStrategy;
    final /* synthetic */ List<String> $missionIds;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorDraftCleanUtil$deleteDraft$1(WinkEditorDraftDeleteStrategy winkEditorDraftDeleteStrategy, List<String> list, Continuation<? super WinkEditorDraftCleanUtil$deleteDraft$1> continuation) {
        super(2, continuation);
        this.$deleteStrategy = winkEditorDraftDeleteStrategy;
        this.$missionIds = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkEditorDraftCleanUtil$deleteDraft$1(this.$deleteStrategy, this.$missionIds, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                WinkEditorDraftCleanUtil.f318495a.d(this.$deleteStrategy, this.$missionIds);
            } catch (Throwable th5) {
                QLog.e("WinkEditorDraftCleanUtil", 1, "deleteDraft, error ", th5);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkEditorDraftCleanUtil$deleteDraft$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
