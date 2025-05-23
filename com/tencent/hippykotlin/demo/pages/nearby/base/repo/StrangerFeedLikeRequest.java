package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import p35.l;
import p35.m;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class StrangerFeedLikeRequest implements IBizRequestByProxy<l, m> {
    public final int appId;
    public final String feedId;
    public final int operType;
    public final String posterTid;

    public StrangerFeedLikeRequest(int i3, String str, int i16, String str2) {
        this.appId = i3;
        this.feedId = str;
        this.operType = i16;
        this.posterTid = str2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final m decodeResponse(byte[] bArr) {
        return (m) i.b(new m(null, 0, null, 7, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final int getAppId() {
        return this.appId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getMethod() {
        return "SsoDoLike";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final l getRequest() {
        return new l(this.operType, this.feedId, this.posterTid, StrangerFeedRepoKt.getAccountType(this.appId), UserDataManager.INSTANCE.getCommonExtInfo());
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getService() {
        return "QQStranger.FeedSvr";
    }
}
