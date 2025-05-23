package com.tencent.mobileqq.qwallet.hb.impl;

import com.tencent.mobileqq.qwallet.hb.send.PanelEntryData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
/* synthetic */ class PanelDataChecker$mTypeCheckerMap$5 extends FunctionReferenceImpl implements Function2<Integer, PanelEntryData, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PanelDataChecker$mTypeCheckerMap$5(Object obj) {
        super(2, obj, PanelDataChecker.class, "verifyExclusiveRedPkg", "verifyExclusiveRedPkg(Ljava/lang/Integer;Lcom/tencent/mobileqq/qwallet/hb/send/PanelEntryData;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    @NotNull
    public final Boolean invoke(@Nullable Integer num, @NotNull PanelEntryData p16) {
        boolean h16;
        Intrinsics.checkNotNullParameter(p16, "p1");
        h16 = ((PanelDataChecker) this.receiver).h(num, p16);
        return Boolean.valueOf(h16);
    }
}
