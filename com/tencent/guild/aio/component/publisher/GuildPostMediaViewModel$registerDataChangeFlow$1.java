package com.tencent.guild.aio.component.publisher;

import com.tencent.guild.api.media.album.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"", "Lcom/tencent/guild/api/media/album/e;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.component.publisher.GuildPostMediaViewModel$registerDataChangeFlow$1", f = "GuildPostMediaViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class GuildPostMediaViewModel$registerDataChangeFlow$1 extends SuspendLambda implements Function2<List<? extends e>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildPostMediaViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildPostMediaViewModel$registerDataChangeFlow$1(GuildPostMediaViewModel guildPostMediaViewModel, Continuation<? super GuildPostMediaViewModel$registerDataChangeFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = guildPostMediaViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildPostMediaViewModel$registerDataChangeFlow$1 guildPostMediaViewModel$registerDataChangeFlow$1 = new GuildPostMediaViewModel$registerDataChangeFlow$1(this.this$0, continuation);
        guildPostMediaViewModel$registerDataChangeFlow$1.L$0 = obj;
        return guildPostMediaViewModel$registerDataChangeFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.p((List) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull List<? extends e> list, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildPostMediaViewModel$registerDataChangeFlow$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
