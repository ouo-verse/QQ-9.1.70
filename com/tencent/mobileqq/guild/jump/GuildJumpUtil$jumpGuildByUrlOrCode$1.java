package com.tencent.mobileqq.guild.jump;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.guild.jump.model.BaseGuildShareParam;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.jump.GuildJumpUtil$jumpGuildByUrlOrCode$1", f = "GuildJumpUtil.kt", i = {0, 1}, l = {80, 83}, m = "invokeSuspend", n = {"reportTask", "reportTask"}, s = {"L$0", "L$0"})
/* loaded from: classes13.dex */
public final class GuildJumpUtil$jumpGuildByUrlOrCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ BaseGuildShareParam $originalParam;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildJumpUtil$jumpGuildByUrlOrCode$1(Context context, BaseGuildShareParam baseGuildShareParam, Continuation<? super GuildJumpUtil$jumpGuildByUrlOrCode$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$originalParam = baseGuildShareParam;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildJumpUtil$jumpGuildByUrlOrCode$1(this.$context, this.$originalParam, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IPerformanceReportTask iPerformanceReportTask;
        IPerformanceReportTask iPerformanceReportTask2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    iPerformanceReportTask2 = (IPerformanceReportTask) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    iPerformanceReportTask = iPerformanceReportTask2;
                    iPerformanceReportTask.report();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            iPerformanceReportTask = (IPerformanceReportTask) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            IPerformanceReportTask stageCode = Reporters.f231995a.b().newReportTask().setEventCode("guild_jump").setStageCode("stage_start");
            GuildUrlParserHelper guildUrlParserHelper = GuildUrlParserHelper.f226381a;
            Context context = this.$context;
            BaseGuildShareParam baseGuildShareParam = this.$originalParam;
            this.L$0 = stageCode;
            this.label = 1;
            Object r16 = guildUrlParserHelper.r(context, baseGuildShareParam, stageCode, this);
            if (r16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            iPerformanceReportTask = stageCode;
            obj = r16;
        }
        JumpGuildParam jumpGuildParam = (JumpGuildParam) obj;
        if (jumpGuildParam != null) {
            Context context2 = this.$context;
            Bundle extras = jumpGuildParam.extras;
            Intrinsics.checkNotNullExpressionValue(extras, "extras");
            qw1.b.t(extras, iPerformanceReportTask, JumpGuildParam.EXTRA_JUMP_REPORT_TASK);
            GuildJumpHelper guildJumpHelper = GuildJumpHelper.f226371a;
            this.L$0 = iPerformanceReportTask;
            this.label = 2;
            if (guildJumpHelper.d(context2, jumpGuildParam, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            iPerformanceReportTask2 = iPerformanceReportTask;
            iPerformanceReportTask = iPerformanceReportTask2;
        }
        iPerformanceReportTask.report();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildJumpUtil$jumpGuildByUrlOrCode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
