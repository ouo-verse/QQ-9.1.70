package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import p35.s;
import p35.t;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class StrangerGetFeedDetailRequest implements IBizRequestByProxy<s, t> {
    public final int appId;
    public final String feedId;

    public StrangerGetFeedDetailRequest(int i3, String str) {
        this.appId = i3;
        this.feedId = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final t decodeResponse(byte[] bArr) {
        try {
            return (t) i.b(new t(0, null, null, null, 15, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("StrangerGetFeedDetailRequest", "GetFeedDetailRsp decode error: " + th5);
            return new t(0, null, null, null, 15, null);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final int getAppId() {
        return this.appId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getMethod() {
        return "GetFeedDetail";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final s getRequest() {
        return new s(this.feedId, UserDataManager.INSTANCE.getCommonExtInfo());
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getService() {
        return "QQStranger.FeedSvr";
    }
}
