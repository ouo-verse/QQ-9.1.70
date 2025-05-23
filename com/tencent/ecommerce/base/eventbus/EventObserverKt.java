package com.tencent.ecommerce.base.eventbus;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a4\u0010\b\u001a\u00020\u0007\"\f\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00032\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u00a8\u0006\t"}, d2 = {"", "Lcom/tencent/ecommerce/base/eventbus/EVENT;", "T", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "event", "Lcom/tencent/ecommerce/base/eventbus/ThreadMode;", "threadMode", "", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class EventObserverKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void a(final EventObserver<T> eventObserver, final Object obj, final ThreadMode threadMode) {
        if (!(obj instanceof Object)) {
            obj = null;
        }
        if (obj != null) {
            if (threadMode == ThreadMode.MAIN) {
                ThreadManager.f100693b.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.base.eventbus.EventObserverKt$dispatchEvent$$inlined$let$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        eventObserver.onEvent(obj);
                    }
                });
            } else {
                eventObserver.onEvent(obj);
            }
        }
    }
}
