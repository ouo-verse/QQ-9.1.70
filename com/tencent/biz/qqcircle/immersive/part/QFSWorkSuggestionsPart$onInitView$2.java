package com.tencent.biz.qqcircle.immersive.part;

import e40.QFSWorkSuggestionsData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
/* synthetic */ class QFSWorkSuggestionsPart$onInitView$2 extends FunctionReferenceImpl implements Function1<QFSWorkSuggestionsData, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public QFSWorkSuggestionsPart$onInitView$2(Object obj) {
        super(1, obj, QFSWorkSuggestionsPart.class, "updateUI", "updateUI(Lcom/tencent/biz/qqcircle/immersive/bean/QFSWorkSuggestionsData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(QFSWorkSuggestionsData qFSWorkSuggestionsData) {
        invoke2(qFSWorkSuggestionsData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable QFSWorkSuggestionsData qFSWorkSuggestionsData) {
        ((QFSWorkSuggestionsPart) this.receiver).Q9(qFSWorkSuggestionsData);
    }
}
