package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center;

import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes37.dex */
public final class QQFTCenterFileSetCardViewKt$showSharePanel$1 extends Lambda implements Function1<e, Unit> {
    public static final QQFTCenterFileSetCardViewKt$showSharePanel$1 INSTANCE = new QQFTCenterFileSetCardViewKt$showSharePanel$1();

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(e eVar) {
        KLog.INSTANCE.d("QQFTCenterFileSetCardView", "shareFile callback: " + eVar);
        return Unit.INSTANCE;
    }

    public QQFTCenterFileSetCardViewKt$showSharePanel$1() {
        super(1);
    }
}
