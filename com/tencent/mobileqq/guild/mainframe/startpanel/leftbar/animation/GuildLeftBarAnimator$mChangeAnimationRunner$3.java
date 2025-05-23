package com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public /* synthetic */ class GuildLeftBarAnimator$mChangeAnimationRunner$3 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildLeftBarAnimator$mChangeAnimationRunner$3(Object obj) {
        super(0, obj, GuildLeftBarAnimator.class, "dispatchFinishedWhenDone", "dispatchFinishedWhenDone()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((GuildLeftBarAnimator) this.receiver).dispatchFinishedWhenDone();
    }
}
