package com.tencent.mobileqq.guild.homev2.misc;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class GuildHomeV2FragmentBehavior$slideRightExitBehaviorHelper$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildHomeV2FragmentBehavior$slideRightExitBehaviorHelper$1$1(Object obj) {
        super(0, obj, GuildHomeV2FragmentBehavior.class, "onSlideRight", "onSlideRight()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((GuildHomeV2FragmentBehavior) this.receiver).w();
    }
}
