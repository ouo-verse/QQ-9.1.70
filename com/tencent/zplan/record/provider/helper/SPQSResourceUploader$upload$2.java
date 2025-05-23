package com.tencent.zplan.record.provider.helper;

import com.tencent.zplan.record.model.ZPlanRecordResource;
import fv4.d;
import java.util.Set;
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
import lx4.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.zplan.record.provider.helper.SPQSResourceUploader$upload$2", f = "SPQSResourceUploader.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes27.dex */
final class SPQSResourceUploader$upload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ZPlanRecordResource $resource;
    final /* synthetic */ String $uploadFlag;
    final /* synthetic */ d $waitUploadRecord;
    int label;
    final /* synthetic */ SPQSResourceUploader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SPQSResourceUploader$upload$2(SPQSResourceUploader sPQSResourceUploader, ZPlanRecordResource zPlanRecordResource, d dVar, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = sPQSResourceUploader;
        this.$resource = zPlanRecordResource;
        this.$waitUploadRecord = dVar;
        this.$uploadFlag = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new SPQSResourceUploader$upload$2(this.this$0, this.$resource, this.$waitUploadRecord, this.$uploadFlag, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SPQSResourceUploader$upload$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            SPQSResourceUploader sPQSResourceUploader = this.this$0;
            ZPlanRecordResource zPlanRecordResource = this.$resource;
            d dVar = this.$waitUploadRecord;
            this.label = 1;
            if (sPQSResourceUploader.g(zPlanRecordResource, dVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        f fVar = (f) mx4.a.f417748a.a(f.class);
        if (fVar != null) {
            fVar.c(new Runnable() { // from class: com.tencent.zplan.record.provider.helper.SPQSResourceUploader$upload$2.1
                @Override // java.lang.Runnable
                public final void run() {
                    Set set;
                    Set set2;
                    set = SPQSResourceUploader.f386129f;
                    synchronized (set) {
                        set2 = SPQSResourceUploader.f386129f;
                        set2.remove(SPQSResourceUploader$upload$2.this.$uploadFlag);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }, 3000L);
        }
        return Unit.INSTANCE;
    }
}
