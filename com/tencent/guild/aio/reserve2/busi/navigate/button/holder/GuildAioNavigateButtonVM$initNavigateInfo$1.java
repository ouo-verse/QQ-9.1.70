package com.tencent.guild.aio.reserve2.busi.navigate.button.holder;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u00052\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0000H\u008a@"}, d2 = {"", "", "", "Lfr0/a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.reserve2.busi.navigate.button.holder.GuildAioNavigateButtonVM$initNavigateInfo$1", f = "GuildAioNavigateButtonVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildAioNavigateButtonVM$initNavigateInfo$1 extends SuspendLambda implements Function2<Map<Integer, ? extends List<? extends fr0.a>>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildAioNavigateButtonVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAioNavigateButtonVM$initNavigateInfo$1(GuildAioNavigateButtonVM guildAioNavigateButtonVM, Continuation<? super GuildAioNavigateButtonVM$initNavigateInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = guildAioNavigateButtonVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildAioNavigateButtonVM$initNavigateInfo$1 guildAioNavigateButtonVM$initNavigateInfo$1 = new GuildAioNavigateButtonVM$initNavigateInfo$1(this.this$0, continuation);
        guildAioNavigateButtonVM$initNavigateInfo$1.L$0 = obj;
        return guildAioNavigateButtonVM$initNavigateInfo$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Map<Integer, ? extends List<? extends fr0.a>> map, Continuation<? super Unit> continuation) {
        return invoke2((Map<Integer, ? extends List<fr0.a>>) map, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.r((Map) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull Map<Integer, ? extends List<fr0.a>> map, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildAioNavigateButtonVM$initNavigateInfo$1) create(map, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
