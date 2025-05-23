package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import com.tencent.kuikly.core.base.l;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes31.dex */
public final class NBPFeedCommentsEvent extends l {
    public Function2<? super NBPCommentVO, ? super NBPReplyVO, Unit> onAddedHandler;
    public Function1<? super CommentClickInfo, Unit> onCommentClickHandler;
    public Function1<? super Integer, Unit> onCountChangeHandler;
    public Function2<? super Boolean, ? super Integer, Unit> onFirstPageLoadedHandler;
}
