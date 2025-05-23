package com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail;

import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPArticleHeadFeedOperationBarViewAttr extends k {
    public NBPArticleFeedModel feedModel;

    /* renamed from: vm, reason: collision with root package name */
    public NBPArticleFeedDetailVM f114205vm;

    public final NBPArticleFeedModel getFeedModel() {
        NBPArticleFeedModel nBPArticleFeedModel = this.feedModel;
        if (nBPArticleFeedModel != null) {
            return nBPArticleFeedModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("feedModel");
        return null;
    }

    public final NBPArticleFeedDetailVM getVm() {
        NBPArticleFeedDetailVM nBPArticleFeedDetailVM = this.f114205vm;
        if (nBPArticleFeedDetailVM != null) {
            return nBPArticleFeedDetailVM;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vm");
        return null;
    }
}
