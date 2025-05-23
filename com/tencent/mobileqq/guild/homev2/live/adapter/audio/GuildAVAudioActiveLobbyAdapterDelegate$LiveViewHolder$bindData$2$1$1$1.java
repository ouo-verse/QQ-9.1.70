package com.tencent.mobileqq.guild.homev2.live.adapter.audio;

import android.graphics.Bitmap;
import com.tencent.mobileqq.guild.homev2.live.adapter.audio.GuildAVAudioActiveLobbyAdapterDelegate;
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
import pp1.GuildAVAudioActiveLobbyUIData;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.live.adapter.audio.GuildAVAudioActiveLobbyAdapterDelegate$LiveViewHolder$bindData$2$1$1$1", f = "GuildAVAudioActiveLobbyAdapterDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildAVAudioActiveLobbyAdapterDelegate$LiveViewHolder$bindData$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ GuildAVAudioActiveLobbyUIData $item;
    int label;
    final /* synthetic */ GuildAVAudioActiveLobbyAdapterDelegate.LiveViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAVAudioActiveLobbyAdapterDelegate$LiveViewHolder$bindData$2$1$1$1(GuildAVAudioActiveLobbyAdapterDelegate.LiveViewHolder liveViewHolder, GuildAVAudioActiveLobbyUIData guildAVAudioActiveLobbyUIData, Bitmap bitmap, Continuation<? super GuildAVAudioActiveLobbyAdapterDelegate$LiveViewHolder$bindData$2$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = liveViewHolder;
        this.$item = guildAVAudioActiveLobbyUIData;
        this.$bitmap = bitmap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildAVAudioActiveLobbyAdapterDelegate$LiveViewHolder$bindData$2$1$1$1(this.this$0, this.$item, this.$bitmap, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.E(this.$item.getCoverUrl(), this.$bitmap);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildAVAudioActiveLobbyAdapterDelegate$LiveViewHolder$bindData$2$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
