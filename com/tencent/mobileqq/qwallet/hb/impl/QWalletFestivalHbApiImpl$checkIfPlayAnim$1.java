package com.tencent.mobileqq.qwallet.hb.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tk2.FestivalHbData;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public /* synthetic */ class QWalletFestivalHbApiImpl$checkIfPlayAnim$1 extends FunctionReferenceImpl implements Function1<FestivalHbData.Anim, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public QWalletFestivalHbApiImpl$checkIfPlayAnim$1(Object obj) {
        super(1, obj, QWalletFestivalHbApiImpl.class, "playBgAndFgAnim", "playBgAndFgAnim(Lcom/tencent/mobileqq/qwallet/data/FestivalHbData$Anim;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FestivalHbData.Anim anim) {
        invoke2(anim);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull FestivalHbData.Anim p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((QWalletFestivalHbApiImpl) this.receiver).playBgAndFgAnim(p06);
    }
}
