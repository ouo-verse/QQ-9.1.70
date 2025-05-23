package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QuickCommentItem;
import com.tencent.kuikly.core.base.k;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes31.dex */
public final class NBPFeedCommentsAttr extends k {
    public List<QuickCommentItem> aiQuickComments;
    public List<QuickCommentItem> quickComments;

    public NBPFeedCommentsAttr() {
        List<QuickCommentItem> emptyList;
        List<QuickCommentItem> emptyList2;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.quickComments = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.aiQuickComments = emptyList2;
    }
}
