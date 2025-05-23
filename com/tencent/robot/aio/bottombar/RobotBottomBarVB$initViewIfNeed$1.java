package com.tencent.robot.aio.bottombar;

import com.tencent.robot.aio.bottombar.model.RobotBottomBarItemModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public /* synthetic */ class RobotBottomBarVB$initViewIfNeed$1 extends FunctionReferenceImpl implements Function1<RobotBottomBarItemModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RobotBottomBarVB$initViewIfNeed$1(Object obj) {
        super(1, obj, RobotBottomBarVB.class, "onBottomBarItemClick", "onBottomBarItemClick(Lcom/tencent/robot/aio/bottombar/model/RobotBottomBarItemModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RobotBottomBarItemModel robotBottomBarItemModel) {
        invoke2(robotBottomBarItemModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull RobotBottomBarItemModel p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((RobotBottomBarVB) this.receiver).l1(p06);
    }
}
