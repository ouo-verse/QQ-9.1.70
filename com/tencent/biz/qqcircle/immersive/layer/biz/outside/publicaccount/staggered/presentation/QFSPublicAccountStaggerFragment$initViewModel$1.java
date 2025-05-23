package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation;

import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public /* synthetic */ class QFSPublicAccountStaggerFragment$initViewModel$1 extends FunctionReferenceImpl implements Function1<UIStateData<List<? extends e30.b>>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public QFSPublicAccountStaggerFragment$initViewModel$1(Object obj) {
        super(1, obj, QFSPublicAccountStaggerFragment.class, "handleUIState", "handleUIState(Lcom/tencent/richframework/data/base/UIStateData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends e30.b>> uIStateData) {
        invoke2((UIStateData<List<e30.b>>) uIStateData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull UIStateData<List<e30.b>> p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((QFSPublicAccountStaggerFragment) this.receiver).Xh(p06);
    }
}
