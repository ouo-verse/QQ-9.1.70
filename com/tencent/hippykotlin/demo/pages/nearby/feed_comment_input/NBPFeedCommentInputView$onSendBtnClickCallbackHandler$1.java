package com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input;

import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class NBPFeedCommentInputView$onSendBtnClickCallbackHandler$1 extends Lambda implements Function1<Object, Unit> {
    public final /* synthetic */ NBPFeedCommentInputView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NBPFeedCommentInputView$onSendBtnClickCallbackHandler$1(NBPFeedCommentInputView nBPFeedCommentInputView) {
        super(1);
        this.this$0 = nBPFeedCommentInputView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Object obj) {
        KLog.INSTANCE.e("NBPFeedCommentInputView", "did click by send btn in emoji board");
        NBPFeedCommentInputView.access$onSend(this.this$0);
        return Unit.INSTANCE;
    }
}
