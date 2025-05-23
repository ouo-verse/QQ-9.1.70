package com.tencent.robot.adelie.kuikly.view.record;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.homepage.AdelieUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x14.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.adelie.kuikly.view.record.AdelieUploadFile$upload$1", f = "AdelieUploadFile.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class AdelieUploadFile$upload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $callback;
    final /* synthetic */ c.TaskParam $param;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AdelieUploadFile this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdelieUploadFile$upload$1(AdelieUploadFile adelieUploadFile, c.TaskParam taskParam, Function1<? super String, Unit> function1, Continuation<? super AdelieUploadFile$upload$1> continuation) {
        super(2, continuation);
        this.this$0 = adelieUploadFile;
        this.$param = taskParam;
        this.$callback = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 function1, AdelieUtils.UploadResult uploadResult) {
        function1.invoke(uploadResult.getUrl());
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AdelieUploadFile$upload$1 adelieUploadFile$upload$1 = new AdelieUploadFile$upload$1(this.this$0, this.$param, this.$callback, continuation);
        adelieUploadFile$upload$1.L$0 = obj;
        return adelieUploadFile$upload$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
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
            async$default = BuildersKt__Builders_commonKt.async$default((CoroutineScope) this.L$0, null, null, new AdelieUploadFile$upload$1$wavUrlJob$1(this.this$0, this.$param, null), 3, null);
            this.label = 1;
            obj = async$default.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        final AdelieUtils.UploadResult uploadResult = (AdelieUtils.UploadResult) obj;
        QLog.i("AdelieUploadFile", 1, "upload result = " + uploadResult);
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final Function1<String, Unit> function1 = this.$callback;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.robot.adelie.kuikly.view.record.a
            @Override // java.lang.Runnable
            public final void run() {
                AdelieUploadFile$upload$1.b(Function1.this, uploadResult);
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AdelieUploadFile$upload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
