package com.tencent.hippykotlin.demo.pages.nearby.feed_comment;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QuickCommentItem;
import com.tencent.kuikly.core.base.k;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPFeedQuickCommentSelectAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedQuickCommentSelectAttr.class, "quickComments", "getQuickComments()Ljava/util/List;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedQuickCommentSelectAttr.class, "aiQuickComments", "getAiQuickComments()Ljava/util/List;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedQuickCommentSelectAttr.class, "isAIQuickCommentMode", "isAIQuickCommentMode()Z", 0)};
    public final ReadWriteProperty aiQuickComments$delegate;
    public final ReadWriteProperty isAIQuickCommentMode$delegate;
    public final ReadWriteProperty quickComments$delegate;

    public NBPFeedQuickCommentSelectAttr() {
        List emptyList;
        List emptyList2;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.quickComments$delegate = c.a(emptyList);
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.aiQuickComments$delegate = c.a(emptyList2);
        this.isAIQuickCommentMode$delegate = c.a(Boolean.FALSE);
    }

    public final List<QuickCommentItem> getQuickComments() {
        return (List) this.quickComments$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setAiQuickComments(List<QuickCommentItem> list) {
        this.aiQuickComments$delegate.setValue(this, $$delegatedProperties[1], list);
    }

    public final void setQuickComments(List<QuickCommentItem> list) {
        this.quickComments$delegate.setValue(this, $$delegatedProperties[0], list);
    }
}
