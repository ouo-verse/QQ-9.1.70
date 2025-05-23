package com.tencent.guild.aio.reserve2.busi.chosen;

import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.reserve2.busi.chosen.GuildChosenMsgState;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lnq0/c;", "<anonymous parameter 0>", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.reserve2.busi.chosen.GuildChosenMsgVM$onCreate$1", f = "GuildChosenMsgVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class GuildChosenMsgVM$onCreate$1 extends SuspendLambda implements Function2<nq0.c, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GuildChosenMsgVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildChosenMsgVM$onCreate$1(GuildChosenMsgVM guildChosenMsgVM, Continuation<? super GuildChosenMsgVM$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = guildChosenMsgVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildChosenMsgVM$onCreate$1(this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i("GuildChosenMsgVM", 4, "hide chosen bar");
            ArrayList arrayList = new ArrayList();
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) this.this$0.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            this.this$0.updateUI(new GuildChosenMsgState.GuildUpdateListUIState(arrayList, com.tencent.guild.aio.util.a.b(g16)));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull nq0.c cVar, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildChosenMsgVM$onCreate$1) create(cVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
