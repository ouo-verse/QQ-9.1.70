package com.tencent.mobileqq.guild.discover;

import com.google.gson.Gson;
import com.tencent.mobileqq.guild.discover.GuildDiscoverABTestHelper;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBottomTabExpData;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.discover.GuildDiscoverABTestHelper$handleTabExpData$2", f = "GuildDiscoverABTestHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildDiscoverABTestHelper$handleTabExpData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGProGuildBottomTabExpData $tabExpData;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildDiscoverABTestHelper$handleTabExpData$2(IGProGuildBottomTabExpData iGProGuildBottomTabExpData, Continuation<? super GuildDiscoverABTestHelper$handleTabExpData$2> continuation) {
        super(2, continuation);
        this.$tabExpData = iGProGuildBottomTabExpData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildDiscoverABTestHelper$handleTabExpData$2(this.$tabExpData, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            bw bwVar = bw.f235485a;
            String json = new Gson().toJson(new GuildDiscoverABTestHelper.ExpDataForCacheSave(this.$tabExpData));
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(ExpDataForCacheSave(tabExpData))");
            bwVar.V0(json);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildDiscoverABTestHelper$handleTabExpData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
