package com.tencent.filament.zplan.business.impl;

import com.tencent.luggage.wxa.uf.f;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082@"}, d2 = {"Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;", "avatarService", "Lorg/json/JSONObject;", "avatarInfo", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;", "continuation", "", "fetchAvatarWithCpp"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.business.impl.AbsBusinessScene", f = "AbsBusinessScene.kt", i = {0, 0, 0}, l = {f.CTRL_INDEX}, m = "fetchAvatarWithCpp", n = {"this", "statistic", "this_$iv"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes6.dex */
public final class AbsBusinessScene$fetchAvatarWithCpp$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AbsBusinessScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsBusinessScene$fetchAvatarWithCpp$1(AbsBusinessScene absBusinessScene, Continuation continuation) {
        super(continuation);
        this.this$0 = absBusinessScene;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchAvatarWithCpp(null, null, this);
    }
}
