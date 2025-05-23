package com.tencent.mobileqq.guild.homev2.viewmodels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.viewmodels.GuildTabsViewModel", f = "GuildTabsViewModel.kt", i = {0}, l = {75}, m = "getGuildHomeItems", n = {"$this$getGuildHomeItems"}, s = {"L$0"})
/* loaded from: classes13.dex */
public final class GuildTabsViewModel$getGuildHomeItems$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuildTabsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTabsViewModel$getGuildHomeItems$1(GuildTabsViewModel guildTabsViewModel, Continuation<? super GuildTabsViewModel$getGuildHomeItems$1> continuation) {
        super(continuation);
        this.this$0 = guildTabsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object T1;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        T1 = this.this$0.T1(null, this);
        return T1;
    }
}
