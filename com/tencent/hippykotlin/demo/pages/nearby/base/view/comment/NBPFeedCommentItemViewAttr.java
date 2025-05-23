package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPFeedCommentItemViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentItemViewAttr.class, "replies", "getReplies()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public NBPCommentVO comment;
    public final ReadWriteProperty replies$delegate = c.b();

    public final com.tencent.kuikly.core.reactive.collection.c<NBPReplyVO> getReplies() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.replies$delegate.getValue(this, $$delegatedProperties[0]);
    }
}
