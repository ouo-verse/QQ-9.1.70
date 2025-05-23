package com.tencent.mobileqq.guild.share;

import com.tencent.mobileqq.qqguildsdk.data.genc.av;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/guild/share/z;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.share.GuildShareWrapper$fetchShareInfo$2$deferred2$1", f = "GuildShareWrapper.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
final class GuildShareWrapper$fetchShareInfo$2$deferred2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ShareInfoResult>, Object> {
    final /* synthetic */ long $channelIdLong;
    final /* synthetic */ long $guildIdLong;
    final /* synthetic */ av $longUrlReqInfo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildShareWrapper$fetchShareInfo$2$deferred2$1(long j3, long j16, av avVar, Continuation<? super GuildShareWrapper$fetchShareInfo$2$deferred2$1> continuation) {
        super(2, continuation);
        this.$guildIdLong = j3;
        this.$channelIdLong = j16;
        this.$longUrlReqInfo = avVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildShareWrapper$fetchShareInfo$2$deferred2$1(this.$guildIdLong, this.$channelIdLong, this.$longUrlReqInfo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            GuildShareWrapper guildShareWrapper = GuildShareWrapper.f234954a;
            long j3 = this.$guildIdLong;
            long j16 = this.$channelIdLong;
            av avVar = this.$longUrlReqInfo;
            this.label = 1;
            obj = guildShareWrapper.f(j3, j16, avVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ShareInfoResult> continuation) {
        return ((GuildShareWrapper$fetchShareInfo$2$deferred2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
