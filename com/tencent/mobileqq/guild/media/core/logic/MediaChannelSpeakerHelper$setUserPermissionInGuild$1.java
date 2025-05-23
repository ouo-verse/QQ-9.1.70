package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.mobileqq.guild.media.core.CommonRsp;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.core.logic.MediaChannelSpeakerHelper$setUserPermissionInGuild$1", f = "MediaChannelSpeakerHelper.kt", i = {}, l = {327}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
final class MediaChannelSpeakerHelper$setUserPermissionInGuild$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $bAllow;
    final /* synthetic */ com.tencent.mobileqq.guild.media.core.i $cb;
    final /* synthetic */ long $channelId;
    final /* synthetic */ long $guildId;
    final /* synthetic */ long $tinyId;
    int label;
    final /* synthetic */ MediaChannelSpeakerHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaChannelSpeakerHelper$setUserPermissionInGuild$1(MediaChannelSpeakerHelper mediaChannelSpeakerHelper, long j3, long j16, long j17, boolean z16, com.tencent.mobileqq.guild.media.core.i iVar, Continuation<? super MediaChannelSpeakerHelper$setUserPermissionInGuild$1> continuation) {
        super(2, continuation);
        this.this$0 = mediaChannelSpeakerHelper;
        this.$guildId = j3;
        this.$channelId = j16;
        this.$tinyId = j17;
        this.$bAllow = z16;
        this.$cb = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MediaChannelSpeakerHelper$setUserPermissionInGuild$1(this.this$0, this.$guildId, this.$channelId, this.$tinyId, this.$bAllow, this.$cb, continuation);
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
            MediaChannelSpeakerHelper mediaChannelSpeakerHelper = this.this$0;
            long j3 = this.$guildId;
            long j16 = this.$channelId;
            long j17 = this.$tinyId;
            boolean z16 = this.$bAllow;
            this.label = 1;
            obj = mediaChannelSpeakerHelper.A(j3, j16, j17, z16, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        CommonRsp commonRsp = (CommonRsp) obj;
        com.tencent.mobileqq.guild.media.core.i iVar = this.$cb;
        if (iVar != null) {
            iVar.onResult(commonRsp.getCode(), commonRsp.getMsg());
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MediaChannelSpeakerHelper$setUserPermissionInGuild$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
