package com.tencent.mobileqq.guild.home.viewmodels.header.processors.biz;

import com.tencent.mobileqq.guild.home.viewmodels.header.processors.c;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildMainFrameHeaderInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.home.viewmodels.header.processors.biz.GuildHomeCommonHeaderBarsUpdateProcessor$handleHeaderBarsList$1", f = "GuildHomeCommonHeaderBarsUpdateProcessor.kt", i = {}, l = {69, 70}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildHomeCommonHeaderBarsUpdateProcessor$handleHeaderBarsList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $guildId;
    int label;
    final /* synthetic */ GuildHomeCommonHeaderBarsUpdateProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeCommonHeaderBarsUpdateProcessor$handleHeaderBarsList$1(GuildHomeCommonHeaderBarsUpdateProcessor guildHomeCommonHeaderBarsUpdateProcessor, String str, Continuation<? super GuildHomeCommonHeaderBarsUpdateProcessor$handleHeaderBarsList$1> continuation) {
        super(2, continuation);
        this.this$0 = guildHomeCommonHeaderBarsUpdateProcessor;
        this.$guildId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildHomeCommonHeaderBarsUpdateProcessor$handleHeaderBarsList$1(this.this$0, this.$guildId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableSharedFlow mutableSharedFlow;
        List listOf;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            GuildHomeCommonHeaderBarsUpdateProcessor guildHomeCommonHeaderBarsUpdateProcessor = this.this$0;
            String str = this.$guildId;
            this.label = 1;
            obj = guildHomeCommonHeaderBarsUpdateProcessor.z(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (((IGProGuildMainFrameHeaderInfo) obj) != null) {
            mutableSharedFlow = this.this$0._eventSource;
            GuildHomeCommonHeaderBarsUpdateProcessor guildHomeCommonHeaderBarsUpdateProcessor2 = this.this$0;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new Pair(Boxing.boxInt(2), this.this$0.guildHeaderBarsDataStoreAndConvertor.e()));
            c cVar = new c(guildHomeCommonHeaderBarsUpdateProcessor2, listOf);
            this.label = 2;
            if (mutableSharedFlow.emit(cVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildHomeCommonHeaderBarsUpdateProcessor$handleHeaderBarsList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
