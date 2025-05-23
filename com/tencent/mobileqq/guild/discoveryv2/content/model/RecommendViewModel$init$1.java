package com.tencent.mobileqq.guild.discoveryv2.content.model;

import com.tencent.mobileqq.guild.discoveryv2.RecommendAdMessage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
/* synthetic */ class RecommendViewModel$init$1 extends AdaptedFunctionReference implements Function2<RecommendAdMessage, Continuation<? super Unit>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RecommendViewModel$init$1(Object obj) {
        super(2, obj, rh1.a.class, "handleMessage", "handleMessage(Lcom/tencent/mobileqq/guild/discoveryv2/RecommendAdMessage;)V", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull RecommendAdMessage recommendAdMessage, @NotNull Continuation<? super Unit> continuation) {
        Object l26;
        l26 = RecommendViewModel.l2((rh1.a) this.receiver, recommendAdMessage, continuation);
        return l26;
    }
}
