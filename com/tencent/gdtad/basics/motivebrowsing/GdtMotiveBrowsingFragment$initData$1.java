package com.tencent.gdtad.basics.motivebrowsing;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public /* synthetic */ class GdtMotiveBrowsingFragment$initData$1 extends FunctionReferenceImpl implements Function1<MotiveBrowsingData, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GdtMotiveBrowsingFragment$initData$1(Object obj) {
        super(1, obj, GdtMotiveBrowsingFragment.class, "handleMotiveBrowsingData", "handleMotiveBrowsingData(Lcom/tencent/gdtad/basics/motivebrowsing/MotiveBrowsingData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MotiveBrowsingData motiveBrowsingData) {
        invoke2(motiveBrowsingData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull MotiveBrowsingData p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((GdtMotiveBrowsingFragment) this.receiver).Eh(p06);
    }
}
