package com.tencent.mobileqq.icgame.base.room.service.connector;

import i22.ActivityLifecycleEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
/* synthetic */ class RoomConnector$initEventConnector$1 extends FunctionReferenceImpl implements Function1<ActivityLifecycleEvent, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RoomConnector$initEventConnector$1(Object obj) {
        super(1, obj, RoomConnector.class, "onActivityLifecycleEvent", "onActivityLifecycleEvent(Lcom/tencent/mobileqq/icgame/base/room/service/event/ActivityLifecycleEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ActivityLifecycleEvent activityLifecycleEvent) {
        invoke2(activityLifecycleEvent);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull ActivityLifecycleEvent p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((RoomConnector) this.receiver).h(p06);
    }
}
