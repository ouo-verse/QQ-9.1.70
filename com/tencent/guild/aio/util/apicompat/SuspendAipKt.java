package com.tencent.guild.aio.util.apicompat;

import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qqnt.msg.api.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bh;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a-\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "", "guildId", "channelId", "Lcom/tencent/qqnt/msg/api/c;", "", "a", "(Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class SuspendAipKt {
    @Nullable
    public static final Object a(@NotNull IGPSService iGPSService, @NotNull String str, @NotNull String str2, @NotNull Continuation<? super c<Boolean>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        iGPSService.getChannelTopMsgState(str, str2, new bh() { // from class: com.tencent.guild.aio.util.apicompat.SuspendAipKt$getChannelTopMsgStateSuspend$2$1
            @Override // vh2.bh
            public final void onResult(int i3, String errMsg, boolean z16) {
                Boolean valueOf = Boolean.valueOf(z16);
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                cancellableContinuationImpl.resume(new c<>(valueOf, i3, errMsg), new Function1<Throwable, Unit>() { // from class: com.tencent.guild.aio.util.apicompat.SuspendAipKt$getChannelTopMsgStateSuspend$2$1.1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Throwable it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                        invoke2(th5);
                        return Unit.INSTANCE;
                    }
                });
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
