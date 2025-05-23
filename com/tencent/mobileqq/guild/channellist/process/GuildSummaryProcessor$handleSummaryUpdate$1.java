package com.tencent.mobileqq.guild.channellist.process;

import com.tencent.mobileqq.guild.summary.GuildSummaryData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.channellist.process.GuildSummaryProcessor$handleSummaryUpdate$1", f = "GuildSummaryProcessor.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class GuildSummaryProcessor$handleSummaryUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<GuildSummaryData> $summaries;
    int label;
    final /* synthetic */ GuildSummaryProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSummaryProcessor$handleSummaryUpdate$1(List<GuildSummaryData> list, GuildSummaryProcessor guildSummaryProcessor, Continuation<? super GuildSummaryProcessor$handleSummaryUpdate$1> continuation) {
        super(2, continuation);
        this.$summaries = list;
        this.this$0 = guildSummaryProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildSummaryProcessor$handleSummaryUpdate$1(this.$summaries, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableSharedFlow mutableSharedFlow;
        Pair pair;
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
            List<GuildSummaryData> list = this.$summaries;
            GuildSummaryProcessor guildSummaryProcessor = this.this$0;
            ArrayList arrayList = new ArrayList();
            for (GuildSummaryData guildSummaryData : list) {
                if (Intrinsics.areEqual(guildSummaryData.getGuildId(), guildSummaryProcessor.guildId)) {
                    pair = TuplesKt.to(guildSummaryData.getChannelId(), guildSummaryData);
                } else {
                    pair = null;
                }
                if (pair != null) {
                    arrayList.add(pair);
                }
            }
            if (!arrayList.isEmpty()) {
                mutableSharedFlow = this.this$0._summaryFlow;
                ItemsProcessEvent itemsProcessEvent = new ItemsProcessEvent(this.this$0.guildId, this.this$0, arrayList);
                this.label = 1;
                if (mutableSharedFlow.emit(itemsProcessEvent, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildSummaryProcessor$handleSummaryUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
