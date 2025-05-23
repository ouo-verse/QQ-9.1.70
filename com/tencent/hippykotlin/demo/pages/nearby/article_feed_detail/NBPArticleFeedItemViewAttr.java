package com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail;

import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPArticleFeedItemViewAttr extends k {
    public NBPArticleFeedModel feed;

    /* renamed from: vm, reason: collision with root package name */
    public NBPArticleFeedDetailVM f114203vm;

    public final NBPArticleFeedModel getFeed() {
        NBPArticleFeedModel nBPArticleFeedModel = this.feed;
        if (nBPArticleFeedModel != null) {
            return nBPArticleFeedModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("feed");
        return null;
    }

    public final NBPArticleFeedDetailVM getVm() {
        NBPArticleFeedDetailVM nBPArticleFeedDetailVM = this.f114203vm;
        if (nBPArticleFeedDetailVM != null) {
            return nBPArticleFeedDetailVM;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vm");
        return null;
    }
}
