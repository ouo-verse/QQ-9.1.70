package com.tencent.state.square.resource;

import com.tencent.state.square.IZPlanRecorder;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.record.RecordIdentifier;
import com.tencent.state.square.record.RecordType;
import com.tencent.state.square.resource.FilamentCoverRecorder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.state.square.resource.FilamentCoverRecorder$doStartRecord$1", f = "FilamentCoverRecorder.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes38.dex */
public final class FilamentCoverRecorder$doStartRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FilamentCoverRecorder.RecordRequest $request;
    final /* synthetic */ Resource $resource;
    final /* synthetic */ FilamentCoverRecorder.RecordTask $task;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentCoverRecorder$doStartRecord$1(FilamentCoverRecorder.RecordRequest recordRequest, Resource resource, FilamentCoverRecorder.RecordTask recordTask, Continuation continuation) {
        super(2, continuation);
        this.$request = recordRequest;
        this.$resource = resource;
        this.$task = recordTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new FilamentCoverRecorder$doStartRecord$1(this.$request, this.$resource, this.$task, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilamentCoverRecorder$doStartRecord$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            SquareBaseKt.getSquareLog().i("FilamentCoverRecorder", "doStartRecord: uin=" + this.$request.getSender().getUin() + ", actionId=" + this.$resource.getActionId() + ", id=" + this.$request.getId() + " coverPath=" + this.$request.getCoverPath());
            IZPlanRecorder recorder = Square.INSTANCE.getConfig().getRecorder();
            Resource resource = this.$resource;
            RecordIdentifier recordIdentifier = this.$request.toRecordIdentifier();
            this.label = 1;
            obj = IZPlanRecorder.DefaultImpls.recordAvatarActions$default(recorder, resource, recordIdentifier, true, false, (Continuation) this, 8, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        if (this.$task.getRequest().getRecordType() == RecordType.FILAMENT_NEARBY && !booleanValue) {
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.resource.FilamentCoverRecorder$doStartRecord$1.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FilamentCoverRecorder.IRecordCallback callback = FilamentCoverRecorder$doStartRecord$1.this.$task.getCallback();
                    if (callback != null) {
                        callback.onRecordError(0, FilamentCoverRecorder$doStartRecord$1.this.$task.getRequest(), 3);
                    }
                }
            });
        }
        return Unit.INSTANCE;
    }
}
