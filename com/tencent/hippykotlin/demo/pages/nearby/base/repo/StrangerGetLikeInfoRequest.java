package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import p35.w;
import p35.x;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class StrangerGetLikeInfoRequest implements IBizRequestByProxy<w, x> {
    public final int appId;
    public final String feedId;
    public final String likeKey;
    public final String roundParam;
    public final String userId;
    public final int reqType = 1;
    public final int needCount = 1;
    public final int count = 15;

    public StrangerGetLikeInfoRequest(int i3, String str, String str2, String str3, String str4) {
        this.appId = i3;
        this.userId = str;
        this.likeKey = str2;
        this.roundParam = str3;
        this.feedId = str4;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final int getAppId() {
        return this.appId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getMethod() {
        return "GetLikeInfo";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final w getRequest() {
        return new w(this.reqType, this.needCount, this.userId, this.likeKey, this.roundParam, this.count, UserDataManager.INSTANCE.getCommonExtInfo(), this.feedId);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getService() {
        return "QQStranger.FeedSvr";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final x decodeResponse(byte[] bArr) {
        try {
            return (x) i.b(new x(null, null, 3, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("StrangerGetLikeInfoRequest", "GetLikeInfoRsp decode error: " + th5);
            return new x(null, null, 3, null);
        }
    }
}
