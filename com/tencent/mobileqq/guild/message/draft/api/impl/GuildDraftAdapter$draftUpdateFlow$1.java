package com.tencent.mobileqq.guild.message.draft.api.impl;

import com.tencent.qqnt.msg.data.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public /* synthetic */ class GuildDraftAdapter$draftUpdateFlow$1 extends AdaptedFunctionReference implements Function2<c, Continuation<? super Unit>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildDraftAdapter$draftUpdateFlow$1(Object obj) {
        super(2, obj, GuildDraftAdapter.class, "executeDraftUpdateData", "executeDraftUpdateData(Lcom/tencent/qqnt/msg/data/DraftUpdateData;)V", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@Nullable c cVar, @NotNull Continuation<? super Unit> continuation) {
        Object e16;
        e16 = GuildDraftAdapter.e((GuildDraftAdapter) this.receiver, cVar, continuation);
        return e16;
    }
}
