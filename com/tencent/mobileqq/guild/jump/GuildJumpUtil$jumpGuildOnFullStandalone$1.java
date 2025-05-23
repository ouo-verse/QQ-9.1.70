package com.tencent.mobileqq.guild.jump;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.jump.GuildJumpUtil$jumpGuildOnFullStandalone$1", f = "GuildJumpUtil.kt", i = {0}, l = {63}, m = "invokeSuspend", n = {"reportTask"}, s = {"L$0"})
/* loaded from: classes13.dex */
public final class GuildJumpUtil$jumpGuildOnFullStandalone$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ JumpGuildParam $param;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildJumpUtil$jumpGuildOnFullStandalone$1(JumpGuildParam jumpGuildParam, Context context, Continuation<? super GuildJumpUtil$jumpGuildOnFullStandalone$1> continuation) {
        super(2, continuation);
        this.$param = jumpGuildParam;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildJumpUtil$jumpGuildOnFullStandalone$1(this.$param, this.$context, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IPerformanceReportTask d16;
        IPerformanceReportTask iPerformanceReportTask;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                iPerformanceReportTask = (IPerformanceReportTask) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            d16 = GuildJumpUtil.f226378a.d(this.$param);
            Bundle bundle = this.$param.extras;
            Intrinsics.checkNotNullExpressionValue(bundle, "param.extras");
            qw1.b.t(bundle, d16, JumpGuildParam.EXTRA_JUMP_REPORT_TASK);
            GuildJumpHelper guildJumpHelper = GuildJumpHelper.f226371a;
            Context context = this.$context;
            JumpGuildParam jumpGuildParam = this.$param;
            this.L$0 = d16;
            this.label = 1;
            if (guildJumpHelper.d(context, jumpGuildParam, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            iPerformanceReportTask = d16;
        }
        iPerformanceReportTask.report();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildJumpUtil$jumpGuildOnFullStandalone$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
