package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import p35.y;
import p35.z;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetRecommendCommentRequest implements IBizRequestByProxy<y, z> {
    public final int appId;
    public final int commentType;
    public final String feedId;
    public final int fetchSource = 2;

    public GetRecommendCommentRequest(int i3, String str, int i16) {
        this.appId = i3;
        this.feedId = str;
        this.commentType = i16;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final int getAppId() {
        return this.appId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getMethod() {
        return "GetRecommendComment";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final y getRequest() {
        return new y(this.feedId, UserDataManager.INSTANCE.getCommonExtInfo(), this.fetchSource, this.commentType);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getService() {
        return "QQStranger.FeedSvr";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final z decodeResponse(byte[] bArr) {
        try {
            return (z) i.b(new z(null, null, 3, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("GetRecommendCommentRequest", "GetRecommendCommentRsp decode error: " + th5);
            return new z(null, null, 3, null);
        }
    }
}
