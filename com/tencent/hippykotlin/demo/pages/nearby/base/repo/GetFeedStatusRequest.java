package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.i;
import com.tencent.kuikly.core.log.KLog;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import p35.u;
import p35.v;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetFeedStatusRequest implements IBizRequestByProxy<u, v> {
    public final int appId;
    public final List<String> feedIds;

    public GetFeedStatusRequest(int i3, List<String> list) {
        this.appId = i3;
        this.feedIds = list;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final int getAppId() {
        return this.appId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getMethod() {
        return "GetFeedStatus";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final u getRequest() {
        List mutableList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.feedIds);
        return new u(mutableList);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getService() {
        return "QQStranger.FeedSvr";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final v decodeResponse(byte[] bArr) {
        try {
            return (v) i.b(new v(null, 1, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("GetFeedStatusRequest", "GetFeedStatusRequest decode error: " + th5);
            return new v(null, 1, null);
        }
    }
}
