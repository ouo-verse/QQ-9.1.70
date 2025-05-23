package com.tencent.mobileqq.guild.share.llmchat;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.qqui.g;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.share.llmchat.GuildLLMChatShareActionSheet$fetchArkInfo$2", f = "GuildLLMChatShareActionSheet.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class GuildLLMChatShareActionSheet$fetchArkInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<com.tencent.mobileqq.guild.share.b, Unit> $callback;
    final /* synthetic */ boolean $showError;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildLLMChatShareActionSheet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildLLMChatShareActionSheet$fetchArkInfo$2(GuildLLMChatShareActionSheet guildLLMChatShareActionSheet, boolean z16, Function1<? super com.tencent.mobileqq.guild.share.b, Unit> function1, Continuation<? super GuildLLMChatShareActionSheet$fetchArkInfo$2> continuation) {
        super(2, continuation);
        this.this$0 = guildLLMChatShareActionSheet;
        this.$showError = z16;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildLLMChatShareActionSheet$fetchArkInfo$2 guildLLMChatShareActionSheet$fetchArkInfo$2 = new GuildLLMChatShareActionSheet$fetchArkInfo$2(this.this$0, this.$showError, this.$callback, continuation);
        guildLLMChatShareActionSheet$fetchArkInfo$2.L$0 = obj;
        return guildLLMChatShareActionSheet$fetchArkInfo$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object m476constructorimpl;
        FetchLLMShareArkInfo fetchLLMShareArkInfo;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                GuildLLMChatShareActionSheet guildLLMChatShareActionSheet = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                fetchLLMShareArkInfo = guildLLMChatShareActionSheet.arkInfoFetcher;
                if (fetchLLMShareArkInfo == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("arkInfoFetcher");
                    fetchLLMShareArkInfo = null;
                }
                this.label = 1;
                obj = fetchLLMShareArkInfo.f(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            m476constructorimpl = Result.m476constructorimpl((com.tencent.mobileqq.guild.share.b) obj);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        boolean z16 = this.$showError;
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "fetchArk failed " + m479exceptionOrNullimpl.getMessage();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.share.GuildLLMChatShareActionSheet", 1, (String) it.next(), m479exceptionOrNullimpl);
            }
            if (z16 && !(m479exceptionOrNullimpl instanceof CancellationException)) {
                g.f(1, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~");
            }
        }
        Function1<com.tencent.mobileqq.guild.share.b, Unit> function1 = this.$callback;
        if (Result.m483isSuccessimpl(m476constructorimpl)) {
            com.tencent.mobileqq.guild.share.b bVar2 = (com.tencent.mobileqq.guild.share.b) m476constructorimpl;
            if (function1 != null) {
                function1.invoke(bVar2);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildLLMChatShareActionSheet$fetchArkInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
