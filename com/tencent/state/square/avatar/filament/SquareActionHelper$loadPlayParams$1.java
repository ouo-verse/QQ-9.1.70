package com.tencent.state.square.avatar.filament;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000*\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u001e\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00060\u0005H\u0096@"}, d2 = {"", "hostUin", "guestUin", "", "url", "Lkotlin/coroutines/Continuation;", "Lkotlin/Triple;", "Lcom/tencent/state/square/avatar/filament/MoodConfig;", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "Lcom/tencent/state/square/avatar/filament/LoadFilamentAssetsStatistics;", "continuation", "", "loadPlayParams"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.state.square.avatar.filament.SquareActionHelper", f = "SquareActionHelper.kt", i = {0, 0}, l = {32}, m = "loadPlayParams", n = {"guestUin", "hostUin"}, s = {"L$0", "J$0"})
/* loaded from: classes38.dex */
public final class SquareActionHelper$loadPlayParams$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SquareActionHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareActionHelper$loadPlayParams$1(SquareActionHelper squareActionHelper, Continuation continuation) {
        super(continuation);
        this.this$0 = squareActionHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadPlayParams(0L, null, null, this);
    }
}
