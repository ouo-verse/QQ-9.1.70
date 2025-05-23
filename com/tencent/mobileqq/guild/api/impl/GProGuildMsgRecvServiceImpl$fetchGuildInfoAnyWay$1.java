package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.api.impl.GProGuildMsgRecvServiceImpl$fetchGuildInfoAnyWay$1", f = "GProGuildMsgRecvServiceImpl.kt", i = {}, l = {419}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class GProGuildMsgRecvServiceImpl$fetchGuildInfoAnyWay$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IGProGuildInfo>, Object> {
    final /* synthetic */ String $guildId;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GProGuildMsgRecvServiceImpl$fetchGuildInfoAnyWay$1(String str, Continuation<? super GProGuildMsgRecvServiceImpl$fetchGuildInfoAnyWay$1> continuation) {
        super(2, continuation);
        this.$guildId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GProGuildMsgRecvServiceImpl$fetchGuildInfoAnyWay$1(this.$guildId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Continuation intercepted;
        Object coroutine_suspended2;
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
            QLog.d(GProGuildMsgRecvServiceImpl.TAG, 1, "fetchGuildInfoAnyWay");
            String str = this.$guildId;
            this.L$0 = str;
            this.label = 1;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            GuildMainFrameUtils.k(str, new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.api.impl.GProGuildMsgRecvServiceImpl$fetchGuildInfoAnyWay$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                    invoke2(iGProGuildInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                    QLog.d(GProGuildMsgRecvServiceImpl.TAG, 1, "fetchGuildInfoAnyWay guildInfo == null:" + (iGProGuildInfo == null));
                    cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(iGProGuildInfo));
                }
            });
            obj = cancellableContinuationImpl.getResult();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (obj == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super IGProGuildInfo> continuation) {
        return ((GProGuildMsgRecvServiceImpl$fetchGuildInfoAnyWay$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
