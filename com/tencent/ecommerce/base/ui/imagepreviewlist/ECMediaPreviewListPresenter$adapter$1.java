package com.tencent.ecommerce.base.ui.imagepreviewlist;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final /* synthetic */ class ECMediaPreviewListPresenter$adapter$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECMediaPreviewListPresenter$adapter$1(ECMediaPreviewListPresenter eCMediaPreviewListPresenter) {
        super(1, eCMediaPreviewListPresenter, ECMediaPreviewListPresenter.class, "onDelete", "onDelete(I)V", 0);
    }

    public final void invoke(int i3) {
        ((ECMediaPreviewListPresenter) this.receiver).h(i3);
    }
}
