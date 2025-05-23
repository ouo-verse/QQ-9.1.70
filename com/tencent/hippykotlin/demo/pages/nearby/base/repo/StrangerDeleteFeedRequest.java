package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import p35.j;
import p35.k;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class StrangerDeleteFeedRequest implements IBizRequestByProxy<j, k> {
    public final int appId;
    public final String feedId;

    public StrangerDeleteFeedRequest(int i3, String str) {
        this.appId = i3;
        this.feedId = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final k decodeResponse(byte[] bArr) {
        try {
            return (k) i.b(new k(0, null, null, 7, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("StrangerDeleteFeedRequest", "decodeResponse decode error: " + th5);
            return new k(0, null, null, 7, null);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final int getAppId() {
        return this.appId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getMethod() {
        return "DeleteFeed";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final j getRequest() {
        return new j(this.feedId, UserDataManager.INSTANCE.getCommonExtInfo());
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getService() {
        return "QQStranger.FeedSvr";
    }
}
