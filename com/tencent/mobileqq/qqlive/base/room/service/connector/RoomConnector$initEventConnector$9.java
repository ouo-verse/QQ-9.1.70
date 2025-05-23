package com.tencent.mobileqq.qqlive.base.room.service.connector;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.base.room.service.event.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
/* synthetic */ class RoomConnector$initEventConnector$9 extends FunctionReferenceImpl implements Function1<d, Unit> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoomConnector$initEventConnector$9(Object obj) {
        super(1, obj, RoomConnector.class, "onOrientationChanged", "onOrientationChanged(Lcom/tencent/mobileqq/qqlive/base/room/service/event/OrientationChangedEvent;)V", 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(d dVar) {
        invoke2(dVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull d p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((RoomConnector) this.receiver).p(p06);
    }
}
