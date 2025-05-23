package com.tencent.mobileqq.qwallet.hb.send.impl;

import bl2.HbSkinInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public /* synthetic */ class HbSkinListFragment$initView$1 extends FunctionReferenceImpl implements Function1<HbSkinInfo, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HbSkinListFragment$initView$1(Object obj) {
        super(1, obj, HbSkinListFragment.class, "onDeleteSkin", "onDeleteSkin(Lcom/tencent/mobileqq/qwallet/hb/send/busylogic/impl/HbSkinInfo;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HbSkinInfo hbSkinInfo) {
        invoke2(hbSkinInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull HbSkinInfo p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((HbSkinListFragment) this.receiver).Qh(p06);
    }
}
