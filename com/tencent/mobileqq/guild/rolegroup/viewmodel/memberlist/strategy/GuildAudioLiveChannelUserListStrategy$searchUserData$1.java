package com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy;

import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.GuildAudioLiveChannelUserListStrategy$searchUserData$1", f = "GuildAudioLiveChannelUserListStrategy.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
final class GuildAudioLiveChannelUserListStrategy$searchUserData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $text;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildAudioLiveChannelUserListStrategy this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAudioLiveChannelUserListStrategy$searchUserData$1(GuildAudioLiveChannelUserListStrategy guildAudioLiveChannelUserListStrategy, String str, Continuation<? super GuildAudioLiveChannelUserListStrategy$searchUserData$1> continuation) {
        super(2, continuation);
        this.this$0 = guildAudioLiveChannelUserListStrategy;
        this.$text = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildAudioLiveChannelUserListStrategy$searchUserData$1 guildAudioLiveChannelUserListStrategy$searchUserData$1 = new GuildAudioLiveChannelUserListStrategy$searchUserData$1(this.this$0, this.$text, continuation);
        guildAudioLiveChannelUserListStrategy$searchUserData$1.L$0 = obj;
        return guildAudioLiveChannelUserListStrategy$searchUserData$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        WeakReference weakReference;
        Deferred async$default;
        jy1.a aVar;
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
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            weakReference = this.this$0.searchRequest;
            Deferred deferred = (Deferred) weakReference.get();
            if (deferred != null) {
                Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
            }
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, this.this$0.getIoDispatcher(), null, new GuildAudioLiveChannelUserListStrategy$searchUserData$1$result$1(this.this$0, this.$text, null), 2, null);
            this.this$0.searchRequest = new WeakReference(async$default);
            this.label = 1;
            obj = async$default.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        aVar = this.this$0.viewModel;
        aVar.s2((List) obj);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildAudioLiveChannelUserListStrategy$searchUserData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
