package com.tencent.mobileqq.guild.media.widget.audiofaceview;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public /* synthetic */ class ColumnLayout$initStatusPriorityMap$2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ColumnLayout$initStatusPriorityMap$2(Object obj) {
        super(1, obj, ColumnLayout.class, "updateGameStatus", "updateGameStatus(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16) {
        ((ColumnLayout) this.receiver).C(z16);
    }
}
