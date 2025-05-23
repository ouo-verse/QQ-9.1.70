package com.tencent.mobileqq.wink.editdraft;

import com.tencent.qphone.base.util.QLog;
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
@DebugMetadata(c = "com.tencent.mobileqq.wink.editdraft.WinkEditorDraftCleanUtil$tryBatchDeleteDraft$1", f = "WinkEditorDraftCleanUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkEditorDraftCleanUtil$tryBatchDeleteDraft$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ d $batchDeleteStrategy;
    final /* synthetic */ String $businessName;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorDraftCleanUtil$tryBatchDeleteDraft$1(d dVar, String str, Continuation<? super WinkEditorDraftCleanUtil$tryBatchDeleteDraft$1> continuation) {
        super(2, continuation);
        this.$batchDeleteStrategy = dVar;
        this.$businessName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkEditorDraftCleanUtil$tryBatchDeleteDraft$1(this.$batchDeleteStrategy, this.$businessName, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                WinkEditorDraftCleanUtil.f318495a.c(this.$batchDeleteStrategy);
            } catch (Exception e16) {
                QLog.e("WinkEditorDraftCleanUtil", 1, "tryBatchDeleteDraft, businessName:" + this.$businessName + ", error ", e16);
                g.f318523a.a(new WinkEditorDraftReportData(0, null, 0L, 0L, 0L, 0L, 0L, 0L, 255, null));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkEditorDraftCleanUtil$tryBatchDeleteDraft$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
