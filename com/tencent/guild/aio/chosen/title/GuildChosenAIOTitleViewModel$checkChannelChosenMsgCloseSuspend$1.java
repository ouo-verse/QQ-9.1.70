package com.tencent.guild.aio.chosen.title;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.guild.aio.chosen.title.GuildChosenAIOTitleViewModel", f = "GuildChosenAIOTitleViewModel.kt", i = {}, l = {157}, m = "checkChannelChosenMsgCloseSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildChosenAIOTitleViewModel$checkChannelChosenMsgCloseSuspend$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuildChosenAIOTitleViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildChosenAIOTitleViewModel$checkChannelChosenMsgCloseSuspend$1(GuildChosenAIOTitleViewModel guildChosenAIOTitleViewModel, Continuation<? super GuildChosenAIOTitleViewModel$checkChannelChosenMsgCloseSuspend$1> continuation) {
        super(continuation);
        this.this$0 = guildChosenAIOTitleViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object t16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        t16 = this.this$0.t(this);
        return t16;
    }
}
