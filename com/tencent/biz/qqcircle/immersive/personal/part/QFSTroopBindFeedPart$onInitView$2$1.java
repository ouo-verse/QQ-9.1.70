package com.tencent.biz.qqcircle.immersive.personal.part;

import com.tencent.biz.qqcircle.immersive.personal.data.QFSTroopItemInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
/* synthetic */ class QFSTroopBindFeedPart$onInitView$2$1 extends FunctionReferenceImpl implements Function1<QFSTroopItemInfo, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public QFSTroopBindFeedPart$onInitView$2$1(Object obj) {
        super(1, obj, QFSTroopBindFeedPart.class, "onItemClick", "onItemClick(Lcom/tencent/biz/qqcircle/immersive/personal/data/QFSTroopItemInfo;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(QFSTroopItemInfo qFSTroopItemInfo) {
        invoke2(qFSTroopItemInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull QFSTroopItemInfo p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((QFSTroopBindFeedPart) this.receiver).Q9(p06);
    }
}
