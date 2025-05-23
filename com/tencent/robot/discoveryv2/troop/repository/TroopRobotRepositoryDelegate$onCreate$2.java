package com.tencent.robot.discoveryv2.troop.repository;

import com.tencent.robot.discoveryv2.common.data.SingleCategoryRsp;
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
/* loaded from: classes25.dex */
/* synthetic */ class TroopRobotRepositoryDelegate$onCreate$2 extends AdaptedFunctionReference implements Function2<SingleCategoryRsp, Continuation<? super Unit>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TroopRobotRepositoryDelegate$onCreate$2(Object obj) {
        super(2, obj, TroopRobotRepositoryDelegate.class, "onReceiveSingleCategoryData", "onReceiveSingleCategoryData(Lcom/tencent/robot/discoveryv2/common/data/SingleCategoryRsp;)V", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull SingleCategoryRsp singleCategoryRsp, @NotNull Continuation<? super Unit> continuation) {
        Object w3;
        w3 = TroopRobotRepositoryDelegate.w((TroopRobotRepositoryDelegate) this.receiver, singleCategoryRsp, continuation);
        return w3;
    }
}
