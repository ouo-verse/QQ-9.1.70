package com.tencent.hippykotlin.demo.pages.nearby.feed_comment;

import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QuickCommentItem;
import com.tencent.kuikly.core.base.l;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NBPFeedQuickCommentSelectEvent extends l {
    public Function0<Unit> onClickAIHandler;
    public Function1<? super QuickCommentItem, Unit> onExposeHandler;
    public Function1<? super QuickCommentItem, Unit> onSelectHandler;
}
