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
public final class NBPFeedAIQuickCommentSelectAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedAIQuickCommentSelectAttr.class, "viewHeight", "getViewHeight()F", 0)};
    public List<QuickCommentItem> aiQuickComments;
    public final ReadWriteProperty viewHeight$delegate;

    public NBPFeedAIQuickCommentSelectAttr() {
        List<QuickCommentItem> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.aiQuickComments = emptyList;
        this.viewHeight$delegate = c.a(Float.valueOf(400.0f));
    }
}
