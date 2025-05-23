package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.part;

import com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalInfoResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
/* synthetic */ class QQStrangerSignalSquareSmartRefreshPart$onPartCreate$1 extends FunctionReferenceImpl implements Function1<QQStrangerSignalInfoResult, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(QQStrangerSignalInfoResult qQStrangerSignalInfoResult) {
        invoke2(qQStrangerSignalInfoResult);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QQStrangerSignalSquareSmartRefreshPart$onPartCreate$1(Object obj) {
        super(1, obj, QQStrangerSignalSquareSmartRefreshPart.class, "onUpdateSignalList", "onUpdateSignalList(Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/QQStrangerSignalInfoResult;)V", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(QQStrangerSignalInfoResult p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((QQStrangerSignalSquareSmartRefreshPart) this.receiver).T9(p06);
    }
}
