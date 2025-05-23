package com.tencent.biz.qqcircle.immersive.personal.part;

import com.tencent.biz.qqcircle.immersive.personal.data.QFSTroopItemInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
/* synthetic */ class QFSProfileHostTroopPart$onInitView$1$1 extends FunctionReferenceImpl implements Function2<QFSTroopItemInfo, Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public QFSProfileHostTroopPart$onInitView$1$1(Object obj) {
        super(2, obj, QFSProfileHostTroopPart.class, "onTroopItemButtonClick", "onTroopItemButtonClick(Lcom/tencent/biz/qqcircle/immersive/personal/data/QFSTroopItemInfo;I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(QFSTroopItemInfo qFSTroopItemInfo, Integer num) {
        invoke(qFSTroopItemInfo, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull QFSTroopItemInfo p06, int i3) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((QFSProfileHostTroopPart) this.receiver).M9(p06, i3);
    }
}
