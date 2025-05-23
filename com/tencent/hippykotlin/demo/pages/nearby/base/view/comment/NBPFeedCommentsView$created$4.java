package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* loaded from: classes31.dex */
public /* synthetic */ class NBPFeedCommentsView$created$4 extends AdaptedFunctionReference implements Function2<NBPCommentVO, NBPReplyVO, Unit> {
    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(NBPCommentVO nBPCommentVO, NBPReplyVO nBPReplyVO) {
        NBPFeedCommentsView.showInput$default((NBPFeedCommentsView) this.receiver, nBPCommentVO, nBPReplyVO, null, 4);
        return Unit.INSTANCE;
    }

    public NBPFeedCommentsView$created$4(Object obj) {
        super(2, obj, NBPFeedCommentsView.class, "showInput", "showInput(Lcom/tencent/hippykotlin/demo/pages/nearby/base/view/comment/NBPCommentVO;Lcom/tencent/hippykotlin/demo/pages/nearby/base/view/comment/NBPReplyVO;Lcom/tencent/hippykotlin/demo/pages/nearby/base/view/CommentPanelState;)V", 0);
    }
}
