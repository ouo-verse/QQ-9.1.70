package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;
import n25.l;
import v25.a;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class FeedCache {
    public final a feedFromExtra;
    public final l feedFromServer;
    public final String feedId;

    public FeedCache(String str, l lVar, a aVar) {
        this.feedId = str;
        this.feedFromServer = lVar;
        this.feedFromExtra = aVar;
    }

    public final int hashCode() {
        int hashCode = this.feedId.hashCode() * 31;
        l lVar = this.feedFromServer;
        int hashCode2 = (hashCode + (lVar == null ? 0 : lVar.hashCode())) * 31;
        a aVar = this.feedFromExtra;
        return hashCode2 + (aVar != null ? aVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("FeedCache(feedId=");
        m3.append(this.feedId);
        m3.append(", feedFromServer=");
        m3.append(this.feedFromServer);
        m3.append(", feedFromExtra=");
        m3.append(this.feedFromExtra);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedCache)) {
            return false;
        }
        FeedCache feedCache = (FeedCache) obj;
        return Intrinsics.areEqual(this.feedId, feedCache.feedId) && Intrinsics.areEqual(this.feedFromServer, feedCache.feedFromServer) && Intrinsics.areEqual(this.feedFromExtra, feedCache.feedFromExtra);
    }
}
