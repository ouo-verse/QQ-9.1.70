package com.tencent.mobileqq.guild.discover;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBottomTabExpData;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.discover.GuildDiscoverABTestHelper$fetchGuildBottomTabExp$1$1", f = "GuildDiscoverABTestHelper.kt", i = {}, l = {267}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildDiscoverABTestHelper$fetchGuildBottomTabExp$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $errMsg;
    final /* synthetic */ IGProGuildBottomTabExpData $expData;
    final /* synthetic */ Function2<Boolean, String, Unit> $onFinish;
    final /* synthetic */ int $result;
    final /* synthetic */ String $source;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildDiscoverABTestHelper$fetchGuildBottomTabExp$1$1(int i3, IGProGuildBottomTabExpData iGProGuildBottomTabExpData, Function2<? super Boolean, ? super String, Unit> function2, String str, String str2, Continuation<? super GuildDiscoverABTestHelper$fetchGuildBottomTabExp$1$1> continuation) {
        super(2, continuation);
        this.$result = i3;
        this.$expData = iGProGuildBottomTabExpData;
        this.$onFinish = function2;
        this.$errMsg = str;
        this.$source = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildDiscoverABTestHelper$fetchGuildBottomTabExp$1$1(this.$result, this.$expData, this.$onFinish, this.$errMsg, this.$source, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IGProGuildBottomTabExpData expData;
        Object A;
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
            GuildDiscoverABTestHelper.loading = false;
            if (this.$result == 0 && (expData = this.$expData) != null) {
                GuildDiscoverABTestHelper guildDiscoverABTestHelper = GuildDiscoverABTestHelper.f216488d;
                Intrinsics.checkNotNullExpressionValue(expData, "expData");
                String str = this.$source;
                this.label = 1;
                A = guildDiscoverABTestHelper.A(expData, str, this);
                if (A == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                Function2<Boolean, String, Unit> function2 = this.$onFinish;
                if (function2 != null) {
                    Boolean boxBoolean = Boxing.boxBoolean(false);
                    String errMsg = this.$errMsg;
                    Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                    function2.invoke(boxBoolean, errMsg);
                }
                Logger logger = Logger.f235387a;
                String str2 = this.$source;
                int i16 = this.$result;
                String str3 = this.$errMsg;
                Logger.b bVar = new Logger.b();
                String str4 = "fetchGuildBottomTabExp " + str2 + " error , result: " + i16 + ", errMsg: " + str3;
                if (str4 instanceof String) {
                    bVar.a().add(str4);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.discovery.GuildDiscoverABTestHelper", 1, (String) it.next(), null);
                }
                return Unit.INSTANCE;
            }
        }
        Function2<Boolean, String, Unit> function22 = this.$onFinish;
        if (function22 != null) {
            Boolean boxBoolean2 = Boxing.boxBoolean(true);
            String errMsg2 = this.$errMsg;
            Intrinsics.checkNotNullExpressionValue(errMsg2, "errMsg");
            function22.invoke(boxBoolean2, errMsg2);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildDiscoverABTestHelper$fetchGuildBottomTabExp$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
