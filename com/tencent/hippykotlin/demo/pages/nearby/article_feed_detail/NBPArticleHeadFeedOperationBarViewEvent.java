package com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail;

import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QuickCommentItem;
import com.tencent.kuikly.core.base.l;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NBPArticleHeadFeedOperationBarViewEvent extends l {
    public Function1<? super QuickCommentItem, Unit> onQuickReplyExposeHandler;
    public Function1<? super QuickCommentItem, Unit> onQuickReplySelectHandler;
}
