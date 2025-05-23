package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildNewFeedPostDelegate;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPreloadGuildFeedsRsp;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildNewFeedPostDelegate$preloadGuildFeeds$3$2", f = "GuildNewFeedPostDelegate.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildNewFeedPostDelegate$preloadGuildFeeds$3$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $errMsg;
    final /* synthetic */ long $preloadBeginTime;
    final /* synthetic */ int $result;
    final /* synthetic */ GProPreloadGuildFeedsRsp $rsp;
    int label;
    final /* synthetic */ GuildNewFeedPostDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildNewFeedPostDelegate$preloadGuildFeeds$3$2(GProPreloadGuildFeedsRsp gProPreloadGuildFeedsRsp, GuildNewFeedPostDelegate guildNewFeedPostDelegate, long j3, int i3, String str, Continuation<? super GuildNewFeedPostDelegate$preloadGuildFeeds$3$2> continuation) {
        super(2, continuation);
        this.$rsp = gProPreloadGuildFeedsRsp;
        this.this$0 = guildNewFeedPostDelegate;
        this.$preloadBeginTime = j3;
        this.$result = i3;
        this.$errMsg = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildNewFeedPostDelegate$preloadGuildFeeds$3$2(this.$rsp, this.this$0, this.$preloadBeginTime, this.$result, this.$errMsg, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        GuildNewFeedPostDelegate.b bVar;
        long j3;
        byte[] bArr;
        long j16;
        long j17;
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
            GProPreloadGuildFeedsRsp rsp = this.$rsp;
            if (rsp != null) {
                int i16 = this.$result;
                GuildNewFeedPostDelegate guildNewFeedPostDelegate = this.this$0;
                String errMsg = this.$errMsg;
                if (i16 == 0) {
                    guildNewFeedPostDelegate.n(rsp);
                    guildNewFeedPostDelegate.o(rsp);
                    bVar = guildNewFeedPostDelegate.depends;
                    Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                    Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                    this.label = 1;
                    if (bVar.b(i16, errMsg, rsp, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        }
        this.this$0.lastTaskRunTime = System.currentTimeMillis();
        int i17 = 0;
        this.this$0.isTaskRunIng = false;
        Logger logger = Logger.f235387a;
        GuildNewFeedPostDelegate guildNewFeedPostDelegate2 = this.this$0;
        long j18 = this.$preloadBeginTime;
        Logger.a d16 = logger.d();
        j3 = guildNewFeedPostDelegate2.cdDuration;
        bArr = guildNewFeedPostDelegate2.token;
        if (bArr != null) {
            i17 = bArr.hashCode();
        }
        long j19 = guildNewFeedPostDelegate2.lastTaskRunTime;
        j16 = guildNewFeedPostDelegate2.lastNewFeedPostTime;
        d16.i("GuildNewFeedPostDelegate", 1, "preloadGuildFeeds rsp cdDuration:" + j3 + " token:" + i17 + " lastTaskRunTime:" + j19 + " lastNewFeedPostTime:" + j16 + " preloadBeginTime:" + j18);
        j17 = this.this$0.lastNewFeedPostTime;
        if (j17 > this.$preloadBeginTime) {
            this.this$0.r();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildNewFeedPostDelegate$preloadGuildFeeds$3$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
