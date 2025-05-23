package com.tencent.state.square;

import com.tencent.state.square.data.SquareAvatarItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "result", "Lcom/tencent/state/square/data/SquareAvatarItem;", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
final class SquareAreaRankAdapter$updateUnreadMessage$1 extends Lambda implements Function1<SquareAvatarItem, Unit> {
    final /* synthetic */ SquareAreaRankAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SquareAreaRankAdapter$updateUnreadMessage$1(SquareAreaRankAdapter squareAreaRankAdapter) {
        super(1);
        this.this$0 = squareAreaRankAdapter;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SquareAvatarItem squareAvatarItem) {
        invoke2(squareAvatarItem);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SquareAvatarItem result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.this$0.onUpdateSquareItem(result);
    }
}
