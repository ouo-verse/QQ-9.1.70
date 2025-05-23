package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.event.TouchParams;
import com.tencent.kuikly.core.views.internal.GroupEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\u0007\u001a\u00020\u00042\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016J \u0010\b\u001a\u00020\u00042\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016J \u0010\t\u001a\u00020\u00042\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/kuikly/core/views/u;", "Lcom/tencent/kuikly/core/views/internal/GroupEvent;", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/event/k;", "", "Lcom/tencent/kuikly/core/views/internal/TouchEventHandlerFn;", "handler", "touchDown", "touchUp", "touchMove", "Lkotlin/Function0;", "handlerFn", "screenFrame", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class u extends GroupEvent {
    @Override // com.tencent.kuikly.core.views.internal.GroupEvent
    public void screenFrame(Function0<Unit> handlerFn) {
        Intrinsics.checkNotNullParameter(handlerFn, "handlerFn");
        super.screenFrame(handlerFn);
    }

    @Override // com.tencent.kuikly.core.views.internal.GroupEvent
    public void touchDown(Function1<? super TouchParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        super.touchDown(handler);
    }

    @Override // com.tencent.kuikly.core.views.internal.GroupEvent
    public void touchMove(Function1<? super TouchParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        super.touchMove(handler);
    }

    @Override // com.tencent.kuikly.core.views.internal.GroupEvent
    public void touchUp(Function1<? super TouchParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        super.touchUp(handler);
    }
}
