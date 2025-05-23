package com.tencent.guild.aio.reserve2.busi.chosen;

import com.tencent.qphone.base.util.QLog;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.reserve2.busi.chosen.GuildChosenMsgVM$requestChosenMsgIfNeed$1", f = "GuildChosenMsgVM.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildChosenMsgVM$requestChosenMsgIfNeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GuildChosenMsgVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildChosenMsgVM$requestChosenMsgIfNeed$1(GuildChosenMsgVM guildChosenMsgVM, Continuation<? super GuildChosenMsgVM$requestChosenMsgIfNeed$1> continuation) {
        super(2, continuation);
        this.this$0 = guildChosenMsgVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildChosenMsgVM$requestChosenMsgIfNeed$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List B;
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
            GuildChosenMsgVM guildChosenMsgVM = this.this$0;
            this.label = 1;
            obj = guildChosenMsgVM.y(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        QLog.i("GuildChosenMsgVM", 1, "isClosed=" + booleanValue);
        if (!booleanValue) {
            B = this.this$0.B();
            this.this$0.L(B);
        } else {
            this.this$0.L(new ArrayList());
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildChosenMsgVM$requestChosenMsgIfNeed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
