package com.tencent.mobileqq.guild.discover;

import com.google.gson.Gson;
import com.tencent.mobileqq.guild.discover.GuildDiscoverABTestHelper;
import com.tencent.mobileqq.guild.util.bw;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.discover.GuildDiscoverABTestHelper$clearNewUserData$1", f = "GuildDiscoverABTestHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildDiscoverABTestHelper$clearNewUserData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GuildDiscoverABTestHelper.ExpDataForCacheSave $cacheData;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildDiscoverABTestHelper$clearNewUserData$1(GuildDiscoverABTestHelper.ExpDataForCacheSave expDataForCacheSave, Continuation<? super GuildDiscoverABTestHelper$clearNewUserData$1> continuation) {
        super(2, continuation);
        this.$cacheData = expDataForCacheSave;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildDiscoverABTestHelper$clearNewUserData$1(this.$cacheData, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            bw bwVar = bw.f235485a;
            String json = new Gson().toJson(new GuildDiscoverABTestHelper.ExpDataForCacheSave(this.$cacheData));
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(ExpDataForCacheSave(cacheData))");
            bwVar.V0(json);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildDiscoverABTestHelper$clearNewUserData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
