package com.tencent.mobileqq.guild.feed.share.preview;

import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.share.preview.GuildFeedShareNormalPreviewContainer$newPicLoadListener$1$onStateChangeCallback$3", f = "GuildFeedShareNormalPreviewContainer.kt", i = {}, l = {365}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class GuildFeedShareNormalPreviewContainer$newPicLoadListener$1$onStateChangeCallback$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CompletableDeferred<ri1.a> $deferred;
    final /* synthetic */ Option $option;
    final /* synthetic */ long $timeoutMillis;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedShareNormalPreviewContainer$newPicLoadListener$1$onStateChangeCallback$3(long j3, CompletableDeferred<ri1.a> completableDeferred, Option option, Continuation<? super GuildFeedShareNormalPreviewContainer$newPicLoadListener$1$onStateChangeCallback$3> continuation) {
        super(2, continuation);
        this.$timeoutMillis = j3;
        this.$deferred = completableDeferred;
        this.$option = option;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFeedShareNormalPreviewContainer$newPicLoadListener$1$onStateChangeCallback$3(this.$timeoutMillis, this.$deferred, this.$option, continuation);
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
            long j3 = this.$timeoutMillis;
            this.label = 1;
            if (DelayKt.delay(j3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (this.$deferred.isActive() && !this.$deferred.isCompleted()) {
            Logger logger = Logger.f235387a;
            Option option = this.$option;
            Logger.b bVar = new Logger.b();
            String str = "[newPicLoadListener] onStateChangeCallback timeout " + option;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildFeedShareNormalPreviewContainer", 1, (String) it.next(), null);
            }
            CompletableDeferred<ri1.a> completableDeferred = this.$deferred;
            ri1.a c16 = ri1.a.c(-89, "loadImageAsync timeout", this.$option.getTargetView());
            Intrinsics.checkNotNullExpressionValue(c16, "error(GProStateCode.ERRO\u2026eout\", option.targetView)");
            completableDeferred.complete(c16);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedShareNormalPreviewContainer$newPicLoadListener$1$onStateChangeCallback$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
