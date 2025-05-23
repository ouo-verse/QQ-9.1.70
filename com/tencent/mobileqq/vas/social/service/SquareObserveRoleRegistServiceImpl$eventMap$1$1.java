package com.tencent.mobileqq.vas.social.service;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.role.logic.CreateRoleEvent;
import com.tencent.state.square.guide.SquareRolePageResultEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleEvent;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
final class SquareObserveRoleRegistServiceImpl$eventMap$1$1 extends Lambda implements Function1<CreateRoleEvent, Unit> {
    public static final SquareObserveRoleRegistServiceImpl$eventMap$1$1 INSTANCE = new SquareObserveRoleRegistServiceImpl$eventMap$1$1();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CreateRoleEvent it) {
        Intrinsics.checkNotNullParameter(it, "$it");
        QLog.i("SquareObserveRoleRegistServiceImpl", 1, "[NoviceGuide] dispatch SquareRolePageResultEvent");
        SimpleEventBus.getInstance().dispatchEvent(new SquareRolePageResultEvent(it.getSuccess()));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CreateRoleEvent createRoleEvent) {
        invoke2(createRoleEvent);
        return Unit.INSTANCE;
    }

    SquareObserveRoleRegistServiceImpl$eventMap$1$1() {
        super(1);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final CreateRoleEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        QLog.i("SquareObserveRoleRegistServiceImpl", 1, "[NoviceGuide] receive CreateRoleEvent: " + it.getSuccess() + ", " + it.getNewCreate());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.social.service.a
            @Override // java.lang.Runnable
            public final void run() {
                SquareObserveRoleRegistServiceImpl$eventMap$1$1.b(CreateRoleEvent.this);
            }
        });
    }
}
