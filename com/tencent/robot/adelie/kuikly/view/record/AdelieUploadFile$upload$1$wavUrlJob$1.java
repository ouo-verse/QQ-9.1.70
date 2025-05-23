package com.tencent.robot.adelie.kuikly.view.record;

import com.tencent.robot.adelie.homepage.AdelieUtils;
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
import x14.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/robot/adelie/homepage/AdelieUtils$a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.adelie.kuikly.view.record.AdelieUploadFile$upload$1$wavUrlJob$1", f = "AdelieUploadFile.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class AdelieUploadFile$upload$1$wavUrlJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AdelieUtils.UploadResult>, Object> {
    final /* synthetic */ c.TaskParam $param;
    int label;
    final /* synthetic */ AdelieUploadFile this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieUploadFile$upload$1$wavUrlJob$1(AdelieUploadFile adelieUploadFile, c.TaskParam taskParam, Continuation<? super AdelieUploadFile$upload$1$wavUrlJob$1> continuation) {
        super(2, continuation);
        this.this$0 = adelieUploadFile;
        this.$param = taskParam;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AdelieUploadFile$upload$1$wavUrlJob$1(this.this$0, this.$param, continuation);
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
            AdelieUploadFile adelieUploadFile = this.this$0;
            c.TaskParam taskParam = this.$param;
            this.label = 1;
            obj = adelieUploadFile.e(taskParam, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super AdelieUtils.UploadResult> continuation) {
        return ((AdelieUploadFile$upload$1$wavUrlJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
