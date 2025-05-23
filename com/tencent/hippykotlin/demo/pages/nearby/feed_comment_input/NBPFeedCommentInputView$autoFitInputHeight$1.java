package com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPFeedCommentInputView$autoFitInputHeight$1 extends Lambda implements Function1<Float, Unit> {
    public final /* synthetic */ NBPFeedCommentInputView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NBPFeedCommentInputView$autoFitInputHeight$1(NBPFeedCommentInputView nBPFeedCommentInputView) {
        super(1);
        this.this$0 = nBPFeedCommentInputView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Float f16) {
        float floatValue = f16.floatValue();
        NBPFeedCommentInputView nBPFeedCommentInputView = this.this$0;
        ReadWriteProperty readWriteProperty = nBPFeedCommentInputView.inputAreaHeight$delegate;
        KProperty<?>[] kPropertyArr = NBPFeedCommentInputView.$$delegatedProperties;
        if (!(floatValue == ((Number) readWriteProperty.getValue(nBPFeedCommentInputView, kPropertyArr[9])).floatValue())) {
            NBPFeedCommentInputView nBPFeedCommentInputView2 = this.this$0;
            nBPFeedCommentInputView2.inputAreaHeight$delegate.setValue(nBPFeedCommentInputView2, kPropertyArr[9], Float.valueOf(floatValue));
        }
        return Unit.INSTANCE;
    }
}
