package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra;

import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;

/* loaded from: classes31.dex */
public interface INBPFeedCommentExtraEvent {

    /* loaded from: classes31.dex */
    public static final class DefaultImpls {
        public static void dispatch(INBPFeedCommentExtraEvent iNBPFeedCommentExtraEvent) {
            NBPFeedCommentInputOpenEvent nBPFeedCommentInputOpenEvent = (NBPFeedCommentInputOpenEvent) iNBPFeedCommentExtraEvent;
            k.d((k) c.f117352a.g().acquireModule("KRNotifyModule"), nBPFeedCommentInputOpenEvent.key, nBPFeedCommentInputOpenEvent.toJson(), false, 4, null);
        }
    }
}
