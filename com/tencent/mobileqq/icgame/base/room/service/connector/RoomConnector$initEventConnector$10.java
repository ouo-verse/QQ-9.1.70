package com.tencent.mobileqq.icgame.base.room.service.connector;

import i22.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
/* synthetic */ class RoomConnector$initEventConnector$10 extends FunctionReferenceImpl implements Function1<i, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RoomConnector$initEventConnector$10(Object obj) {
        super(1, obj, RoomConnector.class, "setParentFragment", "setParentFragment(Lcom/tencent/mobileqq/icgame/base/room/service/event/SetFragmentEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(i iVar) {
        invoke2(iVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull i p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((RoomConnector) this.receiver).D(p06);
    }
}
