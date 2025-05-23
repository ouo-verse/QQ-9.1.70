package com.tencent.robot.aio.helper.tts.task;

import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Pair;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.aio.helper.tts.task.TtsPlayTaskCenter$runNextTtsTask$1", f = "TtsPlayTaskCenter.kt", i = {}, l = {317}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class TtsPlayTaskCenter$runNextTtsTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TtsPlayTaskItem $taskItem;
    int label;
    final /* synthetic */ TtsPlayTaskCenter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TtsPlayTaskCenter$runNextTtsTask$1(TtsPlayTaskCenter ttsPlayTaskCenter, TtsPlayTaskItem ttsPlayTaskItem, Continuation<? super TtsPlayTaskCenter$runNextTtsTask$1> continuation) {
        super(2, continuation);
        this.this$0 = ttsPlayTaskCenter;
        this.$taskItem = ttsPlayTaskItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TtsPlayTaskCenter$runNextTtsTask$1(this.this$0, this.$taskItem, continuation);
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
            TtsPlayTaskCenter ttsPlayTaskCenter = this.this$0;
            this.label = 1;
            obj = ttsPlayTaskCenter.T(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Pair pair = (Pair) obj;
        if (((Boolean) pair.getFirst()).booleanValue()) {
            this.this$0.mNeedFetchRobotTtsId = false;
            this.this$0.mCurrentTtsId = (String) pair.getSecond();
            this.this$0.U(this.$taskItem);
        } else {
            QLog.e("TtsPlayTaskCenter", 1, "tryToFetchRobotTtsId false");
            this.this$0.C();
            if (!this.$taskItem.getIsAutoTrigger()) {
                this.this$0.N(R.string.f170632lk, 1);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TtsPlayTaskCenter$runNextTtsTask$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
