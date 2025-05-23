package com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.rightlist.cover;

import com.tencent.mobileqq.guild.home.views.GuildHomeCoverBelowList;
import com.tencent.mobileqq.guild.util.ch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.rightlist.cover.GuildCoverViewModel$realActiveGuild$1", f = "GuildCoverViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class GuildCoverViewModel$realActiveGuild$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $guildId;
    int label;
    final /* synthetic */ GuildCoverViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildCoverViewModel$realActiveGuild$1(GuildCoverViewModel guildCoverViewModel, String str, Continuation<? super GuildCoverViewModel$realActiveGuild$1> continuation) {
        super(2, continuation);
        this.this$0 = guildCoverViewModel;
        this.$guildId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildCoverViewModel$realActiveGuild$1(this.this$0, this.$guildId, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        GuildHomeCoverBelowList guildHomeCoverBelowList;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0._guildInfo.setValue(ch.L(this.$guildId));
            WeakReference weakReference = this.this$0.bannerViewRef;
            if (weakReference != null && (guildHomeCoverBelowList = (GuildHomeCoverBelowList) weakReference.get()) != null) {
                this.this$0.a2(guildHomeCoverBelowList);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildCoverViewModel$realActiveGuild$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
