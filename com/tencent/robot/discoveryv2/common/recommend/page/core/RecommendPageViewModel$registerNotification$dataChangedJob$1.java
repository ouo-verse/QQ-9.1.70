package com.tencent.robot.discoveryv2.common.recommend.page.core;

import com.tencent.robot.discoveryv2.common.data.RecommendRobotsData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public /* synthetic */ class RecommendPageViewModel$registerNotification$dataChangedJob$1 extends AdaptedFunctionReference implements Function2<RecommendRobotsData, Continuation<? super Unit>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RecommendPageViewModel$registerNotification$dataChangedJob$1(Object obj) {
        super(2, obj, RecommendPageViewModel.class, "categoryRobotsDataChanged", "categoryRobotsDataChanged(Lcom/tencent/robot/discoveryv2/common/data/RecommendRobotsData;)V", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull RecommendRobotsData recommendRobotsData, @NotNull Continuation<? super Unit> continuation) {
        Object h26;
        h26 = RecommendPageViewModel.h2((RecommendPageViewModel) this.receiver, recommendRobotsData, continuation);
        return h26;
    }
}
