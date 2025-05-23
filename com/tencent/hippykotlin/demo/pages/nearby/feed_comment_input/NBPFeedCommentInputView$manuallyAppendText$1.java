package com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input;

import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.views.TextAreaView;
import com.tencent.kuikly.core.views.ak;
import com.tencent.kuikly.core.views.al;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class NBPFeedCommentInputView$manuallyAppendText$1 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ String $text;
    public final /* synthetic */ NBPFeedCommentInputView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NBPFeedCommentInputView$manuallyAppendText$1(NBPFeedCommentInputView nBPFeedCommentInputView, String str) {
        super(1);
        this.this$0 = nBPFeedCommentInputView;
        this.$text = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Integer num) {
        TextAreaView b16;
        int intValue = num.intValue();
        StringBuilder insert = new StringBuilder(this.this$0.getInputText()).insert(intValue, this.$text);
        NBPFeedCommentInputView nBPFeedCommentInputView = this.this$0;
        al alVar = new al();
        ak akVar = new ak();
        akVar.e(insert.toString());
        akVar.b(Float.valueOf(16.0f));
        alVar.a(akVar);
        nBPFeedCommentInputView.inputSpans$delegate.setValue(nBPFeedCommentInputView, NBPFeedCommentInputView.$$delegatedProperties[7], alVar);
        aa<TextAreaView> aaVar = this.this$0.inputViewRef;
        if (aaVar != null && (b16 = aaVar.b()) != null) {
            b16.n(this.$text.length() + intValue);
        }
        return Unit.INSTANCE;
    }
}
