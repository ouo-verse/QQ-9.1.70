package com.tencent.robot.aio.bottombar.picture;

import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public /* synthetic */ class RobotPictureBarVB$initAdapter$2 extends FunctionReferenceImpl implements Function1<LocalMediaInfo, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RobotPictureBarVB$initAdapter$2(Object obj) {
        super(1, obj, RobotPictureBarVB.class, "onPictureBarItemSingleClear", "onPictureBarItemSingleClear(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LocalMediaInfo localMediaInfo) {
        invoke2(localMediaInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull LocalMediaInfo p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((RobotPictureBarVB) this.receiver).k1(p06);
    }
}
