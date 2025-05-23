package com.tencent.mobileqq.matchfriend.reborn.content.signal.base;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [State] */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
/* synthetic */ class QQStrangerSignalBasePart$onPartDestroy$1<State> extends FunctionReferenceImpl implements Function1<State, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke((c) obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QQStrangerSignalBasePart$onPartDestroy$1(Object obj) {
        super(1, obj, QQStrangerSignalBasePart.class, "handleUIState", "handleUIState(Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/base/QQStrangerSignalBaseState;)V", 0);
    }

    /* JADX WARN: Incorrect types in method signature: (TState;)V */
    public final void invoke(c p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((QQStrangerSignalBasePart) this.receiver).B9(p06);
    }
}
