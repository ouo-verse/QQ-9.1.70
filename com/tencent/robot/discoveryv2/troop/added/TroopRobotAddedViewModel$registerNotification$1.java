package com.tencent.robot.discoveryv2.troop.added;

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
/* loaded from: classes25.dex */
public /* synthetic */ class TroopRobotAddedViewModel$registerNotification$1 extends AdaptedFunctionReference implements Function2<AddedRobotsData, Continuation<? super Unit>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TroopRobotAddedViewModel$registerNotification$1(Object obj) {
        super(2, obj, TroopRobotAddedViewModel.class, "onAddedRobotsDataChanged", "onAddedRobotsDataChanged(Lcom/tencent/robot/discoveryv2/troop/added/AddedRobotsData;)V", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull AddedRobotsData addedRobotsData, @NotNull Continuation<? super Unit> continuation) {
        Object X1;
        X1 = TroopRobotAddedViewModel.X1((TroopRobotAddedViewModel) this.receiver, addedRobotsData, continuation);
        return X1;
    }
}
