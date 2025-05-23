package com.tencent.mobileqq.guild.channel.joinchannel;

import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bv;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic$addGuild$2", f = "JoinGuildLogic.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class JoinGuildLogic$addGuild$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $businessType;
    final /* synthetic */ Function4<Integer, String, IGProSecurityResult, IGProJoinGuildResult, Unit> $callbackWrapper;
    final /* synthetic */ String $channelId;
    final /* synthetic */ String $guildId;
    final /* synthetic */ String $inviteCode;
    final /* synthetic */ JoinGuildLogic.JumpParam $joinAfterAction;
    final /* synthetic */ JumpGuildParam $param;
    int label;
    final /* synthetic */ JoinGuildLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public JoinGuildLogic$addGuild$2(String str, String str2, int i3, String str3, JumpGuildParam jumpGuildParam, JoinGuildLogic joinGuildLogic, JoinGuildLogic.JumpParam jumpParam, Function4<? super Integer, ? super String, ? super IGProSecurityResult, ? super IGProJoinGuildResult, Unit> function4, Continuation<? super JoinGuildLogic$addGuild$2> continuation) {
        super(2, continuation);
        this.$guildId = str;
        this.$channelId = str2;
        this.$businessType = i3;
        this.$inviteCode = str3;
        this.$param = jumpGuildParam;
        this.this$0 = joinGuildLogic;
        this.$joinAfterAction = jumpParam;
        this.$callbackWrapper = function4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function4 function4, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        function4.invoke(Integer.valueOf(i3), str, iGProSecurityResult, iGProJoinGuildResult);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new JoinGuildLogic$addGuild$2(this.$guildId, this.$channelId, this.$businessType, this.$inviteCode, this.$param, this.this$0, this.$joinAfterAction, this.$callbackWrapper, continuation);
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
            GuildMainFrameUtils guildMainFrameUtils = GuildMainFrameUtils.f227682a;
            String str = this.$guildId;
            String str2 = this.$channelId;
            int i16 = this.$businessType;
            String str3 = this.$inviteCode;
            this.label = 1;
            obj = guildMainFrameUtils.f(str, str2, i16, str3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp = (GuildMainFrameUtils.GuildAndChannelInfoRsp) obj;
        QLog.d("Guild.join.JoinGuildLogic", 1, "get final join sig: " + guildAndChannelInfoRsp.getJoinSig());
        this.$param.getJoinInfoParam().setJoinSignature(guildAndChannelInfoRsp.getJoinSig());
        JoinGuildLogic joinGuildLogic = this.this$0;
        JumpGuildParam jumpGuildParam = this.$param;
        JoinGuildLogic.JumpParam jumpParam = this.$joinAfterAction;
        final Function4<Integer, String, IGProSecurityResult, IGProJoinGuildResult, Unit> function4 = this.$callbackWrapper;
        joinGuildLogic.h(jumpGuildParam, jumpParam, new bv() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.d
            @Override // vh2.bv
            public final void a(int i17, String str4, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                JoinGuildLogic$addGuild$2.b(Function4.this, i17, str4, iGProSecurityResult, iGProJoinGuildResult);
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((JoinGuildLogic$addGuild$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
