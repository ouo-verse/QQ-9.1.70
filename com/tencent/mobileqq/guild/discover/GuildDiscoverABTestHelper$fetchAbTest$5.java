package com.tencent.mobileqq.guild.discover;

import com.tencent.mobileqq.qqguildsdk.data.genc.s;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.discover.GuildDiscoverABTestHelper$fetchAbTest$5", f = "GuildDiscoverABTestHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildDiscoverABTestHelper$fetchAbTest$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Boolean, String, Unit> $onFinish;
    final /* synthetic */ s $req;
    final /* synthetic */ String $source;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildDiscoverABTestHelper$fetchAbTest$5(s sVar, Function2<? super Boolean, ? super String, Unit> function2, String str, Continuation<? super GuildDiscoverABTestHelper$fetchAbTest$5> continuation) {
        super(2, continuation);
        this.$req = sVar;
        this.$onFinish = function2;
        this.$source = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildDiscoverABTestHelper$fetchAbTest$5(this.$req, this.$onFinish, this.$source, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            GuildDiscoverABTestHelper guildDiscoverABTestHelper = GuildDiscoverABTestHelper.f216488d;
            GuildDiscoverABTestHelper.lastFetchTime = System.currentTimeMillis();
            GuildDiscoverABTestHelper.f216488d.t(this.$req, this.$onFinish, this.$source);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildDiscoverABTestHelper$fetchAbTest$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
