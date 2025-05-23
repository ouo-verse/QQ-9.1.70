package com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input;

import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QuickCommentItem;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CommentPanelState;
import com.tencent.kuikly.core.base.k;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes31.dex */
public final class NBPFeedCommentInputViewAttr extends k {
    public List<QuickCommentItem> aiQuickComments;
    public List<QuickCommentItem> quickComments;
    public String placeHolder = "\u8bf4\u70b9\u4ec0\u4e48\u5427";
    public String cachedText = "";
    public CommentPanelState panelState = CommentPanelState.None;

    public NBPFeedCommentInputViewAttr() {
        List<QuickCommentItem> emptyList;
        List<QuickCommentItem> emptyList2;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.quickComments = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.aiQuickComments = emptyList2;
    }
}
