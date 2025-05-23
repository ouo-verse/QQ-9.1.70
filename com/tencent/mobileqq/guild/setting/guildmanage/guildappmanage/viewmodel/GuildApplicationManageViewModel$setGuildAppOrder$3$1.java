package com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.viewmodel;

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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.viewmodel.GuildApplicationManageViewModel$setGuildAppOrder$3$1", f = "GuildApplicationManageViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
final class GuildApplicationManageViewModel$setGuildAppOrder$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $errMsg;
    final /* synthetic */ int $result;
    final /* synthetic */ Function2<Boolean, String, Unit> $resultFun;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildApplicationManageViewModel$setGuildAppOrder$3$1(Function2<? super Boolean, ? super String, Unit> function2, int i3, String str, Continuation<? super GuildApplicationManageViewModel$setGuildAppOrder$3$1> continuation) {
        super(2, continuation);
        this.$resultFun = function2;
        this.$result = i3;
        this.$errMsg = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildApplicationManageViewModel$setGuildAppOrder$3$1(this.$resultFun, this.$result, this.$errMsg, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z16;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<Boolean, String, Unit> function2 = this.$resultFun;
            if (this.$result == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Boolean boxBoolean = Boxing.boxBoolean(z16);
            String errMsg = this.$errMsg;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            function2.invoke(boxBoolean, errMsg);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildApplicationManageViewModel$setGuildAppOrder$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
